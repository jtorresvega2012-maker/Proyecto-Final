/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author ALEX JOSHUA TORRES V
 */
public class PaginaInformativa extends Pagina {

    public PaginaInformativa(String titulo, int numeroPagina, String contenido) {
        super(titulo, numeroPagina, contenido);
    }

    @Override
    public void mostrarContenido() {

        System.out.println("================================");
        System.out.println("Página: " + getNumeroPagina());
        System.out.println("Título: " + getTitulo());
        System.out.println("--------------------------------");
        System.out.println(getContenido());
        System.out.println("================================");

    }
}
