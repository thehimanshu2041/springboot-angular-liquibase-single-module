package com.trisul.core.security.user;

import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserStoreImpl implements UserStore {

  @Override
  public String getLoggedInUser() {
    try {
      String username;
      Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      if (principal instanceof UserDetails) {
        username = ((UserDetails) principal).getUsername();
      } else {
        username = principal.toString();
      }
      return username;
    } catch (Exception ex) {
      return "anonymousUser";
    }
  }

  @Override
  public String getIpAddress(HttpServletRequest httpServletRequest) {
    String remoteAddr = null;
    if (httpServletRequest != null) {
      remoteAddr = httpServletRequest.getHeader("X-FORWARDED-FOR");
      if (remoteAddr == null || "".equals(remoteAddr)) {
        remoteAddr = httpServletRequest.getRemoteAddr();
      }
    }
    return remoteAddr;
  }
}
