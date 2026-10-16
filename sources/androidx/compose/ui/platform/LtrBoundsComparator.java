package androidx.compose.ui.platform;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.semantics.SemanticsNode;
import java.util.Comparator;
import kotlin.Metadata;

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
final class LtrBoundsComparator implements Comparator<SemanticsNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LtrBoundsComparator f28126a = new LtrBoundsComparator();

    private LtrBoundsComparator() {
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(SemanticsNode semanticsNode, SemanticsNode semanticsNode2) {
        Rect rectJ = semanticsNode.j();
        Rect rectJ2 = semanticsNode2.j();
        int iCompare = Float.compare(rectJ.o(), rectJ2.o());
        if (iCompare != 0) {
            return iCompare;
        }
        int iCompare2 = Float.compare(rectJ.r(), rectJ2.r());
        if (iCompare2 != 0) {
            return iCompare2;
        }
        int iCompare3 = Float.compare(rectJ.i(), rectJ2.i());
        return iCompare3 != 0 ? iCompare3 : Float.compare(rectJ.p(), rectJ2.p());
    }
}
