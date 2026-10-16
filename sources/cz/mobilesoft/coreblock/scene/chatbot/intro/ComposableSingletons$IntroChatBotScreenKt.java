package cz.mobilesoft.coreblock.scene.chatbot.intro;

import android.content.Context;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.navigation.NavController;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.ContactReason;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ComposableSingletons$IntroChatBotScreenKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$IntroChatBotScreenKt f99063a = new ComposableSingletons$IntroChatBotScreenKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function3 f99064b = ComposableLambdaKt.c(1082639679, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.chatbot.intro.a
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$IntroChatBotScreenKt.e((PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f99065c = ComposableLambdaKt.c(2128892213, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.chatbot.intro.b
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$IntroChatBotScreenKt.f((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(PaddingValues padding, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(padding, "padding");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(padding) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1082639679, i4, -1, "cz.mobilesoft.coreblock.scene.chatbot.intro.ComposableSingletons$IntroChatBotScreenKt.lambda$1082639679.<anonymous> (IntroChatBotScreen.kt:93)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierH = PaddingKt.h(companion, padding);
            Arrangement.Vertical verticalH = Arrangement.f6574a.h();
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion2.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierH);
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
            Updater.e(composerA, measurePolicyA, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            float f3 = 16;
            ImageKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.T, composer, 6), null, PaddingKt.i(ColumnScopeInstance.f6666a.c(companion, companion2.g()), Dp.g(f3)), null, null, 0.0f, null, composer, 48, 120);
            String strB = StringResources_androidKt.b(R.string.v7, composer, 0);
            TextStyle textStyleF = ComposeTypographyKt.g(composer, 0).f();
            TextAlign.Companion companion4 = TextAlign.f29616b;
            TextKt.c(strB, SizeKt.h(PaddingKt.i(companion, Dp.g(f3)), 0.0f, 1, null), 0L, 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, textStyleF, composer, 48, 0, 65020);
            TextKt.c(StringResources_androidKt.b(R.string.u7, composer, 0), SizeKt.h(PaddingKt.i(companion, Dp.g(f3)), 0.0f, 1, null), ComposeColorsKt.j(composer, 0).O(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).b(), composer, 48, 0, 65016);
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
    public static final Unit f(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2128892213, i3, -1, "cz.mobilesoft.coreblock.scene.chatbot.intro.ComposableSingletons$IntroChatBotScreenKt.lambda$2128892213.<anonymous> (IntroChatBotScreen.kt:131)");
            }
            NavController navController = new NavController((Context) composer.q(AndroidCompositionLocals_androidKt.g()));
            IntroChatBotViewState introChatBotViewState = new IntroChatBotViewState(true);
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.chatbot.intro.c
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$IntroChatBotScreenKt.g();
                    }
                };
                composer.w(objG);
            }
            IntroChatBotScreenKt.h(navController, introChatBotViewState, (Function0) objG, "", ContactReason.Other, composer, 28032);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g() {
        return Unit.f139807a;
    }

    public final Function3 d() {
        return f99064b;
    }
}
