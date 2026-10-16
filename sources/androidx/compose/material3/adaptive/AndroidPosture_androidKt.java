package androidx.compose.material3.adaptive;

import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.window.layout.FoldingFeature;
import java.util.ArrayList;
import java.util.Iterator;
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
public final class AndroidPosture_androidKt {
    public static final Posture a(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            FoldingFeature foldingFeature = (FoldingFeature) it.next();
            if (Intrinsics.areEqual(foldingFeature.getOrientation(), FoldingFeature.Orientation.f54323d) && Intrinsics.areEqual(foldingFeature.getState(), FoldingFeature.State.f54327d)) {
                z2 = true;
            }
            arrayList.add(new HingeInfo(RectHelper_androidKt.e(foldingFeature.getBounds()), Intrinsics.areEqual(foldingFeature.getState(), FoldingFeature.State.f54326c), Intrinsics.areEqual(foldingFeature.getOrientation(), FoldingFeature.Orientation.f54322c), foldingFeature.a(), Intrinsics.areEqual(foldingFeature.b(), FoldingFeature.OcclusionType.f54319d)));
        }
        return new Posture(z2, arrayList);
    }
}
