package org.example.estacionamentojavafx;

public class Vaga {
    private int numero;
    private boolean ocupada = false;
    private Veiculo veiculoEstacionado;

    public boolean getOcupada (){
        return ocupada;

    }

    public int getNumero(){
        return numero;

    }

    public Vaga (int numero){
        this.numero = numero;
        this.ocupada = false;
        this.veiculoEstacionado = null;

    }

    public void estacionar(Veiculo carro){
        this.ocupada = true;
        this.veiculoEstacionado = carro;

    }

    public void liberar(){
        this.ocupada = false;
        this.veiculoEstacionado = null;

    }

    public String getPlaca(){
        if(veiculoEstacionado == null){
            return null;
        }

        return veiculoEstacionado.getPlaca();
    }
}
