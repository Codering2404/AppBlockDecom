package com.revenuecat.purchases.ui.revenuecatui.extensions;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.paywalls.components.CarouselComponent;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.PaddingKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.style.CarouselComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyList;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyListKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Result;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
public final /* synthetic */ class PageControlExtensionsKt {
    public static final /* synthetic */ Result toPageControlStyles(CarouselComponent.PageControl pageControl, Map aliases) {
        Intrinsics.checkNotNullParameter(pageControl, "<this>");
        Intrinsics.checkNotNullParameter(aliases, "aliases");
        Result colorStyles = ColorStyleKt.toColorStyles(pageControl.getActive().getColor(), aliases);
        Result colorStyles2 = ColorStyleKt.toColorStyles(pageControl.getDefault().getColor(), aliases);
        ColorScheme backgroundColor = pageControl.getBackgroundColor();
        Result resultOrSuccessfullyNull = ResultKt.orSuccessfullyNull(backgroundColor != null ? ColorStyleKt.toColorStyles(backgroundColor, aliases) : null);
        Border border = pageControl.getBorder();
        Result resultOrSuccessfullyNull2 = ResultKt.orSuccessfullyNull(border != null ? BorderStyleKt.toBorderStyles(border, aliases) : null);
        Shadow shadow = pageControl.getShadow();
        Result resultOrSuccessfullyNull3 = ResultKt.orSuccessfullyNull(shadow != null ? ShadowStyleKt.toShadowStyles(shadow, aliases) : null);
        ColorScheme strokeColor = pageControl.getActive().getStrokeColor();
        Result resultOrSuccessfullyNull4 = ResultKt.orSuccessfullyNull(strokeColor != null ? ColorStyleKt.toColorStyles(strokeColor, aliases) : null);
        ColorScheme strokeColor2 = pageControl.getDefault().getStrokeColor();
        Result resultOrSuccessfullyNull5 = ResultKt.orSuccessfullyNull(strokeColor2 != null ? ColorStyleKt.toColorStyles(strokeColor2, aliases) : null);
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(ResultKt.collectErrors(CollectionsKt.listOf((Object[]) new Result[]{colorStyles, colorStyles2, resultOrSuccessfullyNull, resultOrSuccessfullyNull2, resultOrSuccessfullyNull3, resultOrSuccessfullyNull4})));
        if (nonEmptyListOrNull != null) {
            return new Result.Error(nonEmptyListOrNull);
        }
        Intrinsics.checkNotNull(colorStyles, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<A of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value = ((Result.Success) colorStyles).getValue();
        Intrinsics.checkNotNull(colorStyles2, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<B of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value2 = ((Result.Success) colorStyles2).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<C of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value3 = ((Result.Success) resultOrSuccessfullyNull).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull2, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<D of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value4 = ((Result.Success) resultOrSuccessfullyNull2).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull3, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<E of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value5 = ((Result.Success) resultOrSuccessfullyNull3).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull4, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<F of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value6 = ((Result.Success) resultOrSuccessfullyNull4).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull5, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<G of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        ColorStyles colorStyles3 = (ColorStyles) ((Result.Success) resultOrSuccessfullyNull5).getValue();
        ColorStyles colorStyles4 = (ColorStyles) value6;
        ShadowStyles shadowStyles = (ShadowStyles) value5;
        BorderStyles borderStyles = (BorderStyles) value4;
        ColorStyles colorStyles5 = (ColorStyles) value3;
        ColorStyles colorStyles6 = (ColorStyles) value2;
        ColorStyles colorStyles7 = (ColorStyles) value;
        CarouselComponent.PageControl.Position position = pageControl.getPosition();
        float fG = Dp.g(pageControl.getSpacing() != null ? r3.intValue() : 0);
        PaddingValues paddingValues = PaddingKt.toPaddingValues(pageControl.getPadding());
        PaddingValues paddingValues2 = PaddingKt.toPaddingValues(pageControl.getMargin());
        Shape shape = pageControl.getShape();
        if (shape == null) {
            shape = StyleFactory.Companion.getDEFAULT_SHAPE$revenuecatui_defaultsBc8Release();
        }
        return new Result.Success(new CarouselComponentStyle.PageControlStyles(position, fG, paddingValues, paddingValues2, colorStyles5, shape, borderStyles, shadowStyles, new CarouselComponentStyle.IndicatorStyles(Dp.g(pageControl.getActive().m589getWidthpVg5ArA()), Dp.g(pageControl.getActive().m587getHeightpVg5ArA()), colorStyles7, colorStyles4, pageControl.getActive().m588getStrokeWidth0hXNFcg() != null ? Dp.d(Dp.g(r3.f())) : null, null), new CarouselComponentStyle.IndicatorStyles(Dp.g(pageControl.getDefault().m589getWidthpVg5ArA()), Dp.g(pageControl.getDefault().m587getHeightpVg5ArA()), colorStyles6, colorStyles3, pageControl.getDefault().m588getStrokeWidth0hXNFcg() != null ? Dp.d(Dp.g(r2.f())) : null, null), null));
    }
}
