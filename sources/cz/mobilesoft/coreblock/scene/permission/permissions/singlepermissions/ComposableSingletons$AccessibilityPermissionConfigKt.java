package cz.mobilesoft.coreblock.scene.permission.permissions.singlepermissions;

import android.content.Context;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
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
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.enums.Permission;
import cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeEvent;
import cz.mobilesoft.coreblock.scene.permission.permissions.singlepermissions.ComposableSingletons$AccessibilityPermissionConfigKt;
import cz.mobilesoft.coreblock.util.permissions.PermissionDTO;
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
public final class ComposableSingletons$AccessibilityPermissionConfigKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$AccessibilityPermissionConfigKt f112234a = new ComposableSingletons$AccessibilityPermissionConfigKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f112235b = ComposableLambdaKt.c(-1301469791, false, new Function2() { // from class: i1.r
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AccessibilityPermissionConfigKt.m((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f112236c = ComposableLambdaKt.c(1583133077, false, new Function2() { // from class: i1.s
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AccessibilityPermissionConfigKt.i((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Function2 f112237d = ComposableLambdaKt.c(651982621, false, new Function2() { // from class: i1.t
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AccessibilityPermissionConfigKt.k((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Function2 f112238e = ComposableLambdaKt.c(-1581150401, false, new Function2() { // from class: i1.u
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AccessibilityPermissionConfigKt.o((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1583133077, i3, -1, "cz.mobilesoft.coreblock.scene.permission.permissions.singlepermissions.ComposableSingletons$AccessibilityPermissionConfigKt.lambda$1583133077.<anonymous> (AccessibilityPermissionConfig.kt:381)");
            }
            PermissionDTO permissionDTO = new PermissionDTO(new Permission.ACCESSIBILITY(null, false, 3, null), false, false, 6, null);
            Context context = (Context) composer.q(AndroidCompositionLocals_androidKt.g());
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: i1.x
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$AccessibilityPermissionConfigKt.j((PermissionComposeEvent) obj);
                    }
                };
                composer.w(objG);
            }
            AccessibilityPermissionConfigKt.w(null, permissionDTO, context, false, true, false, (Function1) objG, composer, 1797120, 1);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(PermissionComposeEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(651982621, i3, -1, "cz.mobilesoft.coreblock.scene.permission.permissions.singlepermissions.ComposableSingletons$AccessibilityPermissionConfigKt.lambda$651982621.<anonymous> (AccessibilityPermissionConfig.kt:396)");
            }
            PermissionDTO permissionDTO = new PermissionDTO(new Permission.ACCESSIBILITY(null, false, 3, null), false, false, 6, null);
            Context context = (Context) composer.q(AndroidCompositionLocals_androidKt.g());
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: i1.v
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$AccessibilityPermissionConfigKt.l((PermissionComposeEvent) obj);
                    }
                };
                composer.w(objG);
            }
            AccessibilityPermissionConfigKt.w(null, permissionDTO, context, false, true, true, (Function1) objG, composer, 1797120, 1);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(PermissionComposeEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1301469791, i3, -1, "cz.mobilesoft.coreblock.scene.permission.permissions.singlepermissions.ComposableSingletons$AccessibilityPermissionConfigKt.lambda$-1301469791.<anonymous> (AccessibilityPermissionConfig.kt:357)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierH);
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
            AccessibilityPermissionConfigKt.u(companion, new Permission.ACCESSIBILITY(null, false, 3, null), (Context) composer.q(AndroidCompositionLocals_androidKt.g()), false, composer, 3078, 0);
            SpacerKt.a(SizeKt.i(companion, Dp.g(16)), composer, 6);
            PermissionDTO permissionDTO = new PermissionDTO(new Permission.ACCESSIBILITY(null, false, 3, null), false, false, 6, null);
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: i1.y
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$AccessibilityPermissionConfigKt.n((PermissionComposeEvent) obj);
                    }
                };
                composer.w(objG);
            }
            AccessibilityPermissionConfigKt.r(permissionDTO, (Function1) objG, composer, 48);
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
    public static final Unit n(PermissionComposeEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1581150401, i3, -1, "cz.mobilesoft.coreblock.scene.permission.permissions.singlepermissions.ComposableSingletons$AccessibilityPermissionConfigKt.lambda$-1581150401.<anonymous> (AccessibilityPermissionConfig.kt:411)");
            }
            PermissionDTO permissionDTO = new PermissionDTO(new Permission.ACCESSIBILITY(null, false, 3, null), false, false, 6, null);
            Context context = (Context) composer.q(AndroidCompositionLocals_androidKt.g());
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: i1.w
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$AccessibilityPermissionConfigKt.p((PermissionComposeEvent) obj);
                    }
                };
                composer.w(objG);
            }
            AccessibilityPermissionConfigKt.w(null, permissionDTO, context, false, false, true, (Function1) objG, composer, 1797120, 1);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(PermissionComposeEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }
}
