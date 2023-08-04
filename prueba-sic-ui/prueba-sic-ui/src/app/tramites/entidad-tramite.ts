export interface EntidadTramite {
	idTramite:number;
	numeroTramite:string;
	anioRadicacion:string;
	nombreTramite:string;
	descripcion:string;
	personaRadicacion:EntidadTramitePersona;
	funcionarioRecibio:EntidadTramiteEmpleado;
}

export interface EntidadTramiteEmpleado {
	idEmpleado:number;
	persona:EntidadTramitePersona;
	dependencia:string;
	fechaIngreso:string;
}

export interface EntidadTramitePersona {
    idPersona:number;
    tipoIdentificacion:string;
	numeroIdentificacion:string;
	nombres:string;
	apellidos:string;
	telefono:string;
	direccion:string;
	email:string;
}
