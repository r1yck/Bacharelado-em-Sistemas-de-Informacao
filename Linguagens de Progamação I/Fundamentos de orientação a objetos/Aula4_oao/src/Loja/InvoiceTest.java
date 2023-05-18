public class InvoiceTest {
  public static void main(String[] args) {
    // Criando uma instância de Invoice
    Invoice invoice = new Invoice("12345", "Teclado", 2, 50.0);

    // Obtendo e exibindo os valores iniciais
    System.out.println("Número: " + invoice.getNumero());
    System.out.println("Descrição: " + invoice.getDescricao());
    System.out.println("Quantidade: " + invoice.getQuantidade());
    System.out.println("Preço: " + invoice.getPreco());

    // Alterando os valores
    invoice.setNumero("54321");
    invoice.setDescricao("Mouse");
    invoice.setQuantidade(3);
    invoice.setPreco(25.0);

    // Obtendo e exibindo os novos valores
    System.out.println("\nNúmero: " + invoice.getNumero());
    System.out.println("Descrição: " + invoice.getDescricao());
    System.out.println("Quantidade: " + invoice.getQuantidade());
    System.out.println("Preço: " + invoice.getPreco());

    // Calculando e exibindo o valor da fatura
    double valorInvoice = invoice.getValorInvoice();
    System.out.println("\nValor da fatura: " + valorInvoice);
  }
}
