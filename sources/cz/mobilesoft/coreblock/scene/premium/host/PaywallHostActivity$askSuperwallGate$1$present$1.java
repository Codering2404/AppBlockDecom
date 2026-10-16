package cz.mobilesoft.coreblock.scene.premium.host;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.premium.host.PaywallHostActivity$askSuperwallGate$1$present$1", f = "PaywallHostActivity.kt", l = {590, 599, 601}, m = "invokeSuspend", v = 1)
final class PaywallHostActivity$askSuperwallGate$1$present$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f113255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f113256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f113257c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f113258d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f113259f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f113260g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ PaywallHostActivity f113261h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PaywallHostActivity$askSuperwallGate$1$present$1(PaywallHostActivity paywallHostActivity, Continuation continuation) {
        super(2, continuation);
        this.f113261h = paywallHostActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new PaywallHostActivity$askSuperwallGate$1$present$1(this.f113261h, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00ab  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r8.f113260g
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L52
            if (r1 == r4) goto L46
            if (r1 == r3) goto L36
            if (r1 != r2) goto L2e
            boolean r0 = r8.f113259f
            java.lang.Object r1 = r8.f113258d
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            java.lang.Object r2 = r8.f113257c
            cz.mobilesoft.coreblock.util.monetization.MonetizationConfig r2 = (cz.mobilesoft.coreblock.util.monetization.MonetizationConfig) r2
            java.lang.Object r3 = r8.f113256b
            cz.mobilesoft.coreblock.scene.premium.host.PaywallSpec r3 = (cz.mobilesoft.coreblock.scene.premium.host.PaywallSpec) r3
            java.lang.Object r4 = r8.f113255a
            cz.mobilesoft.coreblock.scene.premium.host.SuperwallGate r4 = (cz.mobilesoft.coreblock.scene.premium.host.SuperwallGate) r4
            kotlin.ResultKt.b(r9)
            r7 = r4
            r4 = r0
            r0 = r7
            r7 = r3
            r3 = r1
            r1 = r7
            goto Lb2
        L2e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L36:
            java.lang.Object r1 = r8.f113257c
            cz.mobilesoft.coreblock.util.monetization.MonetizationConfig r1 = (cz.mobilesoft.coreblock.util.monetization.MonetizationConfig) r1
            java.lang.Object r3 = r8.f113256b
            cz.mobilesoft.coreblock.scene.premium.host.PaywallSpec r3 = (cz.mobilesoft.coreblock.scene.premium.host.PaywallSpec) r3
            java.lang.Object r4 = r8.f113255a
            cz.mobilesoft.coreblock.scene.premium.host.SuperwallGate r4 = (cz.mobilesoft.coreblock.scene.premium.host.SuperwallGate) r4
            kotlin.ResultKt.b(r9)
            goto L8e
        L46:
            java.lang.Object r1 = r8.f113256b
            cz.mobilesoft.coreblock.scene.premium.host.PaywallSpec r1 = (cz.mobilesoft.coreblock.scene.premium.host.PaywallSpec) r1
            java.lang.Object r4 = r8.f113255a
            cz.mobilesoft.coreblock.scene.premium.host.SuperwallGate r4 = (cz.mobilesoft.coreblock.scene.premium.host.SuperwallGate) r4
            kotlin.ResultKt.b(r9)
            goto L73
        L52:
            kotlin.ResultKt.b(r9)
            cz.mobilesoft.coreblock.scene.premium.host.SuperwallGate r9 = cz.mobilesoft.coreblock.scene.premium.host.SuperwallGate.f113353a
            cz.mobilesoft.coreblock.scene.premium.host.PaywallHostActivity r1 = r8.f113261h
            cz.mobilesoft.coreblock.scene.premium.host.PaywallSpec r1 = cz.mobilesoft.coreblock.scene.premium.host.PaywallHostActivity.v1(r1)
            cz.mobilesoft.coreblock.scene.premium.host.PaywallHostActivity r5 = r8.f113261h
            cz.mobilesoft.coreblock.storage.datastore.PaywallDataStore r5 = cz.mobilesoft.coreblock.scene.premium.host.PaywallHostActivity.u1(r5)
            r8.f113255a = r9
            r8.f113256b = r1
            r8.f113260g = r4
            java.lang.Object r4 = cz.mobilesoft.coreblock.util.monetization.MonetizationConfigKt.a(r5, r8)
            if (r4 != r0) goto L70
            goto Laa
        L70:
            r7 = r4
            r4 = r9
            r9 = r7
        L73:
            cz.mobilesoft.coreblock.util.monetization.MonetizationConfig r9 = (cz.mobilesoft.coreblock.util.monetization.MonetizationConfig) r9
            cz.mobilesoft.coreblock.scene.premium.host.PaywallHostActivity r5 = r8.f113261h
            cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore r5 = cz.mobilesoft.coreblock.scene.premium.host.PaywallHostActivity.q1(r5)
            r8.f113255a = r4
            r8.f113256b = r1
            r8.f113257c = r9
            r8.f113260g = r3
            java.lang.Object r3 = r5.E1(r8)
            if (r3 != r0) goto L8a
            goto Laa
        L8a:
            r7 = r1
            r1 = r9
            r9 = r3
            r3 = r7
        L8e:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            cz.mobilesoft.coreblock.util.superwall.SuperwallInitializer r5 = cz.mobilesoft.coreblock.util.superwall.SuperwallInitializer.f129740a
            boolean r5 = r5.c()
            cz.mobilesoft.coreblock.scene.premium.host.PaywallHostActivity r6 = r8.f113261h
            r8.f113255a = r4
            r8.f113256b = r3
            r8.f113257c = r1
            r8.f113258d = r9
            r8.f113259f = r5
            r8.f113260g = r2
            java.lang.Object r2 = cz.mobilesoft.coreblock.scene.premium.host.PaywallHostActivity.z1(r6, r8)
            if (r2 != r0) goto Lab
        Laa:
            return r0
        Lab:
            r0 = r3
            r3 = r9
            r9 = r2
            r2 = r1
            r1 = r0
            r0 = r4
            r4 = r5
        Lb2:
            r5 = r9
            cz.mobilesoft.coreblock.util.monetization.PaywallEngine r5 = (cz.mobilesoft.coreblock.util.monetization.PaywallEngine) r5
            boolean r9 = r0.a(r1, r2, r3, r4, r5)
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.a(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.premium.host.PaywallHostActivity$askSuperwallGate$1$present$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((PaywallHostActivity$askSuperwallGate$1$present$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
