/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nst.controlenst.enums;

/**
 *
 * @author emidio
 */
public enum EnumTypeFactory {
    JDBC("JDBC"),
    HIBERNATE("Hibernate");
    private EnumTypeFactory(String tipoFabrica){
        this.tipoFabrica = tipoFabrica;
    }
    @Override
    public String toString(){
        return this.tipoFabrica;
    }
    String tipoFabrica = "";
}
