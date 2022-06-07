import { Component, Input } from '@angular/core';

@Component({
	selector: 'new-directive',
	template: '<h3>This is the second directive! {{firstName}}</h3>',
})
// This is really just a component.
export class NewDirective {
	@Input()
	firstName!: string;
}