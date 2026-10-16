package cz.mobilesoft.coreblock.scene.statistics.overview;

import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.Permission;
import cz.mobilesoft.coreblock.enums.PermissionAccessibilityReason;
import cz.mobilesoft.coreblock.enums.StrictModeTitleAlternatives;
import cz.mobilesoft.coreblock.scene.permission.PermissionActivity;
import cz.mobilesoft.coreblock.util.helperextension.ContextExtKt;
import cz.mobilesoft.coreblock.util.permissions.PermissionDTO;
import cz.mobilesoft.coreblock.util.view.ViewHelperExtKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.statistics.overview.StatisticsOverviewFragment$initRadioGroup$1$1", f = "StatisticsOverviewFragment.kt", l = {216, 216, 217}, m = "invokeSuspend", v = 1)
final class StatisticsOverviewFragment$initRadioGroup$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f120035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f120036b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ StatisticsOverviewFragment f120037c;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.statistics.overview.StatisticsOverviewFragment$initRadioGroup$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.statistics.overview.StatisticsOverviewFragment$initRadioGroup$1$1$1", f = "StatisticsOverviewFragment.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f120038a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f120039b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ StatisticsOverviewFragment f120040c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(boolean z2, StatisticsOverviewFragment statisticsOverviewFragment, Continuation continuation) {
            super(2, continuation);
            this.f120039b = z2;
            this.f120040c = statisticsOverviewFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f120039b, this.f120040c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f120038a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            if (this.f120039b) {
                ViewHelperExtKt.u(this.f120040c, StrictModeTitleAlternatives.Companion.a());
                StatisticsOverviewFragment.V0(this.f120040c).f96698m.check(R.id.f95633l);
            } else {
                ContextExtKt.g(this.f120040c.f120032r, PermissionActivity.Companion.b(PermissionActivity.f111772j, this.f120040c.requireActivity(), CollectionsKt.listOf(new PermissionDTO(new Permission.ACCESSIBILITY(PermissionAccessibilityReason.Statistics.f97009a, false, 2, null), false, false, 6, null)), false, false, false, null, null, 124, null));
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StatisticsOverviewFragment$initRadioGroup$1$1(StatisticsOverviewFragment statisticsOverviewFragment, Continuation continuation) {
        super(1, continuation);
        this.f120037c = statisticsOverviewFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new StatisticsOverviewFragment$initRadioGroup$1$1(this.f120037c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x004f, code lost:
    
        if (r7 == r0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007a, code lost:
    
        if (kotlinx.coroutines.BuildersKt.g(r7, r1, r6) != r0) goto L27;
     */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v2 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r6.f120036b
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L25
            if (r1 == r4) goto L21
            if (r1 == r3) goto L1d
            if (r1 != r2) goto L15
            kotlin.ResultKt.b(r7)
            goto L7d
        L15:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1d:
            kotlin.ResultKt.b(r7)
            goto L52
        L21:
            kotlin.ResultKt.b(r7)
            goto L37
        L25:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.scene.statistics.overview.StatisticsOverviewFragment r7 = r6.f120037c
            cz.mobilesoft.coreblock.scene.statistics.overview.StatisticsOverviewFragmentViewModel r7 = r7.h0()
            r6.f120036b = r4
            java.lang.Object r7 = r7.w1(r6)
            if (r7 != r0) goto L37
            goto L7c
        L37:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L5d
            cz.mobilesoft.coreblock.scene.statistics.overview.StatisticsOverviewFragment r7 = r6.f120037c
            cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore r7 = cz.mobilesoft.coreblock.scene.statistics.overview.StatisticsOverviewFragment.X0(r7)
            kotlinx.coroutines.flow.Flow r7 = r7.m0()
            r6.f120036b = r3
            java.lang.Object r7 = kotlinx.coroutines.flow.FlowKt.D(r7, r6)
            if (r7 != r0) goto L52
            goto L7c
        L52:
            java.util.List r7 = (java.util.List) r7
            cz.mobilesoft.coreblock.enums.StrictModeOption r1 = cz.mobilesoft.coreblock.enums.StrictModeOption.BlockSettings
            boolean r7 = r7.contains(r1)
            if (r7 == 0) goto L5d
            goto L5e
        L5d:
            r4 = 0
        L5e:
            kotlinx.coroutines.MainCoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.c()
            kotlinx.coroutines.CoroutineExceptionHandler r1 = cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt.b()
            kotlin.coroutines.CoroutineContext r7 = r7.plus(r1)
            cz.mobilesoft.coreblock.scene.statistics.overview.StatisticsOverviewFragment$initRadioGroup$1$1$1 r1 = new cz.mobilesoft.coreblock.scene.statistics.overview.StatisticsOverviewFragment$initRadioGroup$1$1$1
            cz.mobilesoft.coreblock.scene.statistics.overview.StatisticsOverviewFragment r3 = r6.f120037c
            r5 = 0
            r1.<init>(r4, r3, r5)
            r6.f120035a = r4
            r6.f120036b = r2
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.g(r7, r1, r6)
            if (r7 != r0) goto L7d
        L7c:
            return r0
        L7d:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.statistics.overview.StatisticsOverviewFragment$initRadioGroup$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((StatisticsOverviewFragment$initRadioGroup$1$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
