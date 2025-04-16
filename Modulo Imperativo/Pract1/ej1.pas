{ 
1.- Descargar el programa ImperativoEjercicioClase1.pas que contiene parte del código del
siguiente enunciado a resolver. Implementar lo indicado en el código.
Se desea procesar la información de las ventas de productos de un comercio (como máximo
50).
Implementar un programa que invoque los siguientes módulos:
a. Un módulo que retorne la información de las ventas en un vector. De cada venta se conoce
el día de la venta, código del producto (entre 1 y 15) y cantidad vendida (como máximo 99
unidades). El código debe generarse automáticamente (random) y la cantidad se debe leer. El
ingreso de las ventas finaliza con el día de venta 0 (no se procesa).
b. Un módulo que muestre el contenido del vector resultante del punto a).
c. Un módulo que ordene el vector de ventas por código.
d. Un módulo que muestre el contenido del vector resultante del punto c).
e. Un módulo que elimine, del vector ordenado, las ventas con código de producto entre dos
valores que se ingresan como parámetros.
f. Un módulo que muestre el contenido del vector resultante del punto e).
g. Un módulo que retorne la información (ordenada por código de producto de menor a
mayor) de cada código par de producto junto a la cantidad total de productos vendidos.
h. Un módulo que muestre la información obtenida en el punto g).
}

program Clase1MI;
const dimF = 50;
type dias = 0..31;
     rango1 = 0..15;
     rango2 = 1..99;
     rango3 = 0..dimF;
     
     venta = record
                dia: dias;
				codigoP: rango1;
				cantidad: rango2;
			 end;
	 vector = array [1..dimF] of venta;
	 elemento = record
	              codigoP: rango1;
	              cantTotal: integer;
	            end;
	 lista = ^nodo;
	 nodo = record
	          dato: elemento;
	          sig: lista;
	        end;

procedure AlmacenarInformacion (var v: vector; var dimL: rango3);
  
  procedure LeerVenta (var v: venta);
  begin
    Randomize;
    write ('Dia: ');
    v.dia:= random(32);  // genera dia entre 0 y 31
    writeln (v.dia);
    if (v.dia <> 0)
    then begin
           write ('Codigo de producto: ');
           v.codigoP:= random(16) + 1;   // genera codigo entre 1 y 16
           writeln (v.codigoP);
           write ('Ingrese cantidad (entre 1 y 99): ');
           readln (v.cantidad);
         end;
  end;

var unaVenta: venta;
begin
    dimL := 0;
    LeerVenta (unaVenta);
    while (unaVenta.dia <> 0)  and ( dimL < dimF ) do   // mientras el dia de venta es distinto de 0 y no se cargue el vector completo
    begin
       dimL := dimL + 1;								// aument la diml del vector
       v[dimL]:= unaVenta;								// agrego el registro venta en la pos del vector actual
       LeerVenta (unaVenta);
    end;
end;

procedure ImprimirVector (v: vector; dimL: rango3);
var
   i: integer;
begin
     write ('         -');
     for i:= 1 to dimL do
         write ('-----');
     writeln;
     write ('  Codigo:| ');
     for i:= 1 to dimL do begin
        if(v[i].codigoP <= 9)then
            write ('0');
        write(v[i].codigoP, ' | ');
     end;
     writeln;
     writeln;
     write ('Cantidad:| ');
     for i:= 1 to dimL do begin
        if (v[i].cantidad <= 9)then
            write ('0');
        write(v[i].cantidad, ' | ');
     end;
     writeln;
     write ('         -');
     for i:= 1 to dimL do
         write ('-----');
     writeln;
     writeln;
End;

procedure Ordenar (var v: vector; dimL: rango3);  // ordena por seleccion

var i, j, pos: rango3; 
	item: venta;		
begin
	for i:= 1 to dimL - 1 do begin {busca el mínimo y guarda en pos la posición}
		pos := i;
		for j := i+1 to dimL do 
			if (v[j].codigoP < v[pos].codigoP) then pos:=j;

   {intercambia v[i] y v[pos]}
		item := v[pos];   
		v[pos] := v[i];   
		v[i] := item;
	end;
end;

procedure Eliminar (var v: vector; var dimL: rango3; valorInferior, valorSuperior: rango1);

  function BuscarPosicion (v: vector; dimL: rango3; elemABuscar: rango1): rango3;
  var pos: rango3;
  begin
    pos:= 1;
    while (pos <= dimL) and (elemABuscar > v[pos].codigoP) do  // avanza por el vector buscando pos del rango menor
       pos:= pos + 1;
    if (pos > dimL) then BuscarPosicion:= 0		// si la pos supera la diml (llego al final) devuelve 0
                    else BuscarPosicion:= pos;	// si hay un elemento igual al minimo, devuelve la pos
  end;
  
  function BuscarPosicionDesde (v: vector; dimL, pos : integer; elemABuscar: rango1): rango3;
  begin
    while (pos <= dimL) and (elemABuscar >= v[pos].codigoP) do   
       pos:= pos + 1;
    if (pos > dimL) then BuscarPosicionDesde:= dimL
                    else BuscarPosicionDesde:= pos - 1;
  end;

var posInferior, posSuperior, salto, i: rango3; 
Begin
  posInferior:= BuscarPosicion (v, dimL, valorInferior);
  if (posInferior <> 0)	then begin
        posSuperior:= BuscarPosicionDesde (v, dimL, posInferior, valorSuperior);  // 1) busca pos del elemento superior a partir de la pos del elem inferior 
        salto := posSuperior - posInferior + 1; 								// 2) Cantidad de elementos a eliminar

		// 3) Realizar el corrimiento para eliminar los elementos en el rango
		for i := posInferior to dimL - salto do
			v[i] := v[i + salto];

		// 4) Actualizar la dimensión lógica
		dimL := dimL - salto;
   end;
end;

procedure GenerarLista (v: vector; dimL: rango3; var L: lista);

  procedure AgregarAtras (var L, ult: lista; elem: elemento);
  var nue: lista;
  begin
	new (nue);
	nue^.dato:= elem;
	nue^.sig:= nil;
	
	if (L = nil) then begin
		L:= nue;
		ult:= nue;
	end
	else begin
		ult^.sig:= nue;
		ult := nue;
	end;
  end;
  
    
var i: rango3; ult: lista; e: elemento;
begin
  L:= nil; ult:= nil; i:= 1;
  while (i<= dimL) do begin   // aprovecho el orden con corte de control
    e.codigoP:=  v[i].codigoP;
    e.cantTotal:= 0;
    while ((i<= dimL) and (e.codigoP =  v[i].codigoP)) do begin
      e.cantTotal:= e.cantTotal + v[i].cantidad;
      i:= i + 1;
    end;
    AgregarAtras (L, ult, e);
  end;
end; 

procedure ImprimirLista (L: lista);
begin
	while (L <> nil) do begin
		writeln ('Codigo de producto:', L^.dato.codigoP);
		writeln ('Cantidad total de prod vendidos:', L^.dato.cantTotal);
		L:= L^.sig;
	end;
end;

var v: vector;
    dimL: rango3;
    valorInferior, valorSuperior: rango1;
    L: lista;
    
Begin
  AlmacenarInformacion (v, dimL);   // inciso a
  writeln;
  if (dimL = 0) then 
	writeln ('--- Vector sin elementos ---')
  else begin						//	si el vector no esta vacio
	writeln ('--- Vector ingresado --->');
    writeln;
    ImprimirVector (v, dimL);		// imprime el contenido
    writeln;
    writeln ('--- Vector ordenado --->');
    writeln;
    Ordenar (v, dimL);				// ordena el vector 
    ImprimirVector (v, dimL);		// imprimir vector ordenado
    write ('Ingrese valor inferior: ');
    readln (valorInferior);
    write ('Ingrese valor superior: ');
    readln (valorSuperior);
    Eliminar (v, dimL, valorInferior, valorSuperior); // eliminar ventas entre 2 cods ingresados
    if (dimL = 0) then 
		writeln ('--- Vector sin elementos, luego de la eliminacion ---')
    else begin						// si el elemento no queda vacio
		writeln;
        writeln ('--- Vector luego de la eliminacion --->');
        writeln;
        ImprimirVector (v, dimL);	// imprime vector despues de eliminación
        GenerarLista (v, dimL, L);	// lista con cods pares y con tot prod vendidos por cada uno (o vector 0..15)
        if (L = nil) then 
			writeln ('--- Lista sin elementos ---')
        else begin
			writeln;
            writeln ('--- Lista obtenida --->');
            writeln;
            ImprimirLista (L);
        end;
    end;
    
  end;
                       
end.
// falta generar lista, corte control
