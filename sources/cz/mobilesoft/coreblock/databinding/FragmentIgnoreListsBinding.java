package cz.mobilesoft.coreblock.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import cz.mobilesoft.coreblock.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class FragmentIgnoreListsBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinearLayout f96645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TabLayout f96646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewPager f96647c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Toolbar f96648d;

    private FragmentIgnoreListsBinding(LinearLayout linearLayout, TabLayout tabLayout, ViewPager viewPager, Toolbar toolbar) {
        this.f96645a = linearLayout;
        this.f96646b = tabLayout;
        this.f96647c = viewPager;
        this.f96648d = toolbar;
    }

    public static FragmentIgnoreListsBinding a(View view) {
        int i3 = R.id.P0;
        TabLayout tabLayout = (TabLayout) ViewBindings.a(view, i3);
        if (tabLayout != null) {
            i3 = R.id.Q0;
            ViewPager viewPager = (ViewPager) ViewBindings.a(view, i3);
            if (viewPager != null) {
                i3 = R.id.f95636l2;
                Toolbar toolbar = (Toolbar) ViewBindings.a(view, i3);
                if (toolbar != null) {
                    return new FragmentIgnoreListsBinding((LinearLayout) view, tabLayout, viewPager, toolbar);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static FragmentIgnoreListsBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.I, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f96645a;
    }
}
