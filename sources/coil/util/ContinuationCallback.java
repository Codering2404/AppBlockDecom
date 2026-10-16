package coil.util;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import okhttp3.Call;
import okhttp3.Callback;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
final class ContinuationCallback implements Callback, Function1<Throwable, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Call f56222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CancellableContinuation f56223b;

    public ContinuationCallback(Call call, CancellableContinuation cancellableContinuation) {
        this.f56222a = call;
        this.f56223b = cancellableContinuation;
    }

    @Override // okhttp3.Callback
    public void c(Call call, IOException iOException) {
        if (call.C()) {
            return;
        }
        CancellableContinuation cancellableContinuation = this.f56223b;
        Result.Companion companion = Result.f139772b;
        cancellableContinuation.resumeWith(Result.b(ResultKt.a(iOException)));
    }

    @Override // okhttp3.Callback
    public void d(Call call, Response response) {
        this.f56223b.resumeWith(Result.b(response));
    }

    public void e(Throwable th) {
        try {
            this.f56222a.cancel();
        } catch (Throwable unused) {
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        e((Throwable) obj);
        return Unit.f139807a;
    }
}
