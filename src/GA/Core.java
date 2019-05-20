package GA;

import java.util.LinkedList;
import java.util.List;

class Core{
    private List<Unit> units;
    private Map map;

    private void Start() {
        units = new LinkedList<>();
    }
/**
 * type - тип селекции
 * limit - ограничение на количество особей
 */
    private void Selection(int type, int limit) {
        Selection selection = new Selection();

        switch(type){
            case 1:
            units = selection.Tournament(units);
            break;

            case 2:
            units = selection.Roulette(units, limit);
            break;
            default:
            units = selection.Tournament(units);
            break;
        }
    }

    private void Cross(int type, int limit) {
        Cross cross = new Cross();

        switch (type) {
            case 0:
               units = cross.crossBestPair(units, limit);
                break;
            case 1:
                units = cross.crossRandPair(units, limit);
                break;
            default:
            units = cross.crossBestPair(units, limit);
                break;
        }
    }
    
    /**
     * type - вид мутации
     * p - вероятность мутации
     */
    private void Mutation(int type, int p) {
        Mutation mutation = new Mutation(p);

        switch (type) {
            case 1:
                units = mutation.RandomMutation(units, map);
                break;
            case 2:
                units = mutation.RandomPairMutation(units);
                break;
            default:  
                units = mutation.RandomMutation(units, map);
                break;
        }
    }

    private void Fitness(int type) {
       
    }
}