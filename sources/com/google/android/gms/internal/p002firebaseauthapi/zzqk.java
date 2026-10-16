package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzqk {
    private final Class<? extends zzqf> zza;
    private final zzaaj zzb;

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzqk)) {
            return false;
        }
        zzqk zzqkVar = (zzqk) obj;
        return zzqkVar.zza.equals(this.zza) && zzqkVar.zzb.equals(this.zzb);
    }

    public final int hashCode() {
        return Objects.hash(this.zza, this.zzb);
    }

    public final String toString() {
        return this.zza.getSimpleName() + ", object identifier: " + String.valueOf(this.zzb);
    }

    private zzqk(Class<? extends zzqf> cls, zzaaj zzaajVar) {
        this.zza = cls;
        this.zzb = zzaajVar;
    }
}
