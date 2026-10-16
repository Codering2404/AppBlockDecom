package cz.mobilesoft.coreblock.scene.streaks.milestone;

import android.content.Context;
import androidx.compose.runtime.MutableIntState;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.streaks.milestone.StreakMilestoneWeekRowKt$StreakMilestoneWeekRow$1$1", f = "StreakMilestoneWeekRow.kt", l = {71, 81}, m = "invokeSuspend", v = 1)
final class StreakMilestoneWeekRowKt$StreakMilestoneWeekRow$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f120966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f120967b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f120968c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f120969d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f120970f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f120971g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f120972h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f120973i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f120974j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ List f120975k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final /* synthetic */ Context f120976l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final /* synthetic */ MutableIntState f120977m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreakMilestoneWeekRowKt$StreakMilestoneWeekRow$1$1(List list, Context context, MutableIntState mutableIntState, Continuation continuation) {
        super(2, continuation);
        this.f120975k = list;
        this.f120976l = context;
        this.f120977m = mutableIntState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new StreakMilestoneWeekRowKt$StreakMilestoneWeekRow$1$1(this.f120975k, this.f120976l, this.f120977m, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0042, code lost:
    
        if (kotlinx.coroutines.DelayKt.c(r5, r13) == r0) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005d  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
        /*
            r13 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r13.f120974j
            r2 = 0
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L35
            if (r1 == r4) goto L31
            if (r1 != r3) goto L29
            int r1 = r13.f120972h
            java.lang.Object r5 = r13.f120971g
            cz.mobilesoft.coreblock.scene.streaks.StreakWeekDayStatus r5 = (cz.mobilesoft.coreblock.scene.streaks.StreakWeekDayStatus) r5
            java.lang.Object r5 = r13.f120969d
            java.util.Iterator r5 = (java.util.Iterator) r5
            java.lang.Object r6 = r13.f120968c
            androidx.compose.runtime.MutableIntState r6 = (androidx.compose.runtime.MutableIntState) r6
            java.lang.Object r7 = r13.f120967b
            android.content.Context r7 = (android.content.Context) r7
            java.lang.Object r8 = r13.f120966a
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            kotlin.ResultKt.b(r14)
            goto L57
        L29:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L31:
            kotlin.ResultKt.b(r14)
            goto L45
        L35:
            kotlin.ResultKt.b(r14)
            long r5 = cz.mobilesoft.coreblock.scene.streaks.milestone.StreakMilestoneWeekRowKt.u()
            r13.f120974j = r4
            java.lang.Object r14 = kotlinx.coroutines.DelayKt.c(r5, r13)
            if (r14 != r0) goto L45
            goto L9b
        L45:
            java.util.List r14 = r13.f120975k
            java.lang.Iterable r14 = (java.lang.Iterable) r14
            android.content.Context r1 = r13.f120976l
            androidx.compose.runtime.MutableIntState r5 = r13.f120977m
            java.util.Iterator r6 = r14.iterator()
            r7 = r6
            r6 = r5
            r5 = r7
            r8 = r14
            r7 = r1
            r1 = r2
        L57:
            boolean r14 = r5.hasNext()
            if (r14 == 0) goto L9c
            java.lang.Object r14 = r5.next()
            r9 = r14
            cz.mobilesoft.coreblock.scene.streaks.StreakWeekDayStatus r9 = (cz.mobilesoft.coreblock.scene.streaks.StreakWeekDayStatus) r9
            int r10 = cz.mobilesoft.coreblock.scene.streaks.milestone.StreakMilestoneWeekRowKt.s(r6)
            int r10 = r10 + r4
            cz.mobilesoft.coreblock.scene.streaks.milestone.StreakMilestoneWeekRowKt.t(r6, r10)
            cz.mobilesoft.coreblock.scene.streaks.StreakWeekDayStatus r10 = cz.mobilesoft.coreblock.scene.streaks.StreakWeekDayStatus.Obtained
            if (r9 != r10) goto L73
            cz.mobilesoft.coreblock.util.helperextension.ContextExtKt.j(r7)
        L73:
            long r10 = cz.mobilesoft.coreblock.scene.streaks.milestone.StreakMilestoneWeekRowKt.v()
            java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.a(r8)
            r13.f120966a = r12
            r13.f120967b = r7
            r13.f120968c = r6
            r13.f120969d = r5
            java.lang.Object r14 = kotlin.coroutines.jvm.internal.SpillingKt.a(r14)
            r13.f120970f = r14
            java.lang.Object r14 = kotlin.coroutines.jvm.internal.SpillingKt.a(r9)
            r13.f120971g = r14
            r13.f120972h = r1
            r13.f120973i = r2
            r13.f120974j = r3
            java.lang.Object r14 = kotlinx.coroutines.DelayKt.c(r10, r13)
            if (r14 != r0) goto L57
        L9b:
            return r0
        L9c:
            kotlin.Unit r14 = kotlin.Unit.f139807a
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.milestone.StreakMilestoneWeekRowKt$StreakMilestoneWeekRow$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((StreakMilestoneWeekRowKt$StreakMilestoneWeekRow$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
