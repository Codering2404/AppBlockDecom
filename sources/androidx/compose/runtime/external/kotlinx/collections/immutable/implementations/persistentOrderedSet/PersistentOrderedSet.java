package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.EndOfChain;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.AbstractSet;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class PersistentOrderedSet<E> extends AbstractSet<E> implements PersistentSet<E> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f24559d = new Companion(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f24560f = 8;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final PersistentOrderedSet f24561g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f24562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f24563b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PersistentHashMap f24564c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PersistentSet a() {
            return PersistentOrderedSet.f24561g;
        }

        private Companion() {
        }
    }

    static {
        EndOfChain endOfChain = EndOfChain.f24577a;
        f24561g = new PersistentOrderedSet(endOfChain, endOfChain, PersistentHashMap.f24457c.a());
    }

    public PersistentOrderedSet(Object obj, Object obj2, PersistentHashMap persistentHashMap) {
        this.f24562a = obj;
        this.f24563b = obj2;
        this.f24564c = persistentHashMap;
    }

    @Override // java.util.Collection, java.util.Set, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet
    public PersistentSet add(Object obj) {
        if (this.f24564c.containsKey(obj)) {
            return this;
        }
        if (isEmpty()) {
            return new PersistentOrderedSet(obj, obj, this.f24564c.i(obj, new Links()));
        }
        Object obj2 = this.f24563b;
        Object obj3 = this.f24564c.get(obj2);
        Intrinsics.checkNotNull(obj3);
        return new PersistentOrderedSet(this.f24562a, obj, this.f24564c.i(obj2, ((Links) obj3).e(obj)).i(obj, new Links(obj2)));
    }

    @Override // java.util.Collection, java.util.Set, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet
    public PersistentSet addAll(Collection collection) {
        PersistentSet.Builder builder = builder();
        builder.addAll(collection);
        return builder.build();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet
    public PersistentSet.Builder builder() {
        return new PersistentOrderedSetBuilder(this);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return this.f24564c.containsKey(obj);
    }

    public final Object d() {
        return this.f24562a;
    }

    public final PersistentHashMap e() {
        return this.f24564c;
    }

    public final Object f() {
        return this.f24563b;
    }

    @Override // kotlin.collections.AbstractCollection
    public int getSize() {
        return this.f24564c.size();
    }

    @Override // kotlin.collections.AbstractSet, kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return new PersistentOrderedSetIterator(this.f24562a, this.f24564c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Collection, java.util.Set, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet
    public PersistentSet remove(Object obj) {
        Links links = (Links) this.f24564c.get(obj);
        if (links == null) {
            return this;
        }
        PersistentHashMap persistentHashMapJ = this.f24564c.j(obj);
        if (links.b()) {
            V v2 = persistentHashMapJ.get(links.d());
            Intrinsics.checkNotNull(v2);
            persistentHashMapJ = persistentHashMapJ.i(links.d(), ((Links) v2).e(links.c()));
        }
        if (links.a()) {
            V v3 = persistentHashMapJ.get(links.c());
            Intrinsics.checkNotNull(v3);
            persistentHashMapJ = persistentHashMapJ.i(links.c(), ((Links) v3).f(links.d()));
        }
        return new PersistentOrderedSet(!links.b() ? links.c() : this.f24562a, !links.a() ? links.d() : this.f24563b, persistentHashMapJ);
    }

    @Override // java.util.Collection, java.util.Set, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet
    public PersistentSet removeAll(Collection collection) {
        PersistentSet.Builder builder = builder();
        builder.removeAll(collection);
        return builder.build();
    }
}
