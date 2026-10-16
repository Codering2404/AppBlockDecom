package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class SnapshotStateMap<K, V> implements StateObject, Map<K, V>, KMutableMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private StateRecord f24971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set f24972b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set f24973c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Collection f24974d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class StateMapStateRecord<K, V> extends StateRecord {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private PersistentMap f24975c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f24976d;

        public StateMapStateRecord(long j3, PersistentMap persistentMap) {
            super(j3);
            this.f24975c = persistentMap;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public void c(StateRecord stateRecord) {
            Intrinsics.checkNotNull(stateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord, V of androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord>");
            StateMapStateRecord stateMapStateRecord = (StateMapStateRecord) stateRecord;
            synchronized (SnapshotStateMapKt.f24977a) {
                this.f24975c = stateMapStateRecord.f24975c;
                this.f24976d = stateMapStateRecord.f24976d;
                Unit unit = Unit.f139807a;
            }
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public StateRecord d() {
            return new StateMapStateRecord(SnapshotKt.I().i(), this.f24975c);
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public StateRecord e(long j3) {
            return new StateMapStateRecord(j3, this.f24975c);
        }

        public final PersistentMap j() {
            return this.f24975c;
        }

        public final int k() {
            return this.f24976d;
        }

        public final void l(PersistentMap persistentMap) {
            this.f24975c = persistentMap;
        }

        public final void m(int i3) {
            this.f24976d = i3;
        }
    }

    public SnapshotStateMap() {
        PersistentMap persistentMapA = ExtensionsKt.a();
        Snapshot snapshotI = SnapshotKt.I();
        StateMapStateRecord stateMapStateRecord = new StateMapStateRecord(snapshotI.i(), persistentMapA);
        if (!(snapshotI instanceof GlobalSnapshot)) {
            stateMapStateRecord.h(new StateMapStateRecord(SnapshotId_jvmKt.c(1), persistentMapA));
        }
        this.f24971a = stateMapStateRecord;
        this.f24972b = new SnapshotMapEntrySet(this);
        this.f24973c = new SnapshotMapKeySet(this);
        this.f24974d = new SnapshotMapValueSet(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean b(StateMapStateRecord stateMapStateRecord, int i3, PersistentMap persistentMap) {
        boolean z2;
        synchronized (SnapshotStateMapKt.f24977a) {
            if (stateMapStateRecord.k() == i3) {
                stateMapStateRecord.l(persistentMap);
                z2 = true;
                stateMapStateRecord.m(stateMapStateRecord.k() + 1);
            } else {
                z2 = false;
            }
        }
        return z2;
    }

    private final int c(StateMapStateRecord stateMapStateRecord, PersistentMap persistentMap) {
        int iK;
        synchronized (SnapshotStateMapKt.f24977a) {
            stateMapStateRecord.l(persistentMap);
            iK = stateMapStateRecord.k();
            stateMapStateRecord.m(iK + 1);
        }
        return iK;
    }

    @Override // java.util.Map
    public void clear() {
        Snapshot snapshotC;
        StateRecord stateRecordP = p();
        Intrinsics.checkNotNull(stateRecordP, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        StateMapStateRecord stateMapStateRecord = (StateMapStateRecord) SnapshotKt.G((StateMapStateRecord) stateRecordP);
        stateMapStateRecord.j();
        PersistentMap persistentMapA = ExtensionsKt.a();
        if (persistentMapA != stateMapStateRecord.j()) {
            StateRecord stateRecordP2 = p();
            Intrinsics.checkNotNull(stateRecordP2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
            StateMapStateRecord stateMapStateRecord2 = (StateMapStateRecord) stateRecordP2;
            synchronized (SnapshotKt.J()) {
                snapshotC = Snapshot.f24914e.c();
                c((StateMapStateRecord) SnapshotKt.h0(stateMapStateRecord2, this, snapshotC), persistentMapA);
            }
            SnapshotKt.Q(snapshotC, this);
        }
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return g().j().containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return g().j().containsValue(obj);
    }

    public Set d() {
        return this.f24972b;
    }

    public Set e() {
        return this.f24973c;
    }

    @Override // java.util.Map
    public final /* bridge */ Set entrySet() {
        return d();
    }

    public final int f() {
        return g().k();
    }

    public final StateMapStateRecord g() {
        StateRecord stateRecordP = p();
        Intrinsics.checkNotNull(stateRecordP, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        return (StateMapStateRecord) SnapshotKt.X((StateMapStateRecord) stateRecordP, this);
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        return g().j().get(obj);
    }

    public int h() {
        return g().j().size();
    }

    public Collection i() {
        return this.f24974d;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return g().j().isEmpty();
    }

    public final boolean j(Object obj) {
        Object next;
        Iterator it = entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics.areEqual(((Map.Entry) next).getValue(), obj)) {
                break;
            }
        }
        Map.Entry entry = (Map.Entry) next;
        if (entry == null) {
            return false;
        }
        remove(entry.getKey());
        return true;
    }

    public final Map k() {
        return g().j();
    }

    @Override // java.util.Map
    public final /* bridge */ Set keySet() {
        return e();
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public void n(StateRecord stateRecord) {
        Intrinsics.checkNotNull(stateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        this.f24971a = (StateMapStateRecord) stateRecord;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public StateRecord p() {
        return this.f24971a;
    }

    @Override // java.util.Map
    public Object put(Object obj, Object obj2) {
        PersistentMap persistentMapJ;
        int iK;
        V vPut;
        Snapshot snapshotC;
        boolean zB;
        do {
            synchronized (SnapshotStateMapKt.f24977a) {
                StateRecord stateRecordP = p();
                Intrinsics.checkNotNull(stateRecordP, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
                StateMapStateRecord stateMapStateRecord = (StateMapStateRecord) SnapshotKt.G((StateMapStateRecord) stateRecordP);
                persistentMapJ = stateMapStateRecord.j();
                iK = stateMapStateRecord.k();
                Unit unit = Unit.f139807a;
            }
            Intrinsics.checkNotNull(persistentMapJ);
            PersistentMap.Builder builder = persistentMapJ.builder();
            vPut = builder.put(obj, obj2);
            PersistentMap persistentMapBuild = builder.build();
            if (Intrinsics.areEqual(persistentMapBuild, persistentMapJ)) {
                break;
            }
            StateRecord stateRecordP2 = p();
            Intrinsics.checkNotNull(stateRecordP2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
            StateMapStateRecord stateMapStateRecord2 = (StateMapStateRecord) stateRecordP2;
            synchronized (SnapshotKt.J()) {
                snapshotC = Snapshot.f24914e.c();
                zB = b((StateMapStateRecord) SnapshotKt.h0(stateMapStateRecord2, this, snapshotC), iK, persistentMapBuild);
            }
            SnapshotKt.Q(snapshotC, this);
        } while (!zB);
        return vPut;
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        PersistentMap persistentMapJ;
        int iK;
        Snapshot snapshotC;
        boolean zB;
        do {
            synchronized (SnapshotStateMapKt.f24977a) {
                StateRecord stateRecordP = p();
                Intrinsics.checkNotNull(stateRecordP, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
                StateMapStateRecord stateMapStateRecord = (StateMapStateRecord) SnapshotKt.G((StateMapStateRecord) stateRecordP);
                persistentMapJ = stateMapStateRecord.j();
                iK = stateMapStateRecord.k();
                Unit unit = Unit.f139807a;
            }
            Intrinsics.checkNotNull(persistentMapJ);
            PersistentMap.Builder builder = persistentMapJ.builder();
            builder.putAll(map);
            PersistentMap persistentMapBuild = builder.build();
            if (Intrinsics.areEqual(persistentMapBuild, persistentMapJ)) {
                return;
            }
            StateRecord stateRecordP2 = p();
            Intrinsics.checkNotNull(stateRecordP2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
            StateMapStateRecord stateMapStateRecord2 = (StateMapStateRecord) stateRecordP2;
            synchronized (SnapshotKt.J()) {
                snapshotC = Snapshot.f24914e.c();
                zB = b((StateMapStateRecord) SnapshotKt.h0(stateMapStateRecord2, this, snapshotC), iK, persistentMapBuild);
            }
            SnapshotKt.Q(snapshotC, this);
        } while (!zB);
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        PersistentMap persistentMapJ;
        int iK;
        V vRemove;
        Snapshot snapshotC;
        boolean zB;
        do {
            synchronized (SnapshotStateMapKt.f24977a) {
                StateRecord stateRecordP = p();
                Intrinsics.checkNotNull(stateRecordP, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
                StateMapStateRecord stateMapStateRecord = (StateMapStateRecord) SnapshotKt.G((StateMapStateRecord) stateRecordP);
                persistentMapJ = stateMapStateRecord.j();
                iK = stateMapStateRecord.k();
                Unit unit = Unit.f139807a;
            }
            Intrinsics.checkNotNull(persistentMapJ);
            PersistentMap.Builder builder = persistentMapJ.builder();
            vRemove = builder.remove(obj);
            PersistentMap persistentMapBuild = builder.build();
            if (Intrinsics.areEqual(persistentMapBuild, persistentMapJ)) {
                break;
            }
            StateRecord stateRecordP2 = p();
            Intrinsics.checkNotNull(stateRecordP2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
            StateMapStateRecord stateMapStateRecord2 = (StateMapStateRecord) stateRecordP2;
            synchronized (SnapshotKt.J()) {
                snapshotC = Snapshot.f24914e.c();
                zB = b((StateMapStateRecord) SnapshotKt.h0(stateMapStateRecord2, this, snapshotC), iK, persistentMapBuild);
            }
            SnapshotKt.Q(snapshotC, this);
        } while (!zB);
        return vRemove;
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return h();
    }

    public String toString() {
        StateRecord stateRecordP = p();
        Intrinsics.checkNotNull(stateRecordP, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        return "SnapshotStateMap(value=" + ((StateMapStateRecord) SnapshotKt.G((StateMapStateRecord) stateRecordP)).j() + ")@" + hashCode();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection values() {
        return i();
    }
}
