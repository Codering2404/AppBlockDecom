package androidx.compose.ui.text.input;

import android.graphics.Rect;
import android.view.Choreographer;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.input.pointer.MatrixPositionCalculator;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;

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
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
@Metadata
public final class TextInputServiceAndroid implements PlatformTextInputService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f29428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InputMethodManager f29429b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Executor f29430c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f29431d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Function1 f29432e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Function1 f29433f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TextFieldValue f29434g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ImeOptions f29435h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List f29436i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Lazy f29437j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Rect f29438k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final CursorAnchorInfoController f29439l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final MutableVector f29440m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Runnable f29441n;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class TextInputCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final TextInputCommand f29442a = new TextInputCommand("StartInput", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final TextInputCommand f29443b = new TextInputCommand("StopInput", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final TextInputCommand f29444c = new TextInputCommand("ShowKeyboard", 2);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final TextInputCommand f29445d = new TextInputCommand("HideKeyboard", 3);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final /* synthetic */ TextInputCommand[] f29446f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final /* synthetic */ EnumEntries f29447g;

        static {
            TextInputCommand[] textInputCommandArrA = a();
            f29446f = textInputCommandArrA;
            f29447g = EnumEntriesKt.a(textInputCommandArrA);
        }

        private TextInputCommand(String str, int i3) {
        }

        private static final /* synthetic */ TextInputCommand[] a() {
            return new TextInputCommand[]{f29442a, f29443b, f29444c, f29445d};
        }

        public static TextInputCommand valueOf(String str) {
            return (TextInputCommand) Enum.valueOf(TextInputCommand.class, str);
        }

        public static TextInputCommand[] values() {
            return (TextInputCommand[]) f29446f.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f29448a;

        static {
            int[] iArr = new int[TextInputCommand.values().length];
            try {
                iArr[TextInputCommand.f29442a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TextInputCommand.f29443b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TextInputCommand.f29444c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TextInputCommand.f29445d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f29448a = iArr;
        }
    }

    public TextInputServiceAndroid(View view, MatrixPositionCalculator matrixPositionCalculator, InputMethodManager inputMethodManager, Executor executor) {
        this.f29428a = view;
        this.f29429b = inputMethodManager;
        this.f29430c = executor;
        this.f29432e = new Function1<List<? extends EditCommand>, Unit>() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid$onEditCommand$1
            public final void invoke(List list) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List) obj);
                return Unit.f139807a;
            }
        };
        this.f29433f = new Function1<ImeAction, Unit>() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid$onImeActionPerformed$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c(((ImeAction) obj).p());
                return Unit.f139807a;
            }

            public final void c(int i3) {
            }
        };
        this.f29434g = new TextFieldValue("", TextRange.f28921b.a(), (TextRange) null, 4, (DefaultConstructorMarker) null);
        this.f29435h = ImeOptions.f29359h.a();
        this.f29436i = new ArrayList();
        this.f29437j = LazyKt.a(LazyThreadSafetyMode.f139763c, new Function0<BaseInputConnection>() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid$baseInputConnection$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final BaseInputConnection invoke() {
                return new BaseInputConnection(this.f29449a.q(), false);
            }
        });
        this.f29439l = new CursorAnchorInfoController(matrixPositionCalculator, inputMethodManager);
        this.f29440m = new MutableVector(new TextInputCommand[16], 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BaseInputConnection p() {
        return (BaseInputConnection) this.f29437j.getValue();
    }

    private final void s() {
        View viewFindFocus;
        if (!this.f29428a.isFocused() && (viewFindFocus = this.f29428a.getRootView().findFocus()) != null && viewFindFocus.onCheckIsTextEditor()) {
            this.f29440m.i();
            return;
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        MutableVector mutableVector = this.f29440m;
        Object[] objArr = mutableVector.f24389a;
        int iO = mutableVector.o();
        for (int i3 = 0; i3 < iO; i3++) {
            t((TextInputCommand) objArr[i3], objectRef, objectRef2);
        }
        this.f29440m.i();
        if (Intrinsics.areEqual(objectRef.f140144a, Boolean.TRUE)) {
            u();
        }
        Boolean bool = (Boolean) objectRef2.f140144a;
        if (bool != null) {
            x(bool.booleanValue());
        }
        if (Intrinsics.areEqual(objectRef.f140144a, Boolean.FALSE)) {
            u();
        }
    }

    private static final void t(TextInputCommand textInputCommand, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2) {
        int i3 = WhenMappings.f29448a[textInputCommand.ordinal()];
        if (i3 == 1) {
            Boolean bool = Boolean.TRUE;
            objectRef.f140144a = bool;
            objectRef2.f140144a = bool;
        } else if (i3 == 2) {
            Boolean bool2 = Boolean.FALSE;
            objectRef.f140144a = bool2;
            objectRef2.f140144a = bool2;
        } else if ((i3 == 3 || i3 == 4) && !Intrinsics.areEqual(objectRef.f140144a, Boolean.FALSE)) {
            objectRef2.f140144a = Boolean.valueOf(textInputCommand == TextInputCommand.f29444c);
        }
    }

    private final void u() {
        this.f29429b.b();
    }

    private final void v(TextInputCommand textInputCommand) {
        this.f29440m.b(textInputCommand);
        if (this.f29441n == null) {
            Runnable runnable = new Runnable() { // from class: androidx.compose.ui.text.input.c
                @Override // java.lang.Runnable
                public final void run() {
                    TextInputServiceAndroid.w(this.f29462a);
                }
            };
            this.f29430c.execute(runnable);
            this.f29441n = runnable;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(TextInputServiceAndroid textInputServiceAndroid) {
        textInputServiceAndroid.f29441n = null;
        textInputServiceAndroid.s();
    }

    private final void x(boolean z2) {
        if (z2) {
            this.f29429b.c();
        } else {
            this.f29429b.d();
        }
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public void a() {
        v(TextInputCommand.f29442a);
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public void b() {
        this.f29431d = false;
        this.f29432e = new Function1<List<? extends EditCommand>, Unit>() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid$stopInput$1
            public final void invoke(List list) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List) obj);
                return Unit.f139807a;
            }
        };
        this.f29433f = new Function1<ImeAction, Unit>() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid$stopInput$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c(((ImeAction) obj).p());
                return Unit.f139807a;
            }

            public final void c(int i3) {
            }
        };
        this.f29438k = null;
        v(TextInputCommand.f29443b);
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public void c() {
        v(TextInputCommand.f29445d);
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public void d(TextFieldValue textFieldValue, TextFieldValue textFieldValue2) {
        boolean z2 = (TextRange.g(this.f29434g.h(), textFieldValue2.h()) && Intrinsics.areEqual(this.f29434g.g(), textFieldValue2.g())) ? false : true;
        this.f29434g = textFieldValue2;
        int size = this.f29436i.size();
        for (int i3 = 0; i3 < size; i3++) {
            RecordingInputConnection recordingInputConnection = (RecordingInputConnection) ((WeakReference) this.f29436i.get(i3)).get();
            if (recordingInputConnection != null) {
                recordingInputConnection.f(textFieldValue2);
            }
        }
        this.f29439l.a();
        if (Intrinsics.areEqual(textFieldValue, textFieldValue2)) {
            if (z2) {
                InputMethodManager inputMethodManager = this.f29429b;
                int iL = TextRange.l(textFieldValue2.h());
                int iK = TextRange.k(textFieldValue2.h());
                TextRange textRangeG = this.f29434g.g();
                int iL2 = textRangeG != null ? TextRange.l(textRangeG.r()) : -1;
                TextRange textRangeG2 = this.f29434g.g();
                inputMethodManager.a(iL, iK, iL2, textRangeG2 != null ? TextRange.k(textRangeG2.r()) : -1);
                return;
            }
            return;
        }
        if (textFieldValue != null && (!Intrinsics.areEqual(textFieldValue.i(), textFieldValue2.i()) || (TextRange.g(textFieldValue.h(), textFieldValue2.h()) && !Intrinsics.areEqual(textFieldValue.g(), textFieldValue2.g())))) {
            u();
            return;
        }
        int size2 = this.f29436i.size();
        for (int i4 = 0; i4 < size2; i4++) {
            RecordingInputConnection recordingInputConnection2 = (RecordingInputConnection) ((WeakReference) this.f29436i.get(i4)).get();
            if (recordingInputConnection2 != null) {
                recordingInputConnection2.g(this.f29434g, this.f29429b);
            }
        }
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public void e() {
        v(TextInputCommand.f29444c);
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public void f(TextFieldValue textFieldValue, ImeOptions imeOptions, Function1 function1, Function1 function12) {
        this.f29431d = true;
        this.f29434g = textFieldValue;
        this.f29435h = imeOptions;
        this.f29432e = function1;
        this.f29433f = function12;
        v(TextInputCommand.f29442a);
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public void g(TextFieldValue textFieldValue, OffsetMapping offsetMapping, TextLayoutResult textLayoutResult, Function1 function1, androidx.compose.ui.geometry.Rect rect, androidx.compose.ui.geometry.Rect rect2) {
        this.f29439l.d(textFieldValue, offsetMapping, textLayoutResult, function1, rect, rect2);
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputService
    public void h(androidx.compose.ui.geometry.Rect rect) {
        Rect rect2;
        this.f29438k = new Rect(MathKt.d(rect.o()), MathKt.d(rect.r()), MathKt.d(rect.p()), MathKt.d(rect.i()));
        if (!this.f29436i.isEmpty() || (rect2 = this.f29438k) == null) {
            return;
        }
        this.f29428a.requestRectangleOnScreen(new Rect(rect2));
    }

    public final InputConnection o(EditorInfo editorInfo) {
        if (!this.f29431d) {
            return null;
        }
        TextInputServiceAndroid_androidKt.h(editorInfo, this.f29435h, this.f29434g);
        TextInputServiceAndroid_androidKt.i(editorInfo);
        RecordingInputConnection recordingInputConnection = new RecordingInputConnection(this.f29434g, new InputEventCallback2() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid$createInputConnection$1
            @Override // androidx.compose.ui.text.input.InputEventCallback2
            public void a(int i3) {
                this.f29450a.f29433f.invoke(ImeAction.j(i3));
            }

            @Override // androidx.compose.ui.text.input.InputEventCallback2
            public void b(KeyEvent keyEvent) {
                this.f29450a.p().sendKeyEvent(keyEvent);
            }

            @Override // androidx.compose.ui.text.input.InputEventCallback2
            public void c(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
                this.f29450a.f29439l.b(z2, z3, z4, z5, z6, z7);
            }

            @Override // androidx.compose.ui.text.input.InputEventCallback2
            public void d(List list) {
                this.f29450a.f29432e.invoke(list);
            }

            @Override // androidx.compose.ui.text.input.InputEventCallback2
            public void e(RecordingInputConnection recordingInputConnection2) {
                int size = this.f29450a.f29436i.size();
                for (int i3 = 0; i3 < size; i3++) {
                    if (Intrinsics.areEqual(((WeakReference) this.f29450a.f29436i.get(i3)).get(), recordingInputConnection2)) {
                        this.f29450a.f29436i.remove(i3);
                        return;
                    }
                }
            }
        }, this.f29435h.b());
        this.f29436i.add(new WeakReference(recordingInputConnection));
        return recordingInputConnection;
    }

    public final View q() {
        return this.f29428a;
    }

    public final boolean r() {
        return this.f29431d;
    }

    public /* synthetic */ TextInputServiceAndroid(View view, MatrixPositionCalculator matrixPositionCalculator, InputMethodManager inputMethodManager, Executor executor, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, matrixPositionCalculator, inputMethodManager, (i3 & 8) != 0 ? TextInputServiceAndroid_androidKt.d(Choreographer.getInstance()) : executor);
    }

    public TextInputServiceAndroid(View view, MatrixPositionCalculator matrixPositionCalculator) {
        this(view, matrixPositionCalculator, new InputMethodManagerImpl(view), null, 8, null);
    }
}
