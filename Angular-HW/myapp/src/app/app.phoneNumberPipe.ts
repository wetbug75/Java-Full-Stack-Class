import { Pipe, PipeTransform } from '@angular/core';

@Pipe ({ name: 'phoneNumberPipe'})

export class PhoneNumberPipe implements PipeTransform {
  transform(phoneNumber:string) {

  const areaNum = phoneNumber.slice(0,3);
  const middleNum = phoneNumber.slice(3, 6);
  const lastNum = phoneNumber.slice(6, 10);

  return '(${areaNum})${middleNum}-${lastNum}'
  }
}