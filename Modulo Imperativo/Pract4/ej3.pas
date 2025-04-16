{
3. Implementar un programa modularizado para una librería. Implementar módulos para:
a. Almacenar los productos vendidos en una estructura eficiente para la búsqueda por
código de producto. De cada producto deben quedar almacenados su código, la
cantidad total de unidades vendidas y el monto total. De cada venta se lee código de
venta, código del producto vendido, cantidad de unidades vendidas y precio unitario. El
ingreso de las ventas finaliza cuando se lee el código de venta -1.
b. Imprimir el contenido del árbol ordenado por código de producto.
c. Retornar el código de producto con mayor cantidad de unidades vendidas.
d. Retornar la cantidad de códigos que existen en el árbol que son menores que un valor
que se recibe como parámetro.
e. Retornar el monto total entre todos los códigos de productos comprendidos entre dos
valores recibidos (sin incluir) como parámetros.
}

program ej3;
type 
	
	producto = record
		codP: integer;
		cantVend :integer;
		montoTot: real;
	end;
	
	arbol = ^nodop;
	nodop = record 
		dato: producto;
		HI: arbol;
		HD: arbol;
	end;
	
	venta = record   		// la venta se lee pero no se almacena 
		codV: integer;
		codPvend: integer;
		cantUvend: integer;
		precioUni: real;
	end;
	
	procedure cargarA (var a: arbol);
	
		procedure leerV (var v: venta);
		begin
			v.codV := random (50);
			if (v.codV <> 0) then begin
				v.codPvend := random (200) + 1;
				v.cantUvend:= random (100) + 1;
				v.precioUni:= random (5000) + 10;
			end;
		end;
		
		procedure agregarA (var a: arbol; v: venta);
		begin
			if (a=nil) then begin
				new (a);
				a^.dato.codP := v.codPvend;
				a^.dato.cantVend := v.cantUvend;
				a^.dato.montoTot:= v.precioUni;
				a^.HI:= nil;
				a^.HD:= nil;
			end
			else
				if (a^.dato.codP = v.codPvend) then begin
					a^.dato.cantVend := a^.dato.cantVend + v.cantUvend;
					a^.dato.montoTot := a^.dato.montoTot + v.precioUni;
				end
				else
					if (a^.dato.codP < v.codPvend) then agregarA (a^.HD, v)
					else
						agregarA (a^.HI, v);
		end;	
	
	var v: venta;
	begin
		leerV (v);
		while (v.codV <> 0) do begin
			agregarA (a, v);
			leerV (v);
		end;
	end;

	procedure ImprimirA (a: arbol);
	begin
		if ( a <> nil ) then begin
			ImprimirA (a^.HI);
			Writeln ('Codigo de producto: ', a^.dato.codP);
			Writeln ('Cantidad vendida de productos: ', a^.dato.cantVend);
			Writeln ('Monto total vendido del producto: ', a^.dato.montoTot:0:2);
			ImprimirA (a^.HD);
		end;
	end;

	procedure maxVentas (a: arbol);
	
		procedure maximo (a: arbol; var vmax: integer; var codMax: integer);
		begin
			if (a <> nil) then begin
				if (a^.dato.cantVend > vmax) then begin
					vmax:= a^.dato.cantVend;
					codMax:= a^.dato.codP;
				end;
				maximo (a^.HI, vmax, codMax);
				maximo (a^.HD, vmax, codMax);
			end;
		end;
	
	var
		codMax: integer;
		vmax: integer;
	begin
		vmax:= -1;
		maximo (a, vmax, codMax);
		if (vmax <> -1) then writeln ('Codigo de producto con más ventas: ', codMax)
		else
			writeln ('arbol vacio');
	end;

	function cantCods (a: arbol; cod: integer): integer;   // codigos menores al ingresado
	begin
		if (a = nil) then cantCods := 0
		else begin
			if (a^.dato.codP < cod) then              
				cantCods := 1 + cantCods (a^.HI, cod) + cantCods (a^.HD, cod)
			else
				cantCods := cantCods (a^.HI, cod);
		end;
	end;
	
	procedure entreValores (a: arbol);
	
		function total (a:arbol; c1, c2: integer): real;   // sin incluir c1 y c2
		begin
			if ( a = nil) then total:= 0
			else begin
				if (a^.dato.codP > c1) and (a^.dato.codP < c2) then
					total := a^.dato.montoTot + total(a^.HI, c1,c2) + total(a^.HD, c1,c2)
				else
					if (a^.dato.codP <= c1) then total:= total (a^.HD, c1,c2)
					else // o if (a^.dato.codP >= c2)
						total := total (a^.HI, c1,c2);
			end
		end;
	
	var
		c1,c2: integer;
	begin
		writeln ('Ingrese valor 1: '); readln (c1);
		writeln ('Ingrese valor 2 (mayor que valor 1): '); readln (c2);
		writeln ('Monto total de todos los productos entre los valores ingresados: ', total (a, c1,c2):0:2);
	end;

var 
	a: arbol;
	cod: integer;
BEGIN
	randomize;
	a:= nil;
	cargarA (a);	 // por cod de prod
	ImprimirA (a);   // por cod de prod
	maxVentas (a);   // cod con mayor cant de unidades vend
	Writeln ('Ingrese codigo a buscar'); readln (cod);
	Writeln ('Cantidad de codigos que menores al valor ingresado: ', cantCods (a, cod)); 
	entreValores (a);
END.

