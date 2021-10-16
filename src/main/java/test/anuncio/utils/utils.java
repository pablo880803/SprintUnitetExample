package test.anuncio.utils;

public class utils {


    public String AbbreviationGenerate(String name){

        String abbreviation="";

        String[] listPalabras = name.split(" ");

        if (listPalabras.length==1){
            abbreviation = name.substring(0, 3).toUpperCase();
        }

        if (listPalabras.length<3){
            abbreviation += listPalabras[0].substring(0, 2).toUpperCase();
            abbreviation += listPalabras[0].substring(0, 1).toUpperCase();
        }
        else{
            for(int i=0 ; i<listPalabras.length;i++){
                abbreviation += listPalabras[i].substring(0, 1).toUpperCase();
            }
        }


        return abbreviation;
    }


}
