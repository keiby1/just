package GA;

import java.util.List;

class Fitness{

    /**
     * Возвращает среднее значение фитнесс-функции
     */
    public static double getAwgFitness(List<Unit> units) {
        double sum = 0;
        
        for(Unit unit : units){
            sum += unit.getFitness();
        }

        return sum/units.size();
    }

    public List<Unit> calcFitnessTime(List<Unit> units, Map map){
        double way = 0;
        double time = 0, v = 0, p = 0;
        int h = unit.getHromosome().size();
        Gene lastGene = unit.getGene(0);

        for(Unit unit : units){
            for(Gene gen : unit.getHromosome()){
                way = gen.getWay();
                v = map.getVelocity(gen, lastGene);
                p = calcPenalty(map.getTrafficJam(), gen, lastGene);
                time += way/(v-p);

                lastGene = gen;
            }
            unit.setFitness((h*1000)/t);
        }
        return units;
    }

    public List<Unit> calcFitnessWay(List<Unit> units, Map map){
        double f =0, way = 0;
        int h = unit.getHromosome().size();

        for(Unit unit : units){
            for(Gene gen : unit.getHromosome()){
                way += gen.getWay();
            }
            unit.setFitness((h*1000)/way);
        }
return units;
    }
}
