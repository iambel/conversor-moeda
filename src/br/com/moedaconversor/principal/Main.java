package br.com.moedaconversor.principal;
import br.com.moedaconversor.modelo.Conversor;
import br.com.moedaconversor.modelo.ConversorRecord;
import br.com.moedaconversor.modelo.Metodos;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Metodos metodo = new Metodos();
        String op;
        Double valor = 0.0;
        String moeda = "";
        String moeda_base = "";
        Conversor conversor = new Conversor();
        while (true) {
        System.out.println("\nCONVERSÃO\n1 - USD >> BRL\n2 - BRL >> ARS\n3 - USD >> CAD\n4 - CAD >> BRL\n5 - RUB >> BRL\n6 - EUR >> BRL\n7 - Encerrar\nInsira a opção: ");
    op = sc.next();

    if(op.equals("7")){
        System.out.println("Encerrado.");
        break;
}
    switch (op) {
        case "1":
            moeda = "BRL";
            moeda_base = "USD";
            break;
        case "2":
            moeda = "ARS";
            moeda_base = "BRL";
            break;
        case "3":
            moeda = "CAD";
            moeda_base = "USD";
            break;
        case "4":
            moeda = "BRL";
            moeda_base = "CAD";
            break;
        case "5":
            moeda = "BRL";
            moeda_base = "RUB";
            break;
        case "6":
            moeda = "BRL";
            moeda_base = "EUR";
            break;
        default:
            System.out.println("Opção inválida.");
            return;

    }

    try {
        System.out.println("Insira o valor que deseja converter: ");
        valor = sc.nextDouble();

        ConversorRecord record = conversor.retornaMoeda(conversor, moeda_base);

        if (record !=null){
            metodo.retorna_atualizacao(record, moeda, moeda_base);
            metodo.converte_moeda(record,valor,moeda,moeda_base);

        } else {
            System.out.println("Não obteve os dados.");

        }

    } catch (Exception e) {
        System.out.println("Valor inválido.");

    }}

    }
}