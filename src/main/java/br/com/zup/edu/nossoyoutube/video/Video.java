package br.com.zup.edu.nossoyoutube.video;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
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

    @Column(nullable = false)
    private Integer visualizacoes;

    @Column(nullable = false)
    private Integer gostei; // joinha para cima

    @Column(nullable = false)
    private Integer naoGostei; // joinha para baixo

    /**
     * @deprecated Construtor de uso exclusivo do Hibernate
     */
    @Deprecated
    public Video() {}

    public Video(String titulo, String descricao, String link) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.link = link;
        this.visualizacoes = 0;
        this.gostei = 0;
        this.naoGostei = 0;
    }

    public Long getId() {
        return id;
    }

}
