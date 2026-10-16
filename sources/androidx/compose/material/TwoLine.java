package androidx.compose.material;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
final class TwoLine {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final float f15102e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final float f15103f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final float f15104g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final float f15105h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final float f15107j;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final float f15110m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final float f15111n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final float f15112o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TwoLine f15098a = new TwoLine();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f15099b = Dp.g(64);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f15100c = Dp.g(72);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float f15101d = Dp.g(40);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final float f15106i = Dp.g(24);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final float f15108k = Dp.g(28);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final float f15109l = Dp.g(32);

    static {
        float f3 = 16;
        f15102e = Dp.g(f3);
        f15103f = Dp.g(f3);
        f15104g = Dp.g(f3);
        f15105h = Dp.g(f3);
        float f4 = 20;
        f15107j = Dp.g(f4);
        f15110m = Dp.g(f4);
        f15111n = Dp.g(f4);
        f15112o = Dp.g(f3);
    }

    private TwoLine() {
    }

    public final void a(Modifier modifier, final Function2 function2, final Function2 function22, final Function2 function23, final Function2 function24, final Function2 function25, Composer composer, final int i3, final int i4) {
        Modifier modifier2;
        int i5;
        TwoLine twoLine;
        Modifier modifier3;
        final float f3;
        final Modifier modifier4;
        Composer composerK = composer.k(-1340612993);
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
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i3 & 48) == 0) {
            i5 |= composerK.I(function2) ? 32 : 16;
        }
        if ((i4 & 4) != 0) {
            i5 |= 384;
        } else if ((i3 & 384) == 0) {
            i5 |= composerK.I(function22) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 8) != 0) {
            i5 |= 3072;
        } else if ((i3 & 3072) == 0) {
            i5 |= composerK.I(function23) ? 2048 : 1024;
        }
        if ((i4 & 16) != 0) {
            i5 |= 24576;
        } else if ((i3 & 24576) == 0) {
            i5 |= composerK.I(function24) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((i4 & 32) != 0) {
            i5 |= 196608;
        } else if ((i3 & 196608) == 0) {
            i5 |= composerK.I(function25) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((i4 & 64) != 0) {
            i5 |= 1572864;
            twoLine = this;
        } else {
            twoLine = this;
            if ((i3 & 1572864) == 0) {
                i5 |= composerK.Z(twoLine) ? 1048576 : 524288;
            }
        }
        if ((599187 & i5) == 599186 && composerK.l()) {
            composerK.Q();
            modifier4 = modifier2;
        } else {
            Modifier modifier5 = i6 != 0 ? Modifier.b8 : modifier2;
            if (ComposerKt.M()) {
                ComposerKt.U(-1340612993, i5, -1, "androidx.compose.material.TwoLine.ListItem (ListItem.kt:206)");
            }
            float f4 = function2 == null ? f15099b : f15100c;
            Modifier modifierK = SizeKt.k(modifier5, f4, 0.0f, 2, null);
            Arrangement.Horizontal horizontalG = Arrangement.f6574a.g();
            Alignment.Companion companion = Alignment.f25072a;
            MeasurePolicy measurePolicyB = RowKt.b(horizontalG, companion.l(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierK);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            float f5 = f4;
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
            Modifier modifier6 = modifier5;
            Updater.e(composerA, measurePolicyB, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            Modifier.Companion companion3 = Modifier.b8;
            Modifier modifierM = PaddingKt.m(RowScope.c(rowScopeInstance, companion3, 1.0f, false, 2, null), f15104g, 0.0f, f15105h, 0.0f, 10, null);
            if (function2 != null) {
                composerK.a0(-1767094742);
                float f6 = f15102e;
                Modifier modifierZ = SizeKt.z(companion3, Dp.g(f6 + f15101d), f5, 0.0f, 0.0f, 12, null);
                f3 = f5;
                float f7 = f15103f;
                Modifier modifierM2 = PaddingKt.m(modifierZ, f6, f7, 0.0f, f7, 4, null);
                MeasurePolicy measurePolicyG = BoxKt.g(companion.o(), false);
                int iA2 = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU2 = composerK.u();
                Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierM2);
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
                modifier3 = modifierM;
                Updater.e(composerA2, measurePolicyG, companion2.e());
                Updater.e(composerA2, compositionLocalMapU2, companion2.g());
                Function2 function2B2 = companion2.b();
                if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                    composerA2.w(Integer.valueOf(iA2));
                    composerA2.p(Integer.valueOf(iA2), function2B2);
                }
                Updater.e(composerA2, modifierF2, companion2.f());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                function2.invoke(composerK, Integer.valueOf((i5 >> 3) & 14));
                composerK.y();
                composerK.U();
            } else {
                modifier3 = modifierM;
                f3 = f5;
                composerK.a0(-1766552738);
                composerK.U();
            }
            if (function24 != null) {
                composerK.a0(-1766504564);
                ListItemKt.a(CollectionsKt.listOf((Object[]) new Dp[]{Dp.d(f15106i), Dp.d(f15107j)}), modifier3, ComposableLambdaKt.e(-1675021441, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TwoLine$ListItem$1$2
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
                        if ((i7 & 3) == 2 && composer2.l()) {
                            composer2.Q();
                            return;
                        }
                        if (ComposerKt.M()) {
                            ComposerKt.U(-1675021441, i7, -1, "androidx.compose.material.TwoLine.ListItem.<anonymous>.<anonymous> (ListItem.kt:233)");
                        }
                        function24.invoke(composer2, 0);
                        function22.invoke(composer2, 0);
                        if (ComposerKt.M()) {
                            ComposerKt.T();
                        }
                    }
                }, composerK, 54), composerK, 390, 0);
                composerK.U();
            } else {
                Modifier modifier7 = modifier3;
                composerK.a0(-1766213598);
                ListItemKt.a(CollectionsKt.listOf((Object[]) new Dp[]{Dp.d(function2 != null ? f15109l : f15108k), Dp.d(function2 != null ? f15111n : f15110m)}), modifier7, ComposableLambdaKt.e(993836488, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TwoLine$ListItem$1$3
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
                        if ((i7 & 3) == 2 && composer2.l()) {
                            composer2.Q();
                            return;
                        }
                        if (ComposerKt.M()) {
                            ComposerKt.U(993836488, i7, -1, "androidx.compose.material.TwoLine.ListItem.<anonymous>.<anonymous> (ListItem.kt:252)");
                        }
                        function22.invoke(composer2, 0);
                        Function2 function26 = function23;
                        Intrinsics.checkNotNull(function26);
                        function26.invoke(composer2, 0);
                        if (ComposerKt.M()) {
                            ComposerKt.T();
                        }
                    }
                }, composerK, 54), composerK, 384, 0);
                composerK.U();
            }
            if (function25 != null) {
                composerK.a0(-1765486555);
                ListItemKt.c(function2 != null ? f15109l : f15108k, null, ComposableLambdaKt.e(-1696992176, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TwoLine$ListItem$1$4
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
                        if ((i7 & 3) == 2 && composer2.l()) {
                            composer2.Q();
                            return;
                        }
                        if (ComposerKt.M()) {
                            ComposerKt.U(-1696992176, i7, -1, "androidx.compose.material.TwoLine.ListItem.<anonymous>.<anonymous> (ListItem.kt:264)");
                        }
                        Modifier modifierM3 = PaddingKt.m(SizeKt.k(Modifier.b8, f3, 0.0f, 2, null), 0.0f, 0.0f, TwoLine.f15112o, 0.0f, 11, null);
                        Alignment alignmentE = Alignment.f25072a.e();
                        Function2 function26 = function25;
                        MeasurePolicy measurePolicyG2 = BoxKt.g(alignmentE, false);
                        int iA3 = ComposablesKt.a(composer2, 0);
                        CompositionLocalMap compositionLocalMapU3 = composer2.u();
                        Modifier modifierF3 = ComposedModifierKt.f(composer2, modifierM3);
                        ComposeUiNode.Companion companion4 = ComposeUiNode.f8;
                        Function0 function0A3 = companion4.a();
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
                        Updater.e(composerA3, measurePolicyG2, companion4.e());
                        Updater.e(composerA3, compositionLocalMapU3, companion4.g());
                        Function2 function2B3 = companion4.b();
                        if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                            composerA3.w(Integer.valueOf(iA3));
                            composerA3.p(Integer.valueOf(iA3), function2B3);
                        }
                        Updater.e(composerA3, modifierF3, companion4.f());
                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.f6642a;
                        function26.invoke(composer2, 0);
                        composer2.y();
                        if (ComposerKt.M()) {
                            ComposerKt.T();
                        }
                    }
                }, composerK, 54), composerK, 384, 2);
                composerK.U();
            } else {
                composerK.a0(-1764878242);
                composerK.U();
            }
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            modifier4 = modifier6;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            final TwoLine twoLine2 = twoLine;
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TwoLine$ListItem$2
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
                    this.f15119a.a(modifier4, function2, function22, function23, function24, function25, composer2, RecomposeScopeImplKt.a(i3 | 1), i4);
                }
            });
        }
    }
}
