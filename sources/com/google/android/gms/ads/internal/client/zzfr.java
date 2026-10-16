package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfr> CREATOR = new zzfs();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f69952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f69953b;

    public zzfr(int i3, int i4) {
        this.f69952a = i3;
        this.f69953b = i4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i4 = this.f69952a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, i4);
        SafeParcelWriter.u(parcel, 2, this.f69953b);
        SafeParcelWriter.b(parcel, iA);
    }

    public zzfr(RequestConfiguration requestConfiguration) {
        this.f69952a = requestConfiguration.c();
        this.f69953b = requestConfiguration.d();
    }
}
