package androidx.activity;

import android.os.Build;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.OnBackPressedDispatcher;
import androidx.core.util.Consumer;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.Iterator;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class OnBackPressedDispatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Runnable f379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Consumer f380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayDeque f381c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private OnBackPressedCallback f382d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private OnBackInvokedCallback f383e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private OnBackInvokedDispatcher f384f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f385g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f386h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Api33Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Api33Impl f392a = new Api33Impl();

        private Api33Impl() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(Function0 function0) {
            function0.invoke();
        }

        public final OnBackInvokedCallback b(final Function0 onBackInvoked) {
            Intrinsics.checkNotNullParameter(onBackInvoked, "onBackInvoked");
            return new OnBackInvokedCallback() { // from class: androidx.activity.q
                public final void onBackInvoked() {
                    OnBackPressedDispatcher.Api33Impl.c(onBackInvoked);
                }
            };
        }

        public final void d(Object dispatcher, int i3, Object callback) {
            Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
            Intrinsics.checkNotNullParameter(callback, "callback");
            ((OnBackInvokedDispatcher) dispatcher).registerOnBackInvokedCallback(i3, (OnBackInvokedCallback) callback);
        }

        public final void e(Object dispatcher, Object callback) {
            Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
            Intrinsics.checkNotNullParameter(callback, "callback");
            ((OnBackInvokedDispatcher) dispatcher).unregisterOnBackInvokedCallback((OnBackInvokedCallback) callback);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Api34Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Api34Impl f393a = new Api34Impl();

        private Api34Impl() {
        }

        public final OnBackInvokedCallback a(final Function1 onBackStarted, final Function1 onBackProgressed, final Function0 onBackInvoked, final Function0 onBackCancelled) {
            Intrinsics.checkNotNullParameter(onBackStarted, "onBackStarted");
            Intrinsics.checkNotNullParameter(onBackProgressed, "onBackProgressed");
            Intrinsics.checkNotNullParameter(onBackInvoked, "onBackInvoked");
            Intrinsics.checkNotNullParameter(onBackCancelled, "onBackCancelled");
            return new OnBackAnimationCallback() { // from class: androidx.activity.OnBackPressedDispatcher$Api34Impl$createOnBackAnimationCallback$1
                public void onBackCancelled() {
                    onBackCancelled.invoke();
                }

                public void onBackInvoked() {
                    onBackInvoked.invoke();
                }

                public void onBackProgressed(BackEvent backEvent) {
                    Intrinsics.checkNotNullParameter(backEvent, "backEvent");
                    onBackProgressed.invoke(new BackEventCompat(backEvent));
                }

                public void onBackStarted(BackEvent backEvent) {
                    Intrinsics.checkNotNullParameter(backEvent, "backEvent");
                    onBackStarted.invoke(new BackEventCompat(backEvent));
                }
            };
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private final class LifecycleOnBackPressedCancellable implements LifecycleEventObserver, Cancellable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Lifecycle f398a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final OnBackPressedCallback f399b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Cancellable f400c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ OnBackPressedDispatcher f401d;

        public LifecycleOnBackPressedCancellable(OnBackPressedDispatcher onBackPressedDispatcher, Lifecycle lifecycle, OnBackPressedCallback onBackPressedCallback) {
            Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
            Intrinsics.checkNotNullParameter(onBackPressedCallback, "onBackPressedCallback");
            this.f401d = onBackPressedDispatcher;
            this.f398a = lifecycle;
            this.f399b = onBackPressedCallback;
            lifecycle.addObserver(this);
        }

        @Override // androidx.activity.Cancellable
        public void cancel() {
            this.f398a.removeObserver(this);
            this.f399b.removeCancellable(this);
            Cancellable cancellable = this.f400c;
            if (cancellable != null) {
                cancellable.cancel();
            }
            this.f400c = null;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void j(LifecycleOwner source, Lifecycle.Event event) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(event, "event");
            if (event == Lifecycle.Event.ON_START) {
                this.f400c = this.f401d.j(this.f399b);
                return;
            }
            if (event != Lifecycle.Event.ON_STOP) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    cancel();
                }
            } else {
                Cancellable cancellable = this.f400c;
                if (cancellable != null) {
                    cancellable.cancel();
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private final class OnBackPressedCancellable implements Cancellable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final OnBackPressedCallback f402a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OnBackPressedDispatcher f403b;

        public OnBackPressedCancellable(OnBackPressedDispatcher onBackPressedDispatcher, OnBackPressedCallback onBackPressedCallback) {
            Intrinsics.checkNotNullParameter(onBackPressedCallback, "onBackPressedCallback");
            this.f403b = onBackPressedDispatcher;
            this.f402a = onBackPressedCallback;
        }

        @Override // androidx.activity.Cancellable
        public void cancel() {
            this.f403b.f381c.remove(this.f402a);
            if (Intrinsics.areEqual(this.f403b.f382d, this.f402a)) {
                this.f402a.handleOnBackCancelled();
                this.f403b.f382d = null;
            }
            this.f402a.removeCancellable(this);
            Function0<Unit> enabledChangedCallback$activity_release = this.f402a.getEnabledChangedCallback$activity_release();
            if (enabledChangedCallback$activity_release != null) {
                enabledChangedCallback$activity_release.invoke();
            }
            this.f402a.setEnabledChangedCallback$activity_release(null);
        }
    }

    public OnBackPressedDispatcher(Runnable runnable, Consumer consumer) {
        this.f379a = runnable;
        this.f380b = consumer;
        this.f381c = new ArrayDeque();
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 33) {
            this.f383e = i3 >= 34 ? Api34Impl.f393a.a(new Function1<BackEventCompat, Unit>() { // from class: androidx.activity.OnBackPressedDispatcher.1
                {
                    super(1);
                }

                public final void c(BackEventCompat backEvent) {
                    Intrinsics.checkNotNullParameter(backEvent, "backEvent");
                    OnBackPressedDispatcher.this.n(backEvent);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    c((BackEventCompat) obj);
                    return Unit.f139807a;
                }
            }, new Function1<BackEventCompat, Unit>() { // from class: androidx.activity.OnBackPressedDispatcher.2
                {
                    super(1);
                }

                public final void c(BackEventCompat backEvent) {
                    Intrinsics.checkNotNullParameter(backEvent, "backEvent");
                    OnBackPressedDispatcher.this.m(backEvent);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    c((BackEventCompat) obj);
                    return Unit.f139807a;
                }
            }, new Function0<Unit>() { // from class: androidx.activity.OnBackPressedDispatcher.3
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m1invoke() {
                    OnBackPressedDispatcher.this.l();
                }
            }, new Function0<Unit>() { // from class: androidx.activity.OnBackPressedDispatcher.4
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m2invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m2invoke() {
                    OnBackPressedDispatcher.this.k();
                }
            }) : Api33Impl.f392a.b(new Function0<Unit>() { // from class: androidx.activity.OnBackPressedDispatcher.5
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m3invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m3invoke() {
                    OnBackPressedDispatcher.this.l();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        Object objPrevious;
        OnBackPressedCallback onBackPressedCallback = this.f382d;
        if (onBackPressedCallback == null) {
            ArrayDeque arrayDeque = this.f381c;
            ListIterator<E> listIterator = arrayDeque.listIterator(arrayDeque.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    objPrevious = null;
                    break;
                } else {
                    objPrevious = listIterator.previous();
                    if (((OnBackPressedCallback) objPrevious).isEnabled()) {
                        break;
                    }
                }
            }
            onBackPressedCallback = (OnBackPressedCallback) objPrevious;
        }
        this.f382d = null;
        if (onBackPressedCallback != null) {
            onBackPressedCallback.handleOnBackCancelled();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(BackEventCompat backEventCompat) {
        Object objPrevious;
        OnBackPressedCallback onBackPressedCallback = this.f382d;
        if (onBackPressedCallback == null) {
            ArrayDeque arrayDeque = this.f381c;
            ListIterator<E> listIterator = arrayDeque.listIterator(arrayDeque.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    objPrevious = null;
                    break;
                } else {
                    objPrevious = listIterator.previous();
                    if (((OnBackPressedCallback) objPrevious).isEnabled()) {
                        break;
                    }
                }
            }
            onBackPressedCallback = (OnBackPressedCallback) objPrevious;
        }
        if (onBackPressedCallback != null) {
            onBackPressedCallback.handleOnBackProgressed(backEventCompat);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(BackEventCompat backEventCompat) {
        Object objPrevious;
        ArrayDeque arrayDeque = this.f381c;
        ListIterator<E> listIterator = arrayDeque.listIterator(arrayDeque.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            } else {
                objPrevious = listIterator.previous();
                if (((OnBackPressedCallback) objPrevious).isEnabled()) {
                    break;
                }
            }
        }
        OnBackPressedCallback onBackPressedCallback = (OnBackPressedCallback) objPrevious;
        if (this.f382d != null) {
            k();
        }
        this.f382d = onBackPressedCallback;
        if (onBackPressedCallback != null) {
            onBackPressedCallback.handleOnBackStarted(backEventCompat);
        }
    }

    private final void p(boolean z2) {
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.f384f;
        OnBackInvokedCallback onBackInvokedCallback = this.f383e;
        if (onBackInvokedDispatcher == null || onBackInvokedCallback == null) {
            return;
        }
        if (z2 && !this.f385g) {
            Api33Impl.f392a.d(onBackInvokedDispatcher, 0, onBackInvokedCallback);
            this.f385g = true;
        } else {
            if (z2 || !this.f385g) {
                return;
            }
            Api33Impl.f392a.e(onBackInvokedDispatcher, onBackInvokedCallback);
            this.f385g = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        boolean z2 = this.f386h;
        ArrayDeque arrayDeque = this.f381c;
        boolean z3 = false;
        if (arrayDeque == null || !arrayDeque.isEmpty()) {
            Iterator<E> it = arrayDeque.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (((OnBackPressedCallback) it.next()).isEnabled()) {
                    z3 = true;
                    break;
                }
            }
        }
        this.f386h = z3;
        if (z3 != z2) {
            Consumer consumer = this.f380b;
            if (consumer != null) {
                consumer.accept(Boolean.valueOf(z3));
            }
            if (Build.VERSION.SDK_INT >= 33) {
                p(z3);
            }
        }
    }

    public final void h(OnBackPressedCallback onBackPressedCallback) {
        Intrinsics.checkNotNullParameter(onBackPressedCallback, "onBackPressedCallback");
        j(onBackPressedCallback);
    }

    public final void i(LifecycleOwner owner, OnBackPressedCallback onBackPressedCallback) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(onBackPressedCallback, "onBackPressedCallback");
        Lifecycle lifecycle = owner.getLifecycle();
        if (lifecycle.getCurrentState() == Lifecycle.State.f39947a) {
            return;
        }
        onBackPressedCallback.addCancellable(new LifecycleOnBackPressedCancellable(this, lifecycle, onBackPressedCallback));
        q();
        onBackPressedCallback.setEnabledChangedCallback$activity_release(new OnBackPressedDispatcher$addCallback$1(this));
    }

    public final Cancellable j(OnBackPressedCallback onBackPressedCallback) {
        Intrinsics.checkNotNullParameter(onBackPressedCallback, "onBackPressedCallback");
        this.f381c.add(onBackPressedCallback);
        OnBackPressedCancellable onBackPressedCancellable = new OnBackPressedCancellable(this, onBackPressedCallback);
        onBackPressedCallback.addCancellable(onBackPressedCancellable);
        q();
        onBackPressedCallback.setEnabledChangedCallback$activity_release(new OnBackPressedDispatcher$addCancellableCallback$1(this));
        return onBackPressedCancellable;
    }

    public final void l() {
        Object objPrevious;
        OnBackPressedCallback onBackPressedCallback = this.f382d;
        if (onBackPressedCallback == null) {
            ArrayDeque arrayDeque = this.f381c;
            ListIterator<E> listIterator = arrayDeque.listIterator(arrayDeque.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    objPrevious = null;
                    break;
                } else {
                    objPrevious = listIterator.previous();
                    if (((OnBackPressedCallback) objPrevious).isEnabled()) {
                        break;
                    }
                }
            }
            onBackPressedCallback = (OnBackPressedCallback) objPrevious;
        }
        this.f382d = null;
        if (onBackPressedCallback != null) {
            onBackPressedCallback.handleOnBackPressed();
            return;
        }
        Runnable runnable = this.f379a;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void o(OnBackInvokedDispatcher invoker) {
        Intrinsics.checkNotNullParameter(invoker, "invoker");
        this.f384f = invoker;
        p(this.f386h);
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this(runnable, null);
    }
}
