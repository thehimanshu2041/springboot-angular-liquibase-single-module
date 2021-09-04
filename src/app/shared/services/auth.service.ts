import { Injectable } from "@angular/core";
import { Observable, of } from "rxjs";
import { mergeMap } from "rxjs/operators";
import { AuthenticationDetail, UserServiceService } from "src/app/generated/rest";


@Injectable()
export class AuthService {

  public authSession: AuthenticationDetail;

  constructor(private userService: UserServiceService) { }

  login(username: string, password: string): Observable<boolean> {
    const loginPayload = { username: username, password: password };
    return this.userService.doLogin(loginPayload)
      .pipe(
        mergeMap((map) => {
          if (map.access_token) {
            this.actionOnLogin(map);
            return of(true);
          } else {
            this.actionOnLogout();
            return of(false);
          }
        })
      );
  }

  private actionOnLogin(authDetail: AuthenticationDetail): void {
    this.authSession = authDetail;
  }

  actionOnLogout(): void {
    this.authSession = null;
  }
}
