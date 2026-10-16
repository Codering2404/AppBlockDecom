package cz.mobilesoft.coreblock.scene.onboarding;

import cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2$checkPendingDeeplink$1;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2$checkPendingDeeplink$1$1", f = "OnboardingViewModelV2.kt", l = {141, 142, 143, 144, 147, 149, 153, 157, 161, 168, 169}, m = "emit", v = 1)
final class OnboardingViewModelV2$checkPendingDeeplink$1$1$emit$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f110981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f110982b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f110983c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    /* synthetic */ Object f110984d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ OnboardingViewModelV2$checkPendingDeeplink$1.AnonymousClass1 f110985f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f110986g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OnboardingViewModelV2$checkPendingDeeplink$1$1$emit$1(OnboardingViewModelV2$checkPendingDeeplink$1.AnonymousClass1 anonymousClass1, Continuation continuation) {
        super(continuation);
        this.f110985f = anonymousClass1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f110984d = obj;
        this.f110986g |= Integer.MIN_VALUE;
        return this.f110985f.emit(null, this);
    }
}
