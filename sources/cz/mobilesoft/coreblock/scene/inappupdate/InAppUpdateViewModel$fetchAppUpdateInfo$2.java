package cz.mobilesoft.coreblock.scene.inappupdate;

import com.google.android.play.core.appupdate.AppUpdateInfo;
import cz.mobilesoft.coreblock.util.FailedWithError;
import cz.mobilesoft.coreblock.util.NetworkHelperKt;
import cz.mobilesoft.coreblock.util.Success;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.inappupdate.InAppUpdateViewModel$fetchAppUpdateInfo$2", f = "InAppUpdateViewModel.kt", l = {30, 40}, m = "invokeSuspend", v = 1)
final class InAppUpdateViewModel$fetchAppUpdateInfo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f102452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f102453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f102454c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f102455d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f102456f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ InAppUpdateViewModel f102457g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InAppUpdateViewModel$fetchAppUpdateInfo$2(InAppUpdateViewModel inAppUpdateViewModel, Continuation continuation) {
        super(2, continuation);
        this.f102457g = inAppUpdateViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InAppUpdateViewState y(InAppUpdateViewState inAppUpdateViewState) {
        return inAppUpdateViewState.a(Success.f128020a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InAppUpdateViewState z(InAppUpdateViewState inAppUpdateViewState) {
        return inAppUpdateViewState.a(new FailedWithError(null, null, null, null, 15, null));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new InAppUpdateViewModel$fetchAppUpdateInfo$2(this.f102457g, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        int i3;
        AnswersHelper answersHelper;
        String str;
        Object objF = IntrinsicsKt.f();
        int i4 = this.f102456f;
        if (i4 == 0) {
            ResultKt.b(obj);
            i3 = this.f102457g.W0() == null ? 1 : 0;
            InAppUpdatesRepository inAppUpdatesRepository = InAppUpdatesRepository.f129855a;
            this.f102452a = i3;
            this.f102456f = 1;
            obj = inAppUpdatesRepository.k(this);
            if (obj != objF) {
            }
            return objF;
        }
        if (i4 != 1) {
            if (i4 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) this.f102455d;
            answersHelper = (AnswersHelper) this.f102454c;
            ResultKt.b(obj);
            answersHelper.e2(str, (Integer) obj);
            this.f102457g.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.inappupdate.i
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return InAppUpdateViewModel$fetchAppUpdateInfo$2.z((InAppUpdateViewState) obj2);
                }
            });
            return Unit.f139807a;
        }
        i3 = this.f102452a;
        ResultKt.b(obj);
        AppUpdateInfo appUpdateInfo = (AppUpdateInfo) obj;
        this.f102457g.c1(appUpdateInfo);
        if (appUpdateInfo != null) {
            if (i3 != 0) {
                AnswersHelper.f128199a.f2(this.f102457g.Y0(), appUpdateInfo.a());
            }
            this.f102457g.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.inappupdate.h
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return InAppUpdateViewModel$fetchAppUpdateInfo$2.y((InAppUpdateViewState) obj2);
                }
            });
            return Unit.f139807a;
        }
        if (NetworkHelperKt.c(this.f102457g.A0())) {
            AnswersHelper answersHelper2 = AnswersHelper.f128199a;
            String strY0 = this.f102457g.Y0();
            InAppUpdatesRepository inAppUpdatesRepositoryX0 = this.f102457g.X0();
            this.f102453b = SpillingKt.a(appUpdateInfo);
            this.f102454c = answersHelper2;
            this.f102455d = strY0;
            this.f102452a = i3;
            this.f102456f = 2;
            obj = inAppUpdatesRepositoryX0.v(this);
            if (obj != objF) {
                answersHelper = answersHelper2;
                str = strY0;
                answersHelper.e2(str, (Integer) obj);
            }
            return objF;
        }
        this.f102457g.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.inappupdate.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return InAppUpdateViewModel$fetchAppUpdateInfo$2.z((InAppUpdateViewState) obj2);
            }
        });
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((InAppUpdateViewModel$fetchAppUpdateInfo$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
