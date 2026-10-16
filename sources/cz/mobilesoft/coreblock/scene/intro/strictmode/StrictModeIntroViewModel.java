package cz.mobilesoft.coreblock.scene.intro.strictmode;

import android.content.Context;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.enums.StrictModeAccessMethod;
import cz.mobilesoft.coreblock.enums.StrictModeOption;
import cz.mobilesoft.coreblock.repository.StrictModeRepository;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO;
import cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroViewEvent;
import cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroViewModel;
import cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.profile.ProfileItemType;
import cz.mobilesoft.coreblock.util.profile.ProfileToViewDTOHelperKt;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
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
public final class StrictModeIntroViewModel extends BaseStatefulViewModel<StrictModeIntroViewState, StrictModeIntroViewEvent, StrictModeIntroViewCommand> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final ProfileDao f105035o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final StrictModeDataStore f105036p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final StrictModeRepository f105037q;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroViewModel$1", f = "StrictModeIntroViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f105038a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroViewModel$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroViewModel$1$1", f = "StrictModeIntroViewModel.kt", l = {41}, m = "invokeSuspend", v = 1)
        static final class C02801 extends SuspendLambda implements Function4<StrictModeAccessMethod, List<? extends StrictModeOption>, List<? extends Profile>, Continuation<? super StateDTO>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f105040a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            int f105041b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            int f105042c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            /* synthetic */ Object f105043d;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            /* synthetic */ Object f105044f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            /* synthetic */ Object f105045g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ StrictModeIntroViewModel f105046h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02801(StrictModeIntroViewModel strictModeIntroViewModel, Continuation continuation) {
                super(4, continuation);
                this.f105046h = strictModeIntroViewModel;
            }

            @Override // kotlin.jvm.functions.Function4
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public final Object invoke(StrictModeAccessMethod strictModeAccessMethod, List list, List list2, Continuation continuation) {
                C02801 c02801 = new C02801(this.f105046h, continuation);
                c02801.f105043d = strictModeAccessMethod;
                c02801.f105044f = list;
                c02801.f105045g = list2;
                return c02801.invokeSuspend(Unit.f139807a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                ProfileViewDTO profileViewDTO;
                StrictModeAccessMethod strictModeAccessMethod = (StrictModeAccessMethod) this.f105043d;
                List list = (List) this.f105044f;
                List list2 = (List) this.f105045g;
                Object objF = IntrinsicsKt.f();
                int i3 = this.f105042c;
                if (i3 == 0) {
                    ResultKt.b(obj);
                    Profile profile = (Profile) CollectionsKt.lastOrNull(list2);
                    if (profile == null) {
                        profileViewDTO = null;
                        return new StateDTO(strictModeAccessMethod, list, profileViewDTO);
                    }
                    Context contextA0 = this.f105046h.A0();
                    Set of = SetsKt.setOf(Boxing.e(profile.r()));
                    ProfileItemType.DetailList.Intro intro = ProfileItemType.DetailList.Intro.f129301a;
                    this.f105043d = strictModeAccessMethod;
                    this.f105044f = list;
                    this.f105045g = SpillingKt.a(list2);
                    this.f105040a = SpillingKt.a(profile);
                    this.f105041b = 0;
                    this.f105042c = 1;
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
                profileViewDTO = (ProfileViewDTO) CollectionsKt.firstOrNull((List) obj);
                return new StateDTO(strictModeAccessMethod, list, profileViewDTO);
            }
        }

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroViewModel$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass2<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ StrictModeIntroViewModel f105047a;

            AnonymousClass2(StrictModeIntroViewModel strictModeIntroViewModel) {
                this.f105047a = strictModeIntroViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final StrictModeIntroViewState f(StateDTO stateDTO, StrictModeIntroViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return updateState.a(stateDTO.a());
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(final StateDTO stateDTO, Continuation continuation) {
                this.f105047a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.y2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StrictModeIntroViewModel.AnonymousClass1.AnonymousClass2.f(stateDTO, (StrictModeIntroViewState) obj);
                    }
                });
                return Unit.f139807a;
            }
        }

        AnonymousClass1(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return StrictModeIntroViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f105038a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            FlowExtKt.i(FlowKt.n(StrictModeIntroViewModel.this.f105036p.f0(), StrictModeIntroViewModel.this.f105036p.m0(), StrictModeIntroViewModel.this.f105035o.Z0(false, true), new C02801(StrictModeIntroViewModel.this, null)), StrictModeIntroViewModel.this.C0(), new AnonymousClass2(StrictModeIntroViewModel.this));
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class StateDTO {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final StrictModeAccessMethod f105048a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List f105049b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ProfileViewDTO f105050c;

        public StateDTO(StrictModeAccessMethod strictModeAccessMethod, List options, ProfileViewDTO profileViewDTO) {
            Intrinsics.checkNotNullParameter(options, "options");
            this.f105048a = strictModeAccessMethod;
            this.f105049b = options;
            this.f105050c = profileViewDTO;
        }

        public final ProfileViewDTO a() {
            return this.f105050c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof StateDTO)) {
                return false;
            }
            StateDTO stateDTO = (StateDTO) obj;
            return this.f105048a == stateDTO.f105048a && Intrinsics.areEqual(this.f105049b, stateDTO.f105049b) && Intrinsics.areEqual(this.f105050c, stateDTO.f105050c);
        }

        public int hashCode() {
            StrictModeAccessMethod strictModeAccessMethod = this.f105048a;
            int iHashCode = (((strictModeAccessMethod == null ? 0 : strictModeAccessMethod.hashCode()) * 31) + this.f105049b.hashCode()) * 31;
            ProfileViewDTO profileViewDTO = this.f105050c;
            return iHashCode + (profileViewDTO != null ? profileViewDTO.hashCode() : 0);
        }

        public String toString() {
            return "StateDTO(accessMethod=" + this.f105048a + ", options=" + this.f105049b + ", profile=" + this.f105050c + ")";
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StrictModeIntroViewModel(LockieApplication application, ProfileDao profileDao, StrictModeDataStore strictModeDataStore, StrictModeRepository strictModeRepository) {
        super(application, new StrictModeIntroViewState(null, 1, null));
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(profileDao, "profileDao");
        Intrinsics.checkNotNullParameter(strictModeDataStore, "strictModeDataStore");
        Intrinsics.checkNotNullParameter(strictModeRepository, "strictModeRepository");
        this.f105035o = profileDao;
        this.f105036p = strictModeDataStore;
        this.f105037q = strictModeRepository;
        G0(new AnonymousClass1(null));
    }

    private final void X0(StrictModeAccessMethod strictModeAccessMethod, List list) {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new StrictModeIntroViewModel$onAccessMethodConfirmed$1(this, strictModeAccessMethod, list, null), 3, null);
    }

    private final void Y0() {
        G0(new StrictModeIntroViewModel$onCloseClicked$1(this, null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: Z0, reason: merged with bridge method [inline-methods] */
    public void O0(StrictModeIntroViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event, StrictModeIntroViewEvent.OnCloseClicked.f105032a)) {
            Y0();
            return;
        }
        if (event instanceof StrictModeIntroViewEvent.OnAccessMethodConfirmed) {
            StrictModeIntroViewEvent.OnAccessMethodConfirmed onAccessMethodConfirmed = (StrictModeIntroViewEvent.OnAccessMethodConfirmed) event;
            X0(onAccessMethodConfirmed.a(), onAccessMethodConfirmed.b());
        } else if (Intrinsics.areEqual(event, StrictModeIntroViewEvent.OnIntroFinished.f105033a)) {
            G0(new StrictModeIntroViewModel$onEvent$1(this, null));
        } else {
            if (!Intrinsics.areEqual(event, StrictModeIntroViewEvent.RestartIntro.f105034a)) {
                throw new NoWhenBranchMatchedException();
            }
            G0(new StrictModeIntroViewModel$onEvent$2(this, null));
        }
    }
}
