package Fetch;

import java.applet.Applet;
import java.awt.PageAttributes.MediaType;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/controller")
class DemoController {
	
	@GetMapping(path ="/show", produces="application/json")
	//@Produces(MediaType.APPLICATION_JSON)
	public String show()
	{
		return "hello rest services";
		
	}

}
