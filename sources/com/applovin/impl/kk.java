package com.applovin.impl;

import android.os.Parcel;
import android.os.Parcelable;
import com.applovin.impl.af;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class kk implements af.b {
    public static final Parcelable.Creator<kk> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f61040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f61041b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public kk[] newArray(int i3) {
            return new kk[i3];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public kk createFromParcel(Parcel parcel) {
            return new kk(parcel, (a) null);
        }
    }

    public kk(float f3, int i3) {
        this.f61040a = f3;
        this.f61041b = i3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && kk.class == obj.getClass()) {
            kk kkVar = (kk) obj;
            if (this.f61040a == kkVar.f61040a && this.f61041b == kkVar.f61041b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((c9.a(this.f61040a) + 527) * 31) + this.f61041b;
    }

    public String toString() {
        return "smta: captureFrameRate=" + this.f61040a + ", svcTemporalLayerCount=" + this.f61041b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeFloat(this.f61040a);
        parcel.writeInt(this.f61041b);
    }

    private kk(Parcel parcel) {
        this.f61040a = parcel.readFloat();
        this.f61041b = parcel.readInt();
    }

    /* synthetic */ kk(Parcel parcel, a aVar) {
        this(parcel);
    }
}
