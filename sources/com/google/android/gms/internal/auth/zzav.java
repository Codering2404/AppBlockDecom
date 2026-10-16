package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzav extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzav> CREATOR = new zzaw();
    final int zza;
    public final String zzb;
    public final int zzc;

    zzav(int i3, String str, int i4) {
        this.zza = 1;
        this.zzb = (String) Preconditions.m(str);
        this.zzc = i4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, this.zza);
        SafeParcelWriter.G(parcel, 2, this.zzb, false);
        SafeParcelWriter.u(parcel, 3, this.zzc);
        SafeParcelWriter.b(parcel, iA);
    }

    public zzav(String str, int i3) {
        this(1, str, i3);
    }
}
