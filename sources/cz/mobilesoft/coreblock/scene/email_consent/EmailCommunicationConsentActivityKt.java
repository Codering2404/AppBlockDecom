package cz.mobilesoft.coreblock.scene.email_consent;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.TextKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.email_consent.EmailConsentViewEvent;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonColors;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class EmailCommunicationConsentActivityKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(Function1 function1) {
        function1.invoke(new EmailConsentViewEvent.OnButtonClicked(false));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(final Function1 function1, BoxScope GradientBoxWithProgress, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(GradientBoxWithProgress, "$this$GradientBoxWithProgress");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(287811245, i3, -1, "cz.mobilesoft.coreblock.scene.email_consent.EmailConsentContent.<anonymous> (EmailCommunicationConsentActivity.kt:137)");
            }
            ScaffoldKt.a(SizeKt.f(Modifier.b8, 0.0f, 1, null), null, ComposableLambdaKt.e(-1149299896, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.email_consent.n
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return EmailCommunicationConsentActivityKt.C(function1, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, null, 0, Color.f25715b.j(), 0L, null, ComposableSingletons$EmailCommunicationConsentActivityKt.f101685a.c(), composer, 806879622, 442);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(final Function1 function1, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1149299896, i3, -1, "cz.mobilesoft.coreblock.scene.email_consent.EmailConsentContent.<anonymous>.<anonymous> (EmailCommunicationConsentActivity.kt:141)");
            }
            boolean Z = composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.email_consent.o
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EmailCommunicationConsentActivityKt.D(function1, ((Boolean) obj).booleanValue());
                    }
                };
                composer.w(objG);
            }
            p((Function1) objG, composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(Function1 function1, boolean z2) {
        function1.invoke(new EmailConsentViewEvent.OnButtonClicked(z2));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(EmailConsentViewState emailConsentViewState, boolean z2, Function1 function1, int i3, int i4, Composer composer, int i5) {
        y(emailConsentViewState, z2, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void F(final java.lang.String r20, kotlin.jvm.functions.Function0 r21, androidx.compose.runtime.Composer r22, final int r23, final int r24) {
        /*
            Method dump skipped, instruction units count: 349
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.email_consent.EmailCommunicationConsentActivityKt.F(java.lang.String, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(String str, Function0 function0, int i3, int i4, Composer composer, int i5) {
        F(str, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void p(final Function1 function1, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        final Function1 onButtonClicked = function1;
        Intrinsics.checkNotNullParameter(onButtonClicked, "onButtonClicked");
        Composer composerK = composer.k(1350714300);
        if ((i3 & 6) == 0) {
            i4 = i3 | (composerK.I(onButtonClicked) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1350714300, i4, -1, "cz.mobilesoft.coreblock.scene.email_consent.BottomActions (EmailCommunicationConsentActivity.kt:193)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierK = PaddingKt.k(PaddingKt.k(SizeKt.h(companion, 0.0f, 1, null), PrimitiveResources_androidKt.a(R.dimen.f95467a, composerK, 0), 0.0f, 2, null), 0.0f, Dp.g(f3), 1, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.g(), composerK, 48);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierK);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
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
            Updater.e(composerA, measurePolicyA, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            FlatButtonColors.Primary primary = FlatButtonColors.Primary.f131166a;
            String strB = StringResources_androidKt.b(R.string.X7, composerK, 0);
            int i5 = i4 & 14;
            boolean z2 = i5 == 4;
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.email_consent.s
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return EmailCommunicationConsentActivityKt.q(onButtonClicked);
                    }
                };
                composerK.w(objG);
            }
            FlatButtonsKt.u(modifierH, 0.0f, 0.0f, null, primary, null, strB, null, 0L, null, null, false, false, (Function0) objG, composerK, 24582, 0, 8110);
            SpacerKt.a(SizeKt.i(companion, Dp.g(12)), composerK, 6);
            Modifier modifierH2 = SizeKt.h(companion, 0.0f, 1, null);
            FlatButtonColors.Secondary secondary = FlatButtonColors.Secondary.f131167a;
            String strB2 = StringResources_androidKt.b(R.string.kl, composerK, 0);
            boolean z3 = i5 == 4;
            Object objG2 = composerK.G();
            if (z3 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.email_consent.f
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return EmailCommunicationConsentActivityKt.r(function1);
                    }
                };
                composerK.w(objG2);
            }
            onButtonClicked = function1;
            FlatButtonsKt.u(modifierH2, 0.0f, 0.0f, null, secondary, null, strB2, null, 0L, null, null, false, false, (Function0) objG2, composerK, 24582, 0, 8110);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composerK, 6);
            TextKt.c(StringResources_androidKt.b(R.string.a8, composerK, 0), null, ComposeColorsKt.j(composerK, 0).q(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).d(), composerK, 0, 0, 65018);
            composer2 = composerK;
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.email_consent.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return EmailCommunicationConsentActivityKt.s(onButtonClicked, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(Function1 function1) {
        function1.invoke(Boolean.TRUE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(Function1 function1) {
        function1.invoke(Boolean.FALSE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(Function1 function1, int i3, Composer composer, int i4) {
        p(function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void t(EmailConsentViewModel emailConsentViewModel, final Function0 function0, Composer composer, final int i3, final int i4) {
        int i5;
        final EmailConsentViewModel emailConsentViewModel2;
        Composer composerK = composer.k(1447886258);
        if ((i3 & 6) == 0) {
            i5 = (composerK.I(emailConsentViewModel) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        int i6 = i4 & 2;
        if (i6 != 0) {
            i5 |= 48;
        } else if ((i3 & 48) == 0) {
            i5 |= composerK.I(function0) ? 32 : 16;
        }
        if (composerK.r((i5 & 19) != 18, i5 & 1)) {
            if (i6 != 0) {
                Object objG = composerK.G();
                if (objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.email_consent.i
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return EmailCommunicationConsentActivityKt.u();
                        }
                    };
                    composerK.w(objG);
                }
                function0 = (Function0) objG;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(1447886258, i5, -1, "cz.mobilesoft.coreblock.scene.email_consent.CommandProcessor (EmailCommunicationConsentActivity.kt:99)");
            }
            boolean z2 = (i5 & 112) == 32;
            Object objG2 = composerK.G();
            if (z2 || objG2 == Composer.f23746a.a()) {
                objG2 = new EmailCommunicationConsentActivityKt$CommandProcessor$2$1(function0, null);
                composerK.w(objG2);
            }
            emailConsentViewModel2 = emailConsentViewModel;
            FlowExtKt.g(emailConsentViewModel2, null, (Function2) objG2, composerK, i5 & 14, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            emailConsentViewModel2 = emailConsentViewModel;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.email_consent.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return EmailCommunicationConsentActivityKt.v(emailConsentViewModel2, function0, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(EmailConsentViewModel emailConsentViewModel, Function0 function0, int i3, int i4, Composer composer, int i5) {
        t(emailConsentViewModel, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final void w(EmailConsentViewState emailConsentViewState, boolean z2, Function1 function1, Composer composer, final int i3) {
        int i4;
        final EmailConsentViewState emailConsentViewState2;
        final boolean z3;
        final Function1 function12;
        Composer composerK = composer.k(-1123898697);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(emailConsentViewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.b(z2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function1) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1123898697, i4, -1, "cz.mobilesoft.coreblock.scene.email_consent.Content (EmailCommunicationConsentActivity.kt:114)");
            }
            emailConsentViewState2 = emailConsentViewState;
            z3 = z2;
            function12 = function1;
            y(emailConsentViewState2, z3, function12, composerK, i4 & 1022, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            emailConsentViewState2 = emailConsentViewState;
            z3 = z2;
            function12 = function1;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.email_consent.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return EmailCommunicationConsentActivityKt.x(emailConsentViewState2, z3, function12, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(EmailConsentViewState emailConsentViewState, boolean z2, Function1 function1, int i3, Composer composer, int i4) {
        w(emailConsentViewState, z2, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void y(cz.mobilesoft.coreblock.scene.email_consent.EmailConsentViewState r22, boolean r23, kotlin.jvm.functions.Function1 r24, androidx.compose.runtime.Composer r25, final int r26, final int r27) {
        /*
            Method dump skipped, instruction units count: 310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.email_consent.EmailCommunicationConsentActivityKt.y(cz.mobilesoft.coreblock.scene.email_consent.EmailConsentViewState, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(EmailConsentViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }
}
