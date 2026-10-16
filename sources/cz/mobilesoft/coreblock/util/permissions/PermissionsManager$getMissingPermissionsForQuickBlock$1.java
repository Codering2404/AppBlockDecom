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
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.permissions.PermissionsManager", f = "PermissionsManager.kt", l = {166, 173}, m = "getMissingPermissionsForQuickBlock", v = 1)
final class PermissionsManager$getMissingPermissionsForQuickBlock$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f129124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f129125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f129126c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f129127d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f129128f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f129129g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Object f129130h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Object f129131i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    /* synthetic */ Object f129132j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ PermissionsManager f129133k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f129134l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PermissionsManager$getMissingPermissionsForQuickBlock$1(PermissionsManager permissionsManager, Continuation continuation) {
        super(continuation);
        this.f129133k = permissionsManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f129132j = obj;
        this.f129134l |= Integer.MIN_VALUE;
        return this.f129133k.q(false, false, false, false, false, false, null, this);
    }
}
