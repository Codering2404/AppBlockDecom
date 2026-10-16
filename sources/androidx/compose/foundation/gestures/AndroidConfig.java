package androidx.compose.foundation.gestures;

import android.view.ViewConfiguration;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.unit.Density;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class AndroidConfig implements ScrollConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewConfiguration f5535a;

    public AndroidConfig(ViewConfiguration viewConfiguration) {
        this.f5535a = viewConfiguration;
    }

    @Override // androidx.compose.foundation.gestures.ScrollConfig
    public long c(Density density, PointerEvent pointerEvent, long j3) {
        ViewConfigurationApi26Impl viewConfigurationApi26Impl = ViewConfigurationApi26Impl.f6426a;
        float f3 = -viewConfigurationApi26Impl.b(this.f5535a);
        float f4 = -viewConfigurationApi26Impl.a(this.f5535a);
        List listC = pointerEvent.c();
        Offset offsetD = Offset.d(Offset.f25596b.c());
        int size = listC.size();
        for (int i3 = 0; i3 < size; i3++) {
            offsetD = Offset.d(Offset.q(offsetD.u(), ((PointerInputChange) listC.get(i3)).m()));
        }
        long jU = offsetD.u();
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jU >> 32)) * f4;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jU & 4294967295L)) * f3;
        return Offset.e((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L));
    }
}
