package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.zat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zai extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zai> CREATOR = new zaj();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f74572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final zat f74573b;

    zai(int i3, zat zatVar) {
        this.f74572a = i3;
        this.f74573b = zatVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, this.f74572a);
        SafeParcelWriter.E(parcel, 2, this.f74573b, i3, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
