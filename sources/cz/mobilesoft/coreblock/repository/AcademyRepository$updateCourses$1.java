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
@DebugMetadata(c = "cz.mobilesoft.coreblock.repository.AcademyRepository", f = "AcademyRepository.kt", l = {96, 100, 102, 121, 122, 147, 148, 150, 153, 156}, m = "updateCourses", v = 1)
final class AcademyRepository$updateCourses$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f97292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f97293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f97294c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f97295d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f97296f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f97297g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Object f97298h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Object f97299i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Object f97300j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    Object f97301k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    Object f97302l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    /* synthetic */ Object f97303m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final /* synthetic */ AcademyRepository f97304n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    int f97305o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AcademyRepository$updateCourses$1(AcademyRepository academyRepository, Continuation continuation) {
        super(continuation);
        this.f97304n = academyRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f97303m = obj;
        this.f97305o |= Integer.MIN_VALUE;
        return this.f97304n.s(this);
    }
}
