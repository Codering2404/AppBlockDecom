package cz.mobilesoft.coreblock.scene.sharing.images.ups_downs;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.scene.sharing.images.SocialShareTemplate;
import cz.mobilesoft.coreblock.scene.sharing.images.components.FixedCanvasKt;
import cz.mobilesoft.coreblock.scene.sharing.images.ups_downs.UpsDownPreviewFrameKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class UpsDownPreviewFrameKt {
    public static final void b(SocialShareTemplate template, Function2 content, Composer composer, final int i3) {
        int i4;
        final SocialShareTemplate socialShareTemplate;
        final Function2 function2;
        Intrinsics.checkNotNullParameter(template, "template");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerK = composer.k(1989354500);
        if ((i3 & 6) == 0) {
            i4 = (composerK.e(template.ordinal()) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(content) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1989354500, i4, -1, "cz.mobilesoft.coreblock.scene.sharing.images.ups_downs.UpsDownPreviewFrame (UpsDownPreviewFrame.kt:17)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierI = PaddingKt.i(SizeKt.x(companion, Dp.g(360), Dp.g(640)), Dp.g(16));
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.e(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierI);
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
            Updater.e(composerA, measurePolicyG, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            int i5 = i4 << 3;
            socialShareTemplate = template;
            function2 = content;
            FixedCanvasKt.e(SizeKt.f(companion, 0.0f, 1, null), socialShareTemplate, function2, composerK, (i5 & 112) | 6 | (i5 & 896), 0);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            socialShareTemplate = template;
            function2 = content;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: s1.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return UpsDownPreviewFrameKt.c(socialShareTemplate, function2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(SocialShareTemplate socialShareTemplate, Function2 function2, int i3, Composer composer, int i4) {
        b(socialShareTemplate, function2, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
