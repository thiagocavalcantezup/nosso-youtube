package br.com.zup.edu.nossoyoutube.video;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "Quantidades_nao_gostei_video")
public class QuantidadeNaoGosteiVideo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer quantidade;

    @Version
    private int versao;

    @OneToOne
    private Video video;

    /**
     * @deprecated Construtor de uso exclusivo do Hibernate
     */
    @Deprecated
    public QuantidadeNaoGosteiVideo() {}

    public QuantidadeNaoGosteiVideo(Video video) {
        this.video = video;
        this.quantidade = 0;
    }

    public Long getId() {
        return id;
    }

    public void incrementar() {
        quantidade++;
    }

}
