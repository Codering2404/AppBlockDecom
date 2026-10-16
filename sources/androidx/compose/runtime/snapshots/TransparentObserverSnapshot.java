package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.internal.Thread_jvmKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
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
public final class TransparentObserverSnapshot extends Snapshot {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Snapshot f25046g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f25047h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f25048i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Function1 f25049j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Function1 f25050k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final long f25051l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Snapshot f25052m;

    public TransparentObserverSnapshot(Snapshot snapshot, Function1 function1, boolean z2, boolean z3) {
        Function1 function1G;
        super(SnapshotKt.f24944b, SnapshotIdSet.f24931f.a(), null);
        this.f25046g = snapshot;
        this.f25047h = z2;
        this.f25048i = z3;
        this.f25049j = SnapshotKt.K(function1, (snapshot == null || (function1G = snapshot.g()) == null) ? SnapshotKt.f24953k.g() : function1G, z2);
        this.f25051l = Thread_jvmKt.a();
        this.f25052m = this;
    }

    private final Snapshot C() {
        Snapshot snapshot = this.f25046g;
        return snapshot == null ? SnapshotKt.f24953k : snapshot;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public Function1 g() {
        return this.f25049j;
    }

    public final long E() {
        return this.f25051l;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public Void m(Snapshot snapshot) {
        SnapshotStateMapKt.b();
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public Void n(Snapshot snapshot) {
        SnapshotStateMapKt.b();
        throw new KotlinNothingValueException();
    }

    public void H(Function1 function1) {
        this.f25049j = function1;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void d() {
        Snapshot snapshot;
        t(true);
        if (!this.f25048i || (snapshot = this.f25046g) == null) {
            return;
        }
        snapshot.d();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public SnapshotIdSet f() {
        return C().f();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public boolean h() {
        return C().h();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public long i() {
        return C().i();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Function1 k() {
        return this.f25050k;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void o() {
        C().o();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void p(StateObject stateObject) {
        C().p(stateObject);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Snapshot x(Function1 function1) {
        Function1 function1L = SnapshotKt.L(function1, g(), false, 4, null);
        return !this.f25047h ? SnapshotKt.E(C().x(null), function1L, true) : C().x(function1L);
    }
}
