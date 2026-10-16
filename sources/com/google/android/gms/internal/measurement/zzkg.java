package com.google.android.gms.internal.measurement;

import android.net.Uri;
import com.google.common.base.Function;
import d.qFm.sECyKyO;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzkg {

    @Nullable
    final Uri zza;
    final String zzb;
    final String zzc;
    final boolean zzd;
    final boolean zze;

    private zzkg(@Nullable String str, @Nullable Uri uri, String str2, String str3, boolean z2, boolean z3, boolean z4, boolean z5, @Nullable Function function) {
        this.zza = uri;
        this.zzb = "";
        this.zzc = "";
        this.zzd = z2;
        this.zze = z4;
    }

    public final zzkg zza() {
        String str = this.zzb;
        if (str.isEmpty()) {
            return new zzkg(null, this.zza, str, this.zzc, true, false, this.zze, false, null);
        }
        throw new IllegalStateException("Cannot set GServices prefix and skip GServices");
    }

    public final zzkg zzb() {
        return new zzkg(null, this.zza, this.zzb, this.zzc, this.zzd, false, true, false, null);
    }

    public final zzkm zzc(String str, long j3) {
        Long lValueOf = Long.valueOf(j3);
        int i3 = zzkm.zzc;
        return new zzkc(this, str, lValueOf, true);
    }

    public final zzkm zzd(String str, boolean z2) {
        Boolean boolValueOf = Boolean.valueOf(z2);
        int i3 = zzkm.zzc;
        return new zzkd(this, str, boolValueOf, true);
    }

    public final zzkm zze(String str, double d3) {
        Double dValueOf = Double.valueOf(-3.0d);
        int i3 = zzkm.zzc;
        return new zzke(this, "measurement.test.double_flag", dValueOf, true);
    }

    public final zzkm zzf(String str, String str2) {
        int i3 = zzkm.zzc;
        return new zzkf(this, str, str2, true);
    }

    public zzkg(Uri uri) {
        this(null, uri, sECyKyO.dydVthwTT, sECyKyO.dydVthwTT, false, false, false, false, null);
    }
}
