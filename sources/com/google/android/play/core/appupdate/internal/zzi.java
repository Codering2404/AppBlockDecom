package com.google.android.play.core.appupdate.internal;

import com.facebook.internal.AnalyticsEvents;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Set f82858a = new HashSet(Arrays.asList("app_update", "review"));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set f82859b = new HashSet(Arrays.asList(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE, "unity"));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map f82860c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final zzm f82861d = new zzm("PlayCoreVersion");

    public static synchronized Map a(String str) {
        Map map;
        try {
            map = f82860c;
            if (!map.containsKey("app_update")) {
                HashMap map2 = new HashMap();
                map2.put("java", 11004);
                map.put("app_update", map2);
            }
        } catch (Throwable th) {
            throw th;
        }
        return (Map) map.get("app_update");
    }
}
