package aleksandra.diary.service;

import aleksandra.diary.model.Post;

import java.util.List;
import java.util.Optional;


public interface PostService {
    List<Post> getAllPosts();
    void deletePost(long id);
    void addPost(Post post);
    void updatePost(Post post);
    Optional<Post> getPostById(long id);
}
