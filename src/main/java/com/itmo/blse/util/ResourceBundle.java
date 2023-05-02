package com.itmo.blse.util;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.core.io.Resource;

import java.io.File;

@Getter
@Setter
@Builder
public class ResourceBundle {
    Resource resource;
    File file;
}
