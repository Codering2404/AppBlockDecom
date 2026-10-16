package cz.mobilesoft.coreblock.scene.feedback;

import android.app.Application;
import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.util.Patterns;
import androidx.lifecycle.ViewModelKt;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.enums.ContactReason;
import cz.mobilesoft.coreblock.repository.DiagnosticRepository;
import cz.mobilesoft.coreblock.repository.StrictModeRepository;
import cz.mobilesoft.coreblock.scene.feedback.FeedbackViewEvent;
import cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel;
import cz.mobilesoft.coreblock.scene.feedback.FeedbackViewState;
import cz.mobilesoft.coreblock.scene.more.haf.HaFRequestHelper;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.storage.datastore.SessionDataStore;
import cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore;
import cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore;
import cz.mobilesoft.coreblock.usecase.SendContactSupportDetailedRequestUseCase;
import cz.mobilesoft.coreblock.util.NetworkHelperKt;
import cz.mobilesoft.coreblock.util.VideoCompressionManager;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableList;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class FeedbackViewModel extends BaseStatefulViewModel<FeedbackViewState, FeedbackViewEvent, FeedbackViewCommand> {
    private Map A;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final SendContactSupportDetailedRequestUseCase f102081o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final boolean f102082p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final boolean f102083q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final String f102084r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final String f102085s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Lazy f102086t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Lazy f102087u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Lazy f102088v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final Lazy f102089w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final Lazy f102090x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final Lazy f102091y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final Lazy f102092z;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel$1", f = "FeedbackViewModel.kt", l = {76, 77, 78}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f102093a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f102094b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f102095c;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ ContactReason f102097f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ContactReason contactReason, Continuation continuation) {
            super(2, continuation);
            this.f102097f = contactReason;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final FeedbackViewState q(boolean z2, ContactReason contactReason, boolean z3, FeedbackViewState feedbackViewState) {
            ContactReason contactReason2;
            ContactReason contactReason3;
            if (z2) {
                contactReason2 = contactReason;
                if (contactReason2 == ContactReason.EmergencyUnblocking) {
                    contactReason3 = null;
                }
                return feedbackViewState.a((10223 & 1) != 0 ? feedbackViewState.f102177a : null, (10223 & 2) != 0 ? feedbackViewState.f102178b : null, (10223 & 4) != 0 ? feedbackViewState.f102179c : null, (10223 & 8) != 0 ? feedbackViewState.f102180d : null, (10223 & 16) != 0 ? feedbackViewState.f102181f : contactReason3, (10223 & 32) != 0 ? feedbackViewState.f102182g : false, (10223 & 64) != 0 ? feedbackViewState.f102183h : false, (10223 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? feedbackViewState.f102184i : 0, (10223 & Function.MAX_NARGS) != 0 ? feedbackViewState.f102185j : null, (10223 & 512) != 0 ? feedbackViewState.f102186k : null, (10223 & 1024) != 0 ? feedbackViewState.f102187l : false, (10223 & 2048) != 0 ? feedbackViewState.f102188m : z2, (10223 & 4096) != 0 ? feedbackViewState.f102189n : z3, (10223 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? feedbackViewState.f102190o : false);
            }
            contactReason2 = contactReason;
            contactReason3 = contactReason2;
            return feedbackViewState.a((10223 & 1) != 0 ? feedbackViewState.f102177a : null, (10223 & 2) != 0 ? feedbackViewState.f102178b : null, (10223 & 4) != 0 ? feedbackViewState.f102179c : null, (10223 & 8) != 0 ? feedbackViewState.f102180d : null, (10223 & 16) != 0 ? feedbackViewState.f102181f : contactReason3, (10223 & 32) != 0 ? feedbackViewState.f102182g : false, (10223 & 64) != 0 ? feedbackViewState.f102183h : false, (10223 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? feedbackViewState.f102184i : 0, (10223 & Function.MAX_NARGS) != 0 ? feedbackViewState.f102185j : null, (10223 & 512) != 0 ? feedbackViewState.f102186k : null, (10223 & 1024) != 0 ? feedbackViewState.f102187l : false, (10223 & 2048) != 0 ? feedbackViewState.f102188m : z2, (10223 & 4096) != 0 ? feedbackViewState.f102189n : z3, (10223 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? feedbackViewState.f102190o : false);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return FeedbackViewModel.this.new AnonymousClass1(this.f102097f, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x0071  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x007e  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00a3  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00a5  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x00ae  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r6.f102095c
                r2 = 3
                r3 = 2
                r4 = 0
                r5 = 1
                if (r1 == 0) goto L31
                if (r1 == r5) goto L2d
                if (r1 == r3) goto L25
                if (r1 != r2) goto L1d
                int r0 = r6.f102094b
                java.lang.Object r1 = r6.f102093a
                cz.mobilesoft.coreblock.enums.StrictModeAccessMethod r1 = (cz.mobilesoft.coreblock.enums.StrictModeAccessMethod) r1
                kotlin.ResultKt.b(r7)
                goto L9b
            L1d:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L25:
                java.lang.Object r1 = r6.f102093a
                cz.mobilesoft.coreblock.enums.StrictModeAccessMethod r1 = (cz.mobilesoft.coreblock.enums.StrictModeAccessMethod) r1
                kotlin.ResultKt.b(r7)
                goto L5f
            L2d:
                kotlin.ResultKt.b(r7)
                goto L47
            L31:
                kotlin.ResultKt.b(r7)
                cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel r7 = cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel.this
                cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore r7 = cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel.n1(r7)
                kotlinx.coroutines.flow.Flow r7 = r7.f0()
                r6.f102095c = r5
                java.lang.Object r7 = kotlinx.coroutines.flow.FlowKt.D(r7, r6)
                if (r7 != r0) goto L47
                goto L98
            L47:
                r1 = r7
                cz.mobilesoft.coreblock.enums.StrictModeAccessMethod r1 = (cz.mobilesoft.coreblock.enums.StrictModeAccessMethod) r1
                cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel r7 = cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel.this
                cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r7 = cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel.h1(r7)
                kotlinx.coroutines.flow.Flow r7 = r7.B3()
                r6.f102093a = r1
                r6.f102095c = r3
                java.lang.Object r7 = kotlinx.coroutines.flow.FlowKt.D(r7, r6)
                if (r7 != r0) goto L5f
                goto L98
            L5f:
                java.lang.Boolean r7 = (java.lang.Boolean) r7
                boolean r7 = r7.booleanValue()
                if (r7 == 0) goto L71
                cz.mobilesoft.coreblock.enums.StrictModeAccessMethod r7 = cz.mobilesoft.coreblock.enums.StrictModeAccessMethod.Timer
                if (r1 == r7) goto L6f
                cz.mobilesoft.coreblock.enums.StrictModeAccessMethod r7 = cz.mobilesoft.coreblock.enums.StrictModeAccessMethod.FollowSchedules
                if (r1 != r7) goto L71
            L6f:
                r7 = r5
                goto L72
            L71:
                r7 = r4
            L72:
                cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel r3 = cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel.this
                cz.mobilesoft.coreblock.repository.StrictModeRepository r3 = cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel.o1(r3)
                boolean r3 = r3.n()
                if (r3 != 0) goto La6
                cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel r3 = cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel.this
                cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r3 = cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel.h1(r3)
                kotlinx.coroutines.flow.Flow r3 = r3.B3()
                java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.a(r1)
                r6.f102093a = r1
                r6.f102094b = r7
                r6.f102095c = r2
                java.lang.Object r1 = kotlinx.coroutines.flow.FlowKt.D(r3, r6)
                if (r1 != r0) goto L99
            L98:
                return r0
            L99:
                r0 = r7
                r7 = r1
            L9b:
                java.lang.Boolean r7 = (java.lang.Boolean) r7
                boolean r7 = r7.booleanValue()
                if (r7 == 0) goto La5
                r7 = r5
                goto La8
            La5:
                r7 = r0
            La6:
                r0 = r7
                r7 = r4
            La8:
                cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel r1 = cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel.this
                cz.mobilesoft.coreblock.enums.ContactReason r2 = r6.f102097f
                if (r0 == 0) goto Laf
                r4 = r5
            Laf:
                cz.mobilesoft.coreblock.scene.feedback.d1 r0 = new cz.mobilesoft.coreblock.scene.feedback.d1
                r0.<init>()
                cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel.s1(r1, r0)
                kotlin.Unit r7 = kotlin.Unit.f139807a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel$2", f = "FeedbackViewModel.kt", l = {95, 109}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f102098a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel$2$1", f = "FeedbackViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
        static final class AnonymousClass1 extends SuspendLambda implements Function4<String, String, String, Continuation<? super Triple<? extends String, ? extends String, ? extends String>>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f102100a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f102101b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            /* synthetic */ Object f102102c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            /* synthetic */ Object f102103d;

            AnonymousClass1(Continuation continuation) {
                super(4, continuation);
            }

            @Override // kotlin.jvm.functions.Function4
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public final Object invoke(String str, String str2, String str3, Continuation continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
                anonymousClass1.f102101b = str;
                anonymousClass1.f102102c = str2;
                anonymousClass1.f102103d = str3;
                return anonymousClass1.invokeSuspend(Unit.f139807a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                String str = (String) this.f102101b;
                String str2 = (String) this.f102102c;
                String str3 = (String) this.f102103d;
                IntrinsicsKt.f();
                if (this.f102100a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return new Triple(str, str2, str3);
            }
        }

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel$2$3, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass3<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ FeedbackViewModel f102104a;

            AnonymousClass3(FeedbackViewModel feedbackViewModel) {
                this.f102104a = feedbackViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final FeedbackViewState f(String str, FeedbackViewModel feedbackViewModel, FeedbackViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return updateState.a((10223 & 1) != 0 ? updateState.f102177a : null, (10223 & 2) != 0 ? updateState.f102178b : null, (10223 & 4) != 0 ? updateState.f102179c : null, (10223 & 8) != 0 ? updateState.f102180d : null, (10223 & 16) != 0 ? updateState.f102181f : null, (10223 & 32) != 0 ? updateState.f102182g : false, (10223 & 64) != 0 ? updateState.f102183h : false, (10223 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? updateState.f102184i : 0, (10223 & Function.MAX_NARGS) != 0 ? updateState.f102185j : null, (10223 & 512) != 0 ? updateState.f102186k : str != null ? (List) feedbackViewModel.A.get(str) : null, (10223 & 1024) != 0 ? updateState.f102187l : false, (10223 & 2048) != 0 ? updateState.f102188m : false, (10223 & 4096) != 0 ? updateState.f102189n : false, (10223 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? updateState.f102190o : false);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(HaFRequestHelper.HafState hafState, Continuation continuation) {
                this.f102104a.A = hafState.i();
                ContactReason contactReasonJ = FeedbackViewModel.f1(this.f102104a).j();
                final String reason = contactReasonJ != null ? contactReasonJ.getReason() : null;
                final FeedbackViewModel feedbackViewModel = this.f102104a;
                feedbackViewModel.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.feedback.f1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FeedbackViewModel.AnonymousClass2.AnonymousClass3.f(reason, feedbackViewModel, (FeedbackViewState) obj);
                    }
                });
                return Unit.f139807a;
            }
        }

        AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final FeedbackViewState q(String str, String str2, FeedbackViewModel feedbackViewModel, FeedbackViewState feedbackViewState) {
            return feedbackViewState.a((10223 & 1) != 0 ? feedbackViewState.f102177a : str, (10223 & 2) != 0 ? feedbackViewState.f102178b : str2, (10223 & 4) != 0 ? feedbackViewState.f102179c : str2, (10223 & 8) != 0 ? feedbackViewState.f102180d : null, (10223 & 16) != 0 ? feedbackViewState.f102181f : null, (10223 & 32) != 0 ? feedbackViewState.f102182g : false, (10223 & 64) != 0 ? feedbackViewState.f102183h : false, (10223 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? feedbackViewState.f102184i : 0, (10223 & Function.MAX_NARGS) != 0 ? feedbackViewState.f102185j : !NetworkHelperKt.c(feedbackViewModel.A0()) ? SetsKt.setOf(FeedbackViewState.FeedbackValidationError.NoInternetConnection) : SetsKt.emptySet(), (10223 & 512) != 0 ? feedbackViewState.f102186k : null, (10223 & 1024) != 0 ? feedbackViewState.f102187l : false, (10223 & 2048) != 0 ? feedbackViewState.f102188m : false, (10223 & 4096) != 0 ? feedbackViewState.f102189n : false, (10223 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? feedbackViewState.f102190o : false);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return FeedbackViewModel.this.new AnonymousClass2(continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0090, code lost:
        
            if (r8.collect(r1, r7) == r0) goto L22;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r7.f102098a
                r2 = 0
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L20
                if (r1 == r4) goto L1c
                if (r1 == r3) goto L17
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L17:
                kotlin.ResultKt.b(r8)
                goto L93
            L1c:
                kotlin.ResultKt.b(r8)
                goto L53
            L20:
                kotlin.ResultKt.b(r8)
                cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel r8 = cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel.this
                cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r8 = cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel.h1(r8)
                kotlinx.coroutines.flow.Flow r8 = r8.y2()
                cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel r1 = cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel.this
                cz.mobilesoft.coreblock.storage.datastore.SessionDataStore r1 = cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel.m1(r1)
                kotlinx.coroutines.flow.Flow r1 = r1.S()
                cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel r5 = cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel.this
                cz.mobilesoft.coreblock.storage.datastore.SessionDataStore r5 = cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel.m1(r5)
                kotlinx.coroutines.flow.Flow r5 = r5.U()
                cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel$2$1 r6 = new cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel$2$1
                r6.<init>(r2)
                kotlinx.coroutines.flow.Flow r8 = kotlinx.coroutines.flow.FlowKt.n(r8, r1, r5, r6)
                r7.f102098a = r4
                java.lang.Object r8 = kotlinx.coroutines.flow.FlowKt.D(r8, r7)
                if (r8 != r0) goto L53
                goto L92
            L53:
                cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel r1 = cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel.this
                kotlin.Triple r8 = (kotlin.Triple) r8
                java.lang.Object r4 = r8.a()
                java.lang.String r4 = (java.lang.String) r4
                java.lang.Object r5 = r8.b()
                java.lang.String r5 = (java.lang.String) r5
                java.lang.Object r8 = r8.c()
                java.lang.String r8 = (java.lang.String) r8
                int r6 = r8.length()
                if (r6 != 0) goto L70
                goto L71
            L70:
                r2 = r8
            L71:
                if (r2 != 0) goto L74
                goto L75
            L74:
                r5 = r2
            L75:
                cz.mobilesoft.coreblock.scene.feedback.e1 r8 = new cz.mobilesoft.coreblock.scene.feedback.e1
                r8.<init>()
                cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel.s1(r1, r8)
                cz.mobilesoft.coreblock.scene.more.haf.HaFRequestHelper r8 = cz.mobilesoft.coreblock.scene.more.haf.HaFRequestHelper.f107559a
                kotlinx.coroutines.flow.StateFlow r8 = r8.i()
                cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel$2$3 r1 = new cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel$2$3
                cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel r2 = cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel.this
                r1.<init>(r2)
                r7.f102098a = r3
                java.lang.Object r8 = r8.collect(r1, r7)
                if (r8 != r0) goto L93
            L92:
                return r0
            L93:
                kotlin.KotlinNothingValueException r8 = new kotlin.KotlinNothingValueException
                r8.<init>()
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel$3", f = "FeedbackViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f102105a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ boolean f102106b;

        AnonymousClass3(Continuation continuation) {
            super(2, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final FeedbackViewState q(boolean z2, FeedbackViewState feedbackViewState) {
            return feedbackViewState.a((10223 & 1) != 0 ? feedbackViewState.f102177a : null, (10223 & 2) != 0 ? feedbackViewState.f102178b : null, (10223 & 4) != 0 ? feedbackViewState.f102179c : null, (10223 & 8) != 0 ? feedbackViewState.f102180d : null, (10223 & 16) != 0 ? feedbackViewState.f102181f : null, (10223 & 32) != 0 ? feedbackViewState.f102182g : false, (10223 & 64) != 0 ? feedbackViewState.f102183h : false, (10223 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? feedbackViewState.f102184i : 0, (10223 & Function.MAX_NARGS) != 0 ? feedbackViewState.f102185j : null, (10223 & 512) != 0 ? feedbackViewState.f102186k : null, (10223 & 1024) != 0 ? feedbackViewState.f102187l : false, (10223 & 2048) != 0 ? feedbackViewState.f102188m : false, (10223 & 4096) != 0 ? feedbackViewState.f102189n : false, (10223 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? feedbackViewState.f102190o : z2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass3 anonymousClass3 = FeedbackViewModel.this.new AnonymousClass3(continuation);
            anonymousClass3.f102106b = ((Boolean) obj).booleanValue();
            return anonymousClass3;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke(((Boolean) obj).booleanValue(), (Continuation) obj2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            final boolean z2 = this.f102106b;
            IntrinsicsKt.f();
            if (this.f102105a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            FeedbackViewModel.this.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.feedback.g1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return FeedbackViewModel.AnonymousClass3.q(z2, (FeedbackViewState) obj2);
                }
            });
            return Unit.f139807a;
        }

        public final Object invoke(boolean z2, Continuation continuation) {
            return ((AnonymousClass3) create(Boolean.valueOf(z2), continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f102108a;

        static {
            int[] iArr = new int[ContactReason.values().length];
            try {
                iArr[ContactReason.ProblemsWithPremium.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ContactReason.FeatureSuggestion.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f102108a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FeedbackViewModel(Application application, SendContactSupportDetailedRequestUseCase sendContactSupportDetailedRequestUseCase, ContactReason contactReason, boolean z2, boolean z3, String str, String str2) {
        super(application, new FeedbackViewState(null, null, null, null, null, false, false, 0, null, null, false, false, false, false, 16383, null));
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(sendContactSupportDetailedRequestUseCase, "sendContactSupportDetailedRequestUseCase");
        this.f102081o = sendContactSupportDetailedRequestUseCase;
        this.f102082p = z2;
        this.f102083q = z3;
        this.f102084r = str;
        this.f102085s = str2;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f102086t = LazyKt.a(lazyThreadSafetyModeB, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreDataStore.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f102087u = LazyKt.a(lazyThreadSafetyModeB2, new Function0<SessionDataStore>() { // from class: cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(SessionDataStore.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f102088v = LazyKt.a(lazyThreadSafetyModeB3, new Function0<DiagnosticRepository>() { // from class: cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DiagnosticRepository.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f102089w = LazyKt.a(lazyThreadSafetyModeB4, new Function0<StrictModeRepository>() { // from class: cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeRepository.class), objArr6, objArr7);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB5 = koinPlatformTools.b();
        final Object[] objArr8 = 0 == true ? 1 : 0;
        final Object[] objArr9 = 0 == true ? 1 : 0;
        this.f102090x = LazyKt.a(lazyThreadSafetyModeB5, new Function0<StrictModeDataStore>() { // from class: cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeDataStore.class), objArr8, objArr9);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB6 = koinPlatformTools.b();
        final Object[] objArr10 = 0 == true ? 1 : 0;
        final Object[] objArr11 = 0 == true ? 1 : 0;
        this.f102091y = LazyKt.a(lazyThreadSafetyModeB6, new Function0<DevDataStore>() { // from class: cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel$special$$inlined$inject$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DevDataStore.class), objArr10, objArr11);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB7 = koinPlatformTools.b();
        final Object[] objArr12 = 0 == true ? 1 : 0;
        final Object[] objArr13 = 0 == true ? 1 : 0;
        this.f102092z = LazyKt.a(lazyThreadSafetyModeB7, new Function0<VideoCompressionManager>() { // from class: cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel$special$$inlined$inject$default$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(VideoCompressionManager.class), objArr12, objArr13);
            }
        });
        this.A = MapsKt.emptyMap();
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass1(contactReason, null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass2(null), 3, null);
        FlowKt.Q(FlowKt.V(A1().y3(), new AnonymousClass3(null)), C0());
        if (contactReason != null) {
            Y1(contactReason);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoreDataStore A1() {
        return (CoreDataStore) this.f102086t.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DevDataStore B1() {
        return (DevDataStore) this.f102091y.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DiagnosticRepository C1() {
        return (DiagnosticRepository) this.f102088v.getValue();
    }

    private final Long E1(Uri uri) throws FileNotFoundException {
        Long lValueOf;
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = A0().getContentResolver().openAssetFileDescriptor(uri, "r");
        if (assetFileDescriptorOpenAssetFileDescriptor != null) {
            try {
                lValueOf = Long.valueOf(assetFileDescriptorOpenAssetFileDescriptor.getLength());
            } finally {
            }
        } else {
            lValueOf = null;
        }
        CloseableKt.a(assetFileDescriptorOpenAssetFileDescriptor, null);
        return lValueOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0097, code lost:
    
        if (r11 == r1) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object F1(cz.mobilesoft.coreblock.repository.DiagnosticRepository r9, cz.mobilesoft.coreblock.enums.ContactReason r10, kotlin.coroutines.Continuation r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 234
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel.F1(cz.mobilesoft.coreblock.repository.DiagnosticRepository, cz.mobilesoft.coreblock.enums.ContactReason, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SessionDataStore G1() {
        return (SessionDataStore) this.f102087u.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StrictModeDataStore H1() {
        return (StrictModeDataStore) this.f102090x.getValue();
    }

    private final VideoCompressionManager I1() {
        return (VideoCompressionManager) this.f102092z.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J1(Uri uri) throws FileNotFoundException {
        Long lE1 = E1(uri);
        long jB = 0;
        long jLongValue = lE1 != null ? lE1.longValue() : 0L;
        long j3 = 20000000;
        Iterator<E> it = ((FeedbackViewState) I0()).d().iterator();
        while (it.hasNext()) {
            jB += ((FeedbackViewState.FreshdeskAttachment) it.next()).b();
        }
        long j4 = j3 - jB;
        if (1 > jLongValue || jLongValue > j4) {
            if (w1(uri)) {
                L1(uri, j4, jLongValue);
                return;
            } else {
                Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.feedback.b1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FeedbackViewModel.K1((FeedbackViewState) obj);
                    }
                });
                return;
            }
        }
        if (w1(uri)) {
            AnswersHelper.f128199a.w1(false, true, h2(jLongValue));
        }
        ContentResolver contentResolver = A0().getContentResolver();
        Intrinsics.checkNotNullExpressionValue(contentResolver, "getContentResolver(...)");
        String strG2 = g2(contentResolver, uri);
        if (strG2 == null) {
            strG2 = "";
        }
        u1(new FeedbackViewState.FreshdeskAttachment.UriFile(strG2, jLongValue, uri));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FeedbackViewState K1(FeedbackViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        Set mutableSet = CollectionsKt.toMutableSet(updateState.n());
        mutableSet.add(FeedbackViewState.FeedbackValidationError.AttachmentSizeExceeded);
        Unit unit = Unit.f139807a;
        return updateState.a((10223 & 1) != 0 ? updateState.f102177a : null, (10223 & 2) != 0 ? updateState.f102178b : null, (10223 & 4) != 0 ? updateState.f102179c : null, (10223 & 8) != 0 ? updateState.f102180d : null, (10223 & 16) != 0 ? updateState.f102181f : null, (10223 & 32) != 0 ? updateState.f102182g : false, (10223 & 64) != 0 ? updateState.f102183h : false, (10223 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? updateState.f102184i : 0, (10223 & Function.MAX_NARGS) != 0 ? updateState.f102185j : mutableSet, (10223 & 512) != 0 ? updateState.f102186k : null, (10223 & 1024) != 0 ? updateState.f102187l : false, (10223 & 2048) != 0 ? updateState.f102188m : false, (10223 & 4096) != 0 ? updateState.f102189n : false, (10223 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? updateState.f102190o : false);
    }

    private final void L1(Uri uri, long j3, long j4) {
        FlowKt.Q(FlowKt.V(I1().s(uri, j3), new FeedbackViewModel$handleVideoCompression$1(this, j4, null)), ViewModelKt.a(this));
    }

    private final void O1(Uri uri) {
        if (((FeedbackViewState) I0()).d().size() >= 5) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new FeedbackViewModel$onAddAttachmentClicked$1(this, null), 3, null);
        } else {
            if (uri == null) {
                return;
            }
            BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), null, null, new FeedbackViewModel$onAddAttachmentClicked$2(this, uri, null), 3, null);
        }
    }

    private final void P1(final FeedbackViewState.FreshdeskAttachment freshdeskAttachment) {
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.feedback.a1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FeedbackViewModel.Q1(freshdeskAttachment, (FeedbackViewState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FeedbackViewState Q1(FeedbackViewState.FreshdeskAttachment freshdeskAttachment, FeedbackViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        List mutableList = CollectionsKt.toMutableList((Collection) updateState.d());
        mutableList.remove(freshdeskAttachment);
        Unit unit = Unit.f139807a;
        ImmutableList immutableListH = ExtensionsKt.h(mutableList);
        Set mutableSet = CollectionsKt.toMutableSet(updateState.n());
        Iterator<E> it = updateState.d().iterator();
        long jB = 0;
        while (it.hasNext()) {
            jB += ((FeedbackViewState.FreshdeskAttachment) it.next()).b();
        }
        if (jB - freshdeskAttachment.b() > 20000000) {
            mutableSet.add(FeedbackViewState.FeedbackValidationError.AttachmentSizeExceeded);
        } else {
            mutableSet.remove(FeedbackViewState.FeedbackValidationError.AttachmentSizeExceeded);
        }
        Unit unit2 = Unit.f139807a;
        return updateState.a((10223 & 1) != 0 ? updateState.f102177a : null, (10223 & 2) != 0 ? updateState.f102178b : null, (10223 & 4) != 0 ? updateState.f102179c : null, (10223 & 8) != 0 ? updateState.f102180d : immutableListH, (10223 & 16) != 0 ? updateState.f102181f : null, (10223 & 32) != 0 ? updateState.f102182g : false, (10223 & 64) != 0 ? updateState.f102183h : false, (10223 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? updateState.f102184i : 0, (10223 & Function.MAX_NARGS) != 0 ? updateState.f102185j : mutableSet, (10223 & 512) != 0 ? updateState.f102186k : null, (10223 & 1024) != 0 ? updateState.f102187l : false, (10223 & 2048) != 0 ? updateState.f102188m : false, (10223 & 4096) != 0 ? updateState.f102189n : false, (10223 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? updateState.f102190o : false);
    }

    private final void R1(final String str) {
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.feedback.s0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FeedbackViewModel.S1(str, (FeedbackViewState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FeedbackViewState S1(String str, FeedbackViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        Set mutableSet = CollectionsKt.toMutableSet(updateState.n());
        mutableSet.remove(FeedbackViewState.FeedbackValidationError.EmailsDoNotMatch);
        mutableSet.remove(FeedbackViewState.FeedbackValidationError.EmailIsInvalid);
        Unit unit = Unit.f139807a;
        return updateState.a((10223 & 1) != 0 ? updateState.f102177a : null, (10223 & 2) != 0 ? updateState.f102178b : null, (10223 & 4) != 0 ? updateState.f102179c : str, (10223 & 8) != 0 ? updateState.f102180d : null, (10223 & 16) != 0 ? updateState.f102181f : null, (10223 & 32) != 0 ? updateState.f102182g : false, (10223 & 64) != 0 ? updateState.f102183h : false, (10223 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? updateState.f102184i : 0, (10223 & Function.MAX_NARGS) != 0 ? updateState.f102185j : mutableSet, (10223 & 512) != 0 ? updateState.f102186k : null, (10223 & 1024) != 0 ? updateState.f102187l : false, (10223 & 2048) != 0 ? updateState.f102188m : false, (10223 & 4096) != 0 ? updateState.f102189n : false, (10223 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? updateState.f102190o : false);
    }

    private final void T1(final String str) {
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.feedback.u0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FeedbackViewModel.U1(str, (FeedbackViewState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FeedbackViewState U1(String str, FeedbackViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        Set mutableSet = CollectionsKt.toMutableSet(updateState.n());
        mutableSet.remove(FeedbackViewState.FeedbackValidationError.EmailsDoNotMatch);
        mutableSet.remove(FeedbackViewState.FeedbackValidationError.EmailIsInvalid);
        Unit unit = Unit.f139807a;
        return updateState.a((10223 & 1) != 0 ? updateState.f102177a : null, (10223 & 2) != 0 ? updateState.f102178b : str, (10223 & 4) != 0 ? updateState.f102179c : null, (10223 & 8) != 0 ? updateState.f102180d : null, (10223 & 16) != 0 ? updateState.f102181f : null, (10223 & 32) != 0 ? updateState.f102182g : false, (10223 & 64) != 0 ? updateState.f102183h : false, (10223 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? updateState.f102184i : 0, (10223 & Function.MAX_NARGS) != 0 ? updateState.f102185j : mutableSet, (10223 & 512) != 0 ? updateState.f102186k : null, (10223 & 1024) != 0 ? updateState.f102187l : false, (10223 & 2048) != 0 ? updateState.f102188m : false, (10223 & 4096) != 0 ? updateState.f102189n : false, (10223 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? updateState.f102190o : false);
    }

    private final void W1(final String str) {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new FeedbackViewModel$onMessageChanged$1(this, str, null), 3, null);
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.feedback.c1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FeedbackViewModel.X1(str, (FeedbackViewState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FeedbackViewState X1(String str, FeedbackViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        Set mutableSet = CollectionsKt.toMutableSet(updateState.n());
        mutableSet.remove(FeedbackViewState.FeedbackValidationError.MessageIsEmpty);
        Unit unit = Unit.f139807a;
        return updateState.a((10223 & 1) != 0 ? updateState.f102177a : str, (10223 & 2) != 0 ? updateState.f102178b : null, (10223 & 4) != 0 ? updateState.f102179c : null, (10223 & 8) != 0 ? updateState.f102180d : null, (10223 & 16) != 0 ? updateState.f102181f : null, (10223 & 32) != 0 ? updateState.f102182g : false, (10223 & 64) != 0 ? updateState.f102183h : false, (10223 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? updateState.f102184i : 0, (10223 & Function.MAX_NARGS) != 0 ? updateState.f102185j : mutableSet, (10223 & 512) != 0 ? updateState.f102186k : null, (10223 & 1024) != 0 ? updateState.f102187l : false, (10223 & 2048) != 0 ? updateState.f102188m : false, (10223 & 4096) != 0 ? updateState.f102189n : false, (10223 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? updateState.f102190o : false);
    }

    private final void Y1(final ContactReason contactReason) {
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.feedback.y0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FeedbackViewModel.Z1(contactReason, this, (FeedbackViewState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FeedbackViewState Z1(ContactReason contactReason, FeedbackViewModel feedbackViewModel, FeedbackViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        Set mutableSet = CollectionsKt.toMutableSet(updateState.n());
        mutableSet.remove(FeedbackViewState.FeedbackValidationError.MissingSelectedReason);
        Unit unit = Unit.f139807a;
        return updateState.a((10223 & 1) != 0 ? updateState.f102177a : null, (10223 & 2) != 0 ? updateState.f102178b : null, (10223 & 4) != 0 ? updateState.f102179c : null, (10223 & 8) != 0 ? updateState.f102180d : null, (10223 & 16) != 0 ? updateState.f102181f : contactReason, (10223 & 32) != 0 ? updateState.f102182g : false, (10223 & 64) != 0 ? updateState.f102183h : false, (10223 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? updateState.f102184i : 0, (10223 & Function.MAX_NARGS) != 0 ? updateState.f102185j : mutableSet, (10223 & 512) != 0 ? updateState.f102186k : (List) feedbackViewModel.A.get(contactReason.getReason()), (10223 & 1024) != 0 ? updateState.f102187l : false, (10223 & 2048) != 0 ? updateState.f102188m : false, (10223 & 4096) != 0 ? updateState.f102189n : false, (10223 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? updateState.f102190o : false);
    }

    private final void a2() {
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.feedback.z0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FeedbackViewModel.b2(this.f102431a, (FeedbackViewState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FeedbackViewState b2(FeedbackViewModel feedbackViewModel, FeedbackViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        Set mutableSet = CollectionsKt.toMutableSet(updateState.n());
        if (NetworkHelperKt.c(feedbackViewModel.A0())) {
            mutableSet.remove(FeedbackViewState.FeedbackValidationError.NoInternetConnection);
        } else {
            mutableSet.add(FeedbackViewState.FeedbackValidationError.NoInternetConnection);
        }
        Unit unit = Unit.f139807a;
        return updateState.a((10223 & 1) != 0 ? updateState.f102177a : null, (10223 & 2) != 0 ? updateState.f102178b : null, (10223 & 4) != 0 ? updateState.f102179c : null, (10223 & 8) != 0 ? updateState.f102180d : null, (10223 & 16) != 0 ? updateState.f102181f : null, (10223 & 32) != 0 ? updateState.f102182g : false, (10223 & 64) != 0 ? updateState.f102183h : false, (10223 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? updateState.f102184i : 0, (10223 & Function.MAX_NARGS) != 0 ? updateState.f102185j : mutableSet, (10223 & 512) != 0 ? updateState.f102186k : null, (10223 & 1024) != 0 ? updateState.f102187l : false, (10223 & 2048) != 0 ? updateState.f102188m : false, (10223 & 4096) != 0 ? updateState.f102189n : false, (10223 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? updateState.f102190o : false);
    }

    private final void c2() {
        if (!NetworkHelperKt.c(A0())) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.feedback.v0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return FeedbackViewModel.d2((FeedbackViewState) obj);
                }
            });
            return;
        }
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.feedback.w0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FeedbackViewModel.e2((FeedbackViewState) obj);
            }
        });
        FeedbackViewState feedbackViewState = (FeedbackViewState) I0();
        if (feedbackViewState.n().isEmpty()) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.feedback.x0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return FeedbackViewModel.f2((FeedbackViewState) obj);
                }
            });
            BuildersKt__Builders_commonKt.d(C0(), null, null, new FeedbackViewModel$onSendClicked$4(feedbackViewState, this, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FeedbackViewState d2(FeedbackViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        Set mutableSet = CollectionsKt.toMutableSet(updateState.n());
        mutableSet.add(FeedbackViewState.FeedbackValidationError.NoInternetConnection);
        Unit unit = Unit.f139807a;
        return updateState.a((10223 & 1) != 0 ? updateState.f102177a : null, (10223 & 2) != 0 ? updateState.f102178b : null, (10223 & 4) != 0 ? updateState.f102179c : null, (10223 & 8) != 0 ? updateState.f102180d : null, (10223 & 16) != 0 ? updateState.f102181f : null, (10223 & 32) != 0 ? updateState.f102182g : false, (10223 & 64) != 0 ? updateState.f102183h : false, (10223 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? updateState.f102184i : 0, (10223 & Function.MAX_NARGS) != 0 ? updateState.f102185j : mutableSet, (10223 & 512) != 0 ? updateState.f102186k : null, (10223 & 1024) != 0 ? updateState.f102187l : false, (10223 & 2048) != 0 ? updateState.f102188m : false, (10223 & 4096) != 0 ? updateState.f102189n : false, (10223 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? updateState.f102190o : false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FeedbackViewState e2(FeedbackViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        Set mutableSet = CollectionsKt.toMutableSet(updateState.n());
        if (updateState.j() == null) {
            mutableSet.add(FeedbackViewState.FeedbackValidationError.MissingSelectedReason);
        } else {
            mutableSet.remove(FeedbackViewState.FeedbackValidationError.MissingSelectedReason);
        }
        if ((Intrinsics.areEqual(updateState.f(), updateState.e()) || updateState.f().length() <= 0) && updateState.f().length() != 0) {
            mutableSet.remove(FeedbackViewState.FeedbackValidationError.EmailsDoNotMatch);
        } else {
            mutableSet.add(FeedbackViewState.FeedbackValidationError.EmailsDoNotMatch);
        }
        if (Patterns.EMAIL_ADDRESS.matcher(updateState.f()).matches()) {
            mutableSet.remove(FeedbackViewState.FeedbackValidationError.EmailIsInvalid);
        } else {
            mutableSet.add(FeedbackViewState.FeedbackValidationError.EmailIsInvalid);
        }
        if (updateState.i().length() == 0) {
            mutableSet.add(FeedbackViewState.FeedbackValidationError.MessageIsEmpty);
        } else {
            mutableSet.remove(FeedbackViewState.FeedbackValidationError.MessageIsEmpty);
        }
        mutableSet.remove(FeedbackViewState.FeedbackValidationError.ApiError);
        Unit unit = Unit.f139807a;
        return updateState.a((10223 & 1) != 0 ? updateState.f102177a : null, (10223 & 2) != 0 ? updateState.f102178b : null, (10223 & 4) != 0 ? updateState.f102179c : null, (10223 & 8) != 0 ? updateState.f102180d : null, (10223 & 16) != 0 ? updateState.f102181f : null, (10223 & 32) != 0 ? updateState.f102182g : false, (10223 & 64) != 0 ? updateState.f102183h : false, (10223 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? updateState.f102184i : 0, (10223 & Function.MAX_NARGS) != 0 ? updateState.f102185j : mutableSet, (10223 & 512) != 0 ? updateState.f102186k : null, (10223 & 1024) != 0 ? updateState.f102187l : false, (10223 & 2048) != 0 ? updateState.f102188m : false, (10223 & 4096) != 0 ? updateState.f102189n : false, (10223 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? updateState.f102190o : false);
    }

    public static final /* synthetic */ FeedbackViewState f1(FeedbackViewModel feedbackViewModel) {
        return (FeedbackViewState) feedbackViewModel.I0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FeedbackViewState f2(FeedbackViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return updateState.a((10223 & 1) != 0 ? updateState.f102177a : null, (10223 & 2) != 0 ? updateState.f102178b : null, (10223 & 4) != 0 ? updateState.f102179c : null, (10223 & 8) != 0 ? updateState.f102180d : null, (10223 & 16) != 0 ? updateState.f102181f : null, (10223 & 32) != 0 ? updateState.f102182g : false, (10223 & 64) != 0 ? updateState.f102183h : true, (10223 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? updateState.f102184i : 0, (10223 & Function.MAX_NARGS) != 0 ? updateState.f102185j : null, (10223 & 512) != 0 ? updateState.f102186k : null, (10223 & 1024) != 0 ? updateState.f102187l : false, (10223 & 2048) != 0 ? updateState.f102188m : false, (10223 & 4096) != 0 ? updateState.f102189n : false, (10223 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? updateState.f102190o : false);
    }

    private final String g2(ContentResolver contentResolver, Uri uri) {
        Cursor cursorQuery = contentResolver.query(uri, null, null, null, null);
        Intrinsics.checkNotNull(cursorQuery);
        int columnIndex = cursorQuery.getColumnIndex("_display_name");
        cursorQuery.moveToFirst();
        String string = cursorQuery.getString(columnIndex);
        cursorQuery.close();
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int h2(long j3) {
        return (int) (j3 / ((long) 1000000));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StrictModeRepository t0() {
        return (StrictModeRepository) this.f102089w.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u1(final FeedbackViewState.FreshdeskAttachment freshdeskAttachment) {
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.feedback.t0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FeedbackViewModel.v1(freshdeskAttachment, (FeedbackViewState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FeedbackViewState v1(FeedbackViewState.FreshdeskAttachment freshdeskAttachment, FeedbackViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        List mutableList = CollectionsKt.toMutableList((Collection) updateState.d());
        mutableList.add(freshdeskAttachment);
        Unit unit = Unit.f139807a;
        ImmutableList immutableListH = ExtensionsKt.h(mutableList);
        Set mutableSet = CollectionsKt.toMutableSet(updateState.n());
        mutableSet.remove(FeedbackViewState.FeedbackValidationError.AttachmentSizeExceeded);
        return updateState.a((10223 & 1) != 0 ? updateState.f102177a : null, (10223 & 2) != 0 ? updateState.f102178b : null, (10223 & 4) != 0 ? updateState.f102179c : null, (10223 & 8) != 0 ? updateState.f102180d : immutableListH, (10223 & 16) != 0 ? updateState.f102181f : null, (10223 & 32) != 0 ? updateState.f102182g : false, (10223 & 64) != 0 ? updateState.f102183h : false, (10223 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? updateState.f102184i : 0, (10223 & Function.MAX_NARGS) != 0 ? updateState.f102185j : mutableSet, (10223 & 512) != 0 ? updateState.f102186k : null, (10223 & 1024) != 0 ? updateState.f102187l : false, (10223 & 2048) != 0 ? updateState.f102188m : false, (10223 & 4096) != 0 ? updateState.f102189n : false, (10223 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? updateState.f102190o : false);
    }

    private final boolean w1(Uri uri) {
        String type = A0().getContentResolver().getType(uri);
        if (type != null) {
            return StringsKt.U(type, "video/", false, 2, null);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object x1(cz.mobilesoft.coreblock.repository.DiagnosticRepository r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel$createDiagnosticJsonAttachment$1
            if (r0 == 0) goto L13
            r0 = r6
            cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel$createDiagnosticJsonAttachment$1 r0 = (cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel$createDiagnosticJsonAttachment$1) r0
            int r1 = r0.f102112d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f102112d = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel$createDiagnosticJsonAttachment$1 r0 = new cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel$createDiagnosticJsonAttachment$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f102110b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f102112d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.f102109a
            cz.mobilesoft.coreblock.repository.DiagnosticRepository r5 = (cz.mobilesoft.coreblock.repository.DiagnosticRepository) r5
            kotlin.ResultKt.b(r6)
            goto L47
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.ResultKt.b(r6)
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.a(r5)
            r0.f102109a = r6
            r0.f102112d = r3
            java.lang.Object r6 = r5.c(r0)
            if (r6 != r1) goto L47
            return r1
        L47:
            byte[] r6 = (byte[]) r6
            cz.mobilesoft.coreblock.scene.feedback.FeedbackViewState$FreshdeskAttachment$MemoryFile r5 = new cz.mobilesoft.coreblock.scene.feedback.FeedbackViewState$FreshdeskAttachment$MemoryFile
            int r0 = r6.length
            long r0 = (long) r0
            java.lang.String r2 = "diagnostic.json.gz"
            r5.<init>(r2, r0, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel.x1(cz.mobilesoft.coreblock.repository.DiagnosticRepository, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object y1(cz.mobilesoft.coreblock.repository.DiagnosticRepository r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel$createRevenueCatJsonAttachment$1
            if (r0 == 0) goto L13
            r0 = r6
            cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel$createRevenueCatJsonAttachment$1 r0 = (cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel$createRevenueCatJsonAttachment$1) r0
            int r1 = r0.f102116d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f102116d = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel$createRevenueCatJsonAttachment$1 r0 = new cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel$createRevenueCatJsonAttachment$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f102114b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f102116d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.f102113a
            cz.mobilesoft.coreblock.repository.DiagnosticRepository r5 = (cz.mobilesoft.coreblock.repository.DiagnosticRepository) r5
            kotlin.ResultKt.b(r6)
            goto L47
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.ResultKt.b(r6)
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.a(r5)
            r0.f102113a = r6
            r0.f102116d = r3
            java.lang.Object r6 = r5.i(r0)
            if (r6 != r1) goto L47
            return r1
        L47:
            byte[] r6 = (byte[]) r6
            cz.mobilesoft.coreblock.scene.feedback.FeedbackViewState$FreshdeskAttachment$MemoryFile r5 = new cz.mobilesoft.coreblock.scene.feedback.FeedbackViewState$FreshdeskAttachment$MemoryFile
            int r0 = r6.length
            long r0 = (long) r0
            java.lang.String r2 = "rc_profile.json.gz"
            r5.<init>(r2, r0, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel.y1(cz.mobilesoft.coreblock.repository.DiagnosticRepository, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final String D1() {
        return this.f102085s;
    }

    public final boolean M1() {
        return this.f102083q;
    }

    public final boolean N1() {
        return this.f102082p;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: V1, reason: merged with bridge method [inline-methods] */
    public void O0(FeedbackViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof FeedbackViewEvent.OnAddAttachmentClicked) {
            O1(((FeedbackViewEvent.OnAddAttachmentClicked) event).a());
            return;
        }
        if (event instanceof FeedbackViewEvent.OnEmailChanged) {
            T1(((FeedbackViewEvent.OnEmailChanged) event).a());
            return;
        }
        if (event instanceof FeedbackViewEvent.OnEmailConfirmedChanged) {
            R1(((FeedbackViewEvent.OnEmailConfirmedChanged) event).a());
            return;
        }
        if (event instanceof FeedbackViewEvent.OnMessageChanged) {
            W1(((FeedbackViewEvent.OnMessageChanged) event).a());
            return;
        }
        if (Intrinsics.areEqual(event, FeedbackViewEvent.OnSendClicked.f102079a)) {
            c2();
            return;
        }
        if (event instanceof FeedbackViewEvent.OnAttachmentRemoved) {
            P1(((FeedbackViewEvent.OnAttachmentRemoved) event).a());
            return;
        }
        if (event instanceof FeedbackViewEvent.OnReasonSelected) {
            Y1(((FeedbackViewEvent.OnReasonSelected) event).a());
            return;
        }
        if (Intrinsics.areEqual(event, FeedbackViewEvent.OnRetryClicked.f102078a)) {
            a2();
        } else {
            if (!Intrinsics.areEqual(event, FeedbackViewEvent.SaveEmergencyEntrance.f102080a)) {
                throw new NoWhenBranchMatchedException();
            }
            if (this.f102085s != null) {
                BuildersKt__Builders_commonKt.d(C0(), null, null, new FeedbackViewModel$onEvent$1$1(this, null), 3, null);
            }
        }
    }

    public final String z1() {
        return this.f102084r;
    }
}
