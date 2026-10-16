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
public class SnapshotMutableLongStateImpl extends StateObjectImpl implements MutableLongState, SnapshotMutableState<Long> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LongStateStateRecord f24235b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class LongStateStateRecord extends StateRecord {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f24236c;

        public LongStateStateRecord(long j3, long j4) {
            super(j3);
            this.f24236c = j4;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public void c(StateRecord stateRecord) {
            Intrinsics.checkNotNull(stateRecord, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableLongStateImpl.LongStateStateRecord");
            this.f24236c = ((LongStateStateRecord) stateRecord).f24236c;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public StateRecord d() {
            return e(SnapshotKt.I().i());
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public StateRecord e(long j3) {
            return new LongStateStateRecord(j3, this.f24236c);
        }

        public final long j() {
            return this.f24236c;
        }

        public final void k(long j3) {
            this.f24236c = j3;
        }
    }

    public SnapshotMutableLongStateImpl(long j3) {
        Snapshot snapshotI = SnapshotKt.I();
        LongStateStateRecord longStateStateRecord = new LongStateStateRecord(snapshotI.i(), j3);
        if (!(snapshotI instanceof GlobalSnapshot)) {
            longStateStateRecord.h(new LongStateStateRecord(SnapshotId_jvmKt.c(1), j3));
        }
        this.f24235b = longStateStateRecord;
    }

    @Override // androidx.compose.runtime.MutableLongState, androidx.compose.runtime.LongState
    public long d() {
        return ((LongStateStateRecord) SnapshotKt.X(this.f24235b, this)).j();
    }

    @Override // androidx.compose.runtime.snapshots.SnapshotMutableState
    public SnapshotMutationPolicy f() {
        return SnapshotStateKt.r();
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public void n(StateRecord stateRecord) {
        Intrinsics.checkNotNull(stateRecord, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableLongStateImpl.LongStateStateRecord");
        this.f24235b = (LongStateStateRecord) stateRecord;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public StateRecord p() {
        return this.f24235b;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public StateRecord q(StateRecord stateRecord, StateRecord stateRecord2, StateRecord stateRecord3) {
        Intrinsics.checkNotNull(stateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableLongStateImpl.LongStateStateRecord");
        Intrinsics.checkNotNull(stateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableLongStateImpl.LongStateStateRecord");
        if (((LongStateStateRecord) stateRecord2).j() == ((LongStateStateRecord) stateRecord3).j()) {
            return stateRecord2;
        }
        return null;
    }

    @Override // androidx.compose.runtime.MutableLongState
    public void t(long j3) {
        Snapshot snapshotC;
        LongStateStateRecord longStateStateRecord = (LongStateStateRecord) SnapshotKt.G(this.f24235b);
        if (longStateStateRecord.j() != j3) {
            LongStateStateRecord longStateStateRecord2 = this.f24235b;
            synchronized (SnapshotKt.J()) {
                snapshotC = Snapshot.f24914e.c();
                ((LongStateStateRecord) SnapshotKt.S(longStateStateRecord2, this, snapshotC, longStateStateRecord)).k(j3);
                Unit unit = Unit.f139807a;
            }
            SnapshotKt.Q(snapshotC, this);
        }
    }

    public String toString() {
        return "MutableLongState(value=" + ((LongStateStateRecord) SnapshotKt.G(this.f24235b)).j() + ")@" + hashCode();
    }
}
