package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfyl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfyl> CREATOR = new zzfym();
    public final int zza;
    private zzaym zzb = null;
    private byte[] zzc;

    zzfyl(int i3, byte[] bArr) {
        this.zza = i3;
        this.zzc = bArr;
        zzb();
    }

    private final void zzb() {
        zzaym zzaymVar = this.zzb;
        if (zzaymVar != null || this.zzc == null) {
            if (zzaymVar == null || this.zzc != null) {
                if (zzaymVar != null && this.zzc != null) {
                    throw new IllegalStateException("Invalid internal representation - full");
                }
                if (zzaymVar != null || this.zzc != null) {
                    throw new IllegalStateException("Impossible");
                }
                throw new IllegalStateException("Invalid internal representation - empty");
            }
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i4 = this.zza;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, i4);
        byte[] bArrZzaN = this.zzc;
        if (bArrZzaN == null) {
            bArrZzaN = this.zzb.zzaN();
        }
        SafeParcelWriter.l(parcel, 2, bArrZzaN, false);
        SafeParcelWriter.b(parcel, iA);
    }

    public final zzaym zza() {
        if (this.zzb == null) {
            try {
                this.zzb = zzaym.zzi(this.zzc, zzido.zza());
                this.zzc = null;
            } catch (zziet | NullPointerException e3) {
                throw new IllegalStateException(e3);
            }
        }
        zzb();
        return this.zzb;
    }
}
