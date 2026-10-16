package androidx.compose.material3.internal;

import android.content.Context;
import android.view.accessibility.AccessibilityManager;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class AccessibilityServiceStateProvider_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final LifecycleOwner lifecycleOwner, Function1 function1, Function0 function0, Composer composer, final int i3, final int i4) {
        int i5;
        Composer composerK = composer.k(-1868327245);
        if ((i4 & 1) != 0) {
            i5 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i5 = (composerK.I(lifecycleOwner) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        int i6 = i4 & 2;
        if (i6 != 0) {
            i5 |= 48;
        } else if ((i3 & 48) == 0) {
            i5 |= composerK.I(function1) ? 32 : 16;
        }
        int i7 = i4 & 4;
        if (i7 != 0) {
            i5 |= 384;
        } else if ((i3 & 384) == 0) {
            i5 |= composerK.I(function0) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i5 & 147) == 146 && composerK.l()) {
            composerK.Q();
        } else {
            if (i6 != 0) {
                function1 = new Function1<Lifecycle.Event, Unit>() { // from class: androidx.compose.material3.internal.AccessibilityServiceStateProvider_androidKt$ObserveState$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        c((Lifecycle.Event) obj);
                        return Unit.f139807a;
                    }

                    public final void c(Lifecycle.Event event) {
                    }
                };
            }
            if (i7 != 0) {
                function0 = new Function0<Unit>() { // from class: androidx.compose.material3.internal.AccessibilityServiceStateProvider_androidKt$ObserveState$2
                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m198invoke() {
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m198invoke();
                        return Unit.f139807a;
                    }
                };
            }
            if (ComposerKt.M()) {
                ComposerKt.U(-1868327245, i5, -1, "androidx.compose.material3.internal.ObserveState (AccessibilityServiceStateProvider.android.kt:74)");
            }
            boolean zI = ((i5 & 112) == 32) | composerK.I(lifecycleOwner) | ((i5 & 896) == 256);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new AccessibilityServiceStateProvider_androidKt$ObserveState$3$1(lifecycleOwner, function1, function0);
                composerK.w(objG);
            }
            EffectsKt.c(lifecycleOwner, (Function1) objG, composerK, i5 & 14);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        final Function1 function12 = function1;
        final Function0 function02 = function0;
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.internal.AccessibilityServiceStateProvider_androidKt$ObserveState$4
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
                    AccessibilityServiceStateProvider_androidKt.a(lifecycleOwner, function12, function02, composer2, RecomposeScopeImplKt.a(i3 | 1), i4);
                }
            });
        }
    }

    public static final State c(boolean z2, boolean z3, Composer composer, int i3, int i4) {
        boolean z4 = true;
        if ((i4 & 1) != 0) {
            z2 = true;
        }
        if ((i4 & 2) != 0) {
            z3 = true;
        }
        if (ComposerKt.M()) {
            ComposerKt.U(-1771705152, i3, -1, "androidx.compose.material3.internal.rememberAccessibilityServiceState (AccessibilityServiceStateProvider.android.kt:46)");
        }
        Object systemService = ((Context) composer.q(AndroidCompositionLocals_androidKt.g())).getSystemService("accessibility");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        final AccessibilityManager accessibilityManager = (AccessibilityManager) systemService;
        boolean z5 = (((i3 & 14) ^ 6) > 4 && composer.b(z2)) || (i3 & 6) == 4;
        if ((((i3 & 112) ^ 48) <= 32 || !composer.b(z3)) && (i3 & 48) != 32) {
            z4 = false;
        }
        boolean z6 = z5 | z4;
        Object objG = composer.G();
        if (z6 || objG == Composer.f23746a.a()) {
            objG = new Listener(z2, z3);
            composer.w(objG);
        }
        final Listener listener = (Listener) objG;
        LifecycleOwner lifecycleOwner = (LifecycleOwner) composer.q(LocalLifecycleOwnerKt.c());
        boolean Z = composer.Z(listener) | composer.I(accessibilityManager);
        Object objG2 = composer.G();
        if (Z || objG2 == Composer.f23746a.a()) {
            objG2 = new Function1<Lifecycle.Event, Unit>() { // from class: androidx.compose.material3.internal.AccessibilityServiceStateProvider_androidKt$rememberAccessibilityServiceState$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void c(Lifecycle.Event event) {
                    if (event == Lifecycle.Event.ON_RESUME) {
                        listener.q(accessibilityManager);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    c((Lifecycle.Event) obj);
                    return Unit.f139807a;
                }
            };
            composer.w(objG2);
        }
        Function1 function1 = (Function1) objG2;
        boolean Z2 = composer.Z(listener) | composer.I(accessibilityManager);
        Object objG3 = composer.G();
        if (Z2 || objG3 == Composer.f23746a.a()) {
            objG3 = new Function0<Unit>() { // from class: androidx.compose.material3.internal.AccessibilityServiceStateProvider_androidKt$rememberAccessibilityServiceState$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m199invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m199invoke() {
                    listener.v(accessibilityManager);
                }
            };
            composer.w(objG3);
        }
        a(lifecycleOwner, function1, (Function0) objG3, composer, 0, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return listener;
    }
}
