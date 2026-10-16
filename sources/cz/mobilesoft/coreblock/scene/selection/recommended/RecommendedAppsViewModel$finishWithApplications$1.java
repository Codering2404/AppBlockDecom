package cz.mobilesoft.coreblock.scene.selection.recommended;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.selection.recommended.RecommendedAppsViewModel$finishWithApplications$1", f = "RecommendedAppsViewModel.kt", l = {61, 69}, m = "invokeSuspend", v = 1)
final class RecommendedAppsViewModel$finishWithApplications$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f119209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f119210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f119211c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ RecommendedAppsViewModel f119212d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ boolean f119213f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ boolean f119214g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RecommendedAppsViewModel$finishWithApplications$1(RecommendedAppsViewModel recommendedAppsViewModel, boolean z2, boolean z3, Continuation continuation) {
        super(1, continuation);
        this.f119212d = recommendedAppsViewModel;
        this.f119213f = z2;
        this.f119214g = z3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new RecommendedAppsViewModel$finishWithApplications$1(this.f119212d, this.f119213f, this.f119214g, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x009a, code lost:
    
        if (r3.P0(r4, r8) == r0) goto L28;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r8.f119211c
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L2b
            if (r1 == r3) goto L23
            if (r1 != r2) goto L1b
            java.lang.Object r0 = r8.f119210b
            java.util.List r0 = (java.util.List) r0
            java.lang.Object r0 = r8.f119209a
            cz.mobilesoft.coreblock.scene.selection.recommended.RecommendedAppsViewState r0 = (cz.mobilesoft.coreblock.scene.selection.recommended.RecommendedAppsViewState) r0
            kotlin.ResultKt.b(r9)
            goto L9d
        L1b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L23:
            java.lang.Object r1 = r8.f119209a
            cz.mobilesoft.coreblock.scene.selection.recommended.RecommendedAppsViewState r1 = (cz.mobilesoft.coreblock.scene.selection.recommended.RecommendedAppsViewState) r1
            kotlin.ResultKt.b(r9)
            goto L70
        L2b:
            kotlin.ResultKt.b(r9)
            cz.mobilesoft.coreblock.scene.selection.recommended.RecommendedAppsViewModel r9 = r8.f119212d
            cz.mobilesoft.coreblock.scene.selection.recommended.RecommendedAppsViewState r1 = cz.mobilesoft.coreblock.scene.selection.recommended.RecommendedAppsViewModel.T0(r9)
            cz.mobilesoft.coreblock.scene.selection.recommended.RecommendedAppsViewModel r9 = r8.f119212d
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao r9 = cz.mobilesoft.coreblock.scene.selection.recommended.RecommendedAppsViewModel.V0(r9)
            kotlinx.collections.immutable.ImmutableList r4 = r1.c()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Iterator r4 = r4.iterator()
        L47:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L65
            java.lang.Object r6 = r4.next()
            cz.mobilesoft.coreblock.dto.ApplicationDTO r6 = (cz.mobilesoft.coreblock.dto.ApplicationDTO) r6
            boolean r7 = r6.h()
            if (r7 == 0) goto L5e
            java.lang.String r6 = r6.f()
            goto L5f
        L5e:
            r6 = 0
        L5f:
            if (r6 == 0) goto L47
            r5.add(r6)
            goto L47
        L65:
            r8.f119209a = r1
            r8.f119211c = r3
            java.lang.Object r9 = r9.a0(r5, r8)
            if (r9 != r0) goto L70
            goto L9c
        L70:
            java.util.List r9 = (java.util.List) r9
            cz.mobilesoft.coreblock.scene.selection.recommended.RecommendedAppsViewModel r3 = r8.f119212d
            cz.mobilesoft.coreblock.scene.selection.recommended.RecommendedAppsViewCommand$FinishRecommendedApps r4 = new cz.mobilesoft.coreblock.scene.selection.recommended.RecommendedAppsViewCommand$FinishRecommendedApps
            boolean r5 = r8.f119213f
            if (r5 == 0) goto L7f
            kotlinx.collections.immutable.ImmutableList r5 = r1.d()
            goto L83
        L7f:
            java.util.List r5 = kotlin.collections.CollectionsKt.emptyList()
        L83:
            boolean r6 = r8.f119214g
            r4.<init>(r9, r5, r6)
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.a(r1)
            r8.f119209a = r1
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.a(r9)
            r8.f119210b = r9
            r8.f119211c = r2
            java.lang.Object r9 = cz.mobilesoft.coreblock.scene.selection.recommended.RecommendedAppsViewModel.X0(r3, r4, r8)
            if (r9 != r0) goto L9d
        L9c:
            return r0
        L9d:
            kotlin.Unit r9 = kotlin.Unit.f139807a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.selection.recommended.RecommendedAppsViewModel$finishWithApplications$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((RecommendedAppsViewModel$finishWithApplications$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
