package com.superwall.sdk.analytics.session;

import java.util.Date;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class AppSessionLogic {
    public static final AppSessionLogic INSTANCE = new AppSessionLogic();

    private AppSessionLogic() {
    }

    public static /* synthetic */ boolean didStartNewSession$default(AppSessionLogic appSessionLogic, Date date, Long l3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            l3 = 3600000L;
        }
        return appSessionLogic.didStartNewSession(date, l3);
    }

    public final boolean didStartNewSession(Date date, Long l3) {
        if (date == null) {
            return true;
        }
        return System.currentTimeMillis() - date.getTime() > (l3 != null ? l3.longValue() : 3600000L);
    }
}
