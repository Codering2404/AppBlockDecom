package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.EndOfChain;
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
public final class Links {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f24557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f24558b;

    public Links(Object obj, Object obj2) {
        this.f24557a = obj;
        this.f24558b = obj2;
    }

    public final boolean a() {
        return this.f24558b != EndOfChain.f24577a;
    }

    public final boolean b() {
        return this.f24557a != EndOfChain.f24577a;
    }

    public final Object c() {
        return this.f24558b;
    }

    public final Object d() {
        return this.f24557a;
    }

    public final Links e(Object obj) {
        return new Links(this.f24557a, obj);
    }

    public final Links f(Object obj) {
        return new Links(obj, this.f24558b);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Links() {
        EndOfChain endOfChain = EndOfChain.f24577a;
        this(endOfChain, endOfChain);
    }

    public Links(Object obj) {
        this(obj, EndOfChain.f24577a);
    }
}
