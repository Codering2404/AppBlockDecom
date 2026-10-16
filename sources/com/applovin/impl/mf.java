package com.applovin.impl;

import android.os.Parcel;
import android.os.Parcelable;
import com.applovin.impl.af;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class mf implements af.b {
    public static final Parcelable.Creator<mf> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f61890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f61891b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f61892c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f61893d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f61894f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public mf[] newArray(int i3) {
            return new mf[i3];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public mf createFromParcel(Parcel parcel) {
            return new mf(parcel, null);
        }
    }

    public mf(long j3, long j4, long j5, long j6, long j7) {
        this.f61890a = j3;
        this.f61891b = j4;
        this.f61892c = j5;
        this.f61893d = j6;
        this.f61894f = j7;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && mf.class == obj.getClass()) {
            mf mfVar = (mf) obj;
            if (this.f61890a == mfVar.f61890a && this.f61891b == mfVar.f61891b && this.f61892c == mfVar.f61892c && this.f61893d == mfVar.f61893d && this.f61894f == mfVar.f61894f) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((((rc.a(this.f61890a) + 527) * 31) + rc.a(this.f61891b)) * 31) + rc.a(this.f61892c)) * 31) + rc.a(this.f61893d)) * 31) + rc.a(this.f61894f);
    }

    public String toString() {
        return "Motion photo metadata: photoStartPosition=" + this.f61890a + ", photoSize=" + this.f61891b + ", photoPresentationTimestampUs=" + this.f61892c + ", videoStartPosition=" + this.f61893d + ", videoSize=" + this.f61894f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.f61890a);
        parcel.writeLong(this.f61891b);
        parcel.writeLong(this.f61892c);
        parcel.writeLong(this.f61893d);
        parcel.writeLong(this.f61894f);
    }

    private mf(Parcel parcel) {
        this.f61890a = parcel.readLong();
        this.f61891b = parcel.readLong();
        this.f61892c = parcel.readLong();
        this.f61893d = parcel.readLong();
        this.f61894f = parcel.readLong();
    }

    /* synthetic */ mf(Parcel parcel, a aVar) {
        this(parcel);
    }
}
