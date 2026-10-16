package androidx.compose.runtime.internal;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Unit;

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
public final class SnapshotThreadLocal<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicReference f24827a = new AtomicReference(SnapshotThreadLocalKt.f24830a);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f24828b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object f24829c;

    public final Object a() {
        long jA = Thread_jvmKt.a();
        return jA == Thread_androidKt.a() ? this.f24829c : ((ThreadMap) this.f24827a.get()).b(jA);
    }

    public final void b(Object obj) {
        long jA = Thread_jvmKt.a();
        if (jA == Thread_androidKt.a()) {
            this.f24829c = obj;
            return;
        }
        synchronized (this.f24828b) {
            ThreadMap threadMap = (ThreadMap) this.f24827a.get();
            if (threadMap.d(jA, obj)) {
                return;
            }
            this.f24827a.set(threadMap.c(jA, obj));
            Unit unit = Unit.f139807a;
        }
    }
}
