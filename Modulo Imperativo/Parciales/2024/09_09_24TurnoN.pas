{
parcial 09_09_24
* turno N
}
program pTurnoN;
const df = 12;
type
	rangMes = 1..df; 

	atencion = record   		//se lee
		matMed: integer;
		dni: integer;
		mes: rangMes;
		diag: char;
	end;

	regArb = record 
		dni: integer;
		diag: char;
	end;
	
	arbol = ^nodo;
	nodo = record 
		dato: regArb;
		HI: arbol;
		HD: arbol;
	end;

	vector = array [rangMes] of arbol;
	
	procedure inicializ (var v:vector);
	var i:rangMes;
	begin
		for i:=1 to df do 
			v[i]:= nil;
	end;
	
	procedure cargarV (var v: vector);
	
		procedure leerAt (var at: atencion);
		var
			vDiag: array [1..5] of char = ('L','M','N','O','P');
		begin
			at.matMed := random (100);
			if (at.matMed <> 0) then begin
				at.dni:= random (1000) + 1000;
				at.mes:= random (12)+1;
				at.diag := vDiag [random (5)+1];
			end;
		end;
		
		procedure agregar (var a:arbol; at:atencion);
		begin
			if (a=nil) then begin
				new(a);
				a^.dato.dni := at.dni;
				a^.dato.diag:= at.diag;
				a^.HI:= nil;
				a^.HD:= nil;
			end
			else begin
				if (a^.dato.dni < at.dni) then agregar (a^.HI, at)
				else
					agregar (a^.HD, at);
			end;
		end;
					
	var 
		at: atencion;
	begin
		leerAt (at);
		while (at.matMed <> 0) do begin
			agregar (v[at.mes], at);
			leerAt (at);
		end;
	end;

	procedure calcMax (v:vector; i:integer; var max: integer; var mesMax: rangMes );  //modulo recursivo
	
		function cant (a: arbol): integer;
		begin
			if (a=nil) then cant:=0
			else
				cant := 1 + cant (a^.HI) + cant(a^.HD);
		end;
	
	var cantAt: integer;
	begin
		if (i <= df) then begin
			cantAt:= cant (v[i]);
			if (cantAt > max) then begin
				max := cantAt;
				mesMax := i;
			end;
			calcMax (v,i+1,max,mesMax);
		end;
	end;
	
	function existe (v:vector; i: integer; dni: integer): boolean;
	
		function existeArb (a: arbol; dni: integer): boolean;
		begin
			if (a=nil) then existeArb :=false
			else begin
				if (a^.dato.dni = dni) then existeArb := true
				else
					if (a^.dato.dni < dni) then existeArb := existeArb (a^.HD, dni)
					else
						existeArb := existeArb (a^.HI, dni);
			end;
		end;		
	
	begin
		if (i > df) then existe:= false
		else begin
			if (existeArb (v[i], dni)) then existe:= true
			else
				existe:= existe (v, i+1, dni);
		end;
	end;

var
	v : vector;
	dni: integer;
	max: integer;
	mesMax: rangMes;
BEGIN
	randomize;
	inicializ (v);
	cargarV (v);
	
	max:=-1;
	calcMax (v, 1, max, mesMax);
	writeln ('Mes con mayor cantidad de atenciones: ', mesMax);
	writeln ('Ingrese dni de paciente: '); readln (dni);
	if (existe(v, 1, dni)) then writeln ('El paciente fue atendido')
	else
		writeln ('El paciente NO fue atendido');
END.

