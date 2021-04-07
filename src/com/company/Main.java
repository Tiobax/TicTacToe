package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        var taskTic = new Tic();
        var taskTac = new Tac();
        var taskToe = new Toe();

        taskTic.getThread().join();
        taskTac.getThread().join();
        taskToe.getThread().join();

        System.out.println("Программа TicTacToe выполена успешно");
    }
}
