package com.revenuecat.purchases.ui.revenuecatui.components.modifier;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
public final /* synthetic */ class OverlayKt {
    public static final /* synthetic */ Modifier overlay(Modifier modifier, final ColorStyle color, final Shape shape) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(shape, "shape");
        return DrawModifierKt.c(modifier, new Function1<CacheDrawScope, DrawResult>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.modifier.OverlayKt.overlay.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DrawResult invoke(CacheDrawScope drawWithCache) {
                Intrinsics.checkNotNullParameter(drawWithCache, "$this$drawWithCache");
                final Outline outlineMo29createOutlinePq9zytI = shape.mo29createOutlinePq9zytI(drawWithCache.b(), drawWithCache.getLayoutDirection(), drawWithCache);
                final ColorStyle colorStyle = color;
                return drawWithCache.x(new Function1<ContentDrawScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.modifier.OverlayKt.overlay.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((ContentDrawScope) obj);
                        return Unit.f139807a;
                    }

                    public final void invoke(ContentDrawScope onDrawWithContent) {
                        Intrinsics.checkNotNullParameter(onDrawWithContent, "$this$onDrawWithContent");
                        onDrawWithContent.i2();
                        ColorStyle colorStyle2 = colorStyle;
                        if (colorStyle2 instanceof ColorStyle.Solid) {
                            OutlineKt.e(onDrawWithContent, outlineMo29createOutlinePq9zytI, ((ColorStyle.Solid) colorStyle2).m782unboximpl(), 0.0f, null, null, 0, 60, null);
                        } else if (colorStyle2 instanceof ColorStyle.Gradient) {
                            OutlineKt.c(onDrawWithContent, outlineMo29createOutlinePq9zytI, ((ColorStyle.Gradient) colorStyle2).m774unboximpl(), 0.0f, null, null, 0, 60, null);
                        }
                    }
                });
            }
        });
    }

    public static /* synthetic */ Modifier overlay$default(Modifier modifier, ColorStyle colorStyle, Shape shape, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            shape = RectangleShapeKt.a();
        }
        return overlay(modifier, colorStyle, shape);
    }

    public static final /* synthetic */ Modifier underlay(Modifier modifier, final ColorStyle color, final Shape shape) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(shape, "shape");
        return DrawModifierKt.b(modifier, new Function1<DrawScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.modifier.OverlayKt.underlay.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((DrawScope) obj);
                return Unit.f139807a;
            }

            public final void invoke(DrawScope drawBehind) {
                Intrinsics.checkNotNullParameter(drawBehind, "$this$drawBehind");
                Outline outlineMo29createOutlinePq9zytI = shape.mo29createOutlinePq9zytI(drawBehind.b(), drawBehind.getLayoutDirection(), drawBehind);
                ColorStyle colorStyle = color;
                if (colorStyle instanceof ColorStyle.Solid) {
                    OutlineKt.e(drawBehind, outlineMo29createOutlinePq9zytI, ((ColorStyle.Solid) colorStyle).m782unboximpl(), 0.0f, null, null, 0, 60, null);
                } else if (colorStyle instanceof ColorStyle.Gradient) {
                    OutlineKt.c(drawBehind, outlineMo29createOutlinePq9zytI, ((ColorStyle.Gradient) colorStyle).m774unboximpl(), 0.0f, null, null, 0, 60, null);
                }
            }
        });
    }

    public static /* synthetic */ Modifier underlay$default(Modifier modifier, ColorStyle colorStyle, Shape shape, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            shape = RectangleShapeKt.a();
        }
        return underlay(modifier, colorStyle, shape);
    }
}
