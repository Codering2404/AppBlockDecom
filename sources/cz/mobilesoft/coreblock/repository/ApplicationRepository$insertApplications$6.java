package cz.mobilesoft.coreblock.repository;

import com.sun.jna.Function;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.repository.ApplicationRepository", f = "ApplicationRepository.kt", l = {Function.MAX_NARGS, 258, 262}, m = "insertApplications", v = 1)
final class ApplicationRepository$insertApplications$6 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f97489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f97490b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f97491c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f97492d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f97493f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f97494g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f97495h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    /* synthetic */ Object f97496i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ ApplicationRepository f97497j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f97498k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ApplicationRepository$insertApplications$6(ApplicationRepository applicationRepository, Continuation continuation) {
        super(continuation);
        this.f97497j = applicationRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f97496i = obj;
        this.f97498k |= Integer.MIN_VALUE;
        return this.f97497j.p(null, null, null, false, null, this);
    }
}
