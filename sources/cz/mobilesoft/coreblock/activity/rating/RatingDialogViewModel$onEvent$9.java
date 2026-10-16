package cz.mobilesoft.coreblock.activity.rating;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.activity.rating.RatingDialogViewModel$onEvent$9", f = "RatingDialogViewModel.kt", l = {67, 68}, m = "invokeSuspend", v = 1)
final class RatingDialogViewModel$onEvent$9 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f96110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ RatingDialogViewModel f96111b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RatingDialogViewModel$onEvent$9(RatingDialogViewModel ratingDialogViewModel, Continuation continuation) {
        super(1, continuation);
        this.f96111b = ratingDialogViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new RatingDialogViewModel$onEvent$9(this.f96111b, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003a, code lost:
    
        if (r5.P0(r1, r4) == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) throws java.lang.Throwable {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r4.f96110a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r5)
            goto L3d
        L12:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L1a:
            kotlin.ResultKt.b(r5)
            goto L30
        L1e:
            kotlin.ResultKt.b(r5)
            cz.mobilesoft.coreblock.activity.rating.RatingDialogViewModel r5 = r4.f96111b
            cz.mobilesoft.coreblock.storage.datastore.RatingDataStore r5 = cz.mobilesoft.coreblock.activity.rating.RatingDialogViewModel.X0(r5)
            r4.f96110a = r3
            java.lang.Object r5 = r5.t0(r4)
            if (r5 != r0) goto L30
            goto L3c
        L30:
            cz.mobilesoft.coreblock.activity.rating.RatingDialogViewModel r5 = r4.f96111b
            cz.mobilesoft.coreblock.activity.rating.RatingDialogCommand$LaunchInAppReview r1 = cz.mobilesoft.coreblock.activity.rating.RatingDialogCommand.LaunchInAppReview.f96065a
            r4.f96110a = r2
            java.lang.Object r5 = cz.mobilesoft.coreblock.activity.rating.RatingDialogViewModel.a1(r5, r1, r4)
            if (r5 != r0) goto L3d
        L3c:
            return r0
        L3d:
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.activity.rating.RatingDialogViewModel$onEvent$9.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((RatingDialogViewModel$onEvent$9) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
