package androidx.credentials.playservices.controllers;

import android.content.Context;
import android.os.Bundle;
import android.os.CancellationSignal;
import androidx.credentials.CredentialManagerCallback;
import androidx.credentials.exceptions.CreateCredentialCancellationException;
import androidx.credentials.exceptions.CreateCredentialUnknownException;
import androidx.credentials.exceptions.GetCredentialCancellationException;
import androidx.credentials.exceptions.GetCredentialUnknownException;
import androidx.credentials.playservices.CredentialProviderPlayServicesImpl;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

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
public abstract class CredentialProviderController<T1, T2, R2, R1, E1> extends CredentialProviderBaseController {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f35101f = new Companion(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f35102e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        protected final void a(CancellationSignal cancellationSignal, Function0 onResultOrException) {
            Intrinsics.checkNotNullParameter(onResultOrException, "onResultOrException");
            if (CredentialProviderPlayServicesImpl.Companion.a(cancellationSignal)) {
                return;
            }
            onResultOrException.invoke();
        }

        public final String b() {
            return "activity is cancelled by the user.";
        }

        public final String c(int i3) {
            return "activity with result code: " + i3 + " indicating not RESULT_OK";
        }

        protected final boolean d(int i3, Function2 cancelOnError, final Function1 onError, CancellationSignal cancellationSignal) {
            Intrinsics.checkNotNullParameter(cancelOnError, "cancelOnError");
            Intrinsics.checkNotNullParameter(onError, "onError");
            if (i3 == -1) {
                return false;
            }
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.f140144a = new CreateCredentialUnknownException(c(i3));
            if (i3 == 0) {
                objectRef.f140144a = new CreateCredentialCancellationException(b());
            }
            cancelOnError.invoke(cancellationSignal, new Function0<Unit>() { // from class: androidx.credentials.playservices.controllers.CredentialProviderController$Companion$maybeReportErrorResultCodeCreate$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m326invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m326invoke() {
                    onError.invoke(objectRef.f140144a);
                }
            });
            return true;
        }

        protected final boolean e(int i3, Function2 cancelOnError, final Function1 onError, CancellationSignal cancellationSignal) {
            Intrinsics.checkNotNullParameter(cancelOnError, "cancelOnError");
            Intrinsics.checkNotNullParameter(onError, "onError");
            if (i3 == -1) {
                return false;
            }
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.f140144a = new GetCredentialUnknownException(c(i3));
            if (i3 == 0) {
                objectRef.f140144a = new GetCredentialCancellationException(b());
            }
            cancelOnError.invoke(cancellationSignal, new Function0<Unit>() { // from class: androidx.credentials.playservices.controllers.CredentialProviderController$Companion$maybeReportErrorResultCodeGet$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m327invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m327invoke() {
                    onError.invoke(objectRef.f140144a);
                }
            });
            return true;
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CredentialProviderController(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f35102e = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final void e(CancellationSignal cancellationSignal, Function0 function0) {
        f35101f.a(cancellationSignal, function0);
    }

    protected static final boolean g(int i3, Function2 function2, Function1 function1, CancellationSignal cancellationSignal) {
        return f35101f.d(i3, function2, function1, cancellationSignal);
    }

    protected static final boolean h(int i3, Function2 function2, Function1 function1, CancellationSignal cancellationSignal) {
        return f35101f.e(i3, function2, function1, cancellationSignal);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean f(Bundle resultData, Function2 conversionFn, Executor executor, CredentialManagerCallback callback, CancellationSignal cancellationSignal) {
        Intrinsics.checkNotNullParameter(resultData, "resultData");
        Intrinsics.checkNotNullParameter(conversionFn, "conversionFn");
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!resultData.getBoolean("FAILURE_RESPONSE")) {
            return false;
        }
        e(cancellationSignal, new CredentialProviderController$maybeReportErrorFromResultReceiver$1(executor, callback, conversionFn.invoke(resultData.getString("EXCEPTION_TYPE"), resultData.getString("EXCEPTION_MESSAGE"))));
        return true;
    }
}
