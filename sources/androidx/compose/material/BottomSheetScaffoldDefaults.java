package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.ui.unit.Dp;
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
public final class BottomSheetScaffoldDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BottomSheetScaffoldDefaults f12181a = new BottomSheetScaffoldDefaults();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f12182b = Dp.g(8);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f12183c = Dp.g(56);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final AnimationSpec f12184d = AnimationSpecKt.n(300, 0, EasingKt.d(), 2, null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f12185e = 8;

    private BottomSheetScaffoldDefaults() {
    }

    public final AnimationSpec a() {
        return f12184d;
    }

    public final float b() {
        return f12182b;
    }

    public final float c() {
        return f12183c;
    }
}
