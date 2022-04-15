package me.brennan.barebones.proxy;

import me.brennan.barebones.manager.AbstractMapManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author Brennan / skateboard
 * @since 4/14/2022
 **/
public class ProxyManager extends AbstractMapManager<String, List<Proxy>> {
    private final Random random = new Random();

    /**
     * Will load all text documents containing the word "proxies" from the current use directory.
     */
    public void loadAllProxyFiles() {
        try {
            final File[] listFiles = new File(System.getProperty("user.dir")).listFiles();

            if(listFiles != null) {
                for (File file : listFiles) {
                    if(file.getName().endsWith(".txt") & file.getName().contains("proxies")) {
                        loadFile(file);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Will load the specified file.
     * @param file - The file to load.
     */
    public void loadFile(File file) {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            final List<Proxy> proxies = new LinkedList<>();

            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            String string;
            while ((string = bufferedReader.readLine()) != null) {
                final String[] split = string.split(":");

                if(split.length > 3) {
                    proxies.add(new Proxy(split[0], Integer.parseInt(split[1]), split[2], split[3]));
                } else {
                    proxies.add(new Proxy(split[0], Integer.parseInt(split[1])));
                }
            }

            add(file.getName(), proxies);

            bufferedReader.close();
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Proxy randomProxy(String proxyList) {
        if(isEmpty())
            return null;

        final List<Proxy> proxies = get(proxyList);
        final Proxy proxy = proxies.get(random.nextInt(proxies.size()));
        proxies.remove(proxy); // Remove the proxy from the list so it can't be used again.
        add(proxyList, proxies); // Replace the proxy list back to the list.

        return proxy;
    }

}
