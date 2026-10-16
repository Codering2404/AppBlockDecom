package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcbw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcbw> CREATOR = new zzcbx();
    public final com.google.android.gms.ads.internal.client.zzm zza;
    public final String zzb;

    public zzcbw(com.google.android.gms.ads.internal.client.zzm zzmVar, String str) {
        this.zza = zzmVar;
        this.zzb = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        com.google.android.gms.ads.internal.client.zzm zzmVar = this.zza;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.E(parcel, 2, zzmVar, i3, false);
        SafeParcelWriter.G(parcel, 3, this.zzb, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
