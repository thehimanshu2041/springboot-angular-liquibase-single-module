package com.trisul.service;

import com.trisul.model.CodeDetail;
import com.trisul.model.CscDetail;

public interface ResolverService {

  CodeDetail resolveCodeDetail(CodeDetail codeDetail);

  CscDetail resolveCscDetail(CscDetail cscDetail);
}
