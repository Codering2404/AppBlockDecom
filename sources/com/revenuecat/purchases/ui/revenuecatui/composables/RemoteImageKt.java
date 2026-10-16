package com.revenuecat.purchases.ui.revenuecatui.composables;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import coil.request.CachePolicy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class RemoteImageKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:148:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x010e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void AsyncImage(final com.revenuecat.purchases.ui.revenuecatui.composables.ImageSource r32, final coil.request.ImageRequest r33, final coil.ImageLoader r34, androidx.compose.ui.Modifier r35, androidx.compose.ui.graphics.painter.Painter r36, final androidx.compose.ui.layout.ContentScale r37, final java.lang.String r38, final float r39, androidx.compose.ui.graphics.ColorFilter r40, kotlin.jvm.functions.Function1<? super coil.compose.AsyncImagePainter.State.Error, kotlin.Unit> r41, androidx.compose.runtime.Composer r42, final int r43, final int r44) {
        /*
            Method dump skipped, instruction units count: 516
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.composables.RemoteImageKt.AsyncImage(com.revenuecat.purchases.ui.revenuecatui.composables.ImageSource, coil.request.ImageRequest, coil.ImageLoader, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.painter.Painter, androidx.compose.ui.layout.ContentScale, java.lang.String, float, androidx.compose.ui.graphics.ColorFilter, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:100:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:154:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0108  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void Image(final com.revenuecat.purchases.ui.revenuecatui.composables.ImageSource r18, final com.revenuecat.purchases.ui.revenuecatui.composables.ImageSource r19, androidx.compose.ui.Modifier r20, final androidx.compose.ui.layout.ContentScale r21, final java.lang.String r22, final coil.transform.Transformation r23, final float r24, final androidx.compose.ui.graphics.ColorFilter r25, androidx.compose.runtime.Composer r26, final int r27, final int r28) {
        /*
            Method dump skipped, instruction units count: 769
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.composables.RemoteImageKt.Image(com.revenuecat.purchases.ui.revenuecatui.composables.ImageSource, com.revenuecat.purchases.ui.revenuecatui.composables.ImageSource, androidx.compose.ui.Modifier, androidx.compose.ui.layout.ContentScale, java.lang.String, coil.transform.Transformation, float, androidx.compose.ui.graphics.ColorFilter, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final CachePolicy Image$lambda$2(MutableState<CachePolicy> mutableState) {
        return (CachePolicy) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ImageForPreviews(Modifier modifier, Composer composer, final int i3) {
        int i4;
        final Modifier modifier2;
        Composer composerK = composer.k(-523416196);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(modifier) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i4 & 3) == 2 && composerK.l()) {
            composerK.Q();
            modifier2 = modifier;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-523416196, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.ImageForPreviews (RemoteImage.kt:211)");
            }
            modifier2 = modifier;
            BoxKt.a(BackgroundKt.d(modifier2, MaterialTheme.f18110a.a(composerK, MaterialTheme.f18111b).j0(), null, 2, null), composerK, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.RemoteImageKt.ImageForPreviews.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    RemoteImageKt.ImageForPreviews(modifier2, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0106  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void LocalImage(final int r20, androidx.compose.ui.Modifier r21, androidx.compose.ui.layout.ContentScale r22, java.lang.String r23, coil.transform.Transformation r24, float r25, androidx.compose.ui.graphics.ColorFilter r26, androidx.compose.runtime.Composer r27, final int r28, final int r29) {
        /*
            Method dump skipped, instruction units count: 357
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.composables.RemoteImageKt.LocalImage(int, androidx.compose.ui.Modifier, androidx.compose.ui.layout.ContentScale, java.lang.String, coil.transform.Transformation, float, androidx.compose.ui.graphics.ColorFilter, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void RemoteImage(final java.lang.String r22, androidx.compose.ui.Modifier r23, java.lang.String r24, androidx.compose.ui.layout.ContentScale r25, java.lang.String r26, coil.transform.Transformation r27, float r28, androidx.compose.ui.graphics.ColorFilter r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instruction units count: 413
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.composables.RemoteImageKt.RemoteImage(java.lang.String, androidx.compose.ui.Modifier, java.lang.String, androidx.compose.ui.layout.ContentScale, java.lang.String, coil.transform.Transformation, float, androidx.compose.ui.graphics.ColorFilter, androidx.compose.runtime.Composer, int, int):void");
    }
}
