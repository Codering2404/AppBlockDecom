package com.google.maps.android.compose;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.compose.foundation.layout.PaddingValues;
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
import com.google.android.gms.maps.LocationSource;
import com.google.android.gms.maps.MapView;
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
public final class GoogleMapKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f90768a;

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
            f90768a = iArr;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x035a  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x04b8 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:255:0x04b9  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0129  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void b(androidx.compose.ui.Modifier r35, com.google.maps.android.compose.CameraPositionState r36, java.lang.String r37, kotlin.jvm.functions.Function0 r38, com.google.maps.android.compose.MapProperties r39, com.google.android.gms.maps.LocationSource r40, com.google.maps.android.compose.MapUiSettings r41, com.google.maps.android.compose.IndoorStateChangeListener r42, kotlin.jvm.functions.Function1 r43, kotlin.jvm.functions.Function1 r44, kotlin.jvm.functions.Function0 r45, kotlin.jvm.functions.Function0 r46, kotlin.jvm.functions.Function1 r47, kotlin.jvm.functions.Function1 r48, androidx.compose.foundation.layout.PaddingValues r49, kotlin.jvm.functions.Function2 r50, androidx.compose.runtime.Composer r51, final int r52, final int r53, final int r54) {
        /*
            Method dump skipped, instruction units count: 1231
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.maps.android.compose.GoogleMapKt.b(androidx.compose.ui.Modifier, com.google.maps.android.compose.CameraPositionState, java.lang.String, kotlin.jvm.functions.Function0, com.google.maps.android.compose.MapProperties, com.google.android.gms.maps.LocationSource, com.google.maps.android.compose.MapUiSettings, com.google.maps.android.compose.IndoorStateChangeListener, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LocationSource c(State state) {
        return (LocationSource) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CameraPositionState d(State state) {
        return (CameraPositionState) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PaddingValues e(State state) {
        return (PaddingValues) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MapUiSettings f(State state) {
        return (MapUiSettings) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MapProperties g(State state) {
        return (MapProperties) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function2 h(State state) {
        return (Function2) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(final MapView mapView, Composer composer, final int i3) {
        Composer composerK = composer.k(-1013003870);
        if (ComposerKt.M()) {
            ComposerKt.U(-1013003870, i3, -1, "com.google.maps.android.compose.MapLifecycle (GoogleMap.kt:170)");
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
        EffectsKt.a(context, lifecycle, mapView, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.google.maps.android.compose.GoogleMapKt$MapLifecycle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                final LifecycleEventObserver lifecycleEventObserverU = GoogleMapKt.u(mapView, mutableState);
                final ComponentCallbacks componentCallbacksS = GoogleMapKt.s(mapView);
                lifecycle.addObserver(lifecycleEventObserverU);
                context.registerComponentCallbacks(componentCallbacksS);
                final Lifecycle lifecycle2 = lifecycle;
                final Context context2 = context;
                return new DisposableEffectResult() { // from class: com.google.maps.android.compose.GoogleMapKt$MapLifecycle$1$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                        lifecycle2.removeObserver(lifecycleEventObserverU);
                        context2.unregisterComponentCallbacks(componentCallbacksS);
                    }
                };
            }
        }, composerK, 584);
        EffectsKt.c(mapView, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.google.maps.android.compose.GoogleMapKt$MapLifecycle$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                final MapView mapView2 = mapView;
                return new DisposableEffectResult() { // from class: com.google.maps.android.compose.GoogleMapKt$MapLifecycle$2$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                        mapView2.c();
                        mapView2.removeAllViews();
                    }
                };
            }
        }, composerK, 8);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN == null) {
            return;
        }
        scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.google.maps.android.compose.GoogleMapKt$MapLifecycle$3
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
                GoogleMapKt.i(mapView, composer2, i3 | 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ComponentCallbacks s(final MapView mapView) {
        return new ComponentCallbacks() { // from class: com.google.maps.android.compose.GoogleMapKt$componentCallbacks$1
            @Override // android.content.ComponentCallbacks
            public void onConfigurationChanged(Configuration config) {
                Intrinsics.checkNotNullParameter(config, "config");
            }

            @Override // android.content.ComponentCallbacks
            public void onLowMemory() {
                mapView.d();
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r4v0, types: [kotlin.jvm.functions.Function0] */
    /* JADX WARN: Type inference failed for: r4v1, types: [androidx.compose.runtime.Composition] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object t(kotlin.jvm.functions.Function0 r4, kotlin.coroutines.Continuation r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof com.google.maps.android.compose.GoogleMapKt$disposingComposition$1
            if (r0 == 0) goto L13
            r0 = r5
            com.google.maps.android.compose.GoogleMapKt$disposingComposition$1 r0 = (com.google.maps.android.compose.GoogleMapKt$disposingComposition$1) r0
            int r1 = r0.f90772c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f90772c = r1
            goto L18
        L13:
            com.google.maps.android.compose.GoogleMapKt$disposingComposition$1 r0 = new com.google.maps.android.compose.GoogleMapKt$disposingComposition$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f90771b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f90772c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 == r3) goto L2d
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2d:
            java.lang.Object r4 = r0.f90770a
            androidx.compose.runtime.Composition r4 = (androidx.compose.runtime.Composition) r4
            kotlin.ResultKt.b(r5)     // Catch: java.lang.Throwable -> L35
            goto L4b
        L35:
            r5 = move-exception
            goto L51
        L37:
            kotlin.ResultKt.b(r5)
            java.lang.Object r4 = r4.invoke()
            androidx.compose.runtime.Composition r4 = (androidx.compose.runtime.Composition) r4
            r0.f90770a = r4     // Catch: java.lang.Throwable -> L35
            r0.f90772c = r3     // Catch: java.lang.Throwable -> L35
            java.lang.Object r5 = kotlinx.coroutines.DelayKt.a(r0)     // Catch: java.lang.Throwable -> L35
            if (r5 != r1) goto L4b
            return r1
        L4b:
            kotlin.KotlinNothingValueException r5 = new kotlin.KotlinNothingValueException     // Catch: java.lang.Throwable -> L35
            r5.<init>()     // Catch: java.lang.Throwable -> L35
            throw r5     // Catch: java.lang.Throwable -> L35
        L51:
            kotlin.jvm.internal.InlineMarker.b(r3)
            r4.dispose()
            kotlin.jvm.internal.InlineMarker.a(r3)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.maps.android.compose.GoogleMapKt.t(kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LifecycleEventObserver u(final MapView mapView, final MutableState mutableState) {
        return new LifecycleEventObserver() { // from class: com.google.maps.android.compose.a
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void j(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                GoogleMapKt.v(mutableState, mapView, lifecycleOwner, event);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(MutableState previousState, MapView this_lifecycleObserver, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(previousState, "$previousState");
        Intrinsics.checkNotNullParameter(this_lifecycleObserver, "$this_lifecycleObserver");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(event, "event");
        event.c();
        switch (WhenMappings.f90768a[event.ordinal()]) {
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
