{
parcial 09/09/24
* Turno P
}
program pTurnoP;
const df=5;
type
	rangCat = 1..df;

	compra = record 
		codCom: integer;
		codCl: integer;
		catE: string;
	end;


	regArb = record 
		codCom: integer;
		cantEnt: integer;
	end;

	arbol =^nodo;
	nodo= record 
		dato: regArb;
		HI: arbol;
		HD: arbol;
	end;
	
	regVec = record 
		nomCat: string;
		cantEnt: integer;
	end;
	
	vector = array [rangCat] of regVec;
	
	procedure inicializ (var v: vector);
	var 
		i:rangCat;
		vNom : array [rangCat] of string = ('Full','Media','Super','Normal','Basica');
	begin
		for i:=1 to df do begin
			v[i].nomCat := vNom [i];
			v[i].cantEnt := 0;
		end;
	end;
			
	procedure cargar (var a:arbol; var v: vector);
		
		procedure leerC (var c:compra);
		var
			vNom : array [rangCat] of string = ('Full','Media','Super', 'Normal','Basica');
		begin
			c.codCl := random (200);
			if (c.codCl <> 0) then begin
				c.catE := vNom [random(5)+1];
				c.codCom := random (200) + 1000;
			end;
		end;
		
		procedure cargarA (var a: arbol; c:compra);
		begin
			if (a=nil) then begin
				new (a);
				a^.dato.codCom:= c.codCom;
				a^.dato.cantEnt := 1;
				a^.HI := nil;
				a^.HD := nil;
			end
			else begin
				if (a^.dato.codCom = c.codCom) then
					a^.dato.cantEnt := a^.dato.cantEnt + 1
				else
					if (a^.dato.codCom < c.codCom) then cargarA (a^.HD, c)
					else
						cargarA (a^.HI, c);
			end;
		end;
		
		procedure cargarV (var v:vector ; c: compra);
		var i: rangCat;
			vNom : array [rangCat] of string = ('Full','Media','Super','Normal','Basica');
		begin
			for i:=1 to df do begin
				if ( vNom[i] = c.catE ) then   			// si coinciden los strings sumo 1 a la cant de entregas 
					v[i].cantEnt:= v[i].cantEnt + 1;
			end;
		end;
		
	var c:compra;		
	begin
		leerC (c);
		while (c.codCl <> 0) do begin
			cargarA (a, c);
			cargarV (v, c);
			leerC (c);
		end;
	end;
		
	function calcCant (a: arbol; codC: integer):integer;
	begin
		if (a=nil) then calcCant := 0
		else begin
			if (a^.dato.codCom = codC) then
				calcCant := a^.dato.cantEnt
			else
				if (a^.dato.codCom < codC) then calcCant := calcCant (a^.HD, codC)
				else
					calcCant:= calcCant (a^.HI, codC);
		end;
	end;
	
	procedure incisoC (var v:vector; var maxCat: string);
	
		procedure ordenar (var v:vector);   //por insercion 
		var
			i,j:integer;
			actual : regVec;
		begin
			for i:=2 to df do begin
				actual:= v[i];
				j:= i-1;
				while (j>0) and (v[j].cantEnt > actual.cantEnt) do begin   // se ordena por cant de entregas de menor a mayor
					v[j+1] := v[j];
					j:= j-1;
				end;
				v[j+1]:= actual;
			end;
		end;
	
	begin
		ordenar (v);
		maxCat := v[df].nomCat; 			// no necesariamente debe imprimir 
	end;
		
var
	a: arbol;
	v: vector;
	codC: integer;
	maxCat: string;
BEGIN
	randomize;
	a:= nil;
	inicializ (v);
	cargar (a, v);
	
	writeln ('Ingresar codigo de comida: '); readln (codC);
	writeln ('Cantidad de entregas realizadas al cod ingresado: ', calcCant (a,codC));
	
	IncisoC (v, maxCat);
	writeln ('Categoria con mayor cant de entregas: ', maxCat)
	
END.
{no resuelto}
