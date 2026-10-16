package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public final class zzx extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzx> CREATOR = new zzy();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f70032a;

    public zzx(int i3) {
        this.f70032a = i3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i4 = this.f70032a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 2, i4);
        SafeParcelWriter.b(parcel, iA);
    }
}
