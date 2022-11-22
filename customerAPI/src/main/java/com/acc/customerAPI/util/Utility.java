package com.acc.customerAPI.util;

import java.util.List;

public final class Utility {
    public static  <T> boolean isNotNullOrEmpty(List<T> list) {
        return list != null && !list.isEmpty();
    }

    public static boolean isNotNullOrEmpty(String string) {
        return string != null && !string.isEmpty();
    }
}
