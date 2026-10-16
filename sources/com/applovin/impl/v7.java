package com.applovin.impl;

import android.os.Parcel;
import android.os.Parcelable;
import com.applovin.impl.af;
import com.applovin.impl.e9;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class v7 implements af.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f64400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f64401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f64402c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f64403d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f64404f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f64405g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final e9 f64398h = new e9.b().f("application/id3").a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final e9 f64399i = new e9.b().f("application/x-scte35").a();
    public static final Parcelable.Creator<v7> CREATOR = new a();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public v7[] newArray(int i3) {
            return new v7[i3];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public v7 createFromParcel(Parcel parcel) {
            return new v7(parcel);
        }
    }

    v7(Parcel parcel) {
        this.f64400a = (String) xp.a((Object) parcel.readString());
        this.f64401b = (String) xp.a((Object) parcel.readString());
        this.f64402c = parcel.readLong();
        this.f64403d = parcel.readLong();
        this.f64404f = (byte[]) xp.a((Object) parcel.createByteArray());
    }

    @Override // com.applovin.impl.af.b
    public byte[] a() {
        if (b() != null) {
            return this.f64404f;
        }
        return null;
    }

    @Override // com.applovin.impl.af.b
    public e9 b() {
        String str = this.f64400a;
        str.getClass();
        switch (str) {
            case "urn:scte:scte35:2014:bin":
                return f64399i;
            case "https://aomedia.org/emsg/ID3":
            case "https://developer.apple.com/streaming/emsg-id3":
                return f64398h;
            default:
                return null;
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
        if (obj != null && v7.class == obj.getClass()) {
            v7 v7Var = (v7) obj;
            if (this.f64402c == v7Var.f64402c && this.f64403d == v7Var.f64403d && xp.a((Object) this.f64400a, (Object) v7Var.f64400a) && xp.a((Object) this.f64401b, (Object) v7Var.f64401b) && Arrays.equals(this.f64404f, v7Var.f64404f)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        if (this.f64405g == 0) {
            String str = this.f64400a;
            int iHashCode = ((str != null ? str.hashCode() : 0) + 527) * 31;
            String str2 = this.f64401b;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            long j3 = this.f64402c;
            int i3 = (iHashCode2 + ((int) (j3 ^ (j3 >>> 32)))) * 31;
            long j4 = this.f64403d;
            this.f64405g = ((i3 + ((int) (j4 ^ (j4 >>> 32)))) * 31) + Arrays.hashCode(this.f64404f);
        }
        return this.f64405g;
    }

    public String toString() {
        return "EMSG: scheme=" + this.f64400a + ", id=" + this.f64403d + ", durationMs=" + this.f64402c + ", value=" + this.f64401b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f64400a);
        parcel.writeString(this.f64401b);
        parcel.writeLong(this.f64402c);
        parcel.writeLong(this.f64403d);
        parcel.writeByteArray(this.f64404f);
    }

    public v7(String str, String str2, long j3, long j4, byte[] bArr) {
        this.f64400a = str;
        this.f64401b = str2;
        this.f64402c = j3;
        this.f64403d = j4;
        this.f64404f = bArr;
    }
}
