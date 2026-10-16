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
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.profile.ProfileToViewDTOHelperKt", f = "ProfileToViewDTOHelper.kt", l = {140, 141, 142, 144, 145, 146, 147, 151}, m = "reloadAndReparseProfiles", v = 1)
final class ProfileToViewDTOHelperKt$reloadAndReparseProfiles$2 extends ContinuationImpl {
    int A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f129358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f129359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f129360c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f129361d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f129362f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f129363g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Object f129364h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Object f129365i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Object f129366j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    Object f129367k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    Object f129368l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    Object f129369m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    Object f129370n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    Object f129371o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    Object f129372p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    Object f129373q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    Object f129374r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    Object f129375s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    Object f129376t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    Object f129377u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    Object f129378v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    Object f129379w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    Object f129380x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    boolean f129381y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    /* synthetic */ Object f129382z;

    ProfileToViewDTOHelperKt$reloadAndReparseProfiles$2(Continuation continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f129382z = obj;
        this.A |= Integer.MIN_VALUE;
        return ProfileToViewDTOHelperKt.E(null, null, null, this);
    }
}
