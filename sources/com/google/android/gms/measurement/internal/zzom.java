package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzom extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzom> CREATOR = new zzon();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f74389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f74390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f74391c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Bundle f74392d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f74393f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f74394g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f74395h;

    zzom(long j3, byte[] bArr, String str, Bundle bundle, int i3, long j4, String str2) {
        this.f74389a = j3;
        this.f74390b = bArr;
        this.f74391c = str;
        this.f74392d = bundle;
        this.f74393f = i3;
        this.f74394g = j4;
        this.f74395h = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        long j3 = this.f74389a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.z(parcel, 1, j3);
        SafeParcelWriter.l(parcel, 2, this.f74390b, false);
        SafeParcelWriter.G(parcel, 3, this.f74391c, false);
        SafeParcelWriter.j(parcel, 4, this.f74392d, false);
        SafeParcelWriter.u(parcel, 5, this.f74393f);
        SafeParcelWriter.z(parcel, 6, this.f74394g);
        SafeParcelWriter.G(parcel, 7, this.f74395h, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
