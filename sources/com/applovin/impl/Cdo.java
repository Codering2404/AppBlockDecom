package com.applovin.impl;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: com.applovin.impl.do, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class Cdo extends sk {
    public static final Parcelable.Creator<Cdo> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f59276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f59277b;

    /* JADX INFO: renamed from: com.applovin.impl.do$a */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Cdo[] newArray(int i3) {
            return new Cdo[i3];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Cdo createFromParcel(Parcel parcel) {
            return new Cdo(parcel.readLong(), parcel.readLong(), null);
        }
    }

    private Cdo(long j3, long j4) {
        this.f59276a = j3;
        this.f59277b = j4;
    }

    static Cdo a(ah ahVar, long j3, ho hoVar) {
        long jA = a(ahVar, j3);
        return new Cdo(jA, hoVar.b(jA));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.f59276a);
        parcel.writeLong(this.f59277b);
    }

    /* synthetic */ Cdo(long j3, long j4, a aVar) {
        this(j3, j4);
    }

    static long a(ah ahVar, long j3) {
        long jW = ahVar.w();
        if ((128 & jW) != 0) {
            return 8589934591L & ((((jW & 1) << 32) | ahVar.y()) + j3);
        }
        return -9223372036854775807L;
    }
}
