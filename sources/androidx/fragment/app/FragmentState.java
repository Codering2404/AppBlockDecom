package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.lifecycle.Lifecycle;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new Parcelable.Creator<FragmentState>() { // from class: androidx.fragment.app.FragmentState.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public FragmentState createFromParcel(Parcel parcel) {
            return new FragmentState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public FragmentState[] newArray(int i3) {
            return new FragmentState[i3];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final String f37288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final String f37289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f37290c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f37291d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f37292f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final String f37293g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final boolean f37294h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final boolean f37295i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final boolean f37296j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final boolean f37297k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final int f37298l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final String f37299m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final int f37300n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    final boolean f37301o;

    FragmentState(Fragment fragment) {
        this.f37288a = fragment.getClass().getName();
        this.f37289b = fragment.mWho;
        this.f37290c = fragment.mFromLayout;
        this.f37291d = fragment.mFragmentId;
        this.f37292f = fragment.mContainerId;
        this.f37293g = fragment.mTag;
        this.f37294h = fragment.mRetainInstance;
        this.f37295i = fragment.mRemoving;
        this.f37296j = fragment.mDetached;
        this.f37297k = fragment.mHidden;
        this.f37298l = fragment.mMaxState.ordinal();
        this.f37299m = fragment.mTargetWho;
        this.f37300n = fragment.mTargetRequestCode;
        this.f37301o = fragment.mUserVisibleHint;
    }

    Fragment a(FragmentFactory fragmentFactory, ClassLoader classLoader) {
        Fragment fragmentA = fragmentFactory.a(classLoader, this.f37288a);
        fragmentA.mWho = this.f37289b;
        fragmentA.mFromLayout = this.f37290c;
        fragmentA.mRestored = true;
        fragmentA.mFragmentId = this.f37291d;
        fragmentA.mContainerId = this.f37292f;
        fragmentA.mTag = this.f37293g;
        fragmentA.mRetainInstance = this.f37294h;
        fragmentA.mRemoving = this.f37295i;
        fragmentA.mDetached = this.f37296j;
        fragmentA.mHidden = this.f37297k;
        fragmentA.mMaxState = Lifecycle.State.values()[this.f37298l];
        fragmentA.mTargetWho = this.f37299m;
        fragmentA.mTargetRequestCode = this.f37300n;
        fragmentA.mUserVisibleHint = this.f37301o;
        return fragmentA;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
        sb.append("FragmentState{");
        sb.append(this.f37288a);
        sb.append(" (");
        sb.append(this.f37289b);
        sb.append(")}:");
        if (this.f37290c) {
            sb.append(" fromLayout");
        }
        if (this.f37292f != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f37292f));
        }
        String str = this.f37293g;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f37293g);
        }
        if (this.f37294h) {
            sb.append(" retainInstance");
        }
        if (this.f37295i) {
            sb.append(" removing");
        }
        if (this.f37296j) {
            sb.append(" detached");
        }
        if (this.f37297k) {
            sb.append(" hidden");
        }
        if (this.f37299m != null) {
            sb.append(" targetWho=");
            sb.append(this.f37299m);
            sb.append(" targetRequestCode=");
            sb.append(this.f37300n);
        }
        if (this.f37301o) {
            sb.append(" userVisibleHint");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f37288a);
        parcel.writeString(this.f37289b);
        parcel.writeInt(this.f37290c ? 1 : 0);
        parcel.writeInt(this.f37291d);
        parcel.writeInt(this.f37292f);
        parcel.writeString(this.f37293g);
        parcel.writeInt(this.f37294h ? 1 : 0);
        parcel.writeInt(this.f37295i ? 1 : 0);
        parcel.writeInt(this.f37296j ? 1 : 0);
        parcel.writeInt(this.f37297k ? 1 : 0);
        parcel.writeInt(this.f37298l);
        parcel.writeString(this.f37299m);
        parcel.writeInt(this.f37300n);
        parcel.writeInt(this.f37301o ? 1 : 0);
    }

    FragmentState(Parcel parcel) {
        this.f37288a = parcel.readString();
        this.f37289b = parcel.readString();
        this.f37290c = parcel.readInt() != 0;
        this.f37291d = parcel.readInt();
        this.f37292f = parcel.readInt();
        this.f37293g = parcel.readString();
        this.f37294h = parcel.readInt() != 0;
        this.f37295i = parcel.readInt() != 0;
        this.f37296j = parcel.readInt() != 0;
        this.f37297k = parcel.readInt() != 0;
        this.f37298l = parcel.readInt();
        this.f37299m = parcel.readString();
        this.f37300n = parcel.readInt();
        this.f37301o = parcel.readInt() != 0;
    }
}
