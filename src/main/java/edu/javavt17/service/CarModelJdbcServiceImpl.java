package edu.javavt17.service;

import edu.javavt17.dao.CarModelDAO;
import edu.javavt17.model.CarModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("carModelJdbcService")
public class CarModelJdbcServiceImpl implements CarModelService {
    @Autowired
    @Qualifier("getCarModelJdbcDAO")
    private CarModelDAO carModelDAO;

    public void saveOrUpdate(CarModel item) {
        carModelDAO.saveOrUpdate(item);
    }
    public void delete(int itemId) {
        carModelDAO.delete(itemId);
    }
    public CarModel get(int itemId) {
        return carModelDAO.get(itemId);
    }
    public List<CarModel> list() {
        return carModelDAO.list();
    }
}