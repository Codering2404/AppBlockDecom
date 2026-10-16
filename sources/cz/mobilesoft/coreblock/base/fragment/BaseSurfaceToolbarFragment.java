package cz.mobilesoft.coreblock.base.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class BaseSurfaceToolbarFragment<Binding extends ViewBinding> extends BaseFragment<Binding> implements BaseScrollViewFragment.OnScrollStateChangedListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Toolbar f96346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f96347c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f96348d;

    public final Toolbar A() {
        Toolbar toolbar = this.f96346b;
        if (toolbar != null) {
            return toolbar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("toolbar");
        return null;
    }

    public final void B(Toolbar toolbar) {
        Intrinsics.checkNotNullParameter(toolbar, "<set-?>");
        this.f96346b = toolbar;
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseScrollViewFragment.OnScrollStateChangedListener
    public void e(boolean z2) {
        if (this.f96347c != z2) {
            this.f96347c = z2;
            if (z2) {
                A().setElevation(0.0f);
            } else {
                A().setElevation(this.f96348d);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f96348d = getResources().getDimensionPixelSize(R.dimen.f95488v);
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        View viewFindViewById = view.findViewById(R.id.f95636l2);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        B((Toolbar) viewFindViewById);
        super.onViewCreated(view, bundle);
    }
}
