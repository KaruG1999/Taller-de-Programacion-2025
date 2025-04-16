{
3.- Implementar un programa que invoque a los siguientes módulos.
a. Un módulo recursivo que retorne un vector de 20 números enteros “random” mayores a 300
y menores a 1550 (incluidos ambos).
b. Un módulo que reciba el vector generado en a) y lo retorne ordenado. (Utilizar lo realizado
en la práctica anterior)
c. Un módulo que realice una búsqueda dicotómica en el vector, utilizando el siguiente
encabezado:
Procedure busquedaDicotomica (v: vector; ini,fin: indice; dato:integer; var pos: indice);
Nota: El parámetro “pos” debe retornar la posición del dato o -1 si el dato no se encuentra
en el vector.
Desafío…
}
program ej3;
const df= 20;
type
	indice= 1..df;
	rang = 300..1550;
	vector = array [indice] of rang;
	
	procedure cargarV (var v: vector);
  
		procedure cargarVrecu(var v: vector; dl: integer);
		begin
			if (dl <= df) then begin
				v[dl] := 300 + random(1550 - 300 + 1);  // Asigna el valor antes de la recursión
				cargarVrecu(v, dl + 1);  				// Llamado recursivo para la siguiente posición
			end;
		end;

	begin
		cargarVrecu(v, 1);  			// Comienza desde la primera posición
	end;

	
	procedure ordenar (v: vector);  // metodo de insercion 
	var
		i,j, actual: integer;  		// si pongo tipo de dato subrango indice salta error en linea ..if(j>0)
	begin
		for i:=2 to df do begin
			actual:= v[i];
			j:= i-1;
			if (j>0) and (v[j] < actual) then begin
				v[j+1] := v[j];
				j:= j-1;
			end;
			v[j+1] := actual;
		end;
	end;
	
	procedure busquedaDicotomica (v: vector; ini, fin: indice; dato: integer; var pos: integer); 	//recursivo
	var medio: indice;
	begin
		medio:= (ini + fin) div 2;   // es lo mismo ponerlo antes o después del if?
		if (ini <= fin) then begin
			if (v[medio] = dato) then  // caso base
				pos:= medio
			else begin
				if (v[medio] > dato) then
					BusquedaDicotomica (v, ini, medio-1, dato, pos)  // busca en mitad inferior
				else
					BusquedaDicotomica (v, ini, medio+1, dato, pos); // busca en mitad superior
			end;
		end;
		// otra opcion: else pos = -1 (si no inicializo pos en pp)
	end;
	
var 
	v:vector;
	ini, fin: indice;
	dato, pos: integer;
BEGIN
	randomize;
	ini:= 1;
	fin:= df;
	pos:= -1;
	cargarV (v);
	ordenar (v);
	writeln ('Ingresar dato a buscar (número entre 300 y 1550): '); read (dato);
	busquedaDicotomica (v, ini, fin, dato, pos);
	if (pos = -1) then writeln ('No se encontró numero')
	else
		writeln ('El numero se encontró en la posición: ', pos);
	
END.
