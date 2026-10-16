package androidx.work.impl;

import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class StartStopTokens {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f54651a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f54652b = new LinkedHashMap();

    public final boolean a(WorkGenerationalId id) {
        boolean zContainsKey;
        Intrinsics.checkNotNullParameter(id, "id");
        synchronized (this.f54651a) {
            zContainsKey = this.f54652b.containsKey(id);
        }
        return zContainsKey;
    }

    public final StartStopToken b(WorkGenerationalId id) {
        StartStopToken startStopToken;
        Intrinsics.checkNotNullParameter(id, "id");
        synchronized (this.f54651a) {
            startStopToken = (StartStopToken) this.f54652b.remove(id);
        }
        return startStopToken;
    }

    public final List c(String workSpecId) {
        List list;
        Intrinsics.checkNotNullParameter(workSpecId, "workSpecId");
        synchronized (this.f54651a) {
            try {
                Map map = this.f54652b;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry entry : map.entrySet()) {
                    if (Intrinsics.areEqual(((WorkGenerationalId) entry.getKey()).b(), workSpecId)) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                Iterator it = linkedHashMap.keySet().iterator();
                while (it.hasNext()) {
                    this.f54652b.remove((WorkGenerationalId) it.next());
                }
                list = CollectionsKt.toList(linkedHashMap.values());
            } catch (Throwable th) {
                throw th;
            }
        }
        return list;
    }

    public final StartStopToken d(WorkGenerationalId id) {
        StartStopToken startStopToken;
        Intrinsics.checkNotNullParameter(id, "id");
        synchronized (this.f54651a) {
            try {
                Map map = this.f54652b;
                Object startStopToken2 = map.get(id);
                if (startStopToken2 == null) {
                    startStopToken2 = new StartStopToken(id);
                    map.put(id, startStopToken2);
                }
                startStopToken = (StartStopToken) startStopToken2;
            } catch (Throwable th) {
                throw th;
            }
        }
        return startStopToken;
    }

    public final StartStopToken e(WorkSpec spec) {
        Intrinsics.checkNotNullParameter(spec, "spec");
        return d(WorkSpecKt.a(spec));
    }
}
