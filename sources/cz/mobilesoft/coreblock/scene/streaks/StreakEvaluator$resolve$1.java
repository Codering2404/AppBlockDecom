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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator", f = "StreakEvaluator.kt", l = {285, 290, 291, 298}, m = "resolve", v = 1)
final class StreakEvaluator$resolve$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f120338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f120339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f120340c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f120341d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f120342f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f120343g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Object f120344h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Object f120345i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    long f120346j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    long f120347k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    long f120348l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    long f120349m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    boolean f120350n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    /* synthetic */ Object f120351o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    final /* synthetic */ StreakEvaluator f120352p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    int f120353q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreakEvaluator$resolve$1(StreakEvaluator streakEvaluator, Continuation continuation) {
        super(continuation);
        this.f120352p = streakEvaluator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f120351o = obj;
        this.f120353q |= Integer.MIN_VALUE;
        return this.f120352p.k(null, 0L, null, this);
    }
}
