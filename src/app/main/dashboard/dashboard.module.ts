import { NgModule } from '@angular/core';
import { SharedModule } from 'src/app/shared';
import { AuthGuard } from 'src/app/shared/authentication';
import { DashboardRoutingModule } from './dashboard.routing.module';
import { DashboardComponent } from './dashboard/dashboard.component';


const DECLARE_COMPONENT = [
  DashboardComponent
];

@NgModule({
  declarations: [
    DECLARE_COMPONENT
  ],
  imports: [
    SharedModule,
    DashboardRoutingModule
  ],
  providers: [AuthGuard]
})
export class DashboardModule {
  constructor() {
    console.log('DashboardModule');
  }
}
