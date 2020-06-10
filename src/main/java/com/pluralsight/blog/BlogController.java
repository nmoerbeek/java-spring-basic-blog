package com.pluralsight.blog;

import com.pluralsight.blog.data.PostRepository;
import com.pluralsight.blog.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BlogController {

    private PostRepository postRepository;

    public BlogController(PostRepository p)
    {
        this.postRepository = p;
    }
    @RequestMapping("/")
    public String listPosts(ModelMap m)
    {
       List<Post> listPost = this.postRepository.getAllPosts();
        m.put("title", "Blog Post 1");
        m.put("posts", listPost);
        return "home";
    }
    @RequestMapping("/post/{id}")
    public String postDetails(@PathVariable Long id, ModelMap modelMap)
    {
        Post p = this.postRepository.findById(id);
        modelMap.put("post", p);
        return "post-details";
    }

}
