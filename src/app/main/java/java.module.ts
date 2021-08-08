import { CommonModule } from '@angular/common';
import { CUSTOM_ELEMENTS_SCHEMA, NgModule, NO_ERRORS_SCHEMA } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { StaticTranslateLoader } from 'src/app/shared/common/translate/static.translate.loader';
import { translateConfiguration } from 'src/app/shared/common/translate/translate.config';
import { SharedModule } from 'src/app/shared/module/shared.module';
import { SpringbootComponent } from './springboot/springboot.component';
import { SpringbootTableOfContentComponent } from './springboot/springboot-table-of-content/springboot-table-of-content.component';
import { SpringbootBodyContentComponent } from './springboot/springboot-body-content/springboot-body-content.component';

export const javaRouters: Routes = [
    {
        path: '',
        component: SpringbootComponent
    },
    {
        path: 'springboot',
        component: SpringbootComponent
    }
];

const DECLARE_COMPONENT = [
    SpringbootComponent,
    SpringbootTableOfContentComponent,
    SpringbootBodyContentComponent
];

@NgModule({
    declarations: [DECLARE_COMPONENT],
    imports: [
        CommonModule,
        RouterModule.forChild(javaRouters),
        TranslateModule.forRoot(translateConfiguration),
        SharedModule,
    ],
    providers: [
        StaticTranslateLoader
    ],
    schemas: [
        CUSTOM_ELEMENTS_SCHEMA,
        NO_ERRORS_SCHEMA
    ]
})

export class JavaModule {
    constructor() {
        console.log('java module loaded');
    }
}
