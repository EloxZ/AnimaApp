package com.example.characterapp;

public abstract class Clase {



    private String nombre;

    private Integer costeVida;

    private Integer costeHa;
    private Integer costeHd;
    private Integer costeLlevarArmadura;

    private Integer costeZeon;
    private Integer costeAct;
    private Integer costeProyMagica;
    private Integer costeNivelMagia;

    private Integer costeCv;
    private Integer costeProyPsiquica;

    private Integer costeAdvertir;
    private Integer costeArte;
    private Integer costeCapFisica;
    private Integer costeConocimiento;
    private Integer costeSigilo;
    private Integer costeVisionMágica;


    private Integer vidaNivel;
    private Integer haNivel;
    private Integer hdNivel;
    private Integer llevarArmaduraNivel;

    private Integer zeonNivel;

    private Integer cvCadaXNiveles;

    private Integer advertirNivel;
    private Integer arteNivel;
    private Integer capFisicaNivel;
    private Integer conocimientoNivel;
    private Integer sigiloNivel;
    private Integer visionMagicaNivel;

    public Clase(String nombre, Integer costeVida, Integer costeHa, Integer costeHd, Integer costeLlevarArmadura, Integer costeZeon, Integer costeAct, Integer costeProyMagica, Integer costeNivelMagia, Integer costeCv, Integer costeProyPsiquica, Integer costeAdvertir, Integer costeArte, Integer costeCapFisica, Integer costeConocimiento, Integer costeSigilo, Integer costeVisionMágica, Integer vidaNivel, Integer haNivel, Integer hdNivel, Integer llevarArmaduraNivel, Integer zeonNivel, Integer cvCadaXNiveles, Integer advertirNivel, Integer arteNivel, Integer capFisicaNivel, Integer conocimientoNivel, Integer sigiloNivel, Integer visionMagicaNivel) {
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

    public Integer getCosteVida() {
        return costeVida;
    }

    public void setCosteVida(Integer costeVida) {
        this.costeVida = costeVida;
    }

    public Integer getCosteHa() {
        return costeHa;
    }

    public void setCosteHa(Integer costeHa) {
        this.costeHa = costeHa;
    }

    public Integer getCosteHd() {
        return costeHd;
    }

    public void setCosteHd(Integer costeHd) {
        this.costeHd = costeHd;
    }

    public Integer getCosteLlevarArmadura() {
        return costeLlevarArmadura;
    }

    public void setCosteLlevarArmadura(Integer costeLlevarArmadura) {
        this.costeLlevarArmadura = costeLlevarArmadura;
    }

    public Integer getCosteZeon() {
        return costeZeon;
    }

    public void setCosteZeon(Integer costeZeon) {
        this.costeZeon = costeZeon;
    }

    public Integer getCosteAct() {
        return costeAct;
    }

    public void setCosteAct(Integer costeAct) {
        this.costeAct = costeAct;
    }

    public Integer getCosteProyMagica() {
        return costeProyMagica;
    }

    public void setCosteProyMagica(Integer costeProyMagica) {
        this.costeProyMagica = costeProyMagica;
    }

    public Integer getCosteNivelMagia() {
        return costeNivelMagia;
    }

    public void setCosteNivelMagia(Integer costeNivelMagia) {
        this.costeNivelMagia = costeNivelMagia;
    }

    public Integer getCosteCv() {
        return costeCv;
    }

    public void setCosteCv(Integer costeCv) {
        this.costeCv = costeCv;
    }

    public Integer getCosteProyPsiquica() {
        return costeProyPsiquica;
    }

    public void setCosteProyPsiquica(Integer costeProyPsiquica) {
        this.costeProyPsiquica = costeProyPsiquica;
    }

    public Integer getCosteAdvertir() {
        return costeAdvertir;
    }

    public void setCosteAdvertir(Integer costeAdvertir) {
        this.costeAdvertir = costeAdvertir;
    }

    public Integer getCosteArte() {
        return costeArte;
    }

    public void setCosteArte(Integer costeArte) {
        this.costeArte = costeArte;
    }

    public Integer getCosteCapFisica() {
        return costeCapFisica;
    }

    public void setCosteCapFisica(Integer costeCapFisica) {
        this.costeCapFisica = costeCapFisica;
    }

    public Integer getCosteConocimiento() {
        return costeConocimiento;
    }

    public void setCosteConocimiento(Integer costeConocimiento) {
        this.costeConocimiento = costeConocimiento;
    }

    public Integer getCosteSigilo() {
        return costeSigilo;
    }

    public void setCosteSigilo(Integer costeSigilo) {
        this.costeSigilo = costeSigilo;
    }

    public Integer getCosteVisionMágica() {
        return costeVisionMágica;
    }

    public void setCosteVisionMágica(Integer costeVisionMágica) {
        this.costeVisionMágica = costeVisionMágica;
    }

    public Integer getVidaNivel() {
        return vidaNivel;
    }

    public void setVidaNivel(Integer vidaNivel) {
        this.vidaNivel = vidaNivel;
    }

    public Integer getHaNivel() {
        return haNivel;
    }

    public void setHaNivel(Integer haNivel) {
        this.haNivel = haNivel;
    }

    public Integer getHdNivel() {
        return hdNivel;
    }

    public void setHdNivel(Integer hdNivel) {
        this.hdNivel = hdNivel;
    }

    public Integer getLlevarArmaduraNivel() {
        return llevarArmaduraNivel;
    }

    public void setLlevarArmaduraNivel(Integer llevarArmaduraNivel) {
        this.llevarArmaduraNivel = llevarArmaduraNivel;
    }

    public Integer getZeonNivel() {
        return zeonNivel;
    }

    public void setZeonNivel(Integer zeonNivel) {
        this.zeonNivel = zeonNivel;
    }

    public Integer getCvCadaXNiveles() {
        return cvCadaXNiveles;
    }

    public void setCvCadaXNiveles(Integer cvCadaXNiveles) {
        this.cvCadaXNiveles = cvCadaXNiveles;
    }

    public Integer getAdvertirNivel() {
        return advertirNivel;
    }

    public void setAdvertirNivel(Integer advertirNivel) {
        this.advertirNivel = advertirNivel;
    }

    public Integer getArteNivel() {
        return arteNivel;
    }

    public void setArteNivel(Integer arteNivel) {
        this.arteNivel = arteNivel;
    }

    public Integer getCapFisicaNivel() {
        return capFisicaNivel;
    }

    public void setCapFisicaNivel(Integer capFisicaNivel) {
        this.capFisicaNivel = capFisicaNivel;
    }

    public Integer getConocimientoNivel() {
        return conocimientoNivel;
    }

    public void setConocimientoNivel(Integer conocimientoNivel) {
        this.conocimientoNivel = conocimientoNivel;
    }

    public Integer getSigiloNivel() {
        return sigiloNivel;
    }

    public void setSigiloNivel(Integer sigiloNivel) {
        this.sigiloNivel = sigiloNivel;
    }

    public Integer getVisionMagicaNivel() {
        return visionMagicaNivel;
    }

    public void setVisionMagicaNivel(Integer visionMagica) {
        this.visionMagicaNivel = visionMagica;
    }
}
