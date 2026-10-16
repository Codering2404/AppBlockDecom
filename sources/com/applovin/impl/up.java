package com.applovin.impl;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class up extends xa {
    public static final Parcelable.Creator<up> CREATOR = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f64339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f64340c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public up[] newArray(int i3) {
            return new up[i3];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public up createFromParcel(Parcel parcel) {
            return new up(parcel);
        }
    }

    up(Parcel parcel) {
        super((String) xp.a((Object) parcel.readString()));
        this.f64339b = parcel.readString();
        this.f64340c = (String) xp.a((Object) parcel.readString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && up.class == obj.getClass()) {
            up upVar = (up) obj;
            if (this.f64884a.equals(upVar.f64884a) && xp.a((Object) this.f64339b, (Object) upVar.f64339b) && xp.a((Object) this.f64340c, (Object) upVar.f64340c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (this.f64884a.hashCode() + 527) * 31;
        String str = this.f64339b;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f64340c;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // com.applovin.impl.xa
    public String toString() {
        return this.f64884a + ": url=" + this.f64340c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f64884a);
        parcel.writeString(this.f64339b);
        parcel.writeString(this.f64340c);
    }

    public up(String str, String str2, String str3) {
        super(str);
        this.f64339b = str2;
        this.f64340c = str3;
    }
}
