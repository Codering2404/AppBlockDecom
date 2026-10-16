package cz.mobilesoft.coreblock.scene.app_feel;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewModel$setIgnoreStatisticsItem$1", f = "AppFeelViewModel.kt", l = {118, 120, 130}, m = "invokeSuspend", v = 1)
final class AppFeelViewModel$setIgnoreStatisticsItem$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f98593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f98594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f98595c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f98596d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ AppFeelViewModel f98597f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ String f98598g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ boolean f98599h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AppFeelViewModel$setIgnoreStatisticsItem$1(AppFeelViewModel appFeelViewModel, String str, boolean z2, Continuation continuation) {
        super(1, continuation);
        this.f98597f = appFeelViewModel;
        this.f98598g = str;
        this.f98599h = z2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new AppFeelViewModel$setIgnoreStatisticsItem$1(this.f98597f, this.f98598g, this.f98599h, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0060, code lost:
    
        if (r2.p(r14, r13) == r0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x008f, code lost:
    
        if (r4.n(r3, r13) == r0) goto L23;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
        /*
            r13 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r13.f98596d
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L2e
            if (r1 == r4) goto L2a
            if (r1 == r3) goto L22
            if (r1 != r2) goto L1a
            java.lang.Object r0 = r13.f98594b
            cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem r0 = (cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem) r0
            java.lang.Object r0 = r13.f98593a
            cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewModel r0 = (cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewModel) r0
            goto L26
        L1a:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L22:
            java.lang.Object r0 = r13.f98593a
            cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem r0 = (cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem) r0
        L26:
            kotlin.ResultKt.b(r14)
            goto L92
        L2a:
            kotlin.ResultKt.b(r14)
            goto L42
        L2e:
            kotlin.ResultKt.b(r14)
            cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewModel r14 = r13.f98597f
            cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao r14 = cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewModel.U0(r14)
            java.lang.String r1 = r13.f98598g
            r13.f98596d = r4
            java.lang.Object r14 = r14.T(r1, r13)
            if (r14 != r0) goto L42
            goto L91
        L42:
            cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem r14 = (cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem) r14
            r1 = 0
            if (r14 == 0) goto L63
            boolean r2 = r13.f98599h
            cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewModel r4 = r13.f98597f
            r14.g(r2)
            cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao r2 = cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewModel.U0(r4)
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r14)
            r13.f98593a = r4
            r13.f98595c = r1
            r13.f98596d = r3
            java.lang.Object r14 = r2.p(r14, r13)
            if (r14 != r0) goto L92
            goto L91
        L63:
            cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewModel r14 = r13.f98597f
            java.lang.String r6 = r13.f98598g
            boolean r9 = r13.f98599h
            cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem r3 = new cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem
            cz.mobilesoft.coreblock.dto.UsageAccess$Type r7 = cz.mobilesoft.coreblock.dto.UsageAccess.Type.APPLICATION
            cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem$ItemSourceType r8 = cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem.ItemSourceType.CUSTOM
            r11 = 1
            r12 = 0
            r4 = 0
            r10 = 1
            r3.<init>(r4, r6, r7, r8, r9, r10, r11, r12)
            cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao r4 = cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewModel.U0(r14)
            java.lang.Object r14 = kotlin.coroutines.jvm.internal.SpillingKt.a(r14)
            r13.f98593a = r14
            java.lang.Object r14 = kotlin.coroutines.jvm.internal.SpillingKt.a(r3)
            r13.f98594b = r14
            r13.f98595c = r1
            r13.f98596d = r2
            java.lang.Object r14 = r4.n(r3, r13)
            if (r14 != r0) goto L92
        L91:
            return r0
        L92:
            kotlin.Unit r14 = kotlin.Unit.f139807a
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewModel$setIgnoreStatisticsItem$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((AppFeelViewModel$setIgnoreStatisticsItem$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
