package com.applovin.impl;

import android.os.Parcel;
import android.os.Parcelable;
import com.applovin.impl.af;
import com.facebook.appevents.AppEventsConstants;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class ua implements af.b {
    public static final Parcelable.Creator<ua> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f64158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f64159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f64160c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f64161d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f64162f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f64163g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ua[] newArray(int i3) {
            return new ua[i3];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ua createFromParcel(Parcel parcel) {
            return new ua(parcel);
        }
    }

    public ua(int i3, String str, String str2, String str3, boolean z2, int i4) {
        b1.a(i4 == -1 || i4 > 0);
        this.f64158a = i3;
        this.f64159b = str;
        this.f64160c = str2;
        this.f64161d = str3;
        this.f64162f = z2;
        this.f64163g = i4;
    }

    public static ua a(Map map) {
        boolean z2;
        int i3;
        String str;
        String str2;
        String str3;
        boolean zEquals;
        int i4;
        int i5;
        int i6;
        List list = (List) map.get("icy-br");
        boolean z3 = true;
        int i7 = -1;
        if (list != null) {
            String str4 = (String) list.get(0);
            try {
                i6 = Integer.parseInt(str4) * 1000;
            } catch (NumberFormatException unused) {
                i6 = -1;
            }
            if (i6 > 0) {
                z2 = true;
                i3 = i6;
            } else {
                try {
                    oc.d("IcyHeaders", "Invalid bitrate: " + str4);
                    z2 = false;
                    i3 = -1;
                } catch (NumberFormatException unused2) {
                    oc.d("IcyHeaders", "Invalid bitrate header: " + str4);
                    z2 = false;
                    i3 = i6;
                }
            }
        } else {
            z2 = false;
            i3 = -1;
        }
        List list2 = (List) map.get("icy-genre");
        if (list2 != null) {
            str = (String) list2.get(0);
            z2 = true;
        } else {
            str = null;
        }
        List list3 = (List) map.get("icy-name");
        if (list3 != null) {
            str2 = (String) list3.get(0);
            z2 = true;
        } else {
            str2 = null;
        }
        List list4 = (List) map.get("icy-url");
        if (list4 != null) {
            str3 = (String) list4.get(0);
            z2 = true;
        } else {
            str3 = null;
        }
        List list5 = (List) map.get("icy-pub");
        if (list5 != null) {
            zEquals = ((String) list5.get(0)).equals(AppEventsConstants.EVENT_PARAM_VALUE_YES);
            z2 = true;
        } else {
            zEquals = false;
        }
        List list6 = (List) map.get("icy-metaint");
        if (list6 != null) {
            String str5 = (String) list6.get(0);
            try {
                i5 = Integer.parseInt(str5);
            } catch (NumberFormatException unused3) {
            }
            if (i5 > 0) {
                i4 = i5;
            } else {
                try {
                    oc.d("IcyHeaders", "Invalid metadata interval: " + str5);
                } catch (NumberFormatException unused4) {
                    i7 = i5;
                    oc.d("IcyHeaders", "Invalid metadata interval: " + str5);
                }
                z3 = z2;
                i4 = i7;
            }
        } else {
            z3 = z2;
            i4 = i7;
        }
        if (z3) {
            return new ua(i3, str, str2, str3, zEquals, i4);
        }
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ua.class == obj.getClass()) {
            ua uaVar = (ua) obj;
            if (this.f64158a == uaVar.f64158a && xp.a((Object) this.f64159b, (Object) uaVar.f64159b) && xp.a((Object) this.f64160c, (Object) uaVar.f64160c) && xp.a((Object) this.f64161d, (Object) uaVar.f64161d) && this.f64162f == uaVar.f64162f && this.f64163g == uaVar.f64163g) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i3 = (this.f64158a + 527) * 31;
        String str = this.f64159b;
        int iHashCode = (i3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f64160c;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f64161d;
        return ((((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + (this.f64162f ? 1 : 0)) * 31) + this.f64163g;
    }

    public String toString() {
        return "IcyHeaders: name=\"" + this.f64160c + "\", genre=\"" + this.f64159b + "\", bitrate=" + this.f64158a + ", metadataInterval=" + this.f64163g;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f64158a);
        parcel.writeString(this.f64159b);
        parcel.writeString(this.f64160c);
        parcel.writeString(this.f64161d);
        xp.a(parcel, this.f64162f);
        parcel.writeInt(this.f64163g);
    }

    ua(Parcel parcel) {
        this.f64158a = parcel.readInt();
        this.f64159b = parcel.readString();
        this.f64160c = parcel.readString();
        this.f64161d = parcel.readString();
        this.f64162f = xp.a(parcel);
        this.f64163g = parcel.readInt();
    }
}
