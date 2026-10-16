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
@DebugMetadata(c = "cz.mobilesoft.coreblock.repository.StrictModeRepository", f = "StrictModeRepository.kt", l = {249, Function.MAX_NARGS, 259, 260, 268, 271, 273, 286, 287, 288, 291}, m = "deactivate", v = 1)
final class StrictModeRepository$deactivate$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f98284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f98285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f98286c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f98287d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    long f98288f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    long f98289g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    long f98290h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f98291i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    /* synthetic */ Object f98292j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ StrictModeRepository f98293k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f98294l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StrictModeRepository$deactivate$1(StrictModeRepository strictModeRepository, Continuation continuation) {
        super(continuation);
        this.f98293k = strictModeRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f98292j = obj;
        this.f98294l |= Integer.MIN_VALUE;
        return this.f98293k.f(false, this);
    }
}
