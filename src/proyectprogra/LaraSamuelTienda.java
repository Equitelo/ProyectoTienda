/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectprogra;

import java.util.Scanner;

public class LaraSamuelTienda {
    public static void main(String[] args) {
        Scanner lea=new Scanner(System.in).useDelimiter("\n");
        
        //Declarion de variables
        int opcion=0;
        
        //dinero
        double billete=0;
        //reportes
        double caja=0;
        int ingresoC=0;
        int ingresoV=0;
        double volumenV=0;
        double volumenC=0;
        double margenGana=0;
        double promedioV=0;
        double promedioC=0;
        
        //cantidad en kilogramos
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
        String decision="no";
        
        //Precios productos compra
        int azucarCompra=25;
        int avenacompraA=20;
        int avenacompraB=22;
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
                System.out.print("Ingresar dinero en caja: L.");
                caja=lea.nextDouble();
                
                billete+=caja;
                
            }else if(opcion==2){
            
                if(azucarKg<=0&&avenaKg<=0&&trigoKg<=0&&maizKg<=0){
                    System.out.println(" ");
                    System.out.println("Uy! No tienes productos a vender");
                    System.out.println(" ");
                }else{
                    // logica clientes venta
                    System.out.println("Que tipo de cliente eres?");
                    System.out.print("Cliente A, B o C: ");
                    cliente=lea.next();
                    if(cliente.equalsIgnoreCase("a")){
                        System.out.println("");
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
                        do{
                        System.out.print("Ingresar codigo del producto: ");
                        int codigoV=lea.nextInt();
                        // cliente A ventas
                        if(codigoV==1){
                            //azucar ventas
                            System.out.print("Cuantos kilogramos de azucar desea?: "); 
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

                                System.out.println("Subtotal: L."+cobroV+
                                                   "\nISV: 7%"+impuesto+
                                                   "\nDescuento"+porcentaje+"%: "+descuento+
                                                   "\nTotal: L."+total);
                                //suma para caja
                                billete+=total;
                                if(cantidadVenta>azucarKg){
                                    System.out.println("No tienes esa cantidad a vender");
                                }else{
                                    azucarKg-=cantidadVenta;
                                }
                            }else{
                                System.out.println("");
                                System.out.println("No cuentas con lo suficiente!");
                                System.out.print("Deseas comprar otro producto? (SI/NO): ");
                                decision=lea.next().toLowerCase();
                            }
                            
                        
                        }else if(codigoV==2){
                            //avena ventas
                            System.out.print("Cuantos kilogramos de avena desea?: "); 
                            int cantidadVenta=lea.nextInt();
                            //facturizacion
                            if(avenaKg>=cantidadVenta){
                            
                                cobroV=cantidadVenta*avenaVentas;
                            
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

                                System.out.println("Subtotal: L."+cobroV+
                                                   "\nISV: 7%"+impuesto+
                                                   "\nDescuento"+porcentaje+"%: "+descuento+
                                                   "\nTotal: L."+total);
                                //suma para caja
                                billete+=total;
                                if(cantidadVenta>avenaKg){
                                    System.out.println("No tienes esa cantidad a vender");
                                }else{
                                    avenaKg-=cantidadVenta;
                                }
                            }else{
                                System.out.println("");
                                System.out.println("No cuentas con lo suficiente!");
                                System.out.print("Deseas comprar otro producto? (SI/NO): ");
                                decision=lea.next().toLowerCase();
                            }
                            
                        }else if(codigoV==3){
                            //trigo ventas
                            System.out.print("Cuantos kilogramos de trigo desea?: "); 
                            int cantidadVenta=lea.nextInt();
                            //facturizacion
                            if(trigoKg>=cantidadVenta){
                                
                                cobroV=cantidadVenta*trigoVentas;
                            
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

                                System.out.println("Subtotal: L."+cobroV+
                                                   "\nISV: 7%"+impuesto+
                                                   "\nDescuento"+porcentaje+"%: "+descuento+
                                                   "\nTotal: L."+total);
                                //suma para caja
                                billete+=total;
                                if(cantidadVenta>trigoKg){
                                    System.out.println("No tienes esa cantidad a vender");
                                }else{
                                    trigoKg-=cantidadVenta;
                                }
                            }else{
                                System.out.println("");
                                System.out.println("No cuentas con lo suficiente!");
                                System.out.print("Deseas comprar otro producto? (SI/NO): ");
                                decision=lea.next().toLowerCase();
                            }
                            
                        }else if(codigoV==4){
                            //maiz ventas
                            System.out.print("Cuantos kilogramos de maiz desea?: "); 
                            int cantidadVenta=lea.nextInt();
                            
                            if(maizKg>=cantidadVenta){
                                cobroV=cantidadVenta*maizVentas;
                            
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

                                System.out.println("Subtotal: L."+cobroV+
                                                   "\nISV 7%: "+impuesto+
                                                   "\nDescuento"+porcentaje+"%: "+descuento+
                                                   "\nTotal: L."+total);
                                //suma para caja
                                billete+=total;
                                if(cantidadVenta>maizKg){
                                    System.out.println("No tienes esa cantidad a vender");
                                }else{
                                    maizKg-=cantidadVenta;
                                }
                            }else{
                                System.out.println("");
                                System.out.println("No cuentas con lo suficiente!");
                                System.out.print("Deseas comprar otro producto? (SI/NO): ");
                                decision=lea.next().toLowerCase();
                            }
                        }else{
                            System.out.println("Escoge un codigo dentro de las opciones la proxima vez!");
                        }
                        }while(decision.equals("si")); 
                    }else if(cliente.equalsIgnoreCase("b")){
                        System.out.println("");
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
                        do{
                        System.out.print("Ingresar codigo del producto: ");
                        int codigoV=lea.nextInt();
                        // cliente B ventas
                        
                        if(codigoV==1){
                            //azucar ventas
                            System.out.print("Cuantos kilogramos de azucar desea?: "); 
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
                                if(cantidadVenta>azucarKg){
                                    System.out.println("No tienes esa cantidad a vender");
                                }else{
                                    azucarKg-=cantidadVenta;
                                }
                            }else{
                                System.out.println("");
                                System.out.println("No cuentas con lo suficiente!");
                                System.out.print("Deseas comprar otro producto? (SI/NO): ");
                                decision=lea.next().toLowerCase();
                            }
                        
                        }else if(codigoV==2){
                            //avena ventas
                            System.out.print("Cuantos kilogramos de avena desea?: "); 
                            int cantidadVenta=lea.nextInt();
                            //facturizacion
                            if(avenaKg>=cantidadVenta){
                            
                                cobroV=cantidadVenta*avenaVentas;
                            
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
                                if(cantidadVenta>avenaKg){
                                    System.out.println("No tienes esa cantidad a vender");
                                }else{
                                    avenaKg-=cantidadVenta;
                                }
                            }else{
                                System.out.println("");
                                System.out.println("No cuentas con lo suficiente!");
                                System.out.print("Deseas comprar otro producto? (SI/NO): ");
                                decision=lea.next().toLowerCase();
                            }
                            
                        }else if(codigoV==3){
                            //trigo ventas
                            System.out.print("Cuantos kilogramos de trigo desea?: "); 
                            int cantidadVenta=lea.nextInt();
                            //facturizacion
                            if(trigoKg>=cantidadVenta){
                                
                                cobroV=cantidadVenta*trigoVentas;
                            
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
                                if(cantidadVenta>trigoKg){
                                    System.out.println("No tienes esa cantidad a vender");
                                }else{
                                    trigoKg-=cantidadVenta;
                                }
                            }else{
                                System.out.println("");
                                System.out.println("No cuentas con lo suficiente!");
                                System.out.print("Deseas comprar otro producto? (SI/NO): ");
                                decision=lea.next().toLowerCase();
                            }
                        }else{
                            System.out.println("No");
                        }
                        }while(decision.equals("si"));
                    }else if(cliente.equalsIgnoreCase("c")){
                        System.out.println("");
                        System.out.println("Los productos para el cliente C: ");
                        System.out.println("***********************************************");
                        System.out.println("* Codigo *     Producto     *   Precio venta  *");
                        System.out.println("***********************************************");
                        System.out.println("*   4    *      Maiz        *       L.20      *");
                        System.out.println("***********************************************");
                        System.out.println("");
                        do{
                        System.out.print("Ingresar codigo del producto: ");
                        int codigoV=lea.nextInt();
                        //cliente C ventas
                        
                        if(codigoV==4){
                            //maiz ventas
                            System.out.print("Cuantos kilogramos de maiz desea?: "); 
                            int cantidadVenta=lea.nextInt();
                            
                            if(maizKg>=cantidadVenta){
                                cobroV=cantidadVenta*maizVentas;
                            
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
                                if(cantidadVenta>maizKg){
                                    System.out.println("No tienes esa cantidad a vender");
                                }else{
                                    maizKg-=cantidadVenta;
                                }
                            }else{
                                System.out.println("");
                                System.out.println("No cuentas con lo suficiente!");
                                System.out.print("Deseas comprar otro producto? (SI/NO): ");
                                decision=lea.next().toLowerCase();
                            }
                        }
                        }while(decision.equals("si"));
                    }
                    else{
                        System.out.println("Ingrese letra dentro de las opciones.");
                    }
                }
            }else if(opcion==3){
                if(billete<=18){
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
                            cobroC=cantidadCompras*azucarCompra;
                            
                            //cantidadKg+=cantidadCompras;
                            if(billete>=cobroC){
                                //factura
                                impuesto=cobroC*0.07;
                                total=cobroC+impuesto;
                                
                                //ganancias y perdidas
                                azucarKg+=cantidadCompras;
                                if(total>billete){
                                    System.out.println("No se puede realizar la compra sin suficiente dinero"); 
                                }else{
                                    System.out.println("Subtotal: L."+cobroC+
                                                       "\nISV. 7%: "+impuesto+
                                                       "\nTotal: L."+total);
                                    billete-=cobroC;  
                                }
                            }else{
                                System.out.println("No tienes suficiente para comprar");
                            }
                        }else if(codigoC==4){
                            System.out.print("Cuantos kilogramos desea de Maiz?: ");
                            int cantidadCompras=lea.nextInt();
                            cobroC=cantidadCompras*maizCompra;
                            //cantidadKg+=cantidadCompras;
                            if(billete>=cobroC){
                                //factura
                                impuesto=cobroC*0.07;
                                total=cobroC+impuesto;
                                
                                //ganancias y perdidas
                                maizKg+=cantidadCompras;
                                if(total>billete){
                                    System.out.println("No se puede realizar la compra sin suficiente dinero"); 
                                }else{
                                    System.out.println("Subtotal: L."+cobroC+
                                                       "\nISV. 7%: "+impuesto+
                                                       "\nTotal: L."+total);
                                    billete-=cobroC;  
                                }
                            }else{
                                System.out.println("No tienes suficiente para comprar");
                            }
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
                            System.out.println("Que tipo de Avena desea?");
                            System.out.print("A o B?: ");
                            String avenaOpcion=lea.next();
                            
                            if(avenaOpcion.equalsIgnoreCase("a")){
                                System.out.print("Cuantos kilogramos de trigo quisera llevar?: ");
                                int cantidadCompras=lea.nextInt();
                                cobroC=cantidadCompras*avenacompraA;
                                
                                if(billete>=cobroC){
                                //factura
                                    impuesto=cobroC*0.07;
                                    total=cobroC+impuesto;

                                    //ganancias y perdidas
                                    avenaKg+=cantidadCompras;
                                    if(total>billete){
                                        System.out.println("No se puede realizar la compra sin suficiente dinero"); 
                                    }else{
                                        System.out.println("Subtotal: L."+cobroC+
                                                       "\nISV. 7%: "+impuesto+
                                                       "\nTotal: L."+total);
                                        billete-=cobroC;  
                                    }
                                }else{
                                    System.out.println("No tienes suficiente para comprar");
                                }
                                
                            }else if(avenaOpcion.equalsIgnoreCase("b")){
                                System.out.print("Cuantos kilogramos de trigo quisiera llevar?: ");
                                int cantidadCompras=lea.nextInt();
                                cobroC=cantidadCompras*avenacompraB;
                                
                                if(billete>=cobroC){
                                //factura
                                    impuesto=cobroC*0.07;
                                    total=cobroC+impuesto;

                                    //ganancias y perdidas
                                    avenaKg+=cantidadCompras;
                                    if(total>billete){
                                        System.out.println("No se puede realizar la compra sin suficiente dinero"); 
                                    }else{
                                        System.out.println("Subtotal: L."+cobroC+
                                                       "\nISV. 7%: "+impuesto+
                                                       "\nTotal: L."+total);
                                        billete-=cobroC;  
                                    }
                                }else{
                                    System.out.println("No tienes suficiente para comprar");
                                }
                                
                            }else{
                                System.out.println("Elija entre tipo A o B.");
                            }
                            
                            //cantidadKg+=cantidadCompras;
                        }else if(codigoC==3){
                            System.out.print("Cuantos kilogramos desea de trigo?: ");
                            int cantidadCompras=lea.nextInt();
                            cobroC=cantidadCompras*trigoCompra;
                            //cantidadKg+=cantidadCompras;
                            if(billete>=cobroC){
                                //factura
                                impuesto=cobroC*0.07;
                                total=cobroC+impuesto;
                                
                                //ganancias y perdidas
                                trigoKg+=cantidadCompras;
                                if(total>billete){
                                    System.out.println("No se puede realizar la compra sin suficiente dinero"); 
                                }else{
                                    System.out.println("Subtotal: L."+cobroC+
                                                       "\nISV. 7%: "+impuesto+
                                                       "\nTotal: L."+total);
                                    billete-=cobroC;  
                                }
                            }else{
                                System.out.println("No tienes suficiente para comprar");
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
                        System.out.print("Ingresar codigo del producto: ");
                        int codigoC=lea.nextInt();
                        
                        // cliente C compras
                        
                        if(codigoC==2){
                            System.out.println("Que tipo de Avena desea?");
                            System.out.print("A o B?: ");
                            String avenaOpcion=lea.next();
                            
                            if(avenaOpcion.equalsIgnoreCase("a")){
                                System.out.print("Cuantos kilogramos de avena desea llevar?: ");
                                int cantidadCompras=lea.nextInt();
                                cobroC=cantidadCompras*avenacompraA;
                                if(billete>=cobroC){
                                    
                                    //factura
                                    impuesto=cobroC*0.07;
                                    total=cobroC+impuesto;
                                    
                                    //ganancias y perdidas
                                    avenaKg+=cantidadCompras;
                                    if(total>billete){
                                        System.out.println("No se puede realizar la compra sin suficiente dinero"); 
                                    }else{
                                        System.out.println("Subtotal: L."+cobroC+
                                                       "\nISV. 7%: "+impuesto+
                                                       "\nTotal: L."+total);
                                        billete-=cobroC;  
                                    }
                                }else{
                                    System.out.println("No tienes suficiente para comprar");
                                }
                                //cantidadKg+=cantidadCompras;
                            }else if(avenaOpcion.equalsIgnoreCase("b")){
                                System.out.print("Cuantos kilogramos de avena desea llevar?: ");
                                int cantidadCompras=lea.nextInt();
                                cobroC=cantidadCompras*avenacompraB;
                                //cantidadKg+=cantidadCompras;
                                if(billete>=cobroC){
                                //factura
                                    impuesto=cobroC*0.07;
                                    total=cobroC+impuesto;

                                    System.out.println("Subtotal: L."+cobroC+
                                                       "\nISV. 7%: "+impuesto+
                                                       "\nTotal: L."+total);
                                    //ganancias y perdidas
                                    avenaKg+=cantidadCompras;
                                    if(total>billete){
                                        System.out.println("No se puede realizar la compra sin suficiente dinero"); 
                                    }else{
                                        billete-=cobroC;  
                                    }
                                }else{
                                    System.out.println("No tienes suficiente para comprar");
                                }
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
                System.out.println("");
                System.out.println("REPORTES");
                System.out.println("La cantidad actual en caja es de: L."+billete);
                System.out.println("");
            }else if(opcion==5){
            
            }else{
                System.out.println("Ya estuvo!");
            }
        }
    }
}
