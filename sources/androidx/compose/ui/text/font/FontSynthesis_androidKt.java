package androidx.compose.ui.text.font;

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
public final class FontSynthesis_androidKt {
    /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(int r4, java.lang.Object r5, androidx.compose.ui.text.font.Font r6, androidx.compose.ui.text.font.FontWeight r7, int r8) {
        /*
            boolean r0 = r5 instanceof android.graphics.Typeface
            if (r0 != 0) goto L5
            return r5
        L5:
            boolean r0 = androidx.compose.ui.text.font.FontSynthesis.k(r4)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L33
            androidx.compose.ui.text.font.FontWeight r0 = r6.b()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r7)
            if (r0 != 0) goto L33
            androidx.compose.ui.text.font.FontWeight$Companion r0 = androidx.compose.ui.text.font.FontWeight.f29233b
            androidx.compose.ui.text.font.FontWeight r3 = androidx.compose.ui.text.font.AndroidFontUtils_androidKt.a(r0)
            int r3 = r7.compareTo(r3)
            if (r3 < 0) goto L33
            androidx.compose.ui.text.font.FontWeight r3 = r6.b()
            androidx.compose.ui.text.font.FontWeight r0 = androidx.compose.ui.text.font.AndroidFontUtils_androidKt.a(r0)
            int r0 = r3.compareTo(r0)
            if (r0 >= 0) goto L33
            r0 = r2
            goto L34
        L33:
            r0 = r1
        L34:
            boolean r4 = androidx.compose.ui.text.font.FontSynthesis.j(r4)
            if (r4 == 0) goto L45
            int r4 = r6.d()
            boolean r4 = androidx.compose.ui.text.font.FontStyle.f(r8, r4)
            if (r4 != 0) goto L45
            r1 = r2
        L45:
            if (r1 != 0) goto L4a
            if (r0 != 0) goto L4a
            return r5
        L4a:
            if (r0 == 0) goto L51
            int r4 = r7.n()
            goto L59
        L51:
            androidx.compose.ui.text.font.FontWeight r4 = r6.b()
            int r4 = r4.n()
        L59:
            if (r1 == 0) goto L66
            androidx.compose.ui.text.font.FontStyle$Companion r6 = androidx.compose.ui.text.font.FontStyle.f29211b
            int r6 = r6.a()
            boolean r6 = androidx.compose.ui.text.font.FontStyle.f(r8, r6)
            goto L74
        L66:
            int r6 = r6.d()
            androidx.compose.ui.text.font.FontStyle$Companion r7 = androidx.compose.ui.text.font.FontStyle.f29211b
            int r7 = r7.a()
            boolean r6 = androidx.compose.ui.text.font.FontStyle.f(r6, r7)
        L74:
            androidx.compose.ui.text.font.TypefaceHelperMethodsApi28 r7 = androidx.compose.ui.text.font.TypefaceHelperMethodsApi28.f29273a
            android.graphics.Typeface r5 = (android.graphics.Typeface) r5
            android.graphics.Typeface r4 = r7.a(r5, r4, r6)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.FontSynthesis_androidKt.a(int, java.lang.Object, androidx.compose.ui.text.font.Font, androidx.compose.ui.text.font.FontWeight, int):java.lang.Object");
    }
}
