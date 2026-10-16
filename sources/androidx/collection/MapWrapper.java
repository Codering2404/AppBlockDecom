package androidx.collection;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

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
class MapWrapper<K, V> implements Map<K, V>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ScatterMap f2960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Entries f2961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Keys f2962c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Values f2963d;

    public MapWrapper(ScatterMap parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        this.f2960a = parent;
    }

    public Set a() {
        Entries entries = this.f2961b;
        if (entries != null) {
            return entries;
        }
        Entries entries2 = new Entries(this.f2960a);
        this.f2961b = entries2;
        return entries2;
    }

    public Set b() {
        Keys keys = this.f2962c;
        if (keys != null) {
            return keys;
        }
        Keys keys2 = new Keys(this.f2960a);
        this.f2962c = keys2;
        return keys2;
    }

    public int c() {
        return this.f2960a.f3112e;
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public Object compute(Object obj, BiFunction biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public Object computeIfAbsent(Object obj, Function function) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public Object computeIfPresent(Object obj, BiFunction biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.f2960a.c(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.f2960a.d(obj);
    }

    public Collection d() {
        Values values = this.f2963d;
        if (values != null) {
            return values;
        }
        Values values2 = new Values(this.f2960a);
        this.f2963d = values2;
        return values2;
    }

    @Override // java.util.Map
    public final /* bridge */ Set entrySet() {
        return a();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Intrinsics.areEqual(this.f2960a, ((MapWrapper) obj).f2960a);
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        return this.f2960a.e(obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.f2960a.hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.f2960a.h();
    }

    @Override // java.util.Map
    public final /* bridge */ Set keySet() {
        return b();
    }

    @Override // java.util.Map
    public Object merge(Object obj, Object obj2, BiFunction biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public Object putIfAbsent(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public Object replace(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void replaceAll(BiFunction biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return c();
    }

    public String toString() {
        return this.f2960a.toString();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection values() {
        return d();
    }

    @Override // java.util.Map
    public boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public boolean replace(Object obj, Object obj2, Object obj3) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
