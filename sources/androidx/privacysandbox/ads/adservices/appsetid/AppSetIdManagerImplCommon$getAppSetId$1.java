package androidx.privacysandbox.ads.adservices.appsetid;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManagerImplCommon", f = "AppSetIdManagerImplCommon.kt", l = {38}, m = "getAppSetId$suspendImpl")
final class AppSetIdManagerImplCommon$getAppSetId$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f51185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f51186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ AppSetIdManagerImplCommon f51187c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f51188d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AppSetIdManagerImplCommon$getAppSetId$1(AppSetIdManagerImplCommon appSetIdManagerImplCommon, Continuation continuation) {
        super(continuation);
        this.f51187c = appSetIdManagerImplCommon;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f51186b = obj;
        this.f51188d |= Integer.MIN_VALUE;
        return AppSetIdManagerImplCommon.d(this.f51187c, this);
    }
}
