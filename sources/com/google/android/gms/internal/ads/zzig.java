package com.google.android.gms.internal.ads;

import com.facebook.ads.AdError;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzig extends zzie {
    public final int zzc;

    public zzig(int i3, String str, IOException iOException, Map map, zzht zzhtVar, byte[] bArr) {
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 15);
        sb.append("Response code: ");
        sb.append(i3);
        super(sb.toString(), iOException, zzhtVar, AdError.INTERNAL_ERROR_2004, 1);
        this.zzc = i3;
    }
}
