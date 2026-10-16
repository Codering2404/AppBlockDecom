package cz.mobilesoft.coreblock.model;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.model.RemoteConfig", f = "RemoteConfig.kt", l = {701, 133}, m = "initIfNeeded", v = 1)
final class RemoteConfig$initIfNeeded$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f97093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f97094b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f97095c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f97096d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f97097f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f97098g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    /* synthetic */ Object f97099h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ RemoteConfig f97100i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f97101j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RemoteConfig$initIfNeeded$1(RemoteConfig remoteConfig, Continuation continuation) {
        super(continuation);
        this.f97100i = remoteConfig;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f97099h = obj;
        this.f97101j |= Integer.MIN_VALUE;
        return this.f97100i.C(this);
    }
}
