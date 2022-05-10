package me.brennan.barebones.http.factory;

import io.vertx.core.Vertx;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.client.impl.CookieStoreImpl;
import me.brennan.barebones.http.Client;
import me.brennan.barebones.http.fingerpritns.Fingerprint;

/**
 * @author Brennan / skateboard
 * @since 5/10/2022
 **/
public class ClientFactory {

    public static Client createClient(Vertx vertx, Fingerprint fingerprint) {
        return new Client(createWebClient(vertx, fingerprint), new CookieStoreImpl());
    }

    private static WebClient createWebClient(Vertx vertx, Fingerprint fingerprint) {
        return WebClient.create(vertx, fingerprint.options());
    }

}
