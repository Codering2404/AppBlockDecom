package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.TabHost;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class FragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList f37321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f37322b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private FragmentManager f37323c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f37324d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TabHost.OnTabChangeListener f37325f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TabInfo f37326g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f37327h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class DummyTabFactory implements TabHost.TabContentFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f37328a;

        @Override // android.widget.TabHost.TabContentFactory
        public View createTabContent(String str) {
            View view = new View(this.f37328a);
            view.setMinimumWidth(0);
            view.setMinimumHeight(0);
            return view;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.fragment.app.FragmentTabHost.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i3) {
                return new SavedState[i3];
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f37329a;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.f37329a + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeString(this.f37329a);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f37329a = parcel.readString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TabInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f37330a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Class f37331b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Bundle f37332c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Fragment f37333d;
    }

    private FragmentTransaction a(String str, FragmentTransaction fragmentTransaction) {
        Fragment fragment;
        TabInfo tabInfoB = b(str);
        if (this.f37326g != tabInfoB) {
            if (fragmentTransaction == null) {
                fragmentTransaction = this.f37323c.q();
            }
            TabInfo tabInfo = this.f37326g;
            if (tabInfo != null && (fragment = tabInfo.f37333d) != null) {
                fragmentTransaction.n(fragment);
            }
            if (tabInfoB != null) {
                Fragment fragment2 = tabInfoB.f37333d;
                if (fragment2 == null) {
                    Fragment fragmentA = this.f37323c.B0().a(this.f37322b.getClassLoader(), tabInfoB.f37331b.getName());
                    tabInfoB.f37333d = fragmentA;
                    fragmentA.setArguments(tabInfoB.f37332c);
                    fragmentTransaction.c(this.f37324d, tabInfoB.f37333d, tabInfoB.f37330a);
                } else {
                    fragmentTransaction.i(fragment2);
                }
            }
            this.f37326g = tabInfoB;
        }
        return fragmentTransaction;
    }

    private TabInfo b(String str) {
        int size = this.f37321a.size();
        for (int i3 = 0; i3 < size; i3++) {
            TabInfo tabInfo = (TabInfo) this.f37321a.get(i3);
            if (tabInfo.f37330a.equals(str)) {
                return tabInfo;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        int size = this.f37321a.size();
        FragmentTransaction fragmentTransactionQ = null;
        for (int i3 = 0; i3 < size; i3++) {
            TabInfo tabInfo = (TabInfo) this.f37321a.get(i3);
            Fragment fragmentN0 = this.f37323c.n0(tabInfo.f37330a);
            tabInfo.f37333d = fragmentN0;
            if (fragmentN0 != null && !fragmentN0.isDetached()) {
                if (tabInfo.f37330a.equals(currentTabTag)) {
                    this.f37326g = tabInfo;
                } else {
                    if (fragmentTransactionQ == null) {
                        fragmentTransactionQ = this.f37323c.q();
                    }
                    fragmentTransactionQ.n(tabInfo.f37333d);
                }
            }
        }
        this.f37327h = true;
        FragmentTransaction fragmentTransactionA = a(currentTabTag, fragmentTransactionQ);
        if (fragmentTransactionA != null) {
            fragmentTransactionA.j();
            this.f37323c.i0();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f37327h = false;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.f37329a);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f37329a = getCurrentTabTag();
        return savedState;
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    public void onTabChanged(String str) {
        FragmentTransaction fragmentTransactionA;
        if (this.f37327h && (fragmentTransactionA = a(str, null)) != null) {
            fragmentTransactionA.j();
        }
        TabHost.OnTabChangeListener onTabChangeListener = this.f37325f;
        if (onTabChangeListener != null) {
            onTabChangeListener.onTabChanged(str);
        }
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setOnTabChangedListener(TabHost.OnTabChangeListener onTabChangeListener) {
        this.f37325f = onTabChangeListener;
    }

    @Override // android.widget.TabHost
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }
}
