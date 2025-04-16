{
4.- Realizar un programa que lea números y que utilice un módulo recursivo que escriba el
	equivalente en binario de un número decimal. El programa termina cuando el usuario ingresa
	el número 0 (cero).
Ayuda: Analizando las posibilidades encontramos que: Binario (N) es N si el valor es menor a 2.
¿Cómo obtenemos los dígitos que componen al número? ¿Cómo achicamos el número para la
próxima llamada recursiva? Ejemplo: si se ingresa 23, el programa debe mostrar: 10111.
}

program ej4;

	procedure binario (num : integer);
	begin
		if (num <> 0) then begin
			binario (num DIV 2);		 		
			write (num MOD 2 ,' ');   
		end;
	end;

var
	num:integer;
BEGIN
	writeln ('Ingresar Numero: ');
	readln (num);
	while (num <> 0) do begin
		binario (num);
		writeln;
		readln(num);
	end;
end.

{
* 
* binario (23 div 2) = 11 MOD 2 = 1 (resto)
* binario (11 div 2) = 5 MOD 2 = 1 (resto)
* binario (5 div 2)  = 2 MOD 2 = 1 (resto)
* binario (2 div 2)  = 1 MOD 2 = 0 (resto)
* binario (1 div 2)  = 0 MOD 2 = 1 (resto)
* 
* muestra resultado (restos) del ultimo resultado al primero, 23 = 10111
* }
