package kotlinx.collections.immutable.implementations.persistentOrderedSet;

import kotlin.Metadata;
import kotlinx.collections.immutable.internal.EndOfChain;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class Links {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f140843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f140844b;

    public Links(Object obj, Object obj2) {
        this.f140843a = obj;
        this.f140844b = obj2;
    }

    public final boolean a() {
        return this.f140844b != EndOfChain.f140866a;
    }

    public final boolean b() {
        return this.f140843a != EndOfChain.f140866a;
    }

    public final Object c() {
        return this.f140844b;
    }

    public final Object d() {
        return this.f140843a;
    }

    public final Links e(Object obj) {
        return new Links(this.f140843a, obj);
    }

    public final Links f(Object obj) {
        return new Links(obj, this.f140844b);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Links() {
        EndOfChain endOfChain = EndOfChain.f140866a;
        this(endOfChain, endOfChain);
    }

    public Links(Object obj) {
        this(obj, EndOfChain.f140866a);
    }
}
