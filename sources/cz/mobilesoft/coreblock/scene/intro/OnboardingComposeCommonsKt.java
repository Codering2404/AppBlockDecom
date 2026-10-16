package cz.mobilesoft.coreblock.scene.intro;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import cz.mobilesoft.coreblock.BuildConfig;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.ContextExtKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeCommonsKt;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class OnboardingComposeCommonsKt {
    public static final void e(String title, final Function0 function0, Composer composer, final int i3, final int i4) {
        int i5;
        final String str;
        Intrinsics.checkNotNullParameter(title, "title");
        Composer composerK = composer.k(935355995);
        if ((i3 & 6) == 0) {
            i5 = (composerK.Z(title) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        int i6 = i4 & 2;
        if (i6 != 0) {
            i5 |= 48;
        } else if ((i3 & 48) == 0) {
            i5 |= composerK.I(function0) ? 32 : 16;
        }
        if (composerK.r((i5 & 19) != 18, i5 & 1)) {
            if (i6 != 0) {
                function0 = null;
            }
            Function0 function02 = function0;
            if (ComposerKt.M()) {
                ComposerKt.U(935355995, i5, -1, "cz.mobilesoft.coreblock.scene.intro.OnboardingToolbar (OnboardingComposeCommons.kt:20)");
            }
            str = title;
            ComposeCommonsKt.n(str, function02, ComposableSingletons$OnboardingComposeCommonsKt.f104473a.b(), composerK, (i5 & 14) | 384 | (i5 & 112), 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            function0 = function02;
        } else {
            str = title;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.intro.h1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OnboardingComposeCommonsKt.f(str, function0, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(String str, Function0 function0, int i3, int i4, Composer composer, int i5) {
        e(str, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void g(Modifier modifier, Composer composer, final int i3, final int i4) {
        Modifier modifier2;
        int i5;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeN;
        Function2 function2;
        Composer composerK = composer.k(-1794466584);
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
        if (composerK.r((i5 & 3) != 2, i5 & 1)) {
            modifier3 = i6 != 0 ? Modifier.b8 : modifier2;
            if (ComposerKt.M()) {
                ComposerKt.U(-1794466584, i5, -1, "cz.mobilesoft.coreblock.scene.intro.SkipButton (OnboardingComposeCommons.kt:32)");
            }
            if (BuildConfig.f95357b.booleanValue()) {
                composerK.a0(504026741);
                final Activity activityB = ContextExtKt.b((Context) composerK.q(AndroidCompositionLocals_androidKt.g()));
                if (activityB == null) {
                    composerK.U();
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                    scopeUpdateScopeN = composerK.n();
                    if (scopeUpdateScopeN != null) {
                        function2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.intro.e1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return OnboardingComposeCommonsKt.h(modifier3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        };
                        scopeUpdateScopeN.a(function2);
                    }
                    return;
                }
                ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.f95580y1, composerK, 6);
                long jN = ComposeColorsKt.j(composerK, 0).N();
                boolean zI = composerK.I(activityB);
                Object objG = composerK.G();
                if (zI || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.f1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return OnboardingComposeCommonsKt.i(activityB);
                        }
                    };
                    composerK.w(objG);
                }
                ComposeButtonsKt.q0(modifier3, imageVectorB, null, false, 0.0f, 0.0f, jN, null, (Function0) objG, composerK, i5 & 14, 188);
            } else {
                composerK.a0(502717146);
            }
            composerK.U();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
            modifier3 = modifier2;
        }
        scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            function2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.intro.g1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OnboardingComposeCommonsKt.j(modifier3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeN.a(function2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(Modifier modifier, int i3, int i4, Composer composer, int i5) {
        g(modifier, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(Activity activity) {
        Intent intentC = DashboardActivity.Companion.c(DashboardActivity.f99133o, activity, null, null, 6, null);
        intentC.setFlags(268468224);
        activity.startActivity(intentC);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(Modifier modifier, int i3, int i4, Composer composer, int i5) {
        g(modifier, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }
}
