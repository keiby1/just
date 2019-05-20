package GA;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

class Cross{

    /**
     * Скрещивание лучших особей.
     * Создается список родителей имеющих достаточно высокое значение фитнесс-функции.
     * Случайным образом выбираются пары особей из этого списка. 
     * В каждой выбранной паре выбирается точка пересечения, создаются дочении особи состоящие из объединения хромосом родителей в точке пересечения.
     * 
     * Пример:
     * АААА|АААА    ->  AAAA|BBBB
     * BBBB|BBBB    ->  BBBB|AAAA
     */
    public List<Unit> crossBestPair(List<Unit> units, int limit) {
        List<Unit> newList = new LinkedList<>();
        List<Unit> parent = new LinkedList<>();
        Random rand = new Random();
        int ind1 = 0, ind2 = 0, size = 0;

        double awgFitness = Fitness.getAwgFitness(units);

        for(Unit unit : units){
            if(unit.getFitness() > awgFitness)
               parent.add(unit);
        }

        size = parent.size();

        for(int i =0; i < limit; i++){
            ind1 = rand.nextInt(size);
            ind2 = rand.nextInt(size);

            if(ind1 != ind2){
                newList.addAll(create(parent.get(ind1), parent.get(ind2)));
            }
            else limit++;
        }

        newList.addAll(parent);
        return newList;
    }

    /**
     * Создает новые особи на основе раодительских.
     */
    private List<Unit> create(Unit un1, Unit un2) {
        Random rand = new Random();
        List<Unit> newUnit = new LinkedList<>();
        int ind = rand.nextInt((int)un1.getSize()/2, un1.getSize()); //создание границы, выше середины хромосомы

        LinkedList<Gene> g1 = un1.getHromosome();    //получение хромосомы 1 родителя
        LinkedList<Gene> g2 = un2.getHromosome();    //получение хромосомы 2 родителя
        LinkedList<Gene> g3 = un1.getHromosome();    //запись в первого ребенка хромосомы 1 родителя
        LinkedList<Gene> g4 = un2.getHromosome();    //запись во второго ребенка хромосомы 2 родителя

        for(int i = 0; i < ind; i++){   //замена в хромосомах дочерних особей, генов после границы
            g3.set(i, g2.get(i));
            g4.set(i, g1.get(i));
        }

        newUnit.add(new Unit(g3));  //создание особей из хромосом, и добавление в спсок
        newUnit.add(new Unit(g4));

        return newUnit;
    }

    /**
     * Скрещивание всех особей.
     * Алгоритм аналогичен скрещиванию лучших особей, за исключением ограничения на значение фитнесс-финкции
     */
    public List<Unit> crossRandPair(List<Unit> units, int limit){
        List<Unit> newList = new LinkedList<>();
        Random rand = new Random();
        int ind1 = 0, ind2 = 0, size = units.size();

        for(int i =0; i < limit; i++){
            ind1 = rand.nextInt(size);
            ind2 = rand.nextInt(size);

            if(ind1 != ind2){
                newList.addAll(create(units.get(ind1), units.get(ind2)));
            }
            else limit++;
        }

        newList.addAll(units);
        return newList;
    }
}