{
3. Un supermercado requiere el procesamiento de sus productos. De cada producto se
conoce código, rubro (1..10), stock y precio unitario. Se pide:

a) Generar una estructura adecuada que permita agrupar los productos por rubro. A su
vez, para cada rubro, se requiere que la búsqueda de un producto por código sea lo
más eficiente posible. El ingreso finaliza con el código de producto igual a 0.
b) Implementar un módulo que reciba la estructura generada en a), un rubro y un código
de producto y retorne si dicho código existe o no para ese rubro.     // retornar 
c) Implementar un módulo que reciba la estructura generada en a), y retorne, para cada
rubro, el código y stock del producto con mayor código.
d) Implementar un módulo que reciba la estructura generada en a), dos códigos y
retorne, para cada rubro, la cantidad de productos con códigos entre los dos valores
ingresados.
}

program ej3;
const df= 10;
type
	rangRub = 1..df;
	
	producto = record 		// se lee
		cod: integer;
		rubro: rangRub;
		stock: integer;
		precioU: real;
	end;

	prod = record
		cod: integer;
		stock: integer;
		precioU: real;
	end;

	arbol = ^nodo;
	nodo = record 
		dato: prod;
		HI: arbol;
		HD: arbol;
	end;
	
	vectorArb = array [rangRub] of arbol;  // vector que para cada rubro tiene un arbol ordenado por cod de producto


	procedure inicializ (var v:vectorArb);
	var i:rangRub;
	begin
		for i:=1 to df do 
			v[i]:= nil;
	end;

	procedure cargarV (var v: vectorArb);  
	
		procedure leerProd (var p: producto);
		begin
			p.cod := random (50);
			if (p.cod <> 0) then begin
				p.rubro := random (10) + 1;
				p.stock := random (1000);
				p.precioU := random (5000) + 100;
			end;
		end;
	
		procedure insertar (var a: arbol; p:producto);		// ordenado por cod de producto
		begin
			if (a = nil) then begin
				new (a);
				a^.dato.cod := p.cod;
				a^.dato.stock:= p.stock;
				a^.dato.precioU:= p.precioU;
				a^.HI := nil;
				a^.HD := nil;
			end
			else begin
				if ( a^.dato.cod >=  p.cod ) then
					insertar (a^.HI , p)
				else
					insertar (a^.HD, p);
			end;
		end;
	
	var p: producto;
	begin
		leerProd (p);
		while (p.cod <> 0) do begin
			insertar (v[p.rubro], p);
			leerProd (p);
		end;
	end;
			
	function buscar (a: arbol ; codp: integer): boolean;
	begin
		if (a = nil) then buscar:= false
		else begin
			if (a^.dato.cod = codp) then 
				buscar := true
			else
				if (a^.dato.cod < codp) then buscar := buscar (a^.HD, codp)
				else
					buscar:= buscar (a^.HI, codp);
		end;
	end;

	procedure InformarMaxCod (v: vectorArb);   //para cada rubro informa el stock y cod del codigo max 
	
		procedure maximo (a: arbol; var codMax: integer; var stock: integer; var existe: boolean);
		begin
			if (a = nil) then existe:= false   // o puede retornar maximo = -1 (sin usar boolean)
			else begin
				if (a^.HD = nil) then begin
					codMax:= a^.dato.cod;
					stock:= a^.dato.stock;
					existe:= true;
				end
				else
					maximo (a^.HD, codMax, stock, existe);
			end;
		end;
	
	var i:rangRub;
		cod, stock: integer;
		existe : boolean;
	begin
		stock := 0;
		for i:=1 to df do begin
			maximo (v[i], cod, stock, existe);
			if (existe) then writeln ('Rubro: ', i ,'codigo mas grande: ', cod , ' stock correspondiente: ', stock)
			else
				writeln ('Rubro: ', i , ' vacio ');
		end;
	end;

	procedure entreValores (v: vectorArb);
	
		function cantProd (a: arbol; c1: integer; c2: integer): integer;
		begin
			if (a=nil) then cantProd := 0
			else begin
				if (a^.dato.cod > c1) and (a^.dato.cod < c2) then
					cantProd := 1 + cantProd (a^.HI,c1,c2) + cantProd (a^.HD, c1,c2)
				else
					if (a^.dato.cod <= c1) then cantProd := cantProd (a^.HD, c1,c2)
					else
						cantProd := cantProd (a^.HI, c1,c2);
			end;
		end;
	
	var 
		cod1, cod2: integer;
		i: rangRub;
	begin
		writeln ('Ingrese codigo 1: '); readln (cod1);
		writeln ('Ingrese codigo 2 (mayor que el cod 1): '); readln (cod2);
		for i:= 1 to df do 
			writeln ('El rubro: ', i , 'vendio un total de: ', cantProd(v[i], cod1, cod2) , 'productos' );
	end;


var 
	v: vectorArb;
	rubr: rangRub;
	codP : integer;
BEGIN
	randomize;
	inicializ(v);
	cargarV (v);
	
	writeln ('Ingrese un rubro (1..10): '); readln (rubr);
	writeln ('Ingrese un codigo de producto a buscar en ese rubro: '); readln (codP);
	if (buscar(v[rubr], codP)) then
		writeln ('Se encontró codigo en el rubro ingresado')
	else 
		writeln ('NO se encontro codigo den el rubro ingresado');
		
	InformarMaxCod (v);
	
	entreValores (v);
END.

