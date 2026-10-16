package cz.mobilesoft.coreblock.repository;

import com.facebook.internal.FacebookRequestErrorClassification;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.repository.ScheduleRepository", f = "ScheduleRepository.kt", l = {99, 121, 130, 147, 164, 174, 179, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 206, 211}, m = "toScheduleDTO", v = 1)
final class ScheduleRepository$toScheduleDTO$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f98135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f98136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f98137c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f98138d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f98139f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f98140g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Object f98141h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Object f98142i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Object f98143j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    Object f98144k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    Object f98145l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    Object f98146m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    Object f98147n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    Object f98148o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    Object f98149p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    /* synthetic */ Object f98150q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    final /* synthetic */ ScheduleRepository f98151r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    int f98152s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScheduleRepository$toScheduleDTO$1(ScheduleRepository scheduleRepository, Continuation continuation) {
        super(continuation);
        this.f98151r = scheduleRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f98150q = obj;
        this.f98152s |= Integer.MIN_VALUE;
        return this.f98151r.T(null, this);
    }
}
