package cz.mobilesoft.coreblock.util.runnability;

import com.revenuecat.purchases.common.Constants;
import cz.mobilesoft.coreblock.util.helperextension.StringHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
public final class ProcessNameHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProcessNameHelper f129616a = new ProcessNameHelper();

    private ProcessNameHelper() {
    }

    public static final String a(String str, String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        if (str == null) {
            return "unknown";
        }
        if (Intrinsics.areEqual(str, packageName)) {
            return "main";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(packageName);
        sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        return !StringsKt.U(str, sb.toString(), false, 2, null) ? str : StringHelper.f128649a.k(str);
    }
}
