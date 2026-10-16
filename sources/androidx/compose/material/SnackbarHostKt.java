package androidx.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AccessibilityManager;
import androidx.compose.ui.platform.CompositionLocalsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class SnackbarHostKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14083a;

        static {
            int[] iArr = new int[SnackbarDuration.values().length];
            try {
                iArr[SnackbarDuration.Indefinite.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SnackbarDuration.Long.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SnackbarDuration.Short.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f14083a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01bb A[LOOP:2: B:78:0x01b9->B:79:0x01bb, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(final androidx.compose.material.SnackbarData r16, androidx.compose.ui.Modifier r17, final kotlin.jvm.functions.Function3 r18, androidx.compose.runtime.Composer r19, final int r20, final int r21) {
        /*
            Method dump skipped, instruction units count: 526
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SnackbarHostKt.a(androidx.compose.material.SnackbarData, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void b(final SnackbarHostState snackbarHostState, Modifier modifier, Function3 function3, Composer composer, final int i3, final int i4) {
        int i5;
        final Modifier modifier2;
        final Function3 function32;
        Composer composerK = composer.k(431012348);
        if ((i4 & 1) != 0) {
            i5 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i5 = (composerK.Z(snackbarHostState) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        int i6 = i4 & 2;
        if (i6 != 0) {
            i5 |= 48;
        } else if ((i3 & 48) == 0) {
            i5 |= composerK.Z(modifier) ? 32 : 16;
        }
        int i7 = i4 & 4;
        if (i7 != 0) {
            i5 |= 384;
        } else if ((i3 & 384) == 0) {
            i5 |= composerK.I(function3) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i5 & 147) == 146 && composerK.l()) {
            composerK.Q();
            modifier2 = modifier;
            function32 = function3;
        } else {
            if (i6 != 0) {
                modifier = Modifier.b8;
            }
            if (i7 != 0) {
                function3 = ComposableSingletons$SnackbarHostKt.f12521a.a();
            }
            Function3 function33 = function3;
            if (ComposerKt.M()) {
                ComposerKt.U(431012348, i5, -1, "androidx.compose.material.SnackbarHost (SnackbarHost.kt:157)");
            }
            SnackbarData snackbarDataB = snackbarHostState.b();
            AccessibilityManager accessibilityManager = (AccessibilityManager) composerK.q(CompositionLocalsKt.c());
            boolean zI = composerK.I(snackbarDataB) | composerK.I(accessibilityManager);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new SnackbarHostKt$SnackbarHost$1$1(snackbarDataB, accessibilityManager, null);
                composerK.w(objG);
            }
            EffectsKt.g(snackbarDataB, (Function2) objG, composerK, 0);
            Modifier modifier3 = modifier;
            a(snackbarHostState.b(), modifier3, function33, composerK, i5 & 1008, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            modifier2 = modifier3;
            function32 = function33;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SnackbarHostKt$SnackbarHost$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i8) {
                    SnackbarHostKt.b(snackbarHostState, modifier2, function32, composer2, RecomposeScopeImplKt.a(i3 | 1), i4);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final State f(AnimationSpec animationSpec, boolean z2, Function0 function0, Composer composer, int i3, int i4) {
        if ((i4 & 4) != 0) {
            function0 = new Function0<Unit>() { // from class: androidx.compose.material.SnackbarHostKt$animatedOpacity$1
                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m135invoke() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m135invoke();
                    return Unit.f139807a;
                }
            };
        }
        Function0 function02 = function0;
        if (ComposerKt.M()) {
            ComposerKt.U(1016418159, i3, -1, "androidx.compose.material.animatedOpacity (SnackbarHost.kt:353)");
        }
        Object objG = composer.G();
        Composer.Companion companion = Composer.f23746a;
        if (objG == companion.a()) {
            objG = AnimatableKt.b(!z2 ? 1.0f : 0.0f, 0.0f, 2, null);
            composer.w(objG);
        }
        Animatable animatable = (Animatable) objG;
        Boolean boolValueOf = Boolean.valueOf(z2);
        boolean zI = composer.I(animatable) | ((((i3 & 112) ^ 48) > 32 && composer.b(z2)) || (i3 & 48) == 32) | composer.I(animationSpec) | ((((i3 & 896) ^ 384) > 256 && composer.Z(function02)) || (i3 & 384) == 256);
        Object objG2 = composer.G();
        if (zI || objG2 == companion.a()) {
            Object snackbarHostKt$animatedOpacity$2$1 = new SnackbarHostKt$animatedOpacity$2$1(animatable, z2, animationSpec, function02, null);
            composer.w(snackbarHostKt$animatedOpacity$2$1);
            objG2 = snackbarHostKt$animatedOpacity$2$1;
        }
        EffectsKt.g(boolValueOf, (Function2) objG2, composer, (i3 >> 3) & 14);
        State stateG = animatable.g();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return stateG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final State g(AnimationSpec animationSpec, boolean z2, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(2003504988, i3, -1, "androidx.compose.material.animatedScale (SnackbarHost.kt:366)");
        }
        Object objG = composer.G();
        Composer.Companion companion = Composer.f23746a;
        if (objG == companion.a()) {
            objG = AnimatableKt.b(!z2 ? 1.0f : 0.8f, 0.0f, 2, null);
            composer.w(objG);
        }
        Animatable animatable = (Animatable) objG;
        Boolean boolValueOf = Boolean.valueOf(z2);
        boolean zI = composer.I(animatable) | ((((i3 & 112) ^ 48) > 32 && composer.b(z2)) || (i3 & 48) == 32) | composer.I(animationSpec);
        Object objG2 = composer.G();
        if (zI || objG2 == companion.a()) {
            objG2 = new SnackbarHostKt$animatedScale$1$1(animatable, z2, animationSpec, null);
            composer.w(objG2);
        }
        EffectsKt.g(boolValueOf, (Function2) objG2, composer, (i3 >> 3) & 14);
        State stateG = animatable.g();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return stateG;
    }

    public static final long h(SnackbarDuration snackbarDuration, boolean z2, AccessibilityManager accessibilityManager) {
        long j3;
        int i3 = WhenMappings.f14083a[snackbarDuration.ordinal()];
        if (i3 == 1) {
            j3 = Long.MAX_VALUE;
        } else if (i3 == 2) {
            j3 = 10000;
        } else {
            if (i3 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            j3 = 4000;
        }
        long j4 = j3;
        return accessibilityManager == null ? j4 : accessibilityManager.a(j4, true, true, z2);
    }
}
