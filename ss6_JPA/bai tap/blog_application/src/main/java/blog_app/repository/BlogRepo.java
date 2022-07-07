package blog_app.repository;

import blog_app.entity.Blog;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface BlogRepo {
    List<Blog> seeAllBlogs();
    Blog findById(int id);
    void save(Blog blog);
    void delete(int id);
}
