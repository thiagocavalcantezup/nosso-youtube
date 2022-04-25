package br.com.zup.edu.nossoyoutube.video;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(VideoController.BASE_URI)
public class VideoController {

    public final static String BASE_URI = "/videos";

    private final VideoRepository videoRepository;

    public VideoController(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @Transactional
    @PatchMapping("/{videoId}/visualizacoes")
    public ResponseEntity<Void> incrementarVisualizacoes(@PathVariable Long videoId) {
        Video video = videoRepository.findById(videoId)
                                     .orElseThrow(
                                         () -> new ResponseStatusException(
                                             HttpStatus.NOT_FOUND,
                                             "Não existe um vídeo com o id fornecido."
                                         )
                                     );

        video.incrementarVisualizacoes();

        return ResponseEntity.noContent().build();
    }

    @Transactional
    @PatchMapping("/{videoId}/gostei")
    public ResponseEntity<Void> incrementarGostei(@PathVariable Long videoId) {
        Video video = videoRepository.findById(videoId)
                                     .orElseThrow(
                                         () -> new ResponseStatusException(
                                             HttpStatus.NOT_FOUND,
                                             "Não existe um vídeo com o id fornecido."
                                         )
                                     );

        video.incrementarGostei();

        return ResponseEntity.noContent().build();
    }

    @Transactional
    @PatchMapping("/{videoId}/nao-gostei")
    public ResponseEntity<Void> incrementarNaoGostei(@PathVariable Long videoId) {
        Video video = videoRepository.findById(videoId)
                                     .orElseThrow(
                                         () -> new ResponseStatusException(
                                             HttpStatus.NOT_FOUND,
                                             "Não existe um vídeo com o id fornecido."
                                         )
                                     );

        video.incrementarNaoGostei();

        return ResponseEntity.noContent().build();
    }

}
