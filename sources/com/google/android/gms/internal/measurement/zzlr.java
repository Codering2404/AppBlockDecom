package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzlr {
    static final zzlr zza = new zzlr(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc = false;
    private static volatile zzlr zzd;
    private final Map zze;

    zzlr() {
        this.zze = new HashMap();
    }

    public static zzlr zza() {
        zzlr zzlrVar = zzd;
        if (zzlrVar != null) {
            return zzlrVar;
        }
        synchronized (zzlr.class) {
            try {
                zzlr zzlrVar2 = zzd;
                if (zzlrVar2 != null) {
                    return zzlrVar2;
                }
                int i3 = zznu.zza;
                zzlr zzlrVarZzb = zzlz.zzb(zzlr.class);
                zzd = zzlrVarZzb;
                return zzlrVarZzb;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final zzme zzb(zznm zznmVar, int i3) {
        return (zzme) this.zze.get(new zzlq(zznmVar, i3));
    }

    zzlr(boolean z2) {
        this.zze = Collections.EMPTY_MAP;
    }
}
