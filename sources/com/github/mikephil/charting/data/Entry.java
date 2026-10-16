package com.github.mikephil.charting.data;

import android.os.Parcel;
import android.os.ParcelFormatException;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class Entry extends BaseEntry implements Parcelable {
    public static final Parcelable.Creator<Entry> CREATOR = new Parcelable.Creator<Entry>() { // from class: com.github.mikephil.charting.data.Entry.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Entry createFromParcel(Parcel parcel) {
            return new Entry(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Entry[] newArray(int i3) {
            return new Entry[i3];
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f68544d;

    public Entry(float f3, float f4) {
        super(f4);
        this.f68544d = f3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float h() {
        return this.f68544d;
    }

    public String toString() {
        return "Entry, x: " + this.f68544d + " y: " + e();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeFloat(this.f68544d);
        parcel.writeFloat(e());
        if (c() == null) {
            parcel.writeInt(0);
        } else {
            if (!(c() instanceof Parcelable)) {
                throw new ParcelFormatException("Cannot parcel an Entry with non-parcelable data");
            }
            parcel.writeInt(1);
            parcel.writeParcelable((Parcelable) c(), i3);
        }
    }

    protected Entry(Parcel parcel) {
        this.f68544d = 0.0f;
        this.f68544d = parcel.readFloat();
        g(parcel.readFloat());
        if (parcel.readInt() == 1) {
            f(parcel.readParcelable(Object.class.getClassLoader()));
        }
    }
}
