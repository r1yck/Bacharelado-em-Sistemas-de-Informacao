// Pacote onde a classe está localizada
package listadesenhas;

// Importação de bibliotecas necessárias
import javax.swing.*;
import java.io.*;
import java.util.*;

// Definição da classe Senha que implementa Serializable
class Senha implements Serializable {

    // Atributos da classe
    String aplicativo; // Nome do aplicativo
    String senha; // Senha associada ao aplicativo

    // Construtor da classe Senha
    public Senha(String aplicativo, String senha) {
        this.aplicativo = aplicativo; // Inicializa o atributo aplicativo
        this.senha = senha; // Inicializa o atributo senha
    }

    // Método sobrescrito para representação em string da classe
    @Override
    public String toString() {
        return "Aplicativo: " + aplicativo + ", Senha: " + senha;
    }
}
