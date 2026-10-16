package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfyu extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfyu> CREATOR = new zzfyv();
    public final int zza;
    public final byte[] zzb;
    public final int zzc;

    zzfyu(int i3, byte[] bArr, int i4) {
        this.zza = i3;
        this.zzb = bArr == null ? null : Arrays.copyOf(bArr, bArr.length);
        this.zzc = i4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i4 = this.zza;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, i4);
        SafeParcelWriter.l(parcel, 2, this.zzb, false);
        SafeParcelWriter.u(parcel, 3, this.zzc);
        SafeParcelWriter.b(parcel, iA);
    }

    public zzfyu(byte[] bArr, int i3) {
        this(1, null, 1);
    }
}
