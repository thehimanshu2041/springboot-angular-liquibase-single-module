import { Component, HostBinding, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { animate, state, style, transition, trigger } from '@angular/animations';
import { NavService } from 'src/app/shared/service/nav.service';
import { NavItem } from 'src/app/shared/model/shared.model';

@Component({
    selector: 'cs-vertical-nav-component',
    templateUrl: './cs.vertical.nav.component.html',
    styleUrls: ['./cs.vertical.nav.component.scss'],
    animations: [
        trigger('indicatorRotate', [
            state('collapsed', style({ transform: 'rotate(0deg)' })),
            state('expanded', style({ transform: 'rotate(180deg)' })),
            transition('expanded <=> collapsed',
                animate('225ms cubic-bezier(0.4,0.0,0.2,1)')
            ),
        ])
    ]
})
export class CSVerticalNavComponent implements OnInit {
    expanded: boolean = false;
    @HostBinding('attr.aria-expanded') ariaExpanded = this.expanded;
    @Input() item: NavItem;
    @Input() depth: number;

    constructor(public navService: NavService,
        public router: Router) {
        if (this.depth === undefined) {
            this.depth = 0;
        }
    }

    ngOnInit() {
        this.navService.currentUrl.subscribe((url: string) => {
            if (this.item.route && url) {
                this.expanded = url.indexOf(`/${this.item.route}`) === 0;
                this.ariaExpanded = this.expanded;
            }
        });
    }

    onItemSelected(item: NavItem) {
        if (!item.children || !item.children.length) {
            this.router.navigate([item.route]);
            this.navService.closeNav();
        }
        if (item.children && item.children.length) {
            this.expanded = !this.expanded;
        }
    }
}
