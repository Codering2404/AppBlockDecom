package androidx.compose.ui.layout;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
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
public final class SubcomposeLayoutKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SubcomposeLayoutKt$ReusedSlotId$1 f27217a = new Object() { // from class: androidx.compose.ui.layout.SubcomposeLayoutKt$ReusedSlotId$1
        public String toString() {
            return "ReusedSlotId";
        }
    };

    public static final void a(final Modifier modifier, Function2 function2, Composer composer, final int i3, final int i4) {
        int i5;
        final Function2 function22;
        Composer composerK = composer.k(-1298353104);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i5 = (composerK.Z(modifier) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i3 & 48) == 0) {
            i5 |= composerK.I(function2) ? 32 : 16;
        }
        if (composerK.r((i5 & 19) != 18, i5 & 1)) {
            if (i6 != 0) {
                modifier = Modifier.b8;
            }
            Modifier modifier2 = modifier;
            if (ComposerKt.M()) {
                ComposerKt.U(-1298353104, i5, -1, "androidx.compose.ui.layout.SubcomposeLayout (SubcomposeLayout.kt:82)");
            }
            Object objG = composerK.G();
            if (objG == Composer.f23746a.a()) {
                objG = new SubcomposeLayoutState();
                composerK.w(objG);
            }
            function22 = function2;
            b((SubcomposeLayoutState) objG, modifier2, function22, composerK, (i5 << 3) & 1008, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            modifier = modifier2;
        } else {
            function22 = function2;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.layout.SubcomposeLayoutKt$SubcomposeLayout$2
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
                    SubcomposeLayoutKt.a(modifier, function22, composer2, RecomposeScopeImplKt.a(i3 | 1), i4);
                }
            });
        }
    }

    public static final void b(final SubcomposeLayoutState subcomposeLayoutState, Modifier modifier, final Function2 function2, Composer composer, final int i3, final int i4) {
        int i5;
        Composer composerK = composer.k(-511989831);
        if ((i4 & 1) != 0) {
            i5 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i5 = (composerK.I(subcomposeLayoutState) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        int i6 = i4 & 2;
        if (i6 != 0) {
            i5 |= 48;
        } else if ((i3 & 48) == 0) {
            i5 |= composerK.Z(modifier) ? 32 : 16;
        }
        if ((i4 & 4) != 0) {
            i5 |= 384;
        } else if ((i3 & 384) == 0) {
            i5 |= composerK.I(function2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i5 & 147) != 146, i5 & 1)) {
            if (i6 != 0) {
                modifier = Modifier.b8;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(-511989831, i5, -1, "androidx.compose.ui.layout.SubcomposeLayout (SubcomposeLayout.kt:115)");
            }
            int iA = ComposablesKt.a(composerK, 0);
            CompositionContext compositionContextD = ComposablesKt.d(composerK, 0);
            Modifier modifierF = ComposedModifierKt.f(composerK, modifier);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Function0 function0A = LayoutNode.T.a();
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
            Updater.e(composerA, subcomposeLayoutState, subcomposeLayoutState.g());
            Updater.e(composerA, compositionContextD, subcomposeLayoutState.e());
            Updater.e(composerA, function2, subcomposeLayoutState.f());
            ComposeUiNode.Companion companion = ComposeUiNode.f8;
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Updater.e(composerA, modifierF, companion.f());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            composerK.y();
            if (composerK.l()) {
                composerK.a0(-26267397);
                composerK.U();
            } else {
                composerK.a0(-26326018);
                boolean zI = composerK.I(subcomposeLayoutState);
                Object objG = composerK.G();
                if (zI || objG == Composer.f23746a.a()) {
                    objG = new Function0<Unit>() { // from class: androidx.compose.ui.layout.SubcomposeLayoutKt$SubcomposeLayout$4$1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m224invoke();
                            return Unit.f139807a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m224invoke() {
                            subcomposeLayoutState.d();
                        }
                    };
                    composerK.w(objG);
                }
                EffectsKt.j((Function0) objG, composerK, 0);
                composerK.U();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        final Modifier modifier2 = modifier;
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.layout.SubcomposeLayoutKt$SubcomposeLayout$5
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
                    SubcomposeLayoutKt.b(subcomposeLayoutState, modifier2, function2, composer2, RecomposeScopeImplKt.a(i3 | 1), i4);
                }
            });
        }
    }
}
