package androidx.compose.foundation.text.input.internal;

import android.view.inputmethod.CursorAnchorInfo;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
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
public final class CursorAnchorInfoApi34Helper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CursorAnchorInfoApi34Helper f10290a = new CursorAnchorInfoApi34Helper();

    private CursorAnchorInfoApi34Helper() {
    }

    public static final CursorAnchorInfo.Builder a(CursorAnchorInfo.Builder builder, TextLayoutResult textLayoutResult, Rect rect) {
        int iR;
        int iR2;
        if (!rect.y() && (iR = textLayoutResult.r(rect.r())) <= (iR2 = textLayoutResult.r(rect.i()))) {
            while (true) {
                builder.addVisibleLineBounds(textLayoutResult.s(iR), textLayoutResult.v(iR), textLayoutResult.t(iR), textLayoutResult.m(iR));
                if (iR == iR2) {
                    break;
                }
                iR++;
            }
        }
        return builder;
    }
}
