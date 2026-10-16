package cz.mobilesoft.coreblock.scene.more.signin;

import androidx.activity.compose.BackHandlerKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.material.IconKt;
import androidx.compose.material.ProgressIndicatorKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.TextKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.VisibilityKt;
import androidx.compose.material.icons.outlined.VisibilityOffKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.more.signin.SignInViewEvent;
import cz.mobilesoft.coreblock.scene.more.signin.SignInViewState;
import cz.mobilesoft.coreblock.util.Loading;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeBackgroundKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsV2Kt;
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
public final class SignInUpWithEmailScreenKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f110406a;

        static {
            int[] iArr = new int[SignInViewState.EmailSignScreen.values().length];
            try {
                iArr[SignInViewState.EmailSignScreen.SIGN_IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SignInViewState.EmailSignScreen.SIGN_UP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f110406a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(final Function0 function0, Composer composer, int i3) throws XmlPullParserException, IOException {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1545140874, i3, -1, "cz.mobilesoft.coreblock.scene.more.signin.Content.<anonymous>.<anonymous> (SignInUpWithEmailScreen.kt:123)");
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
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.signin.e2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SignInUpWithEmailScreenKt.B(function0);
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
    public static final Unit B(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(final SignInViewState signInViewState, final Function1 function1, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1712816021, i3, -1, "cz.mobilesoft.coreblock.scene.more.signin.Content.<anonymous>.<anonymous> (SignInUpWithEmailScreen.kt:130)");
            }
            String strB = StringResources_androidKt.b(R.string.l8, composer, 0);
            boolean zX = signInViewState.x();
            boolean Z = composer.Z(signInViewState) | composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.signin.z1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SignInUpWithEmailScreenKt.D(signInViewState, function1);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.J(null, strB, zX, false, null, (Function0) objG, composer, 0, 25);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(SignInViewState signInViewState, Function1 function1) {
        int i3 = WhenMappings.f110406a[signInViewState.e().ordinal()];
        if (i3 == 1) {
            function1.invoke(SignInViewEvent.OnSignInClicked.f110429a);
        } else {
            if (i3 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            function1.invoke(SignInViewEvent.OnSignUpClicked.f110434a);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(final SignInViewState signInViewState, final Function1 function1, Function0 function0, final Function0 function02, PaddingValues it, Composer composer, int i3) {
        int i4;
        int i5;
        int i6;
        Modifier.Companion companion;
        Composer composer2;
        int i7;
        final Function1 function12;
        ColumnScopeInstance columnScopeInstance;
        Composer composer3;
        Modifier.Companion companion2;
        int i8;
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(it) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1763449501, i4, -1, "cz.mobilesoft.coreblock.scene.more.signin.Content.<anonymous>.<anonymous> (SignInUpWithEmailScreen.kt:145)");
            }
            Modifier.Companion companion3 = Modifier.b8;
            Modifier modifierG = ScrollKt.g(PaddingKt.h(SizeKt.f(companion3, 0.0f, 1, null), it), ScrollKt.c(0, composer, 0, 1), false, null, false, 14, null);
            Arrangement.Vertical verticalH = Arrangement.f6574a.h();
            Alignment.Companion companion4 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion4.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierG);
            ComposeUiNode.Companion companion5 = ComposeUiNode.f8;
            Function0 function0A = companion5.a();
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
            Updater.e(composerA, measurePolicyA, companion5.e());
            Updater.e(composerA, compositionLocalMapU, companion5.g());
            Function2 function2B = companion5.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion5.f());
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.f6666a;
            float f3 = 32;
            SpacerKt.a(SizeKt.i(companion3, Dp.g(f3)), composer, 6);
            SignInViewState.EmailSignScreen emailSignScreenE = signInViewState.e();
            int[] iArr = WhenMappings.f110406a;
            int i9 = iArr[emailSignScreenE.ordinal()];
            if (i9 == 1) {
                i5 = R.string.Bj;
            } else {
                if (i9 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                i5 = R.string.ux;
            }
            String strB = StringResources_androidKt.b(i5, composer, 0);
            TextStyle textStyleE = ComposeTypographyKt.g(composer, 0).e();
            TextAlign.Companion companion6 = TextAlign.f29616b;
            TextKt.c(strB, PaddingKt.k(SizeKt.h(companion3, 0.0f, 1, null), Dp.g(f3), 0.0f, 2, null), 0L, 0L, null, null, null, 0L, null, TextAlign.h(companion6.a()), 0L, 0, false, 0, 0, null, textStyleE, composer, 48, 0, 65020);
            Composer composer4 = composer;
            if (signInViewState.e() == SignInViewState.EmailSignScreen.SIGN_IN) {
                composer4.a0(488903740);
                SpacerKt.a(SizeKt.i(companion3, Dp.g(12)), composer4, 6);
                i6 = 16;
                TextKt.c(StringResources_androidKt.b(R.string.Aj, composer4, 0), SizeKt.h(companion3, 0.0f, 1, null), 0L, 0L, null, null, null, 0L, null, TextAlign.h(companion6.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer4, 0).a(), composer, 48, 0, 65020);
                composer4 = composer;
                SpacerKt.a(SizeKt.i(companion3, Dp.g(16)), composer4, 6);
                composer4.U();
            } else {
                i6 = 16;
                composer4.a0(489341770);
                SpacerKt.a(SizeKt.i(companion3, Dp.g(f3)), composer4, 6);
                composer4.U();
            }
            String strD = signInViewState.d();
            boolean Z = composer4.Z(function1);
            Object objG = composer4.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.signin.a2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SignInUpWithEmailScreenKt.F(function1, (String) obj);
                    }
                };
                composer4.w(objG);
            }
            J(true, strD, (Function1) objG, R.string.Rc, signInViewState.f(), 0, false, function0, composer4, 6, 96);
            Composer composer5 = composer4;
            if (signInViewState.f()) {
                composer5.a0(489977983);
                function12 = function1;
                companion = companion3;
                i7 = 482171067;
                columnScopeInstance = columnScopeInstance2;
                TextKt.c(StringResources_androidKt.b(R.string.zd, composer5, 0), columnScopeInstance2.c(PaddingKt.m(companion3, 0.0f, 0.0f, Dp.g(i6), 0.0f, 11, null), companion4.j()), ComposeColorsKt.j(composer5, 0).k(), 0L, null, null, null, 0L, null, TextAlign.h(companion6.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer5, 0).d(), composer, 0, 0, 65016);
                composer2 = composer;
            } else {
                companion = companion3;
                composer2 = composer5;
                i7 = 482171067;
                function12 = function1;
                columnScopeInstance = columnScopeInstance2;
                composer2.a0(482171067);
            }
            composer2.U();
            String strM = signInViewState.m();
            boolean Z2 = composer2.Z(function12);
            Object objG2 = composer2.G();
            if (Z2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.signin.b2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SignInUpWithEmailScreenKt.G(function12, (String) obj);
                    }
                };
                composer2.w(objG2);
            }
            J(false, strM, (Function1) objG2, R.string.vn, signInViewState.n(), R.drawable.v3, false, function0, composer2, 6, 64);
            Composer composer6 = composer2;
            if (signInViewState.n()) {
                composer6.a0(491064471);
                TextKt.c(StringResources_androidKt.c(R.string.Bd, new Object[]{8}, composer6, 0), columnScopeInstance.c(PaddingKt.m(companion, 0.0f, 0.0f, Dp.g(16), 0.0f, 11, null), companion4.j()), ComposeColorsKt.j(composer6, 0).k(), 0L, null, null, null, 0L, null, TextAlign.h(companion6.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer6, 0).d(), composer6, 0, 0, 65016);
                composer3 = composer6;
                composer3.U();
                companion2 = companion;
            } else {
                composer3 = composer6;
                companion2 = companion;
                composer3.a0(i7);
                composer3.U();
            }
            SpacerKt.a(SizeKt.i(companion2, Dp.g(f3)), composer3, 6);
            Modifier modifierC = columnScopeInstance.c(companion2, companion4.g());
            int i10 = iArr[signInViewState.e().ordinal()];
            if (i10 == 1) {
                i8 = R.string.we;
            } else {
                if (i10 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                i8 = R.string.ox;
            }
            String strB2 = StringResources_androidKt.b(i8, composer3, 0);
            boolean Z3 = composer3.Z(signInViewState) | composer3.Z(function02) | composer3.Z(function12);
            Object objG3 = composer3.G();
            if (Z3 || objG3 == Composer.f23746a.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.signin.c2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SignInUpWithEmailScreenKt.H(signInViewState, function02, function12);
                    }
                };
                composer3.w(objG3);
            }
            ComposeButtonsV2Kt.d(modifierC, strB2, (Function0) objG3, composer3, 0, 0);
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
    public static final Unit F(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(new SignInViewEvent.OnEmailChanged(it));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(new SignInViewEvent.OnPasswordChanged(it));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(SignInViewState signInViewState, Function0 function0, Function1 function1) {
        int i3 = WhenMappings.f110406a[signInViewState.e().ordinal()];
        if (i3 == 1) {
            function0.invoke();
        } else {
            if (i3 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            function1.invoke(SignInViewEvent.OnAlreadyHaveAccountClicked.f110419a);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(SignInViewState signInViewState, Function1 function1, Function0 function0, Function0 function02, int i3, Composer composer, int i4) {
        w(signInViewState, function1, function0, function02, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x039f  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0410  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x013c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void J(boolean r68, final java.lang.String r69, final kotlin.jvm.functions.Function1 r70, final int r71, final boolean r72, int r73, boolean r74, final kotlin.jvm.functions.Function0 r75, androidx.compose.runtime.Composer r76, final int r77, final int r78) {
        /*
            Method dump skipped, instruction units count: 1076
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.signin.SignInUpWithEmailScreenKt.J(boolean, java.lang.String, kotlin.jvm.functions.Function1, int, boolean, int, boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState K(boolean z2) {
        return SnapshotStateKt__SnapshotStateKt.e(Boolean.valueOf(z2), null, 2, null);
    }

    private static final boolean L(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M(int i3, Composer composer, int i4) {
        if (composer.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1498216074, i4, -1, "cz.mobilesoft.coreblock.scene.more.signin.EmailPasswordTextField.<anonymous> (SignInUpWithEmailScreen.kt:302)");
            }
            TextKt.c(StringResources_androidKt.b(i3, composer, 0), null, ComposeColorsKt.j(composer, 0).O(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).a(), composer, 0, 0, 65018);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N(int i3, boolean z2, MutableState mutableState, Composer composer, int i4) {
        long jO;
        if (composer.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1756459383, i4, -1, "cz.mobilesoft.coreblock.scene.more.signin.EmailPasswordTextField.<anonymous> (SignInUpWithEmailScreen.kt:285)");
            }
            Painter painterC = PainterResources_androidKt.c(i3, composer, 0);
            if (z2) {
                composer.a0(35327711);
                jO = ComposeColorsKt.j(composer, 0).k();
                composer.U();
            } else if (S(mutableState).length() > 0) {
                composer.a0(35329917);
                jO = ComposeColorsKt.j(composer, 0).b();
                composer.U();
            } else {
                composer.a0(35331652);
                jO = ComposeColorsKt.j(composer, 0).O();
                composer.U();
            }
            IconKt.a(painterC, null, null, jO, composer, 48, 4);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O(boolean z2, final MutableState mutableState, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(716167544, i3, -1, "cz.mobilesoft.coreblock.scene.more.signin.EmailPasswordTextField.<anonymous> (SignInUpWithEmailScreen.kt:311)");
            }
            if (z2) {
                composer.a0(-2063515030);
            } else {
                composer.a0(-2050165593);
                ImageVector imageVectorA = !L(mutableState) ? VisibilityKt.a(Icons.Outlined.f15155a) : VisibilityOffKt.a(Icons.Outlined.f15155a);
                long jP = ComposeColorsKt.j(composer, 0).P();
                Modifier modifierM = PaddingKt.m(Modifier.b8, 0.0f, 0.0f, Dp.g(8), 0.0f, 11, null);
                boolean Z = composer.Z(mutableState);
                Object objG = composer.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.signin.d2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SignInUpWithEmailScreenKt.P(mutableState);
                        }
                    };
                    composer.w(objG);
                }
                ComposeButtonsKt.q0(modifierM, imageVectorA, null, false, 0.0f, 0.0f, jP, "", (Function0) objG, composer, 12582918, 60);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P(MutableState mutableState) {
        R(mutableState, !L(mutableState));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q(boolean z2, String str, Function1 function1, int i3, boolean z3, int i4, boolean z4, Function0 function0, int i5, int i6, Composer composer, int i7) {
        J(z2, str, function1, i3, z3, i4, z4, function0, composer, RecomposeScopeImplKt.a(i5 | 1), i6);
        return Unit.f139807a;
    }

    private static final void R(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    private static final String S(MutableState mutableState) {
        return (String) mutableState.getValue();
    }

    private static final void T(MutableState mutableState, String str) {
        mutableState.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U(Function0 function0, KeyboardActionScope KeyboardActions) {
        Intrinsics.checkNotNullParameter(KeyboardActions, "$this$KeyboardActions");
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V(Function1 function1, MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        T(mutableState, it);
        function1.invoke(it);
        return Unit.f139807a;
    }

    public static final void W(final Function1 onEvent, final SignInViewState viewState, final Function0 onBackClicked, final Function0 onForgotPasswordClicked, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onBackClicked, "onBackClicked");
        Intrinsics.checkNotNullParameter(onForgotPasswordClicked, "onForgotPasswordClicked");
        Composer composerK = composer.k(-1804737599);
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
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(onForgotPasswordClicked) ? 2048 : 1024;
        }
        if (composerK.r((i4 & 1171) != 1170, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1804737599, i4, -1, "cz.mobilesoft.coreblock.scene.more.signin.SignInUpWithEmailScreen (SignInUpWithEmailScreen.kt:68)");
            }
            int i5 = i4 & 896;
            boolean z2 = i5 == 256;
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.signin.g2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SignInUpWithEmailScreenKt.X(onBackClicked);
                    }
                };
                composerK.w(objG);
            }
            BackHandlerKt.a(false, (Function0) objG, composerK, 0, 1);
            if (Intrinsics.areEqual(viewState.s(), Loading.f127895a)) {
                composerK.a0(-536909823);
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
                composerK.a0(-536393208);
                w(viewState, onEvent, onBackClicked, onForgotPasswordClicked, composerK, (i4 & 7168) | i5 | ((i4 >> 3) & 14) | ((i4 << 3) & 112));
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.signin.h2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SignInUpWithEmailScreenKt.Y(onEvent, viewState, onBackClicked, onForgotPasswordClicked, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y(Function1 function1, SignInViewState signInViewState, Function0 function0, Function0 function02, int i3, Composer composer, int i4) {
        W(function1, signInViewState, function0, function02, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void w(final SignInViewState viewState, final Function1 onEvent, final Function0 onBackClicked, final Function0 onForgotPasswordClicked, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        boolean z2;
        Function0 function0;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Intrinsics.checkNotNullParameter(onBackClicked, "onBackClicked");
        Intrinsics.checkNotNullParameter(onForgotPasswordClicked, "onForgotPasswordClicked");
        Composer composerK = composer.k(-1917173747);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(viewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onEvent) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onBackClicked) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(onForgotPasswordClicked) ? 2048 : 1024;
        }
        if (composerK.r((i4 & 1171) != 1170, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1917173747, i4, -1, "cz.mobilesoft.coreblock.scene.more.signin.Content (SignInUpWithEmailScreen.kt:106)");
            }
            int i5 = WhenMappings.f110406a[viewState.e().ordinal()];
            if (i5 == 1) {
                composerK.a0(-47712815);
                z2 = (i4 & 112) == 32;
                Object objG = composerK.G();
                if (z2 || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.signin.u1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SignInUpWithEmailScreenKt.x(onEvent);
                        }
                    };
                    composerK.w(objG);
                }
                function0 = (Function0) objG;
                composerK.U();
            } else {
                if (i5 != 2) {
                    composerK.a0(137005607);
                    composerK.U();
                    throw new NoWhenBranchMatchedException();
                }
                composerK.a0(-47593775);
                z2 = (i4 & 112) == 32;
                Object objG2 = composerK.G();
                if (z2 || objG2 == Composer.f23746a.a()) {
                    objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.signin.f2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SignInUpWithEmailScreenKt.y(onEvent);
                        }
                    };
                    composerK.w(objG2);
                }
                function0 = (Function0) objG2;
                composerK.U();
            }
            final Function0 function02 = function0;
            composer2 = composerK;
            ComposeBackgroundKt.m(null, false, false, false, null, 0L, null, ComposableLambdaKt.e(-963500133, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.signin.i2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SignInUpWithEmailScreenKt.z(onBackClicked, viewState, onEvent, function02, onForgotPasswordClicked, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composer2, 12582912, 127);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.signin.j2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SignInUpWithEmailScreenKt.I(viewState, onEvent, onBackClicked, onForgotPasswordClicked, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(Function1 function1) {
        function1.invoke(SignInViewEvent.OnSignInClicked.f110429a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(Function1 function1) {
        function1.invoke(SignInViewEvent.OnSignUpClicked.f110434a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(final Function0 function0, final SignInViewState signInViewState, final Function1 function1, final Function0 function02, final Function0 function03, BoxScope GradientBox, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(GradientBox, "$this$GradientBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-963500133, i3, -1, "cz.mobilesoft.coreblock.scene.more.signin.Content.<anonymous> (SignInUpWithEmailScreen.kt:117)");
            }
            ScaffoldKt.a(SizeKt.f(WindowInsetsPaddingKt.d(Modifier.b8, WindowInsets_androidKt.c(WindowInsets.f7172a, composer, 6)), 0.0f, 1, null), null, ComposableLambdaKt.e(-1545140874, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.signin.k2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SignInUpWithEmailScreenKt.A(function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), ComposableLambdaKt.e(1712816021, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.signin.l2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SignInUpWithEmailScreenKt.C(signInViewState, function1, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, Color.f25715b.j(), 0L, ComposableLambdaKt.e(1763449501, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.signin.m2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SignInUpWithEmailScreenKt.E(signInViewState, function1, function02, function03, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
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
}
