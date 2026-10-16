package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material3.tokens.NavigationBarTokens;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

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
public final class NavigationBarKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f18413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f18414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f18415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float f18416d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final float f18417e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final float f18418f;

    static {
        NavigationBarTokens navigationBarTokens = NavigationBarTokens.f22957a;
        f18413a = navigationBarTokens.h();
        f18414b = Dp.g(8);
        f18415c = Dp.g(4);
        float f3 = 2;
        f18416d = Dp.g(Dp.g(navigationBarTokens.e() - navigationBarTokens.i()) / f3);
        f18417e = Dp.g(Dp.g(navigationBarTokens.c() - navigationBarTokens.i()) / f3);
        f18418f = Dp.g(12);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:115:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x011b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(androidx.compose.ui.Modifier r23, long r24, long r26, float r28, androidx.compose.foundation.layout.WindowInsets r29, final kotlin.jvm.functions.Function3 r30, androidx.compose.runtime.Composer r31, final int r32, final int r33) {
        /*
            Method dump skipped, instruction units count: 404
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationBarKt.a(androidx.compose.ui.Modifier, long, long, float, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0170 A[PHI: r0 r8 r9 r13 r15 r20
      0x0170: PHI (r0v12 androidx.compose.material3.NavigationBarItemColors) = (r0v8 androidx.compose.material3.NavigationBarItemColors), (r0v16 androidx.compose.material3.NavigationBarItemColors) binds: [B:139:0x0194, B:125:0x016e] A[DONT_GENERATE, DONT_INLINE]
      0x0170: PHI (r8v5 androidx.compose.ui.Modifier) = (r8v3 androidx.compose.ui.Modifier), (r8v2 androidx.compose.ui.Modifier) binds: [B:139:0x0194, B:125:0x016e] A[DONT_GENERATE, DONT_INLINE]
      0x0170: PHI (r9v4 boolean) = (r9v2 boolean), (r9v1 boolean) binds: [B:139:0x0194, B:125:0x016e] A[DONT_GENERATE, DONT_INLINE]
      0x0170: PHI (r13v6 boolean) = (r13v4 boolean), (r13v3 boolean) binds: [B:139:0x0194, B:125:0x016e] A[DONT_GENERATE, DONT_INLINE]
      0x0170: PHI (r15v6 kotlin.jvm.functions.Function2) = (r15v4 kotlin.jvm.functions.Function2), (r15v3 kotlin.jvm.functions.Function2) binds: [B:139:0x0194, B:125:0x016e] A[DONT_GENERATE, DONT_INLINE]
      0x0170: PHI (r20v8 int) = (r20v6 int), (r20v5 int) binds: [B:139:0x0194, B:125:0x016e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x03c2  */
    /* JADX WARN: Removed duplicated region for block: B:195:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0107  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void b(final androidx.compose.foundation.layout.RowScope r26, final boolean r27, final kotlin.jvm.functions.Function0 r28, final kotlin.jvm.functions.Function2 r29, androidx.compose.ui.Modifier r30, boolean r31, kotlin.jvm.functions.Function2 r32, boolean r33, androidx.compose.material3.NavigationBarItemColors r34, androidx.compose.foundation.interaction.MutableInteractionSource r35, androidx.compose.runtime.Composer r36, final int r37, final int r38) {
        /*
            Method dump skipped, instruction units count: 979
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationBarKt.b(androidx.compose.foundation.layout.RowScope, boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, boolean, androidx.compose.material3.NavigationBarItemColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final int c(MutableIntState mutableIntState) {
        return mutableIntState.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(MutableIntState mutableIntState, int i3) {
        mutableIntState.a(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(final Function2 function2, final Function2 function22, final Function2 function23, final Function2 function24, final boolean z2, final Function0 function0, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-1427075886);
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
            i4 |= composerK.I(function24) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.b(z2) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.I(function0) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((74899 & i4) == 74898 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1427075886, i4, -1, "androidx.compose.material3.NavigationBarItemLayout (NavigationBar.kt:516)");
            }
            int i5 = 458752 & i4;
            int i6 = 57344 & i4;
            boolean z3 = (i5 == 131072) | ((i4 & 7168) == 2048) | (i6 == 16384);
            Object objG = composerK.G();
            if (z3 || objG == Composer.f23746a.a()) {
                objG = new MeasurePolicy() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItemLayout$2$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo10measure3p2s80s(MeasureScope measureScope, List list, long j3) {
                        Object obj;
                        Placeable placeableN0;
                        MeasureScope measureScope2 = measureScope;
                        float fFloatValue = ((Number) function0.invoke()).floatValue();
                        long jD = Constraints.d(j3, 0, 0, 0, 0, 10, null);
                        int size = list.size();
                        int i7 = 0;
                        while (i7 < size) {
                            Measurable measurable = (Measurable) list.get(i7);
                            if (Intrinsics.areEqual(LayoutIdKt.a(measurable), "icon")) {
                                Placeable placeableN02 = measurable.n0(jD);
                                float f3 = 2;
                                int iX0 = placeableN02.X0() + measureScope2.z0(Dp.g(NavigationBarKt.f18416d * f3));
                                int iD = MathKt.d(iX0 * fFloatValue);
                                int iO0 = placeableN02.O0() + measureScope2.z0(Dp.g(NavigationBarKt.l() * f3));
                                int size2 = list.size();
                                int i8 = 0;
                                while (i8 < size2) {
                                    Measurable measurable2 = (Measurable) list.get(i8);
                                    if (Intrinsics.areEqual(LayoutIdKt.a(measurable2), "indicatorRipple")) {
                                        Placeable placeableN03 = measurable2.n0(Constraints.f29963b.c(iX0, iO0));
                                        int size3 = list.size();
                                        int i9 = 0;
                                        while (true) {
                                            if (i9 >= size3) {
                                                obj = null;
                                                break;
                                            }
                                            obj = list.get(i9);
                                            if (Intrinsics.areEqual(LayoutIdKt.a((Measurable) obj), "indicator")) {
                                                break;
                                            }
                                            i9++;
                                        }
                                        Measurable measurable3 = (Measurable) obj;
                                        Placeable placeableN04 = measurable3 != null ? measurable3.n0(Constraints.f29963b.c(iD, iO0)) : null;
                                        if (function24 != null) {
                                            int size4 = list.size();
                                            for (int i10 = 0; i10 < size4; i10++) {
                                                Measurable measurable4 = (Measurable) list.get(i10);
                                                if (Intrinsics.areEqual(LayoutIdKt.a(measurable4), "label")) {
                                                    placeableN0 = measurable4.n0(jD);
                                                }
                                            }
                                            throw new NoSuchElementException("Collection contains no element matching the predicate.");
                                        }
                                        placeableN0 = null;
                                        if (function24 == null) {
                                            return NavigationBarKt.n(measureScope2, placeableN02, placeableN03, placeableN04, j3);
                                        }
                                        Intrinsics.checkNotNull(placeableN0);
                                        return NavigationBarKt.o(measureScope, placeableN0, placeableN02, placeableN03, placeableN04, j3, z2, fFloatValue);
                                    }
                                    i8++;
                                    measureScope2 = measureScope;
                                }
                                throw new NoSuchElementException("Collection contains no element matching the predicate.");
                            }
                            i7++;
                            measureScope2 = measureScope;
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                };
                composerK.w(objG);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) objG;
            Modifier.Companion companion = Modifier.b8;
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, companion);
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
            function2.invoke(composerK, Integer.valueOf(i4 & 14));
            function22.invoke(composerK, Integer.valueOf((i4 >> 3) & 14));
            Modifier modifierB = LayoutIdKt.b(companion, "icon");
            Alignment.Companion companion3 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion3.o(), false);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierB);
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
            function23.invoke(composerK, Integer.valueOf((i4 >> 6) & 14));
            composerK.y();
            composerK.a0(1087198243);
            if (function24 != null) {
                Modifier modifierB2 = LayoutIdKt.b(companion, "label");
                boolean z4 = (i6 == 16384) | (i5 == 131072);
                Object objG2 = composerK.G();
                if (z4 || objG2 == Composer.f23746a.a()) {
                    objG2 = new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItemLayout$1$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((GraphicsLayerScope) obj);
                            return Unit.f139807a;
                        }

                        public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                            graphicsLayerScope.c(z2 ? 1.0f : ((Number) function0.invoke()).floatValue());
                        }
                    };
                    composerK.w(objG2);
                }
                Modifier modifierK = PaddingKt.k(GraphicsLayerModifierKt.a(modifierB2, (Function1) objG2), Dp.g(f18414b / 2), 0.0f, 2, null);
                MeasurePolicy measurePolicyG2 = BoxKt.g(companion3.o(), false);
                int iA3 = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU3 = composerK.u();
                Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierK);
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
                function24.invoke(composerK, Integer.valueOf((i4 >> 9) & 14));
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
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItemLayout$3
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
                    NavigationBarKt.e(function2, function22, function23, function24, z2, function0, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    public static final float l() {
        return f18417e;
    }

    public static final float m() {
        return f18414b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult n(MeasureScope measureScope, final Placeable placeable, final Placeable placeable2, final Placeable placeable3, long j3) {
        final int iL = Constraints.l(j3);
        final int iF = ConstraintsKt.f(j3, measureScope.z0(f18413a));
        final int iX0 = (iL - placeable.X0()) / 2;
        final int iO0 = (iF - placeable.O0()) / 2;
        final int iX02 = (iL - placeable2.X0()) / 2;
        final int iO02 = (iF - placeable2.O0()) / 2;
        return MeasureScope.B0(measureScope, iL, iF, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$placeIcon$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.f139807a;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope placementScope2;
                Placeable placeable4 = placeable3;
                if (placeable4 != null) {
                    Placeable.PlacementScope.m(placementScope, placeable4, (iL - placeable4.X0()) / 2, (iF - placeable4.O0()) / 2, 0.0f, 4, null);
                    placementScope2 = placementScope;
                } else {
                    placementScope2 = placementScope;
                }
                Placeable.PlacementScope.m(placementScope2, placeable, iX0, iO0, 0.0f, 4, null);
                Placeable.PlacementScope.m(placementScope2, placeable2, iX02, iO02, 0.0f, 4, null);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult o(final MeasureScope measureScope, final Placeable placeable, final Placeable placeable2, final Placeable placeable3, final Placeable placeable4, long j3, final boolean z2, final float f3) {
        float fO0 = placeable2.O0();
        float f4 = f18417e;
        float fM1 = fO0 + measureScope.M1(f4);
        float f5 = f18415c;
        float fM12 = fM1 + measureScope.M1(f5) + placeable.O0();
        float f6 = 2;
        final float fE = RangesKt.e((Constraints.m(j3) - fM12) / f6, measureScope.M1(f4));
        float f7 = fM12 + (fE * f6);
        final float fO02 = ((z2 ? fE : (f7 - placeable2.O0()) / f6) - fE) * (1 - f3);
        final float fO03 = placeable2.O0() + fE + measureScope.M1(f4) + measureScope.M1(f5);
        final int iL = Constraints.l(j3);
        final int iX0 = (iL - placeable.X0()) / 2;
        final int iX02 = (iL - placeable2.X0()) / 2;
        final int iX03 = (iL - placeable3.X0()) / 2;
        final float fM13 = fE - measureScope.M1(f4);
        return MeasureScope.B0(measureScope, iL, MathKt.d(f7), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$placeLabelAndIcon$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.f139807a;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope placementScope2;
                Placeable placeable5 = placeable4;
                if (placeable5 != null) {
                    int i3 = iL;
                    float f8 = fE;
                    MeasureScope measureScope2 = measureScope;
                    Placeable.PlacementScope.m(placementScope, placeable5, (i3 - placeable5.X0()) / 2, MathKt.d((f8 - measureScope2.z0(NavigationBarKt.l())) + fO02), 0.0f, 4, null);
                    placementScope2 = placementScope;
                } else {
                    placementScope2 = placementScope;
                }
                if (z2 || f3 != 0.0f) {
                    Placeable.PlacementScope.m(placementScope2, placeable, iX0, MathKt.d(fO03 + fO02), 0.0f, 4, null);
                }
                Placeable.PlacementScope.m(placementScope2, placeable2, iX02, MathKt.d(fE + fO02), 0.0f, 4, null);
                Placeable.PlacementScope.m(placementScope2, placeable3, iX03, MathKt.d(fM13 + fO02), 0.0f, 4, null);
            }
        }, 4, null);
    }
}
