import { Component } from '@angular/core';

//Define sec directive.
@Component({
	//Selector uses lower case with hyphens.
	selector: 'sec-directive',
	template: '<h3>This is the second directive!</h3><!-- <third-directive></third-directive> -->',
})
export class SecDirective {
}