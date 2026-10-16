package cz.mobilesoft.coreblock.scene.streaks;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.streaks.StreakRepository", f = "StreakRepository.kt", l = {96, 99, 113, 111, 122, 123}, m = "catchUp", v = 1)
final class StreakRepository$catchUp$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f120415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f120416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f120417c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f120418d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f120419f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f120420g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Object f120421h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Object f120422i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Object f120423j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    long f120424k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f120425l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    int f120426m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    /* synthetic */ Object f120427n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    final /* synthetic */ StreakRepository f120428o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    int f120429p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreakRepository$catchUp$1(StreakRepository streakRepository, Continuation continuation) {
        super(continuation);
        this.f120428o = streakRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f120427n = obj;
        this.f120429p |= Integer.MIN_VALUE;
        return this.f120428o.b(null, 0L, null, 0, this);
    }
}
