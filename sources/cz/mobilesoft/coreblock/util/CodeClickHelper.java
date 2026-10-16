package cz.mobilesoft.coreblock.util;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
public final class CodeClickHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f127783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f127784b;

    public final void a(Function0 onBackdoorDialogSuccess) {
        Intrinsics.checkNotNullParameter(onBackdoorDialogSuccess, "onBackdoorDialogSuccess");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f127783a > 1000) {
            this.f127784b = 1;
        } else {
            int i3 = this.f127784b;
            if (i3 < 4) {
                this.f127784b = i3 + 1;
            } else {
                this.f127784b = 0;
                onBackdoorDialogSuccess.invoke();
            }
        }
        this.f127783a = jCurrentTimeMillis;
    }
}
