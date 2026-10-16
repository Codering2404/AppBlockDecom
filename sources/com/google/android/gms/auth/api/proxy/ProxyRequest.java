package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ProxyRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ProxyRequest> CREATOR = new zza();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f71160h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f71161i = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f71162j = 2;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f71163k = 3;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f71164l = 4;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f71165m = 5;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f71166n = 6;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f71167o = 7;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f71168p = 7;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f71169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f71170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f71171c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f71172d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f71173f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final Bundle f71174g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder {
    }

    ProxyRequest(int i3, String str, int i4, long j3, byte[] bArr, Bundle bundle) {
        this.f71173f = i3;
        this.f71169a = str;
        this.f71170b = i4;
        this.f71171c = j3;
        this.f71172d = bArr;
        this.f71174g = bundle;
    }

    public String toString() {
        return "ProxyRequest[ url: " + this.f71169a + ", method: " + this.f71170b + " ]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 1, this.f71169a, false);
        SafeParcelWriter.u(parcel, 2, this.f71170b);
        SafeParcelWriter.z(parcel, 3, this.f71171c);
        SafeParcelWriter.l(parcel, 4, this.f71172d, false);
        SafeParcelWriter.j(parcel, 5, this.f71174g, false);
        SafeParcelWriter.u(parcel, 1000, this.f71173f);
        SafeParcelWriter.b(parcel, iA);
    }
}
