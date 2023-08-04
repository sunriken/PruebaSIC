import { Component, Inject } from '@angular/core';
import { EntidadEmpleado } from './entidad-empleado';
import { EmpleadosService } from './empleados.service';

@Component({
  selector: 'app-empleados',
  templateUrl: './empleados.component.html',
  styleUrls: ['./empleados.component.css']
})
export class EmpleadosComponent {

  public empleados: EntidadEmpleado[]=[];
  public nombres: any;
  public tipoIdentificacion: any;
  public numeroIdentificacion: any;
  public apellidos: any;
  public telefono: any;
  public direccion: any;
  public email: any;
  public mensaje:any;
  public dependencia:any;
  public fechaIngreso:any;


  constructor(private empleadosService: EmpleadosService){
    this.refrescarEmpleados();
  }

  refrescarEmpleados() {
    this.empleadosService.obtenerEmpleados().subscribe(
      (response) => {
         this.empleados = response as EntidadEmpleado[];
      }
    )
  }

  guardarEmpleado() {
    let infoEmpleado : EntidadEmpleado = {
      idEmpleado: -1,
      persona:{
        idPersona: -1,
        tipoIdentificacion: this.tipoIdentificacion,
        numeroIdentificacion: this.numeroIdentificacion,
        nombres: this.nombres,
        apellidos: this.apellidos,
        direccion: this.direccion,
        telefono: this.telefono,
        email: this.email
      },
      dependencia: this.dependencia,
      fechaIngreso: this.fechaIngreso
    }

    this.empleadosService.ingresarEmpleado(infoEmpleado).subscribe(
      (response) => {
        this.mensaje="Se ingresó el empleado con éxito.";
        this.refrescarEmpleados();
      }, 
      (error) => {
        this.mensaje = error;
      }
    );
  }
}
