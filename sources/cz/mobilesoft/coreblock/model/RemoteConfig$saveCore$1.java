package cz.mobilesoft.coreblock.model;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.model.RemoteConfig", f = "RemoteConfig.kt", l = {325, 326, 327, 328, 329, 330, 331, 332, 333, 334, 337, 343, 346, 347, 348, 349, 350, 351, 352, 353, 354, 357, 360, 364, 365, 366, 367, 368, 370, 371, 372, 373, 374, 375, 376, 377, 378, 379, 380}, m = "saveCore", v = 1)
final class RemoteConfig$saveCore$1 extends ContinuationImpl {
    boolean A;
    boolean B;
    boolean C;
    boolean D;
    boolean E;
    boolean F;
    boolean G;
    boolean H;
    boolean I;
    boolean J;
    boolean K;
    boolean L;
    boolean M;
    boolean N;
    boolean O;
    int P;
    /* synthetic */ Object Q;
    final /* synthetic */ RemoteConfig R;
    int S;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f97105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f97106b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f97107c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f97108d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f97109f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f97110g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Object f97111h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Object f97112i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Object f97113j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    Object f97114k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    Object f97115l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    Object f97116m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    Object f97117n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    Object f97118o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    boolean f97119p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    boolean f97120q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    boolean f97121r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    boolean f97122s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    boolean f97123t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    boolean f97124u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    boolean f97125v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    boolean f97126w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    boolean f97127x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    boolean f97128y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    boolean f97129z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RemoteConfig$saveCore$1(RemoteConfig remoteConfig, Continuation continuation) {
        super(continuation);
        this.R = remoteConfig;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.Q = obj;
        this.S |= Integer.MIN_VALUE;
        return this.R.E(null, this);
    }
}
