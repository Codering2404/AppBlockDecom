package androidx.compose.runtime.snapshots;

import androidx.collection.MutableScatterSet;
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
public final class TransparentObserverMutableSnapshot extends MutableSnapshot {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final MutableSnapshot f25040s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final boolean f25041t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final boolean f25042u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Function1 f25043v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Function1 f25044w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final long f25045x;

    public TransparentObserverMutableSnapshot(MutableSnapshot mutableSnapshot, Function1 function1, Function1 function12, boolean z2, boolean z3) {
        Function1 function1K;
        Function1 function1G;
        super(SnapshotKt.f24944b, SnapshotIdSet.f24931f.a(), SnapshotKt.K(function1, (mutableSnapshot == null || (function1G = mutableSnapshot.g()) == null) ? SnapshotKt.f24953k.g() : function1G, z2), SnapshotKt.M(function12, (mutableSnapshot == null || (function1K = mutableSnapshot.k()) == null) ? SnapshotKt.f24953k.k() : function1K));
        this.f25040s = mutableSnapshot;
        this.f25041t = z2;
        this.f25042u = z3;
        this.f25043v = super.g();
        this.f25044w = super.k();
        this.f25045x = Thread_jvmKt.a();
    }

    private final MutableSnapshot W() {
        MutableSnapshot mutableSnapshot = this.f25040s;
        return mutableSnapshot == null ? SnapshotKt.f24953k : mutableSnapshot;
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    public SnapshotApplyResult E() {
        return W().E();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    public MutableScatterSet G() {
        return W().G();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public Function1 g() {
        return this.f25043v;
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    public void S(MutableScatterSet mutableScatterSet) {
        SnapshotStateMapKt.b();
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    public MutableSnapshot T(Function1 function1, Function1 function12) {
        Function1 function1L = SnapshotKt.L(function1, g(), false, 4, null);
        Function1 function1M = SnapshotKt.M(function12, k());
        return !this.f25041t ? new TransparentObserverMutableSnapshot(W().T(null, function1M), function1L, function1M, false, true) : W().T(function1L, function1M);
    }

    public final long X() {
        return this.f25045x;
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    /* JADX INFO: renamed from: Y, reason: merged with bridge method [inline-methods] */
    public Void m(Snapshot snapshot) {
        SnapshotStateMapKt.b();
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
    public Void n(Snapshot snapshot) {
        SnapshotStateMapKt.b();
        throw new KotlinNothingValueException();
    }

    public void a0(Function1 function1) {
        this.f25043v = function1;
    }

    public void b0(Function1 function1) {
        this.f25044w = function1;
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public void d() {
        MutableSnapshot mutableSnapshot;
        t(true);
        if (!this.f25042u || (mutableSnapshot = this.f25040s) == null) {
            return;
        }
        mutableSnapshot.d();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public SnapshotIdSet f() {
        return W().f();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public boolean h() {
        return W().h();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public long i() {
        return W().i();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public int j() {
        return W().j();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public Function1 k() {
        return this.f25044w;
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public void o() {
        W().o();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public void p(StateObject stateObject) {
        W().p(stateObject);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void u(SnapshotIdSet snapshotIdSet) {
        SnapshotStateMapKt.b();
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void v(long j3) {
        SnapshotStateMapKt.b();
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public void w(int i3) {
        W().w(i3);
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public Snapshot x(Function1 function1) {
        Function1 function1L = SnapshotKt.L(function1, g(), false, 4, null);
        return !this.f25041t ? SnapshotKt.E(W().x(null), function1L, true) : W().x(function1L);
    }
}
