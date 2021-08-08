import { CUSTOM_ELEMENTS_SCHEMA, NgModule, NO_ERRORS_SCHEMA } from '@angular/core';
import { MaterialModule } from './material/material.module';
import { FlexLayoutModule } from '@angular/flex-layout';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LayoutModule } from '@angular/cdk/layout';
import { OverlayModule } from '@angular/cdk/overlay';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { NgxWebstorageModule } from 'ngx-webstorage';

@NgModule({
    declarations: [
    ],
    imports: [
        CommonModule,
        RouterModule,
        MaterialModule,
        FlexLayoutModule,
        FormsModule,
        ReactiveFormsModule,
        LayoutModule,
        OverlayModule,
        NgxWebstorageModule.forRoot({ prefix: 'cs|' })
    ],
    exports: [
        CommonModule,
        RouterModule,
        MaterialModule,
        FlexLayoutModule,
        FormsModule,
        ReactiveFormsModule,
        LayoutModule,
        OverlayModule,
        NgxWebstorageModule
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA]
})
export class SharedModule { }
