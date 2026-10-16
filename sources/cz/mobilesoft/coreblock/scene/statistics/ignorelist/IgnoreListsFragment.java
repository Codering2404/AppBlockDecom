package cz.mobilesoft.coreblock.scene.statistics.ignorelist;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.fragment.BaseRecyclerViewFragment;
import cz.mobilesoft.coreblock.base.fragment.BaseSurfaceToolbarFragment;
import cz.mobilesoft.coreblock.databinding.FragmentIgnoreListsBinding;
import cz.mobilesoft.coreblock.scene.statistics.ignorelist.IgnoreListsFragment;
import cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem;
import cz.mobilesoft.coreblock.util.view.ViewHelper;
import cz.mobilesoft.coreblock.util.view.ViewHelperExtKt;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class IgnoreListsFragment extends BaseSurfaceToolbarFragment<FragmentIgnoreListsBinding> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f119996f = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f119997g = 8;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final IgnoreListsFragment a() {
            return new IgnoreListsFragment();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public final class StatisticsIgnoreListAdapter extends FragmentStatePagerAdapter {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final WeakReference[] f119998h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ IgnoreListsFragment f119999i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StatisticsIgnoreListAdapter(IgnoreListsFragment ignoreListsFragment, FragmentManager fm) {
            super(fm);
            Intrinsics.checkNotNullParameter(fm, "fm");
            this.f119999i = ignoreListsFragment;
            this.f119998h = new WeakReference[getCount()];
        }

        public final WeakReference[] a() {
            return this.f119998h;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return 2;
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public Fragment getItem(int i3) {
            Fragment fragmentA = i3 == 1 ? IgnoreListDefaultFragment.f119980h.a() : IgnoreListCustomFragment.f119959i.a();
            fragmentA.setTargetFragment(this.f119999i, 930);
            this.f119998h[i3] = new WeakReference(fragmentA);
            return fragmentA;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object object) {
            Intrinsics.checkNotNullParameter(object, "object");
            return -2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i3) {
            if (i3 == 0) {
                String string = this.f119999i.requireContext().getString(R.string.N8);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                return string;
            }
            if (i3 != 1) {
                return "";
            }
            String string2 = this.f119999i.requireContext().getString(R.string.n9);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return string2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f120000a;

        static {
            int[] iArr = new int[IgnoredStatisticsItem.ItemSourceType.values().length];
            try {
                iArr[IgnoredStatisticsItem.ItemSourceType.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IgnoredStatisticsItem.ItemSourceType.CUSTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f120000a = iArr;
        }
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public void y(final FragmentIgnoreListsBinding binding, View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(view, "view");
        super.y(binding, view, bundle);
        ViewPager viewPager = binding.f96647c;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "getParentFragmentManager(...)");
        viewPager.setAdapter(new StatisticsIgnoreListAdapter(this, parentFragmentManager));
        binding.f96646b.setupWithViewPager(binding.f96647c);
        TabLayout ignoreListTabLayout = binding.f96646b;
        Intrinsics.checkNotNullExpressionValue(ignoreListTabLayout, "ignoreListTabLayout");
        ViewHelperExtKt.t(ignoreListTabLayout);
        binding.f96647c.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: cz.mobilesoft.coreblock.scene.statistics.ignorelist.IgnoreListsFragment$initViews$1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i3) {
                BaseRecyclerViewFragment baseRecyclerViewFragment;
                PagerAdapter adapter = binding.f96647c.getAdapter();
                Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type cz.mobilesoft.coreblock.scene.statistics.ignorelist.IgnoreListsFragment.StatisticsIgnoreListAdapter");
                WeakReference[] weakReferenceArrA = ((IgnoreListsFragment.StatisticsIgnoreListAdapter) adapter).a();
                int length = weakReferenceArrA.length;
                for (int i4 = 0; i4 < length; i4++) {
                    WeakReference weakReference = weakReferenceArrA[i4];
                    if (weakReference != null && (baseRecyclerViewFragment = (BaseRecyclerViewFragment) weakReference.get()) != null) {
                        if (!baseRecyclerViewFragment.getLifecycle().getCurrentState().b(Lifecycle.State.f39951f)) {
                            baseRecyclerViewFragment = null;
                        }
                        if (baseRecyclerViewFragment != null) {
                            IgnoreListsFragment ignoreListsFragment = this;
                            if (i4 == i3) {
                                ignoreListsFragment.e(baseRecyclerViewFragment.C());
                                baseRecyclerViewFragment.D(true);
                            } else {
                                baseRecyclerViewFragment.D(false);
                            }
                        }
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i3) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i3, float f3, int i4) {
            }
        });
        ViewHelper.d(binding.f96646b, getContext());
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public FragmentIgnoreListsBinding z(LayoutInflater inflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentIgnoreListsBinding fragmentIgnoreListsBindingC = FragmentIgnoreListsBinding.c(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(fragmentIgnoreListsBindingC, "inflate(...)");
        return fragmentIgnoreListsBindingC;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i4, Intent intent) {
        Object next;
        boolean z2;
        if (i3 != 930 || i4 != -1) {
            super.onActivityResult(i3, i4, intent);
            return;
        }
        Serializable serializableExtra = intent != null ? intent.getSerializableExtra("SOURCE") : null;
        IgnoredStatisticsItem.ItemSourceType itemSourceType = serializableExtra instanceof IgnoredStatisticsItem.ItemSourceType ? (IgnoredStatisticsItem.ItemSourceType) serializableExtra : null;
        if (itemSourceType != null) {
            List listD0 = getParentFragmentManager().D0();
            Intrinsics.checkNotNullExpressionValue(listD0, "getFragments(...)");
            Iterator it = listD0.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                Fragment fragment = (Fragment) next;
                int i5 = WhenMappings.f120000a[itemSourceType.ordinal()];
                if (i5 == 1) {
                    z2 = fragment instanceof IgnoreListCustomFragment;
                } else {
                    if (i5 != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    z2 = fragment instanceof IgnoreListDefaultFragment;
                }
                if (z2) {
                    break;
                }
            }
            BaseIgnoreListFragment baseIgnoreListFragment = next instanceof BaseIgnoreListFragment ? (BaseIgnoreListFragment) next : null;
            if (baseIgnoreListFragment != null) {
                baseIgnoreListFragment.S();
            }
        }
    }
}
