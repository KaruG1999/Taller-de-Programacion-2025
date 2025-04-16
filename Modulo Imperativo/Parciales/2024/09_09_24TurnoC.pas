{
parcial 09/09/24
* turno C
}
program parcial;

type
	
	envio = record 
		codCl: integer;
		dia: integer;
		codP: integer;
		peso: real;
	end;
	
	regLis = record 
		codCl:integer;
		dia:integer;
		peso: real;
	end;
	
	lista=^nodol;
	nodol= record
		datol: regLis;
		sig:lista;
	end;
	
	regArb =record
		codP: integer;
		list:lista;
	end;
	
	arbol = ^nodo;
	nodo= record
		dato: regArb;
		HI: arbol;
		HD: arbol;
	end;

	procedure cargarA (var a: arbol);
	
		procedure leerE (var e: envio);
		begin
			e.codCl := random (50);
			if (e.codCl <> 0) then begin
				e.dia:= random (30) + 1;
				e.codP := random (500)+1000;
				e.peso:= random (20000) / (random(10)+1);
			end;
		end;
		
		procedure agregar (var a: arbol; e:envio);
		
			procedure agAdel (var l: lista; e: envio);
			var nue: lista;
			begin
				new (nue);
				nue^.datol.codCl:= e.codCl;
				nue^.datol.dia:= e.dia;
				nue^.datol.peso:= e.peso;
				nue^.sig := l;
				l:= nue;
			end;
		
		begin
			if (a=nil) then begin
				new (a);
				a^.dato.codP := e.codP;
				a^.dato.list:= nil;
				agAdel (a^.dato.list, e);
				a^.HI:= nil;
				a^.HD:= nil;
			end
			else begin
				if (a^.dato.codP = e.codP) then
					agAdel (a^.dato.list, e)
				else
					if (a^.dato.codP < e.codP) then agregar (a^.HD, e)
					else
						agregar (a^.HI, e);
			end;
		end;

	var
		e: envio;
	begin
		leerE (e);
		while (e.codCl <> 0) do begin
			agregar (a, e);
			leerE (e);
		end;
	end;

	procedure incisoB  (a: arbol; var l:lista);
	
		procedure buscar (a:arbol; cp:integer; var l: lista);
		begin
			if (a <> nil) then begin
				if (a^.dato.codP = cp) then
					l:= a^.dato.list
				else
					if (a^.dato.codP < cp) then buscar (a^.HD, cp, l)
					else
						buscar (a^.HI, cp, l);
			end;
		end;
	
	var cp:integer;
	begin
		writeln ('Ingrese codigo postal: '); readln (cp);
		buscar (a, cp, l);
	end;
	
	procedure incisoC  (l:lista; var codMax, codMin: integer);
	
		procedure minMax (l:lista; var min: real; var codMin: integer; var max: real; var codMax: integer);
		begin
			if (l <> nil) then begin
				if (l^.datol.peso > max) then begin
					max:= l^.datol.peso;
					codMax:= l^.datol.codCl;
				end;
				if (l^.datol.peso < min) then begin
					min:= l^.datol.peso;
					codMin:= l^.datol.codCl;
				end;
				minMax (l^.sig, min, codMin, max, codMax);
			end;
		end;
				
	var min, max: real;
	begin
		min:=999;
		max:=-999;
		minMax (l, min, codMin, max, codMax);
	end;

var 
	a:arbol;
	l:lista;
	codMax, codMin: integer;
BEGIN
	a:=nil;
	randomize;
	cargarA (a);
	
	incisoB (a, l);
	if (l=nil) then writeln ('No se encontro cod Postal ingresado');
	
	codMax:= -1; codMin:= 1000;
	incisoC (l, codMax, codMin);
	writeln('Cliente con mayor peso: ', codMax);
	writeln('Cliente con menor peso: ', codMin);
END.

