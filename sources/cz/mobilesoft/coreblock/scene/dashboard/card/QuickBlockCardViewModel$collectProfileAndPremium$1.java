package cz.mobilesoft.coreblock.scene.dashboard.card;

import cz.mobilesoft.coreblock.dto.WebsiteDTO;
import cz.mobilesoft.coreblock.enums.Limit;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.repository.QuickBlockRepository;
import cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardViewModel;
import cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardViewModel$collectProfileAndPremium$1;
import cz.mobilesoft.coreblock.scene.quickblock.QuickBlockProfileDTO;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.SubAppRelation;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.WebsiteProfileRelation;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import cz.mobilesoft.coreblock.util.monetization.AccessPolicyKt;
import cz.mobilesoft.coreblock.util.monetization.Capability;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardViewModel$collectProfileAndPremium$1", f = "QuickBlockCardViewModel.kt", l = {95}, m = "invokeSuspend", v = 1)
final class QuickBlockCardViewModel$collectProfileAndPremium$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f100478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ QuickBlockCardViewModel f100479b;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardViewModel$collectProfileAndPremium$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardViewModel$collectProfileAndPremium$1$1", f = "QuickBlockCardViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function4<QuickBlockProfileDTO, PremiumState, Integer, Continuation<? super QuickBlockCardViewModel.StateDTO>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f100480a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f100481b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f100482c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ int f100483d;

        AnonymousClass1(Continuation continuation) {
            super(4, continuation);
        }

        public final Object h(QuickBlockProfileDTO quickBlockProfileDTO, PremiumState premiumState, int i3, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.f100481b = quickBlockProfileDTO;
            anonymousClass1.f100482c = premiumState;
            anonymousClass1.f100483d = i3;
            return anonymousClass1.invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            return h((QuickBlockProfileDTO) obj, (PremiumState) obj2, ((Number) obj3).intValue(), (Continuation) obj4);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            QuickBlockProfileDTO quickBlockProfileDTO = (QuickBlockProfileDTO) this.f100481b;
            PremiumState premiumState = (PremiumState) this.f100482c;
            int i3 = this.f100483d;
            IntrinsicsKt.f();
            if (this.f100480a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return new QuickBlockCardViewModel.StateDTO(quickBlockProfileDTO, premiumState, i3);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardViewModel$collectProfileAndPremium$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class AnonymousClass2<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ QuickBlockCardViewModel f100484a;

        AnonymousClass2(QuickBlockCardViewModel quickBlockCardViewModel) {
            this.f100484a = quickBlockCardViewModel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final QuickBlockViewState g(QuickBlockViewState updateState) {
            Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
            return QuickBlockViewState.b(updateState, null, null, null, null, null, null, false, null, 0L, 0L, false, false, null, false, null, false, false, false, false, false, 524287, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final QuickBlockViewState h(QuickBlockProfileDTO quickBlockProfileDTO, PremiumState premiumState, List list, List list2, List list3, long j3, List list4, QuickBlockViewState updateState) {
            Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
            QuickBlockRepository.QuickBlockState quickBlockStateI = quickBlockProfileDTO.i();
            List listJ = quickBlockProfileDTO.j();
            long jS = quickBlockProfileDTO.h().s();
            boolean zI = quickBlockProfileDTO.h().i();
            boolean zN = quickBlockProfileDTO.h().n();
            return QuickBlockViewState.b(updateState, quickBlockStateI, quickBlockProfileDTO.h().o(), list, list2, listJ, list3, zI, null, j3, jS, AccessPolicyKt.a(premiumState, Capability.PremiumAccess), false, list4, zN, null, quickBlockProfileDTO.h().l(), quickBlockProfileDTO.h().m(), quickBlockProfileDTO.h().j(), quickBlockProfileDTO.h().k(), true, 18560, null);
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object emit(QuickBlockCardViewModel.StateDTO stateDTO, Continuation continuation) {
            final QuickBlockProfileDTO quickBlockProfileDTOA = stateDTO.a();
            final PremiumState premiumStateB = stateDTO.b();
            if (quickBlockProfileDTOA == null) {
                this.f100484a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.r1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return QuickBlockCardViewModel$collectProfileAndPremium$1.AnonymousClass2.g((QuickBlockViewState) obj);
                    }
                });
                return Unit.f139807a;
            }
            final List listA = quickBlockProfileDTOA.a();
            List<WebsiteProfileRelation> listM = quickBlockProfileDTOA.m();
            final ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listM, 10));
            for (WebsiteProfileRelation websiteProfileRelation : listM) {
                arrayList.add(new WebsiteDTO(websiteProfileRelation.c(), websiteProfileRelation.a(), websiteProfileRelation.e(), false, 8, null));
            }
            List listL = quickBlockProfileDTOA.l();
            final ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listL, 10));
            Iterator<T> it = listL.iterator();
            while (it.hasNext()) {
                arrayList2.add(((SubAppRelation) it.next()).c());
            }
            final ArrayList arrayList3 = new ArrayList();
            QuickBlockCardViewModel quickBlockCardViewModel = this.f100484a;
            if (quickBlockCardViewModel.w1().E(listA.size())) {
                arrayList3.add(Limit.APP_WEB_LIMIT_QUICK_BLOCK);
            }
            if (quickBlockCardViewModel.w1().G(arrayList.size())) {
                arrayList3.add(Limit.APP_WEB_LIMIT_QUICK_BLOCK);
            }
            if (quickBlockProfileDTOA.h().o() == Profile.BlockingMode.Allowlist && !premiumStateB.g()) {
                arrayList3.add(Limit.ALLOWLIST);
            }
            if (quickBlockProfileDTOA.h().i() && !AccessPolicyKt.a(premiumStateB, Capability.PremiumAccess)) {
                arrayList3.add(Limit.ADD_NEW_APPS);
            }
            if (quickBlockProfileDTOA.h().n() && !AccessPolicyKt.a(premiumStateB, Capability.PremiumAccess)) {
                arrayList3.add(Limit.BLOCK_UNSUPPORTED_BROWSERS);
            }
            if (quickBlockProfileDTOA.h().j() && !premiumStateB.g()) {
                arrayList3.add(Limit.ADULT_CONTENT_BLOCKING);
            }
            if (!quickBlockCardViewModel.w1().y().isEmpty() && !premiumStateB.g()) {
                arrayList3.add(Limit.SUB_APPS_LIMIT);
            }
            final long jW = quickBlockProfileDTOA.h().w() - TimeHelperExt.c();
            if (jW > 0) {
                this.f100484a.J1(jW);
            } else {
                Job job = this.f100484a.f100450y;
                if (job != null) {
                    Job.DefaultImpls.b(job, null, 1, null);
                }
            }
            this.f100484a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.card.s1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return QuickBlockCardViewModel$collectProfileAndPremium$1.AnonymousClass2.h(quickBlockProfileDTOA, premiumStateB, listA, arrayList, arrayList2, jW, arrayList3, (QuickBlockViewState) obj);
                }
            });
            this.f100484a.K1();
            return Unit.f139807a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    QuickBlockCardViewModel$collectProfileAndPremium$1(QuickBlockCardViewModel quickBlockCardViewModel, Continuation continuation) {
        super(2, continuation);
        this.f100479b = quickBlockCardViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new QuickBlockCardViewModel$collectProfileAndPremium$1(this.f100479b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f100478a;
        if (i3 == 0) {
            ResultKt.b(obj);
            Flow flowN = FlowKt.n(this.f100479b.w1().s(), this.f100479b.v1().K(), this.f100479b.f100449x, new AnonymousClass1(null));
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.f100479b);
            this.f100478a = 1;
            if (flowN.collect(anonymousClass2, this) == objF) {
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
        return ((QuickBlockCardViewModel$collectProfileAndPremium$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
