package cz.mobilesoft.coreblock.activity.rating;

import android.content.Context;
import cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity$Companion$show$1", f = "RatingDialogActivity.kt", l = {121, 127}, m = "invokeSuspend", v = 1)
final class RatingDialogActivity$Companion$show$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f96000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f96001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private /* synthetic */ Object f96002c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Context f96003d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ RatingDialogActivity.OnRatingDialogClosedListener f96004f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ boolean f96005g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ RatingTriggerSource f96006h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RatingDialogActivity$Companion$show$1(Context context, RatingDialogActivity.OnRatingDialogClosedListener onRatingDialogClosedListener, boolean z2, RatingTriggerSource ratingTriggerSource, Continuation continuation) {
        super(2, continuation);
        this.f96003d = context;
        this.f96004f = onRatingDialogClosedListener;
        this.f96005g = z2;
        this.f96006h = ratingTriggerSource;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        RatingDialogActivity$Companion$show$1 ratingDialogActivity$Companion$show$1 = new RatingDialogActivity$Companion$show$1(this.f96003d, this.f96004f, this.f96005g, this.f96006h, continuation);
        ratingDialogActivity$Companion$show$1.f96002c = obj;
        return ratingDialogActivity$Companion$show$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0063, code lost:
    
        if (r14 == r1) goto L19;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
        /*
            r13 = this;
            java.lang.Object r0 = r13.f96002c
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r13.f96001b
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L26
            if (r2 == r4) goto L22
            if (r2 != r3) goto L1a
            java.lang.Object r0 = r13.f96000a
            cz.mobilesoft.coreblock.activity.rating.RatingDialogType r0 = (cz.mobilesoft.coreblock.activity.rating.RatingDialogType) r0
            kotlin.ResultKt.b(r14)
            goto L66
        L1a:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L22:
            kotlin.ResultKt.b(r14)
            goto L3a
        L26:
            kotlin.ResultKt.b(r14)
            cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity$Companion r14 = cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity.f95979p
            cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore r14 = cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity.Companion.a(r14)
            r13.f96002c = r0
            r13.f96001b = r4
            java.lang.Object r14 = r14.x0(r13)
            if (r14 != r1) goto L3a
            goto L65
        L3a:
            r8 = r14
            cz.mobilesoft.coreblock.activity.rating.RatingDialogType r8 = (cz.mobilesoft.coreblock.activity.rating.RatingDialogType) r8
            if (r8 == 0) goto L53
            cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity$Companion r4 = cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity.f95979p
            android.content.Context r5 = r13.f96003d
            cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity$OnRatingDialogClosedListener r6 = r13.f96004f
            boolean r7 = r13.f96005g
            cz.mobilesoft.coreblock.activity.rating.RatingTriggerSource r9 = r13.f96006h
            r11 = 32
            r12 = 0
            r10 = 0
            cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity.Companion.l(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            kotlin.Unit r14 = kotlin.Unit.f139807a
            return r14
        L53:
            cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity$Companion r14 = cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity.f95979p
            r13.f96002c = r0
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.a(r8)
            r13.f96000a = r0
            r13.f96001b = r3
            java.lang.Object r14 = cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity.Companion.c(r14, r13)
            if (r14 != r1) goto L66
        L65:
            return r1
        L66:
            cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity$Companion$Launch r14 = (cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity.Companion.Launch) r14
            if (r14 != 0) goto L75
            cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity$OnRatingDialogClosedListener r14 = r13.f96004f
            if (r14 == 0) goto L72
            r0 = 0
            r14.a(r0)
        L72:
            kotlin.Unit r14 = kotlin.Unit.f139807a
            return r14
        L75:
            cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity$Companion r0 = cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity.f95979p
            android.content.Context r1 = r13.f96003d
            cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity$OnRatingDialogClosedListener r2 = r13.f96004f
            boolean r3 = r13.f96005g
            cz.mobilesoft.coreblock.activity.rating.RatingDialogType r4 = r14.a()
            cz.mobilesoft.coreblock.activity.rating.RatingTriggerSource r5 = r13.f96006h
            boolean r6 = r14.b()
            cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity.Companion.d(r0, r1, r2, r3, r4, r5, r6)
            kotlin.Unit r14 = kotlin.Unit.f139807a
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity$Companion$show$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((RatingDialogActivity$Companion$show$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
