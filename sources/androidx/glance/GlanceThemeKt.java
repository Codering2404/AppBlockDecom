package androidx.glance;

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
public final class GlanceThemeKt {
    /* JADX WARN: Removed duplicated region for block: B:41:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(final androidx.glance.color.ColorProviders r4, final kotlin.jvm.functions.Function2 r5, androidx.compose.runtime.Composer r6, final int r7, final int r8) {
        /*
            r0 = -1977781714(0xffffffff8a1d722e, float:-7.58075E-33)
            androidx.compose.runtime.Composer r6 = r6.k(r0)
            r1 = r7 & 14
            if (r1 != 0) goto L1a
            r1 = r8 & 1
            if (r1 != 0) goto L17
            boolean r1 = r6.Z(r4)
            if (r1 == 0) goto L17
            r1 = 4
            goto L18
        L17:
            r1 = 2
        L18:
            r1 = r1 | r7
            goto L1b
        L1a:
            r1 = r7
        L1b:
            r2 = r8 & 2
            if (r2 == 0) goto L22
            r1 = r1 | 48
            goto L32
        L22:
            r2 = r7 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L32
            boolean r2 = r6.Z(r5)
            if (r2 == 0) goto L2f
            r2 = 32
            goto L31
        L2f:
            r2 = 16
        L31:
            r1 = r1 | r2
        L32:
            r2 = r1 & 91
            r3 = 18
            if (r2 != r3) goto L43
            boolean r2 = r6.l()
            if (r2 != 0) goto L3f
            goto L43
        L3f:
            r6.Q()
            goto L95
        L43:
            r6.J()
            r2 = r7 & 1
            if (r2 == 0) goto L5b
            boolean r2 = r6.S()
            if (r2 == 0) goto L51
            goto L5b
        L51:
            r6.Q()
            r2 = r8 & 1
            if (r2 == 0) goto L6a
        L58:
            r1 = r1 & (-15)
            goto L6a
        L5b:
            r2 = r8 & 1
            if (r2 == 0) goto L6a
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.glance.CompositionLocalsKt.a()
            java.lang.Object r4 = r6.q(r4)
            androidx.glance.color.ColorProviders r4 = (androidx.glance.color.ColorProviders) r4
            goto L58
        L6a:
            r6.z()
            boolean r2 = androidx.compose.runtime.ComposerKt.M()
            if (r2 == 0) goto L79
            r2 = -1
            java.lang.String r3 = "androidx.glance.GlanceTheme (GlanceTheme.kt:39)"
            androidx.compose.runtime.ComposerKt.U(r0, r1, r2, r3)
        L79:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.glance.CompositionLocalsKt.a()
            androidx.compose.runtime.ProvidedValue r0 = r0.d(r4)
            androidx.compose.runtime.ProvidedValue[] r0 = new androidx.compose.runtime.ProvidedValue[]{r0}
            r1 = r1 & 112(0x70, float:1.57E-43)
            r1 = r1 | 8
            androidx.compose.runtime.CompositionLocalKt.c(r0, r5, r6, r1)
            boolean r0 = androidx.compose.runtime.ComposerKt.M()
            if (r0 == 0) goto L95
            androidx.compose.runtime.ComposerKt.T()
        L95:
            androidx.compose.runtime.ScopeUpdateScope r6 = r6.n()
            if (r6 != 0) goto L9c
            return
        L9c:
            androidx.glance.GlanceThemeKt$GlanceTheme$1 r0 = new androidx.glance.GlanceThemeKt$GlanceTheme$1
            r0.<init>()
            r6.a(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.glance.GlanceThemeKt.a(androidx.glance.color.ColorProviders, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }
}
