package boot.data.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class LayoutController {
	
	

	@GetMapping("/")
	public String start()
	{

		return "/layout/main";
		}

	
		
		
		  
		
}
