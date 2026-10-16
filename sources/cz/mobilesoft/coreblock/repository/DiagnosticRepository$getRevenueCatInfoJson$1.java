package cz.mobilesoft.coreblock.repository;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.repository.DiagnosticRepository", f = "DiagnosticRepository.kt", l = {55}, m = "getRevenueCatInfoJson", v = 1)
final class DiagnosticRepository$getRevenueCatInfoJson$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f97684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f97685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f97686c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    /* synthetic */ Object f97687d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ DiagnosticRepository f97688f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f97689g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DiagnosticRepository$getRevenueCatInfoJson$1(DiagnosticRepository diagnosticRepository, Continuation continuation) {
        super(continuation);
        this.f97688f = diagnosticRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f97687d = obj;
        this.f97689g |= Integer.MIN_VALUE;
        return this.f97688f.i(this);
    }
}
