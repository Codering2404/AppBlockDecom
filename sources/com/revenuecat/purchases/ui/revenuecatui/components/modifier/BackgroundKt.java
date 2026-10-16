package com.revenuecat.purchases.ui.revenuecatui.components.modifier;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.PainterModifierKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyle;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
public final /* synthetic */ class BackgroundKt {
    public static final /* synthetic */ Modifier background(Modifier modifier, ColorStyle color, Shape shape) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(shape, "shape");
        if (color instanceof ColorStyle.Solid) {
            return androidx.compose.foundation.BackgroundKt.c(modifier, ((ColorStyle.Solid) color).m782unboximpl(), shape);
        }
        if (color instanceof ColorStyle.Gradient) {
            return androidx.compose.foundation.BackgroundKt.a(modifier, ((ColorStyle.Gradient) color).m774unboximpl(), shape, 1.0f);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ Modifier background$default(Modifier modifier, ColorStyle colorStyle, Shape shape, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            shape = RectangleShapeKt.a();
        }
        return background(modifier, colorStyle, shape);
    }

    public static final /* synthetic */ Modifier background(Modifier modifier, BackgroundStyle background, Shape shape) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(background, "background");
        Intrinsics.checkNotNullParameter(shape, "shape");
        if (background instanceof BackgroundStyle.Color) {
            return background(modifier, ((BackgroundStyle.Color) background).m752unboximpl(), shape);
        }
        if (background instanceof BackgroundStyle.Image) {
            BackgroundStyle.Image image = (BackgroundStyle.Image) background;
            return PainterModifierKt.b(ClipKt.a(modifier, shape), image.getPainter(), false, Alignment.f25072a.m(), image.getContentScale(), 0.0f, null, 50, null);
        }
        if (background instanceof BackgroundStyle.Video) {
            return modifier;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ Modifier background$default(Modifier modifier, BackgroundStyle backgroundStyle, Shape shape, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            shape = RectangleShapeKt.a();
        }
        return background(modifier, backgroundStyle, shape);
    }
}
