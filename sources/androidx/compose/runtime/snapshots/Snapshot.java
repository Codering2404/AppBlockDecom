package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.runtime.snapshots.Snapshot;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public abstract class Snapshot {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f24914e = new Companion(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f24915f = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SnapshotIdSet f24916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f24917b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f24918c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f24919d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Object h(Companion companion, Function1 function1, Function1 function12, Function0 function0, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                function1 = null;
            }
            if ((i3 & 2) != 0) {
                function12 = null;
            }
            return companion.g(function1, function12, function0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void j(Function2 function2) {
            synchronized (SnapshotKt.J()) {
                SnapshotKt.f24951i = CollectionsKt.minus(SnapshotKt.f24951i, function2);
                Unit unit = Unit.f139807a;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void l(Function1 function1) {
            synchronized (SnapshotKt.J()) {
                SnapshotKt.f24952j = CollectionsKt.minus(SnapshotKt.f24952j, function1);
                Unit unit = Unit.f139807a;
            }
            SnapshotKt.C();
        }

        public static /* synthetic */ MutableSnapshot p(Companion companion, Function1 function1, Function1 function12, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                function1 = null;
            }
            if ((i3 & 2) != 0) {
                function12 = null;
            }
            return companion.o(function1, function12);
        }

        public final Snapshot c() {
            return SnapshotKt.I();
        }

        public final Snapshot d() {
            return (Snapshot) SnapshotKt.f24945c.a();
        }

        public final Snapshot e(Snapshot snapshot) {
            if (snapshot instanceof TransparentObserverMutableSnapshot) {
                TransparentObserverMutableSnapshot transparentObserverMutableSnapshot = (TransparentObserverMutableSnapshot) snapshot;
                if (transparentObserverMutableSnapshot.X() == Thread_jvmKt.a()) {
                    transparentObserverMutableSnapshot.a0(null);
                    return snapshot;
                }
            }
            if (snapshot instanceof TransparentObserverSnapshot) {
                TransparentObserverSnapshot transparentObserverSnapshot = (TransparentObserverSnapshot) snapshot;
                if (transparentObserverSnapshot.E() == Thread_jvmKt.a()) {
                    transparentObserverSnapshot.H(null);
                    return snapshot;
                }
            }
            Snapshot snapshotF = SnapshotKt.F(snapshot, null, false, 6, null);
            snapshotF.l();
            return snapshotF;
        }

        public final void f() {
            SnapshotKt.I().o();
        }

        public final Object g(Function1 function1, Function1 function12, Function0 function0) {
            Snapshot transparentObserverMutableSnapshot;
            if (function1 == null && function12 == null) {
                return function0.invoke();
            }
            Snapshot snapshot = (Snapshot) SnapshotKt.f24945c.a();
            if (snapshot instanceof TransparentObserverMutableSnapshot) {
                TransparentObserverMutableSnapshot transparentObserverMutableSnapshot2 = (TransparentObserverMutableSnapshot) snapshot;
                if (transparentObserverMutableSnapshot2.X() == Thread_jvmKt.a()) {
                    Function1 function1J = transparentObserverMutableSnapshot2.g();
                    Function1 function1K = transparentObserverMutableSnapshot2.k();
                    try {
                        ((TransparentObserverMutableSnapshot) snapshot).a0(SnapshotKt.L(function1, function1J, false, 4, null));
                        ((TransparentObserverMutableSnapshot) snapshot).b0(SnapshotKt.M(function12, function1K));
                        return function0.invoke();
                    } finally {
                        transparentObserverMutableSnapshot2.a0(function1J);
                        transparentObserverMutableSnapshot2.b0(function1K);
                    }
                }
            }
            if (snapshot == null || (snapshot instanceof MutableSnapshot)) {
                transparentObserverMutableSnapshot = new TransparentObserverMutableSnapshot(snapshot instanceof MutableSnapshot ? (MutableSnapshot) snapshot : null, function1, function12, true, false);
            } else {
                if (function1 == null) {
                    return function0.invoke();
                }
                transparentObserverMutableSnapshot = snapshot.x(function1);
            }
            try {
                Snapshot snapshotL = transparentObserverMutableSnapshot.l();
                try {
                    Object objInvoke = function0.invoke();
                    transparentObserverMutableSnapshot.s(snapshotL);
                    transparentObserverMutableSnapshot.d();
                    return objInvoke;
                } catch (Throwable th) {
                    transparentObserverMutableSnapshot.s(snapshotL);
                    throw th;
                }
            } catch (Throwable th2) {
                transparentObserverMutableSnapshot.d();
                throw th2;
            }
        }

        public final ObserverHandle i(final Function2 function2) {
            SnapshotKt.B(SnapshotKt.f24943a);
            synchronized (SnapshotKt.J()) {
                SnapshotKt.f24951i = CollectionsKt.plus((Collection<? extends Function2>) SnapshotKt.f24951i, function2);
                Unit unit = Unit.f139807a;
            }
            return new ObserverHandle() { // from class: androidx.compose.runtime.snapshots.a
                @Override // androidx.compose.runtime.snapshots.ObserverHandle
                public final void dispose() {
                    Snapshot.Companion.j(function2);
                }
            };
        }

        public final ObserverHandle k(final Function1 function1) {
            synchronized (SnapshotKt.J()) {
                SnapshotKt.f24952j = CollectionsKt.plus((Collection<? extends Function1>) SnapshotKt.f24952j, function1);
                Unit unit = Unit.f139807a;
            }
            SnapshotKt.C();
            return new ObserverHandle() { // from class: androidx.compose.runtime.snapshots.b
                @Override // androidx.compose.runtime.snapshots.ObserverHandle
                public final void dispose() {
                    Snapshot.Companion.l(function1);
                }
            };
        }

        public final void m(Snapshot snapshot, Snapshot snapshot2, Function1 function1) {
            if (snapshot != snapshot2) {
                snapshot2.s(snapshot);
                snapshot2.d();
            } else if (snapshot instanceof TransparentObserverMutableSnapshot) {
                ((TransparentObserverMutableSnapshot) snapshot).a0(function1);
            } else {
                if (snapshot instanceof TransparentObserverSnapshot) {
                    ((TransparentObserverSnapshot) snapshot).H(function1);
                    return;
                }
                throw new IllegalStateException(("Non-transparent snapshot was reused: " + snapshot).toString());
            }
        }

        public final void n() {
            boolean zK;
            synchronized (SnapshotKt.J()) {
                zK = SnapshotKt.f24953k.K();
            }
            if (zK) {
                SnapshotKt.C();
            }
        }

        public final MutableSnapshot o(Function1 function1, Function1 function12) {
            MutableSnapshot mutableSnapshotT;
            Snapshot snapshotI = SnapshotKt.I();
            MutableSnapshot mutableSnapshot = snapshotI instanceof MutableSnapshot ? (MutableSnapshot) snapshotI : null;
            if (mutableSnapshot == null || (mutableSnapshotT = mutableSnapshot.T(function1, function12)) == null) {
                throw new IllegalStateException("Cannot create a mutable snapshot of an read-only snapshot");
            }
            return mutableSnapshotT;
        }

        public final Snapshot q(Function1 function1) {
            return SnapshotKt.I().x(function1);
        }

        private Companion() {
        }
    }

    public /* synthetic */ Snapshot(long j3, SnapshotIdSet snapshotIdSet, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, snapshotIdSet);
    }

    public final void A(Snapshot snapshot) {
        if (!(SnapshotKt.f24945c.a() == this)) {
            PreconditionsKt.b("Cannot leave snapshot; " + this + " is not the current snapshot");
        }
        s(snapshot);
    }

    public final void B() {
        if (this.f24918c) {
            PreconditionsKt.a("Cannot use a disposed snapshot");
        }
    }

    public final void b() {
        synchronized (SnapshotKt.J()) {
            c();
            r();
            Unit unit = Unit.f139807a;
        }
    }

    public void c() {
        SnapshotKt.f24947e = SnapshotKt.f24947e.h(i());
    }

    public void d() {
        this.f24918c = true;
        synchronized (SnapshotKt.J()) {
            q();
            Unit unit = Unit.f139807a;
        }
    }

    public final boolean e() {
        return this.f24918c;
    }

    public SnapshotIdSet f() {
        return this.f24916a;
    }

    public abstract Function1 g();

    public abstract boolean h();

    public long i() {
        return this.f24917b;
    }

    public int j() {
        return 0;
    }

    public abstract Function1 k();

    public Snapshot l() {
        Snapshot snapshot = (Snapshot) SnapshotKt.f24945c.a();
        SnapshotKt.f24945c.b(this);
        return snapshot;
    }

    public abstract void m(Snapshot snapshot);

    public abstract void n(Snapshot snapshot);

    public abstract void o();

    public abstract void p(StateObject stateObject);

    public final void q() {
        int i3 = this.f24919d;
        if (i3 >= 0) {
            SnapshotKt.Y(i3);
            this.f24919d = -1;
        }
    }

    public void r() {
        q();
    }

    public void s(Snapshot snapshot) {
        SnapshotKt.f24945c.b(snapshot);
    }

    public final void t(boolean z2) {
        this.f24918c = z2;
    }

    public void u(SnapshotIdSet snapshotIdSet) {
        this.f24916a = snapshotIdSet;
    }

    public void v(long j3) {
        this.f24917b = j3;
    }

    public void w(int i3) {
        throw new IllegalStateException("Updating write count is not supported for this snapshot");
    }

    public abstract Snapshot x(Function1 function1);

    public final int y() {
        int i3 = this.f24919d;
        this.f24919d = -1;
        return i3;
    }

    public final Snapshot z() {
        return l();
    }

    private Snapshot(long j3, SnapshotIdSet snapshotIdSet) {
        this.f24916a = snapshotIdSet;
        this.f24917b = j3;
        this.f24919d = j3 != SnapshotKt.f24944b ? SnapshotKt.c0(j3, f()) : -1;
    }
}
