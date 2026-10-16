package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzz> CREATOR = new zzaa();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f72662a;

    public zzz(boolean z2) {
        this.f72662a = ((Boolean) Preconditions.m(Boolean.valueOf(z2))).booleanValue();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzz) && this.f72662a == ((zzz) obj).f72662a;
    }

    public final int hashCode() {
        return Objects.c(Boolean.valueOf(this.f72662a));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        boolean z2 = this.f72662a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.g(parcel, 1, z2);
        SafeParcelWriter.b(parcel, iA);
    }
}
