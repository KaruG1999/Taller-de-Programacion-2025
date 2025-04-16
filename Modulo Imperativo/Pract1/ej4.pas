{
4.- Una librería requiere el procesamiento de la información de sus productos. De cada
producto se conoce el código del producto, código de rubro (del 1 al 8) y precio.
Implementar un programa que invoque a módulos para cada uno de los siguientes puntos:
a. Lea los datos de los productos y los almacene ordenados por código de producto y
agrupados por rubro, en una estructura de datos adecuada. El ingreso de los productos finaliza
cuando se lee el precio 0.
b. Una vez almacenados, muestre los códigos de los productos pertenecientes a cada rubro.
c. Genere un vector (de a lo sumo 30 elementos) con los productos del rubro 3. Considerar que
puede haber más o menos de 30 productos del rubro 3. Si la cantidad de productos del rubro 3
es mayor a 30, almacenar los primeros 30 que están en la lista e ignore el resto.
d. Ordene, por precio, los elementos del vector generado en c) utilizando alguno de los dos
métodos vistos en la teoría.
e. Muestre los precios del vector resultante del punto d).
f. Calcule el promedio de los precios del vector resultante del punto d)
}

program ej4;
const
	dfR = 8; 
	dfR3= 30;
type
	rangR3= 1..dfR3;
	rangR = 1..dfR;
	producto = record
		codP: integer;
		codR: rangR;
		precio: real;
	end;
	
	lista = ^nodo;		// ordenado por cod de producto
	nodo= record
		dato:producto;
		sig: lista;
	end;
	
	vectR = array [rangR] of lista;		// agrupado por rubro

	vectR3 = array [rangR3] of producto;   // vector almacena 30 productos
	
	procedure inicializarV (var vR: vectR);
	var i:integer;
	begin
		for i:=1 to dfR do begin
			vR[i]:=nil;
		end;
	end;
	
	procedure cargarV (var vR: vectR);
	
		procedure leerP (var p:producto);
		begin
			p.codP := random (100)+ 1 ;
			writeln ('Cod prod:', p.codP);
			p.codR := random (8) + 1;
			writeln ('Cod rango:', p.codR);
			p.precio:= random (150);			// si o si debe generar desde 0 a ..
			writeln ('Precio:', p.precio:0:2);
		end;
		
		procedure Insertar ( var l:lista; p: producto);
		var
			ant, act, nue: lista;
		begin
			new(nue);
			nue^.dato:= p;
			nue^.sig:= nil;
			
			ant:=l;
			act:=l;
			
			while (act <> nil) and (act^.dato.codP < p.codP) do begin
				ant:= act;
				act:= act^.sig;
			end;
			if (act = l) then  // si lista esta vacia
				l:=nue
			else
				ant^.sig:= nue;
			nue^.sig:= act;
		end;
		
		
	var
		p: producto;
	begin
		leerP (p);
		while (p.precio <> 0) do begin
			Insertar (vR[p.codR], p);		// inserto en lista por cod de producto 
			leerP (p);
		end;
	end;
	
	procedure Imprimir (v: vectR);  // df necesaria? NO, es una const
	var
		i: rangR;
		l:lista;
	begin
		for i:=1 to dfR do begin
			l:= v[i];
			writeln ('Lista Rubro:', i);
			while (l <> nil) do begin    		// podria preguntar directamente sin aux lista 
				writeln ('Codigo de producto:', l^.dato.codP);
				l:= l^.sig;
			end;
		end;
	end;
	
	procedure procesar (l3: lista; var v3: vectR3; var dl: integer);
	begin
		dl:=0;
		while (l3 <> nil) and (dl < dfR3) do begin    // mientras no se termine la lista y la dl sea menor a la dim fisica del vector rango 3
			dl:= dl+1;
			v3[dl]:= l3^.dato;
			l3:= l3^.sig;
		end;
	end;
	
	procedure Ordenar (var v: vectR3; dl: integer); // ordenar por precio por insercion
	var
		i,j: integer;
		actual: producto;
	begin
		for i:= 2 to dl do begin
			actual:= v[i];
			j:= i-1;
			while (j>0) and (v[j].precio > actual.precio) do begin  // j >=1 ?
				v[j+1]:= v[j];
				j:= j-1;
			end;
			v[j+1]:= actual;
		end;
	end;
	
	procedure Imprimir2 (v: vectR3; dl: integer);
	var
		i: rangR3;
	begin
		for i:=1 to dl do 
			writeln ('Precio producto:', v[i].precio:0:2, ' Rango producto:', i);
	end;
	
	procedure Promedio (v3: vectR3; dl: integer);
	var
		suma: real;
		i: rangR3;
	begin
		suma:=0;
		for i:=1 to dl do 
			suma:= suma + v3[i].precio;
		if (dl > 0) then
			writeln ('Precio promedio del vector Rubro 3:', (suma/dl):0:2)
		else
			writeln ('Vector vacio');
	end;
	
var 
	vR: vectR;
	vR3: vectR3;
	dl: integer;

BEGIN
	randomize;
	inicializarV (vR); 			//ini en nil listas
	cargarV(vR);				//
	Imprimir (vR); 				// cods prod de cada rubro (lista)
	procesar (vR[3], vR3, dl); 	// envio lista rubro 3, devuelve vector y dim logica (pueden ser mas o menos de 30 elementos)
	Ordenar (vR3, dl); 			// ordena por precio
	Imprimir2 (vR3, dl);		// imprime precios del vector ant
	Promedio (vR3, dl); 		// sumo todos los precios del vector y lo divido por cant precios
END.

