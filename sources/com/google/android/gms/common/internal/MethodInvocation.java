package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class MethodInvocation extends AbstractSafeParcelable {
    public static final Parcelable.Creator<MethodInvocation> CREATOR = new zan();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f72001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f72002b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f72003c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f72004d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f72005f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f72006g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f72007h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f72008i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f72009j;

    public MethodInvocation(int i3, int i4, int i5, long j3, long j4, String str, String str2, int i6, int i7) {
        this.f72001a = i3;
        this.f72002b = i4;
        this.f72003c = i5;
        this.f72004d = j3;
        this.f72005f = j4;
        this.f72006g = str;
        this.f72007h = str2;
        this.f72008i = i6;
        this.f72009j = i7;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i4 = this.f72001a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, i4);
        SafeParcelWriter.u(parcel, 2, this.f72002b);
        SafeParcelWriter.u(parcel, 3, this.f72003c);
        SafeParcelWriter.z(parcel, 4, this.f72004d);
        SafeParcelWriter.z(parcel, 5, this.f72005f);
        SafeParcelWriter.G(parcel, 6, this.f72006g, false);
        SafeParcelWriter.G(parcel, 7, this.f72007h, false);
        SafeParcelWriter.u(parcel, 8, this.f72008i);
        SafeParcelWriter.u(parcel, 9, this.f72009j);
        SafeParcelWriter.b(parcel, iA);
    }
}
