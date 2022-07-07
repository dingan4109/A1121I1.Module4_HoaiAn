package blog_app.service;

import blog_app.entity.Blog;
import blog_app.repository.BlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepo blogRepo;
    @Override
    public List<Blog> seeAllBlogs() {
        return blogRepo.seeAllBlogs();
    }

    @Override
    public Blog findById(int id) {
        return blogRepo.findById(id);
    }

    @Override
    public void save(Blog blog) {
        blogRepo.save(blog);
    }

    @Override
    public void delete(int id) {
        blogRepo.delete(id);
    }
}
