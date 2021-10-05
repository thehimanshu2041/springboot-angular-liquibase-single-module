package com.trisul.core.security.user;

import javax.servlet.http.HttpServletRequest;

public interface UserStore {

  String getLoggedInUser();

  String getIpAddress(HttpServletRequest httpServletRequest);
}
