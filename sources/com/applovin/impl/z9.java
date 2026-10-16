package com.applovin.impl;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class z9 extends xa {
    public static final Parcelable.Creator<z9> CREATOR = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f65404b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f65405c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f65406d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f65407f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public z9[] newArray(int i3) {
            return new z9[i3];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public z9 createFromParcel(Parcel parcel) {
            return new z9(parcel);
        }
    }

    z9(Parcel parcel) {
        super("GEOB");
        this.f65404b = (String) xp.a((Object) parcel.readString());
        this.f65405c = (String) xp.a((Object) parcel.readString());
        this.f65406d = (String) xp.a((Object) parcel.readString());
        this.f65407f = (byte[]) xp.a((Object) parcel.createByteArray());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && z9.class == obj.getClass()) {
            z9 z9Var = (z9) obj;
            if (xp.a((Object) this.f65404b, (Object) z9Var.f65404b) && xp.a((Object) this.f65405c, (Object) z9Var.f65405c) && xp.a((Object) this.f65406d, (Object) z9Var.f65406d) && Arrays.equals(this.f65407f, z9Var.f65407f)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f65404b;
        int iHashCode = ((str != null ? str.hashCode() : 0) + 527) * 31;
        String str2 = this.f65405c;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f65406d;
        return ((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + Arrays.hashCode(this.f65407f);
    }

    @Override // com.applovin.impl.xa
    public String toString() {
        return this.f64884a + ": mimeType=" + this.f65404b + ", filename=" + this.f65405c + ", description=" + this.f65406d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f65404b);
        parcel.writeString(this.f65405c);
        parcel.writeString(this.f65406d);
        parcel.writeByteArray(this.f65407f);
    }

    public z9(String str, String str2, String str3, byte[] bArr) {
        super("GEOB");
        this.f65404b = str;
        this.f65405c = str2;
        this.f65406d = str3;
        this.f65407f = bArr;
    }
}
