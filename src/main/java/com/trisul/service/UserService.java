package com.trisul.service;

import com.trisul.model.AuthenticationDetail;
import com.trisul.model.LoginDetail;
import com.trisul.model.UserDetail;
import javax.servlet.http.HttpServletRequest;

public interface UserService {

  AuthenticationDetail doLogin(LoginDetail loginDetail);

  Boolean createUser(UserDetail userDetail);

  UserDetail getUserDetail();

  void trackRequest(HttpServletRequest httpServletRequest);
}
