public class Livro {
    private String titulo;
    private String autor;
    private int n_paginas;

    // Construtor
    public Livro(String titulo, String autor, int n_paginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.n_paginas = n_paginas;
    }

    // Métodos de acesso (getters)
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getNPaginas() {
        return n_paginas;
    }

    // Métodos modificadores (setters)
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setNPaginas(int n_paginas) {
        this.n_paginas = n_paginas;
    }
}