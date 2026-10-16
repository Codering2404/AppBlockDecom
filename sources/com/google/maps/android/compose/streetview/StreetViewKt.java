package com.google.maps.android.compose.streetview;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.google.android.gms.maps.StreetViewPanoramaView;
import kotlin.Metadata;
import kotlin.Unit;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class StreetViewKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f91368a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Lifecycle.Event.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f91368a = iArr;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02a9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0113  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void b(androidx.compose.ui.Modifier r21, com.google.maps.android.compose.streetview.StreetViewCameraPositionState r22, kotlin.jvm.functions.Function0 r23, boolean r24, boolean r25, boolean r26, boolean r27, kotlin.jvm.functions.Function1 r28, kotlin.jvm.functions.Function1 r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instruction units count: 693
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.maps.android.compose.streetview.StreetViewKt.b(androidx.compose.ui.Modifier, com.google.maps.android.compose.streetview.StreetViewCameraPositionState, kotlin.jvm.functions.Function0, boolean, boolean, boolean, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StreetViewCameraPositionState c(State state) {
        return (StreetViewCameraPositionState) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(State state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean e(State state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean f(State state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g(State state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StreetViewPanoramaEventListeners h(State state) {
        return (StreetViewPanoramaEventListeners) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(final StreetViewPanoramaView streetViewPanoramaView, Composer composer, final int i3) {
        Composer composerK = composer.k(1614301890);
        if (ComposerKt.M()) {
            ComposerKt.U(1614301890, i3, -1, "com.google.maps.android.compose.streetview.StreetViewLifecycle (StreetView.kt:97)");
        }
        final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
        final Lifecycle lifecycle = ((LifecycleOwner) composerK.q(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner())).getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "LocalLifecycleOwner.current.lifecycle");
        composerK.F(-492369756);
        Object objG = composerK.G();
        if (objG == Composer.f23746a.a()) {
            objG = SnapshotStateKt__SnapshotStateKt.e(Lifecycle.Event.ON_CREATE, null, 2, null);
            composerK.w(objG);
        }
        composerK.Y();
        final MutableState mutableState = (MutableState) objG;
        EffectsKt.a(context, lifecycle, streetViewPanoramaView, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.google.maps.android.compose.streetview.StreetViewKt$StreetViewLifecycle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                final LifecycleEventObserver lifecycleEventObserverT = StreetViewKt.t(streetViewPanoramaView, mutableState);
                final ComponentCallbacks componentCallbacksS = StreetViewKt.s(streetViewPanoramaView);
                lifecycle.addObserver(lifecycleEventObserverT);
                context.registerComponentCallbacks(componentCallbacksS);
                final Lifecycle lifecycle2 = lifecycle;
                final Context context2 = context;
                final StreetViewPanoramaView streetViewPanoramaView2 = streetViewPanoramaView;
                return new DisposableEffectResult() { // from class: com.google.maps.android.compose.streetview.StreetViewKt$StreetViewLifecycle$1$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                        lifecycle2.removeObserver(lifecycleEventObserverT);
                        context2.unregisterComponentCallbacks(componentCallbacksS);
                        streetViewPanoramaView2.c();
                    }
                };
            }
        }, composerK, 584);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN == null) {
            return;
        }
        scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.google.maps.android.compose.streetview.StreetViewKt$StreetViewLifecycle$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.f139807a;
            }

            public final void invoke(Composer composer2, int i4) {
                StreetViewKt.i(streetViewPanoramaView, composer2, i3 | 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ComponentCallbacks s(final StreetViewPanoramaView streetViewPanoramaView) {
        return new ComponentCallbacks() { // from class: com.google.maps.android.compose.streetview.StreetViewKt$componentCallbacks$1
            @Override // android.content.ComponentCallbacks
            public void onConfigurationChanged(Configuration config) {
                Intrinsics.checkNotNullParameter(config, "config");
            }

            @Override // android.content.ComponentCallbacks
            public void onLowMemory() {
                streetViewPanoramaView.d();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LifecycleEventObserver t(final StreetViewPanoramaView streetViewPanoramaView, final MutableState mutableState) {
        return new LifecycleEventObserver() { // from class: com.google.maps.android.compose.streetview.a
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void j(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                StreetViewKt.u(mutableState, streetViewPanoramaView, lifecycleOwner, event);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(MutableState previousState, StreetViewPanoramaView this_lifecycleObserver, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(previousState, "$previousState");
        Intrinsics.checkNotNullParameter(this_lifecycleObserver, "$this_lifecycleObserver");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(event, "event");
        event.c();
        switch (WhenMappings.f91368a[event.ordinal()]) {
            case 1:
                if (previousState.getValue() != Lifecycle.Event.ON_STOP) {
                    this_lifecycleObserver.b(new Bundle());
                }
                break;
            case 2:
                this_lifecycleObserver.g();
                break;
            case 3:
                this_lifecycleObserver.f();
                break;
            case 4:
                this_lifecycleObserver.e();
                break;
            case 5:
                this_lifecycleObserver.h();
                break;
            case 6:
                break;
            default:
                throw new IllegalStateException();
        }
        previousState.setValue(event);
    }
}
