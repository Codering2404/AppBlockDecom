package cz.mobilesoft.coreblock.scene.strictmode3.component.emailinput;

import android.app.Application;
import android.util.Patterns;
import androidx.compose.ui.text.input.TextFieldValue;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.scene.strictmode3.component.emailinput.StrictModeEmailInputBottomSheetViewEvent;
import cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class StrictModeEmailInputBottomSheetViewModel extends BaseStatefulViewModel<StrictModeEmailInputBottomSheetViewState, StrictModeEmailInputBottomSheetViewEvent, StrictModeEmailInputBottomSheetViewCommand> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f121864o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StrictModeEmailInputBottomSheetViewModel(Application application) {
        super(application, new StrictModeEmailInputBottomSheetViewState(null, false, false, false, 15, null));
        Intrinsics.checkNotNullParameter(application, "application");
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f121864o = LazyKt.a(lazyThreadSafetyModeB, new Function0<StrictModeDataStore>() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.component.emailinput.StrictModeEmailInputBottomSheetViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeDataStore.class), qualifier, objArr);
            }
        });
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.component.emailinput.w
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StrictModeEmailInputBottomSheetViewModel.X0((StrictModeEmailInputBottomSheetViewState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StrictModeEmailInputBottomSheetViewState X0(StrictModeEmailInputBottomSheetViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return StrictModeEmailInputBottomSheetViewState.b(updateState, null, false, true, false, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StrictModeDataStore b1() {
        return (StrictModeDataStore) this.f121864o.getValue();
    }

    private final void c1(final TextFieldValue textFieldValue) {
        if (Patterns.EMAIL_ADDRESS.matcher(textFieldValue.i()).matches()) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.component.emailinput.x
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return StrictModeEmailInputBottomSheetViewModel.d1((StrictModeEmailInputBottomSheetViewState) obj);
                }
            });
        } else {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.component.emailinput.y
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return StrictModeEmailInputBottomSheetViewModel.e1((StrictModeEmailInputBottomSheetViewState) obj);
                }
            });
        }
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.component.emailinput.z
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StrictModeEmailInputBottomSheetViewModel.f1(textFieldValue, (StrictModeEmailInputBottomSheetViewState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StrictModeEmailInputBottomSheetViewState d1(StrictModeEmailInputBottomSheetViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return StrictModeEmailInputBottomSheetViewState.b(updateState, null, true, false, false, 13, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StrictModeEmailInputBottomSheetViewState e1(StrictModeEmailInputBottomSheetViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return StrictModeEmailInputBottomSheetViewState.b(updateState, null, false, false, false, 13, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StrictModeEmailInputBottomSheetViewState f1(TextFieldValue textFieldValue, StrictModeEmailInputBottomSheetViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return StrictModeEmailInputBottomSheetViewState.b(updateState, textFieldValue, false, false, false, 14, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g1(String str) {
        BuildersKt__Builders_commonKt.d(B0(), null, null, new StrictModeEmailInputBottomSheetViewModel$onEmailDoubleChecked$1(this, str, null), 3, null);
    }

    private final void h1() {
        if (Patterns.EMAIL_ADDRESS.matcher(((StrictModeEmailInputBottomSheetViewState) I0()).c().i()).matches()) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.component.emailinput.a0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return StrictModeEmailInputBottomSheetViewModel.i1((StrictModeEmailInputBottomSheetViewState) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StrictModeEmailInputBottomSheetViewState i1(StrictModeEmailInputBottomSheetViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return StrictModeEmailInputBottomSheetViewState.b(updateState, null, false, false, true, 3, null);
    }

    private final void k1() {
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.component.emailinput.v
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StrictModeEmailInputBottomSheetViewModel.l1((StrictModeEmailInputBottomSheetViewState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StrictModeEmailInputBottomSheetViewState l1(StrictModeEmailInputBottomSheetViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return StrictModeEmailInputBottomSheetViewState.b(updateState, null, false, true, false, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: j1, reason: merged with bridge method [inline-methods] */
    public void O0(StrictModeEmailInputBottomSheetViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof StrictModeEmailInputBottomSheetViewEvent.OnEmailChanged) {
            c1(((StrictModeEmailInputBottomSheetViewEvent.OnEmailChanged) event).a());
            return;
        }
        if (event instanceof StrictModeEmailInputBottomSheetViewEvent.OnEmailDoubleChecked) {
            BuildersKt__Builders_commonKt.d(B0(), null, null, new StrictModeEmailInputBottomSheetViewModel$onEvent$1(this, event, null), 3, null);
        } else if (Intrinsics.areEqual(event, StrictModeEmailInputBottomSheetViewEvent.OnEmailSet.f121863a)) {
            h1();
        } else {
            if (!Intrinsics.areEqual(event, StrictModeEmailInputBottomSheetViewEvent.OnDismiss.f121860a)) {
                throw new NoWhenBranchMatchedException();
            }
            k1();
        }
    }
}
