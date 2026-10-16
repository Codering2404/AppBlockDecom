package androidx.compose.ui.node;

import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.node.LayoutNode;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

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
public final class MeasureScopeWithLayoutNodeKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f27532a;

        static {
            int[] iArr = new int[LayoutNode.LayoutState.values().length];
            try {
                iArr[LayoutNode.LayoutState.f27385b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutNode.LayoutState.f27387d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LayoutNode.LayoutState.f27384a.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LayoutNode.LayoutState.f27386c.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[LayoutNode.LayoutState.f27388f.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f27532a = iArr;
        }
    }

    public static final List a(IntrinsicMeasureScope intrinsicMeasureScope) {
        Intrinsics.checkNotNull(intrinsicMeasureScope, "null cannot be cast to non-null type androidx.compose.ui.node.MeasureScopeWithLayoutNode");
        LayoutNode layoutNodeX1 = ((MeasureScopeWithLayoutNode) intrinsicMeasureScope).X1();
        boolean zB = b(layoutNodeX1);
        List listW = layoutNodeX1.W();
        ArrayList arrayList = new ArrayList(listW.size());
        int size = listW.size();
        for (int i3 = 0; i3 < size; i3++) {
            LayoutNode layoutNode = (LayoutNode) listW.get(i3);
            arrayList.add(zB ? layoutNode.M() : layoutNode.N());
        }
        return arrayList;
    }

    private static final boolean b(LayoutNode layoutNode) {
        int i3 = WhenMappings.f27532a[layoutNode.h0().ordinal()];
        if (i3 == 1 || i3 == 2) {
            return true;
        }
        if (i3 == 3 || i3 == 4) {
            return false;
        }
        if (i3 != 5) {
            throw new NoWhenBranchMatchedException();
        }
        LayoutNode layoutNodeB0 = layoutNode.B0();
        if (layoutNodeB0 != null) {
            return b(layoutNodeB0);
        }
        throw new IllegalArgumentException("no parent for idle node");
    }
}
