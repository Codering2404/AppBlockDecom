package com.revenuecat.purchases.ui.revenuecatui.components;

import com.revenuecat.purchases.paywalls.components.PartialTextComponent;
import com.revenuecat.purchases.paywalls.components.common.LocaleId;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.FontWeight;
import com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.LocalizationKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.FontSpec;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.FontSpecKt;
import com.revenuecat.purchases.ui.revenuecatui.errors.PaywallValidationError;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyList;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyListKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyMap;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Result;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
public final class LocalizedTextPartial implements PresentedPartial<LocalizedTextPartial> {
    private final ColorStyles backgroundColor;
    private final ColorStyles color;
    private final FontSpec fontSpec;
    private final PartialTextComponent partial;
    private final NonEmptyMap<LocaleId, String> texts;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final /* synthetic */ Result invoke(PartialTextComponent from, NonEmptyMap using, Map aliases, Map fontAliases) {
            Result resultM787getFontSpecpDyximM;
            Intrinsics.checkNotNullParameter(from, "from");
            Intrinsics.checkNotNullParameter(using, "using");
            Intrinsics.checkNotNullParameter(aliases, "aliases");
            Intrinsics.checkNotNullParameter(fontAliases, "fontAliases");
            String strM597getTextsa7TU9Q = from.m597getTextsa7TU9Q();
            Result resultRecoverFromFontAliasError = null;
            Result resultOrSuccessfullyNull = ResultKt.orSuccessfullyNull(strM597getTextsa7TU9Q != null ? LocalizationKt.m731stringForAllLocales7v81vok(using, strM597getTextsa7TU9Q) : null);
            ColorScheme color = from.getColor();
            Result resultOrSuccessfullyNull2 = ResultKt.orSuccessfullyNull(color != null ? ColorStyleKt.toColorStyles(color, aliases) : null);
            ColorScheme backgroundColor = from.getBackgroundColor();
            Result resultOrSuccessfullyNull3 = ResultKt.orSuccessfullyNull(backgroundColor != null ? ColorStyleKt.toColorStyles(backgroundColor, aliases) : null);
            String strM596getFontNameARcRonI = from.m596getFontNameARcRonI();
            if (strM596getFontNameARcRonI != null && (resultM787getFontSpecpDyximM = FontSpecKt.m787getFontSpecpDyximM(fontAliases, strM596getFontNameARcRonI)) != null) {
                resultRecoverFromFontAliasError = FontSpecKt.recoverFromFontAliasError(resultM787getFontSpecpDyximM);
            }
            Result resultOrSuccessfullyNull4 = ResultKt.orSuccessfullyNull(resultRecoverFromFontAliasError);
            if (!(resultOrSuccessfullyNull4 instanceof Result.Success)) {
                if (!(resultOrSuccessfullyNull4 instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                resultOrSuccessfullyNull4 = new Result.Error(NonEmptyListKt.nonEmptyListOf((PaywallValidationError) ((Result.Error) resultOrSuccessfullyNull4).getValue(), new PaywallValidationError[0]));
            }
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
            return new Result.Success(new LocalizedTextPartial((NonEmptyMap) value, (ColorStyles) value2, (ColorStyles) value3, (FontSpec) value4, from, null));
        }

        private Companion() {
        }
    }

    public /* synthetic */ LocalizedTextPartial(NonEmptyMap nonEmptyMap, ColorStyles colorStyles, ColorStyles colorStyles2, FontSpec fontSpec, PartialTextComponent partialTextComponent, DefaultConstructorMarker defaultConstructorMarker) {
        this(nonEmptyMap, colorStyles, colorStyles2, fontSpec, partialTextComponent);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalizedTextPartial)) {
            return false;
        }
        LocalizedTextPartial localizedTextPartial = (LocalizedTextPartial) obj;
        return Intrinsics.areEqual(this.texts, localizedTextPartial.texts) && Intrinsics.areEqual(this.color, localizedTextPartial.color) && Intrinsics.areEqual(this.backgroundColor, localizedTextPartial.backgroundColor) && Intrinsics.areEqual(this.fontSpec, localizedTextPartial.fontSpec) && Intrinsics.areEqual(this.partial, localizedTextPartial.partial);
    }

    public final /* synthetic */ ColorStyles getBackgroundColor() {
        return this.backgroundColor;
    }

    public final /* synthetic */ ColorStyles getColor() {
        return this.color;
    }

    public final /* synthetic */ FontSpec getFontSpec() {
        return this.fontSpec;
    }

    public final /* synthetic */ PartialTextComponent getPartial() {
        return this.partial;
    }

    public final /* synthetic */ NonEmptyMap getTexts() {
        return this.texts;
    }

    public int hashCode() {
        NonEmptyMap<LocaleId, String> nonEmptyMap = this.texts;
        int iHashCode = (nonEmptyMap == null ? 0 : nonEmptyMap.hashCode()) * 31;
        ColorStyles colorStyles = this.color;
        int iHashCode2 = (iHashCode + (colorStyles == null ? 0 : colorStyles.hashCode())) * 31;
        ColorStyles colorStyles2 = this.backgroundColor;
        int iHashCode3 = (iHashCode2 + (colorStyles2 == null ? 0 : colorStyles2.hashCode())) * 31;
        FontSpec fontSpec = this.fontSpec;
        return ((iHashCode3 + (fontSpec != null ? fontSpec.hashCode() : 0)) * 31) + this.partial.hashCode();
    }

    public String toString() {
        return "LocalizedTextPartial(texts=" + this.texts + ", color=" + this.color + ", backgroundColor=" + this.backgroundColor + ", fontSpec=" + this.fontSpec + ", partial=" + this.partial + ')';
    }

    private LocalizedTextPartial(NonEmptyMap<LocaleId, String> nonEmptyMap, ColorStyles colorStyles, ColorStyles colorStyles2, FontSpec fontSpec, PartialTextComponent partialTextComponent) {
        this.texts = nonEmptyMap;
        this.color = colorStyles;
        this.backgroundColor = colorStyles2;
        this.fontSpec = fontSpec;
        this.partial = partialTextComponent;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.PresentedPartial
    public /* synthetic */ LocalizedTextPartial combine(LocalizedTextPartial localizedTextPartial) {
        NonEmptyMap<LocaleId, String> nonEmptyMap;
        ColorStyles colorStyles;
        ColorStyles colorStyles2;
        FontSpec fontSpec;
        Boolean visible;
        String strM597getTextsa7TU9Q;
        ColorScheme color;
        ColorScheme backgroundColor;
        String strM596getFontNameARcRonI;
        FontWeight fontWeight;
        Integer fontWeightInt;
        Integer fontSize;
        HorizontalAlignment horizontalAlignment;
        Size size;
        Padding padding;
        Padding margin;
        PartialTextComponent partialTextComponent = localizedTextPartial != null ? localizedTextPartial.partial : null;
        if (localizedTextPartial == null || (nonEmptyMap = localizedTextPartial.texts) == null) {
            nonEmptyMap = this.texts;
        }
        if (localizedTextPartial == null || (colorStyles = localizedTextPartial.color) == null) {
            colorStyles = this.color;
        }
        if (localizedTextPartial == null || (colorStyles2 = localizedTextPartial.backgroundColor) == null) {
            colorStyles2 = this.backgroundColor;
        }
        if (localizedTextPartial == null || (fontSpec = localizedTextPartial.fontSpec) == null) {
            fontSpec = this.fontSpec;
        }
        FontSpec fontSpec2 = fontSpec;
        if (partialTextComponent == null || (visible = partialTextComponent.getVisible()) == null) {
            visible = this.partial.getVisible();
        }
        Boolean bool = visible;
        if (partialTextComponent == null || (strM597getTextsa7TU9Q = partialTextComponent.m597getTextsa7TU9Q()) == null) {
            strM597getTextsa7TU9Q = this.partial.m597getTextsa7TU9Q();
        }
        String str = strM597getTextsa7TU9Q;
        if (partialTextComponent == null || (color = partialTextComponent.getColor()) == null) {
            color = this.partial.getColor();
        }
        ColorScheme colorScheme = color;
        if (partialTextComponent == null || (backgroundColor = partialTextComponent.getBackgroundColor()) == null) {
            backgroundColor = this.partial.getBackgroundColor();
        }
        ColorScheme colorScheme2 = backgroundColor;
        if (partialTextComponent == null || (strM596getFontNameARcRonI = partialTextComponent.m596getFontNameARcRonI()) == null) {
            strM596getFontNameARcRonI = this.partial.m596getFontNameARcRonI();
        }
        String str2 = strM596getFontNameARcRonI;
        if (partialTextComponent == null || (fontWeight = partialTextComponent.getFontWeight()) == null) {
            fontWeight = this.partial.getFontWeight();
        }
        FontWeight fontWeight2 = fontWeight;
        if (partialTextComponent == null || (fontWeightInt = partialTextComponent.getFontWeightInt()) == null) {
            fontWeightInt = this.partial.getFontWeightInt();
        }
        Integer num = fontWeightInt;
        if (partialTextComponent == null || (fontSize = partialTextComponent.getFontSize()) == null) {
            fontSize = this.partial.getFontSize();
        }
        Integer num2 = fontSize;
        if (partialTextComponent == null || (horizontalAlignment = partialTextComponent.getHorizontalAlignment()) == null) {
            horizontalAlignment = this.partial.getHorizontalAlignment();
        }
        HorizontalAlignment horizontalAlignment2 = horizontalAlignment;
        if (partialTextComponent == null || (size = partialTextComponent.getSize()) == null) {
            size = this.partial.getSize();
        }
        Size size2 = size;
        if (partialTextComponent == null || (padding = partialTextComponent.getPadding()) == null) {
            padding = this.partial.getPadding();
        }
        Padding padding2 = padding;
        if (partialTextComponent == null || (margin = partialTextComponent.getMargin()) == null) {
            margin = this.partial.getMargin();
        }
        return new LocalizedTextPartial(nonEmptyMap, colorStyles, colorStyles2, fontSpec2, new PartialTextComponent(bool, str, colorScheme, colorScheme2, str2, fontWeight2, num, num2, horizontalAlignment2, size2, padding2, margin, null));
    }
}
