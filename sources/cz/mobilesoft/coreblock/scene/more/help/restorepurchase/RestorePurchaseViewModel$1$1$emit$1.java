package cz.mobilesoft.coreblock.scene.more.help.restorepurchase;

import cz.mobilesoft.coreblock.scene.more.help.restorepurchase.RestorePurchaseViewModel;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.help.restorepurchase.RestorePurchaseViewModel$1$1", f = "RestorePurchaseViewModel.kt", l = {29, 30}, m = "emit", v = 1)
final class RestorePurchaseViewModel$1$1$emit$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f107835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f107836b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ RestorePurchaseViewModel.AnonymousClass1.C02841 f107837c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f107838d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RestorePurchaseViewModel$1$1$emit$1(RestorePurchaseViewModel.AnonymousClass1.C02841 c02841, Continuation continuation) {
        super(continuation);
        this.f107837c = c02841;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f107836b = obj;
        this.f107838d |= Integer.MIN_VALUE;
        return this.f107837c.emit(null, this);
    }
}
