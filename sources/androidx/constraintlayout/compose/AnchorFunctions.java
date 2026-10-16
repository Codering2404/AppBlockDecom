package androidx.constraintlayout.compose;

import android.util.Log;
import com.facebook.appevents.internal.ViewHierarchyConstants;
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
public final class AnchorFunctions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AnchorFunctions f30332a = new AnchorFunctions();

    private AnchorFunctions() {
    }

    public final String a(int i3) {
        if (i3 == 0) {
            return ViewHierarchyConstants.DIMENSION_TOP_KEY;
        }
        if (i3 == 1) {
            return "bottom";
        }
        Log.e("CCL", "horizontalAnchorIndexToAnchorName: Unknown horizontal index");
        return ViewHierarchyConstants.DIMENSION_TOP_KEY;
    }

    public final String b(int i3) {
        if (i3 == -2) {
            return "start";
        }
        if (i3 == -1) {
            return "end";
        }
        if (i3 == 0) {
            return ViewHierarchyConstants.DIMENSION_LEFT_KEY;
        }
        if (i3 == 1) {
            return "right";
        }
        Log.e("CCL", "verticalAnchorIndexToAnchorName: Unknown vertical index");
        return "start";
    }
}
