package cz.mobilesoft.coreblock.view.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.LayoutCoordinates;
import coil.request.ImageResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ServerImageKt {
    /* JADX WARN: Removed duplicated region for block: B:133:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:138:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void c(final java.lang.String r24, final java.lang.String r25, androidx.compose.ui.Modifier r26, androidx.compose.ui.Alignment r27, androidx.compose.ui.graphics.painter.Painter r28, androidx.compose.runtime.Composer r29, final int r30, final int r31) {
        /*
            Method dump skipped, instruction units count: 820
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.ServerImageKt.c(java.lang.String, java.lang.String, androidx.compose.ui.Modifier, androidx.compose.ui.Alignment, androidx.compose.ui.graphics.painter.Painter, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final ImageResult d(MutableState mutableState) {
        return (ImageResult) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(String str, String str2, Modifier modifier, Alignment alignment, Painter painter, int i3, int i4, Composer composer, int i5) {
        c(str, str2, modifier, alignment, painter, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(MutableState mutableState, ImageResult imageResult) {
        mutableState.setValue(imageResult);
    }

    private static final Painter g(MutableState mutableState) {
        return (Painter) mutableState.getValue();
    }

    private static final void h(MutableState mutableState, Painter painter) {
        mutableState.setValue(painter);
    }

    private static final int i(MutableState mutableState) {
        return ((Number) mutableState.getValue()).intValue();
    }

    private static final void j(MutableState mutableState, int i3) {
        mutableState.setValue(Integer.valueOf(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(MutableState mutableState, LayoutCoordinates coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        if (i(mutableState) == 0) {
            j(mutableState, (int) (coordinates.a() >> 32));
        }
        return Unit.f139807a;
    }
}
