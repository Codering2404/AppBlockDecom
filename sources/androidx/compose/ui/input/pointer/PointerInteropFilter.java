package androidx.compose.ui.input.pointer;

import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class PointerInteropFilter implements PointerInputModifier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function1 f26897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private RequestDisallowInterceptTouchEvent f26898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f26899c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PointerInputFilter f26900d = new PointerInteropFilter$pointerInputFilter$1(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class DispatchToViewState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DispatchToViewState f26901a = new DispatchToViewState(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final DispatchToViewState f26902b = new DispatchToViewState("Dispatching", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final DispatchToViewState f26903c = new DispatchToViewState("NotDispatching", 2);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ DispatchToViewState[] f26904d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final /* synthetic */ EnumEntries f26905f;

        static {
            DispatchToViewState[] dispatchToViewStateArrA = a();
            f26904d = dispatchToViewStateArrA;
            f26905f = EnumEntriesKt.a(dispatchToViewStateArrA);
        }

        private DispatchToViewState(String str, int i3) {
        }

        private static final /* synthetic */ DispatchToViewState[] a() {
            return new DispatchToViewState[]{f26901a, f26902b, f26903c};
        }

        public static DispatchToViewState valueOf(String str) {
            return (DispatchToViewState) Enum.valueOf(DispatchToViewState.class, str);
        }

        public static DispatchToViewState[] values() {
            return (DispatchToViewState[]) f26904d.clone();
        }
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputModifier
    public PointerInputFilter C1() {
        return this.f26900d;
    }

    public final boolean a() {
        return this.f26899c;
    }

    public final Function1 b() {
        Function1 function1 = this.f26897a;
        if (function1 != null) {
            return function1;
        }
        Intrinsics.throwUninitializedPropertyAccessException("onTouchEvent");
        return null;
    }

    public final void c(boolean z2) {
        this.f26899c = z2;
    }

    public final void d(Function1 function1) {
        this.f26897a = function1;
    }

    public final void e(RequestDisallowInterceptTouchEvent requestDisallowInterceptTouchEvent) {
        RequestDisallowInterceptTouchEvent requestDisallowInterceptTouchEvent2 = this.f26898b;
        if (requestDisallowInterceptTouchEvent2 != null) {
            requestDisallowInterceptTouchEvent2.d(null);
        }
        this.f26898b = requestDisallowInterceptTouchEvent;
        if (requestDisallowInterceptTouchEvent == null) {
            return;
        }
        requestDisallowInterceptTouchEvent.d(this);
    }
}
