package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbrc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbrc> CREATOR = new zzbrd();
    public final String zza;
    public final String[] zzb;
    public final String[] zzc;

    zzbrc(String str, String[] strArr, String[] strArr2) {
        this.zza = str;
        this.zzb = strArr;
        this.zzc = strArr2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        String str = this.zza;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 1, str, false);
        SafeParcelWriter.H(parcel, 2, this.zzb, false);
        SafeParcelWriter.H(parcel, 3, this.zzc, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
