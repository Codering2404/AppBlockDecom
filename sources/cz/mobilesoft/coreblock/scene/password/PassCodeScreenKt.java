package cz.mobilesoft.coreblock.scene.password;

import android.app.Activity;
import android.content.Context;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.SurfaceKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.password.PassCodeViewEvent;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.ContextExtKt;
import cz.mobilesoft.coreblock.util.helperextension.DateHelper;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.slider.NumberedKeyboardButton;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class PassCodeScreenKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f111676a;

        static {
            int[] iArr = new int[PassCodeStep.values().length];
            try {
                iArr[PassCodeStep.Create.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PassCodeStep.Check.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PassCodeStep.Confirm.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PassCodeStep.Remove.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f111676a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(Function1 function1) {
        function1.invoke(PassCodeViewEvent.OnLogoClicked.f111682a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(Function1 function1, NumberedKeyboardButton it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it instanceof NumberedKeyboardButton.Number) {
            function1.invoke(new PassCodeViewEvent.OnNumberClicked(((NumberedKeyboardButton.Number) it).a()));
        } else if (it instanceof NumberedKeyboardButton.Backspace) {
            function1.invoke(PassCodeViewEvent.OnBackspaceClicked.f111680a);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(Function1 function1) {
        function1.invoke(PassCodeViewEvent.OnContinueClicked.f111681a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(Function0 function0, Context context) {
        function0.invoke();
        Activity activityB = ContextExtKt.b(context);
        if (activityB != null) {
            activityB.setResult(-1);
            activityB.finish();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(PassCodeViewState passCodeViewState, Function1 function1, Modifier modifier, boolean z2, boolean z3, Function0 function0, int i3, int i4, Composer composer, int i5) {
        z(passCodeViewState, function1, modifier, z2, z3, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void G(androidx.compose.ui.Modifier r18, final cz.mobilesoft.coreblock.scene.password.BasePassCodeViewModel r19, boolean r20, final kotlin.jvm.functions.Function1 r21, final kotlin.jvm.functions.Function0 r22, androidx.compose.runtime.Composer r23, final int r24, final int r25) {
        /*
            Method dump skipped, instruction units count: 361
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.password.PassCodeScreenKt.G(androidx.compose.ui.Modifier, cz.mobilesoft.coreblock.scene.password.BasePassCodeViewModel, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(MutableState mutableState) {
        mutableState.setValue(Boolean.FALSE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(MutableState mutableState) {
        mutableState.setValue(Boolean.TRUE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(Modifier modifier, BasePassCodeViewModel basePassCodeViewModel, boolean z2, Function1 function1, Function0 function0, int i3, int i4, Composer composer, int i5) {
        G(modifier, basePassCodeViewModel, z2, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x014a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void K(final cz.mobilesoft.coreblock.scene.password.PassCodeViewState r17, final kotlin.jvm.functions.Function1 r18, final kotlin.jvm.functions.Function0 r19, androidx.compose.ui.Modifier r20, boolean r21, final boolean r22, kotlin.jvm.functions.Function0 r23, androidx.compose.runtime.Composer r24, final int r25, final int r26) {
        /*
            Method dump skipped, instruction units count: 361
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.password.PassCodeScreenKt.K(cz.mobilesoft.coreblock.scene.password.PassCodeViewState, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M(PassCodeViewState passCodeViewState, Function1 function1, Function0 function0, Modifier modifier, boolean z2, boolean z3, Function0 function02, int i3, int i4, Composer composer, int i5) {
        K(passCodeViewState, function1, function0, modifier, z2, z3, function02, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final void q(Composer composer, final int i3) {
        Composer composerK = composer.k(559049352);
        if (composerK.r(i3 != 0, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(559049352, i3, -1, "cz.mobilesoft.coreblock.scene.password.CharacterBox (PassCodeScreen.kt:364)");
            }
            SurfaceKt.a(PaddingKt.i(Modifier.b8, Dp.g(8)), RoundedCornerShapeKt.g(), ComposeColorsKt.j(composerK, 0).b(), 0L, null, 0.0f, ComposableSingletons$PassCodeScreenKt.f111665a.k(), composerK, 1572870, 56);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.password.g0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PassCodeScreenKt.r(i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(int i3, Composer composer, int i4) {
        q(composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void s(final int i3, final Modifier modifier, Composer composer, final int i4, final int i5) {
        Composer composerK = composer.k(-1306585498);
        int i6 = (i4 & 6) == 0 ? (composerK.e(i3) ? 4 : 2) | i4 : i4;
        int i7 = i5 & 2;
        if (i7 != 0) {
            i6 |= 48;
        } else if ((i4 & 48) == 0) {
            i6 |= composerK.Z(modifier) ? 32 : 16;
        }
        if (composerK.r((i6 & 19) != 18, i6 & 1)) {
            if (i7 != 0) {
                modifier = Modifier.b8;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(-1306585498, i6, -1, "cz.mobilesoft.coreblock.scene.password.CharactersRow (PassCodeScreen.kt:350)");
            }
            Arrangement.HorizontalOrVertical horizontalOrVerticalB = Arrangement.f6574a.b();
            Modifier modifierI = SizeKt.i(SizeKt.h(modifier, 0.0f, 1, null), Dp.g(40));
            MeasurePolicy measurePolicyB = RowKt.b(horizontalOrVerticalB, Alignment.f25072a.l(), composerK, 6);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierI);
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
            Updater.e(composerA, measurePolicyB, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            composerK.a0(898932688);
            for (int i8 = 0; i8 < i3; i8++) {
                q(composerK, 0);
            }
            composerK.U();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.password.c0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PassCodeScreenKt.t(i3, modifier, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(int i3, Modifier modifier, int i4, int i5, Composer composer, int i6) {
        s(i3, modifier, composer, RecomposeScopeImplKt.a(i4 | 1), i5);
        return Unit.f139807a;
    }

    public static final void u(BasePassCodeViewModel viewModel, final Function1 onSuccess, final Function0 onShowUnlockDialog, Composer composer, final int i3) {
        int i4;
        final BasePassCodeViewModel basePassCodeViewModel;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onShowUnlockDialog, "onShowUnlockDialog");
        Composer composerK = composer.k(-84056059);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(viewModel) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onSuccess) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onShowUnlockDialog) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-84056059, i4, -1, "cz.mobilesoft.coreblock.scene.password.CommandProcessor (PassCodeScreen.kt:383)");
            }
            boolean z2 = ((i4 & 112) == 32) | ((i4 & 896) == 256);
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new PassCodeScreenKt$CommandProcessor$1$1(onSuccess, onShowUnlockDialog, null);
                composerK.w(objG);
            }
            basePassCodeViewModel = viewModel;
            FlowExtKt.g(basePassCodeViewModel, null, (Function2) objG, composerK, i4 & 14, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            basePassCodeViewModel = viewModel;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.password.h0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PassCodeScreenKt.v(basePassCodeViewModel, onSuccess, onShowUnlockDialog, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(BasePassCodeViewModel basePassCodeViewModel, Function1 function1, Function0 function0, int i3, Composer composer, int i4) {
        u(basePassCodeViewModel, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void w(final PassCodeViewState viewState, Function0 function0, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        final Function0 onUnderstandClicked = function0;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onUnderstandClicked, "onUnderstandClicked");
        Composer composerK = composer.k(1994014870);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(viewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onUnderstandClicked) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1994014870, i4, -1, "cz.mobilesoft.coreblock.scene.password.DeactivationDisabledContent (PassCodeScreen.kt:159)");
            }
            Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            final Density density = (Density) composerK.q(CompositionLocalsKt.f());
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(Dp.d(Dp.g(0)), null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            Alignment.Companion companion2 = Alignment.f25072a;
            Alignment.Horizontal horizontalG = companion2.g();
            Modifier.Companion companion3 = Modifier.b8;
            Modifier modifierD = WindowInsetsPaddingKt.d(SizeKt.f(companion3, 0.0f, 1, null), WindowInsets_androidKt.b(WindowInsets.f7172a, composerK, 6));
            int i5 = R.dimen.f95486t;
            Modifier modifierK = PaddingKt.k(modifierD, Dp.g(PrimitiveResources_androidKt.a(i5, composerK, 0) + PrimitiveResources_androidKt.a(R.dimen.f95467a, composerK, 0)), 0.0f, 2, null);
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.h(), horizontalG, composerK, 48);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierK);
            ComposeUiNode.Companion companion4 = ComposeUiNode.f8;
            Function0 function0A = companion4.a();
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
            int i6 = i4;
            Updater.e(composerA, measurePolicyA, companion4.e());
            Updater.e(composerA, compositionLocalMapU, companion4.g());
            Function2 function2B = companion4.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion4.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            Arrangement.HorizontalOrVertical horizontalOrVerticalB = arrangement.b();
            Modifier modifierH = SizeKt.h(ColumnScope.b(columnScopeInstance, companion3, 1.0f, false, 2, null), 0.0f, 1, null);
            MeasurePolicy measurePolicyA2 = ColumnKt.a(horizontalOrVerticalB, companion2.k(), composerK, 6);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierH);
            Function0 function0A2 = companion4.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A2);
            } else {
                composerK.v();
            }
            Composer composerA2 = Updater.a(composerK);
            Updater.e(composerA2, measurePolicyA2, companion4.e());
            Updater.e(composerA2, compositionLocalMapU2, companion4.g());
            Function2 function2B2 = companion4.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion4.f());
            String strB = StringResources_androidKt.b(R.string.fo, composerK, 0);
            TextStyle textStyleF = ComposeTypographyKt.g(composerK, 0).f();
            long jL = ComposeColorsKt.j(composerK, 0).L();
            TextAlign.Companion companion5 = TextAlign.f29616b;
            float f3 = 12;
            TextKt.c(strB, SizeKt.h(PaddingKt.m(companion3, 0.0f, 0.0f, 0.0f, Dp.g(f3), 7, null), 0.0f, 1, null), jL, 0L, null, null, null, 0L, null, TextAlign.h(companion5.a()), 0L, 0, false, 0, 0, null, textStyleF, composerK, 48, 0, 65016);
            int i7 = R.string.go;
            String strK = DateHelper.k(context, viewState.f());
            Intrinsics.checkNotNullExpressionValue(strK, "getRemainingTimeOnlyString(...)");
            String strC = StringResources_androidKt.c(i7, new Object[]{strK}, composerK, 0);
            TextStyle textStyleD = cz.mobilesoft.coreblock.view.compose.TextKt.d(ComposeTypographyKt.g(composerK, 0).a());
            long jL2 = ComposeColorsKt.j(composerK, 0).L();
            int iF = companion5.f();
            Modifier modifierC = columnScopeInstance.c(companion3, companion2.g());
            boolean Z = composerK.Z(density);
            Object objG2 = composerK.G();
            if (Z || objG2 == companion.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.password.j0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PassCodeScreenKt.x(density, mutableState, (IntSize) obj);
                    }
                };
                composerK.w(objG2);
            }
            TextKt.c(strC, SizeKt.b(OnRemeasuredModifierKt.a(modifierC, (Function1) objG2), ((Dp) mutableState.getValue()).l(), 0.0f, 2, null), jL2, 0L, null, null, null, 0L, null, TextAlign.h(iF), 0L, 0, false, 0, 0, null, textStyleD, composerK, 0, 0, 65016);
            composerK.y();
            Modifier modifierM = PaddingKt.m(PaddingKt.k(companion3, Dp.g(PrimitiveResources_androidKt.a(i5, composerK, 0) + Dp.g(16)), 0.0f, 2, null), 0.0f, 0.0f, 0.0f, Dp.g(f3), 7, null);
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA3 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU3 = composerK.u();
            Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierM);
            Function0 function0A3 = companion4.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A3);
            } else {
                composerK.v();
            }
            Composer composerA3 = Updater.a(composerK);
            Updater.e(composerA3, measurePolicyG, companion4.e());
            Updater.e(composerA3, compositionLocalMapU3, companion4.g());
            Function2 function2B3 = companion4.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion4.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            onUnderstandClicked = function0;
            ComposeButtonsKt.i0(null, new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.Vf, composerK, 0), 0.0f, 11, null), new ButtonColor.Accent(false, null, false, null, 15, null), onUnderstandClicked, composerK, (i6 << 6) & 7168, 1);
            composer2 = composerK;
            composer2.y();
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.password.k0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PassCodeScreenKt.y(viewState, onUnderstandClicked, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(Density density, MutableState mutableState, IntSize intSize) {
        float F = density.F((int) (intSize.j() >> 32));
        if (Dp.f(F, ((Dp) mutableState.getValue()).l()) > 0) {
            mutableState.setValue(Dp.d(F));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(PassCodeViewState passCodeViewState, Function0 function0, int i3, Composer composer, int i4) {
        w(passCodeViewState, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:197:0x066d  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0679  */
    /* JADX WARN: Removed duplicated region for block: B:202:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b4  */
    /* JADX WARN: Type inference failed for: r15v18 */
    /* JADX WARN: Type inference failed for: r15v19 */
    /* JADX WARN: Type inference failed for: r15v20 */
    /* JADX WARN: Type inference failed for: r15v21 */
    /* JADX WARN: Type inference failed for: r15v22 */
    /* JADX WARN: Type inference failed for: r15v23 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v32 */
    /* JADX WARN: Type inference failed for: r8v26 */
    /* JADX WARN: Type inference failed for: r8v27 */
    /* JADX WARN: Type inference failed for: r8v28 */
    /* JADX WARN: Type inference failed for: r8v31 */
    /* JADX WARN: Type inference failed for: r9v35 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void z(final cz.mobilesoft.coreblock.scene.password.PassCodeViewState r41, final kotlin.jvm.functions.Function1 r42, androidx.compose.ui.Modifier r43, boolean r44, final boolean r45, final kotlin.jvm.functions.Function0 r46, androidx.compose.runtime.Composer r47, final int r48, final int r49) {
        /*
            Method dump skipped, instruction units count: 1672
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.password.PassCodeScreenKt.z(cz.mobilesoft.coreblock.scene.password.PassCodeViewState, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }
}
