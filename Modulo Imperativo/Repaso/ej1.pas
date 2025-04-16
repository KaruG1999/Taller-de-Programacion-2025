{
El administrador de un edificio de oficinas tiene la información del pago de las expensas
de dichas oficinas. Implementar un programa con:
a) Un módulo que retorne un vector, sin orden, con a lo sumo las 300 oficinas que
administra. Se deben cargar, para cada oficina, el código de identificación, DNI del
propietario y valor de la expensa. La lectura finaliza cuando llega el código de
identificación 0.
b) Un módulo que reciba el vector retornado en a) y retorne dicho vector ordenado por
código de identificación de la oficina. Ordenar el vector aplicando uno de los métodos
vistos en la cursada.
c) Un módulo que realice una búsqueda dicotómica. Este módulo debe recibir el vector
generado en b) y un código de identificación de oficina. En el caso de encontrarlo,
debe retornar la posición del vector donde se encuentra y en caso contrario debe
retornar 0. Luego el programa debe informar el DNI del propietario o un cartel
indicando que no se encontró la oficina.
d) Un módulo recursivo que retorne el monto total de las expensas.
}

program ej1;
const df = 300;
type
	rangOfi = 1..df;
	oficina = record 
		codId: integer;
		dniProp: integer;
		precio: real;
	end;
	
	vector = array [rangOfi] of oficina; 
	
	procedure cargarV (var v: vector; var dl: integer);
		
		procedure leerOfi (var ofi: oficina);
		begin
			ofi.codId := random (50);
			if (ofi.codId <> 0) then begin
				ofi.dniProp:= random (50) * 100;
				ofi.precio := random (5000) + 1;
			end;
		end;
	
	var ofi: oficina;
	begin
		leerOfi (ofi);
		if (ofi.codId <> 0) and (dl < df) then begin
			dl:= dl + 1;
			v[dl] := ofi;
			cargarV (v, dl);  // llamado recursivo
		end;
	end;
	
	procedure ordenar (var v: vector; dl: integer);
	var
		i,j: integer;
		actual: oficina;
		
	begin
		for i:= 2 to dl do begin
			actual := v[i];
			j := i - 1;
			while (j > 0) and (v[j].codId > actual.codId) do begin 
				v [j+1] := v[j];
				j:= j-1;
			end;
			v[j+1] := actual;
		end;
	end;

	procedure busquedaDic (v: vector; ini, fin: integer; cod: integer; var pos: integer);
	var
		medio: rangOfi;
	begin
		medio:= (ini + fin) div 2;
		if (ini <= fin) then begin
			if (v[medio].codId = cod) then
				pos := medio
			else begin
				if (v[medio].codId > cod) then
					busquedaDic (v, ini, medio-1, cod, pos)
				else
					busquedaDic (v, medio+1, fin, cod, pos);
			end;
		end
		else
			pos := 0;
	end;
			
			
	function montoTot (v: vector; dl: integer): real;
	begin
		if (dl = 0 ) then montoTot :=0
		else
			montoTot:= v[dl].precio + montoTot (v, dl-1);  // llamada recursiva
	end;

var 
	v: vector;
	cod: integer;
	dl: integer;
	pos: integer;
BEGIN
	dl:=0;
	pos:= 0;
	randomize;
	cargarV (v, dl);
	ordenar (v, dl);
	
	writeln ('Ingrese codigo de Id a buscar: '); readln (cod);
	busquedaDic (v, 1, dl, cod, pos);
	if (pos <> 0) then writeln ('Dni Propietario encontrado: ', v[pos].dniProp)
	else writeln ('Valor NO encotrado en vector');
	
	writeln ('Monto total de expensas: ', montoTot (v, dl):0:2);
	
END.
{resta puntos el hacerlo recursivamente por ej si no es un arbol?}
