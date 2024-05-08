package com.eden.imageparser.edenai.dto;

import java.io.File;
import java.util.List;

public record EdenOcrLaunchRequest(List<String> providers,
                                   List<EdenQuery> queries,
                                   byte[] file) {
}
