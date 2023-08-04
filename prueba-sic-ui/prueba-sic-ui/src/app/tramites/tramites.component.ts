import { Component } from '@angular/core';
import { EntidadTramite } from './entidad-tramite';
import { TramitesService } from './tramites.service';

@Component({
  selector: 'app-tramites',
  templateUrl: './tramites.component.html',
  styleUrls: ['./tramites.component.css']
})
export class TramitesComponent {

  public tramites: EntidadTramite[]=[];
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


  constructor(private tramitesService: TramitesService){
    this.refrescarTramites();
  }

  refrescarTramites() {
    this.tramitesService.obtenerTramites().subscribe(
      (response) => {
         this.tramites = response as EntidadTramite[];
      }
    )
  }

  
}
