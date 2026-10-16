package androidx.glance.appwidget;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.glance.unit.ColorProvider;
import androidx.glance.unit.ColorProviderKt;
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
public final class ProgressIndicatorDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProgressIndicatorDefaults f38195a = new ProgressIndicatorDefaults();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f38196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ColorProvider f38197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ColorProvider f38198d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f38199e;

    static {
        long jD = ColorKt.d(4284612846L);
        f38196b = jD;
        f38197c = ColorProviderKt.b(jD);
        f38198d = ColorProviderKt.b(Color.r(jD, 0.24f, 0.0f, 0.0f, 0.0f, 14, null));
        f38199e = 8;
    }

    private ProgressIndicatorDefaults() {
    }

    public final ColorProvider a() {
        return f38198d;
    }

    public final ColorProvider b() {
        return f38197c;
    }
}
