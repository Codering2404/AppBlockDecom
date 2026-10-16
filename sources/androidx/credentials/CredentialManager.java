package androidx.credentials;

import android.content.Context;
import android.os.CancellationSignal;
import androidx.credentials.exceptions.ClearCredentialException;
import androidx.credentials.exceptions.GetCredentialException;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public interface CredentialManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f34753a = Companion.f34754a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f34754a = new Companion();

        private Companion() {
        }

        public final CredentialManager a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new CredentialManagerImpl(context);
        }
    }

    static /* synthetic */ Object a(CredentialManager credentialManager, Context context, GetCredentialRequest getCredentialRequest, Continuation continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        final CancellationSignal cancellationSignal = new CancellationSignal();
        cancellableContinuationImpl.m(new Function1<Throwable, Unit>() { // from class: androidx.credentials.CredentialManager$getCredential$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.f139807a;
            }

            public final void invoke(Throwable th) {
                cancellationSignal.cancel();
            }
        });
        credentialManager.e(context, getCredentialRequest, cancellationSignal, new c(), new CredentialManagerCallback<GetCredentialResponse, GetCredentialException>() { // from class: androidx.credentials.CredentialManager$getCredential$2$callback$1
            @Override // androidx.credentials.CredentialManagerCallback
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(GetCredentialException e3) {
                Intrinsics.checkNotNullParameter(e3, "e");
                if (cancellableContinuationImpl.isActive()) {
                    CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
                    Result.Companion companion = Result.f139772b;
                    cancellableContinuation.resumeWith(Result.b(ResultKt.a(e3)));
                }
            }

            @Override // androidx.credentials.CredentialManagerCallback
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void onResult(GetCredentialResponse result) {
                Intrinsics.checkNotNullParameter(result, "result");
                if (cancellableContinuationImpl.isActive()) {
                    cancellableContinuationImpl.resumeWith(Result.b(result));
                }
            }
        });
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV;
    }

    static /* synthetic */ Object f(CredentialManager credentialManager, ClearCredentialStateRequest clearCredentialStateRequest, Continuation continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        final CancellationSignal cancellationSignal = new CancellationSignal();
        cancellableContinuationImpl.m(new Function1<Throwable, Unit>() { // from class: androidx.credentials.CredentialManager$clearCredentialState$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.f139807a;
            }

            public final void invoke(Throwable th) {
                cancellationSignal.cancel();
            }
        });
        credentialManager.d(clearCredentialStateRequest, cancellationSignal, new c(), new CredentialManagerCallback<Void, ClearCredentialException>() { // from class: androidx.credentials.CredentialManager$clearCredentialState$2$callback$1
            @Override // androidx.credentials.CredentialManagerCallback
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(ClearCredentialException e3) {
                Intrinsics.checkNotNullParameter(e3, "e");
                if (cancellableContinuationImpl.isActive()) {
                    CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
                    Result.Companion companion = Result.f139772b;
                    cancellableContinuation.resumeWith(Result.b(ResultKt.a(e3)));
                }
            }

            @Override // androidx.credentials.CredentialManagerCallback
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void onResult(Void r2) {
                if (cancellableContinuationImpl.isActive()) {
                    CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
                    Result.Companion companion = Result.f139772b;
                    cancellableContinuation.resumeWith(Result.b(Unit.f139807a));
                }
            }
        });
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV == IntrinsicsKt.f() ? objV : Unit.f139807a;
    }

    default Object b(Context context, GetCredentialRequest getCredentialRequest, Continuation continuation) {
        return a(this, context, getCredentialRequest, continuation);
    }

    default Object c(ClearCredentialStateRequest clearCredentialStateRequest, Continuation continuation) {
        return f(this, clearCredentialStateRequest, continuation);
    }

    void d(ClearCredentialStateRequest clearCredentialStateRequest, CancellationSignal cancellationSignal, Executor executor, CredentialManagerCallback credentialManagerCallback);

    void e(Context context, GetCredentialRequest getCredentialRequest, CancellationSignal cancellationSignal, Executor executor, CredentialManagerCallback credentialManagerCallback);
}
