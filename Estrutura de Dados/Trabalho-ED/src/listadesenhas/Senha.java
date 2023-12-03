package listadesenhas;

import javax.swing.*;
import java.io.*;
import java.util.*;

class Senha implements Serializable {

    String aplicativo;
    String senha;

    public Senha(String aplicativo, String senha) {
        this.aplicativo = aplicativo;
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Aplicativo: " + aplicativo + ", Senha: " + senha;
    }
}
