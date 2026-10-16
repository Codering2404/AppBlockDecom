package androidx.compose.ui.text.android;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
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
public final class StaticLayoutFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final StaticLayoutFactory f28971a = new StaticLayoutFactory();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final StaticLayoutFactoryImpl f28972b = new StaticLayoutFactory23();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f28973c = 8;

    private StaticLayoutFactory() {
    }

    public static /* synthetic */ StaticLayout b(StaticLayoutFactory staticLayoutFactory, CharSequence charSequence, TextPaint textPaint, int i3, int i4, int i5, TextDirectionHeuristic textDirectionHeuristic, Layout.Alignment alignment, int i6, TextUtils.TruncateAt truncateAt, int i7, float f3, float f4, int i8, boolean z2, boolean z3, int i9, int i10, int i11, int i12, int[] iArr, int[] iArr2, int i13, Object obj) {
        int[] iArr3;
        StaticLayoutFactory staticLayoutFactory2;
        CharSequence charSequence2;
        TextPaint textPaint2;
        int i14;
        int i15 = (i13 & 8) != 0 ? 0 : i4;
        int length = (i13 & 16) != 0 ? charSequence.length() : i5;
        TextDirectionHeuristic textDirectionHeuristicB = (i13 & 32) != 0 ? LayoutCompat.f28948a.b() : textDirectionHeuristic;
        Layout.Alignment alignmentA = (i13 & 64) != 0 ? LayoutCompat.f28948a.a() : alignment;
        int i16 = (i13 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? Integer.MAX_VALUE : i6;
        TextUtils.TruncateAt truncateAt2 = (i13 & Function.MAX_NARGS) != 0 ? null : truncateAt;
        int i17 = (i13 & 512) != 0 ? i3 : i7;
        float f5 = (i13 & 1024) != 0 ? 1.0f : f3;
        float f6 = (i13 & 2048) != 0 ? 0.0f : f4;
        int i18 = (i13 & 4096) != 0 ? 0 : i8;
        boolean z4 = (i13 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? false : z2;
        boolean z5 = (i13 & 16384) != 0 ? true : z3;
        int i19 = (32768 & i13) != 0 ? 0 : i9;
        int i20 = (65536 & i13) != 0 ? 0 : i10;
        int i21 = (131072 & i13) != 0 ? 0 : i11;
        int i22 = (262144 & i13) != 0 ? 0 : i12;
        int[] iArr4 = (524288 & i13) != 0 ? null : iArr;
        if ((i13 & 1048576) != 0) {
            iArr3 = null;
            charSequence2 = charSequence;
            textPaint2 = textPaint;
            i14 = i3;
            staticLayoutFactory2 = staticLayoutFactory;
        } else {
            iArr3 = iArr2;
            staticLayoutFactory2 = staticLayoutFactory;
            charSequence2 = charSequence;
            textPaint2 = textPaint;
            i14 = i3;
        }
        return staticLayoutFactory2.a(charSequence2, textPaint2, i14, i15, length, textDirectionHeuristicB, alignmentA, i16, truncateAt2, i17, f5, f6, i18, z4, z5, i19, i20, i21, i22, iArr4, iArr3);
    }

    public final StaticLayout a(CharSequence charSequence, TextPaint textPaint, int i3, int i4, int i5, TextDirectionHeuristic textDirectionHeuristic, Layout.Alignment alignment, int i6, TextUtils.TruncateAt truncateAt, int i7, float f3, float f4, int i8, boolean z2, boolean z3, int i9, int i10, int i11, int i12, int[] iArr, int[] iArr2) {
        return f28972b.a(new StaticLayoutParams(charSequence, i4, i5, textPaint, i3, textDirectionHeuristic, alignment, i6, truncateAt, i7, f3, f4, i8, z2, z3, i9, i10, i11, i12, iArr, iArr2));
    }

    public final boolean c(StaticLayout staticLayout, boolean z2) {
        return f28972b.b(staticLayout, z2);
    }
}
