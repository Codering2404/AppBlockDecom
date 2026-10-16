package cz.mobilesoft.coreblock.view.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.util.compose.ComposableExtKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
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
public final class FlatButtonsKt {
    /* JADX WARN: Removed duplicated region for block: B:104:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0412  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x042e  */
    /* JADX WARN: Removed duplicated region for block: B:244:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0126  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void A(androidx.compose.ui.Modifier r62, float r63, cz.mobilesoft.coreblock.view.compose.material3.FlatButtonColors r64, cz.mobilesoft.coreblock.view.compose.material3.FlatButtonColors r65, long r66, final java.lang.String r68, androidx.compose.ui.text.TextStyle r69, java.lang.Integer r70, java.lang.String r71, final long r72, long r74, kotlin.jvm.functions.Function0 r76, final kotlin.jvm.functions.Function0 r77, androidx.compose.runtime.Composer r78, final int r79, final int r80, final int r81) {
        /*
            Method dump skipped, instruction units count: 1096
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt.A(androidx.compose.ui.Modifier, float, cz.mobilesoft.coreblock.view.compose.material3.FlatButtonColors, cz.mobilesoft.coreblock.view.compose.material3.FlatButtonColors, long, java.lang.String, androidx.compose.ui.text.TextStyle, java.lang.Integer, java.lang.String, long, long, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B() {
        return Unit.f139807a;
    }

    private static final boolean C(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(Function0 function0, MutableState mutableState) {
        if (!C(mutableState)) {
            function0.invoke();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(Animatable animatable, float f3, long j3, MutableState mutableState, Integer num, String str, FlatButtonColors flatButtonColors, TextStyle textStyle, String str2, RowScope ButtonFlat, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(ButtonFlat, "$this$ButtonFlat");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(221280275, i3, -1, "cz.mobilesoft.coreblock.view.compose.material3.CooldownFlatButtonWithTextAndIcon.<anonymous> (FlatButtons.kt:319)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierF = SizeKt.f(companion, 0.0f, 1, null);
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierF);
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
            Updater.e(composerA, modifierF2, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            if (!C(mutableState) || ((Number) animatable.n()).floatValue() <= 0.0f) {
                composer.a0(2014648181);
            } else {
                composer.a0(2026297764);
                float f4 = f3 / 2;
                float f5 = 0;
                BoxKt.a(BackgroundKt.d(ClipKt.a(SizeKt.g(boxScopeInstance.f(SizeKt.d(companion, 0.0f, 1, null), companion2.h()), ((Number) animatable.n()).floatValue()), RoundedCornerShapeKt.e(Dp.g(f4), Dp.g(f5), Dp.g(f5), Dp.g(f4))), j3, null, 2, null), composer, 0);
            }
            composer.U();
            Modifier modifierK = PaddingKt.k(boxScopeInstance.h(companion), Dp.g(16), 0.0f, 2, null);
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.b(), companion2.i(), composer, 54);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF3 = ComposedModifierKt.f(composer, modifierK);
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
            Updater.e(composerA2, measurePolicyB, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF3, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            if (num == null) {
                composer.a0(-1708074619);
            } else {
                composer.a0(-1708074618);
                IconKt.c(PainterResources_androidKt.c(num.intValue(), composer, 0), str2, SizeKt.v(companion, Dp.g(24)), flatButtonColors.d(composer, 0), composer, 384, 0);
                SpacerKt.a(SizeKt.v(companion, Dp.g(4)), composer, 6);
            }
            composer.U();
            TextKt.c(str, null, flatButtonColors.d(composer, 0), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyle, composer, 0, 0, 65530);
            composer.y();
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
    public static final Unit G(Modifier modifier, float f3, FlatButtonColors flatButtonColors, FlatButtonColors flatButtonColors2, long j3, String str, TextStyle textStyle, Integer num, String str2, long j4, long j5, Function0 function0, Function0 function02, int i3, int i4, int i5, Composer composer, int i6) {
        A(modifier, f3, flatButtonColors, flatButtonColors2, j3, str, textStyle, num, str2, j4, j5, function0, function02, composer, RecomposeScopeImplKt.a(i3 | 1), RecomposeScopeImplKt.a(i4), i5);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:147:0x056b  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0578  */
    /* JADX WARN: Removed duplicated region for block: B:152:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void H(androidx.compose.ui.Modifier r69, float r70, final java.lang.String r71, final int r72, cz.mobilesoft.coreblock.view.compose.material3.FlatButtonColors r73, java.lang.String r74, final kotlin.jvm.functions.Function0 r75, androidx.compose.runtime.Composer r76, final int r77, final int r78) {
        /*
            Method dump skipped, instruction units count: 1428
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt.H(androidx.compose.ui.Modifier, float, java.lang.String, int, cz.mobilesoft.coreblock.view.compose.material3.FlatButtonColors, java.lang.String, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(float f3, long j3, Stroke stroke, ContentDrawScope drawWithContent) {
        Intrinsics.checkNotNullParameter(drawWithContent, "$this$drawWithContent");
        drawWithContent.i2();
        float fM1 = drawWithContent.M1(f3) / 2;
        DrawScope.f2(drawWithContent, j3, 0L, 0L, CornerRadius.b((((long) Float.floatToRawIntBits(fM1)) << 32) | (((long) Float.floatToRawIntBits(fM1)) & 4294967295L)), stroke, 0.0f, null, 0, 230, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(Modifier modifier, float f3, String str, int i3, FlatButtonColors flatButtonColors, String str2, Function0 function0, int i4, int i5, Composer composer, int i6) {
        H(modifier, f3, str, i3, flatButtonColors, str2, function0, composer, RecomposeScopeImplKt.a(i4 | 1), i5);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:107:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void K(androidx.compose.ui.Modifier r24, float r25, final int r26, cz.mobilesoft.coreblock.view.compose.material3.FlatButtonColors r27, final java.lang.String r28, kotlin.jvm.functions.Function0 r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instruction units count: 489
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt.K(androidx.compose.ui.Modifier, float, int, cz.mobilesoft.coreblock.view.compose.material3.FlatButtonColors, java.lang.String, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:107:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void L(androidx.compose.ui.Modifier r24, float r25, final androidx.compose.ui.graphics.vector.ImageVector r26, cz.mobilesoft.coreblock.view.compose.material3.FlatButtonColors r27, final java.lang.String r28, kotlin.jvm.functions.Function0 r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instruction units count: 495
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt.L(androidx.compose.ui.Modifier, float, androidx.compose.ui.graphics.vector.ImageVector, cz.mobilesoft.coreblock.view.compose.material3.FlatButtonColors, java.lang.String, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M(Modifier modifier, float f3, int i3, FlatButtonColors flatButtonColors, String str, Function0 function0, int i4, int i5, Composer composer, int i6) {
        K(modifier, f3, i3, flatButtonColors, str, function0, composer, RecomposeScopeImplKt.a(i4 | 1), i5);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N(Modifier modifier, float f3, ImageVector imageVector, FlatButtonColors flatButtonColors, String str, Function0 function0, int i3, int i4, Composer composer, int i5) {
        L(modifier, f3, imageVector, flatButtonColors, str, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void p(cz.mobilesoft.coreblock.view.compose.material3.FlatButtonColors r20, boolean r21, final java.lang.String r22, boolean r23, final kotlin.jvm.functions.Function0 r24, androidx.compose.runtime.Composer r25, final int r26, final int r27) {
        /*
            Method dump skipped, instruction units count: 409
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt.p(cz.mobilesoft.coreblock.view.compose.material3.FlatButtonColors, boolean, java.lang.String, boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(FlatButtonColors flatButtonColors, boolean z2, String str, boolean z3, Function0 function0, int i3, int i4, Composer composer, int i5) {
        p(flatButtonColors, z2, str, z3, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:120:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0102  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void r(androidx.compose.ui.Modifier r26, float r27, androidx.compose.foundation.layout.PaddingValues r28, cz.mobilesoft.coreblock.view.compose.material3.FlatButtonColors r29, boolean r30, boolean r31, final kotlin.jvm.functions.Function0 r32, final kotlin.jvm.functions.Function3 r33, androidx.compose.runtime.Composer r34, final int r35, final int r36) {
        /*
            Method dump skipped, instruction units count: 484
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt.r(androidx.compose.ui.Modifier, float, androidx.compose.foundation.layout.PaddingValues, cz.mobilesoft.coreblock.view.compose.material3.FlatButtonColors, boolean, boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void s(androidx.compose.ui.Modifier r19, final java.lang.String r20, java.lang.Integer r21, cz.mobilesoft.coreblock.view.compose.material3.FlatButtonColors r22, java.lang.String r23, boolean r24, final kotlin.jvm.functions.Function0 r25, androidx.compose.runtime.Composer r26, final int r27, final int r28) {
        /*
            Method dump skipped, instruction units count: 384
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt.s(androidx.compose.ui.Modifier, java.lang.String, java.lang.Integer, cz.mobilesoft.coreblock.view.compose.material3.FlatButtonColors, java.lang.String, boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(Modifier modifier, String str, Integer num, FlatButtonColors flatButtonColors, String str2, boolean z2, Function0 function0, int i3, int i4, Composer composer, int i5) {
        s(modifier, str, num, flatButtonColors, str2, z2, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:221:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x012a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void u(androidx.compose.ui.Modifier r35, float r36, float r37, androidx.compose.foundation.layout.PaddingValues r38, cz.mobilesoft.coreblock.view.compose.material3.FlatButtonColors r39, cz.mobilesoft.coreblock.view.compose.material3.FlatButtonColors r40, final java.lang.String r41, androidx.compose.ui.text.TextStyle r42, long r43, java.lang.Integer r45, java.lang.String r46, boolean r47, boolean r48, final kotlin.jvm.functions.Function0 r49, androidx.compose.runtime.Composer r50, final int r51, final int r52, final int r53) {
        /*
            Method dump skipped, instruction units count: 877
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt.u(androidx.compose.ui.Modifier, float, float, androidx.compose.foundation.layout.PaddingValues, cz.mobilesoft.coreblock.view.compose.material3.FlatButtonColors, cz.mobilesoft.coreblock.view.compose.material3.FlatButtonColors, java.lang.String, androidx.compose.ui.text.TextStyle, long, java.lang.Integer, java.lang.String, boolean, boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(boolean z2, Integer num, FlatButtonColors flatButtonColors, String str, long j3, TextStyle textStyle, float f3, String str2, RowScope ButtonFlat, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(ButtonFlat, "$this$ButtonFlat");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2102030623, i3, -1, "cz.mobilesoft.coreblock.view.compose.material3.ButtonFlatWithTextAndIcon.<anonymous> (FlatButtons.kt:236)");
            }
            Modifier.Companion companion = Modifier.b8;
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.view.compose.material3.v0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FlatButtonsKt.w((Modifier) obj);
                    }
                };
                composer.w(objG);
            }
            Modifier modifierR = ComposableExtKt.r(companion, z2, (Function1) objG);
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.b(), Alignment.f25072a.i(), composer, 54);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierR);
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
            Updater.e(composerA, measurePolicyB, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            if (num == null) {
                composer.a0(1835682654);
            } else {
                composer.a0(1835682655);
                IconKt.c(PainterResources_androidKt.c(num.intValue(), composer, 0), str2, SizeKt.v(companion, f3), flatButtonColors.d(composer, 0), composer, 0, 0);
                SpacerKt.a(SizeKt.v(companion, Dp.g(4)), composer, 6);
            }
            composer.U();
            TextKt.c(str, null, flatButtonColors.d(composer, 0), j3, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyle, composer, 0, 0, 65522);
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
    public static final Modifier w(Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return SizeKt.h(applyIf, 0.0f, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(Modifier modifier, float f3, float f4, PaddingValues paddingValues, FlatButtonColors flatButtonColors, FlatButtonColors flatButtonColors2, String str, TextStyle textStyle, long j3, Integer num, String str2, boolean z2, boolean z3, Function0 function0, int i3, int i4, int i5, Composer composer, int i6) {
        u(modifier, f3, f4, paddingValues, flatButtonColors, flatButtonColors2, str, textStyle, j3, num, str2, z2, z3, function0, composer, RecomposeScopeImplKt.a(i3 | 1), RecomposeScopeImplKt.a(i4), i5);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier y(Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return SizeKt.h(applyIf, 0.0f, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(Modifier modifier, float f3, PaddingValues paddingValues, FlatButtonColors flatButtonColors, boolean z2, boolean z3, Function0 function0, Function3 function3, int i3, int i4, Composer composer, int i5) {
        r(modifier, f3, paddingValues, flatButtonColors, z2, z3, function0, function3, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }
}
