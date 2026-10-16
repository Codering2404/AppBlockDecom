package kotlinx.collections.immutable.implementations.persistentOrderedSet;

import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.PersistentSet;
import kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder;
import kotlinx.collections.immutable.internal.CommonFunctionsKt;
import kotlinx.collections.immutable.internal.EndOfChain;

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
public final class PersistentOrderedSetBuilder<E> extends AbstractMutableSet<E> implements PersistentSet.Builder<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private PersistentOrderedSet f140852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f140853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object f140854c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PersistentHashMapBuilder f140855d;

    public PersistentOrderedSetBuilder(PersistentOrderedSet set) {
        Intrinsics.checkNotNullParameter(set, "set");
        this.f140852a = set;
        this.f140853b = set.d();
        this.f140854c = this.f140852a.f();
        this.f140855d = this.f140852a.e().d();
    }

    public final Object a() {
        return this.f140853b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractMutableSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        if (this.f140855d.containsKey(obj)) {
            return false;
        }
        if (isEmpty()) {
            this.f140853b = obj;
            this.f140854c = obj;
            this.f140855d.put(obj, new Links());
            return true;
        }
        V v2 = this.f140855d.get(this.f140854c);
        Intrinsics.checkNotNull(v2);
        this.f140855d.put(this.f140854c, ((Links) v2).e(obj));
        this.f140855d.put(obj, new Links(this.f140854c));
        this.f140854c = obj;
        return true;
    }

    public final PersistentHashMapBuilder b() {
        return this.f140855d;
    }

    @Override // kotlinx.collections.immutable.PersistentSet.Builder
    public PersistentSet build() {
        PersistentOrderedSet persistentOrderedSet;
        PersistentHashMap persistentHashMapA = this.f140855d.a();
        if (persistentHashMapA == this.f140852a.e()) {
            CommonFunctionsKt.a(this.f140853b == this.f140852a.d());
            CommonFunctionsKt.a(this.f140854c == this.f140852a.f());
            persistentOrderedSet = this.f140852a;
        } else {
            persistentOrderedSet = new PersistentOrderedSet(this.f140853b, this.f140854c, persistentHashMapA);
        }
        this.f140852a = persistentOrderedSet;
        return persistentOrderedSet;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f140855d.clear();
        EndOfChain endOfChain = EndOfChain.f140866a;
        this.f140853b = endOfChain;
        this.f140854c = endOfChain;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f140855d.containsKey(obj);
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (size() != set.size()) {
            return false;
        }
        return set instanceof PersistentOrderedSet ? this.f140855d.c().k(((PersistentOrderedSet) obj).e().g(), new Function2<Links, Links, Boolean>() { // from class: kotlinx.collections.immutable.implementations.persistentOrderedSet.PersistentOrderedSetBuilder.equals.1
            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(Links noName_0, Links noName_1) {
                Intrinsics.checkNotNullParameter(noName_0, "$noName_0");
                Intrinsics.checkNotNullParameter(noName_1, "$noName_1");
                return Boolean.TRUE;
            }
        }) : set instanceof PersistentOrderedSetBuilder ? this.f140855d.c().k(((PersistentOrderedSetBuilder) obj).f140855d.c(), new Function2<Links, Links, Boolean>() { // from class: kotlinx.collections.immutable.implementations.persistentOrderedSet.PersistentOrderedSetBuilder.equals.2
            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(Links noName_0, Links noName_1) {
                Intrinsics.checkNotNullParameter(noName_0, "$noName_0");
                Intrinsics.checkNotNullParameter(noName_1, "$noName_1");
                return Boolean.TRUE;
            }
        }) : super.equals(obj);
    }

    @Override // kotlin.collections.AbstractMutableSet
    public int getSize() {
        return this.f140855d.size();
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public int hashCode() {
        return super.hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return new PersistentOrderedSetMutableIterator(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        Links links = (Links) this.f140855d.remove(obj);
        if (links == null) {
            return false;
        }
        if (links.b()) {
            V v2 = this.f140855d.get(links.d());
            Intrinsics.checkNotNull(v2);
            this.f140855d.put(links.d(), ((Links) v2).e(links.c()));
        } else {
            this.f140853b = links.c();
        }
        if (!links.a()) {
            this.f140854c = links.d();
            return true;
        }
        V v3 = this.f140855d.get(links.c());
        Intrinsics.checkNotNull(v3);
        this.f140855d.put(links.c(), ((Links) v3).f(links.d()));
        return true;
    }
}
