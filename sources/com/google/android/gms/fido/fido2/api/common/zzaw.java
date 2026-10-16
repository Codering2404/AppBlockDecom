package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaw> CREATOR = new zzax();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f72652a;

    zzaw(String str) {
        this.f72652a = str;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzaw) {
            return Objects.b(this.f72652a, ((zzaw) obj).f72652a);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.c(this.f72652a);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        String str = this.f72652a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 1, str, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
