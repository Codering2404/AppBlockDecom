package cz.mobilesoft.coreblock.activity.rating;

import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.tasks.TasksKt;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity$launchReviewPreparation$2", f = "RatingDialogActivity.kt", l = {RCHTTPStatusCodes.UNAUTHORIZED}, m = "invokeSuspend", v = 1)
final class RatingDialogActivity$launchReviewPreparation$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f96037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f96038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ RatingDialogActivity f96039c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function1 f96040d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Function0 f96041f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RatingDialogActivity$launchReviewPreparation$2(RatingDialogActivity ratingDialogActivity, Function1 function1, Function0 function0, Continuation continuation) {
        super(2, continuation);
        this.f96039c = ratingDialogActivity;
        this.f96040d = function1;
        this.f96041f = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new RatingDialogActivity$launchReviewPreparation$2(this.f96039c, this.f96040d, this.f96041f, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Task task;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f96038b;
        if (i3 == 0) {
            ResultKt.b(obj);
            ReviewManager reviewManager = this.f96039c.f95988k;
            if (reviewManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("reviewManager");
                reviewManager = null;
            }
            Task taskA = reviewManager.a();
            Intrinsics.checkNotNullExpressionValue(taskA, "requestReviewFlow(...)");
            this.f96037a = taskA;
            this.f96038b = 1;
            if (TasksKt.b(taskA, this) == objF) {
                return objF;
            }
            task = taskA;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            task = (Task) this.f96037a;
            ResultKt.b(obj);
        }
        if (task.isSuccessful()) {
            Log.d("RatingDialogActivity", "Review request successful");
            this.f96039c.f95989l = (ReviewInfo) task.getResult();
            this.f96040d.invoke(Boxing.a(this.f96039c.f95989l != null));
        } else {
            Log.w("RatingDialogActivity", "Review request failed - reviewInfo will not be available");
            this.f96041f.invoke();
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((RatingDialogActivity$launchReviewPreparation$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
