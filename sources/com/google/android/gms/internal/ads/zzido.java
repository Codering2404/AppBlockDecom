package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzido {
    static final zzido zza = new zzido(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc = false;
    private static volatile zzido zzd;
    private final Map zze;

    zzido() {
        this.zze = new HashMap();
    }

    public static zzido zza() {
        int i3 = zzicn.zza;
        return zza;
    }

    public static zzido zzb() {
        zzido zzidoVar = zzd;
        if (zzidoVar != null) {
            return zzidoVar;
        }
        synchronized (zzido.class) {
            try {
                zzido zzidoVar2 = zzd;
                if (zzidoVar2 != null) {
                    return zzidoVar2;
                }
                int i3 = zzicn.zza;
                zzido zzidoVarZzb = zzidw.zzb(zzido.class);
                zzd = zzidoVarZzb;
                return zzidoVarZzb;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final zziec zzc(zzifp zzifpVar, int i3) {
        return (zziec) this.zze.get(new zzidn(zzifpVar, i3));
    }

    zzido(boolean z2) {
        this.zze = Collections.EMPTY_MAP;
    }
}
