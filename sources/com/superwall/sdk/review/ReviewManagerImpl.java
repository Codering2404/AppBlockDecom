package com.superwall.sdk.review;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.review.ReviewException;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManagerFactory;
import com.google.android.play.core.review.testing.FakeReviewManager;
import com.superwall.sdk.review.ReviewError;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ReviewManagerImpl implements ReviewManager {
    private final Context context;
    private final Function0<Boolean> isDebug;
    private final Lazy playReviewManager$delegate;

    public ReviewManagerImpl(Context context, Function0<Boolean> isDebug) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(isDebug, "isDebug");
        this.context = context;
        this.isDebug = isDebug;
        this.playReviewManager$delegate = LazyKt.b(new Function0() { // from class: com.superwall.sdk.review.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ReviewManagerImpl.playReviewManager_delegate$lambda$0(this.f93741a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.google.android.play.core.review.ReviewManager getPlayReviewManager() {
        return (com.google.android.play.core.review.ReviewManager) this.playReviewManager$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.google.android.play.core.review.ReviewManager playReviewManager_delegate$lambda$0(ReviewManagerImpl reviewManagerImpl) {
        return ((Boolean) reviewManagerImpl.isDebug.invoke()).booleanValue() ? new FakeReviewManager(reviewManagerImpl.context) : ReviewManagerFactory.a(reviewManagerImpl.context);
    }

    public final Function0<Boolean> isDebug() {
        return this.isDebug;
    }

    @Override // com.superwall.sdk.review.ReviewManager
    public Object launchReviewFlow(Activity activity, ReviewInfo reviewInfo, Continuation<? super Unit> continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        Task taskB = getPlayReviewManager().b(activity, reviewInfo);
        Intrinsics.checkNotNullExpressionValue(taskB, "launchReviewFlow(...)");
        taskB.addOnCompleteListener(new OnCompleteListener() { // from class: com.superwall.sdk.review.ReviewManagerImpl$launchReviewFlow$2$1
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task<Void> task) {
                Intrinsics.checkNotNullParameter(task, "task");
                if (task.isSuccessful()) {
                    CancellableContinuation<Unit> cancellableContinuation = cancellableContinuationImpl;
                    Result.Companion companion = Result.f139772b;
                    cancellableContinuation.resumeWith(Result.b(Unit.f139807a));
                } else {
                    ReviewError.LaunchFlowError launchFlowError = new ReviewError.LaunchFlowError(task.getException());
                    CancellableContinuation<Unit> cancellableContinuation2 = cancellableContinuationImpl;
                    Result.Companion companion2 = Result.f139772b;
                    cancellableContinuation2.resumeWith(Result.b(ResultKt.a(launchFlowError)));
                }
            }
        });
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV == IntrinsicsKt.f() ? objV : Unit.f139807a;
    }

    @Override // com.superwall.sdk.review.ReviewManager
    public Object requestReviewFlow(Continuation<? super ReviewInfo> continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        Task taskA = getPlayReviewManager().a();
        Intrinsics.checkNotNullExpressionValue(taskA, "requestReviewFlow(...)");
        taskA.addOnCompleteListener(new OnCompleteListener() { // from class: com.superwall.sdk.review.ReviewManagerImpl$requestReviewFlow$2$1
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task<ReviewInfo> task) {
                Throwable genericError;
                Intrinsics.checkNotNullParameter(task, "task");
                if (task.isSuccessful()) {
                    cancellableContinuationImpl.resumeWith(Result.b(task.getResult()));
                    return;
                }
                Exception exception = task.getException();
                if (exception instanceof ReviewException) {
                    genericError = new ReviewError.RequestFlowError(((ReviewException) exception).getErrorCode(), exception);
                } else {
                    genericError = new ReviewError.GenericError("Failed to request review flow: " + (exception != null ? exception.getMessage() : null), exception);
                }
                CancellableContinuation<ReviewInfo> cancellableContinuation = cancellableContinuationImpl;
                Result.Companion companion = Result.f139772b;
                cancellableContinuation.resumeWith(Result.b(ResultKt.a(genericError)));
            }
        });
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV;
    }
}
