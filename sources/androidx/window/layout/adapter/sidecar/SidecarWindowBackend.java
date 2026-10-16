package androidx.window.layout.adapter.sidecar;

import android.app.Activity;
import android.content.Context;
import androidx.core.util.Consumer;
import androidx.window.core.Version;
import androidx.window.layout.WindowLayoutInfo;
import androidx.window.layout.adapter.WindowBackend;
import androidx.window.layout.adapter.sidecar.ExtensionInterfaceCompat;
import androidx.window.layout.adapter.sidecar.SidecarWindowBackend;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class SidecarWindowBackend implements WindowBackend {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile SidecarWindowBackend f54420d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ExtensionInterfaceCompat f54422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CopyOnWriteArrayList f54423b = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f54419c = new Companion(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ReentrantLock f54421e = new ReentrantLock();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SidecarWindowBackend a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (SidecarWindowBackend.f54420d == null) {
                ReentrantLock reentrantLock = SidecarWindowBackend.f54421e;
                reentrantLock.lock();
                try {
                    if (SidecarWindowBackend.f54420d == null) {
                        SidecarWindowBackend.f54420d = new SidecarWindowBackend(SidecarWindowBackend.f54419c.b(context));
                    }
                    Unit unit = Unit.f139807a;
                    reentrantLock.unlock();
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    throw th;
                }
            }
            SidecarWindowBackend sidecarWindowBackend = SidecarWindowBackend.f54420d;
            Intrinsics.checkNotNull(sidecarWindowBackend);
            return sidecarWindowBackend;
        }

        public final ExtensionInterfaceCompat b(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                if (c(SidecarCompat.f54407f.c())) {
                    SidecarCompat sidecarCompat = new SidecarCompat(context);
                    if (sidecarCompat.n()) {
                        return sidecarCompat;
                    }
                    return null;
                }
            } catch (Throwable unused) {
            }
            return null;
        }

        public final boolean c(Version version) {
            return version != null && version.compareTo(Version.f54150g.a()) >= 0;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public final class ExtensionListenerImpl implements ExtensionInterfaceCompat.ExtensionCallbackInterface {
        public ExtensionListenerImpl() {
        }

        @Override // androidx.window.layout.adapter.sidecar.ExtensionInterfaceCompat.ExtensionCallbackInterface
        public void a(Activity activity, WindowLayoutInfo newLayout) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(newLayout, "newLayout");
            for (WindowLayoutChangeCallbackWrapper windowLayoutChangeCallbackWrapper : SidecarWindowBackend.this.g()) {
                if (Intrinsics.areEqual(windowLayoutChangeCallbackWrapper.d(), activity)) {
                    windowLayoutChangeCallbackWrapper.b(newLayout);
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class WindowLayoutChangeCallbackWrapper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Activity f54425a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Executor f54426b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Consumer f54427c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private WindowLayoutInfo f54428d;

        public WindowLayoutChangeCallbackWrapper(Activity activity, Executor executor, Consumer callback) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(executor, "executor");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.f54425a = activity;
            this.f54426b = executor;
            this.f54427c = callback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(WindowLayoutChangeCallbackWrapper this$0, WindowLayoutInfo newLayoutInfo) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(newLayoutInfo, "$newLayoutInfo");
            this$0.f54427c.accept(newLayoutInfo);
        }

        public final void b(final WindowLayoutInfo newLayoutInfo) {
            Intrinsics.checkNotNullParameter(newLayoutInfo, "newLayoutInfo");
            this.f54428d = newLayoutInfo;
            this.f54426b.execute(new Runnable() { // from class: androidx.window.layout.adapter.sidecar.b
                @Override // java.lang.Runnable
                public final void run() {
                    SidecarWindowBackend.WindowLayoutChangeCallbackWrapper.c(this.f54431a, newLayoutInfo);
                }
            });
        }

        public final Activity d() {
            return this.f54425a;
        }

        public final Consumer e() {
            return this.f54427c;
        }

        public final WindowLayoutInfo f() {
            return this.f54428d;
        }
    }

    public SidecarWindowBackend(ExtensionInterfaceCompat extensionInterfaceCompat) {
        this.f54422a = extensionInterfaceCompat;
        ExtensionInterfaceCompat extensionInterfaceCompat2 = this.f54422a;
        if (extensionInterfaceCompat2 != null) {
            extensionInterfaceCompat2.a(new ExtensionListenerImpl());
        }
    }

    private final void f(Activity activity) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f54423b;
        if (copyOnWriteArrayList == null || !copyOnWriteArrayList.isEmpty()) {
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(((WindowLayoutChangeCallbackWrapper) it.next()).d(), activity)) {
                    return;
                }
            }
        }
        ExtensionInterfaceCompat extensionInterfaceCompat = this.f54422a;
        if (extensionInterfaceCompat != null) {
            extensionInterfaceCompat.c(activity);
        }
    }

    private final boolean h(Activity activity) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f54423b;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(((WindowLayoutChangeCallbackWrapper) it.next()).d(), activity)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.window.layout.adapter.WindowBackend
    public void a(Consumer callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        synchronized (f54421e) {
            try {
                if (this.f54422a == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (WindowLayoutChangeCallbackWrapper callbackWrapper : this.f54423b) {
                    if (callbackWrapper.e() == callback) {
                        Intrinsics.checkNotNullExpressionValue(callbackWrapper, "callbackWrapper");
                        arrayList.add(callbackWrapper);
                    }
                }
                this.f54423b.removeAll(arrayList);
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    f(((WindowLayoutChangeCallbackWrapper) obj).d());
                }
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.window.layout.adapter.WindowBackend
    public void b(Context context, Executor executor, Consumer callback) {
        Object next;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Unit unit = null;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            ReentrantLock reentrantLock = f54421e;
            reentrantLock.lock();
            try {
                ExtensionInterfaceCompat extensionInterfaceCompat = this.f54422a;
                if (extensionInterfaceCompat == null) {
                    callback.accept(new WindowLayoutInfo(CollectionsKt.emptyList()));
                    return;
                }
                boolean zH = h(activity);
                WindowLayoutChangeCallbackWrapper windowLayoutChangeCallbackWrapper = new WindowLayoutChangeCallbackWrapper(activity, executor, callback);
                this.f54423b.add(windowLayoutChangeCallbackWrapper);
                if (zH) {
                    Iterator it = this.f54423b.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        } else {
                            next = it.next();
                            if (Intrinsics.areEqual(activity, ((WindowLayoutChangeCallbackWrapper) next).d())) {
                                break;
                            }
                        }
                    }
                    WindowLayoutChangeCallbackWrapper windowLayoutChangeCallbackWrapper2 = (WindowLayoutChangeCallbackWrapper) next;
                    WindowLayoutInfo windowLayoutInfoF = windowLayoutChangeCallbackWrapper2 != null ? windowLayoutChangeCallbackWrapper2.f() : null;
                    if (windowLayoutInfoF != null) {
                        windowLayoutChangeCallbackWrapper.b(windowLayoutInfoF);
                    }
                } else {
                    extensionInterfaceCompat.b(activity);
                }
                Unit unit2 = Unit.f139807a;
                reentrantLock.unlock();
                unit = Unit.f139807a;
            } finally {
                reentrantLock.unlock();
            }
        }
        if (unit == null) {
            callback.accept(new WindowLayoutInfo(CollectionsKt.emptyList()));
        }
    }

    public final CopyOnWriteArrayList g() {
        return this.f54423b;
    }
}
