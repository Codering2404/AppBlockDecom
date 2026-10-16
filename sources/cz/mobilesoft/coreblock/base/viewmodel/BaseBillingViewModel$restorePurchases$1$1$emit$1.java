package cz.mobilesoft.coreblock.base.viewmodel;

import cz.mobilesoft.coreblock.base.viewmodel.BaseBillingViewModel$restorePurchases$1;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.base.viewmodel.BaseBillingViewModel$restorePurchases$1$1", f = "BaseBillingViewModel.kt", l = {251, 254, 257, 258}, m = "emit", v = 1)
final class BaseBillingViewModel$restorePurchases$1$1$emit$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f96398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f96399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ BaseBillingViewModel$restorePurchases$1.AnonymousClass1 f96400c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f96401d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BaseBillingViewModel$restorePurchases$1$1$emit$1(BaseBillingViewModel$restorePurchases$1.AnonymousClass1 anonymousClass1, Continuation continuation) {
        super(continuation);
        this.f96400c = anonymousClass1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f96399b = obj;
        this.f96401d |= Integer.MIN_VALUE;
        return this.f96400c.emit(null, this);
    }
}
