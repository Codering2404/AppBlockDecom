package cz.mobilesoft.coreblock.view.compose;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.DoneKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.components.SensibleDefaults;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
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
public final class ComposableSingletons$ComposeDropdownKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$ComposeDropdownKt f130382a = new ComposableSingletons$ComposeDropdownKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f130383b = ComposableLambdaKt.c(416975466, false, new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.p0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ComposeDropdownKt.f((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(416975466, i3, -1, "cz.mobilesoft.coreblock.view.compose.ComposableSingletons$ComposeDropdownKt.lambda$416975466.<anonymous> (ComposeDropdown.kt:139)");
            }
            Modifier modifierK = PaddingKt.k(SizeKt.A(Modifier.b8, Dp.g(200)), Dp.g(16), 0.0f, 2, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierK);
            ComposeUiNode.Companion companion = ComposeUiNode.f8;
            Function0 function0A = companion.a();
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
            Updater.e(composerA, measurePolicyA, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            Color colorN = Color.n(ComposeColorsKt.j(composer, 0).p());
            Icons icons = Icons.f15145a;
            ImageVector imageVectorA = DoneKt.a(icons.a());
            Object objG = composer.G();
            Composer.Companion companion2 = Composer.f23746a;
            if (objG == companion2.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.q0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$ComposeDropdownKt.g();
                    }
                };
                composer.w(objG);
            }
            ComposeDropdownKt.t(new ComposeDropdownItem("Enabled iconed", colorN, null, false, null, null, imageVectorA, null, (Function0) objG, 188, null), composer, 0);
            Color colorN2 = Color.n(ComposeColorsKt.j(composer, 0).k());
            ImageVector imageVectorA2 = DoneKt.a(icons.a());
            Object objG2 = composer.G();
            if (objG2 == companion2.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.r0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$ComposeDropdownKt.h();
                    }
                };
                composer.w(objG2);
            }
            ComposeDropdownKt.t(new ComposeDropdownItem("Item with long t", colorN2, null, false, null, null, imageVectorA2, null, (Function0) objG2, 188, null), composer, 0);
            long jK = ComposeColorsKt.j(composer, 0).k();
            ImageVector imageVectorA3 = DoneKt.a(icons.a());
            Color colorN3 = Color.n(jK);
            Object objG3 = composer.G();
            if (objG3 == companion2.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.s0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$ComposeDropdownKt.i();
                    }
                };
                composer.w(objG3);
            }
            ComposeDropdownKt.t(new ComposeDropdownItem("Disabled", colorN3, null, false, null, null, imageVectorA3, null, (Function0) objG3, SensibleDefaults.X_OFFSET, null), composer, 0);
            Object objG4 = composer.G();
            if (objG4 == companion2.a()) {
                objG4 = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.t0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$ComposeDropdownKt.j();
                    }
                };
                composer.w(objG4);
            }
            ComposeDropdownKt.t(new ComposeDropdownItem("No icon, no color", null, null, false, null, null, null, null, (Function0) objG4, 254, null), composer, 0);
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
    public static final Unit g() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j() {
        return Unit.f139807a;
    }
}
