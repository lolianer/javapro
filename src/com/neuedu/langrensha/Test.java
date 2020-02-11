package com.neuedu.langrensha;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("请输入游玩人数：");
        int nuper = s.nextByte();
        List<Person> people = initPeople(nuper);
        int nupai = nuper+3;
        List<Pai> pais = sort(nupai);
        List<Pai> dipais =xipai(pais);
        System.out.println("玩家手牌为：");
        faPai(people,pais);
        System.out.println("盗贼底牌为：");
        print(dipais);
    }
    public static List sort(int nupai){
        List<Pai> pais = new ArrayList<>();

        for (int j = 0; j<4;j++){
            pais.add(new Pai("狼人"));
        }
        for (int j = 0; j<4;j++){
            pais.add(new Pai("村民"));
        }
        pais.add(new Pai("预言家"));
        pais.add(new Pai("女巫"));
        pais.add(new Pai("丘比特"));
        pais.add(new Pai("守护"));
        pais.add(new Pai("猎人"));
        pais.add(new Pai("村长"));
        pais.add(new Pai("盗贼"));
        if (nupai >= 16){
            pais.add(new Pai("村民"));
        }
        if (nupai >= 17){
            pais.add(new Pai("替罪羊"));
        }
        if (nupai >= 18){
            pais.add(new Pai("狼人"));
        }
        if (nupai >= 19){
            pais.add(new Pai("村民"));
        }
        if (nupai >= 20){
            pais.add(new Pai("村民"));
        }
        if (nupai >= 21){
            pais.add(new Pai("吹笛者"));
        }

        return pais;
    }
    public static void print(List pais){
        System.out.print("{");
        for (int i = 0; i < pais.size();i++){

            System.out.print((i+1)+":");
            System.out.print(pais.get(i)+", ");

        }
        System.out.println("}");
    }
    public static List xipai(List<Pai> pais){
        List<Pai> dipais = new ArrayList<>();
        Collections.shuffle(pais);
        Collections.shuffle(pais);
        Collections.shuffle(pais);
        Collections.shuffle(pais);
        int nudipai = 0;
        int nulangren = 0;
        for (int i = 0; i < pais.size(); i++){
            if (!pais.get(i).toString().equals("盗贼")){
                if (pais.get(i).toString().equals("狼人")){
                    if (nulangren == 1){
                        continue;
                    }
                    Pai a= pais.get(i);
                    dipais.add(a);
                    pais.remove(i);
                    nulangren++;
                }else {
                    Pai a= pais.get(i);
                    dipais.add(a);
                    pais.remove(i);
                }
            }else {
                continue;
            }
            if (dipais.size() == 3){
                break;
            };

        }
        return dipais;
    }
    public static List initPeople(int nuper){
        List<Person> people = new ArrayList<>();
        for (int i = 1; i <= nuper; i++){
            people.add(new Person(i));
        }
        return people;
    }
    public static void faPai(List<Person> people,List<Pai> pais){
        System.out.print("{");
        for (int i =0; i < people.size();i++){
            people.get(i).setPai(pais.get(i).toString());

            System.out.print(people.get(i).getNo()+":"+people.get(i).getPai()+", ");

        }
        System.out.print("}");
        System.out.println();
    }

}
