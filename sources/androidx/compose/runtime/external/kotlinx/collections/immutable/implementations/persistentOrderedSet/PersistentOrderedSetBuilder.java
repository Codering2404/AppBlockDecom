package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.EndOfChain;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableSet;
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
public final class PersistentOrderedSetBuilder<E> extends AbstractMutableSet<E> implements PersistentSet.Builder<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private PersistentOrderedSet f24565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f24566b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object f24567c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PersistentHashMapBuilder f24568d;

    public PersistentOrderedSetBuilder(PersistentOrderedSet persistentOrderedSet) {
        this.f24565a = persistentOrderedSet;
        this.f24566b = persistentOrderedSet.d();
        this.f24567c = this.f24565a.f();
        this.f24568d = this.f24565a.e().builder();
    }

    public final Object a() {
        return this.f24566b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractMutableSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        if (this.f24568d.containsKey(obj)) {
            return false;
        }
        if (isEmpty()) {
            this.f24566b = obj;
            this.f24567c = obj;
            this.f24568d.put(obj, new Links());
            return true;
        }
        V v2 = this.f24568d.get(this.f24567c);
        Intrinsics.checkNotNull(v2);
        this.f24568d.put(this.f24567c, ((Links) v2).e(obj));
        this.f24568d.put(obj, new Links(this.f24567c));
        this.f24567c = obj;
        return true;
    }

    public final PersistentHashMapBuilder b() {
        return this.f24568d;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet.Builder
    public PersistentSet build() {
        PersistentOrderedSet persistentOrderedSet;
        PersistentHashMap persistentHashMapBuild = this.f24568d.build();
        if (persistentHashMapBuild == this.f24565a.e()) {
            CommonFunctionsKt.a(this.f24566b == this.f24565a.d());
            CommonFunctionsKt.a(this.f24567c == this.f24565a.f());
            persistentOrderedSet = this.f24565a;
        } else {
            persistentOrderedSet = new PersistentOrderedSet(this.f24566b, this.f24567c, persistentHashMapBuild);
        }
        this.f24565a = persistentOrderedSet;
        return persistentOrderedSet;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f24568d.clear();
        EndOfChain endOfChain = EndOfChain.f24577a;
        this.f24566b = endOfChain;
        this.f24567c = endOfChain;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f24568d.containsKey(obj);
    }

    @Override // kotlin.collections.AbstractMutableSet
    public int getSize() {
        return this.f24568d.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return new PersistentOrderedSetMutableIterator(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        Links links = (Links) this.f24568d.remove(obj);
        if (links == null) {
            return false;
        }
        if (links.b()) {
            V v2 = this.f24568d.get(links.d());
            Intrinsics.checkNotNull(v2);
            this.f24568d.put(links.d(), ((Links) v2).e(links.c()));
        } else {
            this.f24566b = links.c();
        }
        if (!links.a()) {
            this.f24567c = links.d();
            return true;
        }
        V v3 = this.f24568d.get(links.c());
        Intrinsics.checkNotNull(v3);
        this.f24568d.put(links.c(), ((Links) v3).f(links.d()));
        return true;
    }
}
