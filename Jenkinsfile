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
        // git repository clone
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
         
          stage('Docker-compose up'){
              steps{
                  //sh 'docker build . -t devpgang/offe'
                  sh 'cd /var/jenkins_home/workspace/composetest/'
                  sh 'ls -al'
               
                  //sh 'docker cp jenkins:/var/jenkins_home/workspace/composetest/docker-compose.yml ~/my_app/ '
                  sh 'docker-compose up -d'
              }
          }

        
        
        
    }
}