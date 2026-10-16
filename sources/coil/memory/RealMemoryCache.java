package coil.memory;

import coil.memory.MemoryCache;
import coil.util.Collections;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class RealMemoryCache implements MemoryCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StrongMemoryCache f55961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WeakMemoryCache f55962b;

    public RealMemoryCache(StrongMemoryCache strongMemoryCache, WeakMemoryCache weakMemoryCache) {
        this.f55961a = strongMemoryCache;
        this.f55962b = weakMemoryCache;
    }

    @Override // coil.memory.MemoryCache
    public void a(int i3) {
        this.f55961a.a(i3);
        this.f55962b.a(i3);
    }

    @Override // coil.memory.MemoryCache
    public MemoryCache.Value b(MemoryCache.Key key) {
        MemoryCache.Value valueB = this.f55961a.b(key);
        return valueB == null ? this.f55962b.b(key) : valueB;
    }

    @Override // coil.memory.MemoryCache
    public void c(MemoryCache.Key key, MemoryCache.Value value) {
        this.f55961a.c(MemoryCache.Key.c(key, null, Collections.b(key.d()), 1, null), value.a(), Collections.b(value.b()));
    }
}
