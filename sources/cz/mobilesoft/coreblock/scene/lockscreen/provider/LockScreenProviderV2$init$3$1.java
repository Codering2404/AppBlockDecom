package cz.mobilesoft.coreblock.scene.lockscreen.provider;

import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2$init$3$1", f = "LockScreenProviderV2.kt", l = {306, 307}, m = "invokeSuspend", v = 1)
final class LockScreenProviderV2$init$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f105869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f105870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ LockScreenProviderV2 f105871c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f105872d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Long f105873f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ String f105874g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ ProfileType f105875h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ UsageLimit.PeriodType f105876i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LockScreenProviderV2$init$3$1(LockScreenProviderV2 lockScreenProviderV2, String str, Long l3, String str2, ProfileType profileType, UsageLimit.PeriodType periodType, Continuation continuation) {
        super(2, continuation);
        this.f105871c = lockScreenProviderV2;
        this.f105872d = str;
        this.f105873f = l3;
        this.f105874g = str2;
        this.f105875h = profileType;
        this.f105876i = periodType;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new LockScreenProviderV2$init$3$1(this.f105871c, this.f105872d, this.f105873f, this.f105874g, this.f105875h, this.f105876i, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((LockScreenProviderV2$init$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x006e, code lost:
    
        if (r2.C0(r4, r21) == r1) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r22) throws java.lang.Throwable {
        /*
            r21 = this;
            r0 = r21
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f105870b
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L27
            if (r2 == r4) goto L1d
            if (r2 != r3) goto L14
            kotlin.ResultKt.b(r22)
            goto L71
        L14:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r2 = 0
            java.lang.String r2 = coil.target.Yb.oUcQRqOVfOC.kgezkvfcPWKbwA
            r1.<init>(r2)
            throw r1
        L1d:
            java.lang.Object r2 = r0.f105869a
            cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2 r2 = (cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2) r2
            kotlin.ResultKt.b(r22)
            r4 = r22
            goto L3f
        L27:
            kotlin.ResultKt.b(r22)
            cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2 r2 = r0.f105871c
            cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r5 = cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2.u(r2)
            kotlinx.coroutines.flow.Flow r5 = r5.i2()
            r0.f105869a = r2
            r0.f105870b = r4
            java.lang.Object r4 = kotlinx.coroutines.flow.FlowKt.D(r5, r0)
            if (r4 != r1) goto L3f
            goto L70
        L3f:
            java.util.Set r4 = (java.util.Set) r4
            cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2.M(r2, r4)
            cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2 r2 = r0.f105871c
            cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2$LockScreenDTO r4 = new cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2$LockScreenDTO
            java.lang.String r5 = r0.f105872d
            java.lang.Long r7 = r0.f105873f
            java.lang.String r8 = r0.f105874g
            cz.mobilesoft.coreblock.enums.ProfileType r9 = r0.f105875h
            cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit$PeriodType r10 = r0.f105876i
            r19 = 16320(0x3fc0, float:2.2869E-41)
            r20 = 0
            r6 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            r5 = 0
            r0.f105869a = r5
            r0.f105870b = r3
            java.lang.Object r2 = cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2.K(r2, r4, r0)
            if (r2 != r1) goto L71
        L70:
            return r1
        L71:
            kotlin.Unit r1 = kotlin.Unit.f139807a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2$init$3$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
