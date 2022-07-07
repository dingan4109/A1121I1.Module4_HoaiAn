package blog_app.controller;

import blog_app.entity.Blog;
import blog_app.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;
    @GetMapping("/blogs")
    public ModelAndView blogList() {
        List<Blog> blogList = blogService.seeAllBlogs();
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("page","list");
        modelAndView.addObject("blogList",blogList);

        return modelAndView;
    }

    @GetMapping("/write")
    public ModelAndView write() {
        Blog blog = new Blog();
        ModelAndView modelAndView = new ModelAndView("write");
        modelAndView.addObject("page","write");
        modelAndView.addObject("blog",blog);

        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        return "redirect:/blogs";
    }

    @GetMapping("/view/{id}")
    public ModelAndView view(@PathVariable("id") int id) {
        Blog blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("page","view");
        modelAndView.addObject("blog",blog);

        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") int id) {
        Blog blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("page","edit");
        modelAndView.addObject("blog",blog);

        return modelAndView;
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        return "redirect:/blogs";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        blogService.delete(id);
        return "redirect:/blogs";
    }
}
