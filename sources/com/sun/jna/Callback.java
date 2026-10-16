package com.sun.jna;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public interface Callback {
    public static final List<String> FORBIDDEN_NAMES = Collections.unmodifiableList(Arrays.asList("hashCode", "equals", InAppPurchaseConstants.METHOD_TO_STRING));
    public static final String METHOD_NAME = "callback";

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface UncaughtExceptionHandler {
        void uncaughtException(Callback callback, Throwable th);
    }
}
