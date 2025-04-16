{
Parcial 10/09/24
* Turno E
* 
}
program ParcialE;
const df= 7;
type
	rangGen= 1..df;

	libro = record
		ISBN: integer;
		codAut: integer;
		codGen: rangGen;
	end;
	
	regCod = record  
		codAut : integer;
		cantL : integer;
	end;
	
	arbol = ^nodo;    // ordenado por cod de autor 
	nodo = record 
		dato: regCod;
		HI: arbol;
		HD: arbol;
	end;
	
	regVec = record 
		codGen: integer;
		cantL: integer;
	end;
	
	vector = array [rangGen] of regVec ; 		//  la forma correcta es con vector de registro (no vect cont)
	
	procedure inicializ (var v: vector);
	var i:integer;
	begin
		for i:=1 to df do begin
			v[i].codGen := i;
			v[i].cantL := 0;
		end;
	end;
	
	procedure cargar (var a:arbol; var v: vector);
	
		procedure leerAut (var l: libro);
		begin
			l.ISBN := random (1000);
			if (l.ISBN <> 0) then begin
				l.codAut := random (300) + 100;
				l.codGen := random (7) + 1;
			end;
		end;
		
		procedure agregar (var a: arbol; l:libro);   // ordenado por cod de autor 
		
		begin
			if (a=nil) then begin
				new (a);
				a^.dato.codAut := l.codAut;
				a^.dato.cantL := 1; 		     //inicializo el contador en 1
				a^.HI := nil;
				a^.HD := nil;
			end
			else begin
				if (a^.dato.codAut = l.codAut) then 
					a^.dato.cantL := a^.dato.cantL + 1
				else
					if (a^.dato.codAut < l.codAut) then agregar (a^.HD, l)
					else
						agregar (a^.HI, l);
			end;
		end;
	
		procedure agVector (var v: vector; l: libro);
		begin
				v[l.codGen].cantL := v[l.codGen].cantL + 1;   // al campo cantL del cod de genero le sumo libro leido 
		end;
	
	var l: libro;
	begin
		leerAut (l);
		while (l.ISBN <> 0) do begin
			agregar (a, l);
			agVector(v, l);
			leerAut (l);
		end;
	end;

		procedure ordenar (var v: vector);  // ordeno vector por cantidad 
		var
			i,j: integer;
			item: regVec;		
		begin
			for i:= 2 to df do begin
				item:= v[i];
				j:= i-1;
				while (j > 0) and (v[j].cantL > item.cantL )do begin  // ordena de mayor a menor?
					v[j+1] := v[j];
					j:= j-1;
				end;
				v[j+1]:= item; 
			end;
		end;
	
	// primero ordeno vector y con el cod de genero max imprimo el vector de nombres 
	
	procedure incisoB ( var v: vector);
	var 
		vGen : array [rangGen] of string = ('literario','filosofia','biologia','arte','computacion','medicina','ingenieria');
		codMax : integer;
	begin
		ordenar (v);
		codMax := v[1].codGen;   // el que queda almacenao en indice 1 del vector es el mayor
		writeln ('Nombre de genero con mayor cantidad de libros: ', vGen [codMax]);
		
	end;
	
	procedure entreValores (a: arbol);
	
		function cantLib (a: arbol; c1,c2: integer): integer;
		begin
			if (a = nil) then cantLib := 0
			else begin
				if (a^.dato.codAut >= c1) and (a^.dato.codAut <= c2) then
					cantLib := a^.dato.cantL + cantLib (a^.HI,c1,c2) + cantLib (a^.HD, c1,c2)
				else
					if (a^.dato.codAut < c1) then cantLib := cantLib (a^.HD, c1,c2)
					else
						cantLib := cantLib (a^.HI, c1,c2);
			end;
		end;
					
	var c1,c2: integer;
	begin
		writeln ('Ingresar cod 1: '); readln (c1);
		writeln ('Ingresar cod 2: '); readln (c2);
		writeln ('Cantida total de libros entre los cods de autor ingresados: ', cantLib (a,c1,c2));
	end;

var 
	a: arbol; 
	v: vector;
BEGIN
	randomize;
	a:= nil;
	inicializ (v);  
	cargar (a, v);
	incisoB (v); 
	entreValores (a);
END.

