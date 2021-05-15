package com.company;


import java.util.*;

public class Main {


    // Створіть наступну модель: є зоопарк. Повинна бути можливість помістити у зоопарку різні типи
    // істот, при цьому ми повинні враховувати що певні типи істот потребують особливих умов(риби тільки у воді, тому риб не можемо помістити у звичайний вольєр).
    // Ми не можемо розмістити істот- антагоністів(лева та віслюка наприклад) у одній клітці, кожна комірка має обмеження щодо кількості істот
    // які можуть в ній знаходитись одночасно. Є можливість отримати звіт по  істотам,які живуть у зоопарку. Для кожного типу тварин відома ціна добового  раціону,
    // Необхідно мати можливість розрахувати кошторис за період щодо харчування питомців установи.


}
enum Environment{
    Forest,
    Ocean,
    Desert,
    River
}
class Cage implements Comparable<Animal>{
    Set<TypeofAnimal> animals = new TreeSet<TypeofAnimal>();
    List<Animal>animalsInCage=new ArrayList<>();
    Environment environment;
    float size;
    int number;
    static int numberOfCage;

    public int compareTo(Animal an1){
        return an1.type.compareTo(an1.getType());
    }
    public Cage(Environment environment, float size) {
        this.environment = environment;
        this.size = size;
        numberOfCage++;
        this.number=numberOfCage;
    }
    boolean addAnimalToCage(Animal an){
        if(animalsInCage.size()==0){
            for (var tempAnimalEnvironment:an.type.getEnvironment()) {
                if(tempAnimalEnvironment.equals(environment)){
                    animals.add(an.type);
                    return animalsInCage.add(an);
                }
            }
            return true;
        }
        if(animalsInCage.size() < size) {
            for (var tempAnimal : animalsInCage) {
                if (tempAnimal.equals(an)) {
                    return false;
                }
                if (tempAnimal.type.equals(an.type)) {
                    for (var tempAnimalEnvironment : an.type.getEnvironment()) {
                        if (tempAnimalEnvironment.equals(environment)) {
                            return animalsInCage.add(an);
                        }
                    }

                } else {
                    System.out.println("Неможливо додати тварину цього типу");
                }
            }
        }
        else {
            System.out.println("Вольєр заповнений на максимум");
        }
        return false;
    }
    void giveInformation(){
        System.out.println("Animals in cage:");
        for (var tempAnimals:animalsInCage) {
            System.out.println("Name: "+tempAnimals.name + " "+ "Type:"+tempAnimals.type + " " + "Price of eating per day:"+" "+tempAnimals.type.getPriceOfPerDay() + ".");
        }
        System.out.println("Number of cage : "+number+ " "+"Environment:"+environment);
    }


}
class Animal  {
    String name;
    TypeofAnimal type;

    TypeofAnimal getType(){return type;}

    Animal(TypeofAnimal type){
        this.type=type;
    }
    void addName(String name){
        this.name=name;
    }
}
enum TypeofAnimal{
    Lion("Predator",new Environment[]{Environment.Forest,Environment.Desert},100),
    Wolf("Predator",new Environment[]{Environment.Forest,Environment.Forest},50),
    Elephant("Plant-eating",new Environment[]{Environment.Desert},200),
    Rabbit("Plant-eating",new Environment[]{Environment.Forest},20),
    Shark("Predator",new Environment[]{Environment.Ocean},150),
    Piranha("Predator",new Environment[]{Environment.River},100),
    Eagle("Predator",new Environment[]{Environment.Desert},80);

    private String type;
    private Environment[]environments;
    private int priceOfPerDay;
    TypeofAnimal(String type,Environment[]environments,int priceOfPerDay){
        this.priceOfPerDay=priceOfPerDay;
        this.type = type;
        this.environments=environments;
    }
    //public String getType(){ return type;}

    public Environment []getEnvironment(){ return environments;}

    public int getPriceOfPerDay(){return priceOfPerDay;}
}
class Zoo{
    List<Cage> cages = new ArrayList<Cage>();
    boolean addCage(Cage cage){
        return cages.add(cage);
    }
    public static void main(String[] args) {
        Cage cage1=new Cage(Environment.Forest,2);
        Cage cage2=new Cage(Environment.River,20);
        Cage cage3=new Cage(Environment.Ocean,50);
        Cage cage4=new Cage(Environment.Desert,160);
        Cage cage5=new Cage(Environment.Desert,80);
        Cage cage6=new Cage(Environment.Desert,280);
        Cage cage7=new Cage(Environment.Ocean,50);
        Animal Wolf = new Animal(TypeofAnimal.Wolf);
        Wolf.addName("Луна");
        cage1.addAnimalToCage(Wolf);
        Animal Wolf1 = new Animal(TypeofAnimal.Wolf);
        cage1.addAnimalToCage(Wolf1);
        Animal Wolf2 = new Animal(TypeofAnimal.Wolf);
        cage1.addAnimalToCage(Wolf2);
        Animal Wolf3 = new Animal(TypeofAnimal.Wolf);
        cage1.addAnimalToCage(Wolf3);
        Animal Wolf4 = new Animal(TypeofAnimal.Wolf);
        cage1.addAnimalToCage(Wolf4);
        Animal Wolf5 = new Animal(TypeofAnimal.Wolf);
        cage1.addAnimalToCage(Wolf5);
        cage1.giveInformation();
        Animal Rabbit = new Animal(TypeofAnimal.Rabbit);
        Rabbit.addName("Сайрекс");
        cage1.addAnimalToCage(Rabbit);
        Animal Piranha = new Animal(TypeofAnimal.Piranha);
        cage2.addAnimalToCage(Piranha);
        cage2.giveInformation();

        Animal Shark = new Animal(TypeofAnimal.Shark);
        Shark.addName("Баг");
        cage3.addAnimalToCage(Shark);
        cage3.giveInformation();

        Animal Lion = new Animal(TypeofAnimal.Lion);
        Lion.addName("Кинг");
        cage4.addAnimalToCage(Lion);
        cage4.giveInformation();

        Animal Eagle = new Animal(TypeofAnimal.Eagle);
        cage5.addAnimalToCage(Eagle);
        cage5.giveInformation();

        Animal Elephant = new Animal(TypeofAnimal.Elephant);
        Elephant.addName("Элиот");
        cage6.addAnimalToCage(Elephant);
        cage6.giveInformation();

       Animal Rabbit1 = new Animal(TypeofAnimal.Rabbit);
       cage7.addAnimalToCage(Rabbit1);
       cage7.giveInformation();
    }
}
