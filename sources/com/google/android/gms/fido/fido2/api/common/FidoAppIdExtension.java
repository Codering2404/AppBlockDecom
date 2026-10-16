package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class FidoAppIdExtension extends AbstractSafeParcelable {
    public static final Parcelable.Creator<FidoAppIdExtension> CREATOR = new zzx();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f72525a;

    public FidoAppIdExtension(String str) {
        this.f72525a = (String) Preconditions.m(str);
    }

    public String M() {
        return this.f72525a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof FidoAppIdExtension) {
            return this.f72525a.equals(((FidoAppIdExtension) obj).f72525a);
        }
        return false;
    }

    public int hashCode() {
        return Objects.c(this.f72525a);
    }

    public final String toString() {
        return "FidoAppIdExtension{appid='" + this.f72525a + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 2, M(), false);
        SafeParcelWriter.b(parcel, iA);
    }
}
