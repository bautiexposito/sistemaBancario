package ar.edu.utn.frbb.tup;
import ar.edu.utn.frbb.tup.banco.Cuenta;
import ar.edu.utn.frbb.tup.usuario.Cliente;
import ar.edu.utn.frbb.tup.usuario.Persona;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        int opcion2 = 0;
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        ArrayList<Cuenta> listaCuentas = new ArrayList<>();


        while(true){
            System.out.println("");
            System.out.println("----- Menu -----");
            System.out.println("1. Crear un nuevo cliente");
            System.out.println("2. Modificar un cliente");
            System.out.println("3. Eliminar un cliente");
            System.out.println("4. Crear una nueva cuenta bancaria");
            System.out.println("5. Generar un deposito");
            System.out.println("6. Generar un retiro");
            System.out.println("7. Realizar una transferencia");
            System.out.println("8. Consultar el saldo");
            System.out.println("9. Salir\n");
            System.out.println("Ingresar opcion: ");
            opcion = scanner.nextInt();
            System.out.println("");

            if (opcion == 1) {
                //Crear un cliente
                System.out.println("Ingresar nombre: ");
                String nombre = scanner.next();
                System.out.println("Ingresar apellido: ");
                String apellido = scanner.next();
                System.out.println("Ingresar DNI: ");
                int dni = scanner.nextInt();
                System.out.println("Ingresar telefono: ");
                long telefono = scanner.nextLong();
                Cliente cliente = new Cliente(nombre, apellido, dni,telefono);
                listaClientes.add(cliente);
                System.out.println("Cliente creado correctamente");
            }

            else if (opcion==2) {
                //Modificar un cliente
                System.out.println("Ingresar el DNI del cliente:");
                int dni = scanner.nextInt();
                for(Cliente cliente: listaClientes) {
                    if (cliente.getDni() == dni) {
                        System.out.println("Que dato desea modificar?");
                        System.out.println("1. Nombre");
                        System.out.println("2. Apellido");
                        System.out.println("3. Telefono");
                        opcion2 = scanner.nextInt();
                        if(opcion2==1){
                            String nombre = scanner.next();
                            cliente.setNombre(nombre);
                        }
                        else if(opcion2==2){
                            String apellido = scanner.next();
                            cliente.setApellido(apellido);
                        }
                        else if(opcion2==3){
                            long telefono = scanner.nextLong();
                            cliente.setTelefono(telefono);
                        }
                        else{
                            System.out.println("Error al ingresar opcion ");
                        }
                    }
                    else{
                        System.out.println("Error al ingresar el DNI");
                    }
                }
                System.out.println("Cliente modificado correctamente");
            }

            else if (opcion==3) {
                //Eliminar un cliente
                System.out.println("Ingresar DNI: ");
                int dni = scanner.nextInt();
                boolean clienteEncontrado = false;
                for (Cliente cliente : listaClientes) {
                    if (cliente.getDni() == dni) {
                        listaClientes.remove(cliente);
                        System.out.println("El cliente fue eliminado");
                        clienteEncontrado = true;
                        break;
                    }
                }
                if (!clienteEncontrado) {
                    System.out.println("Error al ingresar DNI");
                }
            }

            else if (opcion==4) {
                //Crear nueva cuenta bancaria
                System.out.println("Ingresar nombre de la cuenta: ");
                String nombre = scanner.next();
                System.out.println("Ingresar cbu: ");
                long cbu = scanner.nextLong();
                System.out.println("Ingresar saldo: ");
                long saldo = scanner.nextLong();
                Cuenta cuenta = new Cuenta(nombre,cbu,saldo);
                listaCuentas.add(cuenta);
                System.out.println("La nueva cuenta bancaria acaba de ser creada");
            }

            else if (opcion==5) {
                //Generar un deposito
                System.out.println("Ingresar CBU:");
                long cbu = scanner.nextLong();
                boolean cuentaEncontrada = false; // Variable para controlar si se ha encontrado la cuenta
                for (Cuenta cuenta : listaCuentas) {
                    if (cuenta.getCbu() == cbu) {
                        cuentaEncontrada = true; // La cuenta ha sido encontrada
                        System.out.println("Ingresar la cantidad de dinero: ");
                        long deposito = scanner.nextLong();
                        deposito = deposito + cuenta.getSaldo();
                        cuenta.setSaldo(deposito);
                        System.out.println("Deposito realizado correctamente");
                        break;
                    }
                }
                if (!cuentaEncontrada) {
                    System.out.println("Error al ingresar CBU"); // Mensaje de error si la cuenta no se encuentra
                }
            }

            else if (opcion==6) {
                //Generar un retiro
                System.out.println("Ingresar CBU:");
                long cbu = scanner.nextLong();
                boolean cuentaEncontrada = false; // Variable para controlar si se ha encontrado la cuenta
                for (Cuenta cuenta : listaCuentas) {
                    if (cuenta.getCbu() == cbu) {
                        cuentaEncontrada = true; // La cuenta ha sido encontrada
                        System.out.println("Ingresar la cantidad de dinero: ");
                        long retiro = scanner.nextLong();
                        if (cuenta.getSaldo() - retiro > 0) {
                            retiro = cuenta.getSaldo() - retiro;
                            System.out.println("Retiro realizado correctamente");
                            break;
                        } else {
                            System.out.println("Saldo insuficiente");
                        }
                    }
                }
                if (!cuentaEncontrada) {
                    System.out.println("Error al ingresar CBU"); // Mensaje de error si la cuenta no se encuentra
                }
            }

            else if (opcion==7) {
                //Realizar una transferencia
                System.out.println("---------------");
            }

            else if (opcion==8) {
                //Consultar saldo
                System.out.println("Ingresar CBU:");
                long cbu = scanner.nextLong();
                boolean cuentaEncontrada = false;
                for (Cuenta cuenta : listaCuentas) {
                    if (cuenta.getCbu() == cbu) {
                        System.out.println("Saldo de la cuenta: $" + cuenta.getSaldo());
                        cuentaEncontrada = true;
                        break; //
                    }
                }
                if (!cuentaEncontrada) {
                    System.out.println("Error al ingresar CBU");
                }
            }

            else if (opcion==9) {
                //Exit
                System.out.println("Programa finalizado");
                System.exit(0);
            }

            else{
                //Error
                System.out.println("Error al ingresar la opcion");
            }
        }

    }
}