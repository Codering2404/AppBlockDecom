package com.revenuecat.purchases.common;

import android.os.Handler;
import android.os.Looper;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.networking.HTTPResult;
import com.revenuecat.purchases.common.networking.NullPointerReadingErrorStreamException;
import com.revenuecat.purchases.common.verification.SignatureVerificationException;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt;
import kotlin.time.Duration;
import org.json.JSONException;

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
/* JADX INFO: loaded from: classes5.dex */
@Metadata
public class Dispatcher {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final double INTEGRATION_TEST_DELAY_PERCENTAGE = 0.01d;
    private final ExecutorService executorService;
    private final Handler mainHandler;
    private final boolean runningIntegrationTests;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class AsyncCall implements Runnable {
        public abstract HTTPResult call() throws JSONException, IOException;

        public void onCompletion(HTTPResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
        }

        public void onError(PurchasesError error) {
            Intrinsics.checkNotNullParameter(error, "error");
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                onCompletion(call());
            } catch (NullPointerReadingErrorStreamException e3) {
                PurchasesError purchasesError = ErrorsKt.toPurchasesError(e3);
                LogUtilsKt.errorLog(purchasesError);
                onError(purchasesError);
            } catch (SignatureVerificationException e4) {
                PurchasesError purchasesError2 = ErrorsKt.toPurchasesError(e4);
                LogUtilsKt.errorLog(purchasesError2);
                onError(purchasesError2);
            } catch (IOException e5) {
                PurchasesError purchasesError3 = ErrorsKt.toPurchasesError(e5);
                LogUtilsKt.errorLog(purchasesError3);
                onError(purchasesError3);
            } catch (SecurityException e6) {
                PurchasesError purchasesError4 = ErrorsKt.toPurchasesError(e6);
                LogUtilsKt.errorLog(purchasesError4);
                onError(purchasesError4);
            } catch (JSONException e7) {
                PurchasesError purchasesError5 = ErrorsKt.toPurchasesError(e7);
                LogUtilsKt.errorLog(purchasesError5);
                onError(purchasesError5);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public Dispatcher(ExecutorService executorService, Handler handler, boolean z2) {
        Intrinsics.checkNotNullParameter(executorService, "executorService");
        this.executorService = executorService;
        this.mainHandler = handler;
        this.runningIntegrationTests = z2;
    }

    public static /* synthetic */ void enqueue$default(Dispatcher dispatcher, Runnable runnable, Delay delay, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enqueue");
        }
        if ((i3 & 2) != 0) {
            delay = Delay.NONE;
        }
        dispatcher.enqueue(runnable, delay);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enqueue$lambda$3$lambda$2(Runnable runnable, Dispatcher dispatcher) {
        try {
            runnable.run();
        } catch (Throwable th) {
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Exception running command: " + th, null);
            Handler handler = dispatcher.mainHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.revenuecat.purchases.common.b
                    @Override // java.lang.Runnable
                    public final void run() throws Throwable {
                        Dispatcher.enqueue$lambda$3$lambda$2$lambda$1(th);
                    }
                });
            }
        }
    }

    public void close() {
        synchronized (this.executorService) {
            this.executorService.shutdownNow();
        }
    }

    public void enqueue(final Runnable command, Delay delay) {
        Intrinsics.checkNotNullParameter(command, "command");
        Intrinsics.checkNotNullParameter(delay, "delay");
        synchronized (this.executorService) {
            try {
                if (!this.executorService.isShutdown()) {
                    Runnable runnable = new Runnable() { // from class: com.revenuecat.purchases.common.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            Dispatcher.enqueue$lambda$3$lambda$2(command, this);
                        }
                    };
                    if (delay == Delay.NONE || !(this.executorService instanceof ScheduledExecutorService)) {
                        this.executorService.submit(runnable);
                    } else {
                        long jX = RangesKt.x(new LongRange(Duration.p(delay.m522getMinDelayUwyO8pc()), Duration.p(delay.m521getMaxDelayUwyO8pc())), Random.f140182a);
                        if (this.runningIntegrationTests) {
                            jX = (long) (jX * 0.01d);
                        }
                        ((ScheduledExecutorService) this.executorService).schedule(runnable, jX, TimeUnit.MILLISECONDS);
                    }
                }
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean isClosed() {
        boolean zIsShutdown;
        synchronized (this.executorService) {
            zIsShutdown = this.executorService.isShutdown();
        }
        return zIsShutdown;
    }

    public /* synthetic */ Dispatcher(ExecutorService executorService, Handler handler, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(executorService, (i3 & 2) != 0 ? new Handler(Looper.getMainLooper()) : handler, (i3 & 4) != 0 ? false : z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enqueue$lambda$3$lambda$2$lambda$1(Throwable th) throws Throwable {
        throw th;
    }
}
