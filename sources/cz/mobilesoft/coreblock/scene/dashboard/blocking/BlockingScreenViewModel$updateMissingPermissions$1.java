package cz.mobilesoft.coreblock.scene.dashboard.blocking;

import android.content.Context;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$updateMissingPermissions$1;
import cz.mobilesoft.coreblock.util.permissions.PermissionsManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$updateMissingPermissions$1", f = "BlockingScreenViewModel.kt", l = {870}, m = "invokeSuspend", v = 1)
final class BlockingScreenViewModel$updateMissingPermissions$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f99879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ BlockingScreenViewModel f99880b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f99881c;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$updateMissingPermissions$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$updateMissingPermissions$1$1", f = "BlockingScreenViewModel.kt", l = {884}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f99882a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f99883b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f99884c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f99885d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ BlockingScreenViewModel f99886f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(boolean z2, List list, BlockingScreenViewModel blockingScreenViewModel, Continuation continuation) {
            super(2, continuation);
            this.f99884c = z2;
            this.f99885d = list;
            this.f99886f = blockingScreenViewModel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final BlockingScreenViewState y(List list, boolean z2, BlockingScreenViewState blockingScreenViewState) {
            return BlockingScreenViewState.b(blockingScreenViewState, new MissingPermissionsState(list, z2), null, null, false, null, null, false, null, false, false, null, null, false, 0L, false, false, false, false, false, null, null, null, null, false, false, false, false, 0, null, 536870910, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final BlockingScreenViewState z(BlockingScreenViewState blockingScreenViewState) {
            return BlockingScreenViewState.b(blockingScreenViewState, MissingPermissionsState.b(blockingScreenViewState.o(), null, false, 1, null), null, null, false, null, null, false, null, false, false, null, null, false, 0L, false, false, false, false, false, null, null, null, null, false, false, false, false, 0, null, 536870910, null);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f99884c, this.f99885d, this.f99886f, continuation);
        }

        /* JADX WARN: Type inference failed for: r6v13 */
        /* JADX WARN: Type inference failed for: r6v2 */
        /* JADX WARN: Type inference failed for: r6v3, types: [boolean, int] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f99883b;
            if (i3 == 0) {
                ResultKt.b(obj);
                final ?? r6 = (this.f99884c && this.f99885d.isEmpty() && !BlockingScreenViewModel.b1(this.f99886f).o().d().isEmpty()) ? 1 : 0;
                BlockingScreenViewModel blockingScreenViewModel = this.f99886f;
                final List list = this.f99885d;
                blockingScreenViewModel.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.i0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return BlockingScreenViewModel$updateMissingPermissions$1.AnonymousClass1.y(list, r6, (BlockingScreenViewState) obj2);
                    }
                });
                if (r6 != 0) {
                    long jS1 = this.f99886f.S1();
                    this.f99882a = r6;
                    this.f99883b = 1;
                    if (DelayKt.b(jS1, this) == objF) {
                        return objF;
                    }
                }
                return Unit.f139807a;
            }
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            this.f99886f.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.j0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return BlockingScreenViewModel$updateMissingPermissions$1.AnonymousClass1.z((BlockingScreenViewState) obj2);
                }
            });
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BlockingScreenViewModel$updateMissingPermissions$1(BlockingScreenViewModel blockingScreenViewModel, boolean z2, Continuation continuation) {
        super(2, continuation);
        this.f99880b = blockingScreenViewModel;
        this.f99881c = z2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BlockingScreenViewModel$updateMissingPermissions$1(this.f99880b, this.f99881c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        BlockingScreenViewModel$updateMissingPermissions$1 blockingScreenViewModel$updateMissingPermissions$1;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f99879a;
        if (i3 == 0) {
            ResultKt.b(obj);
            PermissionsManager permissionsManager = PermissionsManager.f129021a;
            Context contextA0 = this.f99880b.A0();
            this.f99879a = 1;
            blockingScreenViewModel$updateMissingPermissions$1 = this;
            obj = permissionsManager.l(true, contextA0, true, true, blockingScreenViewModel$updateMissingPermissions$1);
            if (obj == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            blockingScreenViewModel$updateMissingPermissions$1 = this;
        }
        BuildersKt__Builders_commonKt.d(blockingScreenViewModel$updateMissingPermissions$1.f99880b.B0(), null, null, new AnonymousClass1(blockingScreenViewModel$updateMissingPermissions$1.f99881c, (List) obj, blockingScreenViewModel$updateMissingPermissions$1.f99880b, null), 3, null);
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((BlockingScreenViewModel$updateMissingPermissions$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
