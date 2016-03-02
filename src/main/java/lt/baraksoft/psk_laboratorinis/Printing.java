package lt.baraksoft.psk_laboratorinis;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateful;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author LaurynasC
 */
@Named
@RequestScoped // @SessionScoped
@Stateful
public class Printing {
    
    @PersistenceContext
private EntityManager em;

    public String sakykLabas() {
       String b = "";
       List<University> q = em.createQuery("SELECT u FROM University u").getResultList();       
       int size = q.size();
       for (int i = 0; i < size; i++){
            University uni = q.get(i);
            String a = uni.getTitle();
            b += a;
       }       
       return b;      
    }
    
    @PostConstruct
    public void init() {
      System.out.println(toString() + " constructed.");
    }
    
    @PreDestroy
    public void aboutToDie() {
      System.out.println(toString() + " ready to die.");
    }   
}
