package com.google.android.play.core.review;

import com.facebook.internal.AnalyticsEvents;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map f83156a;

    static {
        new HashSet(Arrays.asList(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE, "unity"));
        f83156a = new HashMap();
        new com.google.android.play.core.review.internal.zzi("PlayCoreVersion");
    }

    public static synchronized Map a() {
        Map map;
        map = f83156a;
        map.put("java", 20002);
        return map;
    }
}
