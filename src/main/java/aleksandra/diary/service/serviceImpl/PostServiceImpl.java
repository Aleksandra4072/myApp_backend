package aleksandra.diary.service.serviceImpl;

import aleksandra.diary.model.Post;
import aleksandra.diary.repository.PostRepository;
import aleksandra.diary.service.PostService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    @Transactional
    public void deletePost(long id) {
        postRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void addPost(Post post) {
        postRepository.save(post);
    }

    @Override
    @Transactional
    public void updatePost(Post post) {
        postRepository.saveAndFlush(post);
    }

    @Override
    public Optional<Post> getPostById(long id) {
        return postRepository.findById(id);
    }
}
