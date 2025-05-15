/*

 */
package parcial16;

public class Parcial16 {

    public static void main(String[] args) {
        // creo un banco tradicional y un banco digital
        Tradicional tradi= new Tradicional("nombre", 30, 20, "direccion", "localidad"); //se crea banco para N cuentas 
        Digital digital = new Digital("nombre", 30, 20, "direccion WEB");
        //creo cuenta bancaria y agrego a ambos bancos 
        Cuenta cuent1 = new Cuenta (22323, "alias", 042, "pesos Arg", 500.0);
        Cuenta cuent2 = new Cuenta (22324, "alias", 043, "pesos Arg", 550.0);
        Cuenta cuent3 = new Cuenta (22325, "alias", 044, "pesos Arg", 600.0);
        Cuenta cuent4 = new Cuenta (22326, "alias", 045, "pesos Arg", 800.0);
        //
        tradi.agregCuenta(cuent1);
        tradi.agregCuenta(cuent2);
        digital.agregCuenta(cuent3);
        digital.agregaCuenta(cuent4);
        // 
        tradi.deposito(22323, 200.0);
        digital.deposito(22325, 600.3);
        //
        System.out.println(tradi.recibeTarj(22324)); //retorna v o f
        System.out.println(digital.recibeTarj(22326);
        //
        
        
    }
    
}
