package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class UvmEntry extends AbstractSafeParcelable {
    public static final Parcelable.Creator<UvmEntry> CREATOR = new zzbe();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f72636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final short f72637b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final short f72638c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {
    }

    UvmEntry(int i3, short s2, short s3) {
        this.f72636a = i3;
        this.f72637b = s2;
        this.f72638c = s3;
    }

    public short M() {
        return this.f72637b;
    }

    public short N() {
        return this.f72638c;
    }

    public int O() {
        return this.f72636a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof UvmEntry)) {
            return false;
        }
        UvmEntry uvmEntry = (UvmEntry) obj;
        return this.f72636a == uvmEntry.f72636a && this.f72637b == uvmEntry.f72637b && this.f72638c == uvmEntry.f72638c;
    }

    public int hashCode() {
        return Objects.c(Integer.valueOf(this.f72636a), Short.valueOf(this.f72637b), Short.valueOf(this.f72638c));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, O());
        SafeParcelWriter.F(parcel, 2, M());
        SafeParcelWriter.F(parcel, 3, N());
        SafeParcelWriter.b(parcel, iA);
    }
}
