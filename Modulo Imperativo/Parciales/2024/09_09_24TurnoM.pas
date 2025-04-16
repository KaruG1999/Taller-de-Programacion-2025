{
 parcial 09/09/24
 * Turno M
}

program parcial;
type
	rangDiag = 1..6;
	
	atencion = record
		matMed: integer;
		dniPac: integer;
		dia: integer;
		diag: char;
	end;
 
	regArb = record 
		matMed: integer;
		cantAte: integer;
	end;
 
	arbol = ^nodo;
	nodo = record 
		dato: regArb;
		HI: arbol;
		HD: arbol;
	end;
 
	lista = ^nodol;
	nodol = record 
		dni: integer;
		sig:lista;
	end;
 
	regVec = record 
		diag: char;
		list: lista;
	end;
 
	vector = array [rangDiag] of regVec;
	
	procedure inicializ (var v: vector);
	var 
		i: integer;
		vDiag : array [1..6] of char = ('A','B','C','D','E','F');
	begin
		for i:=1 to 6 do begin
			v[i].diag := vDiag [i];
			v[i].list:= nil;
		end;
	end;
	
	procedure cargar (var a:arbol; var v: vector);
	
		procedure leerAt (var at: atencion);
		var vDiag : array [1..6] of char = ('A','B','C','D','E','F');
		begin
			at.dniPac := random (1000);
			if (at.dniPac <> 0) then begin
				at.matMed:= random (100)+ 1;
				at.dia:= random (30)+1;
				at.diag := vDiag[random(6)+1];
			end;
		end;
		
		procedure agregar (var a:arbol; at:atencion);
		begin
			if (a=nil) then begin
				new (a);
				a^.dato.matMed := at.matMed;
				a^.dato.cantAte := 1;
				a^.HD:= nil;
				a^.HI:= nil;
			end
			else begin
				if (a^.dato.matMed = at.matMed) then a^.dato.cantAte := a^.dato.cantAte + 1 
				else
					if (a^.dato.matMed < at.matMed) then agregar (a^.HD, at)
					else
						agregar (a^.HI, at);
			end;
		end;
		
		procedure agVector (var v: vector; at: atencion);
		
			procedure agAdel (var l:lista; dni:integer);
			var nue:lista;
			begin
				new (nue);
				nue^.dni:= dni;
				nue^.sig:= l;
				l:= nue;
			end;
		
		var
			i:rangDiag;
		begin
			for i:=1 to 6 do begin
				if (v[i].diag = at.diag) then  	 // si coincide el char agrega a la lista que corresponde 
					agAdel (v[i].list, at.dniPac);
			end;
		end;
		
	
	var at:atencion;
	begin
		leerAt (at);
		while (at.dniPac <> 0) do begin
			agregar (a, at);
			agVector (v, at);
			leerAt (at);
		end;
	end;
	
	function cantAt (a: arbol; numM:integer): integer;
	begin
		if (a=nil) then cantAt :=0
		else begin
			if (a^.dato.matMed > numM) then cantAt:=  a^.dato.cantAte + cantAt (a^.HI, numM) + cantAt (a^.HD, numM) 
			else
				cantAt := cantAt (a^.HD, numM);
		end;
	end;
	
	procedure maximo (v: vector; i: integer ; var maxP: integer; var diagMax: char);
	
		function cantL (l:lista):integer;
		begin
			if (l=nil) then cantL:=0
			else
				cantL := 1 + cantL (l^.sig);
		end;
	
	var cant: integer;
	begin
		if (i <= 6) then begin
			cant := cantL (v[i].list);
			if (cant > maxP) then begin
				maxP:= cant;
				diagMax:= v[i].diag;
			end;
			maximo (v, i+1, maxP, diagMax);
		end;
	end;
  
var 
	a: arbol;
	v: vector;
	numM: integer;
	maxP: integer;
	diagMax :char;
BEGIN
	randomize;
	a:= nil;
	inicializ (v);
	cargar (a, v);
	
	writeln ('Ingresar num de matricula: '); readln (numM);
	writeln ('Cantidad total de atenciones por medicos con matricula mayor a la ingresada : ', cantAt (a, numM));
	
	maxP := -1;
	maximo (v, 1, maxP, diagMax);
	writeln ('Diagnostico con mayor cantidad de pacientes: ', diagMax);
END.

