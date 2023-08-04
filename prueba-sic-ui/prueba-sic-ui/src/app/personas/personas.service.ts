import { Injectable } from '@angular/core';
import { EntidadPersona } from './entidad-persona';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class PersonasService {
  constructor(private http: HttpClient) { }

  public obtenerPersonas():Observable<any> {
     return this.http.get('http://localhost:8080/personas');
  }

  public ingresarPersona(infoPersona: EntidadPersona):Observable<any> {
    return this.http.put('http://localhost:8080/personas', infoPersona);
  }
}
