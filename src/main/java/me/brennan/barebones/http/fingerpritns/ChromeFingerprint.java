package me.brennan.barebones.http.fingerpritns;

import io.vertx.ext.web.client.WebClientOptions;

/**
 * @author Brennan / skateboard
 * @since 5/10/2022
 *
 * #TODO: Finish this.
 **/
public class ChromeFingerprint implements Fingerprint{

    @Override
    public WebClientOptions options() {
        return new WebClientOptions();
    }
}
