package com.gaurav.efuel.utils;

import com.gaurav.efuel.dao.entity.User;
import com.gaurav.efuel.service.MyUserDetails;
import org.apache.commons.io.FilenameUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.multipart.MultipartFile;

import java.time.*;

public class CommonUtils {

    public static User getLoggedIn() {
        return ((MyUserDetails) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal()).getUser();
    }

    public static String getFileExtension(MultipartFile file) {
        return FilenameUtils.getExtension(file.getOriginalFilename());
    }

    public static Month getMonthFromFileName(String originalFileName) {

        if (originalFileName.contains(Month.JANUARY.toString()))
            return Month.JANUARY;

        else if (originalFileName.contains(Month.FEBRUARY.toString()))
            return Month.FEBRUARY;

        else if (originalFileName.contains(Month.MARCH.toString()))
            return Month.MARCH;

        else if (originalFileName.contains(Month.APRIL.toString()))
            return Month.APRIL;

        else if (originalFileName.contains(Month.MAY.toString()))
            return Month.MAY;

        else if (originalFileName.contains(Month.JUNE.toString()))
            return Month.JUNE;

        else if (originalFileName.contains(Month.JULY.toString()))
            return Month.JULY;

        else if (originalFileName.contains(Month.AUGUST.toString()))
            return Month.AUGUST;

        else if (originalFileName.contains(Month.SEPTEMBER.toString()))
            return Month.SEPTEMBER;

        else if (originalFileName.contains(Month.OCTOBER.toString()))
            return Month.OCTOBER;

        else if (originalFileName.contains(Month.NOVEMBER.toString()))
            return Month.NOVEMBER;

        else if (originalFileName.contains(Month.DECEMBER.toString()))
            return Month.DECEMBER;

        else
            return null;
    }
}
