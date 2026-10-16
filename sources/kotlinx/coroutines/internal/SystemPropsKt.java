package kotlinx.coroutines.internal;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class SystemPropsKt {
    public static final int a() {
        return SystemPropsKt__SystemPropsKt.a();
    }

    public static final int b(String str, int i3, int i4, int i5) {
        return SystemPropsKt__SystemProps_commonKt.a(str, i3, i4, i5);
    }

    public static final long c(String str, long j3, long j4, long j5) {
        return SystemPropsKt__SystemProps_commonKt.b(str, j3, j4, j5);
    }

    public static final String d(String str) {
        return SystemPropsKt__SystemPropsKt.b(str);
    }

    public static final String e(String str, String str2) {
        return SystemPropsKt__SystemProps_commonKt.c(str, str2);
    }

    public static final boolean f(String str, boolean z2) {
        return SystemPropsKt__SystemProps_commonKt.d(str, z2);
    }
}
