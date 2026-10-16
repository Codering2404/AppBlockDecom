package androidx.constraintlayout.compose;

import androidx.compose.foundation.layout.LayoutScopeMarker;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import kotlin.Metadata;

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
/* JADX INFO: loaded from: classes3.dex */
@LayoutScopeMarker
@Metadata
public final class MotionLayoutScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MotionMeasurer f30879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableFloatState f30880b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public final class CustomProperties {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public final class MotionProperties {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f30881a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f30882b;

        public MotionProperties(String str, String str2) {
            this.f30881a = str;
            this.f30882b = str2;
        }
    }

    public MotionLayoutScope(MotionMeasurer motionMeasurer, MutableFloatState mutableFloatState) {
        this.f30879a = motionMeasurer;
        this.f30880b = mutableFloatState;
    }

    public final androidx.compose.runtime.State b(String str, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1417298021, i3, -1, "androidx.constraintlayout.compose.MotionLayoutScope.motionProperties (MotionLayout.kt:871)");
        }
        boolean z2 = (((i3 & 14) ^ 6) > 4 && composer.Z(str)) || (i3 & 6) == 4;
        Object objG = composer.G();
        if (z2 || objG == Composer.f23746a.a()) {
            objG = SnapshotStateKt__SnapshotStateKt.e(new MotionProperties(str, null), null, 2, null);
            composer.w(objG);
        }
        MutableState mutableState = (MutableState) objG;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return mutableState;
    }
}
