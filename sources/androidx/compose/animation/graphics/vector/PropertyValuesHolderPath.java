package androidx.compose.animation.graphics.vector;

import androidx.compose.animation.core.Easing;
import androidx.compose.ui.graphics.vector.PathNode;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

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
public final class PropertyValuesHolderPath extends PropertyValuesHolder1D<List<? extends PathNode>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f4442b;

    public PropertyValuesHolderPath(String str, List list) {
        super(str, null);
        this.f4442b = list;
    }

    public List b() {
        return this.f4442b;
    }

    public final List c(float f3) {
        Iterator it = b().iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            }
            if (((Keyframe) it.next()).a() >= f3) {
                break;
            }
            i3++;
        }
        int iF = RangesKt.f(i3 - 1, 0);
        int i4 = iF + 1;
        Easing easingB = ((Keyframe) b().get(i4)).b();
        float fA = (f3 - ((Keyframe) b().get(iF)).a()) / (((Keyframe) b().get(i4)).a() - ((Keyframe) b().get(iF)).a());
        if (fA < 0.0f) {
            fA = 0.0f;
        }
        if (fA > 1.0f) {
            fA = 1.0f;
        }
        return AnimatorKt.c((List) ((Keyframe) b().get(iF)).c(), (List) ((Keyframe) b().get(i4)).c(), easingB.a(fA));
    }
}
