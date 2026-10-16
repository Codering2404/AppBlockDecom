package com.superwall.sdk.debug;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.activity.EdgeToEdge;
import androidx.activity.SystemBarStyle;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.superwall.sdk.Superwall;
import com.superwall.sdk.paywall.view.ActivityEncapsulatable;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

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
public final class DebugViewActivity extends AppCompatActivity {
    public static final Companion Companion = new Companion(null);
    private static final String VIEW_KEY = "debugViewKey";
    private View contentView;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void startWithView(Context context, View view) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(view, "view");
            String string = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            Superwall.Companion.getInstance().getDependencyContainer$superwall_release().makeViewStore().storeView(string, view);
            Intent intent = new Intent(context, (Class<?>) DebugViewActivity.class);
            intent.putExtra(DebugViewActivity.VIEW_KEY, string);
            intent.setFlags(805306368);
            context.startActivity(intent);
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.debug.DebugViewActivity$onDestroy$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.debug.DebugViewActivity$onDestroy$1", f = "DebugView.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DebugView $debugView;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(DebugView debugView, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$debugView = debugView;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$debugView, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            this.$debugView.viewDestroyed();
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat onCreate$lambda$1(View v2, WindowInsetsCompat windowInsets) {
        Intrinsics.checkNotNullParameter(v2, "v");
        Intrinsics.checkNotNullParameter(windowInsets, "windowInsets");
        Insets insetsF = windowInsets.f(WindowInsetsCompat.Type.i());
        Intrinsics.checkNotNullExpressionValue(insetsF, "getInsets(...)");
        v2.setPadding(insetsF.f33964a, insetsF.f33965b, insetsF.f33966c, insetsF.f33967d);
        return WindowInsetsCompat.f34517b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        int color = Color.parseColor("#181A1E");
        SystemBarStyle.Companion companion = SystemBarStyle.f419e;
        EdgeToEdge.a(this, companion.c(color), companion.c(color));
        super.onCreate(bundle);
        AppCompatDelegate.P(true);
        String stringExtra = getIntent().getStringExtra(VIEW_KEY);
        if (stringExtra == null) {
            finish();
            return;
        }
        View viewRetrieveView = Superwall.Companion.getInstance().getDependencyContainer$superwall_release().makeViewStore().retrieveView(stringExtra);
        if (viewRetrieveView == 0) {
            finish();
            return;
        }
        if (viewRetrieveView instanceof AppCompatActivityEncapsulatable) {
            ((AppCompatActivityEncapsulatable) viewRetrieveView).setEncapsulatingActivity(this);
        }
        requestWindowFeature(1);
        ViewCompat.C0(viewRetrieveView, new OnApplyWindowInsetsListener() { // from class: com.superwall.sdk.debug.p
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat) {
                return DebugViewActivity.onCreate$lambda$1(view, windowInsetsCompat);
            }
        });
        setContentView(viewRetrieveView);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.k();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        View view = this.contentView;
        DebugView debugView = view instanceof DebugView ? (DebugView) view : null;
        if (debugView == null) {
            return;
        }
        BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), null, null, new AnonymousClass1(debugView, null), 3, null);
        KeyEvent.Callback callback = this.contentView;
        ActivityEncapsulatable activityEncapsulatable = callback instanceof ActivityEncapsulatable ? (ActivityEncapsulatable) callback : null;
        if (activityEncapsulatable != null) {
            activityEncapsulatable.setEncapsulatingActivity(null);
        }
        this.contentView = null;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        View view = this.contentView;
        DebugView debugView = view instanceof DebugView ? (DebugView) view : null;
        if (debugView == null) {
            return;
        }
        debugView.setActive$superwall_release(true);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        View view = this.contentView;
        DebugView debugView = view instanceof DebugView ? (DebugView) view : null;
        if (debugView == null) {
            return;
        }
        debugView.setActive$superwall_release(false);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        super.setContentView(view);
        this.contentView = view;
    }
}
