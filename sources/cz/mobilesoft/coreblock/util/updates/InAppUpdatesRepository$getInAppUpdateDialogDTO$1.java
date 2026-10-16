package cz.mobilesoft.coreblock.util.updates;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository", f = "InAppUpdatesRepository.kt", l = {277, 278, 279, 280, 284, 285, 297, 298, 302, 303, 309, 313, 321}, m = "getInAppUpdateDialogDTO", v = 1)
final class InAppUpdatesRepository$getInAppUpdateDialogDTO$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f129884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f129885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f129886c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f129887d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f129888f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    long f129889g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    long f129890h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    long f129891i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    long f129892j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    /* synthetic */ Object f129893k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final /* synthetic */ InAppUpdatesRepository f129894l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    int f129895m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InAppUpdatesRepository$getInAppUpdateDialogDTO$1(InAppUpdatesRepository inAppUpdatesRepository, Continuation continuation) {
        super(continuation);
        this.f129894l = inAppUpdatesRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f129893k = obj;
        this.f129895m |= Integer.MIN_VALUE;
        return this.f129894l.q(this);
    }
}
