package cz.mobilesoft.coreblock.scene.premium.components;

import androidx.compose.foundation.pager.PagerState;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.premium.components.PremiumReviewsCarouselCardKt$PremiumReviewsCarouselCard$1$1", f = "PremiumReviewsCarouselCard.kt", l = {99, 101}, m = "invokeSuspend", v = 1)
final class PremiumReviewsCarouselCardKt$PremiumReviewsCarouselCard$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f112578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ PagerState f112579b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PremiumReviewsCarouselCardKt$PremiumReviewsCarouselCard$1$1(PagerState pagerState, Continuation continuation) {
        super(2, continuation);
        this.f112579b = pagerState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new PremiumReviewsCarouselCardKt$PremiumReviewsCarouselCard$1$1(this.f112579b, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0057, code lost:
    
        if (androidx.compose.foundation.pager.PagerState.n(r4, r5, 0.0f, r7, r11, 2, null) == r0) goto L17;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r11.f112578a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r12)
            goto L5a
        L12:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L1a:
            kotlin.ResultKt.b(r12)
            goto L34
        L1e:
            kotlin.ResultKt.b(r12)
            kotlin.time.Duration$Companion r12 = kotlin.time.Duration.f140631b
            r4 = 2500(0x9c4, double:1.235E-320)
            kotlin.time.DurationUnit r12 = kotlin.time.DurationUnit.f140640d
            long r4 = kotlin.time.DurationKt.t(r4, r12)
            r11.f112578a = r3
            java.lang.Object r12 = kotlinx.coroutines.DelayKt.c(r4, r11)
            if (r12 != r0) goto L34
            goto L59
        L34:
            androidx.compose.foundation.pager.PagerState r12 = r11.f112579b
            boolean r12 = r12.c()
            if (r12 != 0) goto L5a
            androidx.compose.foundation.pager.PagerState r4 = r11.f112579b
            int r12 = r4.S()
            int r5 = r12 + 1
            r12 = 0
            r1 = 6
            r3 = 1000(0x3e8, float:1.401E-42)
            r6 = 0
            androidx.compose.animation.core.TweenSpec r7 = androidx.compose.animation.core.AnimationSpecKt.n(r3, r12, r6, r1, r6)
            r11.f112578a = r2
            r6 = 0
            r9 = 2
            r10 = 0
            r8 = r11
            java.lang.Object r12 = androidx.compose.foundation.pager.PagerState.n(r4, r5, r6, r7, r8, r9, r10)
            if (r12 != r0) goto L5a
        L59:
            return r0
        L5a:
            kotlin.Unit r12 = kotlin.Unit.f139807a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.premium.components.PremiumReviewsCarouselCardKt$PremiumReviewsCarouselCard$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((PremiumReviewsCarouselCardKt$PremiumReviewsCarouselCard$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
