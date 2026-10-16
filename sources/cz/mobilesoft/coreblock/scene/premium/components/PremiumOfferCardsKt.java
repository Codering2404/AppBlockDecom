package cz.mobilesoft.coreblock.scene.premium.components;

import android.content.Context;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.FlowLayoutKt;
import androidx.compose.foundation.layout.FlowRowScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO;
import cz.mobilesoft.coreblock.scene.premium.enums.PremiumOptionPeriod;
import cz.mobilesoft.coreblock.util.ExternalLinksHelper;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeDropdownItem;
import cz.mobilesoft.coreblock.view.compose.ComposeDropdownKt;
import cz.mobilesoft.coreblock.view.compose.IconCircleBackgroundKt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.xmlpull.v1.XmlPullParserException;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class PremiumOfferCardsKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f112571a;

        static {
            int[] iArr = new int[PremiumOptionPeriod.values().length];
            try {
                iArr[PremiumOptionPeriod.Yearly.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PremiumOptionPeriod.Monthly.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PremiumOptionPeriod.Lifetime.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f112571a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(PremiumOptionDTO premiumOptionDTO, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, Composer composer, int i3) throws XmlPullParserException, IOException {
        float f3;
        Modifier.Companion companion;
        float f4;
        char c3;
        int i4;
        String strB;
        String strB2;
        Modifier.Companion companion2;
        float f5;
        int i5;
        int iS;
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1305343282, i3, -1, "cz.mobilesoft.coreblock.scene.premium.components.PremiumOfferCardSelectable.<anonymous> (PremiumOfferCards.kt:250)");
            }
            float fG = Dp.g(24);
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.HorizontalOrVertical horizontalOrVerticalB = arrangement.b();
            Modifier.Companion companion3 = Modifier.b8;
            float f6 = 16;
            Modifier modifierH = SizeKt.h(PaddingKt.m(companion3, Dp.g(f6), Dp.g(f6), 0.0f, 0.0f, 12, null), 0.0f, 1, null);
            Alignment.Companion companion4 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(horizontalOrVerticalB, companion4.k(), composer, 6);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierH);
            ComposeUiNode.Companion companion5 = ComposeUiNode.f8;
            Function0 function0A = companion5.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A);
            } else {
                composer.v();
            }
            Composer composerA = Updater.a(composer);
            Updater.e(composerA, measurePolicyA, companion5.e());
            Updater.e(composerA, compositionLocalMapU, companion5.g());
            Function2 function2B = companion5.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion5.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            Alignment.Vertical verticalI = companion4.i();
            Modifier modifierH2 = SizeKt.h(PaddingKt.m(companion3, 0.0f, 0.0f, Dp.g(f6), 0.0f, 11, null), 0.0f, 1, null);
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), verticalI, composer, 48);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierH2);
            Function0 function0A2 = companion5.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A2);
            } else {
                composer.v();
            }
            Composer composerA2 = Updater.a(composer);
            Updater.e(composerA2, measurePolicyB, companion5.e());
            Updater.e(composerA2, compositionLocalMapU2, companion5.g());
            Function2 function2B2 = companion5.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion5.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            if (z3) {
                composer.a0(1312349661);
                companion = companion3;
                f4 = f6;
                IconCircleBackgroundKt.c(null, fG, 0.0f, VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.f95555q1, composer, 6), Color.f25715b.l(), ComposeColorsKt.j(composer, 0).b(), null, composer, 24624, 69);
                f3 = fG;
                composer.U();
                c3 = 2;
            } else {
                f3 = fG;
                companion = companion3;
                f4 = f6;
                composer.a0(1312687623);
                c3 = 2;
                BoxKt.a(BorderKt.e(SizeKt.v(companion, f3), BorderStrokeKt.a(Dp.g(2), Color.f25715b.e()), RoundedCornerShapeKt.g()), composer, 0);
                composer.U();
            }
            float f7 = f3;
            Modifier.Companion companion6 = companion;
            TextKt.c(StringResources_androidKt.b(premiumOptionDTO.j().getTitleShort(), composer, 0), RowScope.c(rowScopeInstance, PaddingKt.m(companion, Dp.g(f4), 0.0f, 0.0f, 0.0f, 14, null), 1.0f, false, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).g(), composer, 0, 0, 65532);
            Composer composer2 = composer;
            String strD = premiumOptionDTO.d();
            if (strD == null) {
                strD = premiumOptionDTO.a();
            }
            if (z2 && premiumOptionDTO.d() == null) {
                composer2.a0(1313542138);
                String strI = premiumOptionDTO.i();
                if (strI == null) {
                    composer2.a0(1313542137);
                } else {
                    composer2.a0(1313542138);
                    String strC = StringResources_androidKt.c(R.string.kq, new Object[]{strI}, composer2, 0);
                    List listV0 = StringsKt.V0(strC, new String[]{"/"}, false, 0, 6, null);
                    if (listV0.size() == 2) {
                        composer2.a0(1153526033);
                        AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
                        if (Intrinsics.areEqual(listV0.get(0), strI)) {
                            builder.l((String) listV0.get(0));
                            iS = builder.s(new SpanStyle(0L, TextUnitKt.i(13), FontWeight.f29233b.j(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65529, (DefaultConstructorMarker) null));
                            try {
                                builder.l(" / ");
                                builder.l((String) listV0.get(1));
                                Unit unit = Unit.f139807a;
                            } finally {
                            }
                        } else {
                            builder.l((String) listV0.get(1));
                            builder.l(" / ");
                            iS = builder.s(new SpanStyle(0L, TextUnitKt.i(13), FontWeight.f29233b.j(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65529, (DefaultConstructorMarker) null));
                            try {
                                builder.l((String) listV0.get(0));
                                Unit unit2 = Unit.f139807a;
                                builder.q(iS);
                            } finally {
                            }
                        }
                        TextKt.d(builder.t(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, ComposeTypographyKt.g(composer2, 0).g(), composer, 0, 0, 131070);
                        composer2 = composer;
                        composer2.U();
                    } else {
                        composer2.a0(1154661532);
                        TextKt.c(strC, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).g(), composer, 0, 0, 65534);
                        composer2 = composer;
                        composer2.U();
                    }
                    Unit unit3 = Unit.f139807a;
                }
                composer2.U();
                composer2.U();
            } else {
                composer2.a0(1315128005);
                TextKt.c(strD, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).g(), composer, 0, 0, 65534);
                composer2 = composer;
                composer2.U();
                Unit unit4 = Unit.f139807a;
            }
            composer2.y();
            float f8 = 4;
            SpacerKt.a(SizeKt.i(companion6, Dp.g(f8)), composer2, 6);
            if (premiumOptionDTO.j() == PremiumOptionPeriod.Yearly && z2) {
                composer2.a0(1256082399);
                i4 = 0;
                strB2 = StringResources_androidKt.b(R.string.l3, composer2, 0);
                composer2.U();
            } else {
                i4 = 0;
                composer2.a0(1256221899);
                Integer billedPeriod = premiumOptionDTO.j().getBilledPeriod();
                if (billedPeriod == null) {
                    composer2.a0(1256221898);
                    composer2.U();
                    strB = null;
                } else {
                    composer2.a0(1256221899);
                    strB = StringResources_androidKt.b(billedPeriod.intValue(), composer2, 0);
                    composer2.U();
                }
                composer2.U();
                strB2 = strB;
            }
            Alignment.Vertical verticalI2 = companion4.i();
            Modifier modifierM = PaddingKt.m(SizeKt.h(companion6, 0.0f, 1, null), Dp.g(Dp.g(f4) + f7), 0.0f, Dp.g(f4), 0.0f, 10, null);
            MeasurePolicy measurePolicyB2 = RowKt.b(arrangement.g(), verticalI2, composer2, 48);
            int iA3 = ComposablesKt.a(composer2, i4);
            CompositionLocalMap compositionLocalMapU3 = composer2.u();
            Modifier modifierF3 = ComposedModifierKt.f(composer2, modifierM);
            Function0 function0A3 = companion5.a();
            if (composer2.m() == null) {
                ComposablesKt.c();
            }
            composer2.L();
            if (composer2.i()) {
                composer2.P(function0A3);
            } else {
                composer2.v();
            }
            Composer composerA3 = Updater.a(composer2);
            Updater.e(composerA3, measurePolicyB2, companion5.e());
            Updater.e(composerA3, compositionLocalMapU3, companion5.g());
            Function2 function2B3 = companion5.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion5.f());
            if (strB2 == null) {
                composer2.a0(-710043765);
                composer2.U();
                f5 = f8;
                companion2 = companion6;
            } else {
                composer2.a0(-710043764);
                companion2 = companion6;
                f5 = f8;
                TextKt.c(strB2, RowScope.c(rowScopeInstance, companion6, 1.0f, false, 2, null), ComposeColorsKt.j(composer2, i4).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, i4).b(), composer, 0, 0, 65528);
                composer2 = composer;
                Unit unit5 = Unit.f139807a;
                composer2.U();
            }
            if (premiumOptionDTO.d() != null) {
                composer2.a0(-709655427);
                TextKt.c(premiumOptionDTO.a(), null, ComposeColorsKt.j(composer2, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.e(ComposeTypographyKt.g(composer2, 0).b(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, TextDecoration.f29625b.b(), null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16773119, null), composer, 0, 0, 65530);
                composer2 = composer;
                composer2.U();
            } else {
                if (z2) {
                    composer2.a0(-723971227);
                } else {
                    composer2.a0(-438521586);
                    String strI2 = premiumOptionDTO.i();
                    if (strI2 == null) {
                        composer2.a0(-709267277);
                    } else {
                        composer2.a0(-709267276);
                        TextKt.c(StringResources_androidKt.c(R.string.kq, new Object[]{strI2}, composer2, 0), null, ComposeColorsKt.j(composer2, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).b(), composer, 0, 0, 65530);
                        composer2 = composer;
                        Unit unit6 = Unit.f139807a;
                    }
                    composer2.U();
                }
                composer2.U();
            }
            composer2.y();
            composer2.a0(40574444);
            final ArrayList arrayList = new ArrayList();
            String strN = premiumOptionDTO.n();
            if (strN == null) {
                composer2.a0(-1389849978);
                composer2.U();
                i5 = 0;
            } else {
                composer2.a0(-1389849977);
                String upperCase = strN.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                i5 = 0;
                arrayList.add(TuplesKt.a(upperCase, Color.n(ComposeColorsKt.j(composer2, 0).A())));
                composer2.U();
            }
            if (premiumOptionDTO.b() != null) {
                composer2.a0(-1389694543);
                String upperCase2 = StringResources_androidKt.c(R.string.oc, new Object[]{premiumOptionDTO.b()}, composer2, i5).toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
                arrayList.add(TuplesKt.a(upperCase2, Color.n(ComposeColorsKt.j(composer2, i5).Y())));
                composer2.U();
            } else {
                if (z4) {
                    composer2.a0(-1389499305);
                    String upperCase3 = StringResources_androidKt.b(R.string.h3, composer2, i5).toUpperCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(upperCase3, "toUpperCase(...)");
                    arrayList.add(TuplesKt.a(upperCase3, Color.n(ComposeColorsKt.j(composer2, i5).Y())));
                } else {
                    composer2.a0(-1405049494);
                }
                composer2.U();
            }
            if (z5) {
                composer2.a0(-1389337764);
                String upperCase4 = StringResources_androidKt.b(R.string.f95863z, composer2, i5).toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase4, "toUpperCase(...)");
                arrayList.add(TuplesKt.a(upperCase4, Color.n(ComposeColorsKt.j(composer2, i5).b())));
            } else {
                composer2.a0(-1405049494);
            }
            composer2.U();
            composer2.U();
            if (arrayList.isEmpty()) {
                composer2.a0(1259799640);
                SpacerKt.a(SizeKt.i(companion2, Dp.g(f4)), composer2, 6);
                composer2.U();
            } else {
                composer2.a0(1258568320);
                Alignment.Vertical verticalA = companion4.a();
                Modifier.Companion companion7 = companion2;
                Modifier modifierH3 = SizeKt.h(PaddingKt.m(companion7, Dp.g(Dp.g(f4) + f7), 0.0f, 0.0f, 0.0f, 14, null), 0.0f, 1, null);
                MeasurePolicy measurePolicyB3 = RowKt.b(arrangement.g(), verticalA, composer2, 48);
                int iA4 = ComposablesKt.a(composer2, i5);
                CompositionLocalMap compositionLocalMapU4 = composer2.u();
                Modifier modifierF4 = ComposedModifierKt.f(composer2, modifierH3);
                Function0 function0A4 = companion5.a();
                if (composer2.m() == null) {
                    ComposablesKt.c();
                }
                composer2.L();
                if (composer2.i()) {
                    composer2.P(function0A4);
                } else {
                    composer2.v();
                }
                Composer composerA4 = Updater.a(composer2);
                Updater.e(composerA4, measurePolicyB3, companion5.e());
                Updater.e(composerA4, compositionLocalMapU4, companion5.g());
                Function2 function2B4 = companion5.b();
                if (composerA4.i() || !Intrinsics.areEqual(composerA4.G(), Integer.valueOf(iA4))) {
                    composerA4.w(Integer.valueOf(iA4));
                    composerA4.p(Integer.valueOf(iA4), function2B4);
                }
                Updater.e(composerA4, modifierF4, companion5.f());
                float f9 = 8;
                FlowLayoutKt.d(PaddingKt.m(RowScope.c(rowScopeInstance, companion7, 1.0f, false, 2, null), 0.0f, Dp.g(f9), 0.0f, Dp.g(f4), 5, null), arrangement.o(Dp.g(f9)), arrangement.o(Dp.g(f9)), null, 0, 0, ComposableLambdaKt.e(1015701876, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.premium.components.x1
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return PremiumOfferCardsKt.B(arrayList, (FlowRowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer2, 54), composer, 1573296, 56);
                composer2 = composer;
                if (z6) {
                    composer2.a0(666741649);
                    n(PaddingKt.m(companion7, 0.0f, 0.0f, Dp.g(f5), Dp.g(f5), 3, null), true, composer2, 54, i5);
                } else {
                    composer2.a0(649853097);
                }
                composer2.U();
                composer2.y();
                composer2.U();
            }
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(List list, FlowRowScope FlowRow, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(FlowRow, "$this$FlowRow");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1015701876, i3, -1, "cz.mobilesoft.coreblock.scene.premium.components.PremiumOfferCardSelectable.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PremiumOfferCards.kt:401)");
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                t(null, (String) pair.a(), 0L, ((Color) pair.b()).B(), false, null, composer, 0, 53);
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(Modifier modifier, PremiumOptionDTO premiumOptionDTO, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, Function0 function0, int i3, int i4, Composer composer, int i5) {
        z(modifier, premiumOptionDTO, z2, z3, z4, z5, z6, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:92:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void D(androidx.compose.ui.Modifier r63, final cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO r64, boolean r65, androidx.compose.runtime.Composer r66, final int r67, final int r68) {
        /*
            Method dump skipped, instruction units count: 693
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.premium.components.PremiumOfferCardsKt.D(androidx.compose.ui.Modifier, cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(Modifier modifier, PremiumOptionDTO premiumOptionDTO, boolean z2, int i3, int i4, Composer composer, int i5) {
        D(modifier, premiumOptionDTO, z2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final void F(final PremiumOptionDTO premiumOptionDTO, final boolean z2, Composer composer, final int i3) {
        int i4;
        String str;
        int i5;
        Modifier.Companion companion;
        String strC;
        Composer composerK = composer.k(-2003949775);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(premiumOptionDTO) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.b(z2) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2003949775, i4, -1, "cz.mobilesoft.coreblock.scene.premium.components.PriceContent (PremiumOfferCards.kt:201)");
            }
            Alignment.Vertical verticalI = Alignment.f25072a.i();
            Modifier.Companion companion2 = Modifier.b8;
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), verticalI, composerK, 48);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, companion2);
            ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
            Function0 function0A = companion3.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A);
            } else {
                composerK.v();
            }
            Composer composerA = Updater.a(composerK);
            Updater.e(composerA, measurePolicyB, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            String strD = premiumOptionDTO.d();
            if (strD == null) {
                strD = premiumOptionDTO.a();
            }
            if (premiumOptionDTO.d() != null) {
                composerK.a0(1562664547);
                str = strD;
                companion = companion2;
                i5 = 0;
                TextKt.c(premiumOptionDTO.a(), PaddingKt.m(companion2, 0.0f, 0.0f, Dp.g(8), 0.0f, 11, null), ComposeColorsKt.j(composerK, 0).k(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.e(ComposeTypographyKt.g(composerK, 0).i(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, TextDecoration.f29625b.b(), null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16773119, null), composerK, 48, 0, 65528);
                composerK = composerK;
            } else {
                str = strD;
                i5 = 0;
                companion = companion2;
                composerK.a0(1554345325);
            }
            composerK.U();
            if (z2 && premiumOptionDTO.d() == null) {
                composerK.a0(1563063176);
                String strI = premiumOptionDTO.i();
                if (strI == null) {
                    composerK.a0(1563086642);
                    composerK.U();
                    strC = null;
                } else {
                    composerK.a0(1563086643);
                    strC = StringResources_androidKt.c(R.string.kq, new Object[]{strI}, composerK, i5);
                    composerK.U();
                }
                if (strC == null) {
                    strC = str;
                }
                composerK.U();
            } else {
                composerK.a0(1563247223);
                composerK.U();
                strC = str;
            }
            Composer composer2 = composerK;
            TextKt.c(strC, null, ComposeColorsKt.j(composerK, i5).b(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, i5).g(), composer2, 0, 0, 65530);
            composerK = composer2;
            SpacerKt.a(SizeKt.i(companion, Dp.g(2)), composerK, 6);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.components.b2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PremiumOfferCardsKt.G(premiumOptionDTO, z2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(PremiumOptionDTO premiumOptionDTO, boolean z2, int i3, Composer composer, int i4) {
        F(premiumOptionDTO, z2, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void n(Modifier modifier, final boolean z2, Composer composer, final int i3, final int i4) throws XmlPullParserException, IOException {
        Modifier modifier2;
        int i5;
        final Modifier modifier3;
        Composer composerK = composer.k(-1951633314);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
            modifier2 = modifier;
        } else if ((i3 & 6) == 0) {
            modifier2 = modifier;
            i5 = (composerK.Z(modifier2) ? 4 : 2) | i3;
        } else {
            modifier2 = modifier;
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.b(z2) ? 32 : 16;
        }
        if (composerK.r((i5 & 19) != 18, i5 & 1)) {
            Modifier modifier4 = i6 != 0 ? Modifier.b8 : modifier2;
            if (ComposerKt.M()) {
                ComposerKt.U(-1951633314, i5, -1, "cz.mobilesoft.coreblock.scene.premium.components.MoreButton (PremiumOfferCards.kt:494)");
            }
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifier4);
            ComposeUiNode.Companion companion = ComposeUiNode.f8;
            Function0 function0A = companion.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A);
            } else {
                composerK.v();
            }
            Composer composerA = Updater.a(composerK);
            Updater.e(composerA, measurePolicyG, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            Object objG = composerK.G();
            Composer.Companion companion2 = Composer.f23746a;
            if (objG == companion2.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            String strB = StringResources_androidKt.b(R.string.Fj, composerK, 0);
            Color colorN = Color.n(ComposeColorsKt.j(composerK, 0).q());
            boolean zI = composerK.I(context);
            Object objG2 = composerK.G();
            if (zI || objG2 == companion2.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.components.c2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PremiumOfferCardsKt.o(context);
                    }
                };
                composerK.w(objG2);
            }
            ComposeDropdownKt.j(mutableState, null, CollectionsKt.listOf(new ComposeDropdownItem(strB, colorN, null, false, null, null, null, null, (Function0) objG2, 252, null)), composerK, 54);
            ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, z2 ? R.drawable.K3 : R.drawable.L3, composerK, 6);
            long jQ = ComposeColorsKt.j(composerK, 0).q();
            Object objG3 = composerK.G();
            if (objG3 == companion2.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.components.d2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PremiumOfferCardsKt.p(mutableState);
                    }
                };
                composerK.w(objG3);
            }
            modifier3 = modifier4;
            ComposeButtonsKt.q0(null, imageVectorB, null, false, 0.0f, 0.0f, jQ, null, (Function0) objG3, composerK, 100663296, 189);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.components.e2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PremiumOfferCardsKt.q(modifier3, z2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(Context context) {
        ExternalLinksHelper.f127866a.g(context);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(MutableState mutableState) {
        mutableState.setValue(Boolean.TRUE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(Modifier modifier, boolean z2, int i3, int i4, Composer composer, int i5) throws XmlPullParserException, IOException {
        n(modifier, z2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final void r(final boolean z2, final int i3, final PremiumOptionDTO premiumOptionDTO, Composer composer, final int i4) {
        int i5;
        String strB;
        Composer composerK = composer.k(-1069880502);
        if ((i4 & 6) == 0) {
            i5 = (composerK.b(z2) ? 4 : 2) | i4;
        } else {
            i5 = i4;
        }
        if ((i4 & 48) == 0) {
            i5 |= composerK.e(i3) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            i5 |= composerK.Z(premiumOptionDTO) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i5 & 147) != 146, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1069880502, i5, -1, "cz.mobilesoft.coreblock.scene.premium.components.OptionBilledPeriod (PremiumOfferCards.kt:165)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierH);
            ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
            Function0 function0A = companion3.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A);
            } else {
                composerK.v();
            }
            Composer composerA = Updater.a(composerK);
            Updater.e(composerA, measurePolicyG, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            if (z2) {
                composerK.a0(-168502161);
                strB = StringResources_androidKt.b(R.string.l3, composerK, 0);
                composerK.U();
            } else {
                composerK.a0(-168429900);
                strB = StringResources_androidKt.b(i3, composerK, (i5 >> 3) & 14);
                composerK.U();
            }
            TextKt.c(strB, boxScopeInstance.f(companion, z2 ? companion2.e() : companion2.h()), ComposeColorsKt.j(composerK, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).b(), composerK, 0, 0, 65528);
            composerK = composerK;
            if (z2) {
                composerK.a0(-175495854);
            } else {
                composerK.a0(687321793);
                String strI = premiumOptionDTO.i();
                if (strI == null) {
                    composerK.a0(-167860896);
                } else {
                    composerK.a0(-167860895);
                    TextKt.c(StringResources_androidKt.c(R.string.kq, new Object[]{strI}, composerK, 0), boxScopeInstance.f(companion, companion2.f()), ComposeColorsKt.j(composerK, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).b(), composerK, 0, 0, 65528);
                    composerK = composerK;
                }
                composerK.U();
            }
            composerK.U();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.components.a2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PremiumOfferCardsKt.s(z2, i3, premiumOptionDTO, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(boolean z2, int i3, PremiumOptionDTO premiumOptionDTO, int i4, Composer composer, int i5) {
        r(z2, i3, premiumOptionDTO, composer, RecomposeScopeImplKt.a(i4 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:116:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void t(androidx.compose.ui.Modifier r35, final java.lang.String r36, long r37, final long r39, boolean r41, androidx.compose.runtime.MutableState r42, androidx.compose.runtime.Composer r43, final int r44, final int r45) {
        /*
            Method dump skipped, instruction units count: 521
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.premium.components.PremiumOfferCardsKt.t(androidx.compose.ui.Modifier, java.lang.String, long, long, boolean, androidx.compose.runtime.MutableState, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(MutableState mutableState, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (mutableState != null) {
            mutableState.setValue(Integer.valueOf((int) (it.a() & 4294967295L)));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(Modifier modifier, String str, long j3, long j4, boolean z2, MutableState mutableState, int i3, int i4, Composer composer, int i5) {
        t(modifier, str, j3, j4, z2, mutableState, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:128:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void w(androidx.compose.ui.Modifier r32, final cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO r33, final boolean r34, boolean r35, boolean r36, androidx.compose.runtime.Composer r37, final int r38, final int r39) {
        /*
            Method dump skipped, instruction units count: 750
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.premium.components.PremiumOfferCardsKt.w(androidx.compose.ui.Modifier, cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO, boolean, boolean, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(boolean z2, PremiumOptionDTO premiumOptionDTO, boolean z3, ColumnScope BorderedCard, Composer composer, int i3) throws XmlPullParserException, IOException {
        Intrinsics.checkNotNullParameter(BorderedCard, "$this$BorderedCard");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1913180126, i3, -1, "cz.mobilesoft.coreblock.scene.premium.components.PremiumOfferCardCentered.<anonymous>.<anonymous> (PremiumOfferCards.kt:105)");
            }
            Modifier.Companion companion = Modifier.b8;
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, companion);
            ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
            Function0 function0A = companion3.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A);
            } else {
                composer.v();
            }
            Composer composerA = Updater.a(composer);
            Updater.e(composerA, measurePolicyG, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            Modifier modifierH = SizeKt.h(PaddingKt.i(companion, Dp.g(16)), 0.0f, 1, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), companion2.g(), composer, 48);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierH);
            Function0 function0A2 = companion3.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A2);
            } else {
                composer.v();
            }
            Composer composerA2 = Updater.a(composer);
            Updater.e(composerA2, measurePolicyA, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            float f3 = 12;
            TextKt.c(StringResources_androidKt.b(premiumOptionDTO.j().getTitleLong(), composer, 0), PaddingKt.m(companion, 0.0f, Dp.g(f3), 0.0f, 0.0f, 13, null), ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).f(), composer, 48, 0, 65528);
            SpacerKt.a(SizeKt.i(companion, Dp.g(14)), composer, 6);
            F(premiumOptionDTO, z3, composer, 0);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
            Integer billedPeriod = premiumOptionDTO.j().getBilledPeriod();
            if (billedPeriod == null) {
                composer.a0(240633985);
            } else {
                composer.a0(240633986);
                r(z3, billedPeriod.intValue(), premiumOptionDTO, composer, 0);
            }
            composer.U();
            composer.y();
            if (z2) {
                composer.a0(1308665599);
                float f4 = 6;
                n(PaddingKt.m(boxScopeInstance.f(companion, companion2.n()), 0.0f, Dp.g(f4), Dp.g(f4), 0.0f, 9, null), false, composer, 48, 0);
            } else {
                composer.a0(1302612198);
            }
            composer.U();
            composer.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(Modifier modifier, PremiumOptionDTO premiumOptionDTO, boolean z2, boolean z3, boolean z4, int i3, int i4, Composer composer, int i5) {
        w(modifier, premiumOptionDTO, z2, z3, z4, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:109:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void z(androidx.compose.ui.Modifier r24, final cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO r25, final boolean r26, boolean r27, boolean r28, final boolean r29, boolean r30, final kotlin.jvm.functions.Function0 r31, androidx.compose.runtime.Composer r32, final int r33, final int r34) {
        /*
            Method dump skipped, instruction units count: 435
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.premium.components.PremiumOfferCardsKt.z(androidx.compose.ui.Modifier, cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO, boolean, boolean, boolean, boolean, boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }
}
