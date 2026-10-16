package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
final class SnapshotMapValueSet<K, V> extends SnapshotMapSet<K, V, V> {
    public SnapshotMapValueSet(SnapshotStateMap snapshotStateMap) {
        super(snapshotStateMap);
    }

    @Override // java.util.Set, java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        return ((Boolean) d(obj)).booleanValue();
    }

    @Override // java.util.Set, java.util.Collection
    public /* bridge */ /* synthetic */ boolean addAll(Collection collection) {
        return ((Boolean) e(collection)).booleanValue();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object obj) {
        return a().containsValue(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection collection) {
        Collection collection2 = collection;
        if ((collection2 instanceof Collection) && collection2.isEmpty()) {
            return true;
        }
        Iterator it = collection2.iterator();
        while (it.hasNext()) {
            if (!a().containsValue(it.next())) {
                return false;
            }
        }
        return true;
    }

    public Void d(Object obj) {
        SnapshotStateMapKt.b();
        throw new KotlinNothingValueException();
    }

    public Void e(Collection collection) {
        SnapshotStateMapKt.b();
        throw new KotlinNothingValueException();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public StateMapMutableValuesIterator iterator() {
        return new StateMapMutableValuesIterator(a(), ((ImmutableSet) a().g().j().entrySet()).iterator());
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object obj) {
        return a().j(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection collection) {
        PersistentMap persistentMapJ;
        int iK;
        Snapshot snapshotC;
        boolean zB;
        Set set = CollectionsKt.toSet(collection);
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
            for (Map.Entry entry : snapshotStateMapA.entrySet()) {
                if (set.contains(entry.getValue())) {
                    builder.remove(entry.getKey());
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

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection collection) {
        PersistentMap persistentMapJ;
        int iK;
        Snapshot snapshotC;
        boolean zB;
        Set set = CollectionsKt.toSet(collection);
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
            for (Map.Entry entry : snapshotStateMapA.entrySet()) {
                if (!set.contains(entry.getValue())) {
                    builder.remove(entry.getKey());
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
