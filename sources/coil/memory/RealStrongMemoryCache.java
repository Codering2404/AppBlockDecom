package coil.memory;

import android.graphics.Bitmap;
import androidx.collection.LruCache;
import coil.memory.MemoryCache;
import coil.memory.RealStrongMemoryCache;
import coil.util.Bitmaps;
import java.util.Map;
import kotlin.Metadata;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class RealStrongMemoryCache implements StrongMemoryCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakMemoryCache f55963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RealStrongMemoryCache$cache$1 f55964b;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class InternalValue {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Bitmap f55965a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map f55966b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f55967c;

        public InternalValue(Bitmap bitmap, Map map, int i3) {
            this.f55965a = bitmap;
            this.f55966b = map;
            this.f55967c = i3;
        }

        public final Bitmap a() {
            return this.f55965a;
        }

        public final Map b() {
            return this.f55966b;
        }

        public final int c() {
            return this.f55967c;
        }
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [coil.memory.RealStrongMemoryCache$cache$1] */
    public RealStrongMemoryCache(final int i3, WeakMemoryCache weakMemoryCache) {
        this.f55963a = weakMemoryCache;
        this.f55964b = new LruCache<MemoryCache.Key, InternalValue>(i3) { // from class: coil.memory.RealStrongMemoryCache$cache$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.collection.LruCache
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void entryRemoved(boolean z2, MemoryCache.Key key, RealStrongMemoryCache.InternalValue internalValue, RealStrongMemoryCache.InternalValue internalValue2) {
                this.f55963a.c(key, internalValue.a(), internalValue.b(), internalValue.c());
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.collection.LruCache
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public int sizeOf(MemoryCache.Key key, RealStrongMemoryCache.InternalValue internalValue) {
                return internalValue.c();
            }
        };
    }

    @Override // coil.memory.StrongMemoryCache
    public void a(int i3) {
        if (i3 >= 40) {
            e();
        } else {
            if (10 > i3 || i3 >= 20) {
                return;
            }
            trimToSize(g() / 2);
        }
    }

    @Override // coil.memory.StrongMemoryCache
    public MemoryCache.Value b(MemoryCache.Key key) {
        InternalValue internalValue = get(key);
        if (internalValue != null) {
            return new MemoryCache.Value(internalValue.a(), internalValue.b());
        }
        return null;
    }

    @Override // coil.memory.StrongMemoryCache
    public void c(MemoryCache.Key key, Bitmap bitmap, Map map) {
        int iA = Bitmaps.a(bitmap);
        if (iA <= f()) {
            put(key, new InternalValue(bitmap, map, iA));
        } else {
            remove(key);
            this.f55963a.c(key, bitmap, map, iA);
        }
    }

    public void e() {
        evictAll();
    }

    public int f() {
        return maxSize();
    }

    public int g() {
        return size();
    }
}
