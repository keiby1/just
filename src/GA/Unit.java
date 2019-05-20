package GA;

import java.util.LinkedList;
import java.util.List;

class Unit {
    private int id;
    private double fitness;
    private LinkedList<Gene> hromosome;
    private int time;
    private int size;


    public Unit() {
        hromosome = new LinkedList<>();
        time = 0;
    }

    public Unit(int i) {
        id = i;
        hromosome = new LinkedList<>();
        time = 0;
    }

    public Unit(LinkedList<Gene> g3) {
        hromosome = g3;
    }

    public int getSizeHr() {
        return hromosome.size();
    }

    public void setGene(Point point, int ind) {
        hromosome.set(ind, new Gene(point));
    }

    public Gene getGene(int ind) {
        return hromosome.get(ind);
    }

    public double getFitness() {
        return fitness;
    }

    public int getSize() {
        return size;
    }

    public LinkedList<Gene> getHromosome() {
        return hromosome;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

}