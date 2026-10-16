package androidx.compose.runtime.snapshots.tooling;

import androidx.collection.ScatterSet;
import androidx.compose.runtime.collection.ScatterSetWrapperKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.snapshots.Snapshot;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
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
public final class SnapshotObserverKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static PersistentList f25057a;

    public static final void b(PersistentList persistentList, Snapshot snapshot, Snapshot snapshot2, Map map) {
        int size = persistentList.size();
        for (int i3 = 0; i3 < size; i3++) {
            SnapshotObserver snapshotObserver = (SnapshotObserver) persistentList.get(i3);
            snapshotObserver.b(snapshot2, snapshot, map != null ? (SnapshotInstanceObservers) map.get(snapshotObserver) : null);
        }
    }

    public static final void c(Snapshot snapshot, ScatterSet scatterSet) {
        Set setEmptySet;
        PersistentList persistentList = f25057a;
        if (persistentList == null || persistentList.isEmpty()) {
            return;
        }
        if (scatterSet == null || (setEmptySet = ScatterSetWrapperKt.a(scatterSet)) == null) {
            setEmptySet = SetsKt.emptySet();
        }
        int size = persistentList.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((SnapshotObserver) persistentList.get(i3)).d(snapshot, setEmptySet);
        }
    }

    public static final void d(Snapshot snapshot) {
        PersistentList persistentList = f25057a;
        if (persistentList != null) {
            int size = persistentList.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((SnapshotObserver) persistentList.get(i3)).f(snapshot);
            }
        }
    }

    public static final Pair e(PersistentList persistentList, Snapshot snapshot, boolean z2, Function1 function1, Function1 function12) {
        int size = persistentList.size();
        LinkedHashMap linkedHashMap = null;
        for (int i3 = 0; i3 < size; i3++) {
            SnapshotObserver snapshotObserver = (SnapshotObserver) persistentList.get(i3);
            SnapshotInstanceObservers snapshotInstanceObserversA = snapshotObserver.a(snapshot, z2);
            if (snapshotInstanceObserversA != null) {
                function1 = f(snapshotInstanceObserversA.a(), function1);
                function12 = f(snapshotInstanceObserversA.b(), function12);
                if (linkedHashMap == null) {
                    linkedHashMap = new LinkedHashMap();
                }
                linkedHashMap.put(snapshotObserver, snapshotInstanceObserversA);
            }
        }
        return TuplesKt.a(new SnapshotInstanceObservers(function1, function12), linkedHashMap);
    }

    private static final Function1 f(final Function1 function1, final Function1 function12) {
        return (function1 == null || function12 == null) ? function1 == null ? function12 : function1 : new Function1<Object, Unit>() { // from class: androidx.compose.runtime.snapshots.tooling.SnapshotObserverKt$mergeObservers$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(Object obj) {
                function1.invoke(obj);
                function12.invoke(obj);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c(obj);
                return Unit.f139807a;
            }
        };
    }
}
