package com.superwall.sdk.billing;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingResult;
import com.superwall.sdk.billing.BillingError;
import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Logger;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class BillingClientUseCase<T> {
    private final boolean backoffForNetworkErrors;
    private final Function2<Long, Function1<? super BillingError, Unit>, Unit> executeRequestOnUIThread;
    private int foregroundBackoffAttempt;
    private final int maxRetries;
    private final Function1<BillingError, Unit> onError;
    private int retryAttempt;
    private long retryBackoffMilliseconds;
    private final UseCaseParams useCaseParams;

    /* JADX INFO: renamed from: com.superwall.sdk.billing.BillingClientUseCase$processResult$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<T, Unit> {
        AnonymousClass1(Object obj) {
            super(1, obj, BillingClientUseCase.class, "onOk", "onOk(Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m1259invoke(obj);
            return Unit.f139807a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m1259invoke(T t2) {
            ((BillingClientUseCase) this.receiver).onOk(t2);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.billing.BillingClientUseCase$processResult$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<BillingResult, Unit> {
        AnonymousClass2(Object obj) {
            super(1, obj, BillingClientUseCase.class, "forwardError", "forwardError(Lcom/android/billingclient/api/BillingResult;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((BillingResult) obj);
            return Unit.f139807a;
        }

        public final void invoke(BillingResult p02) {
            Intrinsics.checkNotNullParameter(p02, "p0");
            ((BillingClientUseCase) this.receiver).forwardError(p02);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BillingClientUseCase(UseCaseParams useCaseParams, Function1<? super BillingError, Unit> onError, Function2<? super Long, ? super Function1<? super BillingError, Unit>, Unit> executeRequestOnUIThread) {
        Intrinsics.checkNotNullParameter(useCaseParams, "useCaseParams");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(executeRequestOnUIThread, "executeRequestOnUIThread");
        this.useCaseParams = useCaseParams;
        this.onError = onError;
        this.executeRequestOnUIThread = executeRequestOnUIThread;
        this.maxRetries = 3;
        this.retryBackoffMilliseconds = 878L;
    }

    private final void backoffOrErrorIfUseInSession(Function1<? super BillingResult, Unit> function1, BillingResult billingResult) {
        if (this.useCaseParams.getAppInBackground()) {
            Logger.debug$default(Logger.INSTANCE, LogLevel.warn, LogScope.productsManager, "Billing is unavailable. App is in background, will retry with backoff.", (Map) null, (Throwable) null, 24, (Object) null);
            if (this.retryBackoffMilliseconds < BillingClientUseCaseKt.RETRY_TIMER_MAX_TIME_MILLISECONDS) {
                retryWithBackoff();
                return;
            } else {
                function1.invoke(billingResult);
                return;
            }
        }
        int i3 = this.retryAttempt;
        int i4 = this.maxRetries;
        if (i3 < i4) {
            Logger.debug$default(Logger.INSTANCE, LogLevel.warn, LogScope.productsManager, "Billing unavailable in foreground. Retry " + (i3 + 1) + "/" + i4 + " (immediate).", (Map) null, (Throwable) null, 24, (Object) null);
            this.retryAttempt = this.retryAttempt + 1;
            executeAsync();
            return;
        }
        int i5 = this.foregroundBackoffAttempt;
        if (i5 >= 2) {
            Logger.debug$default(Logger.INSTANCE, LogLevel.error, LogScope.productsManager, "Billing unavailable. Foreground retries exhausted.", (Map) null, (Throwable) null, 24, (Object) null);
            function1.invoke(billingResult);
            return;
        }
        long j3 = 250 << i5;
        Logger.debug$default(Logger.INSTANCE, LogLevel.warn, LogScope.productsManager, "Billing unavailable in foreground. Backoff retry " + (i5 + 1) + "/2 in " + j3 + "ms.", (Map) null, (Throwable) null, 24, (Object) null);
        this.foregroundBackoffAttempt = this.foregroundBackoffAttempt + 1;
        run(j3);
    }

    private final void backoffOrRetryNetworkError(Function1<? super BillingResult, Unit> function1, BillingResult billingResult) {
        int i3;
        if (getBackoffForNetworkErrors() && this.retryBackoffMilliseconds < BillingClientUseCaseKt.RETRY_TIMER_MAX_TIME_MILLISECONDS) {
            retryWithBackoff();
        } else if (getBackoffForNetworkErrors() || (i3 = this.retryAttempt) >= this.maxRetries) {
            function1.invoke(billingResult);
        } else {
            this.retryAttempt = i3 + 1;
            executeAsync();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void forwardError(BillingResult billingResult) {
        Object billingNotAvailable;
        String str = "Error loading products - DebugMessage: " + billingResult.a() + " ErrorCode: " + billingResult.c() + ".";
        int iC = billingResult.c();
        if (iC == -2 || iC == 3) {
            billingNotAvailable = new BillingError.BillingNotAvailable(str);
        } else {
            int iC2 = billingResult.c();
            String strA = billingResult.a();
            Intrinsics.checkNotNullExpressionValue(strA, "getDebugMessage(...)");
            billingNotAvailable = new BillingError.WithCode(iC2, strA);
        }
        Logger.debug$default(Logger.INSTANCE, LogLevel.error, LogScope.productsManager, str, (Map) null, (Throwable) null, 24, (Object) null);
        this.onError.invoke(billingNotAvailable);
    }

    private final String getStackTrace() {
        StringWriter stringWriter = new StringWriter();
        new Throwable().printStackTrace(new PrintWriter(stringWriter));
        String string = stringWriter.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void processResult$default(BillingClientUseCase billingClientUseCase, BillingResult billingResult, Object obj, Function1 function1, Function1 function12, int i3, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: processResult");
        }
        if ((i3 & 4) != 0) {
            function1 = new AnonymousClass1(billingClientUseCase);
        }
        if ((i3 & 8) != 0) {
            function12 = new AnonymousClass2(billingClientUseCase);
        }
        billingClientUseCase.processResult(billingResult, obj, function1, function12);
    }

    private final void retryWithBackoff() {
        long j3 = this.retryBackoffMilliseconds;
        this.retryBackoffMilliseconds = Math.min(((long) 2) * j3, BillingClientUseCaseKt.RETRY_TIMER_MAX_TIME_MILLISECONDS);
        run(j3);
    }

    public static /* synthetic */ void run$default(BillingClientUseCase billingClientUseCase, long j3, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: run");
        }
        if ((i3 & 1) != 0) {
            j3 = 0;
        }
        billingClientUseCase.run(j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit run$lambda$0(BillingClientUseCase billingClientUseCase, BillingError billingError) {
        if (billingError == null) {
            billingClientUseCase.executeAsync();
        } else {
            billingClientUseCase.onError.invoke(billingError);
        }
        return Unit.f139807a;
    }

    public abstract void executeAsync();

    protected boolean getBackoffForNetworkErrors() {
        return this.backoffForNetworkErrors;
    }

    public final Function2<Long, Function1<? super BillingError, Unit>, Unit> getExecuteRequestOnUIThread() {
        return this.executeRequestOnUIThread;
    }

    public abstract void onOk(T t2);

    public final void processResult(BillingResult billingResult, T t2, Function1<? super T, Unit> onSuccess, Function1<? super BillingResult, Unit> onError) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        int iC = billingResult.c();
        if (iC == -1) {
            Logger.debug$default(Logger.INSTANCE, LogLevel.error, LogScope.productsManager, "Billing Service disconnected.", (Map) null, (Throwable) null, 24, (Object) null);
            run$default(this, 0L, 1, null);
            return;
        }
        if (iC == 0) {
            this.retryBackoffMilliseconds = 878L;
            onSuccess.invoke(t2);
        } else if (iC == 2) {
            backoffOrErrorIfUseInSession(onError, billingResult);
        } else if (iC == 6 || iC == 12) {
            backoffOrRetryNetworkError(onError, billingResult);
        } else {
            onError.invoke(billingResult);
        }
    }

    public final void run(long j3) {
        this.executeRequestOnUIThread.invoke(Long.valueOf(j3), new Function1() { // from class: com.superwall.sdk.billing.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BillingClientUseCase.run$lambda$0(this.f93455a, (BillingError) obj);
            }
        });
    }

    protected final void withConnectedClient(BillingClient billingClient, Function1<? super BillingClient, Unit> receivingFunction) {
        Intrinsics.checkNotNullParameter(receivingFunction, "receivingFunction");
        if (billingClient != null) {
            if (!billingClient.f()) {
                billingClient = null;
            }
            if (billingClient != null) {
                receivingFunction.invoke(billingClient);
                return;
            }
        }
        Logger.debug$default(Logger.INSTANCE, LogLevel.warn, LogScope.productsManager, "Billing Service disconnected.  Stack trace: " + getStackTrace(), (Map) null, (Throwable) null, 24, (Object) null);
    }
}
