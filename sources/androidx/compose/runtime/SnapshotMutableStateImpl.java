package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.GlobalSnapshot;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotId_jvmKt;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import androidx.compose.runtime.snapshots.StateRecord;
import kotlin.Metadata;
import kotlin.Unit;
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
public class SnapshotMutableStateImpl<T> extends StateObjectImpl implements SnapshotMutableState<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SnapshotMutationPolicy f24238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private StateStateRecord f24239c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class StateStateRecord<T> extends StateRecord {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Object f24240c;

        public StateStateRecord(long j3, Object obj) {
            super(j3);
            this.f24240c = obj;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public void c(StateRecord stateRecord) {
            Intrinsics.checkNotNull(stateRecord, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableStateImpl.StateStateRecord<T of androidx.compose.runtime.SnapshotMutableStateImpl.StateStateRecord>");
            this.f24240c = ((StateStateRecord) stateRecord).f24240c;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public StateStateRecord d() {
            return new StateStateRecord(SnapshotKt.I().i(), this.f24240c);
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public StateStateRecord e(long j3) {
            return new StateStateRecord(SnapshotKt.I().i(), this.f24240c);
        }

        public final Object l() {
            return this.f24240c;
        }

        public final void m(Object obj) {
            this.f24240c = obj;
        }
    }

    public SnapshotMutableStateImpl(Object obj, SnapshotMutationPolicy snapshotMutationPolicy) {
        this.f24238b = snapshotMutationPolicy;
        Snapshot snapshotI = SnapshotKt.I();
        StateStateRecord stateStateRecord = new StateStateRecord(snapshotI.i(), obj);
        if (!(snapshotI instanceof GlobalSnapshot)) {
            stateStateRecord.h(new StateStateRecord(SnapshotId_jvmKt.c(1), obj));
        }
        this.f24239c = stateStateRecord;
    }

    @Override // androidx.compose.runtime.snapshots.SnapshotMutableState
    public SnapshotMutationPolicy f() {
        return this.f24238b;
    }

    @Override // androidx.compose.runtime.MutableState, androidx.compose.runtime.State
    public Object getValue() {
        return ((StateStateRecord) SnapshotKt.X(this.f24239c, this)).l();
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public void n(StateRecord stateRecord) {
        Intrinsics.checkNotNull(stateRecord, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableStateImpl.StateStateRecord<T of androidx.compose.runtime.SnapshotMutableStateImpl>");
        this.f24239c = (StateStateRecord) stateRecord;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public StateRecord p() {
        return this.f24239c;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public StateRecord q(StateRecord stateRecord, StateRecord stateRecord2, StateRecord stateRecord3) {
        Intrinsics.checkNotNull(stateRecord, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableStateImpl.StateStateRecord<T of androidx.compose.runtime.SnapshotMutableStateImpl>");
        StateStateRecord stateStateRecord = (StateStateRecord) stateRecord;
        Intrinsics.checkNotNull(stateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableStateImpl.StateStateRecord<T of androidx.compose.runtime.SnapshotMutableStateImpl>");
        StateStateRecord stateStateRecord2 = (StateStateRecord) stateRecord2;
        Intrinsics.checkNotNull(stateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableStateImpl.StateStateRecord<T of androidx.compose.runtime.SnapshotMutableStateImpl>");
        StateStateRecord stateStateRecord3 = (StateStateRecord) stateRecord3;
        if (f().b(stateStateRecord2.l(), stateStateRecord3.l())) {
            return stateRecord2;
        }
        Object objA = f().a(stateStateRecord.l(), stateStateRecord2.l(), stateStateRecord3.l());
        if (objA == null) {
            return null;
        }
        StateStateRecord stateStateRecordE = stateStateRecord3.e(stateStateRecord3.g());
        stateStateRecordE.m(objA);
        return stateStateRecordE;
    }

    @Override // androidx.compose.runtime.MutableState
    public void setValue(Object obj) {
        Snapshot snapshotC;
        StateStateRecord stateStateRecord = (StateStateRecord) SnapshotKt.G(this.f24239c);
        if (f().b(stateStateRecord.l(), obj)) {
            return;
        }
        StateStateRecord stateStateRecord2 = this.f24239c;
        synchronized (SnapshotKt.J()) {
            snapshotC = Snapshot.f24914e.c();
            ((StateStateRecord) SnapshotKt.S(stateStateRecord2, this, snapshotC, stateStateRecord)).m(obj);
            Unit unit = Unit.f139807a;
        }
        SnapshotKt.Q(snapshotC, this);
    }

    public String toString() {
        return "MutableState(value=" + ((StateStateRecord) SnapshotKt.G(this.f24239c)).l() + ")@" + hashCode();
    }
}
