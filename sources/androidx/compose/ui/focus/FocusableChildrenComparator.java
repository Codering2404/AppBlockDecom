package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutNode;
import java.util.Comparator;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class FocusableChildrenComparator implements Comparator<FocusTargetNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FocusableChildrenComparator f25571a = new FocusableChildrenComparator();

    private FocusableChildrenComparator() {
    }

    private final MutableVector b(LayoutNode layoutNode) {
        MutableVector mutableVector = new MutableVector(new LayoutNode[16], 0);
        while (layoutNode != null) {
            mutableVector.a(0, layoutNode);
            layoutNode = layoutNode.B0();
        }
        return mutableVector;
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(FocusTargetNode focusTargetNode, FocusTargetNode focusTargetNode2) {
        int i3 = 0;
        if (!FocusTraversalKt.g(focusTargetNode) || !FocusTraversalKt.g(focusTargetNode2)) {
            if (FocusTraversalKt.g(focusTargetNode)) {
                return -1;
            }
            return FocusTraversalKt.g(focusTargetNode2) ? 1 : 0;
        }
        LayoutNode layoutNodeO = DelegatableNodeKt.o(focusTargetNode);
        LayoutNode layoutNodeO2 = DelegatableNodeKt.o(focusTargetNode2);
        if (Intrinsics.areEqual(layoutNodeO, layoutNodeO2)) {
            return 0;
        }
        MutableVector mutableVectorB = b(layoutNodeO);
        MutableVector mutableVectorB2 = b(layoutNodeO2);
        int iMin = Math.min(mutableVectorB.o() - 1, mutableVectorB2.o() - 1);
        if (iMin >= 0) {
            while (Intrinsics.areEqual(mutableVectorB.f24389a[i3], mutableVectorB2.f24389a[i3])) {
                if (i3 != iMin) {
                    i3++;
                }
            }
            return Intrinsics.compare(((LayoutNode) mutableVectorB.f24389a[i3]).C0(), ((LayoutNode) mutableVectorB2.f24389a[i3]).C0());
        }
        throw new IllegalStateException("Could not find a common ancestor between the two FocusModifiers.");
    }
}
