package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.internal.AtomicInt;
import kotlin.Metadata;

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
public abstract class StateObjectImpl implements StateObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicInt f25026a = new AtomicInt(0);

    public final boolean i(int i3) {
        return (i3 & ReaderKind.a(this.f25026a.get())) != 0;
    }

    public final void r(int i3) {
        int iA;
        do {
            iA = ReaderKind.a(this.f25026a.get());
            if ((iA & i3) != 0) {
                return;
            }
        } while (!this.f25026a.compareAndSet(iA, ReaderKind.a(iA | i3)));
    }
}
