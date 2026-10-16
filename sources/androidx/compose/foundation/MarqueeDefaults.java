package androidx.compose.foundation;

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
public final class MarqueeDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MarqueeDefaults f5029a = new MarqueeDefaults();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f5030b = 3;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f5031c = 1200;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final MarqueeSpacing f5032d = MarqueeSpacing.f5069a.b(0.33333334f);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final float f5033e = Dp.g(30);

    private MarqueeDefaults() {
    }
}
