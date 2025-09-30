
package trabalhoQuaseTudoGostoso;

import java.util.ArrayList;
import java.util.List;

public class Preparo {
    Float tempo;
    
    private List<String> passos = new ArrayList<>();

    public void adicionarPasso(String passo) {
        if (passo != null && !passo.trim().isEmpty())
            passos.add(passo.trim());
    }

    public List<String> getPassos() {
        return passos;
    }

     public Float getTitulo() {
        return tempo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < passos.size(); i++) {
            sb.append(String.format("%02d. %s%n", i + 1, passos.get(i)));
        }
        return sb.toString();
    }
}
