package com.example.characterapp;

import com.example.characterapp.clases.Guerrero;

public class Personaje {

    private Integer id;
    private String nombre;
    private String raza;
    private Integer nivel;
    private Clase clase;

    private Integer arma;
    private Integer armadura;

    private Integer agilidad;
    private Integer constitucion;
    private Integer destreza;
    private Integer fuerza;
    private Integer inteligencia;
    private Integer percepcion;
    private Integer poder;
    private Integer voluntad;

    private Integer pd;

    private Integer pdVida;
    private Integer pdHa;
    private Integer pdHd;
    private Integer pdLlevarArmadura;
    private Integer pdZeon;
    private Integer pdAct;
    private Integer pdProyMagica;
    private Integer pdNivelMagia;
    private Integer pdCv;
    private Integer pdProyPsiquica;
    private Integer pdSigilo;
    private Integer pdAdvertir;
    private Integer pdConocimiento;
    private Integer pdArte;
    private Integer pdCapFisica;
    private Integer pdValoracionMagica;



    public Personaje(String nombre) {
        this.nombre = nombre;
        this.raza = "";
        this.nivel = 1;
        this.clase = new Guerrero();
        this.arma = 0;
        this.agilidad = 0;
        this.constitucion = 0;
        this.destreza = 0;
        this.fuerza = 0;
        this.inteligencia = 0;
        this.percepcion = 0;
        this.poder = 0;
        this.voluntad = 0;
        this.pd = 600;
        this.pdVida = 0;
        this.pdHa = 0;
        this.pdHd = 0;
        this.pdLlevarArmadura = 0;
        this.pdZeon = 0;
        this.pdAct = 0;
        this.pdProyMagica = 0;
        this.pdNivelMagia = 0;
        this.pdCv = 0;
        this.pdProyPsiquica = 0;
        this.pdSigilo = 0;
        this.pdAdvertir = 0;
        this.pdConocimiento = 0;
        this.pdArte = 0;
        this.pdCapFisica = 0;
        this.pdValoracionMagica = 0;
    }

    public Personaje(Integer id, String nombre, String raza, Integer nivel, Clase clase, Integer arma, Integer agilidad, Integer constitucion, Integer destreza, Integer fuerza, Integer inteligencia, Integer percepcion, Integer poder, Integer voluntad, Integer pd, Integer pdVida, Integer pdHa, Integer pdHd, Integer pdLlevarArmadura, Integer pdZeon, Integer pdAct, Integer pdProyMagica, Integer pdNivelMagia, Integer pdCv, Integer pdProyPsiquica, Integer pdSigilo, Integer pdAdvertir, Integer pdConocimiento, Integer pdArte, Integer pdCapFisica, Integer pdValoracionMagica, Integer pdArma, Integer pdArmadura) {
        this.id = id;
        this.nombre = nombre;
        this.raza = raza;
        this.nivel = nivel;
        this.clase = clase;
        this.arma = arma;
        this.agilidad = agilidad;
        this.constitucion = constitucion;
        this.destreza = destreza;
        this.fuerza = fuerza;
        this.inteligencia = inteligencia;
        this.percepcion = percepcion;
        this.poder = poder;
        this.voluntad = voluntad;
        this.pd = pd;
        this.pdVida = pdVida;
        this.pdHa = pdHa;
        this.pdHd = pdHd;
        this.pdLlevarArmadura = pdLlevarArmadura;
        this.pdZeon = pdZeon;
        this.pdAct = pdAct;
        this.pdProyMagica = pdProyMagica;
        this.pdNivelMagia = pdNivelMagia;
        this.pdCv = pdCv;
        this.pdProyPsiquica = pdProyPsiquica;
        this.pdSigilo = pdSigilo;
        this.pdAdvertir = pdAdvertir;
        this.pdConocimiento = pdConocimiento;
        this.pdArte = pdArte;
        this.pdCapFisica = pdCapFisica;
        this.pdValoracionMagica = pdValoracionMagica;
    }

    private Integer  calcularPDs()
    {
        Integer valor = 0;
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

    private Integer calcularBonoCaracteristica(Integer caracteristica)
    {
        Integer bono = 0;

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

    public Integer calcularValorPdsHabilidad(Integer pdshabilidad, Integer costehabilidad)
    {
        Integer coste = costehabilidad;
        if (costehabilidad == 0) { coste = 2; }
        return pdshabilidad/coste;
    }

    public Integer calcularBonoHabilidad(Integer caracteristica, Integer bonoClaseXnivel)
    {
        Integer bonocaracteristica = calcularBonoCaracteristica(caracteristica);
        return bonocaracteristica + (bonoClaseXnivel*this.nivel);
    }

    private Integer calcularHabilidadFinal(Integer pdshabilidad, Integer costehabilidad, Integer caracteristica, Integer bonoClaseXNivel)
    {
        Integer habilidadFinal = calcularValorPdsHabilidad(pdshabilidad, costehabilidad) + calcularBonoHabilidad(caracteristica, bonoClaseXNivel);
        return habilidadFinal;
    }

    public Integer tablaDeNivelDeMagia(Integer inteligencia)
    {
        Integer valor = 0;
        if (inteligencia <= 5)
        {
            valor = 0;
        } else if (inteligencia <= 10)
        {
            valor = (inteligencia-5)*10;
        } else if (inteligencia <= 12)
        {
            valor = 50+(inteligencia-10)*25;
        } else if (inteligencia <= 14)
        {
            valor = 100+(inteligencia-12)*50;
        } else if (inteligencia >= 15)
        {
            valor = 200+(inteligencia-14)*100;
        }
        return valor;
    }
    public Integer tablaDeAct(Integer poder)
    {
        Integer valor = 5;
        if (1 <= poder && poder <= 4)
        {
            valor = 0;
        } else if (poder <= 7)
        {
            valor = 5;
        } else if (poder <= 11)
        {
            valor = 10;
        } else if (poder <= 14)
        {
            valor = 15;
        } else if (poder == 15) {
            valor = 20;
        } else if (poder <= 17)
        {
            valor = 25;
        } else if (poder <= 19)
        {
            valor = 30;
        } else if (poder >= 20)
        {
            valor = 35;
        }
        return valor;
    }

    private Integer tablaDeVidaOZeon(Integer característica)
    {
        Integer valor = 20;
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

    public Integer calcularVida()
    {
        Integer pv = 0;
        pv = tablaDeVidaOZeon(this.constitucion);
        pv += (this.pdVida / this.clase.getCosteVida())*this.constitucion;
        pv += this.clase.getVidaNivel() * this.nivel;
        return pv;
    }



    public Integer calcularZeon()
    {
        Integer zeon = 0;
        zeon = tablaDeVidaOZeon(this.poder);
        zeon += (this.pdZeon / this.clase.getCosteZeon())*this.poder;
        zeon += this.clase.getZeonNivel() * this.nivel;
        return zeon;

    }


    public Integer calcularAct()
    {
        return tablaDeAct(this.poder) + this.calcularValorPdsHabilidad(this.pdAct, this.getClase().getCosteAct()) * tablaDeAct(this.poder);
    }

    public Integer calcularHabilidadAtaque()
    {
        return calcularHabilidadFinal(this.pdHa, this.clase.getCosteHa(), this.destreza, this.clase.getHaNivel());
    }
    public Integer calcularHabilidadDefensa()
    {
        return calcularHabilidadFinal(this.pdHd, this.clase.getCosteHd(),this.agilidad, this.clase.getHdNivel());
    }
    public Integer calcularLlevarArmadura()
    {
        return calcularHabilidadFinal(this.pdLlevarArmadura, this.clase.getCosteLlevarArmadura(),this.fuerza, this.clase.getLlevarArmaduraNivel());
    }
    public Integer calcularProyMagica()
    {
        return calcularHabilidadFinal(this.pdProyMagica, this.clase.getCosteProyMagica(),this.destreza, 0);
    }
    public Integer calcularNivelMagia()
    {
        return this.getPdNivelMagia() - (this.getPdNivelMagia() % this.getClase().getCosteNivelMagia()) + tablaDeNivelDeMagia(this.getInteligencia());
    }
    public Integer calcularCVs()
    {
        return calcularValorPdsHabilidad(this.getPdCv(), this.getClase().getCosteCv()) + this.nivel / this.getClase().getCvCadaXNiveles();
    }
    public Integer calcularProyPsiquica()
    {
        return calcularHabilidadFinal(this.pdProyPsiquica, this.clase.getCosteProyPsiquica(),this.destreza, 0);
    }
    public Integer calcularSigilo()
    {
        return calcularHabilidadFinal(this.pdSigilo, this.clase.getCosteSigilo(), this.agilidad, this.clase.getSigiloNivel());
    }
    public Integer calcularAdvertir()
    {
        return calcularHabilidadFinal(this.pdAdvertir, this.clase.getCosteAdvertir(), this.percepcion, this.clase.getAdvertirNivel());
    }
    public Integer calcularCapFisica()
    {
        return calcularHabilidadFinal(this.pdCapFisica, this.clase.getCosteCapFisica(),this.fuerza, this.clase.getCapFisicaNivel());
    }
    public Integer calcularConocimiento()
    {
        return calcularHabilidadFinal(this.pdConocimiento, this.clase.getCosteConocimiento(),this.inteligencia, this.clase.getConocimientoNivel());
    }
    public Integer calcularArte()
    {
        return calcularHabilidadFinal(this.pdArte, this.clase.getCosteArte(),this.poder, this.clase.getArteNivel());
    }
    public Integer calcularValoracionMagica()
    {
        return calcularHabilidadFinal(this.pdValoracionMagica, this.clase.getCosteVisionMágica(), this.poder, this.clase.getVisionMagicaNivel());
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getRaza() { return raza; }

    public void setRaza(String raza) { this.raza = raza; }

    public Integer getNivel() { return nivel; }

    public void setNivel(Integer nivel) { this.nivel = nivel; }

    public Clase getClase() { return clase; }

    public void setClase(Clase clase) { this.clase = clase; }

    public Integer getArma() { return arma; }

    public void setArma(int arma) { this.arma = arma; }

    public Integer getArmadura() { return armadura; }

    public void setArmadura(int armadura) { this.armadura = armadura; }

    public Integer getAgilidad() { return agilidad; }

    public void setAgilidad(Integer agilidad) { this.agilidad = agilidad; }

    public Integer getConstitucion() { return constitucion; }

    public void setConstitucion(Integer constitucion) { this.constitucion = constitucion; }

    public Integer getDestreza() { return destreza; }

    public void setDestreza(Integer destreza) { this.destreza = destreza; }

    public Integer getPercepcion() { return percepcion; }

    public void setPercepcion(Integer percepcion) { this.percepcion = percepcion; }

    public Integer getPoder() { return poder; }

    public void setPoder(Integer poder) { this.poder = poder; }

    public Integer getVoluntad() { return voluntad; }

    public void setVoluntad(Integer voluntad) { this.voluntad = voluntad; }

    public Integer getPd() { return pd; }

    public void setPd(Integer pd) { this.pd = pd; }

    public Integer getPdVida() { return pdVida; }

    public void setPdVida(Integer pdVida) { this.pdVida = pdVida; }

    public Integer getPdHa() { return pdHa; }

    public void setPdHa(Integer pdHa) { this.pdHa = pdHa; }

    public Integer getPdHd() { return pdHd; }

    public void setPdhd(Integer pdHd) { this.pdHd = pdHd; }

    public Integer getpdLlevarArmadura() { return pdLlevarArmadura; }

    public void setpdLlevarArmadura(Integer pdLlevarArmadura) { this.pdLlevarArmadura = pdLlevarArmadura; }

    public Integer getPdZeon() { return pdZeon; }

    public void setPdZeon(Integer pdZeon) { this.pdZeon = pdZeon; }

    public Integer getPdAct() { return pdAct; }

    public void setPdAct(Integer pdAct) { this.pdAct = pdAct; }

    public Integer getPdproyMagica() { return pdProyMagica; }

    public void setPdProyMagica(Integer pdProyMagica) { this.pdProyMagica = pdProyMagica; }

    public Integer getPdNivelMagia() { return pdNivelMagia; }

    public void setPdNivelMagia(Integer pdNivelMagia) { this.pdNivelMagia = pdNivelMagia; }

    public Integer getPdCv() { return pdCv; }

    public void setPdCv(Integer pdCv) { this.pdCv = pdCv; }

    public Integer getPdProyPsiquica() { return pdProyPsiquica; }

    public void setPdproyPsiquica(Integer pdProyPsiquica) { this.pdProyPsiquica = pdProyPsiquica; }

    public Integer getPdSigilo() { return pdSigilo; }

    public void setPdSigilo(Integer pdSigilo) { this.pdSigilo = pdSigilo; }

    public Integer getPdAdvertir() { return pdAdvertir; }

    public void setPdAdvertir(Integer pdAdvertir) { this.pdAdvertir = pdAdvertir; }

    public Integer getPdConocimiento() { return pdConocimiento; }

    public void setPdConocimiento(Integer pdConocimiento) { this.pdConocimiento = pdConocimiento; }

    public Integer getPdArte() { return pdArte; }

    public void setPdArte(Integer pdArte) { this.pdArte = pdArte; }

    public Integer getPdCapFisica() { return pdCapFisica; }

    public void setPdCapFisica(Integer pdCapFisica) { this.pdCapFisica = pdCapFisica; }

    public Integer getFuerza() {
        return fuerza;
    }

    public void setFuerza(Integer fuerza) {
        this.fuerza = fuerza;
    }

    public Integer getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(Integer inteligencia) {
        this.inteligencia = inteligencia;
    }

    public void setPdHd(Integer pdHd) {
        this.pdHd = pdHd;
    }

    public Integer getPdLlevarArmadura() {
        return pdLlevarArmadura;
    }

    public void setPdLlevarArmadura(Integer pdLlevarArmadura) {
        this.pdLlevarArmadura = pdLlevarArmadura;
    }

    public Integer getPdProyMagica() {
        return pdProyMagica;
    }

    public void setPdProyPsiquica(Integer pdProyPsiquica) {
        this.pdProyPsiquica = pdProyPsiquica;
    }

    public Integer getPdValoracionMagica() {
        return pdValoracionMagica;
    }

    public void setPdValoracionMagica(Integer pdValoracionMagica) {
        this.pdValoracionMagica = pdValoracionMagica;
    }

    public String toString() {
        if (nombre.length() > 42) {

            return nombre.substring(0, 42) + "..." + " (Lvl " + nivel + ")\n" + raza;
        }
        return nombre + " (Lvl " + nivel + ")\n" + raza;
    }
}
