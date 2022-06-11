import { BoundElementProperty } from '@angular/compiler';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `
      <label [class.danger]="foodWarning">Has food allergy.</label>
      <input type="checkbox" [(ngModel)]="foodWarning" /><br>

      <label [class.makemegreen]="greenWarning">Make me green.</label>
      <input type="checkbox" [(ngModel)]="greenWarning" />

      <p [ngClass]="myClasses">class binding example</p>

      <input type="checkbox" [(ngModel)]="doesNotExercise" (change)="adjustCSS()"/>Does not exercise.
      <input type="checkbox" [(ngModel)]="over55" (change)="adjustCSS()"/>Is over 55.
      <div *ngIf="doesNotExercise || over55" [ngClass]="myClasses2" >
        Is at risk of heart disease.
      </div>

      <p [style.font-weight]="myWeight">style binding example</p>


      `,
  styles: [`
      .warning {
        font-weight: bold;
      }

      .danger {
        color: orange;
        font-weight: bold;
      }

      .danger2 {
        color: red;
      }

      .warning2 {
        font-weight: bold;
      }
      
      .highrisk {
        text-decoration: underline;
      }

      .makemegreen{
        color:green;
        font-weight: bold;
      }

      `
  ]
})
export class AppComponent {
  title = 'Andrew\'s app'
  
  foodWarning:Boolean
  greenWarning:Boolean

  property1=true
  property2=true;
  property3=true;

  doesNotExercise = false;
  over55 = false

  myWeight = "bold";

  myClasses = {
    warning:this.property1,
    danger:this.property2,
    highrisk:this.property3
  }

  myClasses2 = {
    warning2: true,
    danger2: true
  }

  adjustCSS() {
  }

  constructor() {
  // Set default value to false.
  this.foodWarning = false;
  this.greenWarning = false;  
  }
}
