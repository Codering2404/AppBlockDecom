package cz.mobilesoft.coreblock.scene.lockscreen.provider;

import com.google.android.gms.common.api.Api;
import cz.mobilesoft.coreblock.scene.lockscreen.LockViewState;
import cz.mobilesoft.coreblock.storage.room.entity.core.CustomBlockingScreenConfigEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2$init$11", f = "LockScreenProviderV2.kt", l = {455, 455}, m = "invokeSuspend", v = 1)
final class LockScreenProviderV2$init$11 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f105841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f105842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ LockScreenProviderV2 f105843c;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2$init$11$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class AnonymousClass1<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ LockScreenProviderV2 f105844a;

        AnonymousClass1(LockScreenProviderV2 lockScreenProviderV2) {
            this.f105844a = lockScreenProviderV2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final LockViewState g(CustomBlockingScreenConfigEntity customBlockingScreenConfigEntity, LockViewState updateViewState) {
            Intrinsics.checkNotNullParameter(updateViewState, "$this$updateViewState");
            return LockViewState.b(updateViewState, null, null, 0, 0, false, 0, false, false, false, false, false, false, false, null, false, null, null, null, null, null, null, null, false, null, null, false, null, 0.0f, false, false, false, customBlockingScreenConfigEntity, null, null, false, null, Api.BaseClientBuilder.API_PRIORITY_OTHER, 15, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final LockViewState h(CustomBlockingScreenConfigEntity customBlockingScreenConfigEntity, LockViewState updateViewState) {
            Intrinsics.checkNotNullParameter(updateViewState, "$this$updateViewState");
            return LockViewState.b(updateViewState, null, null, 0, 0, false, 0, false, false, false, false, false, false, false, null, false, null, null, null, null, null, null, null, false, null, null, true, String.valueOf(customBlockingScreenConfigEntity.l()), 0.0f, false, false, false, null, null, null, false, null, -100663297, 15, null);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x005a  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(final cz.mobilesoft.coreblock.storage.room.entity.core.CustomBlockingScreenConfigEntity r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
            /*
                r5 = this;
                boolean r0 = r7 instanceof cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2$init$11$1$emit$1
                if (r0 == 0) goto L13
                r0 = r7
                cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2$init$11$1$emit$1 r0 = (cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2$init$11$1$emit$1) r0
                int r1 = r0.f105848d
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f105848d = r1
                goto L18
            L13:
                cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2$init$11$1$emit$1 r0 = new cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2$init$11$1$emit$1
                r0.<init>(r5, r7)
            L18:
                java.lang.Object r7 = r0.f105846b
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r2 = r0.f105848d
                r3 = 1
                if (r2 == 0) goto L35
                if (r2 != r3) goto L2d
                java.lang.Object r6 = r0.f105845a
                cz.mobilesoft.coreblock.storage.room.entity.core.CustomBlockingScreenConfigEntity r6 = (cz.mobilesoft.coreblock.storage.room.entity.core.CustomBlockingScreenConfigEntity) r6
                kotlin.ResultKt.b(r7)
                goto L55
            L2d:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L35:
                kotlin.ResultKt.b(r7)
                if (r6 != 0) goto L58
                cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2 r7 = r5.f105844a
                cz.mobilesoft.coreblock.storage.room.dao.core.CustomBlockingScreenConfigDao r7 = cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2.w(r7)
                cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2 r2 = r5.f105844a
                cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore r2 = cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2.v(r2)
                java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
                r0.f105845a = r6
                r0.f105848d = r3
                java.lang.Object r7 = cz.mobilesoft.coreblock.storage.room.dao.core.CustomBlockingScreenConfigDaoKt.a(r7, r2, r0)
                if (r7 != r1) goto L55
                return r1
            L55:
                r6 = r7
                cz.mobilesoft.coreblock.storage.room.entity.core.CustomBlockingScreenConfigEntity r6 = (cz.mobilesoft.coreblock.storage.room.entity.core.CustomBlockingScreenConfigEntity) r6
            L58:
                if (r6 == 0) goto L96
                cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2 r7 = r5.f105844a
                cz.mobilesoft.coreblock.scene.lockscreen.provider.q r0 = new cz.mobilesoft.coreblock.scene.lockscreen.provider.q
                r0.<init>()
                cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2.R(r7, r0)
                int r7 = r6.l()
                if (r7 <= 0) goto L91
                cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2 r7 = r5.f105844a
                cz.mobilesoft.coreblock.scene.lockscreen.provider.r r0 = new cz.mobilesoft.coreblock.scene.lockscreen.provider.r
                r0.<init>()
                cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2.R(r7, r0)
                cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2 r7 = r5.f105844a
                cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt r0 = cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt.f128663a
                long r0 = r0.f()
                java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.SECONDS
                int r3 = r6.l()
                long r3 = (long) r3
                long r2 = r2.toMillis(r3)
                long r0 = r0 + r2
                int r6 = r6.l()
                double r2 = (double) r6
                cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2.L(r7, r0, r2)
                goto L96
            L91:
                cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2 r6 = r5.f105844a
                cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2.P(r6)
            L96:
                kotlin.Unit r6 = kotlin.Unit.f139807a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2$init$11.AnonymousClass1.emit(cz.mobilesoft.coreblock.storage.room.entity.core.CustomBlockingScreenConfigEntity, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LockScreenProviderV2$init$11(LockScreenProviderV2 lockScreenProviderV2, Continuation continuation) {
        super(2, continuation);
        this.f105843c = lockScreenProviderV2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new LockScreenProviderV2$init$11(this.f105843c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0056, code lost:
    
        if (r5.collect(r1, r4) == r0) goto L15;
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
            int r1 = r4.f105842b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r5)
            goto L59
        L12:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L1a:
            java.lang.Object r1 = r4.f105841a
            cz.mobilesoft.coreblock.storage.room.dao.core.CustomBlockingScreenConfigDao r1 = (cz.mobilesoft.coreblock.storage.room.dao.core.CustomBlockingScreenConfigDao) r1
            kotlin.ResultKt.b(r5)
            goto L40
        L22:
            kotlin.ResultKt.b(r5)
            cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2 r5 = r4.f105843c
            cz.mobilesoft.coreblock.storage.room.dao.core.CustomBlockingScreenConfigDao r1 = cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2.w(r5)
            cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2 r5 = r4.f105843c
            cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore r5 = cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2.v(r5)
            kotlinx.coroutines.flow.Flow r5 = r5.n0()
            r4.f105841a = r1
            r4.f105842b = r3
            java.lang.Object r5 = kotlinx.coroutines.flow.FlowKt.D(r5, r4)
            if (r5 != r0) goto L40
            goto L58
        L40:
            java.lang.String r5 = (java.lang.String) r5
            kotlinx.coroutines.flow.Flow r5 = r1.K(r5)
            cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2$init$11$1 r1 = new cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2$init$11$1
            cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2 r3 = r4.f105843c
            r1.<init>(r3)
            r3 = 0
            r4.f105841a = r3
            r4.f105842b = r2
            java.lang.Object r5 = r5.collect(r1, r4)
            if (r5 != r0) goto L59
        L58:
            return r0
        L59:
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2$init$11.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((LockScreenProviderV2$init$11) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
