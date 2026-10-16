package androidx.compose.foundation.text.input;

import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.foundation.text.input.TextUndoManager;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
public final class TextFieldState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextUndoManager f10149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TextFieldBuffer f10150b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableState f10151c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MutableState f10152d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final UndoState f10153e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final MutableVector f10154f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface NotifyImeListener {
        void a(TextFieldCharSequence textFieldCharSequence, TextFieldCharSequence textFieldCharSequence2, boolean z2);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Saver implements androidx.compose.runtime.saveable.Saver<TextFieldState, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Saver f10155a = new Saver();

        private Saver() {
        }

        @Override // androidx.compose.runtime.saveable.Saver
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public TextFieldState b(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<*>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            Object obj3 = list.get(1);
            Object obj4 = list.get(2);
            Object obj5 = list.get(3);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj2;
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Int");
            int iIntValue = ((Integer) obj3).intValue();
            Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Int");
            long jB = TextRangeKt.b(iIntValue, ((Integer) obj4).intValue());
            TextUndoManager.Companion.Saver saver = TextUndoManager.Companion.Saver.f10172a;
            Intrinsics.checkNotNull(obj5);
            TextUndoManager textUndoManagerC = saver.b(obj5);
            Intrinsics.checkNotNull(textUndoManagerC);
            return new TextFieldState(str, jB, textUndoManagerC, null);
        }

        @Override // androidx.compose.runtime.saveable.Saver
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Object a(SaverScope saverScope, TextFieldState textFieldState) {
            return CollectionsKt.listOf(textFieldState.h().toString(), Integer.valueOf(TextRange.n(textFieldState.g())), Integer.valueOf(TextRange.i(textFieldState.g())), TextUndoManager.Companion.Saver.f10172a.a(saverScope, textFieldState.i()));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10156a;

        static {
            int[] iArr = new int[TextFieldEditUndoBehavior.values().length];
            try {
                iArr[TextFieldEditUndoBehavior.f10977b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TextFieldEditUndoBehavior.f10976a.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TextFieldEditUndoBehavior.f10978c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f10156a = iArr;
        }
    }

    public /* synthetic */ TextFieldState(String str, long j3, TextUndoManager textUndoManager, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j3, textUndoManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(InputTransformation inputTransformation, boolean z2, TextFieldEditUndoBehavior textFieldEditUndoBehavior) {
        TextFieldCharSequence textFieldCharSequenceK = k();
        if (this.f10150b.e().b() == 0 && TextRange.g(textFieldCharSequenceK.g(), this.f10150b.l())) {
            if (Intrinsics.areEqual(textFieldCharSequenceK.d(), this.f10150b.h()) && Intrinsics.areEqual(textFieldCharSequenceK.e(), this.f10150b.i()) && Intrinsics.areEqual(textFieldCharSequenceK.c(), this.f10150b.g())) {
                return;
            }
            q(k(), new TextFieldCharSequence(this.f10150b.toString(), this.f10150b.l(), this.f10150b.h(), this.f10150b.i(), TextFieldStateKt.b(this.f10150b.h(), this.f10150b.g()), null), z2);
            return;
        }
        boolean z3 = false;
        boolean z4 = this.f10150b.e().b() != 0;
        TextFieldCharSequence textFieldCharSequence = new TextFieldCharSequence(this.f10150b.toString(), this.f10150b.l(), this.f10150b.h(), this.f10150b.i(), TextFieldStateKt.b(this.f10150b.h(), this.f10150b.g()), null);
        if (inputTransformation == null) {
            if (z4 && z2) {
                z3 = true;
            }
            q(textFieldCharSequenceK, textFieldCharSequence, z3);
            l(textFieldCharSequenceK, textFieldCharSequence, this.f10150b.e(), textFieldEditUndoBehavior);
            return;
        }
        TextFieldBuffer textFieldBuffer = new TextFieldBuffer(textFieldCharSequence, this.f10150b.e(), textFieldCharSequenceK, null, 8, null);
        inputTransformation.O(textFieldBuffer);
        boolean zA = StringsKt.A(textFieldBuffer.a(), textFieldCharSequence);
        boolean z5 = !zA;
        boolean zG = TextRange.g(textFieldBuffer.l(), textFieldCharSequence.g());
        boolean z6 = !zG;
        if (zA && zG) {
            q(textFieldCharSequenceK, TextFieldBuffer.A(textFieldBuffer, 0L, textFieldCharSequence.d(), null, 5, null), z2);
        } else {
            p(textFieldBuffer, z5, z6);
        }
        l(textFieldCharSequenceK, k(), textFieldBuffer.f(), textFieldEditUndoBehavior);
    }

    private final void l(TextFieldCharSequence textFieldCharSequence, TextFieldCharSequence textFieldCharSequence2, TextFieldBuffer.ChangeList changeList, TextFieldEditUndoBehavior textFieldEditUndoBehavior) {
        int i3 = WhenMappings.f10156a[textFieldEditUndoBehavior.ordinal()];
        if (i3 == 1) {
            this.f10149a.c();
        } else if (i3 == 2) {
            TextUndoManagerKt.c(this.f10149a, textFieldCharSequence, textFieldCharSequence2, changeList, true);
        } else {
            if (i3 != 3) {
                return;
            }
            TextUndoManagerKt.c(this.f10149a, textFieldCharSequence, textFieldCharSequence2, changeList, false);
        }
    }

    private final void n(boolean z2) {
        this.f10151c.setValue(Boolean.valueOf(z2));
    }

    private final void o(TextFieldCharSequence textFieldCharSequence) {
        this.f10152d.setValue(textFieldCharSequence);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(TextFieldCharSequence textFieldCharSequence, TextFieldCharSequence textFieldCharSequence2, boolean z2) {
        o(textFieldCharSequence2);
        e();
        MutableVector mutableVector = this.f10154f;
        Object[] objArr = mutableVector.f24389a;
        int iO = mutableVector.o();
        for (int i3 = 0; i3 < iO; i3++) {
            ((NotifyImeListener) objArr[i3]).a(textFieldCharSequence, textFieldCharSequence2, (!z2 || textFieldCharSequence.a(textFieldCharSequence2) || textFieldCharSequence.d() == null) ? false : true);
        }
    }

    public final void c(NotifyImeListener notifyImeListener) {
        this.f10154f.b(notifyImeListener);
    }

    public final void e() {
        n(false);
    }

    public final TextFieldBuffer f() {
        return this.f10150b;
    }

    public final long g() {
        return k().g();
    }

    public final CharSequence h() {
        return k().h();
    }

    public final TextUndoManager i() {
        return this.f10149a;
    }

    public final UndoState j() {
        return this.f10153e;
    }

    public final TextFieldCharSequence k() {
        return (TextFieldCharSequence) this.f10152d.getValue();
    }

    public final void m(NotifyImeListener notifyImeListener) {
        this.f10154f.s(notifyImeListener);
    }

    public final void p(TextFieldBuffer textFieldBuffer, boolean z2, boolean z3) {
        TextFieldCharSequence textFieldCharSequenceA = TextFieldBuffer.A(this.f10150b, 0L, null, null, 7, null);
        if (z2) {
            this.f10150b = new TextFieldBuffer(new TextFieldCharSequence(textFieldBuffer.toString(), textFieldBuffer.l(), null, null, null, 28, null), null, null, null, 14, null);
        } else if (z3) {
            this.f10150b.x(TextRangeKt.b(TextRange.n(textFieldBuffer.l()), TextRange.i(textFieldBuffer.l())));
        }
        if (z2 || z3 || !Intrinsics.areEqual(textFieldCharSequenceA.d(), textFieldBuffer.h())) {
            this.f10150b.d();
        }
        q(textFieldCharSequenceA, TextFieldBuffer.A(this.f10150b, 0L, null, null, 7, null), true);
    }

    public String toString() {
        Snapshot.Companion companion = Snapshot.f24914e;
        Snapshot snapshotD = companion.d();
        Function1 function1G = snapshotD != null ? snapshotD.g() : null;
        Snapshot snapshotE = companion.e(snapshotD);
        try {
            return "TextFieldState(selection=" + ((Object) TextRange.q(g())) + ", text=\"" + ((Object) h()) + "\")";
        } finally {
            companion.m(snapshotD, snapshotE, function1G);
        }
    }

    public /* synthetic */ TextFieldState(String str, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j3);
    }

    private TextFieldState(String str, long j3, TextUndoManager textUndoManager) {
        this.f10149a = textUndoManager;
        this.f10150b = new TextFieldBuffer(new TextFieldCharSequence(str, TextRangeKt.c(j3, 0, str.length()), null, null, null, 28, null), null, null, null, 14, null);
        this.f10151c = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
        this.f10152d = SnapshotStateKt__SnapshotStateKt.e(new TextFieldCharSequence(str, j3, null, null, null, 28, null), null, 2, null);
        this.f10153e = new UndoState(this);
        this.f10154f = new MutableVector(new NotifyImeListener[16], 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private TextFieldState(String str, long j3) {
        this(str, j3, new TextUndoManager(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0), null);
    }
}
