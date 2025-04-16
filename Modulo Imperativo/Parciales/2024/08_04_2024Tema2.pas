{
parcial 08/04/2024
* tema 2
* 
* Se desea procesar las polizas de una compania de seguros. De cada poliza se conoce: dni del cliente, suma asegurada,
* valor cuota y fecha de vencimiento. Un cliente puede tener mas de una poliza. Las polizas
* se comenzaron a emitir a parti de los 2000 y finalizaron de emitirse en 2023.
* Realice un programa que contenga :
* a) Un modulo que lea polizas, hasta leer una poliza con dni -1, y las almacene en una estructura eficiente para la busqueda por suma asegurada.
* b) Un modulo que reciba la estructura generada en a) y devuelva otra estructura con las polizas cuya suma asegurada
* sea menor a un valor recibido por parametro. Esta estructura debe estar agrupada por año de vencimiento y ordenada por dni del cliente.
* c) Un modulo que reciba la estructura generada en b) y devuelva la cantidad de polizas de un cliente cuyo dni se recibe por parametro.
* 
}
program parcial;
const df= 2023;
type
	rangAnios = 2000..df;

	fecha = record
		dia: integer;
		mes: integer;
		anio: rangAnios;
	end;

	poliza = record
		dniCl: integer;
		sumaAseg: real;
		valorC: real;
		fechaV: fecha;
	end;
	
	arbol = ^nodo;
	nodo = record
		dato: poliza;
		HI: arbol;
		HD: arbol;
	end;
	
	lista= ^nodol;
	nodol = record 
		datol: poliza;
		sig: lista;
	end;
	
	vector = array [rangAnios] of lista;
	
	procedure inicializ (var v:vector);
	var i:rangAnios;
	begin
		for i:=2000 to df do 
			v[i]:= nil;
	end;
	
	procedure cargarA (var a:arbol);
	
		procedure leerP (var p:poliza);
		begin
			p.dniCl := random (1000) - 1;
			if (p.dniCl <> -1) then begin
				p.sumaAseg:= random (5000) + 1000;
				p.valorC := random (5000) + 1000;
				p.fechaV.dia:= random (30)+1;
				p.fechaV.mes:= random (12)+1;
				p.fechaV.anio:= 2000 + random (2023-2000+1);
			end;
		end;
		
		procedure agregar (var a: arbol; p:poliza);
		begin
			if (a=nil) then begin
				new (a);
				a^.dato := p;
				a^.HI:= nil;
				a^.HD:= nil;
			end
			else begin
				if (a^.dato.sumaAseg < p.sumaAseg) then agregar (a^.HD, p)
				else
					agregar (a^.HI, p);
			end;
		end;
	
	var p:poliza;
	begin
		leerP (p);
		while (p.dniCl <> -1) do begin
			agregar (a, p);
			leerP (p);
		end;
	end;
	
	procedure incisoB (a: arbol; sA: real; var v: vector);
	
		procedure agVector (var l:lista; p:poliza);  // inserta ordenado por dni en la lista
		var ant,act,nue: lista;
		begin
			new (nue);
			nue^.datol:= p;
			act:= l;
			
			while (act <> nil) and (act^.datol.dniCl < p.dniCl) do begin
				ant:= act;
				act:= act^.sig;
			end;
			if (act = l) then
				l:= nue
			else
				ant^.sig:= nue;
			nue^.sig:= act;
		end;
	
	begin
		if (a <> nil) then begin
			if (a^.dato.sumaAseg < sA) then begin
				agVector (v[a^.dato.fechaV.anio], a^.dato);  
				incisoB (a^.HI, sA, v);
				incisoB (a^.HD, sA, v);
			end
			else
				incisoB (a^.HI, sA, v);  // si la suma es mayor a la ingresada busca solo en nodos menores 
		end;
	end;
	
	procedure incisoC (v: vector; i: integer; dni: integer; var cantP: integer);
	
		function cantL (l:lista; dni:integer): integer;  // devuelve cantidad de polizas de dni ingresado en lista
		begin
			if (l=nil) then cantL:=0
			else begin
				if (l^.datol.dniCl = dni) then
					cantL:= 1 + cantL (l^.sig, dni)
				else
					if (l^.datol.dniCl < dni) then
						cantL:= cantL (l^.sig, dni);
			end;
		end;
	
	begin
		if (i <= df) then begin
			cantP:= cantP + cantL (v[i],dni);   // suma al total de polizas del dni ingresado, la cantidad en cada lista
			incisoC (v, i+1, dni, cantP);
		end;
	end;
	
var 
	a: arbol;
	v: vector;
	sA: real;
	cantP: integer;
	dni: integer;
BEGIN
	randomize;
	a:=nil;
	cargarA (a);
	
	inicializ (v);
	writeln ('Ingrese suma asegurada: '); readln (sA);
	incisoB (a, sA, v);
	
	cantP:=0;
	writeln ('Ingrese un dni: '); readln (dni);
	incisoC (v, 2000, dni, cantP );
	writeln ('Cantidad d polizas del dni ingresado: ', cantP);
END.

