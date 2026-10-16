package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbrp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbrp> CREATOR = new zzbrq();
    public final String zza;
    public final boolean zzb;
    public final int zzc;
    public final String zzd;

    public zzbrp(String str, boolean z2, int i3, String str2) {
        this.zza = str;
        this.zzb = z2;
        this.zzc = i3;
        this.zzd = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        String str = this.zza;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 1, str, false);
        SafeParcelWriter.g(parcel, 2, this.zzb);
        SafeParcelWriter.u(parcel, 3, this.zzc);
        SafeParcelWriter.G(parcel, 4, this.zzd, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
