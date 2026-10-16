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
@DebugMetadata(c = "cz.mobilesoft.coreblock.model.RemoteConfig", f = "RemoteConfig.kt", l = {532, 535}, m = "savePrefManager", v = 1)
final class RemoteConfig$savePrefManager$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f97175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f97176b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f97177c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f97178d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f97179f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f97180g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Object f97181h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Object f97182i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Object f97183j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    Object f97184k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    Object f97185l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    long f97186m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    long f97187n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    long f97188o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    long f97189p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    long f97190q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    boolean f97191r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    boolean f97192s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    /* synthetic */ Object f97193t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    final /* synthetic */ RemoteConfig f97194u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    int f97195v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RemoteConfig$savePrefManager$1(RemoteConfig remoteConfig, Continuation continuation) {
        super(continuation);
        this.f97194u = remoteConfig;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f97193t = obj;
        this.f97195v |= Integer.MIN_VALUE;
        return this.f97194u.L(null, this);
    }
}
