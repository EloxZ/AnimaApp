package com.example.characterapp;

public class Personaje {

    private int id;
    private String nombre;
    private String raza;
    private int nivel;
    private Clase clase;

    private String arma;

    private int agilidad;
    private int constitucion;
    private int destreza;
    private int fuerza;
    private int inteligencia;
    private int percepcion;
    private int poder;
    private int voluntad;

    private int pd;

    private int pdVida;
    private int pdHa;
    private int pdHd;
    private int pdLlevarArmadura;
    private int pdZeon;
    private int pdAct;
    private int pdProyMagica;
    private int pdNivelMagia;
    private int pdCv;
    private int pdProyPsiquica;
    private int pdSigilo;
    private int pdAdvertir;
    private int pdConocimiento;
    private int pdArte;
    private int pdCapFisica;
    private int pdValoracionMagica;
    private int pdArma;
    private int pdArmadura;

    private int  calcularPDs()
    {
        int valor = 0;
        if (this.nivel == 0)
        {
            valor = 400;
        }
        else
        {
            valor = 600 + (nivel-1)*100;
        }
        return valor;
    }

    private int calcularBonoCaracteristica(int caracteristica)
    {
        int bono = 0;

        if (caracteristica <= 0)
        {
            bono = 0;
        } else if (caracteristica<=3) {
            bono = -40 + 10 * caracteristica;
        } else if (caracteristica==4)
        {
            bono = -5;
        } else if (caracteristica==5)
        {
            bono = 0;
        } else if (caracteristica>=6)
        {
            bono = 5+5*((caracteristica-6)/2);
        }
        return bono;
    }

    private int calcularHabilidadFinal(int pdshabilidad, int costehabilidad, int caracteristica, int bonoClaseXNivel, int nivel)
    {
        int coste = costehabilidad;
        if (costehabilidad == 0) { coste = 2; }

        int bonocaracteristica = calcularBonoCaracteristica(caracteristica);
        int habilidadFinal = pdshabilidad/coste + bonocaracteristica + (bonoClaseXNivel*nivel);
        return habilidadFinal;
    }

    private int tablaDeVidaOZeon(int característica)
    {
        int valor = 20;
        switch (característica)
        {
            case 0:  valor = 20; break;
            case 1:  valor = 5; break;
            case 2:  valor = 20; break;
            case 3:  valor = 40; break;
            case 4:  valor = 55; break;
            case 5:  valor = 70; break;
            case 6:  valor = 85; break;
            case 7:  valor = 95; break;
            case 8:  valor = 110; break;
            case 9:  valor = 120; break;
            case 10:  valor = 135; break;
            case 11:  valor = 150; break;
            case 12:  valor = 160; break;
            case 13:  valor = 175; break;
            case 14:  valor = 185; break;
            case 15:  valor = 205; break;
            case 16:  valor = 215; break;
            case 17:  valor = 225; break;
            case 18:  valor = 240; break;
            case 19:  valor = 250; break;
            case 20:  valor = 265; break;
        }
        if (característica>20)
        {
            valor = 265;
        }
        return valor;

    }

    public int calcularVida()
    {
        int pv = 0;
        pv = tablaDeVidaOZeon(this.constitucion);
        pv += (this.pdVida / this.clase.getCosteVida())*this.constitucion;
        pv += this.clase.getVidaNivel() * this.nivel;
        return pv;
    }

    public int calcularZeon()
    {
        int zeon = 0;
        zeon = tablaDeVidaOZeon(this.poder);
        zeon += (this.pdVida / this.clase.getCosteVida())*this.constitucion;
        zeon += this.clase.getVidaNivel() * this.nivel;
        return zeon;

    }



    public int calcularHabilidadAtaque()
    {
        return calcularHabilidadFinal(this.pdHa, this.clase.getCosteHa(), this.destreza, this.clase.getHaNivel(), this.nivel);
    }
    public int calcularHabilidadDefensa()
    {
        return calcularHabilidadFinal(this.pdHd, this.clase.getCosteHd(),this.agilidad, this.clase.getHdNivel(),this.nivel);
    }
    public int calcularLlevarArmadura()
    {
        return calcularHabilidadFinal(this.pdLlevarArmadura, this.clase.getCosteLlevarArmadura(),this.fuerza, this.clase.getLlevarArmaduraNivel(),this.nivel);
    }
    public int calcularProyMagica()
    {
        return calcularHabilidadFinal(this.pdProyMagica, this.clase.getCosteProyMagica(),this.destreza, 0, this.nivel);
    }
    public int calcularProyPsiquica()
    {
        return calcularHabilidadFinal(this.pdProyPsiquica, this.clase.getCosteProyPsiquica(),this.destreza, 0, this.nivel);
    }
    public int calcularSigilo()
    {
        return calcularHabilidadFinal(this.pdSigilo, this.clase.getCosteSigilo(), this.agilidad, this.clase.getSigiloNivel(), this.nivel);
    }
    public int calcularAdverir()
    {
        return calcularHabilidadFinal(this.pdAdvertir, this.clase.getCosteAdvertir(), this.percepcion, this.clase.getAdvertirNivel(), this.nivel);
    }
    public int calcularCapFisica()
    {
        return calcularHabilidadFinal(this.pdCapFisica, this.clase.getCosteCapFisica(),this.fuerza, this.clase.getCapFisicaNivel(), this.nivel);
    }
    public int calcularConocimiento()
    {
        return calcularHabilidadFinal(this.pdConocimiento, this.clase.getCosteConocimiento(),this.inteligencia, this.clase.getConocimientoNivel(), this.nivel);
    }
    public int calcularArte()
    {
        return calcularHabilidadFinal(this.pdArte, this.clase.getCosteArte(),this.poder, this.clase.getArteNivel(), this.nivel);
    }
    public int calcularVisionMagica()
    {
        return calcularHabilidadFinal(this.pd, this.clase.getCosteArte(),this.poder, this.clase.getArteNivel(), this.nivel);
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getRaza() { return raza; }

    public void setRaza(String raza) { this.raza = raza; }

    public int getNivel() { return nivel; }

    public void setNivel(int nivel) { this.nivel = nivel; }

    public Clase getClase() { return clase; }

    public void setClase(Clase clase) { this.clase = clase; }

    public String getArma() { return arma; }

    public void setArma(String arma) { this.arma = arma; }

    public int getAgilidad() { return agilidad; }

    public void setAgilidad(int agilidad) { this.agilidad = agilidad; }

    public int getConstitucion() { return constitucion; }

    public void setConstitucion(int constitucion) { this.constitucion = constitucion; }

    public int getDestreza() { return destreza; }

    public void setDestreza(int destreza) { this.destreza = destreza; }

    public int getPercepcion() { return percepcion; }

    public void setPercepcion(int percepcion) { this.percepcion = percepcion; }

    public int getPoder() { return poder; }

    public void setPoder(int poder) { this.poder = poder; }

    public int getVoluntad() { return voluntad; }

    public void setVoluntad(int voluntad) { this.voluntad = voluntad; }

    public int getPd() { return pd; }

    public void setPd(int pd) { this.pd = pd; }

    public int getPdVida() { return pdVida; }

    public void setPdVida(int pdVida) { this.pdVida = pdVida; }

    public int getPdHa() { return pdHa; }

    public void setPdHa(int pdHa) { this.pdHa = pdHa; }

    public int getPdHd() { return pdHd; }

    public void setPdhd(int pdHd) { this.pdHd = pdHd; }

    public int getpdLlevarArmadura() { return pdLlevarArmadura; }

    public void setpdLlevarArmadura(int pdLlevarArmadura) { this.pdLlevarArmadura = pdLlevarArmadura; }

    public int getPdZeon() { return pdZeon; }

    public void setPdZeon(int pdZeon) { this.pdZeon = pdZeon; }

    public int getPdAct() { return pdAct; }

    public void setPdAct(int pdAct) { this.pdAct = pdAct; }

    public int getPdproyMagica() { return pdProyMagica; }

    public void setPdProyMagica(int pdProyMagica) { this.pdProyMagica = pdProyMagica; }

    public int getPdNivelMagia() { return pdNivelMagia; }

    public void setPdNivelMagia(int pdNivelMagia) { this.pdNivelMagia = pdNivelMagia; }

    public int getPdCv() { return pdCv; }

    public void setPdCv(int pdCv) { this.pdCv = pdCv; }

    public int getPdProyPsiquica() { return pdProyPsiquica; }

    public void setPdproyPsiquica(int pdProyPsiquica) { this.pdProyPsiquica = pdProyPsiquica; }

    public int getPdSigilo() { return pdSigilo; }

    public void setPdSigilo(int pdSigilo) { this.pdSigilo = pdSigilo; }

    public int getPdAdvertir() { return pdAdvertir; }

    public void setPdAdvertir(int pdAdvertir) { this.pdAdvertir = pdAdvertir; }

    public int getPdConocimiento() { return pdConocimiento; }

    public void setPdConocimiento(int pdConocimiento) { this.pdConocimiento = pdConocimiento; }

    public int getPdArte() { return pdArte; }

    public void setPdArte(int pdArte) { this.pdArte = pdArte; }

    public int getPdCapFisica() { return pdCapFisica; }

    public void setPdCapFisica(int pdCapFisica) { this.pdCapFisica = pdCapFisica; }

    public int getPdArma() { return pdArma; }

    public void setPdArma(int pdArma) { this.pdArma = pdArma; }

    public int getPdArmadura() { return pdArmadura; }

    public void setPdArmadura(int pdArmadura) { this.pdArmadura = pdArmadura; }
}
