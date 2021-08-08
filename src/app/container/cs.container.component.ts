import { Component, ChangeDetectorRef, OnDestroy, ElementRef, ViewChild, AfterViewInit, OnInit } from '@angular/core';
import { MediaMatcher } from '@angular/cdk/layout';
import { Router } from '@angular/router';
import { ColorScheme, NavItem } from '../shared/model/shared.model';
import { NavService } from '../shared/service/nav.service';
import { ThemeService } from '../shared/service/theme.service';
const NAV_ITEMS: any[] = require('./../app.menu.json'); // tslint:disable-line no-var-requires

declare var require: any;

@Component({
  selector: 'cs-container-component',
  templateUrl: './cs.container.component.html',
  styleUrls: ['./cs.container.component.scss']
})
export class CSContainerComponent implements OnInit, OnDestroy, AfterViewInit {

  mobileQuery: MediaQueryList;
  title = 'Coding Standard';

  @ViewChild('appDrawer', { static: true })
  appDrawer: ElementRef;
  _mobileQueryListener: () => void;

  navItems: NavItem[] = NAV_ITEMS as NavItem[];

  matToggleBoolean = false;
  colorScheme: ColorScheme;

  constructor(
    changeDetectorRef: ChangeDetectorRef,
    media: MediaMatcher,
    private router: Router,
    private navService: NavService,
    private themeService: ThemeService) {
    this.mobileQuery = media.matchMedia('(max-width: 960px)');
    this._mobileQueryListener = () => changeDetectorRef.detectChanges();
    this.mobileQuery.addListener(this._mobileQueryListener);
    document.querySelector('html').classList.add('cs');
  }

  ngOnInit(): void {
    this.colorScheme = this.themeService.colorScheme;
    this.matToggleBoolean = this.colorScheme.isNightMode === 'Y' ? true : false;
  }

  ngOnDestroy() {
    this.mobileQuery.removeListener(this._mobileQueryListener);
  }

  ngAfterViewInit() {
    this.navService.appDrawer = this.appDrawer;
  }

  darkMode(flag: boolean) {
    this.matToggleBoolean = flag;
    this.colorScheme.isNightMode = flag ? 'Y' : 'N';
    this.themeService.isNightMode = this.colorScheme.isNightMode;
    this.themeService._checkDarkMode(this.colorScheme);
  }

  get isDarkMode(): boolean {
    this.colorScheme = this.themeService.colorScheme;
    return this.colorScheme.isNightMode === 'Y' ? true : false;
  }
}
