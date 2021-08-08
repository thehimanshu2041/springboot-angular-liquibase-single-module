import { Injectable } from '@angular/core';
import { Event, NavigationEnd, Router } from '@angular/router';
import { BehaviorSubject} from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class NavService {
    public appDrawer: any;
    public currentUrl = new BehaviorSubject<string>(undefined);

    constructor(private router: Router, private httpClient: HttpClient) {
        this.router.events.subscribe((event: Event) => {
            if (event instanceof NavigationEnd) {
                this.currentUrl.next(event.urlAfterRedirects);
            }
        });
    }

    public closeNav() {
        this.appDrawer.close();
    }

    public openNav() {
        this.appDrawer.open();
    }
}
