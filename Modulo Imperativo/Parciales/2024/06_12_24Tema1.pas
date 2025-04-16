{
parcial 06/12/24
* Tema 1   
}

program parcial;
const df=135;
type
	rangMes = 1..12;

	resultado = record 
		leg:integer;
		codMat: integer;
		mes: rangMes;
		anio: integer;
		nota: integer;
	end;
	
	regL = record
		codMat: integer;
		mes: rangMes;
		anio: integer;
		nota: integer;
	end;
	
	lista = ^nodol;
	nodol = record 
		datol: regL;
		sig:lista;
	end;
	
	regArb = record 
		leg: integer;
		list: lista;
	end;
	
	arbol = ^nodo;
	nodo= record 
		dato: regArb;
		HI: arbol;
		HD: arbol;
	end;
	
	vector = array [101..135] of integer;
	
	procedure inicializ (var v: vector);
	var i:integer;
	begin
		for i:=101 to 135 do
			v[i]:=0
	end;
	
	procedure cargar (var a: arbol; var v: vector);
	
		procedure leerR (var r: resultado);
		begin
			r.codMat := random (136);
			if (r.codMat <> 0) then begin
				r.leg := random (200);
				r.mes := random (12)+1;
				r.anio := 200 + random (2024-2000+1);
				r.nota:= random (10) +1;
			end;
		end;
		
		procedure agAdel (var l:lista; r: resultado);
		var nue:lista;
		begin
			new (nue);
			nue^.datol.codMat := r.codMat;
			nue^.datol.mes := r.mes;
			nue^.datol.anio := r.anio;
			nue^.datol.nota := r.nota;
			nue^.sig := l;
			l:= nue;
		end;
		
		procedure agregar (var a:arbol; r: resultado);
		begin 
			if (a=nil) then begin
				new (a);
				a^.dato.leg := r.leg;
				a^.dato.list:= nil;
				agAdel (a^.dato.list, r);
				a^.HI :=nil;
				a^.HD :=nil;
			end
			else begin
				if (a^.dato.leg = r.leg) then agAdel (a^.dato.list, r)
				else
					if (a^.dato.leg < r.leg) then agregar (a^.HD, r)
					else
						agregar (a^.HI, r);
			end;
		end;
		
		procedure agVector (var v: vector ; r: resultado);
		begin
			if (r.nota < 4) then
				v[r.codMat] := v[r.codMat] + 1;
		end;
	
	var r:resultado;
	begin
		leerR (r);
		while (r.codMat <> 0) do begin
			agregar (a, r);
			if (r.codMat >= 101) and (r.codMat <= 135) then
				agVector(v, r);
			leerR (r);
		end;
	end;
	
	procedure promedio (a: arbol; leg:integer; var prom : real);
	
		procedure recorreL (l: lista; var cantN: integer; var sumaN:integer);
		begin
			if (l <> nil) then begin
				cantN:= cantN+1;
				sumaN:= sumaN + l^.datol.nota;
				recorreL (l^.sig, cantN, sumaN);
			end;
		end;
	
		procedure recorreArb (a:arbol; leg: integer; var cantN: integer; var sumaN: integer);
		begin
			if (a <> nil) then begin
				if (a^.dato.leg = leg) then 
					recorreL (a^.dato.list, cantN, sumaN)
				else
					if (a^.dato.leg < leg) then recorreArb (a^.HD, leg, cantN, sumaN)
					else
						recorreArb (a^.HI, leg, cantN, sumaN);
			end;
		end;
	
	var cantN, sumaN: integer;
	begin
		cantN:=0;
		sumaN:=0;
		recorreArb (a, leg, cantN, sumaN);
		if (cantN <> 0) then prom := (sumaN / cantN)
		else
			writeln ('Alumno sin resultados');
	end;
		
	procedure maxAplazos (v: vector; dl: integer; var max: integer; var codMax: integer);	
	begin
		if (dl <= df) then begin
			if (v[dl] > max) then begin
				max:= v[dl];
				codMax:= dl;
			end;
			maxAplazos (v, dl+1, max, codMax);
		end;
	end;

var 
	a: arbol;
	v:vector;
	leg, max: integer;
	prom: real;
	codMax: integer;
BEGIN
	randomize;
	a:=nil;
	inicializ (v);
	cargar (a, v);
	
	writeln ('Ingresar legajo de estudiante: '); readln (leg);
	promedio (a, leg, prom);
	writeln ('promedio sin aplazo para legajo recibido: ', prom:0:2);
	
	max:=-1;
	maxAplazos (v, 101, max, codMax);
	writeln ('cod max:', codMax)
END.

