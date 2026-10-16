package cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues.RemoteConfigValuesProvider", f = "RemoteConfigValuesProvider.kt", l = {24, 27}, m = "fetchCurrentValues", v = 1)
final class RemoteConfigValuesProvider$fetchCurrentValues$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f109282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f109283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    /* synthetic */ Object f109284c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ RemoteConfigValuesProvider f109285d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f109286f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RemoteConfigValuesProvider$fetchCurrentValues$1(RemoteConfigValuesProvider remoteConfigValuesProvider, Continuation continuation) {
        super(continuation);
        this.f109285d = remoteConfigValuesProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f109284c = obj;
        this.f109286f |= Integer.MIN_VALUE;
        return this.f109285d.b(this);
    }
}
