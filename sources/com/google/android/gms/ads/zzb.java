package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzch;
import com.google.android.gms.internal.ads.zzbuy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile zzch f70850a;

    public static zzch a(Context context) {
        if (f70850a == null) {
            synchronized (zzb.class) {
                try {
                    if (f70850a == null) {
                        f70850a = zzay.b().d(context, new zzbuy());
                    }
                } finally {
                }
            }
        }
        return f70850a;
    }
}
