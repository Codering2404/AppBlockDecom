package com.google.android.gms.internal.ads;

import com.facebook.ads.AdError;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzcke extends zzie {
    public zzcke(int i3, Map map, zzht zzhtVar, int i4) {
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 15);
        sb.append("Response code: ");
        sb.append(i3);
        super(sb.toString(), zzhtVar, AdError.SERVER_ERROR_CODE, i4);
    }
}
