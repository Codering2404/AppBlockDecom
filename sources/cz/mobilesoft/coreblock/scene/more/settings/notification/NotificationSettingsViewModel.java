package cz.mobilesoft.coreblock.scene.more.settings.notification;

import android.app.Application;
import com.facebook.internal.instrument.anrreport.jRA.jlWo;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.enums.EmailConsentState;
import cz.mobilesoft.coreblock.enums.EventShowAsType;
import cz.mobilesoft.coreblock.enums.PendingEmailConsentState;
import cz.mobilesoft.coreblock.repository.StrictModeRepository;
import cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationPreference;
import cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewEvent;
import cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewModel;
import cz.mobilesoft.coreblock.scene.streaks.StreakAvailability;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.storage.datastore.NotificationDataStore;
import cz.mobilesoft.coreblock.storage.datastore.SessionDataStore;
import cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore;
import cz.mobilesoft.coreblock.usecase.SyncEmailConsentUseCase;
import cz.mobilesoft.coreblock.util.SessionManager;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
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
public final class NotificationSettingsViewModel extends BaseStatefulViewModel<NotificationSettingsViewState, NotificationSettingsViewEvent, NotificationSettingsViewCommand> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f109988o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f109989p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f109990q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Lazy f109991r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Lazy f109992s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Lazy f109993t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Lazy f109994u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final MutableStateFlow f109995v;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewModel$1", f = "NotificationSettingsViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f109996a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewModel$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class C02911<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ NotificationSettingsViewModel f109998a;

            C02911(NotificationSettingsViewModel notificationSettingsViewModel) {
                this.f109998a = notificationSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final NotificationSettingsViewState f(boolean z2, NotificationSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return NotificationSettingsViewState.b(updateState, null, null, !z2, false, false, false, 0, null, false, null, false, null, 0, false, false, false, false, false, false, 524283, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f109998a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.g1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NotificationSettingsViewModel.AnonymousClass1.C02911.f(z2, (NotificationSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewModel$1$10, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewModel$1$10", f = "NotificationSettingsViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
        static final class AnonymousClass10 extends SuspendLambda implements Function3<Boolean, Boolean, Continuation<? super Pair<? extends NotificationPreference.ShowAfterQuickBlockEnd, ? extends NotificationPreference.ShowAfterQuickBlockEndBlockedNotifications>>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f109999a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ boolean f110000b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            /* synthetic */ boolean f110001c;

            AnonymousClass10(Continuation continuation) {
                super(3, continuation);
            }

            public final Object h(boolean z2, boolean z3, Continuation continuation) {
                AnonymousClass10 anonymousClass10 = new AnonymousClass10(continuation);
                anonymousClass10.f110000b = z2;
                anonymousClass10.f110001c = z3;
                return anonymousClass10.invokeSuspend(Unit.f139807a);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return h(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Continuation) obj3);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                boolean z2 = this.f110000b;
                boolean z3 = this.f110001c;
                IntrinsicsKt.f();
                if (this.f109999a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return TuplesKt.a(new NotificationPreference.ShowAfterQuickBlockEnd(z2), new NotificationPreference.ShowAfterQuickBlockEndBlockedNotifications(z3 && z2, z2));
            }
        }

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewModel$1$11, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass11<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ NotificationSettingsViewModel f110002a;

            AnonymousClass11(NotificationSettingsViewModel notificationSettingsViewModel) {
                this.f110002a = notificationSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final NotificationSettingsViewState f(Pair pair, NotificationSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return NotificationSettingsViewState.b(updateState, null, null, false, false, false, false, 0, null, false, null, ((NotificationPreference.ShowAfterQuickBlockEnd) pair.e()).a(), (NotificationPreference.ShowAfterQuickBlockEndBlockedNotifications) pair.f(), 0, false, false, false, false, false, false, 521215, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(final Pair pair, Continuation continuation) {
                this.f110002a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.h1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NotificationSettingsViewModel.AnonymousClass1.AnonymousClass11.f(pair, (NotificationSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }
        }

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewModel$1$12, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass12<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ NotificationSettingsViewModel f110003a;

            AnonymousClass12(NotificationSettingsViewModel notificationSettingsViewModel) {
                this.f110003a = notificationSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final NotificationSettingsViewState f(int i3, NotificationSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return NotificationSettingsViewState.b(updateState, null, null, false, false, false, false, 0, null, false, null, false, null, i3, false, false, false, false, false, false, 520191, null);
            }

            public final Object b(final int i3, Continuation continuation) {
                this.f110003a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.i1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NotificationSettingsViewModel.AnonymousClass1.AnonymousClass12.f(i3, (NotificationSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Number) obj).intValue(), continuation);
            }
        }

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewModel$1$13, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass13<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ NotificationSettingsViewModel f110004a;

            AnonymousClass13(NotificationSettingsViewModel notificationSettingsViewModel) {
                this.f110004a = notificationSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final NotificationSettingsViewState f(boolean z2, NotificationSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return NotificationSettingsViewState.b(updateState, null, null, false, false, false, false, 0, null, false, null, false, null, 0, z2, false, false, false, false, false, 516095, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f110004a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.j1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NotificationSettingsViewModel.AnonymousClass1.AnonymousClass13.f(z2, (NotificationSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewModel$1$14, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass14<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ NotificationSettingsViewModel f110005a;

            AnonymousClass14(NotificationSettingsViewModel notificationSettingsViewModel) {
                this.f110005a = notificationSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final NotificationSettingsViewState f(boolean z2, NotificationSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return NotificationSettingsViewState.b(updateState, null, null, false, false, false, false, 0, null, false, null, false, null, 0, false, z2, false, false, false, false, 507903, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f110005a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.k1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NotificationSettingsViewModel.AnonymousClass1.AnonymousClass14.f(z2, (NotificationSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewModel$1$15, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass15<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ NotificationSettingsViewModel f110006a;

            AnonymousClass15(NotificationSettingsViewModel notificationSettingsViewModel) {
                this.f110006a = notificationSettingsViewModel;
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f110006a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.l1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NotificationSettingsViewModel.AnonymousClass1.AnonymousClass15.f(z2, (NotificationSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final NotificationSettingsViewState f(boolean z2, NotificationSettingsViewState notificationSettingsViewState) {
                Intrinsics.checkNotNullParameter(notificationSettingsViewState, jlWo.jZGmJwKscKv);
                return NotificationSettingsViewState.b(notificationSettingsViewState, null, null, false, false, false, false, 0, null, false, null, false, null, 0, false, false, z2, false, false, false, 491519, null);
            }
        }

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewModel$1$16, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass16<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ NotificationSettingsViewModel f110007a;

            AnonymousClass16(NotificationSettingsViewModel notificationSettingsViewModel) {
                this.f110007a = notificationSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final NotificationSettingsViewState f(boolean z2, NotificationSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return NotificationSettingsViewState.b(updateState, null, null, false, false, false, false, 0, null, false, null, false, null, 0, false, false, false, z2, false, false, 458751, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f110007a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.m1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NotificationSettingsViewModel.AnonymousClass1.AnonymousClass16.f(z2, (NotificationSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewModel$1$17, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass17<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ NotificationSettingsViewModel f110008a;

            AnonymousClass17(NotificationSettingsViewModel notificationSettingsViewModel) {
                this.f110008a = notificationSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final NotificationSettingsViewState f(SessionManager.SignInState signInState, NotificationSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return NotificationSettingsViewState.b(updateState, null, null, false, false, false, false, 0, null, false, null, false, null, 0, false, false, false, false, signInState instanceof SessionManager.SignedIn, false, 393215, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(final SessionManager.SignInState signInState, Continuation continuation) {
                this.f110008a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.n1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NotificationSettingsViewModel.AnonymousClass1.AnonymousClass17.f(signInState, (NotificationSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }
        }

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewModel$1$18, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewModel$1$18", f = "NotificationSettingsViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
        static final class AnonymousClass18 extends SuspendLambda implements Function3<EmailConsentState, PendingEmailConsentState, Continuation<? super Boolean>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f110009a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f110010b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            /* synthetic */ Object f110011c;

            AnonymousClass18(Continuation continuation) {
                super(3, continuation);
            }

            @Override // kotlin.jvm.functions.Function3
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public final Object invoke(EmailConsentState emailConsentState, PendingEmailConsentState pendingEmailConsentState, Continuation continuation) {
                AnonymousClass18 anonymousClass18 = new AnonymousClass18(continuation);
                anonymousClass18.f110010b = emailConsentState;
                anonymousClass18.f110011c = pendingEmailConsentState;
                return anonymousClass18.invokeSuspend(Unit.f139807a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                EmailConsentState emailConsentState = (EmailConsentState) this.f110010b;
                PendingEmailConsentState pendingEmailConsentState = (PendingEmailConsentState) this.f110011c;
                IntrinsicsKt.f();
                if (this.f110009a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return Boxing.a(NewsletterConsentKt.a(emailConsentState, pendingEmailConsentState));
            }
        }

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewModel$1$19, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass19<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ NotificationSettingsViewModel f110012a;

            AnonymousClass19(NotificationSettingsViewModel notificationSettingsViewModel) {
                this.f110012a = notificationSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final NotificationSettingsViewState f(boolean z2, NotificationSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return NotificationSettingsViewState.b(updateState, null, null, false, false, false, false, 0, null, false, null, false, null, 0, false, false, false, false, false, z2, 262143, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f110012a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.o1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NotificationSettingsViewModel.AnonymousClass1.AnonymousClass19.f(z2, (NotificationSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewModel$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass2<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ NotificationSettingsViewModel f110013a;

            AnonymousClass2(NotificationSettingsViewModel notificationSettingsViewModel) {
                this.f110013a = notificationSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final NotificationSettingsViewState f(boolean z2, NotificationSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return NotificationSettingsViewState.b(updateState, null, null, false, z2, false, false, 0, null, false, null, false, null, 0, false, false, false, false, false, false, 524279, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f110013a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.p1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NotificationSettingsViewModel.AnonymousClass1.AnonymousClass2.f(z2, (NotificationSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewModel$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass3<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ NotificationSettingsViewModel f110014a;

            AnonymousClass3(NotificationSettingsViewModel notificationSettingsViewModel) {
                this.f110014a = notificationSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final NotificationSettingsViewState f(boolean z2, NotificationSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return NotificationSettingsViewState.b(updateState, null, null, false, false, z2, false, 0, null, false, null, false, null, 0, false, false, false, false, false, false, 524271, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f110014a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.q1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NotificationSettingsViewModel.AnonymousClass1.AnonymousClass3.f(z2, (NotificationSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewModel$1$4, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass4<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ NotificationSettingsViewModel f110015a;

            AnonymousClass4(NotificationSettingsViewModel notificationSettingsViewModel) {
                this.f110015a = notificationSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final NotificationSettingsViewState f(boolean z2, NotificationSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return NotificationSettingsViewState.b(updateState, null, null, false, false, false, z2, 0, null, false, null, false, null, 0, false, false, false, false, false, false, 524255, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f110015a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.r1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NotificationSettingsViewModel.AnonymousClass1.AnonymousClass4.f(z2, (NotificationSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewModel$1$5, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass5<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ NotificationSettingsViewModel f110016a;

            AnonymousClass5(NotificationSettingsViewModel notificationSettingsViewModel) {
                this.f110016a = notificationSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final NotificationSettingsViewState f(int i3, NotificationSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return NotificationSettingsViewState.b(updateState, null, null, false, false, false, false, i3, null, false, null, false, null, 0, false, false, false, false, false, false, 524223, null);
            }

            public final Object b(final int i3, Continuation continuation) {
                this.f110016a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.s1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NotificationSettingsViewModel.AnonymousClass1.AnonymousClass5.f(i3, (NotificationSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Number) obj).intValue(), continuation);
            }
        }

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewModel$1$6, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewModel$1$6", f = "NotificationSettingsViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
        static final class AnonymousClass6 extends SuspendLambda implements Function3<Integer, EventShowAsType, Continuation<? super NotificationPreference.NotificationBeforeUsageLimitEnd>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f110017a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ int f110018b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            /* synthetic */ Object f110019c;

            AnonymousClass6(Continuation continuation) {
                super(3, continuation);
            }

            public final Object h(int i3, EventShowAsType eventShowAsType, Continuation continuation) {
                AnonymousClass6 anonymousClass6 = new AnonymousClass6(continuation);
                anonymousClass6.f110018b = i3;
                anonymousClass6.f110019c = eventShowAsType;
                return anonymousClass6.invokeSuspend(Unit.f139807a);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return h(((Number) obj).intValue(), (EventShowAsType) obj2, (Continuation) obj3);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                int i3 = this.f110018b;
                EventShowAsType eventShowAsType = (EventShowAsType) this.f110019c;
                IntrinsicsKt.f();
                if (this.f110017a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return new NotificationPreference.NotificationBeforeUsageLimitEnd(i3, eventShowAsType);
            }
        }

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewModel$1$7, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass7<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ NotificationSettingsViewModel f110020a;

            AnonymousClass7(NotificationSettingsViewModel notificationSettingsViewModel) {
                this.f110020a = notificationSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final NotificationSettingsViewState f(NotificationPreference.NotificationBeforeUsageLimitEnd notificationBeforeUsageLimitEnd, NotificationSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return NotificationSettingsViewState.b(updateState, null, null, false, false, false, false, 0, notificationBeforeUsageLimitEnd, false, null, false, null, 0, false, false, false, false, false, false, 524159, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(final NotificationPreference.NotificationBeforeUsageLimitEnd notificationBeforeUsageLimitEnd, Continuation continuation) {
                this.f110020a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.t1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NotificationSettingsViewModel.AnonymousClass1.AnonymousClass7.f(notificationBeforeUsageLimitEnd, (NotificationSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }
        }

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewModel$1$8, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewModel$1$8", f = "NotificationSettingsViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
        static final class AnonymousClass8 extends SuspendLambda implements Function3<Boolean, Boolean, Continuation<? super Pair<? extends NotificationPreference.ShowAfterScheduleEnd, ? extends NotificationPreference.ShowAfterScheduleEndBlockedNotifications>>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f110021a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ boolean f110022b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            /* synthetic */ boolean f110023c;

            AnonymousClass8(Continuation continuation) {
                super(3, continuation);
            }

            public final Object h(boolean z2, boolean z3, Continuation continuation) {
                AnonymousClass8 anonymousClass8 = new AnonymousClass8(continuation);
                anonymousClass8.f110022b = z2;
                anonymousClass8.f110023c = z3;
                return anonymousClass8.invokeSuspend(Unit.f139807a);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return h(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Continuation) obj3);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                boolean z2 = this.f110022b;
                boolean z3 = this.f110023c;
                IntrinsicsKt.f();
                if (this.f110021a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return TuplesKt.a(new NotificationPreference.ShowAfterScheduleEnd(z2), new NotificationPreference.ShowAfterScheduleEndBlockedNotifications(z3 && z2, z2));
            }
        }

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewModel$1$9, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass9<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ NotificationSettingsViewModel f110024a;

            AnonymousClass9(NotificationSettingsViewModel notificationSettingsViewModel) {
                this.f110024a = notificationSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final NotificationSettingsViewState f(Pair pair, NotificationSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return NotificationSettingsViewState.b(updateState, null, null, false, false, false, false, 0, null, ((NotificationPreference.ShowAfterScheduleEnd) pair.e()).a(), (NotificationPreference.ShowAfterScheduleEndBlockedNotifications) pair.f(), false, null, 0, false, false, false, false, false, false, 523519, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(final Pair pair, Continuation continuation) {
                this.f110024a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.u1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NotificationSettingsViewModel.AnonymousClass1.AnonymousClass9.f(pair, (NotificationSettingsViewState) obj);
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
            return NotificationSettingsViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f109996a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            NotificationSettingsViewModel.this.f1();
            NotificationSettingsViewModel.this.g1();
            FlowExtKt.i(NotificationSettingsViewModel.this.f109995v, NotificationSettingsViewModel.this.C0(), new C02911(NotificationSettingsViewModel.this));
            FlowExtKt.i(NotificationSettingsViewModel.this.i1().a0(), NotificationSettingsViewModel.this.C0(), new AnonymousClass2(NotificationSettingsViewModel.this));
            FlowExtKt.i(NotificationSettingsViewModel.this.i1().Z(), NotificationSettingsViewModel.this.C0(), new AnonymousClass3(NotificationSettingsViewModel.this));
            FlowExtKt.i(NotificationSettingsViewModel.this.l1().c(), NotificationSettingsViewModel.this.C0(), new AnonymousClass4(NotificationSettingsViewModel.this));
            FlowExtKt.i(NotificationSettingsViewModel.this.i1().O(), NotificationSettingsViewModel.this.C0(), new AnonymousClass5(NotificationSettingsViewModel.this));
            FlowExtKt.i(FlowKt.J(NotificationSettingsViewModel.this.i1().Q(), NotificationSettingsViewModel.this.i1().R(), new AnonymousClass6(null)), NotificationSettingsViewModel.this.C0(), new AnonymousClass7(NotificationSettingsViewModel.this));
            FlowExtKt.i(FlowKt.J(NotificationSettingsViewModel.this.i1().U(), NotificationSettingsViewModel.this.i1().V(), new AnonymousClass8(null)), NotificationSettingsViewModel.this.C0(), new AnonymousClass9(NotificationSettingsViewModel.this));
            FlowExtKt.i(FlowKt.J(NotificationSettingsViewModel.this.i1().S(), NotificationSettingsViewModel.this.i1().T(), new AnonymousClass10(null)), NotificationSettingsViewModel.this.C0(), new AnonymousClass11(NotificationSettingsViewModel.this));
            FlowExtKt.i(NotificationSettingsViewModel.this.i1().P(), NotificationSettingsViewModel.this.C0(), new AnonymousClass12(NotificationSettingsViewModel.this));
            FlowExtKt.i(NotificationSettingsViewModel.this.i1().Y(), NotificationSettingsViewModel.this.C0(), new AnonymousClass13(NotificationSettingsViewModel.this));
            FlowExtKt.i(NotificationSettingsViewModel.this.i1().b0(), NotificationSettingsViewModel.this.C0(), new AnonymousClass14(NotificationSettingsViewModel.this));
            FlowExtKt.i(NotificationSettingsViewModel.this.i1().X(), NotificationSettingsViewModel.this.C0(), new AnonymousClass15(NotificationSettingsViewModel.this));
            FlowExtKt.i(NotificationSettingsViewModel.this.i1().W(), NotificationSettingsViewModel.this.C0(), new AnonymousClass16(NotificationSettingsViewModel.this));
            FlowExtKt.i(SessionManager.f127910a.l(), NotificationSettingsViewModel.this.C0(), new AnonymousClass17(NotificationSettingsViewModel.this));
            FlowExtKt.i(FlowKt.J(NotificationSettingsViewModel.this.k1().I(), NotificationSettingsViewModel.this.h1().N2(), new AnonymousClass18(null)), NotificationSettingsViewModel.this.C0(), new AnonymousClass19(NotificationSettingsViewModel.this));
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NotificationSettingsViewModel(Application application) {
        super(application, new NotificationSettingsViewState(null, null, false, false, false, false, 0, null, false, null, false, null, 0, false, false, false, false, false, false, 524287, null));
        Intrinsics.checkNotNullParameter(application, "application");
        final Qualifier qualifier = null;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f109988o = LazyKt.a(lazyThreadSafetyModeB, new Function0<NotificationDataStore>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(NotificationDataStore.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f109989p = LazyKt.a(lazyThreadSafetyModeB2, new Function0<StrictModeRepository>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewModel$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeRepository.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f109990q = LazyKt.a(lazyThreadSafetyModeB3, new Function0<DevDataStore>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewModel$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DevDataStore.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f109991r = LazyKt.a(lazyThreadSafetyModeB4, new Function0<StreakAvailability>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewModel$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StreakAvailability.class), objArr6, objArr7);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB5 = koinPlatformTools.b();
        final Object[] objArr8 = 0 == true ? 1 : 0;
        final Object[] objArr9 = 0 == true ? 1 : 0;
        this.f109992s = LazyKt.a(lazyThreadSafetyModeB5, new Function0<SessionDataStore>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewModel$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(SessionDataStore.class), objArr8, objArr9);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB6 = koinPlatformTools.b();
        final Object[] objArr10 = 0 == true ? 1 : 0;
        final Object[] objArr11 = 0 == true ? 1 : 0;
        this.f109993t = LazyKt.a(lazyThreadSafetyModeB6, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewModel$special$$inlined$inject$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreDataStore.class), objArr10, objArr11);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB7 = koinPlatformTools.b();
        final Object[] objArr12 = 0 == true ? 1 : 0;
        final Object[] objArr13 = 0 == true ? 1 : 0;
        this.f109994u = LazyKt.a(lazyThreadSafetyModeB7, new Function0<SyncEmailConsentUseCase>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewModel$special$$inlined$inject$default$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(SyncEmailConsentUseCase.class), objArr12, objArr13);
            }
        });
        this.f109995v = StateFlowKt.a(Boolean.FALSE);
        G0(new AnonymousClass1(null));
    }

    public static final /* synthetic */ NotificationSettingsViewState T0(NotificationSettingsViewModel notificationSettingsViewModel) {
        return (NotificationSettingsViewState) notificationSettingsViewModel.I0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f1() {
        G0(new NotificationSettingsViewModel$checkAndUpdatePermission$1(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g1() {
        G0(new NotificationSettingsViewModel$checkAndUpdateStateChannelDisabled$1(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoreDataStore h1() {
        return (CoreDataStore) this.f109993t.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NotificationDataStore i1() {
        return (NotificationDataStore) this.f109988o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DevDataStore j1() {
        return (DevDataStore) this.f109990q.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SessionDataStore k1() {
        return (SessionDataStore) this.f109992s.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StreakAvailability l1() {
        return (StreakAvailability) this.f109991r.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SyncEmailConsentUseCase m1() {
        return (SyncEmailConsentUseCase) this.f109994u.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StrictModeRepository t0() {
        return (StrictModeRepository) this.f109989p.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: n1, reason: merged with bridge method [inline-methods] */
    public void O0(NotificationSettingsViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event, NotificationSettingsViewEvent.OnResumed.f109976a)) {
            f1();
            g1();
            Unit unit = Unit.f139807a;
            return;
        }
        if (Intrinsics.areEqual(event, NotificationSettingsViewEvent.OnShowAfterQuickBlockEndBlockedNotificationsChanged.f109977a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new NotificationSettingsViewModel$onEvent$1(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, NotificationSettingsViewEvent.OnShowAfterQuickBlockEndChanged.f109978a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new NotificationSettingsViewModel$onEvent$2(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, NotificationSettingsViewEvent.OnShowAfterScheduleEndBlockedNotificationsChanged.f109979a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new NotificationSettingsViewModel$onEvent$3(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, NotificationSettingsViewEvent.OnShowAfterScheduleEndChanged.f109980a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new NotificationSettingsViewModel$onEvent$4(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, NotificationSettingsViewEvent.OnShowBlockedAppsChanged.f109981a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new NotificationSettingsViewModel$onEvent$5(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, NotificationSettingsViewEvent.OnShowPomodoroNotificationChanged.f109983a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new NotificationSettingsViewModel$onEvent$6(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, NotificationSettingsViewEvent.OnShowStreakNudgeChanged.f109984a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new NotificationSettingsViewModel$onEvent$7(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, NotificationSettingsViewEvent.OnShowUsageLimitChanged.f109985a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new NotificationSettingsViewModel$onEvent$8(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, NotificationSettingsViewEvent.OnShowUsageStatisticsNotificationChanged.f109986a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new NotificationSettingsViewModel$onEvent$9(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, NotificationSettingsViewEvent.OnShowWeeklyStatisticsReportNotificationChanged.f109987a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new NotificationSettingsViewModel$onEvent$10(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, NotificationSettingsViewEvent.OnShowDailyInsightsMotivationChanged.f109982a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new NotificationSettingsViewModel$onEvent$11(this, null), 3, null);
            return;
        }
        if (!Intrinsics.areEqual(event, NotificationSettingsViewEvent.OnNewsletterChanged.f109975a)) {
            throw new NoWhenBranchMatchedException();
        }
        boolean zR = ((NotificationSettingsViewState) I0()).r();
        boolean z2 = !zR;
        if (zR) {
            AnswersHelper.f128199a.i6();
        } else {
            AnswersHelper.f128199a.j6();
        }
        H0(new NotificationSettingsViewModel$onEvent$12(this, z2, null));
        Unit unit2 = Unit.f139807a;
    }
}
