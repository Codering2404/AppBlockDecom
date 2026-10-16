package cz.mobilesoft.coreblock.scene.more.settings.developer;

import android.app.Application;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.media3.exoplayer.audio.wRw.CbYNFSEGaQj;
import com.applovin.sdk.AppLovinEventTypes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.firebase.sessions.api.ITd.wgbAZXYjrv;
import com.revenuecat.purchases.CustomerInfo;
import com.superwall.sdk.identity.Keys;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.activity.rating.RatingDialogType;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.enums.PremiumDevState;
import cz.mobilesoft.coreblock.enums.RevenueCatOffering;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.repository.QuickBlockRepository;
import cz.mobilesoft.coreblock.repository.StrictModeRepository;
import cz.mobilesoft.coreblock.repository.TokenFCMRepository;
import cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewEvent;
import cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel;
import cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewState;
import cz.mobilesoft.coreblock.scene.more.settings.developer.streaks.StreakDebugHelper;
import cz.mobilesoft.coreblock.scene.streaks.StreakAchievementNotificationPlanner;
import cz.mobilesoft.coreblock.scene.streaks.StreakNudgePlanner;
import cz.mobilesoft.coreblock.scene.streaks.StreakSnapshotSync;
import cz.mobilesoft.coreblock.scene.streaks.StreakStore;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore;
import cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore;
import cz.mobilesoft.coreblock.storage.datastore.StreakDataStore;
import cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore;
import cz.mobilesoft.coreblock.storage.datastore.TrialConversionDataStore;
import cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore;
import cz.mobilesoft.coreblock.storage.datastore.dev.DevPrefState;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.AdultContentWebsiteDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockSessionDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.storage.room.entity.core.TokenFCMEntity;
import cz.mobilesoft.coreblock.usecase.SupportJsonParseUseCase;
import cz.mobilesoft.coreblock.usecase.timenudge.PickTimeNudgeNotificationMessageUseCase;
import cz.mobilesoft.coreblock.util.SessionManager;
import cz.mobilesoft.coreblock.util.helperextension.ContextExtKt;
import cz.mobilesoft.coreblock.util.updates.InAppUpdatesMockSettingsDTO;
import dev.doubledot.doki.api.extensions.ConstantsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.xn.YvFRmou;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;

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
public final class DeveloperSettingsViewModel extends BaseStatefulViewModel<DeveloperSettingsViewState, DeveloperSettingsViewEvent, DeveloperSettingsViewCommand> {
    private final Lazy A;
    private final Lazy B;
    private final Lazy C;
    private final Lazy D;
    private final Lazy E;
    private final Lazy F;
    private final Lazy G;
    private final Lazy H;
    private final Lazy I;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f108491o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f108492p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f108493q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Lazy f108494r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Lazy f108495s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Lazy f108496t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Lazy f108497u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Lazy f108498v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final Lazy f108499w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final Lazy f108500x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final Lazy f108501y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final Lazy f108502z;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$1", f = "DeveloperSettingsViewModel.kt", l = {93}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f108503a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class C02881<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ DeveloperSettingsViewModel f108505a;

            C02881(DeveloperSettingsViewModel developerSettingsViewModel) {
                this.f108505a = developerSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final DeveloperSettingsViewState f(boolean z2, DeveloperSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, z2, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, null, -33, 524287, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f108505a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.t5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsViewModel.AnonymousClass1.C02881.f(z2, (DeveloperSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DeveloperSettingsViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f108503a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowH1 = DeveloperSettingsViewModel.this.m2().h1();
                C02881 c02881 = new C02881(DeveloperSettingsViewModel.this);
                this.f108503a = 1;
                if (flowH1.collect(c02881, this) == objF) {
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

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$10, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$10", f = "DeveloperSettingsViewModel.kt", l = {149}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass10 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f108506a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$10$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ DeveloperSettingsViewModel f108508a;

            AnonymousClass1(DeveloperSettingsViewModel developerSettingsViewModel) {
                this.f108508a = developerSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final DeveloperSettingsViewState f(TokenFCMEntity tokenFCMEntity, DeveloperSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, tokenFCMEntity != null ? tokenFCMEntity.a() : null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, null, -32769, 524287, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(final TokenFCMEntity tokenFCMEntity, Continuation continuation) {
                this.f108508a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.u5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsViewModel.AnonymousClass10.AnonymousClass1.f(tokenFCMEntity, (DeveloperSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }
        }

        AnonymousClass10(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DeveloperSettingsViewModel.this.new AnonymousClass10(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f108506a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowD = DeveloperSettingsViewModel.this.B2().d();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(DeveloperSettingsViewModel.this);
                this.f108506a = 1;
                if (flowD.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass10) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$11, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$11", f = "DeveloperSettingsViewModel.kt", l = {ModuleDescriptor.MODULE_VERSION}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass11 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f108509a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$11$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ DeveloperSettingsViewModel f108511a;

            AnonymousClass1(DeveloperSettingsViewModel developerSettingsViewModel) {
                this.f108511a = developerSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final DeveloperSettingsViewState f(CustomerInfo customerInfo, DeveloperSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, customerInfo != null ? customerInfo.getOriginalAppUserId() : null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, null, -65537, 524287, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(final CustomerInfo customerInfo, Continuation continuation) {
                this.f108511a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.v5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsViewModel.AnonymousClass11.AnonymousClass1.f(customerInfo, (DeveloperSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }
        }

        AnonymousClass11(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DeveloperSettingsViewModel.this.new AnonymousClass11(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f108509a;
            if (i3 == 0) {
                ResultKt.b(obj);
                StateFlow stateFlowC = DeveloperSettingsViewModel.this.p2().C();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(DeveloperSettingsViewModel.this);
                this.f108509a = 1;
                if (stateFlowC.collect(anonymousClass1, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            throw new KotlinNothingValueException();
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass11) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$12, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$12", f = "DeveloperSettingsViewModel.kt", l = {161}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass12 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f108512a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$12$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ DeveloperSettingsViewModel f108514a;

            AnonymousClass1(DeveloperSettingsViewModel developerSettingsViewModel) {
                this.f108514a = developerSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final DeveloperSettingsViewState g(SessionManager.SignInState signInState, DeveloperSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, ((SessionManager.SignedIn) signInState).a(), true, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, null, -393217, 524287, null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final DeveloperSettingsViewState h(DeveloperSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, null, -393217, 524287, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public final Object emit(final SessionManager.SignInState signInState, Continuation continuation) {
                if (signInState instanceof SessionManager.SignedIn) {
                    this.f108514a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.w5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return DeveloperSettingsViewModel.AnonymousClass12.AnonymousClass1.g(signInState, (DeveloperSettingsViewState) obj);
                        }
                    });
                } else {
                    this.f108514a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.x5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return DeveloperSettingsViewModel.AnonymousClass12.AnonymousClass1.h((DeveloperSettingsViewState) obj);
                        }
                    });
                }
                return Unit.f139807a;
            }
        }

        AnonymousClass12(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DeveloperSettingsViewModel.this.new AnonymousClass12(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f108512a;
            if (i3 == 0) {
                ResultKt.b(obj);
                StateFlow stateFlowL = SessionManager.f127910a.l();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(DeveloperSettingsViewModel.this);
                this.f108512a = 1;
                if (stateFlowL.collect(anonymousClass1, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            throw new KotlinNothingValueException();
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass12) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$13, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$13", f = "DeveloperSettingsViewModel.kt", l = {185}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass13 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f108515a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$13$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ DeveloperSettingsViewModel f108517a;

            AnonymousClass1(DeveloperSettingsViewModel developerSettingsViewModel) {
                this.f108517a = developerSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final DeveloperSettingsViewState f(DevPrefState devPrefState, DeveloperSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, devPrefState, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, null, -524289, 524287, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(final DevPrefState devPrefState, Continuation continuation) {
                this.f108517a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.y5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsViewModel.AnonymousClass13.AnonymousClass1.f(devPrefState, (DeveloperSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }
        }

        AnonymousClass13(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DeveloperSettingsViewModel.this.new AnonymousClass13(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f108515a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowS0 = DeveloperSettingsViewModel.this.m2().S0();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(DeveloperSettingsViewModel.this);
                this.f108515a = 1;
                if (flowS0.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass13) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$14, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$14", f = "DeveloperSettingsViewModel.kt", l = {191}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass14 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f108518a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$14$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ DeveloperSettingsViewModel f108520a;

            AnonymousClass1(DeveloperSettingsViewModel developerSettingsViewModel) {
                this.f108520a = developerSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final DeveloperSettingsViewState f(DevPrefState devPrefState, DeveloperSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, devPrefState, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, null, -1048577, 524287, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(final DevPrefState devPrefState, Continuation continuation) {
                this.f108520a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.z5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsViewModel.AnonymousClass14.AnonymousClass1.f(devPrefState, (DeveloperSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }
        }

        AnonymousClass14(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DeveloperSettingsViewModel.this.new AnonymousClass14(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f108518a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowA1 = DeveloperSettingsViewModel.this.m2().a1();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(DeveloperSettingsViewModel.this);
                this.f108518a = 1;
                if (flowA1.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass14) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$15, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$15", f = "DeveloperSettingsViewModel.kt", l = {197}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass15 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f108521a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$15$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ DeveloperSettingsViewModel f108523a;

            AnonymousClass1(DeveloperSettingsViewModel developerSettingsViewModel) {
                this.f108523a = developerSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final DeveloperSettingsViewState f(DevPrefState devPrefState, DeveloperSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, devPrefState, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, null, -2097153, 524287, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(final DevPrefState devPrefState, Continuation continuation) {
                this.f108523a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.a6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsViewModel.AnonymousClass15.AnonymousClass1.f(devPrefState, (DeveloperSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }
        }

        AnonymousClass15(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DeveloperSettingsViewModel.this.new AnonymousClass15(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f108521a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowT0 = DeveloperSettingsViewModel.this.m2().T0();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(DeveloperSettingsViewModel.this);
                this.f108521a = 1;
                if (flowT0.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass15) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$16, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$16", f = "DeveloperSettingsViewModel.kt", l = {203}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass16 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f108524a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$16$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ DeveloperSettingsViewModel f108526a;

            AnonymousClass1(DeveloperSettingsViewModel developerSettingsViewModel) {
                this.f108526a = developerSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final DeveloperSettingsViewState f(DevPrefState devPrefState, DeveloperSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, devPrefState, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, null, -4194305, 524287, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(final DevPrefState devPrefState, Continuation continuation) {
                this.f108526a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.b6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsViewModel.AnonymousClass16.AnonymousClass1.f(devPrefState, (DeveloperSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }
        }

        AnonymousClass16(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DeveloperSettingsViewModel.this.new AnonymousClass16(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f108524a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowW0 = DeveloperSettingsViewModel.this.m2().W0();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(DeveloperSettingsViewModel.this);
                this.f108524a = 1;
                if (flowW0.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass16) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$17, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$17", f = "DeveloperSettingsViewModel.kt", l = {209}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass17 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f108527a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$17$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ DeveloperSettingsViewModel f108529a;

            AnonymousClass1(DeveloperSettingsViewModel developerSettingsViewModel) {
                this.f108529a = developerSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final DeveloperSettingsViewState f(DevPrefState devPrefState, DeveloperSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, devPrefState, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, null, -8388609, 524287, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(final DevPrefState devPrefState, Continuation continuation) {
                this.f108529a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.c6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsViewModel.AnonymousClass17.AnonymousClass1.f(devPrefState, (DeveloperSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }
        }

        AnonymousClass17(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DeveloperSettingsViewModel.this.new AnonymousClass17(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f108527a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowI1 = DeveloperSettingsViewModel.this.m2().i1();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(DeveloperSettingsViewModel.this);
                this.f108527a = 1;
                if (flowI1.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass17) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$18, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$18", f = "DeveloperSettingsViewModel.kt", l = {215}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass18 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f108530a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$18$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ DeveloperSettingsViewModel f108532a;

            AnonymousClass1(DeveloperSettingsViewModel developerSettingsViewModel) {
                this.f108532a = developerSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final DeveloperSettingsViewState f(DevPrefState devPrefState, DeveloperSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, devPrefState, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, null, -16777217, 524287, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(final DevPrefState devPrefState, Continuation continuation) {
                this.f108532a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.d6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsViewModel.AnonymousClass18.AnonymousClass1.f(devPrefState, (DeveloperSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }
        }

        AnonymousClass18(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DeveloperSettingsViewModel.this.new AnonymousClass18(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f108530a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowV0 = DeveloperSettingsViewModel.this.m2().V0();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(DeveloperSettingsViewModel.this);
                this.f108530a = 1;
                if (flowV0.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass18) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$19, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$19", f = "DeveloperSettingsViewModel.kt", l = {221}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass19 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f108533a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$19$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ DeveloperSettingsViewModel f108535a;

            AnonymousClass1(DeveloperSettingsViewModel developerSettingsViewModel) {
                this.f108535a = developerSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final DeveloperSettingsViewState f(boolean z2, DeveloperSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, z2, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, null, -67108865, 524287, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f108535a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.e6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsViewModel.AnonymousClass19.AnonymousClass1.f(z2, (DeveloperSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass19(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DeveloperSettingsViewModel.this.new AnonymousClass19(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f108533a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowX0 = DeveloperSettingsViewModel.this.m2().X0();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(DeveloperSettingsViewModel.this);
                this.f108533a = 1;
                if (flowX0.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass19) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$2", f = "DeveloperSettingsViewModel.kt", l = {99}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f108536a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ DeveloperSettingsViewModel f108538a;

            AnonymousClass1(DeveloperSettingsViewModel developerSettingsViewModel) {
                this.f108538a = developerSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final DeveloperSettingsViewState f(boolean z2, DeveloperSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, z2, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, null, -65, 524287, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f108538a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.f6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsViewModel.AnonymousClass2.AnonymousClass1.f(z2, (DeveloperSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DeveloperSettingsViewModel.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f108536a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowO1 = DeveloperSettingsViewModel.this.m2().o1();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(DeveloperSettingsViewModel.this);
                this.f108536a = 1;
                if (flowO1.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$20, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$20", f = "DeveloperSettingsViewModel.kt", l = {227}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass20 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f108539a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$20$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ DeveloperSettingsViewModel f108541a;

            AnonymousClass1(DeveloperSettingsViewModel developerSettingsViewModel) {
                this.f108541a = developerSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final DeveloperSettingsViewState f(boolean z2, DeveloperSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, z2, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, null, -134217729, 524287, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f108541a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.g6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsViewModel.AnonymousClass20.AnonymousClass1.f(z2, (DeveloperSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass20(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DeveloperSettingsViewModel.this.new AnonymousClass20(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f108539a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowG1 = DeveloperSettingsViewModel.this.m2().g1();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(DeveloperSettingsViewModel.this);
                this.f108539a = 1;
                if (flowG1.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass20) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$21, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$21", f = "DeveloperSettingsViewModel.kt", l = {233}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass21 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f108542a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$21$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ DeveloperSettingsViewModel f108544a;

            AnonymousClass1(DeveloperSettingsViewModel developerSettingsViewModel) {
                this.f108544a = developerSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final DeveloperSettingsViewState f(boolean z2, DeveloperSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, z2, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, null, -268435457, 524287, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f108544a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.h6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsViewModel.AnonymousClass21.AnonymousClass1.f(z2, (DeveloperSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass21(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DeveloperSettingsViewModel.this.new AnonymousClass21(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f108542a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowU0 = DeveloperSettingsViewModel.this.m2().U0();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(DeveloperSettingsViewModel.this);
                this.f108542a = 1;
                if (flowU0.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass21) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$22, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$22", f = "DeveloperSettingsViewModel.kt", l = {239}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass22 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f108545a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$22$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ DeveloperSettingsViewModel f108547a;

            AnonymousClass1(DeveloperSettingsViewModel developerSettingsViewModel) {
                this.f108547a = developerSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final DeveloperSettingsViewState f(boolean z2, DeveloperSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, z2, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, null, -536870913, 524287, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f108547a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.i6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsViewModel.AnonymousClass22.AnonymousClass1.f(z2, (DeveloperSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass22(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DeveloperSettingsViewModel.this.new AnonymousClass22(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f108545a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowY0 = DeveloperSettingsViewModel.this.m2().Y0();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(DeveloperSettingsViewModel.this);
                this.f108545a = 1;
                if (flowY0.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass22) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$23, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$23", f = "DeveloperSettingsViewModel.kt", l = {245}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass23 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f108548a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$23$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ DeveloperSettingsViewModel f108550a;

            AnonymousClass1(DeveloperSettingsViewModel developerSettingsViewModel) {
                this.f108550a = developerSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final DeveloperSettingsViewState f(boolean z2, DeveloperSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, z2, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, null, -1073741825, 524287, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f108550a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.j6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsViewModel.AnonymousClass23.AnonymousClass1.f(z2, (DeveloperSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass23(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DeveloperSettingsViewModel.this.new AnonymousClass23(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f108548a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowZ0 = DeveloperSettingsViewModel.this.m2().Z0();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(DeveloperSettingsViewModel.this);
                this.f108548a = 1;
                if (flowZ0.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass23) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$24, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$24", f = "DeveloperSettingsViewModel.kt", l = {251}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass24 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f108551a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$24$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ DeveloperSettingsViewModel f108553a;

            AnonymousClass1(DeveloperSettingsViewModel developerSettingsViewModel) {
                this.f108553a = developerSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final DeveloperSettingsViewState f(boolean z2, DeveloperSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, z2, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, null, Api.BaseClientBuilder.API_PRIORITY_OTHER, 524287, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f108553a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.k6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsViewModel.AnonymousClass24.AnonymousClass1.f(z2, (DeveloperSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass24(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DeveloperSettingsViewModel.this.new AnonymousClass24(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f108551a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowC0 = DeveloperSettingsViewModel.this.m2().C0();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(DeveloperSettingsViewModel.this);
                this.f108551a = 1;
                if (flowC0.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass24) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$25, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$25", f = "DeveloperSettingsViewModel.kt", l = {257}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass25 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f108554a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$25$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ DeveloperSettingsViewModel f108556a;

            AnonymousClass1(DeveloperSettingsViewModel developerSettingsViewModel) {
                this.f108556a = developerSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final DeveloperSettingsViewState f(boolean z2, DeveloperSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, z2, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, null, -1, 524286, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f108556a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.l6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsViewModel.AnonymousClass25.AnonymousClass1.f(z2, (DeveloperSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass25(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DeveloperSettingsViewModel.this.new AnonymousClass25(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f108554a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowD0 = DeveloperSettingsViewModel.this.m2().D0();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(DeveloperSettingsViewModel.this);
                this.f108554a = 1;
                if (flowD0.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass25) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$26, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$26", f = "DeveloperSettingsViewModel.kt", l = {263}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass26 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f108557a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$26$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ DeveloperSettingsViewModel f108559a;

            AnonymousClass1(DeveloperSettingsViewModel developerSettingsViewModel) {
                this.f108559a = developerSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final DeveloperSettingsViewState f(boolean z2, DeveloperSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, z2, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, null, -1, 524285, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f108559a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.m6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsViewModel.AnonymousClass26.AnonymousClass1.f(z2, (DeveloperSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass26(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DeveloperSettingsViewModel.this.new AnonymousClass26(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f108557a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowR0 = DeveloperSettingsViewModel.this.m2().R0();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(DeveloperSettingsViewModel.this);
                this.f108557a = 1;
                if (flowR0.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass26) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$27, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$27", f = "DeveloperSettingsViewModel.kt", l = {270}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass27 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f108560a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$27$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ DeveloperSettingsViewModel f108562a;

            AnonymousClass1(DeveloperSettingsViewModel developerSettingsViewModel) {
                this.f108562a = developerSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final DeveloperSettingsViewState f(boolean z2, DeveloperSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, z2, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, null, -1, 524283, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f108562a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.n6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsViewModel.AnonymousClass27.AnonymousClass1.f(z2, (DeveloperSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass27(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DeveloperSettingsViewModel.this.new AnonymousClass27(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f108560a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowF1 = DeveloperSettingsViewModel.this.m2().f1();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(DeveloperSettingsViewModel.this);
                this.f108560a = 1;
                if (flowF1.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass27) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$28, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$28", f = "DeveloperSettingsViewModel.kt", l = {276}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass28 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f108563a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$28$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ DeveloperSettingsViewModel f108565a;

            AnonymousClass1(DeveloperSettingsViewModel developerSettingsViewModel) {
                this.f108565a = developerSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final DeveloperSettingsViewState f(RatingDialogType ratingDialogType, DeveloperSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, ratingDialogType, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, null, -1, 524279, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(final RatingDialogType ratingDialogType, Continuation continuation) {
                this.f108565a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.o6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsViewModel.AnonymousClass28.AnonymousClass1.f(ratingDialogType, (DeveloperSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }
        }

        AnonymousClass28(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DeveloperSettingsViewModel.this.new AnonymousClass28(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f108563a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowE0 = DeveloperSettingsViewModel.this.m2().E0();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(DeveloperSettingsViewModel.this);
                this.f108563a = 1;
                if (flowE0.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass28) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$29, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$29", f = "DeveloperSettingsViewModel.kt", l = {282}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass29 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f108566a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$29$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ DeveloperSettingsViewModel f108568a;

            AnonymousClass1(DeveloperSettingsViewModel developerSettingsViewModel) {
                this.f108568a = developerSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final DeveloperSettingsViewState f(InAppUpdatesMockSettingsDTO inAppUpdatesMockSettingsDTO, DeveloperSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, inAppUpdatesMockSettingsDTO, null, false, false, null, 0L, false, false, false, false, false, false, false, false, null, -1, 524271, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(final InAppUpdatesMockSettingsDTO inAppUpdatesMockSettingsDTO, Continuation continuation) {
                this.f108568a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.p6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsViewModel.AnonymousClass29.AnonymousClass1.f(inAppUpdatesMockSettingsDTO, (DeveloperSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }
        }

        AnonymousClass29(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DeveloperSettingsViewModel.this.new AnonymousClass29(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f108566a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowF0 = DeveloperSettingsViewModel.this.m2().F0();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(DeveloperSettingsViewModel.this);
                this.f108566a = 1;
                if (flowF0.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass29) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$3", f = "DeveloperSettingsViewModel.kt", l = {105}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f108569a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ DeveloperSettingsViewModel f108571a;

            AnonymousClass1(DeveloperSettingsViewModel developerSettingsViewModel) {
                this.f108571a = developerSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final DeveloperSettingsViewState f(boolean z2, DeveloperSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, z2, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, null, -129, 524287, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f108571a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.q6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsViewModel.AnonymousClass3.AnonymousClass1.f(z2, (DeveloperSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass3(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DeveloperSettingsViewModel.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f108569a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowV1 = DeveloperSettingsViewModel.this.m2().v1();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(DeveloperSettingsViewModel.this);
                this.f108569a = 1;
                if (flowV1.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$30, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$30", f = "DeveloperSettingsViewModel.kt", l = {288}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass30 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f108572a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$30$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ DeveloperSettingsViewModel f108574a;

            AnonymousClass1(DeveloperSettingsViewModel developerSettingsViewModel) {
                this.f108574a = developerSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final DeveloperSettingsViewState f(String str, DeveloperSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, str, false, false, null, 0L, false, false, false, false, false, false, false, false, null, -1, 524255, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(final String str, Continuation continuation) {
                this.f108574a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.r6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsViewModel.AnonymousClass30.AnonymousClass1.f(str, (DeveloperSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }
        }

        AnonymousClass30(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DeveloperSettingsViewModel.this.new AnonymousClass30(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f108572a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowI0 = DeveloperSettingsViewModel.this.m2().I0();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(DeveloperSettingsViewModel.this);
                this.f108572a = 1;
                if (flowI0.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass30) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$31, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$31", f = "DeveloperSettingsViewModel.kt", l = {294}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass31 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f108575a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$31$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ DeveloperSettingsViewModel f108577a;

            AnonymousClass1(DeveloperSettingsViewModel developerSettingsViewModel) {
                this.f108577a = developerSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final DeveloperSettingsViewState f(boolean z2, DeveloperSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, z2, false, null, 0L, false, false, false, false, false, false, false, false, null, -1, 524223, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f108577a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.s6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsViewModel.AnonymousClass31.AnonymousClass1.f(z2, (DeveloperSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass31(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DeveloperSettingsViewModel.this.new AnonymousClass31(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f108575a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowJ0 = DeveloperSettingsViewModel.this.m2().J0();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(DeveloperSettingsViewModel.this);
                this.f108575a = 1;
                if (flowJ0.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass31) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$32, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$32", f = "DeveloperSettingsViewModel.kt", l = {300}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass32 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f108578a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$32$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ DeveloperSettingsViewModel f108580a;

            AnonymousClass1(DeveloperSettingsViewModel developerSettingsViewModel) {
                this.f108580a = developerSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final DeveloperSettingsViewState f(boolean z2, DeveloperSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, z2, null, 0L, false, false, false, false, false, false, false, false, null, -1, 524159, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f108580a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.t6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsViewModel.AnonymousClass32.AnonymousClass1.f(z2, (DeveloperSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass32(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DeveloperSettingsViewModel.this.new AnonymousClass32(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f108578a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowM1 = DeveloperSettingsViewModel.this.m2().m1();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(DeveloperSettingsViewModel.this);
                this.f108578a = 1;
                if (flowM1.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass32) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$33, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$33", f = "DeveloperSettingsViewModel.kt", l = {306}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass33 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f108581a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$33$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ DeveloperSettingsViewModel f108583a;

            AnonymousClass1(DeveloperSettingsViewModel developerSettingsViewModel) {
                this.f108583a = developerSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final DeveloperSettingsViewState f(String str, DeveloperSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, str, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, null, -16385, 524287, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(final String str, Continuation continuation) {
                this.f108583a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.u6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsViewModel.AnonymousClass33.AnonymousClass1.f(str, (DeveloperSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }
        }

        AnonymousClass33(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DeveloperSettingsViewModel.this.new AnonymousClass33(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f108581a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowC1 = DeveloperSettingsViewModel.this.m2().c1();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(DeveloperSettingsViewModel.this);
                this.f108581a = 1;
                if (flowC1.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass33) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$34, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$34", f = "DeveloperSettingsViewModel.kt", l = {313}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass34 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f108584a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$34$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ DeveloperSettingsViewModel f108586a;

            AnonymousClass1(DeveloperSettingsViewModel developerSettingsViewModel) {
                this.f108586a = developerSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final DeveloperSettingsViewState f(String str, DeveloperSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, str, 0L, false, false, false, false, false, false, false, false, null, -1, 524031, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(final String str, Continuation continuation) {
                this.f108586a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.v6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsViewModel.AnonymousClass34.AnonymousClass1.f(str, (DeveloperSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }
        }

        AnonymousClass34(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DeveloperSettingsViewModel.this.new AnonymousClass34(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f108584a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowQ0 = DeveloperSettingsViewModel.this.m2().Q0();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(DeveloperSettingsViewModel.this);
                this.f108584a = 1;
                if (flowQ0.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass34) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$35, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$35", f = "DeveloperSettingsViewModel.kt", l = {319}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass35 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f108587a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$35$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ DeveloperSettingsViewModel f108589a;

            AnonymousClass1(DeveloperSettingsViewModel developerSettingsViewModel) {
                this.f108589a = developerSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final DeveloperSettingsViewState f(long j3, DeveloperSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, j3, false, false, false, false, false, false, false, false, null, -1, 523775, null);
            }

            public final Object b(final long j3, Continuation continuation) {
                this.f108589a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.w6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsViewModel.AnonymousClass35.AnonymousClass1.f(j3, (DeveloperSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Number) obj).longValue(), continuation);
            }
        }

        AnonymousClass35(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DeveloperSettingsViewModel.this.new AnonymousClass35(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f108587a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowD1 = DeveloperSettingsViewModel.this.m2().d1();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(DeveloperSettingsViewModel.this);
                this.f108587a = 1;
                if (flowD1.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass35) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$36, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$36", f = "DeveloperSettingsViewModel.kt", l = {325}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass36 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f108590a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$36$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ DeveloperSettingsViewModel f108592a;

            AnonymousClass1(DeveloperSettingsViewModel developerSettingsViewModel) {
                this.f108592a = developerSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final DeveloperSettingsViewState f(boolean z2, DeveloperSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, z2, false, false, false, false, false, false, false, null, -1, 523263, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f108592a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.x6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsViewModel.AnonymousClass36.AnonymousClass1.f(z2, (DeveloperSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass36(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DeveloperSettingsViewModel.this.new AnonymousClass36(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f108590a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowY0 = DeveloperSettingsViewModel.this.m2().y0();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(DeveloperSettingsViewModel.this);
                this.f108590a = 1;
                if (flowY0.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass36) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$37, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$37", f = "DeveloperSettingsViewModel.kt", l = {332}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass37 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f108593a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$37$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ DeveloperSettingsViewModel f108595a;

            AnonymousClass1(DeveloperSettingsViewModel developerSettingsViewModel) {
                this.f108595a = developerSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final DeveloperSettingsViewState f(boolean z2, DeveloperSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, z2, false, false, false, false, false, false, null, -1, 522239, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f108595a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.y6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsViewModel.AnonymousClass37.AnonymousClass1.f(z2, (DeveloperSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass37(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DeveloperSettingsViewModel.this.new AnonymousClass37(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f108593a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowA0 = DeveloperSettingsViewModel.this.m2().A0();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(DeveloperSettingsViewModel.this);
                this.f108593a = 1;
                if (flowA0.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass37) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$38, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$38", f = "DeveloperSettingsViewModel.kt", l = {338}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass38 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f108596a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$38$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ DeveloperSettingsViewModel f108598a;

            AnonymousClass1(DeveloperSettingsViewModel developerSettingsViewModel) {
                this.f108598a = developerSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final DeveloperSettingsViewState f(boolean z2, DeveloperSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, z2, false, false, false, false, false, null, -1, 520191, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f108598a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.z6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsViewModel.AnonymousClass38.AnonymousClass1.f(z2, (DeveloperSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass38(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DeveloperSettingsViewModel.this.new AnonymousClass38(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f108596a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowZ0 = DeveloperSettingsViewModel.this.m2().z0();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(DeveloperSettingsViewModel.this);
                this.f108596a = 1;
                if (flowZ0.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass38) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$39, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$39", f = "DeveloperSettingsViewModel.kt", l = {344}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass39 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f108599a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$39$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ DeveloperSettingsViewModel f108601a;

            AnonymousClass1(DeveloperSettingsViewModel developerSettingsViewModel) {
                this.f108601a = developerSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final DeveloperSettingsViewState f(boolean z2, DeveloperSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, z2, false, false, false, false, null, -1, 516095, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f108601a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.a7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsViewModel.AnonymousClass39.AnonymousClass1.f(z2, (DeveloperSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass39(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DeveloperSettingsViewModel.this.new AnonymousClass39(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f108599a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowH0 = DeveloperSettingsViewModel.this.m2().H0();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(DeveloperSettingsViewModel.this);
                this.f108599a = 1;
                if (flowH0.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass39) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$4", f = "DeveloperSettingsViewModel.kt", l = {112}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f108602a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$4$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ DeveloperSettingsViewModel f108604a;

            AnonymousClass1(DeveloperSettingsViewModel developerSettingsViewModel) {
                this.f108604a = developerSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final DeveloperSettingsViewState f(PremiumDevState premiumDevState, DeveloperSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, premiumDevState, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, null, -257, 524287, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(final PremiumDevState premiumDevState, Continuation continuation) {
                this.f108604a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.b7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsViewModel.AnonymousClass4.AnonymousClass1.f(premiumDevState, (DeveloperSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }
        }

        AnonymousClass4(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DeveloperSettingsViewModel.this.new AnonymousClass4(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f108602a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowO0 = DeveloperSettingsViewModel.this.m2().O0();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(DeveloperSettingsViewModel.this);
                this.f108602a = 1;
                if (flowO0.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$40, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$40", f = "DeveloperSettingsViewModel.kt", l = {350}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass40 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f108605a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$40$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ DeveloperSettingsViewModel f108607a;

            AnonymousClass1(DeveloperSettingsViewModel developerSettingsViewModel) {
                this.f108607a = developerSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final DeveloperSettingsViewState f(boolean z2, DeveloperSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, z2, false, false, false, null, -1, 507903, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f108607a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.c7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsViewModel.AnonymousClass40.AnonymousClass1.f(z2, (DeveloperSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass40(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DeveloperSettingsViewModel.this.new AnonymousClass40(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f108605a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowM0 = DeveloperSettingsViewModel.this.m2().M0();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(DeveloperSettingsViewModel.this);
                this.f108605a = 1;
                if (flowM0.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass40) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$41, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$41", f = "DeveloperSettingsViewModel.kt", l = {356}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass41 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f108608a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$41$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ DeveloperSettingsViewModel f108610a;

            AnonymousClass1(DeveloperSettingsViewModel developerSettingsViewModel) {
                this.f108610a = developerSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final DeveloperSettingsViewState f(boolean z2, DeveloperSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, z2, false, false, null, -1, 491519, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f108610a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.d7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsViewModel.AnonymousClass41.AnonymousClass1.f(z2, (DeveloperSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass41(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return DeveloperSettingsViewModel.this.new AnonymousClass41(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f108608a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowE1 = DeveloperSettingsViewModel.this.m2().e1();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(DeveloperSettingsViewModel.this);
                this.f108608a = 1;
                if (flowE1.collect(anonymousClass1, this) == objF) {
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

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass41) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$42, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$42", f = "DeveloperSettingsViewModel.kt", l = {362}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass42 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f108611a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$42$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ DeveloperSettingsViewModel f108613a;

            AnonymousClass1(DeveloperSettingsViewModel developerSettingsViewModel) {
                this.f108613a = developerSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final DeveloperSettingsViewState f(boolean z2, DeveloperSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, z2, false, null, -1, 458751, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f108613a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.e7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsViewModel.AnonymousClass42.AnonymousClass1.f(z2, (DeveloperSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass42(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DeveloperSettingsViewModel.this.new AnonymousClass42(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f108611a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowB1 = DeveloperSettingsViewModel.this.m2().b1();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(DeveloperSettingsViewModel.this);
                this.f108611a = 1;
                if (flowB1.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass42) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$43, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$43", f = "DeveloperSettingsViewModel.kt", l = {368}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass43 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f108614a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$43$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ DeveloperSettingsViewModel f108616a;

            AnonymousClass1(DeveloperSettingsViewModel developerSettingsViewModel) {
                this.f108616a = developerSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final DeveloperSettingsViewState f(DevPrefState devPrefState, DeveloperSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, devPrefState, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, null, -33554433, 524287, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(final DevPrefState devPrefState, Continuation continuation) {
                this.f108616a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.f7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsViewModel.AnonymousClass43.AnonymousClass1.f(devPrefState, (DeveloperSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }
        }

        AnonymousClass43(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DeveloperSettingsViewModel.this.new AnonymousClass43(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f108614a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowL0 = DeveloperSettingsViewModel.this.m2().L0();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(DeveloperSettingsViewModel.this);
                this.f108614a = 1;
                if (flowL0.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass43) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$5", f = "DeveloperSettingsViewModel.kt", l = {118}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f108617a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$5$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ DeveloperSettingsViewModel f108619a;

            AnonymousClass1(DeveloperSettingsViewModel developerSettingsViewModel) {
                this.f108619a = developerSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final DeveloperSettingsViewState f(RevenueCatOffering revenueCatOffering, DeveloperSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, revenueCatOffering, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, null, -513, 524287, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(final RevenueCatOffering revenueCatOffering, Continuation continuation) {
                this.f108619a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.g7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsViewModel.AnonymousClass5.AnonymousClass1.f(revenueCatOffering, (DeveloperSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }
        }

        AnonymousClass5(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DeveloperSettingsViewModel.this.new AnonymousClass5(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f108617a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowN0 = DeveloperSettingsViewModel.this.m2().N0();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(DeveloperSettingsViewModel.this);
                this.f108617a = 1;
                if (flowN0.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass5) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$6, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$6", f = "DeveloperSettingsViewModel.kt", l = {124}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f108620a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$6$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ DeveloperSettingsViewModel f108622a;

            AnonymousClass1(DeveloperSettingsViewModel developerSettingsViewModel) {
                this.f108622a = developerSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final DeveloperSettingsViewState f(boolean z2, DeveloperSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, z2, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, null, -1025, 524287, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f108622a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.h7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsViewModel.AnonymousClass6.AnonymousClass1.f(z2, (DeveloperSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass6(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DeveloperSettingsViewModel.this.new AnonymousClass6(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f108620a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowK0 = DeveloperSettingsViewModel.this.m2().K0();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(DeveloperSettingsViewModel.this);
                this.f108620a = 1;
                if (flowK0.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass6) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$7, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$7", f = "DeveloperSettingsViewModel.kt", l = {130}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f108623a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$7$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ DeveloperSettingsViewModel f108625a;

            AnonymousClass1(DeveloperSettingsViewModel developerSettingsViewModel) {
                this.f108625a = developerSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final DeveloperSettingsViewState f(boolean z2, DeveloperSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, z2, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, null, -2049, 524287, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f108625a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.i7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsViewModel.AnonymousClass7.AnonymousClass1.f(z2, (DeveloperSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass7(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DeveloperSettingsViewModel.this.new AnonymousClass7(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f108623a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowX1 = DeveloperSettingsViewModel.this.m2().x1();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(DeveloperSettingsViewModel.this);
                this.f108623a = 1;
                if (flowX1.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass7) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$8, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$8", f = "DeveloperSettingsViewModel.kt", l = {136}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f108626a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$8$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ DeveloperSettingsViewModel f108628a;

            AnonymousClass1(DeveloperSettingsViewModel developerSettingsViewModel) {
                this.f108628a = developerSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final DeveloperSettingsViewState f(boolean z2, DeveloperSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, z2, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, null, -4097, 524287, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f108628a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.j7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsViewModel.AnonymousClass8.AnonymousClass1.f(z2, (DeveloperSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass8(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DeveloperSettingsViewModel.this.new AnonymousClass8(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f108626a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowR1 = DeveloperSettingsViewModel.this.m2().r1();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(DeveloperSettingsViewModel.this);
                this.f108626a = 1;
                if (flowR1.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass8) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$9, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$9", f = "DeveloperSettingsViewModel.kt", l = {142}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass9 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f108629a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$9$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ DeveloperSettingsViewModel f108631a;

            AnonymousClass1(DeveloperSettingsViewModel developerSettingsViewModel) {
                this.f108631a = developerSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final DeveloperSettingsViewState f(boolean z2, DeveloperSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, z2, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, null, -8193, 524287, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f108631a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.k7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsViewModel.AnonymousClass9.AnonymousClass1.f(z2, (DeveloperSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass9(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DeveloperSettingsViewModel.this.new AnonymousClass9(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f108629a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowT1 = DeveloperSettingsViewModel.this.m2().t1();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(DeveloperSettingsViewModel.this);
                this.f108629a = 1;
                if (flowT1.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass9) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DeveloperSettingsViewModel(Application application) {
        super(application, new DeveloperSettingsViewState(null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, null, -1, 524287, null));
        Intrinsics.checkNotNullParameter(application, "application");
        final Qualifier qualifier = null;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f108491o = LazyKt.a(lazyThreadSafetyModeB, new Function0<DevDataStore>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DevDataStore.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f108492p = LazyKt.a(lazyThreadSafetyModeB2, new Function0<StreakDebugHelper>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StreakDebugHelper.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f108493q = LazyKt.a(lazyThreadSafetyModeB3, new Function0<StreakStore>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StreakStore.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f108494r = LazyKt.a(lazyThreadSafetyModeB4, new Function0<StreakDataStore>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StreakDataStore.class), objArr6, objArr7);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB5 = koinPlatformTools.b();
        final Object[] objArr8 = 0 == true ? 1 : 0;
        final Object[] objArr9 = 0 == true ? 1 : 0;
        this.f108495s = LazyKt.a(lazyThreadSafetyModeB5, new Function0<StreakAchievementNotificationPlanner>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StreakAchievementNotificationPlanner.class), objArr8, objArr9);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB6 = koinPlatformTools.b();
        final Object[] objArr10 = 0 == true ? 1 : 0;
        final Object[] objArr11 = 0 == true ? 1 : 0;
        this.f108496t = LazyKt.a(lazyThreadSafetyModeB6, new Function0<StreakNudgePlanner>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$special$$inlined$inject$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StreakNudgePlanner.class), objArr10, objArr11);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB7 = koinPlatformTools.b();
        final Object[] objArr12 = 0 == true ? 1 : 0;
        final Object[] objArr13 = 0 == true ? 1 : 0;
        this.f108497u = LazyKt.a(lazyThreadSafetyModeB7, new Function0<StreakSnapshotSync>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$special$$inlined$inject$default$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StreakSnapshotSync.class), objArr12, objArr13);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB8 = koinPlatformTools.b();
        final Object[] objArr14 = 0 == true ? 1 : 0;
        final Object[] objArr15 = 0 == true ? 1 : 0;
        this.f108498v = LazyKt.a(lazyThreadSafetyModeB8, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$special$$inlined$inject$default$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreDataStore.class), objArr14, objArr15);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB9 = koinPlatformTools.b();
        final Object[] objArr16 = 0 == true ? 1 : 0;
        final Object[] objArr17 = 0 == true ? 1 : 0;
        this.f108499w = LazyKt.a(lazyThreadSafetyModeB9, new Function0<StrictModeDataStore>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$special$$inlined$inject$default$9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeDataStore.class), objArr16, objArr17);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB10 = koinPlatformTools.b();
        final Object[] objArr18 = 0 == true ? 1 : 0;
        final Object[] objArr19 = 0 == true ? 1 : 0;
        this.f108500x = LazyKt.a(lazyThreadSafetyModeB10, new Function0<DiscountDataStore>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$special$$inlined$inject$default$10
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DiscountDataStore.class), objArr18, objArr19);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB11 = koinPlatformTools.b();
        final Object[] objArr20 = 0 == true ? 1 : 0;
        final Object[] objArr21 = 0 == true ? 1 : 0;
        this.f108501y = LazyKt.a(lazyThreadSafetyModeB11, new Function0<StatisticsDataStore>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$special$$inlined$inject$default$11
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StatisticsDataStore.class), objArr20, objArr21);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB12 = koinPlatformTools.b();
        final Object[] objArr22 = 0 == true ? 1 : 0;
        final Object[] objArr23 = 0 == true ? 1 : 0;
        this.f108502z = LazyKt.a(lazyThreadSafetyModeB12, new Function0<TokenFCMRepository>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$special$$inlined$inject$default$12
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(TokenFCMRepository.class), objArr22, objArr23);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB13 = koinPlatformTools.b();
        final Object[] objArr24 = 0 == true ? 1 : 0;
        final Object[] objArr25 = 0 == true ? 1 : 0;
        this.A = LazyKt.a(lazyThreadSafetyModeB13, new Function0<PickTimeNudgeNotificationMessageUseCase>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$special$$inlined$inject$default$13
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PickTimeNudgeNotificationMessageUseCase.class), objArr24, objArr25);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB14 = koinPlatformTools.b();
        final Object[] objArr26 = 0 == true ? 1 : 0;
        final Object[] objArr27 = 0 == true ? 1 : 0;
        this.B = LazyKt.a(lazyThreadSafetyModeB14, new Function0<StrictModeRepository>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$special$$inlined$inject$default$14
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeRepository.class), objArr26, objArr27);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB15 = koinPlatformTools.b();
        final Object[] objArr28 = 0 == true ? 1 : 0;
        final Object[] objArr29 = 0 == true ? 1 : 0;
        this.C = LazyKt.a(lazyThreadSafetyModeB15, new Function0<QuickBlockRepository>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$special$$inlined$inject$default$15
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(QuickBlockRepository.class), objArr28, objArr29);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB16 = koinPlatformTools.b();
        final Object[] objArr30 = 0 == true ? 1 : 0;
        final Object[] objArr31 = 0 == true ? 1 : 0;
        this.D = LazyKt.a(lazyThreadSafetyModeB16, new Function0<SupportJsonParseUseCase>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$special$$inlined$inject$default$16
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(SupportJsonParseUseCase.class), objArr30, objArr31);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB17 = koinPlatformTools.b();
        final Object[] objArr32 = 0 == true ? 1 : 0;
        final Object[] objArr33 = 0 == true ? 1 : 0;
        this.E = LazyKt.a(lazyThreadSafetyModeB17, new Function0<ProfileDao>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$special$$inlined$inject$default$17
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ProfileDao.class), objArr32, objArr33);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB18 = koinPlatformTools.b();
        final Object[] objArr34 = 0 == true ? 1 : 0;
        final Object[] objArr35 = 0 == true ? 1 : 0;
        this.F = LazyKt.a(lazyThreadSafetyModeB18, new Function0<AdultContentWebsiteDao>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$special$$inlined$inject$default$18
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(AdultContentWebsiteDao.class), objArr34, objArr35);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB19 = koinPlatformTools.b();
        final Object[] objArr36 = 0 == true ? 1 : 0;
        final Object[] objArr37 = 0 == true ? 1 : 0;
        this.G = LazyKt.a(lazyThreadSafetyModeB19, new Function0<BlockSessionDao>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$special$$inlined$inject$default$19
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(BlockSessionDao.class), objArr36, objArr37);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB20 = koinPlatformTools.b();
        final Object[] objArr38 = 0 == true ? 1 : 0;
        final Object[] objArr39 = 0 == true ? 1 : 0;
        this.H = LazyKt.a(lazyThreadSafetyModeB20, new Function0<PremiumRepositoryV2>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$special$$inlined$inject$default$20
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PremiumRepositoryV2.class), objArr38, objArr39);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB21 = koinPlatformTools.b();
        final Object[] objArr40 = 0 == true ? 1 : 0;
        final Object[] objArr41 = 0 == true ? 1 : 0;
        this.I = LazyKt.a(lazyThreadSafetyModeB21, new Function0<TrialConversionDataStore>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel$special$$inlined$inject$default$21
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(TrialConversionDataStore.class), objArr40, objArr41);
            }
        });
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass1(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass2(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass3(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass4(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass5(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass6(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass7(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass8(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass9(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass10(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass11(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass12(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass13(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass14(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass15(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass16(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass17(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass18(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass19(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass20(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass21(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass22(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass23(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass24(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass25(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass26(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass27(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass28(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass29(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass30(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass31(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass32(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass33(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass34(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass35(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass36(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass37(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass38(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass39(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass40(null), 3, null);
        G0(new AnonymousClass41(null));
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass42(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass43(null), 3, null);
        j3();
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.i5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DeveloperSettingsViewModel.s1(this.f109144a, (DeveloperSettingsViewState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SupportJsonParseUseCase A2() {
        return (SupportJsonParseUseCase) this.D.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TokenFCMRepository B2() {
        return (TokenFCMRepository) this.f108502z.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TrialConversionDataStore C2() {
        return (TrialConversionDataStore) this.I.getValue();
    }

    private final void D2(final String str) {
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.k5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DeveloperSettingsViewModel.E2(str, (DeveloperSettingsViewState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeveloperSettingsViewState E2(String str, DeveloperSettingsViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return DeveloperSettingsViewState.b(updateState, null, null, null, null, updateState.i().contains(str) ? SetsKt.minus((Set<? extends String>) updateState.i(), str) : SetsKt.plus((Set<? extends String>) updateState.i(), str), false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, null, -17, 524287, null);
    }

    private final void F2(final String str) {
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.j5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DeveloperSettingsViewModel.G2(this.f109162a, str, (DeveloperSettingsViewState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeveloperSettingsViewState G2(DeveloperSettingsViewModel developerSettingsViewModel, String str, DeveloperSettingsViewState updateState) {
        Set setI;
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        List listI2 = developerSettingsViewModel.i2(str, updateState.c());
        if (StringsKt.p0(str)) {
            setI = updateState.i();
        } else {
            List list = listI2;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((DeveloperSettingsCategory) it.next()).d());
            }
            setI = CollectionsKt.toSet(arrayList);
        }
        return DeveloperSettingsViewState.b(updateState, null, str, null, listI2, setI, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, null, -27, 524287, null);
    }

    private final void H2() {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$mockWeeklyStatisticsDialog$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeveloperSettingsViewState J2(DeveloperSettingsViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, DeveloperSettingsViewState.DeveloperDialogType.ShowStreakSeedDialog, -1, 262143, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeveloperSettingsViewState K2(DeveloperSettingsViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, DeveloperSettingsViewState.DeveloperDialogType.ShowPremiumStateDialog, -1, 262143, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeveloperSettingsViewState L2(DeveloperSettingsViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, DeveloperSettingsViewState.DeveloperDialogType.ShowWhatsNewVersionsDialog, -1, 262143, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeveloperSettingsViewState M2(DeveloperSettingsViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, DeveloperSettingsViewState.DeveloperDialogType.ShowWhatsNewCard, -1, 262143, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeveloperSettingsViewState N2(DeveloperSettingsViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, DeveloperSettingsViewState.DeveloperDialogType.ShowAniaInfoDialog, -1, 262143, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeveloperSettingsViewState O2(DeveloperSettingsViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, DeveloperSettingsViewState.DeveloperDialogType.ShowForceRatingDialogType, -1, 262143, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeveloperSettingsViewState P2(DeveloperSettingsViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, null, -1, 262143, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeveloperSettingsViewState Q2(DeveloperSettingsViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, DeveloperSettingsViewState.DeveloperDialogType.ShowInAppUpdatesMockDialog, -1, 262143, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeveloperSettingsViewState R2(DeveloperSettingsViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, DeveloperSettingsViewState.DeveloperDialogType.ShowRemoteConfigMockDialog, -1, 262143, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeveloperSettingsViewState S2(DeveloperSettingsViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, DeveloperSettingsViewState.DeveloperDialogType.ShowQuestionnaireDialog, -1, 262143, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeveloperSettingsViewState T2(DeveloperSettingsViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, DeveloperSettingsViewState.DeveloperDialogType.ShowTimeChangeLimitDialog, -1, 262143, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeveloperSettingsViewState U2(DeveloperSettingsViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, DeveloperSettingsViewState.DeveloperDialogType.ShowParseSupportJsonDialog, -1, 262143, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeveloperSettingsViewState V2(DeveloperSettingsViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, DeveloperSettingsViewState.DeveloperDialogType.ShowPremiumProductDialog, -1, 262143, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeveloperSettingsViewState W2(DeveloperSettingsViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, null, -1, 262143, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X2() {
        throw new RuntimeException("Test Crash");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeveloperSettingsViewState Y2(DeveloperSettingsViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, DeveloperSettingsViewState.DeveloperDialogType.ShowOnboardingFlowVariantDialog, -1, 262143, null);
    }

    private final List Z1() {
        String id = DeveloperSettingsItemId.StreakToday.getId();
        SettingsItemType settingsItemType = SettingsItemType.Value;
        DeveloperSettingsItem developerSettingsItem = new DeveloperSettingsItem(id, "Today", "Tap to refresh. Status and the blocking time measured from the schedule plan", null, null, null, settingsItemType, 56, null);
        DeveloperSettingsItem developerSettingsItem2 = new DeveloperSettingsItem(DeveloperSettingsItemId.StreakPausesToday.getId(), wgbAZXYjrv.gqCd, "Longer than 15 min, or more than 3, loses the day", null, null, null, settingsItemType, 56, null);
        DeveloperSettingsItem developerSettingsItem3 = new DeveloperSettingsItem(DeveloperSettingsItemId.StreakStoredDays.getId(), "Stored days", null, null, null, null, settingsItemType, 60, null);
        String id2 = DeveloperSettingsItemId.StreakSeed.getId();
        SettingsItemType settingsItemType2 = SettingsItemType.Action;
        DeveloperSettingsCategory developerSettingsCategory = new DeveloperSettingsCategory("streaks", "Streaks", null, CollectionsKt.listOf((Object[]) new DeveloperSettingsItem[]{developerSettingsItem, developerSettingsItem2, developerSettingsItem3, new DeveloperSettingsItem(id2, "Seed a streak history", "Type a pattern (3o,l,3o) or a plain number of days — starts yesterday, going back", null, null, null, settingsItemType2, 56, null), new DeveloperSettingsItem(DeveloperSettingsItemId.StreakAddActivity.getId(), "Add 30 min of blocking to today", null, null, null, null, settingsItemType2, 60, null), new DeveloperSettingsItem(DeveloperSettingsItemId.StreakRunCatchUp.getId(), "Run catch-up now", "Finalizes every past day that is still open", null, null, null, settingsItemType2, 56, null), new DeveloperSettingsItem(DeveloperSettingsItemId.StreakOpenMilestone.getId(), "Open the milestone screen", "Uses the seeded streak length. Says so if no streak is running", null, null, null, settingsItemType2, 56, null), new DeveloperSettingsItem(DeveloperSettingsItemId.StreakOpenIntroduction.getId(), "Open the What's New introduction", "The one-off Meet Streaks screen. Ignores whether it has been shown already", null, null, null, settingsItemType2, 56, null), new DeveloperSettingsItem(DeveloperSettingsItemId.StreakShowBanner.getId(), "Show the banner on the Blocking tab", "Reopens today for the streak already seeded, and concedes any milestone so the banner wins. Then open the Blocking tab", null, null, null, settingsItemType2, 56, null), new DeveloperSettingsItem(DeveloperSettingsItemId.StreakSendAchievement.getId(), "Send the milestone notification now", "The morning congratulation. Obeys the rules, so a milestone must be due", null, null, null, settingsItemType2, 56, null), new DeveloperSettingsItem(DeveloperSettingsItemId.StreakSendNudge.getId(), "Send the daily reminder now", "Skips the 22:00 schedule, but still obeys the rules that decide whether it is due", null, null, null, settingsItemType2, 56, null), new DeveloperSettingsItem(DeveloperSettingsItemId.StreakPresentationState.getId(), "Presentation state", "Why the Blocking tab shows a milestone, a banner, or nothing", null, null, null, settingsItemType, 56, null), new DeveloperSettingsItem(DeveloperSettingsItemId.StreakResetPresentation.getId(), "Allow another presentation today", "Clears today's evaluation and the celebrated milestones, so one can show again", null, null, null, settingsItemType2, 56, null), new DeveloperSettingsItem(DeveloperSettingsItemId.StreakUpload.getId(), "Upload the streak to the server", "Sends what this device counted and reports back what the server stored. Restoring happens on sign-in", null, null, null, settingsItemType2, 56, null), new DeveloperSettingsItem(DeveloperSettingsItemId.StreakClear.getId(), "Clear all streak data", "Days, sessions, pauses and flags. Schedules are left alone", null, null, null, settingsItemType2, 56, null)}), false, false, 52, null);
        String strD0 = D0(R.string.P9);
        String id3 = DeveloperSettingsItemId.UseProductionServer.getId();
        String strD02 = D0(R.string.Kb);
        SettingsItemType settingsItemType3 = SettingsItemType.Toggle;
        DeveloperSettingsCategory developerSettingsCategory2 = new DeveloperSettingsCategory("server_network", strD0, null, CollectionsKt.listOf((Object[]) new DeveloperSettingsItem[]{new DeveloperSettingsItem(id3, strD02, null, null, null, null, settingsItemType3, 60, null), new DeveloperSettingsItem(DeveloperSettingsItemId.EnableInternet.getId(), D0(R.string.Y9), null, null, null, null, settingsItemType3, 60, null), new DeveloperSettingsItem(DeveloperSettingsItemId.SpeedUpTimers.getId(), D0(R.string.yb), D0(R.string.zb), null, null, null, settingsItemType3, 56, null)}), false, false, 52, null);
        String strD03 = D0(R.string.O9);
        DeveloperSettingsItem developerSettingsItem4 = new DeveloperSettingsItem(DeveloperSettingsItemId.PremiumState.getId(), D0(R.string.Ga), null, null, null, null, settingsItemType, 60, null);
        DeveloperSettingsItem developerSettingsItem5 = new DeveloperSettingsItem(DeveloperSettingsItemId.PremiumProduct.getId(), D0(R.string.Fa), null, null, null, null, settingsItemType, 60, null);
        DeveloperSettingsItem developerSettingsItem6 = new DeveloperSettingsItem(DeveloperSettingsItemId.RemovePremium.getId(), D0(R.string.Xa), null, null, null, null, settingsItemType2, 60, null);
        DeveloperSettingsItem developerSettingsItem7 = new DeveloperSettingsItem(DeveloperSettingsItemId.ActivateCampaign.getId(), D0(R.string.K9), null, null, null, null, settingsItemType2, 60, null);
        DeveloperSettingsItem developerSettingsItem8 = new DeveloperSettingsItem(DeveloperSettingsItemId.OfferLifetime.getId(), D0(R.string.ra), null, null, null, null, settingsItemType3, 60, null);
        DeveloperSettingsItem developerSettingsItem9 = new DeveloperSettingsItem(DeveloperSettingsItemId.TrialAlwaysEligible.getId(), D0(R.string.Gb), D0(R.string.Hb), null, null, null, settingsItemType3, 56, null);
        DeveloperSettingsItem developerSettingsItem10 = new DeveloperSettingsItem(DeveloperSettingsItemId.SimulateActiveTrial.getId(), D0(R.string.tb), D0(R.string.ub), null, null, null, settingsItemType3, 56, null);
        DeveloperSettingsItem developerSettingsItem11 = new DeveloperSettingsItem(DeveloperSettingsItemId.SimulateBillingError.getId(), D0(R.string.vb), null, null, null, null, settingsItemType3, 60, null);
        String id4 = DeveloperSettingsItemId.SubscriptionOnboardingTest.getId();
        String strD04 = D0(R.string.kC);
        SettingsItemType settingsItemType4 = SettingsItemType.Navigation;
        return CollectionsKt.listOf((Object[]) new DeveloperSettingsCategory[]{developerSettingsCategory, developerSettingsCategory2, new DeveloperSettingsCategory("premium_billing", strD03, null, CollectionsKt.listOf((Object[]) new DeveloperSettingsItem[]{developerSettingsItem4, developerSettingsItem5, developerSettingsItem6, developerSettingsItem7, developerSettingsItem8, developerSettingsItem9, developerSettingsItem10, developerSettingsItem11, new DeveloperSettingsItem(id4, strD04, null, null, null, null, settingsItemType4, 60, null), new DeveloperSettingsItem(DeveloperSettingsItemId.OverridePaywallSettings.getId(), D0(R.string.Ca), null, null, null, null, settingsItemType2, 60, null), new DeveloperSettingsItem(DeveloperSettingsItemId.TestTargetingGroup.getId(), "Test targeting group", "Sends the custom attribute test_targeting_group to RevenueCat. Empty = not sent.", null, null, CollectionsKt.listOf((Object[]) new String[]{"revenuecat", "targeting", "attribute", "audience", "paywall", "test"}), settingsItemType, 24, null), new DeveloperSettingsItem(DeveloperSettingsItemId.OpenDiscountScreen.getId(), D0(R.string.Om), null, null, null, null, settingsItemType2, 60, null)}), false, false, 52, null), new DeveloperSettingsCategory("tokens_ids", D0(R.string.Q9), null, CollectionsKt.listOf((Object[]) new DeveloperSettingsItem[]{new DeveloperSettingsItem(DeveloperSettingsItemId.FcmToken.getId(), D0(R.string.Z9), null, null, null, null, settingsItemType, 60, null), new DeveloperSettingsItem(DeveloperSettingsItemId.RevenueCatId.getId(), D0(R.string.eb), null, null, null, null, settingsItemType, 60, null), new DeveloperSettingsItem(DeveloperSettingsItemId.CustomerId.getId(), D0(R.string.V9), null, null, null, null, settingsItemType, 60, null)}), false, false, 52, null), new DeveloperSettingsCategory("ui_features", "UI & Feature Flags", null, CollectionsKt.listOf((Object[]) new DeveloperSettingsItem[]{new DeveloperSettingsItem(DeveloperSettingsItemId.ShowAdsState.getId(), D0(R.string.gb), null, null, null, null, settingsItemType, 60, null), new DeveloperSettingsItem(DeveloperSettingsItemId.SkipDiscountTimer.getId(), D0(R.string.wb), D0(R.string.xb), null, null, null, settingsItemType, 56, null), new DeveloperSettingsItem(DeveloperSettingsItemId.ShowAllDiscounts.getId(), D0(R.string.ib), null, null, null, null, settingsItemType, 60, null), new DeveloperSettingsItem(DeveloperSettingsItemId.ResetDiscountOffers.getId(), D0(R.string.Ya), D0(R.string.Za), null, null, null, settingsItemType2, 56, null), new DeveloperSettingsItem(DeveloperSettingsItemId.ShowWhatsNewFlow.getId(), D0(R.string.sb), null, null, null, null, settingsItemType2, 60, null), new DeveloperSettingsItem(DeveloperSettingsItemId.WhatsNewCard.getId(), D0(R.string.Lb), null, null, null, null, settingsItemType, 60, null), new DeveloperSettingsItem(DeveloperSettingsItemId.ShowAniaInfoDialog.getId(), D0(R.string.lb), null, null, null, null, settingsItemType, 60, null), new DeveloperSettingsItem(DeveloperSettingsItemId.ShowPirateVersionSheet.getId(), D0(R.string.pb), null, null, null, null, settingsItemType3, 60, null), new DeveloperSettingsItem(DeveloperSettingsItemId.UseNewPaywall.getId(), D0(R.string.Jb), null, null, null, null, settingsItemType3, 60, null), new DeveloperSettingsItem(DeveloperSettingsItemId.ShowAllTrendItems.getId(), D0(R.string.jb), D0(R.string.kb), null, null, null, settingsItemType3, 56, null), new DeveloperSettingsItem(DeveloperSettingsItemId.ShowPremiumExpiring.getId(), D0(R.string.hx), null, null, null, null, settingsItemType3, 60, null), new DeveloperSettingsItem(DeveloperSettingsItemId.ShowPremiumExpiringCards.getId(), D0(R.string.gx), null, null, null, null, settingsItemType3, 60, null)}), false, false, 52, null), new DeveloperSettingsCategory("mocking_testing", "Mocking & Testing", null, CollectionsKt.listOf((Object[]) new DeveloperSettingsItem[]{new DeveloperSettingsItem(DeveloperSettingsItemId.UseFakeReviewManager.getId(), "Use FakeReviewManager", "Uses FakeReviewManager for testing In-App Review on emulators", null, null, CollectionsKt.listOf((Object[]) new String[]{"review", "rating", "fake", "mock", "google play"}), settingsItemType3, 24, null), new DeveloperSettingsItem(DeveloperSettingsItemId.ForceRatingDialog.getId(), "Force Rating Dialog", "Shows rating dialog on every lock screen close, bypassing all checks", null, null, CollectionsKt.listOf((Object[]) new String[]{"rating", "dialog", "force", "lock screen", "review"}), settingsItemType, 24, null), new DeveloperSettingsItem(DeveloperSettingsItemId.MockWeeklyStatsNotification.getId(), D0(R.string.Wj), null, null, null, null, settingsItemType2, 60, null), new DeveloperSettingsItem(DeveloperSettingsItemId.MockDailyInsights.getId(), D0(R.string.Rj), null, null, null, null, settingsItemType2, 60, null), new DeveloperSettingsItem(DeveloperSettingsItemId.MockTrialExpiringNotification.getId(), D0(R.string.Uj), null, null, null, null, settingsItemType2, 60, null), new DeveloperSettingsItem(DeveloperSettingsItemId.MockTrialConvReminderNotification.getId(), "Mock trial conversion reminder notification", "Shows the T-3d payment reminder now, bypassing the kill switch, the guard and the job", null, null, CollectionsKt.listOf((Object[]) new String[]{"trial", "conversion", "reminder", "notification", "payment", "guard"}), settingsItemType2, 24, null), new DeveloperSettingsItem(DeveloperSettingsItemId.MockTrialConvFailedNotification.getId(), "Mock trial conversion failed notification", "Shows the failed-payment notification for the watched trial's SKU, or the active subscription's", null, null, CollectionsKt.listOf((Object[]) new String[]{"trial", "conversion", "failed", "payment", "notification", "guard"}), settingsItemType2, 24, null), new DeveloperSettingsItem(DeveloperSettingsItemId.MockWeeklyStatsScreen.getId(), D0(R.string.Xj), null, null, null, null, settingsItemType4, 60, null), new DeveloperSettingsItem(DeveloperSettingsItemId.MockWeeklyStatsDialog.getId(), D0(R.string.Vj), null, null, null, null, settingsItemType2, 60, null), new DeveloperSettingsItem(DeveloperSettingsItemId.MockPremiumExpiringScreen.getId(), D0(R.string.Sj), null, null, null, null, settingsItemType4, 60, null), new DeveloperSettingsItem(DeveloperSettingsItemId.MockTrialComparisonData.getId(), D0(R.string.Tj), null, null, null, null, settingsItemType3, 60, null), new DeveloperSettingsItem(DeveloperSettingsItemId.InAppUpdatesMock.getId(), D0(R.string.da), null, null, null, null, settingsItemType, 60, null), new DeveloperSettingsItem(DeveloperSettingsItemId.RemoteConfigMock.getId(), D0(R.string.Oa), null, null, null, null, settingsItemType, 60, null), new DeveloperSettingsItem(DeveloperSettingsItemId.ForceLoadingDelay.getId(), "Force loading delay (10s)", null, null, null, null, settingsItemType3, 60, null), new DeveloperSettingsItem(DeveloperSettingsItemId.GenerateFakeInsightsData.getId(), "Generate fake insights data", "Seeds 7 months of usage for apps in the DB. App will restart when done.", null, null, CollectionsKt.listOf((Object[]) new String[]{YvFRmou.YVPVQoBHpiffgq, "stats", "fake", Keys.SEED, "test data", "statistics"}), settingsItemType2, 24, null)}), false, false, 52, null), new DeveloperSettingsCategory("configuration_data", "Configuration & Data", null, CollectionsKt.listOf((Object[]) new DeveloperSettingsItem[]{new DeveloperSettingsItem(DeveloperSettingsItemId.RemoteConfigValues.getId(), D0(R.string.Qa), D0(R.string.Ta), null, null, null, settingsItemType4, 56, null), new DeveloperSettingsItem(DeveloperSettingsItemId.QuestionnaireConfig.getId(), D0(R.string.La), null, null, null, null, settingsItemType, 60, null), new DeveloperSettingsItem(DeveloperSettingsItemId.TimeChangeLimit.getId(), D0(R.string.Bb), null, null, null, null, settingsItemType, 60, null), new DeveloperSettingsItem(DeveloperSettingsItemId.ParseSupportJson.getId(), D0(R.string.tn), null, null, null, null, settingsItemType2, 60, null), new DeveloperSettingsItem(DeveloperSettingsItemId.ParseSupportJsonFile.getId(), D0(R.string.un), null, null, null, null, settingsItemType2, 60, null), new DeveloperSettingsItem(DeveloperSettingsItemId.ClearStrictMode.getId(), D0(R.string.T9), null, null, null, null, settingsItemType2, 60, null), new DeveloperSettingsItem(DeveloperSettingsItemId.ClearStrictModeOnboarding.getId(), D0(R.string.U9), null, null, null, null, settingsItemType2, 60, null), new DeveloperSettingsItem(DeveloperSettingsItemId.ResetQuickBlock.getId(), D0(R.string.ys), null, null, null, null, settingsItemType2, 60, null), new DeveloperSettingsItem(DeveloperSettingsItemId.ClearAdultContent.getId(), D0(R.string.S9), null, null, null, null, settingsItemType2, 60, null), new DeveloperSettingsItem(DeveloperSettingsItemId.ResetStrictModeUpsell.getId(), D0(R.string.ab), null, null, null, null, settingsItemType2, 60, null), new DeveloperSettingsItem(DeveloperSettingsItemId.ResetUnlockAllAppsTimer.getId(), D0(R.string.bb), null, null, null, null, settingsItemType2, 60, null), new DeveloperSettingsItem(DeveloperSettingsItemId.AlwaysShowEmailConsent.getId(), D0(R.string.L9), null, null, null, null, settingsItemType3, 60, null)}), false, false, 52, null), new DeveloperSettingsCategory("security_access", "Security & Access", null, CollectionsKt.listOf((Object[]) new DeveloperSettingsItem[]{new DeveloperSettingsItem(DeveloperSettingsItemId.GenerateBackdoorCode.getId(), D0(R.string.ca), null, null, null, null, settingsItemType2, 60, null), new DeveloperSettingsItem(DeveloperSettingsItemId.DisableBackdoorCodeCheck.getId(), D0(R.string.C2), null, null, null, null, settingsItemType3, 60, null), new DeveloperSettingsItem(DeveloperSettingsItemId.AlwaysValidateEmergencyString.getId(), D0(R.string.M9), null, null, null, null, settingsItemType3, 60, null)}), false, false, 52, null), new DeveloperSettingsCategory("dev_tools", D0(R.string.R9), null, CollectionsKt.listOf((Object[]) new DeveloperSettingsItem[]{new DeveloperSettingsItem(DeveloperSettingsItemId.ListBrowsers.getId(), D0(R.string.oa), null, null, null, null, settingsItemType4, 60, null), new DeveloperSettingsItem(DeveloperSettingsItemId.ShowAdsInspector.getId(), D0(R.string.hb), null, null, null, null, settingsItemType2, 60, null), new DeveloperSettingsItem(DeveloperSettingsItemId.ShowEventsBubble.getId(), D0(R.string.ex), null, null, null, null, settingsItemType2, 60, null), new DeveloperSettingsItem(DeveloperSettingsItemId.ShowChatbot.getId(), D0(R.string.nb), null, null, null, null, settingsItemType4, 60, null), new DeveloperSettingsItem(DeveloperSettingsItemId.PerformFatalCrash.getId(), D0(R.string.Da), null, null, null, null, settingsItemType2, 60, null), new DeveloperSettingsItem(DeveloperSettingsItemId.LogLockService.getId(), D0(R.string.zj), null, null, null, null, settingsItemType3, 60, null), new DeveloperSettingsItem(DeveloperSettingsItemId.PomodoroInSeconds.getId(), D0(R.string.po), null, null, null, null, settingsItemType3, 60, null), new DeveloperSettingsItem(DeveloperSettingsItemId.StrictModePauseInSeconds.getId(), D0(R.string.QB), null, null, null, null, settingsItemType3, 60, null), new DeveloperSettingsItem(DeveloperSettingsItemId.TimeNudgeShortIntervals.getId(), D0(R.string.Cb), D0(R.string.Db), null, null, null, settingsItemType3, 56, null), new DeveloperSettingsItem(DeveloperSettingsItemId.TriggerTimeNudge.getId(), D0(R.string.Ib), null, null, null, null, settingsItemType2, 60, null)}), false, false, 52, null), new DeveloperSettingsCategory("permissions", D0(R.string.Ea), null, CollectionsKt.listOf((Object[]) new DeveloperSettingsItem[]{new DeveloperSettingsItem(DeveloperSettingsItemId.OpenAccessibilitySettings.getId(), D0(R.string.sa), null, D0(R.string.ta), null, null, settingsItemType2, 52, null), new DeveloperSettingsItem(DeveloperSettingsItemId.OpenOverlaySettings.getId(), D0(R.string.ya), null, D0(R.string.za), null, null, settingsItemType2, 52, null), new DeveloperSettingsItem(DeveloperSettingsItemId.OpenUsageSettings.getId(), D0(R.string.Aa), null, D0(R.string.Ba), null, null, settingsItemType2, 52, null), new DeveloperSettingsItem(DeveloperSettingsItemId.OpenNotificationAccessSettings.getId(), D0(R.string.wa), null, D0(R.string.xa), null, null, settingsItemType2, 52, null), new DeveloperSettingsItem(DeveloperSettingsItemId.OpenAppSettings.getId(), D0(R.string.ua), null, D0(R.string.va), null, null, settingsItemType2, 52, null), new DeveloperSettingsItem(DeveloperSettingsItemId.RemoveDeviceAdmin.getId(), D0(R.string.Va), null, D0(R.string.Wa), null, null, settingsItemType2, 52, null)}), false, false, 52, null), new DeveloperSettingsCategory("onboarding_flows", "Onboarding & Flows", null, CollectionsKt.listOf((Object[]) new DeveloperSettingsItem[]{new DeveloperSettingsItem(DeveloperSettingsItemId.LaunchOnboarding.getId(), D0(R.string.ma), D0(R.string.na), null, null, CollectionsKt.listOf((Object[]) new String[]{"onboarding", "flow", "variant", "early paywall"}), settingsItemType2, 24, null), new DeveloperSettingsItem(DeveloperSettingsItemId.ShowIntro.getId(), D0(R.string.ob), null, null, null, null, settingsItemType, 60, null), new DeveloperSettingsItem(DeveloperSettingsItemId.ShowAppFeelOnboarding.getId(), D0(R.string.mb), null, null, null, null, settingsItemType4, 60, null), new DeveloperSettingsItem(DeveloperSettingsItemId.ShowTrialRemindersFlow.getId(), D0(R.string.rb), null, null, null, null, settingsItemType4, 60, null), new DeveloperSettingsItem(DeveloperSettingsItemId.ShowRatingDialogFlow.getId(), D0(R.string.qb), null, null, null, CollectionsKt.listOf((Object[]) new String[]{"rating", "review", "dialog", "flow", "google play", "in-app review"}), settingsItemType4, 28, null)}), false, false, 52, null), new DeveloperSettingsCategory("premium_screens", "Premium Screens", null, CollectionsKt.listOf((Object[]) new DeveloperSettingsItem[]{new DeveloperSettingsItem(DeveloperSettingsItemId.OpenAutoTrialFlow.getId(), "Auto Trial Flow", "Auto-activated monthly trial flow", null, null, CollectionsKt.listOf((Object[]) new String[]{"auto", "trial", "monthly", "premium", "flow"}), settingsItemType4, 24, null), new DeveloperSettingsItem(DeveloperSettingsItemId.ForceAutoTrialExpired.getId(), "Force Auto-Trial Expired (Variant B)", CbYNFSEGaQj.mncaHogPcltjT, null, null, CollectionsKt.listOf((Object[]) new String[]{"auto", "trial", "expired", "notification", "paywall", "variant b"}), settingsItemType3, 24, null), new DeveloperSettingsItem(DeveloperSettingsItemId.ForceAutoTrialExpiredCard.getId(), "Force Auto-Trial Expired (Variant C)", "On: forces the expired card + retention flow on dashboard/profile. Off: cancels it.", null, null, CollectionsKt.listOf((Object[]) new String[]{"auto", "trial", "expired", "card", "retention", "variant c"}), settingsItemType3, 24, null), new DeveloperSettingsItem(DeveloperSettingsItemId.ShortenAutoTrialWait.getId(), "Shorten Auto-Trial Wait", "On: eligibility waiting time 6 months → 3 min (testing).", null, null, CollectionsKt.listOf((Object[]) new String[]{"auto", "trial", "wait", "eligibility", "shorten", "3 min"}), settingsItemType3, 24, null), new DeveloperSettingsItem(DeveloperSettingsItemId.OpenIntroTrialPremium.getId(), "Intro Trial Premium", "trialHeadsUp", null, null, CollectionsKt.listOf((Object[]) new String[]{"intro", "trial", "premium", "paywall"}), settingsItemType4, 24, null), new DeveloperSettingsItem(DeveloperSettingsItemId.OpenTrialRetentionPremium.getId(), "Trial Retention Premium", "trialRetention", null, null, CollectionsKt.listOf((Object[]) new String[]{"trial", "retention", "premium", "paywall"}), settingsItemType4, 24, null), new DeveloperSettingsItem(DeveloperSettingsItemId.OpenGenericPremium.getId(), "Generic Premium", ConstantsKt.DONT_KILL_MY_APP_FALLBACK_MANUFACTURER, null, null, CollectionsKt.listOf((Object[]) new String[]{"generic", "premium", "paywall"}), settingsItemType4, 24, null), new DeveloperSettingsItem(DeveloperSettingsItemId.OpenDiscountPremium.getId(), "Discount Premium 20 %", "discount20", null, null, CollectionsKt.listOf((Object[]) new String[]{"discount", "premium", "paywall"}), settingsItemType4, 24, null), new DeveloperSettingsItem(DeveloperSettingsItemId.OpenDiscountPremium30.getId(), "Discount Premium 30 %", "discount30", null, null, CollectionsKt.listOf((Object[]) new String[]{"discount", "premium", "paywall"}), settingsItemType4, 24, null), new DeveloperSettingsItem(DeveloperSettingsItemId.OpenDiscountPremium50.getId(), "Discount Premium 50 %", "discount50", null, null, CollectionsKt.listOf((Object[]) new String[]{"discount", "premium", "paywall"}), settingsItemType4, 24, null), new DeveloperSettingsItem(DeveloperSettingsItemId.OpenExpiredSubPremium.getId(), "Expired Sub Premium", "renewPremium", null, null, CollectionsKt.listOf((Object[]) new String[]{"expired", "subscription", "premium", "paywall"}), settingsItemType4, 24, null), new DeveloperSettingsItem(DeveloperSettingsItemId.OpenProductPlanPremium.getId(), "Product Plan Premium", null, null, null, CollectionsKt.listOf((Object[]) new String[]{AppLovinEventTypes.USER_VIEWED_PRODUCT, "plan", "premium", "paywall"}), settingsItemType4, 28, null), new DeveloperSettingsItem(DeveloperSettingsItemId.OpenLimitScreenPremium.getId(), "Limit Screen Premium", "limitScreen", null, null, CollectionsKt.listOf((Object[]) new String[]{"limit", "screen", "premium", "paywall"}), settingsItemType4, 24, null), new DeveloperSettingsItem(DeveloperSettingsItemId.OpenExpiredSubDiscountPremium.getId(), "Expired Sub Discount Premium", "premiumRetention", null, null, CollectionsKt.listOf((Object[]) new String[]{"expired", "subscription", "discount", "premium", "paywall"}), settingsItemType4, 24, null), new DeveloperSettingsItem(DeveloperSettingsItemId.OpenIntroTrialTogglePremium.getId(), "Intro Trial Toggle Premium", "trial_toggle", null, null, CollectionsKt.listOf((Object[]) new String[]{"intro", "trial", "toggle", "premium", "paywall"}), settingsItemType4, 24, null), new DeveloperSettingsItem(DeveloperSettingsItemId.OpenOneTimeToSubPremium.getId(), "One Time To Sub Premium", "onetimeToSub", null, null, CollectionsKt.listOf((Object[]) new String[]{"one time", "subscription", "premium", "paywall", "onetimetosub"}), settingsItemType4, 24, null), new DeveloperSettingsItem(DeveloperSettingsItemId.OpenDiscountPremiumReferralSender.getId(), "Discount Premium (Referral Sender)", "referralSent", null, null, CollectionsKt.listOf((Object[]) new String[]{"discount", "referral", "sender", "premium", "paywall"}), settingsItemType4, 24, null), new DeveloperSettingsItem(DeveloperSettingsItemId.OpenDiscountPremiumReferralReceiver.getId(), "Discount Premium (Referral Receiver)", "referralReceived", null, null, CollectionsKt.listOf((Object[]) new String[]{"discount", "referral", "receiver", "premium", "paywall"}), settingsItemType4, 24, null), new DeveloperSettingsItem(DeveloperSettingsItemId.OpenCampaignPremium.getId(), "Campaign Premium", null, null, null, CollectionsKt.listOf((Object[]) new String[]{"campaign", "premium", "paywall"}), settingsItemType4, 28, null)}), false, false, 52, null)});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeveloperSettingsViewState Z2(DeveloperSettingsViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, null, -1, 262143, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a2() {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$clearAdultContent$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeveloperSettingsViewState a3(DeveloperSettingsViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, DeveloperSettingsViewState.DeveloperDialogType.ShowActivateCampaignDialog, -1, 262143, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x012f, code lost:
    
        if (cz.mobilesoft.coreblock.repository.StrictModeRepository.g(r11, false, r0, 1, null) != r1) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c0 A[PHI: r2 r7 r8
      0x00c0: PHI (r2v5 int) = (r2v3 int), (r2v6 int) binds: [B:24:0x00bc, B:17:0x0077] A[DONT_GENERATE, DONT_INLINE]
      0x00c0: PHI (r7v4 cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore) = 
      (r7v1 cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore)
      (r7v6 cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore)
     binds: [B:24:0x00bc, B:17:0x0077] A[DONT_GENERATE, DONT_INLINE]
      0x00c0: PHI (r8v4 cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore) = 
      (r8v1 cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore)
      (r8v6 cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore)
     binds: [B:24:0x00bc, B:17:0x0077] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d6 A[PHI: r2 r7 r8
      0x00d6: PHI (r2v7 int) = (r2v5 int), (r2v8 int) binds: [B:27:0x00d3, B:16:0x0069] A[DONT_GENERATE, DONT_INLINE]
      0x00d6: PHI (r7v7 cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore) = 
      (r7v4 cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore)
      (r7v9 cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore)
     binds: [B:27:0x00d3, B:16:0x0069] A[DONT_GENERATE, DONT_INLINE]
      0x00d6: PHI (r8v7 cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore) = 
      (r8v4 cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore)
      (r8v9 cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore)
     binds: [B:27:0x00d3, B:16:0x0069] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ea A[PHI: r2 r7 r8
      0x00ea: PHI (r2v9 int) = (r2v7 int), (r2v10 int) binds: [B:30:0x00e7, B:15:0x005a] A[DONT_GENERATE, DONT_INLINE]
      0x00ea: PHI (r7v10 cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore) = 
      (r7v7 cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore)
      (r7v12 cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore)
     binds: [B:30:0x00e7, B:15:0x005a] A[DONT_GENERATE, DONT_INLINE]
      0x00ea: PHI (r8v10 cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore) = 
      (r8v7 cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore)
      (r8v12 cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore)
     binds: [B:30:0x00e7, B:15:0x005a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00fc A[PHI: r2 r7 r8
      0x00fc: PHI (r2v11 int) = (r2v9 int), (r2v12 int) binds: [B:33:0x00f9, B:14:0x004b] A[DONT_GENERATE, DONT_INLINE]
      0x00fc: PHI (r7v13 cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore) = 
      (r7v10 cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore)
      (r7v15 cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore)
     binds: [B:33:0x00f9, B:14:0x004b] A[DONT_GENERATE, DONT_INLINE]
      0x00fc: PHI (r8v13 cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore) = 
      (r8v10 cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore)
      (r8v15 cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore)
     binds: [B:33:0x00f9, B:14:0x004b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b2(kotlin.coroutines.Continuation r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 330
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewModel.b2(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeveloperSettingsViewState b3(DeveloperSettingsViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, DeveloperSettingsViewState.DeveloperDialogType.ShowAdsDialog, -1, 262143, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c2() {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$clearStrictModeOnboarding$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeveloperSettingsViewState c3(DeveloperSettingsViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, DeveloperSettingsViewState.DeveloperDialogType.ShowSkipDiscountTimerDialog, -1, 262143, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d2() {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$clearStrictModeUpsellDialog$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeveloperSettingsViewState d3(DeveloperSettingsViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, DeveloperSettingsViewState.DeveloperDialogType.OverridePaywallSettings, -1, 262143, null);
    }

    private final void e2() {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$copyCustomerId$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeveloperSettingsViewState e3(DeveloperSettingsViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, DeveloperSettingsViewState.DeveloperDialogType.ShowTestTargetingGroupDialog, -1, 262143, null);
    }

    private final void f2() {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$copyFCMToken$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeveloperSettingsViewState f3(DeveloperSettingsViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, DeveloperSettingsViewState.DeveloperDialogType.ShowAllDiscountsDialog, -1, 262143, null);
    }

    private final void g2() {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$copyRevenueCatId$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeveloperSettingsViewState g3(DeveloperSettingsViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return DeveloperSettingsViewState.b(updateState, null, null, null, null, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, DeveloperSettingsViewState.DeveloperDialogType.ShowIntroDialog, -1, 262143, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h2(String str, String str2) {
        ContextExtKt.a(A0(), str, str2);
        String str3 = str + ": " + str2;
        String simpleName = DeveloperSettingsViewModel.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        Log.i(simpleName, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h3(String str) {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$parseSupportJson$1(this, str, null), 3, null);
    }

    private final List i2(String str, List list) {
        String strD;
        if (StringsKt.p0(str)) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            DeveloperSettingsCategory developerSettingsCategory = (DeveloperSettingsCategory) it.next();
            List listE = developerSettingsCategory.e();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : listE) {
                DeveloperSettingsItem developerSettingsItem = (DeveloperSettingsItem) obj;
                if (!StringsKt.Y(developerSettingsItem.e(), str, true) && ((strD = developerSettingsItem.d()) == null || !StringsKt.Y(strD, str, true))) {
                    List listC = developerSettingsItem.c();
                    if (!(listC instanceof Collection) || !listC.isEmpty()) {
                        Iterator it2 = listC.iterator();
                        while (it2.hasNext()) {
                            if (StringsKt.Y((String) it2.next(), str, true)) {
                            }
                        }
                    }
                }
                arrayList2.add(obj);
            }
            DeveloperSettingsCategory developerSettingsCategoryB = !arrayList2.isEmpty() ? DeveloperSettingsCategory.b(developerSettingsCategory, null, null, null, arrayList2, false, true, 23, null) : StringsKt.Y(developerSettingsCategory.f(), str, true) ? DeveloperSettingsCategory.b(developerSettingsCategory, null, null, null, null, false, true, 31, null) : null;
            if (developerSettingsCategoryB != null) {
                arrayList.add(developerSettingsCategoryB);
            }
        }
        return arrayList;
    }

    private final void i3(Uri uri) {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$parseSupportJsonFile$1(this, uri, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AdultContentWebsiteDao j2() {
        return (AdultContentWebsiteDao) this.F.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j3() {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$refreshStreakSnapshot$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BlockSessionDao k2() {
        return (BlockSessionDao) this.G.getValue();
    }

    private final void k3() {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$resetQuickBlock$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoreDataStore l2() {
        return (CoreDataStore) this.f108498v.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DiscountDataStore n2() {
        return (DiscountDataStore) this.f108500x.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PickTimeNudgeNotificationMessageUseCase o2() {
        return (PickTimeNudgeNotificationMessageUseCase) this.A.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PremiumRepositoryV2 p2() {
        return (PremiumRepositoryV2) this.H.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProfileDao q2() {
        return (ProfileDao) this.E.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QuickBlockRepository r2() {
        return (QuickBlockRepository) this.C.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeveloperSettingsViewState s1(DeveloperSettingsViewModel developerSettingsViewModel, DeveloperSettingsViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        List listZ1 = developerSettingsViewModel.Z1();
        return DeveloperSettingsViewState.b(updateState, null, null, listZ1, listZ1, null, false, false, false, null, null, false, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, null, null, null, false, false, null, 0L, false, false, false, false, false, false, false, false, null, -13, 524287, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StatisticsDataStore s2() {
        return (StatisticsDataStore) this.f108501y.getValue();
    }

    private final StrictModeRepository t0() {
        return (StrictModeRepository) this.B.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StreakAchievementNotificationPlanner t2() {
        return (StreakAchievementNotificationPlanner) this.f108495s.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StreakDataStore u2() {
        return (StreakDataStore) this.f108494r.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StreakDebugHelper v2() {
        return (StreakDebugHelper) this.f108492p.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StreakNudgePlanner w2() {
        return (StreakNudgePlanner) this.f108496t.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StreakSnapshotSync x2() {
        return (StreakSnapshotSync) this.f108497u.getValue();
    }

    public static final /* synthetic */ DeveloperSettingsViewState y1(DeveloperSettingsViewModel developerSettingsViewModel) {
        return (DeveloperSettingsViewState) developerSettingsViewModel.I0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StreakStore y2() {
        return (StreakStore) this.f108493q.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StrictModeDataStore z2() {
        return (StrictModeDataStore) this.f108499w.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: I2, reason: merged with bridge method [inline-methods] */
    public void O0(DeveloperSettingsViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof DeveloperSettingsViewEvent.OnSearchQueryChanged) {
            F2(((DeveloperSettingsViewEvent.OnSearchQueryChanged) event).a());
            Unit unit = Unit.f139807a;
            return;
        }
        if (event instanceof DeveloperSettingsViewEvent.OnCategoryExpandToggled) {
            D2(((DeveloperSettingsViewEvent.OnCategoryExpandToggled) event).a());
            Unit unit2 = Unit.f139807a;
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnStreakRefreshClicked.f108467a)) {
            j3();
            Unit unit3 = Unit.f139807a;
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnStreakSeedClicked.f108470a)) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.s4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DeveloperSettingsViewModel.J2((DeveloperSettingsViewState) obj);
                }
            });
            Unit unit4 = Unit.f139807a;
            return;
        }
        if (event instanceof DeveloperSettingsViewEvent.OnStreakSeedPatternEntered) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$2(this, event, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnStreakSendAchievementClicked.f108472a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$3(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnStreakAddActivityClicked.f108463a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$4(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnStreakRunCatchUpClicked.f108469a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$5(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnStreakUploadClicked.f108475a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$6(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnStreakSendNudgeClicked.f108473a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$7(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnStreakOpenMilestoneClicked.f108466a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$8(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnStreakOpenIntroductionClicked.f108465a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$9(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnStreakShowBannerClicked.f108474a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$10(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnStreakResetPresentationClicked.f108468a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$11(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnStreakClearClicked.f108464a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$12(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnUseProductionServerToggled.f108487a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$13(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnInternetEnabledToggled.f108375a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$14(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnSpeedUpTimersToggled.f108462a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$15(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnPremiumStateClicked.f108426a)) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.u4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DeveloperSettingsViewModel.K2((DeveloperSettingsViewState) obj);
                }
            });
            Unit unit5 = Unit.f139807a;
            return;
        }
        if (event instanceof DeveloperSettingsViewEvent.OnPremiumStateSelected) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$17(this, event, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnPremiumProductClicked.f108424a)) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.z4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DeveloperSettingsViewModel.V2((DeveloperSettingsViewState) obj);
                }
            });
            Unit unit6 = Unit.f139807a;
            return;
        }
        if (event instanceof DeveloperSettingsViewEvent.OnPremiumProductSelected) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$19(this, event, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnRemovePremiumClicked.f108432a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$20(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnActivateCampaignClicked.f108354a)) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.a5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DeveloperSettingsViewModel.a3((DeveloperSettingsViewState) obj);
                }
            });
            Unit unit7 = Unit.f139807a;
            return;
        }
        if (event instanceof DeveloperSettingsViewEvent.OnCampaignIdEntered) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$22(this, event, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnOfferLifetimeToggled.f108393a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$23(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnTrialAlwaysEligibleToggled.f108483a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$24(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnSimulateActiveTrialToggled.f108458a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$25(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnSimulateBillingErrorToggled.f108459a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$26(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnSubscriptionOnboardingTestClicked.f108477a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$27(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnCopyFCMTokenClicked.f108363a)) {
            f2();
            Unit unit8 = Unit.f139807a;
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnCopyRevenueCatIdClicked.f108364a)) {
            g2();
            Unit unit9 = Unit.f139807a;
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnCopyCustomerIdClicked.f108362a)) {
            e2();
            Unit unit10 = Unit.f139807a;
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnShowAdsClicked.f108439a)) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.b5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DeveloperSettingsViewModel.b3((DeveloperSettingsViewState) obj);
                }
            });
            Unit unit11 = Unit.f139807a;
            return;
        }
        if (event instanceof DeveloperSettingsViewEvent.OnShowAdsStateSelected) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$29(this, event, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnSkipDiscountTimerClicked.f108460a)) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.c5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DeveloperSettingsViewModel.c3((DeveloperSettingsViewState) obj);
                }
            });
            Unit unit12 = Unit.f139807a;
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnOverridePaywallSettingsClicked.f108417a)) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.e5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DeveloperSettingsViewModel.d3((DeveloperSettingsViewState) obj);
                }
            });
            Unit unit13 = Unit.f139807a;
            return;
        }
        if (event instanceof DeveloperSettingsViewEvent.OnSkipDiscountTimerStateSelected) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$32(this, event, null), 3, null);
            return;
        }
        if (event instanceof DeveloperSettingsViewEvent.OnOverridePaywallSettingsSelected) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$33(this, event, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnTestTargetingGroupClicked.f108478a)) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.f5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DeveloperSettingsViewModel.e3((DeveloperSettingsViewState) obj);
                }
            });
            Unit unit14 = Unit.f139807a;
            return;
        }
        if (event instanceof DeveloperSettingsViewEvent.OnTestTargetingGroupSaved) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$35(this, event, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnShowAllDiscountsClicked.f108442a)) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.g5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DeveloperSettingsViewModel.f3((DeveloperSettingsViewState) obj);
                }
            });
            Unit unit15 = Unit.f139807a;
            return;
        }
        if (event instanceof DeveloperSettingsViewEvent.OnShowAllDiscountsStateSelected) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$37(this, event, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnResetDiscountOffersClicked.f108433a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$38(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnShowIntroClicked.f108450a)) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.h5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DeveloperSettingsViewModel.g3((DeveloperSettingsViewState) obj);
                }
            });
            Unit unit16 = Unit.f139807a;
            return;
        }
        if (event instanceof DeveloperSettingsViewEvent.OnShowIntroStateSelected) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$40(this, event, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnShowWhatsNewFlowClicked.f108457a)) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.d5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DeveloperSettingsViewModel.L2((DeveloperSettingsViewState) obj);
                }
            });
            Unit unit17 = Unit.f139807a;
            return;
        }
        if (event instanceof DeveloperSettingsViewEvent.OnWhatsNewVersionSelected) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$42(this, event, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnWhatsNewCardClicked.f108488a)) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.l5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DeveloperSettingsViewModel.M2((DeveloperSettingsViewState) obj);
                }
            });
            Unit unit18 = Unit.f139807a;
            return;
        }
        if (event instanceof DeveloperSettingsViewEvent.OnWhatsNewCardStateSelected) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$44(this, event, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnShowAniaInfoDialogClicked.f108445a)) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.m5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DeveloperSettingsViewModel.N2((DeveloperSettingsViewState) obj);
                }
            });
            Unit unit19 = Unit.f139807a;
            return;
        }
        if (event instanceof DeveloperSettingsViewEvent.OnShowAniaInfoDialogStateSelected) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$46(this, event, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnShowPirateVersionSheetToggled.f108452a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$47(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnUseNewPaywallToggled.f108486a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$48(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnShowAllTrendItemsToggled.f108444a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$49(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnShowPremiumExpiringToggled.f108454a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$50(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnShowPremiumExpiringCardsToggled.f108453a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$51(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnUseFakeReviewManagerToggled.f108485a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$52(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnForceRatingDialogClicked.f108371a)) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.n5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DeveloperSettingsViewModel.O2((DeveloperSettingsViewState) obj);
                }
            });
            Unit unit20 = Unit.f139807a;
            return;
        }
        if (event instanceof DeveloperSettingsViewEvent.OnForceRatingDialogTypeSelected) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$54(this, event, null), 3, null);
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.o5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DeveloperSettingsViewModel.P2((DeveloperSettingsViewState) obj);
                }
            });
            Unit unit21 = Unit.f139807a;
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnMockWeeklyStatsNotificationClicked.f108391a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$56(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnMockDailyInsightsMotivationClicked.f108379a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$57(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnMockTrialExpiringNotificationClicked.f108389a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$58(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnMockTrialConvReminderNotificationClicked.f108388a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$59(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnMockTrialConvFailedNotificationClicked.f108387a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$60(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnMockWeeklyStatsScreenClicked.f108392a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$61(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnMockWeeklyStatsDialogClicked.f108390a)) {
            H2();
            Unit unit22 = Unit.f139807a;
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnMockPremiumExpiringScreenClicked.f108383a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$62(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnMockTrialComparisonDataToggled.f108386a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$63(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnMockInAppUpdatesClicked.f108380a)) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.p5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DeveloperSettingsViewModel.Q2((DeveloperSettingsViewState) obj);
                }
            });
            Unit unit23 = Unit.f139807a;
            return;
        }
        if (event instanceof DeveloperSettingsViewEvent.OnMockInAppUpdatesSaved) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$65(this, event, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnMockRemoteConfigClicked.f108384a)) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.q5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DeveloperSettingsViewModel.R2((DeveloperSettingsViewState) obj);
                }
            });
            Unit unit24 = Unit.f139807a;
            return;
        }
        if (event instanceof DeveloperSettingsViewEvent.OnMockRemoteConfigSaved) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$67(event, this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnForceLoadingEnabledToggled.f108370a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$68(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnGenerateFakeInsightsDataClicked.f108374a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$69(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnRemoteConfigValuesClicked.f108430a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$70(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnQuestionnaireConfigClicked.f108428a)) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.r5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DeveloperSettingsViewModel.S2((DeveloperSettingsViewState) obj);
                }
            });
            Unit unit25 = Unit.f139807a;
            return;
        }
        if (event instanceof DeveloperSettingsViewEvent.OnQuestionnaireConfigSaved) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$72(this, event, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnTimeChangeLimitClicked.f108480a)) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.s5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DeveloperSettingsViewModel.T2((DeveloperSettingsViewState) obj);
                }
            });
            Unit unit26 = Unit.f139807a;
            return;
        }
        if (event instanceof DeveloperSettingsViewEvent.OnTimeChangeLimitSaved) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$74(event, this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnParseSupportJsonClicked.f108419a)) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.t4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DeveloperSettingsViewModel.U2((DeveloperSettingsViewState) obj);
                }
            });
            Unit unit27 = Unit.f139807a;
            return;
        }
        if (event instanceof DeveloperSettingsViewEvent.OnParseSupportJsonSaved) {
            h3(((DeveloperSettingsViewEvent.OnParseSupportJsonSaved) event).a());
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.v4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DeveloperSettingsViewModel.W2((DeveloperSettingsViewState) obj);
                }
            });
            Unit unit28 = Unit.f139807a;
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnParseSupportJsonFileClicked.f108420a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$77(this, null), 3, null);
            return;
        }
        if (event instanceof DeveloperSettingsViewEvent.OnFilePicked) {
            i3(((DeveloperSettingsViewEvent.OnFilePicked) event).a());
            Unit unit29 = Unit.f139807a;
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnClearStrictModeClicked.f108360a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$78(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnClearStrictModeOnboardingClicked.f108361a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$79(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnResetQuickBlockClicked.f108434a)) {
            k3();
            Unit unit30 = Unit.f139807a;
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnClearAdultContentClicked.f108359a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$80(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnResetStrictModeUpsellClicked.f108435a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$81(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnResetUnlockAllAppsTimerClicked.f108436a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$82(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnAlwaysShowEmailConsentToggled.f108355a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$83(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnGenerateBackdoorCodeClicked.f108373a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$84(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnDisableBackdoorCodeCheckToggled.f108365a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$85(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnAlwaysValidateEmergencyStringToggled.f108356a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$86(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnListAllBrowsersClicked.f108377a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$87(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnShowAdsInspectorClicked.f108440a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$88(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnShowEventsBubbleClicked.f108449a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$89(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnShowChatBotClicked.f108448a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$90(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnPerformFatalCrashClicked.f108422a)) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.w4
                @Override // java.lang.Runnable
                public final void run() {
                    DeveloperSettingsViewModel.X2();
                }
            });
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnLogLockServiceToggled.f108378a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$92(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnPomodoroInSecondsToggled.f108423a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$93(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnTimeNudgeShortIntervalsToggled.f108482a)) {
            G0(new DeveloperSettingsViewModel$onEvent$94(this, null));
            Unit unit31 = Unit.f139807a;
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnTriggerTimeNudgeClicked.f108484a)) {
            G0(new DeveloperSettingsViewModel$onEvent$95(this, null));
            Unit unit32 = Unit.f139807a;
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnStrictModePauseInSecondsToggled.f108476a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$96(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnOpenIntroTrialPremiumClicked.f108408a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$97(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnOpenTrialRetentionPremiumClicked.f108415a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$98(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnOpenGenericPremiumClicked.f108407a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$99(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnOpenAutoTrialFlowClicked.f108397a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$100(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnForceAutoTrialExpiredToggled.f108369a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$101(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnForceAutoTrialExpiredCardToggled.f108368a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$102(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnShortenAutoTrialWaitToggled.f108438a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$103(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnOpenDiscountPremiumClicked.f108401a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$104(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnOpenDiscountPremium30Clicked.f108399a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$105(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnOpenDiscountPremium50Clicked.f108400a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$106(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnOpenExpiredSubPremiumClicked.f108406a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$107(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnOpenProductPlanPremiumClicked.f108414a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$108(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnOpenLimitScreenPremiumClicked.f108410a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$109(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnOpenExpiredSubDiscountPremiumClicked.f108405a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$110(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnOpenIntroTrialTogglePremiumClicked.f108409a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$111(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnOpenOneTimeToSubPremiumClicked.f108412a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$112(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnOpenDiscountPremiumReferralSenderClicked.f108403a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$113(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnOpenDiscountPremiumReferralReceiverClicked.f108402a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$114(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnOpenCampaignPremiumClicked.f108398a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$115(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnLaunchOnboardingClicked.f108376a)) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.x4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DeveloperSettingsViewModel.Y2((DeveloperSettingsViewState) obj);
                }
            });
            Unit unit33 = Unit.f139807a;
            return;
        }
        if (event instanceof DeveloperSettingsViewEvent.OnOnboardingFlowVariantSelected) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$117(this, event, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnShowAppFeelOnboardingClicked.f108447a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$118(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnShowTrialRemindersFlowClicked.f108456a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$119(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnShowRatingDialogFlowClicked.f108455a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$120(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnOpenAccessibilitySettings.f108395a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$121(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnOpenOverlaySettings.f108413a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$122(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnOpenUsageSettings.f108416a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$123(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnOpenNotificationAccessSettings.f108411a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$124(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnOpenAppSettings.f108396a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$125(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnRemoveDeviceAdmin.f108431a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new DeveloperSettingsViewModel$onEvent$126(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnDismissDialog.f108366a)) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.y4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DeveloperSettingsViewModel.Z2((DeveloperSettingsViewState) obj);
                }
            });
            Unit unit34 = Unit.f139807a;
        } else {
            if (!Intrinsics.areEqual(event, DeveloperSettingsViewEvent.OnOpenDiscountScreenClicked.f108404a)) {
                throw new NoWhenBranchMatchedException();
            }
            G0(new DeveloperSettingsViewModel$onEvent$128(this, null));
            Unit unit35 = Unit.f139807a;
        }
    }

    public final DevDataStore m2() {
        return (DevDataStore) this.f108491o.getValue();
    }
}
