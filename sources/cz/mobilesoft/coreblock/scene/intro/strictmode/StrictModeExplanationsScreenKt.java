package cz.mobilesoft.coreblock.scene.intro.strictmode;

import android.content.Context;
import android.text.Html;
import android.text.Spanned;
import android.text.style.UnderlineSpan;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.pager.PagerKt;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.pager.PagerStateKt;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.StrictModeOnboardingReviews;
import cz.mobilesoft.coreblock.scene.premium.components.PremiumReviewsCarouselCardKt;
import cz.mobilesoft.coreblock.util.compose.ComposableExtKt;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import cz.mobilesoft.coreblock.view.TextKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
public final class StrictModeExplanationsScreenKt {
    public static final void l(Modifier modifier, final int i3, final TextStyle defaultStyle, final long j3, final long j4, final long j5, float f3, Composer composer, final int i4, final int i5) {
        int i6;
        Composer composer2;
        final Modifier modifier2;
        final float f4;
        boolean z2;
        final MutableState mutableState;
        Intrinsics.checkNotNullParameter(defaultStyle, "defaultStyle");
        Composer composerK = composer.k(-1320047643);
        int i7 = i5 & 1;
        if (i7 != 0) {
            i6 = i4 | 6;
        } else if ((i4 & 6) == 0) {
            i6 = (composerK.Z(modifier) ? 4 : 2) | i4;
        } else {
            i6 = i4;
        }
        if ((i4 & 48) == 0) {
            i6 |= composerK.e(i3) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            i6 |= composerK.Z(defaultStyle) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 3072) == 0) {
            i6 |= composerK.f(j3) ? 2048 : 1024;
        }
        if ((i4 & 24576) == 0) {
            i6 |= composerK.f(j4) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        int i8 = i6;
        int i9 = (196608 & i4) == 0 ? i8 | (composerK.f(j5) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) : i8;
        int i10 = i5 & 64;
        if (i10 != 0) {
            i9 |= 1572864;
        } else if ((i4 & 1572864) == 0) {
            i9 |= composerK.c(f3) ? 1048576 : 524288;
        }
        int i11 = i9;
        if (composerK.r((599187 & i11) != 599186, i11 & 1)) {
            Modifier modifier3 = i7 != 0 ? Modifier.b8 : modifier;
            float fG = i10 != 0 ? Dp.g(1) : f3;
            if (ComposerKt.M()) {
                ComposerKt.U(-1320047643, i11, -1, "cz.mobilesoft.coreblock.scene.intro.strictmode.CustomStyledTextWithUnderline (StrictModeExplanationsScreen.kt:292)");
            }
            String string = ((Context) composerK.q(AndroidCompositionLocals_androidKt.g())).getString(i3);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            final Spanned spannedFromHtml = Html.fromHtml(string, 0);
            Intrinsics.checkNotNullExpressionValue(spannedFromHtml, "fromHtml(...)");
            String string2 = spannedFromHtml.toString();
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
                composerK.w(objG);
            }
            MutableState mutableState2 = (MutableState) objG;
            boolean Z = composerK.Z(string2) | ((i11 & 7168) == 2048) | ((57344 & i11) == 16384);
            Object objG2 = composerK.G();
            if (Z || objG2 == companion.a()) {
                AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
                builder.l(string2);
                z2 = true;
                builder.f(new SpanStyle(j3, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65534, (DefaultConstructorMarker) null), 0, string2.length());
                UnderlineSpan[] underlineSpanArr = (UnderlineSpan[]) spannedFromHtml.getSpans(0, spannedFromHtml.length(), UnderlineSpan.class);
                Intrinsics.checkNotNull(underlineSpanArr);
                for (UnderlineSpan underlineSpan : underlineSpanArr) {
                    builder.f(new SpanStyle(j4, 0L, FontWeight.f29233b.b(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65530, (DefaultConstructorMarker) null), spannedFromHtml.getSpanStart(underlineSpan), spannedFromHtml.getSpanEnd(underlineSpan));
                }
                objG2 = builder.t();
                composerK.w(objG2);
            } else {
                z2 = true;
            }
            AnnotatedString annotatedString = (AnnotatedString) objG2;
            Density density = (Density) composerK.q(CompositionLocalsKt.f());
            boolean z3 = (3670016 & i11) == 1048576 ? z2 : false;
            Object objG3 = composerK.G();
            if (z3 || objG3 == Composer.f23746a.a()) {
                objG3 = Float.valueOf(density.M1(fG));
                composerK.w(objG3);
            }
            final float fFloatValue = ((Number) objG3).floatValue();
            float f5 = fG;
            Modifier modifier4 = modifier3;
            TextStyle textStyleE = TextStyle.e(defaultStyle, j3, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null);
            boolean zI = composerK.I(spannedFromHtml) | composerK.c(fFloatValue) | ((i11 & 458752) == 131072 ? z2 : false);
            Object objG4 = composerK.G();
            if (zI || objG4 == Composer.f23746a.a()) {
                mutableState = mutableState2;
                Function1 function1 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.e0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StrictModeExplanationsScreenKt.m(mutableState, spannedFromHtml, fFloatValue, j5, (DrawScope) obj);
                    }
                };
                composerK.w(function1);
                objG4 = function1;
            } else {
                mutableState = mutableState2;
            }
            modifier2 = modifier4;
            Modifier modifierB = DrawModifierKt.b(modifier2, (Function1) objG4);
            Object objG5 = composerK.G();
            if (objG5 == Composer.f23746a.a()) {
                objG5 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.f0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StrictModeExplanationsScreenKt.n(mutableState, (TextLayoutResult) obj);
                    }
                };
                composerK.w(objG5);
            }
            composer2 = composerK;
            BasicTextKt.d(annotatedString, modifierB, textStyleE, (Function1) objG5, 0, false, 0, 0, null, null, null, composer2, 3072, 0, 2032);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            f4 = f5;
        } else {
            composer2 = composerK;
            composer2.Q();
            modifier2 = modifier;
            f4 = f3;
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.g0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StrictModeExplanationsScreenKt.o(modifier2, i3, defaultStyle, j3, j4, j5, f4, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(MutableState mutableState, Spanned spanned, float f3, long j3, DrawScope drawScope) {
        TextLayoutResult textLayoutResult;
        UnderlineSpan[] underlineSpanArr;
        int i3;
        int i4;
        int iQ;
        int iQ2;
        int i5;
        int i6;
        int i7;
        int i8;
        Spanned spanned2 = spanned;
        DrawScope drawBehind = drawScope;
        Intrinsics.checkNotNullParameter(drawBehind, "$this$drawBehind");
        TextLayoutResult textLayoutResult2 = (TextLayoutResult) mutableState.getValue();
        if (textLayoutResult2 != null) {
            int i9 = 0;
            UnderlineSpan[] underlineSpanArr2 = (UnderlineSpan[]) spanned2.getSpans(0, spanned2.length(), UnderlineSpan.class);
            Intrinsics.checkNotNull(underlineSpanArr2);
            int length = underlineSpanArr2.length;
            while (i9 < length) {
                UnderlineSpan underlineSpan = underlineSpanArr2[i9];
                int spanStart = spanned2.getSpanStart(underlineSpan);
                int spanEnd = spanned2.getSpanEnd(underlineSpan);
                try {
                    iQ = textLayoutResult2.q(spanStart);
                    iQ2 = textLayoutResult2.q(spanEnd - 1);
                } catch (Exception unused) {
                }
                if (iQ <= iQ2) {
                    while (true) {
                        int iU = textLayoutResult2.u(iQ);
                        int iO = textLayoutResult2.o(iQ, true);
                        int iMax = Math.max(spanStart, iU);
                        int iMin = Math.min(spanEnd, iO);
                        if (iMax < iMin) {
                            float fJ = textLayoutResult2.j(iMax, true);
                            float fJ2 = textLayoutResult2.j(iMin, true);
                            float fM = textLayoutResult2.m(iQ) + f3;
                            textLayoutResult = textLayoutResult2;
                            try {
                                i6 = spanStart;
                                underlineSpanArr = underlineSpanArr2;
                                i3 = length;
                                i5 = spanEnd;
                                i4 = i9;
                                i8 = iQ2;
                                i7 = iQ;
                                try {
                                    DrawScope.L0(drawBehind, j3, Offset.e((((long) Float.floatToRawIntBits(fM)) & 4294967295L) | (Float.floatToRawIntBits(fJ) << 32)), Offset.e((((long) Float.floatToRawIntBits(fM)) & 4294967295L) | (Float.floatToRawIntBits(fJ2) << 32)), f3, StrokeCap.f25935b.b(), null, 0.0f, null, 0, 480, null);
                                } catch (Exception unused2) {
                                }
                            } catch (Exception unused3) {
                                underlineSpanArr = underlineSpanArr2;
                                i3 = length;
                                i4 = i9;
                            }
                        } else {
                            textLayoutResult = textLayoutResult2;
                            underlineSpanArr = underlineSpanArr2;
                            i3 = length;
                            i4 = i9;
                            i5 = spanEnd;
                            i6 = spanStart;
                            i7 = iQ;
                            i8 = iQ2;
                        }
                        if (i7 != i8) {
                            iQ = i7 + 1;
                            textLayoutResult2 = textLayoutResult;
                            drawBehind = drawScope;
                            iQ2 = i8;
                            i9 = i4;
                            spanStart = i6;
                            spanEnd = i5;
                            underlineSpanArr2 = underlineSpanArr;
                            length = i3;
                        }
                    }
                    i9 = i4 + 1;
                    textLayoutResult2 = textLayoutResult;
                    spanned2 = spanned;
                    drawBehind = drawScope;
                    underlineSpanArr2 = underlineSpanArr;
                    length = i3;
                } else {
                    textLayoutResult = textLayoutResult2;
                }
                underlineSpanArr = underlineSpanArr2;
                i3 = length;
                i4 = i9;
                i9 = i4 + 1;
                textLayoutResult2 = textLayoutResult;
                spanned2 = spanned;
                drawBehind = drawScope;
                underlineSpanArr2 = underlineSpanArr;
                length = i3;
            }
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(MutableState mutableState, TextLayoutResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        mutableState.setValue(result);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(Modifier modifier, int i3, TextStyle textStyle, long j3, long j4, long j5, float f3, int i4, int i5, Composer composer, int i6) {
        l(modifier, i3, textStyle, j3, j4, j5, f3, composer, RecomposeScopeImplKt.a(i4 | 1), i5);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x0380  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:120:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009e  */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void p(final int r31, boolean r32, final int r33, final androidx.compose.ui.graphics.Color r34, final long r35, final long r37, androidx.compose.runtime.Composer r39, final int r40, final int r41) {
        /*
            Method dump skipped, instruction units count: 928
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeExplanationsScreenKt.p(int, boolean, int, androidx.compose.ui.graphics.Color, long, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(int i3, boolean z2, int i4, Color color, long j3, long j4, int i5, int i6, Composer composer, int i7) {
        p(i3, z2, i4, color, j3, j4, composer, RecomposeScopeImplKt.a(i5 | 1), i6);
        return Unit.f139807a;
    }

    public static final void r(final StrictModeOnboardingReviews item, Composer composer, final int i3) {
        Intrinsics.checkNotNullParameter(item, "item");
        Composer composerK = composer.k(-1101780755);
        int i4 = (i3 & 6) == 0 ? (composerK.e(item.ordinal()) ? 4 : 2) | i3 : i3;
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1101780755, i4, -1, "cz.mobilesoft.coreblock.scene.intro.strictmode.PagerReviewContent (StrictModeExplanationsScreen.kt:185)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierK = PaddingKt.k(SizeKt.h(companion, 0.0f, 1, null), Dp.g(f3), 0.0f, 2, null);
            Alignment.Companion companion2 = Alignment.f25072a;
            Alignment.Horizontal horizontalG = companion2.g();
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.h(), horizontalG, composerK, 48);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierK);
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
            Updater.e(composerA, measurePolicyA, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            float f4 = 8;
            Modifier modifierM = PaddingKt.m(companion, 0.0f, 0.0f, 0.0f, Dp.g(f4), 7, null);
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), companion2.l(), composerK, 0);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierM);
            Function0 function0A2 = companion3.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A2);
            } else {
                composerK.v();
            }
            Composer composerA2 = Updater.a(composerK);
            Updater.e(composerA2, measurePolicyB, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            composerK.a0(2078094990);
            for (int i5 = 0; i5 < 5; i5++) {
                IconKt.d(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.A5, composerK, 6), null, SizeKt.v(Modifier.b8, Dp.g(f3)), ComposeColorsKt.j(composerK, 0).b0(), composerK, 432, 0);
            }
            composerK.U();
            composerK.y();
            Modifier modifierK2 = SizeKt.k(PaddingKt.m(Modifier.b8, 0.0f, 0.0f, 0.0f, Dp.g(f4), 7, null), Dp.g(100), 0.0f, 2, null);
            int review = item.getReview();
            TextStyle textStyleB = ComposeTypographyKt.g(composerK, 0).b();
            long jL = ComposeColorsKt.j(composerK, 0).L();
            TextAlign.Companion companion4 = TextAlign.f29616b;
            TextKt.f(review, new Object[0], modifierK2, textStyleB, jL, TextAlign.h(companion4.a()), 0, null, composerK, 384, 192);
            androidx.compose.material3.TextKt.c(StringHelperExtKt.p(item.getAuthorName(), StringResources_androidKt.b(R.string.pt, composerK, 0), ", "), null, ComposeColorsKt.j(composerK, 0).O(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).d(), composerK, 0, 0, 65018);
            composerK = composerK;
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.x
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StrictModeExplanationsScreenKt.s(item, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(StrictModeOnboardingReviews strictModeOnboardingReviews, int i3, Composer composer, int i4) {
        r(strictModeOnboardingReviews, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void t(final java.lang.String r36, final java.lang.String r37, final java.util.List r38, final java.lang.String r39, boolean r40, boolean r41, final kotlin.jvm.functions.Function0 r42, androidx.compose.runtime.Composer r43, final int r44, final int r45) {
        /*
            Method dump skipped, instruction units count: 342
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeExplanationsScreenKt.t(java.lang.String, java.lang.String, java.util.List, java.lang.String, boolean, boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(final Function0 function0, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1546640816, i3, -1, "cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeExplanationsScreen.<anonymous> (StrictModeExplanationsScreen.kt:175)");
            }
            String strB = StringResources_androidKt.b(R.string.l8, composer, 0);
            boolean Z = composer.Z(function0);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.a0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StrictModeExplanationsScreenKt.v(function0);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.J(null, strB, false, false, null, (Function0) objG, composer, 0, 29);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(String str, String str2, List list, String str3, boolean z2, boolean z3, PaddingValues it, Composer composer, int i3) {
        ColumnScopeInstance columnScopeInstance;
        Intrinsics.checkNotNullParameter(it, "it");
        int i4 = (i3 & 6) == 0 ? i3 | (composer.Z(it) ? 4 : 2) : i3;
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1791035832, i4, -1, "cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeExplanationsScreen.<anonymous> (StrictModeExplanationsScreen.kt:90)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierG = ScrollKt.g(PaddingKt.k(PaddingKt.h(SizeKt.f(companion, 0.0f, 1, null), it), Dp.g(f3), 0.0f, 2, null), ScrollKt.c(0, composer, 0, 1), false, null, false, 14, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.g(), composer, 48);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierG);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
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
            Updater.e(composerA, measurePolicyA, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.f6666a;
            TextStyle textStyleE = TextStyle.e(ComposeTypographyKt.g(composer, 0).e(), 0L, TextUnitKt.i(28), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777213, null);
            long jL = ComposeColorsKt.j(composer, 0).L();
            TextAlign.Companion companion3 = TextAlign.f29616b;
            float f4 = 32;
            ColumnScopeInstance columnScopeInstance3 = columnScopeInstance2;
            androidx.compose.material3.TextKt.c(str, PaddingKt.m(companion, 0.0f, Dp.g(f4), 0.0f, 0.0f, 13, null), jL, 0L, null, null, null, 0L, null, TextAlign.h(companion3.a()), 0L, 0, false, 0, 0, null, textStyleE, composer, 48, 0, 65016);
            float f5 = 8;
            androidx.compose.material3.TextKt.c(str2, PaddingKt.m(companion, Dp.g(f3), Dp.g(f5), Dp.g(f3), 0.0f, 8, null), ComposeColorsKt.j(composer, 0).O(), 0L, null, null, null, 0L, null, TextAlign.h(companion3.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).a(), composer, 0, 0, 65016);
            SpacerKt.a(SizeKt.i(companion, Dp.g(48)), composer, 6);
            composer.a0(-554965652);
            int i5 = 0;
            for (Object obj : list) {
                int i6 = i5 + 1;
                if (i5 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                InfoItem infoItem = (InfoItem) obj;
                p(infoItem.c(), infoItem.f(), infoItem.e(), infoItem.b(), infoItem.d(), infoItem.a(), composer, 0, 0);
                final List listListOf = CollectionsKt.listOf((Object[]) new Color[]{Color.n(ComposeColorsKt.j(composer, 0).a0()), Color.n(ComposeColorsKt.j(composer, 0).b())});
                if (i5 < CollectionsKt.getLastIndex(list)) {
                    composer.a0(1325752735);
                    columnScopeInstance = columnScopeInstance3;
                    float f6 = 1;
                    Modifier modifierX = SizeKt.x(PaddingKt.m(columnScopeInstance.c(Modifier.b8, Alignment.f25072a.k()), Dp.g(27), Dp.g(f6), 0.0f, Dp.g(f6), 4, null), Dp.g(2), Dp.g(f4));
                    boolean z4 = i5 == 0 && z3;
                    boolean Z = composer.Z(listListOf);
                    Object objG = composer.G();
                    if (Z || objG == Composer.f23746a.a()) {
                        objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.b0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return StrictModeExplanationsScreenKt.x(listListOf, (Modifier) obj2);
                            }
                        };
                        composer.w(objG);
                    }
                    SpacerKt.a(ComposableExtKt.r(modifierX, z4, (Function1) objG), composer, 0);
                } else {
                    columnScopeInstance = columnScopeInstance3;
                    composer.a0(1320215918);
                }
                composer.U();
                i5 = i6;
                columnScopeInstance3 = columnScopeInstance;
            }
            composer.U();
            Modifier.Companion companion4 = Modifier.b8;
            SpacerKt.a(ColumnScope.b(columnScopeInstance3, companion4, 1.0f, false, 2, null), composer, 0);
            androidx.compose.material3.TextKt.c(str3, PaddingKt.l(companion4, Dp.g(f3), Dp.g(24), Dp.g(f3), Dp.g(f5)), ComposeColorsKt.j(composer, 0).O(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, TextStyle.e(ComposeTypographyKt.g(composer, 0).a(), 0L, 0L, null, FontStyle.c(FontStyle.f29211b.a()), null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777207, null), composer, 0, 0, 65016);
            Composer composer2 = composer;
            SpacerKt.a(SizeKt.i(companion4, Dp.g(f5)), composer2, 6);
            if (z2) {
                composer2.a0(-22073439);
                Object objG2 = composer2.G();
                if (objG2 == Composer.f23746a.a()) {
                    objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.c0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Integer.valueOf(StrictModeExplanationsScreenKt.y());
                        }
                    };
                    composer2.w(objG2);
                }
                PagerState pagerStateL = PagerStateKt.l(0, 0.0f, (Function0) objG2, composer2, 384, 3);
                PagerKt.a(pagerStateL, SizeKt.E(SizeKt.h(companion4, 0.0f, 1, null), null, false, 3, null), null, null, 0, 0.0f, null, null, false, false, null, null, null, null, ComposableSingletons$StrictModeExplanationsScreenKt.f104984a.b(), composer, 48, 24576, 16380);
                composer2 = composer;
                SpacerKt.a(SizeKt.i(companion4, Dp.g(f3)), composer2, 6);
                PremiumReviewsCarouselCardKt.o(StrictModeOnboardingReviews.getEntries().size(), pagerStateL, null, composer2, 0, 4);
                SpacerKt.a(SizeKt.i(companion4, Dp.g(f3)), composer2, 6);
            } else {
                composer2.a0(-29010588);
            }
            composer2.U();
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
    public static final Modifier x(List list, Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return BackgroundKt.b(applyIf, Brush.Companion.m(Brush.Companion, list, 0.0f, 0.0f, 0, 14, null), null, 0.0f, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int y() {
        return StrictModeOnboardingReviews.getEntries().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(String str, String str2, List list, String str3, boolean z2, boolean z3, Function0 function0, int i3, int i4, Composer composer, int i5) {
        t(str, str2, list, str3, z2, z3, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }
}
