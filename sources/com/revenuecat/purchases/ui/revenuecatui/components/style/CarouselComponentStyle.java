package com.revenuecat.purchases.ui.revenuecatui.components.style;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.Dp;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.google.android.gms.ads_identifier.mrU.pMpIcGE;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.paywalls.components.CarouselComponent;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedCarouselPartial;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedOverride;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext;
import com.revenuecat.purchases.ui.revenuecatui.composables.OfferEligibility;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class CarouselComponentStyle implements ComponentStyle, PackageContext {
    public static final int $stable = 0;
    private final CarouselComponent.AutoAdvancePages autoAdvance;
    private final BackgroundStyles background;
    private final BorderStyles border;
    private final String componentName;
    private final int initialPageIndex;
    private final boolean loop;
    private final PaddingValues margin;
    private final OfferEligibility offerEligibility;
    private final List<PresentedOverride<PresentedCarouselPartial>> overrides;
    private final PaddingValues padding;
    private final Alignment.Vertical pageAlignment;
    private final List<String> pageContextNames;
    private final PageControlStyles pageControl;
    private final float pagePeek;
    private final float pageSpacing;
    private final List<StackComponentStyle> pages;
    private final Package rcPackage;
    private final ResolvedOffer resolvedOffer;
    private final ShadowStyles shadow;
    private final Shape shape;
    private final Size size;
    private final Integer tabIndex;
    private final boolean visible;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class IndicatorStyles {
        public static final int $stable = 0;
        private final ColorStyles color;
        private final float height;
        private final ColorStyles strokeColor;
        private final Dp strokeWidth;
        private final float width;

        public /* synthetic */ IndicatorStyles(float f3, float f4, ColorStyles colorStyles, ColorStyles colorStyles2, Dp dp, DefaultConstructorMarker defaultConstructorMarker) {
            this(f3, f4, colorStyles, colorStyles2, dp);
        }

        /* JADX INFO: renamed from: copy-EwDJqH8$default, reason: not valid java name */
        public static /* synthetic */ IndicatorStyles m821copyEwDJqH8$default(IndicatorStyles indicatorStyles, float f3, float f4, ColorStyles colorStyles, ColorStyles colorStyles2, Dp dp, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                f3 = indicatorStyles.width;
            }
            if ((i3 & 2) != 0) {
                f4 = indicatorStyles.height;
            }
            if ((i3 & 4) != 0) {
                colorStyles = indicatorStyles.color;
            }
            if ((i3 & 8) != 0) {
                colorStyles2 = indicatorStyles.strokeColor;
            }
            if ((i3 & 16) != 0) {
                dp = indicatorStyles.strokeWidth;
            }
            Dp dp2 = dp;
            ColorStyles colorStyles3 = colorStyles;
            return indicatorStyles.m825copyEwDJqH8(f3, f4, colorStyles3, colorStyles2, dp2);
        }

        /* JADX INFO: renamed from: component1-D9Ej5fM, reason: not valid java name */
        public final float m822component1D9Ej5fM() {
            return this.width;
        }

        /* JADX INFO: renamed from: component2-D9Ej5fM, reason: not valid java name */
        public final float m823component2D9Ej5fM() {
            return this.height;
        }

        public final ColorStyles component3() {
            return this.color;
        }

        public final ColorStyles component4() {
            return this.strokeColor;
        }

        /* JADX INFO: renamed from: component5-lTKBWiU, reason: not valid java name */
        public final Dp m824component5lTKBWiU() {
            return this.strokeWidth;
        }

        /* JADX INFO: renamed from: copy-EwDJqH8, reason: not valid java name */
        public final IndicatorStyles m825copyEwDJqH8(float f3, float f4, ColorStyles color, ColorStyles colorStyles, Dp dp) {
            Intrinsics.checkNotNullParameter(color, "color");
            return new IndicatorStyles(f3, f4, color, colorStyles, dp, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof IndicatorStyles)) {
                return false;
            }
            IndicatorStyles indicatorStyles = (IndicatorStyles) obj;
            return Dp.i(this.width, indicatorStyles.width) && Dp.i(this.height, indicatorStyles.height) && Intrinsics.areEqual(this.color, indicatorStyles.color) && Intrinsics.areEqual(this.strokeColor, indicatorStyles.strokeColor) && Intrinsics.areEqual(this.strokeWidth, indicatorStyles.strokeWidth);
        }

        public final /* synthetic */ ColorStyles getColor() {
            return this.color;
        }

        /* JADX INFO: renamed from: getHeight-D9Ej5fM, reason: not valid java name */
        public final /* synthetic */ float m826getHeightD9Ej5fM() {
            return this.height;
        }

        public final /* synthetic */ ColorStyles getStrokeColor() {
            return this.strokeColor;
        }

        /* JADX INFO: renamed from: getStrokeWidth-lTKBWiU, reason: not valid java name */
        public final /* synthetic */ Dp m827getStrokeWidthlTKBWiU() {
            return this.strokeWidth;
        }

        /* JADX INFO: renamed from: getWidth-D9Ej5fM, reason: not valid java name */
        public final /* synthetic */ float m828getWidthD9Ej5fM() {
            return this.width;
        }

        public int hashCode() {
            int iJ = ((((Dp.j(this.width) * 31) + Dp.j(this.height)) * 31) + this.color.hashCode()) * 31;
            ColorStyles colorStyles = this.strokeColor;
            int iHashCode = (iJ + (colorStyles == null ? 0 : colorStyles.hashCode())) * 31;
            Dp dp = this.strokeWidth;
            return iHashCode + (dp != null ? Dp.j(dp.l()) : 0);
        }

        private IndicatorStyles(float f3, float f4, ColorStyles color, ColorStyles colorStyles, Dp dp) {
            Intrinsics.checkNotNullParameter(color, "color");
            this.width = f3;
            this.height = f4;
            this.color = color;
            this.strokeColor = colorStyles;
            this.strokeWidth = dp;
        }

        public String toString() {
            return pMpIcGE.IthRTItzXWV + ((Object) Dp.k(this.width)) + ", height=" + ((Object) Dp.k(this.height)) + ", color=" + this.color + ", strokeColor=" + this.strokeColor + ", strokeWidth=" + this.strokeWidth + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PageControlStyles {
        public static final int $stable = 0;
        private final IndicatorStyles active;
        private final ColorStyles backgroundColor;
        private final BorderStyles border;

        /* JADX INFO: renamed from: default, reason: not valid java name */
        private final IndicatorStyles f9default;
        private final PaddingValues margin;
        private final PaddingValues padding;
        private final CarouselComponent.PageControl.Position position;
        private final ShadowStyles shadow;
        private final Shape shape;
        private final float spacing;

        public /* synthetic */ PageControlStyles(CarouselComponent.PageControl.Position position, float f3, PaddingValues paddingValues, PaddingValues paddingValues2, ColorStyles colorStyles, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, IndicatorStyles indicatorStyles, IndicatorStyles indicatorStyles2, DefaultConstructorMarker defaultConstructorMarker) {
            this(position, f3, paddingValues, paddingValues2, colorStyles, shape, borderStyles, shadowStyles, indicatorStyles, indicatorStyles2);
        }

        /* JADX INFO: renamed from: copy-jfnsLPA$default, reason: not valid java name */
        public static /* synthetic */ PageControlStyles m829copyjfnsLPA$default(PageControlStyles pageControlStyles, CarouselComponent.PageControl.Position position, float f3, PaddingValues paddingValues, PaddingValues paddingValues2, ColorStyles colorStyles, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, IndicatorStyles indicatorStyles, IndicatorStyles indicatorStyles2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                position = pageControlStyles.position;
            }
            if ((i3 & 2) != 0) {
                f3 = pageControlStyles.spacing;
            }
            if ((i3 & 4) != 0) {
                paddingValues = pageControlStyles.padding;
            }
            if ((i3 & 8) != 0) {
                paddingValues2 = pageControlStyles.margin;
            }
            if ((i3 & 16) != 0) {
                colorStyles = pageControlStyles.backgroundColor;
            }
            if ((i3 & 32) != 0) {
                shape = pageControlStyles.shape;
            }
            if ((i3 & 64) != 0) {
                borderStyles = pageControlStyles.border;
            }
            if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
                shadowStyles = pageControlStyles.shadow;
            }
            if ((i3 & Function.MAX_NARGS) != 0) {
                indicatorStyles = pageControlStyles.active;
            }
            if ((i3 & 512) != 0) {
                indicatorStyles2 = pageControlStyles.f9default;
            }
            IndicatorStyles indicatorStyles3 = indicatorStyles;
            IndicatorStyles indicatorStyles4 = indicatorStyles2;
            BorderStyles borderStyles2 = borderStyles;
            ShadowStyles shadowStyles2 = shadowStyles;
            ColorStyles colorStyles2 = colorStyles;
            Shape shape2 = shape;
            return pageControlStyles.m831copyjfnsLPA(position, f3, paddingValues, paddingValues2, colorStyles2, shape2, borderStyles2, shadowStyles2, indicatorStyles3, indicatorStyles4);
        }

        public final CarouselComponent.PageControl.Position component1() {
            return this.position;
        }

        public final IndicatorStyles component10() {
            return this.f9default;
        }

        /* JADX INFO: renamed from: component2-D9Ej5fM, reason: not valid java name */
        public final float m830component2D9Ej5fM() {
            return this.spacing;
        }

        public final PaddingValues component3() {
            return this.padding;
        }

        public final PaddingValues component4() {
            return this.margin;
        }

        public final ColorStyles component5() {
            return this.backgroundColor;
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

        public final IndicatorStyles component9() {
            return this.active;
        }

        /* JADX INFO: renamed from: copy-jfnsLPA, reason: not valid java name */
        public final PageControlStyles m831copyjfnsLPA(CarouselComponent.PageControl.Position position, float f3, PaddingValues padding, PaddingValues margin, ColorStyles colorStyles, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, IndicatorStyles active, IndicatorStyles indicatorStyles) {
            Intrinsics.checkNotNullParameter(position, "position");
            Intrinsics.checkNotNullParameter(padding, "padding");
            Intrinsics.checkNotNullParameter(margin, "margin");
            Intrinsics.checkNotNullParameter(shape, "shape");
            Intrinsics.checkNotNullParameter(active, "active");
            Intrinsics.checkNotNullParameter(indicatorStyles, "default");
            return new PageControlStyles(position, f3, padding, margin, colorStyles, shape, borderStyles, shadowStyles, active, indicatorStyles, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PageControlStyles)) {
                return false;
            }
            PageControlStyles pageControlStyles = (PageControlStyles) obj;
            return this.position == pageControlStyles.position && Dp.i(this.spacing, pageControlStyles.spacing) && Intrinsics.areEqual(this.padding, pageControlStyles.padding) && Intrinsics.areEqual(this.margin, pageControlStyles.margin) && Intrinsics.areEqual(this.backgroundColor, pageControlStyles.backgroundColor) && Intrinsics.areEqual(this.shape, pageControlStyles.shape) && Intrinsics.areEqual(this.border, pageControlStyles.border) && Intrinsics.areEqual(this.shadow, pageControlStyles.shadow) && Intrinsics.areEqual(this.active, pageControlStyles.active) && Intrinsics.areEqual(this.f9default, pageControlStyles.f9default);
        }

        public final /* synthetic */ IndicatorStyles getActive() {
            return this.active;
        }

        public final /* synthetic */ ColorStyles getBackgroundColor() {
            return this.backgroundColor;
        }

        public final /* synthetic */ BorderStyles getBorder() {
            return this.border;
        }

        public final /* synthetic */ IndicatorStyles getDefault() {
            return this.f9default;
        }

        public final /* synthetic */ PaddingValues getMargin() {
            return this.margin;
        }

        public final /* synthetic */ PaddingValues getPadding() {
            return this.padding;
        }

        public final /* synthetic */ CarouselComponent.PageControl.Position getPosition() {
            return this.position;
        }

        public final /* synthetic */ ShadowStyles getShadow() {
            return this.shadow;
        }

        public final /* synthetic */ Shape getShape() {
            return this.shape;
        }

        /* JADX INFO: renamed from: getSpacing-D9Ej5fM, reason: not valid java name */
        public final /* synthetic */ float m832getSpacingD9Ej5fM() {
            return this.spacing;
        }

        public int hashCode() {
            int iHashCode = ((((((this.position.hashCode() * 31) + Dp.j(this.spacing)) * 31) + this.padding.hashCode()) * 31) + this.margin.hashCode()) * 31;
            ColorStyles colorStyles = this.backgroundColor;
            int iHashCode2 = (((iHashCode + (colorStyles == null ? 0 : colorStyles.hashCode())) * 31) + this.shape.hashCode()) * 31;
            BorderStyles borderStyles = this.border;
            int iHashCode3 = (iHashCode2 + (borderStyles == null ? 0 : borderStyles.hashCode())) * 31;
            ShadowStyles shadowStyles = this.shadow;
            return ((((iHashCode3 + (shadowStyles != null ? shadowStyles.hashCode() : 0)) * 31) + this.active.hashCode()) * 31) + this.f9default.hashCode();
        }

        public String toString() {
            return "PageControlStyles(position=" + this.position + ", spacing=" + ((Object) Dp.k(this.spacing)) + ", padding=" + this.padding + ", margin=" + this.margin + ", backgroundColor=" + this.backgroundColor + ", shape=" + this.shape + ", border=" + this.border + ", shadow=" + this.shadow + ", active=" + this.active + ", default=" + this.f9default + ')';
        }

        private PageControlStyles(CarouselComponent.PageControl.Position position, float f3, PaddingValues padding, PaddingValues margin, ColorStyles colorStyles, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, IndicatorStyles active, IndicatorStyles indicatorStyles) {
            Intrinsics.checkNotNullParameter(position, "position");
            Intrinsics.checkNotNullParameter(padding, "padding");
            Intrinsics.checkNotNullParameter(margin, "margin");
            Intrinsics.checkNotNullParameter(shape, "shape");
            Intrinsics.checkNotNullParameter(active, "active");
            Intrinsics.checkNotNullParameter(indicatorStyles, "default");
            this.position = position;
            this.spacing = f3;
            this.padding = padding;
            this.margin = margin;
            this.backgroundColor = colorStyles;
            this.shape = shape;
            this.border = borderStyles;
            this.shadow = shadowStyles;
            this.active = active;
            this.f9default = indicatorStyles;
        }
    }

    public /* synthetic */ CarouselComponentStyle(List list, List list2, int i3, Alignment.Vertical vertical, boolean z2, Size size, float f3, float f4, BackgroundStyles backgroundStyles, PaddingValues paddingValues, PaddingValues paddingValues2, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, PageControlStyles pageControlStyles, boolean z3, CarouselComponent.AutoAdvancePages autoAdvancePages, Package r18, ResolvedOffer resolvedOffer, Integer num, OfferEligibility offerEligibility, List list3, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2, i3, vertical, z2, size, f3, f4, backgroundStyles, paddingValues, paddingValues2, shape, borderStyles, shadowStyles, pageControlStyles, z3, autoAdvancePages, r18, resolvedOffer, num, offerEligibility, list3, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: copy-myaEN6I$default, reason: not valid java name */
    public static /* synthetic */ CarouselComponentStyle m815copymyaEN6I$default(CarouselComponentStyle carouselComponentStyle, List list, List list2, int i3, Alignment.Vertical vertical, boolean z2, Size size, float f3, float f4, BackgroundStyles backgroundStyles, PaddingValues paddingValues, PaddingValues paddingValues2, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, PageControlStyles pageControlStyles, boolean z3, CarouselComponent.AutoAdvancePages autoAdvancePages, Package r35, ResolvedOffer resolvedOffer, Integer num, OfferEligibility offerEligibility, List list3, String str, int i4, Object obj) {
        String str2;
        List list4;
        List list5 = (i4 & 1) != 0 ? carouselComponentStyle.pages : list;
        List list6 = (i4 & 2) != 0 ? carouselComponentStyle.pageContextNames : list2;
        int i5 = (i4 & 4) != 0 ? carouselComponentStyle.initialPageIndex : i3;
        Alignment.Vertical vertical2 = (i4 & 8) != 0 ? carouselComponentStyle.pageAlignment : vertical;
        boolean z4 = (i4 & 16) != 0 ? carouselComponentStyle.visible : z2;
        Size size2 = (i4 & 32) != 0 ? carouselComponentStyle.size : size;
        float f5 = (i4 & 64) != 0 ? carouselComponentStyle.pagePeek : f3;
        float f6 = (i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? carouselComponentStyle.pageSpacing : f4;
        BackgroundStyles backgroundStyles2 = (i4 & Function.MAX_NARGS) != 0 ? carouselComponentStyle.background : backgroundStyles;
        PaddingValues paddingValues3 = (i4 & 512) != 0 ? carouselComponentStyle.padding : paddingValues;
        PaddingValues paddingValues4 = (i4 & 1024) != 0 ? carouselComponentStyle.margin : paddingValues2;
        Shape shape2 = (i4 & 2048) != 0 ? carouselComponentStyle.shape : shape;
        BorderStyles borderStyles2 = (i4 & 4096) != 0 ? carouselComponentStyle.border : borderStyles;
        ShadowStyles shadowStyles2 = (i4 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? carouselComponentStyle.shadow : shadowStyles;
        List list7 = list5;
        PageControlStyles pageControlStyles2 = (i4 & 16384) != 0 ? carouselComponentStyle.pageControl : pageControlStyles;
        boolean z5 = (i4 & 32768) != 0 ? carouselComponentStyle.loop : z3;
        CarouselComponent.AutoAdvancePages autoAdvancePages2 = (i4 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? carouselComponentStyle.autoAdvance : autoAdvancePages;
        Package r21 = (i4 & 131072) != 0 ? carouselComponentStyle.rcPackage : r35;
        ResolvedOffer resolvedOffer2 = (i4 & 262144) != 0 ? carouselComponentStyle.resolvedOffer : resolvedOffer;
        Integer num2 = (i4 & 524288) != 0 ? carouselComponentStyle.tabIndex : num;
        OfferEligibility offerEligibility2 = (i4 & 1048576) != 0 ? carouselComponentStyle.offerEligibility : offerEligibility;
        List list8 = (i4 & 2097152) != 0 ? carouselComponentStyle.overrides : list3;
        if ((i4 & 4194304) != 0) {
            list4 = list8;
            str2 = carouselComponentStyle.componentName;
        } else {
            str2 = str;
            list4 = list8;
        }
        return carouselComponentStyle.m818copymyaEN6I(list7, list6, i5, vertical2, z4, size2, f5, f6, backgroundStyles2, paddingValues3, paddingValues4, shape2, borderStyles2, shadowStyles2, pageControlStyles2, z5, autoAdvancePages2, r21, resolvedOffer2, num2, offerEligibility2, list4, str2);
    }

    public final List<StackComponentStyle> component1() {
        return this.pages;
    }

    public final PaddingValues component10() {
        return this.padding;
    }

    public final PaddingValues component11() {
        return this.margin;
    }

    public final Shape component12() {
        return this.shape;
    }

    public final BorderStyles component13() {
        return this.border;
    }

    public final ShadowStyles component14() {
        return this.shadow;
    }

    public final PageControlStyles component15() {
        return this.pageControl;
    }

    public final boolean component16() {
        return this.loop;
    }

    public final CarouselComponent.AutoAdvancePages component17() {
        return this.autoAdvance;
    }

    public final Package component18() {
        return this.rcPackage;
    }

    public final ResolvedOffer component19() {
        return this.resolvedOffer;
    }

    public final List<String> component2() {
        return this.pageContextNames;
    }

    public final Integer component20() {
        return this.tabIndex;
    }

    public final OfferEligibility component21() {
        return this.offerEligibility;
    }

    public final List<PresentedOverride<PresentedCarouselPartial>> component22() {
        return this.overrides;
    }

    public final String component23() {
        return this.componentName;
    }

    public final int component3() {
        return this.initialPageIndex;
    }

    public final Alignment.Vertical component4() {
        return this.pageAlignment;
    }

    public final boolean component5() {
        return this.visible;
    }

    public final Size component6() {
        return this.size;
    }

    /* JADX INFO: renamed from: component7-D9Ej5fM, reason: not valid java name */
    public final float m816component7D9Ej5fM() {
        return this.pagePeek;
    }

    /* JADX INFO: renamed from: component8-D9Ej5fM, reason: not valid java name */
    public final float m817component8D9Ej5fM() {
        return this.pageSpacing;
    }

    public final BackgroundStyles component9() {
        return this.background;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ boolean computeIsSelected(PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo, int i3) {
        return PackageContext.DefaultImpls.computeIsSelected(this, selectedPackageInfo, i3);
    }

    /* JADX INFO: renamed from: copy-myaEN6I, reason: not valid java name */
    public final CarouselComponentStyle m818copymyaEN6I(List<StackComponentStyle> pages, List<String> pageContextNames, int i3, Alignment.Vertical pageAlignment, boolean z2, Size size, float f3, float f4, BackgroundStyles backgroundStyles, PaddingValues padding, PaddingValues margin, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, PageControlStyles pageControlStyles, boolean z3, CarouselComponent.AutoAdvancePages autoAdvancePages, Package r44, ResolvedOffer resolvedOffer, Integer num, OfferEligibility offerEligibility, List<PresentedOverride<PresentedCarouselPartial>> overrides, String str) {
        Intrinsics.checkNotNullParameter(pages, "pages");
        Intrinsics.checkNotNullParameter(pageContextNames, "pageContextNames");
        Intrinsics.checkNotNullParameter(pageAlignment, "pageAlignment");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(padding, "padding");
        Intrinsics.checkNotNullParameter(margin, "margin");
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        return new CarouselComponentStyle(pages, pageContextNames, i3, pageAlignment, z2, size, f3, f4, backgroundStyles, padding, margin, shape, borderStyles, shadowStyles, pageControlStyles, z3, autoAdvancePages, r44, resolvedOffer, num, offerEligibility, overrides, str, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CarouselComponentStyle)) {
            return false;
        }
        CarouselComponentStyle carouselComponentStyle = (CarouselComponentStyle) obj;
        return Intrinsics.areEqual(this.pages, carouselComponentStyle.pages) && Intrinsics.areEqual(this.pageContextNames, carouselComponentStyle.pageContextNames) && this.initialPageIndex == carouselComponentStyle.initialPageIndex && Intrinsics.areEqual(this.pageAlignment, carouselComponentStyle.pageAlignment) && this.visible == carouselComponentStyle.visible && Intrinsics.areEqual(this.size, carouselComponentStyle.size) && Dp.i(this.pagePeek, carouselComponentStyle.pagePeek) && Dp.i(this.pageSpacing, carouselComponentStyle.pageSpacing) && Intrinsics.areEqual(this.background, carouselComponentStyle.background) && Intrinsics.areEqual(this.padding, carouselComponentStyle.padding) && Intrinsics.areEqual(this.margin, carouselComponentStyle.margin) && Intrinsics.areEqual(this.shape, carouselComponentStyle.shape) && Intrinsics.areEqual(this.border, carouselComponentStyle.border) && Intrinsics.areEqual(this.shadow, carouselComponentStyle.shadow) && Intrinsics.areEqual(this.pageControl, carouselComponentStyle.pageControl) && this.loop == carouselComponentStyle.loop && Intrinsics.areEqual(this.autoAdvance, carouselComponentStyle.autoAdvance) && Intrinsics.areEqual(this.rcPackage, carouselComponentStyle.rcPackage) && Intrinsics.areEqual(this.resolvedOffer, carouselComponentStyle.resolvedOffer) && Intrinsics.areEqual(this.tabIndex, carouselComponentStyle.tabIndex) && Intrinsics.areEqual(this.offerEligibility, carouselComponentStyle.offerEligibility) && Intrinsics.areEqual(this.overrides, carouselComponentStyle.overrides) && Intrinsics.areEqual(this.componentName, carouselComponentStyle.componentName);
    }

    public final /* synthetic */ CarouselComponent.AutoAdvancePages getAutoAdvance() {
        return this.autoAdvance;
    }

    public final /* synthetic */ BackgroundStyles getBackground() {
        return this.background;
    }

    public final /* synthetic */ BorderStyles getBorder() {
        return this.border;
    }

    public final /* synthetic */ String getComponentName() {
        return this.componentName;
    }

    public final /* synthetic */ int getInitialPageIndex() {
        return this.initialPageIndex;
    }

    public final /* synthetic */ boolean getLoop() {
        return this.loop;
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

    public final /* synthetic */ Alignment.Vertical getPageAlignment() {
        return this.pageAlignment;
    }

    public final /* synthetic */ List getPageContextNames() {
        return this.pageContextNames;
    }

    public final /* synthetic */ PageControlStyles getPageControl() {
        return this.pageControl;
    }

    /* JADX INFO: renamed from: getPagePeek-D9Ej5fM, reason: not valid java name */
    public final /* synthetic */ float m819getPagePeekD9Ej5fM() {
        return this.pagePeek;
    }

    /* JADX INFO: renamed from: getPageSpacing-D9Ej5fM, reason: not valid java name */
    public final /* synthetic */ float m820getPageSpacingD9Ej5fM() {
        return this.pageSpacing;
    }

    public final /* synthetic */ List getPages() {
        return this.pages;
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

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ Integer getTabIndex() {
        return this.tabIndex;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle
    public /* synthetic */ boolean getVisible() {
        return this.visible;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((this.pages.hashCode() * 31) + this.pageContextNames.hashCode()) * 31) + Integer.hashCode(this.initialPageIndex)) * 31) + this.pageAlignment.hashCode()) * 31) + Boolean.hashCode(this.visible)) * 31) + this.size.hashCode()) * 31) + Dp.j(this.pagePeek)) * 31) + Dp.j(this.pageSpacing)) * 31;
        BackgroundStyles backgroundStyles = this.background;
        int iHashCode2 = (((((((iHashCode + (backgroundStyles == null ? 0 : backgroundStyles.hashCode())) * 31) + this.padding.hashCode()) * 31) + this.margin.hashCode()) * 31) + this.shape.hashCode()) * 31;
        BorderStyles borderStyles = this.border;
        int iHashCode3 = (iHashCode2 + (borderStyles == null ? 0 : borderStyles.hashCode())) * 31;
        ShadowStyles shadowStyles = this.shadow;
        int iHashCode4 = (iHashCode3 + (shadowStyles == null ? 0 : shadowStyles.hashCode())) * 31;
        PageControlStyles pageControlStyles = this.pageControl;
        int iHashCode5 = (((iHashCode4 + (pageControlStyles == null ? 0 : pageControlStyles.hashCode())) * 31) + Boolean.hashCode(this.loop)) * 31;
        CarouselComponent.AutoAdvancePages autoAdvancePages = this.autoAdvance;
        int iHashCode6 = (iHashCode5 + (autoAdvancePages == null ? 0 : autoAdvancePages.hashCode())) * 31;
        Package r12 = this.rcPackage;
        int iHashCode7 = (iHashCode6 + (r12 == null ? 0 : r12.hashCode())) * 31;
        ResolvedOffer resolvedOffer = this.resolvedOffer;
        int iHashCode8 = (iHashCode7 + (resolvedOffer == null ? 0 : resolvedOffer.hashCode())) * 31;
        Integer num = this.tabIndex;
        int iHashCode9 = (iHashCode8 + (num == null ? 0 : num.hashCode())) * 31;
        OfferEligibility offerEligibility = this.offerEligibility;
        int iHashCode10 = (((iHashCode9 + (offerEligibility == null ? 0 : offerEligibility.hashCode())) * 31) + this.overrides.hashCode()) * 31;
        String str = this.componentName;
        return iHashCode10 + (str != null ? str.hashCode() : 0);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ OfferEligibility resolveOfferEligibility(OfferEligibility offerEligibility) {
        return PackageContext.DefaultImpls.resolveOfferEligibility(this, offerEligibility);
    }

    public String toString() {
        return "CarouselComponentStyle(pages=" + this.pages + ", pageContextNames=" + this.pageContextNames + ", initialPageIndex=" + this.initialPageIndex + ", pageAlignment=" + this.pageAlignment + ", visible=" + this.visible + ", size=" + this.size + ", pagePeek=" + ((Object) Dp.k(this.pagePeek)) + ", pageSpacing=" + ((Object) Dp.k(this.pageSpacing)) + ", background=" + this.background + ", padding=" + this.padding + ", margin=" + this.margin + ", shape=" + this.shape + ", border=" + this.border + ", shadow=" + this.shadow + ", pageControl=" + this.pageControl + ", loop=" + this.loop + ", autoAdvance=" + this.autoAdvance + ", rcPackage=" + this.rcPackage + ", resolvedOffer=" + this.resolvedOffer + ", tabIndex=" + this.tabIndex + ", offerEligibility=" + this.offerEligibility + ", overrides=" + this.overrides + ", componentName=" + this.componentName + ')';
    }

    private CarouselComponentStyle(List<StackComponentStyle> pages, List<String> pageContextNames, int i3, Alignment.Vertical pageAlignment, boolean z2, Size size, float f3, float f4, BackgroundStyles backgroundStyles, PaddingValues padding, PaddingValues margin, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, PageControlStyles pageControlStyles, boolean z3, CarouselComponent.AutoAdvancePages autoAdvancePages, Package r22, ResolvedOffer resolvedOffer, Integer num, OfferEligibility offerEligibility, List<PresentedOverride<PresentedCarouselPartial>> overrides, String str) {
        Intrinsics.checkNotNullParameter(pages, "pages");
        Intrinsics.checkNotNullParameter(pageContextNames, "pageContextNames");
        Intrinsics.checkNotNullParameter(pageAlignment, "pageAlignment");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(padding, "padding");
        Intrinsics.checkNotNullParameter(margin, "margin");
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        this.pages = pages;
        this.pageContextNames = pageContextNames;
        this.initialPageIndex = i3;
        this.pageAlignment = pageAlignment;
        this.visible = z2;
        this.size = size;
        this.pagePeek = f3;
        this.pageSpacing = f4;
        this.background = backgroundStyles;
        this.padding = padding;
        this.margin = margin;
        this.shape = shape;
        this.border = borderStyles;
        this.shadow = shadowStyles;
        this.pageControl = pageControlStyles;
        this.loop = z3;
        this.autoAdvance = autoAdvancePages;
        this.rcPackage = r22;
        this.resolvedOffer = resolvedOffer;
        this.tabIndex = num;
        this.offerEligibility = offerEligibility;
        this.overrides = overrides;
        this.componentName = str;
    }

    public /* synthetic */ CarouselComponentStyle(List list, List list2, int i3, Alignment.Vertical vertical, boolean z2, Size size, float f3, float f4, BackgroundStyles backgroundStyles, PaddingValues paddingValues, PaddingValues paddingValues2, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, PageControlStyles pageControlStyles, boolean z3, CarouselComponent.AutoAdvancePages autoAdvancePages, Package r45, ResolvedOffer resolvedOffer, Integer num, OfferEligibility offerEligibility, List list3, String str, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2, i3, vertical, z2, size, f3, f4, backgroundStyles, paddingValues, paddingValues2, shape, borderStyles, shadowStyles, pageControlStyles, z3, autoAdvancePages, r45, (i4 & 262144) != 0 ? null : resolvedOffer, num, (i4 & 1048576) != 0 ? null : offerEligibility, list3, (i4 & 4194304) != 0 ? null : str, null);
    }
}
