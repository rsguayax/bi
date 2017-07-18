/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author TAWSBC
 */
public abstract class GenericDAO<Entity, K extends Serializable> {

    public Class<Entity> domainClass = getDomainClass();
    private Session session;

    protected Class getDomainClass() {
        if (domainClass == null) {
            ParameterizedType thisType = (ParameterizedType) getClass()
                    .getGenericSuperclass();
            domainClass = (Class) thisType.getActualTypeArguments()[0];
        }
        return domainClass;
    }

    protected Session getHibernateTemplate() {
        session = HibernateUtil.getSessionFactory().openSession();
//        session = HibernateUtil.getsession();
        session.beginTransaction();
        return session;
    }

    public Entity buscar(K id) {
        try {
            Entity returnValue = (Entity) getHibernateTemplate().get(domainClass, id);
//            session.getTransaction().commit();
            return (Entity) returnValue;
        } catch (Exception ex) {
            Logger.getLogger(Level.SEVERE.getName(), " Excepción al buscar en [ "+domainClass+ "] -->"+ ex);
        } finally {
            if (session.isOpen()) {
                session.flush();
                session.close();
            }
        }
        return null;
    }

    public Entity buscar(String key, int val) throws HibernateException {
        try {
            String q = "from " + domainClass.getName() + " a where a." + key + " = " + val;
            Entity obj = (Entity) getHibernateTemplate().createQuery(q).uniqueResult();
//            session.getTransaction().commit();
            return obj;
        } catch (Exception ex) {
            Logger.getLogger(Level.SEVERE.getName(), " Excepción al buscar en [ "+domainClass+ "] -->"+ ex);
        } finally {
            if (session.isOpen()) {
                session.flush();
                session.close();
            }
        }
        return null;
    }

    public Entity buscar(String key, String val) throws HibernateException {
        try {
            String q = "from " + domainClass.getName() + " a where a." + key + " = '" + val + "'";
            Entity obj = (Entity) getHibernateTemplate().createQuery(q).uniqueResult();
//            session.getTransaction().commit();
            return obj;
        } catch (Exception ex) {
            Logger.getLogger(Level.SEVERE.getName(), " Excepción al buscar en [ "+domainClass+ "] -->"+ ex);
        } finally {
            if (session.isOpen()) {
                session.flush();
                session.close();
            }
        }
        return null;
    }

    public Entity buscar(String key1, String key2, int val1, int val2) throws HibernateException {
        try {
            String q = "from " + domainClass.getName() + " a where a." + key1 + " = " + val1 + " and a." + key2 + " = " + val2;
            Entity obj = (Entity) getHibernateTemplate().createQuery(q).uniqueResult();
//            session.getTransaction().commit();
            return obj;
        } catch (Exception ex) {
            Logger.getLogger(Level.SEVERE.getName(), " Excepción al buscar en [ "+domainClass+ "] -->"+ ex);
        } finally {
            if (session.isOpen()) {
                session.flush();
                session.close();
            }
        }
        return null;
    }

    public Entity buscar(String key1, String key2, String val1, String val2) throws HibernateException {
        try {
            String q = "from " + domainClass.getName() + " a where a." + key1 + " = '" + val1 + "' and a." + key2 + " = '" + val2 + "'";
            Entity obj = (Entity) getHibernateTemplate().createQuery(q).uniqueResult();
//            session.getTransaction().commit();
            return obj;
        } catch (Exception ex) {
            Logger.getLogger(Level.SEVERE.getName(), " Excepción al buscar en [ "+domainClass+ "] -->"+ ex);
        } finally {
            if (session.isOpen()) {
                session.flush();
                session.close();
            }
        }
        return null;
    }

    public List<Entity> listar() {
        try {
            List<Entity> returnValue = (List<Entity>) getHibernateTemplate().createCriteria(domainClass).list();
//            session.getTransaction().commit();
            return returnValue;
        } catch (Exception ex) {
            Logger.getLogger(Level.SEVERE.getName(), " Excepción al listar en [ "+domainClass+ "] -->"+ ex);
        } finally {
            if (session.isOpen()) {
                session.flush();
                session.close();
            }
        }
        return null;
    }

    public List<Object[]> listar_sentencia_sql(String q) {
        try {
            List<Object[]> lista = (List<Object[]>) getHibernateTemplate().createSQLQuery(q).list();
//            session.getTransaction().commit();
            return lista;
        } catch (Exception ex) {
            Logger.getLogger(Level.SEVERE.getName(), " Excepción al listar_condicion en [ "+domainClass+ "] -->"+ ex);
        } finally {
            if (session.isOpen()) {
                session.flush();
                session.close();
            }
        }
        return null;
    }
    
    public List<Entity> listar_condicion_query(String q) {
        try {
            List<Entity> lista = (List<Entity>) getHibernateTemplate().createQuery(q).setMaxResults(10).list();
//            session.getTransaction().commit();
            return lista;
        } catch (Exception ex) {
            Logger.getLogger(Level.SEVERE.getName(), " Excepción al listar_condicion en [ "+domainClass+ "] -->"+ ex);
        } finally {
            if (session.isOpen()) {
                session.flush();
                session.close();
            }
        }
        return null;
    }

    public long listar_sentencia_sql_count(String q) {
        try {
            long lista = (long) getHibernateTemplate().createQuery(q).uniqueResult();
//            session.getTransaction().commit();
            return lista;
        } catch (Exception ex) {
            Logger.getLogger(Level.SEVERE.getName(), " Excepción al listar_sentencia_sql_count para [ " + domainClass + "] -->" + ex);
        } finally {
            if (session.isOpen()) {
                session.flush();
                session.close();
            }
        }
        return 0;
    }
    
    public List<Entity> listar(String orderby) {
        try {
//            List<Entity> returnValue = (List<Entity>) getHibernateTemplate().createCriteria(domainClass).list();
            String q = "from " + domainClass.getName() + " " + orderby;
            List<Entity> returnValue = (List<Entity>) getHibernateTemplate().createQuery(q).list();
//            session.getTransaction().commit();
            return returnValue;
        } catch (Exception ex) {
            Logger.getLogger(Level.SEVERE.getName(), " Excepción al listar en [ " + domainClass + "] -->" + ex);
        } finally {
            if (session.isOpen()) {
                session.flush();
                session.close();
            }
        }
        return null;
    }
    
    public long _count(String campowhere, int valorwhere, String campowhere2, int valorwhere2) {
        long count = 0;
        try {
            String q = "";
            if (campowhere == null && campowhere2 == null) {
                q = "select count(*) from " + domainClass.getName() + " sl";
            }else if(campowhere!= null && campowhere2 == null){
                q = "select count(*) from " + domainClass.getName() + " sl where sl." + campowhere + " = " + valorwhere;
            }else if(campowhere != null && campowhere2 != null){
                q = "select count(*) from " + domainClass.getName() + " sl where sl." + campowhere + " = " + valorwhere +" and sl." + campowhere2 + " = " + valorwhere2;
            }
            count = (long) getHibernateTemplate().createQuery(q).uniqueResult();
        } catch (Exception ex) {
            Logger.getLogger(Level.SEVERE.getName(), " Excepción al contar en  _count para [ " + domainClass + "] -->  _count: " + ex);
        } finally {
            if (session.isOpen()) {
                session.flush();
                session.close();
            }
        }
        return count;
    }

    public List<Entity> listar_condicion(String key1, String val1) {
        try {
            String q = "from " + domainClass.getName() + " a where a." + key1 + " = '" + val1 + "'";
            List<Entity> lista = (List<Entity>) getHibernateTemplate().createQuery(q).list();
//            session.getTransaction().commit();
            return lista;
        } catch (Exception ex) {
            Logger.getLogger(Level.SEVERE.getName(), " Excepción al listar_condicion en [ "+domainClass+ "] -->"+ ex);
        } finally {
            if (session.isOpen()) {
                session.flush();
                session.close();
            }
        }
        return null;
    }

    public List<Entity> listar_condicion(String key1, int val1) {
        try {
            String q = "from " + domainClass.getName() + " a where a." + key1 + " = " + val1;
            List<Entity> lista = (List<Entity>) getHibernateTemplate().createQuery(q).list();
//            session.getTransaction().commit();
            return lista;
        } catch (Exception ex) {
            Logger.getLogger(Level.SEVERE.getName(), " Excepción al listar_condicion en [ "+domainClass+ "] -->"+ ex);
        } finally {
            if (session.isOpen()) {
                session.flush();
                session.close();
            }
        }
        return null;
    }

    public List<Entity> listar_condicion(String key1, String key2, int val1, int val2) {
        try {
            String q = "from " + domainClass.getName() + " a where a." + key1 + " = " + val1 + " and a." + key2 + " = " + val2;
            List<Entity> lista = (List<Entity>) getHibernateTemplate().createQuery(q).list();
//            session.getTransaction().commit();
            return lista;
        } catch (Exception ex) {
            Logger.getLogger(Level.SEVERE.getName(), " Excepción al listar_condicion en [ "+domainClass+ "] -->"+ ex);
        } finally {
            if (session.isOpen()) {
                session.flush();
                session.close();
            }
        }
        return null;
    }

    public Entity actualizar(Entity t) throws HibernateException {
        try {
            getHibernateTemplate().update(t);
            session.getTransaction().commit();
            return t;
        } catch (HibernateException ex) {
            Logger.getLogger(Level.SEVERE.getName(), " Excepción al actualizar en [ "+domainClass+ "] -->"+ ex);
        } finally {
            if (session.isOpen()) {
                session.flush();
                session.close();
            }
        }
        return t;
    }

    public Entity guardar(Entity t) throws HibernateException {
        try {
            getHibernateTemplate().save(t);
            session.getTransaction().commit();
            return t;
        } catch (HibernateException ex) {
            Logger.getLogger(Level.SEVERE.getName(), " Excepción al guardar en [ "+domainClass+ "] -->"+ ex);
        } finally {
            if (session.isOpen()) {
                session.flush();
                session.close();
            }
        }
        return t;
    }

    public void eliminar(K id) {
        try {
            Entity t = buscar(id);
            getHibernateTemplate().delete(t);
            session.getTransaction().commit();
        } catch (Exception ex) {
            Logger.getLogger(Level.SEVERE.getName(), " Excepción al eliminar en [ "+domainClass+ "] -->"+ ex);
        } finally {
            if (session.isOpen()) {
                session.flush();
                session.close();
            }
        }
    }

}
