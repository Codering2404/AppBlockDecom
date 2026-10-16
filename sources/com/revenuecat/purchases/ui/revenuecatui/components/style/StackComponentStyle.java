package com.revenuecat.purchases.ui.revenuecatui.components.style;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.unit.Dp;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.paywalls.components.CountdownComponent;
import com.revenuecat.purchases.paywalls.components.properties.Dimension;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedOverride;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedStackPartial;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext;
import com.revenuecat.purchases.ui.revenuecatui.composables.OfferEligibility;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResolvedOffer;
import com.sun.jna.Function;
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
public final class StackComponentStyle implements ComponentStyle, PackageContext {
    public static final int $stable = 0;
    private final boolean applyBottomWindowInsets;
    private final boolean applyHorizontalWindowInsets;
    private final boolean applyTopWindowInsets;
    private final BackgroundStyles background;
    private final BadgeStyle badge;
    private final BorderStyles border;
    private final List<ComponentStyle> children;
    private final CountdownComponent.CountFrom countFrom;
    private final Date countdownDate;
    private final Dimension dimension;
    private final boolean ignoreHeaderHeight;
    private final PaddingValues margin;
    private final OfferEligibility offerEligibility;
    private final List<PresentedOverride<PresentedStackPartial>> overrides;
    private final PaddingValues padding;
    private final Package rcPackage;
    private final ResolvedOffer resolvedOffer;
    private final Orientation scrollOrientation;
    private final ShadowStyles shadow;
    private final Shape shape;
    private final Size size;
    private final float spacing;
    private final Integer tabIndex;
    private final boolean visible;

    public /* synthetic */ StackComponentStyle(List list, Dimension dimension, boolean z2, Size size, float f3, BackgroundStyles backgroundStyles, PaddingValues paddingValues, PaddingValues paddingValues2, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, BadgeStyle badgeStyle, Orientation orientation, Package r14, ResolvedOffer resolvedOffer, Integer num, OfferEligibility offerEligibility, Date date, CountdownComponent.CountFrom countFrom, List list2, boolean z3, boolean z4, boolean z5, boolean z6, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, dimension, z2, size, f3, backgroundStyles, paddingValues, paddingValues2, shape, borderStyles, shadowStyles, badgeStyle, orientation, r14, resolvedOffer, num, offerEligibility, date, countFrom, list2, z3, z4, z5, z6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: copy-h6c5tkY$default, reason: not valid java name */
    public static /* synthetic */ StackComponentStyle m833copyh6c5tkY$default(StackComponentStyle stackComponentStyle, List list, Dimension dimension, boolean z2, Size size, float f3, BackgroundStyles backgroundStyles, PaddingValues paddingValues, PaddingValues paddingValues2, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, BadgeStyle badgeStyle, Orientation orientation, Package r31, ResolvedOffer resolvedOffer, Integer num, OfferEligibility offerEligibility, Date date, CountdownComponent.CountFrom countFrom, List list2, boolean z3, boolean z4, boolean z5, boolean z6, int i3, Object obj) {
        boolean z7;
        boolean z8;
        List list3 = (i3 & 1) != 0 ? stackComponentStyle.children : list;
        Dimension dimension2 = (i3 & 2) != 0 ? stackComponentStyle.dimension : dimension;
        boolean z9 = (i3 & 4) != 0 ? stackComponentStyle.visible : z2;
        Size size2 = (i3 & 8) != 0 ? stackComponentStyle.size : size;
        float f4 = (i3 & 16) != 0 ? stackComponentStyle.spacing : f3;
        BackgroundStyles backgroundStyles2 = (i3 & 32) != 0 ? stackComponentStyle.background : backgroundStyles;
        PaddingValues paddingValues3 = (i3 & 64) != 0 ? stackComponentStyle.padding : paddingValues;
        PaddingValues paddingValues4 = (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? stackComponentStyle.margin : paddingValues2;
        Shape shape2 = (i3 & Function.MAX_NARGS) != 0 ? stackComponentStyle.shape : shape;
        BorderStyles borderStyles2 = (i3 & 512) != 0 ? stackComponentStyle.border : borderStyles;
        ShadowStyles shadowStyles2 = (i3 & 1024) != 0 ? stackComponentStyle.shadow : shadowStyles;
        BadgeStyle badgeStyle2 = (i3 & 2048) != 0 ? stackComponentStyle.badge : badgeStyle;
        Orientation orientation2 = (i3 & 4096) != 0 ? stackComponentStyle.scrollOrientation : orientation;
        Package r15 = (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? stackComponentStyle.rcPackage : r31;
        List list4 = list3;
        ResolvedOffer resolvedOffer2 = (i3 & 16384) != 0 ? stackComponentStyle.resolvedOffer : resolvedOffer;
        Integer num2 = (i3 & 32768) != 0 ? stackComponentStyle.tabIndex : num;
        OfferEligibility offerEligibility2 = (i3 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? stackComponentStyle.offerEligibility : offerEligibility;
        Date date2 = (i3 & 131072) != 0 ? stackComponentStyle.countdownDate : date;
        CountdownComponent.CountFrom countFrom2 = (i3 & 262144) != 0 ? stackComponentStyle.countFrom : countFrom;
        List list5 = (i3 & 524288) != 0 ? stackComponentStyle.overrides : list2;
        boolean z10 = (i3 & 1048576) != 0 ? stackComponentStyle.applyTopWindowInsets : z3;
        boolean z11 = (i3 & 2097152) != 0 ? stackComponentStyle.ignoreHeaderHeight : z4;
        boolean z12 = (i3 & 4194304) != 0 ? stackComponentStyle.applyBottomWindowInsets : z5;
        if ((i3 & 8388608) != 0) {
            z8 = z12;
            z7 = stackComponentStyle.applyHorizontalWindowInsets;
        } else {
            z7 = z6;
            z8 = z12;
        }
        return stackComponentStyle.m835copyh6c5tkY(list4, dimension2, z9, size2, f4, backgroundStyles2, paddingValues3, paddingValues4, shape2, borderStyles2, shadowStyles2, badgeStyle2, orientation2, r15, resolvedOffer2, num2, offerEligibility2, date2, countFrom2, list5, z10, z11, z8, z7);
    }

    public final List<ComponentStyle> component1() {
        return this.children;
    }

    public final BorderStyles component10() {
        return this.border;
    }

    public final ShadowStyles component11() {
        return this.shadow;
    }

    public final BadgeStyle component12() {
        return this.badge;
    }

    public final Orientation component13() {
        return this.scrollOrientation;
    }

    public final Package component14() {
        return this.rcPackage;
    }

    public final ResolvedOffer component15() {
        return this.resolvedOffer;
    }

    public final Integer component16() {
        return this.tabIndex;
    }

    public final OfferEligibility component17() {
        return this.offerEligibility;
    }

    public final Date component18() {
        return this.countdownDate;
    }

    public final CountdownComponent.CountFrom component19() {
        return this.countFrom;
    }

    public final Dimension component2() {
        return this.dimension;
    }

    public final List<PresentedOverride<PresentedStackPartial>> component20() {
        return this.overrides;
    }

    public final boolean component21() {
        return this.applyTopWindowInsets;
    }

    public final boolean component22() {
        return this.ignoreHeaderHeight;
    }

    public final boolean component23() {
        return this.applyBottomWindowInsets;
    }

    public final boolean component24() {
        return this.applyHorizontalWindowInsets;
    }

    public final boolean component3() {
        return this.visible;
    }

    public final Size component4() {
        return this.size;
    }

    /* JADX INFO: renamed from: component5-D9Ej5fM, reason: not valid java name */
    public final float m834component5D9Ej5fM() {
        return this.spacing;
    }

    public final BackgroundStyles component6() {
        return this.background;
    }

    public final PaddingValues component7() {
        return this.padding;
    }

    public final PaddingValues component8() {
        return this.margin;
    }

    public final Shape component9() {
        return this.shape;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ boolean computeIsSelected(PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo, int i3) {
        return PackageContext.DefaultImpls.computeIsSelected(this, selectedPackageInfo, i3);
    }

    /* JADX INFO: renamed from: copy-h6c5tkY, reason: not valid java name */
    public final StackComponentStyle m835copyh6c5tkY(List<? extends ComponentStyle> children, Dimension dimension, boolean z2, Size size, float f3, BackgroundStyles backgroundStyles, PaddingValues padding, PaddingValues margin, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, BadgeStyle badgeStyle, Orientation orientation, Package r41, ResolvedOffer resolvedOffer, Integer num, OfferEligibility offerEligibility, Date date, CountdownComponent.CountFrom countFrom, List<PresentedOverride<PresentedStackPartial>> overrides, boolean z3, boolean z4, boolean z5, boolean z6) {
        Intrinsics.checkNotNullParameter(children, "children");
        Intrinsics.checkNotNullParameter(dimension, "dimension");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(padding, "padding");
        Intrinsics.checkNotNullParameter(margin, "margin");
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(countFrom, "countFrom");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        return new StackComponentStyle(children, dimension, z2, size, f3, backgroundStyles, padding, margin, shape, borderStyles, shadowStyles, badgeStyle, orientation, r41, resolvedOffer, num, offerEligibility, date, countFrom, overrides, z3, z4, z5, z6, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StackComponentStyle)) {
            return false;
        }
        StackComponentStyle stackComponentStyle = (StackComponentStyle) obj;
        return Intrinsics.areEqual(this.children, stackComponentStyle.children) && Intrinsics.areEqual(this.dimension, stackComponentStyle.dimension) && this.visible == stackComponentStyle.visible && Intrinsics.areEqual(this.size, stackComponentStyle.size) && Dp.i(this.spacing, stackComponentStyle.spacing) && Intrinsics.areEqual(this.background, stackComponentStyle.background) && Intrinsics.areEqual(this.padding, stackComponentStyle.padding) && Intrinsics.areEqual(this.margin, stackComponentStyle.margin) && Intrinsics.areEqual(this.shape, stackComponentStyle.shape) && Intrinsics.areEqual(this.border, stackComponentStyle.border) && Intrinsics.areEqual(this.shadow, stackComponentStyle.shadow) && Intrinsics.areEqual(this.badge, stackComponentStyle.badge) && this.scrollOrientation == stackComponentStyle.scrollOrientation && Intrinsics.areEqual(this.rcPackage, stackComponentStyle.rcPackage) && Intrinsics.areEqual(this.resolvedOffer, stackComponentStyle.resolvedOffer) && Intrinsics.areEqual(this.tabIndex, stackComponentStyle.tabIndex) && Intrinsics.areEqual(this.offerEligibility, stackComponentStyle.offerEligibility) && Intrinsics.areEqual(this.countdownDate, stackComponentStyle.countdownDate) && this.countFrom == stackComponentStyle.countFrom && Intrinsics.areEqual(this.overrides, stackComponentStyle.overrides) && this.applyTopWindowInsets == stackComponentStyle.applyTopWindowInsets && this.ignoreHeaderHeight == stackComponentStyle.ignoreHeaderHeight && this.applyBottomWindowInsets == stackComponentStyle.applyBottomWindowInsets && this.applyHorizontalWindowInsets == stackComponentStyle.applyHorizontalWindowInsets;
    }

    public final /* synthetic */ boolean getApplyBottomWindowInsets() {
        return this.applyBottomWindowInsets;
    }

    public final /* synthetic */ boolean getApplyHorizontalWindowInsets() {
        return this.applyHorizontalWindowInsets;
    }

    public final /* synthetic */ boolean getApplyTopWindowInsets() {
        return this.applyTopWindowInsets;
    }

    public final /* synthetic */ BackgroundStyles getBackground() {
        return this.background;
    }

    public final /* synthetic */ BadgeStyle getBadge() {
        return this.badge;
    }

    public final /* synthetic */ BorderStyles getBorder() {
        return this.border;
    }

    public final /* synthetic */ List getChildren() {
        return this.children;
    }

    public final /* synthetic */ CountdownComponent.CountFrom getCountFrom() {
        return this.countFrom;
    }

    public final /* synthetic */ Date getCountdownDate() {
        return this.countdownDate;
    }

    public final /* synthetic */ Dimension getDimension() {
        return this.dimension;
    }

    public final /* synthetic */ boolean getIgnoreHeaderHeight() {
        return this.ignoreHeaderHeight;
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

    public final /* synthetic */ Orientation getScrollOrientation() {
        return this.scrollOrientation;
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

    /* JADX INFO: renamed from: getSpacing-D9Ej5fM, reason: not valid java name */
    public final /* synthetic */ float m836getSpacingD9Ej5fM() {
        return this.spacing;
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
        int iHashCode = ((((((((this.children.hashCode() * 31) + this.dimension.hashCode()) * 31) + Boolean.hashCode(this.visible)) * 31) + this.size.hashCode()) * 31) + Dp.j(this.spacing)) * 31;
        BackgroundStyles backgroundStyles = this.background;
        int iHashCode2 = (((((((iHashCode + (backgroundStyles == null ? 0 : backgroundStyles.hashCode())) * 31) + this.padding.hashCode()) * 31) + this.margin.hashCode()) * 31) + this.shape.hashCode()) * 31;
        BorderStyles borderStyles = this.border;
        int iHashCode3 = (iHashCode2 + (borderStyles == null ? 0 : borderStyles.hashCode())) * 31;
        ShadowStyles shadowStyles = this.shadow;
        int iHashCode4 = (iHashCode3 + (shadowStyles == null ? 0 : shadowStyles.hashCode())) * 31;
        BadgeStyle badgeStyle = this.badge;
        int iHashCode5 = (iHashCode4 + (badgeStyle == null ? 0 : badgeStyle.hashCode())) * 31;
        Orientation orientation = this.scrollOrientation;
        int iHashCode6 = (iHashCode5 + (orientation == null ? 0 : orientation.hashCode())) * 31;
        Package r12 = this.rcPackage;
        int iHashCode7 = (iHashCode6 + (r12 == null ? 0 : r12.hashCode())) * 31;
        ResolvedOffer resolvedOffer = this.resolvedOffer;
        int iHashCode8 = (iHashCode7 + (resolvedOffer == null ? 0 : resolvedOffer.hashCode())) * 31;
        Integer num = this.tabIndex;
        int iHashCode9 = (iHashCode8 + (num == null ? 0 : num.hashCode())) * 31;
        OfferEligibility offerEligibility = this.offerEligibility;
        int iHashCode10 = (iHashCode9 + (offerEligibility == null ? 0 : offerEligibility.hashCode())) * 31;
        Date date = this.countdownDate;
        return ((((((((((((iHashCode10 + (date != null ? date.hashCode() : 0)) * 31) + this.countFrom.hashCode()) * 31) + this.overrides.hashCode()) * 31) + Boolean.hashCode(this.applyTopWindowInsets)) * 31) + Boolean.hashCode(this.ignoreHeaderHeight)) * 31) + Boolean.hashCode(this.applyBottomWindowInsets)) * 31) + Boolean.hashCode(this.applyHorizontalWindowInsets);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ OfferEligibility resolveOfferEligibility(OfferEligibility offerEligibility) {
        return PackageContext.DefaultImpls.resolveOfferEligibility(this, offerEligibility);
    }

    public String toString() {
        return "StackComponentStyle(children=" + this.children + ", dimension=" + this.dimension + ", visible=" + this.visible + ", size=" + this.size + ", spacing=" + ((Object) Dp.k(this.spacing)) + ", background=" + this.background + ", padding=" + this.padding + ", margin=" + this.margin + ", shape=" + this.shape + ", border=" + this.border + ", shadow=" + this.shadow + ", badge=" + this.badge + ", scrollOrientation=" + this.scrollOrientation + ", rcPackage=" + this.rcPackage + ", resolvedOffer=" + this.resolvedOffer + ", tabIndex=" + this.tabIndex + ", offerEligibility=" + this.offerEligibility + ", countdownDate=" + this.countdownDate + ", countFrom=" + this.countFrom + ", overrides=" + this.overrides + ", applyTopWindowInsets=" + this.applyTopWindowInsets + ", ignoreHeaderHeight=" + this.ignoreHeaderHeight + ", applyBottomWindowInsets=" + this.applyBottomWindowInsets + ", applyHorizontalWindowInsets=" + this.applyHorizontalWindowInsets + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    private StackComponentStyle(List<? extends ComponentStyle> children, Dimension dimension, boolean z2, Size size, float f3, BackgroundStyles backgroundStyles, PaddingValues padding, PaddingValues margin, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, BadgeStyle badgeStyle, Orientation orientation, Package r17, ResolvedOffer resolvedOffer, Integer num, OfferEligibility offerEligibility, Date date, CountdownComponent.CountFrom countFrom, List<PresentedOverride<PresentedStackPartial>> overrides, boolean z3, boolean z4, boolean z5, boolean z6) {
        Intrinsics.checkNotNullParameter(children, "children");
        Intrinsics.checkNotNullParameter(dimension, "dimension");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(padding, "padding");
        Intrinsics.checkNotNullParameter(margin, "margin");
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(countFrom, "countFrom");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        this.children = children;
        this.dimension = dimension;
        this.visible = z2;
        this.size = size;
        this.spacing = f3;
        this.background = backgroundStyles;
        this.padding = padding;
        this.margin = margin;
        this.shape = shape;
        this.border = borderStyles;
        this.shadow = shadowStyles;
        this.badge = badgeStyle;
        this.scrollOrientation = orientation;
        this.rcPackage = r17;
        this.resolvedOffer = resolvedOffer;
        this.tabIndex = num;
        this.offerEligibility = offerEligibility;
        this.countdownDate = date;
        this.countFrom = countFrom;
        this.overrides = overrides;
        this.applyTopWindowInsets = z3;
        this.ignoreHeaderHeight = z4;
        this.applyBottomWindowInsets = z5;
        this.applyHorizontalWindowInsets = z6;
    }

    public /* synthetic */ StackComponentStyle(List list, Dimension dimension, boolean z2, Size size, float f3, BackgroundStyles backgroundStyles, PaddingValues paddingValues, PaddingValues paddingValues2, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, BadgeStyle badgeStyle, Orientation orientation, Package r43, ResolvedOffer resolvedOffer, Integer num, OfferEligibility offerEligibility, Date date, CountdownComponent.CountFrom countFrom, List list2, boolean z3, boolean z4, boolean z5, boolean z6, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, dimension, z2, size, f3, backgroundStyles, paddingValues, paddingValues2, shape, borderStyles, shadowStyles, badgeStyle, orientation, r43, (i3 & 16384) != 0 ? null : resolvedOffer, num, (65536 & i3) != 0 ? null : offerEligibility, date, countFrom, list2, (1048576 & i3) != 0 ? false : z3, (2097152 & i3) != 0 ? false : z4, (4194304 & i3) != 0 ? false : z5, (i3 & 8388608) != 0 ? false : z6, null);
    }
}
