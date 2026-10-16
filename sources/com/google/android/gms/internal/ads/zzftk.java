package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdFormat;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzftk {
    private final String zza;
    private final AdFormat zzb;
    private final String zzc;

    /* synthetic */ zzftk(zzftj zzftjVar, byte[] bArr) {
        this.zza = zzftjVar.zzb();
        this.zzb = zzftjVar.zzc();
        this.zzc = zzftjVar.zzd();
    }

    public final boolean equals(Object obj) {
        AdFormat adFormat;
        AdFormat adFormat2;
        if (obj instanceof zzftk) {
            zzftk zzftkVar = (zzftk) obj;
            if (this.zza.equals(zzftkVar.zza) && (adFormat = this.zzb) != null && (adFormat2 = zzftkVar.zzb) != null && adFormat.equals(adFormat2)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.zza, this.zzb);
    }

    public final String zza() {
        return this.zza;
    }

    public final String zzb() {
        AdFormat adFormat = this.zzb;
        return adFormat == null ? "unknown" : adFormat.name().toLowerCase(Locale.ENGLISH);
    }

    public final String zzc() {
        return this.zzc;
    }
}
