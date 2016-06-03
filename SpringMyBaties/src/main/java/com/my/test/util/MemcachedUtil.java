package com.my.test.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import org.springframework.stereotype.Component;

import net.spy.memcached.AddrUtil;
import net.spy.memcached.ConnectionFactoryBuilder;
import net.spy.memcached.ConnectionFactoryBuilder.Protocol;
import net.spy.memcached.MemcachedClient;
import net.spy.memcached.auth.AuthDescriptor;
import net.spy.memcached.auth.PlainCallbackHandler;
import net.spy.memcached.transcoders.Transcoder;

//@Component
public class MemcachedUtil {

	private boolean address;
    private MemcachedClient client;
    private List<String> cacheServerAddress;
    private String userName;
    private String pwd;
    
    public MemcachedUtil() {
    	cacheServerAddress = new ArrayList<String>();
    	cacheServerAddress.add("localhost:11211");
//    	userName = "";
//    	pwd = "";
    	try {
			init();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    public void setCacheServerAddress(List<String> cacheServerAddress) {
        this.cacheServerAddress = cacheServerAddress;
    }

    public <T> Future<Boolean> add(String key, int exp, T o, Transcoder<T> tc) {
        return this.client.add(key, exp, o, tc);
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Future<Boolean> add(String key, int exp, Object o) {
        return this.client.add(key, exp, o);
    }

    public <T> Future<Boolean> set(String key, int exp, T o, Transcoder<T> tc) {
        return this.client.set(key, exp, o, tc);
    }

    public Future<Boolean> set(String key, int exp, Object o) {
        return this.client.set(key, exp, o);
    }

    public <T> Future<Boolean> replace(String key, int exp, T o, Transcoder<T> tc) {
        return this.client.replace(key, exp, o, tc);
    }

    public Future<Boolean> replace(String key, int exp, Object o) {
        return this.client.replace(key, exp, o);
    }

    public Future<Boolean> append(long cas, String key, Object val) {
        return this.client.append(cas, key, val);
    }

    public <T> Future<Boolean> append(long cas, String key, T val, Transcoder<T> tc) {
        return this.client.append(cas, key, val, tc);
    }

    public <T> T get(String key, Transcoder<T> tc) {
        return this.client.get(key, tc);
    }

    public Object get(String key) {
        return this.client.get(key);
    }

    public Future<Boolean> delete(String key) {
        return this.client.delete(key);
    }

    public long incr(String key, int by) {
        return this.client.incr(key, by);
    }

    public long decr(String key, int by) {
        return this.client.decr(key, by);
    }

    public long incr(String key, int by, long def, int exp) {
        return this.client.incr(key, by, def, exp);
    }

    public long decr(String key, int by, long def, int exp) {
        return this.client.decr(key, by, def, exp);
    }

    public long incr(String key, int by, long def) {
        return this.client.incr(key, by, def);
    }

    public long decr(String key, int by, long def) {
        return this.client.decr(key, by, def);
    }

    private void init() throws Exception {
        if(null!=this.userName) {
            AuthDescriptor ad = new AuthDescriptor(new String[]{"PLAIN"}, new PlainCallbackHandler(this.userName, this.pwd));
            this.client = new MemcachedClient((new ConnectionFactoryBuilder()).setProtocol(Protocol.BINARY).setAuthDescriptor(ad).build(), AddrUtil.getAddresses(this.cacheServerAddress));
            if(this.client != null) {
            	System.out.println("init memcached client success!");
            } else {
            	System.out.println("init memcached client error!");
            }
        } else {
            this.client = new MemcachedClient(AddrUtil.getAddresses(this.cacheServerAddress));
        }

    }

    public void afterPropertiesSet() {
        this.address = this.cacheServerAddress != null && this.cacheServerAddress.size() > 0;
        if(this.address) {
            try {
                this.init();
            } catch (Exception var2) {
                System.out.println("init memcached client error!");
            }
        } else {
        }

    }

    public void shutdown() {
        try {
            this.client.shutdown();
        } catch (Exception e) {
        	System.out.println("init memcached client error!");
        }

    }

    public void clear() {
        try {
            this.client.flush();
        } catch (Exception var2) {
        	System.out.println("init memcached client error!");
        }

    }
}
