package com.revenuecat.purchases.ui.revenuecatui.components;

import com.revenuecat.purchases.paywalls.components.PartialVideoComponent;
import com.revenuecat.purchases.paywalls.components.common.LocaleId;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.FitMode;
import com.revenuecat.purchases.paywalls.components.properties.MaskShape;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls;
import com.revenuecat.purchases.paywalls.components.properties.ThemeVideoUrls;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyles;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyList;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyListKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyMap;
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
public final class PresentedVideoPartial implements PresentedPartial<PresentedVideoPartial> {
    private final BorderStyles border;
    private final NonEmptyMap<LocaleId, ThemeImageUrls> fallbackSources;
    private final ColorStyles overlay;
    private final PartialVideoComponent partial;
    private final ShadowStyles shadow;
    private final NonEmptyMap<LocaleId, ThemeVideoUrls> sources;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final /* synthetic */ Result invoke(PartialVideoComponent from, NonEmptyMap nonEmptyMap, NonEmptyMap nonEmptyMap2, Map aliases) {
            Intrinsics.checkNotNullParameter(from, "from");
            Intrinsics.checkNotNullParameter(aliases, "aliases");
            ColorScheme colorOverlay = from.getColorOverlay();
            Result resultOrSuccessfullyNull = ResultKt.orSuccessfullyNull(colorOverlay != null ? ColorStyleKt.toColorStyles(colorOverlay, aliases) : null);
            Border border = from.getBorder();
            Result resultOrSuccessfullyNull2 = ResultKt.orSuccessfullyNull(border != null ? BorderStyleKt.toBorderStyles(border, aliases) : null);
            Shadow shadow = from.getShadow();
            Result resultOrSuccessfullyNull3 = ResultKt.orSuccessfullyNull(shadow != null ? ShadowStyleKt.toShadowStyles(shadow, aliases) : null);
            Unit unit = Unit.f139807a;
            Result.Success success = new Result.Success(unit);
            Result.Success success2 = new Result.Success(unit);
            Result.Success success3 = new Result.Success(unit);
            NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(ResultKt.collectErrors(CollectionsKt.listOf((Object[]) new Result[]{resultOrSuccessfullyNull, resultOrSuccessfullyNull2, resultOrSuccessfullyNull3, success, success2, success3})));
            if (nonEmptyListOrNull != null) {
                return new Result.Error(nonEmptyListOrNull);
            }
            Intrinsics.checkNotNull(resultOrSuccessfullyNull, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<A of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
            Object value = ((Result.Success) resultOrSuccessfullyNull).getValue();
            Intrinsics.checkNotNull(resultOrSuccessfullyNull2, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<B of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
            Object value2 = ((Result.Success) resultOrSuccessfullyNull2).getValue();
            Intrinsics.checkNotNull(resultOrSuccessfullyNull3, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<C of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
            Object value3 = ((Result.Success) resultOrSuccessfullyNull3).getValue();
            Object value4 = success.getValue();
            Object value5 = success2.getValue();
            return new Result.Success(new PresentedVideoPartial(nonEmptyMap, nonEmptyMap2, (ColorStyles) value, (BorderStyles) value2, (ShadowStyles) value3, from));
        }

        private Companion() {
        }
    }

    public PresentedVideoPartial(NonEmptyMap<LocaleId, ThemeVideoUrls> nonEmptyMap, NonEmptyMap<LocaleId, ThemeImageUrls> nonEmptyMap2, ColorStyles colorStyles, BorderStyles borderStyles, ShadowStyles shadowStyles, PartialVideoComponent partial) {
        Intrinsics.checkNotNullParameter(partial, "partial");
        this.sources = nonEmptyMap;
        this.fallbackSources = nonEmptyMap2;
        this.overlay = colorStyles;
        this.border = borderStyles;
        this.shadow = shadowStyles;
        this.partial = partial;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PresentedVideoPartial)) {
            return false;
        }
        PresentedVideoPartial presentedVideoPartial = (PresentedVideoPartial) obj;
        return Intrinsics.areEqual(this.sources, presentedVideoPartial.sources) && Intrinsics.areEqual(this.fallbackSources, presentedVideoPartial.fallbackSources) && Intrinsics.areEqual(this.overlay, presentedVideoPartial.overlay) && Intrinsics.areEqual(this.border, presentedVideoPartial.border) && Intrinsics.areEqual(this.shadow, presentedVideoPartial.shadow) && Intrinsics.areEqual(this.partial, presentedVideoPartial.partial);
    }

    public final /* synthetic */ BorderStyles getBorder() {
        return this.border;
    }

    public final /* synthetic */ NonEmptyMap getFallbackSources() {
        return this.fallbackSources;
    }

    public final /* synthetic */ ColorStyles getOverlay() {
        return this.overlay;
    }

    public final /* synthetic */ PartialVideoComponent getPartial() {
        return this.partial;
    }

    public final /* synthetic */ ShadowStyles getShadow() {
        return this.shadow;
    }

    public final /* synthetic */ NonEmptyMap getSources() {
        return this.sources;
    }

    public int hashCode() {
        NonEmptyMap<LocaleId, ThemeVideoUrls> nonEmptyMap = this.sources;
        int iHashCode = (nonEmptyMap == null ? 0 : nonEmptyMap.hashCode()) * 31;
        NonEmptyMap<LocaleId, ThemeImageUrls> nonEmptyMap2 = this.fallbackSources;
        int iHashCode2 = (iHashCode + (nonEmptyMap2 == null ? 0 : nonEmptyMap2.hashCode())) * 31;
        ColorStyles colorStyles = this.overlay;
        int iHashCode3 = (iHashCode2 + (colorStyles == null ? 0 : colorStyles.hashCode())) * 31;
        BorderStyles borderStyles = this.border;
        int iHashCode4 = (iHashCode3 + (borderStyles == null ? 0 : borderStyles.hashCode())) * 31;
        ShadowStyles shadowStyles = this.shadow;
        return ((iHashCode4 + (shadowStyles != null ? shadowStyles.hashCode() : 0)) * 31) + this.partial.hashCode();
    }

    public String toString() {
        return "PresentedVideoPartial(sources=" + this.sources + ", fallbackSources=" + this.fallbackSources + ", overlay=" + this.overlay + ", border=" + this.border + ", shadow=" + this.shadow + ", partial=" + this.partial + ')';
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.PresentedPartial
    public PresentedVideoPartial combine(PresentedVideoPartial presentedVideoPartial) {
        ColorStyles colorStyles;
        BorderStyles borderStyles;
        ShadowStyles shadowStyles;
        Boolean visible;
        ThemeVideoUrls source;
        ThemeImageUrls fallbackSource;
        Boolean showControls;
        Boolean autoplay;
        Boolean loop;
        Boolean muteAudio;
        Size size;
        FitMode fitMode;
        MaskShape maskShape;
        ColorScheme colorOverlay;
        Padding padding;
        Padding margin;
        Border border;
        Shadow shadow;
        NonEmptyMap<LocaleId, ThemeVideoUrls> nonEmptyMap = presentedVideoPartial != null ? presentedVideoPartial.sources : null;
        NonEmptyMap<LocaleId, ThemeImageUrls> nonEmptyMap2 = presentedVideoPartial != null ? presentedVideoPartial.fallbackSources : null;
        PartialVideoComponent partialVideoComponent = presentedVideoPartial != null ? presentedVideoPartial.partial : null;
        if (nonEmptyMap == null) {
            nonEmptyMap = this.sources;
        }
        NonEmptyMap<LocaleId, ThemeVideoUrls> nonEmptyMap3 = nonEmptyMap;
        if (nonEmptyMap2 == null) {
            nonEmptyMap2 = this.fallbackSources;
        }
        NonEmptyMap<LocaleId, ThemeImageUrls> nonEmptyMap4 = nonEmptyMap2;
        if (presentedVideoPartial == null || (colorStyles = presentedVideoPartial.overlay) == null) {
            colorStyles = this.overlay;
        }
        ColorStyles colorStyles2 = colorStyles;
        if (presentedVideoPartial == null || (borderStyles = presentedVideoPartial.border) == null) {
            borderStyles = this.border;
        }
        BorderStyles borderStyles2 = borderStyles;
        if (presentedVideoPartial == null || (shadowStyles = presentedVideoPartial.shadow) == null) {
            shadowStyles = this.shadow;
        }
        ShadowStyles shadowStyles2 = shadowStyles;
        if (partialVideoComponent == null || (visible = partialVideoComponent.getVisible()) == null) {
            visible = this.partial.getVisible();
        }
        Boolean bool = visible;
        if (partialVideoComponent == null || (source = partialVideoComponent.getSource()) == null) {
            source = this.partial.getSource();
        }
        ThemeVideoUrls themeVideoUrls = source;
        if (partialVideoComponent == null || (fallbackSource = partialVideoComponent.getFallbackSource()) == null) {
            fallbackSource = this.partial.getFallbackSource();
        }
        ThemeImageUrls themeImageUrls = fallbackSource;
        if (partialVideoComponent == null || (showControls = partialVideoComponent.getShowControls()) == null) {
            showControls = this.partial.getShowControls();
        }
        Boolean bool2 = showControls;
        if (partialVideoComponent == null || (autoplay = partialVideoComponent.getAutoplay()) == null) {
            autoplay = this.partial.getAutoplay();
        }
        Boolean bool3 = autoplay;
        if (partialVideoComponent == null || (loop = partialVideoComponent.getLoop()) == null) {
            loop = this.partial.getLoop();
        }
        Boolean bool4 = loop;
        if (partialVideoComponent == null || (muteAudio = partialVideoComponent.getMuteAudio()) == null) {
            muteAudio = this.partial.getMuteAudio();
        }
        Boolean bool5 = muteAudio;
        if (partialVideoComponent == null || (size = partialVideoComponent.getSize()) == null) {
            size = this.partial.getSize();
        }
        Size size2 = size;
        if (partialVideoComponent == null || (fitMode = partialVideoComponent.getFitMode()) == null) {
            fitMode = this.partial.getFitMode();
        }
        FitMode fitMode2 = fitMode;
        if (partialVideoComponent == null || (maskShape = partialVideoComponent.getMaskShape()) == null) {
            maskShape = this.partial.getMaskShape();
        }
        MaskShape maskShape2 = maskShape;
        if (partialVideoComponent == null || (colorOverlay = partialVideoComponent.getColorOverlay()) == null) {
            colorOverlay = this.partial.getColorOverlay();
        }
        ColorScheme colorScheme = colorOverlay;
        if (partialVideoComponent == null || (padding = partialVideoComponent.getPadding()) == null) {
            padding = this.partial.getPadding();
        }
        Padding padding2 = padding;
        if (partialVideoComponent == null || (margin = partialVideoComponent.getMargin()) == null) {
            margin = this.partial.getMargin();
        }
        Padding padding3 = margin;
        if (partialVideoComponent == null || (border = partialVideoComponent.getBorder()) == null) {
            border = this.partial.getBorder();
        }
        Border border2 = border;
        if (partialVideoComponent == null || (shadow = partialVideoComponent.getShadow()) == null) {
            shadow = this.partial.getShadow();
        }
        return new PresentedVideoPartial(nonEmptyMap3, nonEmptyMap4, colorStyles2, borderStyles2, shadowStyles2, new PartialVideoComponent(themeVideoUrls, themeImageUrls, bool, bool2, bool3, bool4, bool5, size2, fitMode2, maskShape2, colorScheme, padding2, padding3, border2, shadow, (String) null, 32768, (DefaultConstructorMarker) null));
    }
}
