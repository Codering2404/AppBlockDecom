package com.revenuecat.purchases.ui.revenuecatui.components.text;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.style.TextAlign;
import androidx.window.core.layout.WindowWidthSizeClass;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.paywalls.components.CountdownComponent;
import com.revenuecat.purchases.paywalls.components.PartialTextComponent;
import com.revenuecat.purchases.paywalls.components.common.LocaleId;
import com.revenuecat.purchases.paywalls.components.common.VariableLocalizationKey;
import com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.ui.revenuecatui.components.ComponentViewState;
import com.revenuecat.purchases.ui.revenuecatui.components.ConditionContext;
import com.revenuecat.purchases.ui.revenuecatui.components.LocalizedTextPartial;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedPartialKt;
import com.revenuecat.purchases.ui.revenuecatui.components.ScreenCondition;
import com.revenuecat.purchases.ui.revenuecatui.components.countdown.CountdownTime;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.AlignmentKt;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.FontKt;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.LocalizationKt;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.PaddingKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.FontSpec;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.FontSpecKt;
import com.revenuecat.purchases.ui.revenuecatui.components.state.PackageAwareDelegate;
import com.revenuecat.purchases.ui.revenuecatui.components.style.TextComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.composables.OfferEligibility;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyMap;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResolvedOffer;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
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
public final class TextComponentState {
    public static final int $stable = 0;
    private final State applicablePackage$delegate;
    private final State backgroundColor$delegate;
    private final State color$delegate;
    private final MutableState countdownTime$delegate;
    private final Function0<Map<String, CustomVariableValue>> customVariablesProvider;
    private final State fontFamily$delegate;
    private final State fontSize$delegate;
    private final State fontSpec$delegate;
    private final State fontWeight$delegate;
    private final State horizontalAlignment$delegate;
    private final State localeId$delegate;
    private final Function0<Locale> localeProvider;
    private final State localizedVariableKeys$delegate;
    private final State margin$delegate;
    private final PackageAwareDelegate packageAwareDelegate;
    private final State padding$delegate;
    private final State presentedPartial$delegate;
    private final Function0<OfferEligibility> selectedOfferEligibilityProvider;
    private final Function0<PaywallState.Loaded.Components.SelectedPackageInfo> selectedPackageInfoProvider;
    private final Function0<Integer> selectedTabIndexProvider;
    private final State size$delegate;
    private final TextComponentStyle style;
    private final State subscriptionOption$delegate;
    private final State text$delegate;
    private final State textAlign$delegate;
    private final State visible$delegate;
    private final MutableState windowSize$delegate;

    /* JADX WARN: Multi-variable type inference failed */
    public TextComponentState(WindowWidthSizeClass initialWindowSize, TextComponentStyle style, Function0<Locale> localeProvider, Function0<PaywallState.Loaded.Components.SelectedPackageInfo> selectedPackageInfoProvider, Function0<Integer> selectedTabIndexProvider, Function0<? extends OfferEligibility> selectedOfferEligibilityProvider, Function0<? extends Map<String, ? extends CustomVariableValue>> customVariablesProvider) {
        Intrinsics.checkNotNullParameter(initialWindowSize, "initialWindowSize");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(localeProvider, "localeProvider");
        Intrinsics.checkNotNullParameter(selectedPackageInfoProvider, "selectedPackageInfoProvider");
        Intrinsics.checkNotNullParameter(selectedTabIndexProvider, "selectedTabIndexProvider");
        Intrinsics.checkNotNullParameter(selectedOfferEligibilityProvider, "selectedOfferEligibilityProvider");
        Intrinsics.checkNotNullParameter(customVariablesProvider, "customVariablesProvider");
        this.style = style;
        this.localeProvider = localeProvider;
        this.selectedPackageInfoProvider = selectedPackageInfoProvider;
        this.selectedTabIndexProvider = selectedTabIndexProvider;
        this.selectedOfferEligibilityProvider = selectedOfferEligibilityProvider;
        this.customVariablesProvider = customVariablesProvider;
        this.windowSize$delegate = SnapshotStateKt__SnapshotStateKt.e(initialWindowSize, null, 2, null);
        this.packageAwareDelegate = new PackageAwareDelegate(style, selectedPackageInfoProvider, selectedTabIndexProvider, selectedOfferEligibilityProvider);
        this.countdownTime$delegate = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
        this.localeId$delegate = SnapshotStateKt.e(new Function0<LocaleId>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentState$localeId$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                return LocaleId.m612boximpl(m851invokeuqtKvyA());
            }

            /* JADX INFO: renamed from: invoke-uqtKvyA, reason: not valid java name */
            public final String m851invokeuqtKvyA() {
                return LocalizationKt.toLocaleId((Locale) this.this$0.localeProvider.invoke());
            }
        });
        this.applicablePackage$delegate = SnapshotStateKt.e(new Function0<Package>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentState$applicablePackage$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Package invoke() {
                Package rcPackage = this.this$0.style.getRcPackage();
                if (rcPackage != null) {
                    return rcPackage;
                }
                PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo = (PaywallState.Loaded.Components.SelectedPackageInfo) this.this$0.selectedPackageInfoProvider.invoke();
                if (selectedPackageInfo != null) {
                    return selectedPackageInfo.getRcPackage();
                }
                return null;
            }
        });
        this.subscriptionOption$delegate = SnapshotStateKt.e(new Function0<SubscriptionOption>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentState$subscriptionOption$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final SubscriptionOption invoke() {
                ResolvedOffer resolvedOffer;
                SubscriptionOption subscriptionOption;
                ResolvedOffer resolvedOffer2 = this.this$0.style.getResolvedOffer();
                if (resolvedOffer2 != null && (subscriptionOption = resolvedOffer2.getSubscriptionOption()) != null) {
                    return subscriptionOption;
                }
                PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo = (PaywallState.Loaded.Components.SelectedPackageInfo) this.this$0.selectedPackageInfoProvider.invoke();
                if (selectedPackageInfo == null || (resolvedOffer = selectedPackageInfo.getResolvedOffer()) == null) {
                    return null;
                }
                return resolvedOffer.getSubscriptionOption();
            }
        });
        this.presentedPartial$delegate = SnapshotStateKt.e(new Function0<LocalizedTextPartial>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentState$presentedPartial$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final LocalizedTextPartial invoke() {
                Package rcPackage;
                ScreenCondition screenConditionFrom = ScreenCondition.Companion.from(this.this$0.getWindowSize());
                ComponentViewState componentViewState = this.this$0.packageAwareDelegate.isSelected() ? ComponentViewState.SELECTED : ComponentViewState.DEFAULT;
                List overrides = this.this$0.style.getOverrides();
                OfferEligibility offerEligibility = this.this$0.packageAwareDelegate.getOfferEligibility();
                PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo = (PaywallState.Loaded.Components.SelectedPackageInfo) this.this$0.selectedPackageInfoProvider.invoke();
                return (LocalizedTextPartial) PresentedPartialKt.buildPresentedPartial(overrides, screenConditionFrom, offerEligibility, componentViewState, new ConditionContext((selectedPackageInfo == null || (rcPackage = selectedPackageInfo.getRcPackage()) == null) ? null : rcPackage.getIdentifier(), (Map) this.this$0.customVariablesProvider.invoke()));
            }
        });
        this.visible$delegate = SnapshotStateKt.e(new Function0<Boolean>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentState$visible$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                PartialTextComponent partial;
                Boolean visible;
                LocalizedTextPartial presentedPartial = this.this$0.getPresentedPartial();
                return Boolean.valueOf((presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (visible = partial.getVisible()) == null) ? this.this$0.style.getVisible() : visible.booleanValue());
            }
        });
        this.text$delegate = SnapshotStateKt.e(new Function0<String>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentState$text$2
            {
                super(0);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                NonEmptyMap texts;
                String str;
                LocalizedTextPartial presentedPartial = this.this$0.getPresentedPartial();
                if (presentedPartial != null && (texts = presentedPartial.getTexts()) != null && (str = (String) texts.getOrDefault(LocaleId.m612boximpl(this.this$0.m849getLocaleIduqtKvyA()), texts.getEntry().getValue())) != null) {
                    return str;
                }
                NonEmptyMap texts2 = this.this$0.style.getTexts();
                return (String) texts2.getOrDefault(LocaleId.m612boximpl(this.this$0.m849getLocaleIduqtKvyA()), texts2.getEntry().getValue());
            }
        });
        this.localizedVariableKeys$delegate = SnapshotStateKt.e(new Function0<NonEmptyMap<VariableLocalizationKey, ? extends String>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentState$localizedVariableKeys$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final NonEmptyMap<VariableLocalizationKey, String> invoke() {
                NonEmptyMap variableLocalizations = this.this$0.style.getVariableLocalizations();
                NonEmptyMap<VariableLocalizationKey, String> nonEmptyMap = (NonEmptyMap) LocalizationKt.m726getBestMatch64pKzr8(variableLocalizations, this.this$0.m849getLocaleIduqtKvyA());
                return nonEmptyMap == null ? (NonEmptyMap) variableLocalizations.getEntry().getValue() : nonEmptyMap;
            }
        });
        this.color$delegate = SnapshotStateKt.e(new Function0<ColorStyles>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentState$color$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ColorStyles invoke() {
                ColorStyles color;
                LocalizedTextPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (color = presentedPartial.getColor()) == null) ? this.this$0.style.getColor() : color;
            }
        });
        this.fontSize$delegate = SnapshotStateKt.e(new Function0<Integer>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentState$fontSize$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                PartialTextComponent partial;
                Integer fontSize;
                LocalizedTextPartial presentedPartial = this.this$0.getPresentedPartial();
                return Integer.valueOf((presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (fontSize = partial.getFontSize()) == null) ? this.this$0.style.getFontSize() : fontSize.intValue());
            }
        });
        this.fontWeight$delegate = SnapshotStateKt.e(new Function0<FontWeight>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentState$fontWeight$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final FontWeight invoke() {
                PartialTextComponent partial;
                FontWeight fontWeight;
                LocalizedTextPartial presentedPartial = this.this$0.getPresentedPartial();
                if (presentedPartial != null && (partial = presentedPartial.getPartial()) != null) {
                    Integer fontWeightInt = partial.getFontWeightInt();
                    if (fontWeightInt != null) {
                        fontWeight = new FontWeight(fontWeightInt.intValue());
                    } else {
                        com.revenuecat.purchases.paywalls.components.properties.FontWeight fontWeight2 = partial.getFontWeight();
                        fontWeight = fontWeight2 != null ? FontKt.toFontWeight(fontWeight2) : null;
                    }
                    if (fontWeight != null) {
                        return fontWeight;
                    }
                }
                return this.this$0.style.getFontWeight();
            }
        });
        this.fontSpec$delegate = SnapshotStateKt.e(new Function0<FontSpec>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentState$fontSpec$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final FontSpec invoke() {
                FontSpec fontSpec;
                LocalizedTextPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (fontSpec = presentedPartial.getFontSpec()) == null) ? this.this$0.style.getFontSpec() : fontSpec;
            }
        });
        this.fontFamily$delegate = SnapshotStateKt.e(new Function0<FontFamily>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentState$fontFamily$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final FontFamily invoke() {
                FontSpec fontSpec = this.this$0.getFontSpec();
                if (fontSpec == null) {
                    return null;
                }
                FontWeight fontWeight = this.this$0.getFontWeight();
                if (fontWeight == null) {
                    fontWeight = FontWeight.f29233b.g();
                }
                return FontSpecKt.m788resolveRetOiIg(fontSpec, fontWeight, FontStyle.f29211b.b());
            }
        });
        this.textAlign$delegate = SnapshotStateKt.e(new Function0<TextAlign>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentState$textAlign$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: invoke-buA522U, reason: not valid java name and merged with bridge method [inline-methods] */
            public final TextAlign invoke() {
                PartialTextComponent partial;
                HorizontalAlignment horizontalAlignment;
                LocalizedTextPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (horizontalAlignment = partial.getHorizontalAlignment()) == null) ? this.this$0.style.m842getTextAlignbuA522U() : TextAlign.h(AlignmentKt.toTextAlign(horizontalAlignment));
            }
        });
        this.horizontalAlignment$delegate = SnapshotStateKt.e(new Function0<Alignment.Horizontal>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentState$horizontalAlignment$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Alignment.Horizontal invoke() {
                PartialTextComponent partial;
                HorizontalAlignment horizontalAlignment;
                Alignment.Horizontal alignment;
                LocalizedTextPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (horizontalAlignment = partial.getHorizontalAlignment()) == null || (alignment = AlignmentKt.toAlignment(horizontalAlignment)) == null) ? this.this$0.style.getHorizontalAlignment() : alignment;
            }
        });
        this.backgroundColor$delegate = SnapshotStateKt.e(new Function0<ColorStyles>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentState$backgroundColor$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ColorStyles invoke() {
                ColorStyles backgroundColor;
                LocalizedTextPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (backgroundColor = presentedPartial.getBackgroundColor()) == null) ? this.this$0.style.getBackgroundColor() : backgroundColor;
            }
        });
        this.size$delegate = SnapshotStateKt.e(new Function0<Size>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentState$size$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Size invoke() {
                PartialTextComponent partial;
                Size size;
                LocalizedTextPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (size = partial.getSize()) == null) ? this.this$0.style.getSize() : size;
            }
        });
        this.padding$delegate = SnapshotStateKt.e(new Function0<PaddingValues>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentState$padding$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final PaddingValues invoke() {
                PartialTextComponent partial;
                Padding padding;
                PaddingValues paddingValues;
                LocalizedTextPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (padding = partial.getPadding()) == null || (paddingValues = PaddingKt.toPaddingValues(padding)) == null) ? this.this$0.style.getPadding() : paddingValues;
            }
        });
        this.margin$delegate = SnapshotStateKt.e(new Function0<PaddingValues>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentState$margin$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final PaddingValues invoke() {
                PartialTextComponent partial;
                Padding margin;
                PaddingValues paddingValues;
                LocalizedTextPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (margin = partial.getMargin()) == null || (paddingValues = PaddingKt.toPaddingValues(margin)) == null) ? this.this$0.style.getMargin() : paddingValues;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FontSpec getFontSpec() {
        return (FontSpec) this.fontSpec$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getLocaleId-uqtKvyA, reason: not valid java name */
    public final String m849getLocaleIduqtKvyA() {
        return ((LocaleId) this.localeId$delegate.getValue()).m618unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LocalizedTextPartial getPresentedPartial() {
        return (LocalizedTextPartial) this.presentedPartial$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WindowWidthSizeClass getWindowSize() {
        return (WindowWidthSizeClass) this.windowSize$delegate.getValue();
    }

    private final void setCountdownTime(CountdownTime countdownTime) {
        this.countdownTime$delegate.setValue(countdownTime);
    }

    private final void setWindowSize(WindowWidthSizeClass windowWidthSizeClass) {
        this.windowSize$delegate.setValue(windowWidthSizeClass);
    }

    public static /* synthetic */ void update$default(TextComponentState textComponentState, WindowWidthSizeClass windowWidthSizeClass, CountdownTime countdownTime, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            windowWidthSizeClass = null;
        }
        if ((i3 & 2) != 0) {
            countdownTime = textComponentState.getCountdownTime();
        }
        textComponentState.update(windowWidthSizeClass, countdownTime);
    }

    public final Package getApplicablePackage() {
        return (Package) this.applicablePackage$delegate.getValue();
    }

    public final /* synthetic */ ColorStyles getBackgroundColor() {
        return (ColorStyles) this.backgroundColor$delegate.getValue();
    }

    public final /* synthetic */ ColorStyles getColor() {
        return (ColorStyles) this.color$delegate.getValue();
    }

    public final /* synthetic */ CountdownComponent.CountFrom getCountFrom() {
        return this.style.getCountFrom();
    }

    public final CountdownTime getCountdownTime() {
        return (CountdownTime) this.countdownTime$delegate.getValue();
    }

    public final /* synthetic */ FontFamily getFontFamily() {
        return (FontFamily) this.fontFamily$delegate.getValue();
    }

    public final /* synthetic */ int getFontSize() {
        return ((Number) this.fontSize$delegate.getValue()).intValue();
    }

    public final /* synthetic */ FontWeight getFontWeight() {
        return (FontWeight) this.fontWeight$delegate.getValue();
    }

    public final /* synthetic */ Alignment.Horizontal getHorizontalAlignment() {
        return (Alignment.Horizontal) this.horizontalAlignment$delegate.getValue();
    }

    public final /* synthetic */ NonEmptyMap getLocalizedVariableKeys() {
        return (NonEmptyMap) this.localizedVariableKeys$delegate.getValue();
    }

    public final /* synthetic */ PaddingValues getMargin() {
        return (PaddingValues) this.margin$delegate.getValue();
    }

    public final /* synthetic */ PaddingValues getPadding() {
        return (PaddingValues) this.padding$delegate.getValue();
    }

    public final /* synthetic */ Size getSize() {
        return (Size) this.size$delegate.getValue();
    }

    public final SubscriptionOption getSubscriptionOption() {
        return (SubscriptionOption) this.subscriptionOption$delegate.getValue();
    }

    public final /* synthetic */ String getText() {
        return (String) this.text$delegate.getValue();
    }

    /* JADX INFO: renamed from: getTextAlign-buA522U, reason: not valid java name */
    public final /* synthetic */ TextAlign m850getTextAlignbuA522U() {
        return (TextAlign) this.textAlign$delegate.getValue();
    }

    public final /* synthetic */ boolean getVisible() {
        return ((Boolean) this.visible$delegate.getValue()).booleanValue();
    }

    public final /* synthetic */ void update(WindowWidthSizeClass windowWidthSizeClass, CountdownTime countdownTime) {
        if (windowWidthSizeClass != null) {
            setWindowSize(windowWidthSizeClass);
        }
        setCountdownTime(countdownTime);
    }

    public /* synthetic */ TextComponentState(WindowWidthSizeClass windowWidthSizeClass, TextComponentStyle textComponentStyle, Function0 function0, Function0 function02, Function0 function03, Function0 function04, Function0 function05, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(windowWidthSizeClass, textComponentStyle, function0, function02, function03, function04, (i3 & 64) != 0 ? new Function0<Map<String, ? extends CustomVariableValue>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentState.1
            @Override // kotlin.jvm.functions.Function0
            public final Map<String, CustomVariableValue> invoke() {
                return MapsKt.emptyMap();
            }
        } : function05);
    }
}
