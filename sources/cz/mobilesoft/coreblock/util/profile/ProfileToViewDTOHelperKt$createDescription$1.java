package cz.mobilesoft.coreblock.util.profile;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.profile.ProfileToViewDTOHelperKt", f = "ProfileToViewDTOHelper.kt", l = {902, 904, 905}, m = "createDescription", v = 1)
final class ProfileToViewDTOHelperKt$createDescription$1 extends ContinuationImpl {
    /* synthetic */ Object A;
    int B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f129307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f129308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f129309c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f129310d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f129311f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f129312g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Object f129313h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Object f129314i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Object f129315j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    Object f129316k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    Object f129317l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    Object f129318m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    Object f129319n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    Object f129320o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    Object f129321p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    Object f129322q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    Object f129323r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    Object f129324s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    Object f129325t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    Object f129326u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    boolean f129327v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    boolean f129328w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    boolean f129329x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    int f129330y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    long f129331z;

    ProfileToViewDTOHelperKt$createDescription$1(Continuation continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.A = obj;
        this.B |= Integer.MIN_VALUE;
        return ProfileToViewDTOHelperKt.p(null, null, null, null, null, null, null, null, null, null, false, this);
    }
}
