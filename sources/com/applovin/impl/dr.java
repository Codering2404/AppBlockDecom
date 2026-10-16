package com.applovin.impl;

import android.os.Parcel;
import android.os.Parcelable;
import com.applovin.impl.af;
import com.applovin.impl.ud;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class dr implements af.b {
    public static final Parcelable.Creator<dr> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f59296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f59297b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public dr[] newArray(int i3) {
            return new dr[i3];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public dr createFromParcel(Parcel parcel) {
            return new dr(parcel);
        }
    }

    dr(Parcel parcel) {
        this.f59296a = (String) xp.a((Object) parcel.readString());
        this.f59297b = (String) xp.a((Object) parcel.readString());
    }

    @Override // com.applovin.impl.af.b
    public void a(ud.b bVar) {
        String str = this.f59296a;
        str.getClass();
        switch (str) {
            case "ALBUM":
                bVar.b(this.f59297b);
                break;
            case "TITLE":
                bVar.k(this.f59297b);
                break;
            case "DESCRIPTION":
                bVar.g(this.f59297b);
                break;
            case "ALBUMARTIST":
                bVar.a(this.f59297b);
                break;
            case "ARTIST":
                bVar.c(this.f59297b);
                break;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && dr.class == obj.getClass()) {
            dr drVar = (dr) obj;
            if (this.f59296a.equals(drVar.f59296a) && this.f59297b.equals(drVar.f59297b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f59296a.hashCode() + 527) * 31) + this.f59297b.hashCode();
    }

    public String toString() {
        return "VC: " + this.f59296a + "=" + this.f59297b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f59296a);
        parcel.writeString(this.f59297b);
    }

    public dr(String str, String str2) {
        this.f59296a = str;
        this.f59297b = str2;
    }
}
