package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.VersionInfo;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
@ParametersAreNonnullByDefault
public final class zzbxq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbxq> CREATOR = new zzbxr();
    public final int zza;
    public final int zzb;
    public final int zzc;

    zzbxq(int i3, int i4, int i5) {
        this.zza = i3;
        this.zzb = i4;
        this.zzc = i5;
    }

    public static zzbxq zza(VersionInfo versionInfo) {
        return new zzbxq(versionInfo.a(), versionInfo.c(), versionInfo.b());
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzbxq)) {
            zzbxq zzbxqVar = (zzbxq) obj;
            if (zzbxqVar.zzc == this.zzc && zzbxqVar.zzb == this.zzb && zzbxqVar.zza == this.zza) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new int[]{this.zza, this.zzb, this.zzc});
    }

    public final String toString() {
        int i3 = this.zza;
        int length = String.valueOf(i3).length();
        int i4 = this.zzb;
        int length2 = String.valueOf(i4).length();
        int i5 = this.zzc;
        StringBuilder sb = new StringBuilder(length + 1 + length2 + 1 + String.valueOf(i5).length());
        sb.append(i3);
        sb.append(".");
        sb.append(i4);
        sb.append(".");
        sb.append(i5);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i4 = this.zza;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, i4);
        SafeParcelWriter.u(parcel, 2, this.zzb);
        SafeParcelWriter.u(parcel, 3, this.zzc);
        SafeParcelWriter.b(parcel, iA);
    }
}
