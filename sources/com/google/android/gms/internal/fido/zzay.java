package com.google.android.gms.internal.fido;

import cz.mobilesoft.coreblock.scene.permission.permissions.success.lbR.YgVrd;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzay {
    private final String zza;
    private final Set zzb;
    private final boolean zzc;

    private zzay(String str, Set set, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.zza = YgVrd.gwssQOAK;
        this.zzb = set;
        this.zzc = z5;
    }

    public final zzaq zza(String str, long j3) {
        final Class<Long> cls = Long.class;
        return new zzaq(this.zza, str, Long.valueOf(j3), new zzak(false, false, false, this.zzc, false, this.zzb, new zzax() { // from class: com.google.android.gms.internal.fido.zzav
        }, new zzax(cls) { // from class: com.google.android.gms.internal.fido.zzaw
        }), true);
    }

    public final zzaq zzb(String str, String str2) {
        final Class<String> cls = String.class;
        return new zzaq(this.zza, str, str2, new zzak(false, false, false, this.zzc, false, this.zzb, new zzax() { // from class: com.google.android.gms.internal.fido.zzat
        }, new zzax(cls) { // from class: com.google.android.gms.internal.fido.zzau
        }), true);
    }

    public final zzaq zzc(String str, boolean z2) {
        Boolean boolValueOf = Boolean.valueOf(z2);
        final Class<Boolean> cls = Boolean.class;
        return new zzaq(this.zza, str, boolValueOf, new zzak(false, false, false, this.zzc, false, this.zzb, new zzax() { // from class: com.google.android.gms.internal.fido.zzar
        }, new zzax(cls) { // from class: com.google.android.gms.internal.fido.zzas
        }), true);
    }

    public final zzay zzd() {
        return new zzay(this.zza, this.zzb, false, false, false, true, false);
    }

    public final zzay zze(Set set) {
        return new zzay(this.zza, set, false, false, false, this.zzc, false);
    }

    public zzay(String str) {
        this("com.google.android.gms.fido", zzcf.zzk(), false, false, false, false, false);
    }
}
