export interface EntidadEmpleado {
	idEmpleado:number;
	persona:EntidadPersonaEmpleado;
	dependencia:string;
	fechaIngreso:string;
}

export interface EntidadPersonaEmpleado {
    idPersona:number;
    tipoIdentificacion:string;
	numeroIdentificacion:string;
	nombres:string;
	apellidos:string;
	telefono:string;
	direccion:string;
	email:string;
}
