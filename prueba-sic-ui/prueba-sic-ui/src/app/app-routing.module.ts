import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PersonasComponent } from './personas/personas.component';
import { EmpleadosComponent } from './empleados/empleados.component';
import { TramitesComponent } from './tramites/tramites.component';

const routes: Routes = [
  {
    path: "personas",
    component: PersonasComponent
  },
  {
    path: "empleados",
    component: EmpleadosComponent
  },
  {
    path: "tramites",
    component: TramitesComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
