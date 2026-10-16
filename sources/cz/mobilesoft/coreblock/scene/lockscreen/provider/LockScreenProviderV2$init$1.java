package cz.mobilesoft.coreblock.scene.lockscreen.provider;

import com.revenuecat.purchases.CustomerInfo;
import cz.mobilesoft.coreblock.enums.PremiumDevState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2$init$1", f = "LockScreenProviderV2.kt", l = {236, 237}, m = "invokeSuspend", v = 1)
final class LockScreenProviderV2$init$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f105831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f105832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ LockScreenProviderV2 f105833c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LockScreenProviderV2$init$1(LockScreenProviderV2 lockScreenProviderV2, Continuation continuation) {
        super(2, continuation);
        this.f105833c = lockScreenProviderV2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(LockScreenProviderV2 lockScreenProviderV2, PremiumDevState premiumDevState, CustomerInfo customerInfo) {
        BuildersKt__Builders_commonKt.d(lockScreenProviderV2.f105776c, null, null, new LockScreenProviderV2$init$1$1$1(lockScreenProviderV2, customerInfo, premiumDevState, null), 3, null);
        return Unit.f139807a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new LockScreenProviderV2$init$1(this.f105833c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0057, code lost:
    
        if (cz.mobilesoft.coreblock.repository.PremiumRepositoryV2.y(r3, null, r5, r9, 1, null) == r0) goto L15;
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
            int r1 = r9.f105832b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1e
            if (r1 != r2) goto L16
            java.lang.Object r0 = r9.f105831a
            cz.mobilesoft.coreblock.enums.PremiumDevState r0 = (cz.mobilesoft.coreblock.enums.PremiumDevState) r0
            kotlin.ResultKt.b(r10)
            goto L5a
        L16:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L1e:
            kotlin.ResultKt.b(r10)
            goto L38
        L22:
            kotlin.ResultKt.b(r10)
            cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2 r10 = r9.f105833c
            cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore r10 = cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2.y(r10)
            kotlinx.coroutines.flow.Flow r10 = r10.O0()
            r9.f105832b = r3
            java.lang.Object r10 = kotlinx.coroutines.flow.FlowKt.D(r10, r9)
            if (r10 != r0) goto L38
            goto L59
        L38:
            cz.mobilesoft.coreblock.enums.PremiumDevState r10 = (cz.mobilesoft.coreblock.enums.PremiumDevState) r10
            cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2 r1 = r9.f105833c
            cz.mobilesoft.coreblock.repository.PremiumRepositoryV2 r3 = cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2.C(r1)
            cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2 r1 = r9.f105833c
            cz.mobilesoft.coreblock.scene.lockscreen.provider.o r5 = new cz.mobilesoft.coreblock.scene.lockscreen.provider.o
            r5.<init>()
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.a(r10)
            r9.f105831a = r10
            r9.f105832b = r2
            r4 = 0
            r7 = 1
            r8 = 0
            r6 = r9
            java.lang.Object r10 = cz.mobilesoft.coreblock.repository.PremiumRepositoryV2.y(r3, r4, r5, r6, r7, r8)
            if (r10 != r0) goto L5a
        L59:
            return r0
        L5a:
            kotlin.Unit r10 = kotlin.Unit.f139807a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2$init$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((LockScreenProviderV2$init$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
