package me.brennan.barebones.http;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.http.*;

import java.util.concurrent.CompletableFuture;

/**
 * @author Brennan / skateboard
 * @since 4/29/2022
 **/
public class Client extends AbstractVerticle {
    private final HttpClient client;

    public Client(Vertx parent) {
        this(new HttpClientOptions().
                setProtocolVersion(HttpVersion.HTTP_2).
                setSsl(true).
                setUseAlpn(true).
                setTrustAll(true)
        );
    }

    public Client(HttpClientOptions options) {
        this.client = vertx.createHttpClient(options);
    }

    public CompletableFuture<HttpClientResponse> get(String url) {
        try {
            CompletableFuture<HttpClientResponse> requestPromise = new CompletableFuture<>();
            var request = client.request(HttpMethod.GET, url).result();
            request.send(ar2 -> {
                if (ar2.succeeded()) {
                    HttpClientResponse response = ar2.result();
                    requestPromise.complete(response);
                }
            });

            return requestPromise;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
