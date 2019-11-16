package edu.javavt17.dao.hibernate;

import edu.javavt17.dao.CarModelDAO;
import edu.javavt17.model.CarModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class CarModelDAOHibernateImpl implements CarModelDAO{

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void saveOrUpdate(CarModel item) {
        if (item.getIdModel() > 0) {
            getCurrentSession().merge(item);
        } else {
            getCurrentSession().save(item);
        }

    }

    public void delete(int itemId) {
        CarModel carModel = get(itemId);
        if (carModel != null)
            getCurrentSession().delete(carModel);
    }

    public CarModel get(int itemId) {
        CarModel carModel = (CarModel) getCurrentSession().get(CarModel.class, itemId);

        return carModel;
    }

    public List<CarModel> list() {
        Criteria criteria = getCurrentSession().createCriteria(CarModel.class);

        return criteria.list();
    }
}