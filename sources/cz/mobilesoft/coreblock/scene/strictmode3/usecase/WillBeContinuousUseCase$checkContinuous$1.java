package cz.mobilesoft.coreblock.scene.strictmode3.usecase;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.strictmode3.usecase.WillBeContinuousUseCase", f = "WillBeContinuousUseCase.kt", l = {58, 126}, m = "checkContinuous", v = 1)
final class WillBeContinuousUseCase$checkContinuous$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f122584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f122585b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f122586c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f122587d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f122588f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f122589g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Object f122590h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Object f122591i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Object f122592j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    Object f122593k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f122594l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    int f122595m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f122596n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    int f122597o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    int f122598p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    int f122599q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    int f122600r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    int f122601s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    int f122602t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    int f122603u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    /* synthetic */ Object f122604v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    final /* synthetic */ WillBeContinuousUseCase f122605w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    int f122606x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WillBeContinuousUseCase$checkContinuous$1(WillBeContinuousUseCase willBeContinuousUseCase, Continuation continuation) {
        super(continuation);
        this.f122605w = willBeContinuousUseCase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f122604v = obj;
        this.f122606x |= Integer.MIN_VALUE;
        return this.f122605w.c(null, null, null, null, null, this);
    }
}
