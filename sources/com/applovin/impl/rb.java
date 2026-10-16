package com.applovin.impl;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class rb extends xa {
    public static final Parcelable.Creator<rb> CREATOR = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f62812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f62813c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f62814d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public rb[] newArray(int i3) {
            return new rb[i3];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public rb createFromParcel(Parcel parcel) {
            return new rb(parcel);
        }
    }

    rb(Parcel parcel) {
        super("----");
        this.f62812b = (String) xp.a((Object) parcel.readString());
        this.f62813c = (String) xp.a((Object) parcel.readString());
        this.f62814d = (String) xp.a((Object) parcel.readString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && rb.class == obj.getClass()) {
            rb rbVar = (rb) obj;
            if (xp.a((Object) this.f62813c, (Object) rbVar.f62813c) && xp.a((Object) this.f62812b, (Object) rbVar.f62812b) && xp.a((Object) this.f62814d, (Object) rbVar.f62814d)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f62812b;
        int iHashCode = ((str != null ? str.hashCode() : 0) + 527) * 31;
        String str2 = this.f62813c;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f62814d;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // com.applovin.impl.xa
    public String toString() {
        return this.f64884a + ": domain=" + this.f62812b + ", description=" + this.f62813c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f64884a);
        parcel.writeString(this.f62812b);
        parcel.writeString(this.f62814d);
    }

    public rb(String str, String str2, String str3) {
        super("----");
        this.f62812b = str;
        this.f62813c = str2;
        this.f62814d = str3;
    }
}
