package hm.offer.common.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class VueController {

	@GetMapping("/v")
	public String testPage() {
		
		return "index.html";
	}
}
