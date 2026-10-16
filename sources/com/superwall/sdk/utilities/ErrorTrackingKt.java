package com.superwall.sdk.utilities;

import com.superwall.sdk.Superwall;
import com.superwall.sdk.billing.BillingError;
import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Logger;
import com.superwall.sdk.misc.Either;
import com.superwall.sdk.network.NetworkError;
import com.superwall.sdk.paywall.presentation.internal.PaywallPresentationRequestStatusReason;
import com.superwall.sdk.paywall.presentation.internal.state.PaywallSkippedReason;
import com.superwall.sdk.store.transactions.TransactionError;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ErrorTrackingKt {
    public static final <R> Object flatten(Object obj) {
        if (Result.h(obj)) {
            if (Result.e(obj) == null) {
                return ((Result) obj).j();
            }
            Throwable thE = Result.e(obj);
            if (thE == null) {
                thE = new IllegalStateException("Unknown error");
            }
            return Result.b(ResultKt.a(thE));
        }
        if (Result.g(obj)) {
            Throwable thE2 = Result.e(obj);
            if (thE2 == null) {
                thE2 = new IllegalStateException("Unknown error");
            }
            return Result.b(ResultKt.a(thE2));
        }
        Throwable thE3 = Result.e(obj);
        if (thE3 == null) {
            thE3 = new IllegalStateException("Unknown error");
        }
        return Result.b(ResultKt.a(thE3));
    }

    public static final boolean isFatal(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "<this>");
        return (th instanceof RuntimeException) || (th instanceof StackOverflowError) || (th instanceof OutOfMemoryError) || (th instanceof ClassNotFoundException) || (th instanceof NoClassDefFoundError);
    }

    public static final boolean shouldLog(Throwable th) {
        boolean z2;
        Intrinsics.checkNotNullParameter(th, "<this>");
        if ((th instanceof CancellationException) || (th instanceof InterruptedException) || ((z2 = th instanceof PaywallPresentationRequestStatusReason)) || (th instanceof TransactionError) || (th instanceof PaywallSkippedReason)) {
            return false;
        }
        return ((!(th instanceof NetworkError.Decoding) && (th instanceof NetworkError)) || (th instanceof BillingError) || z2) ? false : true;
    }

    public static final void trackError(Superwall superwall, Throwable e3) {
        Intrinsics.checkNotNullParameter(superwall, "<this>");
        Intrinsics.checkNotNullParameter(e3, "e");
        try {
            superwall.getDependencyContainer$superwall_release().getErrorTracker$superwall_release().trackError(e3);
        } catch (Exception e4) {
            Logger.debug$default(Logger.INSTANCE, LogLevel.error, LogScope.all, "Error tracking failed for " + e3.getMessage() + ". Cause " + e4.getMessage() + "} ", (Map) null, (Throwable) null, 24, (Object) null);
        }
    }

    public static final <T> Either<T, Throwable> withErrorTracking(Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            return new Either.Success(block.invoke());
        } catch (Throwable th) {
            if (shouldLog(th)) {
                Superwall.Companion companion = Superwall.Companion;
                if (companion.getInitialized()) {
                    trackError(companion.getInstance(), th);
                }
            }
            return new Either.Failure(th);
        }
    }
}
