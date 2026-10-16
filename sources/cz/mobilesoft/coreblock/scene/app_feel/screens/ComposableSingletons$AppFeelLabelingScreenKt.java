package cz.mobilesoft.coreblock.scene.app_feel.screens;

import android.content.Context;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.IconKt;
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
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.core.content.ContextCompat;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.dto.UsageAccess;
import cz.mobilesoft.coreblock.enums.AppDistractionType;
import cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewState;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.statistics.model.AggregatedItemRecord;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
public final class ComposableSingletons$AppFeelLabelingScreenKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$AppFeelLabelingScreenKt f98724a = new ComposableSingletons$AppFeelLabelingScreenKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function3 f98725b = ComposableLambdaKt.c(-5200627, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.app_feel.screens.a1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$AppFeelLabelingScreenKt.m((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function3 f98726c = ComposableLambdaKt.c(-1080996956, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.app_feel.screens.b1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$AppFeelLabelingScreenKt.l((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Function2 f98727d = ComposableLambdaKt.c(-545975959, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.app_feel.screens.c1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AppFeelLabelingScreenKt.n((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Function2 f98728e = ComposableLambdaKt.c(281722033, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.app_feel.screens.d1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AppFeelLabelingScreenKt.k((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(281722033, i3, -1, "cz.mobilesoft.coreblock.scene.app_feel.screens.ComposableSingletons$AppFeelLabelingScreenKt.lambda$281722033.<anonymous> (AppFeelLabelingScreen.kt:702)");
            }
            AppFeelLabelingScreenKt.y0(new Pair("AppBlock", ContextCompat.getDrawable((Context) composer.q(AndroidCompositionLocals_androidKt.g()), R.drawable.f95525j)), new AggregatedItemRecord(1000, "AppBlock", null, null, UsageAccess.Type.APPLICATION.getTypeId(), null, null, 108, null), composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(RowScope TextButton, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1080996956, i3, -1, "cz.mobilesoft.coreblock.scene.app_feel.screens.ComposableSingletons$AppFeelLabelingScreenKt.lambda$-1080996956.<anonymous> (AppFeelLabelingScreen.kt:447)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierJ = PaddingKt.j(companion, Dp.g(4), Dp.g(2));
            Alignment.Companion companion2 = Alignment.f25072a;
            float f3 = 8;
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.p(Dp.g(f3), companion2.g()), companion2.i(), composer, 54);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierJ);
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
            Updater.e(composerA, measurePolicyB, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            IconKt.c(PainterResources_androidKt.c(R.drawable.p4, composer, 0), null, SizeKt.v(companion, Dp.g(16)), ComposeColorsKt.j(composer, 0).Y(), composer, 432, 0);
            TextKt.c(StringResources_androidKt.b(R.string.Ud, composer, 0), PaddingKt.i(companion, Dp.g(f3)), ComposeColorsKt.j(composer, 0).Y(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).i(), composer, 48, 0, 65528);
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
    public static final Unit m(RowScope TextButton, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-5200627, i3, -1, "cz.mobilesoft.coreblock.scene.app_feel.screens.ComposableSingletons$AppFeelLabelingScreenKt.lambda$-5200627.<anonymous> (AppFeelLabelingScreen.kt:421)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 2;
            Modifier modifierJ = PaddingKt.j(companion, Dp.g(4), Dp.g(f3));
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.o(Dp.g(f3)), Alignment.f25072a.i(), composer, 54);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierJ);
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
            IconKt.d(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.C1, composer, 6), null, SizeKt.v(companion, Dp.g(20)), ComposeColorsKt.j(composer, 0).O(), composer, 432, 0);
            TextKt.c(StringResources_androidKt.b(R.string.Ud, composer, 0), null, ComposeColorsKt.j(composer, 0).O(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).i(), composer, 0, 0, 65018);
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
    public static final Unit n(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-545975959, i3, -1, "cz.mobilesoft.coreblock.scene.app_feel.screens.ComposableSingletons$AppFeelLabelingScreenKt.lambda$-545975959.<anonymous> (AppFeelLabelingScreen.kt:686)");
            }
            AppFeelViewState appFeelViewState = new AppFeelViewState(false, null, null, null, 15, null);
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.app_feel.screens.e1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$AppFeelLabelingScreenKt.o((String) obj);
                    }
                };
                composer.w(objG);
            }
            Function1 function1 = (Function1) objG;
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.app_feel.screens.f1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ComposableSingletons$AppFeelLabelingScreenKt.p((String) obj, (AppDistractionType) obj2);
                    }
                };
                composer.w(objG2);
            }
            Function2 function2 = (Function2) objG2;
            Object objG3 = composer.G();
            if (objG3 == companion.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.app_feel.screens.g1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$AppFeelLabelingScreenKt.q();
                    }
                };
                composer.w(objG3);
            }
            Function0 function0 = (Function0) objG3;
            Object objG4 = composer.G();
            if (objG4 == companion.a()) {
                objG4 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.app_feel.screens.h1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$AppFeelLabelingScreenKt.r();
                    }
                };
                composer.w(objG4);
            }
            AppFeelLabelingScreenKt.J(appFeelViewState, function1, function2, function0, (Function0) objG4, composer, 28080);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(String str) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(String str, AppDistractionType appDistractionType) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(appDistractionType, "<unused var>");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r() {
        return Unit.f139807a;
    }

    public final Function3 i() {
        return f98726c;
    }

    public final Function3 j() {
        return f98725b;
    }
}
