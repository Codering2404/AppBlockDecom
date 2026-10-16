package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaf> CREATOR = new zzag();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f73383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f73384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f73385c;

    zzaf(long j3, int i3, long j4) {
        this.f73383a = j3;
        this.f73384b = i3;
        this.f73385c = j4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        long j3 = this.f73383a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.z(parcel, 1, j3);
        SafeParcelWriter.u(parcel, 2, this.f73384b);
        SafeParcelWriter.z(parcel, 3, this.f73385c);
        SafeParcelWriter.b(parcel, iA);
    }
}
