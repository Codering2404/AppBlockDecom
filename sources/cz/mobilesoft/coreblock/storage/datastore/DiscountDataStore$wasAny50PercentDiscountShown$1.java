package cz.mobilesoft.coreblock.storage.datastore;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore", f = "DiscountDataStore.kt", l = {220}, m = "wasAny50PercentDiscountShown", v = 1)
final class DiscountDataStore$wasAny50PercentDiscountShown$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f124370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f124371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ DiscountDataStore f124372c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f124373d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DiscountDataStore$wasAny50PercentDiscountShown$1(DiscountDataStore discountDataStore, Continuation continuation) {
        super(continuation);
        this.f124372c = discountDataStore;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f124371b = obj;
        this.f124373d |= Integer.MIN_VALUE;
        return this.f124372c.i2(this);
    }
}
