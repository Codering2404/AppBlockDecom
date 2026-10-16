package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzr> CREATOR = new zzs();
    public final int A;
    public final long B;
    public final String C;
    public final String D;
    public final long E;
    public final int F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f74500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f74501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f74502c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f74503d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f74504f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f74505g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f74506h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f74507i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f74508j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f74509k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f74510l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f74511m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f74512n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f74513o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f74514p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Boolean f74515q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final long f74516r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final List f74517s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f74518t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f74519u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f74520v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f74521w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final long f74522x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f74523y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final String f74524z;

    zzr(String str, String str2, String str3, long j3, String str4, long j4, long j5, String str5, boolean z2, boolean z3, String str6, long j6, int i3, boolean z4, boolean z5, Boolean bool, long j7, List list, String str7, String str8, String str9, boolean z6, long j8, int i4, String str10, int i5, long j9, String str11, String str12, long j10, int i6) {
        Preconditions.g(str);
        this.f74500a = str;
        this.f74501b = true == TextUtils.isEmpty(str2) ? null : str2;
        this.f74502c = str3;
        this.f74509k = j3;
        this.f74503d = str4;
        this.f74504f = j4;
        this.f74505g = j5;
        this.f74506h = str5;
        this.f74507i = z2;
        this.f74508j = z3;
        this.f74510l = str6;
        this.f74511m = j6;
        this.f74512n = i3;
        this.f74513o = z4;
        this.f74514p = z5;
        this.f74515q = bool;
        this.f74516r = j7;
        this.f74517s = list;
        this.f74518t = str7;
        this.f74519u = str8;
        this.f74520v = str9;
        this.f74521w = z6;
        this.f74522x = j8;
        this.f74523y = i4;
        this.f74524z = str10;
        this.A = i5;
        this.B = j9;
        this.C = str11;
        this.D = str12;
        this.E = j10;
        this.F = i6;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        String str = this.f74500a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 2, str, false);
        SafeParcelWriter.G(parcel, 3, this.f74501b, false);
        SafeParcelWriter.G(parcel, 4, this.f74502c, false);
        SafeParcelWriter.G(parcel, 5, this.f74503d, false);
        SafeParcelWriter.z(parcel, 6, this.f74504f);
        SafeParcelWriter.z(parcel, 7, this.f74505g);
        SafeParcelWriter.G(parcel, 8, this.f74506h, false);
        SafeParcelWriter.g(parcel, 9, this.f74507i);
        SafeParcelWriter.g(parcel, 10, this.f74508j);
        SafeParcelWriter.z(parcel, 11, this.f74509k);
        SafeParcelWriter.G(parcel, 12, this.f74510l, false);
        SafeParcelWriter.z(parcel, 14, this.f74511m);
        SafeParcelWriter.u(parcel, 15, this.f74512n);
        SafeParcelWriter.g(parcel, 16, this.f74513o);
        SafeParcelWriter.g(parcel, 18, this.f74514p);
        SafeParcelWriter.i(parcel, 21, this.f74515q, false);
        SafeParcelWriter.z(parcel, 22, this.f74516r);
        SafeParcelWriter.I(parcel, 23, this.f74517s, false);
        SafeParcelWriter.G(parcel, 25, this.f74518t, false);
        SafeParcelWriter.G(parcel, 26, this.f74519u, false);
        SafeParcelWriter.G(parcel, 27, this.f74520v, false);
        SafeParcelWriter.g(parcel, 28, this.f74521w);
        SafeParcelWriter.z(parcel, 29, this.f74522x);
        SafeParcelWriter.u(parcel, 30, this.f74523y);
        SafeParcelWriter.G(parcel, 31, this.f74524z, false);
        SafeParcelWriter.u(parcel, 32, this.A);
        SafeParcelWriter.z(parcel, 34, this.B);
        SafeParcelWriter.G(parcel, 35, this.C, false);
        SafeParcelWriter.G(parcel, 36, this.D, false);
        SafeParcelWriter.z(parcel, 37, this.E);
        SafeParcelWriter.u(parcel, 38, this.F);
        SafeParcelWriter.b(parcel, iA);
    }

    zzr(String str, String str2, String str3, String str4, long j3, long j4, String str5, boolean z2, boolean z3, long j5, String str6, long j6, int i3, boolean z4, boolean z5, Boolean bool, long j7, List list, String str7, String str8, String str9, boolean z6, long j8, int i4, String str10, int i5, long j9, String str11, String str12, long j10, int i6) {
        this.f74500a = str;
        this.f74501b = str2;
        this.f74502c = str3;
        this.f74509k = j5;
        this.f74503d = str4;
        this.f74504f = j3;
        this.f74505g = j4;
        this.f74506h = str5;
        this.f74507i = z2;
        this.f74508j = z3;
        this.f74510l = str6;
        this.f74511m = j6;
        this.f74512n = i3;
        this.f74513o = z4;
        this.f74514p = z5;
        this.f74515q = bool;
        this.f74516r = j7;
        this.f74517s = list;
        this.f74518t = str7;
        this.f74519u = str8;
        this.f74520v = str9;
        this.f74521w = z6;
        this.f74522x = j8;
        this.f74523y = i4;
        this.f74524z = str10;
        this.A = i5;
        this.B = j9;
        this.C = str11;
        this.D = str12;
        this.E = j10;
        this.F = i6;
    }
}
