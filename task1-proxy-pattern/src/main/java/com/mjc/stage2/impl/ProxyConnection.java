package com.mjc.stage2.impl;


import com.mjc.stage2.Connection;

public class ProxyConnection implements Connection {
    private ProxyConnection proxyConnection;

    public ProxyConnection(ProxyConnection proxyConnection) {
        this.proxyConnection = proxyConnection;
    }

    public void reallyClose() {
        proxyConnection.close();
    }

    @Override
    public void close() {
        ConnectionPool.getInstance().releaseConnection(proxyConnection);
    }

    @Override
    public boolean isClosed() {
        return proxyConnection.isClosed();
    }

}
