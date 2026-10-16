package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.snapshots.tooling.SnapshotInstanceObservers;
import androidx.compose.runtime.snapshots.tooling.SnapshotObserverKt;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;

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
public final class ReadonlySnapshot extends Snapshot {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Function1 f24912g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f24913h;

    public ReadonlySnapshot(long j3, SnapshotIdSet snapshotIdSet, Function1 function1) {
        super(j3, snapshotIdSet, null);
        this.f24912g = function1;
        this.f24913h = 1;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public Function1 g() {
        return this.f24912g;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void d() {
        if (e()) {
            return;
        }
        n(this);
        super.d();
        SnapshotObserverKt.d(this);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public boolean h() {
        return true;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Function1 k() {
        return null;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void m(Snapshot snapshot) {
        this.f24913h++;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void n(Snapshot snapshot) {
        int i3 = this.f24913h - 1;
        this.f24913h = i3;
        if (i3 == 0) {
            b();
        }
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void p(StateObject stateObject) {
        SnapshotKt.Z();
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Snapshot x(Function1 function1) {
        Map map;
        SnapshotKt.g0(this);
        PersistentList persistentList = SnapshotObserverKt.f25057a;
        if (persistentList != null) {
            Pair pairE = SnapshotObserverKt.e(persistentList, this, true, function1, null);
            SnapshotInstanceObservers snapshotInstanceObservers = (SnapshotInstanceObservers) pairE.e();
            Function1 function1A = snapshotInstanceObservers.a();
            snapshotInstanceObservers.b();
            map = (Map) pairE.f();
            function1 = function1A;
        } else {
            map = null;
        }
        NestedReadonlySnapshot nestedReadonlySnapshot = new NestedReadonlySnapshot(i(), f(), SnapshotKt.L(function1, g(), false, 4, null), this);
        if (persistentList != null) {
            SnapshotObserverKt.b(persistentList, this, nestedReadonlySnapshot, map);
        }
        return nestedReadonlySnapshot;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void o() {
    }
}
