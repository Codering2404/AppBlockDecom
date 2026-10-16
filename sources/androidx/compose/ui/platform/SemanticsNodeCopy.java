package androidx.compose.ui.platform;

import androidx.collection.IntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsNode;
import java.util.List;
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
public final class SemanticsNodeCopy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SemanticsConfiguration f28204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableIntSet f28205b;

    public SemanticsNodeCopy(SemanticsNode semanticsNode, IntObjectMap intObjectMap) {
        this.f28204a = semanticsNode.w();
        this.f28205b = new MutableIntSet(semanticsNode.t().size());
        List listT = semanticsNode.t();
        int size = listT.size();
        for (int i3 = 0; i3 < size; i3++) {
            SemanticsNode semanticsNode2 = (SemanticsNode) listT.get(i3);
            if (intObjectMap.a(semanticsNode2.o())) {
                this.f28205b.g(semanticsNode2.o());
            }
        }
    }

    public final MutableIntSet a() {
        return this.f28205b;
    }

    public final SemanticsConfiguration b() {
        return this.f28204a;
    }
}
