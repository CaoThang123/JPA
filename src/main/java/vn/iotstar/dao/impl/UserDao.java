package vn.iotstar.dao.impl;

import java.util.List;


import jakarta.persistence.Query;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.iotstar.configs.JPAConfig;
import vn.iotstar.dao.IUser;
import vn.iotstar.entity.User;
import jakarta.persistence.TypedQuery;

public class UserDao implements IUser{

	 @Override
	    public void insert(User user) {
	        EntityManager enma = JPAConfig.getEntityManager();
	        EntityTransaction trans = enma.getTransaction();
	        
	        try {
	            trans.begin();
	            enma.persist(user);
	            trans.commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	            trans.rollback();
	            throw e;
	        } finally {
	            enma.close();
	        }
	    }

	    @Override
	    public void update(User user) {
	        EntityManager enma = JPAConfig.getEntityManager();
	        EntityTransaction trans = enma.getTransaction();
	        
	        try {
	            trans.begin();
	            enma.merge(user);
	            trans.commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	            trans.rollback();
	            throw e;
	        } finally {
	            enma.close();
	        }
	    }

	    @Override
	    public void delete(int userid) throws Exception {
	        EntityManager enma = JPAConfig.getEntityManager();
	        EntityTransaction trans = enma.getTransaction();
	        
	        try {
	            trans.begin();
	            User user = enma.find(User.class, userid);
	            if (user != null) {
	                enma.remove(user);
	            } else {
	                throw new Exception("Không tìm thấy User với ID: " + userid);
	            }
	            trans.commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	            trans.rollback();
	            throw e;
	        } finally {
	            enma.close();
	        }
	    }

	    @Override
	    public User findById(int userid) {
	        EntityManager enma = JPAConfig.getEntityManager();
	        return enma.find(User.class, userid);
	    }

	    @Override
	    public List<User> findAll() {
	        EntityManager enma = JPAConfig.getEntityManager();
	        TypedQuery<User> query = enma.createQuery("SELECT u FROM User u", User.class);
	        return query.getResultList();
	    }

	    @Override
	    public List<User> findByUsername(String uname) {
	        EntityManager enma = JPAConfig.getEntityManager();
	        String jpql = "SELECT u FROM User u WHERE u.username LIKE :uname";
	        TypedQuery<User> query = enma.createQuery(jpql, User.class);
	        query.setParameter("uname", "%" + uname + "%");
	        return query.getResultList();
	    }

	    @Override
	    public List<User> findAll(int page, int pagesize) {
	        EntityManager enma = JPAConfig.getEntityManager();
	        TypedQuery<User> query = enma.createQuery("SELECT u FROM User u", User.class);
	        query.setFirstResult((page - 1) * pagesize);
	        query.setMaxResults(pagesize);
	        return query.getResultList();
	    }

	    @Override
	    public int count() {
	        EntityManager enma = JPAConfig.getEntityManager();
	        String jpql = "SELECT COUNT(u) FROM User u";
	        Query query = enma.createQuery(jpql);
	        return ((Long) query.getSingleResult()).intValue();
	    }

}
