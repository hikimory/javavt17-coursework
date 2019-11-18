package edu.javavt17.service;

import edu.javavt17.dao.CarBrandDAO;
import edu.javavt17.model.CarBrand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("carBrandJdbcService")
public class CarBrandJdbcServiceImpl implements CarBrandService {
    @Autowired
    @Qualifier("getCarBrandJdbcDAO")
    private CarBrandDAO carBrandDAO;

    public void saveOrUpdate(CarBrand item) {
        carBrandDAO.saveOrUpdate(item);
    }
    public void delete(int itemId) {
        carBrandDAO.delete(itemId);
    }
    public CarBrand get(int itemId) {
        return carBrandDAO.get(itemId);
    }
    public List<CarBrand> list() {
        return carBrandDAO.list();
    }
}