package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zaa extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<zaa> CREATOR = new zab();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f74567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f74568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Intent f74569c;

    zaa(int i3, int i4, Intent intent) {
        this.f74567a = i3;
        this.f74568b = i4;
        this.f74569c = intent;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f74568b == 0 ? Status.f71537g : Status.f71541k;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i4 = this.f74567a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, i4);
        SafeParcelWriter.u(parcel, 2, this.f74568b);
        SafeParcelWriter.E(parcel, 3, this.f74569c, i3, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
