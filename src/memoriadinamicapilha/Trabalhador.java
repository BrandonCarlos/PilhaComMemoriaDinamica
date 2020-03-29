package memoriadinamicapilha;

public class Trabalhador {

    private String nome;
    private float salario;
    private char sexo;
    
    private NodePilha topo;
    int tamanho;//tamanho da pilha

    public Trabalhador() {

    }

    public Trabalhador(String nome, float salario, char sexo) {
        this.nome = nome;
        this.salario = salario;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    
    public void AdicionarDados(Object elem){
        NodePilha nuevo = new NodePilha(elem);
        nuevo.seguinte = topo;
        topo = nuevo;
        tamanho++;
    }
    
    public void MostrarVetor(Object [] vetor){
        int k;
        for(k = 0; k < vetor.length; k++){
            System.out.println("[" + vetor[k] + "]");
        }
        System.out.println();
    }
    
    @Override
    public String toString() {
        return "nome=" + nome + ", salario=" + salario + ", sexo=" + sexo;
    }
    
    

}
