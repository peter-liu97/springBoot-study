package com.test;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

public class TransactionTest extends TransactionTemplate {
    public TransactionTest() {
        super();
    }

    public TransactionTest(PlatformTransactionManager transactionManager) {
        super(transactionManager);
    }

    public TransactionTest(PlatformTransactionManager transactionManager, TransactionDefinition transactionDefinition) {
        super(transactionManager, transactionDefinition);
    }

    @Override
    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        super.setTransactionManager(transactionManager);
    }

    @Override
    public PlatformTransactionManager getTransactionManager() {
        return super.getTransactionManager();
    }

    @Override
    public void afterPropertiesSet() {
        super.afterPropertiesSet();
    }

    @Override
    public <T> T execute(TransactionCallback<T> action) throws TransactionException {
        return super.execute(action);
    }

    @Override
    public boolean equals(Object other) {
        return super.equals(other);
    }
}
