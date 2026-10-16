package com.applovin.impl;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class yh extends sk {
    public static final Parcelable.Creator<yh> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f65214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f65215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f65216c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public yh[] newArray(int i3) {
            return new yh[i3];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public yh createFromParcel(Parcel parcel) {
            return new yh(parcel, null);
        }
    }

    private yh(long j3, byte[] bArr, long j4) {
        this.f65214a = j4;
        this.f65215b = j3;
        this.f65216c = bArr;
    }

    static yh a(ah ahVar, int i3, long j3) {
        long jY = ahVar.y();
        int i4 = i3 - 4;
        byte[] bArr = new byte[i4];
        ahVar.a(bArr, 0, i4);
        return new yh(jY, bArr, j3);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.f65214a);
        parcel.writeLong(this.f65215b);
        parcel.writeByteArray(this.f65216c);
    }

    private yh(Parcel parcel) {
        this.f65214a = parcel.readLong();
        this.f65215b = parcel.readLong();
        this.f65216c = (byte[]) xp.a((Object) parcel.createByteArray());
    }

    /* synthetic */ yh(Parcel parcel, a aVar) {
        this(parcel);
    }
}
