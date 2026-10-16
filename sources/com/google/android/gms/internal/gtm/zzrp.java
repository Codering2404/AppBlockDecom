package com.google.android.gms.internal.gtm;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzrp {
    final Map zza;
    private final Context zzb;
    private final zzse zzc;
    private final Clock zzd;
    private final Map zze;

    public zzrp(Context context) {
        HashMap map = new HashMap();
        zzse zzseVar = new zzse(context);
        Clock clockC = DefaultClock.c();
        this.zza = new HashMap();
        this.zzb = context;
        this.zzd = clockC;
        this.zzc = zzseVar;
        this.zze = map;
    }
}
