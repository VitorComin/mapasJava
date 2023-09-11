//Testes - Comentar o resto para testar uma parte
public class MapaTest {
    public static void main(String[] args) {
        Mapa<String, Integer> mapa = new Mapa<>();

        //Teste put para adicionar
        mapa.put("quatro", 4);
        mapa.put("oito", 8);
        mapa.put("um", 1);

        //Teste de get para mostrar
        System.out.println("quatro: " + mapa.get("quatro"));
        System.out.println("oito: " + mapa.get("oito"));
        System.out.println("um: " + mapa.get("um"));

        //Teste para remover
        mapa.remover("um");
        System.out.println("um: " + mapa.get("um"));
    }
}