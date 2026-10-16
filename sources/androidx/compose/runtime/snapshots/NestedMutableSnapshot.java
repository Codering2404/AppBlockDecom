package androidx.compose.runtime.snapshots;

import androidx.collection.MutableScatterSet;
import androidx.compose.runtime.snapshots.SnapshotApplyResult;
import androidx.compose.runtime.snapshots.tooling.SnapshotObserverKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
public final class NestedMutableSnapshot extends MutableSnapshot {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final MutableSnapshot f24906s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f24907t;

    public NestedMutableSnapshot(long j3, SnapshotIdSet snapshotIdSet, Function1 function1, Function1 function12, MutableSnapshot mutableSnapshot) {
        super(j3, snapshotIdSet, function1, function12);
        this.f24906s = mutableSnapshot;
        mutableSnapshot.m(this);
    }

    private final void W() {
        if (this.f24907t) {
            return;
        }
        this.f24907t = true;
        this.f24906s.n(this);
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    public SnapshotApplyResult E() throws Throwable {
        NestedMutableSnapshot nestedMutableSnapshot;
        if (this.f24906s.F() || this.f24906s.e()) {
            return new SnapshotApplyResult.Failure(this);
        }
        MutableScatterSet mutableScatterSetG = G();
        long jI = i();
        Map mapR = mutableScatterSetG != null ? SnapshotKt.R(this.f24906s.i(), this, this.f24906s.f()) : null;
        synchronized (SnapshotKt.J()) {
            try {
                SnapshotKt.g0(this);
            } catch (Throwable th) {
                th = th;
            }
            try {
                if (mutableScatterSetG == null || mutableScatterSetG.d() == 0) {
                    nestedMutableSnapshot = this;
                    b();
                } else {
                    nestedMutableSnapshot = this;
                    SnapshotApplyResult snapshotApplyResultL = nestedMutableSnapshot.L(this.f24906s.i(), mutableScatterSetG, mapR, this.f24906s.f());
                    if (!Intrinsics.areEqual(snapshotApplyResultL, SnapshotApplyResult.Success.f24922a)) {
                        return snapshotApplyResultL;
                    }
                    MutableScatterSet mutableScatterSetG2 = nestedMutableSnapshot.f24906s.G();
                    if (mutableScatterSetG2 != null) {
                        mutableScatterSetG2.j(mutableScatterSetG);
                    } else {
                        nestedMutableSnapshot.f24906s.S(mutableScatterSetG);
                        S(null);
                    }
                }
                if (nestedMutableSnapshot.f24906s.i() < jI) {
                    nestedMutableSnapshot.f24906s.D();
                }
                MutableSnapshot mutableSnapshot = nestedMutableSnapshot.f24906s;
                mutableSnapshot.u(mutableSnapshot.f().h(jI).g(H()));
                nestedMutableSnapshot.f24906s.M(jI);
                nestedMutableSnapshot.f24906s.O(y());
                nestedMutableSnapshot.f24906s.N(H());
                nestedMutableSnapshot.f24906s.P(I());
                Unit unit = Unit.f139807a;
                R(true);
                W();
                SnapshotObserverKt.c(this, mutableScatterSetG);
                return SnapshotApplyResult.Success.f24922a;
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public void d() {
        if (e()) {
            return;
        }
        super.d();
        W();
    }
}
