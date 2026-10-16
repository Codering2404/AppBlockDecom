package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
@ParametersAreNonnullByDefault
public final class zzcak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcak> CREATOR = new zzcal();
    public final boolean zza;
    public final List zzb;

    public zzcak() {
        this(false, Collections.EMPTY_LIST);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        boolean z2 = this.zza;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.g(parcel, 2, z2);
        SafeParcelWriter.I(parcel, 3, this.zzb, false);
        SafeParcelWriter.b(parcel, iA);
    }

    public zzcak(boolean z2, List list) {
        this.zza = z2;
        this.zzb = list;
    }
}
