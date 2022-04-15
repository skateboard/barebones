package me.brennan.barebones.task.types;

import me.brennan.barebones.http.AllCookiesJar;
import me.brennan.barebones.proxy.Proxy;
import me.brennan.barebones.proxy.ProxyList;
import me.brennan.barebones.task.Task;
import me.brennan.barebones.state.State;
import me.brennan.barebones.state.States;
import okhttp3.OkHttpClient;

import java.net.InetSocketAddress;
import java.util.UUID;

/**
 * @author Brennan / skateboard
 * @since 4/14/2022
 **/
public abstract class AbstractTask implements Task {
    private final UUID uuid = UUID.randomUUID();
    private boolean stopped = false;

    private ProxyList proxyList;

    private OkHttpClient client;

    // this is a field so when we rotate proxy it will have the same cookies.
    private final AllCookiesJar cookieJar = new AllCookiesJar();

    public AbstractTask() {
        this.rotateProxy(); // set our initial client with a proxy.
    }

    /**
     * This method is called when you want to start the state loops.
     */
    public void runTask() {
        State state = States.INITIALIZE; // our initial state

        while (!stopped) { // while loop when not stopped
            state = this.next(state);

            if (state == States.ERROR) { // if we have an error break the loop.
                System.out.println("Task has encountered a error!");
                break;
            }
        }
    }

    /**
     * This method is called when you want to stop the task.
     */
    @Override
    public State stop() {
        setStopped(true);
        return States.NONE;
    }

    @Override
    public UUID getUUID() {
        return uuid;
    }

    @Override
    public ProxyList getProxyList() {
        return proxyList;
    }

    @Override
    public OkHttpClient getClient() {
        return client;
    }

    @Override
    public void setStopped(boolean stopped) {
        this.stopped = stopped;
    }

    @Override
    public boolean isStopped() {
        return stopped;
    }

    protected void rotateProxy() {
        final Proxy proxy = proxyList.randomProxy();

        if (proxy != null) {
            if(proxy.getUsername() != null && proxy.getPassword() != null) {
                this.client = new OkHttpClient.Builder()
                        .proxy(new java.net.Proxy(java.net.Proxy.Type.HTTP, new InetSocketAddress(proxy.getIp(), proxy.getPort())))
                        .proxyAuthenticator(proxy.getAuthenticator())
                        .cookieJar(cookieJar)
                        .build();
            } else {
                this.client = new OkHttpClient.Builder()
                        .proxy(new java.net.Proxy(java.net.Proxy.Type.HTTP, new InetSocketAddress(proxy.getIp(), proxy.getPort())))
                        .cookieJar(cookieJar)
                        .build();
            }
        } else {
            this.client = new OkHttpClient.Builder()
                    .cookieJar(cookieJar)
                    .build();
        }
    }
}
