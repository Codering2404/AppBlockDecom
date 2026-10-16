package androidx.compose.ui.platform;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.view.View;
import android.view.ViewParent;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MonotonicFrameClock;
import androidx.compose.runtime.PausableMonotonicFrameClock;
import androidx.compose.runtime.Recomposer;
import androidx.compose.ui.MotionDurationScale;
import androidx.compose.ui.R;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.core.os.HandlerCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;

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
public final class WindowRecomposer_androidKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map f28292a = new LinkedHashMap();

    public static final Recomposer b(final View view, CoroutineContext coroutineContext, Lifecycle lifecycle) {
        final PausableMonotonicFrameClock pausableMonotonicFrameClock;
        if (coroutineContext.get(ContinuationInterceptor.t8) == null || coroutineContext.get(MonotonicFrameClock.Z7) == null) {
            coroutineContext = AndroidUiDispatcher.f27887m.a().plus(coroutineContext);
        }
        MonotonicFrameClock monotonicFrameClock = (MonotonicFrameClock) coroutineContext.get(MonotonicFrameClock.Z7);
        if (monotonicFrameClock != null) {
            PausableMonotonicFrameClock pausableMonotonicFrameClock2 = new PausableMonotonicFrameClock(monotonicFrameClock);
            pausableMonotonicFrameClock2.d();
            pausableMonotonicFrameClock = pausableMonotonicFrameClock2;
        } else {
            pausableMonotonicFrameClock = null;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        CoroutineContext motionDurationScaleImpl = (MotionDurationScale) coroutineContext.get(MotionDurationScale.c8);
        if (motionDurationScaleImpl == null) {
            motionDurationScaleImpl = new MotionDurationScaleImpl();
            objectRef.f140144a = motionDurationScaleImpl;
        }
        CoroutineContext coroutineContextPlus = coroutineContext.plus(pausableMonotonicFrameClock != null ? pausableMonotonicFrameClock : EmptyCoroutineContext.f139889a).plus(motionDurationScaleImpl);
        final Recomposer recomposer = new Recomposer(coroutineContextPlus);
        recomposer.y0();
        final CoroutineScope coroutineScopeA = CoroutineScopeKt.a(coroutineContextPlus);
        if (lifecycle == null) {
            LifecycleOwner lifecycleOwnerA = ViewTreeLifecycleOwner.a(view);
            lifecycle = lifecycleOwnerA != null ? lifecycleOwnerA.getLifecycle() : null;
        }
        if (lifecycle != null) {
            view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view2) {
                    view.removeOnAttachStateChangeListener(this);
                    recomposer.i0();
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view2) {
                }
            });
            lifecycle.addObserver(new LifecycleEventObserver() { // from class: androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2

                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                public /* synthetic */ class WhenMappings {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public static final /* synthetic */ int[] f28300a;

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
                            iArr[Lifecycle.Event.ON_STOP.ordinal()] = 3;
                        } catch (NoSuchFieldError unused3) {
                        }
                        try {
                            iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 4;
                        } catch (NoSuchFieldError unused4) {
                        }
                        try {
                            iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 5;
                        } catch (NoSuchFieldError unused5) {
                        }
                        try {
                            iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 6;
                        } catch (NoSuchFieldError unused6) {
                        }
                        try {
                            iArr[Lifecycle.Event.ON_ANY.ordinal()] = 7;
                        } catch (NoSuchFieldError unused7) {
                        }
                        f28300a = iArr;
                    }
                }

                @Override // androidx.lifecycle.LifecycleEventObserver
                public void j(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    int i3 = WhenMappings.f28300a[event.ordinal()];
                    if (i3 == 1) {
                        BuildersKt__Builders_commonKt.d(coroutineScopeA, null, CoroutineStart.f140919d, new WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1(objectRef, recomposer, lifecycleOwner, this, view, null), 1, null);
                        return;
                    }
                    if (i3 == 2) {
                        PausableMonotonicFrameClock pausableMonotonicFrameClock3 = pausableMonotonicFrameClock;
                        if (pausableMonotonicFrameClock3 != null) {
                            pausableMonotonicFrameClock3.e();
                        }
                        recomposer.L0();
                        return;
                    }
                    if (i3 == 3) {
                        recomposer.y0();
                    } else {
                        if (i3 != 4) {
                            return;
                        }
                        recomposer.i0();
                    }
                }
            });
            return recomposer;
        }
        InlineClassHelperKt.d("ViewTreeLifecycleOwner not found from " + view);
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ Recomposer c(View view, CoroutineContext coroutineContext, Lifecycle lifecycle, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f139889a;
        }
        if ((i3 & 2) != 0) {
            lifecycle = null;
        }
        return b(view, coroutineContext, lifecycle);
    }

    public static final CompositionContext d(View view) {
        CompositionContext compositionContextF = f(view);
        if (compositionContextF != null) {
            return compositionContextF;
        }
        for (ViewParent parent = view.getParent(); compositionContextF == null && (parent instanceof View); parent = parent.getParent()) {
            compositionContextF = f((View) parent);
        }
        return compositionContextF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r5v1, types: [androidx.compose.ui.platform.WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1] */
    public static final StateFlow e(Context context) {
        StateFlow stateFlow;
        Map map = f28292a;
        synchronized (map) {
            try {
                Object objH0 = map.get(context);
                if (objH0 == null) {
                    ContentResolver contentResolver = context.getContentResolver();
                    Uri uriFor = Settings.Global.getUriFor("animator_duration_scale");
                    final Channel channelB = ChannelKt.b(-1, null, null, 6, null);
                    final Handler handlerA = HandlerCompat.a(Looper.getMainLooper());
                    objH0 = FlowKt.h0(FlowKt.I(new WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1(contentResolver, uriFor, new ContentObserver(handlerA) { // from class: androidx.compose.ui.platform.WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1
                        @Override // android.database.ContentObserver
                        public void onChange(boolean z2, Uri uri) {
                            channelB.h(Unit.f139807a);
                        }
                    }, channelB, context, null)), CoroutineScopeKt.b(), SharingStarted.Companion.b(SharingStarted.f142210a, 0L, 0L, 3, null), Float.valueOf(Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f)));
                    map.put(context, objH0);
                }
                stateFlow = (StateFlow) objH0;
            } catch (Throwable th) {
                throw th;
            }
        }
        return stateFlow;
    }

    public static final CompositionContext f(View view) {
        Object tag = view.getTag(R.id.G);
        if (tag instanceof CompositionContext) {
            return (CompositionContext) tag;
        }
        return null;
    }

    private static final View g(View view) {
        Object parent = view.getParent();
        while (parent instanceof View) {
            View view2 = (View) parent;
            if (view2.getId() == 16908290) {
                break;
            }
            parent = view2.getParent();
            view = view2;
        }
        return view;
    }

    public static final Recomposer h(View view) {
        if (!view.isAttachedToWindow()) {
            InlineClassHelperKt.c("Cannot locate windowRecomposer; View " + view + " is not attached to a window");
        }
        View viewG = g(view);
        CompositionContext compositionContextF = f(viewG);
        if (compositionContextF == null) {
            return WindowRecomposerPolicy.f28285a.a(viewG);
        }
        if (compositionContextF instanceof Recomposer) {
            return (Recomposer) compositionContextF;
        }
        throw new IllegalStateException("root viewTreeParentCompositionContext is not a Recomposer");
    }

    public static final void i(View view, CompositionContext compositionContext) {
        view.setTag(R.id.G, compositionContext);
    }
}
