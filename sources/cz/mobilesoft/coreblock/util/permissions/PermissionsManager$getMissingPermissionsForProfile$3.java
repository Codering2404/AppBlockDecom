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
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.permissions.PermissionsManager", f = "PermissionsManager.kt", l = {101, 112}, m = "getMissingPermissionsForProfile", v = 1)
final class PermissionsManager$getMissingPermissionsForProfile$3 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f129092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f129093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f129094c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f129095d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f129096f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f129097g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f129098h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f129099i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    boolean f129100j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    boolean f129101k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    Object f129102l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    Object f129103m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    Object f129104n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    Object f129105o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    Object f129106p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    Object f129107q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    Object f129108r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    /* synthetic */ Object f129109s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    final /* synthetic */ PermissionsManager f129110t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    int f129111u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PermissionsManager$getMissingPermissionsForProfile$3(PermissionsManager permissionsManager, Continuation continuation) {
        super(continuation);
        this.f129110t = permissionsManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f129109s = obj;
        this.f129111u |= Integer.MIN_VALUE;
        return this.f129110t.m(0, false, false, false, false, false, false, this);
    }
}
