package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zax extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zax> CREATOR = new zay();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f72078a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f72079b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f72080c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Scope[] f72081d;

    zax(int i3, int i4, int i5, Scope[] scopeArr) {
        this.f72078a = i3;
        this.f72079b = i4;
        this.f72080c = i5;
        this.f72081d = scopeArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i4 = this.f72078a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, i4);
        SafeParcelWriter.u(parcel, 2, this.f72079b);
        SafeParcelWriter.u(parcel, 3, this.f72080c);
        SafeParcelWriter.J(parcel, 4, this.f72081d, i3, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
