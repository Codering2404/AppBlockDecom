package androidx.media3.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.util.Util;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class StreamKey implements Comparable<StreamKey>, Parcelable {
    public static final Parcelable.Creator<StreamKey> CREATOR = new Parcelable.Creator<StreamKey>() { // from class: androidx.media3.common.StreamKey.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public StreamKey createFromParcel(Parcel parcel) {
            return new StreamKey(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public StreamKey[] newArray(int i3) {
            return new StreamKey[i3];
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f41090d = Util.y0(0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f41091f = Util.y0(1);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f41092g = Util.y0(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f41093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f41094b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f41095c;

    public StreamKey(int i3, int i4, int i5) {
        this.f41093a = i3;
        this.f41094b = i4;
        this.f41095c = i5;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(StreamKey streamKey) {
        int i3 = this.f41093a - streamKey.f41093a;
        if (i3 != 0) {
            return i3;
        }
        int i4 = this.f41094b - streamKey.f41094b;
        return i4 == 0 ? this.f41095c - streamKey.f41095c : i4;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && StreamKey.class == obj.getClass()) {
            StreamKey streamKey = (StreamKey) obj;
            if (this.f41093a == streamKey.f41093a && this.f41094b == streamKey.f41094b && this.f41095c == streamKey.f41095c) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((this.f41093a * 31) + this.f41094b) * 31) + this.f41095c;
    }

    public String toString() {
        return this.f41093a + "." + this.f41094b + "." + this.f41095c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f41093a);
        parcel.writeInt(this.f41094b);
        parcel.writeInt(this.f41095c);
    }

    StreamKey(Parcel parcel) {
        this.f41093a = parcel.readInt();
        this.f41094b = parcel.readInt();
        this.f41095c = parcel.readInt();
    }
}
