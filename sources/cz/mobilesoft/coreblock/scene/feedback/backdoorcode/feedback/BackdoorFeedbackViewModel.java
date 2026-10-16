package cz.mobilesoft.coreblock.scene.feedback.backdoorcode.feedback;

import android.app.Application;
import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.repository.DiagnosticRepository;
import cz.mobilesoft.coreblock.scene.feedback.FeedbackViewCommand;
import cz.mobilesoft.coreblock.scene.feedback.FeedbackViewEvent;
import cz.mobilesoft.coreblock.scene.feedback.FeedbackViewState;
import cz.mobilesoft.coreblock.scene.feedback.backdoorcode.feedback.BackdoorFeedbackViewModel;
import cz.mobilesoft.coreblock.storage.datastore.SessionDataStore;
import cz.mobilesoft.coreblock.usecase.SendContactSupportDetailedRequestUseCase;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableList;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
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
public final class BackdoorFeedbackViewModel extends BaseStatefulViewModel<FeedbackViewState, FeedbackViewEvent, FeedbackViewCommand> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f102228o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f102229p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f102230q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f102231r;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.feedback.backdoorcode.feedback.BackdoorFeedbackViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.feedback.backdoorcode.feedback.BackdoorFeedbackViewModel$1", f = "BackdoorFeedbackViewModel.kt", l = {36}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f102232a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f102233b;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final FeedbackViewState q(FeedbackViewState feedbackViewState) {
            return feedbackViewState.a((10223 & 1) != 0 ? feedbackViewState.f102177a : null, (10223 & 2) != 0 ? feedbackViewState.f102178b : null, (10223 & 4) != 0 ? feedbackViewState.f102179c : null, (10223 & 8) != 0 ? feedbackViewState.f102180d : null, (10223 & 16) != 0 ? feedbackViewState.f102181f : null, (10223 & 32) != 0 ? feedbackViewState.f102182g : false, (10223 & 64) != 0 ? feedbackViewState.f102183h : false, (10223 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? feedbackViewState.f102184i : 0, (10223 & Function.MAX_NARGS) != 0 ? feedbackViewState.f102185j : null, (10223 & 512) != 0 ? feedbackViewState.f102186k : null, (10223 & 1024) != 0 ? feedbackViewState.f102187l : true, (10223 & 2048) != 0 ? feedbackViewState.f102188m : false, (10223 & 4096) != 0 ? feedbackViewState.f102189n : false, (10223 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? feedbackViewState.f102190o : false);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return BackdoorFeedbackViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            BackdoorFeedbackViewModel backdoorFeedbackViewModel;
            Object objF = IntrinsicsKt.f();
            int i3 = this.f102233b;
            if (i3 == 0) {
                ResultKt.b(obj);
                BackdoorFeedbackViewModel backdoorFeedbackViewModel2 = BackdoorFeedbackViewModel.this;
                Flow flowS = backdoorFeedbackViewModel2.g1().S();
                this.f102232a = backdoorFeedbackViewModel2;
                this.f102233b = 1;
                Object objD = FlowKt.D(flowS, this);
                if (objD == objF) {
                    return objF;
                }
                backdoorFeedbackViewModel = backdoorFeedbackViewModel2;
                obj = objD;
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                backdoorFeedbackViewModel = (BackdoorFeedbackViewModel) this.f102232a;
                ResultKt.b(obj);
            }
            CharSequence charSequence = (CharSequence) obj;
            BackdoorFeedbackViewModel backdoorFeedbackViewModel3 = BackdoorFeedbackViewModel.this;
            if (StringsKt.p0(charSequence)) {
                backdoorFeedbackViewModel3.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.feedback.backdoorcode.feedback.p
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return BackdoorFeedbackViewModel.AnonymousClass1.q((FeedbackViewState) obj2);
                    }
                });
                charSequence = "";
            }
            backdoorFeedbackViewModel.f102231r = (String) charSequence;
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BackdoorFeedbackViewModel(Application application) {
        super(application, new FeedbackViewState(null, null, null, null, null, false, false, 0, null, null, false, false, false, false, 16383, null));
        Intrinsics.checkNotNullParameter(application, "application");
        final Qualifier qualifier = null;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f102228o = LazyKt.a(lazyThreadSafetyModeB, new Function0<SendContactSupportDetailedRequestUseCase>() { // from class: cz.mobilesoft.coreblock.scene.feedback.backdoorcode.feedback.BackdoorFeedbackViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(SendContactSupportDetailedRequestUseCase.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f102229p = LazyKt.a(lazyThreadSafetyModeB2, new Function0<SessionDataStore>() { // from class: cz.mobilesoft.coreblock.scene.feedback.backdoorcode.feedback.BackdoorFeedbackViewModel$special$$inlined$inject$default$2
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
        this.f102230q = LazyKt.a(lazyThreadSafetyModeB3, new Function0<DiagnosticRepository>() { // from class: cz.mobilesoft.coreblock.scene.feedback.backdoorcode.feedback.BackdoorFeedbackViewModel$special$$inlined$inject$default$3
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
        this.f102231r = "";
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DiagnosticRepository d1() {
        return (DiagnosticRepository) this.f102230q.getValue();
    }

    private final Long e1(Uri uri) throws IOException {
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = A0().getContentResolver().openAssetFileDescriptor(uri, "r");
        Long lValueOf = assetFileDescriptorOpenAssetFileDescriptor != null ? Long.valueOf(assetFileDescriptorOpenAssetFileDescriptor.getLength()) : null;
        if (assetFileDescriptorOpenAssetFileDescriptor != null) {
            assetFileDescriptorOpenAssetFileDescriptor.close();
        }
        return lValueOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SendContactSupportDetailedRequestUseCase f1() {
        return (SendContactSupportDetailedRequestUseCase) this.f102228o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SessionDataStore g1() {
        return (SessionDataStore) this.f102229p.getValue();
    }

    private final void h1(final Uri uri) {
        final Long lE1;
        if (((FeedbackViewState) I0()).d().size() >= 5) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new BackdoorFeedbackViewModel$onAddAttachmentClicked$2(this, null), 3, null);
        } else {
            if (uri == null || (lE1 = e1(uri)) == null) {
                return;
            }
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.feedback.backdoorcode.feedback.l
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BackdoorFeedbackViewModel.i1(this.f102290a, uri, lE1, (FeedbackViewState) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FeedbackViewState i1(BackdoorFeedbackViewModel backdoorFeedbackViewModel, Uri uri, Long l3, FeedbackViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        List mutableList = CollectionsKt.toMutableList((Collection) updateState.d());
        ContentResolver contentResolver = backdoorFeedbackViewModel.A0().getContentResolver();
        Intrinsics.checkNotNullExpressionValue(contentResolver, "getContentResolver(...)");
        String strS1 = backdoorFeedbackViewModel.s1(contentResolver, uri);
        if (strS1 == null) {
            strS1 = "";
        }
        mutableList.add(new FeedbackViewState.FreshdeskAttachment.UriFile(strS1, l3.longValue(), uri));
        Unit unit = Unit.f139807a;
        ImmutableList immutableListH = ExtensionsKt.h(mutableList);
        Set mutableSet = CollectionsKt.toMutableSet(updateState.n());
        Iterator<E> it = updateState.d().iterator();
        long jB = 0;
        while (it.hasNext()) {
            jB += ((FeedbackViewState.FreshdeskAttachment) it.next()).b();
        }
        if (jB + l3.longValue() > 20000000) {
            mutableSet.add(FeedbackViewState.FeedbackValidationError.AttachmentSizeExceeded);
        } else {
            mutableSet.remove(FeedbackViewState.FeedbackValidationError.AttachmentSizeExceeded);
        }
        Unit unit2 = Unit.f139807a;
        return updateState.a((10223 & 1) != 0 ? updateState.f102177a : null, (10223 & 2) != 0 ? updateState.f102178b : null, (10223 & 4) != 0 ? updateState.f102179c : null, (10223 & 8) != 0 ? updateState.f102180d : immutableListH, (10223 & 16) != 0 ? updateState.f102181f : null, (10223 & 32) != 0 ? updateState.f102182g : false, (10223 & 64) != 0 ? updateState.f102183h : false, (10223 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? updateState.f102184i : 0, (10223 & Function.MAX_NARGS) != 0 ? updateState.f102185j : mutableSet, (10223 & 512) != 0 ? updateState.f102186k : null, (10223 & 1024) != 0 ? updateState.f102187l : false, (10223 & 2048) != 0 ? updateState.f102188m : false, (10223 & 4096) != 0 ? updateState.f102189n : false, (10223 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? updateState.f102190o : false);
    }

    private final void j1(final FeedbackViewState.FreshdeskAttachment freshdeskAttachment) {
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.feedback.backdoorcode.feedback.o
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BackdoorFeedbackViewModel.k1(freshdeskAttachment, (FeedbackViewState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FeedbackViewState k1(FeedbackViewState.FreshdeskAttachment freshdeskAttachment, FeedbackViewState updateState) {
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

    private final void l1(final String str) {
        this.f102231r = str;
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.feedback.backdoorcode.feedback.k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BackdoorFeedbackViewModel.m1(str, (FeedbackViewState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FeedbackViewState m1(String str, FeedbackViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return updateState.a((10223 & 1) != 0 ? updateState.f102177a : null, (10223 & 2) != 0 ? updateState.f102178b : str, (10223 & 4) != 0 ? updateState.f102179c : null, (10223 & 8) != 0 ? updateState.f102180d : null, (10223 & 16) != 0 ? updateState.f102181f : null, (10223 & 32) != 0 ? updateState.f102182g : false, (10223 & 64) != 0 ? updateState.f102183h : false, (10223 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? updateState.f102184i : 0, (10223 & Function.MAX_NARGS) != 0 ? updateState.f102185j : null, (10223 & 512) != 0 ? updateState.f102186k : null, (10223 & 1024) != 0 ? updateState.f102187l : false, (10223 & 2048) != 0 ? updateState.f102188m : false, (10223 & 4096) != 0 ? updateState.f102189n : false, (10223 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? updateState.f102190o : false);
    }

    private final void o1(final String str) {
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.feedback.backdoorcode.feedback.m
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BackdoorFeedbackViewModel.p1(str, (FeedbackViewState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FeedbackViewState p1(String str, FeedbackViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return updateState.a((10223 & 1) != 0 ? updateState.f102177a : str, (10223 & 2) != 0 ? updateState.f102178b : null, (10223 & 4) != 0 ? updateState.f102179c : null, (10223 & 8) != 0 ? updateState.f102180d : null, (10223 & 16) != 0 ? updateState.f102181f : null, (10223 & 32) != 0 ? updateState.f102182g : false, (10223 & 64) != 0 ? updateState.f102183h : false, (10223 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? updateState.f102184i : 0, (10223 & Function.MAX_NARGS) != 0 ? updateState.f102185j : null, (10223 & 512) != 0 ? updateState.f102186k : null, (10223 & 1024) != 0 ? updateState.f102187l : false, (10223 & 2048) != 0 ? updateState.f102188m : false, (10223 & 4096) != 0 ? updateState.f102189n : false, (10223 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? updateState.f102190o : false);
    }

    private final void q1() {
        FeedbackViewState feedbackViewState = (FeedbackViewState) I0();
        if (feedbackViewState.n().contains(FeedbackViewState.FeedbackValidationError.AttachmentSizeExceeded)) {
            return;
        }
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.feedback.backdoorcode.feedback.n
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BackdoorFeedbackViewModel.r1((FeedbackViewState) obj);
            }
        });
        BuildersKt__Builders_commonKt.d(C0(), null, null, new BackdoorFeedbackViewModel$onSendClicked$2(this, feedbackViewState, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FeedbackViewState r1(FeedbackViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return updateState.a((10223 & 1) != 0 ? updateState.f102177a : null, (10223 & 2) != 0 ? updateState.f102178b : null, (10223 & 4) != 0 ? updateState.f102179c : null, (10223 & 8) != 0 ? updateState.f102180d : null, (10223 & 16) != 0 ? updateState.f102181f : null, (10223 & 32) != 0 ? updateState.f102182g : false, (10223 & 64) != 0 ? updateState.f102183h : true, (10223 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? updateState.f102184i : 0, (10223 & Function.MAX_NARGS) != 0 ? updateState.f102185j : null, (10223 & 512) != 0 ? updateState.f102186k : null, (10223 & 1024) != 0 ? updateState.f102187l : false, (10223 & 2048) != 0 ? updateState.f102188m : false, (10223 & 4096) != 0 ? updateState.f102189n : false, (10223 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? updateState.f102190o : false);
    }

    private final String s1(ContentResolver contentResolver, Uri uri) {
        Cursor cursorQuery = contentResolver.query(uri, null, null, null, null);
        Intrinsics.checkNotNull(cursorQuery);
        int columnIndex = cursorQuery.getColumnIndex("_display_name");
        cursorQuery.moveToFirst();
        String string = cursorQuery.getString(columnIndex);
        cursorQuery.close();
        return string;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: n1, reason: merged with bridge method [inline-methods] */
    public void O0(FeedbackViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.O0(event);
        if (event instanceof FeedbackViewEvent.OnAddAttachmentClicked) {
            h1(((FeedbackViewEvent.OnAddAttachmentClicked) event).a());
            return;
        }
        if (event instanceof FeedbackViewEvent.OnAttachmentRemoved) {
            j1(((FeedbackViewEvent.OnAttachmentRemoved) event).a());
            return;
        }
        if (event instanceof FeedbackViewEvent.OnMessageChanged) {
            o1(((FeedbackViewEvent.OnMessageChanged) event).a());
        } else if (event instanceof FeedbackViewEvent.OnEmailChanged) {
            l1(((FeedbackViewEvent.OnEmailChanged) event).a());
        } else if (Intrinsics.areEqual(event, FeedbackViewEvent.OnSendClicked.f102079a)) {
            q1();
        }
    }
}
