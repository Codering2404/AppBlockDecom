package cz.mobilesoft.coreblock.activity.rating;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity$Companion$showPreview$1", f = "RatingDialogActivity.kt", l = {96, 97}, m = "invokeSuspend", v = 1)
final class RatingDialogActivity$Companion$showPreview$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f96007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f96008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Context f96009c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RatingDialogActivity$Companion$showPreview$1(Context context, Continuation continuation) {
        super(2, continuation);
        this.f96009c = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new RatingDialogActivity$Companion$showPreview$1(this.f96009c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x004e, code lost:
    
        if (r10 == r0) goto L17;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r9.f96008b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1e
            if (r1 != r2) goto L16
            java.lang.Object r0 = r9.f96007a
            cz.mobilesoft.coreblock.activity.rating.RatingDialogType r0 = (cz.mobilesoft.coreblock.activity.rating.RatingDialogType) r0
            kotlin.ResultKt.b(r10)
            goto L51
        L16:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L1e:
            kotlin.ResultKt.b(r10)
            goto L34
        L22:
            kotlin.ResultKt.b(r10)
            cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity$Companion r10 = cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity.f95979p
            cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore r10 = cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity.Companion.a(r10)
            r9.f96008b = r3
            java.lang.Object r10 = r10.x0(r9)
            if (r10 != r0) goto L34
            goto L50
        L34:
            cz.mobilesoft.coreblock.activity.rating.RatingDialogType r10 = (cz.mobilesoft.coreblock.activity.rating.RatingDialogType) r10
            if (r10 != 0) goto L53
            cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity$Companion r1 = cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity.f95979p
            cz.mobilesoft.coreblock.storage.datastore.RatingDataStore r1 = cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity.Companion.b(r1)
            kotlinx.coroutines.flow.Flow r1 = r1.W()
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.a(r10)
            r9.f96007a = r10
            r9.f96008b = r2
            java.lang.Object r10 = kotlinx.coroutines.flow.FlowKt.D(r1, r9)
            if (r10 != r0) goto L51
        L50:
            return r0
        L51:
            cz.mobilesoft.coreblock.activity.rating.RatingDialogType r10 = (cz.mobilesoft.coreblock.activity.rating.RatingDialogType) r10
        L53:
            r4 = r10
            cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity$Companion r0 = cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity.f95979p
            android.content.Context r1 = r9.f96009c
            cz.mobilesoft.coreblock.activity.rating.RatingTriggerSource r5 = cz.mobilesoft.coreblock.activity.rating.RatingTriggerSource.DeveloperPreview
            r7 = 32
            r8 = 0
            r2 = 0
            r3 = 1
            r6 = 0
            cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity.Companion.l(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            kotlin.Unit r10 = kotlin.Unit.f139807a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity$Companion$showPreview$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((RatingDialogActivity$Companion$showPreview$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
