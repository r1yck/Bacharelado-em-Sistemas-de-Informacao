package arvore;

public class Arvore<TIPO extends Comparable> {
    
    private Elemento<TIPO> raiz;
    
    public Arvore(){
        this.raiz = null;
        
    }
    
    public Elemento<TIPO> getRaiz() {
        return raiz;
    }
    
    public void setRaiz(Elemento<TIPO> r) {
         raiz = r;
    }
    
    public void adicionar(TIPO valor){
        Elemento<TIPO> novoElemento = new Elemento<TIPO>(valor); 
        
        if (raiz == null){    // Caso arvore vazia
            this.raiz = novoElemento;
        }
        else{
            Elemento<TIPO> atual = this.raiz;   // inicia raiz com atual
            
            while(true){ //roda constante entrado nos nivies da arvore - Para com break 
                // ------------- Novo elementno MENOR
                if (novoElemento.getValor().compareTo(atual.getValor()) == -1){   
                    if (atual.getEsquerda() != null){
                        atual = atual.getEsquerda();
                    }else{
                        atual.setEsquerda(novoElemento);
                        break;
                    }
                }
                else{ //-------- Novo elemento MAIOR ou igual                        
                    if (atual.getDireita() != null){
                        atual = atual.getDireita();
                    }else{
                        atual.setDireita(novoElemento);
                        break;
                    }
                }
            }
        }
    }
    
 
    
    public  Elemento<TIPO> adicionarRec(TIPO valor, Elemento<TIPO> raizAtual){
        
        Elemento<TIPO> novoElemento = new Elemento<TIPO>(valor); 
        
       //raiz atualvaiza  salva
        if (raizAtual == null){  
            raizAtual = novoElemento;
            
            // Primeiro elemento, atualiza raiz geral.
            if (raiz == null)   
              this.raiz = raizAtual;
        }                       
        else
        {   //Menor busca esquerda
            if (novoElemento.getValor().compareTo(raizAtual.getValor()) == -1)
                 raizAtual.setEsquerda( adicionarRec(valor, raizAtual.getEsquerda()) );
                   
            //Maior busca direita   
            else 
               raizAtual.setDireita( adicionarRec(valor, raizAtual.getDireita()) );      
        }
        
               
        // retorna para o pai o novo elemento criado, ou o ja existente nessa posição
        return raizAtual; 
    }

  
    
    public String emOrdem(Elemento<TIPO> atual){
        
        if (atual != null){
            return emOrdem(atual.getEsquerda()) + 
                   atual.getValor() + ", " + 
                   emOrdem(atual.getDireita());
        }
        else
            return "";         
    }
    
    public String preOrdem(Elemento<TIPO> atual){
        if (atual != null){
            return atual.getValor()+ ", " + 
                   preOrdem(atual.getEsquerda()) + 
                   preOrdem(atual.getDireita());
        } 
        else
            return "";
    }
    
    public String posOrdem(Elemento<TIPO> atual){
        if (atual != null){
            return posOrdem(atual.getEsquerda()) + 
                   posOrdem(atual.getDireita()) +
                   atual.getValor()+ ", " ;  
        } 
        else
            return "";       
    }
    
    public boolean remover(TIPO valor){
        
        // A) -- Buscar o elemento a remover na árvore (e seu pai) ----------
        
        Elemento<TIPO> atual = this.raiz;  
        Elemento<TIPO> paiAtual = null;
        
        //percorre arvore
        while(atual != null){
            
            // valor procurado é igual - Encontrou elemento [Atual]
            if (atual.getValor().equals(valor)){ 
                break;                
            }
            //valor procurado é menor -> vai para [Esquerda] 
            else if (valor.compareTo(atual.getValor()) == -1){  
                paiAtual = atual;
                atual = atual.getEsquerda();
            }
            //valor procurado é maior -> vai para [Direita] 
            else{     
                paiAtual = atual;
                atual = atual.getDireita();
            }
        } // ao fim atual contem o elemento encontrdo ou null se não encontrado
        
        
        //Elemento a remover encotrado
        if (atual != null){ 
            
            // B) -- Buscar elemento substituto e efetuar a substituição - 3 casos ----------
            
            Elemento<TIPO> eleRemover = atual;    //Elemento a remover 
            Elemento<TIPO> paiRemover = paiAtual; //Pai elemento a remover  
            
            
            //----- 1 CASO - Elemento tem 2 filhos ou tem somente filho à Direita
            //        (Substituo sera  encontrado: Um pulo a Direita, e Esquerda sempre)    
            if (eleRemover.getDireita() != null){
                
                // 1-- Encontrar substituto -------
                
                //Um pulo a direita
                Elemento<TIPO> substituto = eleRemover.getDireita(); // Inicia a direita
                Elemento<TIPO> paiSubstituto = eleRemover;
                char paiAndouPara = 'D';                        // guarda para onde andou 
                
                //Vai para a esquerda até chegar em um que não tenha mais esquerda 
                while(substituto.getEsquerda() != null){
                    paiSubstituto = substituto;
                    substituto = substituto.getEsquerda();
                    paiAndouPara = 'E';                        // guarda para onde andou 
                }
                
                // 2-- Eliminar subsitituto -------
                //jogando o que tem na direita dele(null ou itens) no pai, pois na esquerda não tem nada
                if(paiAndouPara == 'D')   //Vindo da direita do pai (primeiro pulo)
                   paiSubstituto.setDireita(substituto.getDireita());
                
                else                     //Vindo da Esquerda do pai (while pulando a esquerda)
                   paiSubstituto.setEsquerda(substituto.getDireita());
                
                
                // 3-- Substituto pega posição do elemento a remover 
                substituto.setEsquerda(eleRemover.getEsquerda()); //vinclua subarvore esquerda
                substituto.setDireita(eleRemover.getDireita());   //vinclua subarvore direta
                
                // 4-- Pai do elemento a remover direciona para substituto já posicionado
                if (paiRemover != null){
                   
                    //menor - a eliminar está a esquerda do pai ->  (eleRemover < paiRemover)
                    if (eleRemover.getValor().compareTo(paiRemover.getValor()) == -1){ 
                        paiRemover.setEsquerda(substituto);
                    }
                    //maior - a substituir está a direita do pai
                    else{
                        paiRemover.setDireita(substituto);
                    }
                }
                //se não tem paiRemover, então elemento está na raiz
                else{
                    this.raiz = substituto;
                }   
            }
            
            
            //----- 2 CASO - Tem filho só à Esquerda
            //        (Substituo sera  encontrado: Um pulo a Esquerda, e Direita sempre)  
            else if (eleRemover.getEsquerda() != null){ 
               
                // 1-- Encontrar substituto -------   
                
                //Um pulo a esquerda
                Elemento<TIPO> substituto = eleRemover.getEsquerda(); // Inicia a esquerda
                Elemento<TIPO> paiSubstituto = eleRemover;
                char paiAndouPara = 'E';                         // guarda para onde andou
                
                //Vai para a direita até chegar em um que não tenha mais direita 
                while(substituto.getDireita() != null){
                    paiSubstituto = substituto;
                    substituto = substituto.getDireita();
                    paiAndouPara = 'D';                         // guarda para onde andou
                }
                
                // 2-- Eliminar subsitituto -------
                //jogando o que tem na esquerda dele(null ou itens) no pai, pois na direita não tem nada                
                if(paiAndouPara == 'E')     //Vindo da Esquerda do pai (primeiro pulo)
                   paiSubstituto.setEsquerda(substituto.getEsquerda());
                
                else                        //Vindo da Direta do pai (while pulando a direita)
                   paiSubstituto.setDireita(substituto.getEsquerda());
                
                // 3-- Substituto pega posição do elemento a remover 
                substituto.setEsquerda(eleRemover.getEsquerda()); //vinclua subarvore esquerda
                substituto.setDireita(eleRemover.getDireita());   //vinclua subarvore direta - será NULL

                // 4-- Pai do elemento a remover direciona para substituto já posicionado
                if (paiRemover != null){
                    
                    //menor - a eliminar está a esquerda do pai ->  (eleRemover < paiRemover)
                    if (eleRemover.getValor().compareTo(paiRemover.getValor()) == -1){ 
                        paiRemover.setEsquerda(substituto); 
                    }
                    //maior - a substituir está a direita do pai
                    else{
                        paiRemover.setDireita(substituto);
                    }
                }
                //se não tem paiRemover, então elemento está na raiz
                else{ 
                    this.raiz = substituto;
                }

            }
            
            //----- 3 CASO - Elemento Não tem filho
            else if (paiRemover != null){
                
                //menor - a eliminar está a esquerda do pai ->  (eleRemover < paiRemover)
                if (eleRemover.getValor().compareTo(paiRemover.getValor()) == -1){ 
                    paiRemover.setEsquerda(null);
                }
                //maior - a substituir está a direita do pai
                else{ 
                    paiRemover.setDireita(null);
                }
            }
            
            //----- é a raiz unico item
            else{ 
                    this.raiz = null;
            }
            
            return true;   // Remoção efetuada
        }
        
        // Nao existe elemento a remover
        else{ 
            return false;  // Remoção Não efetuada
        }        
    }
}
