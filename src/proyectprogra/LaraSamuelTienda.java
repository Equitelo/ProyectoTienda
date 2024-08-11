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
        double banco=0;
        double ingresar=0;
        
        //cantidad en kilogramos
        double azucarKg=0;
        double avenaKg=0;
        double trigoKg=0;
        double maizKg=0;
        
        double azucarSell=0;
        double avenaSell=0;
        double trigoSell=0;
        double maizSell=0; 
        //Precios productos venta
        int azucarVentas=30;
        int avenaVentas=25;
        int trigoVentas=32;
        int maizVentas=20;
        
        int cobroV=0;
        //desear otro producto
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
        
        //reportes
            //a
            double caja=0;
            //b
            int ingresoC=0;
            int ingresoV=0;
            //c
            double volumenV=0;
            double volumenC=0;
            double margenGana=0;
            //d
            int vecesV=0;
            int vecesC=0;
            double promedioV=0;
            double promedioC=0;
            //e
            double mayorV=0;
            double mayorC=00;
            //f
            double dineroAzucar=0;
            double dineroAvena=0;
            double dineroTrigo=0;
            double dineroMaiz=0;
        //tipo de cliente
        String cliente;
        
        while(opcion!=6){
        do{
            System.out.println(" ");
            System.out.println("""
                               ***********MENU**********
                               * 1 *    Abrir Caja     *
                               *************************
                               * 2 *      Ventas       *
                               *************************
                               * 3 *      Compras      *
                               *************************
                               * 4 *     Reportes      *
                               *************************
                               * 5 *  Cierre de Caja   *
                               *************************
                               * 6 * Salir del Sistema *
                               *************************
                               """);
            System.out.print("Digite opcion a realizar: ");
            opcion=lea.nextInt();
        
            if(opcion<1||opcion>6){
                System.out.println("Ingrese un valor dentro del menu!");
            }
        
        }while(opcion<1||opcion>6);
        
            if(opcion==1){
                System.out.print("Ingresar dinero en caja: L.");
                caja=lea.nextDouble();
                
                if(caja>0){
                    billete+=caja;
                }else{
                    System.out.println("No puedes ingresar dinero en negativo! ");
                }
                
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
                        System.out.println("************************************************************");
                        System.out.println("* Codigo *     Producto     *   Precio venta  * kilogramos *");
                        System.out.println("************************************************************");
                        System.out.println("*   1    *      Azucar      *       L.30      *     "+azucarKg+"    *");
                        System.out.println("************************************************************");
                        System.out.println("*   2    *      Avena       *       L.25      *     "+avenaKg+"    *");
                        System.out.println("************************************************************");
                        System.out.println("*   3    *      Trigo       *       L.32      *     "+trigoKg+"    *");
                        System.out.println("************************************************************");
                        System.out.println("*   4    *      Maiz        *       L.20      *     "+maizKg+"    *");
                        System.out.println("************************************************************");
                        System.out.println("");
                        do{
                        System.out.print("Ingresar codigo del producto: ");
                        int codigoV=lea.nextInt();
                        // cliente A ventas
                        if(codigoV==1){
                            //azucar ventas
                            System.out.print("Cuantos kilogramos de azucar desea?: "); 
                            int cantidadVenta=lea.nextInt();
                            //veces ingresadas
                            ingresoV++;
                            
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
                                
                                impuesto=cobroV*0.07;
                                total=(cobroV+impuesto)-descuento;
                                
                                System.out.println("Subtotal: L."+cobroV+
                                                   "\nISV 7%: "+String.format("%.2f", impuesto)+
                                                   "\nDescuento"+porcentaje+"%: "+String.format("%.2f", descuento)+
                                                   "\nTotal: L."+String.format("%.2f", total));
                                
                                if(cantidadVenta>azucarKg||cantidadVenta<=0){
                                    System.out.println("No tienes esa cantidad a vender");
                                }else{
                                    //suma para caja
                                    billete+=total;
                                    vecesV++;
                                    volumenV+=total;
                                    dineroAzucar+=total;
                                    while(mayorV<total){
                                        mayorV=total;
                                    }
                                    azucarKg-=cantidadVenta;
                                    azucarSell+=cantidadVenta;
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
                            //veces ingresadas
                            ingresoV++;
                            
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
                                
                                impuesto=cobroV*0.07;
                                total=(cobroV+impuesto)-descuento;

                                System.out.println("Subtotal: L."+cobroV+
                                                   "\nISV 7%: "+String.format("%.2f", impuesto)+
                                                   "\nDescuento"+porcentaje+"%: "+String.format("%.2f", descuento)+
                                                   "\nTotal: L."+String.format("%.2f", total));
                                
                                while(mayorV<total){
                                    mayorV=total;
                                }
                                if(cantidadVenta>avenaKg||cantidadVenta<=0){
                                    System.out.println("No tienes esa cantidad a vender");
                                }else{
                                    //suma para caja
                                    billete+=total;
                                    vecesV++;
                                    volumenV+=total;
                                    dineroAvena+=total;
                                    avenaKg-=cantidadVenta;
                                    avenaSell+=cantidadVenta;
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
                            //veces ingresadas
                            ingresoV++;
                            
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
                                
                                impuesto=cobroV*0.07;
                                total=(cobroV+impuesto)-descuento;

                                System.out.println("Subtotal: L."+cobroV+
                                                   "\nISV 7%: "+String.format("%.2f", impuesto)+
                                                   "\nDescuento"+porcentaje+"%: "+String.format("%.2f", descuento)+
                                                  "\nTotal: L."+String.format("%.2f", total));
                                
                                if(cantidadVenta>trigoKg||cantidadVenta<=0){
                                    System.out.println("No tienes esa cantidad a vender");
                                }else{
                                    //suma para caja
                                    billete+=total;
                                    vecesV++;
                                    volumenV+=total;
                                    dineroTrigo+=total;
                                    trigoKg-=cantidadVenta;
                                    trigoSell+=cantidadVenta;
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
                            //veces ingresadas
                            ingresoV++;
                            
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
                                
                                impuesto=cobroV*0.07;
                                total=(cobroV+impuesto)-descuento;

                                System.out.println("Subtotal: L."+cobroV+
                                                   "\nISV 7%: "+String.format("%.2f", impuesto)+
                                                   "\nDescuento"+porcentaje+"%: "+String.format("%.2f", descuento)+
                                                   "\nTotal: L."+String.format("%.2f", total));
                                
                                if(cantidadVenta>maizKg||cantidadVenta<=0){
                                    System.out.println("No tienes esa cantidad a vender");
                                }else{
                                    //suma para caja
                                    billete+=total;
                                    vecesV++;
                                    volumenV+=total;
                                    dineroMaiz+=total;
                                    while(mayorV<total){
                                        mayorV=total;
                                    }
                                    maizKg-=cantidadVenta;
                                    maizSell+=cantidadVenta;
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
                        System.out.println("************************************************************");
                        System.out.println("* Codigo *     Producto     *   Precio venta  * kilogramos *");
                        System.out.println("************************************************************");
                        System.out.println("*   1    *      Azucar      *       L.30      *     "+azucarKg+"    *");
                        System.out.println("************************************************************");
                        System.out.println("*   2    *      Avena       *       L.25      *     "+avenaKg+"    *");
                        System.out.println("***********************************************");
                        System.out.println("*   3    *      Trigo       *       L.32      *     "+trigoKg+"    *");
                        System.out.println("************************************************************");
                        System.out.println("");
                        do{
                        System.out.print("Ingresar codigo del producto: ");
                        int codigoV=lea.nextInt();
                        // cliente B ventas
                        
                        if(codigoV==1){
                            //azucar ventas
                            System.out.print("Cuantos kilogramos de azucar desea?: "); 
                            int cantidadVenta=lea.nextInt();
                            //veces ingresadas
                            ingresoV++;
                            
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
                                
                                impuesto=cobroV*0.07;
                                total=(cobroV+impuesto)-descuento;

                                System.out.println("Subtotal: "+cobroV+
                                                   "\nISV 7%: "+String.format("%.2f", impuesto)+
                                                   "\nDescuento"+porcentaje+"%: "+String.format("%.2f", descuento)+
                                                   "\nTotal: L."+String.format("%.2f", total));
                                
                                if(cantidadVenta>azucarKg||cantidadVenta<=0){
                                    System.out.println("No tienes esa cantidad a vender");
                                }else{
                                    //suma para caja
                                    billete+=total;
                                    vecesV++;
                                    volumenV+=total;
                                    dineroAzucar+=total;
                                    while(mayorV<total){
                                        mayorV=total;
                                    }
                                    azucarKg-=cantidadVenta;
                                    azucarSell+=cantidadVenta;
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
                            //veces ingresadas
                            ingresoV++;
                            
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
                                
                                impuesto=cobroV*0.07;
                                total=(cobroV+impuesto)-descuento;

                                System.out.println("Subtotal: "+cobroV+
                                                   "\nISV 7%: "+String.format("%.2f", impuesto)+
                                                   "\nDescuento"+porcentaje+"%: "+String.format("%.2f", descuento)+
                                                   "\nTotal: L."+String.format("%.2f", total));
                                
                                if(cantidadVenta>avenaKg||cantidadVenta<=0){
                                    System.out.println("No tienes esa cantidad a vender");
                                }else{
                                    //suma para caja
                                    billete+=total;
                                    vecesV++;
                                    volumenV+=total;
                                    dineroAvena+=total;
                                    while(mayorV<total){
                                        mayorV=total;
                                    }
                                    avenaKg-=cantidadVenta;
                                    avenaSell+=cantidadVenta;
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
                            //veces ingresadas
                            ingresoV++;
                            
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
                                
                                impuesto=cobroV*0.07;
                                total=(cobroV+impuesto)-descuento;

                                System.out.println("Subtotal: "+cobroV+
                                                   "\nISV 7%: "+String.format("%.2f", impuesto)+
                                                   "\nDescuento"+porcentaje+"%: "+String.format("%.2f", descuento)+
                                                   "\nTotal: L."+String.format("%.2f", total));
                                
                                if(cantidadVenta>trigoKg||cantidadVenta<=0){
                                    System.out.println("No tienes esa cantidad a vender");
                                }else{
                                    //suma para caja
                                    billete+=total;
                                    vecesV++;
                                    volumenV+=total;
                                    dineroTrigo+=total;
                                    while(mayorV<total){
                                        mayorV=total;
                                    }
                                    trigoKg-=cantidadVenta;
                                    trigoSell+=cantidadVenta;
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
                        //cliente C ventas
                        System.out.println("");
                        System.out.println("Los productos para el cliente C: ");
                        System.out.println("************************************************************");
                        System.out.println("* Codigo *     Producto     *   Precio venta  * kilogramos *");
                        System.out.println("************************************************************");
                        System.out.println("*   4    *      Maiz        *       L.20      *     "+maizKg+"    *");
                        System.out.println("************************************************************");
                        System.out.println("");
                        do{
                        System.out.print("Ingresar codigo del producto: ");
                        int codigoV=lea.nextInt();
                        //veces ingresadas
                        ingresoV++;
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
                                
                                impuesto=cobroV*0.07;
                                total=(cobroV+impuesto)-descuento;

                                System.out.println("Subtotal: "+cobroV+
                                                   "\nISV 7%: "+String.format("%.2f", impuesto)+
                                                   "\nDescuento"+porcentaje+"%: "+String.format("%.2f", descuento)+
                                                   "\nTotal: L."+String.format("%.2f", total));
                                
                                if(cantidadVenta>maizKg||cantidadVenta<=0){
                                    System.out.println("No tienes esa cantidad a vender");
                                }else{
                                    //suma para caja
                                    billete+=total;
                                    vecesV++;
                                    volumenV+=total;
                                    dineroMaiz+=total;
                                    while(mayorV<total){
                                        mayorV=total;
                                    }
                                    maizKg-=cantidadVenta;
                                    maizSell+=cantidadVenta;
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
                        System.out.println("************************************************************");
                        System.out.println("* Codigo *     Producto     *  Precio Compra  * kilogramos *");
                        System.out.println("************************************************************");
                        System.out.println("*   1    *      Azucar      *       L.25      *     "+azucarKg+"    *");
                        System.out.println("************************************************************");
                        System.out.println("*   4    *       Maiz       *       L.18      *     "+maizKg+"    *");
                        System.out.println("************************************************************");
                        System.out.println("");
                        System.out.print("Ingresar codigo del producto: ");
                        int codigoC=lea.nextInt();
                        
                        //cliente A compras
                        
                        if(codigoC==1){
                            System.out.print("Cuantos kilogramos desea de azucar?: ");
                            int cantidadCompras=lea.nextInt();
                            //cobro 
                            cobroC=cantidadCompras*azucarCompra;
                            
                            //cantidadKg+=cantidadCompras;
                            if(billete>=cobroC){
                                //factura
                                total=cobroC;
                                
                                //ganancias y perdidas
                                azucarKg+=cantidadCompras;
                                if(total>billete||cantidadCompras<=0){
                                    System.out.println("No se puede realizar la compra sin suficiente dinero"); 
                                }else{
                                    System.out.println("Cantidad comprada: "+cantidadCompras+" kg."+
                                                       "\nTotal: L."+total);
                                    billete-=cobroC; 
                                    ingresoC++;
                                    volumenC+=total;
                                    dineroAzucar-=total;
                                    while(mayorC<total){
                                        mayorC=total;
                                    }
                                }
                            }else{
                                System.out.println("No tienes suficiente para comprar! ");
                                System.out.println("Tu subtotal es de: L."+cobroC+" mas el impuesto");
                                System.out.println("Tu dinero es de: "+billete);
                            }
                        }else if(codigoC==4){
                            System.out.print("Cuantos kilogramos desea de Maiz?: ");
                            int cantidadCompras=lea.nextInt();
                            cobroC=cantidadCompras*maizCompra;
                            //cantidadKg+=cantidadCompras;
                            if(billete>=cobroC){
                                //factura
                                total=cobroC;
                                
                                //ganancias y perdidas
                                maizKg+=cantidadCompras;
                                if(total>billete||cantidadCompras<=0){
                                    System.out.println("No se puede realizar la compra sin suficiente dinero"); 
                                }else{
                                    System.out.println("Subtotal: L."+cobroC+
                                                       "\nTotal: L."+total);
                                    billete-=cobroC;
                                    ingresoC++;
                                    volumenC+=total;
                                    dineroMaiz-=total;
                                    while(mayorC<total){
                                        mayorC=total;
                                    }
                                }
                            }else{
                                System.out.println("No tienes suficiente para comprar! ");
                                System.out.println("Tu subtotal es de: L."+cobroC+" mas el impuesto");
                                System.out.println("Tu dinero es de: "+billete);
                            }
                        }else{
                            System.out.println("No cuento con dicho producto.");
                            
                        }
                    }else if(proveedor.equalsIgnoreCase("b")){
                        System.out.println("Los productos disponibles para Comprar: ");
                        System.out.println("************************************************************");
                        System.out.println("* Codigo *     Producto     *  Precio Compra  * kilogramos *");
                        System.out.println("************************************************************");
                        System.out.println("*        *                  *    A:   L.20    *");
                        System.out.println("*   2    *      Avena       *                 *     "+avenaKg+"    *");
                        System.out.println("*        *                  *    B:   L.22    *");
                        System.out.println("************************************************************");
                        System.out.println("*   3    *      Trigo       *       L.30      *     "+trigoKg+"    *");
                        System.out.println("************************************************************");
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
                                    total=cobroC;

                                    //ganancias y perdidas
                                    avenaKg+=cantidadCompras;
                                    if(total>billete||cantidadCompras<=0){
                                        System.out.println("No se puede realizar la compra sin suficiente dinero"); 
                                    }else{
                                        System.out.println("Subtotal: L."+cobroC+
                                                       "\nTotal: L."+total);
                                        billete-=cobroC;
                                        ingresoC++;
                                        volumenC+=total;
                                        dineroAvena-=total;
                                        while(mayorC<total){
                                            mayorC=total;
                                        }
                                    }
                                }else{
                                    System.out.println("No tienes suficiente para comprar! ");
                                    System.out.println("Tu subtotal es de: L."+cobroC+" mas el impuesto");
                                    System.out.println("Tu dinero es de: "+billete);
                                }
                                
                            }else if(avenaOpcion.equalsIgnoreCase("b")){
                                System.out.print("Cuantos kilogramos de trigo quisiera llevar?: ");
                                int cantidadCompras=lea.nextInt();
                                cobroC=cantidadCompras*avenacompraB;
                                
                                if(billete>=cobroC){
                                //factura
                                    total=cobroC;

                                    //ganancias y perdidas
                                    avenaKg+=cantidadCompras;
                                    if(total>billete||cantidadCompras<=0){
                                        System.out.println("No se puede realizar la compra sin suficiente dinero"); 
                                    }else{
                                        System.out.println("Subtotal: L."+cobroC+
                                                       "\nTotal: L."+total);
                                        billete-=cobroC;
                                        ingresoC++;
                                        volumenC+=total;
                                        dineroAvena-=total;
                                        while(mayorC<total){
                                            mayorC=total;
                                        }
                                    }
                                }else{
                                    System.out.println("No tienes suficiente para comprar! ");
                                    System.out.println("Tu subtotal es de: L."+cobroC+" mas el impuesto");
                                    System.out.println("Tu dinero es de: "+billete);
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
                                total=cobroC;
                                
                                //ganancias y perdidas
                                trigoKg+=cantidadCompras;
                                if(total>billete||cantidadCompras<=0){
                                    System.out.println("No se puede realizar la compra sin suficiente dinero"); 
                                }else{
                                    System.out.println("Subtotal: L."+cobroC+
                                                       "\nTotal: L."+total);
                                    billete-=cobroC;
                                    ingresoC++;
                                    volumenC+=total;
                                    dineroTrigo-=total;
                                    while(mayorC<total){
                                        mayorC=total;
                                    }
                                }
                            }else{
                                System.out.println("No tienes suficiente para comprar! ");
                                System.out.println("Tu subtotal es de: L."+cobroC+" mas el impuesto");
                                System.out.println("Tu dinero es de: "+billete);
                            }
                        }else{
                            System.out.println("No cuento con dicho producto.");
                        }
                        
                    }else if(proveedor.equalsIgnoreCase("c")){
                        System.out.println("Los productos disponibles para Comprar: ");
                        System.out.println("************************************************************");
                        System.out.println("* Codigo *     Producto     *  Precio Compra  * kilogramos *");
                        System.out.println("************************************************************");
                        System.out.println("*        *                  *    A:   L.20    *");
                        System.out.println("*   2    *      Avena       *                 *     "+avenaKg+"    *");
                        System.out.println("*        *                  *    B:   L.22    *");
                        System.out.println("************************************************************");
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
                                    total=cobroC;
                                    
                                    //ganancias y perdidas
                                    avenaKg+=cantidadCompras;
                                    if(total>billete||cantidadCompras<=0){
                                        System.out.println("No se puede realizar la compra sin suficiente dinero"); 
                                    }else{
                                        System.out.println("Subtotal: L."+cobroC+
                                                           "\nTotal: L."+total);
                                        billete-=cobroC;
                                        ingresoC++;
                                        volumenC+=total;
                                        dineroAvena-=total;
                                        while(mayorC<total){
                                            mayorC=total;
                                        }
                                    }
                                }else{
                                    System.out.println("No tienes suficiente para comprar! ");
                                    System.out.println("Tu subtotal es de: L."+cobroC+" mas el impuesto");
                                    System.out.println("Tu dinero es de: "+billete);
                                }
                                //cantidadKg+=cantidadCompras;
                            }else if(avenaOpcion.equalsIgnoreCase("b")){
                                System.out.print("Cuantos kilogramos de avena desea llevar?: ");
                                int cantidadCompras=lea.nextInt();
                                cobroC=cantidadCompras*avenacompraB;
                                //cantidadKg+=cantidadCompras;
                                if(billete>=cobroC){
                                //factura
                                    total=cobroC;
                                    //ganancias y perdidas
                                    avenaKg+=cantidadCompras;
                                    if(total>billete||cantidadCompras<=0){
                                        System.out.println("No se puede realizar la compra sin suficiente dinero"); 
                                    }else{
                                        System.out.println("Subtotal: L."+cobroC+
                                                       "\nTotal: L."+total);
                                        ingresoC++;
                                        billete-=cobroC;
                                        volumenC+=total;
                                        dineroAvena-=total;
                                        while(mayorC<total){
                                            mayorC=total;
                                        }
                                    }
                                }else{
                                    System.out.println("No tienes suficiente para comprar! ");
                                    System.out.println("Tu subtotal es de: L."+cobroC+" mas el impuesto");
                                    System.out.println("Tu dinero es de: "+billete);
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
                System.out.println("***********************REPORTES*******************************");
                //a
                System.out.println("La cantidad actual en caja es de: L."+billete);
                //b
                System.out.println("Numero de Compras realizadas en el dia: "+ingresoC+
                                   "\nNumero de Ventas realizadas en el dia: "+ingresoV);
                //c
                margenGana=(volumenV-volumenC/volumenV)*100;
                if(volumenV<=0){
                    margenGana=0;
                }
                System.out.println("Volumen total de Compras efectuadas antes del cierre: "+volumenC+
                                   "\nVolumen total de Ventas efectuadas antes del cierre: "+volumenV+
                                   "\nEl margen de ganancia: "+String.format("%.2f", margenGana)+"% ");
                //d
                promedioV=(volumenV/vecesV);
                promedioC=(volumenC/vecesC);
                System.out.println("Valor Medio de Compra: "+String.format("%.2f",promedioC)+"% "+
                                   "% \nValor Medio de Venta. "+String.format("%.2f",promedioV)+"% ");
                //e
                System.out.println("La venta con mayor ganancia realizada: "+mayorV+
                                   "\nLa compra con mas gasto efectuada: "+mayorC);
                //f
                if(dineroAzucar>dineroAvena&&dineroAzucar>dineroTrigo&&dineroAzucar>dineroMaiz){
                    System.out.println("Producto estrella: Azucar con "+azucarSell+"kg(s)");    
                }else if(dineroAvena>dineroAzucar&&dineroAvena>dineroTrigo&&dineroAvena>dineroMaiz){
                    System.out.println("Producto estrella: Avena con "+avenaSell+"kg(s)");
                }else if(dineroTrigo>dineroAzucar&&dineroTrigo>dineroAvena&&dineroTrigo>dineroMaiz){
                    System.out.println("Producto estrella: Trigo con "+trigoSell+"kg(s)");
                }else if(dineroMaiz>dineroAzucar&&dineroMaiz>dineroAvena&&dineroMaiz>dineroTrigo){
                    System.out.println("Producto estrella: Maiz con "+maizSell+"kg(s)");
                }else {
                    System.out.println("No hay producto estrella");
                }
                //g
                System.out.println("Ranking: ");
                /*
                    1 - Azucar
                    1 - Avena
                    1 - Trigo
                    1 - Maiz
                */
                if(dineroAzucar==dineroAvena&&dineroAzucar==dineroTrigo&&dineroAzucar==dineroMaiz){
                    System.out.println("#1 Azucar\n#1 Avena\n#1 Trigo\n#1 Maiz");
                /*
                    1 - Azucar
                    2 - Avena
                    3 - Trigo
                    4 - Maiz
                */
                }else if((dineroAzucar>dineroAvena&&dineroAzucar>dineroTrigo&&dineroAzucar>dineroMaiz)&&(dineroAvena==dineroTrigo&&dineroAvena==dineroMaiz)){
//                    if(dineroAvena==dineroTrigo&&dineroAvena==dineroMaiz){
                        System.out.println("#1 Azucar\n#2 Avena\n#2 Trigo\n#2 Maiz");
//                    }
                }else if((dineroAzucar>dineroAvena&&dineroAzucar>dineroTrigo&&dineroAzucar>dineroMaiz)&&(dineroAvena>dineroTrigo&&dineroAvena>dineroMaiz)&&(dineroTrigo==dineroMaiz)){
//                    if(dineroAvena>dineroTrigo&&dineroAvena>dineroMaiz){
//                        if(dineroTrigo==dineroMaiz){
                            System.out.println("#1 Azucar\n#2 Avena\n#3 Trigo\n#3 Maiz");
//                        }
//                    }
                }else if((dineroAzucar>dineroAvena&&dineroAzucar>dineroTrigo&&dineroAzucar>dineroMaiz)&&(dineroAvena>dineroTrigo&&dineroAvena>dineroMaiz)&&(dineroTrigo>dineroMaiz)){
//                    if(dineroAvena>dineroTrigo&&dineroAvena>dineroMaiz){
//                        if(dineroTrigo>dineroMaiz){
                            System.out.println("#1 Azucar\n#2 Avena\n#3 Trigo\n#4 Maiz");
//                        }
//                    }
                }else{
                    /*
                        1-Avena
                        2-Azucar
                        3-Trigo
                        4-Maiz
                    */
                    if((dineroAvena>dineroAzucar&&dineroAvena>dineroTrigo&&dineroAvena>dineroMaiz)&&(dineroAzucar==dineroTrigo&&dineroAzucar==dineroMaiz)){
//                        if(dineroAzucar==dineroTrigo&&dineroAzucar==dineroMaiz){
                            System.out.println("#1 Avena\n#2 Azucar\n#2 Trigo\n#2 Maiz");
//                        }
                    }else if((dineroAvena>dineroAzucar&&dineroAvena>dineroTrigo&&dineroAvena>dineroMaiz)&&(dineroAzucar>dineroTrigo&&dineroAzucar>dineroMaiz)&&(dineroTrigo==dineroMaiz)){
//                        if(dineroAzucar>dineroTrigo&&dineroAzucar>dineroMaiz){
//                            if(dineroTrigo==dineroMaiz){
                                System.out.println("#1 Avena\n#2 Azucar\n#3 Trigo\n#3 Maiz");
//                            }
//                        }
                    }else if((dineroAvena>dineroAzucar&&dineroAvena>dineroTrigo&&dineroAvena>dineroMaiz)&&(dineroAzucar>dineroTrigo&&dineroAzucar>dineroMaiz)&&(dineroTrigo>dineroMaiz)){
//                        if(dineroAzucar>dineroTrigo&&dineroAzucar>dineroMaiz){
//                            if(dineroTrigo>dineroMaiz){
                                System.out.println("#1 Avena\n#2 Azucar\n#3 Trigo\n#4 Maiz");
//                            }
//                        }
                    }else{
                        /*
                            1-Trigo
                            2-Azucar
                            3-Avena
                            4-Maiz
                        */
                        if((dineroTrigo>dineroAzucar&&dineroTrigo>dineroAvena&&dineroTrigo>dineroMaiz)&&(dineroAzucar==dineroAvena&&dineroAzucar==dineroMaiz)){
                            System.out.println("#1 Trigo\n#2 Azucar\n#2 Avena\n#2 Maiz");
                        }else if((dineroTrigo>dineroAzucar&&dineroTrigo>dineroAvena&&dineroTrigo>dineroMaiz)&&(dineroAzucar>dineroAvena&&dineroAzucar>dineroMaiz)&&(dineroAvena==dineroMaiz)){
                            System.out.println("#1 Trigo\n#2 Azucar\n#3 Avena\n#3 Maiz");
                        }else if((dineroTrigo>dineroAzucar&&dineroTrigo>dineroAvena&&dineroTrigo>dineroMaiz)&&(dineroAzucar>dineroAvena&&dineroAzucar>dineroMaiz)&&(dineroAvena>dineroMaiz)){
                            System.out.println("#1 Trigo\n#2 Azucar\n#3 Avena\n#4 Maiz");
                        }else{
                        /*
                            1-Maiz
                            2-Azucar
                            3-Avena
                            4-Trigo
                        */
                            if((dineroMaiz>dineroAzucar&&dineroMaiz>dineroAvena&&dineroMaiz>dineroTrigo)&&(dineroAzucar==dineroAvena&&dineroAzucar==dineroTrigo)){
                                System.out.println("#1 Maiz\n#2 Azucar\n#2 Avena\n#2 Trigo");
                            }else if((dineroMaiz>dineroAzucar&&dineroMaiz>dineroAvena&&dineroMaiz>dineroTrigo)&&(dineroAzucar>dineroAvena&&dineroAzucar>dineroTrigo)&&(dineroAvena==dineroTrigo)){
                                System.out.println("#1 Maiz\n#2 Azucar\n#3 Avena\n#3 Trigo");
                            }else if((dineroMaiz>dineroAzucar&&dineroMaiz>dineroAvena&&dineroMaiz>dineroTrigo)&&(dineroAzucar>dineroAvena&&dineroAzucar>dineroTrigo)&&(dineroAvena>dineroTrigo)){
                                System.out.println("#1 Maiz\n#2 Azucar\n#3 Avena\n#4 Trigo");
                            }else{
                            /*
                                1-Azucar
                                2-Trigo
                                3-Avena
                                4-Maiz
                            */
                               if((dineroAzucar>dineroTrigo&&dineroAzucar>dineroAvena&&dineroAzucar>dineroMaiz)&&(dineroTrigo>dineroAvena&&dineroTrigo>dineroMaiz)&&(dineroAvena==dineroMaiz)){
                                   System.out.println("#1 Azucar\n#2 Trigo\n#3 Avena\n#3 Maiz");
                               }else  if((dineroAzucar>dineroTrigo&&dineroAzucar>dineroAvena&&dineroAzucar>dineroMaiz)&&(dineroTrigo>dineroAvena&&dineroTrigo>dineroMaiz)&&(dineroAvena>dineroMaiz)){
                                   System.out.println("#1 Azucar\n#2 Trigo\n#3 Avena\n#4 Maiz");
                               }else{
                                /*
                                    1-Maiz
                                    2-Azucar
                                    3-Trigo
                                    4-Avena
                                */
                                    if((dineroMaiz>dineroAzucar&&dineroMaiz>dineroAvena&&dineroMaiz>dineroTrigo)&&(dineroAzucar>dineroTrigo&&dineroAzucar>dineroAvena)&&(dineroTrigo==dineroAvena)){
                                        System.out.println("#1 Maiz\n#2 Azucar\n#3 Trigo\n#3 Avena");
                                    }else if((dineroMaiz>dineroAzucar&&dineroMaiz>dineroAvena&&dineroMaiz>dineroTrigo)&&(dineroAzucar>dineroTrigo&&dineroAzucar>dineroAvena)&&(dineroTrigo>dineroAvena)){
                                        System.out.println("#1 Maiz\n#2 Azucar\n#3 Trigo\n#4 Avena");
                                    }else{
                                    /*
                                        1-Azucar
                                        2-Maiz
                                        3-Avena
                                        4-Trigo
                                    */
                                        if((dineroAzucar>dineroMaiz&&dineroAzucar>dineroAvena&&dineroAzucar>dineroTrigo)&&(dineroMaiz>dineroAvena&&dineroMaiz>dineroTrigo)&&(dineroAvena==dineroTrigo)){
                                            System.out.println("#1 Azucar\n#2 Maiz\n#3 Avena\n#3 Trigo");
                                        }else if((dineroAzucar>dineroMaiz&&dineroAzucar>dineroAvena&&dineroAzucar>dineroTrigo)&&(dineroMaiz>dineroAvena&&dineroMaiz>dineroTrigo)&&(dineroAvena>dineroTrigo)){
                                            System.out.println("#1 Azucar\n#2 Maiz\n#3 Avena\n#4 Trigo");
                                        }else{
                                        /*
                                            1-Avena
                                            2-Azucar
                                            3-Maiz
                                            4-Trigo
                                        */
                                            if((dineroAvena>dineroAzucar&&dineroAvena>dineroMaiz&&dineroAvena>dineroTrigo)&&(dineroAzucar>dineroMaiz&&dineroAzucar>dineroTrigo)&&(dineroMaiz==dineroTrigo)){
                                                System.out.println("#1 Avena\n#2 Azucar\n#3 Maiz\n#3 Trigo");
                                            }else if((dineroAvena>dineroAzucar&&dineroAvena>dineroMaiz&&dineroAvena>dineroTrigo)&&(dineroAzucar>dineroMaiz&&dineroAzucar>dineroTrigo)&&(dineroMaiz>dineroTrigo)){
                                                System.out.println("#1 Avena\n#2 Azucar\n#3 Maiz\n#4 Trigo");
                                            }else{
                                            /*
                                                1-Trigo
                                                2-Azucar
                                                3-Maiz
                                                4-Avena
                                            */
                                                if((dineroTrigo>dineroAzucar&&dineroTrigo>dineroMaiz&&dineroTrigo>dineroAvena)&&(dineroAzucar>dineroMaiz&&dineroAzucar>dineroAvena)&&(dineroMaiz==dineroAvena)){
                                                    System.out.println("#1 Trigo\n#2 Azucar\n#3 Maiz\n#3 Avena");
                                                }else if((dineroTrigo>dineroAzucar&&dineroTrigo>dineroMaiz&&dineroTrigo>dineroAvena)&&(dineroAzucar>dineroMaiz&&dineroAzucar>dineroAvena)&&(dineroMaiz>dineroAvena)){
                                                    System.out.println("#1 Trigo\n#2 Azucar\n#3 Maiz\n#4 Avena");
                                                }else{
                                                /*
                                                    1-Avena
                                                    2-Trigo
                                                    3-Azucar
                                                    4-Maiz
                                                */
                                                    if((dineroAvena>dineroAzucar&&dineroAvena>dineroMaiz&&dineroAvena>dineroTrigo)&&(dineroTrigo>dineroAzucar&&dineroTrigo>dineroMaiz)&&(dineroAzucar==dineroMaiz)){
                                                        System.out.println("#1 Avena\n#2 Trigo\n#3 Azucar\n#3 Maiz");
                                                    }else if((dineroAvena>dineroAzucar&&dineroAvena>dineroMaiz&&dineroAvena>dineroTrigo)&&(dineroTrigo>dineroAzucar&&dineroTrigo>dineroMaiz)&&(dineroAzucar>dineroMaiz)){
                                                        System.out.println("#1 Avena\n#2 Trigo\n#3 Azucar\n#4 Maiz");
                                                    }else if((dineroAvena>dineroAzucar&&dineroAvena>dineroMaiz&&dineroAvena>dineroTrigo)&&(dineroTrigo>dineroAzucar&&dineroTrigo>dineroMaiz)&&(dineroAzucar<dineroMaiz)){
                                                    /*
                                                        1-Avena
                                                        2-Trigo
                                                        3-Maiz
                                                        4-Azucar
                                                    */
                                                        System.out.println("#1 Avena\n#2 Trigo\n#3 Maiz\n#4 Azucar");
                                                    }else{
                                                        /*
                                                            1-Maiz
                                                            2-Trigo
                                                            3-Azucar    
                                                            4-Avena
                                                        */  
                                                        if((dineroMaiz>dineroAzucar&&dineroMaiz>dineroAvena&&dineroMaiz>dineroTrigo)&&(dineroTrigo>dineroAzucar&&dineroTrigo>dineroAvena)&&(dineroAzucar==dineroAvena)){
                                                            System.out.println("#1 Maiz\n#2 Trigo\n#3 Azucar\n#3 Avena");
                                                        }else if((dineroMaiz>dineroAzucar&&dineroMaiz>dineroAvena&&dineroMaiz>dineroTrigo)&&(dineroTrigo>dineroAzucar&&dineroTrigo>dineroAvena)&&(dineroAzucar>dineroAvena)){
                                                            System.out.println("#1 Maiz\n#2 Trigo\n#3 Azucar\n#4 Avena");
                                                        }else if((dineroMaiz>dineroAzucar&&dineroMaiz>dineroAvena&&dineroMaiz>dineroTrigo)&&(dineroTrigo>dineroAzucar&&dineroTrigo>dineroAvena)&&(dineroAzucar<dineroAvena)){
                                                        /*
                                                            1-Maiz
                                                            2-Trigo
                                                            3-Avena    
                                                            4-Azucar
                                                        */ 
                                                            System.out.println("#1 Maiz\n#2 Trigo\n#3 Avena\n#4 Azucar");
                                                        }else{
                                                            
                                                        }
                                                    
                                                    }
                                                }
                                            }
                                        }
                                    }
                               }
                            }
                        }
                    }
                }
                
             
                    
                
            }else if(opcion==5){
                //ganancia total variable
                double gananciaT=0;
                //formula para sacar dicha ganancia
                gananciaT=volumenV-volumenC;
                //evitar que de negativo
                if(gananciaT<0){
                    gananciaT=0;
                }
                //salida de pantalla
                System.out.println("CIERRE DE CAJA");
                System.out.println("Ganancia total: "+gananciaT);
                System.out.println("");
                System.out.print("Ingresar cantidad de dinero al banco: L.");
                double guardar=lea.nextInt();
                
                //formula para ingresar el 60 porciento del dinero
                ingresar=billete*0.6;
                
                if(guardar<=billete&&guardar<=ingresar){
                    billete-=guardar;
                    banco+=guardar;
                }else{
                    System.out.println("Solo se permite guardar el 60% en el banco");
                }
            }else{
                System.out.println("Ya estuvo!");
            }
        }
    }
}
