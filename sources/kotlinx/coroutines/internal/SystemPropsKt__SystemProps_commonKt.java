package kotlinx.coroutines.internal;

import com.facebook.FacebookContentProvider;
import com.google.android.gms.common.api.Api;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final /* synthetic */ class SystemPropsKt__SystemProps_commonKt {
    public static final int a(String str, int i3, int i4, int i5) {
        return (int) SystemPropsKt.c(str, i3, i4, i5);
    }

    public static final long b(String str, long j3, long j4, long j5) {
        String strD = SystemPropsKt.d(str);
        if (strD == null) {
            return j3;
        }
        Long lW = StringsKt.w(strD);
        if (lW == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + strD + '\'').toString());
        }
        long jLongValue = lW.longValue();
        if (j4 <= jLongValue && jLongValue <= j5) {
            return jLongValue;
        }
        throw new IllegalStateException(("System property '" + str + "' should be in range " + j4 + FacebookContentProvider.INVALID_FILE_NAME + j5 + ", but is '" + jLongValue + '\'').toString());
    }

    public static final String c(String str, String str2) {
        String strD = SystemPropsKt.d(str);
        return strD == null ? str2 : strD;
    }

    public static final boolean d(String str, boolean z2) {
        String strD = SystemPropsKt.d(str);
        return strD != null ? Boolean.parseBoolean(strD) : z2;
    }

    public static /* synthetic */ int e(String str, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            i4 = 1;
        }
        if ((i6 & 8) != 0) {
            i5 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        return SystemPropsKt.b(str, i3, i4, i5);
    }

    public static /* synthetic */ long f(String str, long j3, long j4, long j5, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            j4 = 1;
        }
        long j6 = j4;
        if ((i3 & 8) != 0) {
            j5 = Long.MAX_VALUE;
        }
        return SystemPropsKt.c(str, j3, j6, j5);
    }
}
