package cz.mobilesoft.appblock.service.lock;

import cz.mobilesoft.coreblock.repository.SubApp;
import cz.mobilesoft.coreblock.repository.SubAppsCatalog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class SubAppScreenResolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SubAppScreenResolver f94938a = new SubAppScreenResolver();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map f94939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f94940c;

    static {
        Iterable<IndexedValue> iterableWithIndex = CollectionsKt.withIndex(SubAppsCatalog.f98385a.a());
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(iterableWithIndex, 10)), 16));
        for (IndexedValue indexedValue : iterableWithIndex) {
            Pair pairA = TuplesKt.a(((SubApp) indexedValue.component2()).getId(), Integer.valueOf(indexedValue.component1()));
            linkedHashMap.put(pairA.e(), pairA.f());
        }
        f94939b = linkedHashMap;
        f94940c = 8;
    }

    private SubAppScreenResolver() {
    }

    public final void a(List candidates, Function1 isVisible, Function0 onNoneVisible, Function1 onVisible) {
        Object obj;
        Intrinsics.checkNotNullParameter(candidates, "candidates");
        Intrinsics.checkNotNullParameter(isVisible, "isVisible");
        Intrinsics.checkNotNullParameter(onNoneVisible, "onNoneVisible");
        Intrinsics.checkNotNullParameter(onVisible, "onVisible");
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : candidates) {
            if (((Boolean) isVisible.invoke(obj2)).booleanValue()) {
                arrayList.add(obj2);
            }
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                Integer num = (Integer) f94939b.get(((SubApp) next).getId());
                int iIntValue = num != null ? num.intValue() : Integer.MAX_VALUE;
                do {
                    Object next2 = it.next();
                    Integer num2 = (Integer) f94939b.get(((SubApp) next2).getId());
                    int iIntValue2 = num2 != null ? num2.intValue() : Integer.MAX_VALUE;
                    if (iIntValue > iIntValue2) {
                        next = next2;
                        iIntValue = iIntValue2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        SubApp subApp = (SubApp) obj;
        if (subApp == null) {
            onNoneVisible.invoke();
        } else {
            onVisible.invoke(subApp);
        }
    }
}
