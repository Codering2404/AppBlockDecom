package com.applovin.impl;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class u3 extends xa {
    public static final Parcelable.Creator<u3> CREATOR = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f64076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f64077c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f64078d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public u3[] newArray(int i3) {
            return new u3[i3];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public u3 createFromParcel(Parcel parcel) {
            return new u3(parcel);
        }
    }

    u3(Parcel parcel) {
        super("COMM");
        this.f64076b = (String) xp.a((Object) parcel.readString());
        this.f64077c = (String) xp.a((Object) parcel.readString());
        this.f64078d = (String) xp.a((Object) parcel.readString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && u3.class == obj.getClass()) {
            u3 u3Var = (u3) obj;
            if (xp.a((Object) this.f64077c, (Object) u3Var.f64077c) && xp.a((Object) this.f64076b, (Object) u3Var.f64076b) && xp.a((Object) this.f64078d, (Object) u3Var.f64078d)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f64076b;
        int iHashCode = ((str != null ? str.hashCode() : 0) + 527) * 31;
        String str2 = this.f64077c;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f64078d;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // com.applovin.impl.xa
    public String toString() {
        return this.f64884a + ": language=" + this.f64076b + ", description=" + this.f64077c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f64884a);
        parcel.writeString(this.f64076b);
        parcel.writeString(this.f64078d);
    }

    public u3(String str, String str2, String str3) {
        super("COMM");
        this.f64076b = str;
        this.f64077c = str2;
        this.f64078d = str3;
    }
}
