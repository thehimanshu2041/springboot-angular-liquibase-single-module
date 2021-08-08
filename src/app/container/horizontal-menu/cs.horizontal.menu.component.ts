import { Component, Input, ViewChild } from '@angular/core';
import { NavItem } from 'src/app/shared/model/shared.model';


@Component({
    selector: 'cs-horizontal-menu',
    templateUrl: './cs.horizontal.menu.component.html',
    styleUrls: ['./cs.horizontal.menu.component.scss']
})
export class CSHorizontalMenuComponent {
    @Input() items: NavItem[];
    @ViewChild('childMenu', { static: false }) public childMenu;
}
