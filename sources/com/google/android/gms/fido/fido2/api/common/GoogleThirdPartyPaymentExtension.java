package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class GoogleThirdPartyPaymentExtension extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GoogleThirdPartyPaymentExtension> CREATOR = new zzaf();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f72535a;

    public GoogleThirdPartyPaymentExtension(boolean z2) {
        this.f72535a = z2;
    }

    public boolean M() {
        return this.f72535a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof GoogleThirdPartyPaymentExtension) && this.f72535a == ((GoogleThirdPartyPaymentExtension) obj).M();
    }

    public int hashCode() {
        return Objects.c(Boolean.valueOf(this.f72535a));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.g(parcel, 1, M());
        SafeParcelWriter.b(parcel, iA);
    }
}
