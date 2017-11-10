/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magiemagie;

/**
 *
 * @author Administrateur
 */
public class Carte {

    public enum TypeCarte {

        BAVE_DE_CRAPAUD,
        AILE_DE_CHAUVE_SOURIS,
        LAPIS_LAZULI,
        MANDRAGORE,
        CORNE_DE_LICORNE
    }

    private TypeCarte type;

    @Override
    public boolean equals(Object obj) {

        Carte carteParam = (Carte) obj;

        if (this.getType() == carteParam.getType()) {
            return true;
        } else {
            return false;
        }
    }

@Override
        public String toString() {
        return type.toString();
    }

    public TypeCarte getType() {
        return type;
    }

    public void setType(TypeCarte type) {
        this.type = type;
    }

}
