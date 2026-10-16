package com.google.android.gms.internal.fido;

import java.io.Serializable;
import java.util.Arrays;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbs implements Serializable, zzbp {
    final Object zza;

    zzbs(Object obj) {
        this.zza = obj;
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof zzbs) {
            return zzbk.zza(this.zza, ((zzbs) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza});
    }

    public final String toString() {
        return "Suppliers.ofInstance(" + this.zza.toString() + ")";
    }

    @Override // com.google.android.gms.internal.fido.zzbp
    public final Object zza() {
        return this.zza;
    }
}
