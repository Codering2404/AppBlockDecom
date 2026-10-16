package com.revenuecat.purchases.ui.revenuecatui.components;

import com.revenuecat.purchases.paywalls.components.IconComponent;
import com.revenuecat.purchases.paywalls.components.PartialIconComponent;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.style.IconComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.IconComponentStyleKt;
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
public final class PresentedIconPartial implements PresentedPartial<PresentedIconPartial> {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final IconComponentStyle.Background background;
    private final ColorStyles colorStyles;
    private final PartialIconComponent partial;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final /* synthetic */ Result invoke(PartialIconComponent from, Map aliases) {
            Intrinsics.checkNotNullParameter(from, "from");
            Intrinsics.checkNotNullParameter(aliases, "aliases");
            ColorScheme color = from.getColor();
            Result resultOrSuccessfullyNull = ResultKt.orSuccessfullyNull(color != null ? ColorStyleKt.toColorStyles(color, aliases) : null);
            IconComponent.IconBackground iconBackground = from.getIconBackground();
            Result resultOrSuccessfullyNull2 = ResultKt.orSuccessfullyNull(iconBackground != null ? IconComponentStyleKt.toBackground(iconBackground, aliases) : null);
            Unit unit = Unit.f139807a;
            Result.Success success = new Result.Success(unit);
            Result.Success success2 = new Result.Success(unit);
            Result.Success success3 = new Result.Success(unit);
            Result.Success success4 = new Result.Success(unit);
            NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(ResultKt.collectErrors(CollectionsKt.listOf((Object[]) new Result[]{resultOrSuccessfullyNull, resultOrSuccessfullyNull2, success, success2, success3, success4})));
            if (nonEmptyListOrNull != null) {
                return new Result.Error(nonEmptyListOrNull);
            }
            Intrinsics.checkNotNull(resultOrSuccessfullyNull, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<A of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
            Object value = ((Result.Success) resultOrSuccessfullyNull).getValue();
            Intrinsics.checkNotNull(resultOrSuccessfullyNull2, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<B of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
            Object value2 = ((Result.Success) resultOrSuccessfullyNull2).getValue();
            Object value3 = success.getValue();
            Object value4 = success2.getValue();
            Object value5 = success3.getValue();
            return new Result.Success(new PresentedIconPartial((ColorStyles) value, (IconComponentStyle.Background) value2, from));
        }

        private Companion() {
        }
    }

    public PresentedIconPartial(ColorStyles colorStyles, IconComponentStyle.Background background, PartialIconComponent partial) {
        Intrinsics.checkNotNullParameter(partial, "partial");
        this.colorStyles = colorStyles;
        this.background = background;
        this.partial = partial;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PresentedIconPartial)) {
            return false;
        }
        PresentedIconPartial presentedIconPartial = (PresentedIconPartial) obj;
        return Intrinsics.areEqual(this.colorStyles, presentedIconPartial.colorStyles) && Intrinsics.areEqual(this.background, presentedIconPartial.background) && Intrinsics.areEqual(this.partial, presentedIconPartial.partial);
    }

    public final /* synthetic */ IconComponentStyle.Background getBackground() {
        return this.background;
    }

    public final /* synthetic */ ColorStyles getColorStyles() {
        return this.colorStyles;
    }

    public final /* synthetic */ PartialIconComponent getPartial() {
        return this.partial;
    }

    public int hashCode() {
        ColorStyles colorStyles = this.colorStyles;
        int iHashCode = (colorStyles == null ? 0 : colorStyles.hashCode()) * 31;
        IconComponentStyle.Background background = this.background;
        return ((iHashCode + (background != null ? background.hashCode() : 0)) * 31) + this.partial.hashCode();
    }

    public String toString() {
        return "PresentedIconPartial(colorStyles=" + this.colorStyles + ", background=" + this.background + ", partial=" + this.partial + ')';
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.PresentedPartial
    public PresentedIconPartial combine(PresentedIconPartial presentedIconPartial) {
        ColorStyles colorStyles;
        IconComponentStyle.Background background;
        Boolean visible;
        String baseUrl;
        String iconName;
        IconComponent.Formats formats;
        Size size;
        ColorScheme color;
        Padding padding;
        Padding margin;
        IconComponent.IconBackground iconBackground;
        PartialIconComponent partialIconComponent = presentedIconPartial != null ? presentedIconPartial.partial : null;
        if (presentedIconPartial == null || (colorStyles = presentedIconPartial.colorStyles) == null) {
            colorStyles = this.colorStyles;
        }
        if (presentedIconPartial == null || (background = presentedIconPartial.background) == null) {
            background = this.background;
        }
        if (partialIconComponent == null || (visible = partialIconComponent.getVisible()) == null) {
            visible = this.partial.getVisible();
        }
        if (partialIconComponent == null || (baseUrl = partialIconComponent.getBaseUrl()) == null) {
            baseUrl = this.partial.getBaseUrl();
        }
        if (partialIconComponent == null || (iconName = partialIconComponent.getIconName()) == null) {
            iconName = this.partial.getIconName();
        }
        if (partialIconComponent == null || (formats = partialIconComponent.getFormats()) == null) {
            formats = this.partial.getFormats();
        }
        if (partialIconComponent == null || (size = partialIconComponent.getSize()) == null) {
            size = this.partial.getSize();
        }
        if (partialIconComponent == null || (color = partialIconComponent.getColor()) == null) {
            color = this.partial.getColor();
        }
        if (partialIconComponent == null || (padding = partialIconComponent.getPadding()) == null) {
            padding = this.partial.getPadding();
        }
        if (partialIconComponent == null || (margin = partialIconComponent.getMargin()) == null) {
            margin = this.partial.getMargin();
        }
        if (partialIconComponent == null || (iconBackground = partialIconComponent.getIconBackground()) == null) {
            iconBackground = this.partial.getIconBackground();
        }
        return new PresentedIconPartial(colorStyles, background, new PartialIconComponent(visible, baseUrl, iconName, formats, size, color, padding, margin, iconBackground));
    }
}
