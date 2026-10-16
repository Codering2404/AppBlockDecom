package cz.mobilesoft.coreblock.util.permissions;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.permissions.PermissionsManager", f = "PermissionsManager.kt", l = {318, 320, 326, 326, 327, 328, 330, 332, 334, 338, 350, 378, 404, 428, 438}, m = "getMissingPermissions", v = 1)
final class PermissionsManager$getMissingPermissions$1 extends ContinuationImpl {
    int A;
    int B;
    int C;
    int D;
    int E;
    int F;
    int G;
    int H;
    int I;
    int J;
    int K;
    int L;
    int M;
    /* synthetic */ Object N;
    final /* synthetic */ PermissionsManager O;
    int P;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f129050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f129051b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f129052c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f129053d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f129054f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f129055g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f129056h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f129057i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    boolean f129058j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    boolean f129059k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    boolean f129060l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    boolean f129061m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    boolean f129062n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    boolean f129063o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    boolean f129064p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    boolean f129065q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    Object f129066r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    Object f129067s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    Object f129068t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    Object f129069u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    Object f129070v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    Object f129071w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    int f129072x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    int f129073y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    int f129074z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PermissionsManager$getMissingPermissions$1(PermissionsManager permissionsManager, Continuation continuation) {
        super(continuation);
        this.O = permissionsManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.N = obj;
        this.P |= Integer.MIN_VALUE;
        return this.O.l(false, null, false, false, this);
    }
}
