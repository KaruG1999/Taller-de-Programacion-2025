{
 ACTIVIDAD 4: Crear un archivo ProgramaListasOrdenadas.pas
a) Implemente un módulo CargarListaOrdenada que cree una lista de
enteros y le agregue valores aleatorios entre el 100 y 150, hasta que se
genere el 120. Los valores dentro de la lista deben quedar ordenados
de menor a mayor.
b) Reutilice el módulo ImprimirLista que reciba una lista generada en a) e
imprima todos los valores de la lista en el mismo orden que están
almacenados.
c) Implemente un módulo BuscarElementoOrdenado que reciba la lista
generada en a) y un valor entero y retorne true si el valor se encuentra
en la lista y false en caso contrario.
d) Invocar desde el programa principal a los módulos implementados
para crear una lista ordenada, mostrar todos sus elementos y
determinar si un valor leído por teclado se encuentra o no en la lista.
   
   
}
program Act4;

type 
	lista = ^nodo;
	nodo = record 
		dato: integer;
		sig: lista;
	end;
	
	procedure Insertar (var l: lista; num: integer);
	var
		ant, act, nue: lista;
	begin
		new (nue);
		nue^.dato:= num;
		nue^.sig:= nil;
		
		ant:= nil;
		act:= l;
		
		while (act <> nil) and (num > act^.dato) do begin
			ant:= act;
			act:= act^.sig;
		end;

		if (ant = nil) then begin
			nue^.sig:= l;
			l:= nue;
		end
		else begin 
			ant^.sig:= nue;
			nue^.sig:= act;
		end;
			
	end;
	
	procedure cargarListaOrd (var l: lista);
	var
		ale: integer;
	begin
		randomize;
		ale:= 100 + random (150-100+1);
		while (ale <> 120) do begin
			Insertar (l, ale);
			ale:= 100 + random (150-100+1);
		end;
	end;
	
	procedure imprimirL (l: lista);
	begin
		while (l <> nil) do begin
			writeln ('Valor:', l^.dato);
			l:= l^.sig;
		end;
	end;

	function buscarElemOrd (l: lista; num: integer): boolean;
	begin
		while (l <> nil) and (num > l^.dato) do 
			l:= l^.sig;
		buscarElemOrd:= (l <> nil) and (l^.dato = num);
	end;
	

var 
	l: lista;
	num: integer;
BEGIN
	l:= nil;
	cargarListaOrd (l); 
	imprimirL (l);
	writeln ('Ingresar un numero entre 100 y 150:');
	readln (num);
	if (buscarElemOrd(l,num)) then
		writeln ('Existe')
	else 
		writeln ('No existe');
END.

