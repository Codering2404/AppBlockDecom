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
public class SnapshotMutableFloatStateImpl extends StateObjectImpl implements MutableFloatState, SnapshotMutableState<Float> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private FloatStateStateRecord f24229b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class FloatStateStateRecord extends StateRecord {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f24230c;

        public FloatStateStateRecord(long j3, float f3) {
            super(j3);
            this.f24230c = f3;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public void c(StateRecord stateRecord) {
            Intrinsics.checkNotNull(stateRecord, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableFloatStateImpl.FloatStateStateRecord");
            this.f24230c = ((FloatStateStateRecord) stateRecord).f24230c;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public StateRecord d() {
            return e(SnapshotKt.I().i());
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public StateRecord e(long j3) {
            return new FloatStateStateRecord(j3, this.f24230c);
        }

        public final float j() {
            return this.f24230c;
        }

        public final void k(float f3) {
            this.f24230c = f3;
        }
    }

    public SnapshotMutableFloatStateImpl(float f3) {
        Snapshot snapshotI = SnapshotKt.I();
        FloatStateStateRecord floatStateStateRecord = new FloatStateStateRecord(snapshotI.i(), f3);
        if (!(snapshotI instanceof GlobalSnapshot)) {
            floatStateStateRecord.h(new FloatStateStateRecord(SnapshotId_jvmKt.c(1), f3));
        }
        this.f24229b = floatStateStateRecord;
    }

    @Override // androidx.compose.runtime.MutableFloatState, androidx.compose.runtime.FloatState
    public float c() {
        return ((FloatStateStateRecord) SnapshotKt.X(this.f24229b, this)).j();
    }

    @Override // androidx.compose.runtime.snapshots.SnapshotMutableState
    public SnapshotMutationPolicy f() {
        return SnapshotStateKt.r();
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public void n(StateRecord stateRecord) {
        Intrinsics.checkNotNull(stateRecord, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableFloatStateImpl.FloatStateStateRecord");
        this.f24229b = (FloatStateStateRecord) stateRecord;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public StateRecord p() {
        return this.f24229b;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public StateRecord q(StateRecord stateRecord, StateRecord stateRecord2, StateRecord stateRecord3) {
        Intrinsics.checkNotNull(stateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableFloatStateImpl.FloatStateStateRecord");
        Intrinsics.checkNotNull(stateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableFloatStateImpl.FloatStateStateRecord");
        if (((FloatStateStateRecord) stateRecord2).j() == ((FloatStateStateRecord) stateRecord3).j()) {
            return stateRecord2;
        }
        return null;
    }

    @Override // androidx.compose.runtime.MutableFloatState
    public void s(float f3) {
        Snapshot snapshotC;
        FloatStateStateRecord floatStateStateRecord = (FloatStateStateRecord) SnapshotKt.G(this.f24229b);
        if (floatStateStateRecord.j() == f3) {
            return;
        }
        FloatStateStateRecord floatStateStateRecord2 = this.f24229b;
        synchronized (SnapshotKt.J()) {
            snapshotC = Snapshot.f24914e.c();
            ((FloatStateStateRecord) SnapshotKt.S(floatStateStateRecord2, this, snapshotC, floatStateStateRecord)).k(f3);
            Unit unit = Unit.f139807a;
        }
        SnapshotKt.Q(snapshotC, this);
    }

    public String toString() {
        return "MutableFloatState(value=" + ((FloatStateStateRecord) SnapshotKt.G(this.f24229b)).j() + ")@" + hashCode();
    }
}
