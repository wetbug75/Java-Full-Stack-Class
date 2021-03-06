//import {SecDirective} from './secDirective';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
//import { NewDirective } from './newDirective';
//import { ThirdDirective } from './thirdDirective';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
//import { HttpModule } from '@angular/http';
//import { FahrenheitPipe } from './app.fahrenheitPipe';
//import { PageDefault } from './app.pagedefault';
import { PageAComponent } from './app.page-a';
import { PageBComponent } from './app.page-b';
import { routing } from './app.routing';

import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
	imports: [ AppComponent, BrowserModule, FormsModule, routing, ReactiveFormsModule ],
	declarations: [ AppComponent, PageAComponent, PageBComponent ],
	bootstrap: [ AppComponent ]
})
export class AppModule { }