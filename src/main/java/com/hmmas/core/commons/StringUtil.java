package com.hmmas.core.commons;/*
package co.cassavasmartech.vmscore.commons;


import zw.co.cassavasmartech.commons.enums.Role;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class StringUtil {

    public static String[] getEnumValuesAsString(Class<? extends Enum<?>> e) {
        return Arrays.stream(e.getEnumConstants()).map(Enum::name).toArray(String[]::new);
    }

    public static Set<Role> getRolesAsSet(String[] roles) {
        if ((roles == null) || (roles.length == 0)) {
            return Collections.emptySet();
        } else {
            return Arrays.stream(roles)
                    .map(Role::getRoleForString)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toSet());
        }
    }
}*/

