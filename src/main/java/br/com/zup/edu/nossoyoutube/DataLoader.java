package br.com.zup.edu.nossoyoutube;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.zup.edu.nossoyoutube.video.VideoRepository;

@Component
public class DataLoader implements CommandLineRunner {

    private final VideoRepository videoRepository;

    public DataLoader(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (videoRepository.count() == 0) {
            load();
        }
    }

    private void load() {

    }

}
