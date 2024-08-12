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
        int oportunidadDiaria=1;
        
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
            double promedioV=0;
            double promedioC=0;
            //e
            double mayorV=0;
            double mayorC=00;
            //f
            String starProduct="";
            double dineroAzucar=0;
            double dineroAvena=0;
            double dineroTrigo=0;
            double dineroMaiz=0;
            //g
            double primerLugar = Integer.MIN_VALUE;
            double segundoLugar = Integer.MIN_VALUE;
            double tercerLugar = Integer.MIN_VALUE;
            double cuartoLugar = Integer.MIN_VALUE;
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
                System.out.println("ABRISTE CAJA! ");
                System.out.println("");
                if(oportunidadDiaria==1){
                    do{
                    System.out.print("Ingresar dinero en caja: L.");
                    caja=lea.nextDouble();
                    
                    if(caja<18){
                        System.out.println("Acuerdate que debes ingresar dinero suficiente.\nPara almenos comprar uno barato.");
                    }
                    
                    }while(caja<18);
                    oportunidadDiaria--;
                }
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
                                    ingresoV++;
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
                                    ingresoV++;
                                    volumenV+=total;
                                    dineroAvena+=total;
                                    avenaKg-=cantidadVenta;
                                    avenaSell+=cantidadVenta;
                                }
                            }else{
                                System.out.println("");
                                System.out.println("No cuentas con lo suficiente!");
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
                                    ingresoV++;
                                    volumenV+=total;
                                    dineroTrigo+=total;
                                    trigoKg-=cantidadVenta;
                                    trigoSell+=cantidadVenta;
                                }
                            }else{
                                System.out.println("");
                                System.out.println("No cuentas con lo suficiente!");
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
                                    ingresoV++;
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
                            }
                        }else{
                            System.out.println("Escoge un codigo dentro de las opciones la proxima vez!");
                        }
                        System.out.print("Deseas comprar otro producto? (SI/NO): ");
                        decision=lea.next().toLowerCase();
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
                                    ingresoV++;
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
                                    ingresoV++;
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
                                    ingresoV++;
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
                            }
                        }else{
                            System.out.println("No");
                        }
                        System.out.print("Deseas comprar otro producto? (SI/NO): ");
                        decision=lea.next().toLowerCase();
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
                                    ingresoV++;
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
                            }
                        }
                        System.out.print("Deseas comprar otro producto? (SI/NO): ");
                        decision=lea.next().toLowerCase();
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
                                if(total>billete||cantidadCompras<=0){
                                    System.out.println("No se puede realizar la compra sin suficiente dinero"); 
                                }else{
                                    System.out.println("Cantidad comprada: "+cantidadCompras+" kg."+
                                                       "\nTotal: L."+total);
                                    azucarKg+=cantidadCompras;
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
                                System.out.println("Tu subtotal es de: L."+cobroC);
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

                                if(total>billete||cantidadCompras<=0){
                                    System.out.println("No se puede realizar la compra sin suficiente dinero"); 
                                }else{
                                    System.out.println("Cantidad comprada: "+cantidadCompras+" kg."+
                                                       "\nTotal: L."+total);
                                    maizKg+=cantidadCompras;
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
                                System.out.println("Tu subtotal es de: L."+cobroC);
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

                                    if(total>billete||cantidadCompras<=0){
                                        System.out.println("No se puede realizar la compra sin suficiente dinero"); 
                                    }else{
                                        System.out.println("Cantidad comprada: "+cantidadCompras+" kg."+
                                                       "\nTotal: L."+total);
                                        avenaKg+=cantidadCompras;
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
                                    System.out.println("Tu subtotal es de: L."+cobroC);
                                    System.out.println("Tu dinero es de: "+billete);
                                }
                                
                            }else if(avenaOpcion.equalsIgnoreCase("b")){
                                System.out.print("Cuantos kilogramos de trigo quisiera llevar?: ");
                                int cantidadCompras=lea.nextInt();
                                cobroC=cantidadCompras*avenacompraB;
                                
                                if(billete>=cobroC){
                                //factura
                                    total=cobroC;

                                    if(total>billete||cantidadCompras<=0){
                                        System.out.println("No se puede realizar la compra sin suficiente dinero"); 
                                    }else{
                                        System.out.println("Cantidad comprada: "+cantidadCompras+" kg."+
                                                       "\nTotal: L."+total);
                                        avenaKg+=cantidadCompras;
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
                                    System.out.println("Tu subtotal es de: L."+cobroC);
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
                                
                                if(total>billete||cantidadCompras<=0){
                                    System.out.println("No se puede realizar la compra sin suficiente dinero"); 
                                }else{
                                    System.out.println("Cantidad comprada: "+cantidadCompras+" kg."+
                                                       "\nTotal: L."+total);
                                    trigoKg+=cantidadCompras;
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
                                System.out.println("Tu subtotal es de: L."+cobroC);
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
                                    
                                    if(total>billete||cantidadCompras<=0){
                                        System.out.println("No se puede realizar la compra sin suficiente dinero"); 
                                    }else{
                                        System.out.println("Cantidad comprada: "+cantidadCompras+" kg."+
                                                       "\nTotal: L."+total);
                                        avenaKg+=cantidadCompras;
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
                                    System.out.println("Tu subtotal es de: L."+cobroC);
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
                                    if(total>billete||cantidadCompras<=0){
                                        System.out.println("No se puede realizar la compra sin suficiente dinero"); 
                                    }else{
                                        System.out.println("Cantidad comprada: "+cantidadCompras+" kg."+
                                                       "\nTotal: L."+total);
                                        avenaKg+=cantidadCompras;
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
                                    System.out.println("Tu subtotal es de: L."+cobroC);
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
                System.out.println("La cantidad actual en caja es de: L."+String.format("%.2f", billete));
                //b
                System.out.println("Numero de Compras realizadas en el dia: "+ingresoC+
                                   "\nNumero de Ventas realizadas en el dia: "+ingresoV);
                //c
                margenGana=(volumenV-volumenC/volumenV)*100;
                if(volumenV<=0){
                    margenGana=0;
                }
                System.out.println("Volumen total de Compras efectuadas antes del cierre: "+String.format("%.2f", volumenC)+
                                   "\nVolumen total de Ventas efectuadas antes del cierre: "+String.format("%.2f", volumenV)+
                                   "\nEl margen de ganancia: "+String.format("%.2f", margenGana)+"% ");
                //d
                promedioV=(volumenV/ingresoV);
                promedioC=(volumenC/ingresoC);
                System.out.println("Valor Medio de Compra: "+String.format("%.2f",promedioC)+"% "+
                                   "% \nValor Medio de Venta. "+String.format("%.2f",promedioV)+"% ");
                //e
                System.out.println("La venta con mayor ganancia realizada: "+mayorV+
                                   "\nLa compra con mas gasto efectuada: "+mayorC);
                //f
                if(dineroAzucar>dineroAvena&&dineroAzucar>dineroTrigo&&dineroAzucar>dineroMaiz){
                    starProduct="Azucar";    
                }else if(dineroAvena>dineroAzucar&&dineroAvena>dineroTrigo&&dineroAvena>dineroMaiz){
                    starProduct="Avena"; 
                }else if(dineroTrigo>dineroAzucar&&dineroTrigo>dineroAvena&&dineroTrigo>dineroMaiz){
                    starProduct="Trigo"; 
                }else if(dineroMaiz>dineroAzucar&&dineroMaiz>dineroAvena&&dineroMaiz>dineroTrigo){
                    starProduct="Maiz"; 
                //si es distinto a vacio, entonces entra
                }
                if(!starProduct.isEmpty()){
                    System.out.println("Producto estrella: "+starProduct+" con "+
                                       (starProduct.equals("Azucar")?azucarSell: starProduct.equals("Avena")?avenaSell:starProduct.equals("Trigo")?trigoSell:maizSell+
                                       " kg(s)."));
                }else{
                    System.out.println("No hay producto estrella");
                }
                //g
                System.out.println("Ranking: ");
                String productOne="";
                String productTwo="";
                String productThree="";
                String productFour="";
                
                for (int i = 0; i < 4; i++) {
                    double puntosActuales = 0;
                    switch (i) {
                        case 0:
                            puntosActuales = dineroAzucar;
                            productOne="Azucar";
                            break;
                        case 1:
                            puntosActuales = dineroAvena;
                            productTwo="Avena";
                            break;
                        case 2:
                            puntosActuales = dineroTrigo;
                            productThree="Trigo";
                            break;
                        case 3:
                            puntosActuales = dineroMaiz;
                            productFour="Maiz";
                            break;
                    }
                        if (puntosActuales > primerLugar) {
                            cuartoLugar = tercerLugar;
                            tercerLugar = segundoLugar;
                            segundoLugar = primerLugar;
                            primerLugar = puntosActuales;
                        } else if (puntosActuales > segundoLugar) {
                            cuartoLugar = tercerLugar;
                            tercerLugar = segundoLugar;
                            segundoLugar = puntosActuales;
                        } else if (puntosActuales > tercerLugar) {
                            cuartoLugar = tercerLugar;
                            tercerLugar = puntosActuales;
                        } else if (puntosActuales > cuartoLugar) {
                            cuartoLugar = puntosActuales;
                        }
                }
                        System.out.println("\nRanking:");
                        System.out.println("1. " + primerLugar + " puntos");
                        System.out.println("2. " + segundoLugar + " puntos");
                        System.out.println("3. " + tercerLugar + " puntos");
                        System.out.println("4. " + cuartoLugar + " puntos");
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
                System.out.println("Ganancia total: "+String.format("%.2f", gananciaT));
                System.out.println("");
                System.out.print("Ingresar cantidad de dinero al banco\nSolo el 60% de los ingresos: L.");
                double guardar=lea.nextInt();
                
                //formula para ingresar el 60 porciento del dinero
                ingresar=billete*0.6;
                
                if(guardar<=billete&&guardar<=ingresar){
                    billete-=guardar;
                    banco+=guardar;
                }else{
                    System.out.println("Solo se permite guardar el 60% en el banco");
                }
        
        billete=0;
        banco=0;
        ingresar=0;
        oportunidadDiaria=1;
        
        //cantidad en kilogramos
        azucarKg=0;
        avenaKg=0;
        trigoKg=0;
        maizKg=0;
        
        azucarSell=0;
        avenaSell=0;
        trigoSell=0;
        maizSell=0; 
        //Precios productos venta
        
        cobroV=0;
        decision="no";
        //Precios productos compra
        azucarCompra=25;
        avenacompraA=20;
        avenacompraB=22;
        trigoCompra=30;
        maizCompra=18;
        
        cobroC=0;
        
        //Para facturas
        porcentaje=0;
        descuento=0;
        impuesto=0;
        subtotal=0;
        total=0;
        
        //reportes
            //a
            caja=0;
            //b
            ingresoC=0;
            ingresoV=0;
            //c
            volumenV=0;
            volumenC=0;
            margenGana=0;
            //d
            promedioV=0;
            promedioC=0;
            //e
            mayorV=0;
            mayorC=0;
            //f
            starProduct="";
            dineroAzucar=0;
            dineroAvena=0;
            dineroTrigo=0;
            dineroMaiz=0;
            //g
            primerLugar = 0;
            segundoLugar = 0;
            tercerLugar = 0;
            cuartoLugar = 0;
            }else{
                System.out.println("Ya estuvo!");
            }
        }
    }
}
