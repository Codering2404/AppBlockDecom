package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.PagerAdapter;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public abstract class FragmentStatePagerAdapter extends PagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FragmentManager f37310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f37311b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private FragmentTransaction f37312c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ArrayList f37313d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ArrayList f37314e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Fragment f37315f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f37316g;

    public FragmentStatePagerAdapter(FragmentManager fragmentManager) {
        this(fragmentManager, 0);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f37312c == null) {
            this.f37312c = this.f37310a.q();
        }
        while (this.f37313d.size() <= i3) {
            this.f37313d.add(null);
        }
        this.f37313d.set(i3, fragment.isAdded() ? this.f37310a.A1(fragment) : null);
        this.f37314e.set(i3, null);
        this.f37312c.r(fragment);
        if (fragment.equals(this.f37315f)) {
            this.f37315f = null;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void finishUpdate(ViewGroup viewGroup) {
        FragmentTransaction fragmentTransaction = this.f37312c;
        if (fragmentTransaction != null) {
            if (!this.f37316g) {
                try {
                    this.f37316g = true;
                    fragmentTransaction.m();
                } finally {
                    this.f37316g = false;
                }
            }
            this.f37312c = null;
        }
    }

    public abstract Fragment getItem(int i3);

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i3) {
        Fragment.SavedState savedState;
        Fragment fragment;
        if (this.f37314e.size() > i3 && (fragment = (Fragment) this.f37314e.get(i3)) != null) {
            return fragment;
        }
        if (this.f37312c == null) {
            this.f37312c = this.f37310a.q();
        }
        Fragment item = getItem(i3);
        if (this.f37313d.size() > i3 && (savedState = (Fragment.SavedState) this.f37313d.get(i3)) != null) {
            item.setInitialSavedState(savedState);
        }
        while (this.f37314e.size() <= i3) {
            this.f37314e.add(null);
        }
        item.setMenuVisibility(false);
        if (this.f37311b == 0) {
            item.setUserVisibleHint(false);
        }
        this.f37314e.set(i3, item);
        this.f37312c.b(viewGroup.getId(), item);
        if (this.f37311b == 1) {
            this.f37312c.v(item, Lifecycle.State.f39950d);
        }
        return item;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.f37313d.clear();
            this.f37314e.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.f37313d.add((Fragment.SavedState) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int i3 = Integer.parseInt(str.substring(1));
                    Fragment fragmentZ0 = this.f37310a.z0(bundle, str);
                    if (fragmentZ0 != null) {
                        while (this.f37314e.size() <= i3) {
                            this.f37314e.add(null);
                        }
                        fragmentZ0.setMenuVisibility(false);
                        this.f37314e.set(i3, fragmentZ0);
                    } else {
                        Log.w("FragmentStatePagerAdapt", "Bad fragment at key " + str);
                    }
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Parcelable saveState() {
        Bundle bundle;
        if (this.f37313d.size() > 0) {
            bundle = new Bundle();
            Fragment.SavedState[] savedStateArr = new Fragment.SavedState[this.f37313d.size()];
            this.f37313d.toArray(savedStateArr);
            bundle.putParcelableArray("states", savedStateArr);
        } else {
            bundle = null;
        }
        for (int i3 = 0; i3 < this.f37314e.size(); i3++) {
            Fragment fragment = (Fragment) this.f37314e.get(i3);
            if (fragment != null && fragment.isAdded()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                this.f37310a.n1(bundle, "f" + i3, fragment);
            }
        }
        return bundle;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i3, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f37315f;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                if (this.f37311b == 1) {
                    if (this.f37312c == null) {
                        this.f37312c = this.f37310a.q();
                    }
                    this.f37312c.v(this.f37315f, Lifecycle.State.f39950d);
                } else {
                    this.f37315f.setUserVisibleHint(false);
                }
            }
            fragment.setMenuVisibility(true);
            if (this.f37311b == 1) {
                if (this.f37312c == null) {
                    this.f37312c = this.f37310a.q();
                }
                this.f37312c.v(fragment, Lifecycle.State.f39951f);
            } else {
                fragment.setUserVisibleHint(true);
            }
            this.f37315f = fragment;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void startUpdate(ViewGroup viewGroup) {
        if (viewGroup.getId() != -1) {
            return;
        }
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }

    public FragmentStatePagerAdapter(FragmentManager fragmentManager, int i3) {
        this.f37312c = null;
        this.f37313d = new ArrayList();
        this.f37314e = new ArrayList();
        this.f37315f = null;
        this.f37310a = fragmentManager;
        this.f37311b = i3;
    }
}
