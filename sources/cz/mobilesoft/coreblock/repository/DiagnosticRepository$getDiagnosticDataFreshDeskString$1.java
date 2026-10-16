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
@DebugMetadata(c = "cz.mobilesoft.coreblock.repository.DiagnosticRepository", f = "DiagnosticRepository.kt", l = {117, 162}, m = "getDiagnosticDataFreshDeskString", v = 1)
final class DiagnosticRepository$getDiagnosticDataFreshDeskString$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f97665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f97666b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f97667c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f97668d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f97669f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f97670g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Object f97671h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Object f97672i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Object f97673j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    Object f97674k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    Object f97675l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    Object f97676m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    /* synthetic */ Object f97677n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    final /* synthetic */ DiagnosticRepository f97678o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    int f97679p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DiagnosticRepository$getDiagnosticDataFreshDeskString$1(DiagnosticRepository diagnosticRepository, Continuation continuation) {
        super(continuation);
        this.f97678o = diagnosticRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f97677n = obj;
        this.f97679p |= Integer.MIN_VALUE;
        return this.f97678o.e(null, this);
    }
}
