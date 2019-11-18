package edu.javavt17.service;

import edu.javavt17.dao.CarBrandDAO;
import edu.javavt17.model.CarBrand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service("carBrandJpaService")
@Transactional(readOnly=false, value = "jpaTransactionManager")
public class CarBrandJpaServiceImpl implements CarBrandService {
    @Autowired
    @Qualifier("getCarBrandJpaDAO")
    private CarBrandDAO carBrandDAO;

    public List<CarBrand> list() {
        return carBrandDAO.list();
    }
    public CarBrand get(int itemId) {
        return carBrandDAO.get(itemId);
    }
    public void saveOrUpdate(CarBrand item) {
        carBrandDAO.saveOrUpdate(item);
    }
    public void delete(int itemId) {
        carBrandDAO.delete(itemId);
    }
}