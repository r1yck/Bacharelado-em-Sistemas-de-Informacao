package Loja;

import javax.swing.JOptionPane;

public class InvoiceTest {
  public static void main(String[] args) {
    // Criando uma instância de Invoice
    Invoice invoice = new Invoice("12345", "Teclado", 2, 50.0);

    // Obtendo e exibindo os valores iniciais
    JOptionPane.showMessageDialog(null, "Número: " + invoice.getNumero()
        + "\nDescrição: " + invoice.getDescricao()
        + "\nQuantidade: " + invoice.getQuantidade()
        + "\nPreço: " + invoice.getPreco());

    // Alterando os valores
    invoice.setNumero("54321");
    invoice.setDescricao("Mouse");
    invoice.setQuantidade(3);
    invoice.setPreco(25.0);

    // Obtendo e exibindo os novos valores
    JOptionPane.showMessageDialog(null, "Número: " + invoice.getNumero()
        + "\nDescrição: " + invoice.getDescricao()
        + "\nQuantidade: " + invoice.getQuantidade()
        + "\nPreço: " + invoice.getPreco());

    // Calculando e exibindo o valor da fatura
    double valorInvoice = invoice.getValorInvoice();
    JOptionPane.showMessageDialog(null, "Valor da fatura: R$" + valorInvoice);
  }
}