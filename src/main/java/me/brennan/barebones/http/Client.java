package me.brennan.barebones.http;

import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.client.impl.WebClientSessionAware;
import io.vertx.ext.web.client.spi.CookieStore;

/**
 * @author Brennan / skateboard
 * @since 4/29/2022
 **/
public class Client extends WebClientSessionAware {

    public Client(WebClient webClient, CookieStore cookieStore) {
        super(webClient, cookieStore);
    }
}
