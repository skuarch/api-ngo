package model.database;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * Generic Data Access Object, please don't create an object only use a
 * instance. example of use "new DAO().method();"
 *
 * @author skuarch
 */
public class HibernateConnection {

    private Session session = null;

    //==========================================================================
    /**
     * create a instance. for use this class please don't create an object,
     * <br>
     * only used new DAO().method();
     *
     * @throws Exception if something is wrong
     */
    public HibernateConnection() throws Exception {
        startSession();
    } // end DAO

    //==========================================================================
    /**
     * start session with hibernate.
     *
     * @throws HibernateException
     */
    private void startSession() throws HibernateException {

        try {

            session = HibernateUtil.getSessionFactory().openSession();

        } catch (HibernateException he) {
            HibernateUtil.closeSession(session);
            throw he;
        }
    } // end startSession

    //==========================================================================
    /**
     * save object in database.
     *
     * @param object Object
     * @return long (id)
     * @throws HibernateException if something is wrong
     */
    public long createObject(Object object) throws HibernateException {

        if (object == null) {
            throw new IllegalArgumentException("the parameter object is null");
        }

        long id = 0;

        try {

            id = (Long) session.save(object);
            session.beginTransaction().commit();

        } catch (HibernateException he) {
            throw he;
        } finally {
            HibernateUtil.closeSession(session);
        }

        return id;

    } // end create

    //==========================================================================
    /**
     * delete object in database.
     *
     * @param object Object
     * @throws HibernateException if something is wrong
     */
    public void deleteObject(Object object) throws HibernateException {

        if (object == null) {
            throw new IllegalArgumentException("the parameter object is null");
        }

        try {

            session.delete(object);
            session.beginTransaction().commit();

        } catch (HibernateException he) {
            throw he;
        } finally {
            HibernateUtil.closeSession(session);
        }
    } // end delete

    //==========================================================================
    /**
     * find object in the data base;
     *
     * @param <T> type
     * @param id long
     * @param c Class
     * @return Generic Object.
     * @throws HibernateException if something is wrong
     */
    public <T> T getObject(long id, Class<T> c) throws HibernateException {

        if (c == null) {
            throw new IllegalArgumentException("the parameter c is null");
        }

        if (id < 1) {
            throw new IllegalArgumentException("the parameter id is less than 1");
        }

        T t = null;

        try {

            t = (T) session.get(c, id);
            session.beginTransaction().commit();

        } catch (HibernateException he) {
            throw he;
        } finally {
            HibernateUtil.closeSession(session);
        }

        return t;

    } // end get

    //==========================================================================
    /**
     * update a object in database.
     *
     * @param object Object
     * @throws HibernateException if something is wrong
     */
    public void updateObject(Object object) throws HibernateException {

        if (object == null) {
            throw new IllegalArgumentException("the parameter object is null");
        }

        try {
            session.update(object);
            session.beginTransaction().commit();
        } catch (HibernateException he) {
            throw he;
        } finally {
            HibernateUtil.closeSession(session);
        }

    } // end update

    //==========================================================================
    /**
     * return the hole list of objects.
     *
     * @param <T> type     
     * @param c Class
     * @return Generic Object.
     * @throws HibernateException if something is wrong
     */
    public <T> List<T> getList(Class<T> c) throws HibernateException {

        if (c == null) {
            throw new IllegalArgumentException("the parameter c is null");
        }

        List<T> list = null;

        try {

            list = session.createQuery("from " + c.getCanonicalName()).list();

        } catch (HibernateException he) {
            throw he;
        } finally {
            HibernateUtil.closeSession(session);
        }

        return list;

    } // end getList
    
    //==========================================================================    
    /**
     * execute an named query.
     * @param <T> type
     * @param queryName String
     * @param c class
     * @return List
     * @throws HibernateException if something is wrong
     */
    public <T> List<T> executeNamedQuery(String queryName, Class<T> c) throws HibernateException {

        if (queryName == null || queryName.length() < 1) {
            throw new NullPointerException("queryName is null or empty");
        }

        if (c == null) {
            throw new NullPointerException("c is null");
        }

        Query query = null;
        List<T> list = null;

        try {

            query = session.getNamedQuery(queryName);
            query.setProperties(c);
            list = query.list();

        } catch (HibernateException he) {
            throw he;
        } finally {
            HibernateUtil.closeSession(session);
        }

        return list;

    } // end executeQuery
    
    //==========================================================================
    /**
     * 
     * @param <T> type
     * @param queryName String
     * @param parameters HashMap
     * @param c class
     * @return List
     * @throws HibernateException if something is wrong. 
     */    
    public <T> List<T> executeNamedQuery(String queryName, HashMap<String, String> parameters, Class<T> c) throws HibernateException {

        if (queryName == null || queryName.length() < 1) {
            throw new NullPointerException("queryName is null or empty");
        }

        if (parameters == null || parameters.size() < 1) {
            throw new NullPointerException("parameters are null or empty");
        }

        if (c == null) {
            throw new NullPointerException("c is null");
        }

        String key = null;
        String value = null;
        Query query = null;
        List<T> list = null;

        try {

            query = session.getNamedQuery(queryName);
            query.setProperties(c);

            for (Map.Entry<String, String> entry : parameters.entrySet()) {
                key = entry.getKey();
                value = entry.getValue();
                query.setString(key, value);
            }

            list = query.list();

        } catch (HibernateException he) {
            throw he;
        } finally {
            HibernateUtil.closeSession(session);
        }

        return list;

    } // end query


} // end class
