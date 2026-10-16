package kotlinx.collections.immutable.implementations.persistentOrderedMap;

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
public final class LinkedValue<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f140801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f140802b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f140803c;

    public LinkedValue(Object obj, Object obj2, Object obj3) {
        this.f140801a = obj;
        this.f140802b = obj2;
        this.f140803c = obj3;
    }

    public final boolean a() {
        return this.f140803c != EndOfChain.f140866a;
    }

    public final boolean b() {
        return this.f140802b != EndOfChain.f140866a;
    }

    public final Object c() {
        return this.f140803c;
    }

    public final Object d() {
        return this.f140802b;
    }

    public final Object e() {
        return this.f140801a;
    }

    public final LinkedValue f(Object obj) {
        return new LinkedValue(this.f140801a, this.f140802b, obj);
    }

    public final LinkedValue g(Object obj) {
        return new LinkedValue(this.f140801a, obj, this.f140803c);
    }

    public final LinkedValue h(Object obj) {
        return new LinkedValue(obj, this.f140802b, this.f140803c);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public LinkedValue(Object obj) {
        EndOfChain endOfChain = EndOfChain.f140866a;
        this(obj, endOfChain, endOfChain);
    }

    public LinkedValue(Object obj, Object obj2) {
        this(obj, obj2, EndOfChain.f140866a);
    }
}
