package org.example.estacionamentojavafx;

import java.time.LocalDateTime;
import java.time.Duration;

public class Ticket {
    private int numero;
    private Veiculo carro;
    private LocalDateTime horaEntrada, horaSaida;

    public void registrarSaida(){
        this.carro = null;
        this.horaEntrada = null;
        this.horaSaida = null;

    }

    public int calcularTempoEmHoras(){
        Duration duracao = Duration.between(horaEntrada, horaSaida);
        long h = duracao.toHours();
        int horas = (int) h;
        return horas;

    }

    public Ticket(int numero){
        this.numero = numero;
        this.carro = null;
        this.horaEntrada = null;
        this.horaSaida = null;

    }

    public int getNumero(){
        return numero;

    }

    public void setHoraEntrada(LocalDateTime horaEntrada){
        this.horaEntrada = horaEntrada;

    }

    public void setHoraSaida(LocalDateTime horaSaida){
        this.horaSaida = horaSaida;

    }
}
