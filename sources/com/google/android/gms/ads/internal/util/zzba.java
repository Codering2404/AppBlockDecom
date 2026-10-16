package com.google.android.gms.ads.internal.util;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.ads.zzfma;
import com.google.android.gms.internal.ads.zzgua;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzba extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzba> CREATOR = new zzbb();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f70263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f70264b;

    zzba(String str, int i3) {
        this.f70263a = str == null ? "" : str;
        this.f70264b = i3;
    }

    public static zzba M(Throwable th) {
        com.google.android.gms.ads.internal.client.zze zzeVarZza = zzfma.zza(th);
        return new zzba(zzgua.zzc(th.getMessage()) ? zzeVarZza.f69852b : th.getMessage(), zzeVarZza.f69851a);
    }

    public final zzaz N() {
        return new zzaz(this.f70263a, this.f70264b);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        String str = this.f70263a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 1, str, false);
        SafeParcelWriter.u(parcel, 2, this.f70264b);
        SafeParcelWriter.b(parcel, iA);
    }
}
