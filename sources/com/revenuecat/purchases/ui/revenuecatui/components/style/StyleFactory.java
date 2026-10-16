package com.revenuecat.purchases.ui.revenuecatui.components.style;

import androidx.compose.animation.core.Xrg.muQRKXGtpOhe;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ColorAlias;
import com.revenuecat.purchases.FontAlias;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.paywalls.components.ButtonComponent;
import com.revenuecat.purchases.paywalls.components.CarouselComponent;
import com.revenuecat.purchases.paywalls.components.CountdownComponent;
import com.revenuecat.purchases.paywalls.components.FallbackHeaderComponent;
import com.revenuecat.purchases.paywalls.components.HeaderComponent;
import com.revenuecat.purchases.paywalls.components.IconComponent;
import com.revenuecat.purchases.paywalls.components.ImageComponent;
import com.revenuecat.purchases.paywalls.components.PackageComponent;
import com.revenuecat.purchases.paywalls.components.PartialCarouselComponent;
import com.revenuecat.purchases.paywalls.components.PartialIconComponent;
import com.revenuecat.purchases.paywalls.components.PartialImageComponent;
import com.revenuecat.purchases.paywalls.components.PartialPackageComponent;
import com.revenuecat.purchases.paywalls.components.PartialStackComponent;
import com.revenuecat.purchases.paywalls.components.PartialTabsComponent;
import com.revenuecat.purchases.paywalls.components.PartialTimelineComponent;
import com.revenuecat.purchases.paywalls.components.PartialTimelineComponentItem;
import com.revenuecat.purchases.paywalls.components.PartialVideoComponent;
import com.revenuecat.purchases.paywalls.components.PaywallComponent;
import com.revenuecat.purchases.paywalls.components.PurchaseButtonComponent;
import com.revenuecat.purchases.paywalls.components.StackComponent;
import com.revenuecat.purchases.paywalls.components.StickyFooterComponent;
import com.revenuecat.purchases.paywalls.components.TabControlButtonComponent;
import com.revenuecat.purchases.paywalls.components.TabControlComponent;
import com.revenuecat.purchases.paywalls.components.TabControlToggleComponent;
import com.revenuecat.purchases.paywalls.components.TabsComponent;
import com.revenuecat.purchases.paywalls.components.TextComponent;
import com.revenuecat.purchases.paywalls.components.TimelineComponent;
import com.revenuecat.purchases.paywalls.components.VideoComponent;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.common.LocaleId;
import com.revenuecat.purchases.paywalls.components.common.LocalizationData;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey;
import com.revenuecat.purchases.paywalls.components.common.VariableLocalizationKey;
import com.revenuecat.purchases.paywalls.components.properties.Badge;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.CornerRadiuses;
import com.revenuecat.purchases.paywalls.components.properties.Dimension;
import com.revenuecat.purchases.paywalls.components.properties.MaskShape;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls;
import com.revenuecat.purchases.paywalls.components.properties.ThemeVideoUrls;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedCarouselPartial;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedIconPartial;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedImagePartial;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedPackagePartial;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedPartialKt;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedStackPartial;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedTabsPartial;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedTimelineItemPartial;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedTimelinePartial;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedVideoPartial;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.AlignmentKt;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.FitModeKt;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.LocalizationKt;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.PaddingKt;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.ShapeKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.FontSpec;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.style.ButtonComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.CarouselComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.IconComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory;
import com.revenuecat.purchases.ui.revenuecatui.components.style.TabControlStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.TabsComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.TimelineComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.composables.OfferEligibility;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.errors.PaywallValidationError;
import com.revenuecat.purchases.ui.revenuecatui.extensions.OverflowExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.extensions.PackageExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.extensions.PageControlExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Logger;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyList;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyListKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyMap;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyMapKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallLegacyComponentInteraction;
import com.revenuecat.purchases.ui.revenuecatui.helpers.PromoOfferResolver;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResolvedOffer;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Result;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt;
import com.sun.jna.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.experimental.kJ.HcgZcEUYo;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
public final class StyleFactory {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final Shape.Rectangle DEFAULT_SHAPE = new Shape.Rectangle((CornerRadiuses) (0 == true ? 1 : 0), 1, (DefaultConstructorMarker) (0 == true ? 1 : 0));
    private static final float DEFAULT_SPACING = 0.0f;
    private static final boolean DEFAULT_VISIBILITY = true;
    private final Map<ColorAlias, ColorScheme> colorAliases;
    private final Map<FontAlias, FontSpec> fontAliases;
    private final NonEmptyMap<LocaleId, NonEmptyMap<LocalizationKey, LocalizationData>> localizations;
    private final Offering offering;
    private final boolean stripRules;
    private final NonEmptyMap<LocaleId, NonEmptyMap<VariableLocalizationKey, String>> variableLocalizations;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Shape.Rectangle getDEFAULT_SHAPE$revenuecatui_defaultsBc8Release() {
            return StyleFactory.DEFAULT_SHAPE;
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class StyleFactoryScope {
        private CountdownComponent.CountFrom countFrom;
        private final Map<Integer, Function1<PaywallComponent, Boolean>> countPredicates;
        private final Map<Integer, Integer> countValues;
        private Date countdownDate;
        private Integer defaultTabIndex;
        private Map<String, String> enclosingTabContextNamesById;
        private String enclosingTabsComponentName;
        private int enclosingTabsDefaultTabIndexForInteraction;
        private List<String> enclosingTabsOrderedTabIds;
        private PaywallState.Loaded.Components.AvailablePackages.Info packageInfo;
        private final Map<Integer, List<PaywallState.Loaded.Components.AvailablePackages.Info>> packagesByTab;
        private final List<PaywallState.Loaded.Components.AvailablePackages.Info> packagesOutsideTabs;
        private TabControlStyle tabControl;
        private Integer tabControlIndex;
        private Integer tabIndex;
        private final WindowInsetsState windowInsetsState;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        private static final class WindowInsetsState {
            private boolean applyTopWindowInsets;
            private boolean heroImageDetected;
            private boolean ignoreTopWindowInsets;
            private boolean stillLookingForHeaderMedia = true;
            private boolean topWindowInsetsApplied;

            private final boolean isHeaderImage(PaywallComponent paywallComponent) {
                boolean z2;
                if (paywallComponent instanceof ImageComponent) {
                    SizeConstraint width = ((ImageComponent) paywallComponent).getSize().getWidth();
                    if (width instanceof SizeConstraint.Fill) {
                        z2 = true;
                    } else {
                        if (!(width instanceof SizeConstraint.Fit ? true : width instanceof SizeConstraint.Fixed)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        z2 = false;
                    }
                    if (z2) {
                        return true;
                    }
                }
                return false;
            }

            private final boolean isHeaderMedia(PaywallComponent paywallComponent) {
                return isHeaderImage(paywallComponent) || isHeaderVideo(paywallComponent);
            }

            private final boolean isHeaderVideo(PaywallComponent paywallComponent) {
                boolean z2;
                if (paywallComponent instanceof VideoComponent) {
                    SizeConstraint width = ((VideoComponent) paywallComponent).getSize().getWidth();
                    if (width instanceof SizeConstraint.Fill) {
                        z2 = true;
                    } else {
                        if (!(width instanceof SizeConstraint.Fit ? true : width instanceof SizeConstraint.Fixed)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        z2 = false;
                    }
                    if (z2) {
                        return true;
                    }
                }
                return false;
            }

            public final boolean getApplyTopWindowInsets() {
                boolean z2 = this.applyTopWindowInsets;
                this.applyTopWindowInsets = false;
                return z2;
            }

            public final boolean getHeroImageDetected() {
                return this.heroImageDetected;
            }

            public final boolean getIgnoreTopWindowInsets() {
                boolean z2 = this.ignoreTopWindowInsets;
                this.ignoreTopWindowInsets = false;
                return z2;
            }

            public final boolean getTopWindowInsetsApplied() {
                return this.topWindowInsetsApplied;
            }

            public final void handleHeaderMediaViewWindowInsets(PaywallComponent component) {
                Intrinsics.checkNotNullParameter(component, "component");
                boolean z2 = false;
                if (component instanceof StackComponent) {
                    if (this.stillLookingForHeaderMedia) {
                        StackComponent stackComponent = (StackComponent) component;
                        Dimension dimension = stackComponent.getDimension();
                        if (dimension instanceof Dimension.ZLayer) {
                            PaywallComponent paywallComponent = (PaywallComponent) CollectionsKt.firstOrNull(stackComponent.getComponents());
                            if (paywallComponent != null && isHeaderMedia(paywallComponent)) {
                                z2 = true;
                            }
                            this.topWindowInsetsApplied = z2;
                            this.heroImageDetected = z2;
                        } else {
                            if (!(dimension instanceof Dimension.Horizontal ? true : dimension instanceof Dimension.Vertical)) {
                                throw new NoWhenBranchMatchedException();
                            }
                        }
                        this.applyTopWindowInsets = z2;
                        return;
                    }
                    return;
                }
                if (component instanceof ImageComponent) {
                    if (this.stillLookingForHeaderMedia) {
                        this.ignoreTopWindowInsets = isHeaderImage(component);
                        this.heroImageDetected = isHeaderImage(component);
                    }
                    this.stillLookingForHeaderMedia = false;
                    return;
                }
                if (!(component instanceof VideoComponent)) {
                    if (component instanceof FallbackHeaderComponent) {
                        return;
                    }
                    this.stillLookingForHeaderMedia = false;
                } else {
                    if (this.stillLookingForHeaderMedia) {
                        this.ignoreTopWindowInsets = isHeaderVideo(component);
                        this.heroImageDetected = isHeaderVideo(component);
                    }
                    this.stillLookingForHeaderMedia = false;
                }
            }

            public final void setApplyTopWindowInsets(boolean z2) {
                this.applyTopWindowInsets = z2;
            }

            public final void setHeroImageDetected(boolean z2) {
                this.heroImageDetected = z2;
            }

            public final void setIgnoreTopWindowInsets(boolean z2) {
                this.ignoreTopWindowInsets = z2;
            }

            public final void setTopWindowInsetsApplied(boolean z2) {
                this.topWindowInsetsApplied = z2;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class WithCount<T> {
            public static final int $stable = 0;
            private final int count;
            private final T value;

            public WithCount(T t2, int i3) {
                this.value = t2;
                this.count = i3;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ WithCount copy$default(WithCount withCount, Object obj, int i3, int i4, Object obj2) {
                if ((i4 & 1) != 0) {
                    obj = withCount.value;
                }
                if ((i4 & 2) != 0) {
                    i3 = withCount.count;
                }
                return withCount.copy(obj, i3);
            }

            public final T component1() {
                return this.value;
            }

            public final int component2() {
                return this.count;
            }

            public final WithCount<T> copy(T t2, int i3) {
                return new WithCount<>(t2, i3);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof WithCount)) {
                    return false;
                }
                WithCount withCount = (WithCount) obj;
                return Intrinsics.areEqual(this.value, withCount.value) && this.count == withCount.count;
            }

            public final int getCount() {
                return this.count;
            }

            public final T getValue() {
                return this.value;
            }

            public int hashCode() {
                T t2 = this.value;
                return ((t2 == null ? 0 : t2.hashCode()) * 31) + Integer.hashCode(this.count);
            }

            public String toString() {
                return "WithCount(value=" + this.value + ", count=" + this.count + ')';
            }
        }

        public StyleFactoryScope() {
            this(null, null, null, null, null, null, null, 0, null, null, null, null, 4095, null);
        }

        private final Map<Integer, Function1<PaywallComponent, Boolean>> component11() {
            return this.countPredicates;
        }

        private final Map<Integer, Integer> component12() {
            return this.countValues;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StyleFactoryScope copy$default(StyleFactoryScope styleFactoryScope, PaywallState.Loaded.Components.AvailablePackages.Info info, TabControlStyle tabControlStyle, Integer num, Integer num2, String str, List list, Map map, int i3, Date date, CountdownComponent.CountFrom countFrom, Map map2, Map map3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                info = styleFactoryScope.packageInfo;
            }
            if ((i4 & 2) != 0) {
                tabControlStyle = styleFactoryScope.tabControl;
            }
            if ((i4 & 4) != 0) {
                num = styleFactoryScope.tabControlIndex;
            }
            if ((i4 & 8) != 0) {
                num2 = styleFactoryScope.tabIndex;
            }
            if ((i4 & 16) != 0) {
                str = styleFactoryScope.enclosingTabsComponentName;
            }
            if ((i4 & 32) != 0) {
                list = styleFactoryScope.enclosingTabsOrderedTabIds;
            }
            if ((i4 & 64) != 0) {
                map = styleFactoryScope.enclosingTabContextNamesById;
            }
            if ((i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
                i3 = styleFactoryScope.enclosingTabsDefaultTabIndexForInteraction;
            }
            if ((i4 & Function.MAX_NARGS) != 0) {
                date = styleFactoryScope.countdownDate;
            }
            if ((i4 & 512) != 0) {
                countFrom = styleFactoryScope.countFrom;
            }
            if ((i4 & 1024) != 0) {
                map2 = styleFactoryScope.countPredicates;
            }
            if ((i4 & 2048) != 0) {
                map3 = styleFactoryScope.countValues;
            }
            Map map4 = map2;
            Map map5 = map3;
            Date date2 = date;
            CountdownComponent.CountFrom countFrom2 = countFrom;
            Map map6 = map;
            int i5 = i3;
            String str2 = str;
            List list2 = list;
            return styleFactoryScope.copy(info, tabControlStyle, num, num2, str2, list2, map6, i5, date2, countFrom2, map4, map5);
        }

        private final void recordPackage(PaywallState.Loaded.Components.AvailablePackages.Info info) {
            Integer num = this.tabIndex;
            if (num == null) {
                this.packagesOutsideTabs.add(info);
                return;
            }
            Map<Integer, List<PaywallState.Loaded.Components.AvailablePackages.Info>> map = this.packagesByTab;
            List<PaywallState.Loaded.Components.AvailablePackages.Info> arrayList = map.get(num);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                map.put(num, arrayList);
            }
            arrayList.add(info);
        }

        public final <T extends ComponentStyle> T applyBottomWindowInsetsIfNecessary(T t2, boolean z2) {
            T tCopy = t2;
            Intrinsics.checkNotNullParameter(tCopy, "<this>");
            if (z2) {
                if (tCopy instanceof StackComponentStyle) {
                    tCopy = StackComponentStyle.m833copyh6c5tkY$default((StackComponentStyle) tCopy, null, null, false, null, StyleFactory.DEFAULT_SPACING, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, true, false, 12582911, null);
                } else if (tCopy instanceof StickyFooterComponentStyle) {
                    StickyFooterComponentStyle stickyFooterComponentStyle = (StickyFooterComponentStyle) tCopy;
                    tCopy = stickyFooterComponentStyle.copy(StackComponentStyle.m833copyh6c5tkY$default(stickyFooterComponentStyle.getStackComponentStyle(), null, null, false, null, StyleFactory.DEFAULT_SPACING, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, true, false, 12582911, null));
                }
                Intrinsics.checkNotNull(tCopy, "null cannot be cast to non-null type T of com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.StyleFactoryScope.applyBottomWindowInsetsIfNecessary");
            }
            return tCopy;
        }

        public final <T extends ComponentStyle> T applyHorizontalWindowInsetsIfNecessary(T t2, boolean z2) {
            T tCopy = t2;
            Intrinsics.checkNotNullParameter(tCopy, "<this>");
            if (z2) {
                if (tCopy instanceof StackComponentStyle) {
                    tCopy = StackComponentStyle.m833copyh6c5tkY$default((StackComponentStyle) tCopy, null, null, false, null, StyleFactory.DEFAULT_SPACING, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, true, 8388607, null);
                } else if (tCopy instanceof StickyFooterComponentStyle) {
                    StickyFooterComponentStyle stickyFooterComponentStyle = (StickyFooterComponentStyle) tCopy;
                    tCopy = stickyFooterComponentStyle.copy(StackComponentStyle.m833copyh6c5tkY$default(stickyFooterComponentStyle.getStackComponentStyle(), null, null, false, null, StyleFactory.DEFAULT_SPACING, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, true, 8388607, null));
                } else if (tCopy instanceof HeaderComponentStyle) {
                    HeaderComponentStyle headerComponentStyle = (HeaderComponentStyle) tCopy;
                    tCopy = headerComponentStyle.copy(StackComponentStyle.m833copyh6c5tkY$default(headerComponentStyle.getStackComponentStyle(), null, null, false, null, StyleFactory.DEFAULT_SPACING, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, true, 8388607, null));
                }
                Intrinsics.checkNotNull(tCopy, "null cannot be cast to non-null type T of com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.StyleFactoryScope.applyHorizontalWindowInsetsIfNecessary");
            }
            return tCopy;
        }

        public final ComponentStyle applyTopWindowInsetsIfNotYetApplied(ComponentStyle to) {
            Intrinsics.checkNotNullParameter(to, "to");
            if (to instanceof StackComponentStyle) {
                return StackComponentStyle.m833copyh6c5tkY$default((StackComponentStyle) to, null, null, false, null, StyleFactory.DEFAULT_SPACING, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, !this.windowInsetsState.getTopWindowInsetsApplied(), false, false, false, 15728639, null);
            }
            if (!(to instanceof HeaderComponentStyle)) {
                return to;
            }
            HeaderComponentStyle headerComponentStyle = (HeaderComponentStyle) to;
            return headerComponentStyle.copy(StackComponentStyle.m833copyh6c5tkY$default(headerComponentStyle.getStackComponentStyle(), null, null, false, null, StyleFactory.DEFAULT_SPACING, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, !this.windowInsetsState.getTopWindowInsetsApplied(), true, false, false, 13631487, null));
        }

        public final PaywallState.Loaded.Components.AvailablePackages.Info component1() {
            return this.packageInfo;
        }

        public final CountdownComponent.CountFrom component10() {
            return this.countFrom;
        }

        public final TabControlStyle component2() {
            return this.tabControl;
        }

        public final Integer component3() {
            return this.tabControlIndex;
        }

        public final Integer component4() {
            return this.tabIndex;
        }

        public final String component5() {
            return this.enclosingTabsComponentName;
        }

        public final List<String> component6() {
            return this.enclosingTabsOrderedTabIds;
        }

        public final Map<String, String> component7() {
            return this.enclosingTabContextNamesById;
        }

        public final int component8() {
            return this.enclosingTabsDefaultTabIndexForInteraction;
        }

        public final Date component9() {
            return this.countdownDate;
        }

        public final StyleFactoryScope copy(PaywallState.Loaded.Components.AvailablePackages.Info info, TabControlStyle tabControlStyle, Integer num, Integer num2, String str, List<String> enclosingTabsOrderedTabIds, Map<String, String> enclosingTabContextNamesById, int i3, Date date, CountdownComponent.CountFrom countFrom, Map<Integer, Function1<PaywallComponent, Boolean>> countPredicates, Map<Integer, Integer> countValues) {
            Intrinsics.checkNotNullParameter(enclosingTabsOrderedTabIds, "enclosingTabsOrderedTabIds");
            Intrinsics.checkNotNullParameter(enclosingTabContextNamesById, "enclosingTabContextNamesById");
            Intrinsics.checkNotNullParameter(countFrom, "countFrom");
            Intrinsics.checkNotNullParameter(countPredicates, "countPredicates");
            Intrinsics.checkNotNullParameter(countValues, "countValues");
            return new StyleFactoryScope(info, tabControlStyle, num, num2, str, enclosingTabsOrderedTabIds, enclosingTabContextNamesById, i3, date, countFrom, countPredicates, countValues);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof StyleFactoryScope)) {
                return false;
            }
            StyleFactoryScope styleFactoryScope = (StyleFactoryScope) obj;
            return Intrinsics.areEqual(this.packageInfo, styleFactoryScope.packageInfo) && Intrinsics.areEqual(this.tabControl, styleFactoryScope.tabControl) && Intrinsics.areEqual(this.tabControlIndex, styleFactoryScope.tabControlIndex) && Intrinsics.areEqual(this.tabIndex, styleFactoryScope.tabIndex) && Intrinsics.areEqual(this.enclosingTabsComponentName, styleFactoryScope.enclosingTabsComponentName) && Intrinsics.areEqual(this.enclosingTabsOrderedTabIds, styleFactoryScope.enclosingTabsOrderedTabIds) && Intrinsics.areEqual(this.enclosingTabContextNamesById, styleFactoryScope.enclosingTabContextNamesById) && this.enclosingTabsDefaultTabIndexForInteraction == styleFactoryScope.enclosingTabsDefaultTabIndexForInteraction && Intrinsics.areEqual(this.countdownDate, styleFactoryScope.countdownDate) && this.countFrom == styleFactoryScope.countFrom && Intrinsics.areEqual(this.countPredicates, styleFactoryScope.countPredicates) && Intrinsics.areEqual(this.countValues, styleFactoryScope.countValues);
        }

        public final boolean getApplyTopWindowInsets() {
            return this.windowInsetsState.getApplyTopWindowInsets();
        }

        public final CountdownComponent.CountFrom getCountFrom() {
            return this.countFrom;
        }

        public final Date getCountdownDate() {
            return this.countdownDate;
        }

        public final Integer getDefaultTabIndex() {
            return this.defaultTabIndex;
        }

        public final Map<String, String> getEnclosingTabContextNamesById() {
            return this.enclosingTabContextNamesById;
        }

        public final String getEnclosingTabsComponentName() {
            return this.enclosingTabsComponentName;
        }

        public final int getEnclosingTabsDefaultTabIndexForInteraction() {
            return this.enclosingTabsDefaultTabIndexForInteraction;
        }

        public final List<String> getEnclosingTabsOrderedTabIds() {
            return this.enclosingTabsOrderedTabIds;
        }

        public final boolean getHeroImageDetected() {
            return this.windowInsetsState.getHeroImageDetected();
        }

        public final boolean getIgnoreTopWindowInsets() {
            return this.windowInsetsState.getIgnoreTopWindowInsets();
        }

        public final OfferEligibility getOfferEligibility() {
            PaywallState.Loaded.Components.AvailablePackages.Info info = this.packageInfo;
            if (info != null) {
                return PackageExtensionsKt.calculateOfferEligibility(info.getResolvedOffer(), info.getPkg());
            }
            return null;
        }

        public final PaywallState.Loaded.Components.AvailablePackages.Info getPackageInfo() {
            return this.packageInfo;
        }

        public final PaywallState.Loaded.Components.AvailablePackages getPackages() {
            return new PaywallState.Loaded.Components.AvailablePackages(this.packagesOutsideTabs, this.packagesByTab);
        }

        public final Package getRcPackage() {
            PaywallState.Loaded.Components.AvailablePackages.Info info = this.packageInfo;
            if (info != null) {
                return info.getPkg();
            }
            return null;
        }

        public final ResolvedOffer getResolvedOffer() {
            PaywallState.Loaded.Components.AvailablePackages.Info info = this.packageInfo;
            if (info != null) {
                return info.getResolvedOffer();
            }
            return null;
        }

        public final TabControlStyle getTabControl() {
            return this.tabControl;
        }

        public final Integer getTabControlIndex() {
            return this.tabControlIndex;
        }

        public final Integer getTabIndex() {
            return this.tabIndex;
        }

        public final WindowInsetsState getWindowInsetsState() {
            return this.windowInsetsState;
        }

        public int hashCode() {
            PaywallState.Loaded.Components.AvailablePackages.Info info = this.packageInfo;
            int iHashCode = (info == null ? 0 : info.hashCode()) * 31;
            TabControlStyle tabControlStyle = this.tabControl;
            int iHashCode2 = (iHashCode + (tabControlStyle == null ? 0 : tabControlStyle.hashCode())) * 31;
            Integer num = this.tabControlIndex;
            int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.tabIndex;
            int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
            String str = this.enclosingTabsComponentName;
            int iHashCode5 = (((((((iHashCode4 + (str == null ? 0 : str.hashCode())) * 31) + this.enclosingTabsOrderedTabIds.hashCode()) * 31) + this.enclosingTabContextNamesById.hashCode()) * 31) + Integer.hashCode(this.enclosingTabsDefaultTabIndexForInteraction)) * 31;
            Date date = this.countdownDate;
            return ((((((iHashCode5 + (date != null ? date.hashCode() : 0)) * 31) + this.countFrom.hashCode()) * 31) + this.countPredicates.hashCode()) * 31) + this.countValues.hashCode();
        }

        public final void recordComponent(PaywallComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            for (Map.Entry<Integer, Function1<PaywallComponent, Boolean>> entry : this.countPredicates.entrySet()) {
                int iIntValue = entry.getKey().intValue();
                if (((Boolean) entry.getValue().invoke(component)).booleanValue()) {
                    Integer num = this.countValues.get(Integer.valueOf(iIntValue));
                    this.countValues.put(Integer.valueOf(iIntValue), Integer.valueOf((num != null ? num.intValue() : 0) + 1));
                }
            }
            this.windowInsetsState.handleHeaderMediaViewWindowInsets(component);
        }

        public final void setCountFrom(CountdownComponent.CountFrom countFrom) {
            Intrinsics.checkNotNullParameter(countFrom, "<set-?>");
            this.countFrom = countFrom;
        }

        public final void setCountdownDate(Date date) {
            this.countdownDate = date;
        }

        public final void setDefaultTabIndex(Integer num) {
            this.defaultTabIndex = num;
        }

        public final void setEnclosingTabContextNamesById(Map<String, String> map) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            this.enclosingTabContextNamesById = map;
        }

        public final void setEnclosingTabsComponentName(String str) {
            this.enclosingTabsComponentName = str;
        }

        public final void setEnclosingTabsDefaultTabIndexForInteraction(int i3) {
            this.enclosingTabsDefaultTabIndexForInteraction = i3;
        }

        public final void setEnclosingTabsOrderedTabIds(List<String> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.enclosingTabsOrderedTabIds = list;
        }

        public final void setPackageInfo(PaywallState.Loaded.Components.AvailablePackages.Info info) {
            this.packageInfo = info;
        }

        public final void setTabControl(TabControlStyle tabControlStyle) {
            this.tabControl = tabControlStyle;
        }

        public final void setTabControlIndex(Integer num) {
            this.tabControlIndex = num;
        }

        public final void setTabIndex(Integer num) {
            this.tabIndex = num;
        }

        public String toString() {
            return "StyleFactoryScope(packageInfo=" + this.packageInfo + ", tabControl=" + this.tabControl + ", tabControlIndex=" + this.tabControlIndex + ", tabIndex=" + this.tabIndex + ", enclosingTabsComponentName=" + this.enclosingTabsComponentName + ", enclosingTabsOrderedTabIds=" + this.enclosingTabsOrderedTabIds + ", enclosingTabContextNamesById=" + this.enclosingTabContextNamesById + ", enclosingTabsDefaultTabIndexForInteraction=" + this.enclosingTabsDefaultTabIndexForInteraction + ", countdownDate=" + this.countdownDate + ", countFrom=" + this.countFrom + ", countPredicates=" + this.countPredicates + ", countValues=" + this.countValues + ')';
        }

        public final <T> WithCount<T> withCount(Function1<? super PaywallComponent, Boolean> predicate, Function1<? super StyleFactoryScope, ? extends T> block) {
            Intrinsics.checkNotNullParameter(predicate, "predicate");
            Intrinsics.checkNotNullParameter(block, "block");
            Integer num = (Integer) CollectionsKt.maxOrNull((Iterable) this.countPredicates.keySet());
            int iIntValue = (num != null ? num.intValue() : -1) + 1;
            this.countPredicates.put(Integer.valueOf(iIntValue), predicate);
            this.countValues.put(Integer.valueOf(iIntValue), 0);
            WithCount<T> withCount = new WithCount<>(block.invoke(this), ((Number) MapsKt.getValue(this.countValues, Integer.valueOf(iIntValue))).intValue());
            this.countPredicates.remove(Integer.valueOf(iIntValue));
            this.countValues.remove(Integer.valueOf(iIntValue));
            return withCount;
        }

        public final <T> T withCountdown(Date countdownDate, CountdownComponent.CountFrom countFrom, Function1<? super StyleFactoryScope, ? extends T> block) {
            Intrinsics.checkNotNullParameter(countdownDate, "countdownDate");
            Intrinsics.checkNotNullParameter(countFrom, "countFrom");
            Intrinsics.checkNotNullParameter(block, "block");
            StyleFactoryScope styleFactoryScopeCopy$default = copy$default(this, null, null, null, null, null, null, null, 0, null, null, null, null, 4095, null);
            this.countdownDate = countdownDate;
            this.countFrom = countFrom;
            T t2 = (T) block.invoke(this);
            this.countdownDate = styleFactoryScopeCopy$default.countdownDate;
            this.countFrom = styleFactoryScopeCopy$default.countFrom;
            return t2;
        }

        public final <T> T withSelectedScope(PaywallState.Loaded.Components.AvailablePackages.Info info, Integer num, Function1<? super StyleFactoryScope, ? extends T> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            if (info != null) {
                recordPackage(info);
            }
            StyleFactoryScope styleFactoryScopeCopy$default = copy$default(this, null, null, null, null, null, null, null, 0, null, null, null, null, 4095, null);
            this.packageInfo = info;
            this.tabControlIndex = num;
            T t2 = (T) block.invoke(this);
            this.packageInfo = styleFactoryScopeCopy$default.packageInfo;
            this.tabControlIndex = styleFactoryScopeCopy$default.tabControlIndex;
            return t2;
        }

        public final <T> T withTabControl(TabControlStyle tabControl, Function1<? super StyleFactoryScope, ? extends T> block) {
            Intrinsics.checkNotNullParameter(tabControl, "tabControl");
            Intrinsics.checkNotNullParameter(block, "block");
            StyleFactoryScope styleFactoryScopeCopy$default = copy$default(this, null, null, null, null, null, null, null, 0, null, null, null, null, 4095, null);
            this.tabControl = tabControl;
            T t2 = (T) block.invoke(this);
            this.tabControl = styleFactoryScopeCopy$default.tabControl;
            return t2;
        }

        public final <T> T withTabIndex(int i3, Function1<? super StyleFactoryScope, ? extends T> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            StyleFactoryScope styleFactoryScopeCopy$default = copy$default(this, null, null, null, null, null, null, null, 0, null, null, null, null, 4095, null);
            this.tabIndex = Integer.valueOf(i3);
            T t2 = (T) block.invoke(this);
            this.tabIndex = styleFactoryScopeCopy$default.tabIndex;
            return t2;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0075  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final <T> T withTabsInteractionContext(java.lang.String r10, java.util.List<com.revenuecat.purchases.paywalls.components.TabsComponent.Tab> r11, java.lang.String r12, kotlin.jvm.functions.Function1<? super com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.StyleFactoryScope, ? extends T> r13) {
            /*
                Method dump skipped, instruction units count: 219
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.StyleFactoryScope.withTabsInteractionContext(java.lang.String, java.util.List, java.lang.String, kotlin.jvm.functions.Function1):java.lang.Object");
        }

        public StyleFactoryScope(PaywallState.Loaded.Components.AvailablePackages.Info info, TabControlStyle tabControlStyle, Integer num, Integer num2, String str, List<String> list, Map<String, String> enclosingTabContextNamesById, int i3, Date date, CountdownComponent.CountFrom countFrom, Map<Integer, Function1<PaywallComponent, Boolean>> countPredicates, Map<Integer, Integer> countValues) {
            Intrinsics.checkNotNullParameter(list, muQRKXGtpOhe.blHAubHbXKzEk);
            Intrinsics.checkNotNullParameter(enclosingTabContextNamesById, "enclosingTabContextNamesById");
            Intrinsics.checkNotNullParameter(countFrom, "countFrom");
            Intrinsics.checkNotNullParameter(countPredicates, "countPredicates");
            Intrinsics.checkNotNullParameter(countValues, "countValues");
            this.packageInfo = info;
            this.tabControl = tabControlStyle;
            this.tabControlIndex = num;
            this.tabIndex = num2;
            this.enclosingTabsComponentName = str;
            this.enclosingTabsOrderedTabIds = list;
            this.enclosingTabContextNamesById = enclosingTabContextNamesById;
            this.enclosingTabsDefaultTabIndexForInteraction = i3;
            this.countdownDate = date;
            this.countFrom = countFrom;
            this.countPredicates = countPredicates;
            this.countValues = countValues;
            this.windowInsetsState = new WindowInsetsState();
            this.packagesOutsideTabs = new ArrayList();
            this.packagesByTab = new LinkedHashMap();
        }

        public /* synthetic */ StyleFactoryScope(PaywallState.Loaded.Components.AvailablePackages.Info info, TabControlStyle tabControlStyle, Integer num, Integer num2, String str, List list, Map map, int i3, Date date, CountdownComponent.CountFrom countFrom, Map map2, Map map3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this((i4 & 1) != 0 ? null : info, (i4 & 2) != 0 ? null : tabControlStyle, (i4 & 4) != 0 ? null : num, (i4 & 8) != 0 ? null : num2, (i4 & 16) != 0 ? null : str, (i4 & 32) != 0 ? CollectionsKt.emptyList() : list, (i4 & 64) != 0 ? MapsKt.emptyMap() : map, (i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? 0 : i3, (i4 & Function.MAX_NARGS) != 0 ? null : date, (i4 & 512) != 0 ? CountdownComponent.CountFrom.DAYS : countFrom, (i4 & 1024) != 0 ? new LinkedHashMap() : map2, (i4 & 2048) != 0 ? new LinkedHashMap() : map3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ButtonComponent.UrlMethod.values().length];
            try {
                iArr[ButtonComponent.UrlMethod.IN_APP_BROWSER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ButtonComponent.UrlMethod.EXTERNAL_BROWSER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ButtonComponent.UrlMethod.DEEP_LINK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ButtonComponent.UrlMethod.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StyleFactory(NonEmptyMap<LocaleId, ? extends NonEmptyMap<LocalizationKey, ? extends LocalizationData>> localizations, Map<ColorAlias, ColorScheme> colorAliases, Map<FontAlias, ? extends FontSpec> fontAliases, NonEmptyMap<LocaleId, NonEmptyMap<VariableLocalizationKey, String>> variableLocalizations, Offering offering, boolean z2) {
        Intrinsics.checkNotNullParameter(localizations, "localizations");
        Intrinsics.checkNotNullParameter(colorAliases, "colorAliases");
        Intrinsics.checkNotNullParameter(fontAliases, "fontAliases");
        Intrinsics.checkNotNullParameter(variableLocalizations, "variableLocalizations");
        Intrinsics.checkNotNullParameter(offering, "offering");
        this.localizations = localizations;
        this.colorAliases = colorAliases;
        this.fontAliases = fontAliases;
        this.variableLocalizations = variableLocalizations;
        this.offering = offering;
        this.stripRules = z2;
    }

    /* JADX INFO: renamed from: buttonComponentStyleUrlDestination-xW_dp2A, reason: not valid java name */
    private final Result<ButtonComponentStyle.Action.NavigateTo.Destination.Url, NonEmptyList<PaywallValidationError.MissingStringLocalization>> m839buttonComponentStyleUrlDestinationxW_dp2A(String str, ButtonComponent.UrlMethod urlMethod, String str2) {
        Result<ButtonComponentStyle.Action.NavigateTo.Destination.Url, NonEmptyList<PaywallValidationError.MissingStringLocalization>> resultM731stringForAllLocales7v81vok = LocalizationKt.m731stringForAllLocales7v81vok(this.localizations, str);
        if (resultM731stringForAllLocales7v81vok instanceof Result.Success) {
            resultM731stringForAllLocales7v81vok = new Result.Success<>(new ButtonComponentStyle.Action.NavigateTo.Destination.Url((NonEmptyMap) ((Result.Success) resultM731stringForAllLocales7v81vok).getValue(), urlMethod, str2));
        } else if (!(resultM731stringForAllLocales7v81vok instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (!(resultM731stringForAllLocales7v81vok instanceof Result.Success)) {
            if (resultM731stringForAllLocales7v81vok instanceof Result.Error) {
                return resultM731stringForAllLocales7v81vok;
            }
            throw new NoWhenBranchMatchedException();
        }
        ButtonComponentStyle.Action.NavigateTo.Destination.Url url = (ButtonComponentStyle.Action.NavigateTo.Destination.Url) ((Result.Success) resultM731stringForAllLocales7v81vok).getValue();
        int i3 = WhenMappings.$EnumSwitchMapping$0[url.getMethod().ordinal()];
        if (i3 != 1 && i3 != 2 && i3 != 3) {
            if (i3 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            url = null;
        }
        return new Result.Success(url);
    }

    private final Result<ButtonComponentStyle.Action, NonEmptyList<PaywallValidationError>> convertAction(StyleFactoryScope styleFactoryScope, ButtonComponent.Action action) {
        if (action instanceof ButtonComponent.Action.NavigateBack) {
            return new Result.Success(ButtonComponentStyle.Action.NavigateBack.INSTANCE);
        }
        if (action instanceof ButtonComponent.Action.RestorePurchases) {
            return new Result.Success(ButtonComponentStyle.Action.RestorePurchases.INSTANCE);
        }
        if (!(action instanceof ButtonComponent.Action.NavigateTo)) {
            if (action instanceof ButtonComponent.Action.WorkflowTrigger) {
                return new Result.Success(ButtonComponentStyle.Action.WorkflowTrigger.INSTANCE);
            }
            if (action instanceof ButtonComponent.Action.Unknown) {
                return new Result.Success(null);
            }
            throw new NoWhenBranchMatchedException();
        }
        Result resultConvertDestination = convertDestination(styleFactoryScope, ((ButtonComponent.Action.NavigateTo) action).getDestination());
        if (resultConvertDestination instanceof Result.Success) {
            ButtonComponentStyle.Action.NavigateTo.Destination destination = (ButtonComponentStyle.Action.NavigateTo.Destination) ((Result.Success) resultConvertDestination).getValue();
            return new Result.Success(destination != null ? new ButtonComponentStyle.Action.NavigateTo(destination) : null);
        }
        if (resultConvertDestination instanceof Result.Error) {
            return resultConvertDestination;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Result<ButtonComponentStyle.Action.NavigateTo.Destination, NonEmptyList<PaywallValidationError>> convertDestination(StyleFactoryScope styleFactoryScope, ButtonComponent.Destination destination) {
        if (destination instanceof ButtonComponent.Destination.CustomerCenter) {
            return new Result.Success(ButtonComponentStyle.Action.NavigateTo.Destination.CustomerCenter.INSTANCE);
        }
        if (destination instanceof ButtonComponent.Destination.PrivacyPolicy) {
            ButtonComponent.Destination.PrivacyPolicy privacyPolicy = (ButtonComponent.Destination.PrivacyPolicy) destination;
            return m839buttonComponentStyleUrlDestinationxW_dp2A(privacyPolicy.m577getUrlLidz7Tp4o(), privacyPolicy.getMethod(), PaywallLegacyComponentInteraction.Value.NAVIGATE_TO_PRIVACY_POLICY);
        }
        if (destination instanceof ButtonComponent.Destination.Terms) {
            ButtonComponent.Destination.Terms terms = (ButtonComponent.Destination.Terms) destination;
            return m839buttonComponentStyleUrlDestinationxW_dp2A(terms.m581getUrlLidz7Tp4o(), terms.getMethod(), PaywallLegacyComponentInteraction.Value.NAVIGATE_TO_TERMS);
        }
        if (destination instanceof ButtonComponent.Destination.Url) {
            ButtonComponent.Destination.Url url = (ButtonComponent.Destination.Url) destination;
            return m839buttonComponentStyleUrlDestinationxW_dp2A(url.m585getUrlLidz7Tp4o(), url.getMethod(), "navigate_to_url");
        }
        if (!(destination instanceof ButtonComponent.Destination.Sheet)) {
            if (destination instanceof ButtonComponent.Destination.Unknown) {
                return new Result.Success(null);
            }
            throw new NoWhenBranchMatchedException();
        }
        ButtonComponent.Destination.Sheet sheet = (ButtonComponent.Destination.Sheet) destination;
        Result resultCreateStackComponentStyle = createStackComponentStyle(styleFactoryScope, sheet.getStack());
        if (resultCreateStackComponentStyle instanceof Result.Success) {
            resultCreateStackComponentStyle = new Result.Success((StackComponentStyle) styleFactoryScope.applyBottomWindowInsetsIfNecessary((StackComponentStyle) ((Result.Success) resultCreateStackComponentStyle).getValue(), true));
        } else if (!(resultCreateStackComponentStyle instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (resultCreateStackComponentStyle instanceof Result.Success) {
            resultCreateStackComponentStyle = new Result.Success((StackComponentStyle) styleFactoryScope.applyHorizontalWindowInsetsIfNecessary((StackComponentStyle) ((Result.Success) resultCreateStackComponentStyle).getValue(), true));
        } else if (!(resultCreateStackComponentStyle instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (resultCreateStackComponentStyle instanceof Result.Success) {
            return new Result.Success(new ButtonComponentStyle.Action.NavigateTo.Destination.Sheet(sheet.getId(), sheet.getName(), (StackComponentStyle) ((Result.Success) resultCreateStackComponentStyle).getValue(), sheet.getBackgroundBlur(), sheet.getSize()));
        }
        if (resultCreateStackComponentStyle instanceof Result.Error) {
            return resultCreateStackComponentStyle;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Result<ButtonComponentStyle.Action, NonEmptyList<PaywallValidationError>> convertPurchaseButtonMethod(StyleFactoryScope styleFactoryScope, PurchaseButtonComponent.Method method) {
        boolean zBooleanValue;
        if (method == null) {
            return new Result.Success(new ButtonComponentStyle.Action.PurchasePackage(styleFactoryScope.getRcPackage(), styleFactoryScope.getResolvedOffer()));
        }
        if (method instanceof PurchaseButtonComponent.Method.InAppCheckout) {
            return new Result.Success(new ButtonComponentStyle.Action.PurchasePackage(styleFactoryScope.getRcPackage(), styleFactoryScope.getResolvedOffer()));
        }
        if (method instanceof PurchaseButtonComponent.Method.WebCheckout) {
            Package rcPackage = styleFactoryScope.getRcPackage();
            PurchaseButtonComponent.Method.WebCheckout webCheckout = (PurchaseButtonComponent.Method.WebCheckout) method;
            Boolean autoDismiss = webCheckout.getAutoDismiss();
            zBooleanValue = autoDismiss != null ? autoDismiss.booleanValue() : true;
            ButtonComponent.UrlMethod openMethod = webCheckout.getOpenMethod();
            if (openMethod == null) {
                openMethod = ButtonComponent.UrlMethod.EXTERNAL_BROWSER;
            }
            return new Result.Success(new ButtonComponentStyle.Action.WebCheckout(rcPackage, zBooleanValue, openMethod));
        }
        if (method instanceof PurchaseButtonComponent.Method.WebProductSelection) {
            PurchaseButtonComponent.Method.WebProductSelection webProductSelection = (PurchaseButtonComponent.Method.WebProductSelection) method;
            Boolean autoDismiss2 = webProductSelection.getAutoDismiss();
            zBooleanValue = autoDismiss2 != null ? autoDismiss2.booleanValue() : true;
            ButtonComponent.UrlMethod openMethod2 = webProductSelection.getOpenMethod();
            if (openMethod2 == null) {
                openMethod2 = ButtonComponent.UrlMethod.EXTERNAL_BROWSER;
            }
            return new Result.Success(new ButtonComponentStyle.Action.WebProductSelection(zBooleanValue, openMethod2));
        }
        if (!(method instanceof PurchaseButtonComponent.Method.CustomWebCheckout)) {
            if (!(method instanceof PurchaseButtonComponent.Method.Unknown)) {
                throw new NoWhenBranchMatchedException();
            }
            Logger.INSTANCE.e("Unknown purchase button method. Defaulting to purchasing current/default package.");
            return new Result.Success(new ButtonComponentStyle.Action.PurchasePackage(styleFactoryScope.getRcPackage(), styleFactoryScope.getResolvedOffer()));
        }
        PurchaseButtonComponent.Method.CustomWebCheckout customWebCheckout = (PurchaseButtonComponent.Method.CustomWebCheckout) method;
        Result<ButtonComponentStyle.Action, NonEmptyList<PaywallValidationError>> resultM731stringForAllLocales7v81vok = LocalizationKt.m731stringForAllLocales7v81vok(this.localizations, customWebCheckout.getCustomUrl().m604getUrlLidz7Tp4o());
        if (!(resultM731stringForAllLocales7v81vok instanceof Result.Success)) {
            if (resultM731stringForAllLocales7v81vok instanceof Result.Error) {
                return resultM731stringForAllLocales7v81vok;
            }
            throw new NoWhenBranchMatchedException();
        }
        NonEmptyMap nonEmptyMap = (NonEmptyMap) ((Result.Success) resultM731stringForAllLocales7v81vok).getValue();
        Boolean autoDismiss3 = customWebCheckout.getAutoDismiss();
        boolean zBooleanValue2 = autoDismiss3 != null ? autoDismiss3.booleanValue() : true;
        ButtonComponent.UrlMethod openMethod3 = customWebCheckout.getOpenMethod();
        if (openMethod3 == null) {
            openMethod3 = ButtonComponent.UrlMethod.EXTERNAL_BROWSER;
        }
        return new Result.Success(new ButtonComponentStyle.Action.CustomWebCheckout(nonEmptyMap, zBooleanValue2, openMethod3, styleFactoryScope.getRcPackage(), customWebCheckout.getCustomUrl().getPackageParam()));
    }

    public static /* synthetic */ Result create$default(StyleFactory styleFactory, PaywallComponent paywallComponent, boolean z2, boolean z3, boolean z4, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = true;
        }
        if ((i3 & 4) != 0) {
            z3 = false;
        }
        if ((i3 & 8) != 0) {
            z4 = false;
        }
        return styleFactory.create(paywallComponent, z2, z3, z4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Result<BackgroundStyles, NonEmptyList<PaywallValidationError>> createBackgroundStyles(Background background, ColorScheme colorScheme) {
        Result colorStyles;
        Result<BackgroundStyles, NonEmptyList<PaywallValidationError>> backgroundStyles;
        if (background != null && (backgroundStyles = BackgroundStyleKt.toBackgroundStyles(background, this.colorAliases)) != null) {
            return backgroundStyles;
        }
        if (colorScheme == null || (colorStyles = ColorStyleKt.toColorStyles(colorScheme, this.colorAliases)) == null) {
            colorStyles = null;
        } else if (colorStyles instanceof Result.Success) {
            colorStyles = new Result.Success(BackgroundStyles.Color.m753boximpl(BackgroundStyles.Color.m754constructorimpl((ColorStyles) ((Result.Success) colorStyles).getValue())));
        } else if (!(colorStyles instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return ResultKt.orSuccessfullyNull(colorStyles);
    }

    private final Result<ButtonComponentStyle, NonEmptyList<PaywallValidationError>> createButtonComponentStyleOrNull(StyleFactoryScope styleFactoryScope, ButtonComponent buttonComponent) {
        Result<ButtonComponentStyle, NonEmptyList<PaywallValidationError>> success;
        Result<StackComponentStyle, NonEmptyList<PaywallValidationError>> resultCreateStackComponentStyle = createStackComponentStyle(styleFactoryScope, buttonComponent.getStack());
        Result<ButtonComponentStyle.Action, NonEmptyList<PaywallValidationError>> resultConvertAction = convertAction(styleFactoryScope, buttonComponent.getAction());
        Unit unit = Unit.f139807a;
        Result.Success success2 = new Result.Success(unit);
        Result.Success success3 = new Result.Success(unit);
        Result.Success success4 = new Result.Success(unit);
        Result.Success success5 = new Result.Success(unit);
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(ResultKt.collectErrors(CollectionsKt.listOf((Object[]) new Result[]{resultCreateStackComponentStyle, resultConvertAction, success2, success3, success4, success5})));
        if (nonEmptyListOrNull != null) {
            success = new Result.Error<>(nonEmptyListOrNull);
        } else {
            Intrinsics.checkNotNull(resultCreateStackComponentStyle, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<A of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
            Object value = ((Result.Success) resultCreateStackComponentStyle).getValue();
            Intrinsics.checkNotNull(resultConvertAction, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<B of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
            Object value2 = ((Result.Success) resultConvertAction).getValue();
            Object value3 = success2.getValue();
            Object value4 = success3.getValue();
            Object value5 = success4.getValue();
            ButtonComponentStyle.Action action = (ButtonComponentStyle.Action) value2;
            success = new Result.Success<>(action != null ? new ButtonComponentStyle((StackComponentStyle) value, action, buttonComponent.getTransition(), buttonComponent.getName(), buttonComponent.getId()) : null);
        }
        if (success instanceof Result.Success) {
            ButtonComponentStyle buttonComponentStyle = (ButtonComponentStyle) ((Result.Success) success).getValue();
            return (((buttonComponentStyle != null ? buttonComponentStyle.getAction() : null) instanceof ButtonComponentStyle.Action.WorkflowTrigger) && buttonComponentStyle.getComponentId() == null) ? new Result.Error(NonEmptyListKt.nonEmptyListOf(new PaywallValidationError.WorkflowButtonMissingComponentId(buttonComponent.getName()), new PaywallValidationError.WorkflowButtonMissingComponentId[0])) : new Result.Success(buttonComponentStyle);
        }
        if (success instanceof Result.Error) {
            return success;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Result<CarouselComponentStyle, NonEmptyList<PaywallValidationError>> createCarouselComponentStyle(StyleFactoryScope styleFactoryScope, CarouselComponent carouselComponent) {
        Result error;
        Result presentedOverrides = PresentedPartialKt.toPresentedOverrides(carouselComponent.getOverrides(), this.stripRules, new Function1<PartialCarouselComponent, Result<? extends PresentedCarouselPartial, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createCarouselComponentStyle.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<PresentedCarouselPartial, NonEmptyList<PaywallValidationError>> invoke(PartialCarouselComponent partial) {
                Intrinsics.checkNotNullParameter(partial, "partial");
                return PresentedCarouselPartial.Companion.invoke(partial, StyleFactory.this.colorAliases);
            }
        });
        if (presentedOverrides instanceof Result.Success) {
            error = presentedOverrides;
        } else {
            if (!(presentedOverrides instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            error = new Result.Error(NonEmptyListKt.nonEmptyListOf((PaywallValidationError) ((Result.Error) presentedOverrides).getValue(), new PaywallValidationError[0]));
        }
        List pages = carouselComponent.getPages();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(pages, 10));
        Iterator it = pages.iterator();
        while (it.hasNext()) {
            arrayList.add(createStackComponentStyle(styleFactoryScope, (StackComponent) it.next()));
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            Result result = (Result) obj;
            if (result instanceof Result.Success) {
                if (arrayList3.isEmpty()) {
                    arrayList2.add((StackComponentStyle) ((Result.Success) result).getValue());
                }
            } else if (result instanceof Result.Error) {
                arrayList3.addAll((Collection) ((Result.Error) result).getValue());
            }
        }
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(arrayList3);
        Result error2 = nonEmptyListOrNull != null ? new Result.Error(nonEmptyListOrNull) : new Result.Success(arrayList2);
        Border border = carouselComponent.getBorder();
        Result resultOrSuccessfullyNull = ResultKt.orSuccessfullyNull(border != null ? BorderStyleKt.toBorderStyles(border, this.colorAliases) : null);
        Shadow shadow = carouselComponent.getShadow();
        Result resultOrSuccessfullyNull2 = ResultKt.orSuccessfullyNull(shadow != null ? ShadowStyleKt.toShadowStyles(shadow, this.colorAliases) : null);
        Result<BackgroundStyles, NonEmptyList<PaywallValidationError>> resultCreateBackgroundStyles = createBackgroundStyles(carouselComponent.getBackground(), carouselComponent.getBackgroundColor());
        CarouselComponent.PageControl pageControl = carouselComponent.getPageControl();
        Result resultOrSuccessfullyNull3 = ResultKt.orSuccessfullyNull(pageControl != null ? PageControlExtensionsKt.toPageControlStyles(pageControl, this.colorAliases) : null);
        NonEmptyList nonEmptyListOrNull2 = NonEmptyListKt.toNonEmptyListOrNull(ResultKt.collectErrors(CollectionsKt.listOf((Object[]) new Result[]{error, error2, resultOrSuccessfullyNull, resultOrSuccessfullyNull2, resultCreateBackgroundStyles, resultOrSuccessfullyNull3})));
        if (nonEmptyListOrNull2 != null) {
            return new Result.Error(nonEmptyListOrNull2);
        }
        Intrinsics.checkNotNull(error, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<A of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value = ((Result.Success) error).getValue();
        Object value2 = ((Result.Success) error2).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<C of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value3 = ((Result.Success) resultOrSuccessfullyNull).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull2, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<D of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value4 = ((Result.Success) resultOrSuccessfullyNull2).getValue();
        Intrinsics.checkNotNull(resultCreateBackgroundStyles, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<E of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value5 = ((Result.Success) resultCreateBackgroundStyles).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull3, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<F of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        CarouselComponentStyle.PageControlStyles pageControlStyles = (CarouselComponentStyle.PageControlStyles) ((Result.Success) resultOrSuccessfullyNull3).getValue();
        BackgroundStyles backgroundStyles = (BackgroundStyles) value5;
        ShadowStyles shadowStyles = (ShadowStyles) value4;
        BorderStyles borderStyles = (BorderStyles) value3;
        List list = (List) value2;
        List list2 = (List) value;
        List pages2 = carouselComponent.getPages();
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(pages2, 10));
        Iterator it2 = pages2.iterator();
        while (it2.hasNext()) {
            arrayList4.add(((StackComponent) it2.next()).getName());
        }
        Integer initialPageIndex = carouselComponent.getInitialPageIndex();
        int iIntValue = initialPageIndex != null ? initialPageIndex.intValue() : 0;
        Alignment.Vertical alignment = AlignmentKt.toAlignment(carouselComponent.getPageAlignment());
        Boolean visible = carouselComponent.getVisible();
        boolean zBooleanValue = visible != null ? visible.booleanValue() : true;
        Size size2 = carouselComponent.getSize();
        float fG = Dp.g(carouselComponent.getPagePeek() != null ? r2.intValue() : 0);
        Float pageSpacing = carouselComponent.getPageSpacing();
        float fG2 = Dp.g(pageSpacing != null ? pageSpacing.floatValue() : DEFAULT_SPACING);
        PaddingValues paddingValues = PaddingKt.toPaddingValues(carouselComponent.getPadding());
        PaddingValues paddingValues2 = PaddingKt.toPaddingValues(carouselComponent.getMargin());
        Shape shape = carouselComponent.getShape();
        if (shape == null) {
            shape = DEFAULT_SHAPE;
        }
        Shape shape2 = shape;
        Boolean loop = carouselComponent.getLoop();
        return new Result.Success(new CarouselComponentStyle(list, arrayList4, iIntValue, alignment, zBooleanValue, size2, fG, fG2, backgroundStyles, paddingValues, paddingValues2, shape2, borderStyles, shadowStyles, pageControlStyles, loop != null ? loop.booleanValue() : false, carouselComponent.getAutoAdvance(), styleFactoryScope.getRcPackage(), styleFactoryScope.getResolvedOffer(), styleFactoryScope.getTabControlIndex(), styleFactoryScope.getOfferEligibility(), list2, carouselComponent.getName(), null));
    }

    private final Result<CountdownComponentStyle, NonEmptyList<PaywallValidationError>> createCountdownComponentStyle(StyleFactoryScope styleFactoryScope, final CountdownComponent countdownComponent) {
        return (Result) styleFactoryScope.withCountdown(countdownComponent.getStyle().getDate(), countdownComponent.getCountFrom(), new Function1<StyleFactoryScope, Result<? extends CountdownComponentStyle, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createCountdownComponentStyle.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<CountdownComponentStyle, NonEmptyList<PaywallValidationError>> invoke(StyleFactoryScope withCountdown) {
                Intrinsics.checkNotNullParameter(withCountdown, "$this$withCountdown");
                Result resultCreateStackComponentStyle = StyleFactory.this.createStackComponentStyle(withCountdown, countdownComponent.getCountdownStack());
                StackComponent endStack = countdownComponent.getEndStack();
                Result resultOrSuccessfullyNull = ResultKt.orSuccessfullyNull(endStack != null ? StyleFactory.this.createStackComponentStyle(withCountdown, endStack) : null);
                StackComponent fallback = countdownComponent.getFallback();
                Result resultOrSuccessfullyNull2 = ResultKt.orSuccessfullyNull(fallback != null ? StyleFactory.this.createStackComponentStyle(withCountdown, fallback) : null);
                CountdownComponent countdownComponent2 = countdownComponent;
                Unit unit = Unit.f139807a;
                Result.Success success = new Result.Success(unit);
                Result.Success success2 = new Result.Success(unit);
                Result.Success success3 = new Result.Success(unit);
                NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(ResultKt.collectErrors(CollectionsKt.listOf((Object[]) new Result[]{resultCreateStackComponentStyle, resultOrSuccessfullyNull, resultOrSuccessfullyNull2, success, success2, success3})));
                if (nonEmptyListOrNull != null) {
                    return new Result.Error(nonEmptyListOrNull);
                }
                Intrinsics.checkNotNull(resultCreateStackComponentStyle, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<A of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
                Object value = ((Result.Success) resultCreateStackComponentStyle).getValue();
                Intrinsics.checkNotNull(resultOrSuccessfullyNull, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<B of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
                Object value2 = ((Result.Success) resultOrSuccessfullyNull).getValue();
                Intrinsics.checkNotNull(resultOrSuccessfullyNull2, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<C of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
                Object value3 = ((Result.Success) resultOrSuccessfullyNull2).getValue();
                Object value4 = success.getValue();
                Object value5 = success2.getValue();
                return new Result.Success(new CountdownComponentStyle(countdownComponent2.getStyle().getDate(), countdownComponent2.getCountFrom(), (StackComponentStyle) value, (StackComponentStyle) value2, (StackComponentStyle) value3));
            }
        });
    }

    private final Result<HeaderComponentStyle, NonEmptyList<PaywallValidationError>> createHeaderComponentStyle(StyleFactoryScope styleFactoryScope, final HeaderComponent headerComponent) {
        return (Result) styleFactoryScope.withSelectedScope(null, null, new Function1<StyleFactoryScope, Result<? extends HeaderComponentStyle, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createHeaderComponentStyle.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<HeaderComponentStyle, NonEmptyList<PaywallValidationError>> invoke(StyleFactoryScope withSelectedScope) {
                Intrinsics.checkNotNullParameter(withSelectedScope, "$this$withSelectedScope");
                Result<HeaderComponentStyle, NonEmptyList<PaywallValidationError>> resultCreateStackComponentStyle = StyleFactory.this.createStackComponentStyle(withSelectedScope, headerComponent.getStack());
                if (resultCreateStackComponentStyle instanceof Result.Success) {
                    return new Result.Success(new HeaderComponentStyle((StackComponentStyle) ((Result.Success) resultCreateStackComponentStyle).getValue()));
                }
                if (resultCreateStackComponentStyle instanceof Result.Error) {
                    return resultCreateStackComponentStyle;
                }
                throw new NoWhenBranchMatchedException();
            }
        });
    }

    private final Result<IconComponentStyle, NonEmptyList<PaywallValidationError>> createIconComponentStyle(StyleFactoryScope styleFactoryScope, IconComponent iconComponent) {
        Result presentedOverrides = PresentedPartialKt.toPresentedOverrides(iconComponent.getOverrides(), this.stripRules, new Function1<PartialIconComponent, Result<? extends PresentedIconPartial, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createIconComponentStyle.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<PresentedIconPartial, NonEmptyList<PaywallValidationError>> invoke(PartialIconComponent partial) {
                Intrinsics.checkNotNullParameter(partial, "partial");
                return PresentedIconPartial.Companion.invoke(partial, StyleFactory.this.colorAliases);
            }
        });
        if (!(presentedOverrides instanceof Result.Success)) {
            if (!(presentedOverrides instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            presentedOverrides = new Result.Error(NonEmptyListKt.nonEmptyListOf((PaywallValidationError) ((Result.Error) presentedOverrides).getValue(), new PaywallValidationError[0]));
        }
        ColorScheme color = iconComponent.getColor();
        Result resultOrSuccessfullyNull = ResultKt.orSuccessfullyNull(color != null ? ColorStyleKt.toColorStyles(color, this.colorAliases) : null);
        IconComponent.IconBackground iconBackground = iconComponent.getIconBackground();
        Result resultOrSuccessfullyNull2 = ResultKt.orSuccessfullyNull(iconBackground != null ? IconComponentStyleKt.toBackground(iconBackground, this.colorAliases) : null);
        Unit unit = Unit.f139807a;
        Result.Success success = new Result.Success(unit);
        Result.Success success2 = new Result.Success(unit);
        Result.Success success3 = new Result.Success(unit);
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(ResultKt.collectErrors(CollectionsKt.listOf((Object[]) new Result[]{presentedOverrides, resultOrSuccessfullyNull, resultOrSuccessfullyNull2, success, success2, success3})));
        if (nonEmptyListOrNull != null) {
            return new Result.Error(nonEmptyListOrNull);
        }
        Intrinsics.checkNotNull(presentedOverrides, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<A of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value = ((Result.Success) presentedOverrides).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<B of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value2 = ((Result.Success) resultOrSuccessfullyNull).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull2, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<C of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value3 = ((Result.Success) resultOrSuccessfullyNull2).getValue();
        Object value4 = success.getValue();
        Object value5 = success2.getValue();
        IconComponentStyle.Background background = (IconComponentStyle.Background) value3;
        ColorStyles colorStyles = (ColorStyles) value2;
        List list = (List) value;
        String baseUrl = iconComponent.getBaseUrl();
        String iconName = iconComponent.getIconName();
        IconComponent.Formats formats = iconComponent.getFormats();
        Boolean visible = iconComponent.getVisible();
        return new Result.Success(new IconComponentStyle(baseUrl, iconName, formats, visible != null ? visible.booleanValue() : true, iconComponent.getSize(), colorStyles, PaddingKt.toPaddingValues(iconComponent.getPadding()), PaddingKt.toPaddingValues(iconComponent.getMargin()), background, styleFactoryScope.getRcPackage(), styleFactoryScope.getResolvedOffer(), styleFactoryScope.getTabControlIndex(), styleFactoryScope.getOfferEligibility(), list));
    }

    private final Result<ImageComponentStyle, NonEmptyList<PaywallValidationError>> createImageComponentStyle(StyleFactoryScope styleFactoryScope, ImageComponent imageComponent) {
        Result<NonEmptyMap<LocaleId, ThemeImageUrls>, NonEmptyList<PaywallValidationError.MissingImageLocalization>> resultM840withLocalizedOverridesTDPsjl0 = m840withLocalizedOverridesTDPsjl0(imageComponent.getSource(), imageComponent.m591getOverrideSourceLidsa7TU9Q());
        Result presentedOverrides = PresentedPartialKt.toPresentedOverrides(imageComponent.getOverrides(), this.stripRules, new Function1<PartialImageComponent, Result<? extends PresentedImagePartial, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createImageComponentStyle.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<PresentedImagePartial, NonEmptyList<PaywallValidationError>> invoke(PartialImageComponent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                ThemeImageUrls source = it.getSource();
                Result<PresentedImagePartial, NonEmptyList<PaywallValidationError>> resultOrSuccessfullyNull = ResultKt.orSuccessfullyNull(source != null ? StyleFactory.this.m840withLocalizedOverridesTDPsjl0(source, it.m593getOverrideSourceLidsa7TU9Q()) : null);
                StyleFactory styleFactory = StyleFactory.this;
                if (resultOrSuccessfullyNull instanceof Result.Success) {
                    return PresentedImagePartial.Companion.invoke(it, (NonEmptyMap) ((Result.Success) resultOrSuccessfullyNull).getValue(), styleFactory.colorAliases);
                }
                if (resultOrSuccessfullyNull instanceof Result.Error) {
                    return resultOrSuccessfullyNull;
                }
                throw new NoWhenBranchMatchedException();
            }
        });
        if (!(presentedOverrides instanceof Result.Success)) {
            if (!(presentedOverrides instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            presentedOverrides = new Result.Error(NonEmptyListKt.nonEmptyListOf((PaywallValidationError) ((Result.Error) presentedOverrides).getValue(), new PaywallValidationError[0]));
        }
        ColorScheme colorOverlay = imageComponent.getColorOverlay();
        Result resultOrSuccessfullyNull = ResultKt.orSuccessfullyNull(colorOverlay != null ? ColorStyleKt.toColorStyles(colorOverlay, this.colorAliases) : null);
        Border border = imageComponent.getBorder();
        Result resultOrSuccessfullyNull2 = ResultKt.orSuccessfullyNull(border != null ? BorderStyleKt.toBorderStyles(border, this.colorAliases) : null);
        Shadow shadow = imageComponent.getShadow();
        Result resultOrSuccessfullyNull3 = ResultKt.orSuccessfullyNull(shadow != null ? ShadowStyleKt.toShadowStyles(shadow, this.colorAliases) : null);
        Result.Success success = new Result.Success(Unit.f139807a);
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(ResultKt.collectErrors(CollectionsKt.listOf((Object[]) new Result[]{resultM840withLocalizedOverridesTDPsjl0, presentedOverrides, resultOrSuccessfullyNull, resultOrSuccessfullyNull2, resultOrSuccessfullyNull3, success})));
        if (nonEmptyListOrNull != null) {
            return new Result.Error(nonEmptyListOrNull);
        }
        Intrinsics.checkNotNull(resultM840withLocalizedOverridesTDPsjl0, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<A of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value = ((Result.Success) resultM840withLocalizedOverridesTDPsjl0).getValue();
        Intrinsics.checkNotNull(presentedOverrides, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<B of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value2 = ((Result.Success) presentedOverrides).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<C of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value3 = ((Result.Success) resultOrSuccessfullyNull).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull2, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<D of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value4 = ((Result.Success) resultOrSuccessfullyNull2).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull3, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<E of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value5 = ((Result.Success) resultOrSuccessfullyNull3).getValue();
        ShadowStyles shadowStyles = (ShadowStyles) value5;
        BorderStyles borderStyles = (BorderStyles) value4;
        ColorStyles colorStyles = (ColorStyles) value3;
        List list = (List) value2;
        NonEmptyMap nonEmptyMap = (NonEmptyMap) value;
        Boolean visible = imageComponent.getVisible();
        boolean zBooleanValue = visible != null ? visible.booleanValue() : true;
        Size size = imageComponent.getSize();
        PaddingValues paddingValues = PaddingKt.toPaddingValues(imageComponent.getPadding());
        PaddingValues paddingValues2 = PaddingKt.toPaddingValues(imageComponent.getMargin());
        MaskShape maskShape = imageComponent.getMaskShape();
        return new Result.Success(new ImageComponentStyle(nonEmptyMap, zBooleanValue, size, paddingValues, paddingValues2, maskShape != null ? ShapeKt.toShape(maskShape) : null, borderStyles, shadowStyles, colorStyles, FitModeKt.toContentScale(imageComponent.getFitMode()), styleFactoryScope.getRcPackage(), styleFactoryScope.getResolvedOffer(), styleFactoryScope.getTabControlIndex(), styleFactoryScope.getOfferEligibility(), list, styleFactoryScope.getIgnoreTopWindowInsets()));
    }

    private final Result<ComponentStyle, NonEmptyList<PaywallValidationError>> createInternal(StyleFactoryScope styleFactoryScope, PaywallComponent paywallComponent) {
        styleFactoryScope.recordComponent(paywallComponent);
        if (paywallComponent instanceof ButtonComponent) {
            return createButtonComponentStyleOrNull(styleFactoryScope, (ButtonComponent) paywallComponent);
        }
        if (paywallComponent instanceof ImageComponent) {
            return createImageComponentStyle(styleFactoryScope, (ImageComponent) paywallComponent);
        }
        if (paywallComponent instanceof PackageComponent) {
            return createPackageComponentStyle(styleFactoryScope, (PackageComponent) paywallComponent);
        }
        if (paywallComponent instanceof PurchaseButtonComponent) {
            return createPurchaseButtonComponentStyle(styleFactoryScope, (PurchaseButtonComponent) paywallComponent);
        }
        if (paywallComponent instanceof StackComponent) {
            return createStackComponentStyle(styleFactoryScope, (StackComponent) paywallComponent);
        }
        if (paywallComponent instanceof HeaderComponent) {
            return createHeaderComponentStyle(styleFactoryScope, (HeaderComponent) paywallComponent);
        }
        if (paywallComponent instanceof StickyFooterComponent) {
            return createStickyFooterComponentStyle(styleFactoryScope, (StickyFooterComponent) paywallComponent);
        }
        if (paywallComponent instanceof TextComponent) {
            return createTextComponentStyle(styleFactoryScope, (TextComponent) paywallComponent);
        }
        if (paywallComponent instanceof IconComponent) {
            return createIconComponentStyle(styleFactoryScope, (IconComponent) paywallComponent);
        }
        if (paywallComponent instanceof TimelineComponent) {
            return createTimelineComponentStyle(styleFactoryScope, (TimelineComponent) paywallComponent);
        }
        if (paywallComponent instanceof CarouselComponent) {
            return createCarouselComponentStyle(styleFactoryScope, (CarouselComponent) paywallComponent);
        }
        if (paywallComponent instanceof TabControlButtonComponent) {
            return createTabControlButtonComponentStyle(styleFactoryScope, (TabControlButtonComponent) paywallComponent);
        }
        if (paywallComponent instanceof TabControlToggleComponent) {
            return createTabControlToggleComponentStyle(styleFactoryScope, (TabControlToggleComponent) paywallComponent);
        }
        if (paywallComponent instanceof TabControlComponent) {
            return ResultKt.errorIfNull(styleFactoryScope.getTabControl(), NonEmptyListKt.nonEmptyListOf(PaywallValidationError.TabControlNotInTab.INSTANCE, new PaywallValidationError.TabControlNotInTab[0]));
        }
        if (paywallComponent instanceof TabsComponent) {
            return createTabsComponentStyle(styleFactoryScope, (TabsComponent) paywallComponent);
        }
        if (paywallComponent instanceof VideoComponent) {
            return createVideoComponentStyle(styleFactoryScope, (VideoComponent) paywallComponent);
        }
        if (paywallComponent instanceof FallbackHeaderComponent) {
            return new Result.Success(null);
        }
        if (paywallComponent instanceof CountdownComponent) {
            return createCountdownComponentStyle(styleFactoryScope, (CountdownComponent) paywallComponent);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Result<PackageComponentStyle, NonEmptyList<PaywallValidationError>> createPackageComponentStyle(StyleFactoryScope styleFactoryScope, final PackageComponent packageComponent) {
        final Package r02 = (Package) new Result.Success(getPackageOrNull(this.offering, packageComponent.getPackageId())).getValue();
        if (r02 != null) {
            final ResolvedOffer resolvedOfferResolve = PromoOfferResolver.INSTANCE.resolve(r02, packageComponent.getPlayStoreOffer());
            return (Result) styleFactoryScope.withSelectedScope(new PaywallState.Loaded.Components.AvailablePackages.Info(r02, packageComponent.isSelectedByDefault(), resolvedOfferResolve), null, new Function1<StyleFactoryScope, Result<? extends PackageComponentStyle, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory$createPackageComponentStyle$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Result<PackageComponentStyle, NonEmptyList<PaywallValidationError>> invoke(StyleFactory.StyleFactoryScope withSelectedScope) {
                    Intrinsics.checkNotNullParameter(withSelectedScope, "$this$withSelectedScope");
                    OfferEligibility offerEligibility = withSelectedScope.getOfferEligibility();
                    Result presentedOverrides = PresentedPartialKt.toPresentedOverrides(packageComponent.getOverrides(), this.stripRules, new Function1<PartialPackageComponent, Result<? extends PresentedPackagePartial, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory$createPackageComponentStyle$1$1$presentedOverridesResult$1
                        @Override // kotlin.jvm.functions.Function1
                        public final Result<PresentedPackagePartial, NonEmptyList<PaywallValidationError>> invoke(PartialPackageComponent partial) {
                            Intrinsics.checkNotNullParameter(partial, "partial");
                            return PresentedPackagePartial.Companion.invoke(partial);
                        }
                    });
                    if (!(presentedOverrides instanceof Result.Success)) {
                        if (!(presentedOverrides instanceof Result.Error)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        presentedOverrides = new Result.Error(NonEmptyListKt.nonEmptyListOf((PaywallValidationError) ((Result.Error) presentedOverrides).getValue(), new PaywallValidationError[0]));
                    }
                    AnonymousClass1 anonymousClass1 = new Function1<PaywallComponent, Boolean>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory$createPackageComponentStyle$1$1.1
                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(PaywallComponent it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            return Boolean.valueOf(it instanceof PurchaseButtonComponent);
                        }
                    };
                    StyleFactory styleFactory = this;
                    PackageComponent packageComponent2 = packageComponent;
                    Integer num = (Integer) CollectionsKt.maxOrNull((Iterable) withSelectedScope.countPredicates.keySet());
                    int iIntValue = (num != null ? num.intValue() : -1) + 1;
                    withSelectedScope.countPredicates.put(Integer.valueOf(iIntValue), anonymousClass1);
                    withSelectedScope.countValues.put(Integer.valueOf(iIntValue), 0);
                    StyleFactory.StyleFactoryScope.WithCount withCount = new StyleFactory.StyleFactoryScope.WithCount(styleFactory.createStackComponentStyle(withSelectedScope, packageComponent2.getStack()), ((Number) MapsKt.getValue(withSelectedScope.countValues, Integer.valueOf(iIntValue))).intValue());
                    withSelectedScope.countPredicates.remove(Integer.valueOf(iIntValue));
                    withSelectedScope.countValues.remove(Integer.valueOf(iIntValue));
                    Result result = (Result) withCount.component1();
                    int iComponent2 = withCount.component2();
                    PackageComponent packageComponent3 = packageComponent;
                    Package r2 = r02;
                    ResolvedOffer resolvedOffer = resolvedOfferResolve;
                    Unit unit = Unit.f139807a;
                    Result.Success success = new Result.Success(unit);
                    Result.Success success2 = new Result.Success(unit);
                    Result.Success success3 = new Result.Success(unit);
                    Result.Success success4 = new Result.Success(unit);
                    NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(ResultKt.collectErrors(CollectionsKt.listOf((Object[]) new Result[]{presentedOverrides, result, success, success2, success3, success4})));
                    if (nonEmptyListOrNull != null) {
                        return new Result.Error(nonEmptyListOrNull);
                    }
                    Intrinsics.checkNotNull(presentedOverrides, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<A of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
                    Object value = ((Result.Success) presentedOverrides).getValue();
                    Intrinsics.checkNotNull(result, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<B of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
                    Object value2 = ((Result.Success) result).getValue();
                    Object value3 = success.getValue();
                    Object value4 = success2.getValue();
                    Object value5 = success3.getValue();
                    StackComponentStyle stackComponentStyle = (StackComponentStyle) value2;
                    List list = (List) value;
                    boolean zIsSelectedByDefault = packageComponent3.isSelectedByDefault();
                    boolean z2 = false;
                    String name = packageComponent3.getName();
                    if (iComponent2 == 0) {
                        z2 = true;
                    }
                    Boolean visible = packageComponent3.getVisible();
                    return new Result.Success(new PackageComponentStyle(r2, zIsSelectedByDefault, name, stackComponentStyle, z2, resolvedOffer, visible != null ? visible.booleanValue() : true, list, offerEligibility));
                }
            });
        }
        String identifier = this.offering.getIdentifier();
        String packageId = packageComponent.getPackageId();
        List<Package> availablePackages = this.offering.getAvailablePackages();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(availablePackages, 10));
        Iterator<T> it = availablePackages.iterator();
        while (it.hasNext()) {
            arrayList.add(((Package) it.next()).getIdentifier());
        }
        Logger.INSTANCE.w(new PaywallValidationError.MissingPackage(identifier, packageId, arrayList).getMessage());
        return new Result.Success(null);
    }

    private final Result<ButtonComponentStyle, NonEmptyList<PaywallValidationError>> createPurchaseButtonComponentStyle(StyleFactoryScope styleFactoryScope, PurchaseButtonComponent purchaseButtonComponent) {
        Result<StackComponentStyle, NonEmptyList<PaywallValidationError>> resultCreateStackComponentStyle = createStackComponentStyle(styleFactoryScope, purchaseButtonComponent.getStack());
        PurchaseButtonComponent.Method method = purchaseButtonComponent.getMethod();
        if (method == null) {
            PurchaseButtonComponent.Action action = purchaseButtonComponent.getAction();
            method = action != null ? action.toMethod() : null;
        }
        Result<ButtonComponentStyle.Action, NonEmptyList<PaywallValidationError>> resultConvertPurchaseButtonMethod = convertPurchaseButtonMethod(styleFactoryScope, method);
        Unit unit = Unit.f139807a;
        Result.Success success = new Result.Success(unit);
        Result.Success success2 = new Result.Success(unit);
        Result.Success success3 = new Result.Success(unit);
        Result.Success success4 = new Result.Success(unit);
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(ResultKt.collectErrors(CollectionsKt.listOf((Object[]) new Result[]{resultCreateStackComponentStyle, resultConvertPurchaseButtonMethod, success, success2, success3, success4})));
        if (nonEmptyListOrNull != null) {
            return new Result.Error(nonEmptyListOrNull);
        }
        Intrinsics.checkNotNull(resultCreateStackComponentStyle, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<A of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value = ((Result.Success) resultCreateStackComponentStyle).getValue();
        Intrinsics.checkNotNull(resultConvertPurchaseButtonMethod, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<B of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value2 = ((Result.Success) resultConvertPurchaseButtonMethod).getValue();
        Object value3 = success.getValue();
        Object value4 = success2.getValue();
        Object value5 = success3.getValue();
        return new Result.Success(new ButtonComponentStyle((StackComponentStyle) value, (ButtonComponentStyle.Action) value2, null, purchaseButtonComponent.getName(), null, 20, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Result<StackComponentStyle, NonEmptyList<PaywallValidationError>> createStackComponentStyle(final StyleFactoryScope styleFactoryScope, StackComponent stackComponent) {
        Result error;
        Result success;
        Result presentedOverrides = PresentedPartialKt.toPresentedOverrides(stackComponent.getOverrides(), this.stripRules, new Function1<PartialStackComponent, Result<? extends PresentedStackPartial, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createStackComponentStyle.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<PresentedStackPartial, NonEmptyList<PaywallValidationError>> invoke(PartialStackComponent partial) {
                Intrinsics.checkNotNullParameter(partial, "partial");
                PresentedStackPartial.Companion companion = PresentedStackPartial.Companion;
                Map map = StyleFactory.this.colorAliases;
                final StyleFactory styleFactory = StyleFactory.this;
                final StyleFactoryScope styleFactoryScope2 = styleFactoryScope;
                return companion.invoke(partial, map, new Function1<StackComponent, Result<? extends StackComponentStyle, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createStackComponentStyle.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Result<StackComponentStyle, NonEmptyList<PaywallValidationError>> invoke(StackComponent stackComponent2) {
                        Intrinsics.checkNotNullParameter(stackComponent2, "stackComponent");
                        return styleFactory.createStackComponentStyle(styleFactoryScope2, stackComponent2);
                    }
                });
            }
        });
        int i3 = 0;
        if (presentedOverrides instanceof Result.Success) {
            error = presentedOverrides;
        } else {
            if (!(presentedOverrides instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            error = new Result.Error(NonEmptyListKt.nonEmptyListOf((PaywallValidationError) ((Result.Error) presentedOverrides).getValue(), new PaywallValidationError[0]));
        }
        List components = stackComponent.getComponents();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(components, 10));
        Iterator it = components.iterator();
        while (it.hasNext()) {
            arrayList.add(createInternal(styleFactoryScope, (PaywallComponent) it.next()));
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            Result result = (Result) obj;
            if (result instanceof Result.Success) {
                if (arrayList3.isEmpty()) {
                    arrayList2.add((ComponentStyle) ((Result.Success) result).getValue());
                }
            } else if (result instanceof Result.Error) {
                arrayList3.addAll((Collection) ((Result.Error) result).getValue());
            }
        }
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(arrayList3);
        Result error2 = nonEmptyListOrNull != null ? new Result.Error(nonEmptyListOrNull) : new Result.Success(arrayList2);
        if (error2 instanceof Result.Success) {
            success = new Result.Success(CollectionsKt.filterNotNull((List) ((Result.Success) error2).getValue()));
        } else {
            if (!(error2 instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            success = error2;
        }
        Badge badge = stackComponent.getBadge();
        Result resultOrSuccessfullyNull = ResultKt.orSuccessfullyNull(badge != null ? BadgeStyleKt.toBadgeStyle(badge, new Function1<StackComponent, Result<? extends StackComponentStyle, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createStackComponentStyle.6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<StackComponentStyle, NonEmptyList<PaywallValidationError>> invoke(StackComponent stackComponent2) {
                Intrinsics.checkNotNullParameter(stackComponent2, "stackComponent");
                return StyleFactory.this.createStackComponentStyle(styleFactoryScope, stackComponent2);
            }
        }) : null);
        Result<BackgroundStyles, NonEmptyList<PaywallValidationError>> resultCreateBackgroundStyles = createBackgroundStyles(stackComponent.getBackground(), stackComponent.getBackgroundColor());
        Border border = stackComponent.getBorder();
        Result resultOrSuccessfullyNull2 = ResultKt.orSuccessfullyNull(border != null ? BorderStyleKt.toBorderStyles(border, this.colorAliases) : null);
        Shadow shadow = stackComponent.getShadow();
        Result resultOrSuccessfullyNull3 = ResultKt.orSuccessfullyNull(shadow != null ? ShadowStyleKt.toShadowStyles(shadow, this.colorAliases) : null);
        NonEmptyList nonEmptyListOrNull2 = NonEmptyListKt.toNonEmptyListOrNull(ResultKt.collectErrors(CollectionsKt.listOf((Object[]) new Result[]{error, success, resultOrSuccessfullyNull, resultCreateBackgroundStyles, resultOrSuccessfullyNull2, resultOrSuccessfullyNull3})));
        if (nonEmptyListOrNull2 != null) {
            return new Result.Error(nonEmptyListOrNull2);
        }
        Intrinsics.checkNotNull(error, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<A of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value = ((Result.Success) error).getValue();
        Object value2 = ((Result.Success) success).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<C of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value3 = ((Result.Success) resultOrSuccessfullyNull).getValue();
        Intrinsics.checkNotNull(resultCreateBackgroundStyles, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<D of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value4 = ((Result.Success) resultCreateBackgroundStyles).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull2, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<E of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value5 = ((Result.Success) resultOrSuccessfullyNull2).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull3, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<F of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        ShadowStyles shadowStyles = (ShadowStyles) ((Result.Success) resultOrSuccessfullyNull3).getValue();
        BorderStyles borderStyles = (BorderStyles) value5;
        BackgroundStyles backgroundStyles = (BackgroundStyles) value4;
        BadgeStyle badgeStyle = (BadgeStyle) value3;
        List list = (List) value2;
        List list2 = (List) value;
        Dimension dimension = stackComponent.getDimension();
        Boolean visible = stackComponent.getVisible();
        boolean zBooleanValue = visible != null ? visible.booleanValue() : true;
        Size size2 = stackComponent.getSize();
        Float spacing = stackComponent.getSpacing();
        float fG = Dp.g(spacing != null ? spacing.floatValue() : DEFAULT_SPACING);
        PaddingValues paddingValues = PaddingKt.toPaddingValues(stackComponent.getPadding());
        PaddingValues paddingValues2 = PaddingKt.toPaddingValues(stackComponent.getMargin());
        Shape shape = stackComponent.getShape();
        if (shape == null) {
            shape = DEFAULT_SHAPE;
        }
        Shape shape2 = shape;
        StackComponent.Overflow overflow = stackComponent.getOverflow();
        return new Result.Success(new StackComponentStyle(list, dimension, zBooleanValue, size2, fG, backgroundStyles, paddingValues, paddingValues2, shape2, borderStyles, shadowStyles, badgeStyle, overflow != null ? OverflowExtensionsKt.toOrientation(overflow, stackComponent.getDimension()) : null, styleFactoryScope.getRcPackage(), styleFactoryScope.getResolvedOffer(), styleFactoryScope.getTabControlIndex(), styleFactoryScope.getOfferEligibility(), styleFactoryScope.getCountdownDate(), styleFactoryScope.getCountFrom(), list2, styleFactoryScope.getApplyTopWindowInsets(), false, false, false, 14680064, null));
    }

    private final Result<StickyFooterComponentStyle, NonEmptyList<PaywallValidationError>> createStickyFooterComponentStyle(StyleFactoryScope styleFactoryScope, final StickyFooterComponent stickyFooterComponent) {
        return (Result) styleFactoryScope.withSelectedScope(null, null, new Function1<StyleFactoryScope, Result<? extends StickyFooterComponentStyle, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createStickyFooterComponentStyle.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<StickyFooterComponentStyle, NonEmptyList<PaywallValidationError>> invoke(StyleFactoryScope withSelectedScope) {
                Intrinsics.checkNotNullParameter(withSelectedScope, "$this$withSelectedScope");
                Result<StickyFooterComponentStyle, NonEmptyList<PaywallValidationError>> resultCreateStackComponentStyle = StyleFactory.this.createStackComponentStyle(withSelectedScope, stickyFooterComponent.getStack());
                if (resultCreateStackComponentStyle instanceof Result.Success) {
                    return new Result.Success(new StickyFooterComponentStyle((StackComponentStyle) ((Result.Success) resultCreateStackComponentStyle).getValue()));
                }
                if (resultCreateStackComponentStyle instanceof Result.Error) {
                    return resultCreateStackComponentStyle;
                }
                throw new NoWhenBranchMatchedException();
            }
        });
    }

    private final Result<TabControlButtonComponentStyle, NonEmptyList<PaywallValidationError>> createTabControlButtonComponentStyle(StyleFactoryScope styleFactoryScope, final TabControlButtonComponent tabControlButtonComponent) {
        return (Result) styleFactoryScope.withSelectedScope(null, Integer.valueOf(tabControlButtonComponent.getTabIndex()), new Function1<StyleFactoryScope, Result<? extends TabControlButtonComponentStyle, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createTabControlButtonComponentStyle.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<TabControlButtonComponentStyle, NonEmptyList<PaywallValidationError>> invoke(StyleFactoryScope withSelectedScope) {
                Intrinsics.checkNotNullParameter(withSelectedScope, "$this$withSelectedScope");
                withSelectedScope.setDefaultTabIndex(0);
                Result<TabControlButtonComponentStyle, NonEmptyList<PaywallValidationError>> resultCreateStackComponentStyle = StyleFactory.this.createStackComponentStyle(withSelectedScope, tabControlButtonComponent.getStack());
                TabControlButtonComponent tabControlButtonComponent2 = tabControlButtonComponent;
                if (resultCreateStackComponentStyle instanceof Result.Success) {
                    return new Result.Success(new TabControlButtonComponentStyle(tabControlButtonComponent2.getTabIndex(), tabControlButtonComponent2.getTabId(), (StackComponentStyle) ((Result.Success) resultCreateStackComponentStyle).getValue(), withSelectedScope.getEnclosingTabsComponentName(), tabControlButtonComponent2.getName(), withSelectedScope.getEnclosingTabsOrderedTabIds(), withSelectedScope.getEnclosingTabContextNamesById(), withSelectedScope.getEnclosingTabsDefaultTabIndexForInteraction()));
                }
                if (resultCreateStackComponentStyle instanceof Result.Error) {
                    return resultCreateStackComponentStyle;
                }
                throw new NoWhenBranchMatchedException();
            }
        });
    }

    private final Result<TabControlToggleComponentStyle, NonEmptyList<PaywallValidationError>> createTabControlToggleComponentStyle(StyleFactoryScope styleFactoryScope, TabControlToggleComponent tabControlToggleComponent) {
        Result colorStyles = ColorStyleKt.toColorStyles(tabControlToggleComponent.getThumbColorOn(), this.colorAliases);
        Result colorStyles2 = ColorStyleKt.toColorStyles(tabControlToggleComponent.getThumbColorOff(), this.colorAliases);
        Result colorStyles3 = ColorStyleKt.toColorStyles(tabControlToggleComponent.getTrackColorOn(), this.colorAliases);
        Result colorStyles4 = ColorStyleKt.toColorStyles(tabControlToggleComponent.getTrackColorOff(), this.colorAliases);
        Unit unit = Unit.f139807a;
        Result.Success success = new Result.Success(unit);
        Result.Success success2 = new Result.Success(unit);
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(ResultKt.collectErrors(CollectionsKt.listOf((Object[]) new Result[]{colorStyles, colorStyles2, colorStyles3, colorStyles4, success, success2})));
        if (nonEmptyListOrNull != null) {
            return new Result.Error(nonEmptyListOrNull);
        }
        Intrinsics.checkNotNull(colorStyles, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<A of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value = ((Result.Success) colorStyles).getValue();
        Intrinsics.checkNotNull(colorStyles2, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<B of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value2 = ((Result.Success) colorStyles2).getValue();
        Intrinsics.checkNotNull(colorStyles3, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<C of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value3 = ((Result.Success) colorStyles3).getValue();
        Intrinsics.checkNotNull(colorStyles4, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<D of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value4 = ((Result.Success) colorStyles4).getValue();
        Object value5 = success.getValue();
        ColorStyles colorStyles5 = (ColorStyles) value4;
        ColorStyles colorStyles6 = (ColorStyles) value3;
        ColorStyles colorStyles7 = (ColorStyles) value2;
        ColorStyles colorStyles8 = (ColorStyles) value;
        styleFactoryScope.setDefaultTabIndex(tabControlToggleComponent.getDefaultValue() ? 1 : 0);
        String enclosingTabsComponentName = styleFactoryScope.getEnclosingTabsComponentName();
        if (enclosingTabsComponentName == null) {
            enclosingTabsComponentName = tabControlToggleComponent.getName();
        }
        return new Result.Success(new TabControlToggleComponentStyle(colorStyles8, colorStyles7, colorStyles6, colorStyles5, enclosingTabsComponentName));
    }

    private final Result<TabsComponentStyle, NonEmptyList<PaywallValidationError>> createTabsComponentStyle(StyleFactoryScope styleFactoryScope, final TabsComponent tabsComponent) {
        return (Result) styleFactoryScope.withTabsInteractionContext(tabsComponent.getName(), tabsComponent.getTabs(), tabsComponent.getDefaultTabId(), new Function1<StyleFactoryScope, Result<? extends TabsComponentStyle, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createTabsComponentStyle.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<TabsComponentStyle, NonEmptyList<PaywallValidationError>> invoke(StyleFactoryScope withTabsInteractionContext) {
                Intrinsics.checkNotNullParameter(withTabsInteractionContext, "$this$withTabsInteractionContext");
                Result<TabsComponentStyle, NonEmptyList<PaywallValidationError>> resultCreateTabsComponentStyleTabControl = StyleFactory.this.createTabsComponentStyleTabControl(withTabsInteractionContext, tabsComponent.getControl());
                TabsComponent tabsComponent2 = tabsComponent;
                final StyleFactory styleFactory = StyleFactory.this;
                if (!(resultCreateTabsComponentStyleTabControl instanceof Result.Success)) {
                    if (resultCreateTabsComponentStyleTabControl instanceof Result.Error) {
                        return resultCreateTabsComponentStyleTabControl;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                TabControlStyle tabControlStyle = (TabControlStyle) ((Result.Success) resultCreateTabsComponentStyleTabControl).getValue();
                String defaultTabId = tabsComponent2.getDefaultTabId();
                if (defaultTabId != null) {
                    if (StringsKt.p0(defaultTabId)) {
                        defaultTabId = null;
                    }
                    if (defaultTabId != null) {
                        Iterator it = tabsComponent2.getTabs().iterator();
                        int i3 = 0;
                        while (true) {
                            if (!it.hasNext()) {
                                i3 = -1;
                                break;
                            }
                            if (Intrinsics.areEqual(((TabsComponent.Tab) it.next()).getId(), defaultTabId)) {
                                break;
                            }
                            i3++;
                        }
                        Integer numValueOf = Integer.valueOf(i3);
                        if (numValueOf.intValue() == -1) {
                            numValueOf = null;
                        }
                        if (numValueOf != null) {
                            withTabsInteractionContext.setDefaultTabIndex(Integer.valueOf(numValueOf.intValue()));
                        }
                    }
                }
                Result presentedOverrides = PresentedPartialKt.toPresentedOverrides(tabsComponent2.getOverrides(), styleFactory.stripRules, new Function1<PartialTabsComponent, Result<? extends PresentedTabsPartial, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory$createTabsComponentStyle$1$1$5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Result<PresentedTabsPartial, NonEmptyList<PaywallValidationError>> invoke(PartialTabsComponent partial) {
                        Intrinsics.checkNotNullParameter(partial, "partial");
                        return PresentedTabsPartial.Companion.invoke(partial, styleFactory.colorAliases);
                    }
                });
                if (!(presentedOverrides instanceof Result.Success)) {
                    if (!(presentedOverrides instanceof Result.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    presentedOverrides = new Result.Error(NonEmptyListKt.nonEmptyListOf((PaywallValidationError) ((Result.Error) presentedOverrides).getValue(), new PaywallValidationError[0]));
                }
                Result resultCreateTabsComponentStyleTabs = styleFactory.createTabsComponentStyleTabs(withTabsInteractionContext, tabsComponent2.getTabs(), tabControlStyle);
                Result resultCreateBackgroundStyles = styleFactory.createBackgroundStyles(tabsComponent2.getBackground(), tabsComponent2.getBackgroundColor());
                Border border = tabsComponent2.getBorder();
                Result resultOrSuccessfullyNull = ResultKt.orSuccessfullyNull(border != null ? BorderStyleKt.toBorderStyles(border, styleFactory.colorAliases) : null);
                Shadow shadow = tabsComponent2.getShadow();
                Result resultOrSuccessfullyNull2 = ResultKt.orSuccessfullyNull(shadow != null ? ShadowStyleKt.toShadowStyles(shadow, styleFactory.colorAliases) : null);
                Result.Success success = new Result.Success(Unit.f139807a);
                NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(ResultKt.collectErrors(CollectionsKt.listOf((Object[]) new Result[]{presentedOverrides, resultCreateTabsComponentStyleTabs, resultCreateBackgroundStyles, resultOrSuccessfullyNull, resultOrSuccessfullyNull2, success})));
                if (nonEmptyListOrNull != null) {
                    return new Result.Error(nonEmptyListOrNull);
                }
                Intrinsics.checkNotNull(presentedOverrides, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<A of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
                Object value = ((Result.Success) presentedOverrides).getValue();
                Intrinsics.checkNotNull(resultCreateTabsComponentStyleTabs, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<B of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
                Object value2 = ((Result.Success) resultCreateTabsComponentStyleTabs).getValue();
                Intrinsics.checkNotNull(resultCreateBackgroundStyles, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<C of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
                Object value3 = ((Result.Success) resultCreateBackgroundStyles).getValue();
                Intrinsics.checkNotNull(resultOrSuccessfullyNull, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<D of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
                Object value4 = ((Result.Success) resultOrSuccessfullyNull).getValue();
                Intrinsics.checkNotNull(resultOrSuccessfullyNull2, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<E of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
                Object value5 = ((Result.Success) resultOrSuccessfullyNull2).getValue();
                ShadowStyles shadowStyles = (ShadowStyles) value5;
                BorderStyles borderStyles = (BorderStyles) value4;
                BackgroundStyles backgroundStyles = (BackgroundStyles) value3;
                NonEmptyList nonEmptyList = (NonEmptyList) value2;
                List list = (List) value;
                boolean zBooleanValue = true;
                Boolean visible = tabsComponent2.getVisible();
                if (visible != null) {
                    zBooleanValue = visible.booleanValue();
                }
                boolean z2 = zBooleanValue;
                Size size = tabsComponent2.getSize();
                PaddingValues paddingValues = PaddingKt.toPaddingValues(tabsComponent2.getPadding());
                PaddingValues paddingValues2 = PaddingKt.toPaddingValues(tabsComponent2.getMargin());
                Shape shape = tabsComponent2.getShape();
                if (shape == null) {
                    shape = StyleFactory.Companion.getDEFAULT_SHAPE$revenuecatui_defaultsBc8Release();
                }
                return new Result.Success(new TabsComponentStyle(z2, size, paddingValues, paddingValues2, backgroundStyles, shape, borderStyles, shadowStyles, tabControlStyle, nonEmptyList, list));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Result<TabsComponentStyle.Tab, NonEmptyList<PaywallValidationError>> createTabsComponentStyleTab(StyleFactoryScope styleFactoryScope, final TabsComponent.Tab tab, final TabControlStyle tabControlStyle, final int i3) {
        return (Result) styleFactoryScope.withSelectedScope(null, null, new Function1<StyleFactoryScope, Result<? extends TabsComponentStyle.Tab, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createTabsComponentStyleTab.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<TabsComponentStyle.Tab, NonEmptyList<PaywallValidationError>> invoke(StyleFactoryScope withSelectedScope) {
                Intrinsics.checkNotNullParameter(withSelectedScope, "$this$withSelectedScope");
                int i4 = i3;
                final TabControlStyle tabControlStyle2 = tabControlStyle;
                final StyleFactory styleFactory = this;
                final TabsComponent.Tab tab2 = tab;
                return (Result) withSelectedScope.withTabIndex(i4, new Function1<StyleFactoryScope, Result<? extends TabsComponentStyle.Tab, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createTabsComponentStyleTab.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Result<TabsComponentStyle.Tab, NonEmptyList<PaywallValidationError>> invoke(StyleFactoryScope withTabIndex) {
                        Intrinsics.checkNotNullParameter(withTabIndex, "$this$withTabIndex");
                        TabControlStyle tabControlStyle3 = tabControlStyle2;
                        final StyleFactory styleFactory2 = styleFactory;
                        final TabsComponent.Tab tab3 = tab2;
                        return (Result) withTabIndex.withTabControl(tabControlStyle3, new Function1<StyleFactoryScope, Result<? extends TabsComponentStyle.Tab, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createTabsComponentStyleTab.1.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Result<TabsComponentStyle.Tab, NonEmptyList<PaywallValidationError>> invoke(StyleFactoryScope withTabControl) {
                                Intrinsics.checkNotNullParameter(withTabControl, "$this$withTabControl");
                                Result<TabsComponentStyle.Tab, NonEmptyList<PaywallValidationError>> resultCreateStackComponentStyle = styleFactory2.createStackComponentStyle(withTabControl, tab3.getStack());
                                if (resultCreateStackComponentStyle instanceof Result.Success) {
                                    return new Result.Success(new TabsComponentStyle.Tab((StackComponentStyle) ((Result.Success) resultCreateStackComponentStyle).getValue()));
                                }
                                if (resultCreateStackComponentStyle instanceof Result.Error) {
                                    return resultCreateStackComponentStyle;
                                }
                                throw new NoWhenBranchMatchedException();
                            }
                        });
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Result<TabControlStyle, NonEmptyList<PaywallValidationError>> createTabsComponentStyleTabControl(StyleFactoryScope styleFactoryScope, final TabsComponent.TabControl tabControl) {
        return (Result) styleFactoryScope.withSelectedScope(null, null, new Function1<StyleFactoryScope, Result<? extends TabControlStyle, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createTabsComponentStyleTabControl.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<TabControlStyle, NonEmptyList<PaywallValidationError>> invoke(StyleFactoryScope withSelectedScope) {
                Intrinsics.checkNotNullParameter(withSelectedScope, "$this$withSelectedScope");
                TabsComponent.TabControl tabControl2 = tabControl;
                if (tabControl2 instanceof TabsComponent.TabControl.Buttons) {
                    Result<TabControlStyle, NonEmptyList<PaywallValidationError>> resultCreateStackComponentStyle = this.createStackComponentStyle(withSelectedScope, ((TabsComponent.TabControl.Buttons) tabControl2).getStack());
                    if (resultCreateStackComponentStyle instanceof Result.Success) {
                        return new Result.Success(new TabControlStyle.Buttons((StackComponentStyle) ((Result.Success) resultCreateStackComponentStyle).getValue()));
                    }
                    if (resultCreateStackComponentStyle instanceof Result.Error) {
                        return resultCreateStackComponentStyle;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                if (!(tabControl2 instanceof TabsComponent.TabControl.Toggle)) {
                    throw new NoWhenBranchMatchedException();
                }
                Result<TabControlStyle, NonEmptyList<PaywallValidationError>> resultCreateStackComponentStyle2 = this.createStackComponentStyle(withSelectedScope, ((TabsComponent.TabControl.Toggle) tabControl2).getStack());
                if (resultCreateStackComponentStyle2 instanceof Result.Success) {
                    return new Result.Success(new TabControlStyle.Toggle((StackComponentStyle) ((Result.Success) resultCreateStackComponentStyle2).getValue()));
                }
                if (resultCreateStackComponentStyle2 instanceof Result.Error) {
                    return resultCreateStackComponentStyle2;
                }
                throw new NoWhenBranchMatchedException();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Result<NonEmptyList<TabsComponentStyle.Tab>, NonEmptyList<PaywallValidationError>> createTabsComponentStyleTabs(final StyleFactoryScope styleFactoryScope, List<TabsComponent.Tab> list, final TabControlStyle tabControlStyle) {
        Result<NonEmptyList<TabsComponentStyle.Tab>, NonEmptyList<PaywallValidationError>> resultErrorIfNull = ResultKt.errorIfNull(NonEmptyListKt.toNonEmptyListOrNull(list), NonEmptyListKt.nonEmptyListOf(PaywallValidationError.TabsComponentWithoutTabs.INSTANCE, new PaywallValidationError.TabsComponentWithoutTabs[0]));
        if (resultErrorIfNull instanceof Result.Success) {
            return NonEmptyListKt.flatten(((NonEmptyList) ((Result.Success) resultErrorIfNull).getValue()).mapIndexed(new Function2<Integer, TabsComponent.Tab, Result<? extends TabsComponentStyle.Tab, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory$createTabsComponentStyleTabs$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public final Result<TabsComponentStyle.Tab, NonEmptyList<PaywallValidationError>> invoke(int i3, TabsComponent.Tab tab) {
                    Intrinsics.checkNotNullParameter(tab, "tab");
                    return this.this$0.createTabsComponentStyleTab(styleFactoryScope, tab, tabControlStyle, i3);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return invoke(((Number) obj).intValue(), (TabsComponent.Tab) obj2);
                }
            }));
        }
        if (resultErrorIfNull instanceof Result.Error) {
            return resultErrorIfNull;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0098 A[LOOP:1: B:18:0x0092->B:20:0x0098, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.revenuecat.purchases.ui.revenuecatui.helpers.Result<com.revenuecat.purchases.ui.revenuecatui.components.style.TextComponentStyle, com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyList<com.revenuecat.purchases.ui.revenuecatui.errors.PaywallValidationError>> createTextComponentStyle(com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.StyleFactoryScope r32, com.revenuecat.purchases.paywalls.components.TextComponent r33) {
        /*
            Method dump skipped, instruction units count: 599
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createTextComponentStyle(com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory$StyleFactoryScope, com.revenuecat.purchases.paywalls.components.TextComponent):com.revenuecat.purchases.ui.revenuecatui.helpers.Result");
    }

    private final Result<TimelineComponentStyle, NonEmptyList<PaywallValidationError>> createTimelineComponentStyle(StyleFactoryScope styleFactoryScope, TimelineComponent timelineComponent) {
        Result presentedOverrides = PresentedPartialKt.toPresentedOverrides(timelineComponent.getOverrides(), this.stripRules, new Function1<PartialTimelineComponent, Result<? extends PresentedTimelinePartial, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createTimelineComponentStyle.1
            @Override // kotlin.jvm.functions.Function1
            public final Result<PresentedTimelinePartial, NonEmptyList<PaywallValidationError>> invoke(PartialTimelineComponent partial) {
                Intrinsics.checkNotNullParameter(partial, "partial");
                return new Result.Success(new PresentedTimelinePartial(partial));
            }
        });
        if (!(presentedOverrides instanceof Result.Success)) {
            if (!(presentedOverrides instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            presentedOverrides = new Result.Error(NonEmptyListKt.nonEmptyListOf((PaywallValidationError) ((Result.Error) presentedOverrides).getValue(), new PaywallValidationError[0]));
        }
        List items = timelineComponent.getItems();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(items, 10));
        Iterator it = items.iterator();
        while (it.hasNext()) {
            arrayList.add(createTimelineComponentItemStyle(styleFactoryScope, (TimelineComponent.Item) it.next()));
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            Result result = (Result) obj;
            if (result instanceof Result.Success) {
                if (arrayList3.isEmpty()) {
                    arrayList2.add((TimelineComponentStyle.ItemStyle) ((Result.Success) result).getValue());
                }
            } else if (result instanceof Result.Error) {
                arrayList3.addAll((Collection) ((Result.Error) result).getValue());
            }
        }
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(arrayList3);
        Result error = nonEmptyListOrNull != null ? new Result.Error(nonEmptyListOrNull) : new Result.Success(arrayList2);
        Unit unit = Unit.f139807a;
        Result.Success success = new Result.Success(unit);
        Result.Success success2 = new Result.Success(unit);
        Result.Success success3 = new Result.Success(unit);
        Result.Success success4 = new Result.Success(unit);
        NonEmptyList nonEmptyListOrNull2 = NonEmptyListKt.toNonEmptyListOrNull(ResultKt.collectErrors(CollectionsKt.listOf((Object[]) new Result[]{presentedOverrides, error, success, success2, success3, success4})));
        if (nonEmptyListOrNull2 != null) {
            return new Result.Error(nonEmptyListOrNull2);
        }
        Intrinsics.checkNotNull(presentedOverrides, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<A of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value = ((Result.Success) presentedOverrides).getValue();
        Object value2 = ((Result.Success) error).getValue();
        Object value3 = success.getValue();
        Object value4 = success2.getValue();
        Object value5 = success3.getValue();
        List list = (List) value2;
        List list2 = (List) value;
        int itemSpacing = timelineComponent.getItemSpacing();
        int textSpacing = timelineComponent.getTextSpacing();
        int columnGutter = timelineComponent.getColumnGutter();
        TimelineComponent.IconAlignment iconAlignment = timelineComponent.getIconAlignment();
        Boolean visible = timelineComponent.getVisible();
        return new Result.Success(new TimelineComponentStyle(itemSpacing, textSpacing, columnGutter, iconAlignment, visible != null ? visible.booleanValue() : true, timelineComponent.getSize(), PaddingKt.toPaddingValues(timelineComponent.getPadding()), PaddingKt.toPaddingValues(timelineComponent.getMargin()), list, styleFactoryScope.getRcPackage(), styleFactoryScope.getResolvedOffer(), styleFactoryScope.getTabControlIndex(), styleFactoryScope.getOfferEligibility(), list2));
    }

    private final Result<VideoComponentStyle, NonEmptyList<PaywallValidationError>> createVideoComponentStyle(StyleFactoryScope styleFactoryScope, VideoComponent videoComponent) {
        Result presentedOverrides;
        PaddingValues paddingValuesC;
        PaddingValues paddingValuesC2;
        Result<NonEmptyMap<LocaleId, ThemeVideoUrls>, NonEmptyList<PaywallValidationError.MissingVideoLocalization>> resultM841withLocalizedOverridesTDPsjl0 = m841withLocalizedOverridesTDPsjl0(videoComponent.getSource(), videoComponent.m611getOverrideSourceLidsa7TU9Q());
        ThemeImageUrls fallbackSource = videoComponent.getFallbackSource();
        Result resultOrSuccessfullyNull = ResultKt.orSuccessfullyNull(fallbackSource != null ? m840withLocalizedOverridesTDPsjl0(fallbackSource, videoComponent.m611getOverrideSourceLidsa7TU9Q()) : null);
        List overrides = videoComponent.getOverrides();
        if (overrides == null || (presentedOverrides = PresentedPartialKt.toPresentedOverrides(overrides, this.stripRules, new Function1<PartialVideoComponent, Result<? extends PresentedVideoPartial, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createVideoComponentStyle.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<PresentedVideoPartial, NonEmptyList<PaywallValidationError>> invoke(PartialVideoComponent videoPartial) {
                Result resultM840withLocalizedOverridesTDPsjl0;
                Intrinsics.checkNotNullParameter(videoPartial, "videoPartial");
                ThemeVideoUrls source = videoPartial.getSource();
                NonEmptyMap nonEmptyMap = null;
                Result<PresentedVideoPartial, NonEmptyList<PaywallValidationError>> resultOrSuccessfullyNull2 = ResultKt.orSuccessfullyNull(source != null ? StyleFactory.this.m841withLocalizedOverridesTDPsjl0(source, videoPartial.m599getOverrideSourceLidsa7TU9Q()) : null);
                StyleFactory styleFactory = StyleFactory.this;
                if (!(resultOrSuccessfullyNull2 instanceof Result.Success)) {
                    if (resultOrSuccessfullyNull2 instanceof Result.Error) {
                        return resultOrSuccessfullyNull2;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                NonEmptyMap nonEmptyMap2 = (NonEmptyMap) ((Result.Success) resultOrSuccessfullyNull2).getValue();
                PresentedVideoPartial.Companion companion = PresentedVideoPartial.Companion;
                ThemeImageUrls fallbackSource2 = videoPartial.getFallbackSource();
                if (fallbackSource2 != null && (resultM840withLocalizedOverridesTDPsjl0 = styleFactory.m840withLocalizedOverridesTDPsjl0(fallbackSource2, videoPartial.m599getOverrideSourceLidsa7TU9Q())) != null && (resultM840withLocalizedOverridesTDPsjl0 instanceof Result.Success)) {
                    nonEmptyMap = (NonEmptyMap) ((Result.Success) resultM840withLocalizedOverridesTDPsjl0).getValue();
                }
                return companion.invoke(videoPartial, nonEmptyMap2, nonEmptyMap, styleFactory.colorAliases);
            }
        })) == null) {
            presentedOverrides = null;
        } else if (!(presentedOverrides instanceof Result.Success)) {
            if (!(presentedOverrides instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            presentedOverrides = new Result.Error(NonEmptyListKt.nonEmptyListOf((PaywallValidationError) ((Result.Error) presentedOverrides).getValue(), new PaywallValidationError[0]));
        }
        Result resultOrSuccessfullyNull2 = ResultKt.orSuccessfullyNull(presentedOverrides);
        ColorScheme colorOverlay = videoComponent.getColorOverlay();
        Result resultOrSuccessfullyNull3 = ResultKt.orSuccessfullyNull(colorOverlay != null ? ColorStyleKt.toColorStyles(colorOverlay, this.colorAliases) : null);
        Border border = videoComponent.getBorder();
        Result resultOrSuccessfullyNull4 = ResultKt.orSuccessfullyNull(border != null ? BorderStyleKt.toBorderStyles(border, this.colorAliases) : null);
        Shadow shadow = videoComponent.getShadow();
        Result resultOrSuccessfullyNull5 = ResultKt.orSuccessfullyNull(shadow != null ? ShadowStyleKt.toShadowStyles(shadow, this.colorAliases) : null);
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(ResultKt.collectErrors(CollectionsKt.listOf((Object[]) new Result[]{resultM841withLocalizedOverridesTDPsjl0, resultOrSuccessfullyNull, resultOrSuccessfullyNull2, resultOrSuccessfullyNull3, resultOrSuccessfullyNull4, resultOrSuccessfullyNull5})));
        if (nonEmptyListOrNull != null) {
            return new Result.Error(nonEmptyListOrNull);
        }
        Intrinsics.checkNotNull(resultM841withLocalizedOverridesTDPsjl0, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<A of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value = ((Result.Success) resultM841withLocalizedOverridesTDPsjl0).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<B of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value2 = ((Result.Success) resultOrSuccessfullyNull).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull2, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<C of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value3 = ((Result.Success) resultOrSuccessfullyNull2).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull3, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<D of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value4 = ((Result.Success) resultOrSuccessfullyNull3).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull4, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<E of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value5 = ((Result.Success) resultOrSuccessfullyNull4).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull5, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<F of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        ShadowStyles shadowStyles = (ShadowStyles) ((Result.Success) resultOrSuccessfullyNull5).getValue();
        BorderStyles borderStyles = (BorderStyles) value5;
        ColorStyles colorStyles = (ColorStyles) value4;
        List listEmptyList = (List) value3;
        NonEmptyMap nonEmptyMap = (NonEmptyMap) value2;
        NonEmptyMap nonEmptyMap2 = (NonEmptyMap) value;
        Boolean visible = videoComponent.getVisible();
        boolean zBooleanValue = visible != null ? visible.booleanValue() : true;
        Size size = videoComponent.getSize();
        Padding padding = videoComponent.getPadding();
        if (padding == null || (paddingValuesC = PaddingKt.toPaddingValues(padding)) == null) {
            paddingValuesC = androidx.compose.foundation.layout.PaddingKt.c(DEFAULT_SPACING, DEFAULT_SPACING, 3, null);
        }
        PaddingValues paddingValues = paddingValuesC;
        Padding margin = videoComponent.getMargin();
        if (margin == null || (paddingValuesC2 = PaddingKt.toPaddingValues(margin)) == null) {
            paddingValuesC2 = androidx.compose.foundation.layout.PaddingKt.c(DEFAULT_SPACING, DEFAULT_SPACING, 3, null);
        }
        PaddingValues paddingValues2 = paddingValuesC2;
        Package rcPackage = styleFactoryScope.getRcPackage();
        ResolvedOffer resolvedOffer = styleFactoryScope.getResolvedOffer();
        Integer tabControlIndex = styleFactoryScope.getTabControlIndex();
        OfferEligibility offerEligibility = styleFactoryScope.getOfferEligibility();
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        List list = listEmptyList;
        boolean showControls = videoComponent.getShowControls();
        boolean autoplay = videoComponent.getAutoplay();
        boolean loop = videoComponent.getLoop();
        boolean muteAudio = videoComponent.getMuteAudio();
        MaskShape maskShape = videoComponent.getMaskShape();
        return new Result.Success(new VideoComponentStyle(nonEmptyMap2, nonEmptyMap, showControls, autoplay, loop, muteAudio, size, zBooleanValue, paddingValues, paddingValues2, maskShape != null ? ShapeKt.toShape(maskShape) : null, borderStyles, shadowStyles, colorStyles, FitModeKt.toContentScale(videoComponent.getFitMode()), rcPackage, resolvedOffer, tabControlIndex, offerEligibility, styleFactoryScope.getIgnoreTopWindowInsets(), list));
    }

    private final Package getPackageOrNull(Offering offering, String str) {
        try {
            return offering.getPackage(str);
        } catch (NoSuchElementException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: withLocalizedOverrides-TDPsjl0, reason: not valid java name */
    public final Result<NonEmptyMap<LocaleId, ThemeImageUrls>, NonEmptyList<PaywallValidationError.MissingImageLocalization>> m840withLocalizedOverridesTDPsjl0(ThemeImageUrls themeImageUrls, String str) {
        Result<NonEmptyMap<LocaleId, ThemeImageUrls>, NonEmptyList<PaywallValidationError.MissingImageLocalization>> resultOrSuccessfullyNull = ResultKt.orSuccessfullyNull(str != null ? LocalizationKt.m729imageForAllLocales7v81vok(this.localizations, str) : null);
        if (!(resultOrSuccessfullyNull instanceof Result.Success)) {
            if (resultOrSuccessfullyNull instanceof Result.Error) {
                return resultOrSuccessfullyNull;
            }
            throw new NoWhenBranchMatchedException();
        }
        Map mapEmptyMap = (NonEmptyMap) ((Result.Success) resultOrSuccessfullyNull).getValue();
        Pair pairA = TuplesKt.a(this.localizations.getEntry().getKey(), themeImageUrls);
        if (mapEmptyMap == null) {
            mapEmptyMap = MapsKt.emptyMap();
        }
        return new Result.Success(NonEmptyMapKt.nonEmptyMapOf(pairA, mapEmptyMap));
    }

    public final Result<StyleResult, NonEmptyList<PaywallValidationError>> create(PaywallComponent component, boolean z2, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(component, "component");
        StyleFactoryScope styleFactoryScope = new StyleFactoryScope(null, null, null, null, null, null, null, 0, null, null, null, null, 4095, null);
        Result resultCreateInternal = createInternal(styleFactoryScope, component);
        if (resultCreateInternal instanceof Result.Success) {
            ComponentStyle componentStyle = (ComponentStyle) ((Result.Success) resultCreateInternal).getValue();
            resultCreateInternal = componentStyle != null ? new Result.Success(componentStyle) : new Result.Error(NonEmptyListKt.nonEmptyListOf(new PaywallValidationError.RootComponentUnsupportedProperties(component), new PaywallValidationError.RootComponentUnsupportedProperties[0]));
        } else if (!(resultCreateInternal instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (resultCreateInternal instanceof Result.Success) {
            ComponentStyle componentStyleApplyTopWindowInsetsIfNotYetApplied = (ComponentStyle) ((Result.Success) resultCreateInternal).getValue();
            if (z2) {
                componentStyleApplyTopWindowInsetsIfNotYetApplied = styleFactoryScope.applyTopWindowInsetsIfNotYetApplied(componentStyleApplyTopWindowInsetsIfNotYetApplied);
            }
            resultCreateInternal = new Result.Success(componentStyleApplyTopWindowInsetsIfNotYetApplied);
        } else if (!(resultCreateInternal instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (resultCreateInternal instanceof Result.Success) {
            resultCreateInternal = new Result.Success(styleFactoryScope.applyBottomWindowInsetsIfNecessary((ComponentStyle) ((Result.Success) resultCreateInternal).getValue(), z3));
        } else if (!(resultCreateInternal instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (resultCreateInternal instanceof Result.Success) {
            resultCreateInternal = new Result.Success(styleFactoryScope.applyHorizontalWindowInsetsIfNecessary((ComponentStyle) ((Result.Success) resultCreateInternal).getValue(), z4));
        } else if (!(resultCreateInternal instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (resultCreateInternal instanceof Result.Success) {
            return new Result.Success(new StyleResult((ComponentStyle) ((Result.Success) resultCreateInternal).getValue(), styleFactoryScope.getPackages(), styleFactoryScope.getDefaultTabIndex(), styleFactoryScope.getHeroImageDetected()));
        }
        if (resultCreateInternal instanceof Result.Error) {
            return resultCreateInternal;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Result<TimelineComponentStyle.ItemStyle, NonEmptyList<PaywallValidationError>> createTimelineComponentItemStyle(StyleFactoryScope styleFactoryScope, TimelineComponent.Item item) {
        ColorScheme color;
        Result presentedOverrides = PresentedPartialKt.toPresentedOverrides(item.getOverrides(), this.stripRules, new Function1<PartialTimelineComponentItem, Result<? extends PresentedTimelineItemPartial, ? extends NonEmptyList<? extends PaywallValidationError>>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory.createTimelineComponentItemStyle.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Result<PresentedTimelineItemPartial, NonEmptyList<PaywallValidationError>> invoke(PartialTimelineComponentItem partial) {
                Intrinsics.checkNotNullParameter(partial, "partial");
                return PresentedTimelineItemPartial.Companion.invoke(partial, StyleFactory.this.colorAliases);
            }
        });
        if (!(presentedOverrides instanceof Result.Success)) {
            if (!(presentedOverrides instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            presentedOverrides = new Result.Error(NonEmptyListKt.nonEmptyListOf((PaywallValidationError) ((Result.Error) presentedOverrides).getValue(), new PaywallValidationError[0]));
        }
        Result<TextComponentStyle, NonEmptyList<PaywallValidationError>> resultCreateTextComponentStyle = createTextComponentStyle(styleFactoryScope, item.getTitle());
        TextComponent description = item.getDescription();
        TimelineComponentStyle.ConnectorStyle connectorStyle = null;
        Result resultOrSuccessfullyNull = ResultKt.orSuccessfullyNull(description != null ? createTextComponentStyle(styleFactoryScope, description) : null);
        Result<IconComponentStyle, NonEmptyList<PaywallValidationError>> resultCreateIconComponentStyle = createIconComponentStyle(styleFactoryScope, item.getIcon());
        TimelineComponent.Connector connector = item.getConnector();
        Result resultOrSuccessfullyNull2 = ResultKt.orSuccessfullyNull((connector == null || (color = connector.getColor()) == null) ? null : ColorStyleKt.toColorStyles(color, this.colorAliases));
        Result.Success success = new Result.Success(Unit.f139807a);
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(ResultKt.collectErrors(CollectionsKt.listOf((Object[]) new Result[]{presentedOverrides, resultCreateTextComponentStyle, resultOrSuccessfullyNull, resultCreateIconComponentStyle, resultOrSuccessfullyNull2, success})));
        if (nonEmptyListOrNull != null) {
            return new Result.Error(nonEmptyListOrNull);
        }
        Intrinsics.checkNotNull(presentedOverrides, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<A of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value = ((Result.Success) presentedOverrides).getValue();
        Intrinsics.checkNotNull(resultCreateTextComponentStyle, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<B of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value2 = ((Result.Success) resultCreateTextComponentStyle).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<C of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value3 = ((Result.Success) resultOrSuccessfullyNull).getValue();
        Intrinsics.checkNotNull(resultCreateIconComponentStyle, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<D of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value4 = ((Result.Success) resultCreateIconComponentStyle).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull2, HcgZcEUYo.pbja);
        Object value5 = ((Result.Success) resultOrSuccessfullyNull2).getValue();
        ColorStyles colorStyles = (ColorStyles) value5;
        IconComponentStyle iconComponentStyle = (IconComponentStyle) value4;
        TextComponentStyle textComponentStyle = (TextComponentStyle) value3;
        TextComponentStyle textComponentStyle2 = (TextComponentStyle) value2;
        List list = (List) value;
        TimelineComponent.Connector connector2 = item.getConnector();
        if (connector2 != null && colorStyles != null) {
            connectorStyle = new TimelineComponentStyle.ConnectorStyle(connector2.getWidth(), PaddingKt.toPaddingValues(connector2.getMargin()), colorStyles);
        }
        TimelineComponentStyle.ConnectorStyle connectorStyle2 = connectorStyle;
        Boolean visible = item.getVisible();
        return new Result.Success(new TimelineComponentStyle.ItemStyle(textComponentStyle2, visible != null ? visible.booleanValue() : true, textComponentStyle, iconComponentStyle, connectorStyle2, styleFactoryScope.getRcPackage(), styleFactoryScope.getResolvedOffer(), styleFactoryScope.getTabControlIndex(), styleFactoryScope.getOfferEligibility(), list));
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class StyleResult {
        public static final int $stable = 0;
        private final PaywallState.Loaded.Components.AvailablePackages availablePackages;
        private final ComponentStyle componentStyle;
        private final Integer defaultTabIndex;
        private final boolean heroImageDetected;

        public StyleResult(ComponentStyle componentStyle, PaywallState.Loaded.Components.AvailablePackages availablePackages, Integer num, boolean z2) {
            Intrinsics.checkNotNullParameter(componentStyle, "componentStyle");
            Intrinsics.checkNotNullParameter(availablePackages, "availablePackages");
            this.componentStyle = componentStyle;
            this.availablePackages = availablePackages;
            this.defaultTabIndex = num;
            this.heroImageDetected = z2;
        }

        public final PaywallState.Loaded.Components.AvailablePackages getAvailablePackages() {
            return this.availablePackages;
        }

        public final ComponentStyle getComponentStyle() {
            return this.componentStyle;
        }

        public final Integer getDefaultTabIndex() {
            return this.defaultTabIndex;
        }

        public final boolean getHeroImageDetected() {
            return this.heroImageDetected;
        }

        public /* synthetic */ StyleResult(ComponentStyle componentStyle, PaywallState.Loaded.Components.AvailablePackages availablePackages, Integer num, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(componentStyle, availablePackages, num, (i3 & 8) != 0 ? false : z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: withLocalizedOverrides-TDPsjl0, reason: not valid java name */
    public final Result<NonEmptyMap<LocaleId, ThemeVideoUrls>, NonEmptyList<PaywallValidationError.MissingVideoLocalization>> m841withLocalizedOverridesTDPsjl0(ThemeVideoUrls themeVideoUrls, String str) {
        Result<NonEmptyMap<LocaleId, ThemeVideoUrls>, NonEmptyList<PaywallValidationError.MissingVideoLocalization>> resultOrSuccessfullyNull = ResultKt.orSuccessfullyNull(str != null ? LocalizationKt.m735videoForAllLocales7v81vok(this.localizations, str) : null);
        if (resultOrSuccessfullyNull instanceof Result.Success) {
            Map mapEmptyMap = (NonEmptyMap) ((Result.Success) resultOrSuccessfullyNull).getValue();
            Pair pairA = TuplesKt.a(this.localizations.getEntry().getKey(), themeVideoUrls);
            if (mapEmptyMap == null) {
                mapEmptyMap = MapsKt.emptyMap();
            }
            return new Result.Success(NonEmptyMapKt.nonEmptyMapOf(pairA, mapEmptyMap));
        }
        if (resultOrSuccessfullyNull instanceof Result.Error) {
            return resultOrSuccessfullyNull;
        }
        throw new NoWhenBranchMatchedException();
    }

    public /* synthetic */ StyleFactory(NonEmptyMap nonEmptyMap, Map map, Map map2, NonEmptyMap nonEmptyMap2, Offering offering, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(nonEmptyMap, map, map2, nonEmptyMap2, offering, (i3 & 32) != 0 ? false : z2);
    }
}
