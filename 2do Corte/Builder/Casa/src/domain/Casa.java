package domain;

public class Casa {

    private String paredes;
    private String puertas;
    private String ventanas;
    private String techo;
    private int pisos;
    private String garaje;
    private String piscina;
    private String jardin;
    private String terraza;

    public void setParedes(String paredes) {
        this.paredes = paredes;
    }

    public void setPuertas(String puertas) {
        this.puertas = puertas;
    }

    public void setVentanas(String ventanas) {
        this.ventanas = ventanas;
    }

    public void setTecho(String techo) {
        this.techo = techo;
    }

    public void setPisos(int pisos) {
        this.pisos = pisos;
    }

    public void setGaraje(String garaje) {
        this.garaje = garaje;
    }

    public void setPiscina(String piscina) {
        this.piscina = piscina;
    }

    public void setJardin(String jardin) {
        this.jardin = jardin;
    }

    public void setTerraza(String terraza) {
        this.terraza = terraza;
    }

    public String getParedes() {
        return paredes;
    }

    public String getPuertas() {
        return puertas;
    }

    public String getVentanas() {
        return ventanas;
    }

    public String getTecho() {
        return techo;
    }

    public int getPisos() {
        return pisos;
    }

    public String getGaraje() {
        return garaje;
    }

    public String getPiscina() {
        return piscina;
    }

    public String getJardin() {
        return jardin;
    }

    public String getTerraza() {
        return terraza;
    }

    public String mostrarCasa() {
        StringBuilder resultado = new StringBuilder();
        agregar(resultado, "Paredes", paredes);
        agregar(resultado, "Puertas", puertas);
        agregar(resultado, "Ventanas", ventanas);
        agregar(resultado, "Techo", techo);
        if (pisos > 0) {
            agregar(resultado, "Pisos", String.valueOf(pisos));
        }
        agregar(resultado, "Garaje", garaje);
        agregar(resultado, "Piscina", piscina);
        agregar(resultado, "Jardin", jardin);
        agregar(resultado, "Terraza", terraza);
        return resultado.toString();
    }

    private void agregar(StringBuilder resultado, String etiqueta, String valor) {
        if (valor == null) {
            return;
        }
        if (resultado.length() > 0) {
            resultado.append(System.lineSeparator());
        }
        resultado.append("- ").append(etiqueta).append(": ").append(valor);
    }
}
