package cz.mobilesoft.coreblock.view.viewholder;

import android.view.View;
import android.widget.FrameLayout;
import cz.mobilesoft.coreblock.databinding.LayoutBaseCardViewHolderBinding;
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
public abstract class BaseDashboardCardViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LayoutBaseCardViewHolderBinding f133458a;

    public final View a() {
        FrameLayout container = b().f96760d;
        Intrinsics.checkNotNullExpressionValue(container, "container");
        return container;
    }

    public final LayoutBaseCardViewHolderBinding b() {
        LayoutBaseCardViewHolderBinding layoutBaseCardViewHolderBinding = this.f133458a;
        if (layoutBaseCardViewHolderBinding != null) {
            return layoutBaseCardViewHolderBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("baseViewBinding");
        return null;
    }
}
