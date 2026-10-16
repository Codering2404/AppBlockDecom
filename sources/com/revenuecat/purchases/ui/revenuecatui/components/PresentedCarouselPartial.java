package com.revenuecat.purchases.ui.revenuecatui.components;

import com.revenuecat.purchases.paywalls.components.CarouselComponent;
import com.revenuecat.purchases.paywalls.components.PartialCarouselComponent;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.VerticalAlignment;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.style.CarouselComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.extensions.PageControlExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyList;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyListKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Result;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class PresentedCarouselPartial implements PresentedPartial<PresentedCarouselPartial> {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final BackgroundStyles backgroundStyles;
    private final BorderStyles borderStyles;
    private final CarouselComponentStyle.PageControlStyles pageControlStyles;
    private final PartialCarouselComponent partial;
    private final ShadowStyles shadowStyles;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final /* synthetic */ Result invoke(PartialCarouselComponent from, Map aliases) {
            BackgroundStyles backgroundStylesM753boximpl;
            Intrinsics.checkNotNullParameter(from, "from");
            Intrinsics.checkNotNullParameter(aliases, "aliases");
            Background background = from.getBackground();
            Result resultOrSuccessfullyNull = ResultKt.orSuccessfullyNull(background != null ? BackgroundStyleKt.toBackgroundStyles(background, aliases) : null);
            ColorScheme backgroundColor = from.getBackgroundColor();
            Result resultOrSuccessfullyNull2 = ResultKt.orSuccessfullyNull(backgroundColor != null ? ColorStyleKt.toColorStyles(backgroundColor, aliases) : null);
            Border border = from.getBorder();
            Result resultOrSuccessfullyNull3 = ResultKt.orSuccessfullyNull(border != null ? BorderStyleKt.toBorderStyles(border, aliases) : null);
            Shadow shadow = from.getShadow();
            Result resultOrSuccessfullyNull4 = ResultKt.orSuccessfullyNull(shadow != null ? ShadowStyleKt.toShadowStyles(shadow, aliases) : null);
            CarouselComponent.PageControl pageControl = from.getPageControl();
            Result resultOrSuccessfullyNull5 = ResultKt.orSuccessfullyNull(pageControl != null ? PageControlExtensionsKt.toPageControlStyles(pageControl, aliases) : null);
            Result.Success success = new Result.Success(Unit.f139807a);
            NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(ResultKt.collectErrors(CollectionsKt.listOf((Object[]) new Result[]{resultOrSuccessfullyNull, resultOrSuccessfullyNull2, resultOrSuccessfullyNull3, resultOrSuccessfullyNull4, resultOrSuccessfullyNull5, success})));
            if (nonEmptyListOrNull != null) {
                return new Result.Error(nonEmptyListOrNull);
            }
            Intrinsics.checkNotNull(resultOrSuccessfullyNull, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<A of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
            Object value = ((Result.Success) resultOrSuccessfullyNull).getValue();
            Intrinsics.checkNotNull(resultOrSuccessfullyNull2, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<B of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
            Object value2 = ((Result.Success) resultOrSuccessfullyNull2).getValue();
            Intrinsics.checkNotNull(resultOrSuccessfullyNull3, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<C of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
            Object value3 = ((Result.Success) resultOrSuccessfullyNull3).getValue();
            Intrinsics.checkNotNull(resultOrSuccessfullyNull4, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<D of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
            Object value4 = ((Result.Success) resultOrSuccessfullyNull4).getValue();
            Intrinsics.checkNotNull(resultOrSuccessfullyNull5, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<E of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
            Object value5 = ((Result.Success) resultOrSuccessfullyNull5).getValue();
            CarouselComponentStyle.PageControlStyles pageControlStyles = (CarouselComponentStyle.PageControlStyles) value5;
            ShadowStyles shadowStyles = (ShadowStyles) value4;
            BorderStyles borderStyles = (BorderStyles) value3;
            ColorStyles colorStyles = (ColorStyles) value2;
            BackgroundStyles backgroundStyles = (BackgroundStyles) value;
            if (backgroundStyles == null) {
                ColorStyles colorStylesM754constructorimpl = colorStyles != null ? BackgroundStyles.Color.m754constructorimpl(colorStyles) : null;
                backgroundStylesM753boximpl = colorStylesM754constructorimpl != null ? BackgroundStyles.Color.m753boximpl(colorStylesM754constructorimpl) : null;
            } else {
                backgroundStylesM753boximpl = backgroundStyles;
            }
            return new Result.Success(new PresentedCarouselPartial(backgroundStylesM753boximpl, borderStyles, shadowStyles, pageControlStyles, from));
        }

        private Companion() {
        }
    }

    public PresentedCarouselPartial(BackgroundStyles backgroundStyles, BorderStyles borderStyles, ShadowStyles shadowStyles, CarouselComponentStyle.PageControlStyles pageControlStyles, PartialCarouselComponent partial) {
        Intrinsics.checkNotNullParameter(partial, "partial");
        this.backgroundStyles = backgroundStyles;
        this.borderStyles = borderStyles;
        this.shadowStyles = shadowStyles;
        this.pageControlStyles = pageControlStyles;
        this.partial = partial;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PresentedCarouselPartial)) {
            return false;
        }
        PresentedCarouselPartial presentedCarouselPartial = (PresentedCarouselPartial) obj;
        return Intrinsics.areEqual(this.backgroundStyles, presentedCarouselPartial.backgroundStyles) && Intrinsics.areEqual(this.borderStyles, presentedCarouselPartial.borderStyles) && Intrinsics.areEqual(this.shadowStyles, presentedCarouselPartial.shadowStyles) && Intrinsics.areEqual(this.pageControlStyles, presentedCarouselPartial.pageControlStyles) && Intrinsics.areEqual(this.partial, presentedCarouselPartial.partial);
    }

    public final /* synthetic */ BackgroundStyles getBackgroundStyles() {
        return this.backgroundStyles;
    }

    public final /* synthetic */ BorderStyles getBorderStyles() {
        return this.borderStyles;
    }

    public final /* synthetic */ CarouselComponentStyle.PageControlStyles getPageControlStyles() {
        return this.pageControlStyles;
    }

    public final /* synthetic */ PartialCarouselComponent getPartial() {
        return this.partial;
    }

    public final /* synthetic */ ShadowStyles getShadowStyles() {
        return this.shadowStyles;
    }

    public int hashCode() {
        BackgroundStyles backgroundStyles = this.backgroundStyles;
        int iHashCode = (backgroundStyles == null ? 0 : backgroundStyles.hashCode()) * 31;
        BorderStyles borderStyles = this.borderStyles;
        int iHashCode2 = (iHashCode + (borderStyles == null ? 0 : borderStyles.hashCode())) * 31;
        ShadowStyles shadowStyles = this.shadowStyles;
        int iHashCode3 = (iHashCode2 + (shadowStyles == null ? 0 : shadowStyles.hashCode())) * 31;
        CarouselComponentStyle.PageControlStyles pageControlStyles = this.pageControlStyles;
        return ((iHashCode3 + (pageControlStyles != null ? pageControlStyles.hashCode() : 0)) * 31) + this.partial.hashCode();
    }

    public String toString() {
        return "PresentedCarouselPartial(backgroundStyles=" + this.backgroundStyles + ", borderStyles=" + this.borderStyles + ", shadowStyles=" + this.shadowStyles + ", pageControlStyles=" + this.pageControlStyles + ", partial=" + this.partial + ')';
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.PresentedPartial
    public PresentedCarouselPartial combine(PresentedCarouselPartial presentedCarouselPartial) {
        Boolean visible;
        Integer initialPageIndex;
        VerticalAlignment pageAlignment;
        Size size;
        Integer pagePeek;
        Float pageSpacing;
        ColorScheme backgroundColor;
        Background background;
        Padding padding;
        Padding margin;
        Shape shape;
        Border border;
        Shadow shadow;
        CarouselComponent.PageControl pageControl;
        Boolean loop;
        CarouselComponent.AutoAdvancePages autoAdvance;
        PartialCarouselComponent partialCarouselComponent = presentedCarouselPartial != null ? presentedCarouselPartial.partial : null;
        BackgroundStyles backgroundStyles = this.backgroundStyles;
        if (backgroundStyles == null) {
            backgroundStyles = presentedCarouselPartial != null ? presentedCarouselPartial.backgroundStyles : null;
        }
        BorderStyles borderStyles = this.borderStyles;
        if (borderStyles == null) {
            borderStyles = presentedCarouselPartial != null ? presentedCarouselPartial.borderStyles : null;
        }
        ShadowStyles shadowStyles = this.shadowStyles;
        if (shadowStyles == null) {
            shadowStyles = presentedCarouselPartial != null ? presentedCarouselPartial.shadowStyles : null;
        }
        CarouselComponentStyle.PageControlStyles pageControlStyles = this.pageControlStyles;
        if (pageControlStyles == null) {
            pageControlStyles = presentedCarouselPartial != null ? presentedCarouselPartial.pageControlStyles : null;
        }
        if (partialCarouselComponent == null || (visible = partialCarouselComponent.getVisible()) == null) {
            visible = this.partial.getVisible();
        }
        Boolean bool = visible;
        if (partialCarouselComponent == null || (initialPageIndex = partialCarouselComponent.getInitialPageIndex()) == null) {
            initialPageIndex = this.partial.getInitialPageIndex();
        }
        Integer num = initialPageIndex;
        if (partialCarouselComponent == null || (pageAlignment = partialCarouselComponent.getPageAlignment()) == null) {
            pageAlignment = this.partial.getPageAlignment();
        }
        VerticalAlignment verticalAlignment = pageAlignment;
        if (partialCarouselComponent == null || (size = partialCarouselComponent.getSize()) == null) {
            size = this.partial.getSize();
        }
        Size size2 = size;
        if (partialCarouselComponent == null || (pagePeek = partialCarouselComponent.getPagePeek()) == null) {
            pagePeek = this.partial.getPagePeek();
        }
        Integer num2 = pagePeek;
        if (partialCarouselComponent == null || (pageSpacing = partialCarouselComponent.getPageSpacing()) == null) {
            pageSpacing = this.partial.getPageSpacing();
        }
        Float f3 = pageSpacing;
        if (partialCarouselComponent == null || (backgroundColor = partialCarouselComponent.getBackgroundColor()) == null) {
            backgroundColor = this.partial.getBackgroundColor();
        }
        ColorScheme colorScheme = backgroundColor;
        if (partialCarouselComponent == null || (background = partialCarouselComponent.getBackground()) == null) {
            background = this.partial.getBackground();
        }
        Background background2 = background;
        if (partialCarouselComponent == null || (padding = partialCarouselComponent.getPadding()) == null) {
            padding = this.partial.getPadding();
        }
        Padding padding2 = padding;
        if (partialCarouselComponent == null || (margin = partialCarouselComponent.getMargin()) == null) {
            margin = this.partial.getMargin();
        }
        Padding padding3 = margin;
        if (partialCarouselComponent == null || (shape = partialCarouselComponent.getShape()) == null) {
            shape = this.partial.getShape();
        }
        Shape shape2 = shape;
        if (partialCarouselComponent == null || (border = partialCarouselComponent.getBorder()) == null) {
            border = this.partial.getBorder();
        }
        Border border2 = border;
        if (partialCarouselComponent == null || (shadow = partialCarouselComponent.getShadow()) == null) {
            shadow = this.partial.getShadow();
        }
        Shadow shadow2 = shadow;
        if (partialCarouselComponent == null || (pageControl = partialCarouselComponent.getPageControl()) == null) {
            pageControl = this.partial.getPageControl();
        }
        CarouselComponent.PageControl pageControl2 = pageControl;
        if (partialCarouselComponent == null || (loop = partialCarouselComponent.getLoop()) == null) {
            loop = this.partial.getLoop();
        }
        Boolean bool2 = loop;
        if (partialCarouselComponent == null || (autoAdvance = partialCarouselComponent.getAutoAdvance()) == null) {
            autoAdvance = this.partial.getAutoAdvance();
        }
        return new PresentedCarouselPartial(backgroundStyles, borderStyles, shadowStyles, pageControlStyles, new PartialCarouselComponent(bool, num, verticalAlignment, size2, num2, f3, colorScheme, background2, padding2, padding3, shape2, border2, shadow2, pageControl2, bool2, autoAdvance));
    }
}
