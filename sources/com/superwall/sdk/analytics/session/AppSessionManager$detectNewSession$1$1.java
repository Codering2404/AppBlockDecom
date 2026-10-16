package com.superwall.sdk.analytics.session;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
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
@DebugMetadata(c = "com.superwall.sdk.analytics.session.AppSessionManager$detectNewSession$1$1", f = "AppSessionManager.kt", l = {113, 116, 122, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD}, m = "invokeSuspend")
final class AppSessionManager$detectNewSession$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ AppSessionManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AppSessionManager$detectNewSession$1$1(AppSessionManager appSessionManager, Continuation<? super AppSessionManager$detectNewSession$1$1> continuation) {
        super(2, continuation);
        this.this$0 = appSessionManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AppSessionManager$detectNewSession$1$1(this.this$0, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b0, code lost:
    
        if (com.superwall.sdk.analytics.internal.TrackingKt.track(r10, r1, r9) == r0) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0088  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r9.label
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r1 == 0) goto L49
            if (r1 == r5) goto L45
            if (r1 == r4) goto L34
            if (r1 == r3) goto L27
            if (r1 != r2) goto L1f
            kotlin.ResultKt.b(r10)
            kotlin.Result r10 = (kotlin.Result) r10
            r10.j()
            goto Lb3
        L1f:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L27:
            java.lang.Object r1 = r9.L$0
            com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent$Attributes r1 = (com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent.Attributes) r1
            kotlin.ResultKt.b(r10)
            kotlin.Result r10 = (kotlin.Result) r10
            r10.j()
            goto La0
        L34:
            java.lang.Object r1 = r9.L$1
            com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent$Attributes r1 = (com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent.Attributes) r1
            java.lang.Object r5 = r9.L$0
            java.util.HashMap r5 = (java.util.HashMap) r5
            kotlin.ResultKt.b(r10)
            kotlin.Result r10 = (kotlin.Result) r10
            r10.j()
            goto L80
        L45:
            kotlin.ResultKt.b(r10)
            goto L5b
        L49:
            kotlin.ResultKt.b(r10)
            com.superwall.sdk.analytics.session.AppSessionManager r10 = r9.this$0
            com.superwall.sdk.analytics.session.AppSessionManager$Factory r10 = com.superwall.sdk.analytics.session.AppSessionManager.access$getDelegate$p(r10)
            r9.label = r5
            java.lang.Object r10 = r10.makeSessionDeviceAttributes(r9)
            if (r10 != r0) goto L5b
            goto Lb2
        L5b:
            java.util.HashMap r10 = (java.util.HashMap) r10
            com.superwall.sdk.analytics.session.AppSessionManager r1 = r9.this$0
            com.superwall.sdk.analytics.session.AppSessionManager$Factory r1 = com.superwall.sdk.analytics.session.AppSessionManager.access$getDelegate$p(r1)
            com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent$Attributes r1 = r1.makeUserAttributesEvent()
            com.superwall.sdk.Superwall$Companion r7 = com.superwall.sdk.Superwall.Companion
            com.superwall.sdk.Superwall r7 = r7.getInstance()
            com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent$SessionStart r8 = new com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent$SessionStart
            r8.<init>(r6, r5, r6)
            r9.L$0 = r10
            r9.L$1 = r1
            r9.label = r4
            java.lang.Object r5 = com.superwall.sdk.analytics.internal.TrackingKt.track(r7, r8, r9)
            if (r5 != r0) goto L7f
            goto Lb2
        L7f:
            r5 = r10
        L80:
            com.superwall.sdk.analytics.session.AppSessionManager r10 = r9.this$0
            boolean r10 = com.superwall.sdk.analytics.session.AppSessionManager.access$getDidTrackAppLaunch$p(r10)
            if (r10 == 0) goto La0
            com.superwall.sdk.Superwall$Companion r10 = com.superwall.sdk.Superwall.Companion
            com.superwall.sdk.Superwall r10 = r10.getInstance()
            com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent$DeviceAttributes r7 = new com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent$DeviceAttributes
            r7.<init>(r5, r6, r4, r6)
            r9.L$0 = r1
            r9.L$1 = r6
            r9.label = r3
            java.lang.Object r10 = com.superwall.sdk.analytics.internal.TrackingKt.track(r10, r7, r9)
            if (r10 != r0) goto La0
            goto Lb2
        La0:
            com.superwall.sdk.Superwall$Companion r10 = com.superwall.sdk.Superwall.Companion
            com.superwall.sdk.Superwall r10 = r10.getInstance()
            r9.L$0 = r6
            r9.L$1 = r6
            r9.label = r2
            java.lang.Object r10 = com.superwall.sdk.analytics.internal.TrackingKt.track(r10, r1, r9)
            if (r10 != r0) goto Lb3
        Lb2:
            return r0
        Lb3:
            kotlin.Unit r10 = kotlin.Unit.f139807a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.analytics.session.AppSessionManager$detectNewSession$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AppSessionManager$detectNewSession$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
