import { Component, Input } from '@angular/core';
import { NavItem } from 'src/app/shared/model/shared.model';

@Component({
    selector: 'cs-horizontal-main-menu',
    templateUrl: './cs.horizontal.main.menu.component.html',
    styles: ['.mat-list-base { padding-top: 0px !important} button:focus { outline: transparent !important}']
})
export class CSHorizontalMainMenuComponent {
    @Input() menuItemList: NavItem[];
}
