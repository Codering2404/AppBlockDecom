package cz.mobilesoft.coreblock.base.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.core.view.KeyEventDispatcher;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
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
public abstract class BaseRecyclerViewFragment<Binding extends ViewBinding> extends BaseFragment<Binding> implements BaseScrollViewFragment.OnScrollStateChangedListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f96342b = true;

    public abstract RecyclerView A();

    public final boolean B() {
        return this.f96342b;
    }

    public boolean C() {
        return !A().canScrollVertically(-1);
    }

    public final void D(boolean z2) {
        this.f96342b = z2;
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseScrollViewFragment.OnScrollStateChangedListener
    public void e(boolean z2) {
        KeyEventDispatcher.Component activity = getActivity();
        BaseScrollViewFragment.OnScrollStateChangedListener onScrollStateChangedListener = activity instanceof BaseScrollViewFragment.OnScrollStateChangedListener ? (BaseScrollViewFragment.OnScrollStateChangedListener) activity : null;
        if (onScrollStateChangedListener != null) {
            onScrollStateChangedListener.e(z2);
        }
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        A().n(new RecyclerView.OnScrollListener() { // from class: cz.mobilesoft.coreblock.base.fragment.BaseRecyclerViewFragment.onViewCreated.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void b(RecyclerView recyclerView, int i3, int i4) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                if (BaseRecyclerViewFragment.this.B()) {
                    BaseRecyclerViewFragment.this.e(!recyclerView.canScrollVertically(-1));
                }
            }
        });
    }
}
