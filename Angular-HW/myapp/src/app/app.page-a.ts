import { Component } from '@angular/core';

@Component({
	template: 'This is page A.<br>This content was set in page-b: {{someItem}}'
})

export class PageAComponent {
	someItem: string;
	
	constructor() {
		if (sessionStorage.getItem("autosave")) {
			this.someItem = sessionStorage.getItem("autosave");
		}
	}
}