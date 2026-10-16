package cz.mobilesoft.coreblock.scene.dashboard;

import cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.DashboardViewModel$9$2", f = "DashboardViewModel.kt", l = {212, 214, 215}, m = "emit", v = 1)
final class DashboardViewModel$9$2$emit$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f99337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f99338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f99339c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f99340d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f99341f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    long f99342g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    /* synthetic */ Object f99343h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ DashboardViewModel.AnonymousClass9.AnonymousClass2 f99344i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f99345j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DashboardViewModel$9$2$emit$1(DashboardViewModel.AnonymousClass9.AnonymousClass2 anonymousClass2, Continuation continuation) {
        super(continuation);
        this.f99344i = anonymousClass2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f99343h = obj;
        this.f99345j |= Integer.MIN_VALUE;
        return this.f99344i.emit(null, this);
    }
}
