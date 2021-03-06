package br.com.rfaengines.timedeferro_app.factory;

import java.util.List;

import br.com.rfaengines.timedeferro_app.dto.personagem.HeroiDTO;
import br.com.rfaengines.timedeferro_app.gameplay.Sistema;
import br.com.rfaengines.timedeferro_app.util.Sortear;

public class HeroiFactory {

    private HeroiFactory(){}

    public static List<HeroiDTO> distribuirPontosDeAtributos(List<HeroiDTO>  herois){
        for (int i=0; i < herois.size();i++) {
            herois.get(i).getHabilidades().get(0).setValor(Sortear.num(1, Sistema.HABILIDADE_MAXIMO) + Sistema.HABILIDADE_BONUS);
            herois.get(i).getHabilidades().get(0).setFezHabilidade(false);
            herois.get(i).getHabilidades().get(1).setValor(Sortear.num(1, Sistema.HABILIDADE_MAXIMO) + Sistema.HABILIDADE_BONUS);
            herois.get(i).getHabilidades().get(1).setFezHabilidade(false);
            herois.get(i).setEnergia(Sistema.ENERGIA_MAXIMO);
            herois.get(i).setSorte(Sortear.num(1, Sistema.SORTE_MAXIMO));
            herois.get(i).getEspecial().setValor(Sistema.ESPECIAL_INICIAL);
            herois.get(i).getEspecial().setFezHabilidade(false);
        }
        return herois;
    }

}
