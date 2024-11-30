package testingfinal;

import java.time.LocalDate;
import testingfinal.PaseVencidoException;

/**
 *
 * @author JuanJo
 */

public class PaseMensual {
    private int nroPase;
    private LocalDate fechaIni;
    private LocalDate fechaFin;
    private int entradas;
    private boolean estado;
    public Socio socio;
   
    public int descontarPase() throws PaseVencidoException{
        if (entradas>0 && LocalDate.now().isBefore(fechaFin)) {
            this.entradas--;
        } else {
            if (LocalDate.now().isBefore(fechaFin))
                throw new PaseVencidoException("vencido");
            else 
                System.out.println("membresía sin entradas");
        } 
        return entradas;
    }
    public void descontarPaseTildado() throws InterruptedException {
        Thread.sleep(100);
    }
    
    public PaseMensual(int nroPase, LocalDate fechaIni, LocalDate fechaFin, int entradas, boolean estado, Socio s) {
        this.nroPase = nroPase;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.entradas = entradas;
        this.estado = estado;
        socio = s;
    }

    public LocalDate getFechaIni() {
        return fechaIni;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public int getEntradas() {
        return entradas;
    }

    public boolean isEstado() {
        return estado;
    }
    
}