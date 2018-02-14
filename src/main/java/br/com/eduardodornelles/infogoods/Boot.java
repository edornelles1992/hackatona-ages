package br.com.eduardodornelles.infogoods;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Boot
{

   public static void main(String[] args)
   {
      SpringApplication.run(Boot.class, args);
   }
   
	
   /**
    * bean to instantiate the ModelMapper to application.
    * @return
    */
   @Bean
   public ModelMapper modelMapper() {
	   return new ModelMapper();
   }

}
