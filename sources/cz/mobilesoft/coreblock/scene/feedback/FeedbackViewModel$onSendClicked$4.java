package cz.mobilesoft.coreblock.scene.feedback;

import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.scene.feedback.FeedbackViewState;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel$onSendClicked$4", f = "FeedbackViewModel.kt", l = {247, 255, Function.MAX_NARGS, 261}, m = "invokeSuspend", v = 1)
final class FeedbackViewModel$onSendClicked$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f102139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f102140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f102141c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f102142d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f102143f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f102144g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Object f102145h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f102146i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ FeedbackViewState f102147j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ FeedbackViewModel f102148k;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel$onSendClicked$4$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class AnonymousClass1<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedbackViewModel f102149a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ FeedbackViewState f102150b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f102151c;

        AnonymousClass1(FeedbackViewModel feedbackViewModel, FeedbackViewState feedbackViewState, List list) {
            this.f102149a = feedbackViewModel;
            this.f102150b = feedbackViewState;
            this.f102151c = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final FeedbackViewState h(FeedbackViewState updateState) {
            Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
            return updateState.a((10223 & 1) != 0 ? updateState.f102177a : null, (10223 & 2) != 0 ? updateState.f102178b : null, (10223 & 4) != 0 ? updateState.f102179c : null, (10223 & 8) != 0 ? updateState.f102180d : null, (10223 & 16) != 0 ? updateState.f102181f : null, (10223 & 32) != 0 ? updateState.f102182g : false, (10223 & 64) != 0 ? updateState.f102183h : true, (10223 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? updateState.f102184i : 0, (10223 & Function.MAX_NARGS) != 0 ? updateState.f102185j : null, (10223 & 512) != 0 ? updateState.f102186k : null, (10223 & 1024) != 0 ? updateState.f102187l : false, (10223 & 2048) != 0 ? updateState.f102188m : false, (10223 & 4096) != 0 ? updateState.f102189n : false, (10223 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? updateState.f102190o : false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final FeedbackViewState i(FeedbackViewState updateState) {
            Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
            return updateState.a((10223 & 1) != 0 ? updateState.f102177a : null, (10223 & 2) != 0 ? updateState.f102178b : null, (10223 & 4) != 0 ? updateState.f102179c : null, (10223 & 8) != 0 ? updateState.f102180d : null, (10223 & 16) != 0 ? updateState.f102181f : null, (10223 & 32) != 0 ? updateState.f102182g : true, (10223 & 64) != 0 ? updateState.f102183h : false, (10223 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? updateState.f102184i : 0, (10223 & Function.MAX_NARGS) != 0 ? updateState.f102185j : null, (10223 & 512) != 0 ? updateState.f102186k : null, (10223 & 1024) != 0 ? updateState.f102187l : false, (10223 & 2048) != 0 ? updateState.f102188m : false, (10223 & 4096) != 0 ? updateState.f102189n : false, (10223 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? updateState.f102190o : false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final FeedbackViewState j(FeedbackViewState updateState) {
            Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
            Set mutableSet = CollectionsKt.toMutableSet(updateState.n());
            mutableSet.add(FeedbackViewState.FeedbackValidationError.ApiError);
            return updateState.a((10223 & 1) != 0 ? updateState.f102177a : null, (10223 & 2) != 0 ? updateState.f102178b : null, (10223 & 4) != 0 ? updateState.f102179c : null, (10223 & 8) != 0 ? updateState.f102180d : null, (10223 & 16) != 0 ? updateState.f102181f : null, (10223 & 32) != 0 ? updateState.f102182g : false, (10223 & 64) != 0 ? updateState.f102183h : false, (10223 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? updateState.f102184i : 0, (10223 & Function.MAX_NARGS) != 0 ? updateState.f102185j : mutableSet, (10223 & 512) != 0 ? updateState.f102186k : null, (10223 & 1024) != 0 ? updateState.f102187l : false, (10223 & 2048) != 0 ? updateState.f102188m : false, (10223 & 4096) != 0 ? updateState.f102189n : false, (10223 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? updateState.f102190o : false);
        }

        /* JADX WARN: Code restructure failed: missing block: B:53:0x0130, code lost:
        
            if (r10.P0(r2, r0) != r1) goto L55;
         */
        /* JADX WARN: Removed duplicated region for block: B:44:0x00de  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0120 A[PHI: r9
          0x0120: PHI (r9v7 cz.mobilesoft.coreblock.util.ViewModelState) = (r9v6 cz.mobilesoft.coreblock.util.ViewModelState), (r9v18 cz.mobilesoft.coreblock.util.ViewModelState) binds: [B:50:0x011d, B:18:0x0042] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:60:0x0105 A[EDGE_INSN: B:60:0x0105->B:49:0x0105 BREAK  A[LOOP:0: B:42:0x00d8->B:62:?], SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(cz.mobilesoft.coreblock.util.ViewModelState r9, kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 323
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel$onSendClicked$4.AnonymousClass1.emit(cz.mobilesoft.coreblock.util.ViewModelState, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FeedbackViewModel$onSendClicked$4(FeedbackViewState feedbackViewState, FeedbackViewModel feedbackViewModel, Continuation continuation) {
        super(2, continuation);
        this.f102147j = feedbackViewState;
        this.f102148k = feedbackViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new FeedbackViewModel$onSendClicked$4(this.f102147j, this.f102148k, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0152, code lost:
    
        if (r2.collect(r5, r18) != r1) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0104  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 344
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.feedback.FeedbackViewModel$onSendClicked$4.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((FeedbackViewModel$onSendClicked$4) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
