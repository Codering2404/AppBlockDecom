package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap;

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
public final class LinkedValue<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f24521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f24522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f24523c;

    public LinkedValue(Object obj, Object obj2, Object obj3) {
        this.f24521a = obj;
        this.f24522b = obj2;
        this.f24523c = obj3;
    }

    public final boolean a() {
        return this.f24523c != EndOfChain.f24577a;
    }

    public final boolean b() {
        return this.f24522b != EndOfChain.f24577a;
    }

    public final Object c() {
        return this.f24523c;
    }

    public final Object d() {
        return this.f24522b;
    }

    public final Object e() {
        return this.f24521a;
    }

    public final LinkedValue f(Object obj) {
        return new LinkedValue(this.f24521a, this.f24522b, obj);
    }

    public final LinkedValue g(Object obj) {
        return new LinkedValue(this.f24521a, obj, this.f24523c);
    }

    public final LinkedValue h(Object obj) {
        return new LinkedValue(obj, this.f24522b, this.f24523c);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public LinkedValue(Object obj) {
        EndOfChain endOfChain = EndOfChain.f24577a;
        this(obj, endOfChain, endOfChain);
    }

    public LinkedValue(Object obj, Object obj2) {
        this(obj, obj2, EndOfChain.f24577a);
    }
}
