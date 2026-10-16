package androidx.compose.ui.text.platform.style;

import android.graphics.Paint;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
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
public final class DrawStyleSpan_androidKt {
    public static final Paint.Cap a(int i3) {
        StrokeCap.Companion companion = StrokeCap.f25935b;
        return StrokeCap.g(i3, companion.a()) ? Paint.Cap.BUTT : StrokeCap.g(i3, companion.b()) ? Paint.Cap.ROUND : StrokeCap.g(i3, companion.c()) ? Paint.Cap.SQUARE : Paint.Cap.BUTT;
    }

    public static final Paint.Join b(int i3) {
        StrokeJoin.Companion companion = StrokeJoin.f25940b;
        return StrokeJoin.g(i3, companion.b()) ? Paint.Join.MITER : StrokeJoin.g(i3, companion.c()) ? Paint.Join.ROUND : StrokeJoin.g(i3, companion.a()) ? Paint.Join.BEVEL : Paint.Join.MITER;
    }
}
