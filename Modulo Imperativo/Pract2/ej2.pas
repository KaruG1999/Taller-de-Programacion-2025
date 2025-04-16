{
2.- Escribir un programa que:
a. Implemente un módulo recursivo que genere y retorne una lista de números enteros
“random” en el rango 100-200. Finalizar con el número 100.
b. Un módulo recursivo que reciba la lista generada en a) e imprima los valores de la lista en el
mismo orden que están almacenados.
c. Implemente un módulo recursivo que reciba la lista generada en a) e imprima los valores de
la lista en orden inverso al que están almacenados.
d. Implemente un módulo recursivo que reciba la lista generada en a) y devuelva el mínimo
valor de la lista.
e. Implemente un módulo recursivo que reciba la lista generada en a) y un valor y devuelva
verdadero si dicho valor se encuentra en la lista o falso en caso contrario.
}

program ej2;
const sup = 200;
type
	rango = 100..sup;
	lista=^nodo;
	nodo = record 
		dato:integer;
		sig:lista;
	end;

	procedure cargarL (var l:lista);
	
		procedure AgAdel (var l: lista; n: rango);
		var
			nue :lista;
		begin
			new(nue);
			nue^.dato:= n;
			nue^.sig:= l;
			l:=nue;
		end;
	
	var num:rango;
	begin
		num:= 100 + random (200-100+1);  // genera num aleatorio entre 100 y 200
		if (num <> 100) then begin		 // caso base es cuando num = 100
			AgAdel (l,num);  			 // agrega numero a la lista   (al reves?)
			cargarL(l);		 			 // sigue iterando con la llamada recursiva
		end;
	end;

	procedure imprimirOrd (l:lista);  	// imprime en el mismo orden que es almacenado de manera recursiva	
	begin
		if (l <> nil) then begin       		// caso base: fin de la lista
			writeln ('Numero: ', l^.dato);  // primero imprime y luego pasa al siguiente num
			imprimirOrd (l^.sig);
		end;
	end;

	procedure imprimirInv (l:lista);	//imprime en orden inverso al que se almacena 
	begin
		if (l <> nil) then begin
			imprimirInv (l^.sig);			// primero llega al ultimo num, imprime y va "saliendo" e imprimiendo de atras hacia adelante
			writeln ('Numero: ', l^.dato);
		end;
	end;

	
	function calcMin (l:lista; min: integer): integer;  // el min lo inicializo por fuera del procedimiento en pp
	begin
		if (l <> nil) then begin
			if (l^.dato < min) then 			// actualizo minimo 
				min:= l^.dato;
		
			calcMin:= calcMin (l^.sig, min);   //llamada recursiva funcion
		end
		else 
			calcMin:= min;     				 // caso base: devuelve el minimo encontrado
	end;
		
	
	function Buscar (l:lista; num:rango): boolean;
	begin
		if (l <> nil) then begin
			if (l^.dato = num) then 
				Buscar := true  		// si no encuentra el dato sigue buscando
			else
				Buscar:= Buscar (l^.sig, num); 
		end
		else Buscar:= false				// si no encuentra el dato, cuando llega a nil se pone en falso
	end;
	
	
var 
	l: lista;
	num:rango;
	min:integer;
BEGIN
	l:=nil;
	randomize;
	cargarL(l);
	writeln ('Lista en el orden en que se almacena');
	imprimirOrd (l); 
	writeln ('Lista en el orden inverso en que se almacena');
	imprimirInv (l);  // se imprime en orden inverso al que se almacenan
	min:=999;
	if (calcMin(l,min) = 999) then writeln ('Lista vacia')
	else
		Writeln ('Numero más chico de la lista: ', calcMin (l,min)) ;
	writeln ('Ingresar un valor entre 100 y 200: ');
	readln (num);
	if (Buscar(l,num)) then writeln ('Numero encontrado')
	else writeln ('Numero no encontrado');
END.

