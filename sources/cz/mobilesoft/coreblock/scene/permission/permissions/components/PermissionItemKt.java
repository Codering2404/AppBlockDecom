package cz.mobilesoft.coreblock.scene.permission.permissions.components;

import android.content.Context;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.Permission;
import cz.mobilesoft.coreblock.scene.permission.permissions.components.PermissionItemKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.permissions.PermissionDTO;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
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
public final class PermissionItemKt {
    /* JADX WARN: Removed duplicated region for block: B:33:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:77:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void f(androidx.compose.ui.Modifier r20, final cz.mobilesoft.coreblock.util.permissions.PermissionDTO r21, boolean r22, final kotlin.jvm.functions.Function0 r23, androidx.compose.runtime.Composer r24, final int r25, final int r26) {
        /*
            Method dump skipped, instruction units count: 344
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.permission.permissions.components.PermissionItemKt.f(androidx.compose.ui.Modifier, cz.mobilesoft.coreblock.util.permissions.PermissionDTO, boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(PermissionDTO permissionDTO, boolean z2, Context context, final Function0 function0, ColumnScope BorderedCard, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(BorderedCard, "$this$BorderedCard");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-305571585, i3, -1, "cz.mobilesoft.coreblock.scene.permission.permissions.components.PermissionItem.<anonymous> (PermissionItem.kt:45)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierI = PaddingKt.i(SizeKt.h(companion, 0.0f, 1, null), Dp.g(f3));
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierI);
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
            String strB = StringResources_androidKt.b(permissionDTO.e().i(z2), composer, 0);
            MaterialTheme materialTheme = MaterialTheme.f13091a;
            int i4 = MaterialTheme.f13092b;
            TextKt.c(strB, null, ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, materialTheme.c(composer, i4).i(), composer, 0, 0, 65530);
            SpacerKt.a(SizeKt.i(companion, Dp.g(8)), composer, 6);
            TextKt.c(Permission.e(permissionDTO.e(), context, false, z2, 2, null), null, ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, materialTheme.c(composer, i4).b(), composer, 0, 0, 65530);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
            if (permissionDTO.c()) {
                composer.a0(1441927504);
                ButtonType.MediumRound mediumRound = new ButtonType.MediumRound(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.U, composer, 6), null, StringResources_androidKt.b(R.string.qd, composer, 0), null, false, 26, null);
                ButtonColor.Custom custom = new ButtonColor.Custom(true, null, false, Color.n(ComposeColorsKt.j(composer, 0).A()), null, Color.n(ComposeColorsKt.j(composer, 0).q0()), 22, null);
                boolean Z = composer.Z(function0);
                Object objG = composer.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: h1.p
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return PermissionItemKt.i(function0);
                        }
                    };
                    composer.w(objG);
                }
                ComposeButtonsKt.i0(null, mediumRound, custom, (Function0) objG, composer, 0, 1);
                composer.U();
            } else {
                composer.a0(1442555874);
                ButtonType.MediumRound mediumRound2 = new ButtonType.MediumRound(null, null, StringResources_androidKt.b(R.string.md, composer, 0), null, false, 27, null);
                ButtonColor.Accent accent = new ButtonColor.Accent(false, null, false, null, 15, null);
                boolean Z2 = composer.Z(function0);
                Object objG2 = composer.G();
                if (Z2 || objG2 == Composer.f23746a.a()) {
                    objG2 = new Function0() { // from class: h1.q
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return PermissionItemKt.j(function0);
                        }
                    };
                    composer.w(objG2);
                }
                ComposeButtonsKt.i0(null, mediumRound2, accent, (Function0) objG2, composer, 0, 1);
                composer.U();
            }
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
    public static final Unit i(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(Modifier modifier, PermissionDTO permissionDTO, boolean z2, Function0 function0, int i3, int i4, Composer composer, int i5) {
        f(modifier, permissionDTO, z2, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }
}
