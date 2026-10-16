package cz.mobilesoft.coreblock.scene.intro.schedule;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.TextKt;
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
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParserException;

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
public final class ComposableSingletons$GoodJobScreenKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$GoodJobScreenKt f104806a = new ComposableSingletons$GoodJobScreenKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f104807b = ComposableLambdaKt.c(-1623721735, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.intro.schedule.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$GoodJobScreenKt.f((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function3 f104808c = ComposableLambdaKt.c(75156706, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.intro.schedule.b
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$GoodJobScreenKt.e((PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(PaddingValues it, Composer composer, int i3) throws XmlPullParserException, IOException {
        int i4;
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(it) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(75156706, i4, -1, "cz.mobilesoft.coreblock.scene.intro.schedule.ComposableSingletons$GoodJobScreenKt.lambda$75156706.<anonymous> (GoodJobScreen.kt:40)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierH = PaddingKt.h(ScrollKt.g(SizeKt.f(companion, 0.0f, 1, null), ScrollKt.c(0, composer, 0, 1), false, null, false, 14, null), it);
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.Vertical verticalH = arrangement.h();
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
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            Modifier modifierC = columnScopeInstance.c(PaddingKt.k(companion, PrimitiveResources_androidKt.a(R.dimen.f95467a, composer, 0), 0.0f, 2, null), companion2.g());
            MeasurePolicy measurePolicyA2 = ColumnKt.a(arrangement.h(), companion2.k(), composer, 0);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierC);
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
            Updater.e(composerA2, measurePolicyA2, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.L7, composer, 6);
            Alignment alignmentE = companion2.e();
            Modifier modifierC2 = columnScopeInstance.c(companion, companion2.g());
            float f3 = 16;
            ImageKt.b(imageVectorB, null, PaddingKt.m(modifierC2, 0.0f, Dp.g(f3), 0.0f, 0.0f, 13, null), alignmentE, null, 0.0f, null, composer, 3120, 112);
            TextKt.c(StringResources_androidKt.b(R.string.BD, composer, 0), PaddingKt.m(companion, 0.0f, Dp.g(f3), 0.0f, 0.0f, 13, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).f(), composer, 48, 0, 65532);
            TextKt.c(StringResources_androidKt.b(R.string.ir, composer, 0), PaddingKt.m(companion, 0.0f, Dp.g(f3), 0.0f, 0.0f, 13, null), ComposeColorsKt.j(composer, 0).O(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).a(), composer, 48, 0, 65528);
            composer.y();
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
                ComposerKt.U(-1623721735, i3, -1, "cz.mobilesoft.coreblock.scene.intro.schedule.ComposableSingletons$GoodJobScreenKt.lambda$-1623721735.<anonymous> (GoodJobScreen.kt:32)");
            }
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.schedule.c
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$GoodJobScreenKt.g();
                    }
                };
                composer.w(objG);
            }
            GoodJobScreenKt.d((Function0) objG, composer, 6);
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
        return f104808c;
    }
}
