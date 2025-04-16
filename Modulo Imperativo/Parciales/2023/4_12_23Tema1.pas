{
Parcial 4/12/2023  
* recuperatorio tema1
* 
}

program parcial;
const df=12;

type 
	rangMes = 1..df;
	rangProv = 1..24;
	partida = record
		mes: rangMes;
		anio: integer;
		codProv: rangProv;
		monto: real;
	end;
	
	regL = record
		mes: rangMes;
		codProv: rangProv;
		monto: real;
	end;
	
	lista = ^nodol;
	nodol = record 
		datol : regL;
		sig: lista;
	end;
	
	regArb = record 
		anio: integer;
		list: lista;
	end;
	
	arbol = ^nodo;
	nodo= record 
		dato: regArb;
		HI: arbol;
		HD: arbol;
	end;
	
	regVec = record 
		cantPart: integer;
		montoTot: real;
	end;
	
	vector = array [rangProv] of regVec;
	
	procedure cargarA (var a:arbol);
	
		procedure leerP (var p: partida);
		begin
			p.mes := random (12) +1;
			p.anio:= 2000 + random (2025-2000+1);
			p.codProv := random (24)+1;
			p.monto := random (50000);
		end;
		
		
		procedure insertar (var l:lista; p:partida);  // ordenada por mes de manera ascendente 
		var
			ant, act, nue: lista;
		begin
			new (nue);
			nue^.datol.mes:= p.mes;
			nue^.datol.codProv := p.codProv;
			nue^.datol.monto := p.monto;
			ant:=nil;
			act:=l;
			
			while (act <> nil) and (act^.datol.mes < p.mes) do begin
				ant:= act;
				act:= act^.sig;
			end;
			if (ant = nil) then begin
				nue^.sig:= l;
				l:=nue;
			end
			else begin
				nue^.sig:= act;
				ant^.sig:= nue;
			end;
		end;
		
		procedure agregar (var a:arbol; p:partida);
		begin 
			if (a=nil) then begin
				new (a);
				a^.dato.anio := p.anio;
				a^.dato.list :=nil;
				insertar (a^.dato.list, p);
				a^.HI := nil;
				a^.HD := nil;
			end
			else begin
				if (a^.dato.anio = p.anio) then insertar (a^.dato.list, p)
				else
					if (a^.dato.anio < p.anio) then agregar (a^.HD, p)
					else
						agregar (a^.HI, p);
			end;
		end;
	
	var p:partida;
	begin
		leerP (p);
		while (p.codProv <> 24) and (p.mes <> 12) and (p.anio <> 2022) do begin  //corte genera errores 
			agregar (a, p);
			leerP (p);
		end;
	end;

	procedure inicializ (var v: vector);
	var i:rangProv;
	begin
		for i:=1 to 24 do begin
			v[i].cantPart:= 0;
			v[i].montoTot:=0;
		end;
	end;
	
	procedure inciso2 (a: arbol; var v: vector);
	
		procedure agVector (var v:vector; l:lista);
		begin
			while (l<> nil) do begin
				v[l^.datol.codProv].cantPart :=  v[l^.datol.codProv].cantPart + 1;
				v[l^.datol.codProv].montoTot :=  v[l^.datol.codProv].montoTot + l^.datol.monto;
				l:= l^.sig;
			end;
		end;
	
	begin
		if (a <> nil) then begin
			agVector (v ,a^.dato.list);
			inciso2 (a^.HI, v);
			inciso2 (a^.HD, v);
		end;
	end;
	
	procedure inciso3 (v: vector; i: integer; var maxPart: integer ;var maxProv: integer);
	begin
		if (i <= 24) then begin
			if (v[i].cantPart > maxPart) then begin
				maxPart := v[i].cantPart;
				maxProv := i;
			end;
			inciso3 (v, i+1, maxPart, maxProv);
		end;
	end;
	
	procedure inciso4 (a:arbol; a1,a2: integer; mes:rangMes; var cantTot: integer);
	
		procedure evaluar (l: lista; mes: rangMes; var cantTot: integer);
		begin
			if (l <> nil) then begin
				if (l^.datol.mes = mes) then
					cantTot := cantTot + 1;
				evaluar (l^.sig, mes, cantTot);
			end;
		end;
	
	begin
		if (a=nil) then cantTot:=0
		else begin
			if (a^.dato.anio > a1) and (a^.dato.anio < a2) then begin
				evaluar (a^.dato.list, mes, cantTot);
				inciso4 (a^.HD, a1,a2, mes, cantTot);
				inciso4 (a^.HI, a1,a2, mes, cantTot);
			end
			else
				if (a^.dato.anio <= a1) then inciso4 (a^.HD, a1,a2, mes, cantTot)
				else
					inciso4 (a^.HI, a1,a2, mes, cantTot);
		end;
	end;

var 
	a: arbol;
	v: vector;
	maxProv: integer;
	mes: rangMes;
	maxPart: integer;
	a1,a2: integer;
	cantTot: integer;
BEGIN
	randomize;
	a:= nil;
	cargarA (a);
	
	inicializ (v);
	inciso2 (a, v);
	
	maxPart:= 0;
	inciso3 (v, 1, maxPart, maxProv);
	writeln ('Codigo de provincia con mayor cantidad de partidas recibidas: ', maxProv);
	
	
	writeln ('Ingresar mes: '); readln (mes);
	writeln ('Ingrese anio1 y anio 2: '); readln (a1); readln (a2);
	cantTot:=0;
	inciso4 (a, a1, a2, mes, cantTot);
	writeln ('Cantidad total de partidas enviadas dicho mes, entre esos años: ', cantTot);
	
END.

