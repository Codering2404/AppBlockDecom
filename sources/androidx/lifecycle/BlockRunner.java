package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
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
public final class BlockRunner<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CoroutineLiveData f39870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function2 f39871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f39872c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CoroutineScope f39873d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Function0 f39874e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Job f39875f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Job f39876g;

    public BlockRunner(CoroutineLiveData liveData, Function2 block, long j3, CoroutineScope scope, Function0 onDone) {
        Intrinsics.checkNotNullParameter(liveData, "liveData");
        Intrinsics.checkNotNullParameter(block, "block");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(onDone, "onDone");
        this.f39870a = liveData;
        this.f39871b = block;
        this.f39872c = j3;
        this.f39873d = scope;
        this.f39874e = onDone;
    }

    public final void g() {
        if (this.f39876g != null) {
            throw new IllegalStateException("Cancel call cannot happen without a maybeRun");
        }
        this.f39876g = BuildersKt__Builders_commonKt.d(this.f39873d, Dispatchers.c().w0(), null, new BlockRunner$cancel$1(this, null), 2, null);
    }

    public final void h() {
        Job job = this.f39876g;
        if (job != null) {
            Job.DefaultImpls.b(job, null, 1, null);
        }
        this.f39876g = null;
        if (this.f39875f != null) {
            return;
        }
        this.f39875f = BuildersKt__Builders_commonKt.d(this.f39873d, null, null, new BlockRunner$maybeRun$1(this, null), 3, null);
    }
}
