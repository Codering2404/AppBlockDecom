package coil.request;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import coil.ImageLoader;
import coil.target.ViewTarget;
import coil.util.Lifecycles;
import coil.util.Utils;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlinx.coroutines.Job;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class ViewTargetRequestDelegate implements RequestDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ImageLoader f56151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ImageRequest f56152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ViewTarget f56153c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lifecycle f56154d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Job f56155f;

    public ViewTargetRequestDelegate(ImageLoader imageLoader, ImageRequest imageRequest, ViewTarget viewTarget, Lifecycle lifecycle, Job job) {
        this.f56151a = imageLoader;
        this.f56152b = imageRequest;
        this.f56153c = viewTarget;
        this.f56154d = lifecycle;
        this.f56155f = job;
    }

    @Override // coil.request.RequestDelegate
    public void K() {
        if (this.f56153c.a().isAttachedToWindow()) {
            return;
        }
        Utils.m(this.f56153c.a()).c(this);
        throw new CancellationException("'ViewTarget.view' must be attached to a window.");
    }

    public void a() {
        Job.DefaultImpls.b(this.f56155f, null, 1, null);
        ViewTarget viewTarget = this.f56153c;
        if (viewTarget instanceof LifecycleObserver) {
            this.f56154d.removeObserver((LifecycleObserver) viewTarget);
        }
        this.f56154d.removeObserver(this);
    }

    public final void c() {
        this.f56151a.b(this.f56152b);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onDestroy(LifecycleOwner lifecycleOwner) {
        Utils.m(this.f56153c.a()).a();
    }

    @Override // coil.request.RequestDelegate
    public void start() {
        this.f56154d.addObserver(this);
        ViewTarget viewTarget = this.f56153c;
        if (viewTarget instanceof LifecycleObserver) {
            Lifecycles.b(this.f56154d, (LifecycleObserver) viewTarget);
        }
        Utils.m(this.f56153c.a()).c(this);
    }
}
