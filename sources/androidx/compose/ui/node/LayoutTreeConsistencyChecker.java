package androidx.compose.ui.node;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.MeasureAndLayoutDelegate;
import com.facebook.FacebookContentProvider;
import java.util.List;
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
public final class LayoutTreeConsistencyChecker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LayoutNode f27424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DepthSortedSetsForDifferentPasses f27425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f27426c;

    public LayoutTreeConsistencyChecker(LayoutNode layoutNode, DepthSortedSetsForDifferentPasses depthSortedSetsForDifferentPasses, List list) {
        this.f27424a = layoutNode;
        this.f27425b = depthSortedSetsForDifferentPasses;
        this.f27426c = list;
    }

    private final boolean b(LayoutNode layoutNode) {
        Object obj;
        LayoutNode layoutNodeB0 = layoutNode.B0();
        Object obj2 = null;
        LayoutNode.LayoutState layoutStateH0 = layoutNodeB0 != null ? layoutNodeB0.h0() : null;
        if (layoutNode.u() || (layoutNode.C0() != Integer.MAX_VALUE && layoutNodeB0 != null && layoutNodeB0.u())) {
            if (layoutNode.o0()) {
                List list = this.f27426c;
                int size = list.size();
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        obj = null;
                        break;
                    }
                    obj = list.get(i3);
                    MeasureAndLayoutDelegate.PostponedRequest postponedRequest = (MeasureAndLayoutDelegate.PostponedRequest) obj;
                    if (Intrinsics.areEqual(postponedRequest.a(), layoutNode) && !postponedRequest.c()) {
                        break;
                    }
                    i3++;
                }
                if (obj != null) {
                    return true;
                }
            }
            if (layoutNode.y()) {
                return true;
            }
            if (layoutNode.o0()) {
                return this.f27425b.d(layoutNode) || layoutNode.h0() == LayoutNode.LayoutState.f27385b || (layoutNodeB0 != null && layoutNodeB0.o0()) || ((layoutNodeB0 != null && layoutNodeB0.j0()) || layoutStateH0 == LayoutNode.LayoutState.f27384a);
            }
            if (layoutNode.g0()) {
                if (!this.f27425b.d(layoutNode) && layoutNodeB0 != null && !layoutNodeB0.o0() && !layoutNodeB0.g0() && layoutStateH0 != LayoutNode.LayoutState.f27384a && layoutStateH0 != LayoutNode.LayoutState.f27386c) {
                    List list2 = this.f27426c;
                    int size2 = list2.size();
                    int i4 = 0;
                    while (true) {
                        if (i4 >= size2) {
                            if (layoutNode.h0() == LayoutNode.LayoutState.f27384a) {
                                break;
                            }
                            return false;
                        }
                        if (Intrinsics.areEqual(((MeasureAndLayoutDelegate.PostponedRequest) list2.get(i4)).a(), layoutNode)) {
                            break;
                        }
                        i4++;
                    }
                }
                return true;
            }
        }
        if (Intrinsics.areEqual(layoutNode.V0(), Boolean.TRUE)) {
            if (layoutNode.j0()) {
                List list3 = this.f27426c;
                int size3 = list3.size();
                int i5 = 0;
                while (true) {
                    if (i5 >= size3) {
                        break;
                    }
                    Object obj3 = list3.get(i5);
                    MeasureAndLayoutDelegate.PostponedRequest postponedRequest2 = (MeasureAndLayoutDelegate.PostponedRequest) obj3;
                    if (Intrinsics.areEqual(postponedRequest2.a(), layoutNode) && postponedRequest2.c()) {
                        obj2 = obj3;
                        break;
                    }
                    i5++;
                }
                if (obj2 != null) {
                    return true;
                }
            }
            if (layoutNode.j0()) {
                return this.f27425b.e(layoutNode, true) || (layoutNodeB0 != null && layoutNodeB0.j0()) || layoutStateH0 == LayoutNode.LayoutState.f27385b || (layoutNodeB0 != null && layoutNodeB0.o0() && Intrinsics.areEqual(layoutNode.l0(), layoutNode));
            }
            if (layoutNode.i0() && !this.f27425b.e(layoutNode, true) && layoutNodeB0 != null && !layoutNodeB0.j0() && !layoutNodeB0.i0() && layoutStateH0 != LayoutNode.LayoutState.f27385b && layoutStateH0 != LayoutNode.LayoutState.f27387d && (!layoutNodeB0.g0() || !Intrinsics.areEqual(layoutNode.l0(), layoutNode))) {
                return false;
            }
        }
        return true;
    }

    private final boolean c(LayoutNode layoutNode) {
        if (!b(layoutNode)) {
            return false;
        }
        List listO = layoutNode.O();
        int size = listO.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (!c((LayoutNode) listO.get(i3))) {
                return false;
            }
        }
        return true;
    }

    private final String d() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tree state:");
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        e(this, sb, this.f27424a, 0);
        return sb.toString();
    }

    private static final void e(LayoutTreeConsistencyChecker layoutTreeConsistencyChecker, StringBuilder sb, LayoutNode layoutNode, int i3) {
        String strF = layoutTreeConsistencyChecker.f(layoutNode);
        if (strF.length() > 0) {
            for (int i4 = 0; i4 < i3; i4++) {
                sb.append(FacebookContentProvider.INVALID_FILE_NAME);
            }
            sb.append(strF);
            Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            sb.append('\n');
            Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            i3++;
        }
        List listO = layoutNode.O();
        int size = listO.size();
        for (int i5 = 0; i5 < size; i5++) {
            e(layoutTreeConsistencyChecker, sb, (LayoutNode) listO.get(i5), i3);
        }
    }

    private final String f(LayoutNode layoutNode) {
        StringBuilder sb = new StringBuilder();
        sb.append(layoutNode);
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        sb2.append(layoutNode.h0());
        sb2.append(']');
        sb.append(sb2.toString());
        if (!layoutNode.u()) {
            sb.append("[!isPlaced]");
        }
        sb.append("[measuredByParent=" + layoutNode.q0() + ']');
        if (!b(layoutNode)) {
            sb.append("[INCONSISTENT]");
        }
        return sb.toString();
    }

    public final void a() {
        if (c(this.f27424a)) {
            return;
        }
        System.out.println((Object) d());
        throw new IllegalStateException("Inconsistency found!");
    }
}
