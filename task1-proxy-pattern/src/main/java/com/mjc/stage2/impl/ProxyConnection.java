package com.mjc.stage2.impl;


import com.mjc.stage2.Connection;

public class ProxyConnection implements Connection {
    private RealConnection realConnection;
    private ConnectionPool connectionPool;

    public ProxyConnection(RealConnection realConnection) {
        this.realConnection = realConnection;
    }

    public void reallyClose() {
        realConnection.close();
    }

    @Override
    public void close() {
        connectionPool.releaseConnection(realConnection);
    }

    @Override
    public boolean isClosed() {
        return realConnection.isClosed();
    }

}
