package fila_ex2;

import javax.swing.JOptionPane;
import java.util.HashMap;

public class GerenciaFilas {

    private int nCaixaNor = 1;
    private int nCaixaPri = 1;
    private int nHbtNor = 1;
    private int nHbtPri = 1;
    private int nFinNor = 1;
    private int nFinPri = 1;
    private int nGerNor = 1;
    private int nGerPri = 1;

    private Fila<Senha> filaCaixaNor = new Fila<>("filaCaixaNor");
    private Fila<Senha> filaCaixaPri = new Fila<>("filaCaixaPri");
    private Fila<Senha> filaHbtNor = new Fila<>("filaHbtNor");
    private Fila<Senha> filaHbtPri = new Fila<>("filaHbtPri");
    private Fila<Senha> filaFinNor = new Fila<>("filaFinNor");
    private Fila<Senha> filaFinPri = new Fila<>("filaFinPri");
    private Fila<Senha> filaGerNor = new Fila<>("filaGerNor");
    private Fila<Senha> filaGerPri = new Fila<>("filaGerPri");

    private HashMap<String, Fila<Senha>> filas = new HashMap<>();

    public GerenciaFilas() {
        filas.put("CaixaNor", filaCaixaNor);
        filas.put("CaixaPri", filaCaixaPri);
        filas.put("HbtNor", filaHbtNor);
        filas.put("HbtPri", filaHbtPri);
        filas.put("FinNor", filaFinNor);
        filas.put("FinPri", filaFinPri);
        filas.put("GerNor", filaGerNor);
        filas.put("GerPri", filaGerPri);
    }

    public String escolheTipo() {
        String retorno = "";
        int t = Integer.parseInt(
                JOptionPane.showInputDialog(null,
                        "--- Escolha o tipo: ---- \n"
                        + "  1- Caixa\n"
                        + "  2- Habitação\n"
                        + "  3- Financiamento\n"
                        + "  4- Geral "));
        switch (t) {
            case 1:
                retorno = "Caixa";
                break;
            case 2:
                retorno = "Habitação";
                break;
            case 3:
                retorno = "Financiamento";
                break;
            case 4:
                retorno = "Geral";
                break;
            default:
                JOptionPane.showMessageDialog(null, "Tipo Inválido");
                retorno = escolheTipo();
        }

        return retorno;
    }

    public String escolhePrioridade() {
        String retorno = "";
        int t = Integer.parseInt(
                JOptionPane.showInputDialog(null,
                        "--- Escolha a Prioridade: ---- \n"
                        + "  1- Normal \n"
                        + "  2- Prioritário"));
        switch (t) {
            case 1:
                retorno = "Normal";
                break;
            case 2:
                retorno = "Prioritário";
                break;
            default:
                JOptionPane.showMessageDialog(null, "Prioridade Inválida");
                retorno = escolhePrioridade();
        }
        return retorno;
    }

    public int escolheNumero(String tipo, String pri) {
        int numero = 0;
        if (tipo.equals("Caixa")) {
            if (pri.equals("Normal")) {
                numero = nCaixaNor;
                nCaixaNor++;
            } else {
                numero = nCaixaPri;
                nCaixaPri++;
            }
        }

        if (tipo.equals("Habitação")) {
            if (pri.equals("Normal")) {
                numero = nHbtNor;
                nHbtNor++;
            } else {
                numero = nHbtPri;
                nHbtPri++;
            }
        }

        if (tipo.equals("Financiamento")) {
            if (pri.equals("Normal")) {
                numero = nFinNor;
                nFinNor++;
            } else {
                numero = nFinPri;
                nFinPri++;
            }
        }

        if (tipo.equals("Geral")) {
            if (pri.equals("Normal")) {
                numero = nGerNor;
                nGerNor++;
            } else {
                numero = nGerPri;
                nGerPri++;
            }
        }

        return numero;
    }

    public Fila<Senha> escolheFila(Senha s) {
        Fila<Senha> retorno = null;

        if (s.getTipo().equals("Caixa")) {
            if (s.getPrioridade().equals("Normal")) {
                retorno = filaCaixaNor;
            } else {
                retorno = filaCaixaPri;
            }
        }

        if (s.getTipo().equals("Habitação")) {
            if (s.getPrioridade().equals("Normal")) {
                retorno = filaHbtNor;
            } else {
                retorno = filaHbtPri;
            }
        }

        if (s.getTipo().equals("Financiamento")) {
            if (s.getPrioridade().equals("Normal")) {
                retorno = filaFinNor;
            } else {
                retorno = filaFinPri;
            }
        }

        if (s.getTipo().equals("Geral")) {
            if (s.getPrioridade().equals("Normal")) {
                retorno = filaGerNor;
            } else {
                retorno = filaGerPri;
            }
        }

        return retorno;
    }

    public void intercalarFilas() {
        Fila<Senha> filaIntercalada = new Fila<>("FilaIntercalada");

        intercalarFilaAux(filaIntercalada, filaCaixaNor);
        intercalarFilaAux(filaIntercalada, filaHbtNor);
        intercalarFilaAux(filaIntercalada, filaFinNor);
        intercalarFilaAux(filaIntercalada, filaGerNor);
        intercalarFilaAux(filaIntercalada, filaCaixaPri);
        intercalarFilaAux(filaIntercalada, filaHbtPri);
        intercalarFilaAux(filaIntercalada, filaFinPri);
        intercalarFilaAux(filaIntercalada, filaGerPri);

        JOptionPane.showMessageDialog(null, "Fila Intercalada: " + filaIntercalada);
    }

    private void intercalarFilaAux(Fila<Senha> filaInterCalada, Fila<Senha> fila) {
        while (!fila.vazia()) {
            filaInterCalada.inserePrioritario(fila.remove());
        }
    }

    public void inserirSenha(Senha senha) {
        Fila<Senha> filaEscolhida = escolheFila(senha);

        if (senha.isPrioritaria()) {
            filaEscolhida.inserePrioritario(senha);
        } else {
            filaEscolhida.insere(senha);
        }

        JOptionPane.showMessageDialog(null, "Fila Atual:\n" + filaEscolhida);
    }

    public void chamarSenha(String tipoAtendimento) {
        Fila<Senha> filaPrioritaria = getFilaPrioritaria(tipoAtendimento);
        Fila<Senha> filaNormal = getFilaNormal(tipoAtendimento);

        if (!filaPrioritaria.vazia()) {
            JOptionPane.showMessageDialog(null, "Chamando senha prioritária: " + filaPrioritaria.remove());
        } else if (!filaNormal.vazia()) {
            JOptionPane.showMessageDialog(null, "Chamando senha normal: " + filaNormal.remove());
        } else {
            JOptionPane.showMessageDialog(null, "Não há senhas na fila de " + tipoAtendimento);
        }
    }

    public void mostrarOrdemAtendimento(String tipoAtendimento) {
        Fila<Senha> filaPrioritaria = getFilaPrioritaria(tipoAtendimento);
        Fila<Senha> filaNormal = getFilaNormal(tipoAtendimento);

        JOptionPane.showMessageDialog(null,
                "Ordem de Atendimento para " + tipoAtendimento + ":\n"
                + "Prioritárias: " + filaPrioritaria + "\n"
                + "Normais: " + filaNormal);
    }

    public int tamanhoFila(String tipoAtendimento) {
        Fila<Senha> filaPrioritaria = getFilaPrioritaria(tipoAtendimento);
        Fila<Senha> filaNormal = getFilaNormal(tipoAtendimento);

        return filaPrioritaria.tamanho() + filaNormal.tamanho();
    }

    public int verificaPosicao(String tipoAtendimento, int numeroSenha) {
        Fila<Senha> filaPrioritaria = getFilaPrioritaria(tipoAtendimento);
        Fila<Senha> filaNormal = getFilaNormal(tipoAtendimento);

        int posicaoPrioritaria = filaPrioritaria.verificaElemento(new Senha("", "", numeroSenha));
        int posicaoNormal = filaNormal.verificaElemento(new Senha("", "", numeroSenha));

        if (posicaoPrioritaria != -1) {
            return posicaoPrioritaria + 1;
        } else if (posicaoNormal != -1) {
            return posicaoNormal + filaPrioritaria.tamanho() + 1;
        } else {
            return -1;
        }
    }

    public int tamanhoTotalFilas() {
        int tamanhoTotal = 0;
        for (Fila<Senha> fila : filas.values()) {
            tamanhoTotal += fila.tamanho();
        }
        return tamanhoTotal;
    }

    private Fila<Senha> getFilaPrioritaria(String tipoAtendimento) {
        return filas.get(tipoAtendimento + "Pri");
    }

    private Fila<Senha> getFilaNormal(String tipoAtendimento) {
        return filas.get(tipoAtendimento + "Nor");
    }
}
