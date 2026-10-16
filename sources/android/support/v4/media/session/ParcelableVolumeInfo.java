package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new Parcelable.Creator<ParcelableVolumeInfo>() { // from class: android.support.v4.media.session.ParcelableVolumeInfo.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableVolumeInfo createFromParcel(Parcel parcel) {
            return new ParcelableVolumeInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelableVolumeInfo[] newArray(int i3) {
            return new ParcelableVolumeInfo[i3];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f286b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f287c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f288d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f289f;

    public ParcelableVolumeInfo(int i3, int i4, int i5, int i6, int i7) {
        this.f285a = i3;
        this.f286b = i4;
        this.f287c = i5;
        this.f288d = i6;
        this.f289f = i7;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f285a);
        parcel.writeInt(this.f287c);
        parcel.writeInt(this.f288d);
        parcel.writeInt(this.f289f);
        parcel.writeInt(this.f286b);
    }

    public ParcelableVolumeInfo(Parcel parcel) {
        this.f285a = parcel.readInt();
        this.f287c = parcel.readInt();
        this.f288d = parcel.readInt();
        this.f289f = parcel.readInt();
        this.f286b = parcel.readInt();
    }
}
