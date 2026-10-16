package com.revenuecat.purchases.ui.revenuecatui.components.style;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.paywalls.components.CountdownComponent;
import com.revenuecat.purchases.paywalls.components.common.LocaleId;
import com.revenuecat.purchases.paywalls.components.common.VariableLocalizationKey;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.ui.revenuecatui.components.LocalizedTextPartial;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedOverride;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.FontSpec;
import com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext;
import com.revenuecat.purchases.ui.revenuecatui.composables.OfferEligibility;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyMap;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResolvedOffer;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class TextComponentStyle implements ComponentStyle, PackageContext {
    public static final int $stable = 0;
    private final ColorStyles backgroundColor;
    private final ColorStyles color;
    private final String componentName;
    private final CountdownComponent.CountFrom countFrom;
    private final Date countdownDate;
    private final int fontSize;
    private final FontSpec fontSpec;
    private final FontWeight fontWeight;
    private final Alignment.Horizontal horizontalAlignment;
    private final PaddingValues margin;
    private final OfferEligibility offerEligibility;
    private final List<PresentedOverride<LocalizedTextPartial>> overrides;
    private final PaddingValues padding;
    private final Package rcPackage;
    private final ResolvedOffer resolvedOffer;
    private final Size size;
    private final Integer tabIndex;
    private final TextAlign textAlign;
    private final NonEmptyMap<LocaleId, String> texts;
    private final NonEmptyMap<LocaleId, NonEmptyMap<VariableLocalizationKey, String>> variableLocalizations;
    private final boolean visible;

    public /* synthetic */ TextComponentStyle(NonEmptyMap nonEmptyMap, ColorStyles colorStyles, int i3, FontWeight fontWeight, FontSpec fontSpec, TextAlign textAlign, Alignment.Horizontal horizontal, ColorStyles colorStyles2, boolean z2, Size size, PaddingValues paddingValues, PaddingValues paddingValues2, Package r13, ResolvedOffer resolvedOffer, Integer num, OfferEligibility offerEligibility, Date date, CountdownComponent.CountFrom countFrom, NonEmptyMap nonEmptyMap2, List list, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(nonEmptyMap, colorStyles, i3, fontWeight, fontSpec, textAlign, horizontal, colorStyles2, z2, size, paddingValues, paddingValues2, r13, resolvedOffer, num, offerEligibility, date, countFrom, nonEmptyMap2, list, str);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ boolean computeIsSelected(PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo, int i3) {
        return PackageContext.DefaultImpls.computeIsSelected(this, selectedPackageInfo, i3);
    }

    public final /* synthetic */ ColorStyles getBackgroundColor() {
        return this.backgroundColor;
    }

    public final /* synthetic */ ColorStyles getColor() {
        return this.color;
    }

    public final /* synthetic */ String getComponentName() {
        return this.componentName;
    }

    public final /* synthetic */ CountdownComponent.CountFrom getCountFrom() {
        return this.countFrom;
    }

    public final /* synthetic */ Date getCountdownDate() {
        return this.countdownDate;
    }

    public final /* synthetic */ int getFontSize() {
        return this.fontSize;
    }

    public final /* synthetic */ FontSpec getFontSpec() {
        return this.fontSpec;
    }

    public final /* synthetic */ FontWeight getFontWeight() {
        return this.fontWeight;
    }

    public final /* synthetic */ Alignment.Horizontal getHorizontalAlignment() {
        return this.horizontalAlignment;
    }

    public final /* synthetic */ PaddingValues getMargin() {
        return this.margin;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ OfferEligibility getOfferEligibility() {
        return this.offerEligibility;
    }

    public final /* synthetic */ List getOverrides() {
        return this.overrides;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public String getPackageUniqueId() {
        return PackageContext.DefaultImpls.getPackageUniqueId(this);
    }

    public final /* synthetic */ PaddingValues getPadding() {
        return this.padding;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ Package getRcPackage() {
        return this.rcPackage;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ ResolvedOffer getResolvedOffer() {
        return this.resolvedOffer;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle
    public /* synthetic */ Size getSize() {
        return this.size;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ Integer getTabIndex() {
        return this.tabIndex;
    }

    /* JADX INFO: renamed from: getTextAlign-buA522U, reason: not valid java name */
    public final /* synthetic */ TextAlign m842getTextAlignbuA522U() {
        return this.textAlign;
    }

    public final /* synthetic */ NonEmptyMap getTexts() {
        return this.texts;
    }

    public final /* synthetic */ NonEmptyMap getVariableLocalizations() {
        return this.variableLocalizations;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle
    public /* synthetic */ boolean getVisible() {
        return this.visible;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ OfferEligibility resolveOfferEligibility(OfferEligibility offerEligibility) {
        return PackageContext.DefaultImpls.resolveOfferEligibility(this, offerEligibility);
    }

    private TextComponentStyle(NonEmptyMap<LocaleId, String> texts, ColorStyles color, int i3, FontWeight fontWeight, FontSpec fontSpec, TextAlign textAlign, Alignment.Horizontal horizontalAlignment, ColorStyles colorStyles, boolean z2, Size size, PaddingValues padding, PaddingValues margin, Package r20, ResolvedOffer resolvedOffer, Integer num, OfferEligibility offerEligibility, Date date, CountdownComponent.CountFrom countFrom, NonEmptyMap<LocaleId, NonEmptyMap<VariableLocalizationKey, String>> variableLocalizations, List<PresentedOverride<LocalizedTextPartial>> overrides, String str) {
        Intrinsics.checkNotNullParameter(texts, "texts");
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(horizontalAlignment, "horizontalAlignment");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(padding, "padding");
        Intrinsics.checkNotNullParameter(margin, "margin");
        Intrinsics.checkNotNullParameter(countFrom, "countFrom");
        Intrinsics.checkNotNullParameter(variableLocalizations, "variableLocalizations");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        this.texts = texts;
        this.color = color;
        this.fontSize = i3;
        this.fontWeight = fontWeight;
        this.fontSpec = fontSpec;
        this.textAlign = textAlign;
        this.horizontalAlignment = horizontalAlignment;
        this.backgroundColor = colorStyles;
        this.visible = z2;
        this.size = size;
        this.padding = padding;
        this.margin = margin;
        this.rcPackage = r20;
        this.resolvedOffer = resolvedOffer;
        this.tabIndex = num;
        this.offerEligibility = offerEligibility;
        this.countdownDate = date;
        this.countFrom = countFrom;
        this.variableLocalizations = variableLocalizations;
        this.overrides = overrides;
        this.componentName = str;
    }

    public /* synthetic */ TextComponentStyle(NonEmptyMap nonEmptyMap, ColorStyles colorStyles, int i3, FontWeight fontWeight, FontSpec fontSpec, TextAlign textAlign, Alignment.Horizontal horizontal, ColorStyles colorStyles2, boolean z2, Size size, PaddingValues paddingValues, PaddingValues paddingValues2, Package r39, ResolvedOffer resolvedOffer, Integer num, OfferEligibility offerEligibility, Date date, CountdownComponent.CountFrom countFrom, NonEmptyMap nonEmptyMap2, List list, String str, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(nonEmptyMap, colorStyles, i3, fontWeight, fontSpec, textAlign, horizontal, colorStyles2, z2, size, paddingValues, paddingValues2, r39, (i4 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? null : resolvedOffer, num, (32768 & i4) != 0 ? null : offerEligibility, date, countFrom, nonEmptyMap2, list, (i4 & 1048576) != 0 ? null : str, null);
    }
}
