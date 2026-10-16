package androidx.glance;

import androidx.glance.text.EmittableText;
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
public final class ButtonKt {
    /* JADX WARN: Removed duplicated region for block: B:101:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0177 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0117  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(final java.lang.String r19, final androidx.glance.action.Action r20, androidx.glance.GlanceModifier r21, boolean r22, androidx.glance.text.TextStyle r23, androidx.glance.ButtonColors r24, int r25, androidx.compose.runtime.Composer r26, final int r27, final int r28) {
        /*
            Method dump skipped, instruction units count: 391
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.glance.ButtonKt.a(java.lang.String, androidx.glance.action.Action, androidx.glance.GlanceModifier, boolean, androidx.glance.text.TextStyle, androidx.glance.ButtonColors, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x017e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0118  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void b(final java.lang.String r19, final kotlin.jvm.functions.Function0 r20, androidx.glance.GlanceModifier r21, boolean r22, androidx.glance.text.TextStyle r23, androidx.glance.ButtonColors r24, int r25, androidx.compose.runtime.Composer r26, final int r27, final int r28) {
        /*
            Method dump skipped, instruction units count: 396
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.glance.ButtonKt.b(java.lang.String, kotlin.jvm.functions.Function0, androidx.glance.GlanceModifier, boolean, androidx.glance.text.TextStyle, androidx.glance.ButtonColors, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01c0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0111  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void c(final java.lang.String r21, final kotlin.jvm.functions.Function0 r22, androidx.glance.GlanceModifier r23, boolean r24, androidx.glance.text.TextStyle r25, androidx.glance.ButtonColors r26, int r27, java.lang.String r28, androidx.compose.runtime.Composer r29, final int r30, final int r31) {
        /*
            Method dump skipped, instruction units count: 460
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.glance.ButtonKt.c(java.lang.String, kotlin.jvm.functions.Function0, androidx.glance.GlanceModifier, boolean, androidx.glance.text.TextStyle, androidx.glance.ButtonColors, int, java.lang.String, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0205 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0106  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void d(final java.lang.String r24, final androidx.glance.action.Action r25, androidx.glance.GlanceModifier r26, boolean r27, androidx.glance.text.TextStyle r28, androidx.glance.ButtonColors r29, int r30, androidx.compose.runtime.Composer r31, final int r32, final int r33) {
        /*
            Method dump skipped, instruction units count: 529
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.glance.ButtonKt.d(java.lang.String, androidx.glance.action.Action, androidx.glance.GlanceModifier, boolean, androidx.glance.text.TextStyle, androidx.glance.ButtonColors, int, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final EmittableText e(EmittableButton emittableButton) {
        EmittableText emittableText = new EmittableText();
        emittableText.b(emittableButton.a());
        emittableText.h(emittableButton.f());
        emittableText.g(emittableButton.e());
        emittableText.f(emittableButton.d());
        return emittableText;
    }
}
