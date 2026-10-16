package com.revenuecat.purchases.ui.revenuecatui.components.style;

import androidx.compose.foundation.layout.PaddingValues;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.paywalls.components.IconComponent;
import com.revenuecat.purchases.paywalls.components.properties.MaskShape;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedIconPartial;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedOverride;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext;
import com.revenuecat.purchases.ui.revenuecatui.composables.OfferEligibility;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class IconComponentStyle implements ComponentStyle, PackageContext {
    public static final int $stable = 0;
    private final String baseUrl;
    private final ColorStyles color;
    private final IconComponent.Formats formats;
    private final Background iconBackground;
    private final String iconName;
    private final PaddingValues margin;
    private final OfferEligibility offerEligibility;
    private final List<PresentedOverride<PresentedIconPartial>> overrides;
    private final PaddingValues padding;
    private final Package rcPackage;
    private final ResolvedOffer resolvedOffer;
    private final Size size;
    private final Integer tabIndex;
    private final boolean visible;

    public IconComponentStyle(String baseUrl, String iconName, IconComponent.Formats formats, boolean z2, Size size, ColorStyles colorStyles, PaddingValues padding, PaddingValues margin, Background background, Package r11, ResolvedOffer resolvedOffer, Integer num, OfferEligibility offerEligibility, List<PresentedOverride<PresentedIconPartial>> overrides) {
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics.checkNotNullParameter(iconName, "iconName");
        Intrinsics.checkNotNullParameter(formats, "formats");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(padding, "padding");
        Intrinsics.checkNotNullParameter(margin, "margin");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        this.baseUrl = baseUrl;
        this.iconName = iconName;
        this.formats = formats;
        this.visible = z2;
        this.size = size;
        this.color = colorStyles;
        this.padding = padding;
        this.margin = margin;
        this.iconBackground = background;
        this.rcPackage = r11;
        this.resolvedOffer = resolvedOffer;
        this.tabIndex = num;
        this.offerEligibility = offerEligibility;
        this.overrides = overrides;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ boolean computeIsSelected(PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo, int i3) {
        return PackageContext.DefaultImpls.computeIsSelected(this, selectedPackageInfo, i3);
    }

    public final /* synthetic */ String getBaseUrl() {
        return this.baseUrl;
    }

    public final /* synthetic */ ColorStyles getColor() {
        return this.color;
    }

    public final /* synthetic */ IconComponent.Formats getFormats() {
        return this.formats;
    }

    public final /* synthetic */ Background getIconBackground() {
        return this.iconBackground;
    }

    public final /* synthetic */ String getIconName() {
        return this.iconName;
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

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle
    public /* synthetic */ boolean getVisible() {
        return this.visible;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ OfferEligibility resolveOfferEligibility(OfferEligibility offerEligibility) {
        return PackageContext.DefaultImpls.resolveOfferEligibility(this, offerEligibility);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Background {
        public static final int $stable = 0;
        private final BorderStyles border;
        private final ColorStyles color;
        private final ShadowStyles shadow;
        private final MaskShape shape;

        public Background(ColorStyles color, MaskShape shape, BorderStyles borderStyles, ShadowStyles shadowStyles) {
            Intrinsics.checkNotNullParameter(color, "color");
            Intrinsics.checkNotNullParameter(shape, "shape");
            this.color = color;
            this.shape = shape;
            this.border = borderStyles;
            this.shadow = shadowStyles;
        }

        public final /* synthetic */ BorderStyles getBorder() {
            return this.border;
        }

        public final /* synthetic */ ColorStyles getColor() {
            return this.color;
        }

        public final /* synthetic */ ShadowStyles getShadow() {
            return this.shadow;
        }

        public final /* synthetic */ MaskShape getShape() {
            return this.shape;
        }

        public /* synthetic */ Background(ColorStyles colorStyles, MaskShape maskShape, BorderStyles borderStyles, ShadowStyles shadowStyles, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(colorStyles, maskShape, (i3 & 4) != 0 ? null : borderStyles, (i3 & 8) != 0 ? null : shadowStyles);
        }
    }

    public /* synthetic */ IconComponentStyle(String str, String str2, IconComponent.Formats formats, boolean z2, Size size, ColorStyles colorStyles, PaddingValues paddingValues, PaddingValues paddingValues2, Background background, Package r28, ResolvedOffer resolvedOffer, Integer num, OfferEligibility offerEligibility, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, formats, z2, size, colorStyles, paddingValues, paddingValues2, background, r28, (i3 & 1024) != 0 ? null : resolvedOffer, num, (i3 & 4096) != 0 ? null : offerEligibility, list);
    }
}
