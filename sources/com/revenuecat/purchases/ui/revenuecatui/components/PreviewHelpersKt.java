package com.revenuecat.purchases.ui.revenuecatui.components;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import coil.ComponentRegistry;
import coil.ImageLoader;
import coil.decode.DataSource;
import coil.intercept.Interceptor;
import coil.request.ImageResult;
import coil.request.SuccessResult;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.paywalls.components.CountdownComponent;
import com.revenuecat.purchases.paywalls.components.HeaderComponent;
import com.revenuecat.purchases.paywalls.components.IconComponent;
import com.revenuecat.purchases.paywalls.components.StackComponent;
import com.revenuecat.purchases.paywalls.components.StickyFooterComponent;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.common.ComponentsConfig;
import com.revenuecat.purchases.paywalls.components.common.ExitOffers;
import com.revenuecat.purchases.paywalls.components.common.LocaleId;
import com.revenuecat.purchases.paywalls.components.common.LocalizationData;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey;
import com.revenuecat.purchases.paywalls.components.common.PaywallComponentsConfig;
import com.revenuecat.purchases.paywalls.components.common.PaywallComponentsData;
import com.revenuecat.purchases.paywalls.components.common.ProductChangeConfig;
import com.revenuecat.purchases.paywalls.components.common.VariableLocalizationKey;
import com.revenuecat.purchases.paywalls.components.properties.Badge;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.paywalls.components.properties.ColorInfo;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.Dimension;
import com.revenuecat.purchases.paywalls.components.properties.FontWeight;
import com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.MaskShape;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import com.revenuecat.purchases.ui.revenuecatui.BuildConfig;
import com.revenuecat.purchases.ui.revenuecatui.R;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.AlignmentKt;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.FontKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.FontSpec;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.style.BadgeStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.IconComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.StackComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.TextComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.data.MockPurchasesType;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.TestData;
import com.revenuecat.purchases.ui.revenuecatui.errors.PaywallValidationError;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyList;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyMap;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyMapKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.OfferingToStateMapperKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallResourceProvider;
import com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallValidationResult;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Result;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt;
import com.sun.jna.Function;
import java.net.URL;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

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
public final /* synthetic */ class PreviewHelpersKt {
    public static final long MILLIS_2025_01_25 = 1737763200000L;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VariableLocalizationKey.values().length];
            try {
                iArr[VariableLocalizationKey.ANNUAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VariableLocalizationKey.ANNUAL_SHORT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[VariableLocalizationKey.ANNUALLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[VariableLocalizationKey.DAILY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[VariableLocalizationKey.DAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[VariableLocalizationKey.DAY_SHORT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[VariableLocalizationKey.FREE_PRICE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[VariableLocalizationKey.MONTH.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[VariableLocalizationKey.MONTH_SHORT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[VariableLocalizationKey.MONTHLY.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[VariableLocalizationKey.LIFETIME.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_DAY_FEW.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_DAY_MANY.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_DAY_ONE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_DAY_OTHER.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_DAY_TWO.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_DAY_ZERO.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_MONTH_FEW.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_MONTH_MANY.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_MONTH_ONE.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_MONTH_OTHER.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_MONTH_TWO.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_MONTH_ZERO.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_WEEK_FEW.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_WEEK_MANY.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_WEEK_ONE.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_WEEK_OTHER.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_WEEK_TWO.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_WEEK_ZERO.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_YEAR_FEW.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_YEAR_MANY.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_YEAR_ONE.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_YEAR_OTHER.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_YEAR_TWO.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_YEAR_ZERO.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                iArr[VariableLocalizationKey.PERCENT.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                iArr[VariableLocalizationKey.WEEK.ordinal()] = 37;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                iArr[VariableLocalizationKey.WEEK_SHORT.ordinal()] = 38;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                iArr[VariableLocalizationKey.WEEKLY.ordinal()] = 39;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                iArr[VariableLocalizationKey.YEAR.ordinal()] = 40;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                iArr[VariableLocalizationKey.YEAR_SHORT.ordinal()] = 41;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                iArr[VariableLocalizationKey.YEARLY.ordinal()] = 42;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_DAYS_SHORT.ordinal()] = 43;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_WEEKS_SHORT.ordinal()] = 44;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_MONTHS_SHORT.ordinal()] = 45;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                iArr[VariableLocalizationKey.NUM_YEARS_SHORT.ordinal()] = 46;
            } catch (NoSuchFieldError unused46) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ PaywallState.Loaded.Components previewEmptyState(Integer num, Composer composer, int i3, int i4) {
        composer.a0(1055380879);
        PaywallValidationResult.Components components = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Integer num2 = (i4 & 1) != 0 ? null : num;
        if (ComposerKt.M()) {
            ComposerKt.U(1055380879, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.previewEmptyState (PreviewHelpers.kt:85)");
        }
        URL url = new URL("https://assets.pawwalls.com");
        StackComponent stackComponent = new StackComponent(CollectionsKt.listOf(TestData.Components.INSTANCE.getMonthlyPackageComponent()), (Boolean) null, (Dimension) null, (Size) null, (Float) null, (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65534, (DefaultConstructorMarker) null);
        Object[] objArr3 = objArr2 == true ? 1 : 0;
        Offering offering = new Offering("identifier", "serverDescription", MapsKt.emptyMap(), CollectionsKt.listOf(TestData.Packages.INSTANCE.getMonthly()), null, new Offering.PaywallComponents(new UiConfig((UiConfig.AppConfig) null, (Map) NonEmptyMapKt.nonEmptyMapOf(TuplesKt.a(LocaleId.m612boximpl(LocaleId.m613constructorimpl("en_US")), variableLocalizationKeysForEnUs()), new Pair[0]), (UiConfig.VariableConfig) (0 == true ? 1 : 0), (Map) (0 == true ? 1 : 0), 13, (DefaultConstructorMarker) (0 == true ? 1 : 0)), new PaywallComponentsData("preview_paywall_id", SDKConstants.PARAM_UPDATE_TEMPLATE, url, new ComponentsConfig(new PaywallComponentsConfig(stackComponent, new Background.Color(new ColorScheme((ColorInfo) new ColorInfo.Hex(ColorKt.k(Color.f25715b.l())), (ColorInfo) objArr3, 2, (DefaultConstructorMarker) (objArr == true ? 1 : 0))), (StickyFooterComponent) null, (HeaderComponent) null, 8, (DefaultConstructorMarker) null)), (Map) NonEmptyMapKt.nonEmptyMapOf(TuplesKt.a(LocaleId.m612boximpl(LocaleId.m613constructorimpl("en_US")), NonEmptyMapKt.nonEmptyMapOf(TuplesKt.a(LocalizationKey.m648boximpl(LocalizationKey.m649constructorimpl("text")), LocalizationData.Text.m630boximpl(LocalizationData.Text.m631constructorimpl("text"))), new Pair[0])), new Pair[0]), LocaleId.m613constructorimpl("en_US"), 0, (List) (0 == true ? 1 : 0), (ExitOffers) (0 == true ? 1 : 0), (ProductChangeConfig) (0 == true ? 1 : 0), 960, (DefaultConstructorMarker) (0 == true ? 1 : 0))), null, 80, null);
        Result resultValidatePaywallComponentsDataOrNullForPreviews = validatePaywallComponentsDataOrNullForPreviews(offering, composer, 0);
        if (resultValidatePaywallComponentsDataOrNullForPreviews != null) {
            if (resultValidatePaywallComponentsDataOrNullForPreviews instanceof Result.Success) {
                PaywallValidationResult.Components componentsCopy$default = (PaywallValidationResult.Components) ((Result.Success) resultValidatePaywallComponentsDataOrNullForPreviews).getValue();
                if (num2 != null) {
                    componentsCopy$default = PaywallValidationResult.Components.copy$default(componentsCopy$default, null, null, null, null, null, null, null, null, null, num2, false, 1535, null);
                }
                resultValidatePaywallComponentsDataOrNullForPreviews = new Result.Success(componentsCopy$default);
            } else if (!(resultValidatePaywallComponentsDataOrNullForPreviews instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            components = (PaywallValidationResult.Components) ResultKt.getOrThrow(resultValidatePaywallComponentsDataOrNullForPreviews);
        }
        PaywallValidationResult.Components components2 = components;
        Intrinsics.checkNotNull(components2);
        PaywallState.Loaded.Components componentsPaywallState$default = OfferingToStateMapperKt.toComponentsPaywallState$default(offering, components2, null, new Function0<Date>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.PreviewHelpersKt.previewEmptyState.1
            @Override // kotlin.jvm.functions.Function0
            public final Date invoke() {
                return new Date(PreviewHelpersKt.MILLIS_2025_01_25);
            }
        }, new MockPurchasesType(null, null, null, null, 15, null), null, null, 48, null);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return componentsPaywallState$default;
    }

    public static final IconComponentStyle previewIconComponentStyle(Size size, boolean z2, ColorStyles colorStyles, ColorStyles colorStyles2, PaddingValues paddingValues, PaddingValues paddingValues2, BorderStyles borderStyles, ShadowStyles shadowStyles, MaskShape maskShape, Composer composer, int i3, int i4) {
        Intrinsics.checkNotNullParameter(size, "size");
        composer.a0(971508494);
        boolean z3 = (i4 & 2) != 0 ? true : z2;
        ColorStyles colorStyles3 = (i4 & 4) != 0 ? new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(Color.f25715b.c())), null, 2, null) : colorStyles;
        ColorStyles colorStyles4 = (i4 & 8) != 0 ? new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(Color.f25715b.i())), null, 2, null) : colorStyles2;
        PaddingValues paddingValuesA = (i4 & 16) != 0 ? PaddingKt.a(Dp.g(10)) : paddingValues;
        PaddingValues paddingValuesA2 = (i4 & 32) != 0 ? PaddingKt.a(Dp.g(10)) : paddingValues2;
        BorderStyles borderStyles2 = (i4 & 64) != 0 ? new BorderStyles(Dp.g(2), new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(Color.f25715b.c())), null, 2, null), null) : borderStyles;
        ShadowStyles shadowStyles2 = (i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? new ShadowStyles(new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(Color.f25715b.a())), null, 2, null), Dp.g(10), Dp.g(0), Dp.g(3), null) : shadowStyles;
        MaskShape maskShape2 = (i4 & Function.MAX_NARGS) != 0 ? MaskShape.Circle.INSTANCE : maskShape;
        if (ComposerKt.M()) {
            ComposerKt.U(971508494, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.previewIconComponentStyle (PreviewHelpers.kt:261)");
        }
        IconComponentStyle iconComponentStyle = new IconComponentStyle("https://example.com", "test-icon-name", new IconComponent.Formats("test-webp"), z3, size, colorStyles3, paddingValuesA, paddingValuesA2, new IconComponentStyle.Background(colorStyles4, maskShape2, borderStyles2, shadowStyles2), null, null, null, null, CollectionsKt.emptyList(), 5120, null);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return iconComponentStyle;
    }

    public static final /* synthetic */ ImageLoader previewImageLoader(final int i3, Composer composer, int i4, int i5) {
        composer.a0(-1745938743);
        boolean z2 = true;
        if ((i5 & 1) != 0) {
            i3 = R.drawable.f92317android;
        }
        if (ComposerKt.M()) {
            ComposerKt.U(-1745938743, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.components.previewImageLoader (PreviewHelpers.kt:287)");
        }
        final Context context = (Context) composer.q(AndroidCompositionLocals_androidKt.g());
        ImageLoader.Builder builder = new ImageLoader.Builder(context);
        ComponentRegistry.Builder builder2 = new ComponentRegistry.Builder();
        composer.a0(1695006622);
        boolean zI = composer.I(context);
        if ((((i4 & 14) ^ 6) <= 4 || !composer.e(i3)) && (i4 & 6) != 4) {
            z2 = false;
        }
        boolean z3 = zI | z2;
        Object objG = composer.G();
        if (z3 || objG == Composer.f23746a.a()) {
            objG = new Interceptor() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.PreviewHelpersKt$previewImageLoader$1$1$1
                @Override // coil.intercept.Interceptor
                public final Object intercept(Interceptor.Chain chain, Continuation<? super ImageResult> continuation) {
                    Drawable drawable = context.getDrawable(i3);
                    Intrinsics.checkNotNull(drawable);
                    return new SuccessResult(drawable, chain.b(), DataSource.MEMORY, null, null, false, false, 120, null);
                }
            };
            composer.w(objG);
        }
        composer.U();
        builder2.c((Interceptor) objG);
        ImageLoader imageLoaderB = builder.c(builder2.f()).b();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return imageLoaderB;
    }

    /* JADX INFO: renamed from: previewStackComponentStyle-7SJ-wSw, reason: not valid java name */
    public static final StackComponentStyle m698previewStackComponentStyle7SJwSw(List<? extends ComponentStyle> children, Dimension dimension, boolean z2, Size size, float f3, BackgroundStyles background, PaddingValues padding, PaddingValues margin, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, BadgeStyle badgeStyle, Orientation orientation, Date date, CountdownComponent.CountFrom countFrom) {
        Intrinsics.checkNotNullParameter(children, "children");
        Intrinsics.checkNotNullParameter(dimension, "dimension");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(background, "background");
        Intrinsics.checkNotNullParameter(padding, "padding");
        Intrinsics.checkNotNullParameter(margin, "margin");
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(countFrom, "countFrom");
        return new StackComponentStyle(children, dimension, z2, size, f3, background, padding, margin, shape, borderStyles, shadowStyles, badgeStyle, orientation, null, null, null, null, date, countFrom, CollectionsKt.emptyList(), false, false, false, false, 15810560, null);
    }

    public static final /* synthetic */ TextComponentStyle previewTextComponentStyle(String text, ColorStyles color, int i3, FontWeight fontWeight, FontSpec fontSpec, HorizontalAlignment textAlign, HorizontalAlignment horizontalAlignment, ColorStyles colorStyles, boolean z2, Size size, Padding padding, Padding margin, Integer num, Date date, CountdownComponent.CountFrom countFrom, List overrides) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        Intrinsics.checkNotNullParameter(textAlign, "textAlign");
        Intrinsics.checkNotNullParameter(horizontalAlignment, "horizontalAlignment");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(padding, "padding");
        Intrinsics.checkNotNullParameter(margin, "margin");
        Intrinsics.checkNotNullParameter(countFrom, "countFrom");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        androidx.compose.ui.text.font.FontWeight fontWeight2 = FontKt.toFontWeight(fontWeight);
        String strM613constructorimpl = LocaleId.m613constructorimpl("en_US");
        return new TextComponentStyle(NonEmptyMapKt.nonEmptyMapOf(TuplesKt.a(LocaleId.m612boximpl(strM613constructorimpl), text), new Pair[0]), color, i3, fontWeight2, fontSpec, TextAlign.h(AlignmentKt.toTextAlign(textAlign)), AlignmentKt.toAlignment(horizontalAlignment), colorStyles, z2, size, com.revenuecat.purchases.ui.revenuecatui.components.ktx.PaddingKt.toPaddingValues(padding), com.revenuecat.purchases.ui.revenuecatui.components.ktx.PaddingKt.toPaddingValues(margin), null, null, num, null, date, countFrom, NonEmptyMapKt.nonEmptyMapOf(TuplesKt.a(LocaleId.m612boximpl(strM613constructorimpl), variableLocalizationKeysForEnUs()), new Pair[0]), overrides, null, 1089536, null);
    }

    public static /* synthetic */ TextComponentStyle previewTextComponentStyle$default(String str, ColorStyles colorStyles, int i3, FontWeight fontWeight, FontSpec fontSpec, HorizontalAlignment horizontalAlignment, HorizontalAlignment horizontalAlignment2, ColorStyles colorStyles2, boolean z2, Size size, Padding padding, Padding padding2, Integer num, Date date, CountdownComponent.CountFrom countFrom, List list, int i4, Object obj) {
        return previewTextComponentStyle(str, (i4 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(Color.f25715b.a())), null, 2, null) : colorStyles, (i4 & 4) != 0 ? 15 : i3, (i4 & 8) != 0 ? FontWeight.REGULAR : fontWeight, (i4 & 16) != 0 ? null : fontSpec, (i4 & 32) != 0 ? HorizontalAlignment.CENTER : horizontalAlignment, (i4 & 64) != 0 ? HorizontalAlignment.CENTER : horizontalAlignment2, (i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : colorStyles2, (i4 & Function.MAX_NARGS) != 0 ? true : z2, (i4 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE) : size, (i4 & 1024) != 0 ? Padding.Companion.getZero() : padding, (i4 & 2048) != 0 ? Padding.Companion.getZero() : padding2, (i4 & 4096) != 0 ? null : num, (i4 & Utility.DEFAULT_STREAM_BUFFER_SIZE) == 0 ? date : null, (i4 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : countFrom, (i4 & 32768) != 0 ? CollectionsKt.emptyList() : list);
    }

    public static final UiConfig previewUiConfig(UiConfig.AppConfig app, Map<LocaleId, ? extends Map<VariableLocalizationKey, String>> localizations, UiConfig.VariableConfig variableConfig) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(localizations, "localizations");
        Intrinsics.checkNotNullParameter(variableConfig, "variableConfig");
        return new UiConfig(app, localizations, variableConfig, (Map) null, 8, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UiConfig previewUiConfig$default(UiConfig.AppConfig appConfig, Map map, UiConfig.VariableConfig variableConfig, int i3, Object obj) {
        int i4 = 3;
        Map map2 = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        Object[] objArr5 = 0;
        if ((i3 & 1) != 0) {
            appConfig = new UiConfig.AppConfig(map2, (Map) (objArr5 == true ? 1 : 0), i4, (DefaultConstructorMarker) (objArr4 == true ? 1 : 0));
        }
        if ((i3 & 2) != 0) {
            map = MapsKt.mapOf(TuplesKt.a(LocaleId.m612boximpl(LocaleId.m613constructorimpl("en_US")), variableLocalizationKeysForEnUs()));
        }
        if ((i3 & 4) != 0) {
            variableConfig = new UiConfig.VariableConfig((Map) (objArr3 == true ? 1 : 0), (Map) (objArr2 == true ? 1 : 0), i4, (DefaultConstructorMarker) (objArr == true ? 1 : 0));
        }
        return previewUiConfig(appConfig, map, variableConfig);
    }

    public static final /* synthetic */ Result validatePaywallComponentsDataOrNullForPreviews(Offering offering, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(offering, "<this>");
        composer.a0(1679297795);
        if (ComposerKt.M()) {
            ComposerKt.U(1679297795, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.validatePaywallComponentsDataOrNullForPreviews (PreviewHelpers.kt:306)");
        }
        Resources resources = ((Context) composer.q(AndroidCompositionLocals_androidKt.g())).getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "LocalContext.current.resources");
        Result<PaywallValidationResult.Components, NonEmptyList<PaywallValidationError>> resultValidatePaywallComponentsDataOrNull = OfferingToStateMapperKt.validatePaywallComponentsDataOrNull(offering, new PaywallResourceProvider("RevenueCatUI Previews", BuildConfig.LIBRARY_PACKAGE_NAME, resources));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return resultValidatePaywallComponentsDataOrNull;
    }

    public static final /* synthetic */ NonEmptyMap variableLocalizationKeysForEnUs() {
        VariableLocalizationKey[] variableLocalizationKeyArrValues = VariableLocalizationKey.values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(variableLocalizationKeyArrValues.length), 16));
        for (VariableLocalizationKey variableLocalizationKey : variableLocalizationKeyArrValues) {
            String str = "day";
            switch (WhenMappings.$EnumSwitchMapping$0[variableLocalizationKey.ordinal()]) {
                case 1:
                    str = "annual";
                    break;
                case 2:
                case 41:
                    str = "yr";
                    break;
                case 3:
                    str = "annually";
                    break;
                case 4:
                    str = "daily";
                    break;
                case 5:
                case 6:
                    break;
                case 7:
                    str = "free";
                    break;
                case 8:
                    str = "month";
                    break;
                case 9:
                    str = "mo";
                    break;
                case 10:
                    str = "monthly";
                    break;
                case 11:
                    str = "lifetime";
                    break;
                case 12:
                case 13:
                case 15:
                case 16:
                    str = "%d days";
                    break;
                case 14:
                case 17:
                    str = "%d day";
                    break;
                case 18:
                case 19:
                case 21:
                case 22:
                    str = "%d months";
                    break;
                case 20:
                case 23:
                    str = "%d month";
                    break;
                case 24:
                case 25:
                case 27:
                case 28:
                    str = "%d weeks";
                    break;
                case 26:
                case 29:
                    str = "%d week";
                    break;
                case 30:
                case 31:
                case 33:
                case 34:
                    str = "%d years";
                    break;
                case 32:
                case 35:
                    str = "%d year";
                    break;
                case 36:
                    str = "%d%%";
                    break;
                case 37:
                    str = "week";
                    break;
                case 38:
                    str = "wk";
                    break;
                case 39:
                    str = "weekly";
                    break;
                case 40:
                    str = "year";
                    break;
                case 42:
                    str = "yearly";
                    break;
                case 43:
                    str = "%dd";
                    break;
                case 44:
                    str = "%dwk";
                    break;
                case 45:
                    str = "%dmo";
                    break;
                case 46:
                    str = "%dyr";
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            linkedHashMap.put(variableLocalizationKey, str);
        }
        NonEmptyMap nonEmptyMapOrNull = NonEmptyMapKt.toNonEmptyMapOrNull(linkedHashMap);
        Intrinsics.checkNotNull(nonEmptyMapOrNull);
        return nonEmptyMapOrNull;
    }
}
