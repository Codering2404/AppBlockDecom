package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class Tile extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Tile> CREATOR = new zzae();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f73255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f73256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f73257c;

    public Tile(int i3, int i4, byte[] bArr) {
        this.f73255a = i3;
        this.f73256b = i4;
        this.f73257c = bArr;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int i4 = this.f73255a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 2, i4);
        SafeParcelWriter.u(parcel, 3, this.f73256b);
        SafeParcelWriter.l(parcel, 4, this.f73257c, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
