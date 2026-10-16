package cz.mobilesoft.coreblock.rest.interceptor;

import cz.mobilesoft.coreblock.LockieApplication;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

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
public final class DiagnosticInterceptor implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f98508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function2 f98509b;

    public DiagnosticInterceptor(String filterByUrl, Function2 onRequestCaptured) {
        Intrinsics.checkNotNullParameter(filterByUrl, "filterByUrl");
        Intrinsics.checkNotNullParameter(onRequestCaptured, "onRequestCaptured");
        this.f98508a = filterByUrl;
        this.f98509b = onRequestCaptured;
    }

    @Override // okhttp3.Interceptor
    public Response a(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request requestL = chain.l();
        String string = requestL.k().toString();
        if (!StringsKt.a0(string, this.f98508a, false, 2, null)) {
            return chain.a(requestL);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strH = requestL.h();
        LogSanitizer logSanitizer = LogSanitizer.f98558a;
        DiagnosticRequestData diagnosticRequestData = new DiagnosticRequestData(jCurrentTimeMillis, string, strH, logSanitizer.i(requestL.f()), logSanitizer.h(requestL).b());
        CoroutineScope applicationScope = LockieApplication.f95365k;
        Intrinsics.checkNotNullExpressionValue(applicationScope, "applicationScope");
        BuildersKt__Builders_commonKt.d(applicationScope, null, null, new DiagnosticInterceptor$intercept$1(this, diagnosticRequestData, null), 3, null);
        return chain.a(requestL);
    }
}
