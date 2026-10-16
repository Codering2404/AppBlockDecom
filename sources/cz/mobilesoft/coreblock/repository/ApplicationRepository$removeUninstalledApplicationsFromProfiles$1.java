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
@DebugMetadata(c = "cz.mobilesoft.coreblock.repository.ApplicationRepository", f = "ApplicationRepository.kt", l = {371, 372, 373, 374, 377, 382, 384}, m = "removeUninstalledApplicationsFromProfiles", v = 1)
final class ApplicationRepository$removeUninstalledApplicationsFromProfiles$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f97525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f97526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f97527c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f97528d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f97529f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f97530g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Object f97531h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Object f97532i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    boolean f97533j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f97534k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f97535l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    int f97536m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    /* synthetic */ Object f97537n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    final /* synthetic */ ApplicationRepository f97538o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    int f97539p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ApplicationRepository$removeUninstalledApplicationsFromProfiles$1(ApplicationRepository applicationRepository, Continuation continuation) {
        super(continuation);
        this.f97538o = applicationRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f97537n = obj;
        this.f97539p |= Integer.MIN_VALUE;
        return this.f97538o.u(null, false, this);
    }
}
