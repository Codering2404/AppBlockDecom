package androidx.compose.foundation.lazy.grid;

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
public final class LazyGridKt {
    /* JADX WARN: Removed duplicated region for block: B:101:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:191:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0100  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(androidx.compose.ui.Modifier r23, final androidx.compose.foundation.lazy.grid.LazyGridState r24, final androidx.compose.foundation.lazy.grid.LazyGridSlotsProvider r25, androidx.compose.foundation.layout.PaddingValues r26, boolean r27, final boolean r28, androidx.compose.foundation.gestures.FlingBehavior r29, final boolean r30, final androidx.compose.foundation.OverscrollEffect r31, final androidx.compose.foundation.layout.Arrangement.Vertical r32, final androidx.compose.foundation.layout.Arrangement.Horizontal r33, final kotlin.jvm.functions.Function1 r34, androidx.compose.runtime.Composer r35, final int r36, final int r37, final int r38) {
        /*
            Method dump skipped, instruction units count: 811
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridKt.a(androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.grid.LazyGridState, androidx.compose.foundation.lazy.grid.LazyGridSlotsProvider, androidx.compose.foundation.layout.PaddingValues, boolean, boolean, androidx.compose.foundation.gestures.FlingBehavior, boolean, androidx.compose.foundation.OverscrollEffect, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x008f A[PHI: r3
      0x008f: PHI (r3v23 boolean) = (r3v21 boolean), (r3v24 boolean) binds: [B:44:0x008d, B:40:0x0087] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00f4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final kotlin.jvm.functions.Function2 b(final kotlin.jvm.functions.Function0 r18, final androidx.compose.foundation.lazy.grid.LazyGridState r19, final androidx.compose.foundation.lazy.grid.LazyGridSlotsProvider r20, final androidx.compose.foundation.layout.PaddingValues r21, final boolean r22, boolean r23, final androidx.compose.foundation.layout.Arrangement.Horizontal r24, final androidx.compose.foundation.layout.Arrangement.Vertical r25, final kotlinx.coroutines.CoroutineScope r26, final androidx.compose.ui.graphics.GraphicsContext r27, final androidx.compose.foundation.lazy.layout.StickyItemsPlacement r28, androidx.compose.runtime.Composer r29, int r30, int r31) {
        /*
            Method dump skipped, instruction units count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridKt.b(kotlin.jvm.functions.Function0, androidx.compose.foundation.lazy.grid.LazyGridState, androidx.compose.foundation.lazy.grid.LazyGridSlotsProvider, androidx.compose.foundation.layout.PaddingValues, boolean, boolean, androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.foundation.layout.Arrangement$Vertical, kotlinx.coroutines.CoroutineScope, androidx.compose.ui.graphics.GraphicsContext, androidx.compose.foundation.lazy.layout.StickyItemsPlacement, androidx.compose.runtime.Composer, int, int):kotlin.jvm.functions.Function2");
    }
}
