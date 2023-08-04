import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { EntidadEmpleado } from './entidad-empleado';

@Injectable({
  providedIn: 'root'
})
export class EmpleadosService {
  constructor(private http: HttpClient) { }

  public obtenerEmpleados():Observable<any> {
     return this.http.get('http://localhost:8080/empleados');
  }

  public ingresarEmpleado(infoEmpleado: EntidadEmpleado):Observable<any> {
    return this.http.put('http://localhost:8080/empleados', infoEmpleado);
  }
}
