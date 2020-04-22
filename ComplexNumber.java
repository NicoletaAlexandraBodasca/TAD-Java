//A. TAD număr “COMPLEX”
//        Metode:
//        -  constructori;
//        -  accesori;
//        -  suma a două numere complexe;
//        -  modulul unui număr complex;
//        -  metode de comparare a numerelor complexe;
//        -  alte metode, dacă sunt necesare.
//        B. Se citesc mai multe şiruri de numere complexe. Pentru fiecare şir  se calculeze suma numerelor din şir si
//        cea mai lunga secvenţă de numere consecutive cu modulul mai mic decat unitatea. La sfârşit să se afişeze toate numerele complexe întâlnite.
//        Citirea se poate face şi din fişier, cate un şir pe o linie.

import java.util.*;

public class ComplexNumber {
    private double realPart;
    private double imaginaryPart;


    //constructor cu parametrii
    public  ComplexNumber(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;

    }

    //default constructor

    ComplexNumber() {
        realPart = 0;
        imaginaryPart = 0;

    }


    // copy constructor
    public ComplexNumber(ComplexNumber c) {
//        System.out.println("Copy constructor called");
        this.realPart = c.realPart;
        this.imaginaryPart = c.imaginaryPart;
    }

    //accesori
    public double getRealPart() {

        return this.realPart;
    }

    public double getImaginaryPart() {
        return this.imaginaryPart;
    }

    private void setRealPart(double realPart2) {
        this.realPart = realPart2;
    }

    private void setImaginaryPart(double imaginaryPart2) {
        this.imaginaryPart = imaginaryPart2;
    }

    //adunarea a doua numere complexe

    public ComplexNumber add(ComplexNumber number2) {
        this.realPart += number2.realPart;
        this.imaginaryPart += number2.imaginaryPart;

        return this;
    }


    public double getMagnitude() {
        return Math.sqrt(this.realPart * this.realPart + this.imaginaryPart * this.imaginaryPart);
    }

    public String toString() {
        String result = "Complex: " + getRealPart() + " + " + getImaginaryPart() + "i; " +
                " Modulul este: " + getMagnitude();
        return result;
    }


//    public boolean Compare(ComplexNumber number2){
//        if(this.realPart==number2.realPart && this.imaginaryPart=number2.imaginaryPart){
//            return true;
//        }
//        return false;
//    }

    public static boolean Compare(ComplexNumber num,ComplexNumber num2) {

//        ComplexNumber num1 = new ComplexNumber(realPart, imaginaryPart);
        if (num.realPart == num2.realPart && num.imaginaryPart == num2.imaginaryPart) {
            return true;
        } else {
            return false;
        }

    }

    //crearea sirurilor de nr complexe date de la tastatura

    public static void createArrays(){
        ComplexNumber[] sir = new ComplexNumber[100];
        ComplexNumber sum=new ComplexNumber(0,0);
        Scanner in = new Scanner(System.in);
        System.out.print("Nr sirurilor este:");
        int nrOfArrays = in.nextInt();
        for (int i = 0; i < nrOfArrays; i++) {
            System.out.print("Nr elementelor din sir este:");
            int nrElem = in.nextInt();
            System.out.print("Dati numerele:");
            int j = 0;
            for (j = 0; j < nrElem; j++) {
                double a, b;
                System.out.print("Parte reala:");
                a = in.nextDouble();
                System.out.print("Parte imaginara");
                b = in.nextDouble();
                ComplexNumber c = new ComplexNumber(a, b);
                sir[j] = c;
                System.out.println(sir[j]);
                if(sir[j].getMagnitude()<1){
                    System.out.println(sir[j]);
                }
            }
            for (j = 0; j < nrElem; j++) {
                sum.add(sir[j]);
            }
            System.out.println("Suma numerelor este:" + " " + sum);

        }
    }


    public void Menu(){
        System.out.println("0.Iesire!");
        System.out.println("1.Compara numerele");
        System.out.println("2.Creare siruri de nr complexe ");
       // System.out.println("Calcul suma");
        System.out.print("Alegeti optiunea:");

    }


    public void run(){
        int op;
        do{
            Menu();
            Scanner in = new Scanner(System.in);
            op = in.nextInt();
            if(op==2){
                createArrays();
            }
            if(op==1){
                Scanner sc=new Scanner(System.in);
                double a,b,c,d;
                System.out.print("Parte reala:");
                a=sc.nextDouble();
                System.out.print("Parte imaginara");
                b=sc.nextDouble();
                System.out.print("Parte reala:");
                c=sc.nextDouble();
                System.out.print("Parte imaginara");
                d=sc.nextDouble();
                ComplexNumber m=new ComplexNumber(a,b);
                ComplexNumber n=new ComplexNumber(c,d);
                System.out.println(m);
                System.out.println(n);
                if(ComplexNumber.Compare(m,n)==true){
                    System.out.println("Numerele sunt egale");
                }
                else{
                    System.out.println("Numerele nu sunt egale");
                }

            }


        }
        while (op!=0);

    }
}

