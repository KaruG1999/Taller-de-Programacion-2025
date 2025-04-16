{
3.- Netflix ha publicado la lista de películas que estarán disponibles durante el mes de
diciembre de 2022. De cada película se conoce: código de película, código de género (1: acción,
2: aventura, 3: drama, 4: suspenso, 5: comedia, 6: bélico, 7: documental y 8: terror) y puntaje
promedio otorgado por las críticas.
Implementar un programa que invoque a módulos para cada uno de los siguientes puntos:
a. Lea los datos de películas, los almacene por orden de llegada y agrupados por código de
género, y retorne en una estructura de datos adecuada. La lectura finaliza cuando se lee el
código de la película -1.
b. Genere y retorne en un vector, para cada género, el código de película con mayor puntaje
obtenido entre todas las críticas, a partir de la estructura generada en a)..
c. Ordene los elementos del vector generado en b) por puntaje utilizando alguno de los dos
métodos vistos en la teoría.
d. Muestre el código de película con mayor puntaje y el código de película con menor puntaje,
del vector obtenido en el punto c).
}
program ej3;
const df = 8;
type 
	ranggen= 1..df;

	pelicula = record 
		codP: integer;
		codG: ranggen;
		punt: real;
	end;
	
	lista = ^nodo;
	nodo= record 
		dato: pelicula;
		sig: lista;
	end;
	
	vectGen = array [ranggen] of lista;     // almacena lista de peliculas agupadas por genero  
	
	vp = array [ranggen] of integer; 		// almacena por cada genero el codigo con mayor puntaje 
	
	// PROCEDIMIENTO PARA CARGAR LAS PELÍCULAS AL VECTOR DE LISTAS
	procedure cargarV (var vgen: vectGen); // carga pelicula a la lista correspondiente segun cod
	
		procedure AgAtras (var l, ult: lista; p: pelicula);
		var
			nue: lista;
		begin
			new (nue);
			nue^.dato:=p;
			nue^.sig:= nil;
		
			if (l = nil) then begin
				l:= nue;
				ult:= nue;
			end
			else begin
				ult^.sig := nue;
				ult:= nue;
			end;
		end;
	
		// PROCEDIMIENTO PARA LEER PELÍCULA (SIMULANDO ENTRADA)
		procedure leerP (var p: pelicula);
		begin
			p.codP := random (100)-1; // cod de pelicula del 1 al 100
			writeln ('Codigo de pelicula:', p.codP);
			if (p.codP <> -1) then begin
				p.codG:= random (8) + 1; 	// codigo del 1 al 8 (rangGen)
				writeln ('Codigo de genero:', p.codG);
				p.punt:= random (10) + 1; 	// puntaje generado entre el 1 y el 10
				writeln ('Puntaje promedio de pelicula:', p.punt:0:2);
			end;
		end;
		
	var
		p: pelicula;
		ult: array [ranggen] of lista; // cada genero tiene su puntero al ultimo
	begin
		leerP (p);
		while (p.codP <> -1) do begin 				 // deberia agregar la nueva pelicula a la lista del codigo que corresponde 
			AgAtras (vgen[p.codG], ult[p.codG], p);  // agrego nodo a la lista del cod de genero, actualizo punt al ultimo 
			leerP (p);
		end; 
	end;	
	
	// PROCEDIMIENTO PARA INICIALIZAR LAS LISTAS Y EL VECTOR DE CÓDIGOS
	procedure inicializarV (var vgen: vectGen; var vp: vp);    // puedo usar df sin pasar por parametro
	var
		i: ranggen;
	begin
		for i:=1 to df do begin
			vgen[i]:= nil;
			vp[i]:=0;
		end;
	end;
	
	procedure procesar (vgen: vectGen; var vp: vp); // retorna en vector contador, el cod de peli con mayor puntaje
	var
		i: ranggen;
		pmax: real;
		codPMax: integer;
		l:lista;
	begin
		for i:=1 to df do begin
			l:= vgen[i]; 		// recorro lista con un aux				
			pmax:= -1;
			codPMax:= 0;
			while (l <> nil) do begin
				if (l^.dato.punt > pmax) then begin
					pmax:= l^.dato.punt;
					codPMax := l^.dato.codP;
				end;
				l := l^.sig; 	// avanzo en la lista 
			end; 				// cuando recorre toda la lista pasa a la siguiente lista del vector
			vp[i] := codPMax; // agrego en el vector contador el cod pelicula con mayor puntaje de cada lista
		end;
	end;
	
	procedure ordenar (var vp: vp); // ordeno por insercion el vector contador 
	var
		i,j: integer;   								// deja de dar error al cambiar ranggen a integer
		actual: integer;
	begin
		for i:= 2 to df do begin
			actual:= vp[i];
			j:= i-1;
			while (j > 0) and (vp[j] > actual) do begin   // si uso j>0 error, si uso j>=1 también ??
				vp[j+1]:= vp[j];
				j:= j-1;
			end;
			vp[j+1]:= actual;
		end;
	end;
	
var 
	vgen: vectGen;
	vpel: vp;
BEGIN
	randomize;
	inicializarV (vgen, vpel);		// inicializo vector de listas en nil y vector de cods de peliculas en 0
	cargarV (vgen);  				// cargar vector de genero 
	procesar (vgen, vpel );			// genera vector con los puntajes max por cod de genero 
	ordenar (vpel);					// ordeno el vector de puntajes 
	
	writeln ('Codigo de pelicula con mayor puntaje:', vpel[df]);
	writeln ('Codigo de pelicula con menor puntaje:', vpel [1]);
	
	//imprimir (vpel);				// imprime min y max del vector anterior 
END.
