package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.ServerProtocol;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new Parcelable.Creator<BackStackState>() { // from class: androidx.fragment.app.BackStackState.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BackStackState createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public BackStackState[] newArray(int i3) {
            return new BackStackState[i3];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final List f37123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final List f37124b;

    BackStackState(List list, List list2) {
        this.f37123a = list;
        this.f37124b = list2;
    }

    List a(FragmentManager fragmentManager, Map map) {
        HashMap map2 = new HashMap(this.f37123a.size());
        for (String str : this.f37123a) {
            Fragment fragment = (Fragment) map.get(str);
            if (fragment != null) {
                map2.put(fragment.mWho, fragment);
            } else {
                Bundle bundleB = fragmentManager.C0().B(str, null);
                if (bundleB != null) {
                    ClassLoader classLoader = fragmentManager.E0().f().getClassLoader();
                    Fragment fragmentA = ((FragmentState) bundleB.getParcelable(ServerProtocol.DIALOG_PARAM_STATE)).a(fragmentManager.B0(), classLoader);
                    fragmentA.mSavedFragmentState = bundleB;
                    if (bundleB.getBundle("savedInstanceState") == null) {
                        fragmentA.mSavedFragmentState.putBundle("savedInstanceState", new Bundle());
                    }
                    Bundle bundle = bundleB.getBundle("arguments");
                    if (bundle != null) {
                        bundle.setClassLoader(classLoader);
                    }
                    fragmentA.setArguments(bundle);
                    map2.put(fragmentA.mWho, fragmentA);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f37124b.iterator();
        while (it.hasNext()) {
            arrayList.add(((BackStackRecordState) it.next()).d(fragmentManager, map2));
        }
        return arrayList;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeStringList(this.f37123a);
        parcel.writeTypedList(this.f37124b);
    }

    BackStackState(Parcel parcel) {
        this.f37123a = parcel.createStringArrayList();
        this.f37124b = parcel.createTypedArrayList(BackStackRecordState.CREATOR);
    }
}
