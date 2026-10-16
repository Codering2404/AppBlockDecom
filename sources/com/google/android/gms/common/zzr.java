package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzr> CREATOR = new zzs();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f72351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f72352b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f72353c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f72354d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f72355f;

    zzr(boolean z2, String str, int i3, int i4, long j3) {
        this.f72351a = z2;
        this.f72352b = str;
        this.f72353c = zzz.a(i3) - 1;
        this.f72354d = zzc.a(i4) - 1;
        this.f72355f = j3;
    }

    public final int M() {
        return zzz.a(this.f72353c);
    }

    public final int N() {
        return zzc.a(this.f72354d);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.g(parcel, 1, this.f72351a);
        SafeParcelWriter.G(parcel, 2, this.f72352b, false);
        SafeParcelWriter.u(parcel, 3, this.f72353c);
        SafeParcelWriter.u(parcel, 4, this.f72354d);
        SafeParcelWriter.z(parcel, 5, this.f72355f);
        SafeParcelWriter.b(parcel, iA);
    }

    public final boolean zza() {
        return this.f72351a;
    }

    public final String zzb() {
        return this.f72352b;
    }

    public final long zzc() {
        return this.f72355f;
    }
}
