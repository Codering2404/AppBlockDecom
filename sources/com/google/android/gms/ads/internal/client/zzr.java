package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzr> CREATOR = new zzs();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f70004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f70005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f70006c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f70007d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f70008f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f70009g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final zzr[] f70010h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f70011i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f70012j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f70013k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f70014l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f70015m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f70016n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f70017o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f70018p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f70019q;

    public zzr() {
        this("interstitial_mb", 0, 0, true, 0, 0, null, false, false, false, false, false, false, false, false, false);
    }

    public static int M(DisplayMetrics displayMetrics) {
        return (int) (j0(displayMetrics) * displayMetrics.density);
    }

    public static zzr N() {
        return new zzr("320x50_mb", 0, 0, false, 0, 0, null, true, false, false, false, false, false, false, false, false);
    }

    public static zzr O() {
        return new zzr("reward_mb", 0, 0, true, 0, 0, null, false, false, false, false, false, false, false, false, false);
    }

    public static zzr g0() {
        return new zzr("interstitial_mb", 0, 0, false, 0, 0, null, false, false, false, false, true, false, false, false, false);
    }

    private static int j0(DisplayMetrics displayMetrics) {
        int i3 = (int) (displayMetrics.heightPixels / displayMetrics.density);
        if (i3 <= 400) {
            return 32;
        }
        return i3 <= 720 ? 50 : 90;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        String str = this.f70004a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 2, str, false);
        SafeParcelWriter.u(parcel, 3, this.f70005b);
        SafeParcelWriter.u(parcel, 4, this.f70006c);
        SafeParcelWriter.g(parcel, 5, this.f70007d);
        SafeParcelWriter.u(parcel, 6, this.f70008f);
        SafeParcelWriter.u(parcel, 7, this.f70009g);
        SafeParcelWriter.J(parcel, 8, this.f70010h, i3, false);
        SafeParcelWriter.g(parcel, 9, this.f70011i);
        SafeParcelWriter.g(parcel, 10, this.f70012j);
        SafeParcelWriter.g(parcel, 11, this.f70013k);
        SafeParcelWriter.g(parcel, 12, this.f70014l);
        SafeParcelWriter.g(parcel, 13, this.f70015m);
        SafeParcelWriter.g(parcel, 14, this.f70016n);
        SafeParcelWriter.g(parcel, 15, this.f70017o);
        SafeParcelWriter.g(parcel, 16, this.f70018p);
        SafeParcelWriter.g(parcel, 17, this.f70019q);
        SafeParcelWriter.b(parcel, iA);
    }

    public zzr(Context context, AdSize adSize) {
        this(context, new AdSize[]{adSize});
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public zzr(android.content.Context r13, com.google.android.gms.ads.AdSize[] r14) {
        /*
            Method dump skipped, instruction units count: 449
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzr.<init>(android.content.Context, com.google.android.gms.ads.AdSize[]):void");
    }

    zzr(String str, int i3, int i4, boolean z2, int i5, int i6, zzr[] zzrVarArr, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11) {
        this.f70004a = str;
        this.f70005b = i3;
        this.f70006c = i4;
        this.f70007d = z2;
        this.f70008f = i5;
        this.f70009g = i6;
        this.f70010h = zzrVarArr;
        this.f70011i = z3;
        this.f70012j = z4;
        this.f70013k = z5;
        this.f70014l = z6;
        this.f70015m = z7;
        this.f70016n = z8;
        this.f70017o = z9;
        this.f70018p = z10;
        this.f70019q = z11;
    }
}
