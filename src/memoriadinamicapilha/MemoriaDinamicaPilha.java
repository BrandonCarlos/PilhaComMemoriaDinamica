package memoriadinamicapilha;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MemoriaDinamicaPilha {

    private Trabalhador trab[];
    private int N;

    public static void main(String[] args) {
        MemoriaDinamicaPilha Pilhas = new MemoriaDinamicaPilha();
    }

    public MemoriaDinamicaPilha() {
        LeituraDeDados();
        //Declarei os métodos abaixo no case 8:   //pois assim que o usúario cadastrar os trabalhadores já mostrar ordenado por Bubble Sort
        /*MostrarTrabalhadoresCadastrados("Trabalhadores sem ordenamento");
        bubbleSortPorNomes(trab);
        MostrarTrabalhadoresCadastrados("Ordenado por BubbleSort");*/
    }

    public void LeituraDeDados() {

        int opcao = 0, tamanho;
        boolean estado = false;
        String nome;
        float salario;
        char sexo;

        Trabalhador tr = new Trabalhador();
        Pilha p = new Pilha();
        do {
            try {
                opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1. Adicionar um elemento na PILHA\n"
                        + "2. Retirar um elemento da PILHA\n"
                        + "3. A PILHA está vazia?\n"
                        + "4. Qual elemento está no topo da PILHA?\n"
                        + "5. Tamanho da PILHA\n"
                        + "6. Mostrar todos os dados da PILHA\n"
                        + "7. Apagar todos os dados da PILHA\n"
                        + "8. Guardar dados no vetor e ordenar por nome\n" +
                          "9. Sair\n" + 
                                "O que deseja fazer?", "Menú de opções", JOptionPane.INFORMATION_MESSAGE));
                switch (opcao) {
                    case 1:
                            //Método dentro do case 1:
                            nome = JOptionPane.showInputDialog(null, "Digite o nome: ", "NOME", JOptionPane.INFORMATION_MESSAGE);
                            salario = Float.parseFloat(JOptionPane.showInputDialog(null, "Digite o salário: ", "SALÁRIO", JOptionPane.INFORMATION_MESSAGE));
                            sexo = JOptionPane.showInputDialog(null, "Digite o sexo: ", "SEXO", JOptionPane.INFORMATION_MESSAGE).charAt(0);
                            p.AdicionarDado(new Trabalhador(nome, salario, sexo));//PILHA
                            tr.AdicionarDados(new Trabalhador(nome, salario, sexo));//VETOR
                                                  
                        break;
                    case 2:
                        if (!p.EstaVazio()) {
                            JOptionPane.showMessageDialog(null, "O elemento a ser retirado é: " + p.RetirarDado(), "RETIRANDO DADO", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "A PILHA está vazia", "PILHA VAZIA", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 3:
                        if (!p.EstaVazio()) {
                            JOptionPane.showMessageDialog(null, "Não, a PILHA contem dados dos trabalhadores", "PILHA TEM DADOS DOS TRABALHADORES", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Sim, a PILHA está vazia");
                        }
                        break;
                    case 4:
                        if (!p.EstaVazio()) {
                            JOptionPane.showMessageDialog(null, "O elemento que está no topo da PILHA é: " + p.topo(), "ELEMENTO NO TOPO DA PILHA", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "A PILHA está vazia");
                        }
                        break;
                    case 5:
                        if (!p.EstaVazio()) {
                            JOptionPane.showMessageDialog(null, "O tamanho da PILHA é: " + p.TamanhoDaPilha(), "TAMANHO DA PILHA", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "A PILHA está vazia");
                        }
                        break;
                    case 6:
                        if(!p.EstaVazio()){
                            p.MostrarDados();
                        }else JOptionPane.showMessageDialog(null, "A PILHA não tem dados");
                        
                        break;
                    case 7:
                        if (!p.EstaVazio()) {
                            JOptionPane.showMessageDialog(null, "Esvaziando a PILHA... " + p.EsvaziarPilha(), "PILHA VAZIA", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "A PILHA está vazia");
                        }
                        break;
                    case 8:
                        N = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade de trabalhadores: ", "TRABALHADORES", JOptionPane.INFORMATION_MESSAGE));
                        trab = new Trabalhador[N];
                        
                        for(int i = 0; i < N; i++){
                            nome = JOptionPane.showInputDialog(null, "Digite o nome: ", "NOME DO TRABALHADOR", JOptionPane.INFORMATION_MESSAGE);
                            salario = Float.parseFloat(JOptionPane.showInputDialog(null, "Digite o salário: ", "SALÁRIO", JOptionPane.INFORMATION_MESSAGE));
                            sexo = JOptionPane.showInputDialog(null, "Digite o sexo: ", "SEXO", JOptionPane.INFORMATION_MESSAGE).charAt(0);
                            trab[i] = new Trabalhador(nome, salario, sexo);
                        }
                        MostrarTrabalhadoresCadastrados("Nomes sem Ordenação.");
                        bubbleSortPorNomes(trab);//ordenando com BubbleSort
                        MostrarTrabalhadoresCadastrados("Ordenado por BubbleSort.");                        
                        break; 
                    case 9:
                        JOptionPane.showMessageDialog(null, "Encerrando a aplicação");                    
                }
            } catch (NumberFormatException n) {
                JOptionPane.showMessageDialog(null, "Error " + n.getMessage());
            }
        } while (opcao != 9);

    }

    public boolean bubbleSortPorNomes(Trabalhador vetor[]) {
        // Este método ordena um vetor de objetos Trabalhador trab[]
        // em ordem crescente pelo atributo nome       
        if (vetor == null) {
            return false;
        }
        boolean trocou;
        int i = 0;
        do {
            trocou = false;
            for (int j = 0; j < vetor.length - 1 - i; j++) {
                if (vetor[j].getNome().compareToIgnoreCase(vetor[j + 1].getNome()) > 0) {
                    Trabalhador tmp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = tmp;
                    trocou = true;
                }
            }
            i++;
        } while (trocou);
        return true;
    }
    
    public void MostrarTrabalhadoresCadastrados(String texto){
        String cad = "";
        for(int i = 0; i < trab.length; i++){
            cad += trab[i].toString() + "\n";      
        }
        JTextArea outputArea = new JTextArea(15, 40);  //dois parametros, o 1° e para altura, 2° é para largura;
        outputArea.setText(cad);//"cad", ou seja quero mostre nesse JTextArea o "cad"
        JScrollPane rolagem = new JScrollPane(outputArea);//JScrollPane é para ter aquela barrinha de "rolagem" JScrollPane rolagem = new JScrollPane(outputArea), pronto rolagem agora tem vinculo com o outputArea = "cad"
        JOptionPane.showMessageDialog(null, rolagem, texto,//"texto" está vinculado com o parãmetro texto acima = String texto;
                JOptionPane.INFORMATION_MESSAGE);
    }
    
}
