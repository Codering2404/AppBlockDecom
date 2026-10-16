package cz.mobilesoft.coreblock.view;

import com.google.android.material.card.MaterialCardView;
import cz.mobilesoft.coreblock.databinding.ViewCheckableCardBinding;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class CheckableCardView extends MaterialCardView {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ViewCheckableCardBinding f130027t;

    public final ViewCheckableCardBinding getBinding() {
        ViewCheckableCardBinding viewCheckableCardBinding = this.f130027t;
        if (viewCheckableCardBinding != null) {
            return viewCheckableCardBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final String getTitle() {
        return getBinding().f96860b.getText().toString();
    }

    public final void setBinding(ViewCheckableCardBinding viewCheckableCardBinding) {
        Intrinsics.checkNotNullParameter(viewCheckableCardBinding, "<set-?>");
        this.f130027t = viewCheckableCardBinding;
    }

    public final void setTitle(int i3) {
        getBinding().f96860b.setText(i3);
    }

    public final void setTitle(String str) {
        getBinding().f96860b.setText(str);
    }
}
