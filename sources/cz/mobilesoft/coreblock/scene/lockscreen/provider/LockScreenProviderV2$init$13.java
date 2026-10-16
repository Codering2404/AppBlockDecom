package cz.mobilesoft.coreblock.scene.lockscreen.provider;

import com.google.android.gms.ads.AdView;
import cz.mobilesoft.coreblock.scene.lockscreen.LockViewState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2$init$13", f = "LockScreenProviderV2.kt", l = {509, 528}, m = "invokeSuspend", v = 1)
final class LockScreenProviderV2$init$13 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f105852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ LockScreenProviderV2 f105853b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LockScreenProviderV2$init$13(LockScreenProviderV2 lockScreenProviderV2, Continuation continuation) {
        super(2, continuation);
        this.f105853b = lockScreenProviderV2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LockViewState A(boolean z2, LockViewState lockViewState) {
        return LockViewState.b(lockViewState, null, null, 0, 0, false, 0, false, false, false, false, false, false, false, null, false, null, null, null, null, null, null, null, false, null, null, false, null, 0.0f, false, z2, false, null, null, null, false, null, -536870913, 15, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(LockScreenProviderV2 lockScreenProviderV2, final AdView adView) {
        lockScreenProviderV2.C = true;
        lockScreenProviderV2.V0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.provider.w
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LockScreenProviderV2$init$13.J(adView, (LockViewState) obj);
            }
        });
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LockViewState J(AdView adView, LockViewState lockViewState) {
        return LockViewState.b(lockViewState, null, null, 0, 0, false, 0, false, false, false, false, false, false, false, null, false, null, null, null, null, null, null, null, true, adView, null, false, null, 0.0f, false, false, false, null, null, null, false, null, -12582913, 15, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LockViewState K(LockViewState lockViewState) {
        return LockViewState.b(lockViewState, null, null, 0, 0, false, 0, false, false, false, false, false, false, false, null, false, null, null, null, null, null, null, null, false, null, null, false, null, 0.0f, false, false, false, null, null, null, false, null, -536870913, 15, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new LockScreenProviderV2$init$13(this.f105853b, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x005f, code lost:
    
        if (r9 == r0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x009f, code lost:
    
        if (kotlinx.coroutines.DelayKt.b(2000, r8) != r0) goto L24;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r8.f105852a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1f
            if (r1 == r3) goto L1b
            if (r1 != r2) goto L13
            kotlin.ResultKt.b(r9)
            goto La2
        L13:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L1b:
            kotlin.ResultKt.b(r9)
            goto L62
        L1f:
            kotlin.ResultKt.b(r9)
            cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2 r9 = r8.f105853b
            long r4 = r9.m0()
            r6 = -1
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r9 == 0) goto L3f
            cz.mobilesoft.coreblock.util.analytics.AnswersHelper r9 = cz.mobilesoft.coreblock.util.analytics.AnswersHelper.f128199a
            cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2 r1 = r8.f105853b
            long r3 = r1.m0()
            r9.b1(r3)
            cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2 r9 = r8.f105853b
            cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2.r(r9)
            goto L97
        L3f:
            cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2 r9 = r8.f105853b
            boolean r9 = cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2.H(r9)
            if (r9 != 0) goto L97
            cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager r9 = cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager.f126839a
            boolean r9 = r9.X0()
            if (r9 == 0) goto L97
            cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2 r9 = r8.f105853b
            cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r9 = cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2.u(r9)
            kotlinx.coroutines.flow.Flow r9 = r9.s2()
            r8.f105852a = r3
            java.lang.Object r9 = kotlinx.coroutines.flow.FlowKt.D(r9, r8)
            if (r9 != r0) goto L62
            goto La1
        L62:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2 r1 = r8.f105853b
            cz.mobilesoft.coreblock.scene.lockscreen.provider.t r3 = new cz.mobilesoft.coreblock.scene.lockscreen.provider.t
            r3.<init>()
            cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2.R(r1, r3)
            cz.mobilesoft.coreblock.util.LockScreenBannerUtils r9 = cz.mobilesoft.coreblock.util.LockScreenBannerUtils.f127896d
            cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2 r1 = r8.f105853b
            android.content.Context r1 = cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2.t(r1)
            android.content.Context r1 = r1.getApplicationContext()
            java.lang.String r3 = "getApplicationContext(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2 r3 = r8.f105853b
            cz.mobilesoft.coreblock.repository.PremiumRepositoryV2 r3 = cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2.C(r3)
            cz.mobilesoft.coreblock.enums.PremiumState r3 = r3.J()
            cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2 r4 = r8.f105853b
            cz.mobilesoft.coreblock.scene.lockscreen.provider.u r5 = new cz.mobilesoft.coreblock.scene.lockscreen.provider.u
            r5.<init>()
            r9.f(r1, r3, r5)
        L97:
            r8.f105852a = r2
            r1 = 2000(0x7d0, double:9.88E-321)
            java.lang.Object r9 = kotlinx.coroutines.DelayKt.b(r1, r8)
            if (r9 != r0) goto La2
        La1:
            return r0
        La2:
            cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2 r9 = r8.f105853b
            cz.mobilesoft.coreblock.scene.lockscreen.provider.v r0 = new cz.mobilesoft.coreblock.scene.lockscreen.provider.v
            r0.<init>()
            cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2.R(r9, r0)
            kotlin.Unit r9 = kotlin.Unit.f139807a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2$init$13.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((LockScreenProviderV2$init$13) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
