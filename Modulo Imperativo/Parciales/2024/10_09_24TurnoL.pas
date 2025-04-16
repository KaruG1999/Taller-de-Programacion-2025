{  
 parcial 10/09/24
 * Turno L  
}

program parcial;
const df=12;
type
	
	rangMes = 1..df;
	
	compra = record 
		codCl: integer;
		numF: integer;
		mes: rangMes;
		monto: real;
	end;
	
	vectAnual = array [rangMes] of real;
	
	regArb = record 
		codCl: integer;
		vector: vectAnual;
	end;
	
	arbol=^nodo;
	nodo = record 
		dato:regArb;
		HI: arbol;
		HD: arbol;
	end;
		
		
	procedure cargarA (var a:arbol);
	
		procedure leerC (var c: compra );
		begin
			c.codCl:= random (1000);
			if (c.codCl <> 0) then begin
				c.numF := random (2000)+1000;
				c.mes := random (12)+1;
				c.monto := random (2000);
			end;
		end;
		
		procedure agregar (var a:arbol; c:compra);
		
			procedure inicializ (var v:vectAnual);
			var i:rangMes;
			begin
				for i:=1 to df do 
					v[i]:=0;
			end;
		
			procedure cargarV (var v:vectAnual ; c:compra);
			begin
				v[c.mes]:= v[c.mes] + c.monto;
			end;
		
		
		begin
			if (a=nil) then begin
				new (a);
				a^.dato.codCl:= c.codCl;
				inicializ (a^.dato.vector);
				cargarV (a^.dato.vector, c);
				a^.HI:= nil;
				a^.HD:= nil;
			end
			else begin
				if (a^.dato.codCl = c.codCl) then cargarV (a^.dato.vector, c)
				else
					if (a^.dato.codCl < c.codCl) then agregar (a^.HD, c)
					else
						agregar (a^.HI, c);
			end;
		end;
				
	
	var c:compra;
	begin
		leerC (c);
		while (c.codCl <> 0) do begin
			agregar (a, c);
			leerC (c);
		end;
	end;

	procedure calcMax (a: arbol; cod:integer; var cantMax: real; var mesMax: integer);

		procedure recorreV (v:vectAnual; var cantMax: real; var mesMax: integer);
		var i:rangMes;
		begin
			for i:=1 to df do begin
				if (v[i] > cantMax) then begin
					cantMax:= v[i];
					mesMax:= i;
				end;
			end;
		end;

	begin
		if (a <> nil) then begin
			if (a^.dato.codCl = cod) then 
				recorreV (a^.dato.vector, cantMax, mesMax)
			else 
				 if (a^.dato.codCl < cod) then calcMax (a^.HD, cod, cantMax, mesMax)
				 else
					calcMax (a^.HI, cod, cantMax, mesMax);
		end
	end;
	
	procedure incisoC (a:arbol; mes: integer; var cantCl: integer);
	begin
		if (a <> nil) then begin
			if (a^.dato.vector[mes] = 0) then
				cantCl:= cantCl + 1;
			incisoC (a^.HI, mes, cantCl);
			incisoC (a^.HD, mes, cantCl);
		end;
	end;

var 
	a: arbol;
	cod:integer;
	mes, mesMax:integer;
	cantMax:real;
	cantCl: integer;
BEGIN
	randomize;
	a:=nil;
	cargarA (a);
	
	writeln ('Ingrese codigo de cliente: '); readln (cod);
	cantMax:=-1;
	calcMax (a, cod, cantMax, mesMax);
	writeln ('Mes con mayor gasto del mes de dicho cliente: ', mesMax);
	
	writeln ('Ingresar numero de mes: '); readln (mes);
	cantCl :=0;
	incisoC (a, mes, cantCl);
	writeln ('cantidad de clientes de que no gastaron nada en dicho mes: ', cantCl);
END.

