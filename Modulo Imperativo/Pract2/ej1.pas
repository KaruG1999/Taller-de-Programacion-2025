{1.- Implementar un programa que invoque a los siguientes m�dulos.
a. Un modulo recursivo que retorne un vector de a lo sumo 15 n�meros enteros �random� mayores a 10 y menores a 155 (incluidos ambos). La carga finaliza con 
el valor  20.
b. Un modulo no recursivo que reciba el vector generado en a) e imprima el contenido del vector.
c. Un modulo recursivo que reciba el vector generado en a) e imprima el contenido del vector.
d. Un modulo recursivo que reciba el vector generado en a) y devuelva la suma de los valores pares contenidos en el vector.
e. Un modulo recursivo que reciba el vector generado en a) y devuelva el m�ximo valor del vector.
f. Un modulo recursivo que reciba el vector generado en a) y un valor y devuelva verdadero si dicho valor se encuentra en el vector o falso en caso contrario.
g. Un modulo que reciba el vector generado en a) e imprima, para cada n�mero contenido en el vector, sus d�gitos en el orden en que aparecen en el n�mero. 
Debe implementarse un m�dulo recursivo que reciba el n�mero e imprima lo pedido. Ejemplo si se lee el valor 142, se debe imprimir 1  4  2
}

Program Clase2MI;
const dimF = 15;
      min = 10;
      max = 155;
      
type vector = array [1..dimF] of integer;  		//	vector de 15 enteros
     

procedure CargarVector (var v: vector; var dimL: integer);

  procedure CargarVectorRecursivo (var v: vector; var dimL: integer);
  var valor: integer;
  begin
    valor:= min + random (max - min + 1);
    if ((valor <> 20 ) and (dimL < dimF)) then begin    // caso base implicito: valor = 20 y cuando diml = dimf 
          dimL:= dimL + 1;
          v[dimL]:= valor;
          CargarVectorRecursivo (v, dimL);
         end;
  end;
  
begin
  dimL:= 0;
  CargarVectorRecursivo (v, dimL);
end;
 
procedure ImprimirVector (v: vector; dimL: integer);    // imprimir no recursivo
var
   i: integer;
begin
     for i:= 1 to dimL do
         write ('----');
     writeln;
     write (' ');
     for i:= 1 to dimL do begin
        write(v[i], ' | ');
     end;
     writeln;
     for i:= 1 to dimL do
         write ('----');
     writeln;
     writeln;
End;     

procedure ImprimirVectorRecursivo (v: vector; dimL: integer);  // imprime en el orden que se encuentran almacenado en el vector 
begin   
	if ( dimL > 0) then	begin			// caso base: si la dim lógica es mayor/igual que 0
	    ImprimirVectorRecursivo (v, dimL-1);    //llamada recursiva disminuyendo la dimL, va haciendo la recursion del ultimo elemento al primero 
		writeln(v[dimL], ' | ');				// imprime el entero en la dimL actual (indice)
	end;
end; 
    
function Sumar (v: vector; dimL: integer): integer;  
begin
 if (dimL = 0) then Sumar:= 0				//caso en que el vector esta vacio
 else
     if (( v[dimL] mod 2 ) = 0) then        // caso en el que el ultimo num es par
         Sumar:= v[dimL] + Sumar (v, dimL-1) 
     else
         Sumar:= Sumar (v, dimL-1);  		// caso en el que el ultimo es impar
end;

function  ObtenerMaximo (v: vector; dimL: integer): integer;
var
	max: integer;
begin
	if (dimL = 1) then ObtenerMaximo:= v[1]  // caso base: el unico elemento es el max 
	else begin
		max:= ObtenerMaximo (v, dimL-1);  	// llamada recursiva (evalua de principio a fin, "comienza con el caso base")
		if (v[dimL] > max) then
			ObtenerMaximo := v[dimL] 		// actualizo max
	    else 
			ObtenerMaximo := max;			// almacena el max "almacenado" 
	end;
end;     
     
function  BuscarValor (v: vector; dimL, valor: integer): boolean;
begin
	if (dimL = 0) then BuscarValor:= false  		//caso base: si el vector esta vacio
	else begin
		if (v[dimL] = valor ) then 					// si encuentro valor
			BuscarValor:= true
		else 
			BuscarValor:= BuscarValor(v, dimL-1, valor);  // si no encuentra el valor, llamada recursiva (sigue buscando)
	end;
end;  

procedure ImprimirDigitos (v:vector ;dimL: integer);

	procedure imprimir (num: integer);
	begin
		if ( num < 10 ) then write (num,'  ') // caso base donde el num tiene un solo digito
		else begin
			imprimir (num DIV 10); 		// llamado recurs con resto num  
			write (num MOD 10,'  ');	// imprime digito
		end;
	end;

begin
	if (dimL > 0) then begin
		ImprimirDigitos (v, dimL-1);          // llamada recursiva: va al primer elemento del vector
		imprimir (v[dimL]);
	end;
end;


var dimL, suma, maximo, valor: integer; 
    v: vector;
    encontre: boolean;
Begin 
  randomize;
  CargarVector (v, dimL);
  writeln;
  if (dimL = 0) then writeln ('--- Vector sin elementos ---')
                else begin
                       writeln ('--- Imprimir Vector Iterativo ---');
                       ImprimirVector (v, dimL);
                       
                       writeln ('--- Imprimir Vector Recursivo ---');                       
                       ImprimirVectorRecursivo (v, dimL);
                     end;
  writeln;
  writeln;                   
  suma:= Sumar(v, dimL);
  writeln;
  writeln;
  writeln('La suma de los valores del vector es ', suma); 
  writeln;
  writeln;
  maximo:= ObtenerMaximo(v, dimL);
  writeln;
  writeln;
  writeln('El maximo del vector es ', maximo); 
  writeln;
  writeln;
  write ('Ingrese un valor a buscar: ');
  read (valor);
  encontre:= BuscarValor(v, dimL, valor);
  writeln;
  writeln;
  if (encontre) then writeln('El ', valor, ' esta en el vector')
                else writeln('El ', valor, ' no esta en el vector');
                
  writeln;
  writeln;
  ImprimirDigitos (v, dimL);
end.
{Importante: antes de llamar a la recursion siempre tengo que almacenar el valor porque lo puedo perder}
