package memoriadinamicapilha;

import javax.swing.JOptionPane;

public class Pilha {
    private NodePilha topo;
    int tamanho;//tamanho da pilha
    String Lista = "";
    
    public Pilha(){
        topo = null;
        tamanho = 0;
    }
    
    //Método para saber quando a pilha está vazia
    public boolean EstaVazio(){
        return topo == null;
    }
    
    //Método para adicionar(PUSH) um elemento na PILHA;
    public void AdicionarDado(Object elem){
        NodePilha novo = new NodePilha(elem);
        novo.seguinte = topo;
        topo = novo;
        tamanho++;
    }
    
    //Método para retirar um elemento da pilha
    public Object RetirarDado(){
        Object auxiliar = topo.dado;
        topo = topo.seguinte;
        tamanho--;
        return auxiliar;
    }
    
    //Método para saber qual é o elemento que está no tipo da PILHA
    public Object topo(){
        return topo.dado;
    }
    
    //método para saber o tamanho da PILHA;
    public int TamanhoDaPilha(){
        return tamanho;
    }
    
    //Método para esvaziar a PILHA
    public Object EsvaziarPilha(){
        return topo = null;

    }
    
    public void MostrarDados(){
        NodePilha pegar = topo;
        
        while(pegar != null){
            Lista += pegar.dado + "\n";
            pegar = pegar.seguinte;
        }
        JOptionPane.showMessageDialog(null, Lista);
        Lista = "";
    }
}
