package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class BackStackRecordState implements Parcelable {
    public static final Parcelable.Creator<BackStackRecordState> CREATOR = new Parcelable.Creator<BackStackRecordState>() { // from class: androidx.fragment.app.BackStackRecordState.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BackStackRecordState createFromParcel(Parcel parcel) {
            return new BackStackRecordState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public BackStackRecordState[] newArray(int i3) {
            return new BackStackRecordState[i3];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int[] f37109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ArrayList f37110b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int[] f37111c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int[] f37112d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f37113f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final String f37114g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final int f37115h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final int f37116i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final CharSequence f37117j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final int f37118k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final CharSequence f37119l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final ArrayList f37120m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final ArrayList f37121n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    final boolean f37122o;

    BackStackRecordState(BackStackRecord backStackRecord) {
        int size = backStackRecord.f37336c.size();
        this.f37109a = new int[size * 6];
        if (!backStackRecord.f37342i) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f37110b = new ArrayList(size);
        this.f37111c = new int[size];
        this.f37112d = new int[size];
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            FragmentTransaction.Op op = (FragmentTransaction.Op) backStackRecord.f37336c.get(i4);
            int i5 = i3 + 1;
            this.f37109a[i3] = op.f37353a;
            ArrayList arrayList = this.f37110b;
            Fragment fragment = op.f37354b;
            arrayList.add(fragment != null ? fragment.mWho : null);
            int[] iArr = this.f37109a;
            iArr[i5] = op.f37355c ? 1 : 0;
            iArr[i3 + 2] = op.f37356d;
            iArr[i3 + 3] = op.f37357e;
            int i6 = i3 + 5;
            iArr[i3 + 4] = op.f37358f;
            i3 += 6;
            iArr[i6] = op.f37359g;
            this.f37111c[i4] = op.f37360h.ordinal();
            this.f37112d[i4] = op.f37361i.ordinal();
        }
        this.f37113f = backStackRecord.f37341h;
        this.f37114g = backStackRecord.f37344k;
        this.f37115h = backStackRecord.f37107v;
        this.f37116i = backStackRecord.f37345l;
        this.f37117j = backStackRecord.f37346m;
        this.f37118k = backStackRecord.f37347n;
        this.f37119l = backStackRecord.f37348o;
        this.f37120m = backStackRecord.f37349p;
        this.f37121n = backStackRecord.f37350q;
        this.f37122o = backStackRecord.f37351r;
    }

    private void a(BackStackRecord backStackRecord) {
        int i3 = 0;
        int i4 = 0;
        while (true) {
            boolean z2 = true;
            if (i3 >= this.f37109a.length) {
                backStackRecord.f37341h = this.f37113f;
                backStackRecord.f37344k = this.f37114g;
                backStackRecord.f37342i = true;
                backStackRecord.f37345l = this.f37116i;
                backStackRecord.f37346m = this.f37117j;
                backStackRecord.f37347n = this.f37118k;
                backStackRecord.f37348o = this.f37119l;
                backStackRecord.f37349p = this.f37120m;
                backStackRecord.f37350q = this.f37121n;
                backStackRecord.f37351r = this.f37122o;
                return;
            }
            FragmentTransaction.Op op = new FragmentTransaction.Op();
            int i5 = i3 + 1;
            op.f37353a = this.f37109a[i3];
            if (FragmentManager.R0(2)) {
                Log.v("FragmentManager", "Instantiate " + backStackRecord + " op #" + i4 + " base fragment #" + this.f37109a[i5]);
            }
            op.f37360h = Lifecycle.State.values()[this.f37111c[i4]];
            op.f37361i = Lifecycle.State.values()[this.f37112d[i4]];
            int[] iArr = this.f37109a;
            int i6 = i3 + 2;
            if (iArr[i5] == 0) {
                z2 = false;
            }
            op.f37355c = z2;
            int i7 = iArr[i6];
            op.f37356d = i7;
            int i8 = iArr[i3 + 3];
            op.f37357e = i8;
            int i9 = i3 + 5;
            int i10 = iArr[i3 + 4];
            op.f37358f = i10;
            i3 += 6;
            int i11 = iArr[i9];
            op.f37359g = i11;
            backStackRecord.f37337d = i7;
            backStackRecord.f37338e = i8;
            backStackRecord.f37339f = i10;
            backStackRecord.f37340g = i11;
            backStackRecord.f(op);
            i4++;
        }
    }

    public BackStackRecord c(FragmentManager fragmentManager) {
        BackStackRecord backStackRecord = new BackStackRecord(fragmentManager);
        a(backStackRecord);
        backStackRecord.f37107v = this.f37115h;
        for (int i3 = 0; i3 < this.f37110b.size(); i3++) {
            String str = (String) this.f37110b.get(i3);
            if (str != null) {
                ((FragmentTransaction.Op) backStackRecord.f37336c.get(i3)).f37354b = fragmentManager.j0(str);
            }
        }
        backStackRecord.z(1);
        return backStackRecord;
    }

    public BackStackRecord d(FragmentManager fragmentManager, Map map) {
        BackStackRecord backStackRecord = new BackStackRecord(fragmentManager);
        a(backStackRecord);
        for (int i3 = 0; i3 < this.f37110b.size(); i3++) {
            String str = (String) this.f37110b.get(i3);
            if (str != null) {
                Fragment fragment = (Fragment) map.get(str);
                if (fragment == null) {
                    throw new IllegalStateException("Restoring FragmentTransaction " + this.f37114g + " failed due to missing saved state for Fragment (" + str + ")");
                }
                ((FragmentTransaction.Op) backStackRecord.f37336c.get(i3)).f37354b = fragment;
            }
        }
        return backStackRecord;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeIntArray(this.f37109a);
        parcel.writeStringList(this.f37110b);
        parcel.writeIntArray(this.f37111c);
        parcel.writeIntArray(this.f37112d);
        parcel.writeInt(this.f37113f);
        parcel.writeString(this.f37114g);
        parcel.writeInt(this.f37115h);
        parcel.writeInt(this.f37116i);
        TextUtils.writeToParcel(this.f37117j, parcel, 0);
        parcel.writeInt(this.f37118k);
        TextUtils.writeToParcel(this.f37119l, parcel, 0);
        parcel.writeStringList(this.f37120m);
        parcel.writeStringList(this.f37121n);
        parcel.writeInt(this.f37122o ? 1 : 0);
    }

    BackStackRecordState(Parcel parcel) {
        this.f37109a = parcel.createIntArray();
        this.f37110b = parcel.createStringArrayList();
        this.f37111c = parcel.createIntArray();
        this.f37112d = parcel.createIntArray();
        this.f37113f = parcel.readInt();
        this.f37114g = parcel.readString();
        this.f37115h = parcel.readInt();
        this.f37116i = parcel.readInt();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.f37117j = (CharSequence) creator.createFromParcel(parcel);
        this.f37118k = parcel.readInt();
        this.f37119l = (CharSequence) creator.createFromParcel(parcel);
        this.f37120m = parcel.createStringArrayList();
        this.f37121n = parcel.createStringArrayList();
        this.f37122o = parcel.readInt() != 0;
    }
}
