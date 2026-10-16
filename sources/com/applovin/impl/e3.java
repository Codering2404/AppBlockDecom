package com.applovin.impl;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class e3 extends xa {
    public static final Parcelable.Creator<e3> CREATOR = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f59345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f59346c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f59347d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f59348f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f59349g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final xa[] f59350h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e3[] newArray(int i3) {
            return new e3[i3];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e3 createFromParcel(Parcel parcel) {
            return new e3(parcel);
        }
    }

    e3(Parcel parcel) {
        super("CHAP");
        this.f59345b = (String) xp.a((Object) parcel.readString());
        this.f59346c = parcel.readInt();
        this.f59347d = parcel.readInt();
        this.f59348f = parcel.readLong();
        this.f59349g = parcel.readLong();
        int i3 = parcel.readInt();
        this.f59350h = new xa[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            this.f59350h[i4] = (xa) parcel.readParcelable(xa.class.getClassLoader());
        }
    }

    @Override // com.applovin.impl.xa, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && e3.class == obj.getClass()) {
            e3 e3Var = (e3) obj;
            if (this.f59346c == e3Var.f59346c && this.f59347d == e3Var.f59347d && this.f59348f == e3Var.f59348f && this.f59349g == e3Var.f59349g && xp.a((Object) this.f59345b, (Object) e3Var.f59345b) && Arrays.equals(this.f59350h, e3Var.f59350h)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i3 = (((((((this.f59346c + 527) * 31) + this.f59347d) * 31) + ((int) this.f59348f)) * 31) + ((int) this.f59349g)) * 31;
        String str = this.f59345b;
        return i3 + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f59345b);
        parcel.writeInt(this.f59346c);
        parcel.writeInt(this.f59347d);
        parcel.writeLong(this.f59348f);
        parcel.writeLong(this.f59349g);
        parcel.writeInt(this.f59350h.length);
        for (xa xaVar : this.f59350h) {
            parcel.writeParcelable(xaVar, 0);
        }
    }

    public e3(String str, int i3, int i4, long j3, long j4, xa[] xaVarArr) {
        super("CHAP");
        this.f59345b = str;
        this.f59346c = i3;
        this.f59347d = i4;
        this.f59348f = j3;
        this.f59349g = j4;
        this.f59350h = xaVarArr;
    }
}
