package cz.mobilesoft.coreblock.scene.statistics;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.statistics.StatisticsProfileListBottomSheet$setupDialog$2$1", f = "StatisticsProfileListBottomSheet.kt", l = {75, 78}, m = "invokeSuspend", v = 1)
final class StatisticsProfileListBottomSheet$setupDialog$2$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f119731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f119732b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ StatisticsProfileListBottomSheet f119733c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f119734d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StatisticsProfileListBottomSheet$setupDialog$2$1(StatisticsProfileListBottomSheet statisticsProfileListBottomSheet, String str, Continuation continuation) {
        super(1, continuation);
        this.f119733c = statisticsProfileListBottomSheet;
        this.f119734d = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new StatisticsProfileListBottomSheet$setupDialog$2$1(this.f119733c, this.f119734d, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0075, code lost:
    
        if (r1.emit(r6, r5) == r0) goto L19;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r5.f119732b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1e
            if (r1 != r2) goto L16
            java.lang.Object r0 = r5.f119731a
            java.util.Set r0 = (java.util.Set) r0
            kotlin.ResultKt.b(r6)
            goto L78
        L16:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L1e:
            kotlin.ResultKt.b(r6)
            goto L36
        L22:
            kotlin.ResultKt.b(r6)
            cz.mobilesoft.coreblock.scene.statistics.StatisticsProfileListBottomSheet r6 = r5.f119733c
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationProfileRelationDao r6 = cz.mobilesoft.coreblock.scene.statistics.StatisticsProfileListBottomSheet.L0(r6)
            java.lang.String r1 = r5.f119734d
            r5.f119732b = r3
            java.lang.Object r6 = r6.c0(r1, r5)
            if (r6 != r0) goto L36
            goto L77
        L36:
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r1 = new java.util.ArrayList
            r3 = 10
            int r3 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r6, r3)
            r1.<init>(r3)
            java.util.Iterator r6 = r6.iterator()
        L47:
            boolean r3 = r6.hasNext()
            if (r3 == 0) goto L5f
            java.lang.Object r3 = r6.next()
            cz.mobilesoft.coreblock.storage.room.entity.blocking.ApplicationProfileRelation r3 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.ApplicationProfileRelation) r3
            long r3 = r3.e()
            java.lang.Long r3 = kotlin.coroutines.jvm.internal.Boxing.e(r3)
            r1.add(r3)
            goto L47
        L5f:
            java.util.Set r6 = kotlin.collections.CollectionsKt.toSet(r1)
            cz.mobilesoft.coreblock.scene.statistics.StatisticsProfileListBottomSheet r1 = r5.f119733c
            kotlinx.coroutines.flow.MutableStateFlow r1 = cz.mobilesoft.coreblock.scene.statistics.StatisticsProfileListBottomSheet.P0(r1)
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
            r5.f119731a = r3
            r5.f119732b = r2
            java.lang.Object r6 = r1.emit(r6, r5)
            if (r6 != r0) goto L78
        L77:
            return r0
        L78:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.statistics.StatisticsProfileListBottomSheet$setupDialog$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((StatisticsProfileListBottomSheet$setupDialog$2$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
