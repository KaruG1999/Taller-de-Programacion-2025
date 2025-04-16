{
parcial 10/09/2024
* turno H
}
program pH;
const df=10;
type
	rangSuc = 1..df;
	
	venta = record 
		dni: integer;
		codSuc: rangSuc;
		numFac: integer;
		monto: real;
	end;
	
	regList = record 
		numFac: integer;
		monto: real;
	end;
	
	lista = ^nodol;
	nodol = record 
		datol: regList;
		sig: lista;
	end;
	
	regArb = record 
		dni: integer;
		list: lista;
		ult: lista;
	end;
		
	arbol = ^nodo;
	nodo = record 
		dato: regArb;
		HI: arbol;
		HD: arbol;
	end;

	vector = array [rangSuc] of integer;  
	
	procedure inicializ (var v: vector);
	var i:rangSuc;
	begin
		for i:= 1 to df do
				v[i] := 0
	end;
	
	procedure cargar (var a:arbol; var v: vector);
	
		procedure leerV (var v:venta);
		begin
			v.dni := random (5000);
			if (v.dni <> 0) then begin
				v.codSuc := random (10) + 1;
				v.numFac := random (1000) + 1;
				v.monto:= random (5000) + 100;
			end;
		end;
		
		procedure agregar (var a: arbol; v: venta);
		
			procedure agAtras (var l, ult:lista; v:venta);
			var nue:lista;
			begin
				new (nue);
				nue^.datol.numFac := v.numFac;
				nue^.datol.monto := v.monto;
				nue^.sig:= nil;
				
				if (l = nil) then  // si la lista esta vacia l y ult es el nodo nuevo
					l:= nue
				else
					nue^.sig := ult; // si la lista no esta vacia el nodo sig a nue es el ultimo y nuevo ultimo es el nuevo
					
				ult := nue;
			end;
		
		begin
			if (a=nil) then begin
				new (a);
				a^.dato.dni := v.dni;
				a^.dato.list:= nil;
				a^.dato.ult:= nil;             
				agAtras (a^.dato.list, a^.dato.ult, v);
				a^.HI := nil;
				a^.HD := nil;
			end
			else begin
				if (a^.dato.dni = v.dni) then
					agAtras (a^.dato.list, a^.dato.ult, v)
				else
					if (a^.dato.dni < v.dni) then agregar (a^.HD, v)
					else
						agregar (a^.HI, v);
			end;
		end;
		
		procedure agVector (var v: vector; vent:venta);   // esta bien ? 
		begin
			v[vent.codSuc] := v [vent.codSuc] + 1;
		end;
		
	
	var vent: venta;
	begin
		leerV (vent);
		while (vent.dni <> 0) do begin
			agregar (a,vent);
			agVector (v, vent);
			leerV (vent);
		end;
	end;

	procedure incisoB (a: arbol);
	
		function cantFac (a:arbol; dni:integer; mont:real): integer;
		
			function sup (l:lista; mont: real): integer;    // cuenta en la lista cant de ventas con monto sup al indicado
			begin
				if (l = nil) then sup:= 0
				else begin
					if (l^.datol.monto > mont) then
						sup := 1 + sup (l^.sig, mont)
					else
						sup := sup (l^.sig, mont);
				end;
			end;
		
		begin
			if (a= nil) then cantFac := 0
			else begin
				if (a^.dato.dni = dni) then
					cantFac := sup (a^.dato.list, mont) 
				else
					if (a^.dato.dni < dni) then cantFac := cantFac (a^.HD,dni,mont)
					else
						cantFac := cantFac (a^.HI,dni,mont);
			end;
		end;
	
	
	var 
		dni:integer;
		mont: real;
	begin
		writeln ('Ingresar dni de cliente: ' ); readln (dni);
		writeln ('Ingresar monto: '); readln (mont);
		writeln ('Cantidad de facturas con monto sup del ingresado de el cliente ingresado: ', cantFac (a,dni,mont));
	end;

	procedure incisoC (v: vector);
	
		procedure codMax (v:vector; dl:integer; var max: integer; var maxCod: integer);  // debe ser recursivo
		begin
			if (dl <= df ) then begin
				if (v[dl] > max) then begin
					max := v[dl];
					maxCod := dl;
				end;
				codMax (v, dl+1, max, maxCod);
			end;
		end;
		
	var 
		max: integer;
		maxCod: integer;
	begin
		max:= -999;
		maxCod:= -1;
		codMax (v, 1, max, maxCod);  // envio dl = 1
		if (maxCod <> -1) then writeln ('Codigo de sucursal con mayor cant ventas: ', maxCod)
		else
			writeln ('No se encontro cod Max');
	end;

var 
	a: arbol;
	v: vector;
BEGIN
	randomize;
	a:= nil;
	inicializ (v);
	cargar (a, v);
	incisoB (a);
	incisoC (v);
END.

