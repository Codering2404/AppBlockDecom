package cz.mobilesoft.coreblock.usecase;

import cz.mobilesoft.coreblock.util.permissions.PermissionDTO;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.usecase.StatisticsPermissionsUseCase$invoke$1", f = "StatisticsPermissionsUseCase.kt", l = {19, 21}, m = "invokeSuspend", v = 1)
final class StatisticsPermissionsUseCase$invoke$1 extends SuspendLambda implements Function2<FlowCollector<? super List<? extends PermissionDTO>>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f127325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f127326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f127327c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private /* synthetic */ Object f127328d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ StatisticsPermissionsUseCase f127329f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StatisticsPermissionsUseCase$invoke$1(StatisticsPermissionsUseCase statisticsPermissionsUseCase, Continuation continuation) {
        super(2, continuation);
        this.f127329f = statisticsPermissionsUseCase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        StatisticsPermissionsUseCase$invoke$1 statisticsPermissionsUseCase$invoke$1 = new StatisticsPermissionsUseCase$invoke$1(this.f127329f, continuation);
        statisticsPermissionsUseCase$invoke$1.f127328d = obj;
        return statisticsPermissionsUseCase$invoke$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0060, code lost:
    
        if (r0.emit(r12, r11) == r1) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0075, code lost:
    
        if (r0.emit(r12, r11) == r1) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0077, code lost:
    
        return r1;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            r11 = this;
            java.lang.Object r0 = r11.f127328d
            kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r11.f127327c
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L23
            if (r2 == r4) goto L1b
            if (r2 != r3) goto L13
            goto L1f
        L13:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L1b:
            java.lang.Object r0 = r11.f127325a
            java.util.List r0 = (java.util.List) r0
        L1f:
            kotlin.ResultKt.b(r12)
            goto L78
        L23:
            kotlin.ResultKt.b(r12)
            cz.mobilesoft.coreblock.usecase.StatisticsPermissionsUseCase r12 = r11.f127329f
            android.content.Context r12 = r12.a()
            boolean r12 = cz.mobilesoft.coreblock.util.permissions.PermissionHelper.k(r12)
            r2 = r12 ^ 1
            if (r12 != 0) goto L63
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            cz.mobilesoft.coreblock.util.permissions.PermissionDTO r5 = new cz.mobilesoft.coreblock.util.permissions.PermissionDTO
            cz.mobilesoft.coreblock.enums.Permission$USAGE_ACCESS r6 = new cz.mobilesoft.coreblock.enums.Permission$USAGE_ACCESS
            cz.mobilesoft.coreblock.enums.PermissionUsageAccessReason r3 = cz.mobilesoft.coreblock.enums.PermissionUsageAccessReason.Statistics
            r6.<init>(r3)
            r9 = 6
            r10 = 0
            r7 = 0
            r8 = 0
            r5.<init>(r6, r7, r8, r9, r10)
            r12.add(r5)
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.a(r0)
            r11.f127328d = r3
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.a(r12)
            r11.f127325a = r3
            r11.f127326b = r2
            r11.f127327c = r4
            java.lang.Object r12 = r0.emit(r12, r11)
            if (r12 != r1) goto L78
            goto L77
        L63:
            java.util.List r12 = kotlin.collections.CollectionsKt.emptyList()
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r0)
            r11.f127328d = r4
            r11.f127326b = r2
            r11.f127327c = r3
            java.lang.Object r12 = r0.emit(r12, r11)
            if (r12 != r1) goto L78
        L77:
            return r1
        L78:
            kotlin.Unit r12 = kotlin.Unit.f139807a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.usecase.StatisticsPermissionsUseCase$invoke$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector flowCollector, Continuation continuation) {
        return ((StatisticsPermissionsUseCase$invoke$1) create(flowCollector, continuation)).invokeSuspend(Unit.f139807a);
    }
}
