package testingfinal;

/**
 *
 * @author JuanJo
 */
public class Socio {
    private int dni;
    private String nombre;

    public Socio(int dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }
    
    public boolean sociosDiferentes (Socio s2){
        return this.equals(s2);
    }
    
    public int ComprarGatorade(String code, int precio){
        if (code.equals("2por1"))
           return precio;
        else
           return precio*2;
    }
    
    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }
}