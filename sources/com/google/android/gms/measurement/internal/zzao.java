package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzao extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzao> CREATOR = new zzap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f73415a;

    public zzao(Bundle bundle) {
        this.f73415a = bundle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        Bundle bundle = this.f73415a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.j(parcel, 1, bundle, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
