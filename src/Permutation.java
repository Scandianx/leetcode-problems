import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) throws Exception {

        Solution solution = new Solution();
        final int[] numeros = { 1, 2, 3 };
        List<List<Integer>> listaFinal = solution.permute(numeros);
        System.out.print("[");
        for (List<Integer> l : listaFinal) {
            System.out.print("[");
            for (Integer i : l) {
                System.out.print(i + " ");
            }
            System.out.print("]");
        }
        System.out.print("]");
    }

    public static class Solution {
        public List<List<Integer>> permute(int[] nums) {
            int tamanho = nums.length;
            List<List<Integer>> resposta = new ArrayList<>();
            List<Integer> dado = new ArrayList<>();
            int fatorial = fatorial(tamanho);
            int divisor = fatorial / tamanho;
            for (int i = 0; i < fatorial; i++) {
                dado = new ArrayList<>();
                for (int c = 0; c < tamanho; c++) {
                    for (int z = 0; z < tamanho; z++) {
                        if (possoInserir(resposta, dado, nums[c], divisor, z)) {
                            dado.add(nums[c]);
                        }
                    }
                }
                resposta.add(dado);
            }
            return resposta;

        }
        public void iterador(List<Integer> l) {
            System.out.print("[");
            for(Integer i: l) {
                  
                System.out.print(i);
            }
            System.out.print("]");
        }

        public int fatorial(int valor) {
            if (valor == 0 || valor == 1) {
                return 1;
            }
            return valor * fatorial(valor - 1);
        }

        public boolean possoInserir(List<List<Integer>> lista, List<Integer> dado, int num, int divisor, int posicao) {
            int achouNum = 0;
            for (int i = 0; i < lista.size(); i++) {
                List<Integer> listaInterna = lista.get(i);
                for (int j = 0; j < listaInterna.size(); j++) {
                    if (listaInterna.get(j) == num && j == posicao) {
                        System.out.println("Debug pode inserir: " + posicao + " Numero: " + num); 
                        iterador(dado);
                        achouNum++;
                    }
                }
            }
            for (Integer d: dado) {
                if (d==num) {
                    return false;
                }
            }
            return achouNum >= divisor ? false : true;
        }
    }

}
