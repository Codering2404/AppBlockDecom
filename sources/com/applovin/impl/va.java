package com.applovin.impl;

import android.os.Parcel;
import android.os.Parcelable;
import com.applovin.impl.af;
import com.applovin.impl.ud;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class va implements af.b {
    public static final Parcelable.Creator<va> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f64410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f64411b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f64412c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public va[] newArray(int i3) {
            return new va[i3];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public va createFromParcel(Parcel parcel) {
            return new va(parcel);
        }
    }

    va(Parcel parcel) {
        this.f64410a = (byte[]) b1.a(parcel.createByteArray());
        this.f64411b = parcel.readString();
        this.f64412c = parcel.readString();
    }

    @Override // com.applovin.impl.af.b
    public void a(ud.b bVar) {
        String str = this.f64411b;
        if (str != null) {
            bVar.k(str);
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
        if (obj == null || va.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f64410a, ((va) obj).f64410a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f64410a);
    }

    public String toString() {
        return String.format("ICY: title=\"%s\", url=\"%s\", rawMetadata.length=\"%s\"", this.f64411b, this.f64412c, Integer.valueOf(this.f64410a.length));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeByteArray(this.f64410a);
        parcel.writeString(this.f64411b);
        parcel.writeString(this.f64412c);
    }

    public va(byte[] bArr, String str, String str2) {
        this.f64410a = bArr;
        this.f64411b = str;
        this.f64412c = str2;
    }
}
