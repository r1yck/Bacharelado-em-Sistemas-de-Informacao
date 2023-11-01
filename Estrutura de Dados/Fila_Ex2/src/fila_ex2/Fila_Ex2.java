package fila_ex2;

import javax.swing.JOptionPane;

public class Fila_Ex2 {

    public static void main(String[] args) {

        GerenciaFilas filas = new GerenciaFilas();
        int op = 0;

        while (op != 8) {

            op = Integer.parseInt(
                    JOptionPane.showInputDialog("--- Escolha a opção: ---- \n"
                            + "  1- Inserir Senha\n"
                            + "  2- Chamar Senha\n"
                            + "  3- Ordem Atendimento\n"
                            + "  4- Tamanho Fila \n"
                            + "  5- Posição da senha \n"
                            + "  6- Tamanho total da fila\n"
                            + "  7- [Extra] Intercalar Filas\n"
                            + "  8- Sair"));

            switch (op) {
                case 1: //---- inserir senha na fila correta
                    String tipo = filas.escolheTipo();
                    String pri = filas.escolhePrioridade();
                    int numero = filas.escolheNumero(tipo, pri);
                    Senha nova = new Senha(tipo, pri, numero);

                    Fila filaEscolhida = filas.escolheFila(nova);
                    filaEscolhida.insere(nova);

                    JOptionPane.showMessageDialog(null, "Fila Atual:\n" + filaEscolhida);
                    break;

                case 2:   //--- Chamar Senha
                    String tipoAtendimento = filas.escolheTipo();
                    filas.chamarSenha(tipoAtendimento);
                    break;

                case 3:   //--- Ordem Atendimento
                    String tipoAtendimentoOrdem = filas.escolheTipo();
                    filas.mostrarOrdemAtendimento(tipoAtendimentoOrdem);
                    break;

                case 4:   //--- Tamanho Fila
                    String tipoTamanho = filas.escolheTipo();
                    int tamanhoFila = filas.tamanhoFila(tipoTamanho);
                    JOptionPane.showMessageDialog(null, "Tamanho da Fila de " + tipoTamanho + ": " + tamanhoFila);
                    break;

                case 5:   //--- Posição da senha
                    String tipoPosicao = filas.escolheTipo();
                    int numeroSenha = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da senha: "));
                    int posicao = filas.verificaPosicao(tipoPosicao, numeroSenha);
                    if (posicao != -1) {
                        JOptionPane.showMessageDialog(null, "Posição da Senha " + numeroSenha + " na Fila de " + tipoPosicao + ": " + posicao);
                    } else {
                        JOptionPane.showMessageDialog(null, "Senha não encontrada na Fila de " + tipoPosicao);
                    }
                    break;

                case 6:  //--- Tamanho total da fila
                    int tamanhoTotal = filas.tamanhoTotalFilas();
                    JOptionPane.showMessageDialog(null, "Tamanho Total da Fila: " + tamanhoTotal);
                    break;

                case 7: // [Extra] Intercalar Filas
                    filas.intercalarFilas();
                    break;
            }
        }
    }

}
