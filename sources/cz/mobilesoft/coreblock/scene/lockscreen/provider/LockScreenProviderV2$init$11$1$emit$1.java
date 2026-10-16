package cz.mobilesoft.coreblock.scene.lockscreen.provider;

import cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2$init$11;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2$init$11$1", f = "LockScreenProviderV2.kt", l = {460}, m = "emit", v = 1)
final class LockScreenProviderV2$init$11$1$emit$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f105845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f105846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ LockScreenProviderV2$init$11.AnonymousClass1 f105847c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f105848d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LockScreenProviderV2$init$11$1$emit$1(LockScreenProviderV2$init$11.AnonymousClass1 anonymousClass1, Continuation continuation) {
        super(continuation);
        this.f105847c = anonymousClass1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f105846b = obj;
        this.f105848d |= Integer.MIN_VALUE;
        return this.f105847c.emit(null, this);
    }
}
