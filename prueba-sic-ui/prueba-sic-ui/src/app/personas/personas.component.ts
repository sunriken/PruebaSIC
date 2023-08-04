import { Component, Inject } from '@angular/core';
import { EntidadPersona } from './entidad-persona';
import { PersonasService } from './personas.service';

@Component({
  selector: 'app-personas',
  templateUrl: './personas.component.html',
  styleUrls: ['./personas.component.css']
})
export class PersonasComponent {

  public personas: EntidadPersona[]=[];
  public nombres: any;
  public tipoIdentificacion: any;
  public numeroIdentificacion: any;
  public apellidos: any;
  public telefono: any;
  public direccion: any;
  public email: any;
  public mensaje:any;


  constructor(private personasService: PersonasService){
    this.refrescarPersonas();
  }

  refrescarPersonas() {
    this.personasService.obtenerPersonas().subscribe(
      (response) => {
         this.personas = response as EntidadPersona[];
      }
    )
  }

  guardarPersona() {
    let infoPersona : EntidadPersona = {
      idPersona: -1,
      tipoIdentificacion: this.tipoIdentificacion,
      numeroIdentificacion: this.numeroIdentificacion,
      nombres: this.nombres,
      apellidos: this.apellidos,
      direccion: this.direccion,
      telefono: this.telefono,
      email: this.email
    }

    this.personasService.ingresarPersona(infoPersona).subscribe(
      (response) => {
        this.mensaje="Se ingresó la persona con éxito.";
        this.refrescarPersonas();
      }, 
      (error) => {
        this.mensaje = error;
      }
    );
  }
}
