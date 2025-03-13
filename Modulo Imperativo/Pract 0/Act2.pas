{
ACTIVIDAD 2: Crear un nuevo archivo ProgramaVectores.pas
a) Implemente un módulo CargarVector que cree un vector de enteros
con a lo sumo 50 valores aleatorios. Los valores, generados
aleatoriamente (entre un mínimo y máximo recibidos por parámetro),
deben ser almacenados en el vector en el mismo orden que se
generaron, hasta que se genere el cero.
b) Implemente un módulo ImprimirVector que reciba el vector generago
en a) e imprima todos los valores del vector en el mismo orden que
están almacenados. Qué cambiaría para imprimir en orden inverso?
c) Escriba el cuerpo principal que invoque a los módulos ya
implementados. 
   
}
program progvectores;
const
	df=50;
type 
	Vnums=array [1..df] of integer;
	
procedure cargarvec (n,a,b :integer; var vec:Vnums ; var dl:integer);
var
	ale:integer;
begin
	dl:=0;
	randomize; 
	while (n<>dl) and (dl<df) do begin
		ale:= a + random(b-a + 1); // genero numero aleatorio entre a y b
		writeln('num generado:', ale); 
		dl:=dl+1;
	end;
	readln;	
end;
procedure Imprimir(v: Vnums; dl:integer);
var i:integer;
begin
	for i:=1 to dl do begin
		writeln('num puesto=', i,' generó=', v[i]); 
	end;
end;
{En caso de querer imprimir en orden inverso: for dl downto 1 do...}
var 
	a,b,n:integer;
	vec:Vnums;
	dl:integer;
BEGIN
	
	readln(n); 
	readln(a); 
	readln(b); //leo rango entre a y b
	cargarvec(n,a,b,vec,dl); //cargo el vector con a lo sumo 50 num aleatorios
	Imprimir (vec,dl);
END.
