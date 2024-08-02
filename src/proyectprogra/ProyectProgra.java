/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectprogra;

import java.util.Scanner;

public class ProyectProgra {
    public static void main(String[] args) {
        Scanner lea=new Scanner(System.in).useDelimiter("\n");
        
        //Declarion de variables
        int opcion=0;
        
        double billete=0;
        double caja=0;
        
        double azucarKg=0;
        double avenaKg=0;
        double trigoKg=0;
        double maizKg=0;
        
        //Precios productos venta
        int azucarVentas=30;
        int avenaVentas=25;
        int trigoVentas=32;
        int maizVentas=20;
        
        int cobroV=0;
        
        //Precios productos compra
        int azucarCompra=25;
        int avenaCompraA=20;
        int avenaCompraB=22;
        int trigoCompra=30;
        int maizCompra=18;
        
        int cobroC=0;
        
        //Para facturas
        double porcentaje=0;
        double descuento=0;
        double impuesto=0;
        double subtotal=0;
        double total=0;
        
        String cliente;
        
        while(opcion!=6){
        do{
            System.out.println(" ");
            System.out.println("""
                               *** MENU ***
                               1 - Abrir Caja
                               2 - Ventas
                               3 - Compras
                               4 - Reportes
                               5 - Cierre de Caja
                               6 - Salir del Sistema
                               """);
            System.out.print("Que desea realizar?: ");
            opcion=lea.nextInt();
        
            if(opcion<1||opcion>6){
                System.out.println("Ingrese un valor dentro del menu!");
            }
        
        }while(opcion<1||opcion>6);
            if(opcion==1){
                
                System.out.println("La cantidad actual en caja es de: "+billete);
                
                System.out.print("Ingresar dinero en caja: ");
                caja=lea.nextDouble();
                
                billete+=caja;
                
            }else if(opcion==2){
            
                if(azucarKg<=0||avenaKg<=0||trigoKg<=0||maizKg<=0){
                    System.out.println(" ");
                    System.out.println("Uy! No tienes productos a vender");
                    System.out.println(" ");
                }else{
                    // logica clientes venta
                    System.out.println("Que tipo de cliente eres?");
                    System.out.print("Cliente A, B o C: ");
                    cliente=lea.next();
                    if(cliente.equalsIgnoreCase("a")){
                        System.out.println("Los productos para el cliente A: ");
                        System.out.println("***********************************************");
                        System.out.println("* Codigo *     Producto     *   Precio venta  *");
                        System.out.println("***********************************************");
                        System.out.println("*   1    *      Azucar      *       L.30      *");
                        System.out.println("***********************************************");
                        System.out.println("*   2    *      Avena       *       L.25      *");
                        System.out.println("***********************************************");
                        System.out.println("*   3    *      Trigo       *       L.32      *");
                        System.out.println("***********************************************");
                        System.out.println("*   4    *      Maiz        *       L.20      *");
                        System.out.println("***********************************************");
                        System.out.println("");
                        System.out.print("Ingresar codigo del producto: ");
                        int codigoV=lea.nextInt();
                        
                        // cliente A ventas
                        
                        if(codigoV==1){
                            //azucar ventas
                            System.out.println("Cuantos kilogramos de azucar desea?: "); 
                            int cantidadVenta=lea.nextInt();
                            
                            //logica de facturacion
                            if((azucarKg>=cantidadVenta)){
                                
                                cobroV=cantidadVenta*azucarVentas;
                            
                                if(cobroV>=1000&&cobroV<=5000){
                                    descuento=cobroV*0.05;
                                    porcentaje=5;

                                }else if(cobroV>=5000){
                                    descuento=cobroV*0.10;
                                    porcentaje=10;
                                }else{
                                    descuento=0;
                                }
                                
                                impuesto=subtotal*0.07;
                                total=(cobroV+impuesto)-descuento;

                                System.out.println("Subtotal: "+cobroV+
                                                   "\nISV: "+impuesto+
                                                   "\nDescuento"+porcentaje+"%: "+descuento+
                                                   "\nTotal: "+total);
                                //suma para caja
                                billete+=total;
                            }else{
                                System.out.println("No tienes para vender!");
                            }
                        
                        }else if(codigoV==2){
                            //avena ventas
                            System.out.println("Cuantos kilogramos de avena desea?: "); 
                            int cantidadVenta=lea.nextInt();
                            //facturizacion
                            if(avenaKg>=cantidadVenta){
                            
                                cobroV=cantidadVenta*azucarVentas;
                            
                                if(cobroV>=1000&&cobroV<=5000){
                                    descuento=cobroV*0.05;
                                    porcentaje=5;

                                }else if(cobroV>=5000){
                                    descuento=cobroV*0.10;
                                    porcentaje=10;
                                }else{
                                    descuento=0;
                                }
                                
                                impuesto=subtotal*0.07;
                                total=(cobroV+impuesto)-descuento;

                                System.out.println("Subtotal: "+cobroV+
                                                   "\nISV: "+impuesto+
                                                   "\nDescuento"+porcentaje+"%: "+descuento+
                                                   "\nTotal: "+total);
                                //suma para caja
                                billete+=total;
                            }else{
                                System.out.println("No tienes para vender!");
                            }
                            
                        }else if(codigoV==3){
                            //trigo ventas
                            System.out.println("Cuantos kilogramos de trigo desea?: "); 
                            int cantidadVenta=lea.nextInt();
                            //facturizacion
                            if(trigoKg>=cantidadVenta){
                                
                                cobroV=cantidadVenta*azucarVentas;
                            
                                if(cobroV>=1000&&cobroV<=5000){
                                    descuento=cobroV*0.05;
                                    porcentaje=5;

                                }else if(cobroV>=5000){
                                    descuento=cobroV*0.10;
                                    porcentaje=10;
                                }else{
                                    descuento=0;
                                }
                                
                                impuesto=subtotal*0.07;
                                total=(cobroV+impuesto)-descuento;

                                System.out.println("Subtotal: "+cobroV+
                                                   "\nISV: "+impuesto+
                                                   "\nDescuento"+porcentaje+"%: "+descuento+
                                                   "\nTotal: "+total);
                                //suma para caja
                                billete+=total;
                            }else{
                                System.out.println("No tienes para vender!");
                            }
                            
                        }else if(codigoV==4){
                            //maiz ventas
                            System.out.println("Cuantos kilogramos de maiz desea?: "); 
                            int cantidadVenta=lea.nextInt();
                            
                            if(maizKg>=cantidadVenta){
                                cobroV=cantidadVenta*azucarVentas;
                            
                                if(cobroV>=1000&&cobroV<=5000){
                                    descuento=cobroV*0.05;
                                    porcentaje=5;

                                }else if(cobroV>=5000){
                                    descuento=cobroV*0.10;
                                    porcentaje=10;
                                }else{
                                    descuento=0;
                                }
                                
                                impuesto=subtotal*0.07;
                                total=(cobroV+impuesto)-descuento;

                                System.out.println("Subtotal: "+cobroV+
                                                   "\nISV: "+impuesto+
                                                   "\nDescuento"+porcentaje+"%: "+descuento+
                                                   "\nTotal: "+total);
                                //suma para caja
                                billete+=total;
                            }else{
                                System.out.println("No tienes para vender!");
                            }
                            
                        }else{
                            System.out.println("Escoge un codigo dentro de las opciones la proxima vez!");
                        }
                    }
                    else if(cliente.equalsIgnoreCase("b")){
                        System.out.println("Los productos para el cliente B: ");
                        System.out.println("***********************************************");
                        System.out.println("* Codigo *     Producto     *   Precio venta  *");
                        System.out.println("***********************************************");
                        System.out.println("*   1    *      Azucar      *       L.30      *");
                        System.out.println("***********************************************");
                        System.out.println("*   2    *      Avena       *       L.25      *");
                        System.out.println("***********************************************");
                        System.out.println("*   3    *      Trigo       *       L.32      *");
                        System.out.println("***********************************************");
                        System.out.println("");
                        System.out.print("Ingresar codigo del producto: ");
                        
                        // cliente B ventas
                    }
                    else if(cliente.equalsIgnoreCase("c")){
                        System.out.println("Los productos para el cliente C: ");
                        System.out.println("***********************************************");
                        System.out.println("* Codigo *     Producto     *   Precio venta  *");
                        System.out.println("***********************************************");
                        System.out.println("*   4    *      Maiz        *       L.20      *");
                        System.out.println("***********************************************");
                        System.out.println("");
                        System.out.print("Ingresar codigo del producto: ");
                        
                        //cliente C ventas
                    }
                    else{
                        System.out.println("Ingrese letra dentro de las opciones.");
                    }
                }
            }else if(opcion==3){
                if(caja<=18){
                    System.out.println(" ");
                    System.out.println("No tienes suficiente dinero para comprar.");
                    System.out.println(" ");
                }else{
                    // logica  cliente compras 
                    System.out.println("Que tipo de proveedor prefieres?");
                    System.out.print("A, B o C: ");
                    String proveedor=lea.next();
                    
                    if(proveedor.equalsIgnoreCase("a")){
                        System.out.println("Los productos disponibles para Comprar: ");
                        System.out.println("***********************************************");
                        System.out.println("* Codigo *     Producto     *  Precio Compra  *");
                        System.out.println("***********************************************");
                        System.out.println("*   1    *      Azucar      *       L.25      *");
                        System.out.println("***********************************************");
                        System.out.println("*   4    *       Maiz       *       L.18      *");
                        System.out.println("***********************************************");
                        System.out.println("");
                        System.out.print("Ingresar codigo del producto: ");
                        int codigoC=lea.nextInt();
                        
                        //cliente A compras
                        
                        if(codigoC==1){
                            System.out.print("Cuantos kilogramos desea de azucar?: ");
                            int cantidadCompras=lea.nextInt();
                            
                            cantidadKg+=cantidadCompras;
                            
                            cobroC=cantidadCompras*azucarCompra;
                            
                            caja-=cobroC;
                            
                        }else if(codigoC==4){
                            System.out.print("Cuantos kilogramos desea de Maiz?: ");
                            int cantidadCompras=lea.nextInt();
                            
                            cantidadKg+=cantidadCompras;
                            
                            cobroC=cantidadCompras*maizCompra;
                        }else{
                            System.out.println("No cuento con dicho producto.");
                            
                        }
                    }else if(proveedor.equalsIgnoreCase("b")){
                        System.out.println("Los productos disponibles para Comprar: ");
                        System.out.println("***********************************************");
                        System.out.println("* Codigo *     Producto     *  Precio Compra  *");
                        System.out.println("***********************************************");
                        System.out.println("*        *                  *    A:   L.20    *");
                        System.out.println("*   2    *      Avena       *                 *");
                        System.out.println("*        *                  *    B:   L.22    *");
                        System.out.println("***********************************************");
                        System.out.println("*   3    *      Trigo       *       L.30      *");
                        System.out.println("***********************************************");
                        System.out.println("Ingresar codigo del producto: ");
                        int codigoC=lea.nextInt();
                        
                        //clientes B compras 
                        
                        if(codigoC==2){
                            System.out.println("Cuantos desea de azucar: ");
                            int cantidadCompras=lea.nextInt();
                            
                            cantidadKg+=cantidadCompras;
                        }else if(codigoC==3){
                            System.out.println("Que tipo de Maiz desea?");
                            System.out.print("A o B?: ");
                            String avenaOpcion=lea.next();
                            
                            if(avenaOpcion.equalsIgnoreCase("a")){
                                System.out.println("Cuantos kilogramos de trigo quisera llevar?: ");
                                int cantidadCompras=lea.nextInt();
                                
                                cantidadKg+=cantidadCompras;
                            }else if(avenaOpcion.equalsIgnoreCase("b")){
                                System.out.println("Cuantos kilogramos de trigo quisiera llevar?: ");
                                int cantidadCompras=lea.nextInt();
                                
                                cantidadKg+=cantidadCompras;
                            }else{
                                System.out.println("Elija entre tipo A o B.");
                            }
                           
                        }else{
                            System.out.println("No cuento con dicho producto.");
                        }
                        
                    }else if(proveedor.equalsIgnoreCase("c")){
                        System.out.println("Los productos disponibles para Comprar: ");
                        System.out.println("***********************************************");
                        System.out.println("* Codigo *     Producto     *  Precio Compra  *");
                        System.out.println("***********************************************");
                        System.out.println("*        *                  *    A:   L.20    *");
                        System.out.println("*   2    *      Avena       *                 *");
                        System.out.println("*        *                  *    B:   L.22    *");
                        System.out.println("***********************************************");
                        System.out.println("Ingresar codigo del producto: ");
                        int codigoC=lea.nextInt();
                        
                        // cliente C compras
                        
                        if(codigoC==3){
                            System.out.println("Que tipo de Avena desea?");
                            System.out.print("A o B?: ");
                            String avenaOpcion=lea.next();
                            
                            if(avenaOpcion.equalsIgnoreCase("a")){
                                System.out.println("Cuantos kilogramos de avena desea llevar?: ");
                                int cantidadCompras=lea.nextInt();
                                
                                cantidadKg+=cantidadCompras;
                            }else if(avenaOpcion.equalsIgnoreCase("b")){
                                System.out.println("Cuantos kilogramos de avena desea llevar?: ");
                                int cantidadCompras=lea.nextInt();
                                
                                cantidadKg+=cantidadCompras;
                            }else{
                                System.out.println("Elija entre tipo A o B.");
                            }
                           
                        }else{
                            System.out.println("No cuento con dicho producto.");
                        }
                        
                    }else{
                        System.out.println("Ingrese letra dentro de las opciones.");
                    }
                }
            }else if(opcion==4){
            
            }else if(opcion==5){
            
            }else{
                System.out.println("Ya estuvo!");
            }
        }
    }
}
