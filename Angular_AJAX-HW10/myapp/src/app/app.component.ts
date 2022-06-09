import { Component } from '@angular/core';
//import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Andrew\'s app';
  cutContent = '';
  copyContent = '';

  myMouseEnter() {
    console.log("Mouse entered!")
  }
  myMouseLeft() {
    console.log("Mouse left!")
  }

  myKeyDown(event: KeyboardEvent) {
    console.log(event)
    console.log(event.key)
  }
  myKeyUp(event: KeyboardEvent) {
    console.log(event)
    console.log(event.key)
  }

  myFocusEvent(description: string) {
    console.log(description)
  }

  cutEvent(content: string) {
    this.cutContent = content;
    console.log("cut: " + content)
  }
  copyEvent(content: string) {
    this.copyContent = content;
    console.log("copied: " + content)
  }
  pasteContent() { //this doesn't work right with copy but is good enough for this assignment
    console.log("pasted: " + this.cutContent)
    this.cutContent = '';
  }

  myMouseHandler(event: any, description: string) {
    console.log(description + " X: " + event.screenX.toString() + " Y:" + event.screenY.toString())
  }
}

/*@Component({
  selector: 'app-root',
  template: `
      <h3>Please enter the customer information:</h3>
      <child [callParent]="parentFuncRef" [city]="dataFromChild"></child>
      {{dataFromChild}}
      `
})
export class AppComponent {
  parentFuncRef!: Function;
  operations!: Array<any>;
  dataFromChild!: string;

  // This function is called by the Angular framework after the constructor executes.
  public ngOnInit() {
    this.parentFuncRef = this.myCallBackFunction.bind(this);
  }
  // This function can be called by child.
  public myCallBackFunction(streetAddress: string, city: string, region: string) {
    this.dataFromChild = "Street Address: " + streetAddress + "Region:" + region + " " + "City: " + city;
  }
}*/