package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;

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
final class SnapshotMapEntrySet<K, V> extends SnapshotMapSet<K, V, Map.Entry<K, V>> {
    public SnapshotMapEntrySet(SnapshotStateMap snapshotStateMap) {
        super(snapshotStateMap);
    }

    @Override // java.util.Set, java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        return ((Boolean) d((Map.Entry) obj)).booleanValue();
    }

    @Override // java.util.Set, java.util.Collection
    public /* bridge */ /* synthetic */ boolean addAll(Collection collection) {
        return ((Boolean) e(collection)).booleanValue();
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (TypeIntrinsics.o(obj)) {
            return f((Map.Entry) obj);
        }
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection collection) {
        Collection collection2 = collection;
        if ((collection2 instanceof Collection) && collection2.isEmpty()) {
            return true;
        }
        Iterator it = collection2.iterator();
        while (it.hasNext()) {
            if (!contains((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public Void d(Map.Entry entry) {
        SnapshotStateMapKt.b();
        throw new KotlinNothingValueException();
    }

    public Void e(Collection collection) {
        SnapshotStateMapKt.b();
        throw new KotlinNothingValueException();
    }

    public boolean f(Map.Entry entry) {
        return Intrinsics.areEqual(a().get(entry.getKey()), entry.getValue());
    }

    public boolean g(Map.Entry entry) {
        return a().remove(entry.getKey()) != null;
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return new StateMapMutableEntriesIterator(a(), ((ImmutableSet) a().g().j().entrySet()).iterator());
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ boolean remove(Object obj) {
        if (TypeIntrinsics.o(obj)) {
            return g((Map.Entry) obj);
        }
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection collection) {
        Iterator it = collection.iterator();
        while (true) {
            boolean z2 = false;
            while (it.hasNext()) {
                if (a().remove(((Map.Entry) it.next()).getKey()) != null || z2) {
                    z2 = true;
                }
            }
            return z2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection collection) {
        PersistentMap persistentMapJ;
        int iK;
        Snapshot snapshotC;
        boolean zB;
        Collection<Map.Entry> collection2 = collection;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(collection2, 10)), 16));
        for (Map.Entry entry : collection2) {
            Pair pairA = TuplesKt.a(entry.getKey(), entry.getValue());
            linkedHashMap.put(pairA.e(), pairA.f());
        }
        SnapshotStateMap snapshotStateMapA = a();
        boolean z2 = false;
        do {
            synchronized (SnapshotStateMapKt.f24977a) {
                StateRecord stateRecordP = snapshotStateMapA.p();
                Intrinsics.checkNotNull(stateRecordP, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
                SnapshotStateMap.StateMapStateRecord stateMapStateRecord = (SnapshotStateMap.StateMapStateRecord) SnapshotKt.G((SnapshotStateMap.StateMapStateRecord) stateRecordP);
                persistentMapJ = stateMapStateRecord.j();
                iK = stateMapStateRecord.k();
                Unit unit = Unit.f139807a;
            }
            Intrinsics.checkNotNull(persistentMapJ);
            PersistentMap.Builder builder = persistentMapJ.builder();
            for (Map.Entry entry2 : snapshotStateMapA.entrySet()) {
                if (!linkedHashMap.containsKey(entry2.getKey()) || !Intrinsics.areEqual(linkedHashMap.get(entry2.getKey()), entry2.getValue())) {
                    builder.remove(entry2.getKey());
                    z2 = true;
                }
            }
            Unit unit2 = Unit.f139807a;
            PersistentMap persistentMapBuild = builder.build();
            if (Intrinsics.areEqual(persistentMapBuild, persistentMapJ)) {
                break;
            }
            StateRecord stateRecordP2 = snapshotStateMapA.p();
            Intrinsics.checkNotNull(stateRecordP2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
            SnapshotStateMap.StateMapStateRecord stateMapStateRecord2 = (SnapshotStateMap.StateMapStateRecord) stateRecordP2;
            synchronized (SnapshotKt.J()) {
                snapshotC = Snapshot.f24914e.c();
                zB = snapshotStateMapA.b((SnapshotStateMap.StateMapStateRecord) SnapshotKt.h0(stateMapStateRecord2, snapshotStateMapA, snapshotC), iK, persistentMapBuild);
            }
            SnapshotKt.Q(snapshotC, snapshotStateMapA);
        } while (!zB);
        return z2;
    }
}
