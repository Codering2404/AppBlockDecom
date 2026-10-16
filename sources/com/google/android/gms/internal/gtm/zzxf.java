package com.google.android.gms.internal.gtm;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class zzxf {
    static final zzxf zza = new zzxf(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc = false;
    private static volatile zzxf zzd;
    private final Map zze;

    zzxf() {
        this.zze = new HashMap();
    }

    public static zzxf zza() {
        zzxf zzxfVar = zzd;
        if (zzxfVar != null) {
            return zzxfVar;
        }
        synchronized (zzxf.class) {
            try {
                zzxf zzxfVar2 = zzd;
                if (zzxfVar2 != null) {
                    return zzxfVar2;
                }
                zzxf zzxfVarZzb = zzxn.zzb(zzxf.class);
                zzd = zzxfVarZzb;
                return zzxfVarZzb;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public zzxt zzb(zzzg zzzgVar, int i3) {
        return (zzxt) this.zze.get(new zzxe(zzzgVar, i3));
    }

    zzxf(boolean z2) {
        this.zze = Collections.EMPTY_MAP;
    }
}
