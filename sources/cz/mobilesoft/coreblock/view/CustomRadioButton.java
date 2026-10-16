package cz.mobilesoft.coreblock.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import androidx.viewbinding.ViewBinding;
import com.facebook.appevents.internal.ViewHierarchyConstants;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public abstract class CustomRadioButton<Binding extends ViewBinding> extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RadioButton f130034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LayoutInflater f130035b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewGroup f130036c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ViewBinding f130037d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f130038f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private OnToggledListener f130039g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface OnToggledListener {
    }

    protected void a(boolean z2) {
        getRadioButton().setChecked(z2);
    }

    public final Binding getBinding() {
        Binding binding = (Binding) this.f130037d;
        if (binding != null) {
            return binding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final LayoutInflater getLayoutInflater() {
        LayoutInflater layoutInflater = this.f130035b;
        if (layoutInflater != null) {
            return layoutInflater;
        }
        Intrinsics.throwUninitializedPropertyAccessException("layoutInflater");
        return null;
    }

    public final OnToggledListener getListener() {
        return this.f130039g;
    }

    public final RadioButton getRadioButton() {
        RadioButton radioButton = this.f130034a;
        if (radioButton != null) {
            return radioButton;
        }
        Intrinsics.throwUninitializedPropertyAccessException("radioButton");
        return null;
    }

    public final ViewGroup getView() {
        ViewGroup viewGroup = this.f130036c;
        if (viewGroup != null) {
            return viewGroup;
        }
        Intrinsics.throwUninitializedPropertyAccessException(ViewHierarchyConstants.VIEW_KEY);
        return null;
    }

    public final void setBinding(Binding binding) {
        Intrinsics.checkNotNullParameter(binding, "<set-?>");
        this.f130037d = binding;
    }

    public final void setChecked(boolean z2) {
        a(z2);
        this.f130038f = z2;
    }

    public final void setLayoutInflater(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "<set-?>");
        this.f130035b = layoutInflater;
    }

    public final void setListener(OnToggledListener onToggledListener) {
        this.f130039g = onToggledListener;
    }

    public final void setRadioButton(RadioButton radioButton) {
        Intrinsics.checkNotNullParameter(radioButton, "<set-?>");
        this.f130034a = radioButton;
    }

    public final void setView(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
        this.f130036c = viewGroup;
    }
}
