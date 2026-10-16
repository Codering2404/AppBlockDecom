package cz.mobilesoft.coreblock.base.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import androidx.core.view.KeyEventDispatcher;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.fragment.BaseScrollViewFragment;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class BaseScrollViewFragment<Binding extends ViewBinding> extends BaseFragment<Binding> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f96344b = R.id.Q1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f96345c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface OnScrollStateChangedListener {
        void e(boolean z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(BaseScrollViewFragment baseScrollViewFragment, NestedScrollView nestedScrollView, int i3, int i4, int i5, int i6) {
        baseScrollViewFragment.F(nestedScrollView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(BaseScrollViewFragment baseScrollViewFragment, View view, int i3, int i4, int i5, int i6) {
        baseScrollViewFragment.F(view);
    }

    public int C() {
        return this.f96344b;
    }

    public void F(View view) {
        KeyEventDispatcher.Component activity = getActivity();
        OnScrollStateChangedListener onScrollStateChangedListener = activity instanceof OnScrollStateChangedListener ? (OnScrollStateChangedListener) activity : null;
        if (onScrollStateChangedListener != null) {
            boolean z2 = false;
            if (view != null && view.canScrollVertically(-1)) {
                z2 = true;
            }
            onScrollStateChangedListener.e(!z2);
        }
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment
    public void y(ViewBinding binding, View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(view, "view");
        super.y(binding, view, bundle);
        View viewFindViewById = view.findViewById(C());
        this.f96345c = viewFindViewById;
        F(viewFindViewById);
        View view2 = this.f96345c;
        NestedScrollView nestedScrollView = view2 instanceof NestedScrollView ? (NestedScrollView) view2 : null;
        if (nestedScrollView != null) {
            nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: p0.c
                @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
                public final void a(NestedScrollView nestedScrollView2, int i3, int i4, int i5, int i6) {
                    BaseScrollViewFragment.D(this.f146649a, nestedScrollView2, i3, i4, i5, i6);
                }
            });
            return;
        }
        ScrollView scrollView = view2 instanceof ScrollView ? (ScrollView) view2 : null;
        if (scrollView != null) {
            scrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: p0.d
                @Override // android.view.View.OnScrollChangeListener
                public final void onScrollChange(View view3, int i3, int i4, int i5, int i6) {
                    BaseScrollViewFragment.E(this.f146650a, view3, i3, i4, i5, i6);
                }
            });
        }
    }
}
