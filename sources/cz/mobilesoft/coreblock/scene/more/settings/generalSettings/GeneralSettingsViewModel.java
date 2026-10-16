package cz.mobilesoft.coreblock.scene.more.settings.generalSettings;

import android.app.Application;
import androidx.appcompat.app.AppCompatDelegate;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.enums.TripleState;
import cz.mobilesoft.coreblock.repository.QuickBlockRepository;
import cz.mobilesoft.coreblock.repository.StrictModeRepository;
import cz.mobilesoft.coreblock.scene.more.settings.dialog.LanguagePickerDialogFragmentKt;
import cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewEvent;
import cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel;
import cz.mobilesoft.coreblock.scene.quickblock.QuickBlockProfileDTO;
import cz.mobilesoft.coreblock.scene.streaks.StreakAvailability;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore;
import cz.mobilesoft.coreblock.storage.datastore.InAppUpdatesDataStore;
import cz.mobilesoft.coreblock.storage.datastore.PassCodeDataStore;
import cz.mobilesoft.coreblock.storage.datastore.QuickBlockDataStore;
import cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;
import cz.mobilesoft.coreblock.util.helperextension.DateHelperExtKt;
import java.util.Calendar;
import java.util.Date;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
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
public final class GeneralSettingsViewModel extends BaseStatefulViewModel<GeneralSettingsViewState, GeneralSettingsViewEvent, GeneralSettingsViewCommand> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f109721o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f109722p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f109723q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Lazy f109724r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Lazy f109725s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Lazy f109726t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Lazy f109727u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Lazy f109728v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final Lazy f109729w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final Lazy f109730x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final Lazy f109731y;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel$1", f = "GeneralSettingsViewModel.kt", l = {50}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f109732a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class C02901<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ GeneralSettingsViewModel f109734a;

            C02901(GeneralSettingsViewModel generalSettingsViewModel) {
                this.f109734a = generalSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final GeneralSettingsViewState f(Calendar calendar, GeneralSettingsViewModel generalSettingsViewModel, GeneralSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                Date time = calendar.getTime();
                Intrinsics.checkNotNullExpressionValue(time, "getTime(...)");
                return updateState.a((16381 & 1) != 0 ? updateState.f109819a : null, (16381 & 2) != 0 ? updateState.f109820b : DateHelperExtKt.p(time, generalSettingsViewModel.A0()), (16381 & 4) != 0 ? updateState.f109821c : null, (16381 & 8) != 0 ? updateState.f109822d : false, (16381 & 16) != 0 ? updateState.f109823f : false, (16381 & 32) != 0 ? updateState.f109824g : false, (16381 & 64) != 0 ? updateState.f109825h : false, (16381 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? updateState.f109826i : false, (16381 & Function.MAX_NARGS) != 0 ? updateState.f109827j : false, (16381 & 512) != 0 ? updateState.f109828k : false, (16381 & 1024) != 0 ? updateState.f109829l : false, (16381 & 2048) != 0 ? updateState.f109830m : false, (16381 & 4096) != 0 ? updateState.f109831n : false, (16381 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? updateState.f109832o : false);
            }

            public final Object b(int i3, Continuation continuation) {
                final GeneralSettingsViewModel generalSettingsViewModel = this.f109734a;
                final Calendar calendar = Calendar.getInstance();
                calendar.set(11, i3);
                calendar.set(12, 0);
                generalSettingsViewModel.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.a0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GeneralSettingsViewModel.AnonymousClass1.C02901.f(calendar, generalSettingsViewModel, (GeneralSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Number) obj).intValue(), continuation);
            }
        }

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return GeneralSettingsViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f109732a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowD0 = GeneralSettingsViewModel.this.j1().d0();
                C02901 c02901 = new C02901(GeneralSettingsViewModel.this);
                this.f109732a = 1;
                if (flowD0.collect(c02901, this) == objF) {
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

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel$10, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel$10", f = "GeneralSettingsViewModel.kt", l = {148}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass10 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f109735a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel$10$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ GeneralSettingsViewModel f109737a;

            AnonymousClass1(GeneralSettingsViewModel generalSettingsViewModel) {
                this.f109737a = generalSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final GeneralSettingsViewState f(boolean z2, GeneralSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return updateState.a((16381 & 1) != 0 ? updateState.f109819a : null, (16381 & 2) != 0 ? updateState.f109820b : null, (16381 & 4) != 0 ? updateState.f109821c : null, (16381 & 8) != 0 ? updateState.f109822d : false, (16381 & 16) != 0 ? updateState.f109823f : false, (16381 & 32) != 0 ? updateState.f109824g : false, (16381 & 64) != 0 ? updateState.f109825h : false, (16381 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? updateState.f109826i : false, (16381 & Function.MAX_NARGS) != 0 ? updateState.f109827j : false, (16381 & 512) != 0 ? updateState.f109828k : false, (16381 & 1024) != 0 ? updateState.f109829l : false, (16381 & 2048) != 0 ? updateState.f109830m : false, (16381 & 4096) != 0 ? updateState.f109831n : z2, (16381 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? updateState.f109832o : false);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f109737a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.b0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GeneralSettingsViewModel.AnonymousClass10.AnonymousClass1.f(z2, (GeneralSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass10(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return GeneralSettingsViewModel.this.new AnonymousClass10(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f109735a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowV3 = GeneralSettingsViewModel.this.i1().v3();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(GeneralSettingsViewModel.this);
                this.f109735a = 1;
                if (flowV3.collect(anonymousClass1, this) == objF) {
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

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel$11, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel$11", f = "GeneralSettingsViewModel.kt", l = {153}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass11 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f109738a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel$11$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ GeneralSettingsViewModel f109740a;

            AnonymousClass1(GeneralSettingsViewModel generalSettingsViewModel) {
                this.f109740a = generalSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final GeneralSettingsViewState f(boolean z2, GeneralSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return updateState.a((16381 & 1) != 0 ? updateState.f109819a : null, (16381 & 2) != 0 ? updateState.f109820b : null, (16381 & 4) != 0 ? updateState.f109821c : null, (16381 & 8) != 0 ? updateState.f109822d : false, (16381 & 16) != 0 ? updateState.f109823f : false, (16381 & 32) != 0 ? updateState.f109824g : false, (16381 & 64) != 0 ? updateState.f109825h : false, (16381 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? updateState.f109826i : false, (16381 & Function.MAX_NARGS) != 0 ? updateState.f109827j : false, (16381 & 512) != 0 ? updateState.f109828k : false, (16381 & 1024) != 0 ? updateState.f109829l : false, (16381 & 2048) != 0 ? updateState.f109830m : false, (16381 & 4096) != 0 ? updateState.f109831n : false, (16381 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? updateState.f109832o : z2);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f109740a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.c0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GeneralSettingsViewModel.AnonymousClass11.AnonymousClass1.f(z2, (GeneralSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass11(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return GeneralSettingsViewModel.this.new AnonymousClass11(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f109738a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowB = GeneralSettingsViewModel.this.p1().b();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(GeneralSettingsViewModel.this);
                this.f109738a = 1;
                if (flowB.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass11) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel$2", f = "GeneralSettingsViewModel.kt", l = {66}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f109741a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ GeneralSettingsViewModel f109743a;

            AnonymousClass1(GeneralSettingsViewModel generalSettingsViewModel) {
                this.f109743a = generalSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final GeneralSettingsViewState f(String str, GeneralSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return updateState.a((16381 & 1) != 0 ? updateState.f109819a : null, (16381 & 2) != 0 ? updateState.f109820b : null, (16381 & 4) != 0 ? updateState.f109821c : null, (16381 & 8) != 0 ? updateState.f109822d : !StringsKt.p0(str), (16381 & 16) != 0 ? updateState.f109823f : false, (16381 & 32) != 0 ? updateState.f109824g : false, (16381 & 64) != 0 ? updateState.f109825h : false, (16381 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? updateState.f109826i : false, (16381 & Function.MAX_NARGS) != 0 ? updateState.f109827j : false, (16381 & 512) != 0 ? updateState.f109828k : false, (16381 & 1024) != 0 ? updateState.f109829l : false, (16381 & 2048) != 0 ? updateState.f109830m : false, (16381 & 4096) != 0 ? updateState.f109831n : false, (16381 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? updateState.f109832o : false);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(final String str, Continuation continuation) {
                this.f109743a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.d0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GeneralSettingsViewModel.AnonymousClass2.AnonymousClass1.f(str, (GeneralSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }
        }

        AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return GeneralSettingsViewModel.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f109741a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowY = GeneralSettingsViewModel.this.l1().y();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(GeneralSettingsViewModel.this);
                this.f109741a = 1;
                if (flowY.collect(anonymousClass1, this) == objF) {
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

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel$3", f = "GeneralSettingsViewModel.kt", l = {76}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f109744a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ GeneralSettingsViewModel f109746a;

            AnonymousClass1(GeneralSettingsViewModel generalSettingsViewModel) {
                this.f109746a = generalSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final GeneralSettingsViewState f(boolean z2, GeneralSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return updateState.a((16381 & 1) != 0 ? updateState.f109819a : null, (16381 & 2) != 0 ? updateState.f109820b : null, (16381 & 4) != 0 ? updateState.f109821c : null, (16381 & 8) != 0 ? updateState.f109822d : false, (16381 & 16) != 0 ? updateState.f109823f : z2, (16381 & 32) != 0 ? updateState.f109824g : false, (16381 & 64) != 0 ? updateState.f109825h : false, (16381 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? updateState.f109826i : false, (16381 & Function.MAX_NARGS) != 0 ? updateState.f109827j : false, (16381 & 512) != 0 ? updateState.f109828k : false, (16381 & 1024) != 0 ? updateState.f109829l : false, (16381 & 2048) != 0 ? updateState.f109830m : false, (16381 & 4096) != 0 ? updateState.f109831n : false, (16381 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? updateState.f109832o : false);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f109746a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.e0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GeneralSettingsViewModel.AnonymousClass3.AnonymousClass1.f(z2, (GeneralSettingsViewState) obj);
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
            return GeneralSettingsViewModel.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f109744a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowL = GeneralSettingsViewModel.this.k1().L();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(GeneralSettingsViewModel.this);
                this.f109744a = 1;
                if (flowL.collect(anonymousClass1, this) == objF) {
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

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel$4", f = "GeneralSettingsViewModel.kt", l = {86}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f109747a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel$4$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ GeneralSettingsViewModel f109749a;

            AnonymousClass1(GeneralSettingsViewModel generalSettingsViewModel) {
                this.f109749a = generalSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final GeneralSettingsViewState f(int i3, GeneralSettingsViewModel generalSettingsViewModel, GeneralSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return updateState.a((16381 & 1) != 0 ? updateState.f109819a : null, (16381 & 2) != 0 ? updateState.f109820b : null, (16381 & 4) != 0 ? updateState.f109821c : i3 != -1 ? i3 != 1 ? generalSettingsViewModel.D0(R.string.Yj) : generalSettingsViewModel.D0(R.string.ak) : generalSettingsViewModel.D0(R.string.Zj), (16381 & 8) != 0 ? updateState.f109822d : false, (16381 & 16) != 0 ? updateState.f109823f : false, (16381 & 32) != 0 ? updateState.f109824g : false, (16381 & 64) != 0 ? updateState.f109825h : false, (16381 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? updateState.f109826i : false, (16381 & Function.MAX_NARGS) != 0 ? updateState.f109827j : false, (16381 & 512) != 0 ? updateState.f109828k : false, (16381 & 1024) != 0 ? updateState.f109829l : false, (16381 & 2048) != 0 ? updateState.f109830m : false, (16381 & 4096) != 0 ? updateState.f109831n : false, (16381 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? updateState.f109832o : false);
            }

            public final Object b(final int i3, Continuation continuation) {
                final GeneralSettingsViewModel generalSettingsViewModel = this.f109749a;
                generalSettingsViewModel.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.f0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GeneralSettingsViewModel.AnonymousClass4.AnonymousClass1.f(i3, generalSettingsViewModel, (GeneralSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Number) obj).intValue(), continuation);
            }
        }

        AnonymousClass4(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return GeneralSettingsViewModel.this.new AnonymousClass4(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f109747a;
            if (i3 == 0) {
                ResultKt.b(obj);
                MutableSharedFlow mutableSharedFlowX0 = PrefManager.f126839a.x0();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(GeneralSettingsViewModel.this);
                this.f109747a = 1;
                if (mutableSharedFlowX0.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel$5", f = "GeneralSettingsViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f109750a;

        AnonymousClass5(Continuation continuation) {
            super(2, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final GeneralSettingsViewState q(boolean z2, GeneralSettingsViewState generalSettingsViewState) {
            return generalSettingsViewState.a((16381 & 1) != 0 ? generalSettingsViewState.f109819a : null, (16381 & 2) != 0 ? generalSettingsViewState.f109820b : null, (16381 & 4) != 0 ? generalSettingsViewState.f109821c : null, (16381 & 8) != 0 ? generalSettingsViewState.f109822d : false, (16381 & 16) != 0 ? generalSettingsViewState.f109823f : false, (16381 & 32) != 0 ? generalSettingsViewState.f109824g : false, (16381 & 64) != 0 ? generalSettingsViewState.f109825h : false, (16381 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? generalSettingsViewState.f109826i : z2, (16381 & Function.MAX_NARGS) != 0 ? generalSettingsViewState.f109827j : false, (16381 & 512) != 0 ? generalSettingsViewState.f109828k : false, (16381 & 1024) != 0 ? generalSettingsViewState.f109829l : false, (16381 & 2048) != 0 ? generalSettingsViewState.f109830m : false, (16381 & 4096) != 0 ? generalSettingsViewState.f109831n : false, (16381 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? generalSettingsViewState.f109832o : false);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return GeneralSettingsViewModel.this.new AnonymousClass5(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f109750a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            final boolean zN = GeneralSettingsViewModel.this.t0().n();
            GeneralSettingsViewModel.this.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.g0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return GeneralSettingsViewModel.AnonymousClass5.q(zN, (GeneralSettingsViewState) obj2);
                }
            });
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass5) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel$6, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel$6", f = "GeneralSettingsViewModel.kt", l = {109}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f109752a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel$6$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ GeneralSettingsViewModel f109754a;

            AnonymousClass1(GeneralSettingsViewModel generalSettingsViewModel) {
                this.f109754a = generalSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final GeneralSettingsViewState f(TripleState tripleState, GeneralSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return updateState.a((16381 & 1) != 0 ? updateState.f109819a : null, (16381 & 2) != 0 ? updateState.f109820b : null, (16381 & 4) != 0 ? updateState.f109821c : null, (16381 & 8) != 0 ? updateState.f109822d : false, (16381 & 16) != 0 ? updateState.f109823f : false, (16381 & 32) != 0 ? updateState.f109824g : false, (16381 & 64) != 0 ? updateState.f109825h : false, (16381 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? updateState.f109826i : false, (16381 & Function.MAX_NARGS) != 0 ? updateState.f109827j : tripleState == TripleState.True, (16381 & 512) != 0 ? updateState.f109828k : false, (16381 & 1024) != 0 ? updateState.f109829l : false, (16381 & 2048) != 0 ? updateState.f109830m : false, (16381 & 4096) != 0 ? updateState.f109831n : false, (16381 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? updateState.f109832o : false);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(final TripleState tripleState, Continuation continuation) {
                this.f109754a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.h0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GeneralSettingsViewModel.AnonymousClass6.AnonymousClass1.f(tripleState, (GeneralSettingsViewState) obj);
                    }
                });
                return Unit.f139807a;
            }
        }

        AnonymousClass6(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return GeneralSettingsViewModel.this.new AnonymousClass6(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f109752a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowA0 = GeneralSettingsViewModel.this.j1().a0();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(GeneralSettingsViewModel.this);
                this.f109752a = 1;
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
            return ((AnonymousClass6) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel$7, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel$7", f = "GeneralSettingsViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass7 extends SuspendLambda implements Function3<Boolean, QuickBlockProfileDTO, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f109755a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ boolean f109756b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f109757c;

        AnonymousClass7(Continuation continuation) {
            super(3, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final GeneralSettingsViewState y(boolean z2, QuickBlockProfileDTO quickBlockProfileDTO, GeneralSettingsViewState generalSettingsViewState) {
            Profile profileH;
            boolean z3 = false;
            if (quickBlockProfileDTO != null && (profileH = quickBlockProfileDTO.h()) != null && !profileH.G()) {
                z3 = true;
            }
            return generalSettingsViewState.a((16381 & 1) != 0 ? generalSettingsViewState.f109819a : null, (16381 & 2) != 0 ? generalSettingsViewState.f109820b : null, (16381 & 4) != 0 ? generalSettingsViewState.f109821c : null, (16381 & 8) != 0 ? generalSettingsViewState.f109822d : false, (16381 & 16) != 0 ? generalSettingsViewState.f109823f : false, (16381 & 32) != 0 ? generalSettingsViewState.f109824g : z2, (16381 & 64) != 0 ? generalSettingsViewState.f109825h : z3, (16381 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? generalSettingsViewState.f109826i : false, (16381 & Function.MAX_NARGS) != 0 ? generalSettingsViewState.f109827j : false, (16381 & 512) != 0 ? generalSettingsViewState.f109828k : false, (16381 & 1024) != 0 ? generalSettingsViewState.f109829l : false, (16381 & 2048) != 0 ? generalSettingsViewState.f109830m : false, (16381 & 4096) != 0 ? generalSettingsViewState.f109831n : false, (16381 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? generalSettingsViewState.f109832o : false);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return q(((Boolean) obj).booleanValue(), (QuickBlockProfileDTO) obj2, (Continuation) obj3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            final boolean z2 = this.f109756b;
            final QuickBlockProfileDTO quickBlockProfileDTO = (QuickBlockProfileDTO) this.f109757c;
            IntrinsicsKt.f();
            if (this.f109755a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            GeneralSettingsViewModel.this.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.i0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return GeneralSettingsViewModel.AnonymousClass7.y(z2, quickBlockProfileDTO, (GeneralSettingsViewState) obj2);
                }
            });
            return Unit.f139807a;
        }

        public final Object q(boolean z2, QuickBlockProfileDTO quickBlockProfileDTO, Continuation continuation) {
            AnonymousClass7 anonymousClass7 = GeneralSettingsViewModel.this.new AnonymousClass7(continuation);
            anonymousClass7.f109756b = z2;
            anonymousClass7.f109757c = quickBlockProfileDTO;
            return anonymousClass7.invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel$8, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel$8", f = "GeneralSettingsViewModel.kt", l = {ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f109759a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel$8$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ GeneralSettingsViewModel f109761a;

            AnonymousClass1(GeneralSettingsViewModel generalSettingsViewModel) {
                this.f109761a = generalSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final GeneralSettingsViewState f(boolean z2, GeneralSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return updateState.a((16381 & 1) != 0 ? updateState.f109819a : null, (16381 & 2) != 0 ? updateState.f109820b : null, (16381 & 4) != 0 ? updateState.f109821c : null, (16381 & 8) != 0 ? updateState.f109822d : false, (16381 & 16) != 0 ? updateState.f109823f : false, (16381 & 32) != 0 ? updateState.f109824g : false, (16381 & 64) != 0 ? updateState.f109825h : false, (16381 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? updateState.f109826i : false, (16381 & Function.MAX_NARGS) != 0 ? updateState.f109827j : false, (16381 & 512) != 0 ? updateState.f109828k : false, (16381 & 1024) != 0 ? updateState.f109829l : z2, (16381 & 2048) != 0 ? updateState.f109830m : false, (16381 & 4096) != 0 ? updateState.f109831n : false, (16381 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? updateState.f109832o : false);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f109761a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.j0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GeneralSettingsViewModel.AnonymousClass8.AnonymousClass1.f(z2, (GeneralSettingsViewState) obj);
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
            return GeneralSettingsViewModel.this.new AnonymousClass8(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f109759a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowC3 = GeneralSettingsViewModel.this.i1().c3();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(GeneralSettingsViewModel.this);
                this.f109759a = 1;
                if (flowC3.collect(anonymousClass1, this) == objF) {
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

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel$9, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel$9", f = "GeneralSettingsViewModel.kt", l = {137}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass9 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f109762a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel$9$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ GeneralSettingsViewModel f109764a;

            AnonymousClass1(GeneralSettingsViewModel generalSettingsViewModel) {
                this.f109764a = generalSettingsViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final GeneralSettingsViewState f(boolean z2, GeneralSettingsViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return updateState.a((16381 & 1) != 0 ? updateState.f109819a : null, (16381 & 2) != 0 ? updateState.f109820b : null, (16381 & 4) != 0 ? updateState.f109821c : null, (16381 & 8) != 0 ? updateState.f109822d : false, (16381 & 16) != 0 ? updateState.f109823f : false, (16381 & 32) != 0 ? updateState.f109824g : false, (16381 & 64) != 0 ? updateState.f109825h : false, (16381 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? updateState.f109826i : false, (16381 & Function.MAX_NARGS) != 0 ? updateState.f109827j : false, (16381 & 512) != 0 ? updateState.f109828k : false, (16381 & 1024) != 0 ? updateState.f109829l : false, (16381 & 2048) != 0 ? updateState.f109830m : z2, (16381 & 4096) != 0 ? updateState.f109831n : false, (16381 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? updateState.f109832o : false);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f109764a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.k0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GeneralSettingsViewModel.AnonymousClass9.AnonymousClass1.f(z2, (GeneralSettingsViewState) obj);
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
            return GeneralSettingsViewModel.this.new AnonymousClass9(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f109762a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowE0 = GeneralSettingsViewModel.this.o1().e0();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(GeneralSettingsViewModel.this);
                this.f109762a = 1;
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
            return ((AnonymousClass9) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GeneralSettingsViewModel(Application app) {
        super(app, new GeneralSettingsViewState(null, null, null, false, false, false, false, false, false, false, false, false, false, false, 16383, null));
        Intrinsics.checkNotNullParameter(app, "app");
        final Qualifier qualifier = null;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f109721o = LazyKt.a(lazyThreadSafetyModeB, new Function0<CoreMultiProcessDataStore>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreMultiProcessDataStore.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f109722p = LazyKt.a(lazyThreadSafetyModeB2, new Function0<PassCodeDataStore>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PassCodeDataStore.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f109723q = LazyKt.a(lazyThreadSafetyModeB3, new Function0<InAppUpdatesDataStore>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(InAppUpdatesDataStore.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f109724r = LazyKt.a(lazyThreadSafetyModeB4, new Function0<QuickBlockDataStore>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(QuickBlockDataStore.class), objArr6, objArr7);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB5 = koinPlatformTools.b();
        final Object[] objArr8 = 0 == true ? 1 : 0;
        final Object[] objArr9 = 0 == true ? 1 : 0;
        this.f109725s = LazyKt.a(lazyThreadSafetyModeB5, new Function0<QuickBlockRepository>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(QuickBlockRepository.class), objArr8, objArr9);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB6 = koinPlatformTools.b();
        final Object[] objArr10 = 0 == true ? 1 : 0;
        final Object[] objArr11 = 0 == true ? 1 : 0;
        this.f109726t = LazyKt.a(lazyThreadSafetyModeB6, new Function0<ProfileDao>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel$special$$inlined$inject$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ProfileDao.class), objArr10, objArr11);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB7 = koinPlatformTools.b();
        final Object[] objArr12 = 0 == true ? 1 : 0;
        final Object[] objArr13 = 0 == true ? 1 : 0;
        this.f109727u = LazyKt.a(lazyThreadSafetyModeB7, new Function0<StrictModeRepository>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel$special$$inlined$inject$default$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeRepository.class), objArr12, objArr13);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB8 = koinPlatformTools.b();
        final Object[] objArr14 = 0 == true ? 1 : 0;
        final Object[] objArr15 = 0 == true ? 1 : 0;
        this.f109728v = LazyKt.a(lazyThreadSafetyModeB8, new Function0<ApplicationDao>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel$special$$inlined$inject$default$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ApplicationDao.class), objArr14, objArr15);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB9 = koinPlatformTools.b();
        final Object[] objArr16 = 0 == true ? 1 : 0;
        final Object[] objArr17 = 0 == true ? 1 : 0;
        this.f109729w = LazyKt.a(lazyThreadSafetyModeB9, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel$special$$inlined$inject$default$9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreDataStore.class), objArr16, objArr17);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB10 = koinPlatformTools.b();
        final Object[] objArr18 = 0 == true ? 1 : 0;
        final Object[] objArr19 = 0 == true ? 1 : 0;
        this.f109730x = LazyKt.a(lazyThreadSafetyModeB10, new Function0<StreakAvailability>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel$special$$inlined$inject$default$10
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StreakAvailability.class), objArr18, objArr19);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB11 = koinPlatformTools.b();
        final Object[] objArr20 = 0 == true ? 1 : 0;
        final Object[] objArr21 = 0 == true ? 1 : 0;
        this.f109731y = LazyKt.a(lazyThreadSafetyModeB11, new Function0<StatisticsDataStore>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewModel$special$$inlined$inject$default$11
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
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass1(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass2(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass3(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass4(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass5(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass6(null), 3, null);
        FlowKt.Q(FlowKt.m(m1().B(), n1().s(), new AnonymousClass7(null)), C0());
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass8(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass9(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass10(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass11(null), 3, null);
    }

    public static final /* synthetic */ GeneralSettingsViewState S0(GeneralSettingsViewModel generalSettingsViewModel) {
        return (GeneralSettingsViewState) generalSettingsViewModel.I0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GeneralSettingsViewState g1(GeneralSettingsViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return updateState.a((16381 & 1) != 0 ? updateState.f109819a : LanguagePickerDialogFragmentKt.c(AppCompatDelegate.q()), (16381 & 2) != 0 ? updateState.f109820b : null, (16381 & 4) != 0 ? updateState.f109821c : null, (16381 & 8) != 0 ? updateState.f109822d : false, (16381 & 16) != 0 ? updateState.f109823f : false, (16381 & 32) != 0 ? updateState.f109824g : false, (16381 & 64) != 0 ? updateState.f109825h : false, (16381 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? updateState.f109826i : false, (16381 & Function.MAX_NARGS) != 0 ? updateState.f109827j : false, (16381 & 512) != 0 ? updateState.f109828k : false, (16381 & 1024) != 0 ? updateState.f109829l : false, (16381 & 2048) != 0 ? updateState.f109830m : false, (16381 & 4096) != 0 ? updateState.f109831n : false, (16381 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? updateState.f109832o : false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ApplicationDao h1() {
        return (ApplicationDao) this.f109728v.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoreDataStore i1() {
        return (CoreDataStore) this.f109729w.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoreMultiProcessDataStore j1() {
        return (CoreMultiProcessDataStore) this.f109721o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InAppUpdatesDataStore k1() {
        return (InAppUpdatesDataStore) this.f109723q.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PassCodeDataStore l1() {
        return (PassCodeDataStore) this.f109722p.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QuickBlockDataStore m1() {
        return (QuickBlockDataStore) this.f109724r.getValue();
    }

    private final QuickBlockRepository n1() {
        return (QuickBlockRepository) this.f109725s.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StatisticsDataStore o1() {
        return (StatisticsDataStore) this.f109731y.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StreakAvailability p1() {
        return (StreakAvailability) this.f109730x.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StrictModeRepository t0() {
        return (StrictModeRepository) this.f109727u.getValue();
    }

    public final void f1() {
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.z
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GeneralSettingsViewModel.g1((GeneralSettingsViewState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: q1, reason: merged with bridge method [inline-methods] */
    public void O0(GeneralSettingsViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event, GeneralSettingsViewEvent.OnInAppsUpdateClicked.f109717a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new GeneralSettingsViewModel$onEvent$1(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, GeneralSettingsViewEvent.OnQuickBlockSwitchClicked.f109719a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new GeneralSettingsViewModel$onEvent$2(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, GeneralSettingsViewEvent.OnAllowCategoriesClicked.f109714a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new GeneralSettingsViewModel$onEvent$3(this, null), 3, null);
            return;
        }
        if (event instanceof GeneralSettingsViewEvent.OnCategoriesAllowed) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new GeneralSettingsViewModel$onEvent$4(this, event, null), 3, null);
            return;
        }
        if (event instanceof GeneralSettingsViewEvent.OnDailyTrendBadgeClicked) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new GeneralSettingsViewModel$onEvent$5(this, null), 3, null);
        } else if (event instanceof GeneralSettingsViewEvent.OnMoodCheckInAutoShowClicked) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new GeneralSettingsViewModel$onEvent$6(this, null), 3, null);
        } else {
            if (!(event instanceof GeneralSettingsViewEvent.OnStreaksEnabledClicked)) {
                throw new NoWhenBranchMatchedException();
            }
            BuildersKt__Builders_commonKt.d(C0(), null, null, new GeneralSettingsViewModel$onEvent$7(this, null), 3, null);
        }
    }
}
