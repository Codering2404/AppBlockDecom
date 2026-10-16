package com.superwall.sdk.review;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.testing.FakeReviewManager;
import com.superwall.sdk.review.MockReviewManager;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

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
public final class MockReviewManager implements ReviewManager {
    private final Context context;
    private final FakeReviewManager fakeReviewManager;

    /* JADX INFO: renamed from: com.superwall.sdk.review.MockReviewManager$showMockReviewBottomSheet$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.review.MockReviewManager$showMockReviewBottomSheet$1", f = "MockReviewManager.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ Function1<Integer, Unit> $onComplete;
        int label;
        final /* synthetic */ MockReviewManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Activity activity, MockReviewManager mockReviewManager, Function1<? super Integer, Unit> function1, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$activity = activity;
            this.this$0 = mockReviewManager;
            this.$onComplete = function1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0(AlertDialog alertDialog, Function1 function1, int i3) {
            alertDialog.dismiss();
            function1.invoke(Integer.valueOf(i3));
            return Unit.f139807a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$activity, this.this$0, this.$onComplete, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            final AlertDialog alertDialogA = new AlertDialog.Builder(this.$activity, R.style.Theme.DeviceDefault.Light.Dialog).d(true).a();
            Intrinsics.checkNotNullExpressionValue(alertDialogA, "create(...)");
            MockReviewManager mockReviewManager = this.this$0;
            Activity activity = this.$activity;
            final Function1<Integer, Unit> function1 = this.$onComplete;
            alertDialogA.m(mockReviewManager.createMockReviewView(activity, new Function1() { // from class: com.superwall.sdk.review.c
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return MockReviewManager.AnonymousClass1.invokeSuspend$lambda$0(alertDialogA, function1, ((Integer) obj2).intValue());
                }
            }));
            Window window = alertDialogA.getWindow();
            if (window != null) {
                window.setLayout(-1, -2);
                window.setGravity(80);
                window.setBackgroundDrawable(new ColorDrawable(0));
                window.setSoftInputMode(16);
            }
            alertDialogA.show();
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    public MockReviewManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.fakeReviewManager = new FakeReviewManager(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View createMockReviewView(Activity activity, final Function1<? super Integer, Unit> function1) {
        Drawable drawable;
        String string;
        ApplicationInfo applicationInfo = null;
        View viewInflate = LayoutInflater.from(activity).inflate(com.superwall.sdk.R.layout.mock_review_layout, (ViewGroup) null);
        ImageView imageView = (ImageView) viewInflate.findViewById(com.superwall.sdk.R.id.app_icon);
        PackageManager packageManager = activity.getPackageManager();
        try {
            applicationInfo = packageManager.getApplicationInfo(activity.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (applicationInfo == null || (drawable = packageManager.getApplicationIcon(applicationInfo)) == null) {
            drawable = ContextCompat.getDrawable(activity, R.drawable.sym_def_app_icon);
        }
        imageView.setImageDrawable(drawable);
        TextView textView = (TextView) viewInflate.findViewById(com.superwall.sdk.R.id.app_name);
        if (applicationInfo == null || (string = packageManager.getApplicationLabel(applicationInfo).toString()) == null) {
            string = "App Name";
        }
        textView.setText(string);
        final RatingBar ratingBar = (RatingBar) viewInflate.findViewById(com.superwall.sdk.R.id.rating_bar);
        Button button = (Button) viewInflate.findViewById(com.superwall.sdk.R.id.not_now_button);
        Button button2 = (Button) viewInflate.findViewById(com.superwall.sdk.R.id.submit_button);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.superwall.sdk.review.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MockReviewManager.createMockReviewView$lambda$4(function1, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.superwall.sdk.review.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MockReviewManager.createMockReviewView$lambda$5(ratingBar, function1, view);
            }
        });
        Intrinsics.checkNotNull(viewInflate);
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createMockReviewView$lambda$4(Function1 function1, View view) {
        function1.invoke(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createMockReviewView$lambda$5(RatingBar ratingBar, Function1 function1, View view) {
        function1.invoke(Integer.valueOf((int) ratingBar.getRating()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showMockReviewBottomSheet(Activity activity, Function1<? super Integer, Unit> function1) {
        BuildersKt__Builders_commonKt.d(CoroutineScopeKt.b(), null, null, new AnonymousClass1(activity, this, function1, null), 3, null);
    }

    @Override // com.superwall.sdk.review.ReviewManager
    public Object launchReviewFlow(Activity activity, ReviewInfo reviewInfo, Continuation<? super Unit> continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        showMockReviewBottomSheet(activity, new Function1<Integer, Unit>() { // from class: com.superwall.sdk.review.MockReviewManager$launchReviewFlow$2$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).intValue());
                return Unit.f139807a;
            }

            public final void invoke(int i3) {
                CancellableContinuation<Unit> cancellableContinuation = cancellableContinuationImpl;
                Result.Companion companion = Result.f139772b;
                cancellableContinuation.resumeWith(Result.b(Unit.f139807a));
            }
        });
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV == IntrinsicsKt.f() ? objV : Unit.f139807a;
    }

    @Override // com.superwall.sdk.review.ReviewManager
    public Object requestReviewFlow(Continuation<? super ReviewInfo> continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        Task taskA = this.fakeReviewManager.a();
        Intrinsics.checkNotNullExpressionValue(taskA, "requestReviewFlow(...)");
        taskA.addOnCompleteListener(new OnCompleteListener() { // from class: com.superwall.sdk.review.MockReviewManager$requestReviewFlow$2$1
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task<ReviewInfo> task) {
                Intrinsics.checkNotNullParameter(task, "task");
                if (task.isSuccessful()) {
                    CancellableContinuation<ReviewInfo> cancellableContinuation = cancellableContinuationImpl;
                    Result.Companion companion = Result.f139772b;
                    cancellableContinuation.resumeWith(Result.b(task.getResult()));
                } else {
                    CancellableContinuation<ReviewInfo> cancellableContinuation2 = cancellableContinuationImpl;
                    Result.Companion companion2 = Result.f139772b;
                    cancellableContinuation2.resumeWith(Result.b(task.getResult()));
                }
            }
        });
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV;
    }
}
