package cn.swu.edu.javaweb.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.CompositePropertySource;
import org.springframework.core.env.MapPropertySource;
import sun.tools.java.Environment;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class DruidConfig {
    private static final String DB_PREFIX = "spring.datasource.";

    @Autowired
    private AbstractEnvironment environment;

    @Bean
    @ConfigurationProperties(prefix = DB_PREFIX)
    public DataSource druidDataSource(){
        Properties dbProperties = new Properties();
        Map<String,Object> map = new HashMap<>();
        for (org.springframework.core.env.PropertySource<?> propertySource : environment.getPropertySources()) {
            getPropertiesFromSource((PropertySource) propertySource, map);
        }
        dbProperties.putAll(map);
        DruidDataSource dds;
        try {
            dds = (DruidDataSource) DruidDataSourceFactory.createDataSource(dbProperties);
            dds.init();
        } catch (Exception e) {
            throw new RuntimeException("load datasource error, dbProperties is :" + dbProperties, e);
        }
        return dds;
    }

    private void getPropertiesFromSource(PropertySource propertySource, Map<String, Object> map) {
        if (propertySource instanceof MapPropertySource) {
            for (String key : ((MapPropertySource) propertySource).getPropertyNames()) {
                if (key.startsWith(DB_PREFIX))
                    map.put(key.replaceFirst(DB_PREFIX, ""), ((MapPropertySource) propertySource).getProperty(key));
                else if (key.startsWith(DB_PREFIX))
                    map.put(key.replaceFirst(DB_PREFIX, ""), ((MapPropertySource) propertySource).getProperty(key));
            }
        }

        if (propertySource instanceof CompositePropertySource) {
            for (org.springframework.core.env.PropertySource<?> s : ((CompositePropertySource) propertySource).getPropertySources()) {
                getPropertiesFromSource((PropertySource) s, map);
            }
        }
    }

    @Bean
    public ServletRegistrationBean druidServlet() {
        return new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }
}
