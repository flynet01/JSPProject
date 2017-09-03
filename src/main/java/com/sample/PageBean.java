package com.sample;

import org.infinispan.Cache;
import org.infinispan.manager.EmbeddedCacheManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;

public class PageBean {
    Context context = new InitialContext();

    Cache<String, String> cache;

    public PageBean(HttpSession session) throws NamingException {


        EmbeddedCacheManager container = (EmbeddedCacheManager) context.lookup("java:jboss/infinispan/container/web");
        cache = container.getCache();
        System.out.println(((EmbeddedCacheManager) context.lookup("java:jboss/infinispan/container/server")).getCache().getName());
        System.out.println(((EmbeddedCacheManager) context.lookup("java:jboss/infinispan/container/web")).getCache().getName());
        System.out.println(((EmbeddedCacheManager) context.lookup("java:jboss/infinispan/container/ejb")).getCache().getName());
        cache.clear();
    }

    public int getCacheSize(){
        return cache.size();
    }

    public int getServerCacheSize() throws NamingException {
        return ((EmbeddedCacheManager) context.lookup("java:jboss/infinispan/container/server")).getCache().size();
    }

    public int getEjbCacheSize() throws NamingException {
        return ((EmbeddedCacheManager) context.lookup("java:jboss/infinispan/container/ejb")).getCache().size();
    }

    public String getCacheContent(){
        StringBuffer sb = new StringBuffer();
        cache.entrySet().stream().forEach(cs -> sb.append("key: " + cs.getKey() + ", value: " + cs.getValue() + "<br />"));
        return sb.toString();
    }
}
