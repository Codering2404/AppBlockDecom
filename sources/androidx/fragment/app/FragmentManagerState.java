package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new Parcelable.Creator<FragmentManagerState>() { // from class: androidx.fragment.app.FragmentManagerState.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public FragmentManagerState createFromParcel(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public FragmentManagerState[] newArray(int i3) {
            return new FragmentManagerState[i3];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ArrayList f37272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ArrayList f37273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    BackStackRecordState[] f37274c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f37275d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    String f37276f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    ArrayList f37277g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    ArrayList f37278h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    ArrayList f37279i;

    public FragmentManagerState() {
        this.f37276f = null;
        this.f37277g = new ArrayList();
        this.f37278h = new ArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeStringList(this.f37272a);
        parcel.writeStringList(this.f37273b);
        parcel.writeTypedArray(this.f37274c, i3);
        parcel.writeInt(this.f37275d);
        parcel.writeString(this.f37276f);
        parcel.writeStringList(this.f37277g);
        parcel.writeTypedList(this.f37278h);
        parcel.writeTypedList(this.f37279i);
    }

    public FragmentManagerState(Parcel parcel) {
        this.f37276f = null;
        this.f37277g = new ArrayList();
        this.f37278h = new ArrayList();
        this.f37272a = parcel.createStringArrayList();
        this.f37273b = parcel.createStringArrayList();
        this.f37274c = (BackStackRecordState[]) parcel.createTypedArray(BackStackRecordState.CREATOR);
        this.f37275d = parcel.readInt();
        this.f37276f = parcel.readString();
        this.f37277g = parcel.createStringArrayList();
        this.f37278h = parcel.createTypedArrayList(BackStackState.CREATOR);
        this.f37279i = parcel.createTypedArrayList(FragmentManager.LaunchedFragmentInfo.CREATOR);
    }
}
