package cz.mobilesoft.coreblock.scene.more.signin;

import androidx.activity.compose.BackHandlerKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material.ProgressIndicatorKt;
import androidx.compose.material.ScaffoldKt;
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
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.google.accompanist.systemuicontroller.SystemUiController;
import com.google.accompanist.systemuicontroller.SystemUiControllerKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.more.signin.SignInViewEvent;
import cz.mobilesoft.coreblock.scene.more.signin.SignInViewState;
import cz.mobilesoft.coreblock.util.Loading;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeBackgroundKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ForgotPasswordScreenKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f110365a;

        static {
            int[] iArr = new int[SignInViewState.ForgotPasswordScreenType.values().length];
            try {
                iArr[SignInViewState.ForgotPasswordScreenType.EMAIL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SignInViewState.ForgotPasswordScreenType.VERIFICATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SignInViewState.ForgotPasswordScreenType.CREATE_NEW_PASSWORD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f110365a = iArr;
        }
    }

    private static final void l(final SignInViewState signInViewState, final Function1 function1, final Function0 function0, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-1406652698);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(signInViewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function1) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function0) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1406652698, i4, -1, "cz.mobilesoft.coreblock.scene.more.signin.Content (ForgotPasswordScreen.kt:84)");
            }
            ComposeBackgroundKt.m(null, false, false, false, null, 0L, null, ComposableLambdaKt.e(-1475798888, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.signin.s
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ForgotPasswordScreenKt.m(function0, signInViewState, function1, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 12582912, 127);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.signin.u
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ForgotPasswordScreenKt.u(signInViewState, function1, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(final Function0 function0, final SignInViewState signInViewState, final Function1 function1, BoxScope GradientBox, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(GradientBox, "$this$GradientBox");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(GradientBox) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1475798888, i4, -1, "cz.mobilesoft.coreblock.scene.more.signin.Content.<anonymous> (ForgotPasswordScreen.kt:86)");
            }
            ScaffoldKt.a(GradientBox.f(SizeKt.f(WindowInsetsPaddingKt.d(Modifier.b8, WindowInsets_androidKt.c(WindowInsets.f7172a, composer, 6)), 0.0f, 1, null), Alignment.f25072a.m()), null, ComposableLambdaKt.e(-168176931, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.signin.v
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ForgotPasswordScreenKt.n(function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), ComposableLambdaKt.e(1116885598, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.signin.w
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ForgotPasswordScreenKt.p(signInViewState, function1, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, Color.f25715b.j(), 0L, ComposableLambdaKt.e(2013686358, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.signin.x
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ForgotPasswordScreenKt.r(signInViewState, function1, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 3456, 12779520, 98290);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(final Function0 function0, Composer composer, int i3) throws XmlPullParserException, IOException {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-168176931, i3, -1, "cz.mobilesoft.coreblock.scene.more.signin.Content.<anonymous>.<anonymous> (ForgotPasswordScreen.kt:93)");
            }
            Modifier.Companion companion = Modifier.b8;
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), Alignment.f25072a.l(), composer, 0);
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
            Updater.e(composerA, measurePolicyB, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.C1, composer, 6);
            boolean Z = composer.Z(function0);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.signin.b0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ForgotPasswordScreenKt.o(function0);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.q0(null, imageVectorB, null, false, 0.0f, 0.0f, 0L, null, (Function0) objG, composer, 0, 253);
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
    public static final Unit o(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(final SignInViewState signInViewState, final Function1 function1, Composer composer, int i3) {
        boolean z2 = false;
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1116885598, i3, -1, "cz.mobilesoft.coreblock.scene.more.signin.Content.<anonymous>.<anonymous> (ForgotPasswordScreen.kt:100)");
            }
            String strB = StringResources_androidKt.b(R.string.l8, composer, 0);
            if (signInViewState.d().length() > 0 && !signInViewState.f()) {
                z2 = true;
            }
            boolean Z = composer.Z(signInViewState) | composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.signin.a0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ForgotPasswordScreenKt.q(signInViewState, function1);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.J(null, strB, z2, false, null, (Function0) objG, composer, 0, 25);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(SignInViewState signInViewState, Function1 function1) {
        int i3 = WhenMappings.f110365a[signInViewState.i().ordinal()];
        if (i3 == 1) {
            function1.invoke(SignInViewEvent.OnSubmitEmailClicked.f110435a);
        } else if (i3 == 2) {
            function1.invoke(SignInViewEvent.OnVerifyCodeClicked.f110437a);
        } else {
            if (i3 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            function1.invoke(SignInViewEvent.OnCreatePasswordClicked.f110421a);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final kotlin.Unit r(cz.mobilesoft.coreblock.scene.more.signin.SignInViewState r39, final kotlin.jvm.functions.Function1 r40, androidx.compose.foundation.layout.PaddingValues r41, androidx.compose.runtime.Composer r42, int r43) {
        /*
            Method dump skipped, instruction units count: 986
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.signin.ForgotPasswordScreenKt.r(cz.mobilesoft.coreblock.scene.more.signin.SignInViewState, kotlin.jvm.functions.Function1, androidx.compose.foundation.layout.PaddingValues, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(SignInViewState signInViewState, Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        int i3 = WhenMappings.f110365a[signInViewState.i().ordinal()];
        if (i3 == 1) {
            function1.invoke(new SignInViewEvent.OnEmailChanged(it));
        } else if (i3 == 2) {
            function1.invoke(new SignInViewEvent.OnVerificationCodeChanged(it));
        } else {
            if (i3 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            function1.invoke(new SignInViewEvent.OnPasswordChanged(it));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(SignInViewState signInViewState, Function1 function1) {
        int i3 = WhenMappings.f110365a[signInViewState.i().ordinal()];
        if (i3 == 1) {
            function1.invoke(SignInViewEvent.OnSubmitEmailClicked.f110435a);
        } else if (i3 == 2) {
            function1.invoke(SignInViewEvent.OnVerifyCodeClicked.f110437a);
        } else {
            if (i3 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            function1.invoke(SignInViewEvent.OnCreatePasswordClicked.f110421a);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(SignInViewState signInViewState, Function1 function1, Function0 function0, int i3, Composer composer, int i4) {
        l(signInViewState, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void v(final Function1 onEvent, final SignInViewState viewState, final Function0 onBackClicked, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onBackClicked, "onBackClicked");
        Composer composerK = composer.k(1921591411);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(onEvent) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(viewState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onBackClicked) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1921591411, i4, -1, "cz.mobilesoft.coreblock.scene.more.signin.ForgotPasswordScreen (ForgotPasswordScreen.kt:45)");
            }
            SystemUiController.b(SystemUiControllerKt.e(null, composerK, 0, 1), Color.f25715b.j(), false, null, 6, null);
            int i5 = i4 & 896;
            boolean z2 = i5 == 256;
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.signin.c0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ForgotPasswordScreenKt.w(onBackClicked);
                    }
                };
                composerK.w(objG);
            }
            BackHandlerKt.a(false, (Function0) objG, composerK, 0, 1);
            if (Intrinsics.areEqual(viewState.s(), Loading.f127895a)) {
                composerK.a0(-1488994257);
                Modifier.Companion companion = Modifier.b8;
                Modifier modifierF = SizeKt.f(companion, 0.0f, 1, null);
                Alignment.Companion companion2 = Alignment.f25072a;
                MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
                int iA = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU = composerK.u();
                Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierF);
                ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
                Function0 function0A = companion3.a();
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
                Updater.e(composerA, measurePolicyG, companion3.e());
                Updater.e(composerA, compositionLocalMapU, companion3.g());
                Function2 function2B = companion3.b();
                if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                    composerA.w(Integer.valueOf(iA));
                    composerA.p(Integer.valueOf(iA), function2B);
                }
                Updater.e(composerA, modifierF2, companion3.f());
                ProgressIndicatorKt.b(BoxScopeInstance.f6642a.f(SizeKt.v(PaddingKt.i(companion, Dp.g(8)), Dp.g(120)), companion2.e()), ComposeColorsKt.j(composerK, 0).b(), Dp.g(4), 0L, StrokeCap.f25935b.b(), composerK, 384, 8);
                composerK.y();
                composerK.U();
            } else {
                composerK.a0(-1488479843);
                l(viewState, onEvent, onBackClicked, composerK, ((i4 >> 3) & 14) | ((i4 << 3) & 112) | i5);
                composerK.U();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.signin.t
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ForgotPasswordScreenKt.x(onEvent, viewState, onBackClicked, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(Function1 function1, SignInViewState signInViewState, Function0 function0, int i3, Composer composer, int i4) {
        v(function1, signInViewState, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
