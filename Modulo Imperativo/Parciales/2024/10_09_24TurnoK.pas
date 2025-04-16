{
 parcial 10/09/2024
 * Turno K
}

program parcial;
const df=15;
type
	rangGen = 1..df;
	libro = record 
		ISBN : integer;
		anioEd: integer;
		codAut: integer;
		codGen: rangGen;
	end;

	regL = record 
		ISBN: integer;
		anioEd: integer;
		codGen: rangGen;
	end; 
	
	lista= ^nodol;
	nodol= record 
		datol: regL;
		sig: lista;
	end;

	regArb = record
		codAut: integer;
		list : lista;
	end;

	arbol = ^nodo;
	nodo = record
		dato: regArb;
		HI: arbol;
		HD: arbol;
	end;
	
	regLnue = record 
		codAut: integer;
		cantL : integer;
	end;
	
	listaNue =^nodoNue;
	nodoNue = record 
		dato: regLnue;
		sig: listaNue;
	end;

	procedure cargarA (var a: arbol);
	
		procedure leerL (var l:libro);
		begin
			l.ISBN := random (1000);
			if (l.ISBN <> 0) then begin
				l.anioEd := 2000 + random (2025-2000+1);
				l.codAut:= random (1000) + 1;
				l.codGen:= random (15)+1;
			end;
		end;
		
		procedure agregar (var a:arbol; l:libro);   // por cada codigo de autor carga una lista con todos sus libros 
		
			procedure agAdel (var l:lista; lib:libro);
			var nue:lista;
			begin
				new(nue);
				nue^.datol.ISBN:= lib.ISBN;
				nue^.datol.anioEd:= lib.anioEd;
				nue^.datol.codGen := lib.codGen;
				nue^.sig := l;
				l:= nue;
			end;
		
		begin
			if (a=nil) then begin
				new (a);
				a^.dato.codAut:= l.codAut;
				a^.dato.list := nil;
				agAdel (a^.dato.list, l);
				a^.HI := nil;
				a^.HD := nil;
			end
			else begin
				if (a^.dato.codAut = l.codAut) then agAdel (a^.dato.list, l) 
				else
					if (a^.dato.codAut > l.codAut) then agregar (a^.HI, l)   //arbol ordenado por cod de autor 
					else
						agregar (a^.HD, l);
			end;
		end;
	
	var l:libro;
	begin
		leerL(l);
		while (l.ISBN <> 0) do begin
			agregar (a, l);
			leerL (l);
		end;
	end;
	
	procedure incisoB (a:arbol; codA: integer; var l:listaNue);   // retorna una lista con cod de autor y cantidad de libros, para cada autor con cod maximo al ingresado
	
		function recorreL (l:lista; codA: integer): integer;
		begin
			if (l = nil) then recorreL := 0
			else
				recorreL := 1 + recorreL (l^.sig, codA);
		end;
	
		procedure agAdel(var l: listaNue; codAut: integer; cantL: integer);
		var
			act: listaNue;
			nue: listaNue;
		begin
			act := l;
			// Buscar si ya existe el autor en la lista
			while (act <> nil) and (act^.dato.codAut <> codAut) do
				act := act^.sig;
			if (act <> nil) then
				act^.dato.cantL := act^.dato.cantL + cantL  // si no encuentra el autor agrega nuevo adelante
			else begin
				new(nue);
				nue^.dato.codAut := codAut;
				nue^.dato.cantL := cantL;
				nue^.sig := l;
				l := nue;
			end;
		end;
	
	var cantL: integer;
	begin
		if (a <> nil) then begin
			if (a^.dato.codAut > codA) then begin
				cantL := recorreL (a^.dato.list, codA);
				agAdel (l, a^.dato.codAut, cantL);
				incisoB (a^.HD, codA, l);
				incisoB (a^.HI, codA, l);
			end
			else
				incisoB (a^.HD, codA, l);
		end;
	end;

	procedure incisoC (l:listaNue; var cantM: integer; var codMax: integer);  // modulo recursivo, retorna cant y cod de autor con mayor cantidad de libros 
	begin
		if (l <> nil) then begin
			if (l^.dato.cantL > cantM) then begin
				cantM := l^.dato.cantL;
				codMax := l^.dato.codAut;
			end;
			incisoC (l^.sig, cantM, codMax);
		end;
	end;

var 
	a : arbol;
	l: listaNue;
	codAut: integer;
	cantM: integer;
	codAutMax: integer;
BEGIN
	randomize;

	a:=nil;
	cargarA (a);
	
	writeln ('Ingresar un codigo de autor: '); readln (codAut);
	l:=nil;
	incisoB (a, codAut, l);
	
	cantM:= -1;
	incisoC (l, cantM, codAutMax);
END.

