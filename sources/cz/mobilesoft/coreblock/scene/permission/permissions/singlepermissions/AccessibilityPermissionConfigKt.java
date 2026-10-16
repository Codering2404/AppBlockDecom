package cz.mobilesoft.coreblock.scene.permission.permissions.singlepermissions;

import android.content.Context;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.TextKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.InspectionModeKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.LinkAnnotation;
import androidx.compose.ui.text.LinkInteractionListener;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLinkStyles;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.Dp;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.Permission;
import cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeEvent;
import cz.mobilesoft.coreblock.scene.permission.permissions.SinglePermissionScreenConfig;
import cz.mobilesoft.coreblock.scene.permission.permissions.components.PermissionsHeaderKt;
import cz.mobilesoft.coreblock.scene.permission.permissions.components.StepsItemKt;
import cz.mobilesoft.coreblock.scene.permission.permissions.singlepermissions.AccessibilityPermissionConfigKt;
import cz.mobilesoft.coreblock.util.ExternalLinksHelper;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.permissions.PermissionDTO;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.material3.CardsKt;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt;
import cz.mobilesoft.coreblock.view.viewholder.StepDTO;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class AccessibilityPermissionConfigKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(Function1 function1, PermissionDTO permissionDTO) {
        AnswersHelper.f128199a.f0();
        function1.invoke(new PermissionComposeEvent.OnPermissionClick(permissionDTO, false));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(Modifier modifier, PermissionDTO permissionDTO, Context context, boolean z2, boolean z3, boolean z4, Function1 function1, int i3, int i4, Composer composer, int i5) {
        w(modifier, permissionDTO, context, z2, z3, z4, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final void C(Modifier modifier, Composer composer, final int i3, final int i4) {
        final Modifier modifier2;
        int i5;
        Composer composer2;
        Composer composerK = composer.k(448262600);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
            modifier2 = modifier;
        } else if ((i3 & 6) == 0) {
            modifier2 = modifier;
            i5 = i3 | (composerK.Z(modifier2) ? 4 : 2);
        } else {
            modifier2 = modifier;
            i5 = i3;
        }
        if (composerK.r((i5 & 3) != 2, i5 & 1)) {
            Modifier modifier3 = i6 != 0 ? Modifier.b8 : modifier2;
            if (ComposerKt.M()) {
                ComposerKt.U(448262600, i5, -1, "cz.mobilesoft.coreblock.scene.permission.permissions.singlepermissions.AdvancedProtectionListHeader (AccessibilityPermissionConfig.kt:226)");
            }
            Modifier modifierH = SizeKt.h(modifier3, 0.0f, 1, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.g(), composerK, 48);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierH);
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
            float f3 = 8;
            Modifier modifierK = PaddingKt.k(companion2, 0.0f, Dp.g(f3), 1, null);
            TextAlign.Companion companion3 = TextAlign.f29616b;
            int iA2 = companion3.a();
            String strB = StringResources_androidKt.b(R.string.f95789f0, composerK, 0);
            MaterialTheme materialTheme = MaterialTheme.f13091a;
            int i7 = MaterialTheme.f13092b;
            Modifier modifier4 = modifier3;
            composer2 = composerK;
            TextKt.c(strB, modifierK, ComposeColorsKt.j(composerK, 0).p(), 0L, null, null, null, 0L, null, TextAlign.h(iA2), 0L, 0, false, 0, 0, null, materialTheme.c(composerK, i7).f(), composer2, 48, 0, 65016);
            TextKt.c(StringResources_androidKt.c(R.string.f95785e0, new Object[]{StringResources_androidKt.b(R.string.f95790f1, composer2, 0)}, composer2, 0), PaddingKt.k(companion2, 0.0f, Dp.g(f3), 1, null), ComposeColorsKt.j(composer2, 0).q(), 0L, null, null, null, 0L, null, TextAlign.h(companion3.a()), 0L, 0, false, 0, 0, null, materialTheme.c(composer2, i7).b(), composer2, 48, 0, 65016);
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            modifier2 = modifier4;
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: i1.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AccessibilityPermissionConfigKt.D(modifier2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(Modifier modifier, int i3, int i4, Composer composer, int i5) {
        C(modifier, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final void E(Modifier modifier, final String str, final AnnotatedString annotatedString, final Function2 function2, Composer composer, final int i3, final int i4) {
        Modifier modifier2;
        int i5;
        final Modifier modifier3;
        Composer composerK = composer.k(-1153755428);
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
            i5 |= composerK.Z(str) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerK.Z(annotatedString) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i5 |= composerK.I(function2) ? 2048 : 1024;
        }
        if (composerK.r((i5 & 1171) != 1170, i5 & 1)) {
            modifier3 = i6 != 0 ? Modifier.b8 : modifier2;
            if (ComposerKt.M()) {
                ComposerKt.U(-1153755428, i5, -1, "cz.mobilesoft.coreblock.scene.permission.permissions.singlepermissions.AdvancedProtectionStepCard (AccessibilityPermissionConfig.kt:276)");
            }
            CardsKt.k(SizeKt.h(modifier3, 0.0f, 1, null), 0L, 0.0f, null, null, ComposableLambdaKt.e(51377753, true, new Function3() { // from class: i1.p
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AccessibilityPermissionConfigKt.F(str, annotatedString, function2, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 196608, 30);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: i1.q
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AccessibilityPermissionConfigKt.G(modifier3, str, annotatedString, function2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(String str, AnnotatedString annotatedString, Function2 function2, ColumnScope BaseCard, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(BaseCard, "$this$BaseCard");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(51377753, i3, -1, "cz.mobilesoft.coreblock.scene.permission.permissions.singlepermissions.AdvancedProtectionStepCard.<anonymous> (AccessibilityPermissionConfig.kt:280)");
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
            MaterialTheme materialTheme = MaterialTheme.f13091a;
            int i4 = MaterialTheme.f13092b;
            TextKt.c(str, null, ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, materialTheme.c(composer, i4).i(), composer, 0, 0, 65530);
            SpacerKt.a(SizeKt.i(companion, Dp.g(8)), composer, 6);
            TextKt.d(annotatedString, null, ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, materialTheme.c(composer, i4).b(), composer, 0, 0, 131066);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
            function2.invoke(composer, 0);
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
    public static final Unit G(Modifier modifier, String str, AnnotatedString annotatedString, Function2 function2, int i3, int i4, Composer composer, int i5) {
        E(modifier, str, annotatedString, function2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final void H(String str, Function0 function0, Composer composer, final int i3) {
        int i4;
        final String str2;
        final Function0 function02;
        Composer composer2;
        Composer composerK = composer.k(-1325742368);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(str) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function0) ? 32 : 16;
        }
        int i5 = i4;
        if (composerK.r((i5 & 19) != 18, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1325742368, i5, -1, "cz.mobilesoft.coreblock.scene.permission.permissions.singlepermissions.StepActionButton (AccessibilityPermissionConfig.kt:310)");
            }
            str2 = str;
            function02 = function0;
            composer2 = composerK;
            ComposeButtonsKt.i0(null, new ButtonType.MediumRound(null, null, str, null, false, 27, null), new ButtonColor.Accent(false, null, false, null, 15, null), function02, composer2, (i5 << 6) & 7168, 1);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            str2 = str;
            function02 = function0;
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: i1.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AccessibilityPermissionConfigKt.I(str2, function02, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(String str, Function0 function0, int i3, Composer composer, int i4) {
        H(str, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void J(Composer composer, final int i3) {
        Composer composerK = composer.k(-1959489833);
        if (composerK.r(i3 != 0, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1959489833, i3, -1, "cz.mobilesoft.coreblock.scene.permission.permissions.singlepermissions.StepDoneButton (AccessibilityPermissionConfig.kt:320)");
            }
            ButtonType.MediumRound mediumRound = new ButtonType.MediumRound(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.U, composerK, 6), null, StringResources_androidKt.b(R.string.Ac, composerK, 0), null, false, 26, null);
            ButtonColor.Custom custom = new ButtonColor.Custom(true, null, false, Color.n(ComposeColorsKt.j(composerK, 0).A()), null, Color.n(ComposeColorsKt.j(composerK, 0).q0()), 22, null);
            Object objG = composerK.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: i1.d
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AccessibilityPermissionConfigKt.K();
                    }
                };
                composerK.w(objG);
            }
            ComposeButtonsKt.i0(null, mediumRound, custom, (Function0) objG, composerK, 3072, 1);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: i1.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AccessibilityPermissionConfigKt.L(i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(int i3, Composer composer, int i4) {
        J(composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final SinglePermissionScreenConfig P(final PermissionDTO permission, final Function1 onEvent, final Context context, boolean z2, boolean z3, boolean z4, boolean z5, Composer composer, int i3, int i4) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Intrinsics.checkNotNullParameter(context, "context");
        final boolean z6 = (i4 & 8) != 0 ? false : z2;
        final boolean z7 = (i4 & 16) != 0 ? false : z3;
        final boolean z8 = (i4 & 32) != 0 ? false : z4;
        final boolean z9 = (i4 & 64) != 0 ? false : z5;
        if (ComposerKt.M()) {
            ComposerKt.U(1965598421, i3, -1, "cz.mobilesoft.coreblock.scene.permission.permissions.singlepermissions.accessibilityPermissionConfig (AccessibilityPermissionConfig.kt:70)");
        }
        SinglePermissionScreenConfig singlePermissionScreenConfig = new SinglePermissionScreenConfig(ComposableLambdaKt.e(1148390107, true, new Function3() { // from class: i1.g
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return AccessibilityPermissionConfigKt.Q(z7, permission, context, z6, z8, z9, onEvent, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, composer, 54), ComposableLambdaKt.e(523100979, true, new Function2() { // from class: i1.h
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AccessibilityPermissionConfigKt.R(z7, permission, onEvent, (Composer) obj, ((Integer) obj2).intValue());
            }
        }, composer, 54));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return singlePermissionScreenConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q(boolean z2, PermissionDTO permissionDTO, Context context, boolean z3, boolean z4, boolean z5, Function1 function1, Modifier modifier, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(modifier) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1148390107, i4, -1, "cz.mobilesoft.coreblock.scene.permission.permissions.singlepermissions.accessibilityPermissionConfig.<anonymous> (AccessibilityPermissionConfig.kt:73)");
            }
            if (z2) {
                composer.a0(-2019724332);
                w(modifier, permissionDTO, context, z3, z4, z5, function1, composer, i4 & 14, 0);
                composer.U();
            } else {
                composer.a0(-2019229386);
                u(modifier, permissionDTO.e(), context, z3, composer, i4 & 14, 0);
                composer.U();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R(boolean z2, PermissionDTO permissionDTO, Function1 function1, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(523100979, i3, -1, "cz.mobilesoft.coreblock.scene.permission.permissions.singlepermissions.accessibilityPermissionConfig.<anonymous> (AccessibilityPermissionConfig.kt:93)");
            }
            if (z2) {
                composer.a0(1555217391);
            } else {
                composer.a0(1559972915);
                r(permissionDTO, function1, composer, 0);
            }
            composer.U();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    private static final AnnotatedString S(final Context context, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-19235876, i3, -1, "cz.mobilesoft.coreblock.scene.permission.permissions.singlepermissions.advancedProtectionStepDescription (AccessibilityPermissionConfig.kt:251)");
        }
        composer.a0(-1305804678);
        AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
        builder.l(StringResources_androidKt.b(R.string.f95775c0, composer, 0));
        builder.l(" ");
        TextLinkStyles textLinkStyles = new TextLinkStyles(new SpanStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.f29625b.d(), (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 61439, (DefaultConstructorMarker) null), null, null, null, 14, null);
        boolean zI = composer.I(context);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new LinkInteractionListener() { // from class: i1.n
                @Override // androidx.compose.ui.text.LinkInteractionListener
                public final void a(LinkAnnotation linkAnnotation) {
                    AccessibilityPermissionConfigKt.T(context, linkAnnotation);
                }
            };
            composer.w(objG);
        }
        LinkAnnotation.Clickable clickable = new LinkAnnotation.Clickable("advanced_protection_learn_more", textLinkStyles, (LinkInteractionListener) objG);
        composer.a0(-1305789754);
        int iR = builder.r(clickable);
        try {
            builder.l(StringResources_androidKt.b(R.string.Ci, composer, 0));
            Unit unit = Unit.f139807a;
            builder.q(iR);
            composer.U();
            builder.l(".");
            AnnotatedString annotatedStringT = builder.t();
            composer.U();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            return annotatedStringT;
        } catch (Throwable th) {
            builder.q(iR);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(Context context, LinkAnnotation it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ExternalLinksHelper.f127866a.d(context, "https://appblock.app/advanced-protection-may-affect-appblock-blocking-on-android/");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(final PermissionDTO permissionDTO, final Function1 function1, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Composer composerK = composer.k(-2044114598);
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
                ComposerKt.U(-2044114598, i4, -1, "cz.mobilesoft.coreblock.scene.permission.permissions.singlepermissions.AccessibilityBottomBar (AccessibilityPermissionConfig.kt:339)");
            }
            Modifier modifierM = PaddingKt.m(PaddingKt.k(SizeKt.h(Modifier.b8, 0.0f, 1, null), PrimitiveResources_androidKt.a(R.dimen.f95467a, composerK, 0), 0.0f, 2, null), 0.0f, 0.0f, 0.0f, Dp.g(16), 7, null);
            String strB = StringResources_androidKt.b(R.string.Qm, composerK, 0);
            boolean z2 = ((i4 & 112) == 32) | ((i4 & 14) == 4);
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: i1.i
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AccessibilityPermissionConfigKt.s(function1, permissionDTO);
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
            scopeUpdateScopeN.a(new Function2() { // from class: i1.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AccessibilityPermissionConfigKt.t(permissionDTO, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(Function1 function1, PermissionDTO permissionDTO) {
        function1.invoke(new PermissionComposeEvent.OnPermissionClick(permissionDTO, false));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(PermissionDTO permissionDTO, Function1 function1, int i3, Composer composer, int i4) {
        r(permissionDTO, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(Modifier modifier, final Permission permission, final Context context, final boolean z2, Composer composer, final int i3, final int i4) {
        Modifier modifier2;
        int i5;
        Context context2;
        boolean z3;
        final Modifier modifier3;
        Composer composerK = composer.k(-30559966);
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
                ComposerKt.U(-30559966, i7, -1, "cz.mobilesoft.coreblock.scene.permission.permissions.singlepermissions.AccessibilityPermissionContent (AccessibilityPermissionConfig.kt:109)");
            }
            ScrollState scrollStateC = ScrollKt.c(0, composerK, 0, 1);
            boolean zBooleanValue = ((Boolean) composerK.q(InspectionModeKt.a())).booleanValue();
            Modifier modifierG = ScrollKt.g(SizeKt.h(PaddingKt.k(modifier4, Dp.g(16), 0.0f, 2, null), 0.0f, 1, null), scrollStateC, false, null, false, 14, null);
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
                composerK.a0(-1361934442);
            } else {
                composerK.a0(1203191299);
                List<StepDTO> listH = permission.h(context);
                if (listH == null) {
                    composerK.a0(-1355775394);
                } else {
                    composerK.a0(-1355775393);
                    SpacerKt.a(SizeKt.i(companion2, Dp.g(24)), composerK, 6);
                    composerK.a0(1203194261);
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
            scopeUpdateScopeN.a(new Function2() { // from class: i1.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AccessibilityPermissionConfigKt.v(modifier3, permission, context, z2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(Modifier modifier, Permission permission, Context context, boolean z2, int i3, int i4, Composer composer, int i5) {
        u(modifier, permission, context, z2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void w(Modifier modifier, final PermissionDTO permissionDTO, Context context, final boolean z2, final boolean z3, final boolean z4, final Function1 function1, Composer composer, final int i3, final int i4) {
        int i5;
        Context context2;
        final Modifier modifier2;
        int i6;
        int i7;
        Modifier modifier3;
        int i8;
        int i9;
        float f3;
        int i10;
        Composer composerK = composer.k(1007562196);
        int i11 = i4 & 1;
        if (i11 != 0) {
            i5 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i5 = (composerK.Z(modifier) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.Z(permissionDTO) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerK.I(context) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i5 |= composerK.b(z2) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i5 |= composerK.b(z3) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i5 |= composerK.b(z4) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i3) == 0) {
            i5 |= composerK.I(function1) ? 1048576 : 524288;
        }
        int i12 = i5;
        if (composerK.r((599187 & i12) != 599186, i12 & 1)) {
            Modifier modifier4 = i11 != 0 ? Modifier.b8 : modifier;
            if (ComposerKt.M()) {
                ComposerKt.U(1007562196, i12, -1, "cz.mobilesoft.coreblock.scene.permission.permissions.singlepermissions.AdvancedProtectionContent (AccessibilityPermissionConfig.kt:163)");
            }
            float f4 = 16;
            Modifier modifierG = ScrollKt.g(SizeKt.h(PaddingKt.k(modifier4, Dp.g(f4), 0.0f, 2, null), 0.0f, 1, null), ScrollKt.c(0, composerK, 0, 1), false, null, false, 14, null);
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
            if (z4) {
                composerK.a0(-13435026);
                C(null, composerK, 0, 1);
                composerK.U();
                context2 = context;
                i7 = 0;
                modifier3 = modifier4;
                i6 = 1;
                f3 = f4;
                i8 = 6;
                i9 = i12;
                i10 = 2;
            } else {
                composerK.a0(-13366485);
                i6 = 1;
                i7 = 0;
                modifier3 = modifier4;
                context2 = context;
                i8 = 6;
                i9 = i12;
                f3 = f4;
                i10 = 2;
                PermissionsHeaderKt.e(z2, StringResources_androidKt.b(R.string.Nn, composerK, 0), StringResources_androidKt.b(Permission.j(permissionDTO.e(), false, 1, null), composerK, 0), Permission.e(permissionDTO.e(), context2, false, false, 6, null), composerK, (i12 >> 9) & 14, 0);
                composerK.U();
            }
            SpacerKt.a(SizeKt.i(companion2, Dp.g(24)), composerK, i8);
            int i13 = R.string.xA;
            int i14 = i10;
            boolean z5 = i6;
            E(null, StringResources_androidKt.c(i13, new Object[]{Integer.valueOf(i6)}, composerK, i7), S(context2, composerK, (i9 >> i8) & 14), ComposableLambdaKt.e(-706048969, z5, new Function2() { // from class: i1.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AccessibilityPermissionConfigKt.x(z3, function1, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, 3072, 1);
            SpacerKt.a(SizeKt.i(companion2, Dp.g(8)), composerK, i8);
            E(null, StringResources_androidKt.c(i13, new Object[]{Integer.valueOf(i14)}, composerK, i7), new AnnotatedString(StringResources_androidKt.c(R.string.f95780d0, new Object[]{StringResources_androidKt.b(R.string.f95790f1, composerK, i7)}, composerK, i7), null, i14, null), ComposableLambdaKt.e(333324384, z5, new Function2() { // from class: i1.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AccessibilityPermissionConfigKt.z(function1, permissionDTO, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, 3072, 1);
            SpacerKt.a(SizeKt.i(companion2, Dp.g(f3)), composerK, i8);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            modifier2 = modifier3;
        } else {
            context2 = context;
            composerK.Q();
            modifier2 = modifier;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            final Context context3 = context2;
            scopeUpdateScopeN.a(new Function2() { // from class: i1.m
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AccessibilityPermissionConfigKt.B(modifier2, permissionDTO, context3, z2, z3, z4, function1, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(boolean z2, final Function1 function1, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-706048969, i3, -1, "cz.mobilesoft.coreblock.scene.permission.permissions.singlepermissions.AdvancedProtectionContent.<anonymous>.<anonymous> (AccessibilityPermissionConfig.kt:197)");
            }
            if (z2) {
                composer.a0(-1449933614);
                String strB = StringResources_androidKt.b(R.string.f95771b0, composer, 0);
                boolean Z = composer.Z(function1);
                Object objG = composer.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: i1.c
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return AccessibilityPermissionConfigKt.y(function1);
                        }
                    };
                    composer.w(objG);
                }
                H(strB, (Function0) objG, composer, 0);
                composer.U();
            } else {
                composer.a0(-1449717637);
                J(composer, 0);
                composer.U();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(Function1 function1) {
        function1.invoke(PermissionComposeEvent.OnAdvancedProtectionStepClick.f112003a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(final Function1 function1, final PermissionDTO permissionDTO, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(333324384, i3, -1, "cz.mobilesoft.coreblock.scene.permission.permissions.singlepermissions.AdvancedProtectionContent.<anonymous>.<anonymous> (AccessibilityPermissionConfig.kt:212)");
            }
            String strB = StringResources_androidKt.b(R.string.Qm, composer, 0);
            boolean Z = composer.Z(function1) | composer.Z(permissionDTO);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: i1.o
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AccessibilityPermissionConfigKt.A(function1, permissionDTO);
                    }
                };
                composer.w(objG);
            }
            H(strB, (Function0) objG, composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }
}
