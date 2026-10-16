package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new zzk();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Bundle f72106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Feature[] f72107b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f72108c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ConnectionTelemetryConfiguration f72109d;

    zzj(Bundle bundle, Feature[] featureArr, int i3, ConnectionTelemetryConfiguration connectionTelemetryConfiguration) {
        this.f72106a = bundle;
        this.f72107b = featureArr;
        this.f72108c = i3;
        this.f72109d = connectionTelemetryConfiguration;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.j(parcel, 1, this.f72106a, false);
        SafeParcelWriter.J(parcel, 2, this.f72107b, i3, false);
        SafeParcelWriter.u(parcel, 3, this.f72108c);
        SafeParcelWriter.E(parcel, 4, this.f72109d, i3, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
