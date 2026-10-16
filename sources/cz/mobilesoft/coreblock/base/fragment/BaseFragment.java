package cz.mobilesoft.coreblock.base.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.viewbinding.ViewBinding;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class BaseFragment<Binding extends ViewBinding> extends Fragment implements LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ViewBinding f96340a;

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private final void clearViewBinding() {
        this.f96340a = null;
        getViewLifecycleOwner().getLifecycle().removeObserver(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this.f96340a = z(inflater, viewGroup);
        return w().getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.f96340a = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        AnswersHelper.l5(getClass());
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        getViewLifecycleOwner().getLifecycle().addObserver(this);
        y(w(), view, bundle);
        x(w());
    }

    protected final ViewBinding w() {
        ViewBinding viewBinding = this.f96340a;
        if (viewBinding != null) {
            return viewBinding;
        }
        throw new IllegalArgumentException("Required value was null.");
    }

    public void x(ViewBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
    }

    public void y(ViewBinding binding, View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(view, "view");
    }

    public abstract ViewBinding z(LayoutInflater layoutInflater, ViewGroup viewGroup);
}
