package cz.mobilesoft.coreblock.scene.permission.permissions.singlepermissions;

import android.content.Context;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.InspectionModeKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.Permission;
import cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeEvent;
import cz.mobilesoft.coreblock.scene.permission.permissions.SinglePermissionScreenConfig;
import cz.mobilesoft.coreblock.scene.permission.permissions.components.PermissionsHeaderKt;
import cz.mobilesoft.coreblock.scene.permission.permissions.components.StepsItemKt;
import cz.mobilesoft.coreblock.scene.permission.permissions.singlepermissions.SimplePermissionsConfigsKt;
import cz.mobilesoft.coreblock.util.permissions.PermissionDTO;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt;
import cz.mobilesoft.coreblock.view.viewholder.StepDTO;
import java.util.List;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class SimplePermissionsConfigsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Modifier modifier, final Permission permission, final Context context, final boolean z2, Composer composer, final int i3, final int i4) {
        Modifier modifier2;
        int i5;
        Context context2;
        boolean z3;
        final Modifier modifier3;
        Composer composerK = composer.k(-1109777522);
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
        if ((i3 & 48) == 0) {
            i5 |= composerK.Z(permission) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            context2 = context;
            i5 |= composerK.I(context2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } else {
            context2 = context;
        }
        if ((i3 & 3072) == 0) {
            z3 = z2;
            i5 |= composerK.b(z3) ? 2048 : 1024;
        } else {
            z3 = z2;
        }
        int i7 = i5;
        if (composerK.r((i7 & 1171) != 1170, i7 & 1)) {
            Modifier modifier4 = i6 != 0 ? Modifier.b8 : modifier2;
            if (ComposerKt.M()) {
                ComposerKt.U(-1109777522, i7, -1, "cz.mobilesoft.coreblock.scene.permission.permissions.singlepermissions.SimplePermissionContent (SimplePermissionsConfigs.kt:64)");
            }
            ScrollState scrollStateC = ScrollKt.c(0, composerK, 0, 1);
            boolean zBooleanValue = ((Boolean) composerK.q(InspectionModeKt.a())).booleanValue();
            Modifier modifierG = ScrollKt.g(PaddingKt.k(SizeKt.h(modifier4, 0.0f, 1, null), Dp.g(16), 0.0f, 2, null), scrollStateC, false, null, false, 14, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.g(), composerK, 48);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierG);
            ComposeUiNode.Companion companion = ComposeUiNode.f8;
            Function0 function0A = companion.a();
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
            Updater.e(composerA, measurePolicyA, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            Modifier.Companion companion2 = Modifier.b8;
            BoxKt.a(SizeKt.h(SizeKt.i(WindowInsetsPaddingKt.d(companion2, WindowInsets_androidKt.d(WindowInsets.f7172a, composerK, 6)), Dp.g(56)), 0.0f, 1, null), composerK, 0);
            PermissionsHeaderKt.e(z3, StringResources_androidKt.b(R.string.Nn, composerK, 0), StringResources_androidKt.b(Permission.j(permission, false, 1, null), composerK, 0), Permission.e(permission, context2, false, false, 6, null), composerK, (i7 >> 9) & 14, 0);
            composerK = composerK;
            if (zBooleanValue) {
                composerK.a0(-950442230);
            } else {
                composerK.a0(-1277467185);
                List<StepDTO> listH = permission.h(context);
                if (listH == null) {
                    composerK.a0(-946777070);
                } else {
                    composerK.a0(-946777069);
                    SpacerKt.a(SizeKt.i(companion2, Dp.g(24)), composerK, 6);
                    composerK.a0(-1277464223);
                    for (StepDTO stepDTO : listH) {
                        Modifier.Companion companion3 = Modifier.b8;
                        StepsItemKt.c(SizeKt.h(companion3, 0.0f, 1, null), stepDTO.a(), stepDTO.b().toString(), composerK, 6, 0);
                        SpacerKt.a(SizeKt.i(companion3, Dp.g(8)), composerK, 6);
                    }
                    composerK.U();
                }
                composerK.U();
            }
            composerK.U();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            modifier3 = modifier4;
        } else {
            composerK.Q();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: i1.h0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SimplePermissionsConfigsKt.g(modifier3, permission, context, z2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(Modifier modifier, Permission permission, Context context, boolean z2, int i3, int i4, Composer composer, int i5) {
        f(modifier, permission, context, z2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(final PermissionDTO permissionDTO, final Function1 function1, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Composer composerK = composer.k(-890198611);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(permissionDTO) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function1) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-890198611, i4, -1, "cz.mobilesoft.coreblock.scene.permission.permissions.singlepermissions.UsageAccessBottomBar (SimplePermissionsConfigs.kt:113)");
            }
            Modifier modifierM = PaddingKt.m(PaddingKt.k(SizeKt.h(Modifier.b8, 0.0f, 1, null), PrimitiveResources_androidKt.a(R.dimen.f95467a, composerK, 0), 0.0f, 2, null), 0.0f, 0.0f, 0.0f, Dp.g(16), 7, null);
            String strB = StringResources_androidKt.b(R.string.Qm, composerK, 0);
            boolean z2 = ((i4 & 112) == 32) | ((i4 & 14) == 4);
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: i1.i0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SimplePermissionsConfigsKt.i(function1, permissionDTO);
                    }
                };
                composerK.w(objG);
            }
            composer2 = composerK;
            FlatButtonsKt.u(modifierM, 0.0f, 0.0f, null, null, null, strB, null, 0L, null, null, false, false, (Function0) objG, composer2, 805306368, 0, 7614);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: i1.j0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SimplePermissionsConfigsKt.j(permissionDTO, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(Function1 function1, PermissionDTO permissionDTO) {
        function1.invoke(new PermissionComposeEvent.OnPermissionClick(permissionDTO, false));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(PermissionDTO permissionDTO, Function1 function1, int i3, Composer composer, int i4) {
        h(permissionDTO, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final SinglePermissionScreenConfig m(final PermissionDTO permission, final Function1 onEvent, final Context context, final boolean z2, Composer composer, int i3, int i4) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Intrinsics.checkNotNullParameter(context, "context");
        if ((i4 & 8) != 0) {
            z2 = false;
        }
        if (ComposerKt.M()) {
            ComposerKt.U(-1898167601, i3, -1, "cz.mobilesoft.coreblock.scene.permission.permissions.singlepermissions.simplePermissionConfig (SimplePermissionsConfigs.kt:39)");
        }
        SinglePermissionScreenConfig singlePermissionScreenConfig = new SinglePermissionScreenConfig(ComposableLambdaKt.e(-1262276139, true, new Function3() { // from class: i1.k0
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return SimplePermissionsConfigsKt.n(permission, context, z2, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, composer, 54), ComposableLambdaKt.e(-368093651, true, new Function2() { // from class: i1.l0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return SimplePermissionsConfigsKt.o(permission, onEvent, (Composer) obj, ((Integer) obj2).intValue());
            }
        }, composer, 54));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return singlePermissionScreenConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(PermissionDTO permissionDTO, Context context, boolean z2, Modifier modifier, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        if ((i3 & 6) == 0) {
            i3 |= composer.Z(modifier) ? 4 : 2;
        }
        if (composer.r((i3 & 19) != 18, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1262276139, i3, -1, "cz.mobilesoft.coreblock.scene.permission.permissions.singlepermissions.simplePermissionConfig.<anonymous> (SimplePermissionsConfigs.kt:42)");
            }
            f(modifier, permissionDTO.e(), context, z2, composer, i3 & 14, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(PermissionDTO permissionDTO, Function1 function1, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-368093651, i3, -1, "cz.mobilesoft.coreblock.scene.permission.permissions.singlepermissions.simplePermissionConfig.<anonymous> (SimplePermissionsConfigs.kt:50)");
            }
            h(permissionDTO, function1, composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }
}
