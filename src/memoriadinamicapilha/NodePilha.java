package memoriadinamicapilha;
public class NodePilha {
    Object dado;
    NodePilha seguinte;
    
    public NodePilha(Object d){
        dado = d;
        seguinte = null;
    }
}
