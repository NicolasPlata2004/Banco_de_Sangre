package Clases;

public class Donante {

    String nombreD;
    String documentoD;
    String celularD;
    String correoD;
    String tipoSangreD;
    int edadD;

    public Donante(String nombreD, String documentoD, String celularD, String correoD, String tipoSangreD, int edad) {

        this.nombreD = nombreD;
        this.documentoD = documentoD;
        this.celularD = celularD;
        this.correoD = correoD;
        this.tipoSangreD = tipoSangreD;
        this.edadD = edad;
    }
    @Override
    public String toString() {
        return nombreD + "," + documentoD + "," + celularD + "," + correoD + "," + tipoSangreD + "," + edadD;

    }
    public void setNombre(String nuevoNombre) {
        this.nombreD = nuevoNombre;
    }


    public void setDocumento(String nuevoDocumento) {
        this.documentoD = nuevoDocumento;
    }
}

