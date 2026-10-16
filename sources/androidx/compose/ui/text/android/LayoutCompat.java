package androidx.compose.ui.text.android;

import android.text.Layout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
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
@Metadata
public final class LayoutCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LayoutCompat f28948a = new LayoutCompat();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Layout.Alignment f28949b = Layout.Alignment.ALIGN_NORMAL;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final TextDirectionHeuristic f28950c = TextDirectionHeuristics.FIRSTSTRONG_LTR;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f28951d = 8;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention
    public @interface BreakStrategy {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention
    public @interface HyphenationFrequency {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention
    public @interface JustificationMode {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention
    public @interface LineBreakStyle {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention
    public @interface LineBreakWordStyle {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention
    public @interface TextDirection {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention
    public @interface TextGranularity {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention
    public @interface TextLayoutAlignment {
    }

    private LayoutCompat() {
    }

    public final Layout.Alignment a() {
        return f28949b;
    }

    public final TextDirectionHeuristic b() {
        return f28950c;
    }
}
