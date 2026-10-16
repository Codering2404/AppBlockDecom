package cz.mobilesoft.coreblock.util.location;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.location.LocationCheckHelper", f = "LocationCheckHelper.kt", l = {152, 165, 184, 227, 228, 237, 242}, m = "checkLocation", v = 1)
final class LocationCheckHelper$checkLocation$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f128816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f128817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f128818c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f128819d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f128820f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f128821g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Object f128822h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Object f128823i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Object f128824j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    float f128825k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    long f128826l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    int f128827m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f128828n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    /* synthetic */ Object f128829o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    final /* synthetic */ LocationCheckHelper f128830p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    int f128831q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LocationCheckHelper$checkLocation$1(LocationCheckHelper locationCheckHelper, Continuation continuation) {
        super(continuation);
        this.f128830p = locationCheckHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f128829o = obj;
        this.f128831q |= Integer.MIN_VALUE;
        return this.f128830p.o(null, this);
    }
}
