package cz.mobilesoft.coreblock.scene.premium.trial_notifications.pages;

import android.content.Context;
import android.text.Spanned;
import android.text.style.UnderlineSpan;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.IconKt;
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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
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
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.premium.trial_notifications.pages.TrialEndNotificationScreenKt;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import kotlin.Metadata;
import kotlin.Unit;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class TrialEndNotificationScreenKt {
    private static final void e(final ImageVector imageVector, AnnotatedString annotatedString, Composer composer, final int i3) {
        int i4;
        final AnnotatedString annotatedString2;
        Composer composerK = composer.k(292528047);
        if ((i3 & 6) == 0) {
            i4 = i3 | (composerK.Z(imageVector) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(annotatedString) ? 32 : 16;
        }
        int i5 = i4;
        if (composerK.r((i5 & 19) != 18, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(292528047, i5, -1, "cz.mobilesoft.coreblock.scene.premium.trial_notifications.pages.TrialEndNotificationItem (TrialEndNotificationScreen.kt:135)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            final long jB = ComposeColorsKt.j(composerK, 0).b();
            Modifier.Companion companion2 = Modifier.b8;
            Modifier modifierK = PaddingKt.k(SizeKt.h(companion2, 0.0f, 1, null), Dp.g(16), 0.0f, 2, null);
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.o(Dp.g(24)), Alignment.f25072a.i(), composerK, 54);
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
            Updater.e(composerA, measurePolicyB, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            IconKt.d(imageVector, null, SizeKt.v(companion2, Dp.g(40)), ComposeColorsKt.j(composerK, 0).b(), composerK, (i5 & 14) | 432, 0);
            Modifier modifierC = RowScope.c(rowScopeInstance, companion2, 1.0f, false, 2, null);
            boolean zF = composerK.f(jB);
            Object objG2 = composerK.G();
            if (zF || objG2 == companion.a()) {
                final float f3 = 2.0f;
                objG2 = new Function1() { // from class: j1.i
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TrialEndNotificationScreenKt.h(mutableState, f3, jB, (ContentDrawScope) obj);
                    }
                };
                composerK.w(objG2);
            }
            Modifier modifierD = DrawModifierKt.d(modifierC, (Function1) objG2);
            TextStyle textStyleA = ComposeTypographyKt.g(composerK, 0).a();
            long jL = ComposeColorsKt.j(composerK, 0).L();
            Object objG3 = composerK.G();
            if (objG3 == companion.a()) {
                objG3 = new Function1() { // from class: j1.j
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TrialEndNotificationScreenKt.i(mutableState, (TextLayoutResult) obj);
                    }
                };
                composerK.w(objG3);
            }
            annotatedString2 = annotatedString;
            TextKt.d(annotatedString2, modifierD, jL, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, (Function1) objG3, textStyleA, composerK, (i5 >> 3) & 14, 1572864, 65528);
            composerK = composerK;
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            annotatedString2 = annotatedString;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: j1.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TrialEndNotificationScreenKt.j(imageVector, annotatedString2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final TextLayoutResult f(MutableState mutableState) {
        return (TextLayoutResult) mutableState.getValue();
    }

    private static final void g(MutableState mutableState, TextLayoutResult textLayoutResult) {
        mutableState.setValue(textLayoutResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(MutableState mutableState, float f3, long j3, ContentDrawScope contentDrawScope) {
        TextLayoutResult textLayoutResult;
        boolean z2;
        int i3;
        int i4;
        int iMax;
        int iMin;
        ContentDrawScope drawWithContent = contentDrawScope;
        Intrinsics.checkNotNullParameter(drawWithContent, "$this$drawWithContent");
        drawWithContent.i2();
        TextLayoutResult textLayoutResultF = f(mutableState);
        if (textLayoutResultF != null) {
            boolean z3 = false;
            for (AnnotatedString.Range range : textLayoutResultF.l().j().j("TRIAL_UNDERLINE_TAG", 0, textLayoutResultF.l().j().length())) {
                int iQ = textLayoutResultF.q(range.h());
                int iQ2 = textLayoutResultF.q(range.f());
                if (iQ <= iQ2) {
                    while (true) {
                        int iU = textLayoutResultF.u(iQ);
                        int iO = textLayoutResultF.o(iQ, true);
                        if (iO < iU || (iMax = Math.max(range.h(), iU)) >= (iMin = Math.min(range.f(), (i4 = iO + 1)))) {
                            textLayoutResult = textLayoutResultF;
                            i3 = iQ2;
                            z2 = z3;
                        } else {
                            float fM = textLayoutResultF.m(iQ) + f3;
                            float fJ = textLayoutResultF.j(iMax, true);
                            float fT = (iMin == i4 && (range.f() > i4 ? true : z3)) ? textLayoutResultF.t(iQ) : textLayoutResultF.j(iMin, true);
                            textLayoutResult = textLayoutResultF;
                            i3 = iQ2;
                            z2 = z3;
                            DrawScope.L0(drawWithContent, j3, Offset.e((((long) Float.floatToRawIntBits(fJ)) << 32) | (((long) Float.floatToRawIntBits(fM)) & 4294967295L)), Offset.e((((long) Float.floatToRawIntBits(fT)) << 32) | (((long) Float.floatToRawIntBits(fM)) & 4294967295L)), f3, 0, null, 0.0f, null, 0, 496, null);
                            iQ = iQ;
                        }
                        if (iQ != i3) {
                            iQ++;
                            drawWithContent = contentDrawScope;
                            iQ2 = i3;
                            z3 = z2;
                            textLayoutResultF = textLayoutResult;
                        }
                    }
                } else {
                    textLayoutResult = textLayoutResultF;
                    z2 = z3;
                }
                textLayoutResultF = textLayoutResult;
                drawWithContent = contentDrawScope;
                z3 = z2;
            }
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(MutableState mutableState, TextLayoutResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        g(mutableState, it);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(ImageVector imageVector, AnnotatedString annotatedString, int i3, Composer composer, int i4) {
        e(imageVector, annotatedString, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void k(final Function0 onContinueClicked, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(onContinueClicked, "onContinueClicked");
        Composer composerK = composer.k(-272115355);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(onContinueClicked) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-272115355, i4, -1, "cz.mobilesoft.coreblock.scene.premium.trial_notifications.pages.TrialEndNotificationScreen (TrialEndNotificationScreen.kt:55)");
            }
            Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierJ = PaddingKt.j(BackgroundKt.d(SizeKt.f(companion, 0.0f, 1, null), ComposeColorsKt.j(composerK, 0).e(), null, 2, null), Dp.g(f3), Dp.g(8));
            Alignment.Companion companion2 = Alignment.f25072a;
            Alignment.Horizontal horizontalG = companion2.g();
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.h(), horizontalG, composerK, 48);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierJ);
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
            Modifier modifierG = ScrollKt.g(ColumnScope.b(columnScopeInstance, SizeKt.h(companion, 0.0f, 1, null), 1.0f, false, 2, null), ScrollKt.c(0, composerK, 0, 1), false, null, false, 14, null);
            MeasurePolicy measurePolicyA2 = ColumnKt.a(arrangement.h(), companion2.g(), composerK, 54);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierG);
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
            Updater.e(composerA2, measurePolicyA2, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            ImageKt.a(PainterResources_androidKt.c(R.drawable.nb, composerK, 0), null, columnScopeInstance.c(SizeKt.h(companion, 0.0f, 1, null), companion2.g()), null, ContentScale.f27054a.e(), 0.0f, null, composerK, 24624, 104);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composerK, 6);
            String strB = StringResources_androidKt.b(R.string.qE, composerK, 0);
            TextStyle textStyleF = ComposeTypographyKt.g(composerK, 0).f();
            TextAlign.Companion companion4 = TextAlign.f29616b;
            TextKt.c(strB, null, 0L, 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, textStyleF, composerK, 0, 0, 65022);
            float f4 = 24;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f4)), composerK, 6);
            ImageVector.Companion companion5 = ImageVector.f26323k;
            ImageVector imageVectorB = VectorResources_androidKt.b(companion5, R.drawable.f95567u0, composerK, 6);
            CharSequence text = context.getText(R.string.wE);
            Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
            e(imageVectorB, n(text, "TRIAL_UNDERLINE_TAG", false, 4, null), composerK, 0);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f4)), composerK, 6);
            ImageVector imageVectorB2 = VectorResources_androidKt.b(companion5, R.drawable.f95547o1, composerK, 6);
            CharSequence text2 = context.getText(R.string.xE);
            Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
            e(imageVectorB2, n(text2, "TRIAL_UNDERLINE_TAG", false, 4, null), composerK, 0);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f4)), composerK, 6);
            ImageVector imageVectorB3 = VectorResources_androidKt.b(companion5, R.drawable.z5, composerK, 6);
            CharSequence text3 = context.getText(R.string.yE);
            Intrinsics.checkNotNullExpressionValue(text3, "getText(...)");
            e(imageVectorB3, n(text3, "TRIAL_UNDERLINE_TAG", false, 4, null), composerK, 0);
            composerK.y();
            SpacerKt.a(SizeKt.i(companion, Dp.g(f4)), composerK, 6);
            TextKt.c(StringResources_androidKt.b(R.string.pE, composerK, 0), null, ComposeColorsKt.j(composerK, 0).P(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).b(), composerK, 0, 0, 65018);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composerK, 6);
            ComposeButtonsKt.J(null, StringResources_androidKt.b(R.string.l8, composerK, 0), false, false, null, onContinueClicked, composerK, ((i4 << 15) & 458752) | 3072, 21);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: j1.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TrialEndNotificationScreenKt.l(onContinueClicked, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(Function0 function0, int i3, Composer composer, int i4) {
        k(function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final AnnotatedString m(CharSequence text, String annotationTag, boolean z2) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(annotationTag, "annotationTag");
        Spanned spanned = text instanceof Spanned ? (Spanned) text : null;
        if (spanned == null) {
            AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
            builder.append(text);
            return builder.t();
        }
        UnderlineSpan[] underlineSpanArr = (UnderlineSpan[]) spanned.getSpans(0, spanned.length(), UnderlineSpan.class);
        AnnotatedString.Builder builder2 = new AnnotatedString.Builder(0, 1, null);
        builder2.l(spanned.toString());
        Intrinsics.checkNotNull(underlineSpanArr);
        for (UnderlineSpan underlineSpan : underlineSpanArr) {
            int spanStart = spanned.getSpanStart(underlineSpan);
            int spanEnd = spanned.getSpanEnd(underlineSpan);
            builder2.d(annotationTag, spanned.subSequence(spanStart, spanEnd).toString(), spanStart, spanEnd);
            if (z2) {
                builder2.f(new SpanStyle(0L, 0L, FontWeight.f29233b.b(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65531, (DefaultConstructorMarker) null), spanStart, spanEnd);
            }
        }
        return builder2.t();
    }

    public static /* synthetic */ AnnotatedString n(CharSequence charSequence, String str, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = "TRIAL_UNDERLINE_TAG";
        }
        if ((i3 & 4) != 0) {
            z2 = true;
        }
        return m(charSequence, str, z2);
    }
}
