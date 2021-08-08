import { CUSTOM_ELEMENTS_SCHEMA, NgModule, NO_ERRORS_SCHEMA } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app.routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { SharedModule } from 'src/app/shared/module/shared.module';
import { NavService } from './shared/service/nav.service';
import { CSContainerComponent } from './container/cs.container.component';
import { CSHorizontalMainMenuComponent } from './container/horizontal-menu/cs.horizontal.main.menu.component';
import { CSHorizontalMenuComponent } from './container/horizontal-menu/cs.horizontal.menu.component';
import { CSVerticalNavComponent } from './container/vertical-menu/cs.vertical.nav.component';
import { ThemeService } from './shared/service/theme.service';
import { HomeComponent } from './main/home.component';
import { AlertService } from './shared/service/alert.service';
import { AlertAreaComponent } from './shared/ui/component/alert/alert.area.component';
import { TranslateModule, TranslateService } from '@ngx-translate/core';
import { translateConfiguration } from './shared/common/translate/translate.config';
import { StaticTranslateLoader } from './shared/common/translate/static.translate.loader';
import { MatIconRegistry } from '@angular/material/icon';
import { HashLocationStrategy, LocationStrategy } from '@angular/common';
import { LoginComponent } from './login';

const DECLARE_COMPONENT = [
  AppComponent,
  CSContainerComponent,
  CSHorizontalMainMenuComponent,
  CSHorizontalMenuComponent,
  CSVerticalNavComponent,
  AlertAreaComponent,
  HomeComponent,
  LoginComponent
];

@NgModule({
  declarations: [
    DECLARE_COMPONENT
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    SharedModule,
    AppRoutingModule,
    TranslateModule.forRoot(translateConfiguration),
  ],
  providers: [
    StaticTranslateLoader,
    NavService,
    ThemeService,
    AlertService,
    {
      provide: LocationStrategy,
      useClass: HashLocationStrategy
    },
  ],
  schemas: [
    CUSTOM_ELEMENTS_SCHEMA,
    NO_ERRORS_SCHEMA
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
  constructor(translate: TranslateService, registry: MatIconRegistry) {
    console.log('App module loaded');
    translate.setDefaultLang('en');
    translate.use('en');
    registry.setDefaultFontSetClass('material-icons');
  }
}
