package blog_app.service;

import blog_app.entity.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();
    Blog findById(int id);
    void save(Blog blog);
    void deleteById(int id);
}
