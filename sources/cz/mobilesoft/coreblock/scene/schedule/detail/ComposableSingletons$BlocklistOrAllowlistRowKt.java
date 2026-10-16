package cz.mobilesoft.coreblock.scene.schedule.detail;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
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
import cz.mobilesoft.coreblock.scene.schedule.ScheduleViewEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ExtensionsKt;

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
public final class ComposableSingletons$BlocklistOrAllowlistRowKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$BlocklistOrAllowlistRowKt f116509a = new ComposableSingletons$BlocklistOrAllowlistRowKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f116510b = ComposableLambdaKt.c(1406284677, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.z0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BlocklistOrAllowlistRowKt.i((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f116511c = ComposableLambdaKt.c(1086872876, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.a1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BlocklistOrAllowlistRowKt.g((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Function2 f116512d = ComposableLambdaKt.c(457279676, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.b1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BlocklistOrAllowlistRowKt.j((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Function2 f116513e = ComposableLambdaKt.c(1329518409, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.c1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BlocklistOrAllowlistRowKt.h((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Function2 f116514f = ComposableLambdaKt.c(-741137936, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.d1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BlocklistOrAllowlistRowKt.l((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1086872876, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.ComposableSingletons$BlocklistOrAllowlistRowKt.lambda$1086872876.<anonymous> (BlocklistOrAllowlistRow.kt:93)");
            }
            BlocklistOrAllowlistRowKt.n0(true, composer, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1329518409, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.ComposableSingletons$BlocklistOrAllowlistRowKt.lambda$1329518409.<anonymous> (BlocklistOrAllowlistRow.kt:121)");
            }
            BlocklistOrAllowlistRowKt.O(false, composer, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1406284677, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.ComposableSingletons$BlocklistOrAllowlistRowKt.lambda$1406284677.<anonymous> (BlocklistOrAllowlistRow.kt:85)");
            }
            BlocklistOrAllowlistRowKt.n0(false, composer, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(457279676, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.ComposableSingletons$BlocklistOrAllowlistRowKt.lambda$457279676.<anonymous> (BlocklistOrAllowlistRow.kt:101)");
            }
            Modifier.Companion companion = Modifier.b8;
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, companion);
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
            Updater.e(composerA, measurePolicyA, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            Blocking blocking = new Blocking(null, null, false, ExtensionsKt.a(), ExtensionsKt.a(), null, null, null, 227, null);
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.e1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$BlocklistOrAllowlistRowKt.k((ScheduleViewEvent) obj);
                    }
                };
                composer.w(objG);
            }
            BlocklistOrAllowlistRowKt.d0(false, blocking, false, false, false, (Function1) objG, composer, 196614, 28);
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
    public static final Unit k(ScheduleViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-741137936, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.ComposableSingletons$BlocklistOrAllowlistRowKt.lambda$-741137936.<anonymous> (BlocklistOrAllowlistRow.kt:129)");
            }
            BlocklistOrAllowlistRowKt.O(true, composer, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }
}
