package com.zb.hikari.service;

import com.zaxxer.hikari.HikariDataSource;
import com.zb.hikari.config.MyHikariConfig;
import com.zb.hikari.utils.CommonUtils;
import com.zb.hikari.utils.MapConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.boot.context.properties.source.MapConfigurationPropertySource;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

/**
 * Description
 *
 * @author
 * @date 2025/3/3
 */


@Service
@Slf4j
public class HikariCPSysCallService {

    @Autowired
    private MyHikariConfig myHikariConfig;

    @Autowired
    @Qualifier("myHikariDataSource")
    private DataSource dataSource;

    public String getNewConnection() {
        DataSource dataSource = new HikariDataSource();
        // 初始化数据源配置
        MyHikariConfig myHikariConfigTmp = new MyHikariConfig();
        BeanUtils.copyProperties(myHikariConfig, myHikariConfigTmp);

        Map<String, Object> dsProperties = MapConverter.convertToMap(myHikariConfigTmp);
        Binder binder = new Binder(new MapConfigurationPropertySource(dsProperties));
        dataSource = binder.bind("", Bindable.ofInstance(dataSource)).get();

        String result = "result: ";
        try (Connection connection = dataSource.getConnection()
        ) {
          log.info("connection: {}", connection);
        } catch (SQLException e) {
            log.error("数据库连接失败", e);
        }
        CommonUtils.endOfCallSign();
        return result;
    }

}
