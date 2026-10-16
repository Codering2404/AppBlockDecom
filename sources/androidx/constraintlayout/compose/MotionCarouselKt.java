package androidx.constraintlayout.compose;

import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class MotionCarouselKt {
    public static final void a(final int i3, final String str, final boolean z2, final Function2 function2, Composer composer, final int i4) {
        int i5;
        Composer composerK = composer.k(1970516035);
        if ((i4 & 6) == 0) {
            i5 = (composerK.e(i3) ? 4 : 2) | i4;
        } else {
            i5 = i4;
        }
        if ((i4 & 48) == 0) {
            i5 |= composerK.Z(str) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            i5 |= composerK.b(z2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 3072) == 0) {
            i5 |= composerK.I(function2) ? 2048 : 1024;
        }
        if ((i5 & 1171) == 1170 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1970516035, i5, -1, "androidx.constraintlayout.compose.ItemHolder (MotionCarousel.kt:250)");
            }
            Modifier modifierD = ConstraintLayoutTagKt.d(Modifier.b8, str + i3, null, 2, null);
            if (z2) {
                float f3 = 20;
                modifierD = BorderKt.f(ClipKt.a(modifierD, RoundedCornerShapeKt.d(Dp.g(f3))), Dp.g(2), ColorKt.c(0, 0, 0, 60), RoundedCornerShapeKt.d(Dp.g(f3)));
            }
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.e(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierD);
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
            Updater.e(composerA, measurePolicyG, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            function2.invoke(composerK, Integer.valueOf((i5 >> 9) & 14));
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$ItemHolder$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i6) {
                    MotionCarouselKt.a(i3, str, z2, function2, composer2, RecomposeScopeImplKt.a(i4 | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0340  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x041b  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x042a  */
    /* JADX WARN: Removed duplicated region for block: B:180:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void b(final androidx.constraintlayout.compose.MotionScene r36, final int r37, final int r38, java.lang.String r39, java.lang.String r40, java.lang.String r41, boolean r42, final kotlin.jvm.functions.Function1 r43, androidx.compose.runtime.Composer r44, final int r45, final int r46) {
        /*
            Method dump skipped, instruction units count: 1081
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.compose.MotionCarouselKt.b(androidx.constraintlayout.compose.MotionScene, int, int, java.lang.String, java.lang.String, java.lang.String, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final float c(MutableFloatState mutableFloatState) {
        return mutableFloatState.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(MutableFloatState mutableFloatState, float f3) {
        mutableFloatState.s(f3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CarouselState e(MutableState mutableState) {
        return (CarouselState) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int f(MutableIntState mutableIntState) {
        return mutableIntState.g();
    }

    private static final void g(MutableIntState mutableIntState, int i3) {
        mutableIntState.a(i3);
    }

    private static final androidx.compose.runtime.State k(Function1 function1, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1507876322, i3, -1, "androidx.constraintlayout.compose.rememberStateOfItemsProvider (MotionCarousel.kt:307)");
        }
        final androidx.compose.runtime.State stateP = SnapshotStateKt.p(function1, composer, i3 & 14);
        Object objG = composer.G();
        if (objG == Composer.f23746a.a()) {
            objG = SnapshotStateKt.e(new Function0<MotionCarouselScopeImpl>() { // from class: androidx.constraintlayout.compose.MotionCarouselKt$rememberStateOfItemsProvider$1$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final MotionCarouselScopeImpl invoke() {
                    MotionCarouselScopeImpl motionCarouselScopeImpl = new MotionCarouselScopeImpl();
                    ((Function1) stateP.getValue()).invoke(motionCarouselScopeImpl);
                    return motionCarouselScopeImpl;
                }
            });
            composer.w(objG);
        }
        androidx.compose.runtime.State state = (androidx.compose.runtime.State) objG;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return state;
    }
}
