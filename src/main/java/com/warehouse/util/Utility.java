package com.warehouse.util;


import com.warehouse.excetion.FileFormatException;
import org.springframework.util.StringUtils;

import java.io.File;

public class Utility {

    public static boolean verifyFile(String fullName) {
        if (!StringUtils.isEmpty(fullName)) {
            String fileName = new File(fullName).getName();
            int dotIndex = fileName.lastIndexOf('.');
            String extension = (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
            if (extension.equalsIgnoreCase("json")) {
                return true;
            }
        }
        throw new FileFormatException("Invalid input file!!");
    }
}
