package edu.javavt17.dao.jpa;

import edu.javavt17.dao.CarModelDAO;
import edu.javavt17.model.CarModel;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CarModelDAOJpaImpl implements CarModelDAO {
    @PersistenceContext
    private EntityManager em;

    public void saveOrUpdate(CarModel item) {
        if (item.getIdBrand() > 0) {
            // update
            em.merge(item);
        } else {
            // insert
            em.persist(item);
        }
    }

    public void delete(int itemId) {
        em.remove(get(itemId));
    }

    public CarModel get(int itemId) {
        return em.find(CarModel.class, itemId);
    }

    public List<CarModel> list() {
        List<CarModel> carModels = em.createNamedQuery("CarModel.findAll",CarModel.class).getResultList();
        return carModels;
    }
}