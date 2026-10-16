package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public final class zzft extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzft> CREATOR = new zzfu();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f69954a;

    zzft(String str) {
        this.f69954a = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        String str = this.f69954a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 15, str, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
