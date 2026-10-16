package androidx.compose.ui.text.android.selection;

import android.text.TextPaint;
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
public final class GraphemeClusterSegmentFinderApi29 extends GraphemeClusterSegmentFinder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CharSequence f29031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextPaint f29032b;

    public GraphemeClusterSegmentFinderApi29(CharSequence charSequence, TextPaint textPaint) {
        this.f29031a = charSequence;
        this.f29032b = textPaint;
    }

    @Override // androidx.compose.ui.text.android.selection.GraphemeClusterSegmentFinder
    public int e(int i3) {
        TextPaint textPaint = this.f29032b;
        CharSequence charSequence = this.f29031a;
        return textPaint.getTextRunCursor(charSequence, 0, charSequence.length(), false, i3, 0);
    }

    @Override // androidx.compose.ui.text.android.selection.GraphemeClusterSegmentFinder
    public int f(int i3) {
        TextPaint textPaint = this.f29032b;
        CharSequence charSequence = this.f29031a;
        return textPaint.getTextRunCursor(charSequence, 0, charSequence.length(), false, i3, 2);
    }
}
