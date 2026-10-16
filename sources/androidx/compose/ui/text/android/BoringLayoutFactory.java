package androidx.compose.ui.text.android;

import android.os.Build;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
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
public final class BoringLayoutFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BoringLayoutFactory f28933a = new BoringLayoutFactory();

    private BoringLayoutFactory() {
    }

    public final BoringLayout a(CharSequence charSequence, TextPaint textPaint, int i3, BoringLayout.Metrics metrics, Layout.Alignment alignment, boolean z2, boolean z3, TextUtils.TruncateAt truncateAt, int i4) {
        if (!(i3 >= 0)) {
            InlineClassHelperKt.a("negative width");
        }
        if (!(i4 >= 0)) {
            InlineClassHelperKt.a("negative ellipsized width");
        }
        return Build.VERSION.SDK_INT >= 33 ? BoringLayoutFactory33.a(charSequence, textPaint, i3, alignment, 1.0f, 0.0f, metrics, z2, z3, truncateAt, i4) : BoringLayoutFactoryDefault.a(charSequence, textPaint, i3, alignment, 1.0f, 0.0f, metrics, z2, truncateAt, i4);
    }

    public final boolean b(BoringLayout boringLayout) {
        if (Build.VERSION.SDK_INT >= 33) {
            return BoringLayoutFactory33.c(boringLayout);
        }
        return false;
    }

    public final BoringLayout.Metrics c(CharSequence charSequence, TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic) {
        return Build.VERSION.SDK_INT >= 33 ? BoringLayoutFactory33.b(charSequence, textPaint, textDirectionHeuristic) : BoringLayoutFactoryDefault.b(charSequence, textPaint, textDirectionHeuristic);
    }
}
