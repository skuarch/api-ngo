package model.components;

import model.database.HibernateConnection;

/**
 * Data Access Object Generic.
 *
 * @author skuarch
 */
public abstract class DataAccessObject implements DataAccessObjectInterface {

    //==========================================================================
    @Override
    public <T> T getObject(long id, Class<T> c) throws Exception {

        if (id < 1) {
            throw new IllegalArgumentException("id is less than 1");
        }

        T t = null;

        try {

            t = new HibernateConnection().getObject(id, c);

        } catch (Exception e) {
            throw e;
        }

        return t;

    }

    //==========================================================================
    @Override
    public long createObject(Object object) throws Exception {

        if (object == null) {
            throw new IllegalArgumentException("object is null");
        }

        long id;

        try {

            id = new HibernateConnection().createObject(object);

        } catch (Exception e) {
            throw e;
        }

        return id;

    }
    
    //==========================================================================
    @Override
    public void updateObject(Object object) throws Exception {

        if (object == null) {
            throw new IllegalArgumentException("object is null");
        }

        try {

            new HibernateConnection().updateObject(object);

        } catch (Exception e) {
            throw e;
        }

    }
    
    
    //==========================================================================
    @Override
    public void deleteObject(Object object) throws Exception {

        if (object == null) {
            throw new IllegalArgumentException("object is null");
        }

        try {

            new HibernateConnection().deleteObject(object);

        } catch (Exception e) {
            throw e;
        }

    }
    
}
