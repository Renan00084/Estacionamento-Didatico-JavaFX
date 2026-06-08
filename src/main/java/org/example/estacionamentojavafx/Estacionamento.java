package org.example.estacionamentojavafx;

import java.util.ArrayList;
import java.util.Objects;
import java.time.LocalDateTime;

public class Estacionamento {
    private ArrayList<Vaga> vagas;
    private ArrayList<Ticket> ticketsAbertos;
    private boolean flag, flag2;
    private int horaTotal;

    Tarifario tarifario = new Tarifario();

    public Estacionamento(int totalVagas){
        this.vagas = new ArrayList<>(); // Inicializa o Array
        this.ticketsAbertos = new ArrayList<>();
        for (int i=1; i <= totalVagas; i++){
            Vaga novaVaga = new Vaga(i); // cria a vaga com base no numero
            this.vagas.add(novaVaga); // Adiciona no Array
            Ticket novoTicket = new Ticket(i);
            this.ticketsAbertos.add(novoTicket);

        }

    }

    public void registrarEntrada(Veiculo carro, int vagaNum){

        if(vagaNum <= 0 || vagaNum > vagas.size()){
            System.out.println("Vaga não encontrada");
            return;
        }

        for(Vaga vaga : vagas){

            if(vaga.getNumero() == vagaNum){

                if(vaga.getOcupada()){

                    System.out.println("Vaga já está ocupada");
                    return;
                }

                vaga.estacionar(carro);

                System.out.println("Vaga registrada com sucesso!");

                LocalDateTime agora = LocalDateTime.now();

                for(Ticket ticket : ticketsAbertos){
                    if(ticket.getNumero() == vagaNum){
                        ticket.setHoraEntrada(agora);

                        break;
                    }
                }

                return;
            }
        }
    }

    public boolean registrarSaida(String placa){

        for(Vaga vaga : vagas){

            if(vaga.getOcupada() && Objects.equals(vaga.getPlaca(), placa)){

                LocalDateTime agora = LocalDateTime.now();

                for(Ticket ticket : ticketsAbertos){

                    if(ticket.getNumero() == vaga.getNumero()){

                        ticket.setHoraSaida(agora);

                        int horaTotal = ticket.calcularTempoEmHoras();

                        double valor = tarifario.calcularValor(horaTotal);

                        System.out.println("Tempo total: " + horaTotal + " hora(s)");

                        System.out.println("Valor a pagar: R$ " + valor);

                        ticket.registrarSaida();

                        break;
                    }
                }

                vaga.liberar();

                System.out.println("Carro da vaga " + vaga.getNumero() + " foi liberado");

                return true;
            }
        }

        return false;
    }

    public void exibirVagasLivres(){
        System.out.println(" --- VAGAS DISPONÍVEIS ---");

        System.out.println("Vagas disponiveis agora: ");

        for(Vaga vaga : vagas){
            if(!vaga.getOcupada()){
                if(vaga.getNumero() == 0){
                    //nada

                }else{
                    System.out.println("Vaga " + vaga.getNumero());

                }

            }else{
                System.out.println("Vaga ocupada, placa do carro: " + vaga.getPlaca());

            }

        }

    }

    public boolean verificarPlaca(String placa){

        for(Vaga vaga : vagas){

            if(vaga.getOcupada() &&
                    Objects.equals(vaga.getPlaca(), placa)){

                return true;
            }
        }

        return false;
    }
}
