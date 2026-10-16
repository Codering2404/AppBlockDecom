package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zav extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zav> CREATOR = new zaw();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f72073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final IBinder f72074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ConnectionResult f72075c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f72076d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f72077f;

    zav(int i3, IBinder iBinder, ConnectionResult connectionResult, boolean z2, boolean z3) {
        this.f72073a = i3;
        this.f72074b = iBinder;
        this.f72075c = connectionResult;
        this.f72076d = z2;
        this.f72077f = z3;
    }

    public final ConnectionResult M() {
        return this.f72075c;
    }

    public final IAccountAccessor N() {
        IBinder iBinder = this.f72074b;
        if (iBinder == null) {
            return null;
        }
        return IAccountAccessor.Stub.x3(iBinder);
    }

    public final boolean O() {
        return this.f72076d;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zav)) {
            return false;
        }
        zav zavVar = (zav) obj;
        return this.f72075c.equals(zavVar.f72075c) && Objects.b(N(), zavVar.N());
    }

    public final boolean g0() {
        return this.f72077f;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, this.f72073a);
        SafeParcelWriter.t(parcel, 2, this.f72074b, false);
        SafeParcelWriter.E(parcel, 3, this.f72075c, i3, false);
        SafeParcelWriter.g(parcel, 4, this.f72076d);
        SafeParcelWriter.g(parcel, 5, this.f72077f);
        SafeParcelWriter.b(parcel, iA);
    }
}
