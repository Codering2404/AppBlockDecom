package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.snapshots.tooling.SnapshotInstanceObservers;
import androidx.compose.runtime.snapshots.tooling.SnapshotObserverKt;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

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
public final class GlobalSnapshot extends MutableSnapshot {
    public GlobalSnapshot(long j3, SnapshotIdSet snapshotIdSet) {
        super(j3, snapshotIdSet, null, new Function1<Object, Unit>() { // from class: androidx.compose.runtime.snapshots.GlobalSnapshot.1
            public final void c(Object obj) {
                synchronized (SnapshotKt.J()) {
                    try {
                        List list = SnapshotKt.f24952j;
                        int size = list.size();
                        for (int i3 = 0; i3 < size; i3++) {
                            ((Function1) list.get(i3)).invoke(obj);
                        }
                        Unit unit = Unit.f139807a;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c(obj);
                return Unit.f139807a;
            }
        });
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    public SnapshotApplyResult E() {
        throw new IllegalStateException("Cannot apply the global snapshot directly. Call Snapshot.advanceGlobalSnapshot");
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    public MutableSnapshot T(final Function1 function1, Function1 function12) {
        final Function1 function13;
        Map map;
        PersistentList persistentList = SnapshotObserverKt.f25057a;
        if (persistentList != null) {
            Pair pairE = SnapshotObserverKt.e(persistentList, null, false, function1, function12);
            SnapshotInstanceObservers snapshotInstanceObservers = (SnapshotInstanceObservers) pairE.e();
            Function1 function1A = snapshotInstanceObservers.a();
            Function1 function1B = snapshotInstanceObservers.b();
            map = (Map) pairE.f();
            function1 = function1A;
            function13 = function1B;
        } else {
            function13 = function12;
            map = null;
        }
        MutableSnapshot mutableSnapshot = (MutableSnapshot) SnapshotKt.b0(new Function1<SnapshotIdSet, MutableSnapshot>() { // from class: androidx.compose.runtime.snapshots.GlobalSnapshot$takeNestedMutableSnapshot$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final MutableSnapshot invoke(SnapshotIdSet snapshotIdSet) {
                long j3;
                synchronized (SnapshotKt.J()) {
                    j3 = SnapshotKt.f24948f;
                    SnapshotKt.f24948f++;
                }
                return new MutableSnapshot(j3, snapshotIdSet, function1, function13);
            }
        });
        if (persistentList != null) {
            SnapshotObserverKt.b(persistentList, null, mutableSnapshot, map);
        }
        return mutableSnapshot;
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public Void m(Snapshot snapshot) {
        SnapshotStateMapKt.b();
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    /* JADX INFO: renamed from: X, reason: merged with bridge method [inline-methods] */
    public Void n(Snapshot snapshot) {
        SnapshotStateMapKt.b();
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public void d() {
        synchronized (SnapshotKt.J()) {
            q();
            Unit unit = Unit.f139807a;
        }
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public void o() {
        SnapshotKt.C();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public Snapshot x(final Function1 function1) {
        Map map;
        PersistentList persistentList = SnapshotObserverKt.f25057a;
        if (persistentList != null) {
            Pair pairE = SnapshotObserverKt.e(persistentList, null, true, function1, null);
            SnapshotInstanceObservers snapshotInstanceObservers = (SnapshotInstanceObservers) pairE.e();
            Function1 function1A = snapshotInstanceObservers.a();
            snapshotInstanceObservers.b();
            map = (Map) pairE.f();
            function1 = function1A;
        } else {
            map = null;
        }
        ReadonlySnapshot readonlySnapshot = (ReadonlySnapshot) SnapshotKt.b0(new Function1<SnapshotIdSet, ReadonlySnapshot>() { // from class: androidx.compose.runtime.snapshots.GlobalSnapshot$takeNestedSnapshot$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final ReadonlySnapshot invoke(SnapshotIdSet snapshotIdSet) {
                long j3;
                synchronized (SnapshotKt.J()) {
                    j3 = SnapshotKt.f24948f;
                    SnapshotKt.f24948f++;
                }
                return new ReadonlySnapshot(j3, snapshotIdSet, function1);
            }
        });
        if (persistentList != null) {
            SnapshotObserverKt.b(persistentList, null, readonlySnapshot, map);
        }
        return readonlySnapshot;
    }
}
