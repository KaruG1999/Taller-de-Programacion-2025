{
Una agencia dedicada a la venta de autos ha organizado su stock y, tiene la información
de los autos en venta. Implementar un programa que:
a) Genere la información de los autos (patente, año de fabricación (2010..2018), marca y
modelo, finalizando con marca ‘MMM’) y los almacene en dos estructuras de datos:
i. Una estructura eficiente para la búsqueda por patente.
ii. Una estructura eficiente para la búsqueda por marca. Para cada marca se deben
almacenar todos juntos los autos pertenecientes a ella.
b) Invoque a un módulo que reciba la estructura generado en a) i y una marca y retorne
la cantidad de autos de dicha marca que posee la agencia.
c) Invoque a un módulo que reciba la estructura generado en a) ii y una marca y retorne
la cantidad de autos de dicha marca que posee la agencia.
d) Invoque a un módulo que reciba el árbol generado en a) i y retorne una estructura con
la información de los autos agrupados por año de fabricación.
e) Invoque a un módulo que reciba el árbol generado en a) i y una patente y devuelva el
modelo del auto con dicha patente.
f) Invoque a un módulo que reciba el árbol generado en a) ii y una patente y devuelva el
modelo del auto con dicha patente. 
}

program ej2;

type
	rangAnios = 2010..2018;

	auto = record 
		patente: integer;
		anioFab: rangAnios;
		marca: string;
		modelo: string;
	end;
	
	arbol = ^nodo1;
	nodo1 = record 
		dato: auto;
		HI : arbol;
		HD : arbol;
	end;
	
	regList = record 
		patente: integer;
		anioFab: rangAnios;
		modelo: string;
	end;
	
	lista = ^nodol;
	nodol= record
		datol: reglist;
		sig: lista;
	end;
	
	reg2 = record
		marca: string;
		list: lista;
	end;
	
	arbol2 = ^nodo2;
	nodo2 = record
		dato2: reg2;
		HI: arbol2;
		HD: arbol2;   // puede tener los mismos tags que id 1? si, los campos pueden tener el mismo nombre 
	end;

	regL = record
		patente: integer;
		marca : string;
		modelo: string;
	end;

	listaAnio = ^nodoList;
	nodoList = record 
		datoL: regL;
		sig: listaAnio;
	end;

	vector = array [rangAnios] of listaAnio;

	procedure cargarA (var a1: arbol; var a2: arbol2);
	
		procedure leerAuto (var a: auto);
		var
			vMarcas : array [0..9] of string = ('Toyota','MMM','Chevrolet','Ford','Honda','Fiat','Citroen','Mercedes','Renault','Audi');
			vModelos: array [0..4] of string = ('Sedan','Coupe','Descapotable','Hibrido','PickUp');
		begin
			a.patente := random (3000) + 1000;
			a.anioFab := 2010 + random (2018 - 2010 +1);
			a.marca := vMarcas [random (10)];
			if (a.marca <> 'MMM') then
				a.modelo := vModelos [random(5)];
		end;
	
		procedure agregarA1 (var a1: arbol; a: auto);    // ordenado por patente
		begin
			if (a1 = nil) then begin
				new (a1);
				a1^.dato:= a;
				a1^.HI:= nil;
				a1^.HD := nil;
			end
			else begin
				if (a1^.dato.patente < a.patente) then
					agregarA1 (a1^.HD, a)
				else
					agregarA1 (a1^.HI, a);
			end;
		end;
		
		procedure agregarA2 (var a2: arbol2; a: auto);  // ordenado por marca, para cada marca los autos almacenados (lista autos)
		
			procedure agAdel (var l: lista; a: auto);
			var nue:lista;
			begin
				new (nue);
				nue^.datol.patente:= a.patente;
				nue^.datol.anioFab:= a.anioFab;
				nue^.datol.modelo := a.modelo;
				nue^.sig := l;
				l:= nue;
			end;
				
		begin
			if (a2 = nil) then begin
				new (a2);
				a2^.dato2.marca := a.marca;
				a2^.dato2.list := nil;
				agAdel (a2^.dato2.list, a);
				a2^.HI:= nil;
				a2^.HD:= nil;
			end
			else begin
				if (a2^.dato2.marca = a.marca) then
					agAdel (a2^.dato2.list, a)
				else
					if (a2^.dato2.marca < a.marca) then agregarA2 (a2^.HD, a)
					else
						agregarA2 (a2^.HI, a);
			end;
		end;
	
	var 
		a: auto;
	begin
		leerAuto (a);
		while (a.marca <> 'MMM') do begin
			agregarA1 (a1, a);
			agregarA2 (a2, a);
			leerAuto (a);
		end;
	end;

	function cantAut (a: arbol; marc: string): integer;  // devuelve cant de autos de marca ingresada
	begin
		if (a = nil) then cantAut := 0
		else begin
			if ( a^.dato.marca = marc) then
				cantAut := 1 + cantAut (a^.HI, marc) + cantAut (a^.HD, marc)
			else
				cantAut := cantAut (a^.HI, marc) + cantAut (a^.HD, marc);
		end;
	end;
	
	procedure cantAutos (a2: arbol2);   // devuelve cant de autos de la marca ingresada 
	
		function cantL (l: lista): integer;
		begin
			if (l = nil) then cantL := 0
			else
				cantL := 1 + cantL (l^.sig);
		end;
		
	
		function cantA (a: arbol2; marc: string): integer;
		begin
			if (a= nil) then cantA :=0
			else begin
				if (a^.dato2.marca = marc) then
					cantA := cantL (a^.dato2.list) + cantA (a^.HI, marc) + cantA (a^.HD, marc)
				else 
					if (a^.dato2.marca < marc) then cantA := cantA (a^.HD, marc)
					else
						cantA := cantA (a^.HI, marc);
			end;
		end;
	
	var marc: string;
	begin
		writeln ('Ingresar marca: '); readln (marc);
		writeln ('Cantidad de autos de dicha marca en arbol 2: ', cantA (a2,marc));
	end;
	
	procedure inicializ (var v: vector);		// inicializo vector con listas en nil
	var i: rangAnios;
	begin
		for i:= 2010 to 2018 do
			v[i] := nil;
	end;
	
	
	procedure estrNue (a: arbol; var v: vector); 		// vector de listas 
	
		procedure agAdel (var l: listaAnio; a: auto);
		var nue: listaAnio;
		begin
			new (nue);
			nue^.datoL.patente := a.patente;
			nue^.datoL.marca := a.marca;
			nue^.datoL.modelo:= a.modelo;
			nue^.sig := l;
			l:= nue;
		end;
	
	begin
		if (a <> nil) then begin
			agAdel (v[a^.dato.anioFab], a^.dato);   // recorro arbol y por cada año de fab(indice vect) agrego el dato en lista
			estrNue (a^.HI,v);
			estrNue (a^.HD,v);
		end;
	end;
			
	procedure modelo (a: arbol; pat: integer; var model: string); 
	begin
		if (a <> nil) then begin
			if (a^.dato.patente = pat) then
				model := a^.dato.modelo
			else begin
				if (a^.dato.patente < pat) then 
					modelo (a^.HD, pat, model)
				else
					modelo (a^.HI, pat, model);
			end;
		end
		else 
			writeln ('Patente no encontrada');
	end;
	
	procedure devModelo (a: arbol2);
	
		procedure buscaPat (a: arbol2; pat: integer; var model: string; var existe: boolean);
		var
			l: lista;
		begin
			if (a <> nil) and (not existe) then begin	// por cada nodo (marca) y recorro lista buscando pat 
				l:= a^.dato2.list;
				while (l <> nil) and (not existe) do begin
					if (l^.datol.patente = pat) then begin
						model := l^.datol.modelo;    // si lo encontro se detiene ahí?
						existe:= true;
					end
					else 
						l:= l^.sig;
				end;
				if not existe then buscaPat (a^.HI, pat, model);
				if not existe then buscaPat (a^.HD, pat, model);				// es valido????
				end; 		
			end;
		end;
		
	var 
		model: string;
		pat: integer;
		existe: boolean
	begin
		existe:= false;
		writeln ('Ingresar patente: '); readln (pat);
		buscaPat(a, pat, model, existe);
		if (existe) then writeln ('Modelo del auto de dicha patente en arbol2: ', model)
		else 
			writeln ('No existe patente ingresada');
	end;
	
var 
	a1: arbol;
	a2: arbol2;
	marc: string;
	model: string;
	v: vector;
	pat: integer;
BEGIN
	randomize;
	a1:= nil; a2:= nil;
	cargarA (a1, a2);
	
	writeln ('Ingresar marca: '); readln (marc);
	writeln ('Cantidad de autos de dicha marca en arbol 1: ', cantAut (a1, marc));
	
	cantAutos (a2); // idem anterior con arbol2
	
	inicializ (v);
	estrNue (a1, v);
	
	writeln ('Ingresar patente: '); readln (pat);
	modelo (a1, pat, model);
	writeln ('Modelo del auto de dicha patente: ', model);
	
	devModelo (a2);  // idem anterior con arbol2
END.

