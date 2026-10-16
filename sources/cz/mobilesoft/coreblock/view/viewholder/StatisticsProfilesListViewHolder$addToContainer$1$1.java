package cz.mobilesoft.coreblock.view.viewholder;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.view.viewholder.StatisticsProfilesListViewHolder$addToContainer$1$1", f = "StatisticsProfilesListViewHolder.kt", l = {42, 41}, m = "invokeSuspend", v = 1)
final class StatisticsProfilesListViewHolder$addToContainer$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f133485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f133486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ StatisticsProfilesListViewHolder f133487c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StatisticsProfilesListViewHolder$addToContainer$1$1(StatisticsProfilesListViewHolder statisticsProfilesListViewHolder, Continuation continuation) {
        super(1, continuation);
        this.f133487c = statisticsProfilesListViewHolder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new StatisticsProfilesListViewHolder$addToContainer$1$1(this.f133487c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x004d, code lost:
    
        if (r1.emit(r7, r6) == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r6.f133486b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r7)
            goto L50
        L12:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1a:
            java.lang.Object r1 = r6.f133485a
            kotlinx.coroutines.flow.MutableStateFlow r1 = (kotlinx.coroutines.flow.MutableStateFlow) r1
            kotlin.ResultKt.b(r7)
            goto L44
        L22:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.view.viewholder.StatisticsProfilesListViewHolder r7 = r6.f133487c
            kotlinx.coroutines.flow.MutableStateFlow r1 = cz.mobilesoft.coreblock.view.viewholder.StatisticsProfilesListViewHolder.i(r7)
            cz.mobilesoft.coreblock.view.viewholder.StatisticsProfilesListViewHolder r7 = r6.f133487c
            android.content.Context r7 = r7.l()
            cz.mobilesoft.coreblock.view.viewholder.StatisticsProfilesListViewHolder r4 = r6.f133487c
            java.util.List r4 = r4.m()
            cz.mobilesoft.coreblock.util.profile.ProfileItemType$DetailList$Statistics r5 = cz.mobilesoft.coreblock.util.profile.ProfileItemType.DetailList.Statistics.f129302a
            r6.f133485a = r1
            r6.f133486b = r3
            java.lang.Object r7 = cz.mobilesoft.coreblock.util.profile.ProfileToViewDTOHelperKt.E(r7, r4, r5, r6)
            if (r7 != r0) goto L44
            goto L4f
        L44:
            r3 = 0
            r6.f133485a = r3
            r6.f133486b = r2
            java.lang.Object r7 = r1.emit(r7, r6)
            if (r7 != r0) goto L50
        L4f:
            return r0
        L50:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.viewholder.StatisticsProfilesListViewHolder$addToContainer$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((StatisticsProfilesListViewHolder$addToContainer$1$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
