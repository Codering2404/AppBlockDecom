package androidx.compose.runtime.snapshots;

import androidx.appcompat.app.jE.vxrlPPpdv;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.RandomAccess;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableSet;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class SnapshotStateSet<T> implements StateObject, Set<T>, RandomAccess, KMutableSet {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private StateRecord f25006a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes.dex */
    @Metadata
    public static final class StateSetStateRecord<T> extends StateRecord {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private PersistentSet f25007c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f25008d;

        public StateSetStateRecord(long j3, PersistentSet persistentSet) {
            super(j3);
            this.f25007c = persistentSet;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public void c(StateRecord stateRecord) {
            synchronized (SnapshotStateSetKt.f25010a) {
                Intrinsics.checkNotNull(stateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateSet.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSet.StateSetStateRecord>");
                this.f25007c = ((StateSetStateRecord) stateRecord).f25007c;
                this.f25008d = ((StateSetStateRecord) stateRecord).f25008d;
                Unit unit = Unit.f139807a;
            }
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public StateRecord d() {
            return new StateSetStateRecord(SnapshotKt.I().i(), this.f25007c);
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public StateRecord e(long j3) {
            return new StateSetStateRecord(j3, this.f25007c);
        }

        public final int j() {
            return this.f25008d;
        }

        public final PersistentSet k() {
            return this.f25007c;
        }

        public final void l(int i3) {
            this.f25008d = i3;
        }

        public final void m(PersistentSet persistentSet) {
            this.f25007c = persistentSet;
        }
    }

    private final boolean a(StateSetStateRecord stateSetStateRecord, int i3, PersistentSet persistentSet) {
        boolean z2;
        synchronized (SnapshotStateSetKt.f25010a) {
            if (stateSetStateRecord.j() == i3) {
                stateSetStateRecord.m(persistentSet);
                z2 = true;
                stateSetStateRecord.l(stateSetStateRecord.j() + 1);
            } else {
                z2 = false;
            }
        }
        return z2;
    }

    private final boolean f(Function1 function1) {
        int iJ;
        PersistentSet persistentSetK;
        PersistentSet.Builder builder;
        Object objInvoke;
        Snapshot snapshotC;
        boolean zA;
        do {
            synchronized (SnapshotStateSetKt.f25010a) {
                StateRecord stateRecordP = p();
                Intrinsics.checkNotNull(stateRecordP, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateSet.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSet>");
                StateSetStateRecord stateSetStateRecord = (StateSetStateRecord) SnapshotKt.G((StateSetStateRecord) stateRecordP);
                iJ = stateSetStateRecord.j();
                persistentSetK = stateSetStateRecord.k();
                Unit unit = Unit.f139807a;
            }
            if (persistentSetK != null && (builder = persistentSetK.builder()) != null) {
                objInvoke = function1.invoke(builder);
                PersistentSet persistentSetBuild = builder.build();
                if (Intrinsics.areEqual(persistentSetBuild, persistentSetK)) {
                    break;
                }
                StateRecord stateRecordP2 = p();
                Intrinsics.checkNotNull(stateRecordP2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateSet.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSet>");
                StateSetStateRecord stateSetStateRecord2 = (StateSetStateRecord) stateRecordP2;
                synchronized (SnapshotKt.J()) {
                    snapshotC = Snapshot.f24914e.c();
                    zA = a((StateSetStateRecord) SnapshotKt.h0(stateSetStateRecord2, this, snapshotC), iJ, persistentSetBuild);
                }
                SnapshotKt.Q(snapshotC, this);
            } else {
                throw new IllegalStateException("No set to mutate");
            }
        } while (!zA);
        return ((Boolean) objInvoke).booleanValue();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean add(Object obj) {
        int iJ;
        PersistentSet persistentSetK;
        Snapshot snapshotC;
        boolean zA;
        do {
            synchronized (SnapshotStateSetKt.f25010a) {
                StateRecord stateRecordP = p();
                Intrinsics.checkNotNull(stateRecordP, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateSet.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSet>");
                StateSetStateRecord stateSetStateRecord = (StateSetStateRecord) SnapshotKt.G((StateSetStateRecord) stateRecordP);
                iJ = stateSetStateRecord.j();
                persistentSetK = stateSetStateRecord.k();
                Unit unit = Unit.f139807a;
            }
            Intrinsics.checkNotNull(persistentSetK);
            PersistentSet persistentSetAdd = persistentSetK.add(obj);
            if (Intrinsics.areEqual(persistentSetAdd, persistentSetK)) {
                return false;
            }
            StateRecord stateRecordP2 = p();
            Intrinsics.checkNotNull(stateRecordP2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateSet.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSet>");
            StateSetStateRecord stateSetStateRecord2 = (StateSetStateRecord) stateRecordP2;
            synchronized (SnapshotKt.J()) {
                snapshotC = Snapshot.f24914e.c();
                zA = a((StateSetStateRecord) SnapshotKt.h0(stateSetStateRecord2, this, snapshotC), iJ, persistentSetAdd);
            }
            SnapshotKt.Q(snapshotC, this);
        } while (!zA);
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection collection) {
        int iJ;
        PersistentSet persistentSetK;
        Snapshot snapshotC;
        boolean zA;
        do {
            synchronized (SnapshotStateSetKt.f25010a) {
                StateRecord stateRecordP = p();
                Intrinsics.checkNotNull(stateRecordP, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateSet.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSet>");
                StateSetStateRecord stateSetStateRecord = (StateSetStateRecord) SnapshotKt.G((StateSetStateRecord) stateRecordP);
                iJ = stateSetStateRecord.j();
                persistentSetK = stateSetStateRecord.k();
                Unit unit = Unit.f139807a;
            }
            Intrinsics.checkNotNull(persistentSetK);
            PersistentSet persistentSetAddAll = persistentSetK.addAll(collection);
            if (Intrinsics.areEqual(persistentSetAddAll, persistentSetK)) {
                return false;
            }
            StateRecord stateRecordP2 = p();
            Intrinsics.checkNotNull(stateRecordP2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateSet.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSet>");
            StateSetStateRecord stateSetStateRecord2 = (StateSetStateRecord) stateRecordP2;
            synchronized (SnapshotKt.J()) {
                snapshotC = Snapshot.f24914e.c();
                zA = a((StateSetStateRecord) SnapshotKt.h0(stateSetStateRecord2, this, snapshotC), iJ, persistentSetAddAll);
            }
            SnapshotKt.Q(snapshotC, this);
        } while (!zA);
        return true;
    }

    public final int b() {
        StateRecord stateRecordP = p();
        Intrinsics.checkNotNull(stateRecordP, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateSet.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSet>");
        return ((StateSetStateRecord) SnapshotKt.G((StateSetStateRecord) stateRecordP)).j();
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        Snapshot snapshotC;
        StateRecord stateRecordP = p();
        Intrinsics.checkNotNull(stateRecordP, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateSet.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSet>");
        StateSetStateRecord stateSetStateRecord = (StateSetStateRecord) stateRecordP;
        synchronized (SnapshotKt.J()) {
            snapshotC = Snapshot.f24914e.c();
            StateSetStateRecord stateSetStateRecord2 = (StateSetStateRecord) SnapshotKt.h0(stateSetStateRecord, this, snapshotC);
            synchronized (SnapshotStateSetKt.f25010a) {
                stateSetStateRecord2.m(ExtensionsKt.c());
                stateSetStateRecord2.l(stateSetStateRecord2.j() + 1);
            }
        }
        SnapshotKt.Q(snapshotC, this);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object obj) {
        return d().k().contains(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection collection) {
        return d().k().containsAll(collection);
    }

    public final StateSetStateRecord d() {
        StateRecord stateRecordP = p();
        Intrinsics.checkNotNull(stateRecordP, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateSet.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSet>");
        return (StateSetStateRecord) SnapshotKt.X((StateSetStateRecord) stateRecordP, this);
    }

    public int e() {
        return d().k().size();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return d().k().isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return new StateSetIterator(this, d().k().iterator());
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public void n(StateRecord stateRecord) {
        stateRecord.h(p());
        Intrinsics.checkNotNull(stateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateSet.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSet>");
        this.f25006a = (StateSetStateRecord) stateRecord;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public StateRecord p() {
        return this.f25006a;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object obj) {
        int iJ;
        PersistentSet persistentSetK;
        Snapshot snapshotC;
        boolean zA;
        do {
            synchronized (SnapshotStateSetKt.f25010a) {
                StateRecord stateRecordP = p();
                Intrinsics.checkNotNull(stateRecordP, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateSet.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSet>");
                StateSetStateRecord stateSetStateRecord = (StateSetStateRecord) SnapshotKt.G((StateSetStateRecord) stateRecordP);
                iJ = stateSetStateRecord.j();
                persistentSetK = stateSetStateRecord.k();
                Unit unit = Unit.f139807a;
            }
            Intrinsics.checkNotNull(persistentSetK);
            PersistentSet persistentSetRemove = persistentSetK.remove(obj);
            if (Intrinsics.areEqual(persistentSetRemove, persistentSetK)) {
                return false;
            }
            StateRecord stateRecordP2 = p();
            Intrinsics.checkNotNull(stateRecordP2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateSet.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSet>");
            StateSetStateRecord stateSetStateRecord2 = (StateSetStateRecord) stateRecordP2;
            synchronized (SnapshotKt.J()) {
                snapshotC = Snapshot.f24914e.c();
                zA = a((StateSetStateRecord) SnapshotKt.h0(stateSetStateRecord2, this, snapshotC), iJ, persistentSetRemove);
            }
            SnapshotKt.Q(snapshotC, this);
        } while (!zA);
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(final Collection collection) {
        return f(new Function1<Set<T>, Boolean>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateSet.retainAll.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(Set set) {
                return Boolean.valueOf(set.retainAll(CollectionsKt.toSet(collection)));
            }
        });
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ int size() {
        return e();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.a(this);
    }

    public String toString() {
        StateRecord stateRecordP = p();
        Intrinsics.checkNotNull(stateRecordP, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateSet.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSet>");
        return "SnapshotStateSet(value=" + ((StateSetStateRecord) SnapshotKt.G((StateSetStateRecord) stateRecordP)).k() + ")@" + hashCode();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray(Object[] objArr) {
        return CollectionToArray.b(this, objArr);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection collection) {
        int iJ;
        PersistentSet persistentSetK;
        Snapshot snapshotC;
        boolean zA;
        do {
            synchronized (SnapshotStateSetKt.f25010a) {
                StateRecord stateRecordP = p();
                Intrinsics.checkNotNull(stateRecordP, vxrlPPpdv.DcoEOh);
                StateSetStateRecord stateSetStateRecord = (StateSetStateRecord) SnapshotKt.G((StateSetStateRecord) stateRecordP);
                iJ = stateSetStateRecord.j();
                persistentSetK = stateSetStateRecord.k();
                Unit unit = Unit.f139807a;
            }
            Intrinsics.checkNotNull(persistentSetK);
            PersistentSet persistentSetRemoveAll = persistentSetK.removeAll(collection);
            if (Intrinsics.areEqual(persistentSetRemoveAll, persistentSetK)) {
                return false;
            }
            StateRecord stateRecordP2 = p();
            Intrinsics.checkNotNull(stateRecordP2, vxrlPPpdv.DcoEOh);
            StateSetStateRecord stateSetStateRecord2 = (StateSetStateRecord) stateRecordP2;
            synchronized (SnapshotKt.J()) {
                snapshotC = Snapshot.f24914e.c();
                zA = a((StateSetStateRecord) SnapshotKt.h0(stateSetStateRecord2, this, snapshotC), iJ, persistentSetRemoveAll);
            }
            SnapshotKt.Q(snapshotC, this);
        } while (!zA);
        return true;
    }
}
