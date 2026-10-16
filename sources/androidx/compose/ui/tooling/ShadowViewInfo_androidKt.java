package androidx.compose.ui.tooling;

import androidx.compose.ui.layout.LayoutInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class ShadowViewInfo_androidKt {
    public static final List a(List list) {
        if (list.size() < 2) {
            return list;
        }
        List list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(new ShadowViewInfo((ViewInfo) it.next()));
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i3 = 0;
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            CollectionsKt.addAll(arrayList2, ((ShadowViewInfo) obj).b());
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        int size2 = arrayList2.size();
        int i5 = 0;
        while (i5 < size2) {
            Object obj2 = arrayList2.get(i5);
            i5++;
            ShadowViewInfo shadowViewInfo = (ShadowViewInfo) obj2;
            arrayList3.add(TuplesKt.a(shadowViewInfo.d(), shadowViewInfo));
        }
        ArrayList arrayList4 = new ArrayList();
        int size3 = arrayList3.size();
        int i6 = 0;
        while (i6 < size3) {
            Object obj3 = arrayList3.get(i6);
            i6++;
            if (((Pair) obj3).e() != null) {
                arrayList4.add(obj3);
            }
        }
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        int size4 = arrayList4.size();
        int i7 = 0;
        while (i7 < size4) {
            Object obj4 = arrayList4.get(i7);
            i7++;
            LayoutInfo layoutInfo = (LayoutInfo) ((Pair) obj4).e();
            Object arrayList5 = linkedHashMap.get(layoutInfo);
            if (arrayList5 == null) {
                arrayList5 = new ArrayList();
                linkedHashMap.put(layoutInfo, arrayList5);
            }
            ((List) arrayList5).add(obj4);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(arrayList);
        int size5 = arrayList.size();
        while (i3 < size5) {
            Object obj5 = arrayList.get(i3);
            i3++;
            final ShadowViewInfo shadowViewInfo2 = (ShadowViewInfo) obj5;
            ShadowViewInfo shadowViewInfo3 = (ShadowViewInfo) SequencesKt.E(SequencesKt.M(SequencesKt.A(SequencesKt.G(shadowViewInfo2.b(), new Function1<ShadowViewInfo, List<? extends Pair<? extends LayoutInfo, ? extends ShadowViewInfo>>>() { // from class: androidx.compose.ui.tooling.ShadowViewInfo_androidKt$stitchTrees$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final List invoke(ShadowViewInfo shadowViewInfo4) {
                    Map map = linkedHashMap;
                    LayoutInfo layoutInfoD = shadowViewInfo4.d();
                    List list3 = (List) map.get(layoutInfoD != null ? layoutInfoD.a() : null);
                    return list3 == null ? CollectionsKt.emptyList() : list3;
                }
            }), new Function1<Pair<? extends LayoutInfo, ? extends ShadowViewInfo>, Boolean>() { // from class: androidx.compose.ui.tooling.ShadowViewInfo_androidKt$stitchTrees$1$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final Boolean invoke(Pair pair) {
                    return Boolean.valueOf(!Intrinsics.areEqual(((ShadowViewInfo) pair.f()).a(), shadowViewInfo2));
                }
            }), new Function1<Pair<? extends LayoutInfo, ? extends ShadowViewInfo>, ShadowViewInfo>() { // from class: androidx.compose.ui.tooling.ShadowViewInfo_androidKt$stitchTrees$1$3
                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final ShadowViewInfo invoke(Pair pair) {
                    return (ShadowViewInfo) pair.b();
                }
            }));
            if (shadowViewInfo3 != null) {
                shadowViewInfo2.e(shadowViewInfo3);
                linkedHashSet.remove(shadowViewInfo2);
            }
        }
        ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(linkedHashSet, 10));
        Iterator it2 = linkedHashSet.iterator();
        while (it2.hasNext()) {
            arrayList6.add(((ShadowViewInfo) it2.next()).f());
        }
        return arrayList6;
    }
}
