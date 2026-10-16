package cz.mobilesoft.coreblock.scene.selection.recommended;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.coroutines.CoroutineScope;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.selection.recommended.RecommendedAppsViewModel$getWebsitesForSelectedApps$1", f = "RecommendedAppsViewModel.kt", l = {131, 145}, m = "invokeSuspend", v = 1)
final class RecommendedAppsViewModel$getWebsitesForSelectedApps$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f119215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f119216b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f119217c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ RecommendedAppsViewModel f119218d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RecommendedAppsViewModel$getWebsitesForSelectedApps$1(RecommendedAppsViewModel recommendedAppsViewModel, Continuation continuation) {
        super(2, continuation);
        this.f119218d = recommendedAppsViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RecommendedAppsViewState q(List list, RecommendedAppsViewState recommendedAppsViewState) {
        return RecommendedAppsViewState.b(recommendedAppsViewState, null, ExtensionsKt.h(list), 1, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new RecommendedAppsViewModel$getWebsitesForSelectedApps$1(this.f119218d, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x007b, code lost:
    
        if (r14 == r0) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00df, code lost:
    
        if (r14.P0(r3, r13) == r0) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00e1, code lost:
    
        return r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c5  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 229
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.selection.recommended.RecommendedAppsViewModel$getWebsitesForSelectedApps$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((RecommendedAppsViewModel$getWebsitesForSelectedApps$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
