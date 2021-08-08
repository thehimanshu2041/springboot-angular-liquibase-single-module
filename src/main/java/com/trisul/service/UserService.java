package com.trisul.service;

import com.trisul.model.AuthenticationDetail;
import com.trisul.model.LoginDetail;
import com.trisul.model.UserDetail;

/**
 * @author h3kumar
 * @since 16/05/2021
 */
public interface UserService {

  AuthenticationDetail doLogin(LoginDetail loginDetail);

  boolean createUser(UserDetail userDetail);
}
