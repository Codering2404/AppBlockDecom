package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzb> CREATOR = new zzc();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f73014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f73015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final WorkSource f73016c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f73017d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int[] f73018f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f73019g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f73020h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f73021i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f73022j;

    zzb(long j3, boolean z2, WorkSource workSource, String str, int[] iArr, boolean z3, String str2, long j4, String str3) {
        this.f73014a = j3;
        this.f73015b = z2;
        this.f73016c = workSource;
        this.f73017d = str;
        this.f73018f = iArr;
        this.f73019g = z3;
        this.f73020h = str2;
        this.f73021i = j4;
        this.f73022j = str3;
    }

    public final zzb M(String str) {
        this.f73022j = str;
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        Preconditions.m(parcel);
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.z(parcel, 1, this.f73014a);
        SafeParcelWriter.g(parcel, 2, this.f73015b);
        SafeParcelWriter.E(parcel, 3, this.f73016c, i3, false);
        SafeParcelWriter.G(parcel, 4, this.f73017d, false);
        SafeParcelWriter.v(parcel, 5, this.f73018f, false);
        SafeParcelWriter.g(parcel, 6, this.f73019g);
        SafeParcelWriter.G(parcel, 7, this.f73020h, false);
        SafeParcelWriter.z(parcel, 8, this.f73021i);
        SafeParcelWriter.G(parcel, 9, this.f73022j, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
