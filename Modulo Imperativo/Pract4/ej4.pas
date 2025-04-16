{
  Una biblioteca nos ha encargado procesar la información de los préstamos realizados
durante el año 2021. De cada préstamo se conoce el ISBN del libro, el número de socio, día
y mes del préstamo y cantidad de días prestados. Implementar un programa con:
a. Un módulo que lea préstamos y retorne 2 estructuras de datos con la información de
los préstamos. La lectura de los préstamos finaliza con ISBN 0. Las estructuras deben
ser eficientes para buscar por ISBN.
i. En una estructura cada préstamo debe estar en un nodo. Los ISBN repetidos
insertarlos a la derecha.
ii. En otra estructura, cada nodo debe contener todos los préstamos realizados al ISBN.
(prestar atención sobre los datos que se almacenan).
b. Un módulo recursivo que reciba la estructura generada en i. y retorne el ISBN más
grande.
c. Un módulo recursivo que reciba la estructura generada en ii. y retorne el ISBN más
pequeño.
d. Un módulo recursivo que reciba la estructura generada en i. y un número de socio. El
módulo debe retornar la cantidad de préstamos realizados a dicho socio.
e. Un módulo recursivo que reciba la estructura generada en ii. y un número de socio. El
módulo debe retornar la cantidad de préstamos realizados a dicho socio.
f. Un módulo que reciba la estructura generada en i. y retorne una nueva estructura
ordenada ISBN, donde cada ISBN aparezca una vez junto a la cantidad total de veces
que se prestó.
g. Un módulo que reciba la estructura generada en ii. y retorne una nueva estructura
ordenada ISBN, donde cada ISBN aparezca una vez junto a la cantidad total de veces
que se prestó.
h. Un módulo recursivo que reciba la estructura generada en g. y muestre su contenido.
i. Un módulo recursivo que reciba la estructura generada en i. y dos valores de ISBN. El
módulo debe retornar la cantidad total de préstamos realizados a los ISBN
comprendidos entre los dos valores recibidos (incluidos).
j. Un módulo recursivo que reciba la estructura generada en ii. y dos valores de ISBN. El
módulo debe retornar la cantidad total de préstamos realizados a los ISBN
comprendidos entre los dos valores recibidos (incluidos).
}

program ej4;
type 
	prestamo = record 
		ISBN: integer;
		numSoc:integer;
		dia: integer;
		mes: integer;
		cantDias: integer;
	end;
	
	arbol =^nodo;
	nodo = record 
		dato: prestamo;
		HI: arbol;
		HD: arbol;
	end;
	
	reglista = record 
		numSoc: integer;
		dia: integer;
		mes: integer;
		cantDias: integer;
	end;
	
	lista= ^nodol;
	nodol = record 
		datol : reglista;
		sig: lista;
	end;
	
	prest = record 
		ISBN: integer;
		list: lista;
	end;
	
	arbol2 = ^nodo2;
	nodo2 = record
		dato2: prest;
		HI: arbol2;
		HD: arbol2;
	end;

	arbolnue = ^nodonue;
	nodonue= record 
		ISBN: integer;
		cantTot: integer;
		HI: arbolnue;
		HD: arbolnue;
	end;

	procedure cargarA (var a1: arbol; var a2: arbol2);
	
		procedure leerP (var p:prestamo);
		begin
			p.ISBN := random (50);
			if (p.ISBN <> 0) then begin
				p.numSoc:= random (100) + 1;
				p.dia := random (30) + 1;
				p.mes := random (12) + 1;
				p.cantDias := random (90) + 1;
			end;
		end;
		
		procedure agregarA1 (var a: arbol; p:prestamo);
		begin
			if ( a = nil) then begin
				new (a);
				a^.dato:= p;
				a^.HI:= nil;
				a^.HD:= nil;
			end
			else
				if (a^.dato.ISBN <= p.ISBN) then agregarA1 (a^.HD, p)
				else
					agregarA1 (a^.HI, p);
		end;
		
		procedure agregarA2 (var a: arbol2; p:prestamo);
		
			procedure agAdel (var l:lista; p:prestamo);
			var nue:lista;
			begin
				new(nue);
				nue^.datol.numSoc := p.numSoc;
				nue^.datol.dia := p.dia;
				nue^.datol.mes := p.mes;
				nue^.datol.cantDias := p.cantDias;
				nue^.sig:= l;
				l := nue;
			end;
		
		begin
			if (a = nil) then begin
				new (a);
				a^.dato2.ISBN := p.ISBN;
				a^.dato2.list:= nil;
				agAdel (a^.dato2.list, p);
				a^.HI:= nil;
				a^.HD:= nil;
			end
			else
				if (a^.dato2.ISBN = p.ISBN) then agAdel (a^.dato2.list, p)
				else
					if (a^.dato2.ISBN < p.ISBN) then agregarA2 (a^.HD, p)
					else
						agregarA2 (a^.HI, p);
		end;
		
	var p:prestamo;
	begin
		leerP (p);
		while (p.ISBN <> 0) do begin
			agregarA1 (a1, p);
			agregarA2 (a2, p);
			leerP (p);
		end;
	end;
	
	procedure ISBNmax (a: arbol);   // retorna ISBN mas grande 
	
		function maximo (a: arbol): integer;
		begin
			if (a^.HD = nil) then maximo:= a^.dato.ISBN 
			else
				maximo := maximo (a^.HD);
		end;
	
	begin
		writeln ('ISBN mas grande de arbol 1: ', maximo (a));
	end;

	procedure ISBNmin (a: arbol2);
	
		function minimo (a: arbol2): integer;
		begin
			if (a^.HI = nil) then minimo := a^.dato2.ISBN 
			else
				minimo := minimo (a^.HI)
		end;
	
	begin
		writeln ('ISBN mas chico de arbol 2: ', minimo (a));
	end;

	procedure cantPrest (a: arbol); 		// retorna cantida de libros prestados a socio ingresado 

		function cant (a: arbol; num: integer): integer;
		begin
			if (a = nil) then cant:= 0
			else
				if (a^.dato.ISBN = num) then
					cant:= 1 + cant (a^.HI,num) + cant (a^.HD, num)
				else
					cant := cant (a^.HI,num) + cant (a^.HD,num)
		end;
		
	var num:integer;
	begin
		writeln ('Ingresar numero de socio de arbol 1: ' );
		readln (num);
		writeln ('Cantidad de prestamos realizados al socio ingresado: ', cant (a, num));
	end;

	procedure cantPrest2 (a: arbol2); 		// retorna cantida de libros prestados a socio ingresado 

		function procesarL (l:lista): integer;
		begin
			if (l = nil) then procesarL := 0
			else
				procesarL := 1 + procesarL (l^.sig);
		end;

		function cantTot (a: arbol2; num: integer): integer;
		begin
			if (a = nil) then cantTot:= 0
			else
				if (a^.dato2.ISBN = num) then
					cantTot:= procesarL (a^.dato2.list) + cantTot (a^.HI,num) + cantTot (a^.HD, num)
				else
					cantTot := cantTot (a^.HI,num) + cantTot (a^.HD,num)
		end;
		
	var num:integer;
	begin
		writeln ('Ingresar numero de socio de arbol 2: ' );
		readln (num);
		writeln ('Cantidad de prestamos realizados al socio ingresado: ', cantTot (a, num));
	end;

	procedure nuevaEst (a: arbol; var aNue: arbolnue);   // nueva estr donde cada ISBN aparece junto con la cantidad de veces que se prestó
	begin
		if (a <> nil) then begin
			nuevaEst (a^.HI, aNue);  // recorrido en orden para insertar en orden en el nuevo arbol
		
			if (aNue = nil) then begin
				new (aNue);
				aNue^.ISBN := a^.dato.ISBN;
				aNue^.cantTot := 1;  // empieza en 1 o 0?
				a^.HI:= nil;
				a^.HD:= nil;
			end
			else begin
				if (aNue^.ISBN = a^.dato.ISBN) then
					aNue^.cantTot := aNue^.cantTot + 1
				else if (a^.dato.ISBN < aNue^.ISBN) then nuevaEst (a^.HI, aNue^.HI)
				else
					nuevaEst (a^.HD, aNue^.HD);
			end;
					
			nuevaEst (a^.HD, aNue);	
		end;		
	end;
	
	function cantPrestL (l: lista): integer;
	begin
		if (l = nil) then cantPrestL := 0
		else
			cantPrestL := 1 + cantPrestL (l^.sig);
	end;
	
	
	procedure nuevaEst (a: arbol2 ; var aNue: arbolnue);
	begin
		if (a <> nil) then begin
			nuevaEst (a^.HI, aNue);
			
			if (aNue = nil) then begin
				new (aNue);
				aNue^.ISBN := a^.dato2.ISBN;
				aNue^.cantTot := cantPrestL (a^.dato2.list); 	// funcion recorre lista contando prestamos totales
				aNue^.HI:= nil;
				aNue^.HD:= nil;
			end;
			  	// recorro la estructura de manera ordenada para que nueva estructura quede en mismo orden 
			nuevaEst (a^.HD, aNue);
		end;
	end;

	procedure imprimir (anue2: arbolnue);
	begin
		if (anue2 <> nil) then begin
			imprimir (anue2^.HI);
			writeln ('ISBN de prestamo en estructura nueva 2: ', anue2^.ISBN);
			writeln ('Cantidad total de prestamos de ISBN: ', anue2^.cantTot);
			imprimir (anue2^.HD);
		end;
	end;
	
	procedure entreValores (a: arbol);
	
		function cantEntre (a: arbol; n1, n2: integer): integer;
		begin
			if (a = nil) then cantEntre := 0
			else
				if (a^.dato.ISBN >= n1) and (a^.dato.ISBN <= n2) then
					cantEntre := 1 + cantEntre (a^.HI, n1,n2) + cantEntre (a^.HD, n1,n2)
				else
					if (a^.dato.ISBN < n1) then cantEntre := cantEntre (a^.HD, n1,n2)
					else //o if (a^.dato.ISBN > n2) then 
						cantEntre := cantEntre (a^.HI, n1,n2);
		end;
	var n1, n2: integer;
	begin
		writeln ('valor de ISBN 1: '); 
		readln (n1);
		writeln ('valor de ISBN 2 (mayor que el primero): '); 
		readln (n2);
		writeln ('Cantidad de prestamos entre valores ingresados: ' ,cantEntre (a, n1, n2));
	end;
	
	procedure entreValores2 (a: arbol2);
	
		function cantEntre (a: arbol2; n1, n2: integer): integer;
		begin
			if (a = nil) then cantEntre := 0
			else
				if (a^.dato2.ISBN >= n1) and (a^.dato2.ISBN <= n2) then  // suma cant prest en la lista al total
					cantEntre := cantPrestL (a^.dato2.list) + cantEntre (a^.HI, n1,n2) + cantEntre (a^.HD, n1,n2)  // func que devuelve cant de prestmos en lista + suma izq + suma der
				else
					if (a^.dato2.ISBN < n1) then cantEntre := cantEntre (a^.HD, n1,n2)
					else   //  o if (a^.dato2.ISBN > n2)
						cantEntre := cantEntre (a^.HI, n1,n2);
		end;
	var n1, n2: integer;
	begin
		writeln ('valor de ISBN 1: '); 
		readln (n1);
		writeln ('valor de ISBN 2 (mayor que el primero): '); 
		readln (n2);
		writeln ('Cantidad de prestamos entre valores ingresados: ' ,cantEntre (a, n1, n2));
	end;

var 
	a1: arbol;
	a2: arbol2;
	anue1, anue2: arbolnue;
BEGIN
	randomize;
	a1:= nil; a2:= nil;
	anue1:= nil; anue2:= nil;
	cargarA (a1, a2);
	ISBNmax (a1);
	ISBNmin (a2);
	cantPrest (a1);
	cantPrest2 (a2);
	nuevaEst (a1, anue1);
	nuevaEst (a2, anue2);
	imprimir (anue2);
	entreValores (a1);
	entreValores2 (a2);
END.

