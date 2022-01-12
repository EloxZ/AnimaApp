package com.example.characterapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.characterapp.clases.Guerrero;
import com.example.characterapp.clases.Hechicero;
import com.example.characterapp.clases.Ladron;
import com.example.characterapp.clases.Mentalista;

public class CreatorActivity extends AppCompatActivity {
    private Spinner classSpinner, razaSpinner, spinnerWeapon, spinnerArmor;
    private EditText agilidadNumber, percepNumber, volNumber, poderNumber, intNumber, constNumber, fuerzaNumber, destrezaNumber, lvlNumber;
    private EditText PDsAtaque, PDsDefensa, PDsArmadura, PDsZeon, PDsAct, PDsProyMagica, PDsNivelMagia, PDsCV,
            PDsProyPsiquica, PDsSigilo, PDsAdvertir, PDsConocimiento, PDsArte, PDsCapFisica, PDsValoracionMagica, PDsVida, nameField;

    private TextView pdsDisponibles, baseAtaque, baseDefensa, baseArmadura, baseZeon, baseAct, baseProyMagica, baseNivelMagia, baseCV, baseProyPsiquica, baseSigilo, baseAdvertir, baseConocimiento, baseArte, baseCapFisica, baseValoracionMagica, baseVida;

    private TextView costeAtaque, costeDefensa, costeArmadura, costeZeon, costeAct, costeProyMagica, costeNivelMagia, costeCV, costeProyPsiquica, costeSigilo, costeAdvertir, costeConocimiento, costeArte, costeCapFisica, costeValoracionMagica, costeVida;

    private TextView bonoAtaque, bonoDefensa, bonoArmadura, bonoZeon, bonoAct, bonoProyMagica, bonoNivelMagia, bonoCV, bonoProyPsiquica, bonoSigilo, bonoAdvertir, bonoConocimiento, bonoArte, bonoCapFisica, bonoValoracionMagica, bonoVida;

    private TextView totalAtaque, totalDefensa, totalArmadura, totalZeon, totalAct, totalProyMagica, totalNivelMagia, totalCV, totalProyPsiquica, totalSigilo, totalAdvertir, totalConocimiento, totalArte, totalCapFisica, totalValoracionMagica, totalVida;
    private Button buttonPd, btnAccept;
    private boolean back;
    private ScrollView viewAtr;
    private ConstraintLayout viewPds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creator);
        setTitle("Creador de personaje");
        back = false;
        DatabaseHelper db = new DatabaseHelper(this);

        viewAtr = (ScrollView) findViewById(R.id.viewAtr);
        viewPds = (ConstraintLayout) findViewById(R.id.viewPds);
        classSpinner = (Spinner) findViewById(R.id.classSpinner);
        razaSpinner = (Spinner) findViewById(R.id.razaSpinner);
        spinnerWeapon = (Spinner) findViewById(R.id.spinnerWeapon);
        spinnerArmor = (Spinner) findViewById(R.id.spinnerArmor);
        buttonPd = (Button) findViewById(R.id.buttonPd);
        btnAccept = (Button) findViewById(R.id.btnAccept);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.clases, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.razas, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.armas, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.armaduras, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_item);
        classSpinner.setAdapter(adapter);
        razaSpinner.setAdapter(adapter2);
        spinnerWeapon.setAdapter(adapter3);
        spinnerArmor.setAdapter(adapter4);
        nameField = (EditText) findViewById(R.id.nameField);
        Personaje p = new Personaje("");
        lvlNumber = (EditText) findViewById(R.id.lvlNumber);
        lvlNumber.setTransformationMethod(null);

        //Cada vez que cambiamos una label se tienen que hacer los cambios correspondientes, hay un montón de label, vamos a explicar el funcionamiento de esta ya que todas funcionan igual
        lvlNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                //cogemos el valor del label, si no hay nadie el valor es 0
                Integer val;
                if (lvlNumber.getText().toString().compareTo("")==0)
                {
                    val = 0;
                } else {
                    val = Integer.parseInt(lvlNumber.getText().toString());
                }
                //guardamos el valor de la clase
                p.setNivel(val);
                //hacemos todos los cambios de label que podrian cambiar por el valor cambiado, como estamos cambiando el nivel hay que cambiar casi todos los datos de personaje
                p.setPd(p.calcularPDs());
                Integer pdsdisponibles = calcularPDsDisponibles(p);
                pdsDisponibles.setText(pdsdisponibles.toString());

                baseSigilo.setText(p.calcularValorPdsHabilidad(p.getPdSigilo(),p.getClase().getCosteSigilo()).toString());
                bonoSigilo.setText(p.calcularBonoHabilidad(p.getAgilidad(),p.getClase().getSigiloNivel()).toString());
                totalSigilo.setText(p.calcularSigilo().toString());

                baseDefensa.setText(p.calcularValorPdsHabilidad(p.getPdHd(),p.getClase().getCosteHd()).toString());
                bonoDefensa.setText(p.calcularBonoHabilidad(p.getAgilidad(),p.getClase().getHdNivel()).toString());
                totalDefensa.setText(p.calcularHabilidadDefensa().toString());

                baseAdvertir.setText(p.calcularValorPdsHabilidad(p.getPdAdvertir(),p.getClase().getCosteAdvertir()).toString());
                bonoAdvertir.setText(p.calcularBonoHabilidad(p.getDestreza(),0).toString());
                totalAdvertir.setText(p.calcularAdvertir().toString());

                baseZeon.setText(p.calcularValorPdsHabilidad(p.getPdZeon(),p.getClase().getCosteZeon()).toString());
                Integer valorBonoHabilidad = p.calcularZeon() - p.calcularValorPdsHabilidad(p.getPdZeon(),p.getClase().getCosteZeon());
                bonoZeon.setText(valorBonoHabilidad.toString());
                totalZeon.setText(p.calcularZeon().toString());

                baseValoracionMagica.setText(p.calcularValorPdsHabilidad(p.getPdValoracionMagica(),p.getClase().getCosteVisionMágica()).toString());
                bonoValoracionMagica.setText(p.calcularBonoHabilidad(p.getPoder(),p.getClase().getVisionMagicaNivel()).toString());
                totalValoracionMagica.setText(p.calcularValoracionMagica().toString());

                baseArte.setText(p.calcularValorPdsHabilidad(p.getPdArte(),p.getClase().getCosteVisionMágica()).toString());
                bonoArte.setText(p.calcularBonoHabilidad(p.getPoder(),p.getClase().getArteNivel()).toString());
                totalArte.setText(p.calcularArte().toString());

                Integer base = (p.getPdVida() / p.getClase().getCosteVida())*p.getConstitucion();
                baseVida.setText(base.toString());
                bonoVida.setText(p.calcularBonoHabilidad(p.getAgilidad(),p.getClase().getVidaNivel()).toString());
                totalVida.setText(p.calcularVida().toString());

                baseCapFisica.setText(p.calcularValorPdsHabilidad(p.getPdCapFisica(),p.getClase().getCosteCapFisica()).toString());
                bonoCapFisica.setText(p.calcularBonoHabilidad(p.getFuerza(),p.getClase().getCapFisicaNivel()).toString());
                totalCapFisica.setText(p.calcularCapFisica().toString());

                baseConocimiento.setText(p.calcularValorPdsHabilidad(p.getPdConocimiento(),p.getClase().getCosteConocimiento()).toString());
                bonoConocimiento.setText(p.calcularBonoHabilidad(p.getInteligencia(),p.getClase().getConocimientoNivel()).toString());
                totalConocimiento.setText(p.calcularConocimiento().toString());

                baseNivelMagia.setText(p.calcularValorPdsHabilidad(p.getPdNivelMagia(),p.getClase().getCosteNivelMagia()).toString());
                bonoNivelMagia.setText(p.tablaDeNivelDeMagia(p.getInteligencia()).toString());
                totalNivelMagia.setText(p.calcularNivelMagia().toString());

                baseAtaque.setText(p.calcularValorPdsHabilidad(p.getPdHa(),p.getClase().getCosteHa()).toString());
                bonoAtaque.setText(p.calcularBonoHabilidad(p.getDestreza(),p.getClase().getHaNivel()).toString());
                totalAtaque.setText(p.calcularHabilidadAtaque().toString());

                baseProyMagica.setText(p.calcularValorPdsHabilidad(p.getPdProyMagica(),p.getClase().getCosteProyMagica()).toString());
                bonoProyMagica.setText(p.calcularBonoHabilidad(p.getDestreza(),0).toString());
                totalProyMagica.setText(p.calcularProyMagica().toString());

                baseProyPsiquica.setText(p.calcularValorPdsHabilidad(p.getPdProyPsiquica(),p.getClase().getCosteProyPsiquica()).toString());
                bonoProyPsiquica.setText(p.calcularBonoHabilidad(p.getDestreza(),0).toString());
                totalProyPsiquica.setText(p.calcularProyPsiquica().toString());



            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        pdsDisponibles = (TextView) findViewById(R.id.pdsDisponibles);
        Integer pdsdisponibles = calcularPDsDisponibles(p);
        pdsDisponibles.setText(pdsdisponibles.toString());
        if (pdsdisponibles < 0)
        {
            pdsDisponibles.setTextColor(Color.RED);
        } else
        {
            pdsDisponibles.setTextColor(Color.BLACK);
        }

        PDsAtaque = (EditText) findViewById(R.id.PDsAtaque);
        PDsAtaque.setTransformationMethod(null);
        PDsAtaque.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Integer val;
                if (PDsAtaque.getText().toString().compareTo("")==0)
                {
                    val = 0;
                } else {
                    val = Integer.parseInt(PDsAtaque.getText().toString());
                }
                p.setPdHa(val);
                Integer valorPdsHabilidad = p.calcularValorPdsHabilidad(p.getPdHa(),p.getClase().getCosteHa());
                Integer valorBonoHabilidad = p.calcularBonoHabilidad(p.getDestreza(),p.getClase().getHaNivel());
                Integer habilidadTotal = p.calcularHabilidadAtaque();
                baseAtaque.setText(valorPdsHabilidad.toString());
                bonoAtaque.setText(valorBonoHabilidad.toString());
                totalAtaque.setText(habilidadTotal.toString());
                Integer pdsdisponibles = calcularPDsDisponibles(p);
                pdsDisponibles.setText(pdsdisponibles.toString());
                if (pdsdisponibles < 0)
                {
                    pdsDisponibles.setTextColor(Color.RED);
                } else
                {
                    pdsDisponibles.setTextColor(Color.BLACK);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
        baseAtaque = (TextView) findViewById(R.id.baseAtaque);
        baseAtaque.setText(p.calcularValorPdsHabilidad(p.getPdHa(),p.getClase().getCosteHa()).toString());
        bonoAtaque = (TextView) findViewById(R.id.bonoAtaque);
        bonoAtaque.setText(p.calcularBonoHabilidad(p.getDestreza(),p.getClase().getHaNivel()).toString());
        totalAtaque = (TextView) findViewById(R.id.totalAtaque);
        totalAtaque.setText(p.calcularHabilidadAtaque().toString());
        costeAtaque = (TextView) findViewById(R.id.costeAtaque);
        costeAtaque.setText(p.getClase().getCosteHa().toString());

        PDsDefensa = (EditText) findViewById(R.id.PDsDefensa);
        PDsDefensa.setTransformationMethod(null);
        PDsDefensa.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Integer val;
                if (PDsDefensa.getText().toString().compareTo("")==0)
                {
                    val = 0;
                } else {
                    val = Integer.parseInt(PDsDefensa.getText().toString());
                }
                p.setPdHd(val);
                Integer valorPdsHabilidad = p.calcularValorPdsHabilidad(p.getPdHd(),p.getClase().getCosteHd());
                Integer valorBonoHabilidad = p.calcularBonoHabilidad(p.getAgilidad(),p.getClase().getHdNivel());
                Integer habilidadTotal = p.calcularHabilidadDefensa();
                baseDefensa.setText(valorPdsHabilidad.toString());
                bonoDefensa.setText(valorBonoHabilidad.toString());
                totalDefensa.setText(habilidadTotal.toString());
                Integer pdsdisponibles = calcularPDsDisponibles(p);
                pdsDisponibles.setText(pdsdisponibles.toString());
                if (pdsdisponibles < 0)
                {
                    pdsDisponibles.setTextColor(Color.RED);
                } else
                {
                    pdsDisponibles.setTextColor(Color.BLACK);
                }


            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
        baseDefensa = (TextView) findViewById(R.id.baseDefensa);
        baseDefensa.setText(p.calcularValorPdsHabilidad(p.getPdHd(),p.getClase().getCosteHd()).toString());
        bonoDefensa = (TextView) findViewById(R.id.bonoDefensa);
        bonoDefensa.setText(p.calcularBonoHabilidad(p.getAgilidad(),p.getClase().getHdNivel()).toString());
        totalDefensa = (TextView) findViewById(R.id.totalDefensa);
        totalDefensa.setText(p.calcularHabilidadDefensa().toString());
        costeDefensa = (TextView) findViewById(R.id.costeDefensa);
        costeDefensa.setText(p.getClase().getCosteHd().toString());

        PDsArmadura = (EditText) findViewById(R.id.PDsArmadura);
        PDsArmadura.setTransformationMethod(null);
        PDsArmadura.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Integer val;
                if (PDsArmadura.getText().toString().compareTo("")==0)
                {
                    val = 0;
                } else {
                    val = Integer.parseInt(PDsArmadura.getText().toString());
                }
                p.setpdLlevarArmadura(val);
                Integer valorPdsHabilidad = p.calcularValorPdsHabilidad(p.getPdLlevarArmadura(),p.getClase().getCosteLlevarArmadura());
                Integer valorBonoHabilidad = p.calcularBonoHabilidad(p.getFuerza(),p.getClase().getLlevarArmaduraNivel());
                Integer habilidadTotal = p.calcularLlevarArmadura();
                baseArmadura.setText(valorPdsHabilidad.toString());
                bonoArmadura.setText(valorBonoHabilidad.toString());
                totalArmadura.setText(habilidadTotal.toString());
                Integer pdsdisponibles = calcularPDsDisponibles(p);
                pdsDisponibles.setText(pdsdisponibles.toString());
                if (pdsdisponibles < 0)
                {
                    pdsDisponibles.setTextColor(Color.RED);
                } else
                {
                    pdsDisponibles.setTextColor(Color.BLACK);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
        baseArmadura = (TextView) findViewById(R.id.baseArmadura);
        baseArmadura.setText(p.calcularValorPdsHabilidad(p.getPdLlevarArmadura(),p.getClase().getCosteLlevarArmadura()).toString());
        bonoArmadura = (TextView) findViewById(R.id.bonoArmadura);
        bonoArmadura.setText(p.calcularBonoHabilidad(p.getFuerza(),p.getClase().getLlevarArmaduraNivel()).toString());
        totalArmadura = (TextView) findViewById(R.id.totalArmadura);
        totalArmadura.setText(p.calcularLlevarArmadura().toString());
        costeArmadura = (TextView) findViewById(R.id.costeArmadura);
        costeArmadura.setText(p.getClase().getCosteLlevarArmadura().toString());

        PDsZeon = (EditText) findViewById(R.id.PDsZeon);
        PDsZeon.setTransformationMethod(null);
        PDsZeon.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Integer val;
                if (PDsZeon.getText().toString().compareTo("")==0)
                {
                    val = 0;
                } else {
                    val = Integer.parseInt(PDsZeon.getText().toString());
                }
                p.setPdZeon(val);
                Integer valorPdsHabilidad = p.calcularValorPdsHabilidad(p.getPdZeon(),p.getClase().getCosteZeon());
                Integer valorBonoHabilidad = p.calcularZeon() - valorPdsHabilidad;
                Integer habilidadTotal = p.calcularZeon();
                baseZeon.setText(valorPdsHabilidad.toString());
                bonoZeon.setText(valorBonoHabilidad.toString());
                totalZeon.setText(habilidadTotal.toString());
                Integer pdsdisponibles = calcularPDsDisponibles(p);
                pdsDisponibles.setText(pdsdisponibles.toString());
                if (pdsdisponibles < 0)
                {
                    pdsDisponibles.setTextColor(Color.RED);
                } else
                {
                    pdsDisponibles.setTextColor(Color.BLACK);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
        baseZeon = (TextView) findViewById(R.id.baseZeon);
        baseZeon.setText(p.calcularValorPdsHabilidad(p.getPdZeon(),p.getClase().getCosteZeon()).toString());
        bonoZeon = (TextView) findViewById(R.id.bonoZeon);
        Integer valorBonoHabilidad = p.calcularZeon() - p.calcularValorPdsHabilidad(p.getPdZeon(),p.getClase().getCosteZeon());
        bonoZeon.setText(valorBonoHabilidad.toString());
        totalZeon = (TextView) findViewById(R.id.totalZeon);
        totalZeon.setText(p.calcularZeon().toString());
        costeZeon = (TextView) findViewById(R.id.costeZeon);
        costeZeon.setText(p.getClase().getCosteZeon().toString());

        PDsAct = (EditText) findViewById(R.id.PDsAct);
        PDsAct.setTransformationMethod(null);
        PDsAct.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Integer val;
                if (PDsAct.getText().toString().compareTo("")==0)
                {
                    val = 0;
                } else {
                    val = Integer.parseInt(PDsAct.getText().toString());
                }
                p.setPdAct(val);
                Integer valorPdsHabilidad = p.calcularValorPdsHabilidad(p.getPdAct(),p.getClase().getCosteAct());
                Integer valorBonoHabilidad = p.tablaDeAct(p.getPoder());
                Integer habilidadTotal = p.calcularAct();
                baseAct.setText(valorPdsHabilidad.toString());
                bonoAct.setText(valorBonoHabilidad.toString());
                totalAct.setText(habilidadTotal.toString());
                Integer pdsdisponibles = calcularPDsDisponibles(p);
                pdsDisponibles.setText(pdsdisponibles.toString());
                if (pdsdisponibles < 0)
                {
                    pdsDisponibles.setTextColor(Color.RED);
                } else
                {
                    pdsDisponibles.setTextColor(Color.BLACK);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        baseAct = (TextView) findViewById(R.id.baseAct);
        baseAct.setText(p.calcularValorPdsHabilidad(p.getPdAct(),p.getClase().getCosteAct()).toString());
        bonoAct = (TextView) findViewById(R.id.bonoAct);
        bonoAct.setText(p.tablaDeAct(p.getPoder()).toString());
        totalAct = (TextView) findViewById(R.id.totalAct);
        totalAct.setText(p.calcularAct().toString());
        costeAct = (TextView) findViewById(R.id.costeAct);
        costeAct.setText(p.getClase().getCosteAct().toString());

        PDsProyMagica = (EditText) findViewById(R.id.PDsProyMagica);
        PDsProyMagica.setTransformationMethod(null);
        PDsProyMagica.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Integer val;
                if (PDsProyMagica.getText().toString().compareTo("")==0)
                {
                    val = 0;
                } else {
                    val = Integer.parseInt(PDsProyMagica.getText().toString());
                }
                p.setPdProyMagica(val);
                Integer valorPdsHabilidad = p.calcularValorPdsHabilidad(p.getPdProyMagica(),p.getClase().getCosteProyMagica());
                Integer valorBonoHabilidad = p.calcularBonoHabilidad(p.getDestreza(),0);
                Integer habilidadTotal = p.calcularProyMagica();
                baseProyMagica.setText(valorPdsHabilidad.toString());
                bonoProyMagica.setText(valorBonoHabilidad.toString());
                totalProyMagica.setText(habilidadTotal.toString());
                Integer pdsdisponibles = calcularPDsDisponibles(p);
                pdsDisponibles.setText(pdsdisponibles.toString());
                if (pdsdisponibles < 0)
                {
                    pdsDisponibles.setTextColor(Color.RED);
                } else
                {
                    pdsDisponibles.setTextColor(Color.BLACK);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
        baseProyMagica = (TextView) findViewById(R.id.baseProyMagica);
        baseProyMagica.setText(p.calcularValorPdsHabilidad(p.getPdProyMagica(),p.getClase().getCosteProyMagica()).toString());
        bonoProyMagica = (TextView) findViewById(R.id.bonoProyMagica);
        bonoProyMagica.setText(p.calcularBonoHabilidad(p.getDestreza(),0).toString());
        totalProyMagica = (TextView) findViewById(R.id.totalProyMagica);
        totalProyMagica.setText(p.calcularProyMagica().toString());
        costeProyMagica = (TextView) findViewById(R.id.costeProyMagica);
        costeProyMagica.setText(p.getClase().getCosteProyMagica().toString());

        PDsNivelMagia = (EditText) findViewById(R.id.PDsNivelMagia);
        PDsNivelMagia.setTransformationMethod(null);
        PDsNivelMagia.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Integer val;
                if (PDsNivelMagia.getText().toString().compareTo("")==0)
                {
                    val = 0;
                } else {
                    val = Integer.parseInt(PDsNivelMagia.getText().toString());
                }
                p.setPdNivelMagia(val);
                Integer valorPdsHabilidad = p.calcularValorPdsHabilidad(p.getPdNivelMagia(),p.getClase().getCosteNivelMagia());
                Integer valorBonoHabilidad = p.tablaDeNivelDeMagia(p.getInteligencia());
                Integer habilidadTotal = p.calcularNivelMagia();
                baseNivelMagia.setText(valorPdsHabilidad.toString());
                bonoNivelMagia.setText(valorBonoHabilidad.toString());
                totalNivelMagia.setText(habilidadTotal.toString());
                Integer pdsdisponibles = calcularPDsDisponibles(p);
                pdsDisponibles.setText(pdsdisponibles.toString());
                if (pdsdisponibles < 0)
                {
                    pdsDisponibles.setTextColor(Color.RED);
                } else
                {
                    pdsDisponibles.setTextColor(Color.BLACK);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        baseNivelMagia = (TextView) findViewById(R.id.baseNivelMagia);
        baseNivelMagia.setText(p.calcularValorPdsHabilidad(p.getPdNivelMagia(),p.getClase().getCosteNivelMagia()).toString());
        bonoNivelMagia = (TextView) findViewById(R.id.bonoNivelMagia);
        bonoNivelMagia.setText(p.tablaDeNivelDeMagia(p.getInteligencia()).toString());
        totalNivelMagia = (TextView) findViewById(R.id.totalNivelMagia);
        totalNivelMagia.setText(p.calcularNivelMagia().toString());
        costeNivelMagia = (TextView) findViewById(R.id.costeNivelMagia);
        costeNivelMagia.setText(p.getClase().getCosteNivelMagia().toString());

        PDsCV = (EditText) findViewById(R.id.PDsCV);
        PDsCV.setTransformationMethod(null);
        PDsCV.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Integer val;
                if (PDsCV.getText().toString().compareTo("")==0)
                {
                    val = 0;
                } else {
                    val = Integer.parseInt(PDsCV.getText().toString());
                }
                p.setPdCv(val);
                Integer valorPdsHabilidad = p.calcularValorPdsHabilidad(p.getPdCv(),p.getClase().getCosteCv());
                Integer valorBonoHabilidad = p.getNivel() / p.getClase().getCvCadaXNiveles();
                Integer habilidadTotal = p.calcularCVs();
                baseCV.setText(valorPdsHabilidad.toString());
                bonoCV.setText(valorBonoHabilidad.toString());
                totalCV.setText(habilidadTotal.toString());
                Integer pdsdisponibles = calcularPDsDisponibles(p);
                pdsDisponibles.setText(pdsdisponibles.toString());
                if (pdsdisponibles < 0)
                {
                    pdsDisponibles.setTextColor(Color.RED);
                } else
                {
                    pdsDisponibles.setTextColor(Color.BLACK);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        baseCV = (TextView) findViewById(R.id.baseCV);
        baseCV.setText(p.calcularValorPdsHabilidad(p.getPdCv(),p.getClase().getCosteCv()).toString());
        bonoCV = (TextView) findViewById(R.id.bonoCV);
        Integer bono = p.getNivel() / p.getClase().getCvCadaXNiveles();
        bonoCV.setText(bono.toString());
        totalCV = (TextView) findViewById(R.id.totalCV);
        totalCV.setText(p.calcularCVs().toString());
        costeCV = (TextView) findViewById(R.id.costeCV);
        costeCV.setText(p.getClase().getCosteCv().toString());

        PDsProyPsiquica = (EditText) findViewById(R.id.PDsProyPsiquica);
        PDsProyPsiquica.setTransformationMethod(null);
        PDsProyPsiquica.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Integer val;
                if (PDsProyPsiquica.getText().toString().compareTo("")==0)
                {
                    val = 0;
                } else {
                    val = Integer.parseInt(PDsProyPsiquica.getText().toString());
                }
                p.setPdProyPsiquica(val);
                Integer valorPdsHabilidad = p.calcularValorPdsHabilidad(p.getPdProyPsiquica(),p.getClase().getCosteProyPsiquica());
                Integer valorBonoHabilidad = p.calcularBonoHabilidad(p.getDestreza(),0);
                Integer habilidadTotal = p.calcularProyPsiquica();
                baseProyPsiquica.setText(valorPdsHabilidad.toString());
                bonoProyPsiquica.setText(valorBonoHabilidad.toString());
                totalProyPsiquica.setText(habilidadTotal.toString());
                Integer pdsdisponibles = calcularPDsDisponibles(p);
                pdsDisponibles.setText(pdsdisponibles.toString());
                if (pdsdisponibles < 0)
                {
                    pdsDisponibles.setTextColor(Color.RED);
                } else
                {
                    pdsDisponibles.setTextColor(Color.BLACK);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
        baseProyPsiquica = (TextView) findViewById(R.id.baseProyPsiquica);
        baseProyPsiquica.setText(p.calcularValorPdsHabilidad(p.getPdProyPsiquica(),p.getClase().getCosteProyPsiquica()).toString());
        bonoProyPsiquica = (TextView) findViewById(R.id.bonoProyPsiquica);
        bonoProyPsiquica.setText(p.calcularBonoHabilidad(p.getDestreza(),0).toString());
        totalProyPsiquica = (TextView) findViewById(R.id.totalProyPsiquica);
        totalProyPsiquica.setText(p.calcularProyPsiquica().toString());
        costeProyPsiquica = (TextView) findViewById(R.id.costeProyPsiquica);
        costeProyPsiquica.setText(p.getClase().getCosteProyPsiquica().toString());

        PDsAdvertir = (EditText) findViewById(R.id.PDsAdvertir);
        PDsAdvertir.setTransformationMethod(null);
        PDsAdvertir.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Integer val;
                if (PDsAdvertir.getText().toString().compareTo("")==0)
                {
                    val = 0;
                } else {
                    val = Integer.parseInt(PDsAdvertir.getText().toString());
                }
                p.setPdAdvertir(val);
                Integer valorPdsHabilidad = p.calcularValorPdsHabilidad(p.getPdAdvertir(),p.getClase().getCosteAdvertir());
                Integer valorBonoHabilidad = p.calcularBonoHabilidad(p.getPercepcion(),0);
                Integer habilidadTotal = p.calcularAdvertir();
                baseAdvertir.setText(valorPdsHabilidad.toString());
                bonoAdvertir.setText(valorBonoHabilidad.toString());
                totalAdvertir.setText(habilidadTotal.toString());
                Integer pdsdisponibles = calcularPDsDisponibles(p);
                pdsDisponibles.setText(pdsdisponibles.toString());
                if (pdsdisponibles < 0)
                {
                    pdsDisponibles.setTextColor(Color.RED);
                } else
                {
                    pdsDisponibles.setTextColor(Color.BLACK);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
        baseAdvertir = (TextView) findViewById(R.id.baseAdvertir);
        baseAdvertir.setText(p.calcularValorPdsHabilidad(p.getPdAdvertir(),p.getClase().getCosteAdvertir()).toString());
        bonoAdvertir = (TextView) findViewById(R.id.bonoAdvertir);
        bonoAdvertir.setText(p.calcularBonoHabilidad(p.getDestreza(),0).toString());
        totalAdvertir = (TextView) findViewById(R.id.totalAdvertir);
        totalAdvertir.setText(p.calcularAdvertir().toString());
        costeAdvertir = (TextView) findViewById(R.id.costeAdvertir);
        costeAdvertir.setText(p.getClase().getCosteAdvertir().toString());

        PDsAdvertir = (EditText) findViewById(R.id.PDsAdvertir);
        PDsAdvertir.setTransformationMethod(null);
        PDsAdvertir.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Integer val;
                if (PDsAdvertir.getText().toString().compareTo("")==0)
                {
                    val = 0;
                } else {
                    val = Integer.parseInt(PDsAdvertir.getText().toString());
                }
                p.setPdAdvertir(val);
                Integer valorPdsHabilidad = p.calcularValorPdsHabilidad(p.getPdAdvertir(),p.getClase().getCosteAdvertir());
                Integer valorBonoHabilidad = p.calcularBonoHabilidad(p.getPercepcion(),p.getClase().getAdvertirNivel());
                Integer habilidadTotal = p.calcularAdvertir();
                baseAdvertir.setText(valorPdsHabilidad.toString());
                bonoAdvertir.setText(valorBonoHabilidad.toString());
                totalAdvertir.setText(habilidadTotal.toString());
                Integer pdsdisponibles = calcularPDsDisponibles(p);
                pdsDisponibles.setText(pdsdisponibles.toString());
                if (pdsdisponibles < 0)
                {
                    pdsDisponibles.setTextColor(Color.RED);
                } else
                {
                    pdsDisponibles.setTextColor(Color.BLACK);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
        baseAdvertir = (TextView) findViewById(R.id.baseAdvertir);
        baseAdvertir.setText(p.calcularValorPdsHabilidad(p.getPdAdvertir(),p.getClase().getCosteAdvertir()).toString());
        bonoAdvertir = (TextView) findViewById(R.id.bonoAdvertir);
        bonoAdvertir.setText(p.calcularBonoHabilidad(p.getPercepcion(),p.getClase().getAdvertirNivel()).toString());
        totalAdvertir = (TextView) findViewById(R.id.totalAdvertir);
        totalAdvertir.setText(p.calcularAdvertir().toString());
        costeAdvertir = (TextView) findViewById(R.id.costeAdvertir);
        costeAdvertir.setText(p.getClase().getCosteAdvertir().toString());


        PDsArte = (EditText) findViewById(R.id.PDsArte);
        PDsArte.setTransformationMethod(null);
        PDsArte.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Integer val;
                if (PDsArte.getText().toString().compareTo("")==0)
                {
                    val = 0;
                } else {
                    val = Integer.parseInt(PDsArte.getText().toString());
                }
                p.setPdArte(val);
                Integer valorPdsHabilidad = p.calcularValorPdsHabilidad(p.getPdArte(),p.getClase().getCosteArte());
                Integer valorBonoHabilidad = p.calcularBonoHabilidad(p.getPoder(),p.getClase().getArteNivel());
                Integer habilidadTotal = p.calcularArte();
                baseArte.setText(valorPdsHabilidad.toString());
                bonoArte.setText(valorBonoHabilidad.toString());
                totalArte.setText(habilidadTotal.toString());
                Integer pdsdisponibles = calcularPDsDisponibles(p);
                pdsDisponibles.setText(pdsdisponibles.toString());
                if (pdsdisponibles < 0)
                {
                    pdsDisponibles.setTextColor(Color.RED);
                } else
                {
                    pdsDisponibles.setTextColor(Color.BLACK);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
        baseArte = (TextView) findViewById(R.id.baseArte);
        baseArte.setText(p.calcularValorPdsHabilidad(p.getPdArte(),p.getClase().getCosteArte()).toString());
        bonoArte = (TextView) findViewById(R.id.bonoArte);
        bonoArte.setText(p.calcularBonoHabilidad(p.getPoder(),p.getClase().getArteNivel()).toString());
        totalArte = (TextView) findViewById(R.id.totalArte);
        totalArte.setText(p.calcularArte().toString());
        costeArte = (TextView) findViewById(R.id.costeArte);
        costeArte.setText(p.getClase().getCosteArte().toString());

        PDsCapFisica = (EditText) findViewById(R.id.PDsCapFisica);
        PDsCapFisica.setTransformationMethod(null);
        PDsCapFisica.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Integer val;
                if (PDsCapFisica.getText().toString().compareTo("")==0)
                {
                    val = 0;
                } else {
                    val = Integer.parseInt(PDsCapFisica.getText().toString());
                }
                p.setPdCapFisica(val);
                Integer valorPdsHabilidad = p.calcularValorPdsHabilidad(p.getPdCapFisica(),p.getClase().getCosteCapFisica());
                Integer valorBonoHabilidad = p.calcularBonoHabilidad(p.getFuerza(),p.getClase().getCapFisicaNivel());
                Integer habilidadTotal = p.calcularCapFisica();
                baseCapFisica.setText(valorPdsHabilidad.toString());
                bonoCapFisica.setText(valorBonoHabilidad.toString());
                totalCapFisica.setText(habilidadTotal.toString());
                Integer pdsdisponibles = calcularPDsDisponibles(p);
                pdsDisponibles.setText(pdsdisponibles.toString());
                if (pdsdisponibles < 0)
                {
                    pdsDisponibles.setTextColor(Color.RED);
                } else
                {
                    pdsDisponibles.setTextColor(Color.BLACK);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
        baseCapFisica = (TextView) findViewById(R.id.baseCapFisica);
        baseCapFisica.setText(p.calcularValorPdsHabilidad(p.getPdCapFisica(),p.getClase().getCosteCapFisica()).toString());
        bonoCapFisica = (TextView) findViewById(R.id.bonoCapFisica);
        bonoCapFisica.setText(p.calcularBonoHabilidad(p.getFuerza(),p.getClase().getCapFisicaNivel()).toString());
        totalCapFisica = (TextView) findViewById(R.id.totalCapFisica);
        totalCapFisica.setText(p.calcularCapFisica().toString());
        costeCapFisica = (TextView) findViewById(R.id.costeCapFisica);
        costeCapFisica.setText(p.getClase().getCosteCapFisica().toString());

        PDsConocimiento = (EditText) findViewById(R.id.PDsConocimiento);
        PDsConocimiento.setTransformationMethod(null);
        PDsConocimiento.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Integer val;
                if (PDsConocimiento.getText().toString().compareTo("")==0)
                {
                    val = 0;
                } else {
                    val = Integer.parseInt(PDsConocimiento.getText().toString());
                }
                p.setPdConocimiento(val);
                Integer valorPdsHabilidad = p.calcularValorPdsHabilidad(p.getPdConocimiento(),p.getClase().getCosteConocimiento());
                Integer valorBonoHabilidad = p.calcularBonoHabilidad(p.getInteligencia(),p.getClase().getConocimientoNivel());
                Integer habilidadTotal = p.calcularConocimiento();
                baseConocimiento.setText(valorPdsHabilidad.toString());
                bonoConocimiento.setText(valorBonoHabilidad.toString());
                totalConocimiento.setText(habilidadTotal.toString());
                Integer pdsdisponibles = calcularPDsDisponibles(p);
                pdsDisponibles.setText(pdsdisponibles.toString());
                if (pdsdisponibles < 0)
                {
                    pdsDisponibles.setTextColor(Color.RED);
                } else
                {
                    pdsDisponibles.setTextColor(Color.BLACK);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
        baseConocimiento = (TextView) findViewById(R.id.baseConocimiento);
        baseConocimiento.setText(p.calcularValorPdsHabilidad(p.getPdConocimiento(),p.getClase().getCosteConocimiento()).toString());
        bonoConocimiento = (TextView) findViewById(R.id.bonoConocimiento);
        bonoConocimiento.setText(p.calcularBonoHabilidad(p.getInteligencia(),p.getClase().getConocimientoNivel()).toString());
        totalConocimiento = (TextView) findViewById(R.id.totalConocimiento);
        totalConocimiento.setText(p.calcularConocimiento().toString());
        costeConocimiento = (TextView) findViewById(R.id.costeConocimiento);
        costeConocimiento.setText(p.getClase().getCosteConocimiento().toString());

        PDsSigilo = (EditText) findViewById(R.id.PDsSigilo);
        PDsSigilo.setTransformationMethod(null);
        PDsSigilo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Integer val;
                if (PDsSigilo.getText().toString().compareTo("")==0)
                {
                    val = 0;
                } else {
                    val = Integer.parseInt(PDsSigilo.getText().toString());
                }
                p.setPdSigilo(val);
                Integer valorPdsHabilidad = p.calcularValorPdsHabilidad(p.getPdSigilo(),p.getClase().getCosteSigilo());
                Integer valorBonoHabilidad = p.calcularBonoHabilidad(p.getAgilidad(),p.getClase().getSigiloNivel());
                Integer habilidadTotal = p.calcularSigilo();
                baseSigilo.setText(valorPdsHabilidad.toString());
                bonoSigilo.setText(valorBonoHabilidad.toString());
                totalSigilo.setText(habilidadTotal.toString());
                Integer pdsdisponibles = calcularPDsDisponibles(p);
                pdsDisponibles.setText(pdsdisponibles.toString());
                if (pdsdisponibles < 0)
                {
                    pdsDisponibles.setTextColor(Color.RED);
                } else
                {
                    pdsDisponibles.setTextColor(Color.BLACK);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
        baseSigilo = (TextView) findViewById(R.id.baseSigilo);
        baseSigilo.setText(p.calcularValorPdsHabilidad(p.getPdSigilo(),p.getClase().getCosteSigilo()).toString());
        bonoSigilo = (TextView) findViewById(R.id.bonoSigilo);
        bonoSigilo.setText(p.calcularBonoHabilidad(p.getAgilidad(),p.getClase().getSigiloNivel()).toString());
        totalSigilo = (TextView) findViewById(R.id.totalSigilo);
        totalSigilo.setText(p.calcularSigilo().toString());
        costeSigilo = (TextView) findViewById(R.id.costeSigilo);
        costeSigilo.setText(p.getClase().getCosteSigilo().toString());

        PDsValoracionMagica = (EditText) findViewById(R.id.PDsValoracionMagica);
        PDsValoracionMagica.setTransformationMethod(null);
        PDsValoracionMagica.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Integer val;
                if (PDsValoracionMagica.getText().toString().compareTo("")==0)
                {
                    val = 0;
                } else {
                    val = Integer.parseInt(PDsValoracionMagica.getText().toString());
                }
                p.setPdValoracionMagica(val);
                Integer valorPdsHabilidad = p.calcularValorPdsHabilidad(p.getPdValoracionMagica(),p.getClase().getCosteVisionMágica());
                Integer valorBonoHabilidad = p.calcularBonoHabilidad(p.getPoder(),p.getClase().getVisionMagicaNivel());
                Integer habilidadTotal = p.calcularValoracionMagica();
                baseValoracionMagica.setText(valorPdsHabilidad.toString());
                bonoValoracionMagica.setText(valorBonoHabilidad.toString());
                totalValoracionMagica.setText(habilidadTotal.toString());
                Integer pdsdisponibles = calcularPDsDisponibles(p);
                pdsDisponibles.setText(pdsdisponibles.toString());
                if (pdsdisponibles < 0)
                {
                    pdsDisponibles.setTextColor(Color.RED);
                } else
                {
                    pdsDisponibles.setTextColor(Color.BLACK);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
        baseValoracionMagica = (TextView) findViewById(R.id.baseValoracionMagica);
        baseValoracionMagica.setText(p.calcularValorPdsHabilidad(p.getPdValoracionMagica(),p.getClase().getCosteVisionMágica()).toString());
        bonoValoracionMagica = (TextView) findViewById(R.id.bonoValoracionMagica);
        bonoValoracionMagica.setText(p.calcularBonoHabilidad(p.getPoder(),p.getClase().getVisionMagicaNivel()).toString());
        totalValoracionMagica = (TextView) findViewById(R.id.totalValoracionMagica);
        totalValoracionMagica.setText(p.calcularValoracionMagica().toString());
        costeValoracionMagica = (TextView) findViewById(R.id.costeValoracionMagica);
        costeValoracionMagica.setText(p.getClase().getCosteVisionMágica().toString());

        PDsVida = (EditText) findViewById(R.id.PDsVida);
        PDsVida.setTransformationMethod(null);
        PDsVida.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Integer val;
                if (PDsVida.getText().toString().compareTo("")==0)
                {
                    val = 0;
                } else {
                    val = Integer.parseInt(PDsVida.getText().toString());
                }
                p.setPdVida(val);
                Integer valorPdsHabilidad = (p.getPdVida() / p.getClase().getCosteVida())*p.getConstitucion();
                Integer valorBonoHabilidad = p.calcularVida()-valorPdsHabilidad;
                Integer habilidadTotal = p.calcularVida();

                baseVida.setText(valorPdsHabilidad.toString());
                bonoVida.setText(valorBonoHabilidad.toString());
                totalVida.setText(habilidadTotal.toString());
                Integer pdsdisponibles = calcularPDsDisponibles(p);
                pdsDisponibles.setText(pdsdisponibles.toString());
                if (pdsdisponibles < 0)
                {
                    pdsDisponibles.setTextColor(Color.RED);
                } else
                {
                    pdsDisponibles.setTextColor(Color.BLACK);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
        baseVida = (TextView) findViewById(R.id.baseVida);
        Integer base = (p.getPdVida() / p.getClase().getCosteVida())*p.getConstitucion();
        baseVida.setText(base.toString());
        bonoVida = (TextView) findViewById(R.id.bonoVida);
        bonoVida.setText(p.calcularBonoHabilidad(p.getAgilidad(),p.getClase().getVidaNivel()).toString());
        totalVida = (TextView) findViewById(R.id.totalVida);
        totalVida.setText(p.calcularVida().toString());
        costeVida = (TextView) findViewById(R.id.costeVida);
        costeVida.setText(p.getClase().getCosteVida().toString());

        agilidadNumber = (EditText) findViewById(R.id.agilidadNumber);
        agilidadNumber.setTransformationMethod(null);
        agilidadNumber.setText(p.getAgilidad().toString());
        agilidadNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Integer val;
                if (agilidadNumber.getText().toString().compareTo("")==0)
                {
                    val = 0;
                } else {
                    val = Integer.parseInt(agilidadNumber.getText().toString());
                }
                p.setAgilidad(val);

                baseSigilo.setText(p.calcularValorPdsHabilidad(p.getPdSigilo(),p.getClase().getCosteSigilo()).toString());
                bonoSigilo.setText(p.calcularBonoHabilidad(p.getAgilidad(),p.getClase().getSigiloNivel()).toString());
                totalSigilo.setText(p.calcularSigilo().toString());

                baseDefensa.setText(p.calcularValorPdsHabilidad(p.getPdHd(),p.getClase().getCosteHd()).toString());
                bonoDefensa.setText(p.calcularBonoHabilidad(p.getAgilidad(),p.getClase().getHdNivel()).toString());
                totalDefensa.setText(p.calcularHabilidadDefensa().toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });


        percepNumber = (EditText) findViewById(R.id.percepNumber);
        percepNumber.setTransformationMethod(null);
        percepNumber.setText(p.getPercepcion().toString());
        percepNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Integer val;
                if (percepNumber.getText().toString().compareTo("")==0)
                {
                    val = 0;
                } else {
                    val = Integer.parseInt(percepNumber.getText().toString());
                }
                p.setPercepcion(val);

                baseAdvertir.setText(p.calcularValorPdsHabilidad(p.getPdAdvertir(),p.getClase().getCosteAdvertir()).toString());
                bonoAdvertir.setText(p.calcularBonoHabilidad(p.getDestreza(),0).toString());
                totalAdvertir.setText(p.calcularAdvertir().toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        volNumber = (EditText) findViewById(R.id.volNumber);
        volNumber.setTransformationMethod(null);
        volNumber.setText(p.getVoluntad().toString());
        volNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Integer val;
                if (volNumber.getText().toString().compareTo("")==0)
                {
                    val = 0;
                } else {
                    val = Integer.parseInt(volNumber.getText().toString());
                }
                p.setVoluntad(val);
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        poderNumber = (EditText) findViewById(R.id.poderNumber);
        poderNumber.setTransformationMethod(null);
        poderNumber.setText(p.getPoder().toString());
        poderNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Integer val;
                if (poderNumber.getText().toString().compareTo("")==0)
                {
                    val = 0;
                } else {
                    val = Integer.parseInt(poderNumber.getText().toString());
                }
                p.setPoder(val);

                baseZeon.setText(p.calcularValorPdsHabilidad(p.getPdZeon(),p.getClase().getCosteZeon()).toString());
                Integer valorBonoHabilidad = p.calcularZeon() - p.calcularValorPdsHabilidad(p.getPdZeon(),p.getClase().getCosteZeon());
                bonoZeon.setText(valorBonoHabilidad.toString());
                totalZeon.setText(p.calcularZeon().toString());

                baseValoracionMagica.setText(p.calcularValorPdsHabilidad(p.getPdValoracionMagica(),p.getClase().getCosteVisionMágica()).toString());
                bonoValoracionMagica.setText(p.calcularBonoHabilidad(p.getPoder(),p.getClase().getVisionMagicaNivel()).toString());
                totalValoracionMagica.setText(p.calcularValoracionMagica().toString());

                baseArte.setText(p.calcularValorPdsHabilidad(p.getPdArte(),p.getClase().getCosteVisionMágica()).toString());
                bonoArte.setText(p.calcularBonoHabilidad(p.getPoder(),p.getClase().getArteNivel()).toString());
                totalArte.setText(p.calcularArte().toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        intNumber = (EditText) findViewById(R.id.intNumber);
        intNumber.setTransformationMethod(null);
        intNumber.setText(p.getInteligencia().toString());
        intNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Integer val;
                if (intNumber.getText().toString().compareTo("")==0)
                {
                    val = 0;
                } else {
                    val = Integer.parseInt(intNumber.getText().toString());
                }
                p.setInteligencia(val);

                baseConocimiento.setText(p.calcularValorPdsHabilidad(p.getPdConocimiento(),p.getClase().getCosteConocimiento()).toString());
                bonoConocimiento.setText(p.calcularBonoHabilidad(p.getInteligencia(),p.getClase().getConocimientoNivel()).toString());
                totalConocimiento.setText(p.calcularConocimiento().toString());

                baseNivelMagia.setText(p.calcularValorPdsHabilidad(p.getPdNivelMagia(),p.getClase().getCosteNivelMagia()).toString());
                bonoNivelMagia.setText(p.tablaDeNivelDeMagia(p.getInteligencia()).toString());
                totalNivelMagia.setText(p.calcularNivelMagia().toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        constNumber = (EditText) findViewById(R.id.constNumber);
        constNumber.setTransformationMethod(null);
        constNumber.setText(p.getConstitucion().toString());
        constNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Integer val;
                if (constNumber.getText().toString().compareTo("")==0)
                {
                    val = 0;
                } else {
                    val = Integer.parseInt(constNumber.getText().toString());
                }
                p.setConstitucion(val);

                Integer base = (p.getPdVida() / p.getClase().getCosteVida())*p.getConstitucion();
                baseVida.setText(base.toString());
                bonoVida.setText(p.calcularBonoHabilidad(p.getAgilidad(),p.getClase().getVidaNivel()).toString());
                totalVida.setText(p.calcularVida().toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        fuerzaNumber = (EditText) findViewById(R.id.fuerzaNumber);
        fuerzaNumber.setTransformationMethod(null);
        fuerzaNumber.setText(p.getFuerza().toString());
        fuerzaNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Integer val;
                if (fuerzaNumber.getText().toString().compareTo("")==0)
                {
                    val = 0;
                } else {
                    val = Integer.parseInt(fuerzaNumber.getText().toString());
                }
                p.setFuerza(val);

                baseCapFisica.setText(p.calcularValorPdsHabilidad(p.getPdCapFisica(),p.getClase().getCosteCapFisica()).toString());
                bonoCapFisica.setText(p.calcularBonoHabilidad(p.getFuerza(),p.getClase().getCapFisicaNivel()).toString());
                totalCapFisica.setText(p.calcularCapFisica().toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        destrezaNumber = (EditText) findViewById(R.id.destrezaNumber);
        destrezaNumber.setTransformationMethod(null);
        destrezaNumber.setText(p.getDestreza().toString());
        destrezaNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Integer val;
                if (destrezaNumber.getText().toString().compareTo("")==0)
                {
                    val = 0;
                } else {
                    val = Integer.parseInt(destrezaNumber.getText().toString());
                }
                p.setDestreza(val);

                baseAtaque.setText(p.calcularValorPdsHabilidad(p.getPdHa(),p.getClase().getCosteHa()).toString());
                bonoAtaque.setText(p.calcularBonoHabilidad(p.getDestreza(),p.getClase().getHaNivel()).toString());
                totalAtaque.setText(p.calcularHabilidadAtaque().toString());

                baseProyMagica.setText(p.calcularValorPdsHabilidad(p.getPdProyMagica(),p.getClase().getCosteProyMagica()).toString());
                bonoProyMagica.setText(p.calcularBonoHabilidad(p.getDestreza(),0).toString());
                totalProyMagica.setText(p.calcularProyMagica().toString());

                baseProyPsiquica.setText(p.calcularValorPdsHabilidad(p.getPdProyPsiquica(),p.getClase().getCosteProyPsiquica()).toString());
                bonoProyPsiquica.setText(p.calcularBonoHabilidad(p.getDestreza(),0).toString());
                totalProyPsiquica.setText(p.calcularProyPsiquica().toString());


            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
        PDsProyMagica = (EditText) findViewById(R.id.PDsProyMagica);
        PDsProyMagica.setTransformationMethod(null);

        PDsNivelMagia = (EditText) findViewById(R.id.PDsNivelMagia);
        PDsNivelMagia.setTransformationMethod(null);

        PDsCV = (EditText) findViewById(R.id.PDsCV);
        PDsCV.setTransformationMethod(null);

        PDsProyPsiquica = (EditText) findViewById(R.id.PDsProyPsiquica);
        PDsProyPsiquica.setTransformationMethod(null);

        PDsSigilo = (EditText) findViewById(R.id.PDsSigilo);
        PDsSigilo.setTransformationMethod(null);

        PDsAdvertir = (EditText) findViewById(R.id.PDsAdvertir);
        PDsAdvertir.setTransformationMethod(null);

        PDsConocimiento = (EditText) findViewById(R.id.PDsConocimiento);
        PDsConocimiento.setTransformationMethod(null);

        PDsArte = (EditText) findViewById(R.id.PDsArte);
        PDsArte.setTransformationMethod(null);

        PDsCapFisica = (EditText) findViewById(R.id.PDsCapFisica);
        PDsCapFisica.setTransformationMethod(null);

        PDsValoracionMagica = (EditText) findViewById(R.id.PDsValoracionMagica);
        PDsValoracionMagica.setTransformationMethod(null);

        PDsVida = (EditText) findViewById(R.id.PDsVida);
        PDsVida.setTransformationMethod(null);

        agilidadNumber = (EditText) findViewById(R.id.agilidadNumber);
        agilidadNumber.setTransformationMethod(null);

        percepNumber = (EditText) findViewById(R.id.percepNumber);
        percepNumber.setTransformationMethod(null);

        volNumber = (EditText) findViewById(R.id.volNumber);
        volNumber.setTransformationMethod(null);

        poderNumber = (EditText) findViewById(R.id.poderNumber);
        poderNumber.setTransformationMethod(null);

        intNumber = (EditText) findViewById(R.id.intNumber);
        intNumber.setTransformationMethod(null);

        constNumber = (EditText) findViewById(R.id.constNumber);
        constNumber.setTransformationMethod(null);

        fuerzaNumber = (EditText) findViewById(R.id.fuerzaNumber);
        fuerzaNumber.setTransformationMethod(null);

        destrezaNumber = (EditText) findViewById(R.id.destrezaNumber);
        destrezaNumber.setTransformationMethod(null);

        buttonPd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                back = true;
                viewAtr.setVisibility(View.GONE);
                viewPds.setVisibility(View.VISIBLE);
            }
        });

        btnAccept.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    String name = nameField.getText().toString();
                    if (name.isEmpty()) throw new RuntimeException("Nombre vacío, por favor escriba un nombre");
                    if (Integer.parseInt(pdsDisponibles.getText().toString())<0) throw new RuntimeException("PDs negativos, borra algunos PDs");
                    Personaje pFinal = new Personaje(name);
                    pFinal.setRaza(razaSpinner.getSelectedItem().toString());
                    //p.setClase(classSpinner.getSelectedItem().toString());
                    pFinal.setClase(new Guerrero());
                    if (!lvlNumber.getText().toString().isEmpty() && Integer.parseInt(lvlNumber.getText().toString()) > 0) pFinal.setNivel(Integer.parseInt(lvlNumber.getText().toString()));
                    if (!agilidadNumber.getText().toString().isEmpty()) pFinal.setAgilidad(Integer.parseInt(agilidadNumber.getText().toString()));
                    if (!constNumber.getText().toString().isEmpty()) pFinal.setConstitucion(Integer.parseInt(constNumber.getText().toString()));
                    if (!percepNumber.getText().toString().isEmpty()) pFinal.setPercepcion(Integer.parseInt(percepNumber.getText().toString()));
                    if (!fuerzaNumber.getText().toString().isEmpty()) pFinal.setFuerza(Integer.parseInt(fuerzaNumber.getText().toString()));
                    if (!intNumber.getText().toString().isEmpty()) pFinal.setInteligencia(Integer.parseInt(intNumber.getText().toString()));
                    if (!poderNumber.getText().toString().isEmpty()) pFinal.setPoder(Integer.parseInt(poderNumber.getText().toString()));
                    if (!destrezaNumber.getText().toString().isEmpty()) pFinal.setDestreza(Integer.parseInt(destrezaNumber.getText().toString()));
                    if (!volNumber.getText().toString().isEmpty()) pFinal.setVoluntad(Integer.parseInt(volNumber.getText().toString()));

                    if (!PDsAct.getText().toString().isEmpty()) pFinal.setPdAct(Integer.parseInt(PDsAct.getText().toString()));
                    if (!PDsAdvertir.getText().toString().isEmpty()) pFinal.setPdAdvertir(Integer.parseInt(PDsAdvertir.getText().toString()));
                    if (!PDsArmadura.getText().toString().isEmpty()) pFinal.setPdLlevarArmadura(Integer.parseInt(PDsArmadura.getText().toString()));
                    if (!PDsArte.getText().toString().isEmpty()) pFinal.setPdArte(Integer.parseInt(PDsArte.getText().toString()));
                    if (!PDsAtaque.getText().toString().isEmpty()) pFinal.setPdHa(Integer.parseInt(PDsAtaque.getText().toString()));
                    if (!PDsCapFisica.getText().toString().isEmpty()) pFinal.setPdCapFisica(Integer.parseInt(PDsCapFisica.getText().toString()));
                    if (!PDsConocimiento.getText().toString().isEmpty()) pFinal.setPdConocimiento(Integer.parseInt(PDsConocimiento.getText().toString()));
                    if (!PDsCV.getText().toString().isEmpty()) pFinal.setPdCv(Integer.parseInt(PDsCV.getText().toString()));
                    if (!PDsDefensa.getText().toString().isEmpty()) pFinal.setPdHd(Integer.parseInt(PDsDefensa.getText().toString()));
                    if (!PDsNivelMagia.getText().toString().isEmpty()) pFinal.setPdNivelMagia(Integer.parseInt(PDsNivelMagia.getText().toString()));
                    if (!PDsProyMagica.getText().toString().isEmpty()) pFinal.setPdProyMagica(Integer.parseInt(PDsProyMagica.getText().toString()));
                    if (!PDsProyPsiquica.getText().toString().isEmpty()) pFinal.setPdProyPsiquica(Integer.parseInt(PDsProyPsiquica.getText().toString()));
                    if (!PDsSigilo.getText().toString().isEmpty()) pFinal.setPdSigilo(Integer.parseInt(PDsSigilo.getText().toString()));
                    if (!PDsValoracionMagica.getText().toString().isEmpty()) pFinal.setPdValoracionMagica(Integer.parseInt(PDsValoracionMagica.getText().toString()));
                    if (!PDsVida.getText().toString().isEmpty()) pFinal.setPdVida(Integer.parseInt(PDsVida.getText().toString()));
                    if (!PDsZeon.getText().toString().isEmpty()) pFinal.setPdZeon(Integer.parseInt(PDsZeon.getText().toString()));

                    int weapon = R.string.vara;
                    int armor = R.string.cuero;

                    int pos = spinnerWeapon.getSelectedItemPosition();

                    switch (pos) {
                        case 0:
                            weapon = R.string.vara;
                            break;
                        case 1:
                            weapon = R.string.lanza;
                            break;
                        case 2:
                            weapon = R.string.martillo;
                            break;
                        case 3:
                            weapon = R.string.daga;
                            break;
                        case 4:
                            weapon = R.string.ballesta;
                            break;
                        case 5:
                            weapon = R.string.arco;
                            break;
                        case 6:
                            weapon = R.string.espada;
                    }

                    pos = spinnerArmor.getSelectedItemPosition();

                    switch (pos) {
                        case 0:
                            armor = R.string.cuero;
                            break;
                        case 1:
                            armor = R.string.piezas;
                            break;
                        case 2:
                            armor = R.string.completaPesada;
                            break;
                        case 3:
                            armor = R.string.completa;
                            break;
                        case 4:
                            armor = R.string.semicompleta;
                            break;
                        case 5:
                            armor = R.string.placas;
                            break;
                        case 6:
                            armor = R.string.mallas;
                            break;
                        case 7:
                            armor = R.string.cueroTachonado;
                            break;
                        case 8:
                            armor = R.string.piel;
                            break;
                        case 9:
                            armor = R.string.acolchada;
                    }

                    String s = classSpinner.getSelectedItem().toString();
                    Clase c = new Guerrero();

                    switch (s) {
                        case "Warrior":
                        case "Guerrero":
                            c = new Guerrero();
                            break;
                        case "Hechicero":
                        case "Sorcerer":
                            c = new Hechicero();
                            break;
                        case "Ladron":
                        case "Thief":
                            c = new Ladron();
                            break;
                        case "Mentalista":
                        case "Mentalist":
                            c = new Mentalista();
                    }
                    pFinal.setClase(c);
                    pFinal.setArma(weapon);
                    pFinal.setArmadura(armor);

                    boolean b = db.addPersonaje(pFinal);
                    if (!b) {
                        throw new RuntimeException("Error al subir a la base de datos");
                    } else {
                        Toast.makeText(getApplicationContext(), "Se ha creado su personaje", Toast.LENGTH_LONG).show();
                    }
                    finish();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(back){
            back = false;
            viewPds.setVisibility(View.GONE);
            viewAtr.setVisibility(View.VISIBLE);
        } else {
            finish();
        }
    }

    private Integer calcularPDsDisponibles(Personaje p)
    {
        Integer valor = p.getPd()-p.getPdHa()-p.getPdHd()-p.getPdLlevarArmadura()-p.getPdVida();
        valor = valor - p.getPdZeon()-p.getPdAct()-p.getPdProyMagica()-p.getPdNivelMagia();
        valor = valor - p.getPdCv()-p.getPdProyPsiquica();
        valor = valor - p.getPdArte()-p.getPdAdvertir()-p.getPdCapFisica()-p.getPdConocimiento()-p.getPdSigilo()-p.getPdValoracionMagica();
        return valor;

    }
}
