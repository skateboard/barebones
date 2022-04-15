package me.brennan.barebones.proxy;

import okhttp3.Authenticator;
import okhttp3.Credentials;

/**
 * @author Brennan / skateboard
 * @since 4/14/2022
 **/
public class Proxy {
    private final String ip;
    private final int port;

    private String username;
    private String password;

    public Proxy(String ip, int port, String username, String password) {
        this.ip = ip;
        this.username = username;
        this.password = password;
        this.port = port;
    }

    public Proxy(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public int getPort() {
        return port;
    }

    public String getIp() {
        return ip;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public Authenticator getAuthenticator() {
        return (route, response) -> {
            final String credential = Credentials.basic(getUsername(), getPassword());

            return response.request().newBuilder()
                    .header("Proxy-Authorization", credential)
                    .build();
        };
    }
}