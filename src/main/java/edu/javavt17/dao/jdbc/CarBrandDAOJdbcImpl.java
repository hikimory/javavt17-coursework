package edu.javavt17.dao.jdbc;

import edu.javavt17.dao.CarBrandDAO;
import edu.javavt17.model.CarBrand;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;


public class CarBrandDAOJdbcImpl implements CarBrandDAO {

    private JdbcTemplate jdbcTemplate;
    @Autowired
    public CarBrandDAOJdbcImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void saveOrUpdate(CarBrand item) {
        if (item.getIdBrand() > 0) {
            // update
            System.out.println("CarBrand update");
            String sql = "UPDATE brand SET name=?, foundedYear=?, headquarter=? WHERE idBrand=?";
            jdbcTemplate.update(sql, item.getName(), item.getFoundedYear(),item.getHeadquarter(), item.getIdBrand());
        } else {
            // insert
            System.out.println("CarBrand insert");
            String sql = "INSERT INTO brand (name, foundedYear, headquarter)"
                    + " VALUES (?, ?, ?)";
            jdbcTemplate.update(sql, item.getName(), item.getFoundedYear(), item.getHeadquarter());
        }
    }

    public void delete(int itemId) {
        String sql = "DELETE FROM brand WHERE idBrand=?";
        jdbcTemplate.update(sql, itemId);
    }

    public CarBrand get(int itemId) {
        String sql = "SELECT * FROM brand WHERE idBrand=" + itemId;
        return jdbcTemplate.query(sql, new ResultSetExtractor<CarBrand>() {

            public CarBrand extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    return getCarBrandFromDB(rs);
                }
                return null;
            }
        });
    }

    public List<CarBrand> list() {
        String sql = "SELECT * FROM brand";
        List<CarBrand> listCarBrand = jdbcTemplate.query(sql, new RowMapper<CarBrand>() {

            public CarBrand mapRow(ResultSet rs, int i) throws SQLException {

                return getCarBrandFromDB(rs);
            }
        });
        return listCarBrand;
    }

    private CarBrand getCarBrandFromDB(ResultSet rs) throws SQLException{
        CarBrand brand = new CarBrand();
        brand.setIdBrand(rs.getInt("idBrand"));
        brand.setName(rs.getString("name"));
        brand.setFoundedYear(rs.getShort("foundedYear"));
        brand.setHeadquarter(rs.getString("headquarter"));
        return brand;
    }
}
