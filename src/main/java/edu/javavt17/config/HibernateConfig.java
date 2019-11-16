package edu.javavt17.config;

import edu.javavt17.dao.CarBrandDAO;
import edu.javavt17.dao.CarModelDAO;
import edu.javavt17.dao.hibernate.CarBrandDAOHibernateImpl;
import edu.javavt17.dao.hibernate.CarModelDAOHibernateImpl;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@PropertySource(value = {"classpath:application.properties"})
@ComponentScan({"edu.javavt17"})
public class HibernateConfig {

    @Autowired
    private DataSource dataSource;

    //Hibernate configuration
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPackagesToScan(new String[] { "edu.javavt17.model" });
        return sessionFactory;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager hibernateTransactionManager(SessionFactory s) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(s);
        return txManager;
    }

    @Bean
    public CarBrandDAO getCarBrandHibernateDAO() {
        return new CarBrandDAOHibernateImpl();
    }
    @Bean
    public CarModelDAO getCarModelHibernateDAO() {
        return new CarModelDAOHibernateImpl();
    }
}