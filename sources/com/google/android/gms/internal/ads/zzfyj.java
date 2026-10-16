package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfyj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfyj> CREATOR = new zzfyk();
    public final int zza;
    public final String zzb;
    public final String zzc;

    zzfyj(int i3, String str, String str2) {
        this.zza = i3;
        this.zzb = str;
        this.zzc = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i4 = this.zza;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, i4);
        SafeParcelWriter.G(parcel, 2, this.zzb, false);
        SafeParcelWriter.G(parcel, 3, this.zzc, false);
        SafeParcelWriter.b(parcel, iA);
    }

    public zzfyj(String str, String str2) {
        this(1, str, str2);
    }
}
