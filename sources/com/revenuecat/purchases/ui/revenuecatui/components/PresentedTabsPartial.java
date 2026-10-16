package com.revenuecat.purchases.ui.revenuecatui.components;

import com.revenuecat.purchases.paywalls.components.PartialTabsComponent;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyles;
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
public final class PresentedTabsPartial implements PresentedPartial<PresentedTabsPartial> {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final BackgroundStyles backgroundStyles;
    private final BorderStyles borderStyles;
    private final PartialTabsComponent partial;
    private final ShadowStyles shadowStyles;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final /* synthetic */ Result invoke(PartialTabsComponent from, Map aliases) {
            Intrinsics.checkNotNullParameter(from, "from");
            Intrinsics.checkNotNullParameter(aliases, "aliases");
            Background background = from.getBackground();
            BackgroundStyles backgroundStylesM753boximpl = null;
            Result resultOrSuccessfullyNull = ResultKt.orSuccessfullyNull(background != null ? BackgroundStyleKt.toBackgroundStyles(background, aliases) : null);
            ColorScheme backgroundColor = from.getBackgroundColor();
            Result resultOrSuccessfullyNull2 = ResultKt.orSuccessfullyNull(backgroundColor != null ? ColorStyleKt.toColorStyles(backgroundColor, aliases) : null);
            Border border = from.getBorder();
            Result resultOrSuccessfullyNull3 = ResultKt.orSuccessfullyNull(border != null ? BorderStyleKt.toBorderStyles(border, aliases) : null);
            Shadow shadow = from.getShadow();
            Result resultOrSuccessfullyNull4 = ResultKt.orSuccessfullyNull(shadow != null ? ShadowStyleKt.toShadowStyles(shadow, aliases) : null);
            Unit unit = Unit.f139807a;
            Result.Success success = new Result.Success(unit);
            Result.Success success2 = new Result.Success(unit);
            NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(ResultKt.collectErrors(CollectionsKt.listOf((Object[]) new Result[]{resultOrSuccessfullyNull, resultOrSuccessfullyNull2, resultOrSuccessfullyNull3, resultOrSuccessfullyNull4, success, success2})));
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
            Object value5 = success.getValue();
            ShadowStyles shadowStyles = (ShadowStyles) value4;
            BorderStyles borderStyles = (BorderStyles) value3;
            ColorStyles colorStyles = (ColorStyles) value2;
            BackgroundStyles backgroundStyles = (BackgroundStyles) value;
            if (backgroundStyles == null) {
                ColorStyles colorStylesM754constructorimpl = colorStyles != null ? BackgroundStyles.Color.m754constructorimpl(colorStyles) : null;
                if (colorStylesM754constructorimpl != null) {
                    backgroundStylesM753boximpl = BackgroundStyles.Color.m753boximpl(colorStylesM754constructorimpl);
                }
            } else {
                backgroundStylesM753boximpl = backgroundStyles;
            }
            return new Result.Success(new PresentedTabsPartial(backgroundStylesM753boximpl, borderStyles, shadowStyles, from));
        }

        private Companion() {
        }
    }

    public PresentedTabsPartial(BackgroundStyles backgroundStyles, BorderStyles borderStyles, ShadowStyles shadowStyles, PartialTabsComponent partial) {
        Intrinsics.checkNotNullParameter(partial, "partial");
        this.backgroundStyles = backgroundStyles;
        this.borderStyles = borderStyles;
        this.shadowStyles = shadowStyles;
        this.partial = partial;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PresentedTabsPartial)) {
            return false;
        }
        PresentedTabsPartial presentedTabsPartial = (PresentedTabsPartial) obj;
        return Intrinsics.areEqual(this.backgroundStyles, presentedTabsPartial.backgroundStyles) && Intrinsics.areEqual(this.borderStyles, presentedTabsPartial.borderStyles) && Intrinsics.areEqual(this.shadowStyles, presentedTabsPartial.shadowStyles) && Intrinsics.areEqual(this.partial, presentedTabsPartial.partial);
    }

    public final /* synthetic */ BackgroundStyles getBackgroundStyles() {
        return this.backgroundStyles;
    }

    public final /* synthetic */ BorderStyles getBorderStyles() {
        return this.borderStyles;
    }

    public final /* synthetic */ PartialTabsComponent getPartial() {
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
        return ((iHashCode2 + (shadowStyles != null ? shadowStyles.hashCode() : 0)) * 31) + this.partial.hashCode();
    }

    public String toString() {
        return "PresentedTabsPartial(backgroundStyles=" + this.backgroundStyles + ", borderStyles=" + this.borderStyles + ", shadowStyles=" + this.shadowStyles + ", partial=" + this.partial + ')';
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.PresentedPartial
    public PresentedTabsPartial combine(PresentedTabsPartial presentedTabsPartial) {
        BackgroundStyles backgroundStyles;
        BorderStyles borderStyles;
        ShadowStyles shadowStyles;
        Boolean visible;
        Size size;
        Padding padding;
        Padding margin;
        ColorScheme backgroundColor;
        Background background;
        Shape shape;
        Border border;
        Shadow shadow;
        PartialTabsComponent partialTabsComponent = presentedTabsPartial != null ? presentedTabsPartial.partial : null;
        if (presentedTabsPartial == null || (backgroundStyles = presentedTabsPartial.backgroundStyles) == null) {
            backgroundStyles = this.backgroundStyles;
        }
        if (presentedTabsPartial == null || (borderStyles = presentedTabsPartial.borderStyles) == null) {
            borderStyles = this.borderStyles;
        }
        if (presentedTabsPartial == null || (shadowStyles = presentedTabsPartial.shadowStyles) == null) {
            shadowStyles = this.shadowStyles;
        }
        if (partialTabsComponent == null || (visible = partialTabsComponent.getVisible()) == null) {
            visible = this.partial.getVisible();
        }
        if (partialTabsComponent == null || (size = partialTabsComponent.getSize()) == null) {
            size = this.partial.getSize();
        }
        if (partialTabsComponent == null || (padding = partialTabsComponent.getPadding()) == null) {
            padding = this.partial.getPadding();
        }
        if (partialTabsComponent == null || (margin = partialTabsComponent.getMargin()) == null) {
            margin = this.partial.getMargin();
        }
        if (partialTabsComponent == null || (backgroundColor = partialTabsComponent.getBackgroundColor()) == null) {
            backgroundColor = this.partial.getBackgroundColor();
        }
        if (partialTabsComponent == null || (background = partialTabsComponent.getBackground()) == null) {
            background = this.partial.getBackground();
        }
        if (partialTabsComponent == null || (shape = partialTabsComponent.getShape()) == null) {
            shape = this.partial.getShape();
        }
        if (partialTabsComponent == null || (border = partialTabsComponent.getBorder()) == null) {
            border = this.partial.getBorder();
        }
        if (partialTabsComponent == null || (shadow = partialTabsComponent.getShadow()) == null) {
            shadow = this.partial.getShadow();
        }
        return new PresentedTabsPartial(backgroundStyles, borderStyles, shadowStyles, new PartialTabsComponent(visible, size, padding, margin, backgroundColor, background, shape, border, shadow));
    }
}
