{
 .Implementar un programa que contenga:
a. Un módulo que lea información de los finales rendidos por los alumnos de la Facultad de
Informática y los almacene en una estructura de datos. La información que se lee es legajo,
código de materia, fecha y nota. La lectura de los alumnos finaliza con legajo 0. La estructura
generada debe ser eficiente para la búsqueda por número de legajo y para cada alumno deben
guardarse los finales que rindió en una lista.
b. Un módulo que reciba la estructura generada en a. y retorne la cantidad de alumnos con
legajo impar.
c. Un módulo que reciba la estructura generada en a. e informe, para cada alumno, su legajo y
su cantidad de finales aprobados (nota mayor o igual a 4).
c. Un módulo que reciba la estructura generada en a. y un valor real. Este módulo debe
retornar los legajos y promedios de los alumnos cuyo promedio supera el valor ingresado 
}

program ej3;
type
	
	finalAlu = record      // se leen finales
		legajo: integer;
		codMat: integer;
		fecha: integer;
	    nota: integer;
	end;
	
	
	lista = ^nodol;
	nodol = record 
		codMat: integer;  // puede declararse como dato (registro) dentro de la lista
		fecha: integer;
		nota: integer;
		sig: lista;
	end;
	
	alumno = record
		legajo: integer;
		list : lista;
	end;
	
	arbol = ^nodo;
	nodo = record 
		dato: alumno;
		HI: arbol;
		HD: arbol;
	end;
	
	procedure cargarA (var a: arbol);
	
		procedure leerF (var f: finalAlu);
		begin
			f.legajo:= random (100) ;
			if (f.legajo <> 0) then begin
				f.codMat := random (30)+ 1;
				f.fecha := random (30) + 1; 
				f.nota := random (10) + 1;
			end;
		end;
	
		procedure agregarA (var a: arbol; f: finalAlu);
		
			procedure agAdel (var l:lista; cod,fecha,nota: integer);
			var nue:lista;
			begin
				new (nue);
				nue^.codMat:= cod;
				nue^.fecha:= fecha;
				nue^.nota:= nota;
				nue^.sig:= l;
				l:= nue;
			end;
		
		begin
			if (a = nil) then begin
				new (a);
				a^.dato.legajo := f.legajo;
				a^.dato.list:= nil;
				agAdel (a^.dato.list, f.codMat, f.fecha, f.nota);
				a^.HI:= nil;
				a^.HD:= nil;
			end
			else begin	
				if (a^.dato.legajo = f.legajo) then   				// si coincide el legajo agrego final a la lista del alumno 
					agAdel (a^.dato.list, f.codMat, f.fecha, f.nota)
				else 
					if (f.legajo < a^.dato.legajo) then agregarA (a^.HI, f)
					else
						agregarA (a^.HD, f);
			end;
		end;
	
	var f:finalAlu;
	begin
		leerF (f);
		while (f.legajo <> 0) do begin
			agregarA (a, f);
			leerF (f);
		end;
	end;
	
	function legImpar (a:arbol): integer;
	
		function cumple (leg: integer): boolean;
		begin
			cumple := ((leg MOD 2) = 1); // o (((leg MOD 10) MOD 2) = 1) ?
		end;
	
	begin
		if (a <> nil) then begin
			if (cumple(a^.dato.legajo)) then
				legImpar:= 1 + legImpar(a^.Hi) + legImpar (a^.HD)
			else
				legImpar:= legImpar (a^.HI)+ legImpar (a^.HD);
		end
		else 
			legImpar := 0;
	end;
	
	procedure Informar (a:arbol);
	
		function cantF (l:lista): integer;
		begin
			if (l <> nil) then begin
				if (l^.nota >= 4) then cantF:= 1 + cantF (l^.sig)
				else
					cantF:= cantF (l^.sig);
			end
			else 
				cantF := 0;
		end;
		
	begin
		if (a <> nil) then begin
			writeln ('Legajo de alumno: ', a^.dato.legajo);
			writeln ('Cantidad de finales aprobados: ', cantF(a^.dato.list));
			Informar (a^.HI);
			Informar (a^.HD);
		end;
	end;
	
	procedure promedios (a:arbol; valor: real);

		function prom (l:lista): real;
		var sumaN, cantN: integer;
		begin
			sumaN:=0;
			cantN:=0;
			while (l <> nil) do begin
				sumaN:= sumaN + l^.nota;
				cantN:= cantN + 1;
				l:=l^.sig;
			end;
			if (cantN > 0) then
				prom := (sumaN / cantN)  // suma de todas las notas entre la cantidad de finales 
			else
				prom:=0;
		end;
				

	begin
		if (a <> nil) then begin
			if (valor < prom (a^.dato.list)) then begin
				writeln ('Legajo de alumno que cumple: ', a^.dato.legajo);
				writeln ('Promedio del alumno: ', prom (a^.dato.list):0:2 );
			end;
			promedios (a^.HI, valor);
			promedios (a^.HD, valor);
		end;
	end;
var 
	a : arbol;
	valor: real;
BEGIN
	randomize;
	a:= nil;
	cargarA (a);
	Writeln ('Cantidad de alumnos con legajo impar: ', legImpar (a));
	Informar (a);
	writeln ('Ingrese valor real entre 1 y 10'); read (valor);
	promedios (a, valor);
END.

{esta bien que antes de agregar a la lista la ponga en nil al crear el nodo arbol? SI, si estoy creando el nodo arbol la lista no tiene nada cargado,
* asi que primero se inicializa en nil y seguido se carga el primer dato de la lista}
