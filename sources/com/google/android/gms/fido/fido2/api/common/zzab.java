package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzab extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzab> CREATOR = new zzac();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f72639a;

    public zzab(long j3) {
        this.f72639a = ((Long) Preconditions.m(Long.valueOf(j3))).longValue();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzab) && this.f72639a == ((zzab) obj).f72639a;
    }

    public final int hashCode() {
        return Objects.c(Long.valueOf(this.f72639a));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        long j3 = this.f72639a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.z(parcel, 1, j3);
        SafeParcelWriter.b(parcel, iA);
    }
}
