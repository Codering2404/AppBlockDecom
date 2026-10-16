package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class DeviceMetaData extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DeviceMetaData> CREATOR = new zzy();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f70998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f70999b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f71000c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f71001d;

    DeviceMetaData(int i3, boolean z2, long j3, boolean z3) {
        this.f70998a = i3;
        this.f70999b = z2;
        this.f71000c = j3;
        this.f71001d = z3;
    }

    public long M() {
        return this.f71000c;
    }

    public boolean N() {
        return this.f71001d;
    }

    public boolean O() {
        return this.f70999b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, this.f70998a);
        SafeParcelWriter.g(parcel, 2, O());
        SafeParcelWriter.z(parcel, 3, M());
        SafeParcelWriter.g(parcel, 4, N());
        SafeParcelWriter.b(parcel, iA);
    }
}
