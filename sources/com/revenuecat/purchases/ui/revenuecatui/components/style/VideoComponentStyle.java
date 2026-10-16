package com.revenuecat.purchases.ui.revenuecatui.components.style;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.ContentScale;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.paywalls.components.common.LocaleId;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls;
import com.revenuecat.purchases.paywalls.components.properties.ThemeVideoUrls;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedOverride;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedVideoPartial;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext;
import com.revenuecat.purchases.ui.revenuecatui.composables.OfferEligibility;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyMap;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResolvedOffer;
import com.sun.jna.Function;
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
public final class VideoComponentStyle implements ComponentStyle, PackageContext {
    public static final int $stable = 0;
    private final boolean autoplay;
    private final BorderStyles border;
    private final ContentScale contentScale;
    private final NonEmptyMap<LocaleId, ThemeImageUrls> fallbackSources;
    private final boolean ignoreTopWindowInsets;
    private final boolean loop;
    private final PaddingValues margin;
    private final boolean muteAudio;
    private final OfferEligibility offerEligibility;
    private final ColorStyles overlay;
    private final List<PresentedOverride<PresentedVideoPartial>> overrides;
    private final PaddingValues padding;
    private final Package rcPackage;
    private final ResolvedOffer resolvedOffer;
    private final ShadowStyles shadow;
    private final Shape shape;
    private final boolean showControls;
    private final Size size;
    private final NonEmptyMap<LocaleId, ThemeVideoUrls> sources;
    private final Integer tabIndex;
    private final boolean visible;

    public VideoComponentStyle(NonEmptyMap<LocaleId, ThemeVideoUrls> sources, NonEmptyMap<LocaleId, ThemeImageUrls> nonEmptyMap, boolean z2, boolean z3, boolean z4, boolean z5, Size size, boolean z6, PaddingValues padding, PaddingValues margin, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, ColorStyles colorStyles, ContentScale contentScale, Package r19, ResolvedOffer resolvedOffer, Integer num, OfferEligibility offerEligibility, boolean z7, List<PresentedOverride<PresentedVideoPartial>> overrides) {
        Intrinsics.checkNotNullParameter(sources, "sources");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(padding, "padding");
        Intrinsics.checkNotNullParameter(margin, "margin");
        Intrinsics.checkNotNullParameter(contentScale, "contentScale");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        this.sources = sources;
        this.fallbackSources = nonEmptyMap;
        this.showControls = z2;
        this.autoplay = z3;
        this.loop = z4;
        this.muteAudio = z5;
        this.size = size;
        this.visible = z6;
        this.padding = padding;
        this.margin = margin;
        this.shape = shape;
        this.border = borderStyles;
        this.shadow = shadowStyles;
        this.overlay = colorStyles;
        this.contentScale = contentScale;
        this.rcPackage = r19;
        this.resolvedOffer = resolvedOffer;
        this.tabIndex = num;
        this.offerEligibility = offerEligibility;
        this.ignoreTopWindowInsets = z7;
        this.overrides = overrides;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VideoComponentStyle copy$default(VideoComponentStyle videoComponentStyle, NonEmptyMap nonEmptyMap, NonEmptyMap nonEmptyMap2, boolean z2, boolean z3, boolean z4, boolean z5, Size size, boolean z6, PaddingValues paddingValues, PaddingValues paddingValues2, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, ColorStyles colorStyles, ContentScale contentScale, Package r33, ResolvedOffer resolvedOffer, Integer num, OfferEligibility offerEligibility, boolean z7, List list, int i3, Object obj) {
        List list2;
        boolean z8;
        NonEmptyMap nonEmptyMap3 = (i3 & 1) != 0 ? videoComponentStyle.sources : nonEmptyMap;
        NonEmptyMap nonEmptyMap4 = (i3 & 2) != 0 ? videoComponentStyle.fallbackSources : nonEmptyMap2;
        boolean z9 = (i3 & 4) != 0 ? videoComponentStyle.showControls : z2;
        boolean z10 = (i3 & 8) != 0 ? videoComponentStyle.autoplay : z3;
        boolean z11 = (i3 & 16) != 0 ? videoComponentStyle.loop : z4;
        boolean z12 = (i3 & 32) != 0 ? videoComponentStyle.muteAudio : z5;
        Size size2 = (i3 & 64) != 0 ? videoComponentStyle.size : size;
        boolean z13 = (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? videoComponentStyle.visible : z6;
        PaddingValues paddingValues3 = (i3 & Function.MAX_NARGS) != 0 ? videoComponentStyle.padding : paddingValues;
        PaddingValues paddingValues4 = (i3 & 512) != 0 ? videoComponentStyle.margin : paddingValues2;
        Shape shape2 = (i3 & 1024) != 0 ? videoComponentStyle.shape : shape;
        BorderStyles borderStyles2 = (i3 & 2048) != 0 ? videoComponentStyle.border : borderStyles;
        ShadowStyles shadowStyles2 = (i3 & 4096) != 0 ? videoComponentStyle.shadow : shadowStyles;
        ColorStyles colorStyles2 = (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? videoComponentStyle.overlay : colorStyles;
        NonEmptyMap nonEmptyMap5 = nonEmptyMap3;
        ContentScale contentScale2 = (i3 & 16384) != 0 ? videoComponentStyle.contentScale : contentScale;
        Package r19 = (i3 & 32768) != 0 ? videoComponentStyle.rcPackage : r33;
        ResolvedOffer resolvedOffer2 = (i3 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? videoComponentStyle.resolvedOffer : resolvedOffer;
        Integer num2 = (i3 & 131072) != 0 ? videoComponentStyle.tabIndex : num;
        OfferEligibility offerEligibility2 = (i3 & 262144) != 0 ? videoComponentStyle.offerEligibility : offerEligibility;
        boolean z14 = (i3 & 524288) != 0 ? videoComponentStyle.ignoreTopWindowInsets : z7;
        if ((i3 & 1048576) != 0) {
            z8 = z14;
            list2 = videoComponentStyle.overrides;
        } else {
            list2 = list;
            z8 = z14;
        }
        return videoComponentStyle.copy(nonEmptyMap5, nonEmptyMap4, z9, z10, z11, z12, size2, z13, paddingValues3, paddingValues4, shape2, borderStyles2, shadowStyles2, colorStyles2, contentScale2, r19, resolvedOffer2, num2, offerEligibility2, z8, list2);
    }

    public final NonEmptyMap<LocaleId, ThemeVideoUrls> component1() {
        return this.sources;
    }

    public final PaddingValues component10() {
        return this.margin;
    }

    public final Shape component11() {
        return this.shape;
    }

    public final BorderStyles component12() {
        return this.border;
    }

    public final ShadowStyles component13() {
        return this.shadow;
    }

    public final ColorStyles component14() {
        return this.overlay;
    }

    public final ContentScale component15() {
        return this.contentScale;
    }

    public final Package component16() {
        return this.rcPackage;
    }

    public final ResolvedOffer component17() {
        return this.resolvedOffer;
    }

    public final Integer component18() {
        return this.tabIndex;
    }

    public final OfferEligibility component19() {
        return this.offerEligibility;
    }

    public final NonEmptyMap<LocaleId, ThemeImageUrls> component2() {
        return this.fallbackSources;
    }

    public final boolean component20() {
        return this.ignoreTopWindowInsets;
    }

    public final List<PresentedOverride<PresentedVideoPartial>> component21() {
        return this.overrides;
    }

    public final boolean component3() {
        return this.showControls;
    }

    public final boolean component4() {
        return this.autoplay;
    }

    public final boolean component5() {
        return this.loop;
    }

    public final boolean component6() {
        return this.muteAudio;
    }

    public final Size component7() {
        return this.size;
    }

    public final boolean component8() {
        return this.visible;
    }

    public final PaddingValues component9() {
        return this.padding;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ boolean computeIsSelected(PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo, int i3) {
        return PackageContext.DefaultImpls.computeIsSelected(this, selectedPackageInfo, i3);
    }

    public final VideoComponentStyle copy(NonEmptyMap<LocaleId, ThemeVideoUrls> sources, NonEmptyMap<LocaleId, ThemeImageUrls> nonEmptyMap, boolean z2, boolean z3, boolean z4, boolean z5, Size size, boolean z6, PaddingValues padding, PaddingValues margin, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, ColorStyles colorStyles, ContentScale contentScale, Package r39, ResolvedOffer resolvedOffer, Integer num, OfferEligibility offerEligibility, boolean z7, List<PresentedOverride<PresentedVideoPartial>> overrides) {
        Intrinsics.checkNotNullParameter(sources, "sources");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(padding, "padding");
        Intrinsics.checkNotNullParameter(margin, "margin");
        Intrinsics.checkNotNullParameter(contentScale, "contentScale");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        return new VideoComponentStyle(sources, nonEmptyMap, z2, z3, z4, z5, size, z6, padding, margin, shape, borderStyles, shadowStyles, colorStyles, contentScale, r39, resolvedOffer, num, offerEligibility, z7, overrides);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoComponentStyle)) {
            return false;
        }
        VideoComponentStyle videoComponentStyle = (VideoComponentStyle) obj;
        return Intrinsics.areEqual(this.sources, videoComponentStyle.sources) && Intrinsics.areEqual(this.fallbackSources, videoComponentStyle.fallbackSources) && this.showControls == videoComponentStyle.showControls && this.autoplay == videoComponentStyle.autoplay && this.loop == videoComponentStyle.loop && this.muteAudio == videoComponentStyle.muteAudio && Intrinsics.areEqual(this.size, videoComponentStyle.size) && this.visible == videoComponentStyle.visible && Intrinsics.areEqual(this.padding, videoComponentStyle.padding) && Intrinsics.areEqual(this.margin, videoComponentStyle.margin) && Intrinsics.areEqual(this.shape, videoComponentStyle.shape) && Intrinsics.areEqual(this.border, videoComponentStyle.border) && Intrinsics.areEqual(this.shadow, videoComponentStyle.shadow) && Intrinsics.areEqual(this.overlay, videoComponentStyle.overlay) && Intrinsics.areEqual(this.contentScale, videoComponentStyle.contentScale) && Intrinsics.areEqual(this.rcPackage, videoComponentStyle.rcPackage) && Intrinsics.areEqual(this.resolvedOffer, videoComponentStyle.resolvedOffer) && Intrinsics.areEqual(this.tabIndex, videoComponentStyle.tabIndex) && Intrinsics.areEqual(this.offerEligibility, videoComponentStyle.offerEligibility) && this.ignoreTopWindowInsets == videoComponentStyle.ignoreTopWindowInsets && Intrinsics.areEqual(this.overrides, videoComponentStyle.overrides);
    }

    public final /* synthetic */ boolean getAutoplay() {
        return this.autoplay;
    }

    public final /* synthetic */ BorderStyles getBorder() {
        return this.border;
    }

    public final /* synthetic */ ContentScale getContentScale() {
        return this.contentScale;
    }

    public final /* synthetic */ NonEmptyMap getFallbackSources() {
        return this.fallbackSources;
    }

    public final /* synthetic */ boolean getIgnoreTopWindowInsets() {
        return this.ignoreTopWindowInsets;
    }

    public final /* synthetic */ boolean getLoop() {
        return this.loop;
    }

    public final /* synthetic */ PaddingValues getMargin() {
        return this.margin;
    }

    public final /* synthetic */ boolean getMuteAudio() {
        return this.muteAudio;
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

    public final /* synthetic */ boolean getShowControls() {
        return this.showControls;
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
        int iHashCode = this.sources.hashCode() * 31;
        NonEmptyMap<LocaleId, ThemeImageUrls> nonEmptyMap = this.fallbackSources;
        int iHashCode2 = (((((((((((((((((iHashCode + (nonEmptyMap == null ? 0 : nonEmptyMap.hashCode())) * 31) + Boolean.hashCode(this.showControls)) * 31) + Boolean.hashCode(this.autoplay)) * 31) + Boolean.hashCode(this.loop)) * 31) + Boolean.hashCode(this.muteAudio)) * 31) + this.size.hashCode()) * 31) + Boolean.hashCode(this.visible)) * 31) + this.padding.hashCode()) * 31) + this.margin.hashCode()) * 31;
        Shape shape = this.shape;
        int iHashCode3 = (iHashCode2 + (shape == null ? 0 : shape.hashCode())) * 31;
        BorderStyles borderStyles = this.border;
        int iHashCode4 = (iHashCode3 + (borderStyles == null ? 0 : borderStyles.hashCode())) * 31;
        ShadowStyles shadowStyles = this.shadow;
        int iHashCode5 = (iHashCode4 + (shadowStyles == null ? 0 : shadowStyles.hashCode())) * 31;
        ColorStyles colorStyles = this.overlay;
        int iHashCode6 = (((iHashCode5 + (colorStyles == null ? 0 : colorStyles.hashCode())) * 31) + this.contentScale.hashCode()) * 31;
        Package r12 = this.rcPackage;
        int iHashCode7 = (iHashCode6 + (r12 == null ? 0 : r12.hashCode())) * 31;
        ResolvedOffer resolvedOffer = this.resolvedOffer;
        int iHashCode8 = (iHashCode7 + (resolvedOffer == null ? 0 : resolvedOffer.hashCode())) * 31;
        Integer num = this.tabIndex;
        int iHashCode9 = (iHashCode8 + (num == null ? 0 : num.hashCode())) * 31;
        OfferEligibility offerEligibility = this.offerEligibility;
        return ((((iHashCode9 + (offerEligibility != null ? offerEligibility.hashCode() : 0)) * 31) + Boolean.hashCode(this.ignoreTopWindowInsets)) * 31) + this.overrides.hashCode();
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ OfferEligibility resolveOfferEligibility(OfferEligibility offerEligibility) {
        return PackageContext.DefaultImpls.resolveOfferEligibility(this, offerEligibility);
    }

    public String toString() {
        return "VideoComponentStyle(sources=" + this.sources + ", fallbackSources=" + this.fallbackSources + ", showControls=" + this.showControls + ", autoplay=" + this.autoplay + ", loop=" + this.loop + ", muteAudio=" + this.muteAudio + ", size=" + this.size + ", visible=" + this.visible + ", padding=" + this.padding + ", margin=" + this.margin + ", shape=" + this.shape + ", border=" + this.border + ", shadow=" + this.shadow + ", overlay=" + this.overlay + ", contentScale=" + this.contentScale + ", rcPackage=" + this.rcPackage + ", resolvedOffer=" + this.resolvedOffer + ", tabIndex=" + this.tabIndex + ", offerEligibility=" + this.offerEligibility + ", ignoreTopWindowInsets=" + this.ignoreTopWindowInsets + ", overrides=" + this.overrides + ')';
    }

    public /* synthetic */ VideoComponentStyle(NonEmptyMap nonEmptyMap, NonEmptyMap nonEmptyMap2, boolean z2, boolean z3, boolean z4, boolean z5, Size size, boolean z6, PaddingValues paddingValues, PaddingValues paddingValues2, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, ColorStyles colorStyles, ContentScale contentScale, Package r40, ResolvedOffer resolvedOffer, Integer num, OfferEligibility offerEligibility, boolean z7, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(nonEmptyMap, nonEmptyMap2, z2, z3, z4, z5, size, z6, paddingValues, paddingValues2, shape, borderStyles, shadowStyles, colorStyles, contentScale, r40, (i3 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? null : resolvedOffer, num, (i3 & 262144) != 0 ? null : offerEligibility, (i3 & 524288) != 0 ? false : z7, list);
    }
}
