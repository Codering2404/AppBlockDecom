package cz.mobilesoft.coreblock.base.viewmodel;

import cz.mobilesoft.coreblock.base.viewmodel.BaseBillingViewModel$initInAppBilling$1$setupCompleted$1;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.base.viewmodel.BaseBillingViewModel$initInAppBilling$1$setupCompleted$1$1", f = "BaseBillingViewModel.kt", l = {120, 127, 131, 135, 138}, m = "emit", v = 1)
final class BaseBillingViewModel$initInAppBilling$1$setupCompleted$1$1$emit$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f96374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f96375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f96376c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f96377d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f96378f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    /* synthetic */ Object f96379g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ BaseBillingViewModel$initInAppBilling$1$setupCompleted$1.AnonymousClass1 f96380h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f96381i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BaseBillingViewModel$initInAppBilling$1$setupCompleted$1$1$emit$1(BaseBillingViewModel$initInAppBilling$1$setupCompleted$1.AnonymousClass1 anonymousClass1, Continuation continuation) {
        super(continuation);
        this.f96380h = anonymousClass1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f96379g = obj;
        this.f96381i |= Integer.MIN_VALUE;
        return this.f96380h.emit(null, this);
    }
}
