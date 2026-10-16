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
public class SnapshotMutableIntStateImpl extends StateObjectImpl implements MutableIntState, SnapshotMutableState<Integer> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private IntStateStateRecord f24232b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class IntStateStateRecord extends StateRecord {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f24233c;

        public IntStateStateRecord(long j3, int i3) {
            super(j3);
            this.f24233c = i3;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public void c(StateRecord stateRecord) {
            Intrinsics.checkNotNull(stateRecord, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableIntStateImpl.IntStateStateRecord");
            this.f24233c = ((IntStateStateRecord) stateRecord).f24233c;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public StateRecord d() {
            return e(SnapshotKt.I().i());
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public StateRecord e(long j3) {
            return new IntStateStateRecord(j3, this.f24233c);
        }

        public final int j() {
            return this.f24233c;
        }

        public final void k(int i3) {
            this.f24233c = i3;
        }
    }

    public SnapshotMutableIntStateImpl(int i3) {
        Snapshot snapshotI = SnapshotKt.I();
        IntStateStateRecord intStateStateRecord = new IntStateStateRecord(snapshotI.i(), i3);
        if (!(snapshotI instanceof GlobalSnapshot)) {
            intStateStateRecord.h(new IntStateStateRecord(SnapshotId_jvmKt.c(1), i3));
        }
        this.f24232b = intStateStateRecord;
    }

    @Override // androidx.compose.runtime.MutableIntState
    public void a(int i3) {
        Snapshot snapshotC;
        IntStateStateRecord intStateStateRecord = (IntStateStateRecord) SnapshotKt.G(this.f24232b);
        if (intStateStateRecord.j() != i3) {
            IntStateStateRecord intStateStateRecord2 = this.f24232b;
            synchronized (SnapshotKt.J()) {
                snapshotC = Snapshot.f24914e.c();
                ((IntStateStateRecord) SnapshotKt.S(intStateStateRecord2, this, snapshotC, intStateStateRecord)).k(i3);
                Unit unit = Unit.f139807a;
            }
            SnapshotKt.Q(snapshotC, this);
        }
    }

    @Override // androidx.compose.runtime.snapshots.SnapshotMutableState
    public SnapshotMutationPolicy f() {
        return SnapshotStateKt.r();
    }

    @Override // androidx.compose.runtime.MutableIntState, androidx.compose.runtime.IntState
    public int g() {
        return ((IntStateStateRecord) SnapshotKt.X(this.f24232b, this)).j();
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public void n(StateRecord stateRecord) {
        Intrinsics.checkNotNull(stateRecord, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableIntStateImpl.IntStateStateRecord");
        this.f24232b = (IntStateStateRecord) stateRecord;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public StateRecord p() {
        return this.f24232b;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public StateRecord q(StateRecord stateRecord, StateRecord stateRecord2, StateRecord stateRecord3) {
        Intrinsics.checkNotNull(stateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableIntStateImpl.IntStateStateRecord");
        Intrinsics.checkNotNull(stateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableIntStateImpl.IntStateStateRecord");
        if (((IntStateStateRecord) stateRecord2).j() == ((IntStateStateRecord) stateRecord3).j()) {
            return stateRecord2;
        }
        return null;
    }

    public String toString() {
        return "MutableIntState(value=" + ((IntStateStateRecord) SnapshotKt.G(this.f24232b)).j() + ")@" + hashCode();
    }
}
