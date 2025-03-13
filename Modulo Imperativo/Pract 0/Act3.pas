{
ACTIVIDAD 3: Crear un archivo ProgramaListas.pas
a) Implemente un módulo CargarLista que cree una lista de enteros y le
agregue valores aleatorios entre el 100 y 150, hasta que se genere el
120.
b) Implemente un módulo ImprimirLista que reciba una lista generada en
a) e imprima todos los valores de la lista en el mismo orden que están
almacenados.
c) Implemente un módulo BuscarElemento que reciba la lista generada
en a) y un valor entero y retorne true si el valor se encuentra en la lista
y false en caso contrario.
d) Invocar desde el programa principal a los módulos implementados
para crear una lista, mostrar todos sus elementos y determinar si un
valor leído por teclado se encuentra o no en la lista.
}
program act3;
type 
	lista= ^nodo;
	nodo = record 
		dato: integer;
		sig: lista;
	end;
	
	procedure agAdel (var l: lista; num: integer );
	var
		nue: lista;
	begin
		new (nue);
		nue^.dato:= num;
		nue^.sig:= l;
		l:= nue;
	end;
	
	procedure cargarLista (var l: lista);
	var 
		ale: integer;
	begin
		Randomize;
		ale:= 100 + random (150 - 100 + 1); // ale = a + random (b-a+1
		while (ale <> 120) do begin
			ale:= 100 + random (150 - 100 + 1); 
			if (ale <> 120) then
				agAdel (l, ale);
		end;
	end;
	
	procedure imprimirL (l: lista);
	begin 
		while (l <> nil) do begin
			writeln ('Valor:', l^.dato);
			l:= l^.sig;
		end;
	end;

	function buscarElem (l: lista; num: integer): boolean;
	var
		existe: boolean;
	begin
		existe:= false;
		while (l <> nil) and (not existe) do begin
			if (num = l^.dato) then
				existe:= true
			else 
				l:= l^.sig;
		end;
		buscarElem := existe;
	end;

var
	num: integer;
	l: lista;
BEGIN
	l:= nil;
	cargarLista (l);
	imprimirL (l);
	writeln ('Ingrese un numero entre 100 y 150:');
	readln (num);
	if (buscarElem(l,num)) then 
		writeln ('Numero existente')
	else 
		writeln ('Numero no existente');
	
	
END.

