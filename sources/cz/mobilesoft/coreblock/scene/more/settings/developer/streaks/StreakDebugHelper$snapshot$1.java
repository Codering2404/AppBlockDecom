package cz.mobilesoft.coreblock.scene.more.settings.developer.streaks;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.streaks.StreakDebugHelper", f = "StreakDebugHelper.kt", l = {58, 59, 63, 86, 87, 88}, m = "snapshot", v = 1)
final class StreakDebugHelper$snapshot$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f109398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    long f109399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    long f109400c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    long f109401d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f109402f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f109403g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Object f109404h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Object f109405i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Object f109406j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    Object f109407k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    Object f109408l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    Object f109409m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    Object f109410n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    Object f109411o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    Object f109412p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    Object f109413q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    int f109414r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    int f109415s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    boolean f109416t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    /* synthetic */ Object f109417u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    final /* synthetic */ StreakDebugHelper f109418v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    int f109419w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreakDebugHelper$snapshot$1(StreakDebugHelper streakDebugHelper, Continuation continuation) {
        super(continuation);
        this.f109418v = streakDebugHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f109417u = obj;
        this.f109419w |= Integer.MIN_VALUE;
        return this.f109418v.f(0L, null, this);
    }
}
