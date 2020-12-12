package org.codingsquid.jpa.config.properties;

import org.hibernate.cfg.AvailableSettings;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.util.Properties;

/**
 * @author taewoong.han
 * @since 2020.12.12
 */
@ConstructorBinding
@ConfigurationProperties(prefix = "jpa")
public class PlayJpaProperties {

    private final boolean generateDdl;
    private final boolean showSql;
    private final String storageEngine;
    private final String dialect;
    private final String hbm2ddlAuto;
    private final String implicitNamingStrategy;
    private final String physicalNamingStrategy;

    public PlayJpaProperties(boolean generateDdl,
                             boolean showSql,
                             String storageEngine,
                             String dialect,
                             String hbm2ddlAuto,
                             String implicitNamingStrategy,
                             String physicalNamingStrategy) {
        this.generateDdl = generateDdl;
        this.showSql = showSql;
        this.storageEngine = storageEngine;
        this.dialect = dialect;
        this.hbm2ddlAuto = hbm2ddlAuto;
        this.implicitNamingStrategy = implicitNamingStrategy;
        this.physicalNamingStrategy = physicalNamingStrategy;
    }

    public boolean isGenerateDdl() {
        return generateDdl;
    }

    public boolean isShowSql() {
        return showSql;
    }

    public String getStorageEngine() {
        return storageEngine;
    }

    public String getDialect() {
        return dialect;
    }

    public String getHbm2ddlAuto() {
        return hbm2ddlAuto;
    }

    public String getImplicitNamingStrategy() {
        return implicitNamingStrategy;
    }

    public String getPhysicalNamingStrategy() {
        return physicalNamingStrategy;
    }

    public Properties toProperties() {
        Properties properties = new Properties();
        properties.put(AvailableSettings.SHOW_SQL, showSql);
        properties.put(AvailableSettings.STORAGE_ENGINE, storageEngine);
        properties.put(AvailableSettings.DIALECT, dialect);
        properties.put(AvailableSettings.HBM2DDL_AUTO, hbm2ddlAuto);
        properties.put(AvailableSettings.PHYSICAL_NAMING_STRATEGY, physicalNamingStrategy);
        return properties;
    }
}
