package GA;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

class Selection{

    /**
     * Турнирный отбор
     * 
     * Из старой популяции попарно выбираются особи, внутри пары выбирается наилучшая особь,
     * которая проходит в следующее поколение.
     * 
     * units - старая популяция
     * return - новая популяция
     */
    public List<Unit> Tournament(List<Unit> units) {
        Random random = new Random();
        List<Unit> newUnits = new LinkedList<>();   //список особей проходящих в новое поколение
        Unit un1 = null, un2=null;
        int size =0;

        while ((size = units.size()) > 1) {        //до тех пор пока в начальной популяции остались особи
            un1 = units.getUnit(random.nextInt(size)); //получение случайной особи
            units.remove(un1);                      //удалиени из старой популяции

            un2 = units.getUnit(random.nextInt(size));
            units.remove(un2);

            if(un1.getFitness() > un2.getFitness()){  //выбор особи проходящей в следующую популяцию в зависимости от значения фитнесс-функции
                newUnits.add(un1);
            }
            else if(un1.getFitness() == un2.getFitness()){
                newUnits.add(un1);
                newUnits.add(un2);
            }
            else{
                newUnits.add(un2);
            }
            
            return newUnits;
        }

    
        }
    }
    
    /**
     * Метод выбора рулеткой.
     * Создается список с номерами особей, в котором одна и таже особь повторяется чаще в зависимости от значения фитнесс-функции,
     * из списка отбирается заданное количество особей. После выбора особи из списка, она и ее дуюликаты удаляются
     */
    public List<Unit> Roulette(List<Unit> units, int limit){
        List<Unit> newUnits = new LinkedList<>();
        List<Int> listRand = new LinkedList<>();
        Random random = new Random();
        int ind = 0;

        listRand = prepare(units);
        

        for(int i =0; i < limit; i++){
            ind = random.nextInt(listRand.size());

            newUnits.add(units.get(ind));
            listRand = remove(listRand, ind);
        }

        return newUnits;
    }

    /**
     * Создает список особей, в котором каждая особь встречается чаще либо реже, 
     * в зависимости от значения фитнесс-функции
     */
    private List<Int> prepare(List<Unit> units) {
        List<Int> listInt = new LinkedList<>();
        int count = 0;

        for(int i = 0; i < units.size(); i++){
            count = units.get(i).getFitnessInt();
            for(int j =0; j < count; j++){
                listInt.add(i);
            }
        }        
        return listInt;
    }

    /**
     * Удаляет из списка особь и ее дубликаты, после того как она была выбрана
     */
    private List<Int> remove(List<Int> list, int val){
        for(int i : list){
            if(i == val){
                list.remove(i);
            }
        }
        return list;
    }
}