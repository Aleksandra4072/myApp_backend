package aleksandra.diary.controller;

import aleksandra.diary.model.Post;
import aleksandra.diary.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/board")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<List<Post>> allPosts() {
        return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/deletePost")
    public ResponseEntity<Void> removePost(@RequestParam Long id) {
        postService.deletePost(id);
       return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/post")
    public ResponseEntity<Optional<Post>> getPostById(@RequestParam Long id) {
        return new ResponseEntity<>(postService.getPostById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/addPost")
    public ResponseEntity<Void> addPost(@RequestBody Post newPost) {
        postService.addPost(newPost);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/updatePost")
    public ResponseEntity<Void> updatePost(@PathVariable("postId") Long postId, @RequestBody Post updatedPost) {
        Optional<Post> post = postService.getPostById(postId);
        if(post == null) {
            throw new NotFoundException("Post was not found");
        }
        postService.updatePost(updatedPost);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
