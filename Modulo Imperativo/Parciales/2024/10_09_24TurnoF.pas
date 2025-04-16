{
 Parcial 10/09/2024
 * Turno F   
}

program p09;
const df= 8;
type 
	rangMat = 1..df;

	artesania = record   //se lee 
		numId : integer;
		dni: integer;
		codMat: rangMat;
	end;	
	
	regArb = record
		dni: integer;
		cantArt: integer;
	end;
	
	arbol = ^nodo;
	nodo = record 
		dato: regArb;
		HI: arbol;
		HD: arbol;
	end;
	
	regVec = record 
		codMat: rangMat;
		cantArt :integer;
	end;
	
	vector = array [rangMat] of regVec;
	
	procedure inicializ (var v:vector);
	var i:rangMat;
	begin
		for i:=1 to df do begin
			v[i].codMat := i;
			v[i].cantArt := 0;
		end;
	end;
	
	procedure cargar (var a:arbol; var v:vector);
	
		procedure leerArt (var a: artesania);
		begin
			a.dni := random (1000);
			if (a.dni <> 0) then begin
				a.numId := random (100) + 100;
				a.codMat:= random (8) + 1;
			end;
		end;
		
		procedure agregar (var a:arbol; art:artesania);
		begin
			if (a=nil) then begin
				new (a);
				a^.dato.dni := art.dni;
				a^.dato.cantArt := 1;
				a^.HI := nil;
				a^.HD := nil;
			end
			else begin
				if (a^.dato.dni = art.dni) then a^.dato.cantArt := a^.dato.cantArt + 1
				else
					if (a^.dato.dni < art.dni) then agregar (a^.HD, art)
					else
						agregar (a^.HI, art);
			end;
		end;
		
		procedure agVector (var v:vector; art:artesania);
		begin
			v[art.codMat].cantArt := v[art.codMat].cantArt + 1;
		end;
	
	var art: artesania;
	begin
		leerArt (art);
		while (art.dni <> 0) do begin
			agregar (a, art);
			agVector(v, art);
			leerArt (art);
		end;
	end;
	
	function cantArt (a:arbol; dni:integer): integer;
	begin
		if (a=nil) then cantArt :=0
		else
			if (a^.dato.dni < dni) then cantArt := 1 + cantArt (a^.HI, dni) + cantArt (a^.HD, dni)
			else
				cantArt := cantArt (a^.HI, dni);
	end;
	
	procedure incisoC ( var v:vector ; var nomMax : string);
	
		procedure ordenar (var v: vector);
		var 
			i,j: integer;
			actual: regVec;
		begin
			for i:=1 to df do begin
				actual := v[i];
				j:= i-1;
				while (j > 0) and (v[j].cantArt > actual.cantArt) do begin
					v[j+1]:= v[j];
					j:= j-1;
				end;
				v[j+1]:= actual;
			end;
		end;
	
	
	var vMat : array [rangMat] of string = ('Madera','Yeso','Ceramica','Vidrio','Acero','Porcelana','Lana','Carton');
	begin
		ordenar (v);
		nomMax := vMat [v[df].codMat];
		writeln ('Nombre de material base con mayor cantidad de artesanias: ', nomMax);
	end;
	
var 
	a : arbol;
	v: vector;
	dni: integer;
	nomMax : string;
BEGIN
	randomize;
	a:=nil;
	inicializ (v);
	cargar (a, v);
	
	writeln ('Ingrese un dni: '); readln (dni);
	writeln ('Cantidad de artesanos con dni menor al ingresado: ', cantArt (a, dni));
	
	incisoC (v, nomMax);
END.

