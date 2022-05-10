package me.brennan.barebones.http.fingerpritns;

import io.vertx.core.http.Http2Settings;
import io.vertx.ext.web.client.WebClientOptions;

import java.util.concurrent.TimeUnit;

/**
 * @author Brennan / skateboard
 * @since 5/10/2022
 *
 * #TODO: Finish this.
 **/
public class ChromeFingerprint implements Fingerprint{

    @Override
    public WebClientOptions options() {
        var options = new WebClientOptions()
                .setLogActivity(false).setUserAgentEnabled(false).setSsl(true)
                .setUseAlpn(true).setTrustAll(true).setVerifyHost(true)
                .setForceSni(true).setConnectTimeout(10000).setSslHandshakeTimeout(10000)
                .setSslHandshakeTimeoutUnit(TimeUnit.SECONDS).setIdleTimeoutUnit(TimeUnit.SECONDS)
                .setIdleTimeout(10000).setKeepAlive(true).setKeepAliveTimeout(50)
                .setHttp2KeepAliveTimeout(100).setHttp2MaxPoolSize(10).setHttp2MultiplexingLimit(150)
                .setPoolCleanerPeriod(15000).setMaxPoolSize(10).setTryUseCompression(true)
                .setTcpFastOpen(true).setTcpKeepAlive(true).setTcpNoDelay(true)
                .setTcpQuickAck(true).setFollowRedirects(false);

        options.setInitialSettings(new Http2Settings()
                .setHeaderTableSize(65536).setPushEnabled(true)
                .setMaxConcurrentStreams(1000).setInitialWindowSize(6291456)
                .setMaxFrameSize(16384).setMaxHeaderListSize(262144));

        return options;
    }
}
