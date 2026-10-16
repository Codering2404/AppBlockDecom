package androidx.window.layout.adapter.sidecar;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.content.OnConfigurationChangedProvider;
import androidx.core.util.Consumer;
import androidx.window.core.Version;
import androidx.window.layout.WindowLayoutInfo;
import androidx.window.layout.adapter.sidecar.ExtensionInterfaceCompat;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarDisplayFeature;
import androidx.window.sidecar.SidecarInterface;
import androidx.window.sidecar.SidecarProvider;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
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
public final class SidecarCompat implements ExtensionInterfaceCompat {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f54407f = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SidecarInterface f54408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SidecarAdapter f54409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f54410c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f54411d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private DistinctElementCallback f54412e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final IBinder a(Activity activity) {
            Window window;
            WindowManager.LayoutParams attributes;
            if (activity == null || (window = activity.getWindow()) == null || (attributes = window.getAttributes()) == null) {
                return null;
            }
            return attributes.token;
        }

        public final SidecarInterface b(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return SidecarProvider.getSidecarImpl(context.getApplicationContext());
        }

        public final Version c() {
            try {
                String apiVersion = SidecarProvider.getApiVersion();
                if (TextUtils.isEmpty(apiVersion)) {
                    return null;
                }
                return Version.f54150g.b(apiVersion);
            } catch (NoClassDefFoundError | UnsupportedOperationException unused) {
                return null;
            }
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class DistinctElementCallback implements ExtensionInterfaceCompat.ExtensionCallbackInterface {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ExtensionInterfaceCompat.ExtensionCallbackInterface f54413a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ReentrantLock f54414b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final WeakHashMap f54415c;

        public DistinctElementCallback(ExtensionInterfaceCompat.ExtensionCallbackInterface callbackInterface) {
            Intrinsics.checkNotNullParameter(callbackInterface, "callbackInterface");
            this.f54413a = callbackInterface;
            this.f54414b = new ReentrantLock();
            this.f54415c = new WeakHashMap();
        }

        @Override // androidx.window.layout.adapter.sidecar.ExtensionInterfaceCompat.ExtensionCallbackInterface
        public void a(Activity activity, WindowLayoutInfo newLayout) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(newLayout, "newLayout");
            ReentrantLock reentrantLock = this.f54414b;
            reentrantLock.lock();
            try {
                if (Intrinsics.areEqual(newLayout, (WindowLayoutInfo) this.f54415c.get(activity))) {
                    return;
                }
                reentrantLock.unlock();
                this.f54413a.a(activity, newLayout);
            } finally {
                reentrantLock.unlock();
            }
        }

        public final void b(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            ReentrantLock reentrantLock = this.f54414b;
            reentrantLock.lock();
            try {
                this.f54415c.put(activity, null);
                Unit unit = Unit.f139807a;
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class FirstAttachAdapter implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SidecarCompat f54416a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final WeakReference f54417b;

        public FirstAttachAdapter(SidecarCompat sidecarCompat, Activity activity) {
            Intrinsics.checkNotNullParameter(sidecarCompat, "sidecarCompat");
            Intrinsics.checkNotNullParameter(activity, "activity");
            this.f54416a = sidecarCompat;
            this.f54417b = new WeakReference(activity);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            view.removeOnAttachStateChangeListener(this);
            Activity activity = (Activity) this.f54417b.get();
            IBinder iBinderA = SidecarCompat.f54407f.a(activity);
            if (activity == null || iBinderA == null) {
                return;
            }
            this.f54416a.j(iBinderA, activity);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public final class TranslatingCallback implements SidecarInterface.SidecarCallback {
        public TranslatingCallback() {
        }

        public void onDeviceStateChanged(SidecarDeviceState newDeviceState) {
            SidecarInterface sidecarInterfaceH;
            Intrinsics.checkNotNullParameter(newDeviceState, "newDeviceState");
            Collection<Activity> collectionValues = SidecarCompat.this.f54410c.values();
            SidecarCompat sidecarCompat = SidecarCompat.this;
            for (Activity activity : collectionValues) {
                IBinder iBinderA = SidecarCompat.f54407f.a(activity);
                SidecarWindowLayoutInfo windowLayoutInfo = null;
                if (iBinderA != null && (sidecarInterfaceH = sidecarCompat.h()) != null) {
                    windowLayoutInfo = sidecarInterfaceH.getWindowLayoutInfo(iBinderA);
                }
                DistinctElementCallback distinctElementCallback = sidecarCompat.f54412e;
                if (distinctElementCallback != null) {
                    distinctElementCallback.a(activity, sidecarCompat.f54409b.e(windowLayoutInfo, newDeviceState));
                }
            }
        }

        public void onWindowLayoutChanged(IBinder windowToken, SidecarWindowLayoutInfo newLayout) {
            SidecarDeviceState sidecarDeviceState;
            Intrinsics.checkNotNullParameter(windowToken, "windowToken");
            Intrinsics.checkNotNullParameter(newLayout, "newLayout");
            Activity activity = (Activity) SidecarCompat.this.f54410c.get(windowToken);
            if (activity == null) {
                Log.w("SidecarCompat", "Unable to resolve activity from window token. Missing a call to #onWindowLayoutChangeListenerAdded()?");
                return;
            }
            SidecarAdapter sidecarAdapter = SidecarCompat.this.f54409b;
            SidecarInterface sidecarInterfaceH = SidecarCompat.this.h();
            if (sidecarInterfaceH == null || (sidecarDeviceState = sidecarInterfaceH.getDeviceState()) == null) {
                sidecarDeviceState = new SidecarDeviceState();
            }
            WindowLayoutInfo windowLayoutInfoE = sidecarAdapter.e(newLayout, sidecarDeviceState);
            DistinctElementCallback distinctElementCallback = SidecarCompat.this.f54412e;
            if (distinctElementCallback != null) {
                distinctElementCallback.a(activity, windowLayoutInfoE);
            }
        }
    }

    public SidecarCompat(SidecarInterface sidecarInterface, SidecarAdapter sidecarAdapter) {
        Intrinsics.checkNotNullParameter(sidecarAdapter, "sidecarAdapter");
        this.f54408a = sidecarInterface;
        this.f54409b = sidecarAdapter;
        this.f54410c = new LinkedHashMap();
        this.f54411d = new LinkedHashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void k(final Activity activity) {
        if (this.f54411d.get(activity) == null && (activity instanceof OnConfigurationChangedProvider)) {
            Consumer consumer = new Consumer() { // from class: androidx.window.layout.adapter.sidecar.a
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    SidecarCompat.l(this.f54429a, activity, (Configuration) obj);
                }
            };
            this.f54411d.put(activity, consumer);
            ((OnConfigurationChangedProvider) activity).addOnConfigurationChangedListener(consumer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(SidecarCompat this$0, Activity activity, Configuration configuration) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        DistinctElementCallback distinctElementCallback = this$0.f54412e;
        if (distinctElementCallback != null) {
            distinctElementCallback.a(activity, this$0.i(activity));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void m(Activity activity) {
        Consumer consumer = (Consumer) this.f54411d.get(activity);
        if (consumer == null) {
            return;
        }
        if (activity instanceof OnConfigurationChangedProvider) {
            ((OnConfigurationChangedProvider) activity).removeOnConfigurationChangedListener(consumer);
        }
        this.f54411d.remove(activity);
    }

    @Override // androidx.window.layout.adapter.sidecar.ExtensionInterfaceCompat
    public void a(ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallback) {
        Intrinsics.checkNotNullParameter(extensionCallback, "extensionCallback");
        this.f54412e = new DistinctElementCallback(extensionCallback);
        SidecarInterface sidecarInterface = this.f54408a;
        if (sidecarInterface != null) {
            sidecarInterface.setSidecarCallback(new DistinctElementSidecarCallback(this.f54409b, new TranslatingCallback()));
        }
    }

    @Override // androidx.window.layout.adapter.sidecar.ExtensionInterfaceCompat
    public void b(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        IBinder iBinderA = f54407f.a(activity);
        if (iBinderA != null) {
            j(iBinderA, activity);
        } else {
            activity.getWindow().getDecorView().addOnAttachStateChangeListener(new FirstAttachAdapter(this, activity));
        }
    }

    @Override // androidx.window.layout.adapter.sidecar.ExtensionInterfaceCompat
    public void c(Activity activity) {
        SidecarInterface sidecarInterface;
        Intrinsics.checkNotNullParameter(activity, "activity");
        IBinder iBinderA = f54407f.a(activity);
        if (iBinderA == null) {
            return;
        }
        SidecarInterface sidecarInterface2 = this.f54408a;
        if (sidecarInterface2 != null) {
            sidecarInterface2.onWindowLayoutChangeListenerRemoved(iBinderA);
        }
        m(activity);
        DistinctElementCallback distinctElementCallback = this.f54412e;
        if (distinctElementCallback != null) {
            distinctElementCallback.b(activity);
        }
        boolean z2 = this.f54410c.size() == 1;
        this.f54410c.remove(iBinderA);
        if (!z2 || (sidecarInterface = this.f54408a) == null) {
            return;
        }
        sidecarInterface.onDeviceStateListenersChanged(true);
    }

    public final SidecarInterface h() {
        return this.f54408a;
    }

    public final WindowLayoutInfo i(Activity activity) {
        SidecarDeviceState sidecarDeviceState;
        Intrinsics.checkNotNullParameter(activity, "activity");
        IBinder iBinderA = f54407f.a(activity);
        if (iBinderA == null) {
            return new WindowLayoutInfo(CollectionsKt.emptyList());
        }
        SidecarInterface sidecarInterface = this.f54408a;
        SidecarWindowLayoutInfo windowLayoutInfo = sidecarInterface != null ? sidecarInterface.getWindowLayoutInfo(iBinderA) : null;
        SidecarAdapter sidecarAdapter = this.f54409b;
        SidecarInterface sidecarInterface2 = this.f54408a;
        if (sidecarInterface2 == null || (sidecarDeviceState = sidecarInterface2.getDeviceState()) == null) {
            sidecarDeviceState = new SidecarDeviceState();
        }
        return sidecarAdapter.e(windowLayoutInfo, sidecarDeviceState);
    }

    public final void j(IBinder windowToken, Activity activity) {
        SidecarInterface sidecarInterface;
        Intrinsics.checkNotNullParameter(windowToken, "windowToken");
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.f54410c.put(windowToken, activity);
        SidecarInterface sidecarInterface2 = this.f54408a;
        if (sidecarInterface2 != null) {
            sidecarInterface2.onWindowLayoutChangeListenerAdded(windowToken);
        }
        if (this.f54410c.size() == 1 && (sidecarInterface = this.f54408a) != null) {
            sidecarInterface.onDeviceStateListenersChanged(false);
        }
        DistinctElementCallback distinctElementCallback = this.f54412e;
        if (distinctElementCallback != null) {
            distinctElementCallback.a(activity, i(activity));
        }
        k(activity);
    }

    public boolean n() {
        Class<?> cls;
        Class<?> cls2;
        Class<?> cls3;
        Class<?> cls4;
        try {
            SidecarInterface sidecarInterface = this.f54408a;
            Method method = (sidecarInterface == null || (cls4 = sidecarInterface.getClass()) == null) ? null : cls4.getMethod("setSidecarCallback", SidecarInterface.SidecarCallback.class);
            Class<?> returnType = method != null ? method.getReturnType() : null;
            Class cls5 = Void.TYPE;
            if (!Intrinsics.areEqual(returnType, cls5)) {
                throw new NoSuchMethodException("Illegal return type for 'setSidecarCallback': " + returnType);
            }
            SidecarInterface sidecarInterface2 = this.f54408a;
            if (sidecarInterface2 != null) {
                sidecarInterface2.getDeviceState();
            }
            SidecarInterface sidecarInterface3 = this.f54408a;
            if (sidecarInterface3 != null) {
                sidecarInterface3.onDeviceStateListenersChanged(true);
            }
            SidecarInterface sidecarInterface4 = this.f54408a;
            Method method2 = (sidecarInterface4 == null || (cls3 = sidecarInterface4.getClass()) == null) ? null : cls3.getMethod("getWindowLayoutInfo", IBinder.class);
            Class<?> returnType2 = method2 != null ? method2.getReturnType() : null;
            if (!Intrinsics.areEqual(returnType2, SidecarWindowLayoutInfo.class)) {
                throw new NoSuchMethodException("Illegal return type for 'getWindowLayoutInfo': " + returnType2);
            }
            SidecarInterface sidecarInterface5 = this.f54408a;
            Method method3 = (sidecarInterface5 == null || (cls2 = sidecarInterface5.getClass()) == null) ? null : cls2.getMethod("onWindowLayoutChangeListenerAdded", IBinder.class);
            Class<?> returnType3 = method3 != null ? method3.getReturnType() : null;
            if (!Intrinsics.areEqual(returnType3, cls5)) {
                throw new NoSuchMethodException("Illegal return type for 'onWindowLayoutChangeListenerAdded': " + returnType3);
            }
            SidecarInterface sidecarInterface6 = this.f54408a;
            Method method4 = (sidecarInterface6 == null || (cls = sidecarInterface6.getClass()) == null) ? null : cls.getMethod("onWindowLayoutChangeListenerRemoved", IBinder.class);
            Class<?> returnType4 = method4 != null ? method4.getReturnType() : null;
            if (!Intrinsics.areEqual(returnType4, cls5)) {
                throw new NoSuchMethodException("Illegal return type for 'onWindowLayoutChangeListenerRemoved': " + returnType4);
            }
            SidecarDeviceState sidecarDeviceState = new SidecarDeviceState();
            try {
                sidecarDeviceState.posture = 3;
            } catch (NoSuchFieldError unused) {
                SidecarDeviceState.class.getMethod("setPosture", Integer.TYPE).invoke(sidecarDeviceState, 3);
                Object objInvoke = SidecarDeviceState.class.getMethod("getPosture", null).invoke(sidecarDeviceState, null);
                Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Int");
                if (((Integer) objInvoke).intValue() != 3) {
                    throw new Exception("Invalid device posture getter/setter");
                }
            }
            SidecarDisplayFeature sidecarDisplayFeature = new SidecarDisplayFeature();
            Rect rect = sidecarDisplayFeature.getRect();
            Intrinsics.checkNotNullExpressionValue(rect, "displayFeature.rect");
            sidecarDisplayFeature.setRect(rect);
            sidecarDisplayFeature.getType();
            sidecarDisplayFeature.setType(1);
            SidecarWindowLayoutInfo sidecarWindowLayoutInfo = new SidecarWindowLayoutInfo();
            try {
                List list = sidecarWindowLayoutInfo.displayFeatures;
                return true;
            } catch (NoSuchFieldError unused2) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(sidecarDisplayFeature);
                SidecarWindowLayoutInfo.class.getMethod("setDisplayFeatures", List.class).invoke(sidecarWindowLayoutInfo, arrayList);
                Object objInvoke2 = SidecarWindowLayoutInfo.class.getMethod("getDisplayFeatures", null).invoke(sidecarWindowLayoutInfo, null);
                Intrinsics.checkNotNull(objInvoke2, "null cannot be cast to non-null type kotlin.collections.List<androidx.window.sidecar.SidecarDisplayFeature>");
                if (Intrinsics.areEqual(arrayList, (List) objInvoke2)) {
                    return true;
                }
                throw new Exception("Invalid display feature getter/setter");
            }
        } catch (Throwable unused3) {
            return false;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SidecarCompat(Context context) {
        this(f54407f.b(context), new SidecarAdapter(null, 1, null));
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
