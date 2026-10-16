package cz.mobilesoft.coreblock.activity.rating;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.TextKt;
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
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.activity.rating.RatingDialogEvent;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeDialogsKt;
import java.io.IOException;
import kotlin.Metadata;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class RatingDialogContentKt {
    public static final void g(final Function1 onEvent, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Composer composerK = composer.k(-359902116);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(onEvent) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-359902116, i4, -1, "cz.mobilesoft.coreblock.activity.rating.RatingDialogContent (RatingDialogContent.kt:29)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.TRUE, null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            boolean z2 = (i4 & 14) == 4;
            Object objG2 = composerK.G();
            if (z2 || objG2 == companion.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.activity.rating.i0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return RatingDialogContentKt.h(onEvent);
                    }
                };
                composerK.w(objG2);
            }
            ComposeDialogsKt.z0(mutableState, null, null, (Function0) objG2, ComposableLambdaKt.e(1583358971, true, new Function3() { // from class: cz.mobilesoft.coreblock.activity.rating.j0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return RatingDialogContentKt.i(onEvent, mutableState, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 24582, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.activity.rating.k0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RatingDialogContentKt.m(onEvent, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(Function1 function1) {
        function1.invoke(RatingDialogEvent.OnDismissRequested.f96071a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(final Function1 function1, final MutableState mutableState, BoxScope CustomDialog, Composer composer, int i3) throws XmlPullParserException, IOException {
        int i4;
        Intrinsics.checkNotNullParameter(CustomDialog, "$this$CustomDialog");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(CustomDialog) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1583358971, i4, -1, "cz.mobilesoft.coreblock.activity.rating.RatingDialogContent.<anonymous> (RatingDialogContent.kt:37)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierI = PaddingKt.i(SizeKt.h(companion, 0.0f, 1, null), Dp.g(f3));
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), companion2.g(), composer, 48);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierI);
            ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
            Function0 function0A = companion3.a();
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
            Updater.e(composerA, measurePolicyA, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            ImageVector.Companion companion4 = ImageVector.f26323k;
            ImageKt.b(VectorResources_androidKt.b(companion4, R.drawable.K8, composer, 6), null, null, null, null, 0.0f, null, composer, 48, 124);
            float f4 = 24;
            TextKt.c(StringResources_androidKt.b(R.string.ud, composer, 0), PaddingKt.m(companion, 0.0f, Dp.g(f4), 0.0f, 0.0f, 13, null), ComposeColorsKt.j(composer, 0).L(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).g(), composer, 48, 0, 65528);
            float f5 = 56;
            Modifier modifierI2 = SizeKt.i(SizeKt.h(PaddingKt.m(companion, 0.0f, Dp.g(f4), 0.0f, 0.0f, 13, null), 0.0f, 1, null), Dp.g(f5));
            ButtonType.Big big = new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.Dj, composer, 0), 0.0f, 11, null);
            ButtonColor.Accent accent = new ButtonColor.Accent(false, null, false, null, 11, null);
            boolean Z = composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.activity.rating.l0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return RatingDialogContentKt.j(mutableState, function1);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.i0(modifierI2, big, accent, (Function0) objG, composer, 6, 0);
            Modifier modifierI3 = SizeKt.i(SizeKt.h(PaddingKt.m(companion, 0.0f, Dp.g(f3), 0.0f, 0.0f, 13, null), 0.0f, 1, null), Dp.g(f5));
            ButtonType.Big big2 = new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.xr, composer, 0), 0.0f, 11, null);
            ButtonColor.Disabled disabled = new ButtonColor.Disabled(false, null, false, null, 11, null);
            boolean Z2 = composer.Z(function1);
            Object objG2 = composer.G();
            if (Z2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.activity.rating.m0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return RatingDialogContentKt.k(mutableState, function1);
                    }
                };
                composer.w(objG2);
            }
            ComposeButtonsKt.i0(modifierI3, big2, disabled, (Function0) objG2, composer, 6, 0);
            composer.y();
            Modifier modifierF2 = CustomDialog.f(companion, companion2.n());
            ImageVector imageVectorB = VectorResources_androidKt.b(companion4, R.drawable.C1, composer, 6);
            long jP = ComposeColorsKt.j(composer, 0).P();
            boolean Z3 = composer.Z(function1);
            Object objG3 = composer.G();
            if (Z3 || objG3 == Composer.f23746a.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.activity.rating.n0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return RatingDialogContentKt.l(function1);
                    }
                };
                composer.w(objG3);
            }
            ComposeButtonsKt.q0(modifierF2, imageVectorB, null, false, 0.0f, 0.0f, jP, null, (Function0) objG3, composer, 0, 188);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(MutableState mutableState, Function1 function1) {
        mutableState.setValue(Boolean.FALSE);
        function1.invoke(RatingDialogEvent.OnLoveItClicked.f96074a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(MutableState mutableState, Function1 function1) {
        mutableState.setValue(Boolean.FALSE);
        function1.invoke(RatingDialogEvent.OnRateNoClicked.f96078a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(Function1 function1) {
        function1.invoke(RatingDialogEvent.OnCloseClicked.f96069a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(Function1 function1, int i3, Composer composer, int i4) {
        g(function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
