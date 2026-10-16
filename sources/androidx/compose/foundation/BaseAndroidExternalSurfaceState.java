package androidx.compose.foundation;

import android.view.Surface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
abstract class BaseAndroidExternalSurfaceState implements AndroidExternalSurfaceScope, SurfaceScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CoroutineScope f4636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Function5 f4637b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Function3 f4638c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Function1 f4639d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Job f4640f;

    public BaseAndroidExternalSurfaceState(CoroutineScope coroutineScope) {
        this.f4636a = coroutineScope;
    }

    public final void c(Surface surface, int i3, int i4) {
        Function3 function3 = this.f4638c;
        if (function3 != null) {
            function3.invoke(surface, Integer.valueOf(i3), Integer.valueOf(i4));
        }
    }

    public final void d(Surface surface, int i3, int i4) {
        if (this.f4637b != null) {
            this.f4640f = BuildersKt__Builders_commonKt.d(this.f4636a, null, CoroutineStart.f140919d, new BaseAndroidExternalSurfaceState$dispatchSurfaceCreated$1(this, surface, i3, i4, null), 1, null);
        }
    }

    public final void e(Surface surface) {
        Function1 function1 = this.f4639d;
        if (function1 != null) {
            function1.invoke(surface);
        }
        Job job = this.f4640f;
        if (job != null) {
            Job.DefaultImpls.b(job, null, 1, null);
        }
        this.f4640f = null;
    }
}
