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
@DebugMetadata(c = "cz.mobilesoft.coreblock.repository.AppVersionRepository", f = "AppVersionRepository.kt", l = {546, 566, 569, 572, 576, 600}, m = "handlePossibleUpdate", v = 1)
final class AppVersionRepository$handlePossibleUpdate$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f97393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f97394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f97395c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f97396d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f97397f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f97398g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f97399h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f97400i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    boolean f97401j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f97402k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f97403l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    int f97404m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f97405n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    int f97406o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    int f97407p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    int f97408q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    int f97409r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    /* synthetic */ Object f97410s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    final /* synthetic */ AppVersionRepository f97411t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    int f97412u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AppVersionRepository$handlePossibleUpdate$1(AppVersionRepository appVersionRepository, Continuation continuation) {
        super(continuation);
        this.f97411t = appVersionRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f97410s = obj;
        this.f97412u |= Integer.MIN_VALUE;
        return this.f97411t.x(null, false, this);
    }
}
