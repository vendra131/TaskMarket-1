package com.kodekonveyor.market.integrationtests;

import java.io.IOException;

import org.apache.commons.io.IOUtils;

import com.kodekonveyor.market.github.FileNotFoundException;
import com.kodekonveyor.market.github.GithubConstants;
import com.kodekonveyor.market.github.JsonResultDTO;

public class JsonResultTestData {

  public static final String GITHUB_API_URL =
      "https://api.github.com/repos/kode-konveyor/taskmarket/issues/74";

  public static final JsonResultDTO get() throws IOException {
    final JsonResultDTO jsonResult = new JsonResultDTO();
    jsonResult.setResult(getGithubResponse());
    return jsonResult;
  }

  public static final String getGithubResponse() {
    String resp;
    try {
      resp = IOUtils.toString(
          Thread.currentThread().getContextClassLoader()
              .getResource(GithubConstants.FILE_NAME),
          GithubConstants.UTF_8
      );
    } catch (final IOException exception) {
      throw new FileNotFoundException(
          GithubConstants.FILE_NOT_FOUND, exception
      );
    }
    return resp;
  }
}
