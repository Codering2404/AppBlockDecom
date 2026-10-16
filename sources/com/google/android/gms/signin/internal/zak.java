package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.zav;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zak> CREATOR = new zal();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f74574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConnectionResult f74575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zav f74576c;

    zak(int i3, ConnectionResult connectionResult, zav zavVar) {
        this.f74574a = i3;
        this.f74575b = connectionResult;
        this.f74576c = zavVar;
    }

    public final ConnectionResult M() {
        return this.f74575b;
    }

    public final zav N() {
        return this.f74576c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, this.f74574a);
        SafeParcelWriter.E(parcel, 2, this.f74575b, i3, false);
        SafeParcelWriter.E(parcel, 3, this.f74576c, i3, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
