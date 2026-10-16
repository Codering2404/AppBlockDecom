package androidx.work.impl.utils;

import android.content.Context;
import androidx.work.Configuration;
import androidx.work.Logger;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class ProcessUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f55162a;

    static {
        String strI = Logger.i("ProcessUtils");
        Intrinsics.checkNotNullExpressionValue(strI, "tagWithPrefix(\"ProcessUtils\")");
        f55162a = strI;
    }

    private static final String a(Context context) {
        return Api28Impl.f55132a.a();
    }

    public static final boolean b(Context context, Configuration configuration) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        String strA = a(context);
        String strC = configuration.c();
        return (strC == null || strC.length() == 0) ? Intrinsics.areEqual(strA, context.getApplicationInfo().processName) : Intrinsics.areEqual(strA, configuration.c());
    }
}
