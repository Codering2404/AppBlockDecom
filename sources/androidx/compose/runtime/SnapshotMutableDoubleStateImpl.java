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
public class SnapshotMutableDoubleStateImpl extends StateObjectImpl implements MutableDoubleState, SnapshotMutableState<Double> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private DoubleStateStateRecord f24226b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class DoubleStateStateRecord extends StateRecord {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private double f24227c;

        public DoubleStateStateRecord(long j3, double d3) {
            super(j3);
            this.f24227c = d3;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public void c(StateRecord stateRecord) {
            Intrinsics.checkNotNull(stateRecord, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableDoubleStateImpl.DoubleStateStateRecord");
            this.f24227c = ((DoubleStateStateRecord) stateRecord).f24227c;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public StateRecord d() {
            return e(g());
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public StateRecord e(long j3) {
            return new DoubleStateStateRecord(j3, this.f24227c);
        }

        public final double j() {
            return this.f24227c;
        }

        public final void k(double d3) {
            this.f24227c = d3;
        }
    }

    public SnapshotMutableDoubleStateImpl(double d3) {
        Snapshot snapshotI = SnapshotKt.I();
        DoubleStateStateRecord doubleStateStateRecord = new DoubleStateStateRecord(snapshotI.i(), d3);
        if (!(snapshotI instanceof GlobalSnapshot)) {
            doubleStateStateRecord.h(new DoubleStateStateRecord(SnapshotId_jvmKt.c(1), d3));
        }
        this.f24226b = doubleStateStateRecord;
    }

    @Override // androidx.compose.runtime.MutableDoubleState, androidx.compose.runtime.DoubleState
    public double e() {
        return ((DoubleStateStateRecord) SnapshotKt.X(this.f24226b, this)).j();
    }

    @Override // androidx.compose.runtime.snapshots.SnapshotMutableState
    public SnapshotMutationPolicy f() {
        return SnapshotStateKt.r();
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public void n(StateRecord stateRecord) {
        Intrinsics.checkNotNull(stateRecord, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableDoubleStateImpl.DoubleStateStateRecord");
        this.f24226b = (DoubleStateStateRecord) stateRecord;
    }

    @Override // androidx.compose.runtime.MutableDoubleState
    public void o(double d3) {
        Snapshot snapshotC;
        DoubleStateStateRecord doubleStateStateRecord = (DoubleStateStateRecord) SnapshotKt.G(this.f24226b);
        if (doubleStateStateRecord.j() == d3) {
            return;
        }
        DoubleStateStateRecord doubleStateStateRecord2 = this.f24226b;
        synchronized (SnapshotKt.J()) {
            snapshotC = Snapshot.f24914e.c();
            ((DoubleStateStateRecord) SnapshotKt.S(doubleStateStateRecord2, this, snapshotC, doubleStateStateRecord)).k(d3);
            Unit unit = Unit.f139807a;
        }
        SnapshotKt.Q(snapshotC, this);
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public StateRecord p() {
        return this.f24226b;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public StateRecord q(StateRecord stateRecord, StateRecord stateRecord2, StateRecord stateRecord3) {
        Intrinsics.checkNotNull(stateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableDoubleStateImpl.DoubleStateStateRecord");
        Intrinsics.checkNotNull(stateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableDoubleStateImpl.DoubleStateStateRecord");
        if (((DoubleStateStateRecord) stateRecord2).j() == ((DoubleStateStateRecord) stateRecord3).j()) {
            return stateRecord2;
        }
        return null;
    }

    public String toString() {
        return "MutableDoubleState(value=" + ((DoubleStateStateRecord) SnapshotKt.G(this.f24226b)).j() + ")@" + hashCode();
    }
}
