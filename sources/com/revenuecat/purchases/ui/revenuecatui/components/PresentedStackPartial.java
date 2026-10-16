package com.revenuecat.purchases.ui.revenuecatui.components;

import com.revenuecat.purchases.paywalls.components.PartialStackComponent;
import com.revenuecat.purchases.paywalls.components.StackComponent;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.properties.Badge;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.Dimension;
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
import com.revenuecat.purchases.ui.revenuecatui.components.style.BadgeStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.BadgeStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyList;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyListKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Result;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
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
public final class PresentedStackPartial implements PresentedPartial<PresentedStackPartial> {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final BackgroundStyles backgroundStyles;
    private final BadgeStyle badgeStyle;
    private final BorderStyles borderStyles;
    private final PartialStackComponent partial;
    private final ShadowStyles shadowStyles;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final /* synthetic */ Result invoke(PartialStackComponent from, Map aliases, Function1 createBadgeStackComponentStyle) {
            BackgroundStyles backgroundStylesM753boximpl;
            Intrinsics.checkNotNullParameter(from, "from");
            Intrinsics.checkNotNullParameter(aliases, "aliases");
            Intrinsics.checkNotNullParameter(createBadgeStackComponentStyle, "createBadgeStackComponentStyle");
            Background background = from.getBackground();
            Result resultOrSuccessfullyNull = ResultKt.orSuccessfullyNull(background != null ? BackgroundStyleKt.toBackgroundStyles(background, aliases) : null);
            ColorScheme backgroundColor = from.getBackgroundColor();
            Result resultOrSuccessfullyNull2 = ResultKt.orSuccessfullyNull(backgroundColor != null ? ColorStyleKt.toColorStyles(backgroundColor, aliases) : null);
            Border border = from.getBorder();
            Result resultOrSuccessfullyNull3 = ResultKt.orSuccessfullyNull(border != null ? BorderStyleKt.toBorderStyles(border, aliases) : null);
            Shadow shadow = from.getShadow();
            Result resultOrSuccessfullyNull4 = ResultKt.orSuccessfullyNull(shadow != null ? ShadowStyleKt.toShadowStyles(shadow, aliases) : null);
            Badge badge = from.getBadge();
            Result resultOrSuccessfullyNull5 = ResultKt.orSuccessfullyNull(badge != null ? BadgeStyleKt.toBadgeStyle(badge, createBadgeStackComponentStyle) : null);
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
            BadgeStyle badgeStyle = (BadgeStyle) value5;
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
            return new Result.Success(new PresentedStackPartial(backgroundStylesM753boximpl, borderStyles, shadowStyles, badgeStyle, from));
        }

        private Companion() {
        }
    }

    public PresentedStackPartial(BackgroundStyles backgroundStyles, BorderStyles borderStyles, ShadowStyles shadowStyles, BadgeStyle badgeStyle, PartialStackComponent partial) {
        Intrinsics.checkNotNullParameter(partial, "partial");
        this.backgroundStyles = backgroundStyles;
        this.borderStyles = borderStyles;
        this.shadowStyles = shadowStyles;
        this.badgeStyle = badgeStyle;
        this.partial = partial;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PresentedStackPartial)) {
            return false;
        }
        PresentedStackPartial presentedStackPartial = (PresentedStackPartial) obj;
        return Intrinsics.areEqual(this.backgroundStyles, presentedStackPartial.backgroundStyles) && Intrinsics.areEqual(this.borderStyles, presentedStackPartial.borderStyles) && Intrinsics.areEqual(this.shadowStyles, presentedStackPartial.shadowStyles) && Intrinsics.areEqual(this.badgeStyle, presentedStackPartial.badgeStyle) && Intrinsics.areEqual(this.partial, presentedStackPartial.partial);
    }

    public final /* synthetic */ BackgroundStyles getBackgroundStyles() {
        return this.backgroundStyles;
    }

    public final /* synthetic */ BadgeStyle getBadgeStyle() {
        return this.badgeStyle;
    }

    public final /* synthetic */ BorderStyles getBorderStyles() {
        return this.borderStyles;
    }

    public final /* synthetic */ PartialStackComponent getPartial() {
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
        BadgeStyle badgeStyle = this.badgeStyle;
        return ((iHashCode3 + (badgeStyle != null ? badgeStyle.hashCode() : 0)) * 31) + this.partial.hashCode();
    }

    public String toString() {
        return "PresentedStackPartial(backgroundStyles=" + this.backgroundStyles + ", borderStyles=" + this.borderStyles + ", shadowStyles=" + this.shadowStyles + ", badgeStyle=" + this.badgeStyle + ", partial=" + this.partial + ')';
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.PresentedPartial
    public PresentedStackPartial combine(PresentedStackPartial presentedStackPartial) {
        BackgroundStyles backgroundStyles;
        BorderStyles borderStyles;
        ShadowStyles shadowStyles;
        BadgeStyle badgeStyle;
        Boolean visible;
        Dimension dimension;
        Size size;
        Float spacing;
        ColorScheme backgroundColor;
        Background background;
        Padding padding;
        Padding margin;
        Shape shape;
        Border border;
        Shadow shadow;
        Badge badge;
        StackComponent.Overflow overflow;
        String name;
        PartialStackComponent partialStackComponent = presentedStackPartial != null ? presentedStackPartial.partial : null;
        if (presentedStackPartial == null || (backgroundStyles = presentedStackPartial.backgroundStyles) == null) {
            backgroundStyles = this.backgroundStyles;
        }
        if (presentedStackPartial == null || (borderStyles = presentedStackPartial.borderStyles) == null) {
            borderStyles = this.borderStyles;
        }
        if (presentedStackPartial == null || (shadowStyles = presentedStackPartial.shadowStyles) == null) {
            shadowStyles = this.shadowStyles;
        }
        if (presentedStackPartial == null || (badgeStyle = presentedStackPartial.badgeStyle) == null) {
            badgeStyle = this.badgeStyle;
        }
        BadgeStyle badgeStyle2 = badgeStyle;
        if (partialStackComponent == null || (visible = partialStackComponent.getVisible()) == null) {
            visible = this.partial.getVisible();
        }
        Boolean bool = visible;
        if (partialStackComponent == null || (dimension = partialStackComponent.getDimension()) == null) {
            dimension = this.partial.getDimension();
        }
        Dimension dimension2 = dimension;
        if (partialStackComponent == null || (size = partialStackComponent.getSize()) == null) {
            size = this.partial.getSize();
        }
        Size size2 = size;
        if (partialStackComponent == null || (spacing = partialStackComponent.getSpacing()) == null) {
            spacing = this.partial.getSpacing();
        }
        Float f3 = spacing;
        if (partialStackComponent == null || (backgroundColor = partialStackComponent.getBackgroundColor()) == null) {
            backgroundColor = this.partial.getBackgroundColor();
        }
        ColorScheme colorScheme = backgroundColor;
        if (partialStackComponent == null || (background = partialStackComponent.getBackground()) == null) {
            background = this.partial.getBackground();
        }
        Background background2 = background;
        if (partialStackComponent == null || (padding = partialStackComponent.getPadding()) == null) {
            padding = this.partial.getPadding();
        }
        Padding padding2 = padding;
        if (partialStackComponent == null || (margin = partialStackComponent.getMargin()) == null) {
            margin = this.partial.getMargin();
        }
        Padding padding3 = margin;
        if (partialStackComponent == null || (shape = partialStackComponent.getShape()) == null) {
            shape = this.partial.getShape();
        }
        Shape shape2 = shape;
        if (partialStackComponent == null || (border = partialStackComponent.getBorder()) == null) {
            border = this.partial.getBorder();
        }
        Border border2 = border;
        if (partialStackComponent == null || (shadow = partialStackComponent.getShadow()) == null) {
            shadow = this.partial.getShadow();
        }
        Shadow shadow2 = shadow;
        if (partialStackComponent == null || (badge = partialStackComponent.getBadge()) == null) {
            badge = this.partial.getBadge();
        }
        Badge badge2 = badge;
        if (partialStackComponent == null || (overflow = partialStackComponent.getOverflow()) == null) {
            overflow = this.partial.getOverflow();
        }
        StackComponent.Overflow overflow2 = overflow;
        if (partialStackComponent == null || (name = partialStackComponent.getName()) == null) {
            name = this.partial.getName();
        }
        return new PresentedStackPartial(backgroundStyles, borderStyles, shadowStyles, badgeStyle2, new PartialStackComponent(bool, dimension2, size2, f3, colorScheme, background2, padding2, padding3, shape2, border2, shadow2, badge2, overflow2, name));
    }
}
