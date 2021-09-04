import { CUSTOM_ELEMENTS_SCHEMA, NgModule, NO_ERRORS_SCHEMA } from '@angular/core';
import { MaterialModule } from './modules/material/material.module';
import { FlexLayoutModule } from '@angular/flex-layout';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LayoutModule } from '@angular/cdk/layout';
import { OverlayModule } from '@angular/cdk/overlay';
import { NgxWebstorageModule } from 'ngx-webstorage';
import { AlertService, ThemeService } from './services';
import { StaticTranslateLoader } from './translate';
import { TranslateLoader, TranslateModule, TranslateStore } from '@ngx-translate/core';
import { TrisulServiceService, UserServiceService } from 'src/app/generated/rest';
import { MenuService } from 'src/app/container';
import { AuthService } from './services/auth.service';
import { ToastrModule } from 'ngx-toastr';
import { AlertAreaModule } from './components';

const API_CLIENT = [
  TrisulServiceService,
  UserServiceService
];

const EXTERNAL_MODULES = [
  AlertAreaModule
];

const toastConfig = {
  positionClass: 'toast-top-right',
  closeButton: true,
  timeOut: 10000,
  easeTime: 300,
  enableHtml: true,
  progressBar: true,
  preventDuplicates: true
};

@NgModule({
  declarations: [
  ],
  imports: [
    MaterialModule,
    FlexLayoutModule,
    FormsModule,
    ReactiveFormsModule,
    LayoutModule,
    OverlayModule,
    NgxWebstorageModule.forRoot({ prefix: 'TRISUL|' }),
    TranslateModule.forChild({
      defaultLanguage: 'en',
      loader: {
        provide: TranslateLoader,
        useExisting: StaticTranslateLoader
      },
    }),
    ToastrModule.forRoot(toastConfig),
    ...EXTERNAL_MODULES
  ],
  exports: [
    MaterialModule,
    FlexLayoutModule,
    FormsModule,
    ReactiveFormsModule,
    LayoutModule,
    OverlayModule,
    NgxWebstorageModule,
    TranslateModule,
    ToastrModule,
    ...EXTERNAL_MODULES
  ],
  providers: [
    StaticTranslateLoader,
    TranslateStore,
    AlertService,
    ThemeService,
    MenuService,
    AuthService,
    ...API_CLIENT
  ],
  schemas: [
    CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA
  ]
})
export class SharedModule { }
