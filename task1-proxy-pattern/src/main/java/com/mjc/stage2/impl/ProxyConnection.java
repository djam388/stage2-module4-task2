package com.mjc.stage2.impl;


import com.mjc.stage2.Connection;

public class ProxyConnection implements Connection {
    private RealConnection realConnection;

    public ProxyConnection(RealConnection realConnection) {
        this.realConnection = realConnection;
    }

    public void reallyClose() {
        realConnection.close();
    }

    @Override
    public void close() {
//        if (ConnectionPool.getInstance().getFreeConnectionsCount() > 0) {
            ConnectionPool.getInstance().releaseConnection(new ProxyConnection(realConnection));
//        }
    }

    @Override
    public boolean isClosed() {
        return realConnection.isClosed();
    }

}
