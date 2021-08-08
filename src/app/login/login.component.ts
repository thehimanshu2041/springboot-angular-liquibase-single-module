import { Component, ViewChild, ElementRef } from '@angular/core';
import { predefinedAnimations } from '../shared/ui/animation/predefined.animations';

@Component({
    selector: 'cs-login-component',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.scss'],
    animations: [predefinedAnimations.zoomInOutAnimations]
})
export class LoginComponent {

    username: string;
    password: string;
    @ViewChild('usernameInput', { static: false }) usernameInput: ElementRef;

    constructor() { }

    login(): void {
        console.log(this.username, this.password);
    }

}