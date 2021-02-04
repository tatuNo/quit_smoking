package com.example.kahiproject;


import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;


public class TipsActivity extends AppCompatActivity {

    ListView mListView;
    String [] mobileBrands;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);
        // hei
        mListView =findViewById(R.id.list_view);

        mobileBrands = new String[] {"Päätä ennakolta päivä, jolloin lopetat. Kun valitset etukäteen lopettamispäivän, päätöksestä on vaikea perääntyä. Lopettamista on turha lykätä viikkoja, mutta sinun on hyvä varmistaa ajankohdan olevan mahdollisimman stressitön. Näin voit keskittää voimasi tupakoinnin lopettamiseen.", "Pyydä tukea läheisiltäsi. Ympärilläsi olevat ihmiset suhtautuvat sinuun ymmärtäväisemmin ja kannustavammin, kun kerrot mihin olet ryhtynyt ja mitä heidän tukensa sinulle merkitsee.",
                "Pyydä tukihenkilö avuksesi. Etsi lähipiiristäsi innostava ihminen, joka kannustaa sinua pysymään päätöksessäsi.",
                "Keskustele erityisesti puolisosi kanssa siitä, kuinka hän voi tukea päätöstäsi. Käykää yhdessä läpi käytännön asiat, joilla on vaikutusta: vapaa-ajanvietto, mahdolliset vieroitusoireet, keskustelun ja rohkaisun tarpeet sekä pelisäännöt, jos puoliso vielä tupakoi.",
                "Varaudu vieroitusoireisiin ja mieti, miten selviät erilaisesta tilanteista. Kestätkö vieroitusoireet vai helpotatko oloasi korvaushoidolla? Hanki tarvittaessa nikotiinivalmisteet ennakkoon ja lue tuotteiden käyttöohjeet.",
                "Varaa itsellesi jotain kevyttä ja raikasta purtavaa. Kokeile lohkottuja juureksia tai hedelmiä. Kun tupakantuska yllättää, pieni naposteltava voi alkuun olla pelastuksesi.",
                "Hävitä edellisenä iltana kaikki tupakointivälineesi. Älä jätä itsellesi yhtään takaporttia.","Palkitse itseäsi pienistäkin onnistumisista. Jos lipsahdat tupakoimaan, älä lannistu. Monet antavat periksi heti kun lipsahtavat uskoen, että he ovat epäonnistuneet. Tällaisessa tilanteessa on hyvä muistaa, että kyseessä on vain pieni takaisku, jonka vuoksi ei kannata luopua savuttoman elämän tavoitteesta. Kompurointi on osa elämää.",
        };

        ArrayAdapter<String>mAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mobileBrands);

        mListView.setAdapter(mAdapter);
    }
}