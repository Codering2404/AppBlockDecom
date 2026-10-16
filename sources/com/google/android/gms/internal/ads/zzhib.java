package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhib extends zzheu {
    private final zzhia zza;
    private final int zzb;

    private zzhib(zzhia zzhiaVar, int i3) {
        this.zza = zzhiaVar;
        this.zzb = i3;
    }

    public static zzhib zzb(zzhia zzhiaVar, int i3) throws GeneralSecurityException {
        if (i3 < 8 || i3 > 12) {
            throw new GeneralSecurityException("Salt size must be between 8 and 12 bytes");
        }
        return new zzhib(zzhiaVar, i3);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzhib)) {
            return false;
        }
        zzhib zzhibVar = (zzhib) obj;
        return zzhibVar.zza == this.zza && zzhibVar.zzb == this.zzb;
    }

    public final int hashCode() {
        return Objects.hash(zzhib.class, this.zza, Integer.valueOf(this.zzb));
    }

    public final String toString() {
        String string = this.zza.toString();
        int length = string.length();
        int i3 = this.zzb;
        StringBuilder sb = new StringBuilder(length + 48 + String.valueOf(i3).length() + 1);
        sb.append("X-AES-GCM Parameters (variant: ");
        sb.append(string);
        sb.append("salt_size_bytes: ");
        sb.append(i3);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzheh
    public final boolean zza() {
        return this.zza != zzhia.zzb;
    }

    public final zzhia zzc() {
        return this.zza;
    }

    public final int zzd() {
        return this.zzb;
    }
}
