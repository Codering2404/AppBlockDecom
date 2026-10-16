package com.google.maps.android.compose.streetview;

import android.util.Log;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.StreetViewPanoramaView;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
@DebugMetadata(c = "com.google.maps.android.compose.streetview.StreetViewKt$StreetView$6", f = "StreetView.kt", l = {164, 176}, m = "invokeSuspend")
final class StreetViewKt$StreetView$6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f91327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f91328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f91329c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f91330d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f91331f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ StreetViewPanoramaView f91332g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ CompositionContext f91333h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ State f91334i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ State f91335j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ State f91336k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final /* synthetic */ State f91337l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final /* synthetic */ State f91338m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final /* synthetic */ State f91339n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreetViewKt$StreetView$6(StreetViewPanoramaView streetViewPanoramaView, CompositionContext compositionContext, State state, State state2, State state3, State state4, State state5, State state6, Continuation continuation) {
        super(2, continuation);
        this.f91332g = streetViewPanoramaView;
        this.f91333h = compositionContext;
        this.f91334i = state;
        this.f91335j = state2;
        this.f91336k = state3;
        this.f91337l = state4;
        this.f91338m = state5;
        this.f91339n = state6;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new StreetViewKt$StreetView$6(this.f91332g, this.f91333h, this.f91334i, this.f91335j, this.f91336k, this.f91337l, this.f91338m, this.f91339n, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        CompositionContext compositionContext;
        Function2 function2;
        Composition compositionA;
        Composition composition;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f91331f;
        try {
            if (i3 == 0) {
                ResultKt.b(obj);
                StreetViewPanoramaView streetViewPanoramaView = this.f91332g;
                CompositionContext compositionContext2 = this.f91333h;
                final State state = this.f91334i;
                final State state2 = this.f91335j;
                final State state3 = this.f91336k;
                final State state4 = this.f91337l;
                final State state5 = this.f91338m;
                final State state6 = this.f91339n;
                ComposableLambda composableLambdaC = ComposableLambdaKt.c(-1039809540, true, new Function2<Composer, Integer, Unit>() { // from class: com.google.maps.android.compose.streetview.StreetViewKt$StreetView$6$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                        invoke((Composer) obj2, ((Number) obj3).intValue());
                        return Unit.f139807a;
                    }

                    public final void invoke(Composer composer, int i4) {
                        if ((i4 & 11) == 2 && composer.l()) {
                            composer.Q();
                            return;
                        }
                        if (ComposerKt.M()) {
                            ComposerKt.U(-1039809540, i4, -1, "com.google.maps.android.compose.streetview.StreetView.<anonymous>.<anonymous>.<anonymous> (StreetView.kt:82)");
                        }
                        final StreetViewCameraPositionState streetViewCameraPositionStateC = StreetViewKt.c(state);
                        final boolean zD = StreetViewKt.d(state2);
                        final boolean zE = StreetViewKt.e(state3);
                        final boolean zF = StreetViewKt.f(state4);
                        final boolean zG = StreetViewKt.g(state5);
                        final StreetViewPanoramaEventListeners streetViewPanoramaEventListenersH = StreetViewKt.h(state6);
                        composer.F(-647819622);
                        Applier applierM = composer.m();
                        Intrinsics.checkNotNull(applierM, "null cannot be cast to non-null type com.google.maps.android.compose.streetview.StreetViewPanoramaApplier");
                        final StreetViewPanorama streetViewPanoramaQ = ((StreetViewPanoramaApplier) applierM).q();
                        final Function0<StreetViewPanoramaPropertiesNode> function0 = new Function0<StreetViewPanoramaPropertiesNode>() { // from class: com.google.maps.android.compose.streetview.StreetViewPanoramaUpdaterKt$StreetViewUpdater$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                            public final StreetViewPanoramaPropertiesNode invoke() {
                                return new StreetViewPanoramaPropertiesNode(streetViewCameraPositionStateC, streetViewPanoramaQ, streetViewPanoramaEventListenersH);
                            }
                        };
                        composer.F(1886828752);
                        if (!(composer.m() instanceof StreetViewPanoramaApplier)) {
                            ComposablesKt.c();
                        }
                        composer.o();
                        if (composer.i()) {
                            composer.P(new Function0<StreetViewPanoramaPropertiesNode>() { // from class: com.google.maps.android.compose.streetview.StreetViewPanoramaUpdaterKt$StreetViewUpdater$$inlined$ComposeNode$1
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return function0.invoke();
                                }
                            });
                        } else {
                            composer.v();
                        }
                        Composer composerA = Updater.a(composer);
                        Updater.e(composerA, Boolean.valueOf(zD), new Function2<StreetViewPanoramaPropertiesNode, Boolean, Unit>() { // from class: com.google.maps.android.compose.streetview.StreetViewPanoramaUpdaterKt$StreetViewUpdater$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public final void c(StreetViewPanoramaPropertiesNode set, boolean z2) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.h().f(zD);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                c((StreetViewPanoramaPropertiesNode) obj2, ((Boolean) obj3).booleanValue());
                                return Unit.f139807a;
                            }
                        });
                        Updater.e(composerA, Boolean.valueOf(zE), new Function2<StreetViewPanoramaPropertiesNode, Boolean, Unit>() { // from class: com.google.maps.android.compose.streetview.StreetViewPanoramaUpdaterKt$StreetViewUpdater$2$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public final void c(StreetViewPanoramaPropertiesNode set, boolean z2) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.h().g(zE);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                c((StreetViewPanoramaPropertiesNode) obj2, ((Boolean) obj3).booleanValue());
                                return Unit.f139807a;
                            }
                        });
                        Updater.e(composerA, Boolean.valueOf(zF), new Function2<StreetViewPanoramaPropertiesNode, Boolean, Unit>() { // from class: com.google.maps.android.compose.streetview.StreetViewPanoramaUpdaterKt$StreetViewUpdater$2$3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public final void c(StreetViewPanoramaPropertiesNode set, boolean z2) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.h().h(zF);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                c((StreetViewPanoramaPropertiesNode) obj2, ((Boolean) obj3).booleanValue());
                                return Unit.f139807a;
                            }
                        });
                        Updater.e(composerA, Boolean.valueOf(zG), new Function2<StreetViewPanoramaPropertiesNode, Boolean, Unit>() { // from class: com.google.maps.android.compose.streetview.StreetViewPanoramaUpdaterKt$StreetViewUpdater$2$4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public final void c(StreetViewPanoramaPropertiesNode set, boolean z2) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                set.h().i(zG);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                c((StreetViewPanoramaPropertiesNode) obj2, ((Boolean) obj3).booleanValue());
                                return Unit.f139807a;
                            }
                        });
                        Updater.e(composerA, streetViewPanoramaEventListenersH, new Function2<StreetViewPanoramaPropertiesNode, StreetViewPanoramaEventListeners, Unit>() { // from class: com.google.maps.android.compose.streetview.StreetViewPanoramaUpdaterKt$StreetViewUpdater$2$5
                            public final void c(StreetViewPanoramaPropertiesNode set, StreetViewPanoramaEventListeners it) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                Intrinsics.checkNotNullParameter(it, "it");
                                set.m(it);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                c((StreetViewPanoramaPropertiesNode) obj2, (StreetViewPanoramaEventListeners) obj3);
                                return Unit.f139807a;
                            }
                        });
                        composer.y();
                        composer.Y();
                        composer.Y();
                        if (ComposerKt.M()) {
                            ComposerKt.T();
                        }
                    }
                });
                this.f91327a = compositionContext2;
                this.f91328b = composableLambdaC;
                this.f91329c = this;
                this.f91330d = streetViewPanoramaView;
                this.f91331f = 1;
                final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.c(this));
                streetViewPanoramaView.a(new OnStreetViewPanoramaReadyCallback() { // from class: com.google.maps.android.compose.streetview.StreetViewKt$newComposition$$inlined$awaitStreetViewPanorama$1
                    @Override // com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback
                    public final void a(StreetViewPanorama it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        safeContinuation.resumeWith(Result.b(it));
                    }
                });
                obj = safeContinuation.a();
                if (obj == IntrinsicsKt.f()) {
                    DebugProbesKt.c(this);
                }
                if (obj != objF) {
                    compositionContext = compositionContext2;
                    function2 = composableLambdaC;
                }
                return objF;
            }
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                composition = (Composition) this.f91327a;
                try {
                    ResultKt.b(obj);
                    throw new KotlinNothingValueException();
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    composition.dispose();
                    throw th2;
                }
            }
            function2 = (Function2) this.f91328b;
            compositionContext = (CompositionContext) this.f91327a;
            ResultKt.b(obj);
            this.f91327a = compositionA;
            this.f91328b = null;
            this.f91329c = null;
            this.f91330d = null;
            this.f91331f = 2;
            if (DelayKt.a(this) != objF) {
                composition = compositionA;
                throw new KotlinNothingValueException();
            }
            return objF;
        } catch (Throwable th3) {
            th = th3;
            composition = compositionA;
            Throwable th22 = th;
            composition.dispose();
            throw th22;
        }
        StreetViewPanorama streetViewPanorama = (StreetViewPanorama) obj;
        Log.d("StreetView", "Location is " + streetViewPanorama.a());
        compositionA = CompositionKt.a(new StreetViewPanoramaApplier(streetViewPanorama), compositionContext);
        compositionA.f(function2);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((StreetViewKt$StreetView$6) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
