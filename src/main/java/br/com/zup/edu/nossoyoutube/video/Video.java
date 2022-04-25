package br.com.zup.edu.nossoyoutube.video;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "videos")
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String link;

    @OneToOne(mappedBy = "video", cascade = {
            CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private QuantidadeVisualizacoesVideo visualizacoes;

    @OneToOne(mappedBy = "video", cascade = {
            CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private QuantidadeGosteiVideo gostei;

    @OneToOne(mappedBy = "video", cascade = {
            CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private QuantidadeNaoGosteiVideo naoGostei;

    @Version
    private int versao;

    /**
     * @deprecated Construtor de uso exclusivo do Hibernate
     */
    @Deprecated
    public Video() {}

    public Video(String titulo, String descricao, String link) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.link = link;
        this.visualizacoes = new QuantidadeVisualizacoesVideo(this);
        this.gostei = new QuantidadeGosteiVideo(this);
        this.naoGostei = new QuantidadeNaoGosteiVideo(this);
    }

    public void incrementarVisualizacoes() {
        visualizacoes.incrementar();
    }

    public void incrementarGostei() {
        gostei.incrementar();
    }

    public void incrementarNaoGostei() {
        naoGostei.incrementar();
    }

    public Long getId() {
        return id;
    }

}
