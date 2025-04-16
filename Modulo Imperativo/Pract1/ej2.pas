{
2.- El administrador de un edificio de oficinas cuenta, en papel, con la información del pago de
las expensas de dichas oficinas.
Implementar un programa que invoque a módulos para cada uno de los siguientes puntos:
a. Genere un vector, sin orden, con a lo sumo las 300 oficinas que administra. De cada oficina
se ingresa el código de identificación, DNI del propietario y valor de la expensa. La lectura
finaliza cuando se ingresa el código de identificación -1, el cual no se procesa.
b. Ordene el vector, aplicando el método de inserción, por código de identificación de la
oficina.
c. Ordene el vector aplicando el método de selección, por código de identificación de la oficina.
}

program ej2;
const df = 300; 
type 
	indice= 1..df;
	oficina = record 
		id: integer;
		dni: integer;
		exp: real;
	end;
	edificio = array [indice] of oficina;

	procedure cargarV (var v: edificio; var dl:  integer);
	
		procedure leerOfi (var ofi: oficina);
		begin
			ofi.id := random (301) - 1; // genera 301 numeros empezando por el -1 ?
			writeln ('Id generado:', ofi.id);
			if (ofi.id <> -1) then begin
				ofi.dni := random (500) + 1;  // genera num del 1 al 500 
				writeln ('Dni Propietario:', ofi.dni);
				ofi.exp := random (1000) + 1; 	  // valor de exp entre 1 y 1000
				writeln ('Precio de expensas:', ofi.exp:0:2);  // muestra numero con 2 decimales 
			end;
		end;
	
	var
		ofi: oficina;
	begin
		dl:=0;
		leerOfi (ofi); 
		while ( ofi.id <> -1 ) and (dl < df) do begin
			dl:= dl +1;
			v[dl] := ofi;
			leerOfi(ofi);
		end;
	end;

	procedure insercion (var v: edificio; dl: integer);
	var
		i,j: integer;  // con indice no funciona por error en la comparacionde j > 0 
		actual: oficina;
	begin
		for i:= 2 to dl do begin  // el primer elemento lo considero ordenado 
			actual := v[i]; 	  // guardo registro en elemento actual 
			j:= i-1;			  // j realiza comparacion con el elemento anterior al actual
			while (j > 0) and (v[j].id > actual.id) do begin   // mientras j no sea 0 y el elemento anterior sea mayor al actual
				v[j+1] := v[j];  // realizo corrimiento para "pisar" al actual
				j := j-1;		  // 
			end;
			v[j+1] := actual; 
		end; 
	end;
	
	
	procedure seleccion (var v: edificio; dl: integer);
	var
		i,j,pos: indice;
		item: oficina;
	begin
		for i:=1 to dl-1 do begin		// cant de mov
			pos:=i;						// guarda pos actual
			for j:=i+1 to dl do			// desde el indice siguiente (j) recorro vector
				if v[j].id < v[pos].id then pos:=j;	// si el elemento en pos j es menor a elemento en pos actual, entonces pos pasa a ser j
			item := v[pos];				// guardo el elemento min a un aux 
			v[pos] := v[i];				// el elemento en pos i lo almacena en la pos donde estaba elem min
			v[i] := item;				// y donde estaba el elemento i, almaceno el nuevo min 
		end;
	end;

var 
	v: edificio;
	dl: integer;
BEGIN
	randomize;
	cargarV (v,dl);
	insercion (v,dl);
	seleccion (v,dl);
END.

