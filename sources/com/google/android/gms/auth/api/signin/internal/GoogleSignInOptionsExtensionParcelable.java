package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class GoogleSignInOptionsExtensionParcelable extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GoogleSignInOptionsExtensionParcelable> CREATOR = new zaa();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f71230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f71231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Bundle f71232c;

    GoogleSignInOptionsExtensionParcelable(int i3, int i4, Bundle bundle) {
        this.f71230a = i3;
        this.f71231b = i4;
        this.f71232c = bundle;
    }

    public int M() {
        return this.f71231b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, this.f71230a);
        SafeParcelWriter.u(parcel, 2, M());
        SafeParcelWriter.j(parcel, 3, this.f71232c, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
