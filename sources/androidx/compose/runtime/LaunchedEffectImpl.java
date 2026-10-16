package androidx.compose.runtime;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class LaunchedEffectImpl implements RememberObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function2 f23930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CoroutineScope f23931b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Job f23932c;

    public LaunchedEffectImpl(CoroutineContext coroutineContext, Function2 function2) {
        this.f23930a = function2;
        this.f23931b = CoroutineScopeKt.a(coroutineContext);
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void c() {
        Job job = this.f23932c;
        if (job != null) {
            JobKt__JobKt.f(job, "Old job was still running!", null, 2, null);
        }
        this.f23932c = BuildersKt__Builders_commonKt.d(this.f23931b, null, null, this.f23930a, 3, null);
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void d() {
        Job job = this.f23932c;
        if (job != null) {
            job.cancel((CancellationException) new LeftCompositionCancellationException());
        }
        this.f23932c = null;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void e() {
        Job job = this.f23932c;
        if (job != null) {
            job.cancel((CancellationException) new LeftCompositionCancellationException());
        }
        this.f23932c = null;
    }
}
