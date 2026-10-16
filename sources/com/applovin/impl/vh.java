package com.applovin.impl;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class vh extends xa {
    public static final Parcelable.Creator<vh> CREATOR = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f64428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f64429c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public vh[] newArray(int i3) {
            return new vh[i3];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public vh createFromParcel(Parcel parcel) {
            return new vh(parcel);
        }
    }

    vh(Parcel parcel) {
        super("PRIV");
        this.f64428b = (String) xp.a((Object) parcel.readString());
        this.f64429c = (byte[]) xp.a((Object) parcel.createByteArray());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && vh.class == obj.getClass()) {
            vh vhVar = (vh) obj;
            if (xp.a((Object) this.f64428b, (Object) vhVar.f64428b) && Arrays.equals(this.f64429c, vhVar.f64429c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f64428b;
        return (((str != null ? str.hashCode() : 0) + 527) * 31) + Arrays.hashCode(this.f64429c);
    }

    @Override // com.applovin.impl.xa
    public String toString() {
        return this.f64884a + ": owner=" + this.f64428b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f64428b);
        parcel.writeByteArray(this.f64429c);
    }

    public vh(String str, byte[] bArr) {
        super("PRIV");
        this.f64428b = str;
        this.f64429c = bArr;
    }
}
