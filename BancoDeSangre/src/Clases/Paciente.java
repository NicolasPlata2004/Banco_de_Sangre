package Clases;

class Paciente{

    String nombreP;
    String documentoP;
    String celularP;
    String correoP;
    String tipoDeSangreP;
    int edadD;

    public Paciente(String nombreP, String documentoP, String celularP, String correoP, String tipoDeSangreP, int edadD) {

        this.nombreP = nombreP;
        this.documentoP = documentoP;
        this.celularP = celularP;
        this.correoP = correoP;
        this.tipoDeSangreP = tipoDeSangreP;
        this.edadD = edadD;
    }

    @Override
    public String toString() {
        return nombreP + "," + documentoP + "," + celularP + "," + correoP + "," + tipoDeSangreP + "," + edadD;
    }


    public void setNombre(String nuevoNombre) {
        this.nombreP = nuevoNombre;
    }


    public void setDocumento(String nuevoDocumento) {
        this.documentoP = nuevoDocumento;
    }
}

