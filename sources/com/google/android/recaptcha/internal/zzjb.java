package com.google.android.recaptcha.internal;

import android.os.Build;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzjb {
    public static final Map zza() {
        Map mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.a(-4, zzba.zzo), TuplesKt.a(-12, zzba.zzp), TuplesKt.a(-6, zzba.zzk), TuplesKt.a(-11, zzba.zzm), TuplesKt.a(-13, zzba.zzq), TuplesKt.a(-14, zzba.zzr), TuplesKt.a(-2, zzba.zzl), TuplesKt.a(-7, zzba.zzs), TuplesKt.a(-5, zzba.zzt), TuplesKt.a(-9, zzba.zzu), TuplesKt.a(-8, zzba.zzE), TuplesKt.a(-15, zzba.zzn), TuplesKt.a(-1, zzba.zzv), TuplesKt.a(-3, zzba.zzx), TuplesKt.a(-10, zzba.zzy));
        int i3 = Build.VERSION.SDK_INT;
        mapMutableMapOf.put(-16, zzba.zzw);
        mapMutableMapOf.put(1, zzba.zzA);
        mapMutableMapOf.put(2, zzba.zzB);
        mapMutableMapOf.put(0, zzba.zzC);
        mapMutableMapOf.put(3, zzba.zzD);
        if (i3 >= 29) {
            mapMutableMapOf.put(4, zzba.zzz);
        }
        return mapMutableMapOf;
    }
}
