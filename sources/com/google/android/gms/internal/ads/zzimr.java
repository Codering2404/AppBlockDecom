package com.google.android.gms.internal.ads;

import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzimr {
    public static List zza(int i3) {
        return i3 == 0 ? Collections.EMPTY_LIST : new ArrayList(i3);
    }

    static HashSet zzb(int i3) {
        return new HashSet(zzd(i3));
    }

    public static LinkedHashMap zzc(int i3) {
        return new LinkedHashMap(zzd(i3));
    }

    private static int zzd(int i3) {
        return i3 < 3 ? i3 + 1 : i3 < 1073741824 ? (int) ((i3 / 0.75f) + 1.0f) : Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }
}
