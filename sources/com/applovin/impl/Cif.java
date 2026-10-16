package com.applovin.impl;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: renamed from: com.applovin.impl.if, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class Cif extends xa {
    public static final Parcelable.Creator<Cif> CREATOR = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f60441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f60442c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f60443d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int[] f60444f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int[] f60445g;

    /* JADX INFO: renamed from: com.applovin.impl.if$a */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Cif[] newArray(int i3) {
            return new Cif[i3];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Cif createFromParcel(Parcel parcel) {
            return new Cif(parcel);
        }
    }

    public Cif(int i3, int i4, int i5, int[] iArr, int[] iArr2) {
        super("MLLT");
        this.f60441b = i3;
        this.f60442c = i4;
        this.f60443d = i5;
        this.f60444f = iArr;
        this.f60445g = iArr2;
    }

    @Override // com.applovin.impl.xa, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && Cif.class == obj.getClass()) {
            Cif cif = (Cif) obj;
            if (this.f60441b == cif.f60441b && this.f60442c == cif.f60442c && this.f60443d == cif.f60443d && Arrays.equals(this.f60444f, cif.f60444f) && Arrays.equals(this.f60445g, cif.f60445g)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((((this.f60441b + 527) * 31) + this.f60442c) * 31) + this.f60443d) * 31) + Arrays.hashCode(this.f60444f)) * 31) + Arrays.hashCode(this.f60445g);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f60441b);
        parcel.writeInt(this.f60442c);
        parcel.writeInt(this.f60443d);
        parcel.writeIntArray(this.f60444f);
        parcel.writeIntArray(this.f60445g);
    }

    Cif(Parcel parcel) {
        super("MLLT");
        this.f60441b = parcel.readInt();
        this.f60442c = parcel.readInt();
        this.f60443d = parcel.readInt();
        this.f60444f = (int[]) xp.a(parcel.createIntArray());
        this.f60445g = (int[]) xp.a(parcel.createIntArray());
    }
}
