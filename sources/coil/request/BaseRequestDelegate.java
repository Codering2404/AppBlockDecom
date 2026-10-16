package coil.request;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
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
public final class BaseRequestDelegate implements RequestDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lifecycle f56003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Job f56004b;

    public BaseRequestDelegate(Lifecycle lifecycle, Job job) {
        this.f56003a = lifecycle;
        this.f56004b = job;
    }

    public void a() {
        Job.DefaultImpls.b(this.f56004b, null, 1, null);
    }

    @Override // coil.request.RequestDelegate
    public void b() {
        this.f56003a.removeObserver(this);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onDestroy(LifecycleOwner lifecycleOwner) {
        a();
    }

    @Override // coil.request.RequestDelegate
    public void start() {
        this.f56003a.addObserver(this);
    }
}
