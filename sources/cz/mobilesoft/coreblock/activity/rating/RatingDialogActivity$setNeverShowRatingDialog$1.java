package cz.mobilesoft.coreblock.activity.rating;

import cz.mobilesoft.coreblock.storage.datastore.RatingDataStore;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity$setNeverShowRatingDialog$1", f = "RatingDialogActivity.kt", l = {541}, m = "invokeSuspend", v = 1)
final class RatingDialogActivity$setNeverShowRatingDialog$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f96044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ RatingDialogActivity f96045b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RatingDialogActivity$setNeverShowRatingDialog$1(RatingDialogActivity ratingDialogActivity, Continuation continuation) {
        super(2, continuation);
        this.f96045b = ratingDialogActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new RatingDialogActivity$setNeverShowRatingDialog$1(this.f96045b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f96044a;
        if (i3 == 0) {
            ResultKt.b(obj);
            RatingDataStore ratingDataStoreC1 = this.f96045b.c1();
            RatingTriggerSource ratingTriggerSource = this.f96045b.f95991n;
            if (ratingTriggerSource == null) {
                Intrinsics.throwUninitializedPropertyAccessException("resolvedTriggerSource");
                ratingTriggerSource = null;
            }
            this.f96044a = 1;
            if (ratingDataStoreC1.H0(-1L, ratingTriggerSource, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((RatingDialogActivity$setNeverShowRatingDialog$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
