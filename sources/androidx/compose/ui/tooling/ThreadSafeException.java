package androidx.compose.ui.tooling;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ThreadSafeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Throwable f29775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f29776b;

    public final void a(Throwable th) {
        synchronized (this.f29776b) {
            this.f29775a = th;
            Unit unit = Unit.f139807a;
        }
    }

    public final void b() {
        synchronized (this.f29776b) {
            Throwable th = this.f29775a;
            if (th != null) {
                this.f29775a = null;
                throw th;
            }
        }
    }
}
