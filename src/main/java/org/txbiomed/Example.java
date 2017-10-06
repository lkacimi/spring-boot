package org.txbiomed;




import java.util.Enumeration;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.apache.log4j.Appender;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.apache.log4j.spi.ErrorHandler;
import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.txbiomed.entities.Contact;
import org.txbiomed.entities.Customer;
import org.txbiomed.entities.Name;


@RestController
@SpringBootApplication
public class Example implements ApplicationRunner{

    private final Logger logger = LogManager.getLogger(Example.class);
      

    @Override
    public void run(ApplicationArguments aa) throws Exception {
        System.out.println("!!!!!!!!!!!!!THIS WILL RUN!!!!!");
    }
    
    @Value("${firstProperty}")
    private String value;
    
    @Autowired
    private String amazing;
    @Autowired
    private int number;
    
   
    
    @Autowired
    private EntityManagerFactory emf;
    @RequestMapping("/")
    String home(){
        
        
      
        logger.setLevel(Level.FATAL);
        
        logger.log(Level.INFO, "FATAL ERROR");
        EntityManager entityManager;
        entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        Contact contact = new Contact();
        contact.setId(1);
        contact.setName(new Name());
        contact.getName().setFirst("Lamine");
        contact.getName().setLast("KACIMI");
        contact.setNotes("A simple note");
        contact.setStarred(true);
        entityManager.merge(contact);
        
        
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Lamine");
        customer.setPassword("Lamine");
        
        entityManager.merge(customer);
        
        entityManager.getTransaction().commit();
        
        Contact savedContact = entityManager.find(Contact.class, 1);
        
        return amazing + " " +number + " " + value + " " + savedContact.getNotes();
    }
    
    public static void main(String[] args) throws Exception{
        
        SpringApplication.run(Example.class, args);
    }
    
    @Bean
    @Primary
    public String getAmazingString(){
       
        return "Hello World the Spring way!";
    }
    
    @Bean
    public String getAnotherAmazingString(){
        return "Hello World the Spring way!";
    }
    
    @Bean
    public int getNumber(){
        return 1;
    }
}
