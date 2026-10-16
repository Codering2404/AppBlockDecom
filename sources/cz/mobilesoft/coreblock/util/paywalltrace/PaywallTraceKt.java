package cz.mobilesoft.coreblock.util.paywalltrace;

import java.util.ArrayList;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class PaywallTraceKt {
    public static final List a(List list) {
        Iterator it;
        ArrayList arrayList;
        int i3;
        Intrinsics.checkNotNullParameter(list, "<this>");
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            PaywallTrace paywallTrace = (PaywallTrace) it2.next();
            CollapsedTrace collapsedTrace = (CollapsedTrace) CollectionsKt.lastOrNull((List) arrayList2);
            if (collapsedTrace != null) {
                it = it2;
                ArrayList arrayList3 = arrayList2;
                i3 = 1;
                if (!Intrinsics.areEqual(PaywallTrace.b(collapsedTrace.d(), 0L, null, null, null, null, null, null, null, null, null, 0, 2046, null), PaywallTrace.b(paywallTrace, 0L, null, null, null, null, null, null, null, null, null, 0, 2046, null)) || collapsedTrace == null) {
                    arrayList = arrayList3;
                } else {
                    int lastIndex = CollectionsKt.getLastIndex(arrayList3);
                    CollapsedTrace collapsedTraceB = CollapsedTrace.b(collapsedTrace, null, collapsedTrace.c() + 1, 1, null);
                    arrayList = arrayList3;
                    arrayList.set(lastIndex, collapsedTraceB);
                    it2 = it;
                    arrayList2 = arrayList;
                }
            } else {
                it = it2;
                arrayList = arrayList2;
                i3 = 1;
            }
            arrayList.add(new CollapsedTrace(paywallTrace, i3));
            it2 = it;
            arrayList2 = arrayList;
        }
        return arrayList2;
    }

    public static final List b(List list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : list) {
            Integer numValueOf = Integer.valueOf(((PaywallTrace) obj).h());
            Object arrayList = linkedHashMap.get(numValueOf);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(numValueOf, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        ArrayList arrayList2 = new ArrayList(linkedHashMap.size());
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            arrayList2.add(new TraceGroup(((Number) entry.getKey()).intValue(), a((List) entry.getValue())));
        }
        return arrayList2;
    }
}
