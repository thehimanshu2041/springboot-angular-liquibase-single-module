import { Component, OnDestroy, OnInit } from '@angular/core';
import { ReplaySubject } from 'rxjs';
import { takeUntil } from 'rxjs/operators';
import { MenuDetail } from 'src/app/generated/rest';
import { MenuService } from '../service/menu.service';

@Component({ template: '' })
export class BaseContainerComponent implements OnInit, OnDestroy {

  items: MenuDetail[];
  private destroyed$: ReplaySubject<boolean> = new ReplaySubject(1);

  constructor(public menuService: MenuService) {
    this.menuService.getMenuList();
  }

  ngOnInit() {
    this.menuService.menuObservable$
      .pipe(takeUntil(this.destroyed$))
      .subscribe((res) => this.items = res);
  }

  ngOnDestroy(): void {
    this.destroyed$.next(true);
    this.destroyed$.complete();
  }
}
