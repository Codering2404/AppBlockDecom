package com.revenuecat.purchases.ui.revenuecatui.composables;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.node.DrawModifierNode;
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
final class PlaceholderNode extends Modifier.Node implements DrawModifierNode {
    private Placeholder placeholder;

    public PlaceholderNode(Placeholder placeholder) {
        Intrinsics.checkNotNullParameter(placeholder, "placeholder");
        this.placeholder = placeholder;
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
        this.placeholder.draw$revenuecatui_defaultsBc8Release(contentDrawScope);
    }

    public final Placeholder getPlaceholder() {
        return this.placeholder;
    }

    @Override // androidx.compose.ui.node.DelegatableNode, androidx.compose.ui.node.PointerInputModifierNode
    public /* bridge */ /* synthetic */ void onDensityChange() {
        super.onDensityChange();
    }

    @Override // androidx.compose.ui.node.DelegatableNode
    public /* bridge */ /* synthetic */ void onLayoutDirectionChange() {
        super.onLayoutDirectionChange();
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public /* bridge */ /* synthetic */ void onMeasureResultChanged() {
        super.onMeasureResultChanged();
    }

    public final void setPlaceholder(Placeholder placeholder) {
        Intrinsics.checkNotNullParameter(placeholder, "<set-?>");
        this.placeholder = placeholder;
    }
}
