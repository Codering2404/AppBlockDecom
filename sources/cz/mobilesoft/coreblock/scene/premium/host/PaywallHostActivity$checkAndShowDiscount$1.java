package cz.mobilesoft.coreblock.scene.premium.host;

import cz.mobilesoft.coreblock.enums.RevenueCatPlacement;
import cz.mobilesoft.coreblock.scene.premium.enums.DiscountSource;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.premium.host.PaywallHostActivity$checkAndShowDiscount$1", f = "PaywallHostActivity.kt", l = {731, 738, 746}, m = "invokeSuspend", v = 1)
final class PaywallHostActivity$checkAndShowDiscount$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f113262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f113263b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f113264c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f113265d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ PaywallHostActivity f113266f;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.premium.host.PaywallHostActivity$checkAndShowDiscount$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.premium.host.PaywallHostActivity$checkAndShowDiscount$1$1", f = "PaywallHostActivity.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f113267a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ PaywallHostActivity f113268b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f113269c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ RevenueCatPlacement f113270d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PaywallHostActivity paywallHostActivity, boolean z2, RevenueCatPlacement revenueCatPlacement, Continuation continuation) {
            super(2, continuation);
            this.f113268b = paywallHostActivity;
            this.f113269c = z2;
            this.f113270d = revenueCatPlacement;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f113268b, this.f113269c, this.f113270d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f113267a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            if (this.f113268b.isFinishing() || this.f113268b.isDestroyed()) {
                return Unit.f139807a;
            }
            if (this.f113269c) {
                this.f113268b.startActivity(Paywall.c(Paywall.f113165a, this.f113268b, new PaywallTarget.Discount(this.f113270d, DiscountSource.LEAVING_SCREEN, false, null), "leaving_premium_screen", null, false, false, false, null, 248, null));
            }
            this.f113268b.finish();
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PaywallHostActivity$checkAndShowDiscount$1(PaywallHostActivity paywallHostActivity, Continuation continuation) {
        super(1, continuation);
        this.f113266f = paywallHostActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new PaywallHostActivity$checkAndShowDiscount$1(this.f113266f, continuation);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:0|2|(1:(1:(1:(3:7|36|37)(2:8|9))(5:10|40|11|28|33))(1:15))(3:16|(1:19)|35)|20|(1:22)(1:23)|38|24|(3:27|28|33)|35) */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0080, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0081, code lost:
    
        r8 = r1;
        r1 = r10;
        r10 = r3;
        r3 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a8, code lost:
    
        if (kotlinx.coroutines.BuildersKt.g(r4, r6, r9) != r0) goto L36;
     */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v16, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r10v23 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r9.f113265d
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L3d
            if (r1 == r4) goto L35
            if (r1 == r3) goto L27
            if (r1 != r2) goto L1f
            java.lang.Object r0 = r9.f113263b
            cz.mobilesoft.coreblock.enums.RevenueCatPlacement r0 = (cz.mobilesoft.coreblock.enums.RevenueCatPlacement) r0
            java.lang.Object r0 = r9.f113262a
            cz.mobilesoft.coreblock.util.subscription.DiscountRepository r0 = (cz.mobilesoft.coreblock.util.subscription.DiscountRepository) r0
            kotlin.ResultKt.b(r10)
            goto Lab
        L1f:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L27:
            java.lang.Object r1 = r9.f113263b
            cz.mobilesoft.coreblock.enums.RevenueCatPlacement r1 = (cz.mobilesoft.coreblock.enums.RevenueCatPlacement) r1
            java.lang.Object r3 = r9.f113262a
            cz.mobilesoft.coreblock.util.subscription.DiscountRepository r3 = (cz.mobilesoft.coreblock.util.subscription.DiscountRepository) r3
            kotlin.ResultKt.b(r10)     // Catch: java.lang.Throwable -> L33
            goto L79
        L33:
            r10 = move-exception
            goto L85
        L35:
            java.lang.Object r1 = r9.f113262a
            cz.mobilesoft.coreblock.util.subscription.DiscountRepository r1 = (cz.mobilesoft.coreblock.util.subscription.DiscountRepository) r1
            kotlin.ResultKt.b(r10)
            goto L57
        L3d:
            kotlin.ResultKt.b(r10)
            java.lang.Class<cz.mobilesoft.coreblock.util.subscription.DiscountRepository> r10 = cz.mobilesoft.coreblock.util.subscription.DiscountRepository.class
            r1 = 6
            java.lang.Object r10 = org.koin.java.KoinJavaComponent.c(r10, r5, r5, r1, r5)
            cz.mobilesoft.coreblock.util.subscription.DiscountRepository r10 = (cz.mobilesoft.coreblock.util.subscription.DiscountRepository) r10
            r9.f113262a = r10
            r9.f113265d = r4
            java.lang.Object r1 = r10.g(r9)
            if (r1 != r0) goto L54
            goto Laa
        L54:
            r8 = r1
            r1 = r10
            r10 = r8
        L57:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L62
            cz.mobilesoft.coreblock.enums.RevenueCatPlacement r10 = cz.mobilesoft.coreblock.enums.RevenueCatPlacement.Discount50
            goto L64
        L62:
            cz.mobilesoft.coreblock.enums.RevenueCatPlacement r10 = cz.mobilesoft.coreblock.enums.RevenueCatPlacement.Discount20
        L64:
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r1)     // Catch: java.lang.Throwable -> L80
            r9.f113262a = r4     // Catch: java.lang.Throwable -> L80
            r9.f113263b = r10     // Catch: java.lang.Throwable -> L80
            r9.f113265d = r3     // Catch: java.lang.Throwable -> L80
            java.lang.Object r3 = r1.h(r10, r9)     // Catch: java.lang.Throwable -> L80
            if (r3 != r0) goto L75
            goto Laa
        L75:
            r8 = r1
            r1 = r10
            r10 = r3
            r3 = r8
        L79:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch: java.lang.Throwable -> L33
            boolean r10 = r10.booleanValue()     // Catch: java.lang.Throwable -> L33
            goto L89
        L80:
            r3 = move-exception
            r8 = r1
            r1 = r10
            r10 = r3
            r3 = r8
        L85:
            cz.mobilesoft.coreblock.util.CrashHelper.j(r10)
            r10 = 0
        L89:
            kotlinx.coroutines.MainCoroutineDispatcher r4 = kotlinx.coroutines.Dispatchers.c()
            cz.mobilesoft.coreblock.scene.premium.host.PaywallHostActivity$checkAndShowDiscount$1$1 r6 = new cz.mobilesoft.coreblock.scene.premium.host.PaywallHostActivity$checkAndShowDiscount$1$1
            cz.mobilesoft.coreblock.scene.premium.host.PaywallHostActivity r7 = r9.f113266f
            r6.<init>(r7, r10, r1, r5)
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.a(r3)
            r9.f113262a = r3
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.a(r1)
            r9.f113263b = r1
            r9.f113264c = r10
            r9.f113265d = r2
            java.lang.Object r10 = kotlinx.coroutines.BuildersKt.g(r4, r6, r9)
            if (r10 != r0) goto Lab
        Laa:
            return r0
        Lab:
            kotlin.Unit r10 = kotlin.Unit.f139807a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.premium.host.PaywallHostActivity$checkAndShowDiscount$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((PaywallHostActivity$checkAndShowDiscount$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
