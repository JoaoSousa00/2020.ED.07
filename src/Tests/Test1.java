package Tests;

import Uses.Car;
import SearchingInArray.Searchs;
import SearchingInArray.Sorts;
import Uses.DoubleLinkedList;
import Uses.LinkedList;
import java.util.Scanner;

/**
 * <h3>
 * ESTG - Escola Superior de Tecnologia e Gestão<br>
 * IPP - Instituto Politécnico do Porto<br>
 * LEI - Licenciatura em Engenharia Informática<br>
 * PP - Paradigmas de Programação<br>
 * </h3>
 * <p>
 * <strong>Author: </strong><br>
 * Joao Sousa<br>
 * <strong>Description: </strong><br>
 *
 * </p>
 */
public class Test1 {

    public static void main(String[] args) {

        long tempoInicial;

        Car[] cars = new Car[6];
        cars[0] = new Car("2Fiesta", "Michelin", (short) 1999, (short) 11, 8000);
        cars[1] = new Car("3Clio", "Michelin", (short) 2000, (short) 10, 8900);
        cars[2] = new Car("1Toyota", "Continental", (short) 1999, (short) 7, 4000);
        cars[3] = new Car("5Mazda X30", "Michelin", (short) 1999, (short) 4, 32000);
        cars[4] = new Car("6Tesla Ta fixe", "Michelin", (short) 2004, (short) 2, 78000);
        cars[5] = new Car("4Ford", "Michelin", (short) 1999, (short) 12, 28000);

        LinkedList CarsList = new LinkedList();
        for (int i = 0; i < cars.length; i++) {
            CarsList.add(cars[i]);
        }

        DoubleLinkedList CarsDoubleList = new DoubleLinkedList();
        for (int i = 0; i < cars.length; i++) {
            CarsDoubleList.add(cars[i]);
        }

        Searchs search = new Searchs();

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nTestes Disponiveis:\nTeste 1 - Exercicio 1\nTeste 2 - Exercicio 2\nTeste3 - Exercicio 3\n\nQue Teste pretende efetuar:");
        int a = scanner.nextInt(4); //Aceita só até 3

        switch (a) {
            case 1:
                System.out.println("LinearSearch:");
                System.out.println("Carro: Fiesta | Valor: 8000 | Na lista: " + search.linearSearch(cars, 0, 0, cars[0]));
                System.out.println("Carro: BMW | Valor: 56000 | Na lista: " + search.linearSearch(cars, 0, 0, new Car("BMW", "Arames", (short) 1900, (short) 12, 56000)));

                System.out.println("\nBinarySearch:");
                System.out.println("Carro: Fiesta | Valor: 8000 | Na lista: " + search.binarySearch(cars, 0, 0, cars[0]));
                System.out.println("Carro: BMW | Valor: 56000 | Na lista: " + search.binarySearch(cars, 0, 0, new Car("BMW", "Arames", (short) 1900, (short) 12, 56000)));
                break;
            case 2:
                System.out.println("LinearSearch:");
                System.out.println("Carro: Fiesta | Valor: 8000 | Na lista: " + search.linearSearchInLinkedList(CarsList, cars[0]));
                System.out.println("Carro: BMW | Valor: 56000 | Na lista: " + search.linearSearchInLinkedList(CarsList, new Car("BMW", "Arames", (short) 1900, (short) 12, 56000)));

                System.out.println("\nBinarySearch:");
                System.out.println("Carro: Fiesta | Valor: 8000 | Na lista: " + search.linearSearchInLinkedList(CarsList, cars[0]));
                System.out.println("Carro: BMW | Valor: 56000 | Na lista: " + search.linearSearchInLinkedList(CarsList, new Car("BMW", "Arames", (short) 1900, (short) 12, 56000)));
                break;
            case 3:
                System.out.println("\nMétodos Disponiveis:\nMétodo 1 - Selection Sort\nMétodo 2 - Insertion Sort\nMétodo 3 - Bubble Sort\nMétodo 4 - Quick Sort\nMétodo 5 - Merge Sort\n\nQue método pretende executar:");
                int b = scanner.nextInt(6);
                switch (b) {
                    case 1:
                        for (Car car : cars) {
                            System.out.println(car.getModel());
                        }
                        tempoInicial = System.currentTimeMillis();
                        Sorts.selectionSort(cars);
                        System.out.println("O método executou em " + (System.currentTimeMillis() - tempoInicial));
                        for (Car car : cars) {
                            System.out.println(car.getModel());
                        }
                        break;
                    case 2:
                        for (Car car : cars) {
                            System.out.println(car.getModel());
                        }
                        tempoInicial = System.currentTimeMillis();
                        Sorts.insertionSort(cars);
                        System.out.println("O método executou em " + (System.currentTimeMillis() - tempoInicial));
                        for (Car car : cars) {
                            System.out.println(car.getModel());
                        }
                        break;
                    case 3:
                        for (Car car : cars) {
                            System.out.println(car.getModel());
                        }
                        tempoInicial = System.currentTimeMillis();
                        Sorts.bubbleSort(cars);
                        System.out.println("O método executou em " + (System.currentTimeMillis() - tempoInicial));
                        for (Car car : cars) {
                            System.out.println(car.getModel());
                        }
                        break;
                    case 4:
                        for (Car car : cars) {
                            System.out.println(car.getModel());
                        }
                        tempoInicial = System.currentTimeMillis();
                        Sorts.quickSort(cars, 0, cars.length - 1);
                        System.out.println("O método executou em " + (System.currentTimeMillis() - tempoInicial));
                        for (Car car : cars) {
                            System.out.println(car.getModel());
                        }
                        break;
                    case 5:
                        for (Car car : cars) {
                            System.out.println(car.getModel());
                        }
                        tempoInicial = System.currentTimeMillis();
                        Sorts.mergeSort(cars, 0, cars.length - 1);
                        System.out.println("O método executou em " + (System.currentTimeMillis() - tempoInicial));
                        for (Car car : cars) {
                            System.out.println(car.getModel());
                        }
                        break;
                }
        }

    }

}
