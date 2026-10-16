package androidx.compose.ui.platform.accessibility;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.semantics.CollectionInfo;
import androidx.compose.ui.semantics.CollectionItemInfo;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;

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
public final class CollectionInfo_androidKt {
    private static final boolean a(List list) {
        List listEmptyList;
        long jU;
        if (list.size() < 2) {
            return true;
        }
        if (list.size() <= 1) {
            listEmptyList = CollectionsKt.emptyList();
        } else {
            ArrayList arrayList = new ArrayList();
            Object obj = list.get(0);
            int lastIndex = CollectionsKt.getLastIndex(list);
            int i3 = 0;
            while (i3 < lastIndex) {
                i3++;
                Object obj2 = list.get(i3);
                SemanticsNode semanticsNode = (SemanticsNode) obj2;
                SemanticsNode semanticsNode2 = (SemanticsNode) obj;
                arrayList.add(Offset.d(Offset.e((((long) Float.floatToRawIntBits(Math.abs(Float.intBitsToFloat((int) (semanticsNode2.i().m() >> 32)) - Float.intBitsToFloat((int) (semanticsNode.i().m() >> 32))))) << 32) | (((long) Float.floatToRawIntBits(Math.abs(Float.intBitsToFloat((int) (semanticsNode2.i().m() & 4294967295L)) - Float.intBitsToFloat((int) (semanticsNode.i().m() & 4294967295L))))) & 4294967295L))));
                obj = obj2;
            }
            listEmptyList = arrayList;
        }
        if (listEmptyList.size() == 1) {
            jU = ((Offset) CollectionsKt.first(listEmptyList)).u();
        } else {
            if (listEmptyList.isEmpty()) {
                ListUtilsKt.f("Empty collection can't be reduced.");
            }
            Object objFirst = CollectionsKt.first((List<? extends Object>) listEmptyList);
            int lastIndex2 = CollectionsKt.getLastIndex(listEmptyList);
            if (1 <= lastIndex2) {
                int i4 = 1;
                while (true) {
                    objFirst = Offset.d(Offset.q(((Offset) objFirst).u(), ((Offset) listEmptyList.get(i4)).u()));
                    if (i4 == lastIndex2) {
                        break;
                    }
                    i4++;
                }
            }
            jU = ((Offset) objFirst).u();
        }
        return Float.intBitsToFloat((int) (4294967295L & jU)) < Float.intBitsToFloat((int) (jU >> 32));
    }

    public static final boolean b(SemanticsNode semanticsNode) {
        SemanticsConfiguration semanticsConfigurationN = semanticsNode.n();
        SemanticsProperties semanticsProperties = SemanticsProperties.f28517a;
        return (SemanticsConfigurationKt.a(semanticsConfigurationN, semanticsProperties.a()) == null && SemanticsConfigurationKt.a(semanticsNode.n(), semanticsProperties.D()) == null) ? false : true;
    }

    private static final boolean c(CollectionInfo collectionInfo) {
        return collectionInfo.b() < 0 || collectionInfo.a() < 0;
    }

    public static final void d(SemanticsNode semanticsNode, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        SemanticsConfiguration semanticsConfigurationN = semanticsNode.n();
        SemanticsProperties semanticsProperties = SemanticsProperties.f28517a;
        CollectionInfo collectionInfo = (CollectionInfo) SemanticsConfigurationKt.a(semanticsConfigurationN, semanticsProperties.a());
        if (collectionInfo != null) {
            accessibilityNodeInfoCompat.k0(f(collectionInfo));
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (SemanticsConfigurationKt.a(semanticsNode.n(), semanticsProperties.D()) != null) {
            List listT = semanticsNode.t();
            int size = listT.size();
            for (int i3 = 0; i3 < size; i3++) {
                SemanticsNode semanticsNode2 = (SemanticsNode) listT.get(i3);
                if (semanticsNode2.n().d(SemanticsProperties.f28517a.E())) {
                    arrayList.add(semanticsNode2);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        boolean zA = a(arrayList);
        accessibilityNodeInfoCompat.k0(AccessibilityNodeInfoCompat.CollectionInfoCompat.b(zA ? 1 : arrayList.size(), zA ? arrayList.size() : 1, false, 0));
    }

    public static final void e(SemanticsNode semanticsNode, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        SemanticsConfiguration semanticsConfigurationN = semanticsNode.n();
        SemanticsProperties semanticsProperties = SemanticsProperties.f28517a;
        CollectionItemInfo collectionItemInfo = (CollectionItemInfo) SemanticsConfigurationKt.a(semanticsConfigurationN, semanticsProperties.b());
        if (collectionItemInfo != null) {
            accessibilityNodeInfoCompat.l0(g(collectionItemInfo, semanticsNode));
        }
        SemanticsNode semanticsNodeR = semanticsNode.r();
        if (semanticsNodeR == null || SemanticsConfigurationKt.a(semanticsNodeR.n(), semanticsProperties.D()) == null) {
            return;
        }
        CollectionInfo collectionInfo = (CollectionInfo) SemanticsConfigurationKt.a(semanticsNodeR.n(), semanticsProperties.a());
        if ((collectionInfo == null || !c(collectionInfo)) && semanticsNode.n().d(semanticsProperties.E())) {
            ArrayList arrayList = new ArrayList();
            List listT = semanticsNodeR.t();
            int size = listT.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                SemanticsNode semanticsNode2 = (SemanticsNode) listT.get(i4);
                if (semanticsNode2.n().d(SemanticsProperties.f28517a.E())) {
                    arrayList.add(semanticsNode2);
                    if (semanticsNode2.q().C0() < semanticsNode.q().C0()) {
                        i3++;
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            boolean zA = a(arrayList);
            AccessibilityNodeInfoCompat.CollectionItemInfoCompat collectionItemInfoCompatA = AccessibilityNodeInfoCompat.CollectionItemInfoCompat.a(zA ? 0 : i3, 1, zA ? i3 : 0, 1, false, ((Boolean) semanticsNode.n().h(SemanticsProperties.f28517a.E(), new Function0<Boolean>() { // from class: androidx.compose.ui.platform.accessibility.CollectionInfo_androidKt$setCollectionItemInfo$itemInfo$1
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return Boolean.FALSE;
                }
            })).booleanValue());
            if (collectionItemInfoCompatA != null) {
                accessibilityNodeInfoCompat.l0(collectionItemInfoCompatA);
            }
        }
    }

    private static final AccessibilityNodeInfoCompat.CollectionInfoCompat f(CollectionInfo collectionInfo) {
        return AccessibilityNodeInfoCompat.CollectionInfoCompat.b(collectionInfo.b(), collectionInfo.a(), false, 0);
    }

    private static final AccessibilityNodeInfoCompat.CollectionItemInfoCompat g(CollectionItemInfo collectionItemInfo, SemanticsNode semanticsNode) {
        return AccessibilityNodeInfoCompat.CollectionItemInfoCompat.a(collectionItemInfo.c(), collectionItemInfo.d(), collectionItemInfo.a(), collectionItemInfo.b(), false, ((Boolean) semanticsNode.n().h(SemanticsProperties.f28517a.E(), new Function0<Boolean>() { // from class: androidx.compose.ui.platform.accessibility.CollectionInfo_androidKt$toAccessibilityCollectionItemInfo$1
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.FALSE;
            }
        })).booleanValue());
    }
}
