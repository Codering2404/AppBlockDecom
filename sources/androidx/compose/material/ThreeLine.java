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
import java.util.List;
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
final class ThreeLine {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float f15077d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final float f15078e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final float f15079f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final float f15080g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final float f15082i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final float f15083j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final float f15084k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final float f15085l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreeLine f15074a = new ThreeLine();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f15075b = Dp.g(88);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f15076c = Dp.g(40);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final float f15081h = Dp.g(28);

    static {
        float f3 = 16;
        f15077d = Dp.g(f3);
        f15078e = Dp.g(f3);
        f15079f = Dp.g(f3);
        f15080g = Dp.g(f3);
        float f4 = 20;
        f15082i = Dp.g(f4);
        f15083j = Dp.g(f4);
        f15084k = Dp.g(f3);
        f15085l = Dp.g(f3);
    }

    private ThreeLine() {
    }

    public final void a(Modifier modifier, final Function2 function2, final Function2 function22, final Function2 function23, final Function2 function24, final Function2 function25, Composer composer, final int i3, final int i4) {
        Modifier modifier2;
        int i5;
        ThreeLine threeLine;
        final Modifier modifier3;
        Composer composerK = composer.k(1749738797);
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
            threeLine = this;
        } else {
            threeLine = this;
            if ((i3 & 1572864) == 0) {
                i5 |= composerK.Z(threeLine) ? 1048576 : 524288;
            }
        }
        int i7 = i5;
        if ((599187 & i7) == 599186 && composerK.l()) {
            composerK.Q();
            modifier3 = modifier2;
        } else {
            modifier3 = i6 != 0 ? Modifier.b8 : modifier2;
            if (ComposerKt.M()) {
                ComposerKt.U(1749738797, i7, -1, "androidx.compose.material.ThreeLine.ListItem (ListItem.kt:304)");
            }
            Modifier modifierK = SizeKt.k(modifier3, f15075b, 0.0f, 2, null);
            Arrangement.Horizontal horizontalG = Arrangement.f6574a.g();
            Alignment.Companion companion = Alignment.f25072a;
            MeasurePolicy measurePolicyB = RowKt.b(horizontalG, companion.l(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierK);
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
            Updater.e(composerA, measurePolicyB, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            if (function2 != null) {
                composerK.a0(1135402069);
                float f3 = f15077d;
                float fG = Dp.g(f3 + f15076c);
                Modifier modifierZ = SizeKt.z(Modifier.b8, fG, fG, 0.0f, 0.0f, 12, null);
                float f4 = f15078e;
                Modifier modifierM = PaddingKt.m(modifierZ, f3, f4, 0.0f, f4, 4, null);
                MeasurePolicy measurePolicyG = BoxKt.g(companion.h(), false);
                int iA2 = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU2 = composerK.u();
                Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierM);
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
                function2.invoke(composerK, Integer.valueOf((i7 >> 3) & 14));
                composerK.y();
                composerK.U();
            } else {
                composerK.a0(1135920048);
                composerK.U();
            }
            float f5 = f15081h;
            List listListOf = CollectionsKt.listOf((Object[]) new Dp[]{Dp.d(f5), Dp.d(f15082i), Dp.d(f15083j)});
            Modifier.Companion companion3 = Modifier.b8;
            ListItemKt.a(listListOf, PaddingKt.m(RowScope.c(rowScopeInstance, companion3, 1.0f, false, 2, null), f15079f, 0.0f, f15080g, 0.0f, 10, null), ComposableLambdaKt.e(-318094245, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ThreeLine$ListItem$1$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i8) {
                    if ((i8 & 3) == 2 && composer2.l()) {
                        composer2.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(-318094245, i8, -1, "androidx.compose.material.ThreeLine.ListItem.<anonymous>.<anonymous> (ListItem.kt:328)");
                    }
                    if (function24 != null) {
                        composer2.a0(-1959307137);
                        function24.invoke(composer2, 0);
                    } else {
                        composer2.a0(-608965647);
                    }
                    composer2.U();
                    function22.invoke(composer2, 0);
                    function23.invoke(composer2, 0);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), composerK, 390, 0);
            composerK = composerK;
            if (function25 != null) {
                composerK.a0(1136449683);
                float f6 = f15084k;
                ListItemKt.c(Dp.g(f5 - f6), PaddingKt.m(companion3, 0.0f, f6, f15085l, 0.0f, 9, null), function25, composerK, ((i7 >> 9) & 896) | 54, 0);
                composerK.U();
            } else {
                composerK.a0(1136723568);
                composerK.U();
            }
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            final ThreeLine threeLine2 = threeLine;
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ThreeLine$ListItem$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i8) {
                    this.f15089a.a(modifier3, function2, function22, function23, function24, function25, composer2, RecomposeScopeImplKt.a(i3 | 1), i4);
                }
            });
        }
    }
}
