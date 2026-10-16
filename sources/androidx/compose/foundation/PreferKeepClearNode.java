package androidx.compose.foundation;

import android.graphics.Rect;
import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

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
final class PreferKeepClearNode extends RectListNode {
    public PreferKeepClearNode(Function1 function1) {
        super(function1);
    }

    @Override // androidx.compose.foundation.RectListNode
    public MutableVector n2() {
        MutableVector mutableVector = new MutableVector(new Rect[16], 0);
        mutableVector.f(mutableVector.o(), p2().getPreferKeepClearRects());
        return mutableVector;
    }

    @Override // androidx.compose.foundation.RectListNode
    public void s2(MutableVector mutableVector) {
        p2().setPreferKeepClearRects(mutableVector.h());
    }
}
