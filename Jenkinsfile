pipeline {
    agent any

    triggers {
        pollSCM('*/3 * * * *')
    }

    environment {
        imagename = "gat"
        registryCredential = 'dochkm'
        dockerImage = ''
    }

    stages {
        // git���� repository clone
        stage('Prepare') {
          steps {
            echo 'Clonning Repository'
            git url: 'https://github.com/happym92/offer.git',
              branch: 'master',
              credentialsId: 'githkm'
            }
            post {
             success { 
               echo 'Successfully Cloned Repository'
             }
           	 failure {
               error 'This pipeline stops here...'
             }
          }
        }

       stage('build gradle') {
            steps {
                sh  './gradlew build'


                sh 'ls -al ./build'
            }
            post {
                success {
                    echo 'gradle build success'
                }

                failure {
                    echo 'gradle build failed...'
                }
            }
        }
        
        stage('dockerizing'){
            steps{
                sh 'docker build . -t devpgang/offe'
            }
        }

        stage('Deploy') {
            steps {
                sh 'docker stop offer'
                sh 'docker rm offer'
                sh 'docker run -d -p 8090:8090 --name offer devpgang/offe'
            }

            post {
                success {
                    echo 'success'
                }

                failure {
                    echo 'failed'
                }
            }
        }
    }
}