package cz.mobilesoft.coreblock.scene.lockscreen.backdoor;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.ContextThemeWrapper;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.databinding.DialogRichEditTextBinding;
import cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorUtils;
import cz.mobilesoft.coreblock.storage.datastore.PassCodeDataStore;
import cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore;
import cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore;
import cz.mobilesoft.coreblock.usecase.BackdoorCodeUseCase;
import cz.mobilesoft.coreblock.util.Canceled;
import cz.mobilesoft.coreblock.util.FailedWithError;
import cz.mobilesoft.coreblock.util.ViewModelState;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.koin.core.Koin;
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
public final class BackdoorCodeDialog implements KoinComponent {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Companion f105571p = new Companion(null);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f105572q = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f105573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f105574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f105575c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f105576d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f105577f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f105578g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final CoroutineScope f105579h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final CoroutineScope f105580i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final MutableStateFlow f105581j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private DialogRichEditTextBinding f105582k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private AlertDialog f105583l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Button f105584m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Job f105585n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Pattern f105586o;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BackdoorCodeDialog(Context context, List unlockTypes) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(unlockTypes, "unlockTypes");
        this.f105573a = context;
        this.f105574b = unlockTypes;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f105575c = LazyKt.a(lazyThreadSafetyModeB, new Function0<BackdoorCodeUseCase>() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(BackdoorCodeUseCase.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f105576d = LazyKt.a(lazyThreadSafetyModeB2, new Function0<DevDataStore>() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DevDataStore.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f105577f = LazyKt.a(lazyThreadSafetyModeB3, new Function0<StrictModeDataStore>() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeDataStore.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f105578g = LazyKt.a(lazyThreadSafetyModeB4, new Function0<PassCodeDataStore>() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PassCodeDataStore.class), objArr6, objArr7);
            }
        });
        this.f105579h = CoroutineScopeKt.a(Dispatchers.a().plus(SupervisorKt.b(null, 1, null)).plus(CoroutinesHelperExtKt.b()));
        this.f105580i = CoroutineScopeKt.a(Dispatchers.c().plus(SupervisorKt.b(null, 1, null)).plus(CoroutinesHelperExtKt.b()));
        this.f105581j = StateFlowKt.a(Canceled.f127782a);
        Pattern patternCompile = Pattern.compile("\\p{XDigit}+");
        Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(...)");
        this.f105586o = patternCompile;
    }

    private final BackdoorCodeUseCase A() {
        return (BackdoorCodeUseCase) this.f105575c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DevDataStore C() {
        return (DevDataStore) this.f105576d.getValue();
    }

    private final PassCodeDataStore D() {
        return (PassCodeDataStore) this.f105578g.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object E(kotlin.coroutines.Continuation r13) throws java.lang.Throwable {
        /*
            r12 = this;
            boolean r0 = r13 instanceof cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog$getRemainingDelay$1
            if (r0 == 0) goto L13
            r0 = r13
            cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog$getRemainingDelay$1 r0 = (cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog$getRemainingDelay$1) r0
            int r1 = r0.f105612d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f105612d = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog$getRemainingDelay$1 r0 = new cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog$getRemainingDelay$1
            r0.<init>(r12, r13)
        L18:
            java.lang.Object r13 = r0.f105610b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f105612d
            r3 = 0
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L3c
            if (r2 == r6) goto L38
            if (r2 != r5) goto L30
            int r0 = r0.f105609a
            kotlin.ResultKt.b(r13)
            goto L74
        L30:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L38:
            kotlin.ResultKt.b(r13)
            goto L50
        L3c:
            kotlin.ResultKt.b(r13)
            cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore r13 = r12.F()
            kotlinx.coroutines.flow.Flow r13 = r13.j0()
            r0.f105612d = r6
            java.lang.Object r13 = kotlinx.coroutines.flow.FlowKt.D(r13, r0)
            if (r13 != r1) goto L50
            goto L70
        L50:
            java.lang.Number r13 = (java.lang.Number) r13
            int r13 = r13.intValue()
            r2 = 5
            if (r13 > r2) goto L5e
            java.lang.Long r13 = kotlin.coroutines.jvm.internal.Boxing.e(r3)
            return r13
        L5e:
            cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore r2 = r12.F()
            kotlinx.coroutines.flow.Flow r2 = r2.k0()
            r0.f105609a = r13
            r0.f105612d = r5
            java.lang.Object r0 = kotlinx.coroutines.flow.FlowKt.D(r2, r0)
            if (r0 != r1) goto L71
        L70:
            return r1
        L71:
            r11 = r0
            r0 = r13
            r13 = r11
        L74:
            java.lang.Number r13 = (java.lang.Number) r13
            long r1 = r13.longValue()
            long r5 = java.lang.System.currentTimeMillis()
            int r13 = r12.w(r0)
            long r7 = (long) r13
            r9 = 1000(0x3e8, double:4.94E-321)
            long r7 = r7 * r9
            long r5 = r5 - r1
            long r7 = r7 - r5
            long r0 = kotlin.ranges.RangesKt.g(r7, r3)
            java.lang.Long r13 = kotlin.coroutines.jvm.internal.Boxing.e(r0)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog.E(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StrictModeDataStore F() {
        return (StrictModeDataStore) this.f105577f.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object H(kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r10 instanceof cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog$logStrictModeDeactivation$1
            if (r0 == 0) goto L13
            r0 = r10
            cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog$logStrictModeDeactivation$1 r0 = (cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog$logStrictModeDeactivation$1) r0
            int r1 = r0.f105617f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f105617f = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog$logStrictModeDeactivation$1 r0 = new cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog$logStrictModeDeactivation$1
            r0.<init>(r9, r10)
        L18:
            java.lang.Object r10 = r0.f105615c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f105617f
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L49
            if (r2 == r5) goto L3d
            if (r2 != r4) goto L35
            java.lang.Object r1 = r0.f105614b
            cz.mobilesoft.coreblock.scene.strictmode.dto.StrictModeConfigDTO r1 = (cz.mobilesoft.coreblock.scene.strictmode.dto.StrictModeConfigDTO) r1
            java.lang.Object r0 = r0.f105613a
            cz.mobilesoft.coreblock.util.analytics.AnswersHelper r0 = (cz.mobilesoft.coreblock.util.analytics.AnswersHelper) r0
            kotlin.ResultKt.b(r10)
            goto L8a
        L35:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L3d:
            java.lang.Object r2 = r0.f105614b
            cz.mobilesoft.coreblock.scene.strictmode.dto.StrictModeConfigDTO r2 = (cz.mobilesoft.coreblock.scene.strictmode.dto.StrictModeConfigDTO) r2
            java.lang.Object r6 = r0.f105613a
            cz.mobilesoft.coreblock.util.analytics.AnswersHelper r6 = (cz.mobilesoft.coreblock.util.analytics.AnswersHelper) r6
            kotlin.ResultKt.b(r10)
            goto L6f
        L49:
            kotlin.ResultKt.b(r10)
            cz.mobilesoft.coreblock.util.analytics.AnswersHelper r10 = cz.mobilesoft.coreblock.util.analytics.AnswersHelper.f128199a
            cz.mobilesoft.coreblock.scene.strictmode.dto.StrictModeConfigDTO r2 = new cz.mobilesoft.coreblock.scene.strictmode.dto.StrictModeConfigDTO
            java.util.List r6 = kotlin.collections.CollectionsKt.emptyList()
            r2.<init>(r6, r3)
            cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore r6 = r9.F()
            kotlinx.coroutines.flow.Flow r6 = r6.f0()
            r0.f105613a = r10
            r0.f105614b = r2
            r0.f105617f = r5
            java.lang.Object r6 = kotlinx.coroutines.flow.FlowKt.D(r6, r0)
            if (r6 != r1) goto L6c
            goto L87
        L6c:
            r8 = r6
            r6 = r10
            r10 = r8
        L6f:
            cz.mobilesoft.coreblock.enums.StrictModeAccessMethod r7 = cz.mobilesoft.coreblock.enums.StrictModeAccessMethod.Timer
            if (r10 != r7) goto L8f
            cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore r10 = r9.F()
            kotlinx.coroutines.flow.Flow r10 = r10.z0()
            r0.f105613a = r6
            r0.f105614b = r2
            r0.f105617f = r4
            java.lang.Object r10 = kotlinx.coroutines.flow.FlowKt.D(r10, r0)
            if (r10 != r1) goto L88
        L87:
            return r1
        L88:
            r1 = r2
            r0 = r6
        L8a:
            r3 = r10
            java.lang.Long r3 = (java.lang.Long) r3
            r6 = r0
            r2 = r1
        L8f:
            r6.l7(r2, r3, r5, r5)
            kotlin.Unit r10 = kotlin.Unit.f139807a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog.H(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object I(Continuation continuation) {
        Object objP0 = F().P0(0, continuation);
        return objP0 == IntrinsicsKt.f() ? objP0 : Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0053, code lost:
    
        if (r7.J(0, r0) == r1) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object J(kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog$resetPinFailedAttempts$1
            if (r0 == 0) goto L13
            r0 = r7
            cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog$resetPinFailedAttempts$1 r0 = (cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog$resetPinFailedAttempts$1) r0
            int r1 = r0.f105620c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f105620c = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog$resetPinFailedAttempts$1 r0 = new cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog$resetPinFailedAttempts$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f105618a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f105620c
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L39
            if (r2 == r5) goto L35
            if (r2 != r4) goto L2d
            kotlin.ResultKt.b(r7)
            goto L56
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L35:
            kotlin.ResultKt.b(r7)
            goto L49
        L39:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore r7 = r6.F()
            r0.f105620c = r5
            java.lang.Object r7 = r7.W0(r3, r0)
            if (r7 != r1) goto L49
            goto L55
        L49:
            cz.mobilesoft.coreblock.storage.datastore.PassCodeDataStore r7 = r6.D()
            r0.f105620c = r4
            java.lang.Object r7 = r7.J(r3, r0)
            if (r7 != r1) goto L56
        L55:
            return r1
        L56:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog.J(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object K(kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog$shouldResetAttempts$1
            if (r0 == 0) goto L13
            r0 = r7
            cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog$shouldResetAttempts$1 r0 = (cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog$shouldResetAttempts$1) r0
            int r1 = r0.f105623c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f105623c = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog$shouldResetAttempts$1 r0 = new cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog$shouldResetAttempts$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f105621a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f105623c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r7)
            goto L45
        L29:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L31:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore r7 = r6.F()
            kotlinx.coroutines.flow.Flow r7 = r7.k0()
            r0.f105623c = r3
            java.lang.Object r7 = kotlinx.coroutines.flow.FlowKt.D(r7, r0)
            if (r7 != r1) goto L45
            return r1
        L45:
            java.lang.Number r7 = (java.lang.Number) r7
            long r0 = r7.longValue()
            long r4 = java.lang.System.currentTimeMillis()
            long r4 = r4 - r0
            r0 = 3600000(0x36ee80, double:1.7786363E-317)
            int r7 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r7 < 0) goto L58
            goto L59
        L58:
            r3 = 0
        L59:
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.a(r3)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog.K(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ void M(BackdoorCodeDialog backdoorCodeDialog, Function0 function0, Function0 function02, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function02 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.backdoor.a
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return BackdoorCodeDialog.N();
                }
            };
        }
        backdoorCodeDialog.L(function0, function02);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean O(BackdoorCodeDialog backdoorCodeDialog, Function0 function0, TextView textView, int i3, KeyEvent keyEvent) {
        if (i3 != 6) {
            return false;
        }
        backdoorCodeDialog.x(function0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(BackdoorCodeDialog backdoorCodeDialog, DialogInterface dialogInterface) {
        Job job = backdoorCodeDialog.f105585n;
        DialogRichEditTextBinding dialogRichEditTextBinding = null;
        if (job != null) {
            Job.DefaultImpls.b(job, null, 1, null);
        }
        DialogRichEditTextBinding dialogRichEditTextBinding2 = backdoorCodeDialog.f105582k;
        if (dialogRichEditTextBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dialogRichEditTextBinding = dialogRichEditTextBinding2;
        }
        TextView countdownTextView = dialogRichEditTextBinding.f96532c;
        Intrinsics.checkNotNullExpressionValue(countdownTextView, "countdownTextView");
        countdownTextView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(final BackdoorCodeDialog backdoorCodeDialog, final DialogRichEditTextBinding dialogRichEditTextBinding, final Function0 function0, final Function0 function02, DialogInterface dialogInterface) {
        DisplayMetrics displayMetrics;
        AlertDialog alertDialog = backdoorCodeDialog.f105583l;
        if (alertDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("alertDialog");
            alertDialog = null;
        }
        Button buttonJ = alertDialog.j(-1);
        backdoorCodeDialog.f105584m = buttonJ;
        if (buttonJ != null) {
            buttonJ.setOnClickListener(new View.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.backdoor.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BackdoorCodeDialog.R(this.f105664a, function0, view);
                }
            });
        }
        BuildersKt__Builders_commonKt.d(backdoorCodeDialog.f105579h, null, null, new BackdoorCodeDialog$show$2$3$2(backdoorCodeDialog, null), 3, null);
        dialogRichEditTextBinding.f96533d.addTextChangedListener(new TextWatcher() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog$show$2$3$3
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                boolean z2 = false;
                boolean z3 = (editable != null ? editable.length() : 0) >= 20;
                boolean z4 = this.f105626a.f105581j.getValue() instanceof Canceled;
                TextView infoTextView = dialogRichEditTextBinding.f96535f;
                Intrinsics.checkNotNullExpressionValue(infoTextView, "infoTextView");
                infoTextView.setVisibility(z3 && z4 ? 0 : 8);
                ViewModelState viewModelState = (ViewModelState) this.f105626a.f105581j.getValue();
                Button button = this.f105626a.f105584m;
                if (button != null) {
                    if (!z3 && ((viewModelState instanceof Canceled) || (viewModelState instanceof FailedWithError))) {
                        Job job = this.f105626a.f105585n;
                        if (!(job != null && job.isActive())) {
                            z2 = true;
                        }
                    }
                    button.setEnabled(z2);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
            }
        });
        AlertDialog alertDialog2 = backdoorCodeDialog.f105583l;
        if (alertDialog2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("alertDialog");
            alertDialog2 = null;
        }
        Button buttonJ2 = alertDialog2.j(-2);
        if (buttonJ2 != null) {
            buttonJ2.setOnClickListener(new View.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.backdoor.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BackdoorCodeDialog.S(function02, backdoorCodeDialog, view);
                }
            });
        }
        AlertDialog alertDialog3 = backdoorCodeDialog.f105583l;
        if (alertDialog3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("alertDialog");
            alertDialog3 = null;
        }
        Window window = alertDialog3.getWindow();
        if (window != null) {
            window.setSoftInputMode(5);
        }
        AlertDialog alertDialog4 = backdoorCodeDialog.f105583l;
        if (alertDialog4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("alertDialog");
            alertDialog4 = null;
        }
        Window window2 = alertDialog4.getWindow();
        if (window2 != null) {
            Resources resources = backdoorCodeDialog.f105573a.getResources();
            int i3 = (int) (((resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) ? 0 : displayMetrics.widthPixels) * 0.9f);
            window2.setLayout(i3 > 0 ? i3 : -1, -2);
        }
        dialogRichEditTextBinding.f96533d.requestFocus();
        BuildersKt__Builders_commonKt.d(backdoorCodeDialog.f105580i, null, null, new BackdoorCodeDialog$show$2$3$6(backdoorCodeDialog, dialogRichEditTextBinding, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(BackdoorCodeDialog backdoorCodeDialog, Function0 function0, View view) {
        backdoorCodeDialog.x(function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(Function0 function0, BackdoorCodeDialog backdoorCodeDialog, View view) {
        function0.invoke();
        AlertDialog alertDialog = backdoorCodeDialog.f105583l;
        if (alertDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("alertDialog");
            alertDialog = null;
        }
        alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T() {
        Job job = this.f105585n;
        if (job != null) {
            Job.DefaultImpls.b(job, null, 1, null);
        }
        this.f105585n = BuildersKt__Builders_commonKt.d(this.f105580i, null, null, new BackdoorCodeDialog$startCountdown$1(this, null), 3, null);
    }

    private final int w(int i3) {
        if (i3 <= 5) {
            return 0;
        }
        return RangesKt.k((1 << (i3 - 6)) * 5, 320);
    }

    private final void x(Function0 function0) {
        BuildersKt__Builders_commonKt.d(this.f105579h, null, null, new BackdoorCodeDialog$checkCode$1(this, function0, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object y(Function0 function0, Continuation continuation) {
        ViewModelState viewModelState = (ViewModelState) this.f105581j.getValue();
        DialogRichEditTextBinding dialogRichEditTextBinding = null;
        if (!Intrinsics.areEqual(viewModelState, Canceled.f127782a)) {
            if (viewModelState instanceof FailedWithError) {
                BuildersKt__Builders_commonKt.d(this.f105579h, null, null, new BackdoorCodeDialog$checkRealCode$3(this, null), 3, null);
            }
            return Unit.f139807a;
        }
        DialogRichEditTextBinding dialogRichEditTextBinding2 = this.f105582k;
        if (dialogRichEditTextBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dialogRichEditTextBinding = dialogRichEditTextBinding2;
        }
        Object objCollect = A().a(new BackdoorCodeUseCase.Params(dialogRichEditTextBinding.f96533d.getText().toString())).collect(new BackdoorCodeDialog$checkRealCode$2(this, function0), continuation);
        return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a0, code lost:
    
        if (I(r0) != r1) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0098 A[PHI: r8
      0x0098: PHI (r8v3 kotlin.jvm.functions.Function0) = (r8v2 kotlin.jvm.functions.Function0), (r8v11 kotlin.jvm.functions.Function0) binds: [B:30:0x0095, B:17:0x003f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object z(kotlin.jvm.functions.Function0 r8, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog$fakeDevCodeCheck$1
            if (r0 == 0) goto L13
            r0 = r9
            cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog$fakeDevCodeCheck$1 r0 = (cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog$fakeDevCodeCheck$1) r0
            int r1 = r0.f105608d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f105608d = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog$fakeDevCodeCheck$1 r0 = new cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog$fakeDevCodeCheck$1
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.f105606b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f105608d
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L57
            if (r2 == r6) goto L4f
            if (r2 == r5) goto L47
            if (r2 == r4) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r8 = r0.f105605a
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            kotlin.ResultKt.b(r9)
            goto La3
        L37:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3f:
            java.lang.Object r8 = r0.f105605a
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            kotlin.ResultKt.b(r9)
            goto L98
        L47:
            java.lang.Object r8 = r0.f105605a
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            kotlin.ResultKt.b(r9)
            goto L80
        L4f:
            java.lang.Object r8 = r0.f105605a
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            kotlin.ResultKt.b(r9)
            goto L71
        L57:
            kotlin.ResultKt.b(r9)
            cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorUtils r9 = cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorUtils.f105650a
            java.util.List r2 = r7.f105574b
            r9.b(r2)
            cz.mobilesoft.coreblock.util.analytics.AnswersHelper r9 = cz.mobilesoft.coreblock.util.analytics.AnswersHelper.f128199a
            r9.Q7()
            r0.f105605a = r8
            r0.f105608d = r6
            java.lang.Object r9 = r7.H(r0)
            if (r9 != r1) goto L71
            goto La2
        L71:
            kotlinx.coroutines.flow.MutableStateFlow r9 = r7.f105581j
            cz.mobilesoft.coreblock.util.Success r2 = cz.mobilesoft.coreblock.util.Success.f128020a
            r0.f105605a = r8
            r0.f105608d = r5
            java.lang.Object r9 = r9.emit(r2, r0)
            if (r9 != r1) goto L80
            goto La2
        L80:
            androidx.appcompat.app.AlertDialog r9 = r7.f105583l
            if (r9 != 0) goto L8a
            java.lang.String r9 = "alertDialog"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            r9 = 0
        L8a:
            r9.dismiss()
            r0.f105605a = r8
            r0.f105608d = r4
            java.lang.Object r9 = r7.J(r0)
            if (r9 != r1) goto L98
            goto La2
        L98:
            r0.f105605a = r8
            r0.f105608d = r3
            java.lang.Object r9 = r7.I(r0)
            if (r9 != r1) goto La3
        La2:
            return r1
        La3:
            r8.invoke()
            kotlin.Unit r8 = kotlin.Unit.f139807a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog.z(kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Context B() {
        return this.f105573a;
    }

    public final List G() {
        return this.f105574b;
    }

    public final void L(final Function0 onSuccess, final Function0 onCancel) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onCancel, "onCancel");
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(this.f105573a, R.style.f95866a);
        final DialogRichEditTextBinding dialogRichEditTextBindingC = DialogRichEditTextBinding.c(LayoutInflater.from(contextThemeWrapper));
        Intrinsics.checkNotNullExpressionValue(dialogRichEditTextBindingC, "inflate(...)");
        this.f105582k = dialogRichEditTextBindingC;
        AlertDialog alertDialog = null;
        if (dialogRichEditTextBindingC == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogRichEditTextBindingC = null;
        }
        dialogRichEditTextBindingC.f96533d.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.backdoor.b
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
                return BackdoorCodeDialog.O(this.f105657a, onSuccess, textView, i3, keyEvent);
            }
        });
        dialogRichEditTextBindingC.f96533d.setFilters(new InputFilter.AllCaps[]{new InputFilter.AllCaps()});
        dialogRichEditTextBindingC.f96535f.setText(this.f105573a.getString(R.string.Gj, 20));
        TextView infoTextView = dialogRichEditTextBindingC.f96535f;
        Intrinsics.checkNotNullExpressionValue(infoTextView, "infoTextView");
        infoTextView.setVisibility(8);
        AlertDialog alertDialogA = new MaterialAlertDialogBuilder(contextThemeWrapper).P(R.string.wd).u(dialogRichEditTextBindingC.getRoot()).L(R.string.PF, null).G(android.R.string.cancel, null).a();
        Intrinsics.checkNotNullExpressionValue(alertDialogA, "create(...)");
        this.f105583l = alertDialogA;
        if (alertDialogA == null) {
            Intrinsics.throwUninitializedPropertyAccessException("alertDialog");
            alertDialogA = null;
        }
        alertDialogA.setCanceledOnTouchOutside(false);
        AlertDialog alertDialog2 = this.f105583l;
        if (alertDialog2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("alertDialog");
            alertDialog2 = null;
        }
        alertDialog2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.backdoor.c
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                BackdoorCodeDialog.P(this.f105659a, dialogInterface);
            }
        });
        AlertDialog alertDialog3 = this.f105583l;
        if (alertDialog3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("alertDialog");
            alertDialog3 = null;
        }
        alertDialog3.setOnShowListener(new DialogInterface.OnShowListener() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.backdoor.d
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                BackdoorCodeDialog.Q(this.f105660a, dialogRichEditTextBindingC, onSuccess, onCancel, dialogInterface);
            }
        });
        if (!(this.f105573a instanceof Activity)) {
            AlertDialog alertDialog4 = this.f105583l;
            if (alertDialog4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("alertDialog");
                alertDialog4 = null;
            }
            Window window = alertDialog4.getWindow();
            if (window != null) {
                window.setType(2038);
            }
        }
        AlertDialog alertDialog5 = this.f105583l;
        if (alertDialog5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("alertDialog");
        } else {
            alertDialog = alertDialog5;
        }
        alertDialog.show();
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    public /* synthetic */ BackdoorCodeDialog(Context context, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? BackdoorUtils.UnlockType.getEntries() : list);
    }
}
