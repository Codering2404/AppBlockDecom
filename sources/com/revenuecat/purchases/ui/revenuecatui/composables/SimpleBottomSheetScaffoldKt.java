package com.revenuecat.purchases.ui.revenuecatui.composables;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class SimpleBottomSheetScaffoldKt {
    private static final float ALPHA_SCRIM = 0.6f;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: Scrim-EUb7tLY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m927ScrimEUb7tLY(final boolean r17, float r18, final kotlin.jvm.functions.Function0<kotlin.Unit> r19, androidx.compose.ui.Modifier r20, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r21, androidx.compose.runtime.Composer r22, final int r23, final int r24) {
        /*
            Method dump skipped, instruction units count: 430
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.composables.SimpleBottomSheetScaffoldKt.m927ScrimEUb7tLY(boolean, float, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final float Scrim_EUb7tLY$lambda$2(State<Dp> state) {
        return ((Dp) state.getValue()).l();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void SimpleBottomSheetScaffold(final com.revenuecat.purchases.ui.revenuecatui.composables.SimpleSheetState r17, androidx.compose.ui.Modifier r18, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r19, androidx.compose.runtime.Composer r20, final int r21, final int r22) {
        /*
            Method dump skipped, instruction units count: 418
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.composables.SimpleBottomSheetScaffoldKt.SimpleBottomSheetScaffold(com.revenuecat.purchases.ui.revenuecatui.composables.SimpleSheetState, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SimpleBottomSheetScaffold_Preview(Composer composer, final int i3) {
        Composer composerK = composer.k(-266393130);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-266393130, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.SimpleBottomSheetScaffold_Preview (SimpleBottomSheetScaffold.kt:147)");
            }
            SimpleSheetState simpleSheetState = new SimpleSheetState();
            ComposableSingletons$SimpleBottomSheetScaffoldKt composableSingletons$SimpleBottomSheetScaffoldKt = ComposableSingletons$SimpleBottomSheetScaffoldKt.INSTANCE;
            SimpleSheetState.show$default(simpleSheetState, true, composableSingletons$SimpleBottomSheetScaffoldKt.m876getLambda2$revenuecatui_defaultsBc8Release(), null, 4, null);
            SimpleBottomSheetScaffold(simpleSheetState, BackgroundKt.d(SizeKt.f(Modifier.b8, 0.0f, 1, null), Color.f25715b.e(), null, 2, null), composableSingletons$SimpleBottomSheetScaffoldKt.m877getLambda3$revenuecatui_defaultsBc8Release(), composerK, 432, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.SimpleBottomSheetScaffoldKt.SimpleBottomSheetScaffold_Preview.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i4) {
                    SimpleBottomSheetScaffoldKt.SimpleBottomSheetScaffold_Preview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    private static final <T> TweenSpec<T> blurAnimationSpec() {
        return AnimationSpecKt.n(0, 0, null, 7, null);
    }
}
