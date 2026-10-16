package com.google.maps.android.compose;

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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class InputHandlerKt {
    /* JADX WARN: Removed duplicated region for block: B:100:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0237 A[LOOP:0: B:167:0x0235->B:168:0x0237, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x030c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x010f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(kotlin.jvm.functions.Function1 r37, kotlin.jvm.functions.Function1 r38, kotlin.jvm.functions.Function1 r39, kotlin.jvm.functions.Function1 r40, kotlin.jvm.functions.Function1 r41, kotlin.jvm.functions.Function1 r42, kotlin.jvm.functions.Function1 r43, kotlin.jvm.functions.Function1 r44, kotlin.jvm.functions.Function1 r45, kotlin.jvm.functions.Function1 r46, kotlin.jvm.functions.Function1 r47, androidx.compose.runtime.Composer r48, final int r49, final int r50, final int r51) {
        /*
            Method dump skipped, instruction units count: 794
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.maps.android.compose.InputHandlerKt.a(kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int, int):void");
    }
}
