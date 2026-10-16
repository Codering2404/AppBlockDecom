package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;

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
public final class SnapshotStateList<T> implements StateObject, List<T>, RandomAccess, KMutableList {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private StateRecord f24963a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class StateListStateRecord<T> extends StateRecord {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private PersistentList f24964c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f24965d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f24966e;

        public StateListStateRecord(long j3, PersistentList persistentList) {
            super(j3);
            this.f24964c = persistentList;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public void c(StateRecord stateRecord) {
            synchronized (SnapshotStateListKt.f24970a) {
                Intrinsics.checkNotNull(stateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord>");
                this.f24964c = ((StateListStateRecord) stateRecord).f24964c;
                this.f24965d = ((StateListStateRecord) stateRecord).f24965d;
                this.f24966e = ((StateListStateRecord) stateRecord).f24966e;
                Unit unit = Unit.f139807a;
            }
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public StateRecord d() {
            return e(SnapshotKt.I().i());
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public StateRecord e(long j3) {
            return new StateListStateRecord(j3, this.f24964c);
        }

        public final PersistentList j() {
            return this.f24964c;
        }

        public final int k() {
            return this.f24965d;
        }

        public final int l() {
            return this.f24966e;
        }

        public final void m(PersistentList persistentList) {
            this.f24964c = persistentList;
        }

        public final void n(int i3) {
            this.f24965d = i3;
        }

        public final void o(int i3) {
            this.f24966e = i3;
        }
    }

    public SnapshotStateList(PersistentList persistentList) {
        this.f24963a = s(persistentList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean b(StateListStateRecord stateListStateRecord, int i3, PersistentList persistentList, boolean z2) {
        boolean z3;
        synchronized (SnapshotStateListKt.f24970a) {
            try {
                if (stateListStateRecord.k() == i3) {
                    stateListStateRecord.m(persistentList);
                    z3 = true;
                    if (z2) {
                        stateListStateRecord.o(stateListStateRecord.l() + 1);
                    }
                    stateListStateRecord.n(stateListStateRecord.k() + 1);
                } else {
                    z3 = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z3;
    }

    private final boolean g(Function1 function1) {
        int iK;
        PersistentList persistentListJ;
        Object objInvoke;
        Snapshot snapshotC;
        boolean zB;
        do {
            synchronized (SnapshotStateListKt.f24970a) {
                StateRecord stateRecordP = p();
                Intrinsics.checkNotNull(stateRecordP, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.G((StateListStateRecord) stateRecordP);
                iK = stateListStateRecord.k();
                persistentListJ = stateListStateRecord.j();
                Unit unit = Unit.f139807a;
            }
            Intrinsics.checkNotNull(persistentListJ);
            PersistentList.Builder builder = persistentListJ.builder();
            objInvoke = function1.invoke(builder);
            PersistentList persistentListBuild = builder.build();
            if (Intrinsics.areEqual(persistentListBuild, persistentListJ)) {
                break;
            }
            StateRecord stateRecordP2 = p();
            Intrinsics.checkNotNull(stateRecordP2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) stateRecordP2;
            synchronized (SnapshotKt.J()) {
                snapshotC = Snapshot.f24914e.c();
                zB = b((StateListStateRecord) SnapshotKt.h0(stateListStateRecord2, this, snapshotC), iK, persistentListBuild, true);
            }
            SnapshotKt.Q(snapshotC, this);
        } while (!zB);
        return ((Boolean) objInvoke).booleanValue();
    }

    private final StateRecord s(PersistentList persistentList) {
        Snapshot snapshotI = SnapshotKt.I();
        StateListStateRecord stateListStateRecord = new StateListStateRecord(snapshotI.i(), persistentList);
        if (!(snapshotI instanceof GlobalSnapshot)) {
            stateListStateRecord.h(new StateListStateRecord(SnapshotId_jvmKt.c(1), persistentList));
        }
        return stateListStateRecord;
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(Object obj) {
        int iK;
        PersistentList persistentListJ;
        Snapshot snapshotC;
        boolean zB;
        do {
            synchronized (SnapshotStateListKt.f24970a) {
                StateRecord stateRecordP = p();
                Intrinsics.checkNotNull(stateRecordP, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.G((StateListStateRecord) stateRecordP);
                iK = stateListStateRecord.k();
                persistentListJ = stateListStateRecord.j();
                Unit unit = Unit.f139807a;
            }
            Intrinsics.checkNotNull(persistentListJ);
            PersistentList persistentListAdd = persistentListJ.add(obj);
            if (Intrinsics.areEqual(persistentListAdd, persistentListJ)) {
                return false;
            }
            StateRecord stateRecordP2 = p();
            Intrinsics.checkNotNull(stateRecordP2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) stateRecordP2;
            synchronized (SnapshotKt.J()) {
                snapshotC = Snapshot.f24914e.c();
                zB = b((StateListStateRecord) SnapshotKt.h0(stateListStateRecord2, this, snapshotC), iK, persistentListAdd, true);
            }
            SnapshotKt.Q(snapshotC, this);
        } while (!zB);
        return true;
    }

    @Override // java.util.List
    public boolean addAll(final int i3, final Collection collection) {
        return g(new Function1<List<T>, Boolean>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateList.addAll.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(List list) {
                return Boolean.valueOf(list.addAll(i3, collection));
            }
        });
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        Snapshot snapshotC;
        StateRecord stateRecordP = p();
        Intrinsics.checkNotNull(stateRecordP, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        StateListStateRecord stateListStateRecord = (StateListStateRecord) stateRecordP;
        synchronized (SnapshotKt.J()) {
            snapshotC = Snapshot.f24914e.c();
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.h0(stateListStateRecord, this, snapshotC);
            synchronized (SnapshotStateListKt.f24970a) {
                stateListStateRecord2.m(ExtensionsKt.b());
                stateListStateRecord2.n(stateListStateRecord2.k() + 1);
                stateListStateRecord2.o(stateListStateRecord2.l() + 1);
            }
        }
        SnapshotKt.Q(snapshotC, this);
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return d().j().contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection collection) {
        return d().j().containsAll(collection);
    }

    public final StateListStateRecord d() {
        StateRecord stateRecordP = p();
        Intrinsics.checkNotNull(stateRecordP, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return (StateListStateRecord) SnapshotKt.X((StateListStateRecord) stateRecordP, this);
    }

    public int e() {
        return d().j().size();
    }

    public final int f() {
        StateRecord stateRecordP = p();
        Intrinsics.checkNotNull(stateRecordP, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return ((StateListStateRecord) SnapshotKt.G((StateListStateRecord) stateRecordP)).l();
    }

    @Override // java.util.List
    public Object get(int i3) {
        return d().j().get(i3);
    }

    public Object h(int i3) {
        int iK;
        PersistentList persistentListJ;
        Snapshot snapshotC;
        boolean zB;
        Object obj = get(i3);
        do {
            synchronized (SnapshotStateListKt.f24970a) {
                StateRecord stateRecordP = p();
                Intrinsics.checkNotNull(stateRecordP, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.G((StateListStateRecord) stateRecordP);
                iK = stateListStateRecord.k();
                persistentListJ = stateListStateRecord.j();
                Unit unit = Unit.f139807a;
            }
            Intrinsics.checkNotNull(persistentListJ);
            PersistentList persistentListQ0 = persistentListJ.q0(i3);
            if (Intrinsics.areEqual(persistentListQ0, persistentListJ)) {
                return obj;
            }
            StateRecord stateRecordP2 = p();
            Intrinsics.checkNotNull(stateRecordP2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) stateRecordP2;
            synchronized (SnapshotKt.J()) {
                snapshotC = Snapshot.f24914e.c();
                zB = b((StateListStateRecord) SnapshotKt.h0(stateListStateRecord2, this, snapshotC), iK, persistentListQ0, true);
            }
            SnapshotKt.Q(snapshotC, this);
        } while (!zB);
        return obj;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return d().j().indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return d().j().isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return listIterator();
    }

    public final void l(int i3, int i4) {
        int iK;
        PersistentList persistentListJ;
        Snapshot snapshotC;
        boolean zB;
        do {
            synchronized (SnapshotStateListKt.f24970a) {
                StateRecord stateRecordP = p();
                Intrinsics.checkNotNull(stateRecordP, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.G((StateListStateRecord) stateRecordP);
                iK = stateListStateRecord.k();
                persistentListJ = stateListStateRecord.j();
                Unit unit = Unit.f139807a;
            }
            Intrinsics.checkNotNull(persistentListJ);
            PersistentList.Builder builder = persistentListJ.builder();
            builder.subList(i3, i4).clear();
            PersistentList persistentListBuild = builder.build();
            if (Intrinsics.areEqual(persistentListBuild, persistentListJ)) {
                return;
            }
            StateRecord stateRecordP2 = p();
            Intrinsics.checkNotNull(stateRecordP2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) stateRecordP2;
            synchronized (SnapshotKt.J()) {
                snapshotC = Snapshot.f24914e.c();
                zB = b((StateListStateRecord) SnapshotKt.h0(stateListStateRecord2, this, snapshotC), iK, persistentListBuild, true);
            }
            SnapshotKt.Q(snapshotC, this);
        } while (!zB);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return d().j().lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator listIterator() {
        return new StateListIterator(this, 0);
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public void n(StateRecord stateRecord) {
        stateRecord.h(p());
        Intrinsics.checkNotNull(stateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        this.f24963a = (StateListStateRecord) stateRecord;
    }

    public final int o(Collection collection, int i3, int i4) {
        int iK;
        PersistentList persistentListJ;
        Snapshot snapshotC;
        boolean zB;
        int size = size();
        do {
            synchronized (SnapshotStateListKt.f24970a) {
                StateRecord stateRecordP = p();
                Intrinsics.checkNotNull(stateRecordP, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.G((StateListStateRecord) stateRecordP);
                iK = stateListStateRecord.k();
                persistentListJ = stateListStateRecord.j();
                Unit unit = Unit.f139807a;
            }
            Intrinsics.checkNotNull(persistentListJ);
            PersistentList.Builder builder = persistentListJ.builder();
            builder.subList(i3, i4).retainAll(collection);
            PersistentList persistentListBuild = builder.build();
            if (Intrinsics.areEqual(persistentListBuild, persistentListJ)) {
                break;
            }
            StateRecord stateRecordP2 = p();
            Intrinsics.checkNotNull(stateRecordP2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) stateRecordP2;
            synchronized (SnapshotKt.J()) {
                snapshotC = Snapshot.f24914e.c();
                zB = b((StateListStateRecord) SnapshotKt.h0(stateListStateRecord2, this, snapshotC), iK, persistentListBuild, true);
            }
            SnapshotKt.Q(snapshotC, this);
        } while (!zB);
        return size - size();
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public StateRecord p() {
        return this.f24963a;
    }

    @Override // java.util.List
    public final /* bridge */ Object remove(int i3) {
        return h(i3);
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection collection) {
        int iK;
        PersistentList persistentListJ;
        Snapshot snapshotC;
        boolean zB;
        do {
            synchronized (SnapshotStateListKt.f24970a) {
                StateRecord stateRecordP = p();
                Intrinsics.checkNotNull(stateRecordP, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.G((StateListStateRecord) stateRecordP);
                iK = stateListStateRecord.k();
                persistentListJ = stateListStateRecord.j();
                Unit unit = Unit.f139807a;
            }
            Intrinsics.checkNotNull(persistentListJ);
            PersistentList persistentListRemoveAll = persistentListJ.removeAll(collection);
            if (Intrinsics.areEqual(persistentListRemoveAll, persistentListJ)) {
                return false;
            }
            StateRecord stateRecordP2 = p();
            Intrinsics.checkNotNull(stateRecordP2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) stateRecordP2;
            synchronized (SnapshotKt.J()) {
                snapshotC = Snapshot.f24914e.c();
                zB = b((StateListStateRecord) SnapshotKt.h0(stateListStateRecord2, this, snapshotC), iK, persistentListRemoveAll, true);
            }
            SnapshotKt.Q(snapshotC, this);
        } while (!zB);
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(final Collection collection) {
        return g(new Function1<List<T>, Boolean>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateList.retainAll.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(List list) {
                return Boolean.valueOf(list.retainAll(collection));
            }
        });
    }

    @Override // java.util.List
    public Object set(int i3, Object obj) {
        int iK;
        PersistentList persistentListJ;
        Snapshot snapshotC;
        boolean zB;
        Object obj2 = get(i3);
        do {
            synchronized (SnapshotStateListKt.f24970a) {
                StateRecord stateRecordP = p();
                Intrinsics.checkNotNull(stateRecordP, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.G((StateListStateRecord) stateRecordP);
                iK = stateListStateRecord.k();
                persistentListJ = stateListStateRecord.j();
                Unit unit = Unit.f139807a;
            }
            Intrinsics.checkNotNull(persistentListJ);
            PersistentList persistentList = persistentListJ.set(i3, obj);
            if (Intrinsics.areEqual(persistentList, persistentListJ)) {
                return obj2;
            }
            StateRecord stateRecordP2 = p();
            Intrinsics.checkNotNull(stateRecordP2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) stateRecordP2;
            synchronized (SnapshotKt.J()) {
                snapshotC = Snapshot.f24914e.c();
                zB = b((StateListStateRecord) SnapshotKt.h0(stateListStateRecord2, this, snapshotC), iK, persistentList, false);
            }
            SnapshotKt.Q(snapshotC, this);
        } while (!zB);
        return obj2;
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return e();
    }

    @Override // java.util.List
    public List subList(int i3, int i4) {
        if (!(i3 >= 0 && i3 <= i4 && i4 <= size())) {
            PreconditionsKt.a("fromIndex or toIndex are out of bounds");
        }
        return new SubList(this, i3, i4);
    }

    public final List t() {
        return d().j();
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.a(this);
    }

    public String toString() {
        StateRecord stateRecordP = p();
        Intrinsics.checkNotNull(stateRecordP, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return "SnapshotStateList(value=" + ((StateListStateRecord) SnapshotKt.G((StateListStateRecord) stateRecordP)).j() + ")@" + hashCode();
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection collection) {
        int iK;
        PersistentList persistentListJ;
        Snapshot snapshotC;
        boolean zB;
        do {
            synchronized (SnapshotStateListKt.f24970a) {
                StateRecord stateRecordP = p();
                Intrinsics.checkNotNull(stateRecordP, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.G((StateListStateRecord) stateRecordP);
                iK = stateListStateRecord.k();
                persistentListJ = stateListStateRecord.j();
                Unit unit = Unit.f139807a;
            }
            Intrinsics.checkNotNull(persistentListJ);
            PersistentList persistentListAddAll = persistentListJ.addAll(collection);
            if (Intrinsics.areEqual(persistentListAddAll, persistentListJ)) {
                return false;
            }
            StateRecord stateRecordP2 = p();
            Intrinsics.checkNotNull(stateRecordP2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) stateRecordP2;
            synchronized (SnapshotKt.J()) {
                snapshotC = Snapshot.f24914e.c();
                zB = b((StateListStateRecord) SnapshotKt.h0(stateListStateRecord2, this, snapshotC), iK, persistentListAddAll, true);
            }
            SnapshotKt.Q(snapshotC, this);
        } while (!zB);
        return true;
    }

    @Override // java.util.List
    public ListIterator listIterator(int i3) {
        return new StateListIterator(this, i3);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        int iK;
        PersistentList persistentListJ;
        Snapshot snapshotC;
        boolean zB;
        do {
            synchronized (SnapshotStateListKt.f24970a) {
                StateRecord stateRecordP = p();
                Intrinsics.checkNotNull(stateRecordP, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.G((StateListStateRecord) stateRecordP);
                iK = stateListStateRecord.k();
                persistentListJ = stateListStateRecord.j();
                Unit unit = Unit.f139807a;
            }
            Intrinsics.checkNotNull(persistentListJ);
            PersistentList persistentListRemove = persistentListJ.remove(obj);
            if (Intrinsics.areEqual(persistentListRemove, persistentListJ)) {
                return false;
            }
            StateRecord stateRecordP2 = p();
            Intrinsics.checkNotNull(stateRecordP2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) stateRecordP2;
            synchronized (SnapshotKt.J()) {
                snapshotC = Snapshot.f24914e.c();
                zB = b((StateListStateRecord) SnapshotKt.h0(stateListStateRecord2, this, snapshotC), iK, persistentListRemove, true);
            }
            SnapshotKt.Q(snapshotC, this);
        } while (!zB);
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray(Object[] objArr) {
        return CollectionToArray.b(this, objArr);
    }

    public SnapshotStateList() {
        this(ExtensionsKt.b());
    }

    @Override // java.util.List
    public void add(int i3, Object obj) {
        int iK;
        PersistentList persistentListJ;
        Snapshot snapshotC;
        boolean zB;
        do {
            synchronized (SnapshotStateListKt.f24970a) {
                StateRecord stateRecordP = p();
                Intrinsics.checkNotNull(stateRecordP, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.G((StateListStateRecord) stateRecordP);
                iK = stateListStateRecord.k();
                persistentListJ = stateListStateRecord.j();
                Unit unit = Unit.f139807a;
            }
            Intrinsics.checkNotNull(persistentListJ);
            PersistentList persistentListAdd = persistentListJ.add(i3, obj);
            if (Intrinsics.areEqual(persistentListAdd, persistentListJ)) {
                return;
            }
            StateRecord stateRecordP2 = p();
            Intrinsics.checkNotNull(stateRecordP2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) stateRecordP2;
            synchronized (SnapshotKt.J()) {
                snapshotC = Snapshot.f24914e.c();
                zB = b((StateListStateRecord) SnapshotKt.h0(stateListStateRecord2, this, snapshotC), iK, persistentListAdd, true);
            }
            SnapshotKt.Q(snapshotC, this);
        } while (!zB);
    }
}
