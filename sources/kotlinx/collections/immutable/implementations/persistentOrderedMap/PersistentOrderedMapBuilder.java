package kotlinx.collections.immutable.implementations.persistentOrderedMap;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableMap;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.PersistentMap;
import kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder;
import kotlinx.collections.immutable.internal.CommonFunctionsKt;
import kotlinx.collections.immutable.internal.EndOfChain;
import kotlinx.collections.immutable.internal.MapImplementation;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class PersistentOrderedMapBuilder<K, V> extends AbstractMutableMap<K, V> implements PersistentMap.Builder<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object f140815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f140816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PersistentHashMapBuilder f140817c;

    public final Object a() {
        return this.f140815a;
    }

    public final PersistentHashMapBuilder b() {
        return this.f140817c;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.f140817c.clear();
        EndOfChain endOfChain = EndOfChain.f140866a;
        this.f140815a = endOfChain;
        this.f140816b = endOfChain;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return this.f140817c.containsKey(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (size() != map.size()) {
            return false;
        }
        return map instanceof PersistentOrderedMap ? this.f140817c.c().k(((PersistentOrderedMap) obj).e().g(), new Function2<LinkedValue<V>, ?, Boolean>() { // from class: kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMapBuilder.equals.1
            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(LinkedValue a3, LinkedValue b3) {
                Intrinsics.checkNotNullParameter(a3, "a");
                Intrinsics.checkNotNullParameter(b3, "b");
                return Boolean.valueOf(Intrinsics.areEqual(a3.e(), b3.e()));
            }
        }) : map instanceof PersistentOrderedMapBuilder ? this.f140817c.c().k(((PersistentOrderedMapBuilder) obj).f140817c.c(), new Function2<LinkedValue<V>, ?, Boolean>() { // from class: kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMapBuilder.equals.2
            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(LinkedValue a3, LinkedValue b3) {
                Intrinsics.checkNotNullParameter(a3, "a");
                Intrinsics.checkNotNullParameter(b3, "b");
                return Boolean.valueOf(Intrinsics.areEqual(a3.e(), b3.e()));
            }
        }) : map instanceof PersistentHashMap ? this.f140817c.c().k(((PersistentHashMap) obj).g(), new Function2<LinkedValue<V>, ?, Boolean>() { // from class: kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMapBuilder.equals.3
            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(LinkedValue a3, Object obj2) {
                Intrinsics.checkNotNullParameter(a3, "a");
                return Boolean.valueOf(Intrinsics.areEqual(a3.e(), obj2));
            }
        }) : map instanceof PersistentHashMapBuilder ? this.f140817c.c().k(((PersistentHashMapBuilder) obj).c(), new Function2<LinkedValue<V>, ?, Boolean>() { // from class: kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMapBuilder.equals.4
            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(LinkedValue a3, Object obj2) {
                Intrinsics.checkNotNullParameter(a3, "a");
                return Boolean.valueOf(Intrinsics.areEqual(a3.e(), obj2));
            }
        }) : MapImplementation.f140868a.b(this, map);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        LinkedValue linkedValue = (LinkedValue) this.f140817c.get(obj);
        if (linkedValue == null) {
            return null;
        }
        return linkedValue.e();
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
        return this.f140817c.size();
    }

    @Override // kotlin.collections.AbstractMutableMap
    public Collection getValues() {
        return new PersistentOrderedMapBuilderValues(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        return MapImplementation.f140868a.c(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractMutableMap, java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        LinkedValue linkedValue = (LinkedValue) this.f140817c.get(obj);
        if (linkedValue != null) {
            if (linkedValue.e() == obj2) {
                return obj2;
            }
            this.f140817c.put(obj, linkedValue.h(obj2));
            return linkedValue.e();
        }
        if (isEmpty()) {
            this.f140815a = obj;
            this.f140816b = obj;
            this.f140817c.put(obj, new LinkedValue(obj2));
            return null;
        }
        Object obj3 = this.f140816b;
        Object obj4 = this.f140817c.get(obj3);
        Intrinsics.checkNotNull(obj4);
        CommonFunctionsKt.a(!r2.a());
        this.f140817c.put(obj3, ((LinkedValue) obj4).f(obj));
        this.f140817c.put(obj, new LinkedValue(obj2, obj3));
        this.f140816b = obj;
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        LinkedValue linkedValue = (LinkedValue) this.f140817c.remove(obj);
        if (linkedValue == null) {
            return null;
        }
        if (linkedValue.b()) {
            V v2 = this.f140817c.get(linkedValue.d());
            Intrinsics.checkNotNull(v2);
            this.f140817c.put(linkedValue.d(), ((LinkedValue) v2).f(linkedValue.c()));
        } else {
            this.f140815a = linkedValue.c();
        }
        if (linkedValue.a()) {
            V v3 = this.f140817c.get(linkedValue.c());
            Intrinsics.checkNotNull(v3);
            this.f140817c.put(linkedValue.c(), ((LinkedValue) v3).g(linkedValue.d()));
        } else {
            this.f140816b = linkedValue.d();
        }
        return linkedValue.e();
    }

    @Override // java.util.Map
    public final boolean remove(Object obj, Object obj2) {
        LinkedValue linkedValue = (LinkedValue) this.f140817c.get(obj);
        if (linkedValue == null || !Intrinsics.areEqual(linkedValue.e(), obj2)) {
            return false;
        }
        remove(obj);
        return true;
    }
}
