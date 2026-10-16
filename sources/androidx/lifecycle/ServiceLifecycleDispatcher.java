package androidx.lifecycle;

import android.os.Handler;
import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
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
public class ServiceLifecycleDispatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LifecycleRegistry f40103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f40104b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private DispatchRunnable f40105c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DispatchRunnable implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final LifecycleRegistry f40106a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Lifecycle.Event f40107b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f40108c;

        public DispatchRunnable(LifecycleRegistry registry, Lifecycle.Event event) {
            Intrinsics.checkNotNullParameter(registry, "registry");
            Intrinsics.checkNotNullParameter(event, "event");
            this.f40106a = registry;
            this.f40107b = event;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f40108c) {
                return;
            }
            this.f40106a.g(this.f40107b);
            this.f40108c = true;
        }
    }

    public ServiceLifecycleDispatcher(LifecycleOwner provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        this.f40103a = new LifecycleRegistry(provider);
        this.f40104b = new Handler();
    }

    private final void f(Lifecycle.Event event) {
        DispatchRunnable dispatchRunnable = this.f40105c;
        if (dispatchRunnable != null) {
            dispatchRunnable.run();
        }
        DispatchRunnable dispatchRunnable2 = new DispatchRunnable(this.f40103a, event);
        this.f40105c = dispatchRunnable2;
        Handler handler = this.f40104b;
        Intrinsics.checkNotNull(dispatchRunnable2);
        handler.postAtFrontOfQueue(dispatchRunnable2);
    }

    public Lifecycle a() {
        return this.f40103a;
    }

    public void b() {
        f(Lifecycle.Event.ON_START);
    }

    public void c() {
        f(Lifecycle.Event.ON_CREATE);
    }

    public void d() {
        f(Lifecycle.Event.ON_STOP);
        f(Lifecycle.Event.ON_DESTROY);
    }

    public void e() {
        f(Lifecycle.Event.ON_START);
    }
}
