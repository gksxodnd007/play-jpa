package org.codingsquid.jpa.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

/**
 * @author taewoong.han
 * @since 2020.12.12
 */
@ConstructorBinding
@ConfigurationProperties(prefix = "database")
public class DatabaseProperties {

    private final String url;
    private final String username;
    private final String password;
    private final int maxConnection;
    private final int minConnection;

    public DatabaseProperties(String url, String username, String password, int maxConnection, int minConnection) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.maxConnection = maxConnection;
        this.minConnection = minConnection;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getMaxConnection() {
        return maxConnection;
    }

    public int getMinConnection() {
        return minConnection;
    }
}
