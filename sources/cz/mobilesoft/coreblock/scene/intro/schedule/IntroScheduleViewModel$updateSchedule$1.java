package cz.mobilesoft.coreblock.scene.intro.schedule;

import android.content.Context;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO;
import cz.mobilesoft.coreblock.util.profile.ProfileItemType;
import cz.mobilesoft.coreblock.util.profile.ProfileToViewDTOHelperKt;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.intro.schedule.IntroScheduleViewModel$updateSchedule$1", f = "IntroScheduleViewModel.kt", l = {36}, m = "invokeSuspend", v = 1)
final class IntroScheduleViewModel$updateSchedule$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f104829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ IntroScheduleViewModel f104830b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    IntroScheduleViewModel$updateSchedule$1(IntroScheduleViewModel introScheduleViewModel, Continuation continuation) {
        super(2, continuation);
        this.f104830b = introScheduleViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntroScheduleViewState q(List list, IntroScheduleViewModel introScheduleViewModel, IntroScheduleViewState introScheduleViewState) {
        return introScheduleViewState.a((ProfileViewDTO) CollectionsKt.firstOrNull(list), Integer.valueOf(introScheduleViewModel.f104827p));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new IntroScheduleViewModel$updateSchedule$1(this.f104830b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f104829a;
        if (i3 == 0) {
            ResultKt.b(obj);
            Context contextA0 = this.f104830b.A0();
            Set of = SetsKt.setOf(Boxing.e(this.f104830b.f104826o));
            ProfileItemType.DetailList.Intro intro = ProfileItemType.DetailList.Intro.f129301a;
            this.f104829a = 1;
            obj = ProfileToViewDTOHelperKt.F(contextA0, of, intro, this);
            if (obj == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        final List list = (List) obj;
        final IntroScheduleViewModel introScheduleViewModel = this.f104830b;
        introScheduleViewModel.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.intro.schedule.b0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return IntroScheduleViewModel$updateSchedule$1.q(list, introScheduleViewModel, (IntroScheduleViewState) obj2);
            }
        });
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((IntroScheduleViewModel$updateSchedule$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
