package com.applovin.impl;

import android.os.Parcel;
import android.os.Parcelable;
import com.applovin.impl.af;
import com.applovin.impl.ud;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class lh implements af.b {
    public static final Parcelable.Creator<lh> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f61221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f61222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f61223c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f61224d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f61225f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f61226g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f61227h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final byte[] f61228i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public lh[] newArray(int i3) {
            return new lh[i3];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public lh createFromParcel(Parcel parcel) {
            return new lh(parcel);
        }
    }

    public lh(int i3, String str, String str2, int i4, int i5, int i6, int i7, byte[] bArr) {
        this.f61221a = i3;
        this.f61222b = str;
        this.f61223c = str2;
        this.f61224d = i4;
        this.f61225f = i5;
        this.f61226g = i6;
        this.f61227h = i7;
        this.f61228i = bArr;
    }

    @Override // com.applovin.impl.af.b
    public void a(ud.b bVar) {
        bVar.a(this.f61228i, this.f61221a);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && lh.class == obj.getClass()) {
            lh lhVar = (lh) obj;
            if (this.f61221a == lhVar.f61221a && this.f61222b.equals(lhVar.f61222b) && this.f61223c.equals(lhVar.f61223c) && this.f61224d == lhVar.f61224d && this.f61225f == lhVar.f61225f && this.f61226g == lhVar.f61226g && this.f61227h == lhVar.f61227h && Arrays.equals(this.f61228i, lhVar.f61228i)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((this.f61221a + 527) * 31) + this.f61222b.hashCode()) * 31) + this.f61223c.hashCode()) * 31) + this.f61224d) * 31) + this.f61225f) * 31) + this.f61226g) * 31) + this.f61227h) * 31) + Arrays.hashCode(this.f61228i);
    }

    public String toString() {
        return "Picture: mimeType=" + this.f61222b + ", description=" + this.f61223c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f61221a);
        parcel.writeString(this.f61222b);
        parcel.writeString(this.f61223c);
        parcel.writeInt(this.f61224d);
        parcel.writeInt(this.f61225f);
        parcel.writeInt(this.f61226g);
        parcel.writeInt(this.f61227h);
        parcel.writeByteArray(this.f61228i);
    }

    lh(Parcel parcel) {
        this.f61221a = parcel.readInt();
        this.f61222b = (String) xp.a((Object) parcel.readString());
        this.f61223c = (String) xp.a((Object) parcel.readString());
        this.f61224d = parcel.readInt();
        this.f61225f = parcel.readInt();
        this.f61226g = parcel.readInt();
        this.f61227h = parcel.readInt();
        this.f61228i = (byte[]) xp.a((Object) parcel.createByteArray());
    }
}
