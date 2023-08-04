import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PersonasComponent } from './personas.component';
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    PersonasComponent
  ],
  imports: [
    CommonModule,
    FormsModule
  ],
  exports: [
    PersonasComponent
  ]
})
export class PersonasModule { }
