package Uses;

/**
 * <h3>
 * ESTG - Escola Superior de Tecnologia e Gestão<br>
 * IPP - Instituto Politécnico do Porto<br>
 * LEI - Licenciatura em Engenharia Informática<br>
 * PP - Paradigmas de Programação<br>
 * </h3>
 * <p>
 * <strong>Author: </strong><br>
 * Joao Sousa<br>
 * <strong>Description: </strong><br>
 * Class that represents 
 * </p>
 */

public class Car implements Comparable{

    private String model;
    /**
     * Modelo dos pneus
     */
    private String wheels;
    private short year;
    private short month;
    private int value;

    public Car(String model, String wheels, short year, short month, int value) {
        this.model = model;
        this.wheels = wheels;
        this.year = year;
        this.month = month;
        this.value = value;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @return the wheels
     */
    public String getWheels() {
        return wheels;
    }

    /**
     * @param wheels the wheels to set
     */
    public void setWheels(String wheels) {
        this.wheels = wheels;
    }

    /**
     * @return the year
     */
    public short getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(short year) {
        this.year = year;
    }

    /**
     * @return the month
     */
    public short getMonth() {
        return month;
    }

    /**
     * @param month the month to set
     */
    public void setMonth(short month) {
        this.month = month;
    }

    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(int value) {
        this.value = value;
    }
        
    @Override
    public int compareTo(Object o) {
        Comparable CValue = (Comparable) this.value;
        return CValue.compareTo( ( (Car) o ).getValue() );
    }
    
}
