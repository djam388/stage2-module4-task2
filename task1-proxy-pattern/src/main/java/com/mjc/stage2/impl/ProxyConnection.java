package com.mjc.stage2.impl;


import com.mjc.stage2.Connection;

public class ProxyConnection implements Connection {
    private final Connection connection;


    public ProxyConnection(Connection connection) {
        this.connection = connection;
    }

    public void reallyClose() {
        connection.close();
    }

    @Override
    public void close() {
        ConnectionPool.getInstance().releaseConnection(connection);
    }

    @Override
    public boolean isClosed() {
        return connection.isClosed();
    }

}
