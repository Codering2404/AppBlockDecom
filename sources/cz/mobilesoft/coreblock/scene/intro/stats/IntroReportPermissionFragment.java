package cz.mobilesoft.coreblock.scene.intro.stats;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.databinding.FragmentIntroQuestion4Binding;
import cz.mobilesoft.coreblock.scene.intro.BaseIntroFragment;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.permissions.PermissionHelperV2;
import cz.mobilesoft.coreblock.util.view.ViewHelperExtKt;
import io.reactivex.internal.operators.mixed.yrog.FptyjHFU;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
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
public final class IntroReportPermissionFragment extends BaseIntroFragment<FragmentIntroQuestion4Binding> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Companion f104922l = new Companion(null);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f104923m = 8;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f104924j = true;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Boolean f104925k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final IntroReportPermissionFragment a() {
            return new IntroReportPermissionFragment();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.intro.stats.IntroReportPermissionFragment$onResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.intro.stats.IntroReportPermissionFragment$onResume$1", f = "IntroReportPermissionFragment.kt", l = {46, 48, 56}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f104926a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f104927b;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.intro.stats.IntroReportPermissionFragment$onResume$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.intro.stats.IntroReportPermissionFragment$onResume$1$1", f = "IntroReportPermissionFragment.kt", l = {}, m = "invokeSuspend", v = 1)
        static final class C02791 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f104929a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ IntroReportPermissionFragment f104930b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02791(IntroReportPermissionFragment introReportPermissionFragment, Continuation continuation) {
                super(2, continuation);
                this.f104930b = introReportPermissionFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new C02791(this.f104930b, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.f();
                if (this.f104929a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                Button buttonH = this.f104930b.H();
                if (buttonH != null) {
                    buttonH.setText("...");
                }
                Button buttonH2 = this.f104930b.H();
                if (buttonH2 != null) {
                    buttonH2.setEnabled(false);
                }
                return Unit.f139807a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((C02791) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.intro.stats.IntroReportPermissionFragment$onResume$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.intro.stats.IntroReportPermissionFragment$onResume$1$2", f = "IntroReportPermissionFragment.kt", l = {}, m = "invokeSuspend", v = 1)
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f104931a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private /* synthetic */ Object f104932b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ IntroReportPermissionFragment f104933c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ Ref.BooleanRef f104934d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(IntroReportPermissionFragment introReportPermissionFragment, Ref.BooleanRef booleanRef, Continuation continuation) {
                super(2, continuation);
                this.f104933c = introReportPermissionFragment;
                this.f104934d = booleanRef;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.f104933c, this.f104934d, continuation);
                anonymousClass2.f104932b = obj;
                return anonymousClass2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.f();
                if (this.f104931a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                Button buttonH = this.f104933c.H();
                if (buttonH != null) {
                    buttonH.setEnabled(true);
                }
                if (!this.f104934d.f140137a) {
                    Button buttonH2 = this.f104933c.H();
                    if (buttonH2 != null) {
                        buttonH2.setText(R.string.Qm);
                    }
                    TextView permissionTextView = IntroReportPermissionFragment.O(this.f104933c).f96658f;
                    Intrinsics.checkNotNullExpressionValue(permissionTextView, "permissionTextView");
                    permissionTextView.setVisibility(0);
                } else if (this.f104933c.f104925k != null) {
                    this.f104933c.f104925k = null;
                } else {
                    IntroReportPermissionFragment introReportPermissionFragment = this.f104933c;
                    Button buttonH3 = introReportPermissionFragment.H();
                    if (buttonH3 != null) {
                        buttonH3.setText(R.string.l8);
                    }
                    TextView permissionTextView2 = IntroReportPermissionFragment.O(introReportPermissionFragment).f96658f;
                    Intrinsics.checkNotNullExpressionValue(permissionTextView2, "permissionTextView");
                    permissionTextView2.setVisibility(8);
                }
                this.f104933c.f104925k = Boxing.a(this.f104934d.f140137a);
                return Unit.f139807a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        AnonymousClass1(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return IntroReportPermissionFragment.this.new AnonymousClass1(continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x006a, code lost:
        
            if (kotlinx.coroutines.BuildersKt.g(r8, r5, r7) == r0) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0091, code lost:
        
            if (kotlinx.coroutines.BuildersKt.g(r1, r4, r7) != r0) goto L25;
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
                int r1 = r7.f104927b
                r2 = 0
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L33
                if (r1 == r5) goto L2b
                if (r1 == r4) goto L23
                if (r1 != r3) goto L1b
                java.lang.Object r0 = r7.f104926a
                kotlin.jvm.internal.Ref$BooleanRef r0 = (kotlin.jvm.internal.Ref.BooleanRef) r0
                kotlin.ResultKt.b(r8)
                goto L94
            L1b:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L23:
                java.lang.Object r1 = r7.f104926a
                kotlin.jvm.internal.Ref$BooleanRef r1 = (kotlin.jvm.internal.Ref.BooleanRef) r1
                kotlin.ResultKt.b(r8)
                goto L6d
            L2b:
                java.lang.Object r1 = r7.f104926a
                kotlin.jvm.internal.Ref$BooleanRef r1 = (kotlin.jvm.internal.Ref.BooleanRef) r1
                kotlin.ResultKt.b(r8)
                goto L57
            L33:
                kotlin.ResultKt.b(r8)
                kotlin.jvm.internal.Ref$BooleanRef r8 = new kotlin.jvm.internal.Ref$BooleanRef
                r8.<init>()
                cz.mobilesoft.coreblock.scene.intro.stats.IntroReportPermissionFragment r1 = cz.mobilesoft.coreblock.scene.intro.stats.IntroReportPermissionFragment.this
                android.content.Context r1 = r1.requireContext()
                boolean r1 = cz.mobilesoft.coreblock.util.permissions.PermissionHelper.k(r1)
                r8.f140137a = r1
                if (r1 != 0) goto L7a
                r7.f104926a = r8
                r7.f104927b = r5
                r5 = 500(0x1f4, double:2.47E-321)
                java.lang.Object r1 = kotlinx.coroutines.DelayKt.b(r5, r7)
                if (r1 != r0) goto L56
                goto L93
            L56:
                r1 = r8
            L57:
                kotlinx.coroutines.MainCoroutineDispatcher r8 = kotlinx.coroutines.Dispatchers.c()
                cz.mobilesoft.coreblock.scene.intro.stats.IntroReportPermissionFragment$onResume$1$1 r5 = new cz.mobilesoft.coreblock.scene.intro.stats.IntroReportPermissionFragment$onResume$1$1
                cz.mobilesoft.coreblock.scene.intro.stats.IntroReportPermissionFragment r6 = cz.mobilesoft.coreblock.scene.intro.stats.IntroReportPermissionFragment.this
                r5.<init>(r6, r2)
                r7.f104926a = r1
                r7.f104927b = r4
                java.lang.Object r8 = kotlinx.coroutines.BuildersKt.g(r8, r5, r7)
                if (r8 != r0) goto L6d
                goto L93
            L6d:
                cz.mobilesoft.coreblock.scene.intro.stats.IntroReportPermissionFragment r8 = cz.mobilesoft.coreblock.scene.intro.stats.IntroReportPermissionFragment.this
                android.content.Context r8 = r8.requireContext()
                boolean r8 = cz.mobilesoft.coreblock.util.permissions.PermissionHelper.k(r8)
                r1.f140137a = r8
                r8 = r1
            L7a:
                kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.c()
                cz.mobilesoft.coreblock.scene.intro.stats.IntroReportPermissionFragment$onResume$1$2 r4 = new cz.mobilesoft.coreblock.scene.intro.stats.IntroReportPermissionFragment$onResume$1$2
                cz.mobilesoft.coreblock.scene.intro.stats.IntroReportPermissionFragment r5 = cz.mobilesoft.coreblock.scene.intro.stats.IntroReportPermissionFragment.this
                r4.<init>(r5, r8, r2)
                java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.a(r8)
                r7.f104926a = r8
                r7.f104927b = r3
                java.lang.Object r8 = kotlinx.coroutines.BuildersKt.g(r1, r4, r7)
                if (r8 != r0) goto L94
            L93:
                return r0
            L94:
                kotlin.Unit r8 = kotlin.Unit.f139807a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.intro.stats.IntroReportPermissionFragment.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    public static final /* synthetic */ FragmentIntroQuestion4Binding O(IntroReportPermissionFragment introReportPermissionFragment) {
        return (FragmentIntroQuestion4Binding) introReportPermissionFragment.w();
    }

    @Override // cz.mobilesoft.coreblock.scene.intro.BaseIntroFragment
    public boolean L() {
        return this.f104924j;
    }

    @Override // cz.mobilesoft.coreblock.scene.intro.BaseIntroFragment
    public void N() {
        if (Intrinsics.areEqual(this.f104925k, Boolean.TRUE)) {
            AnswersHelper.f128199a.m3();
            this.f104925k = null;
            return;
        }
        AnswersHelper.f128199a.k3();
        String string = getString(R.string.F1);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        PermissionHelperV2 permissionHelperV2 = PermissionHelperV2.f129006a;
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        permissionHelperV2.h(fragmentActivityRequireActivity, string, requireActivity().getComponentName(), true);
    }

    @Override // cz.mobilesoft.coreblock.scene.intro.BaseIntroFragment, cz.mobilesoft.coreblock.base.fragment.BaseScrollViewFragment, cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public void y(FragmentIntroQuestion4Binding binding, View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(view, "view");
        super.y(binding, view, bundle);
        TextView descriptionTextView = binding.f96655c;
        Intrinsics.checkNotNullExpressionValue(descriptionTextView, "descriptionTextView");
        String string = getString(R.string.Oh, getString(R.string.f95790f1));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        ViewHelperExtKt.m(descriptionTextView, string, false, 2, null);
        TextView permissionTextView = binding.f96658f;
        Intrinsics.checkNotNullExpressionValue(permissionTextView, "permissionTextView");
        ViewHelperExtKt.l(permissionTextView, R.string.Ph, false, 2, null);
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Lifecycle lifecycle = getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "<get-lifecycle>(...)");
        CoroutinesHelperExtKt.c(lifecycle, Dispatchers.a(), new AnonymousClass1(null));
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public FragmentIntroQuestion4Binding z(LayoutInflater inflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentIntroQuestion4Binding fragmentIntroQuestion4BindingC = FragmentIntroQuestion4Binding.c(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(fragmentIntroQuestion4BindingC, FptyjHFU.GPkiFGzBcikwVG);
        return fragmentIntroQuestion4BindingC;
    }
}
