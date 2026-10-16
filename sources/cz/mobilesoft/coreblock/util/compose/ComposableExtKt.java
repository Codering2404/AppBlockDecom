package cz.mobilesoft.coreblock.util.compose;

import android.content.Context;
import android.content.res.Resources;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.KeyframesSpec;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.media3.exoplayer.audio.wRw.CbYNFSEGaQj;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore;
import cz.mobilesoft.coreblock.util.view.ViewHelperExtKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
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
public final class ComposableExtKt {
    public static final PaddingValues h(boolean z2, boolean z3, Composer composer, int i3, int i4) {
        if ((i4 & 1) != 0) {
            z2 = true;
        }
        if ((i4 & 2) != 0) {
            z3 = true;
        }
        if (ComposerKt.M()) {
            ComposerKt.U(1719058956, i3, -1, "cz.mobilesoft.coreblock.util.compose.ActivityPadding (ComposableExt.kt:159)");
        }
        Dp dpD = Dp.d(PrimitiveResources_androidKt.a(R.dimen.f95468b, composer, 0));
        dpD.l();
        if (!z2) {
            dpD = null;
        }
        float fL = dpD != null ? dpD.l() : Dp.g(0);
        Dp dpD2 = Dp.d(PrimitiveResources_androidKt.a(R.dimen.f95467a, composer, 0));
        dpD2.l();
        Dp dp = z3 ? dpD2 : null;
        PaddingValues paddingValuesB = PaddingKt.b(dp != null ? dp.l() : Dp.g(0), fL);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return paddingValuesB;
    }

    public static final PaddingValues i(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1427350156, i3, -1, "cz.mobilesoft.coreblock.util.compose.ActivityPaddingHorizontal (ComposableExt.kt:167)");
        }
        PaddingValues paddingValuesH = h(false, false, composer, 6, 2);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return paddingValuesH;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void j(final androidx.lifecycle.LifecycleOwner r7, final kotlin.jvm.functions.Function2 r8, androidx.compose.runtime.Composer r9, final int r10, final int r11) {
        /*
            java.lang.String r0 = "onEvent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = -368883063(0xffffffffea034a89, float:-3.9680316E25)
            androidx.compose.runtime.Composer r9 = r9.k(r0)
            r1 = r10 & 6
            if (r1 != 0) goto L1f
            r1 = r11 & 1
            if (r1 != 0) goto L1c
            boolean r1 = r9.I(r7)
            if (r1 == 0) goto L1c
            r1 = 4
            goto L1d
        L1c:
            r1 = 2
        L1d:
            r1 = r1 | r10
            goto L20
        L1f:
            r1 = r10
        L20:
            r2 = r10 & 48
            r3 = 32
            if (r2 != 0) goto L31
            boolean r2 = r9.I(r8)
            if (r2 == 0) goto L2e
            r2 = r3
            goto L30
        L2e:
            r2 = 16
        L30:
            r1 = r1 | r2
        L31:
            r2 = r1 & 19
            r4 = 18
            r5 = 0
            r6 = 1
            if (r2 == r4) goto L3b
            r2 = r6
            goto L3c
        L3b:
            r2 = r5
        L3c:
            r4 = r1 & 1
            boolean r2 = r9.r(r2, r4)
            if (r2 == 0) goto Lab
            r9.J()
            r2 = r10 & 1
            if (r2 == 0) goto L5c
            boolean r2 = r9.S()
            if (r2 == 0) goto L52
            goto L5c
        L52:
            r9.Q()
            r2 = r11 & 1
            if (r2 == 0) goto L6b
        L59:
            r1 = r1 & (-15)
            goto L6b
        L5c:
            r2 = r11 & 1
            if (r2 == 0) goto L6b
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalLifecycleOwner()
            java.lang.Object r7 = r9.q(r7)
            androidx.lifecycle.LifecycleOwner r7 = (androidx.lifecycle.LifecycleOwner) r7
            goto L59
        L6b:
            r9.z()
            boolean r2 = androidx.compose.runtime.ComposerKt.M()
            if (r2 == 0) goto L7a
            r2 = -1
            java.lang.String r4 = "cz.mobilesoft.coreblock.util.compose.ComposableLifecycle (ComposableExt.kt:42)"
            androidx.compose.runtime.ComposerKt.U(r0, r1, r2, r4)
        L7a:
            r0 = r1 & 112(0x70, float:1.57E-43)
            if (r0 != r3) goto L7f
            r5 = r6
        L7f:
            boolean r0 = r9.I(r7)
            r0 = r0 | r5
            java.lang.Object r2 = r9.G()
            if (r0 != 0) goto L92
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.f23746a
            java.lang.Object r0 = r0.a()
            if (r2 != r0) goto L9a
        L92:
            cz.mobilesoft.coreblock.util.compose.a r2 = new cz.mobilesoft.coreblock.util.compose.a
            r2.<init>()
            r9.w(r2)
        L9a:
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r0 = r1 & 14
            androidx.compose.runtime.EffectsKt.c(r7, r2, r9, r0)
            boolean r0 = androidx.compose.runtime.ComposerKt.M()
            if (r0 == 0) goto Lae
            androidx.compose.runtime.ComposerKt.T()
            goto Lae
        Lab:
            r9.Q()
        Lae:
            androidx.compose.runtime.ScopeUpdateScope r9 = r9.n()
            if (r9 == 0) goto Lbc
            cz.mobilesoft.coreblock.util.compose.b r0 = new cz.mobilesoft.coreblock.util.compose.b
            r0.<init>()
            r9.a(r0)
        Lbc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.compose.ComposableExtKt.j(androidx.lifecycle.LifecycleOwner, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult k(final LifecycleOwner lifecycleOwner, final Function2 function2, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        final LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: cz.mobilesoft.coreblock.util.compose.e
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void j(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                ComposableExtKt.l(function2, lifecycleOwner2, event);
            }
        };
        lifecycleOwner.getLifecycle().addObserver(lifecycleEventObserver);
        return new DisposableEffectResult() { // from class: cz.mobilesoft.coreblock.util.compose.ComposableExtKt$ComposableLifecycle$lambda$0$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                lifecycleOwner.getLifecycle().removeObserver(lifecycleEventObserver);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(Function2 function2, LifecycleOwner source, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        function2.invoke(source, event);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(LifecycleOwner lifecycleOwner, Function2 function2, int i3, int i4, Composer composer, int i5) {
        j(lifecycleOwner, function2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0142  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void n(final cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore r8, final kotlin.jvm.functions.Function2 r9, androidx.compose.runtime.Composer r10, final int r11, final int r12) {
        /*
            Method dump skipped, instruction units count: 344
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.compose.ComposableExtKt.n(cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final String o(State state) {
        return (String) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(Function2 function2, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1386877959, i3, -1, "cz.mobilesoft.coreblock.util.compose.ProvideLocalizedContext.<anonymous> (ComposableExt.kt:198)");
            }
            function2.invoke(composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(CoreMultiProcessDataStore coreMultiProcessDataStore, Function2 function2, int i3, int i4, Composer composer, int i5) {
        n(coreMultiProcessDataStore, function2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final Modifier r(Modifier modifier, boolean z2, Function1 modify) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(modify, "modify");
        return z2 ? (Modifier) modify.invoke(modifier) : modifier;
    }

    public static final String t(int i3, int i4, Object[] formatArgs, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(formatArgs, "formatArgs");
        if (ComposerKt.M()) {
            ComposerKt.U(-1196996812, i5, -1, "cz.mobilesoft.coreblock.util.compose.pluralStringResource (ComposableExt.kt:60)");
        }
        String quantityString = ((Context) composer.q(AndroidCompositionLocals_androidKt.g())).getResources().getQuantityString(i3, i4, Arrays.copyOf(formatArgs, formatArgs.length));
        Intrinsics.checkNotNullExpressionValue(quantityString, "getQuantityString(...)");
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return quantityString;
    }

    public static final Modifier u(Modifier modifier, final boolean z2) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return ComposedModifierKt.c(modifier, null, new Function3() { // from class: cz.mobilesoft.coreblock.util.compose.f
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return ComposableExtKt.v(z2, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier v(boolean z2, Modifier composed, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composed, "$this$composed");
        composer.a0(-669715221);
        if (ComposerKt.M()) {
            ComposerKt.U(-669715221, i3, -1, "cz.mobilesoft.coreblock.util.compose.shake.<anonymous> (ComposableExt.kt:102)");
        }
        Object objG = composer.G();
        Composer.Companion companion = Composer.f23746a;
        if (objG == companion.a()) {
            objG = AnimatableKt.b(0.0f, 0.0f, 2, null);
            composer.w(objG);
        }
        Animatable animatable = (Animatable) objG;
        Object objG2 = composer.G();
        if (objG2 == companion.a()) {
            objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.util.compose.g
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ComposableExtKt.w((KeyframesSpec.KeyframesSpecConfig) obj);
                }
            };
            composer.w(objG2);
        }
        KeyframesSpec keyframesSpecF = AnimationSpecKt.f((Function1) objG2);
        Boolean boolValueOf = Boolean.valueOf(z2);
        boolean zB = composer.b(z2) | composer.I(animatable);
        Object objG3 = composer.G();
        if (zB || objG3 == companion.a()) {
            objG3 = new ComposableExtKt$shake$1$1$1(z2, animatable, keyframesSpecF, null);
            composer.w(objG3);
        }
        EffectsKt.g(boolValueOf, (Function2) objG3, composer, 0);
        Modifier modifierC = OffsetKt.c(composed, Dp.g(((Number) animatable.n()).floatValue()), Dp.g(0));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return modifierC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(KeyframesSpec.KeyframesSpecConfig keyframes) {
        Intrinsics.checkNotNullParameter(keyframes, "$this$keyframes");
        keyframes.d(800);
        Easing easingC = EasingKt.c();
        for (int i3 = 1; i3 < 9; i3++) {
            int i4 = i3 % 3;
            keyframes.g(keyframes.f(Float.valueOf(i4 != 0 ? i4 != 1 ? 0.0f : -8.0f : 8.0f), (keyframes.b() / 10) * i3), easingC);
        }
        return Unit.f139807a;
    }

    public static final float x(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-712207681, i3, -1, "cz.mobilesoft.coreblock.util.compose.statusBarHeight (ComposableExt.kt:55)");
        }
        composer.a0(-1531780519);
        Density density = (Density) composer.q(CompositionLocalsKt.f());
        Resources resources = ((Context) composer.q(AndroidCompositionLocals_androidKt.g())).getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        float F = density.F(ViewHelperExtKt.e(resources));
        composer.U();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return F;
    }

    public static final TextStyle y(TextStyle textStyle, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(textStyle, "<this>");
        if (ComposerKt.M()) {
            ComposerKt.U(2079876113, i3, -1, "cz.mobilesoft.coreblock.util.compose.withGradient (ComposableExt.kt:97)");
        }
        TextStyle textStyleC = TextStyle.c(textStyle, ComposeTypographyKt.e(composer, 0), 0.0f, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 33554430, null);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return textStyleC;
    }

    public static final Modifier s(Modifier modifier, boolean z2, Function1 modify, Function1 function1) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(modify, "modify");
        Intrinsics.checkNotNullParameter(function1, CbYNFSEGaQj.CFSILI);
        return z2 ? (Modifier) modify.invoke(modifier) : (Modifier) function1.invoke(modifier);
    }
}
