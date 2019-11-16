package edu.javavt17.dao.jpa;

import edu.javavt17.dao.CarBrandDAO;
import edu.javavt17.model.CarBrand;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CarBrandDAOJpaImpl implements CarBrandDAO {
    @PersistenceContext
    private EntityManager em;

    public void saveOrUpdate(CarBrand item) {
        if (item.getIdBrand() > 0) {
            //update
            em.merge(item);
        } else {
            //insert
            em.persist(item);
        }
    }

    public void delete(int itemId) {
        em.remove(get(itemId));

    }

    public CarBrand get(int itemId) {
        return em.find(CarBrand.class, itemId);
    }

    public List<CarBrand> list() {
        List<CarBrand> carBrands = em.createNamedQuery("CarBrand.findAll",CarBrand.class).getResultList();
        return carBrands;
    }
}