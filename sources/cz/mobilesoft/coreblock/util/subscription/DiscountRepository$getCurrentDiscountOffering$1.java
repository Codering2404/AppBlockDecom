package cz.mobilesoft.coreblock.util.subscription;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.subscription.DiscountRepository", f = "DiscountRepository.kt", l = {106, 107, 116, 139}, m = "getCurrentDiscountOffering", v = 1)
final class DiscountRepository$getCurrentDiscountOffering$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f129684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    long f129685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    long f129686c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    long f129687d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    long f129688f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    long f129689g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    long f129690h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f129691i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f129692j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    Object f129693k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    Object f129694l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    Object f129695m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    /* synthetic */ Object f129696n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    final /* synthetic */ DiscountRepository f129697o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    int f129698p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DiscountRepository$getCurrentDiscountOffering$1(DiscountRepository discountRepository, Continuation continuation) {
        super(continuation);
        this.f129697o = discountRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f129696n = obj;
        this.f129698p |= Integer.MIN_VALUE;
        return this.f129697o.a(0L, this);
    }
}
