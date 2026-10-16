package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.EndOfChain;
import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableMap;
import kotlin.jvm.internal.Intrinsics;

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
public final class PersistentOrderedMapBuilder<K, V> extends AbstractMutableMap<K, V> implements PersistentMap.Builder<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private PersistentOrderedMap f24532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f24533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object f24534c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PersistentHashMapBuilder f24535d;

    public PersistentOrderedMapBuilder(PersistentOrderedMap persistentOrderedMap) {
        this.f24532a = persistentOrderedMap;
        this.f24533b = persistentOrderedMap.d();
        this.f24534c = this.f24532a.g();
        this.f24535d = this.f24532a.e().builder();
    }

    public final Object a() {
        return this.f24533b;
    }

    public final PersistentHashMapBuilder b() {
        return this.f24535d;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap.Builder
    public PersistentMap build() {
        PersistentOrderedMap persistentOrderedMap;
        PersistentHashMap persistentHashMapBuild = this.f24535d.build();
        if (persistentHashMapBuild == this.f24532a.e()) {
            CommonFunctionsKt.a(this.f24533b == this.f24532a.d());
            CommonFunctionsKt.a(this.f24534c == this.f24532a.g());
            persistentOrderedMap = this.f24532a;
        } else {
            persistentOrderedMap = new PersistentOrderedMap(this.f24533b, this.f24534c, persistentHashMapBuild);
        }
        this.f24532a = persistentOrderedMap;
        return persistentOrderedMap;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.f24535d.clear();
        EndOfChain endOfChain = EndOfChain.f24577a;
        this.f24533b = endOfChain;
        this.f24534c = endOfChain;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return this.f24535d.containsKey(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        LinkedValue linkedValue = (LinkedValue) this.f24535d.get(obj);
        if (linkedValue != null) {
            return linkedValue.e();
        }
        return null;
    }

    @Override // kotlin.collections.AbstractMutableMap
    public Set getEntries() {
        return new PersistentOrderedMapBuilderEntries(this);
    }

    @Override // kotlin.collections.AbstractMutableMap
    public Set getKeys() {
        return new PersistentOrderedMapBuilderKeys(this);
    }

    @Override // kotlin.collections.AbstractMutableMap
    public int getSize() {
        return this.f24535d.size();
    }

    @Override // kotlin.collections.AbstractMutableMap
    public Collection getValues() {
        return new PersistentOrderedMapBuilderValues(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractMutableMap, java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        LinkedValue linkedValue = (LinkedValue) this.f24535d.get(obj);
        if (linkedValue != null) {
            if (linkedValue.e() == obj2) {
                return obj2;
            }
            this.f24535d.put(obj, linkedValue.h(obj2));
            return linkedValue.e();
        }
        if (isEmpty()) {
            this.f24533b = obj;
            this.f24534c = obj;
            this.f24535d.put(obj, new LinkedValue(obj2));
            return null;
        }
        Object obj3 = this.f24534c;
        Object obj4 = this.f24535d.get(obj3);
        Intrinsics.checkNotNull(obj4);
        CommonFunctionsKt.a(!r2.a());
        this.f24535d.put(obj3, ((LinkedValue) obj4).f(obj));
        this.f24535d.put(obj, new LinkedValue(obj2, obj3));
        this.f24534c = obj;
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        LinkedValue linkedValue = (LinkedValue) this.f24535d.remove(obj);
        if (linkedValue == null) {
            return null;
        }
        if (linkedValue.b()) {
            V v2 = this.f24535d.get(linkedValue.d());
            Intrinsics.checkNotNull(v2);
            this.f24535d.put(linkedValue.d(), ((LinkedValue) v2).f(linkedValue.c()));
        } else {
            this.f24533b = linkedValue.c();
        }
        if (linkedValue.a()) {
            V v3 = this.f24535d.get(linkedValue.c());
            Intrinsics.checkNotNull(v3);
            this.f24535d.put(linkedValue.c(), ((LinkedValue) v3).g(linkedValue.d()));
        } else {
            this.f24534c = linkedValue.d();
        }
        return linkedValue.e();
    }

    @Override // java.util.Map
    public final boolean remove(Object obj, Object obj2) {
        LinkedValue linkedValue = (LinkedValue) this.f24535d.get(obj);
        if (linkedValue == null || !Intrinsics.areEqual(linkedValue.e(), obj2)) {
            return false;
        }
        remove(obj);
        return true;
    }
}
