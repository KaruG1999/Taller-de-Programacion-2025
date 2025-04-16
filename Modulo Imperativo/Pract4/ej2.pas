{Escribir un programa que:
a. Implementar un modulo que almacene informacion de socios de un club en un arbol binario de busqueda. De cada socio se debe almacenar numero de socio, 
nombre y edad. La carga finaliza con el numero de socio 0 y el arbol debe quedar ordenado por numero de socio. La informacion de cada socio debe generarse
aleatoriamente.
b. Una vez generado el arbol, realice modulos independientes que reciban el arbol como parametro para: 
    i. Informar los datos de los socios en orden creciente    por número de socio.
    ii. Informar los datos de los socios en orden decreciente por número de socio.
    iii. Informar el número de socio con mayor edad. Debe invocar a un módulo recursivo que retorne dicho valor.
    iv. Aumentar en 1 la edad de los socios con edad impar e informar la cantidad de socios que se les aumento la edad.
    vi. Leer un nombre e informar si existe o no existe un socio con ese nombre. Debe invocar a un módulo recursivo que reciba el nombre leído y retorne verdadero o falso.
    vii. Informar la cantidad de socios. Debe invocar a un módulo recursivo que retorne dicha cantidad.
    viii. Informar el promedio de edad de los socios. Debe invocar al módulo recursivo del inciso vii e invocar a un módulo recursivo que retorne la suma de las edades de los socios.
2) 
i. Informar el número de socio más grande. Debe invocar a un módulo recursivo que
retorne dicho valor.
ii. Informar los datos del socio con el número de socio más chico. Debe invocar a un
módulo recursivo que retorne dicho socio.
iii. Leer un valor entero e informar si existe o no existe un socio con ese valor. Debe
invocar a un módulo recursivo que reciba el valor leído y retornar verdadero o falso.
iv. Leer e informar la cantidad de socios cuyos códigos se encuentran comprendidos
entre los valores leídos. Debe invocar a un módulo recursivo que reciba los valores
leídos y retorne la cantidad solicitada.
}

Program ej2;

type rangoEdad = 12..100;
     cadena15 = string [15];
     socio = record
               numero: integer;
               nombre: cadena15;
               edad: rangoEdad;
             end;
     arbol = ^nodoArbol;
     nodoArbol = record
                    dato: socio;
                    HI: arbol;
                    HD: arbol;
                 end;
     
procedure GenerarArbol (var a: arbol);
{ Implementar un modulo que almacene informacion de socios de un club en un arbol binario de busqueda. De cada socio se debe almacenar numero de socio, 
nombre y edad. La carga finaliza con el numero de socio 0 y el arbol debe quedar ordenado por numero de socio. La informacion de cada socio debe generarse
aleatoriamente. }

  Procedure CargarSocio (var s: socio);
  var vNombres:array [0..9] of string= ('Ana', 'Jose', 'Luis', 'Ema', 'Ariel', 'Pedro', 'Lena', 'Lisa', 'Martin', 'Lola'); 
  
  begin
    s.numero:= random (51) * 100;
    If (s.numero <> 0)
    then begin
           s.nombre:= vNombres[random(10)];     // otra forma de cargar nombres
           s.edad:= 12 + random (79);
         end;
  end;  
  
  Procedure InsertarElemento (var a: arbol; elem: socio);
  Begin
    if (a = nil) 
    then begin
           new(a);
           a^.dato:= elem; 
           a^.HI:= nil; 
           a^.HD:= nil;
         end
    else if (elem.numero < a^.dato.numero) 
         then InsertarElemento(a^.HI, elem)
         else InsertarElemento(a^.HD, elem); 
  End;

var unSocio: socio;  
Begin
 writeln;
 writeln ('----- Ingreso de socios y armado del arbol ----->');
 writeln;
 a:= nil;
 CargarSocio (unSocio);
 while (unSocio.numero <> 0)do
  begin
   writeln ('Numero generado: ', unSocio.numero);
   InsertarElemento (a, unSocio);
   CargarSocio (unSocio);
  end;
 writeln;
 writeln ('//////////////////////////////////////////////////////////');
 writeln;
end;

procedure InformarSociosOrdenCreciente (a: arbol);
{ Informar los datos de los socios en orden creciente. }
  
  procedure InformarDatosSociosOrdenCreciente (a: arbol);
  begin
    if (a <> nil) then begin
        InformarDatosSociosOrdenCreciente (a^.HI);
        writeln ('Numero: ', a^.dato.numero, ' Nombre: ', a^.dato.nombre, ' Edad: ', a^.dato.edad);
        InformarDatosSociosOrdenCreciente (a^.HD);
    end;
  end;

Begin
 writeln;
 writeln ('----- Socios en orden creciente por numero de socio ----->');
 writeln;
 InformarDatosSociosOrdenCreciente (a);
 writeln;
 writeln ('//////////////////////////////////////////////////////////');
 writeln;
end;

procedure InformarSociosOrdenDecreciente (a: arbol);
{ Informar los datos de los socios en orden decreciente. }
  
  procedure InformarDatosSociosOrdenDecreciente (a: arbol);
  begin
    if (a <> nil) then begin
        InformarDatosSociosOrdenDecreciente (a^.HD);
        writeln ('Numero: ', a^.dato.numero, ' Nombre: ', a^.dato.nombre, ' Edad: ', a^.dato.edad);
        InformarDatosSociosOrdenDecreciente (a^.HI);
    end;
  end;

Begin
 writeln;
 writeln ('----- Socios en orden decreciente por numero de socio ----->');
 writeln;
 InformarDatosSociosOrdenDecreciente (a);
 writeln;
 writeln ('//////////////////////////////////////////////////////////');
 writeln;
end;


procedure InformarNumeroSocioConMasEdad (a: arbol);
{ Informar el numero de socio con mayor edad. Debe invocar a un modulo recursivo que retorne dicho valor.  }

     procedure actualizarMaximo(var maxValor,maxElem : integer; nuevoValor, nuevoElem : integer);
	begin
	  if (nuevoValor >= maxValor) then
	  begin
		maxValor := nuevoValor;
		maxElem := nuevoElem;
	  end;
	end;
	procedure NumeroMasEdad (a: arbol; var maxEdad: integer; var maxNum: integer);  // var por ref porque las lllamadas rcursivas deben ver los datos actualizados en mem 
	begin
	   if (a <> nil) then
	   begin
		  actualizarMaximo(maxEdad,maxNum,a^.dato.edad,a^.dato.numero);
		  numeroMasEdad(a^.hi, maxEdad,maxNum);
		  numeroMasEdad(a^.hd, maxEdad,maxNum);
	   end; 
	end;

var maxEdad, maxNum: integer;
begin
  writeln;
  writeln ('----- Informar Numero Socio Con Mas Edad ----->');
  writeln;
  maxEdad := -1;
  NumeroMasEdad (a, maxEdad, maxNum);
  if (maxEdad = -1) 
  then writeln ('Arbol sin elementos')
  else begin
         writeln;
         writeln ('Numero de socio con mas edad: ', maxNum);
         writeln;
       end;
  writeln;
  writeln ('//////////////////////////////////////////////////////////');
  writeln;
end;

procedure AumentarEdadNumeroImpar (a: arbol);
{Aumentar en 1 la edad de los socios con edad impar e informar la cantidad de socios que se les aumento la edad.}
  
  function AumentarEdad (a: arbol): integer;
  var resto: integer;
  begin
     if (a = nil) then AumentarEdad:= 0
     else begin
            resto:= a^.dato.edad mod 2;
            if (resto = 1) then a^.dato.edad:= a^.dato.edad + 1;
            AumentarEdad:= resto + AumentarEdad (a^.HI) + AumentarEdad (a^.HD); // si es impar resto igual a 1 se suma 
            {equivalente a if AumentarEdad:= 1 + AumentarEdad (a^.HI) + AumentarEdad (a^.HD) else AumentarEdad:= AumentarEdad (a^.HI) + AumentarEdad (a^.HD)}
          end;  
  end;

begin
  writeln;
  writeln ('----- Cantidad de socios con edad aumentada ----->');
  writeln;
  writeln ('Cantidad: ', AumentarEdad (a));
  writeln;
  writeln;
  writeln ('//////////////////////////////////////////////////////////');
  writeln;
end;

procedure InformarExistenciaNombreSocio (a:arbol);

	function existe (a: arbol; nomb: string): boolean; //devuelve true o false si existe el nombre indicado
	begin
		if ( a = nil) then 
			existe := false
		else begin
			if (a^.dato.nombre = nomb) then    			// si encuentra el dato debe terminar
				existe := true
			else 
				existe:= existe(a^.HI, nomb) or existe (a^.HD, nomb);
		end;
	end;
	
var
	nomb:string;
begin
	writeln ('Ingresar nombre socio: '); 
	readln (nomb);
	if (existe(a, nomb)) then writeln ('Socio encontrado')
	else writeln ('Socio NO encontrado');

end;

function cantSocios (a: arbol): integer;  // cuenta el total de socios en el arbol
begin
	if (a = nil) then cantSocios:=0
	else 
		cantSocios:= 1 + cantSocios (a^.HI) + cantSocios (a^.HD);  // en todo caso que encuentre un nodo suma un socio 
end;

procedure InformarCantidadSocios (a:arbol);
begin
	writeln ('Cantidad total de socios: ', cantSocios (a));
end;

procedure InformarPromedioDeEdad (a:arbol);

	function sumaSocios (a: arbol):integer;  // suma total de edades de socios  
		begin
			if (a = nil) then sumaSocios:=0
			else
				sumaSocios:= a^.dato.edad + sumaSocios (a^.HI) + sumaSocios(a^.HD);
		end;
	
begin
	if (cantSocios(a) = 0) then writeln ('No hay socios')
	else
		writeln ('Promedio de edad en Socios: ',  sumaSocios(a) /cantSocios(a):0:2);
end;

procedure InformarSocioMax (a: arbol);     // Numero de socio mas grande  

	function Maximo (a:arbol): integer;
	begin
		if ( a = nil) then Maximo := -999
		else begin
			if (a^.HD = nil) then Maximo := a^.dato.numero 
			else
				Maximo := Maximo (a^.HD);
		end;
	end;

begin
	Writeln ('Numero de socio más grande: ', Maximo (a));   
end;

procedure InformarSocioMin (a: arbol);

	function Minimo (a: arbol): integer;
	begin
		if (a = nil) then Minimo := 999
		else begin
			if (a^.HI = nil) then Minimo := a^.dato.numero
			else
				Minimo := Minimo (a^.HI);
		end;
	end;

begin
	Writeln ('Numero de socio más chico: ', Minimo (a));
end;

procedure InfomarExiste (a: arbol);

	function Existe (a: arbol; num:integer):boolean;
	begin
		if (a = nil) then Existe:= false
		else begin
			if (a^.dato.numero = num) then Existe := true
			else
				if (num < a^.dato.numero) then Existe:= Existe (a^.HI, num)
				else
					Existe := Existe (a^.HD, num)
		end;
	end;

var num:integer;
begin
	writeln ('Ingrese numero de socio: ');
	read (num);
	if (Existe (a, num)) then writeln ('Numero de socio encontrado')
	else
		writeln ('Numero de socio NO encontrado');
end;

procedure InformarCantSocios (a: arbol); // lee 2 codigos de socios y retorna cantidad de socios entre los ingresados de manera recursiva

	function contarSoc (a:arbol; num1, num2: integer): integer;
	begin
		if (a = nil) then contarSoc :=0
		else begin
			if (a^.dato.numero >= num1) and (a^.dato.numero <= num2) then
				contarSoc := 1 + contarSoc (a^.HI, num1, num2) + contarSoc (a^.HD, num1, num2)
			else 
				if (a^.dato.numero < num1) then contarSoc := contarSoc (a^.HD, num1, num2) 		// solo derecha, los valores a la izq de num 1 son menores 
				else // if (a^.dato.numero > num2) then
					contarSoc := contarSoc (a^.HI, num1,num2);
		end;
	end;
	
var num1, num2: integer;
begin
	Writeln ('Ingrese codigo 1: '); readln (num1);
	Writeln ('Ingrese codigo 2 (mayor a num1): '); readln (num2);
	writeln ('Cantidad de socios que sus codigo estan entre los valores ingresados: ', contarSoc (a, num1, num2));
end;


var a: arbol; 
Begin
  randomize;
  GenerarArbol (a);
  InformarSociosOrdenCreciente (a);
  InformarSociosOrdenDecreciente (a);
  InformarNumeroSocioConMasEdad (a);
  AumentarEdadNumeroImpar (a);
  InformarSociosOrdenCreciente (a);
  InformarExistenciaNombreSocio (a);
  InformarCantidadSocios (a);
  InformarPromedioDeEdad (a); 
  InformarSocioMax (a);
  InformarSocioMin (a);
  InfomarExiste (a);
  InformarCantSocios (a);
End.
