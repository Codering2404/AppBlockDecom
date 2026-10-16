package androidx.compose.material3.tokens;

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
public final class BottomAppBarTokens {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BottomAppBarTokens f22329a = new BottomAppBarTokens();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ColorSchemeKeyTokens f22330b = ColorSchemeKeyTokens.SurfaceContainer;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f22331c = ElevationTokens.f22534a.c();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float f22332d = Dp.g((float) 80.0d);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ShapeKeyTokens f22333e = ShapeKeyTokens.CornerNone;

    private BottomAppBarTokens() {
    }

    public final ColorSchemeKeyTokens a() {
        return f22330b;
    }

    public final float b() {
        return f22332d;
    }

    public final ShapeKeyTokens c() {
        return f22333e;
    }
}
