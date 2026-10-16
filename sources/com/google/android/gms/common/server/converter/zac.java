package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zac extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zac> CREATOR = new zae();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f72199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final String f72200b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f72201c;

    zac(int i3, String str, int i4) {
        this.f72199a = i3;
        this.f72200b = str;
        this.f72201c = i4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i4 = this.f72199a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, i4);
        SafeParcelWriter.G(parcel, 2, this.f72200b, false);
        SafeParcelWriter.u(parcel, 3, this.f72201c);
        SafeParcelWriter.b(parcel, iA);
    }

    zac(String str, int i3) {
        this.f72199a = 1;
        this.f72200b = str;
        this.f72201c = i3;
    }
}
