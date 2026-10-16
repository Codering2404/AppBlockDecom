package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.lifecycle.ReportFragment;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class ProcessLifecycleOwner implements LifecycleOwner {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Companion f40032j = new Companion(null);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final ProcessLifecycleOwner f40033k = new ProcessLifecycleOwner();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f40034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f40035b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Handler f40038f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f40036c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f40037d = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final LifecycleRegistry f40039g = new LifecycleRegistry(this);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Runnable f40040h = new Runnable() { // from class: androidx.lifecycle.i
        @Override // java.lang.Runnable
        public final void run() {
            ProcessLifecycleOwner.i(this.f40205a);
        }
    };

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ReportFragment.ActivityInitializationListener f40041i = new ReportFragment.ActivityInitializationListener() { // from class: androidx.lifecycle.ProcessLifecycleOwner$initializationListener$1
        @Override // androidx.lifecycle.ReportFragment.ActivityInitializationListener
        public void onResume() {
            this.f40043a.e();
        }

        @Override // androidx.lifecycle.ReportFragment.ActivityInitializationListener
        public void onStart() {
            this.f40043a.f();
        }

        @Override // androidx.lifecycle.ReportFragment.ActivityInitializationListener
        public void onCreate() {
        }
    };

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Api29Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Api29Impl f40042a = new Api29Impl();

        private Api29Impl() {
        }

        public static final void a(Activity activity, Application.ActivityLifecycleCallbacks callback) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(callback, "callback");
            activity.registerActivityLifecycleCallbacks(callback);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LifecycleOwner a() {
            return ProcessLifecycleOwner.f40033k;
        }

        public final void b(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            ProcessLifecycleOwner.f40033k.h(context);
        }

        private Companion() {
        }
    }

    private ProcessLifecycleOwner() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(ProcessLifecycleOwner processLifecycleOwner) {
        processLifecycleOwner.j();
        processLifecycleOwner.k();
    }

    public static final LifecycleOwner l() {
        return f40032j.a();
    }

    public final void d() {
        int i3 = this.f40035b - 1;
        this.f40035b = i3;
        if (i3 == 0) {
            Handler handler = this.f40038f;
            Intrinsics.checkNotNull(handler);
            handler.postDelayed(this.f40040h, 700L);
        }
    }

    public final void e() {
        int i3 = this.f40035b + 1;
        this.f40035b = i3;
        if (i3 == 1) {
            if (this.f40036c) {
                this.f40039g.g(Lifecycle.Event.ON_RESUME);
                this.f40036c = false;
            } else {
                Handler handler = this.f40038f;
                Intrinsics.checkNotNull(handler);
                handler.removeCallbacks(this.f40040h);
            }
        }
    }

    public final void f() {
        int i3 = this.f40034a + 1;
        this.f40034a = i3;
        if (i3 == 1 && this.f40037d) {
            this.f40039g.g(Lifecycle.Event.ON_START);
            this.f40037d = false;
        }
    }

    public final void g() {
        this.f40034a--;
        k();
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.f40039g;
    }

    public final void h(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f40038f = new Handler();
        this.f40039g.g(Lifecycle.Event.ON_CREATE);
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext).registerActivityLifecycleCallbacks(new EmptyActivityLifecycleCallbacks() { // from class: androidx.lifecycle.ProcessLifecycleOwner$attach$1
            @Override // androidx.lifecycle.EmptyActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                if (Build.VERSION.SDK_INT < 29) {
                    ReportFragment.f40077b.b(activity).e(this.this$0.f40041i);
                }
            }

            @Override // androidx.lifecycle.EmptyActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                this.this$0.d();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPreCreated(Activity activity, Bundle bundle) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                final ProcessLifecycleOwner processLifecycleOwner = this.this$0;
                ProcessLifecycleOwner.Api29Impl.a(activity, new EmptyActivityLifecycleCallbacks() { // from class: androidx.lifecycle.ProcessLifecycleOwner$attach$1$onActivityPreCreated$1
                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityPostResumed(Activity activity2) {
                        Intrinsics.checkNotNullParameter(activity2, "activity");
                        processLifecycleOwner.e();
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityPostStarted(Activity activity2) {
                        Intrinsics.checkNotNullParameter(activity2, "activity");
                        processLifecycleOwner.f();
                    }
                });
            }

            @Override // androidx.lifecycle.EmptyActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                this.this$0.g();
            }
        });
    }

    public final void j() {
        if (this.f40035b == 0) {
            this.f40036c = true;
            this.f40039g.g(Lifecycle.Event.ON_PAUSE);
        }
    }

    public final void k() {
        if (this.f40034a == 0 && this.f40036c) {
            this.f40039g.g(Lifecycle.Event.ON_STOP);
            this.f40037d = true;
        }
    }
}
