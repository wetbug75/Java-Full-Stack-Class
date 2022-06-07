import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
	template: 'This is page b. <input type="input" (ngModelChange)="mychange($any($event))" [(ngModel)]="mymodel">'
})

//<input type="input" (ngModelChange)="mychange2($event)" [ngModel]="mymodel2">

export class PageBComponent {

	/*mymodel!: string;
	mymodel2!: string;*/
	
	mymodel!: string;
	
	/*constructor() {
	}*/
	
	mychange(val:string) {
		sessionStorage.setItem("autosave", val);
		console.log(val); // updated value
	}
	
	/*mychange2(val2: string) {
		sessionStorage.setItem("autosave2", val2);
		console.log(val2); // updated value
	}*/
}