package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class LifecycleController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lifecycle f39954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lifecycle.State f39955b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DispatchQueue f39956c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LifecycleEventObserver f39957d;

    public LifecycleController(Lifecycle lifecycle, Lifecycle.State minState, DispatchQueue dispatchQueue, final Job parentJob) {
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        Intrinsics.checkNotNullParameter(minState, "minState");
        Intrinsics.checkNotNullParameter(dispatchQueue, "dispatchQueue");
        Intrinsics.checkNotNullParameter(parentJob, "parentJob");
        this.f39954a = lifecycle;
        this.f39955b = minState;
        this.f39956c = dispatchQueue;
        LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: androidx.lifecycle.f
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void j(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                LifecycleController.c(this.f40200a, parentJob, lifecycleOwner, event);
            }
        };
        this.f39957d = lifecycleEventObserver;
        if (lifecycle.getCurrentState() != Lifecycle.State.f39947a) {
            lifecycle.addObserver(lifecycleEventObserver);
        } else {
            Job.DefaultImpls.b(parentJob, null, 1, null);
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(LifecycleController lifecycleController, Job job, LifecycleOwner source, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "<unused var>");
        if (source.getLifecycle().getCurrentState() == Lifecycle.State.f39947a) {
            Job.DefaultImpls.b(job, null, 1, null);
            lifecycleController.b();
        } else if (source.getLifecycle().getCurrentState().compareTo(lifecycleController.f39955b) < 0) {
            lifecycleController.f39956c.h();
        } else {
            lifecycleController.f39956c.i();
        }
    }

    public final void b() {
        this.f39954a.removeObserver(this.f39957d);
        this.f39956c.g();
    }
}
