package GA;

import java.util.List;
import java.util.Random;

class Mutation{
    double p;

    public Mutation(int p){
        this.p = p; //задает вероятность произведения мутации
    }
    
    public List<Unit> RandomMutation(List<Unit> units, Map map){
       Random random = new Random();
       int gene = 0;

       for(Unit unit: units){
        if(random.nextDouble(0, 100) < p){       //выбор особи для метуции
          gene = random.nextInt(unit.getSize()); //выбор случайного гена для изменения
          unit.setGene(map.getRandomPoint(), gene);
        } 
       }
       return units;
    }

    public List<Unit> RandomPairMutation(List<Unit> units){
        Random random = new Random();
        int gene1 = 0, gene2 = 0;
 
        for(Unit unit: units){
         if(random.nextDouble(0, 100) < p){       //выбор особи для метуции
           gene1 = random.nextInt(unit.getSize()); //выбор случайного гена для изменения
           gene2 = random.nextInt(unit.getSize()); 
          
           Gene gen1 = unit.getGene(gene1); //получение значений генов
           Gene gen2 = unit.getGene(gene2);
          
           unit.setGene(gen1, gene2);   //обмен генов местами
           unit.setGene(gen2, gene1);
         } 
        }
        return units;
    }
}