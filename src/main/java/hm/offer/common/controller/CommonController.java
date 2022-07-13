package hm.offer.common.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
public class CommonController {

	@GetMapping("/str")
	public String testPage() {
		log.info("test suc");
		return "hello";
	}
}
