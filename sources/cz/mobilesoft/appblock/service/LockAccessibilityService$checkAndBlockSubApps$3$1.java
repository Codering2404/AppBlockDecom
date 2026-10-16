package cz.mobilesoft.appblock.service;

import cz.mobilesoft.appblock.service.lock.BlockingDecision;
import cz.mobilesoft.coreblock.repository.SubApp;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.appblock.service.LockAccessibilityService$checkAndBlockSubApps$3$1", f = "LockAccessibilityService.kt", l = {1232}, m = "invokeSuspend", v = 1)
final class LockAccessibilityService$checkAndBlockSubApps$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f94263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f94264b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ LockAccessibilityService f94265c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ List f94266d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ SubApp f94267f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LockAccessibilityService$checkAndBlockSubApps$3$1(LockAccessibilityService lockAccessibilityService, List list, SubApp subApp, Continuation continuation) {
        super(2, continuation);
        this.f94265c = lockAccessibilityService;
        this.f94266d = list;
        this.f94267f = subApp;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new LockAccessibilityService$checkAndBlockSubApps$3$1(this.f94265c, this.f94266d, this.f94267f, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        BlockingDecision blockingDecision;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f94264b;
        if (i3 == 0) {
            ResultKt.b(obj);
            BlockingDecision blockingDecisionG0 = LockAccessibilityService.G0(this.f94265c, this.f94266d, null, this.f94267f, 2, null);
            if (!(blockingDecisionG0 instanceof BlockingDecision.Blocked)) {
                if (!Intrinsics.areEqual(blockingDecisionG0, BlockingDecision.NotBlocked.f94766a)) {
                    throw new NoWhenBranchMatchedException();
                }
                this.f94265c.I1(this.f94267f.getParentApp(), null, this.f94267f);
                return Unit.f139807a;
            }
            LockAccessibilityService lockAccessibilityService = this.f94265c;
            String parentApp = this.f94267f.getParentApp();
            this.f94263a = blockingDecisionG0;
            this.f94264b = 1;
            if (lockAccessibilityService.K0(parentApp, this) == objF) {
                return objF;
            }
            blockingDecision = blockingDecisionG0;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            blockingDecision = (BlockingDecision) this.f94263a;
            ResultKt.b(obj);
        }
        BlockingDecision.Blocked blocked = (BlockingDecision.Blocked) blockingDecision;
        LockAccessibilityService.H1(this.f94265c, this.f94267f.getParentApp(), null, blocked.a(), blocked.b(), this.f94265c.getApplicationContext().getString(this.f94267f.getTitle()), null, 32, null);
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((LockAccessibilityService$checkAndBlockSubApps$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
