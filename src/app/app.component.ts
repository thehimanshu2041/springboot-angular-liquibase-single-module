import { Component } from '@angular/core';
import { ThemeService } from './shared/service/theme.service';

@Component({
  selector: 'cs-app-root',
  template: '<cs-container-component></cs-container-component>'
})
export class AppComponent {

  constructor(private themeService: ThemeService) {
    this.themeService._setColorOnOnload();
  }
}
