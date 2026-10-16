package cz.mobilesoft.coreblock.scene.emergency_unblock.screens;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
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
public final class ComposableSingletons$EmergencyUnblockCloseSuccessScreenKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$EmergencyUnblockCloseSuccessScreenKt f101907a = new ComposableSingletons$EmergencyUnblockCloseSuccessScreenKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function3 f101908b = ComposableLambdaKt.c(-1004740998, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.screens.a
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$EmergencyUnblockCloseSuccessScreenKt.c((AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.M()) {
            ComposerKt.U(-1004740998, i3, -1, "cz.mobilesoft.coreblock.scene.emergency_unblock.screens.ComposableSingletons$EmergencyUnblockCloseSuccessScreenKt.lambda$-1004740998.<anonymous> (EmergencyUnblockCloseSuccessScreen.kt:55)");
        }
        Modifier.Companion companion = Modifier.b8;
        Modifier modifierK = PaddingKt.k(SizeKt.f(companion, 0.0f, 1, null), PrimitiveResources_androidKt.a(R.dimen.f95467a, composer, 0), 0.0f, 2, null);
        Alignment.Companion companion2 = Alignment.f25072a;
        MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
        int iA = ComposablesKt.a(composer, 0);
        CompositionLocalMap compositionLocalMapU = composer.u();
        Modifier modifierF = ComposedModifierKt.f(composer, modifierK);
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
        Updater.e(composerA, measurePolicyG, companion3.e());
        Updater.e(composerA, compositionLocalMapU, companion3.g());
        Function2 function2B = companion3.b();
        if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
            composerA.w(Integer.valueOf(iA));
            composerA.p(Integer.valueOf(iA), function2B);
        }
        Updater.e(composerA, modifierF, companion3.f());
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
        Alignment.Horizontal horizontalG = companion2.g();
        Modifier modifierF2 = boxScopeInstance.f(companion, companion2.e());
        MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), horizontalG, composer, 48);
        int iA2 = ComposablesKt.a(composer, 0);
        CompositionLocalMap compositionLocalMapU2 = composer.u();
        Modifier modifierF3 = ComposedModifierKt.f(composer, modifierF2);
        Function0 function0A2 = companion3.a();
        if (composer.m() == null) {
            ComposablesKt.c();
        }
        composer.L();
        if (composer.i()) {
            composer.P(function0A2);
        } else {
            composer.v();
        }
        Composer composerA2 = Updater.a(composer);
        Updater.e(composerA2, measurePolicyA, companion3.e());
        Updater.e(composerA2, compositionLocalMapU2, companion3.g());
        Function2 function2B2 = companion3.b();
        if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
            composerA2.w(Integer.valueOf(iA2));
            composerA2.p(Integer.valueOf(iA2), function2B2);
        }
        Updater.e(composerA2, modifierF3, companion3.f());
        ImageKt.a(PainterResources_androidKt.c(R.drawable.f95515g1, composer, 0), null, PaddingKt.k(ColumnScopeInstance.f6666a.c(companion, companion2.g()), 0.0f, Dp.g(48), 1, null), null, null, 0.0f, null, composer, 48, 120);
        String strB = StringResources_androidKt.b(R.string.YF, composer, 0);
        TextStyle textStyleF = ComposeTypographyKt.g(composer, 0).f();
        TextAlign.Companion companion4 = TextAlign.f29616b;
        TextKt.c(strB, null, ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, textStyleF, composer, 0, 0, 65018);
        SpacerKt.a(SizeKt.i(companion, Dp.g(12)), composer, 6);
        TextKt.c(StringResources_androidKt.b(R.string.wA, composer, 0), null, ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).a(), composer, 0, 0, 65018);
        composer.y();
        composer.y();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    public final Function3 b() {
        return f101908b;
    }
}
