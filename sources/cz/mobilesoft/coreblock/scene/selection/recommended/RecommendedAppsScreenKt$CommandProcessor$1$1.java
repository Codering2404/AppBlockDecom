package cz.mobilesoft.coreblock.scene.selection.recommended;

import android.content.Context;
import androidx.compose.material.ModalBottomSheetState;
import cz.mobilesoft.coreblock.scene.premium.host.Paywall;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import cz.mobilesoft.coreblock.scene.selection.recommended.RecommendedAppsViewCommand;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.selection.recommended.RecommendedAppsScreenKt$CommandProcessor$1$1", f = "RecommendedAppsScreen.kt", l = {}, m = "invokeSuspend", v = 1)
final class RecommendedAppsScreenKt$CommandProcessor$1$1 extends SuspendLambda implements Function2<RecommendedAppsViewCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f119176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f119177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Context f119178c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function3 f119179d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ CoroutineScope f119180f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ ModalBottomSheetState f119181g;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.selection.recommended.RecommendedAppsScreenKt$CommandProcessor$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.selection.recommended.RecommendedAppsScreenKt$CommandProcessor$1$1$1", f = "RecommendedAppsScreen.kt", l = {272}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f119182a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ModalBottomSheetState f119183b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ModalBottomSheetState modalBottomSheetState, Continuation continuation) {
            super(2, continuation);
            this.f119183b = modalBottomSheetState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f119183b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f119182a;
            if (i3 == 0) {
                ResultKt.b(obj);
                ModalBottomSheetState modalBottomSheetState = this.f119183b;
                this.f119182a = 1;
                if (modalBottomSheetState.l(this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RecommendedAppsScreenKt$CommandProcessor$1$1(Context context, Function3 function3, CoroutineScope coroutineScope, ModalBottomSheetState modalBottomSheetState, Continuation continuation) {
        super(2, continuation);
        this.f119178c = context;
        this.f119179d = function3;
        this.f119180f = coroutineScope;
        this.f119181g = modalBottomSheetState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        RecommendedAppsScreenKt$CommandProcessor$1$1 recommendedAppsScreenKt$CommandProcessor$1$1 = new RecommendedAppsScreenKt$CommandProcessor$1$1(this.f119178c, this.f119179d, this.f119180f, this.f119181g, continuation);
        recommendedAppsScreenKt$CommandProcessor$1$1.f119177b = obj;
        return recommendedAppsScreenKt$CommandProcessor$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(RecommendedAppsViewCommand recommendedAppsViewCommand, Continuation continuation) {
        return ((RecommendedAppsScreenKt$CommandProcessor$1$1) create(recommendedAppsViewCommand, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        RecommendedAppsViewCommand recommendedAppsViewCommand = (RecommendedAppsViewCommand) this.f119177b;
        IntrinsicsKt.f();
        if (this.f119176a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (recommendedAppsViewCommand instanceof RecommendedAppsViewCommand.ShowPremiumFeatureDialog) {
            this.f119178c.startActivity(Paywall.c(Paywall.f113165a, this.f119178c, new PaywallTarget.LimitScreen(((RecommendedAppsViewCommand.ShowPremiumFeatureDialog) recommendedAppsViewCommand).a()), "recommended_apps_screen", "unlimited_apps", false, false, false, null, 240, null));
        } else if (recommendedAppsViewCommand instanceof RecommendedAppsViewCommand.FinishRecommendedApps) {
            RecommendedAppsViewCommand.FinishRecommendedApps finishRecommendedApps = (RecommendedAppsViewCommand.FinishRecommendedApps) recommendedAppsViewCommand;
            this.f119179d.invoke(finishRecommendedApps.a(), finishRecommendedApps.c(), Boxing.a(finishRecommendedApps.b()));
        } else {
            if (!Intrinsics.areEqual(recommendedAppsViewCommand, RecommendedAppsViewCommand.ShowWebsitesBottomSheet.f119191a)) {
                throw new NoWhenBranchMatchedException();
            }
            BuildersKt__Builders_commonKt.d(this.f119180f, null, null, new AnonymousClass1(this.f119181g, null), 3, null);
        }
        return Unit.f139807a;
    }
}
