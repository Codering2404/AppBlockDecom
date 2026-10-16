package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzl> CREATOR = new zzm();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f70422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f70423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f70424c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f70425d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f70426f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f70427g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f70428h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f70429i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f70430j;

    zzl(boolean z2, boolean z3, String str, boolean z4, float f3, int i3, boolean z5, boolean z6, boolean z7) {
        this.f70422a = z2;
        this.f70423b = z3;
        this.f70424c = str;
        this.f70425d = z4;
        this.f70426f = f3;
        this.f70427g = i3;
        this.f70428h = z5;
        this.f70429i = z6;
        this.f70430j = z7;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        boolean z2 = this.f70422a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.g(parcel, 2, z2);
        SafeParcelWriter.g(parcel, 3, this.f70423b);
        SafeParcelWriter.G(parcel, 4, this.f70424c, false);
        SafeParcelWriter.g(parcel, 5, this.f70425d);
        SafeParcelWriter.q(parcel, 6, this.f70426f);
        SafeParcelWriter.u(parcel, 7, this.f70427g);
        SafeParcelWriter.g(parcel, 8, this.f70428h);
        SafeParcelWriter.g(parcel, 9, this.f70429i);
        SafeParcelWriter.g(parcel, 10, this.f70430j);
        SafeParcelWriter.b(parcel, iA);
    }

    public zzl(boolean z2, boolean z3, boolean z4, float f3, int i3, boolean z5, boolean z6, boolean z7) {
        this(z2, z3, null, z4, f3, -1, z5, z6, z7);
    }
}
