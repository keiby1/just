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

    public void calcFitnessTime(List<Unit> units, Map map){
        double f =0, way = 0;
        int time = 0;

        for(Unit unit : units){
            for(Gene gen : unit.getHromosome()){
                way += gen.getWay();
            }
            unit.setFitness((unit.getHromosome().size()/way)*1000);
        }
    }

    public void calcFitnessWay(List<Unit> units, Map map){
        double f =0, time = 0;
        int time = 0;
       
        for(Unit unit : units){
            for(Gene gen : unit.getHromosome()){
                time += gen.getTime();
            }
            unit.setFitness((unit.getHromosome().size()/time)*1000);
        }

    }
}