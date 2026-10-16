package com.google.android.play.core.review.model;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zza {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map f83138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map f83139b;

    static {
        HashMap map = new HashMap();
        f83138a = map;
        HashMap map2 = new HashMap();
        f83139b = map2;
        map.put(-1, "The Play Store app is either not installed or not the official version.");
        map.put(-2, "Call first requestReviewFlow to get the ReviewInfo.");
        map.put(-100, "Retry with an exponential backoff. Consider filing a bug if fails consistently.");
        map2.put(-1, "PLAY_STORE_NOT_FOUND");
        map2.put(-2, "INVALID_REQUEST");
        map2.put(-100, "INTERNAL_ERROR");
    }

    public static String a(int i3) {
        Map map = f83138a;
        Integer numValueOf = Integer.valueOf(i3);
        if (!map.containsKey(numValueOf)) {
            return "";
        }
        return ((String) map.get(numValueOf)) + " (https://developer.android.com/reference/com/google/android/play/core/review/model/ReviewErrorCode.html#" + ((String) f83139b.get(numValueOf)) + ")";
    }
}
