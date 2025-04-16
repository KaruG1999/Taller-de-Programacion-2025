{

}

program ej1;
type
	socio = record 
		numS: integer;
		nombre: string;
		edad: integer;
	end;

	arbol = ^nodo;
	nodo = record
		dato: socio;
		HI: arbol;
		HD: arbol;
	end;
	
	procedure cargarA (var a:arbol);  // carga socios en estructura de datos arbol
	
		procedure leerSocio (var s:socio);
		var n:string;
		begin
			s.numS:= random (10);
			readln (n); 
			s.nombre := (n);
			s.edad := random (100);
		end;
		
		procedure agregar (var a:arbol; s:socio);
		begin
			if (a = nil) then begin
				new (a);
				a^.dato:= s;
				a^.HI:= nil;
				a^.HD:= nil;
			end
			else begin	
				if (s.numS <= a^.dato.numS) then agregar (a^.HI, s) // ordenado segun numero de socio
				else
					agregar (a^.HD, s);
			end;
		end;
		
	var s:socio;
	begin
		leerSocio (s);
		while (s.numS <> 0) do begin   // corta cuando lee numero de socio = 0
			agregar (a, s);
			leerSocio(s);
		end;
	end;
	
	procedure InformaCrec (a:arbol);   // informa socios de manera  creciente segun su numero socio
	begin
		if (a <> nil) then begin
			InformaCrec (a^.HI);
			writeln ('Numero de socio: ', a^.dato.numS);
			writeln ('Nombre de socio: ', a^.dato.nombre);
			writeln ('Edad de socio: ', a^.dato.edad);
			InformaCrec (a^.HD);
		end;
	end;
	
	procedure InformarDecre (a:arbol);  //informa de manera decreciente 
	begin
		if (a <> nil) then begin
			InformarDecre (a^.HD);
			writeln ('Numero de socio: ', a^.dato.numS);
			writeln ('Nombre de socio: ', a^.dato.nombre);
			writeln ('Edad de socio: ', a^.dato.edad);
			InformarDecre (a^.HI);
		end;
	end;
	
	procedure SocioMax (a:arbol; var Emax, Smax: integer);   // socio con mayor edad
	begin
		if (a <> nil) then begin
			if (a^.dato.edad > Emax) then begin
				Emax:= a^.dato.edad;
				Smax:= a^.dato.numS;
			end;
			SocioMax (a^.HI, Emax, Smax);
			SocioMax (a^.HD, Emax, Smax); 
		end;
	end;
	
	procedure Aumenta (a: arbol);  // aumenta los socios con edad impar en 1
	begin
		if (a <> nil) then begin
			Aumenta (a^.HI);
			
			if (a^.dato.edad MOD 2 = 1) then 
				a^.dato.edad := a^.dato.edad + 1;
				
			Aumenta (a^.HD);
		end;
	end;
	
	function existe (a: arbol; nomb: string): boolean; //devuelve true o false si existe el nombre indicado
	begin
		if ( a = nil) then 
			existe := false
		else begin
			if (a^.dato.nombre = nomb) then
				existe := true
			else 
				existe:= existe(a^.HI, nomb) or existe (a^.HD, nomb);
		end;
	end;
	
	function cantSocios (a: arbol): integer;  // cuenta el total de socios en el arbol
	begin
		if (a = nil) then cantSocios:=0
		else 
			cantSocios:= 1 + cantSocios (a^.HI) + cantSocios (a^.HD);
	end;
	
	procedure promedio (a:arbol);    // promedio de la edad de socios
	
		function sumaSocios (a: arbol):integer;  // suma total de edades de socios  
		begin
			if (a = nil) then sumaSocios:=0
			else
				sumaSocios:= a^.dato.edad + sumaSocios (a^.HI) + sumaSocios(a^.HD);
		end;
	
	begin
		if (cantSocios(a) = 0) then writeln ('No hay socios')
		else
			write ('Promedio de edad en Socios: ',  sumaSocios(a) /cantSocios(a):0:2);
	end;
	
var 
	a:arbol;
	nomb:string;
	Emax, Smax: integer;
BEGIN
	Emax:=-1;
	Smax:=-1;
	a:=nil;
	randomize;
	cargarA(a);
	InformaCrec (a);
	InformarDecre (a);
	SocioMax (a, Emax, Smax);
	Aumenta (a);
	
	writeln ('Ingresar nombre socio: '); readln (nomb);
	if (existe(a, nomb)) then writeln ('Socio encontrado')
	else writeln ('Socio NO encontrado');
	
	writeln ('Cantidad total de socios: ',cantSocios (a));
	
	promedio(a);
END.

