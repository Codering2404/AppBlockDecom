package cz.mobilesoft.coreblock.view.compose;

import android.content.Context;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.MaterialTheme;
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
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Html_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import com.google.android.gms.ads.AdView;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class LockScreensComponentsKt {
    public static final void f(Modifier modifier, final AdView adView, Composer composer, final int i3) {
        int i4;
        final Modifier modifier2;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(adView, "adView");
        Composer composerK = composer.k(-1375438290);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(modifier) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(adView) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1375438290, i4, -1, "cz.mobilesoft.coreblock.view.compose.AdMobBanner (LockScreensComponents.kt:35)");
            }
            boolean zI = composerK.I(adView);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.view.compose.p9
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return LockScreensComponentsKt.g(adView, (Context) obj);
                    }
                };
                composerK.w(objG);
            }
            modifier2 = modifier;
            AndroidView_androidKt.a((Function1) objG, modifier2, null, composerK, (i4 << 3) & 112, 4);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            modifier2 = modifier;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.q9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LockScreensComponentsKt.h(modifier2, adView, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AdView g(AdView adView, Context it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return adView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(Modifier modifier, AdView adView, int i3, Composer composer, int i4) {
        f(modifier, adView, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void i(final Modifier modifier, final String message, final Function0 onClick, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerK = composer.k(672893101);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(modifier) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(message) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onClick) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(672893101, i4, -1, "cz.mobilesoft.coreblock.view.compose.LockScreenCampaignCard (LockScreensComponents.kt:94)");
            }
            ComposeCardsKt.j(modifier, onClick, ComposeColorsKt.j(composerK, 0).p(), null, 0.0f, null, null, ComposableLambdaKt.e(1731867128, true, new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.r9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LockScreensComponentsKt.j(message, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, (i4 & 14) | 12582912 | ((i4 >> 3) & 112), 120);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.s9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LockScreensComponentsKt.k(modifier, message, onClick, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(String str, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1731867128, i3, -1, "cz.mobilesoft.coreblock.view.compose.LockScreenCampaignCard.<anonymous> (LockScreensComponents.kt:100)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierK = PaddingKt.k(IntrinsicKt.a(companion, IntrinsicSize.f6987b), Dp.g(f3), 0.0f, 2, null);
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), Alignment.f25072a.i(), composer, 54);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierK);
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
            androidx.compose.foundation.ImageKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.z2, composer, 6), "ic_campaign_logo", SizeKt.G(companion, null, false, 3, null), null, null, 0.0f, null, composer, 432, 120);
            SpacerKt.a(SizeKt.v(companion, Dp.g(f3)), composer, 6);
            androidx.compose.material.TextKt.d(Html_androidKt.d(AnnotatedString.f28632f, str, null, null, 6, null), null, ComposeColorsKt.j(composer, 0).l0(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, TextKt.d(MaterialTheme.f13091a.c(composer, MaterialTheme.f13092b).b()), composer, 0, 0, 131066);
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
    public static final Unit k(Modifier modifier, String str, Function0 function0, int i3, Composer composer, int i4) {
        i(modifier, str, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void l(final Modifier modifier, final Function0 onClick, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerK = composer.k(-1584027143);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(modifier) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onClick) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1584027143, i4, -1, "cz.mobilesoft.coreblock.view.compose.LockScreenInAppUpdateCard (LockScreensComponents.kt:43)");
            }
            ComposeCardsKt.j(modifier, onClick, ComposeColorsKt.j(composerK, 0).p(), null, 0.0f, null, null, ComposableSingletons$LockScreensComponentsKt.f130391a.b(), composerK, (i4 & 14) | 12582912 | (i4 & 112), 120);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.o9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LockScreensComponentsKt.m(modifier, onClick, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(Modifier modifier, Function0 function0, int i3, Composer composer, int i4) {
        l(modifier, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
