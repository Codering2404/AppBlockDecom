package com.revenuecat.purchases.ui.revenuecatui.components.ktx;

import androidx.compose.foundation.shape.GenericShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.revenuecat.purchases.paywalls.components.properties.CornerRadiuses;
import com.revenuecat.purchases.paywalls.components.properties.MaskShape;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
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
public final /* synthetic */ class ShapeKt {
    private static final float SCALE_Y_OFFSET_CONCAVE_CONVEX = 0.1f;

    private static final Shape convertCornerRadiusesToShape(CornerRadiuses cornerRadiuses) {
        if (cornerRadiuses instanceof CornerRadiuses.Percentage) {
            CornerRadiuses.Percentage percentage = (CornerRadiuses.Percentage) cornerRadiuses;
            return RoundedCornerShapeKt.b(percentage.getTopLeading(), percentage.getTopTrailing(), percentage.getBottomTrailing(), percentage.getBottomLeading());
        }
        if (!(cornerRadiuses instanceof CornerRadiuses.Dp)) {
            throw new NoWhenBranchMatchedException();
        }
        CornerRadiuses.Dp dp = (CornerRadiuses.Dp) cornerRadiuses;
        return RoundedCornerShapeKt.e(Dp.g((float) dp.getTopLeading()), Dp.g((float) dp.getTopTrailing()), Dp.g((float) dp.getBottomTrailing()), Dp.g((float) dp.getBottomLeading()));
    }

    public static final /* synthetic */ Shape toShape(com.revenuecat.purchases.paywalls.components.properties.Shape shape) {
        Intrinsics.checkNotNullParameter(shape, "<this>");
        return convertCornerRadiusesToShape(shape.getCornerRadiuses());
    }

    public static final /* synthetic */ Shape toShape(MaskShape maskShape) {
        Shape shapeConvertCornerRadiusesToShape;
        Intrinsics.checkNotNullParameter(maskShape, "<this>");
        if (maskShape instanceof MaskShape.Rectangle) {
            CornerRadiuses corners = ((MaskShape.Rectangle) maskShape).getCorners();
            return (corners == null || (shapeConvertCornerRadiusesToShape = convertCornerRadiusesToShape(corners)) == null) ? RectangleShapeKt.a() : shapeConvertCornerRadiusesToShape;
        }
        if (maskShape instanceof MaskShape.Concave) {
            return new GenericShape(new Function3<Path, Size, LayoutDirection, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.ktx.ShapeKt.toShape.1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    m737invoke12SF9DM((Path) obj, ((Size) obj2).m(), (LayoutDirection) obj3);
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke-12SF9DM, reason: not valid java name */
                public final void m737invoke12SF9DM(Path $receiver, long j3, LayoutDirection layoutDirection) {
                    Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                    Intrinsics.checkNotNullParameter(layoutDirection, "<anonymous parameter 1>");
                    float fG = Size.g(j3) * ShapeKt.SCALE_Y_OFFSET_CONCAVE_CONVEX * 2.0f;
                    $receiver.a(0.0f, 0.0f);
                    $receiver.c(Size.i(j3), 0.0f);
                    $receiver.c(Size.i(j3), Size.g(j3));
                    $receiver.m(Size.i(j3) / 2, Size.g(j3) - fG, 0.0f, Size.g(j3));
                    $receiver.c(0.0f, 0.0f);
                }
            });
        }
        if (maskShape instanceof MaskShape.Convex) {
            return new GenericShape(new Function3<Path, Size, LayoutDirection, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.ktx.ShapeKt.toShape.2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    m738invoke12SF9DM((Path) obj, ((Size) obj2).m(), (LayoutDirection) obj3);
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke-12SF9DM, reason: not valid java name */
                public final void m738invoke12SF9DM(Path $receiver, long j3, LayoutDirection layoutDirection) {
                    Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                    Intrinsics.checkNotNullParameter(layoutDirection, "<anonymous parameter 1>");
                    float fG = Size.g(j3) * ShapeKt.SCALE_Y_OFFSET_CONCAVE_CONVEX;
                    $receiver.a(0.0f, 0.0f);
                    $receiver.c(Size.i(j3), 0.0f);
                    $receiver.c(Size.i(j3), Size.g(j3) - fG);
                    $receiver.m(Size.i(j3) / 2, Size.g(j3) + fG, 0.0f, Size.g(j3) - fG);
                    $receiver.c(0.0f, 0.0f);
                }
            });
        }
        if (maskShape instanceof MaskShape.Circle) {
            return RoundedCornerShapeKt.g();
        }
        throw new NoWhenBranchMatchedException();
    }
}
