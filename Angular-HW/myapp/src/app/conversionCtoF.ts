import { Component } from '@angular/core';

// This is the service.
export class ConversionCtoF {
	c: number;
	f: number;
	
	constructor() {
		this.c = 6;
		this.f= (this.c*9/5) + 32;
	}
	
	getConversion() {
		this.f= (this.c*9/5) + 32;
		return this.f;
	}
}