package com.revenuecat.purchases.ui.revenuecatui.components.video;

import androidx.compose.ui.Modifier;
import com.revenuecat.purchases.ui.revenuecatui.components.modifier.OverlayKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
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
public /* synthetic */ class VideoComponentViewKt$VideoComponentView$5$2 extends AdaptedFunctionReference implements Function2<Modifier, ColorStyle, Modifier> {
    public static final VideoComponentViewKt$VideoComponentView$5$2 INSTANCE = new VideoComponentViewKt$VideoComponentView$5$2();

    VideoComponentViewKt$VideoComponentView$5$2() {
        super(2, OverlayKt.class, "overlay", "overlay(Landroidx/compose/ui/Modifier;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;Landroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Modifier invoke(Modifier p02, ColorStyle p12) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        Intrinsics.checkNotNullParameter(p12, "p1");
        return OverlayKt.overlay$default(p02, p12, null, 2, null);
    }
}
