package com.revenuecat.purchases.ui.revenuecatui.components.style;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.ContentScale;
import com.facebook.internal.Utility;
import com.google.android.material.bottomsheet.lKiE.YznnJpHcAmeoW;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.paywalls.components.common.LocaleId;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedImagePartial;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedOverride;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext;
import com.revenuecat.purchases.ui.revenuecatui.composables.OfferEligibility;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyMap;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResolvedOffer;
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
public final class ImageComponentStyle implements ComponentStyle, PackageContext {
    public static final int $stable = 0;
    private final BorderStyles border;
    private final ContentScale contentScale;
    private final boolean ignoreTopWindowInsets;
    private final PaddingValues margin;
    private final OfferEligibility offerEligibility;
    private final ColorStyles overlay;
    private final List<PresentedOverride<PresentedImagePartial>> overrides;
    private final PaddingValues padding;
    private final Package rcPackage;
    private final ResolvedOffer resolvedOffer;
    private final ShadowStyles shadow;
    private final Shape shape;
    private final Size size;
    private final NonEmptyMap<LocaleId, ThemeImageUrls> sources;
    private final Integer tabIndex;
    private final boolean visible;

    public ImageComponentStyle(NonEmptyMap<LocaleId, ThemeImageUrls> sources, boolean z2, Size size, PaddingValues padding, PaddingValues margin, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, ColorStyles colorStyles, ContentScale contentScale, Package r13, ResolvedOffer resolvedOffer, Integer num, OfferEligibility offerEligibility, List<PresentedOverride<PresentedImagePartial>> overrides, boolean z3) {
        Intrinsics.checkNotNullParameter(sources, "sources");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(padding, "padding");
        Intrinsics.checkNotNullParameter(margin, "margin");
        Intrinsics.checkNotNullParameter(contentScale, "contentScale");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        this.sources = sources;
        this.visible = z2;
        this.size = size;
        this.padding = padding;
        this.margin = margin;
        this.shape = shape;
        this.border = borderStyles;
        this.shadow = shadowStyles;
        this.overlay = colorStyles;
        this.contentScale = contentScale;
        this.rcPackage = r13;
        this.resolvedOffer = resolvedOffer;
        this.tabIndex = num;
        this.offerEligibility = offerEligibility;
        this.overrides = overrides;
        this.ignoreTopWindowInsets = z3;
    }

    public final NonEmptyMap<LocaleId, ThemeImageUrls> component1() {
        return this.sources;
    }

    public final ContentScale component10() {
        return this.contentScale;
    }

    public final Package component11() {
        return this.rcPackage;
    }

    public final ResolvedOffer component12() {
        return this.resolvedOffer;
    }

    public final Integer component13() {
        return this.tabIndex;
    }

    public final OfferEligibility component14() {
        return this.offerEligibility;
    }

    public final List<PresentedOverride<PresentedImagePartial>> component15() {
        return this.overrides;
    }

    public final boolean component16() {
        return this.ignoreTopWindowInsets;
    }

    public final boolean component2() {
        return this.visible;
    }

    public final Size component3() {
        return this.size;
    }

    public final PaddingValues component4() {
        return this.padding;
    }

    public final PaddingValues component5() {
        return this.margin;
    }

    public final Shape component6() {
        return this.shape;
    }

    public final BorderStyles component7() {
        return this.border;
    }

    public final ShadowStyles component8() {
        return this.shadow;
    }

    public final ColorStyles component9() {
        return this.overlay;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ boolean computeIsSelected(PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo, int i3) {
        return PackageContext.DefaultImpls.computeIsSelected(this, selectedPackageInfo, i3);
    }

    public final ImageComponentStyle copy(NonEmptyMap<LocaleId, ThemeImageUrls> sources, boolean z2, Size size, PaddingValues padding, PaddingValues margin, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, ColorStyles colorStyles, ContentScale contentScale, Package r29, ResolvedOffer resolvedOffer, Integer num, OfferEligibility offerEligibility, List<PresentedOverride<PresentedImagePartial>> overrides, boolean z3) {
        Intrinsics.checkNotNullParameter(sources, "sources");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(padding, "padding");
        Intrinsics.checkNotNullParameter(margin, "margin");
        Intrinsics.checkNotNullParameter(contentScale, "contentScale");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        return new ImageComponentStyle(sources, z2, size, padding, margin, shape, borderStyles, shadowStyles, colorStyles, contentScale, r29, resolvedOffer, num, offerEligibility, overrides, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageComponentStyle)) {
            return false;
        }
        ImageComponentStyle imageComponentStyle = (ImageComponentStyle) obj;
        return Intrinsics.areEqual(this.sources, imageComponentStyle.sources) && this.visible == imageComponentStyle.visible && Intrinsics.areEqual(this.size, imageComponentStyle.size) && Intrinsics.areEqual(this.padding, imageComponentStyle.padding) && Intrinsics.areEqual(this.margin, imageComponentStyle.margin) && Intrinsics.areEqual(this.shape, imageComponentStyle.shape) && Intrinsics.areEqual(this.border, imageComponentStyle.border) && Intrinsics.areEqual(this.shadow, imageComponentStyle.shadow) && Intrinsics.areEqual(this.overlay, imageComponentStyle.overlay) && Intrinsics.areEqual(this.contentScale, imageComponentStyle.contentScale) && Intrinsics.areEqual(this.rcPackage, imageComponentStyle.rcPackage) && Intrinsics.areEqual(this.resolvedOffer, imageComponentStyle.resolvedOffer) && Intrinsics.areEqual(this.tabIndex, imageComponentStyle.tabIndex) && Intrinsics.areEqual(this.offerEligibility, imageComponentStyle.offerEligibility) && Intrinsics.areEqual(this.overrides, imageComponentStyle.overrides) && this.ignoreTopWindowInsets == imageComponentStyle.ignoreTopWindowInsets;
    }

    public final /* synthetic */ BorderStyles getBorder() {
        return this.border;
    }

    public final /* synthetic */ ContentScale getContentScale() {
        return this.contentScale;
    }

    public final /* synthetic */ boolean getIgnoreTopWindowInsets() {
        return this.ignoreTopWindowInsets;
    }

    public final /* synthetic */ PaddingValues getMargin() {
        return this.margin;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ OfferEligibility getOfferEligibility() {
        return this.offerEligibility;
    }

    public final /* synthetic */ ColorStyles getOverlay() {
        return this.overlay;
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

    public final /* synthetic */ ShadowStyles getShadow() {
        return this.shadow;
    }

    public final /* synthetic */ Shape getShape() {
        return this.shape;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle
    public /* synthetic */ Size getSize() {
        return this.size;
    }

    public final /* synthetic */ NonEmptyMap getSources() {
        return this.sources;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ Integer getTabIndex() {
        return this.tabIndex;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle
    public /* synthetic */ boolean getVisible() {
        return this.visible;
    }

    public int hashCode() {
        int iHashCode = ((((((((this.sources.hashCode() * 31) + Boolean.hashCode(this.visible)) * 31) + this.size.hashCode()) * 31) + this.padding.hashCode()) * 31) + this.margin.hashCode()) * 31;
        Shape shape = this.shape;
        int iHashCode2 = (iHashCode + (shape == null ? 0 : shape.hashCode())) * 31;
        BorderStyles borderStyles = this.border;
        int iHashCode3 = (iHashCode2 + (borderStyles == null ? 0 : borderStyles.hashCode())) * 31;
        ShadowStyles shadowStyles = this.shadow;
        int iHashCode4 = (iHashCode3 + (shadowStyles == null ? 0 : shadowStyles.hashCode())) * 31;
        ColorStyles colorStyles = this.overlay;
        int iHashCode5 = (((iHashCode4 + (colorStyles == null ? 0 : colorStyles.hashCode())) * 31) + this.contentScale.hashCode()) * 31;
        Package r12 = this.rcPackage;
        int iHashCode6 = (iHashCode5 + (r12 == null ? 0 : r12.hashCode())) * 31;
        ResolvedOffer resolvedOffer = this.resolvedOffer;
        int iHashCode7 = (iHashCode6 + (resolvedOffer == null ? 0 : resolvedOffer.hashCode())) * 31;
        Integer num = this.tabIndex;
        int iHashCode8 = (iHashCode7 + (num == null ? 0 : num.hashCode())) * 31;
        OfferEligibility offerEligibility = this.offerEligibility;
        return ((((iHashCode8 + (offerEligibility != null ? offerEligibility.hashCode() : 0)) * 31) + this.overrides.hashCode()) * 31) + Boolean.hashCode(this.ignoreTopWindowInsets);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ OfferEligibility resolveOfferEligibility(OfferEligibility offerEligibility) {
        return PackageContext.DefaultImpls.resolveOfferEligibility(this, offerEligibility);
    }

    public String toString() {
        return "ImageComponentStyle(sources=" + this.sources + ", visible=" + this.visible + ", size=" + this.size + ", padding=" + this.padding + ", margin=" + this.margin + ", shape=" + this.shape + ", border=" + this.border + ", shadow=" + this.shadow + ", overlay=" + this.overlay + ", contentScale=" + this.contentScale + ", rcPackage=" + this.rcPackage + ", resolvedOffer=" + this.resolvedOffer + YznnJpHcAmeoW.uFaQ + this.tabIndex + ", offerEligibility=" + this.offerEligibility + ", overrides=" + this.overrides + ", ignoreTopWindowInsets=" + this.ignoreTopWindowInsets + ')';
    }

    public /* synthetic */ ImageComponentStyle(NonEmptyMap nonEmptyMap, boolean z2, Size size, PaddingValues paddingValues, PaddingValues paddingValues2, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, ColorStyles colorStyles, ContentScale contentScale, Package r31, ResolvedOffer resolvedOffer, Integer num, OfferEligibility offerEligibility, List list, boolean z3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(nonEmptyMap, z2, size, paddingValues, paddingValues2, shape, borderStyles, shadowStyles, colorStyles, contentScale, r31, (i3 & 2048) != 0 ? null : resolvedOffer, num, (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? null : offerEligibility, list, (i3 & 32768) != 0 ? false : z3);
    }
}
