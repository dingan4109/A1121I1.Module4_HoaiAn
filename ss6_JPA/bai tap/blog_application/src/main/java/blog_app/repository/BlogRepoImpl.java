package blog_app.repository;

import blog_app.entity.Blog;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class BlogRepoImpl implements BlogRepo {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Blog> seeAllBlogs() {
       String hql = "SELECT b FROM Blog b";
        TypedQuery<Blog> query = entityManager.createQuery(hql,Blog.class);

        return query.getResultList();
    }

    @Override
    public Blog findById(int id) {
        String hql = "SELECT b FROM Blog b WHERE b.id = :id";
        TypedQuery<Blog> query = entityManager.createQuery(hql,Blog.class).setParameter("id",id);

        return query.getSingleResult();
    }

    @Override
    public void save(Blog blog) {
        if(blog.getId() == 0) {
            entityManager.persist(blog);
        }else {
            entityManager.merge(blog);
        }
    }

    @Override
    public void delete(int id) {
        Blog blog = findById(id);
        entityManager.remove(blog);
    }
}
