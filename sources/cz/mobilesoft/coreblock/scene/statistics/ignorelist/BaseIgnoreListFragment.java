package cz.mobilesoft.coreblock.scene.statistics.ignorelist;

import android.R;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.internal.Utility;
import cz.mobilesoft.coreblock.base.fragment.BaseRecyclerViewFragment;
import cz.mobilesoft.coreblock.base.fragment.BaseSurfaceToolbarFragment;
import cz.mobilesoft.coreblock.databinding.FragmentIgnoreListBinding;
import cz.mobilesoft.coreblock.dto.UsageAccess;
import cz.mobilesoft.coreblock.scene.statistics.ignorelist.BaseIgnoreListFragment;
import cz.mobilesoft.coreblock.scene.statistics.ignorelist.BaseIgnoreListFragmentViewModel;
import cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem;
import cz.mobilesoft.coreblock.util.helperextension.LiveDataExtKt;
import cz.mobilesoft.coreblock.util.view.ViewHelper;
import cz.mobilesoft.coreblock.view.badge.BadgeView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
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
public abstract class BaseIgnoreListFragment<VM extends BaseIgnoreListFragmentViewModel> extends BaseRecyclerViewFragment<FragmentIgnoreListBinding> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private IgnoreListAdapter f119871c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public final class IgnoreListAdapter extends RecyclerView.Adapter<BaseIgnoreListFragment<VM>.IgnoreListAdapter.ViewHolder> {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private PackageManager f119872i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private List f119873j;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public final class ViewHolder extends RecyclerView.ViewHolder {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final BadgeView f119875b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final TextView f119876c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private final TextView f119877d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private final ImageView f119878e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ IgnoreListAdapter f119879f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ViewHolder(IgnoreListAdapter ignoreListAdapter, View itemView) {
                super(itemView);
                Intrinsics.checkNotNullParameter(itemView, "itemView");
                this.f119879f = ignoreListAdapter;
                View viewFindViewById = itemView.findViewById(R.id.icon);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
                this.f119875b = (BadgeView) viewFindViewById;
                View viewFindViewById2 = itemView.findViewById(cz.mobilesoft.coreblock.R.id.f95631k1);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
                this.f119876c = (TextView) viewFindViewById2;
                View viewFindViewById3 = itemView.findViewById(cz.mobilesoft.coreblock.R.id.f95629k);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
                this.f119877d = (TextView) viewFindViewById3;
                View viewFindViewById4 = itemView.findViewById(cz.mobilesoft.coreblock.R.id.G);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
                this.f119878e = (ImageView) viewFindViewById4;
            }

            public final TextView b() {
                return this.f119877d;
            }

            public final ImageView c() {
                return this.f119878e;
            }

            public final BadgeView d() {
                return this.f119875b;
            }

            public final TextView e() {
                return this.f119876c;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final /* synthetic */ class WhenMappings {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f119880a;

            static {
                int[] iArr = new int[UsageAccess.Type.values().length];
                try {
                    iArr[UsageAccess.Type.APPLICATION.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[UsageAccess.Type.WEBSITE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f119880a = iArr;
            }
        }

        public IgnoreListAdapter() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void i(BaseIgnoreListFragment baseIgnoreListFragment, IgnoredStatisticsItem ignoredStatisticsItem, View view) {
            baseIgnoreListFragment.H().P0(ignoredStatisticsItem.c(), ignoredStatisticsItem.d());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List list = this.f119873j;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(ViewHolder holder, int i3) {
            final IgnoredStatisticsItem ignoredStatisticsItem;
            Intrinsics.checkNotNullParameter(holder, "holder");
            List list = this.f119873j;
            if (list == null || (ignoredStatisticsItem = (IgnoredStatisticsItem) CollectionsKt.getOrNull(list, i3)) == null) {
                return;
            }
            final BaseIgnoreListFragment baseIgnoreListFragment = BaseIgnoreListFragment.this;
            int i4 = WhenMappings.f119880a[ignoredStatisticsItem.d().ordinal()];
            if (i4 == 1) {
                String strC = ignoredStatisticsItem.c();
                try {
                    PackageManager packageManager = this.f119872i;
                    PackageManager packageManager2 = null;
                    if (packageManager == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("packageManager");
                        packageManager = null;
                    }
                    ApplicationInfo applicationInfo = packageManager.getApplicationInfo(strC, Utility.DEFAULT_STREAM_BUFFER_SIZE);
                    Intrinsics.checkNotNullExpressionValue(applicationInfo, "getApplicationInfo(...)");
                    BadgeView badgeViewD = holder.d();
                    PackageManager packageManager3 = this.f119872i;
                    if (packageManager3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("packageManager");
                        packageManager3 = null;
                    }
                    badgeViewD.setImageDrawable(packageManager3.getApplicationIcon(applicationInfo));
                    TextView textViewE = holder.e();
                    PackageManager packageManager4 = this.f119872i;
                    if (packageManager4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("packageManager");
                    } else {
                        packageManager2 = packageManager4;
                    }
                    textViewE.setText(packageManager2.getApplicationLabel(applicationInfo));
                } catch (PackageManager.NameNotFoundException e3) {
                    e3.printStackTrace();
                    holder.e().setText(strC);
                    holder.d().setImageResource(cz.mobilesoft.coreblock.R.drawable.f95516g2);
                }
                TextView textViewB = holder.b();
                textViewB.setText(baseIgnoreListFragment.getString(cz.mobilesoft.coreblock.R.string.I0));
                textViewB.setTextColor(ContextCompat.getColor(textViewB.getContext(), cz.mobilesoft.coreblock.R.color.f95446a));
            } else if (i4 == 2) {
                String strC2 = ignoredStatisticsItem.c();
                holder.e().setText(strC2);
                ViewHelper.g(holder.d(), strC2);
                TextView textViewB2 = holder.b();
                textViewB2.setText(baseIgnoreListFragment.getString(cz.mobilesoft.coreblock.R.string.ZF));
                textViewB2.setTextColor(ContextCompat.getColor(textViewB2.getContext(), cz.mobilesoft.coreblock.R.color.f95455j));
            }
            holder.c().setOnClickListener(new View.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.statistics.ignorelist.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseIgnoreListFragment.IgnoreListAdapter.i(baseIgnoreListFragment, ignoredStatisticsItem, view);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public ViewHolder onCreateViewHolder(ViewGroup parent, int i3) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(cz.mobilesoft.coreblock.R.layout.Q, parent, false);
            PackageManager packageManager = parent.getContext().getApplicationContext().getPackageManager();
            Intrinsics.checkNotNullExpressionValue(packageManager, "getPackageManager(...)");
            this.f119872i = packageManager;
            Intrinsics.checkNotNull(viewInflate);
            return new ViewHolder(this, viewInflate);
        }

        public final void k(List list) {
            this.f119873j = list;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M(BaseIgnoreListFragment baseIgnoreListFragment, List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        IgnoreListAdapter ignoreListAdapter = baseIgnoreListFragment.f119871c;
        if (ignoreListAdapter != null) {
            ignoreListAdapter.k(it);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat O(View view, View v2, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(v2, "v");
        Intrinsics.checkNotNullParameter(insets, "insets");
        Insets insetsF = insets.f(WindowInsetsCompat.Type.i());
        Intrinsics.checkNotNullExpressionValue(insetsF, "getInsets(...)");
        view.setPadding(0, insetsF.f33965b, 0, insetsF.f33967d);
        return insets;
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseRecyclerViewFragment
    public RecyclerView A() {
        RecyclerView ignoreListRecyclerView = ((FragmentIgnoreListBinding) w()).f96644d;
        Intrinsics.checkNotNullExpressionValue(ignoreListRecyclerView, "ignoreListRecyclerView");
        return ignoreListRecyclerView;
    }

    public final IgnoreListAdapter G() {
        return this.f119871c;
    }

    public abstract BaseIgnoreListFragmentViewModel H();

    public abstract void I(FragmentIgnoreListBinding fragmentIgnoreListBinding);

    public abstract void J(FragmentIgnoreListBinding fragmentIgnoreListBinding);

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public void x(FragmentIgnoreListBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        super.x(binding);
        LiveDataExtKt.c(this, H().L0(), new Function1() { // from class: cz.mobilesoft.coreblock.scene.statistics.ignorelist.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BaseIgnoreListFragment.M(this.f120003a, (List) obj);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public void y(FragmentIgnoreListBinding binding, View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(view, "view");
        super.y(binding, view, bundle);
        I(binding);
        J(binding);
    }

    public final void P(IgnoreListAdapter ignoreListAdapter) {
        this.f119871c = ignoreListAdapter;
    }

    public final void Q() {
        FragmentIgnoreListBinding fragmentIgnoreListBinding = (FragmentIgnoreListBinding) w();
        IgnoreListAdapter ignoreListAdapter = this.f119871c;
        boolean z2 = ignoreListAdapter == null || (ignoreListAdapter != null && ignoreListAdapter.getItemCount() == 0);
        fragmentIgnoreListBinding.f96644d.setVisibility(z2 ? 8 : 0);
        fragmentIgnoreListBinding.f96642b.f96779b.setVisibility(z2 ? 0 : 8);
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public FragmentIgnoreListBinding z(LayoutInflater inflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentIgnoreListBinding fragmentIgnoreListBindingC = FragmentIgnoreListBinding.c(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(fragmentIgnoreListBindingC, "inflate(...)");
        return fragmentIgnoreListBindingC;
    }

    public final void S() {
        H().R0();
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseRecyclerViewFragment, cz.mobilesoft.coreblock.base.fragment.BaseScrollViewFragment.OnScrollStateChangedListener
    public void e(boolean z2) {
        Fragment targetFragment = getTargetFragment();
        BaseSurfaceToolbarFragment baseSurfaceToolbarFragment = targetFragment instanceof BaseSurfaceToolbarFragment ? (BaseSurfaceToolbarFragment) targetFragment : null;
        if (baseSurfaceToolbarFragment != null) {
            baseSurfaceToolbarFragment.e(z2);
        }
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseRecyclerViewFragment, cz.mobilesoft.coreblock.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(final View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ViewCompat.C0(view, new OnApplyWindowInsetsListener() { // from class: cz.mobilesoft.coreblock.scene.statistics.ignorelist.b
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat a(View view2, WindowInsetsCompat windowInsetsCompat) {
                return BaseIgnoreListFragment.O(view, view2, windowInsetsCompat);
            }
        });
    }
}
