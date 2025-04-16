{

}
program ej4;
type
	reclamo = record   // se lee
		cod: integer;
		dni: integer;
		anio: integer;
		tipo: string;
	end;
	
	reclam = record 
		cod: integer;
		anio: integer;
		tipo: string;
	end;
	
	lista =^nodol;
	nodol = record 
		datol: reclam;
		sig:lista;
	end;
	
	regArb = record 
		dni: integer;
		listRecl: lista;
		cantRecl: integer;
	end; 
	
	arbol = ^nodo;
	nodo = record 
		dato: regArb;
		HI: arbol;
		HD: arbol;
	end;
	
	procedure cargarA (var a: arbol);
	
		procedure leerR (var r: reclamo);
		var 
			vTipo : array [0..3] of string = ('defectuoso','garantia','facturacion','atencion');
		begin
			r.cod := random (100);
			if (r.cod <> 0) then begin
				r.dni := random (5000) + 1000;
				r.anio:= 2010 + random (2025-2010+1);
				r.tipo := vTipo [random (4)];
			end;
		end;
		
		procedure agregar (var a: arbol; r: reclamo);
		
			procedure agAdel (var l:lista; r: reclamo);
			var nue:lista;
			begin
				new(nue);
				nue^.datol.cod := r.cod;
				nue^.datol.anio := r.anio;
				nue^.datol.tipo := r.tipo;
				nue^.sig:= l;
				l:= nue;
			end;
		
		begin
			if (a=nil) then begin
				new (a);
				a^.dato.dni:= r.dni;
				a^.dato.listRecl := nil;
				agAdel (a^.dato.listRecl, r);
				a^.dato.cantRecl:= 1;
				a^.HI:= nil;
				a^.HD:= nil;
			end
			else begin
				if (a^.dato.dni = r.dni) then begin
					agAdel (a^.dato.listRecl, r);
					a^.dato.cantRecl := a^.dato.cantRecl + 1;
				end
				else
					if (a^.dato.dni < r.dni) then agregar (a^.HD, r)
					else
						agregar (a^.HI, r);
			end;
		end;
					
	var r: reclamo;
	begin
		leerR (r);
		while (r.cod <> 0) do begin
			agregar (a, r);
			leerR (r);
		end;
	end;
	
	function cantL (l: lista): integer;
	begin
		if (l = nil) then cantL :=0
		else
			cantL := cantL (l^.sig);
	end;
	
	
	function cantReclam (a: arbol; dni: integer): integer;
	
	begin
		if (a=nil) then cantReclam :=0
		else begin
			if (a^.dato.dni = dni) then cantReclam := cantL (a^.dato.listRecl) + cantReclam (a^.HI, dni) + cantReclam (a^.HD, dni)
			else
				if (a^.dato.dni < dni) then cantReclam := cantReclam (a^.HD, dni)
				else
					cantReclam := cantReclam (a^.HI, dni);
		end;
	end;

	procedure entreValores (a:arbol);
	
		function cantR (a: arbol; d1, d2: integer): integer;
		begin
			if (a = nil) then cantR := 0
			else begin
				if (a^.dato.dni > d1) and (a^.dato.dni < d2) then
					cantR := cantL (a^.dato.listRecl) + cantR (a^.HI, d1,d2) + cantR (a^.HD, d1,d2)
				else
					if (a^.dato.dni <= d1) then cantR := cantR (a^.HD, d1,d2)
					else
						cantR := cantR (a^.HI, d1,d2);
			end;
		end;
	
	var d1, d2: integer;
	begin
		writeln ('Ingrese dni 1: '); readln (d1);
		writeln ('Ingrese dni 2 (mayor que el dni 1): '); readln (d2);
		writeln ('Cantidad de relamos dentro del rango de dnis ingresados: ', cantR (a, d1, d2));
	end;

	procedure InformaCods (a: arbol);
	
		procedure retornaCods (a: arbol; anio: integer);
		var l:lista;
		begin
			if (a <> nil) then begin
				l:= a^.dato.listRecl;
				while (l <> nil) do begin
					if (l^.datol.anio = anio) then
						writeln ('Codigo de reclamo en año recibido: ', l^.datol.cod , ' cliente ', a^.dato.dni);
					l:= l^.sig;
				end;
				retornaCods (a^.HI, anio);
				retornaCods (a^.HD, anio);
			end;
		end;
	
	var anio: integer;
	begin
		writeln ('Ingrese anio (entre 2010 y 2025): '); readln (anio);
		retornaCods (a, anio);
	end;
	
var 
	a: arbol;
	dni: integer;
BEGIN
	a:= nil;
	cargarA (a);
	
	writeln ('Ingrese dni de cliente: '); readln (dni);
	writeln ('Cantidad de reclamos efectuados con el dni ingresado: ', cantReclam (a, dni));
	
	entreValores (a);
	
	InformaCods (a);
	
END.

