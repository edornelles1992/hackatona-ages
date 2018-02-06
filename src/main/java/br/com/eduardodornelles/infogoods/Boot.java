package br.com.eduardodornelles.infogoods;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Boot
{

   public static void main(String[] args)
   {
      SpringApplication.run(Boot.class, args);
   }
   
   @Bean
   public BCryptPasswordEncoder bCryptPasswordEncoder() {
       return new BCryptPasswordEncoder();
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
