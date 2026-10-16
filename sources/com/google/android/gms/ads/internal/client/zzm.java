package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzm extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzm> CREATOR = new zzo();
    public final long A;
    public final long B;
    public final Bundle C = new Bundle();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f69964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f69965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Bundle f69966c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f69967d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f69968f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f69969g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f69970h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f69971i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f69972j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final zzft f69973k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Location f69974l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f69975m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Bundle f69976n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Bundle f69977o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final List f69978p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f69979q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f69980r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f69981s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final zzc f69982t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f69983u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f69984v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final List f69985w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f69986x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String f69987y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f69988z;

    public zzm(int i3, long j3, Bundle bundle, int i4, List list, boolean z2, int i5, boolean z3, String str, zzft zzftVar, Location location, String str2, Bundle bundle2, Bundle bundle3, List list2, String str3, String str4, boolean z4, zzc zzcVar, int i6, String str5, List list3, int i7, String str6, int i8, long j4, long j5) {
        this.f69964a = i3;
        this.f69965b = j3;
        this.f69966c = bundle == null ? new Bundle() : bundle;
        this.f69967d = i4;
        this.f69968f = list;
        this.f69969g = z2;
        this.f69970h = i5;
        this.f69971i = z3;
        this.f69972j = str;
        this.f69973k = zzftVar;
        this.f69974l = location;
        this.f69975m = str2;
        this.f69976n = bundle2 == null ? new Bundle() : bundle2;
        this.f69977o = bundle3;
        this.f69978p = list2;
        this.f69979q = str3;
        this.f69980r = str4;
        this.f69981s = z4;
        this.f69982t = zzcVar;
        this.f69983u = i6;
        this.f69984v = str5;
        this.f69985w = list3 == null ? new ArrayList() : list3;
        this.f69986x = i7;
        this.f69987y = str6;
        this.f69988z = i8;
        this.A = j4;
        this.B = j5;
    }

    public final boolean M(Object obj) {
        if (!(obj instanceof zzm)) {
            return false;
        }
        zzm zzmVar = (zzm) obj;
        return this.f69964a == zzmVar.f69964a && this.f69965b == zzmVar.f69965b && com.google.android.gms.ads.internal.util.client.zzp.a(this.f69966c, zzmVar.f69966c) && this.f69967d == zzmVar.f69967d && Objects.b(this.f69968f, zzmVar.f69968f) && this.f69969g == zzmVar.f69969g && this.f69970h == zzmVar.f69970h && this.f69971i == zzmVar.f69971i && Objects.b(this.f69972j, zzmVar.f69972j) && Objects.b(this.f69973k, zzmVar.f69973k) && Objects.b(this.f69974l, zzmVar.f69974l) && Objects.b(this.f69975m, zzmVar.f69975m) && com.google.android.gms.ads.internal.util.client.zzp.a(this.f69976n, zzmVar.f69976n) && com.google.android.gms.ads.internal.util.client.zzp.a(this.f69977o, zzmVar.f69977o) && Objects.b(this.f69978p, zzmVar.f69978p) && Objects.b(this.f69979q, zzmVar.f69979q) && Objects.b(this.f69980r, zzmVar.f69980r) && this.f69981s == zzmVar.f69981s && this.f69983u == zzmVar.f69983u && Objects.b(this.f69984v, zzmVar.f69984v) && Objects.b(this.f69985w, zzmVar.f69985w) && this.f69986x == zzmVar.f69986x && Objects.b(this.f69987y, zzmVar.f69987y) && this.f69988z == zzmVar.f69988z;
    }

    public final boolean N() {
        return zzc() || zzd();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzm) {
            return M(obj) && this.A == ((zzm) obj).A;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.c(Integer.valueOf(this.f69964a), Long.valueOf(this.f69965b), this.f69966c, Integer.valueOf(this.f69967d), this.f69968f, Boolean.valueOf(this.f69969g), Integer.valueOf(this.f69970h), Boolean.valueOf(this.f69971i), this.f69972j, this.f69973k, this.f69974l, this.f69975m, this.f69976n, this.f69977o, this.f69978p, this.f69979q, this.f69980r, Boolean.valueOf(this.f69981s), Integer.valueOf(this.f69983u), this.f69984v, this.f69985w, Integer.valueOf(this.f69986x), this.f69987y, Integer.valueOf(this.f69988z), Long.valueOf(this.A), Long.valueOf(this.B));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i4 = this.f69964a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, i4);
        SafeParcelWriter.z(parcel, 2, this.f69965b);
        SafeParcelWriter.j(parcel, 3, this.f69966c, false);
        SafeParcelWriter.u(parcel, 4, this.f69967d);
        SafeParcelWriter.I(parcel, 5, this.f69968f, false);
        SafeParcelWriter.g(parcel, 6, this.f69969g);
        SafeParcelWriter.u(parcel, 7, this.f69970h);
        SafeParcelWriter.g(parcel, 8, this.f69971i);
        SafeParcelWriter.G(parcel, 9, this.f69972j, false);
        SafeParcelWriter.E(parcel, 10, this.f69973k, i3, false);
        SafeParcelWriter.E(parcel, 11, this.f69974l, i3, false);
        SafeParcelWriter.G(parcel, 12, this.f69975m, false);
        SafeParcelWriter.j(parcel, 13, this.f69976n, false);
        SafeParcelWriter.j(parcel, 14, this.f69977o, false);
        SafeParcelWriter.I(parcel, 15, this.f69978p, false);
        SafeParcelWriter.G(parcel, 16, this.f69979q, false);
        SafeParcelWriter.G(parcel, 17, this.f69980r, false);
        SafeParcelWriter.g(parcel, 18, this.f69981s);
        SafeParcelWriter.E(parcel, 19, this.f69982t, i3, false);
        SafeParcelWriter.u(parcel, 20, this.f69983u);
        SafeParcelWriter.G(parcel, 21, this.f69984v, false);
        SafeParcelWriter.I(parcel, 22, this.f69985w, false);
        SafeParcelWriter.u(parcel, 23, this.f69986x);
        SafeParcelWriter.G(parcel, 24, this.f69987y, false);
        SafeParcelWriter.u(parcel, 25, this.f69988z);
        SafeParcelWriter.z(parcel, 26, this.A);
        SafeParcelWriter.z(parcel, 27, this.B);
        SafeParcelWriter.b(parcel, iA);
    }

    public final boolean zzc() {
        return this.f69966c.getBoolean("is_sdk_preload", false);
    }

    public final boolean zzd() {
        return this.f69966c.getBoolean("zenith_v2", false);
    }
}
