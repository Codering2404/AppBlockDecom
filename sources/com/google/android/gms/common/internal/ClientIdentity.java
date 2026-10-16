package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ClientIdentity extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ClientIdentity> CREATOR = new zaa();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f71950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f71951b;

    public ClientIdentity(int i3, String str) {
        this.f71950a = i3;
        this.f71951b = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ClientIdentity)) {
            return false;
        }
        ClientIdentity clientIdentity = (ClientIdentity) obj;
        return clientIdentity.f71950a == this.f71950a && Objects.b(clientIdentity.f71951b, this.f71951b);
    }

    public final int hashCode() {
        return this.f71950a;
    }

    public final String toString() {
        return this.f71950a + com.revenuecat.purchases.common.Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + this.f71951b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i4 = this.f71950a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, i4);
        SafeParcelWriter.G(parcel, 2, this.f71951b, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
