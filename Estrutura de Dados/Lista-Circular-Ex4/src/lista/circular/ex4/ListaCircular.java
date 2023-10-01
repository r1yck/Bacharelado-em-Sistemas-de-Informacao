package lista.circular.ex4;


public class ListaCircular {
    
    private Celula primeira;
    private Celula ultima;
    
    private int totalDeElementos = 0;
    
    public ListaCircular() {
        primeira = null;
        ultima = null;
        totalDeElementos = 0;
    }
    
     /* 4.2 - Tamanho */
    public int tamanho() {
        return this.totalDeElementos;
    }
    
    /* 4.3 Adiciona no final */
    public void adiciona(Object elemento) {
        
        Celula nova = new Celula(elemento);
        
        //01 - Lista Vazia
        if(this.totalDeElementos == 0)
        {
            this.primeira = nova;
            this.ultima = nova;
            nova.setProxima(nova);
            nova.setAnterior(nova);
        }
        else
        {
            nova.setProxima(primeira);
            primeira.setAnterior(nova);
            ultima.setProxima(nova);
            nova.setAnterior(ultima);
            ultima = nova;
        }
        totalDeElementos++;
    }
    
    /* 4.4 Remove no final */
    public void remove(){
        // lista vazia
        if (this.totalDeElementos == 0){
            throw new IllegalArgumentException("Posição não existe");
        }
        
        // lista com 1 elemento
        else if(this.totalDeElementos == 1){
            primeira.setProxima(null);
            primeira.setAnterior(null);
            primeira = null;
            ultima = null;
        }
        else{ // lista mais de 1 elemento
            Celula penultima = ultima.getAnterior();
            penultima.setProxima(primeira);
            primeira.setAnterior(penultima);
            ultima = penultima;
        }
        
        totalDeElementos--;
    }
    
    /* 4.5 Concatena */
    public void concatena(ListaCircular L2){
        //01 - L1 vazia e L2 vazia
        if(this.totalDeElementos == 0 && L2.totalDeElementos == 0)
        {}
        //02 - L1 cheia e L2 vazia
        else if(this.totalDeElementos > 0 && L2.totalDeElementos == 0)
        {}
        //03 - L1 vazia e L2 cheia
        if(this.totalDeElementos == 0 && L2.totalDeElementos > 0){
            this.primeira         = L2.primeira;
            this.ultima           = L2.ultima;
            this.totalDeElementos = L2.totalDeElementos;
        }
        //04 - L1 cheia e L2 cheia
        else if(this.totalDeElementos > 0 && L2.totalDeElementos > 0){
            this.ultima.setProxima(L2.primeira);
            L2.primeira.setAnterior(this.ultima);
            
            L2.ultima.setProxima(primeira);
            this.primeira.setAnterior(L2.ultima);
            
            this.ultima = L2.ultima;
            this.totalDeElementos += L2.totalDeElementos;
        }
        
        
    }
    
    /* 4.6 Intercala lista */
    public void intercala(ListaCircular L2){
        //01 - L1 vazia e L2 vazia
        if(this.totalDeElementos == 0 && L2.totalDeElementos == 0)
        {}
        //02 - L1 cheia e L2 vazia
        else if(this.totalDeElementos > 0 && L2.totalDeElementos == 0)
        {}
        //03 - L1 vazia e L2 cheia
        if(this.totalDeElementos == 0 && L2.totalDeElementos > 0){
            this.primeira         = L2.primeira;
            this.ultima           = L2.ultima;
            this.totalDeElementos = L2.totalDeElementos;
        }
        //04 - L1 cheia e L2 cheia
        else if(this.totalDeElementos > 0 && L2.totalDeElementos > 0){
            
            //pega a primeira de L1
            //pega a primeira de L2
            
            // do while - enquanto não é a primeira
            // -> adicionar L3 o atual L1
            // -> adicionar L3 o atual L2
            // -> pula para próxima de L1 e L2
            
            // Se existe elementos em L1
            // -> add os elementos de L1 em L3
            
            // Copiar para L1 o resutado de L3
            
            ListaCircular L3 = new ListaCircular ();
            
            Celula atual1 = this.primeira;
            Celula atual2 = L2.primeira;
            
            // Insere enquanto tem a mesma quantidade de elementos
            do {
                L3.adiciona(atual1.getElemento()); // add L1
                L3.adiciona((atual2.getElemento())); // add L2
                
                atual1 = atual1.getProxima();
                atual2 = atual2.getProxima();
            } while ((atual1 != this.primeira) && (atual2 != L2.primeira));

           // L1 Ainda tem elementos
            while (atual1 != this.primeira) {
                L3.adiciona(atual1.getElemento());
                atual1 = atual1.getProxima();
            }
            
           // L2 Ainda tem elementos
            while (atual2 != L2.primeira) {
                L3.adiciona(atual2.getElemento());
                atual2 = atual2.getProxima();
            }
            
            // Copiar de L3 auxiliar para L1 onde deve estar a resposta
            this.primeira = L3.primeira;
            this.ultima = L3.ultima;
            this.totalDeElementos = L3.totalDeElementos;
                        
        }
                
    }

    /* 4.6 - Intercalar Lista - Sem utilizar a lista auxiliar L3 */
    public void intercala2(ListaCircular L2){
        // situação 1 - listas 1 e 2 vazias
        if(this.totalDeElementos == 0 && L2.totalDeElementos == 0){}
        
        // situação 2 - L1 cheia e L2 vazia
        else if(this.totalDeElementos > 0 && L2.totalDeElementos == 0){}
        
        // situação 3 - L1 vazia e L2 cheia
        else if(this.totalDeElementos == 0 && L2.totalDeElementos > 0){
            this.primeira = L2.primeira;
            this.ultima = L2.ultima;
            this.totalDeElementos = L2.totalDeElementos;
        }
        
        // situação 4 - L1 cheia e L2 vazia
        else if (this.totalDeElementos > 0 & L2.totalDeElementos > 0) {
            
            Celula atual = this.primeira;
            Celula aux1 = this.primeira;
            Celula aux2 = L2.primeira;
            
            while(atual != this.ultima & atual != L2.ultima) {
                
                // Bloco L1
                aux1 = atual.getProxima();
                atual.setProxima(aux2);
                aux1.setAnterior(aux2);
                aux2.setAnterior(atual);
                
                atual = atual.getProxima();
                
                // Bloco L2 - Não pode ser o ultimo elemento
                if(atual != L2.ultima) {
                    aux2 = atual.getProxima();
                    atual.setProxima(aux1);
                    aux2.setAnterior(aux1);
                    
                    atual = atual.getProxima();
                }

            }
            
            // Final da L1 -> ainda tem elementos em L2
            if(atual == this.ultima) {
                atual.setProxima(aux2);
                this.ultima = L2.ultima;
            }
            
            // Final da L2 -> ainda tem elementos em L1
            if(atual == L2.ultima) {
                atual.setProxima(aux1);
            }
            
            // Fazer circular
            this.primeira.setAnterior(this.ultima);
            this.ultima.setProxima(primeira);
            
            // Somar total de elementos
            this.totalDeElementos += L2.totalDeElementos;
            
        }
    }
    /* 4.7 - Imprimir lista */
    public String toString() {
        // Lista vazia
        if (this.totalDeElementos == 0) {
            return "[]";
        }

        StringBuilder builder = new StringBuilder("[");
        Celula atual = primeira;

        // Percorrendo até o penúltimo elemento.
        for (int i = 0; i < this.totalDeElementos - 1; i++) {
            builder.append(atual.getElemento());
            builder.append(", ");
            atual = atual.getProxima();
        }

        // último elemento
        builder.append(atual.getElemento());
        builder.append("]");

        return builder.toString();
    }
    
    public static void main(String[] args) {
        Aluno a1 = new Aluno("Rafael");
        Aluno a2 = new Aluno("Bernardo");
        Aluno a3 = new Aluno("Laura");
        
        //Lista implementada
        ListaCircular l1 = new ListaCircular();
        l1.adiciona(a1);
        l1.adiciona(a2);
        l1.adiciona(a3);
        System.out.println(l1);
        
        Aluno b1 = new Aluno("Rafael-L2");
        Aluno b2 = new Aluno("Bernardo-L2");
        Aluno b3 = new Aluno("Laura-L2");
        
        //Lista implementada
        ListaCircular l2 = new ListaCircular();
        l2.adiciona(b1);
        l2.adiciona(b2);
        l2.adiciona(b3);
        System.out.println(l2);
        
        l1.intercala2(l2);
        System.out.println(l1);
        System.out.println(l1.tamanho());
    }
    
}
