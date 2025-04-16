{
 Escribir un programa que:
   
a. Implemente un módulo que genere aleatoriamente información de ventas de un comercio.
Para cada venta generar código de producto, fecha y cantidad de unidades vendidas. Finalizar
con el código de producto 0. Un producto puede estar en más de una venta. Se pide:
	i. Generar y retornar un árbol binario de búsqueda de ventas ordenado por código de
producto. Los códigos repetidos van a la derecha.
	ii. Generar y retornar otro árbol binario de búsqueda de productos vendidos ordenado por
código de producto. Cada nodo del árbol debe contener el código de producto y la
cantidad total de unidades vendidas.
	iii. Generar y retornar otro árbol binario de búsqueda de productos vendidos ordenado
por código de producto. Cada nodo del árbol debe contener el código de producto y la
lista de las ventas realizadas del producto.
	Nota: El módulo debe retornar TRES árboles.
b. Implemente un módulo que reciba el árbol generado en i. y una fecha y retorne la cantidad
total de productos vendidos en la fecha recibida.
c. Implemente un módulo que reciba el árbol generado en ii. y retorne el código de producto
con mayor cantidad total de unidades vendidas.
d. Implemente un módulo que reciba el árbol generado en iii. y retorne el código de producto
con mayor cantidad de ventas.
   
}
program ej2;

type
	venta = record
		cod: integer;
		fecha: integer;
		cantV: integer;
	end;
	
	arbol=^nodo;       		// arbol 1: arbol de ventas (ordenado por cod de producto)
	nodo = record 
		dato:venta;
		HI:arbol;
		HD:arbol;
	end;

	v2 = record
		cod2: integer;  	// cod prod
		cantT: integer; 	//cant total de unid vendidas
	end;
	
	arbol2 = ^nodo2;		// arbol 2: arbol de total de ventas (ordenado por cod de producto)
	nodo2 = record
		dato2: v2;
		HI: arbol2;
		HD: arbol2;
	end;
	
	lista = ^nodol;		
	nodol= record
		fecha3: integer;
		cantV3: integer;
		sig: lista;
	end;
	
	v3 = record
		cod3:integer;
		list: lista;
	end;
	
	arbol3 =^nodo3;			// arbol 3: arbol de listas de ventas por producto (ordenado por cod de producto)
	nodo3 = record 
		dato3: v3;
		HI:arbol3;
		HD:arbol3;
	end;
	
	procedure cargarA (var a1: arbol; var a2: arbol2; var a3: arbol3);
	
		procedure leerV (var v:venta);
		begin
			v.cod:= random (30);
			if (v.cod <> 0) then begin
				v.fecha:= random (30) + 1; // ej fecha en dias 
				v.cantV:= random (50);
			end;
		end;
		
		procedure agregarA1 (var a1: arbol; v:venta);
		begin
			if (a1 = nil) then begin
				new(a1);
				a1^.dato:= v;
				a1^.HI:= nil;
				a1^.HD:= nil;
			end
			else begin
				if (v.cod >= a1^.dato.cod) then agregarA1(a1^.HD, v)  // los cod repetidos van a la derecha 
				else
					agregarA1 (a1^.HI, v);
			end;
		end;
	
		procedure agregarA2 (var a2: arbol2; cod: integer; tot:integer);
		begin
			if (a2 = nil) then begin
				new (a2);
				a2^.dato2.cod2:= cod;
				a2^.dato2.cantT:= tot; 
				a2^.HI:=nil;
				a2^.HD:=nil;
			end
			else begin
				if (cod = a2^.dato2.cod2) then
					a2^.dato2.cantT := a2^.dato2.cantT + tot 			//sumo cant de vendidos por codigo
				else begin
					if (cod < a2^.dato2.cod2) then agregarA2 (a2^.HI, cod, tot)
					else
						agregarA2 (a2^.HD, cod, tot);
				end;
			end;
		end;
					
		procedure agregarA3 (var a3: arbol3; v:venta);
		
			procedure agAdel (var l:lista; fecha, cantV: integer);
			var nue:lista;
			begin
				new (nue);
				nue^.fecha3:= fecha;
				nue^.cantV3 := cantV;
				nue^.sig:= l;
				l:=nue;
			end; 
		
		begin
			if (a3 = nil) then begin
				new (a3);
				a3^.dato3.cod3 := v.cod;
				a3^.dato3.list:= nil;
				agAdel (a3^.dato3.list, v.fecha, v.cantV); 
				a3^.HI:= nil;
				a3^.HD:= nil;
			end
			else begin
				if (v.cod = a3^.dato3.cod3) then
					agAdel (a3^.dato3.list, v.fecha, v.cantV)
				else begin
					if (v.cod < a3^.dato3.cod3) then agregarA3 (a3^.HI, v)
					else
						agregarA3 (a3^.HD, v);
				end;
			end;
		end;
	
	var
		v:venta;
	begin
		leerV (v);
		while (v.cod <> 0) do begin
			agregarA1 (a1, v);
			agregarA2 (a2, v.cod, v.cantV);  // inicializa con la cant de ventas generado
			agregarA3 (a3, v);
			leerV (v);
		end;
	end;
	
	function cantVend (a1:arbol ; f: integer): integer;
	begin
		if (a1 = nil) then cantVend:=0
		else begin
			if (a1^.dato.fecha = f) then
				cantVend:= a1^.dato.cantV + cantVend(a1^.HI, f) + cantVend (a1^.HD, f)
			else
				cantVend:= cantVend (a1^.HI,f) + cantVend(a1^.HD,f);
		end;
	end;
	
	procedure maxCod (a2: arbol2);
	
		procedure buscaMax (a2: arbol2; var cantTmax:integer; var codMax:integer);
		begin
			if (a2 <> nil) then begin
				if (a2^.dato2.cantT > cantTmax) then begin
					cantTmax:= a2^.dato2.cantT;
					codMax:= a2^.dato2.cod2;
				end;
				buscaMax (a2^.HI, cantTmax, codMax);
				buscaMax (a2^.HD, cantTmax ,codMax);
			end;
		end;
	
	var 
		codMax:integer;   			// no es necesario inicializar el codigo max 
		cantTmax: integer;
	begin
		cantTmax:=0;  
		buscaMax (a2, cantTmax, codMax);
		if (cantTmax = 0) then writeln ('Arbol vacio')
		else
			writeln ('Codigo de producto con más ventas en arbol 2: ', codMax);
	end;
	
	procedure codMaxL (a3: arbol3; var codMax:integer);
	
		procedure contarV (l:lista; var cant: integer);
		begin
			while (l <> nil) do begin
				cant:= cant +1;
				l:= l^.sig;
			end;
		end;
		
		procedure buscaMax (a3: arbol3; var cantMax:integer; var codMax:integer);
		var cant:integer;
		begin
			if (a3 <> nil) then begin
				cant:=0;              				// para cada lista la cantidad inicial debe ser 0
				contarV(a3^.dato3.list, cant);
				if (cant > cantMax) then begin;  	// actualiza codigo con mas ventas 
					cantMax:= cant;
					codMax:= a3^.dato3.cod3;
				end;
				buscaMax(a3^.HI,cantMax,codMax);
				buscaMax(a3^.HD,cantMax,codMax);
			end;
		end;
	
	var
		cantMax: integer;
	begin
		cantMax:=0;
		buscaMax (a3, cantMax, codMax);
	end;
	
	procedure imprimirArbol1(a1: arbol);
	begin
		if (a1 <> nil) then begin
			imprimirArbol1(a1^.HI);
			writeln('Código de Producto: ', a1^.dato.cod, ' | Fecha: ', a1^.dato.fecha, ' | Cantidad Vendida: ', a1^.dato.cantV);
			imprimirArbol1(a1^.HD);
		end;
	end;

	procedure imprimirArbol2(a2: arbol2);
	begin
		if (a2 <> nil) then begin
			imprimirArbol2(a2^.HI);
			writeln('Código de Producto: ', a2^.dato2.cod2, ' | Cantidad Total Vendida: ', a2^.dato2.cantT);
			imprimirArbol2(a2^.HD);
		end;
	end;

	procedure imprimirArbol3(a3: arbol3);
		procedure imprimirLista(l: lista);
		begin
			while (l <> nil) do begin
				writeln('  Fecha: ', l^.fecha3, ' | Cantidad Vendida: ', l^.cantV3);
				l := l^.sig;
			end;
		end;

	begin
		if (a3 <> nil) then begin
			imprimirArbol3(a3^.HI);
			writeln('Código de Producto: ', a3^.dato3.cod3);
			writeln('Ventas:');
			imprimirLista(a3^.dato3.list);
			writeln('----------------------');
			imprimirArbol3(a3^.HD);
		end;
	end;

	
var 
	a1: arbol;
	a2: arbol2;
	a3: arbol3; 
	codMax: integer;
	fech:integer;
BEGIN
	randomize;
	a1:= nil; a2:= nil; a3:= nil;  
	cargarA (a1, a2, a3);
	
	writeln('--- Árbol 1: Ventas individuales ---');
	imprimirArbol1(a1);
  
	writeln('--- Árbol 2: Cantidad total vendida por producto ---');
	imprimirArbol2(a2);
  
	writeln('--- Árbol 3: Listas de ventas por producto ---');
	imprimirArbol3(a3);
	
	
	writeln ('Ingrese fecha: '); read (fech);
	writeln ('Cantidad de ventas en la fecha ingresada en arbol 1: ', cantVend (a1, fech));
	
	maxCod (a2);  // maximo de las cantidades total en arbol
	
	codMaxL (a3, codMax);
	writeln ('Codigo de producto con más ventas en arbol 3: ', codMax);  // lista con mayor cant de ventas
	
END.

