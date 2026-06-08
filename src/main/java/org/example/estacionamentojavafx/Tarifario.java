package org.example.estacionamentojavafx;

public class Tarifario {
    private double valorHora = 10, valorDiaria = 240, valorSemana = 1680, valorMes = 6720;

    public double calcularValor(int totalHoras){
        double total;
        if(totalHoras > 0){
            int meses = totalHoras / 720;
            int restoMes = totalHoras % 720;
            int semanas = restoMes / 168;
            int restoSemana = restoMes % 168;
            int dias = restoSemana / 24;
            int horasExtras = restoSemana % 24;

            total = (meses * valorMes) + (semanas * valorSemana) + (dias * valorDiaria) + (horasExtras * valorHora);

        }else{
            total = 10;

        }

        return total;

    }

}
