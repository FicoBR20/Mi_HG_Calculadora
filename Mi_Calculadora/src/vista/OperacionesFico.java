package vista;

public class OperacionesFico {

    private double primerTerlmino;
    private  double segundoTermino;

    public OperacionesFico(double pt, double st){
         pt = primerTerlmino;
         st = segundoTermino;
    }

    double sumar (double a, double b){
        return a + b;
    }

    double restar (double a, double b){
        return a-b;
    }


    double multiplicar (double a, double b){
        return a*b;
    }

    double dividir (double a, double b){
        if (b==0){
            System.out.print(" error ingreso cero");
            double result =0;
            return result;

        }
        else {
            return a / b;

        }

    }
}
