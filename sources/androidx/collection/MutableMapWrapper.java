package androidx.collection;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

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
final class MutableMapWrapper<K, V> extends MapWrapper<K, V> implements Map<K, V>, KMutableMap {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final MutableScatterMap f3011f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private MutableEntries f3012g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private MutableKeys f3013h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private MutableValues f3014i;

    @Override // androidx.collection.MapWrapper
    public Set a() {
        MutableEntries mutableEntries = this.f3012g;
        if (mutableEntries != null) {
            return mutableEntries;
        }
        MutableEntries mutableEntries2 = new MutableEntries(this.f3011f);
        this.f3012g = mutableEntries2;
        return mutableEntries2;
    }

    @Override // androidx.collection.MapWrapper
    public Set b() {
        MutableKeys mutableKeys = this.f3013h;
        if (mutableKeys != null) {
            return mutableKeys;
        }
        MutableKeys mutableKeys2 = new MutableKeys(this.f3011f);
        this.f3013h = mutableKeys2;
        return mutableKeys2;
    }

    @Override // androidx.collection.MapWrapper, java.util.Map
    public void clear() {
        this.f3011f.k();
    }

    @Override // androidx.collection.MapWrapper
    public Collection d() {
        MutableValues mutableValues = this.f3014i;
        if (mutableValues != null) {
            return mutableValues;
        }
        MutableValues mutableValues2 = new MutableValues(this.f3011f);
        this.f3014i = mutableValues2;
        return mutableValues2;
    }

    @Override // androidx.collection.MapWrapper, java.util.Map
    public Object put(Object obj, Object obj2) {
        return this.f3011f.r(obj, obj2);
    }

    @Override // androidx.collection.MapWrapper, java.util.Map
    public void putAll(Map from) {
        Intrinsics.checkNotNullParameter(from, "from");
        for (Map.Entry<K, V> entry : from.entrySet()) {
            this.f3011f.x(entry.getKey(), entry.getValue());
        }
    }

    @Override // androidx.collection.MapWrapper, java.util.Map
    public Object remove(Object obj) {
        return this.f3011f.u(obj);
    }
}
