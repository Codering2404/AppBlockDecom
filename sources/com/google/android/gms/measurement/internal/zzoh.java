package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzoh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzoh> CREATOR = new zzoi();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f74381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f74382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f74383c;

    zzoh(String str, long j3, int i3) {
        this.f74381a = str;
        this.f74382b = j3;
        this.f74383c = i3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        String str = this.f74381a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 1, str, false);
        SafeParcelWriter.z(parcel, 2, this.f74382b);
        SafeParcelWriter.u(parcel, 3, this.f74383c);
        SafeParcelWriter.b(parcel, iA);
    }
}
