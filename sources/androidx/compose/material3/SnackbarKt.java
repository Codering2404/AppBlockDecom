package androidx.compose.material3;

import androidx.compose.foundation.layout.AlignmentLineKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class SnackbarKt {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float f20265d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final float f20268g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f20262a = Dp.g(600);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f20263b = Dp.g(30);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f20264c = Dp.g(16);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final float f20266e = Dp.g(2);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final float f20267f = Dp.g(6);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final float f20269h = Dp.g(12);

    static {
        float f3 = 8;
        f20265d = Dp.g(f3);
        f20268g = Dp.g(f3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r12v10, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v9 */
    public static final void a(final Function2 function2, final Function2 function22, final Function2 function23, final TextStyle textStyle, final long j3, final long j4, Composer composer, final int i3) {
        int i4;
        ?? r12;
        Composer composerK = composer.k(-1332496681);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(function2) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function22) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function23) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.Z(textStyle) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.f(j3) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.f(j4) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((74899 & i4) == 74898 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1332496681, i4, -1, "androidx.compose.material3.NewLineButtonSnackbar (Snackbar.kt:263)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierM = PaddingKt.m(SizeKt.h(SizeKt.C(companion, 0.0f, f20262a, 1, null), 0.0f, 1, null), f20264c, 0.0f, 0.0f, f20266e, 6, null);
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.Vertical verticalH = arrangement.h();
            Alignment.Companion companion2 = Alignment.f25072a;
            int i5 = i4;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion2.k(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierM);
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
            Modifier modifierG = AlignmentLineKt.g(companion, f20263b, f20269h);
            float fG = f20265d;
            Modifier modifierM2 = PaddingKt.m(modifierG, 0.0f, 0.0f, fG, 0.0f, 11, null);
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierM2);
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
            Updater.e(composerA2, measurePolicyG, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            function2.invoke(composerK, Integer.valueOf(i5 & 14));
            composerK.y();
            Modifier modifierC = columnScopeInstance.c(companion, companion2.j());
            if (function23 == null) {
                r12 = 0;
            } else {
                r12 = 0;
                fG = Dp.g(0);
            }
            Modifier modifierM3 = PaddingKt.m(modifierC, 0.0f, 0.0f, fG, 0.0f, 11, null);
            MeasurePolicy measurePolicyG2 = BoxKt.g(companion2.o(), r12);
            int iA3 = ComposablesKt.a(composerK, r12);
            CompositionLocalMap compositionLocalMapU3 = composerK.u();
            Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierM3);
            Function0 function0A3 = companion3.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A3);
            } else {
                composerK.v();
            }
            Composer composerA3 = Updater.a(composerK);
            Updater.e(composerA3, measurePolicyG2, companion3.e());
            Updater.e(composerA3, compositionLocalMapU3, companion3.g());
            Function2 function2B3 = companion3.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion3.f());
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), companion2.l(), composerK, 0);
            int iA4 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU4 = composerK.u();
            Modifier modifierF4 = ComposedModifierKt.f(composerK, companion);
            Function0 function0A4 = companion3.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A4);
            } else {
                composerK.v();
            }
            Composer composerA4 = Updater.a(composerK);
            Updater.e(composerA4, measurePolicyB, companion3.e());
            Updater.e(composerA4, compositionLocalMapU4, companion3.g());
            Function2 function2B4 = companion3.b();
            if (composerA4.i() || !Intrinsics.areEqual(composerA4.G(), Integer.valueOf(iA4))) {
                composerA4.w(Integer.valueOf(iA4));
                composerA4.p(Integer.valueOf(iA4), function2B4);
            }
            Updater.e(composerA4, modifierF4, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            ProvidedValue[] providedValueArr = {ContentColorKt.a().d(Color.n(j3)), TextKt.f().d(textStyle)};
            int i6 = ProvidedValue.f24012i;
            CompositionLocalKt.c(providedValueArr, function22, composerK, (i5 & 112) | i6);
            composerK.a0(618603253);
            if (function23 != null) {
                CompositionLocalKt.b(ContentColorKt.a().d(Color.n(j4)), function23, composerK, i6 | ((i5 >> 3) & 112));
            }
            composerK.U();
            composerK.y();
            composerK.y();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$NewLineButtonSnackbar$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i7) {
                    SnackbarKt.a(function2, function22, function23, textStyle, j3, j4, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(final Function2 function2, final Function2 function22, final Function2 function23, final TextStyle textStyle, final long j3, final long j4, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-903235475);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(function2) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function22) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function23) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.Z(textStyle) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.f(j3) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.f(j4) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((74899 & i4) == 74898 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-903235475, i4, -1, "androidx.compose.material3.OneRowSnackbar (Snackbar.kt:308)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierM = PaddingKt.m(companion, f20264c, 0.0f, function23 == null ? f20265d : Dp.g(0), 0.0f, 10, null);
            Object objG = composerK.G();
            final String str = "text";
            int i5 = i4;
            final String str2 = "action";
            final String str3 = "dismissAction";
            if (objG == Composer.f23746a.a()) {
                objG = new MeasurePolicy() { // from class: androidx.compose.material3.SnackbarKt$OneRowSnackbar$2$1
                    /* JADX WARN: Removed duplicated region for block: B:60:0x0125 A[PHI: r0 r4
                      0x0125: PHI (r0v11 int) = (r0v10 int), (r0v17 int), (r0v17 int) binds: [B:63:0x0148, B:56:0x0116, B:58:0x0120] A[DONT_GENERATE, DONT_INLINE]
                      0x0125: PHI (r4v4 int) = (r4v3 int), (r4v12 int), (r4v12 int) binds: [B:63:0x0148, B:56:0x0116, B:58:0x0120] A[DONT_GENERATE, DONT_INLINE]] */
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final androidx.compose.ui.layout.MeasureResult mo10measure3p2s80s(androidx.compose.ui.layout.MeasureScope r22, java.util.List r23, long r24) {
                        /*
                            Method dump skipped, instruction units count: 395
                            To view this dump change 'Code comments level' option to 'DEBUG'
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SnackbarKt$OneRowSnackbar$2$1.mo10measure3p2s80s(androidx.compose.ui.layout.MeasureScope, java.util.List, long):androidx.compose.ui.layout.MeasureResult");
                    }
                };
                composerK.w(objG);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) objG;
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierM);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
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
            Updater.e(composerA, measurePolicy, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            Modifier modifierK = PaddingKt.k(LayoutIdKt.b(companion, "text"), 0.0f, f20267f, 1, null);
            Alignment.Companion companion3 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion3.o(), false);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierK);
            Function0 function0A2 = companion2.a();
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
            Updater.e(composerA2, measurePolicyG, companion2.e());
            Updater.e(composerA2, compositionLocalMapU2, companion2.g());
            Function2 function2B2 = companion2.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion2.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            function2.invoke(composerK, Integer.valueOf(i5 & 14));
            composerK.y();
            composerK.a0(-904778058);
            if (function22 != null) {
                Modifier modifierB = LayoutIdKt.b(companion, "action");
                MeasurePolicy measurePolicyG2 = BoxKt.g(companion3.o(), false);
                int iA3 = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU3 = composerK.u();
                Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierB);
                Function0 function0A3 = companion2.a();
                if (composerK.m() == null) {
                    ComposablesKt.c();
                }
                composerK.L();
                if (composerK.i()) {
                    composerK.P(function0A3);
                } else {
                    composerK.v();
                }
                Composer composerA3 = Updater.a(composerK);
                Updater.e(composerA3, measurePolicyG2, companion2.e());
                Updater.e(composerA3, compositionLocalMapU3, companion2.g());
                Function2 function2B3 = companion2.b();
                if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                    composerA3.w(Integer.valueOf(iA3));
                    composerA3.p(Integer.valueOf(iA3), function2B3);
                }
                Updater.e(composerA3, modifierF3, companion2.f());
                CompositionLocalKt.c(new ProvidedValue[]{ContentColorKt.a().d(Color.n(j3)), TextKt.f().d(textStyle)}, function22, composerK, ProvidedValue.f24012i | (i5 & 112));
                composerK.y();
            }
            composerK.U();
            composerK.a0(-904766579);
            if (function23 != null) {
                Modifier modifierB2 = LayoutIdKt.b(companion, "dismissAction");
                MeasurePolicy measurePolicyG3 = BoxKt.g(companion3.o(), false);
                int iA4 = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU4 = composerK.u();
                Modifier modifierF4 = ComposedModifierKt.f(composerK, modifierB2);
                Function0 function0A4 = companion2.a();
                if (composerK.m() == null) {
                    ComposablesKt.c();
                }
                composerK.L();
                if (composerK.i()) {
                    composerK.P(function0A4);
                } else {
                    composerK.v();
                }
                Composer composerA4 = Updater.a(composerK);
                Updater.e(composerA4, measurePolicyG3, companion2.e());
                Updater.e(composerA4, compositionLocalMapU4, companion2.g());
                Function2 function2B4 = companion2.b();
                if (composerA4.i() || !Intrinsics.areEqual(composerA4.G(), Integer.valueOf(iA4))) {
                    composerA4.w(Integer.valueOf(iA4));
                    composerA4.p(Integer.valueOf(iA4), function2B4);
                }
                Updater.e(composerA4, modifierF4, companion2.f());
                CompositionLocalKt.b(ContentColorKt.a().d(Color.n(j4)), function23, composerK, ProvidedValue.f24012i | ((i5 >> 3) & 112));
                composerK.y();
            }
            composerK.U();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$OneRowSnackbar$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i6) {
                    SnackbarKt.b(function2, function22, function23, textStyle, j3, j4, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:179:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0107  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void c(androidx.compose.ui.Modifier r24, kotlin.jvm.functions.Function2 r25, kotlin.jvm.functions.Function2 r26, boolean r27, androidx.compose.ui.graphics.Shape r28, long r29, long r31, long r33, long r35, final kotlin.jvm.functions.Function2 r37, androidx.compose.runtime.Composer r38, final int r39, final int r40) {
        /*
            Method dump skipped, instruction units count: 646
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SnackbarKt.c(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.graphics.Shape, long, long, long, long, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:177:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0107  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void d(final androidx.compose.material3.SnackbarData r34, androidx.compose.ui.Modifier r35, boolean r36, androidx.compose.ui.graphics.Shape r37, long r38, long r40, long r42, long r44, long r46, androidx.compose.runtime.Composer r48, final int r49, final int r50) {
        /*
            Method dump skipped, instruction units count: 702
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SnackbarKt.d(androidx.compose.material3.SnackbarData, androidx.compose.ui.Modifier, boolean, androidx.compose.ui.graphics.Shape, long, long, long, long, long, androidx.compose.runtime.Composer, int, int):void");
    }
}
