package myself.study.test.mavenProject;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
 
@Controller
@SpringBootApplication
public class SampleController  {
 
    @ResponseBody
    @RequestMapping(value = "/1234")
    String home() {   
        return "Hello World!1234";
    }
 
    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }
 
}
