package com.google.android.gms.internal.fido;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhh extends zzhp {
    private final boolean zza;

    zzhh(boolean z2) {
        this.zza = z2;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        zzhp zzhpVar = (zzhp) obj;
        if (zzhp.zzd((byte) -32) != zzhpVar.zza()) {
            return zzhp.zzd((byte) -32) - zzhpVar.zza();
        }
        return (true != this.zza ? 20 : 21) - (true != ((zzhh) zzhpVar).zza ? 20 : 21);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && zzhh.class == obj.getClass() && this.zza == ((zzhh) obj).zza;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(zzhp.zzd((byte) -32)), Boolean.valueOf(this.zza)});
    }

    public final String toString() {
        return Boolean.toString(this.zza);
    }

    @Override // com.google.android.gms.internal.fido.zzhp
    protected final int zza() {
        return zzhp.zzd((byte) -32);
    }
}
