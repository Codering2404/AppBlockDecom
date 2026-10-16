package cz.mobilesoft.coreblock.view.compose;

import android.content.res.Configuration;
import androidx.activity.compose.BackHandlerKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.FloatTweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.ScreenProgressBarKt;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CoroutineScope;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ComposeCommitmentScreenKt {
    public static final void j(final String text, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer composerK = composer.k(473788739);
        if ((i3 & 6) == 0) {
            i4 = i3 | (composerK.Z(text) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(473788739, i4, -1, "cz.mobilesoft.coreblock.view.compose.CheckMarkRow (ComposeCommitmentScreen.kt:341)");
            }
            Arrangement.Horizontal horizontalG = Arrangement.f6574a.g();
            Alignment.Vertical verticalI = Alignment.f25072a.i();
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierH = SizeKt.h(SizeKt.k(PaddingKt.k(companion, Dp.g(24), 0.0f, 2, null), Dp.g(48), 0.0f, 2, null), 0.0f, 1, null);
            MeasurePolicy measurePolicyB = RowKt.b(horizontalG, verticalI, composerK, 54);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierH);
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
            Updater.e(composerA, measurePolicyB, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            IconKt.c(PainterResources_androidKt.c(R.drawable.f95565t1, composerK, 0), null, SizeKt.v(companion, Dp.g(32)), ComposeColorsKt.j(composerK, 0).A(), composerK, 432, 0);
            SpacerKt.a(SizeKt.v(companion, Dp.g(8)), composerK, 6);
            composer2 = composerK;
            androidx.compose.material3.TextKt.c(text, null, ComposeColorsKt.j(composerK, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).a(), composer2, i4 & 14, 0, 65530);
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.p4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComposeCommitmentScreenKt.k(text, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(String str, int i3, Composer composer, int i4) {
        j(str, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void l(Modifier modifier, final float f3, final String title, final String description, final Function0 function0, final List checkMarkItems, Composer composer, final int i3, final int i4) throws XmlPullParserException, IOException {
        Modifier modifier2;
        int i5;
        final Modifier modifier3;
        Modifier modifier4;
        int i6;
        int i7;
        int i8;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(checkMarkItems, "checkMarkItems");
        Composer composerK = composer.k(-1060736382);
        int i9 = i4 & 1;
        if (i9 != 0) {
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
            i5 |= composerK.c(f3) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerK.Z(title) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i5 |= composerK.Z(description) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i5 |= composerK.I(function0) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i5 |= composerK.I(checkMarkItems) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if (composerK.r((74899 & i5) != 74898, i5 & 1)) {
            Modifier modifier5 = i9 != 0 ? Modifier.b8 : modifier2;
            if (ComposerKt.M()) {
                ComposerKt.U(-1060736382, i5, -1, "cz.mobilesoft.coreblock.view.compose.CommitmentContent (ComposeCommitmentScreen.kt:227)");
            }
            Alignment.Companion companion = Alignment.f25072a;
            Alignment.Horizontal horizontalG = companion.g();
            Unit unit = null;
            Modifier modifierK = PaddingKt.k(ScrollKt.g(SizeKt.f(modifier5, 0.0f, 1, null), ScrollKt.c(0, composerK, 0, 1), false, null, false, 14, null), PrimitiveResources_androidKt.a(R.dimen.f95486t, composerK, 0), 0.0f, 2, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), horizontalG, composerK, 48);
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
            if (function0 == null) {
                composerK.a0(769864658);
                composerK.U();
                modifier4 = modifier5;
                i6 = i5;
                i7 = 32;
            } else {
                composerK.a0(769864659);
                ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.C1, composerK, 6);
                Modifier modifierC = columnScopeInstance.c(Modifier.b8, companion.k());
                boolean z2 = (57344 & i5) == 16384;
                Object objG = composerK.G();
                if (z2 || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.m4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ComposeCommitmentScreenKt.m(function0);
                        }
                    };
                    composerK.w(objG);
                }
                modifier4 = modifier5;
                i6 = i5;
                i7 = 32;
                ComposeButtonsKt.q0(modifierC, imageVectorB, null, false, 0.0f, 0.0f, 0L, null, (Function0) objG, composerK, 0, 252);
                composerK = composerK;
                Unit unit2 = Unit.f139807a;
                composerK.U();
                unit = Unit.f139807a;
            }
            if (unit == null) {
                composerK.a0(770203830);
                Modifier.Companion companion3 = Modifier.b8;
                i8 = 6;
                SpacerKt.a(SizeKt.i(companion3, Dp.g(i7)), composerK, 6);
                ScreenProgressBarKt.b(columnScopeInstance.c(companion3, companion.g()), f3, composerK, i6 & 112, 0);
                Unit unit3 = Unit.f139807a;
                composerK.U();
            } else {
                i8 = 6;
                composerK.a0(-806449961);
                composerK.U();
            }
            Modifier.Companion companion4 = Modifier.b8;
            SpacerKt.a(SizeKt.i(companion4, Dp.g(30)), composerK, i8);
            TextAlign.Companion companion5 = TextAlign.f29616b;
            float f4 = 16;
            Composer composer2 = composerK;
            int i10 = i8;
            androidx.compose.material3.TextKt.c(title, PaddingKt.k(companion4, Dp.g(f4), 0.0f, 2, null), 0L, 0L, null, null, null, 0L, null, TextAlign.h(companion5.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).f(), composer2, ((i6 >> 6) & 14) | 48, 0, 65020);
            SpacerKt.a(SizeKt.i(companion4, Dp.g(12)), composer2, i10);
            androidx.compose.material3.TextKt.c(description, PaddingKt.k(companion4, Dp.g(f4), 0.0f, 2, null), ComposeColorsKt.j(composer2, 0).q(), 0L, null, null, null, 0L, null, TextAlign.h(companion5.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).b(), composer2, ((i6 >> 9) & 14) | 48, 0, 65016);
            composerK = composer2;
            SpacerKt.a(SizeKt.i(companion4, Dp.g(32)), composerK, i10);
            composerK.a0(-806412615);
            Iterator it = checkMarkItems.iterator();
            while (it.hasNext()) {
                j(StringResources_androidKt.b(((Number) it.next()).intValue(), composerK, 0), composerK, 0);
                SpacerKt.a(SizeKt.i(Modifier.b8, Dp.g(7)), composerK, i10);
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.n4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComposeCommitmentScreenKt.n(modifier3, f3, title, description, function0, checkMarkItems, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(Modifier modifier, float f3, String str, String str2, Function0 function0, List list, int i3, int i4, Composer composer, int i5) throws XmlPullParserException, IOException {
        l(modifier, f3, str, str2, function0, list, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void o(final float f3, final String title, final String description, final String commitmentText, final Function0 function0, final Function0 onContinueClicked, boolean z2, final List checkMarkItems, Composer composer, final int i3, final int i4) {
        float f4;
        int i5;
        boolean z3;
        char c3;
        Composer composer2;
        final boolean z4;
        float f5;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(commitmentText, "commitmentText");
        Intrinsics.checkNotNullParameter(onContinueClicked, "onContinueClicked");
        Intrinsics.checkNotNullParameter(checkMarkItems, "checkMarkItems");
        Composer composerK = composer.k(-823449873);
        if ((i3 & 6) == 0) {
            f4 = f3;
            i5 = (composerK.c(f4) ? 4 : 2) | i3;
        } else {
            f4 = f3;
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.Z(title) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerK.Z(description) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i5 |= composerK.Z(commitmentText) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i5 |= composerK.I(function0) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i5 |= composerK.I(onContinueClicked) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        int i6 = i4 & 64;
        if (i6 != 0) {
            i5 |= 1572864;
            z3 = z2;
            c3 = ' ';
        } else {
            z3 = z2;
            c3 = ' ';
            if ((i3 & 1572864) == 0) {
                i5 |= composerK.b(z3) ? 1048576 : 524288;
            }
        }
        if ((i3 & 12582912) == 0) {
            i5 |= composerK.I(checkMarkItems) ? 8388608 : 4194304;
        }
        if (composerK.r((i5 & 4793491) != 4793490, i5 & 1)) {
            boolean z5 = i6 != 0 ? false : z3;
            if (ComposerKt.M()) {
                ComposerKt.U(-823449873, i5, -1, "cz.mobilesoft.coreblock.view.compose.ComposeCommitmentScreen (ComposeCommitmentScreen.kt:92)");
            }
            WindowInfo windowInfo = (WindowInfo) composerK.q(CompositionLocalsKt.u());
            float F = ((Density) composerK.q(CompositionLocalsKt.f())).F((int) (windowInfo.a() >> c3));
            float F2 = ((Density) composerK.q(CompositionLocalsKt.f())).F((int) (windowInfo.a() & 4294967295L));
            final float fG = Dp.g((float) Math.sqrt((F * F) + (F2 * F2)));
            boolean z6 = ((Configuration) composerK.q(AndroidCompositionLocals_androidKt.f())).orientation == 2;
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.TRUE, null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                f5 = F2;
                objG2 = SnapshotStateKt__SnapshotStateKt.e(Dp.d(Dp.g(100)), null, 2, null);
                composerK.w(objG2);
            } else {
                f5 = F2;
            }
            final MutableState mutableState2 = (MutableState) objG2;
            final State stateC = AnimateAsStateKt.c(((Dp) mutableState2.getValue()).l(), null, "BoxSizeAnimation", null, composerK, 384, 10);
            boolean z7 = (i5 & 57344) == 16384;
            Object objG3 = composerK.G();
            if (z7 || objG3 == companion.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.h4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposeCommitmentScreenKt.q(function0);
                    }
                };
                composerK.w(objG3);
            }
            BackHandlerKt.a(false, (Function0) objG3, composerK, 0, 1);
            Unit unit = Unit.f139807a;
            boolean z8 = (i5 & 3670016) == 1048576;
            Object objG4 = composerK.G();
            if (z8 || objG4 == companion.a()) {
                objG4 = new ComposeCommitmentScreenKt$ComposeCommitmentScreen$2$1(z5, null);
                composerK.w(objG4);
            }
            EffectsKt.g(unit, (Function2) objG4, composerK, 6);
            final float f6 = f4;
            boolean z9 = z5;
            final float f7 = f5;
            final boolean z10 = z6;
            composer2 = composerK;
            ComposeBackgroundKt.m(null, false, false, false, null, 0L, null, ComposableLambdaKt.e(-2038351071, true, new Function3() { // from class: cz.mobilesoft.coreblock.view.compose.i4
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ComposeCommitmentScreenKt.r(mutableState, f6, title, description, function0, checkMarkItems, f7, mutableState2, fG, commitmentText, z10, stateC, onContinueClicked, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composer2, 12582912, 127);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            z4 = z9;
        } else {
            composer2 = composerK;
            composer2.Q();
            z4 = z3;
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.j4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComposeCommitmentScreenKt.u(f3, title, description, commitmentText, function0, onContinueClicked, z4, checkMarkItems, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final float p(State state) {
        return ((Dp) state.getValue()).l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(Function0 function0) {
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(final MutableState mutableState, float f3, String str, String str2, Function0 function0, List list, float f4, final MutableState mutableState2, final float f5, String str3, boolean z2, State state, final Function0 function02, BoxScope GradientBox, Composer composer, int i3) throws XmlPullParserException, IOException {
        float f6;
        BoxScopeInstance boxScopeInstance;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(GradientBox, "$this$GradientBox");
        if (composer2.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2038351071, i3, -1, "cz.mobilesoft.coreblock.view.compose.ComposeCommitmentScreen.<anonymous> (ComposeCommitmentScreen.kt:116)");
            }
            if (((Boolean) mutableState.getValue()).booleanValue()) {
                composer2.a0(2026013725);
                Modifier.Companion companion = Modifier.b8;
                Modifier modifierF = SizeKt.f(WindowInsetsPaddingKt.d(companion, WindowInsets_androidKt.c(WindowInsets.f7172a, composer2, 6)), 0.0f, 1, null);
                Alignment.Companion companion2 = Alignment.f25072a;
                MeasurePolicy measurePolicyG = BoxKt.g(companion2.b(), false);
                int iA = ComposablesKt.a(composer2, 0);
                CompositionLocalMap compositionLocalMapU = composer2.u();
                Modifier modifierF2 = ComposedModifierKt.f(composer2, modifierF);
                ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
                Function0 function0A = companion3.a();
                if (composer2.m() == null) {
                    ComposablesKt.c();
                }
                composer2.L();
                if (composer2.i()) {
                    composer2.P(function0A);
                } else {
                    composer2.v();
                }
                Composer composerA = Updater.a(composer2);
                Updater.e(composerA, measurePolicyG, companion3.e());
                Updater.e(composerA, compositionLocalMapU, companion3.g());
                Function2 function2B = companion3.b();
                if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                    composerA.w(Integer.valueOf(iA));
                    composerA.p(Integer.valueOf(iA), function2B);
                }
                Updater.e(composerA, modifierF2, companion3.f());
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.f6642a;
                l(null, f3, str, str2, function0, list, composer2, 0, 1);
                Modifier modifierF3 = boxScopeInstance2.f(companion, companion2.b());
                Arrangement arrangement = Arrangement.f6574a;
                MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.h(), companion2.k(), composer2, 0);
                int iA2 = ComposablesKt.a(composer2, 0);
                CompositionLocalMap compositionLocalMapU2 = composer2.u();
                Modifier modifierF4 = ComposedModifierKt.f(composer2, modifierF3);
                Function0 function0A2 = companion3.a();
                if (composer2.m() == null) {
                    ComposablesKt.c();
                }
                composer2.L();
                if (composer2.i()) {
                    composer2.P(function0A2);
                } else {
                    composer2.v();
                }
                Composer composerA2 = Updater.a(composer2);
                Updater.e(composerA2, measurePolicyA, companion3.e());
                Updater.e(composerA2, compositionLocalMapU2, companion3.g());
                Function2 function2B2 = companion3.b();
                if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                    composerA2.w(Integer.valueOf(iA2));
                    composerA2.p(Integer.valueOf(iA2), function2B2);
                }
                Updater.e(composerA2, modifierF4, companion3.f());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
                TextStyle textStyleH = ComposeTypographyKt.g(composer2, 0).h();
                TextAlign.Companion companion4 = TextAlign.f29616b;
                androidx.compose.material3.TextKt.c(str3, SizeKt.h(PaddingKt.k(companion, Dp.g(32), 0.0f, 2, null), 0.0f, 1, null), ComposeColorsKt.j(composer2, 0).p(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, textStyleH, composer, 48, 0, 65016);
                SpacerKt.a(SizeKt.i(companion, Dp.g(8)), composer, 6);
                androidx.compose.material3.TextKt.c(StringResources_androidKt.b(R.string.jq, composer, 0), SizeKt.h(PaddingKt.k(companion, Dp.g(16), 0.0f, 2, null), 0.0f, 1, null), ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).b(), composer, 48, 0, 65016);
                composer2 = composer;
                if (z2) {
                    composer2.a0(-788854351);
                    SpacerKt.a(SizeKt.i(companion, Dp.g(24)), composer2, 6);
                    composer2.U();
                } else {
                    composer2.a0(-788760111);
                    SpacerKt.a(SizeKt.i(companion, Dp.g(64)), composer2, 6);
                    composer2.U();
                }
                composer2.y();
                float f7 = f4 / 2.2f;
                Modifier modifierM = PaddingKt.m(boxScopeInstance2.f(SizeKt.G(SizeKt.f(companion, 0.0f, 1, null), null, true, 1, null), companion2.e()), 0.0f, Dp.g(Dp.g(f7)), 0.0f, 0.0f, 13, null);
                MeasurePolicy measurePolicyA2 = ColumnKt.a(arrangement.h(), companion2.k(), composer2, 0);
                int iA3 = ComposablesKt.a(composer2, 0);
                CompositionLocalMap compositionLocalMapU3 = composer2.u();
                Modifier modifierF5 = ComposedModifierKt.f(composer2, modifierM);
                Function0 function0A3 = companion3.a();
                if (composer2.m() == null) {
                    ComposablesKt.c();
                }
                composer2.L();
                if (composer2.i()) {
                    composer2.P(function0A3);
                } else {
                    composer2.v();
                }
                Composer composerA3 = Updater.a(composer2);
                Updater.e(composerA3, measurePolicyA2, companion3.e());
                Updater.e(composerA3, compositionLocalMapU3, companion3.g());
                Function2 function2B3 = companion3.b();
                if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                    composerA3.w(Integer.valueOf(iA3));
                    composerA3.p(Integer.valueOf(iA3), function2B3);
                }
                Updater.e(composerA3, modifierF5, companion3.f());
                BoxKt.a(SizeKt.G(BackgroundKt.c(SizeKt.v(companion, p(state)), ComposeColorsKt.j(composer2, 0).b(), RoundedCornerShapeKt.g()), null, true, 1, null), composer2, 0);
                composer2.y();
                if (Dp.f(((Dp) mutableState2.getValue()).l(), Dp.g(1.1f * f5)) > 0) {
                    composer2.a0(-540349287);
                    boxScopeInstance = boxScopeInstance2;
                    f6 = 0.0f;
                    androidx.compose.material3.TextKt.c(StringResources_androidKt.b(R.string.If, composer2, 0), PaddingKt.m(boxScopeInstance2.f(companion, companion2.m()), 0.0f, Dp.g(Dp.g(f4 / 4)), 0.0f, 0.0f, 13, null), ComposeColorsKt.j(composer2, 0).q0(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).f(), composer, 0, 0, 65528);
                    composer2 = composer;
                } else {
                    f6 = 0.0f;
                    boxScopeInstance = boxScopeInstance2;
                    composer2.a0(-548027584);
                }
                composer2.U();
                BoxScopeInstance boxScopeInstance3 = boxScopeInstance;
                Modifier modifierM2 = PaddingKt.m(boxScopeInstance3.f(SizeKt.f(companion, f6, 1, null), companion2.e()), 0.0f, Dp.g(Dp.g(f7)), 0.0f, 0.0f, 13, null);
                MeasurePolicy measurePolicyG2 = BoxKt.g(companion2.o(), false);
                int iA4 = ComposablesKt.a(composer2, 0);
                CompositionLocalMap compositionLocalMapU4 = composer2.u();
                Modifier modifierF6 = ComposedModifierKt.f(composer2, modifierM2);
                Function0 function0A4 = companion3.a();
                if (composer2.m() == null) {
                    ComposablesKt.c();
                }
                composer2.L();
                if (composer2.i()) {
                    composer2.P(function0A4);
                } else {
                    composer2.v();
                }
                Composer composerA4 = Updater.a(composer2);
                Updater.e(composerA4, measurePolicyG2, companion3.e());
                Updater.e(composerA4, compositionLocalMapU4, companion3.g());
                Function2 function2B4 = companion3.b();
                if (composerA4.i() || !Intrinsics.areEqual(composerA4.G(), Integer.valueOf(iA4))) {
                    composerA4.w(Integer.valueOf(iA4));
                    composerA4.p(Integer.valueOf(iA4), function2B4);
                }
                Updater.e(composerA4, modifierF6, companion3.f());
                ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.D3, composer2, 6);
                boolean zC = composer2.c(f5);
                Object objG = composer2.G();
                if (zC || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.k4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ComposeCommitmentScreenKt.s(mutableState2, f5);
                        }
                    };
                    composer2.w(objG);
                }
                Function0 function03 = (Function0) objG;
                boolean Z = composer2.Z(function02);
                Object objG2 = composer2.G();
                if (Z || objG2 == Composer.f23746a.a()) {
                    objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.l4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ComposeCommitmentScreenKt.t(function02, mutableState);
                        }
                    };
                    composer2.w(objG2);
                }
                androidx.compose.foundation.ImageKt.b(imageVectorB, null, boxScopeInstance3.f(SizeKt.v(w(companion, 0L, 0L, function03, (Function0) objG2, 3, null), Dp.g(64)), companion2.e()), null, null, 0.0f, null, composer2, 48, 120);
                composer2.y();
                composer2.y();
            } else {
                composer2.a0(2021002017);
            }
            composer2.U();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(MutableState mutableState, float f3) {
        mutableState.setValue(RangesKt.m(Dp.d(Dp.g(((Dp) mutableState.getValue()).l() * 1.1f)), Dp.d(Dp.g(Dp.g(f3 * 1.1f) + Dp.g(500)))));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(Function0 function0, MutableState mutableState) {
        function0.invoke();
        mutableState.setValue(Boolean.FALSE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(float f3, String str, String str2, String str3, Function0 function0, Function0 function02, boolean z2, List list, int i3, int i4, Composer composer, int i5) {
        o(f3, str, str2, str3, function0, function02, z2, list, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final Modifier v(Modifier pressAndHoldAnimation, final long j3, final long j4, final Function0 onHold, final Function0 onComplete) {
        Intrinsics.checkNotNullParameter(pressAndHoldAnimation, "$this$pressAndHoldAnimation");
        Intrinsics.checkNotNullParameter(onHold, "onHold");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        return ComposedModifierKt.c(pressAndHoldAnimation, null, new Function3() { // from class: cz.mobilesoft.coreblock.view.compose.o4
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return ComposeCommitmentScreenKt.x(onComplete, j3, j4, onHold, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, 1, null);
    }

    public static /* synthetic */ Modifier w(Modifier modifier, long j3, long j4, Function0 function0, Function0 function02, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            Duration.Companion companion = Duration.f140631b;
            j3 = DurationKt.r(2.5d, DurationUnit.f140641f);
        }
        long j5 = j3;
        if ((i3 & 2) != 0) {
            Duration.Companion companion2 = Duration.f140631b;
            j4 = DurationKt.s(50, DurationUnit.f140640d);
        }
        return v(modifier, j5, j4, function0, function02);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier x(final Function0 function0, final long j3, final long j4, final Function0 function02, Modifier composed, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composed, "$this$composed");
        composer.a0(-1026812234);
        if (ComposerKt.M()) {
            ComposerKt.U(-1026812234, i3, -1, "cz.mobilesoft.coreblock.view.compose.pressAndHoldAnimation.<anonymous> (ComposeCommitmentScreen.kt:279)");
        }
        Object objG = composer.G();
        Composer.Companion companion = Composer.f23746a;
        if (objG == companion.a()) {
            objG = EffectsKt.l(EmptyCoroutineContext.f139889a, composer);
            composer.w(objG);
        }
        final CoroutineScope coroutineScope = (CoroutineScope) objG;
        Object objG2 = composer.G();
        if (objG2 == companion.a()) {
            objG2 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
            composer.w(objG2);
        }
        final MutableState mutableState = (MutableState) objG2;
        Object objG3 = composer.G();
        if (objG3 == companion.a()) {
            objG3 = new ComposeCommitmentScreenKt$pressAndHoldAnimation$1$1$1(mutableState, null);
            composer.w(objG3);
        }
        EffectsKt.g(function0, (Function2) objG3, composer, 0);
        boolean zF = composer.f(j3) | composer.I(coroutineScope) | composer.f(j4) | composer.Z(function02) | composer.Z(function0);
        Object objG4 = composer.G();
        if (zF || objG4 == companion.a()) {
            objG4 = new PointerInputEventHandler() { // from class: cz.mobilesoft.coreblock.view.compose.ComposeCommitmentScreenKt$pressAndHoldAnimation$1$2$1

                /* JADX INFO: renamed from: cz.mobilesoft.coreblock.view.compose.ComposeCommitmentScreenKt$pressAndHoldAnimation$1$2$1$1, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                @DebugMetadata(c = "cz.mobilesoft.coreblock.view.compose.ComposeCommitmentScreenKt$pressAndHoldAnimation$1$2$1$1", f = "ComposeCommitmentScreen.kt", l = {293, 325}, m = "invokeSuspend", v = 1)
                static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    Object f130425a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    Object f130426b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    int f130427c;

                    /* JADX INFO: renamed from: d, reason: collision with root package name */
                    private /* synthetic */ Object f130428d;

                    /* JADX INFO: renamed from: f, reason: collision with root package name */
                    final /* synthetic */ MutableState f130429f;

                    /* JADX INFO: renamed from: g, reason: collision with root package name */
                    final /* synthetic */ CoroutineScope f130430g;

                    /* JADX INFO: renamed from: h, reason: collision with root package name */
                    final /* synthetic */ Function0 f130431h;

                    /* JADX INFO: renamed from: i, reason: collision with root package name */
                    final /* synthetic */ long f130432i;

                    /* JADX INFO: renamed from: j, reason: collision with root package name */
                    final /* synthetic */ Function0 f130433j;

                    /* JADX INFO: renamed from: k, reason: collision with root package name */
                    final /* synthetic */ FloatTweenSpec f130434k;

                    /* JADX INFO: renamed from: l, reason: collision with root package name */
                    final /* synthetic */ long f130435l;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(MutableState mutableState, CoroutineScope coroutineScope, Function0 function0, long j3, Function0 function02, FloatTweenSpec floatTweenSpec, long j4, Continuation continuation) {
                        super(2, continuation);
                        this.f130429f = mutableState;
                        this.f130430g = coroutineScope;
                        this.f130431h = function0;
                        this.f130432i = j3;
                        this.f130433j = function02;
                        this.f130434k = floatTweenSpec;
                        this.f130435l = j4;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation create(Object obj, Continuation continuation) {
                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f130429f, this.f130430g, this.f130431h, this.f130432i, this.f130433j, this.f130434k, this.f130435l, continuation);
                        anonymousClass1.f130428d = obj;
                        return anonymousClass1;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation continuation) {
                        return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.f139807a);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:19:0x00a3  */
                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final java.lang.Object invokeSuspend(java.lang.Object r22) throws java.lang.Throwable {
                        /*
                            r21 = this;
                            r3 = r21
                            java.lang.Object r0 = r3.f130428d
                            androidx.compose.ui.input.pointer.AwaitPointerEventScope r0 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r0
                            java.lang.Object r6 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                            int r1 = r3.f130427c
                            r7 = 2
                            r8 = 0
                            r9 = 1
                            if (r1 == 0) goto L30
                            if (r1 == r9) goto L2a
                            if (r1 != r7) goto L22
                            java.lang.Object r0 = r3.f130426b
                            kotlinx.coroutines.Job r0 = (kotlinx.coroutines.Job) r0
                            java.lang.Object r1 = r3.f130425a
                            androidx.compose.ui.input.pointer.PointerInputChange r1 = (androidx.compose.ui.input.pointer.PointerInputChange) r1
                            kotlin.ResultKt.b(r22)
                            goto L92
                        L22:
                            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                            r0.<init>(r1)
                            throw r0
                        L2a:
                            kotlin.ResultKt.b(r22)
                            r1 = r22
                            goto L42
                        L30:
                            kotlin.ResultKt.b(r22)
                            r3.f130428d = r0
                            r3.f130427c = r9
                            r1 = 0
                            r2 = 0
                            r4 = 2
                            r5 = 0
                            java.lang.Object r1 = androidx.compose.foundation.gestures.TapGestureDetectorKt.f(r0, r1, r2, r3, r4, r5)
                            if (r1 != r6) goto L42
                            goto L90
                        L42:
                            r13 = r1
                            androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
                            androidx.compose.runtime.MutableState r1 = r3.f130429f
                            r2 = 0
                            java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.Boxing.a(r2)
                            r1.setValue(r2)
                            kotlinx.coroutines.CoroutineScope r1 = r3.f130430g
                            cz.mobilesoft.coreblock.view.compose.ComposeCommitmentScreenKt$pressAndHoldAnimation$1$2$1$1$holdJob$1 r17 = new cz.mobilesoft.coreblock.view.compose.ComposeCommitmentScreenKt$pressAndHoldAnimation$1$2$1$1$holdJob$1
                            long r11 = r3.f130432i
                            androidx.compose.runtime.MutableState r14 = r3.f130429f
                            kotlin.jvm.functions.Function0 r15 = r3.f130433j
                            androidx.compose.animation.core.FloatTweenSpec r2 = r3.f130434k
                            long r4 = r3.f130435l
                            kotlin.jvm.functions.Function0 r10 = r3.f130431h
                            r20 = 0
                            r16 = r2
                            r19 = r10
                            r10 = r17
                            r17 = r4
                            r10.<init>(r11, r13, r14, r15, r16, r17, r19, r20)
                            r17 = r10
                            r18 = 3
                            r19 = 0
                            r15 = 0
                            r16 = 0
                            r14 = r1
                            kotlinx.coroutines.Job r1 = kotlinx.coroutines.BuildersKt.d(r14, r15, r16, r17, r18, r19)
                            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.a(r0)
                            r3.f130428d = r2
                            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.a(r13)
                            r3.f130425a = r2
                            r3.f130426b = r1
                            r3.f130427c = r7
                            java.lang.Object r0 = androidx.compose.foundation.gestures.TapGestureDetectorKt.v(r0, r8, r3, r9, r8)
                            if (r0 != r6) goto L91
                        L90:
                            return r6
                        L91:
                            r0 = r1
                        L92:
                            kotlinx.coroutines.Job.DefaultImpls.b(r0, r8, r9, r8)
                            androidx.compose.runtime.MutableState r0 = r3.f130429f
                            java.lang.Object r0 = r0.getValue()
                            java.lang.Boolean r0 = (java.lang.Boolean) r0
                            boolean r0 = r0.booleanValue()
                            if (r0 != 0) goto Lb1
                            androidx.compose.runtime.MutableState r0 = r3.f130429f
                            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.a(r9)
                            r0.setValue(r1)
                            kotlin.jvm.functions.Function0 r0 = r3.f130431h
                            r0.invoke()
                        Lb1:
                            kotlin.Unit r0 = kotlin.Unit.f139807a
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.ComposeCommitmentScreenKt$pressAndHoldAnimation$1$2$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
                    }
                }

                @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
                    Object objE = ForEachGestureKt.e(pointerInputScope, new AnonymousClass1(mutableState, coroutineScope, function0, j4, function02, new FloatTweenSpec((int) Duration.p(j3), 0, EasingKt.f()), j3, null), continuation);
                    return objE == IntrinsicsKt.f() ? objE : Unit.f139807a;
                }
            };
            composer.w(objG4);
        }
        Modifier modifierD = SuspendingPointerInputFilterKt.d(composed, function0, (PointerInputEventHandler) objG4);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return modifierD;
    }
}
