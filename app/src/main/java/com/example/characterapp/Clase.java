package com.example.characterapp;

public abstract class Clase {



    private String nombre;

    private int costeVida;

    private int costeHa;
    private int costeHd;
    private int costeLlevarArmadura;

    private int costeZeon;
    private int costeAct;
    private int costeProyMagica;
    private int costeNivelMagia;

    private int costeCv;
    private int costeProyPsiquica;

    private int costeAdvertir;
    private int costeArte;
    private int costeCapFisica;
    private int costeConocimiento;
    private int costeSigilo;
    private int costeVisionMágica;


    private int vidaNivel;
    private int haNivel;
    private int hdNivel;
    private int llevarArmaduraNivel;

    private int zeonNivel;

    private int cvCadaXNiveles;

    private int advertirNivel;
    private int arteNivel;
    private int capFisicaNivel;
    private int conocimientoNivel;
    private int sigiloNivel;
    private int visionMagicaNivel;

    public Clase(String nombre, int costeVida, int costeHa, int costeHd, int costeLlevarArmadura, int costeZeon, int costeAct, int costeProyMagica, int costeNivelMagia, int costeCv, int costeProyPsiquica, int costeAdvertir, int costeArte, int costeCapFisica, int costeConocimiento, int costeSigilo, int costeVisionMágica, int vidaNivel, int haNivel, int hdNivel, int llevarArmaduraNivel, int zeonNivel, int cvCadaXNiveles, int advertirNivel, int arteNivel, int capFisicaNivel, int conocimientoNivel, int sigiloNivel, int visionMagicaNivel) {
        this.nombre = nombre;
        this.costeVida = costeVida;
        this.costeHa = costeHa;
        this.costeHd = costeHd;
        this.costeLlevarArmadura = costeLlevarArmadura;
        this.costeZeon = costeZeon;
        this.costeAct = costeAct;
        this.costeProyMagica = costeProyMagica;
        this.costeNivelMagia = costeNivelMagia;
        this.costeCv = costeCv;
        this.costeProyPsiquica = costeProyPsiquica;
        this.costeAdvertir = costeAdvertir;
        this.costeArte = costeArte;
        this.costeCapFisica = costeCapFisica;
        this.costeConocimiento = costeConocimiento;
        this.costeSigilo = costeSigilo;
        this.costeVisionMágica = costeVisionMágica;
        this.vidaNivel = vidaNivel;
        this.haNivel = haNivel;
        this.hdNivel = hdNivel;
        this.llevarArmaduraNivel = llevarArmaduraNivel;
        this.zeonNivel = zeonNivel;
        this.cvCadaXNiveles = cvCadaXNiveles;
        this.advertirNivel = advertirNivel;
        this.arteNivel = arteNivel;
        this.capFisicaNivel = capFisicaNivel;
        this.conocimientoNivel = conocimientoNivel;
        this.sigiloNivel = sigiloNivel;
        this.visionMagicaNivel = visionMagicaNivel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCosteVida() {
        return costeVida;
    }

    public void setCosteVida(int costeVida) {
        this.costeVida = costeVida;
    }

    public int getCosteHa() {
        return costeHa;
    }

    public void setCosteHa(int costeHa) {
        this.costeHa = costeHa;
    }

    public int getCosteHd() {
        return costeHd;
    }

    public void setCosteHd(int costeHd) {
        this.costeHd = costeHd;
    }

    public int getCosteLlevarArmadura() {
        return costeLlevarArmadura;
    }

    public void setCosteLlevarArmadura(int costeLlevarArmadura) {
        this.costeLlevarArmadura = costeLlevarArmadura;
    }

    public int getCosteZeon() {
        return costeZeon;
    }

    public void setCosteZeon(int costeZeon) {
        this.costeZeon = costeZeon;
    }

    public int getCosteAct() {
        return costeAct;
    }

    public void setCosteAct(int costeAct) {
        this.costeAct = costeAct;
    }

    public int getCosteProyMagica() {
        return costeProyMagica;
    }

    public void setCosteProyMagica(int costeProyMagica) {
        this.costeProyMagica = costeProyMagica;
    }

    public int getCosteNivelMagia() {
        return costeNivelMagia;
    }

    public void setCosteNivelMagia(int costeNivelMagia) {
        this.costeNivelMagia = costeNivelMagia;
    }

    public int getCosteCv() {
        return costeCv;
    }

    public void setCosteCv(int costeCv) {
        this.costeCv = costeCv;
    }

    public int getCosteProyPsiquica() {
        return costeProyPsiquica;
    }

    public void setCosteProyPsiquica(int costeProyPsiquica) {
        this.costeProyPsiquica = costeProyPsiquica;
    }

    public int getCosteAdvertir() {
        return costeAdvertir;
    }

    public void setCosteAdvertir(int costeAdvertir) {
        this.costeAdvertir = costeAdvertir;
    }

    public int getCosteArte() {
        return costeArte;
    }

    public void setCosteArte(int costeArte) {
        this.costeArte = costeArte;
    }

    public int getCosteCapFisica() {
        return costeCapFisica;
    }

    public void setCosteCapFisica(int costeCapFisica) {
        this.costeCapFisica = costeCapFisica;
    }

    public int getCosteConocimiento() {
        return costeConocimiento;
    }

    public void setCosteConocimiento(int costeConocimiento) {
        this.costeConocimiento = costeConocimiento;
    }

    public int getCosteSigilo() {
        return costeSigilo;
    }

    public void setCosteSigilo(int costeSigilo) {
        this.costeSigilo = costeSigilo;
    }

    public int getCosteVisionMágica() {
        return costeVisionMágica;
    }

    public void setCosteVisionMágica(int costeVisionMágica) {
        this.costeVisionMágica = costeVisionMágica;
    }

    public int getVidaNivel() {
        return vidaNivel;
    }

    public void setVidaNivel(int vidaNivel) {
        this.vidaNivel = vidaNivel;
    }

    public int getHaNivel() {
        return haNivel;
    }

    public void setHaNivel(int haNivel) {
        this.haNivel = haNivel;
    }

    public int getHdNivel() {
        return hdNivel;
    }

    public void setHdNivel(int hdNivel) {
        this.hdNivel = hdNivel;
    }

    public int getLlevarArmaduraNivel() {
        return llevarArmaduraNivel;
    }

    public void setLlevarArmaduraNivel(int llevarArmaduraNivel) {
        this.llevarArmaduraNivel = llevarArmaduraNivel;
    }

    public int getZeonNivel() {
        return zeonNivel;
    }

    public void setZeonNivel(int zeonNivel) {
        this.zeonNivel = zeonNivel;
    }

    public int getCvCadaXNiveles() {
        return cvCadaXNiveles;
    }

    public void setCvCadaXNiveles(int cvCadaXNiveles) {
        this.cvCadaXNiveles = cvCadaXNiveles;
    }

    public int getAdvertirNivel() {
        return advertirNivel;
    }

    public void setAdvertirNivel(int advertirNivel) {
        this.advertirNivel = advertirNivel;
    }

    public int getArteNivel() {
        return arteNivel;
    }

    public void setArteNivel(int arteNivel) {
        this.arteNivel = arteNivel;
    }

    public int getCapFisicaNivel() {
        return capFisicaNivel;
    }

    public void setCapFisicaNivel(int capFisicaNivel) {
        this.capFisicaNivel = capFisicaNivel;
    }

    public int getConocimientoNivel() {
        return conocimientoNivel;
    }

    public void setConocimientoNivel(int conocimientoNivel) {
        this.conocimientoNivel = conocimientoNivel;
    }

    public int getSigiloNivel() {
        return sigiloNivel;
    }

    public void setSigiloNivel(int sigiloNivel) {
        this.sigiloNivel = sigiloNivel;
    }

    public int getVisionMagicaNivel() {
        return visionMagicaNivel;
    }

    public void setVisionMagicaNivel(int visionMagica) {
        this.visionMagicaNivel = visionMagica;
    }
}
