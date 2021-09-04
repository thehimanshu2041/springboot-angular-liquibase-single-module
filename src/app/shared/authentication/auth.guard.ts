import { Component } from "@angular/core";
import { ActivatedRouteSnapshot, CanActivate, CanActivateChild, Router, RouterStateSnapshot } from "@angular/router";
import { Observable, of } from "rxjs";
import { map } from "rxjs/operators";
import { AuthenticationDetail } from "src/app/generated/rest";
import { AuthService } from "../services/auth.service";


@Component({ template: '' })
export class AuthGuard implements CanActivate, CanActivateChild {

  private user: AuthenticationDetail;
  private init: Observable<boolean>;

  constructor(private router: Router, private authService: AuthService) { }

  getUser(): Observable<boolean> {
    if (this.authService.authSession && this.authService.authSession.access_token) {
      this.user = this.authService.authSession;
      return of(true);
    } else {
      this.user = null;
      this.router.navigate(['login']);
      return of(false);
    }
  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> {
    this.init = this.getUser();
    return this.checkForActivation(route, state);
  }

  canActivateChild(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> {
    this.init = this.getUser();
    return this.checkForActivation(route, state);
  }

  private checkForActivation(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> {
    return this.init.pipe(map(auth => {
      if (!this.user) {
        return false;
      }
      else {
        this.init;
      }
    }));
  }
}
