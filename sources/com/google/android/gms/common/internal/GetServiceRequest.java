package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class GetServiceRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new zzm();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    static final Scope[] f71974p = new Scope[0];

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    static final Feature[] f71975q = new Feature[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f71976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f71977b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f71978c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    String f71979d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    IBinder f71980f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Scope[] f71981g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Bundle f71982h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Account f71983i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Feature[] f71984j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    Feature[] f71985k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final boolean f71986l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final int f71987m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    boolean f71988n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final String f71989o;

    GetServiceRequest(int i3, int i4, int i5, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, Feature[] featureArr, Feature[] featureArr2, boolean z2, int i6, boolean z3, String str2) {
        scopeArr = scopeArr == null ? f71974p : scopeArr;
        bundle = bundle == null ? new Bundle() : bundle;
        featureArr = featureArr == null ? f71975q : featureArr;
        featureArr2 = featureArr2 == null ? f71975q : featureArr2;
        this.f71976a = i3;
        this.f71977b = i4;
        this.f71978c = i5;
        if ("com.google.android.gms".equals(str)) {
            this.f71979d = "com.google.android.gms";
        } else {
            this.f71979d = str;
        }
        if (i3 < 2) {
            this.f71983i = iBinder != null ? AccountAccessor.h5(IAccountAccessor.Stub.x3(iBinder)) : null;
        } else {
            this.f71980f = iBinder;
            this.f71983i = account;
        }
        this.f71981g = scopeArr;
        this.f71982h = bundle;
        this.f71984j = featureArr;
        this.f71985k = featureArr2;
        this.f71986l = z2;
        this.f71987m = i6;
        this.f71988n = z3;
        this.f71989o = str2;
    }

    public String M() {
        return this.f71989o;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        zzm.a(this, parcel, i3);
    }
}
